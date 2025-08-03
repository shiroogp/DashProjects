package com.google.firebase.database.core;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.RangeMerge;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.EventRaiser;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class Repo implements PersistentConnection.Delegate {
    private static final String INTERRUPT_REASON = "repo_interrupt";
    private static final int TRANSACTION_MAX_RETRIES = 25;
    private static final String TRANSACTION_OVERRIDE_BY_SET = "overriddenBySet";
    private static final String TRANSACTION_TOO_MANY_RETRIES = "maxretries";
    /* access modifiers changed from: private */
    public PersistentConnection connection;
    /* access modifiers changed from: private */
    public final Context ctx;
    private final LogWrapper dataLogger;
    public long dataUpdateCount = 0;
    private FirebaseDatabase database;
    private final EventRaiser eventRaiser;
    private boolean hijackHash = false;
    /* access modifiers changed from: private */
    public SnapshotHolder infoData;
    /* access modifiers changed from: private */
    public SyncTree infoSyncTree;
    private boolean loggedTransactionPersistenceWarning = false;
    private long nextWriteId = 1;
    /* access modifiers changed from: private */
    public SparseSnapshotTree onDisconnect;
    /* access modifiers changed from: private */
    public final LogWrapper operationLogger;
    private final RepoInfo repoInfo;
    /* access modifiers changed from: private */
    public final OffsetClock serverClock = new OffsetClock(new DefaultClock(), 0);
    /* access modifiers changed from: private */
    public SyncTree serverSyncTree;
    private final LogWrapper transactionLogger;
    private long transactionOrder = 0;
    /* access modifiers changed from: private */
    public Tree<List<TransactionData>> transactionQueueTree;

    private enum TransactionStatus {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    Repo(RepoInfo repoInfo2, Context context, FirebaseDatabase firebaseDatabase) {
        this.repoInfo = repoInfo2;
        this.ctx = context;
        this.database = firebaseDatabase;
        this.operationLogger = context.getLogger("RepoOperation");
        this.transactionLogger = context.getLogger("Transaction");
        this.dataLogger = context.getLogger("DataOperation");
        this.eventRaiser = new EventRaiser(context);
        scheduleNow(new Runnable() {
            public void run() {
                Repo.this.deferredInitialization();
            }
        });
    }

    /* access modifiers changed from: private */
    public void deferredInitialization() {
        this.connection = this.ctx.newPersistentConnection(new HostInfo(this.repoInfo.host, this.repoInfo.namespace, this.repoInfo.secure), this);
        this.ctx.getAuthTokenProvider().addTokenChangeListener(((DefaultRunLoop) this.ctx.getRunLoop()).getExecutorService(), new TokenProvider.TokenChangeListener() {
            public void onTokenChange() {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken();
            }

            public void onTokenChange(String str) {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken(str);
            }
        });
        this.ctx.getAppCheckTokenProvider().addTokenChangeListener(((DefaultRunLoop) this.ctx.getRunLoop()).getExecutorService(), new TokenProvider.TokenChangeListener() {
            public void onTokenChange() {
                Repo.this.operationLogger.debug("App check token changed, triggering app check token refresh", new Object[0]);
                Repo.this.connection.refreshAppCheckToken();
            }

            public void onTokenChange(String str) {
                Repo.this.operationLogger.debug("App check token changed, triggering app check token refresh", new Object[0]);
                Repo.this.connection.refreshAppCheckToken(str);
            }
        });
        this.connection.initialize();
        PersistenceManager persistenceManager = this.ctx.getPersistenceManager(this.repoInfo.host);
        this.infoData = new SnapshotHolder();
        this.onDisconnect = new SparseSnapshotTree();
        this.transactionQueueTree = new Tree<>();
        this.infoSyncTree = new SyncTree(this.ctx, new NoopPersistenceManager(), new SyncTree.ListenProvider() {
            public void stopListening(QuerySpec querySpec, Tag tag) {
            }

            public void startListening(final QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, final SyncTree.CompletionListener completionListener) {
                Repo.this.scheduleNow(new Runnable() {
                    public void run() {
                        Node node = Repo.this.infoData.getNode(querySpec.getPath());
                        if (!node.isEmpty()) {
                            Repo.this.postEvents(Repo.this.infoSyncTree.applyServerOverwrite(querySpec.getPath(), node));
                            completionListener.onListenComplete((DatabaseError) null);
                        }
                    }
                });
            }
        });
        this.serverSyncTree = new SyncTree(this.ctx, persistenceManager, new SyncTree.ListenProvider() {
            public void startListening(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, final SyncTree.CompletionListener completionListener) {
                Repo.this.connection.listen(querySpec.getPath().asList(), querySpec.getParams().getWireProtocolParams(), listenHashProvider, tag != null ? Long.valueOf(tag.getTagNumber()) : null, new RequestResultCallback() {
                    public void onRequestResult(String str, String str2) {
                        Repo.this.postEvents(completionListener.onListenComplete(Repo.fromErrorCode(str, str2)));
                    }
                });
            }

            public void stopListening(QuerySpec querySpec, Tag tag) {
                Repo.this.connection.unlisten(querySpec.getPath().asList(), querySpec.getParams().getWireProtocolParams());
            }
        });
        restoreWrites(persistenceManager);
        updateInfo(Constants.DOT_INFO_AUTHENTICATED, false);
        updateInfo(Constants.DOT_INFO_CONNECTED, false);
    }

    private void restoreWrites(PersistenceManager persistenceManager) {
        List<UserWriteRecord> loadUserWrites = persistenceManager.loadUserWrites();
        Map<String, Object> generateServerValues = ServerValues.generateServerValues(this.serverClock);
        long j = Long.MIN_VALUE;
        for (final UserWriteRecord next : loadUserWrites) {
            AnonymousClass6 r6 = new RequestResultCallback() {
                public void onRequestResult(String str, String str2) {
                    DatabaseError access$600 = Repo.fromErrorCode(str, str2);
                    Repo.this.warnIfWriteFailed("Persisted write", next.getPath(), access$600);
                    Repo.this.ackWriteAndRerunTransactions(next.getWriteId(), next.getPath(), access$600);
                }
            };
            if (j < next.getWriteId()) {
                j = next.getWriteId();
                this.nextWriteId = next.getWriteId() + 1;
                if (next.isOverwrite()) {
                    if (this.operationLogger.logsDebug()) {
                        this.operationLogger.debug("Restoring overwrite with id " + next.getWriteId(), new Object[0]);
                    }
                    this.connection.put(next.getPath().asList(), next.getOverwrite().getValue(true), r6);
                    this.serverSyncTree.applyUserOverwrite(next.getPath(), next.getOverwrite(), ServerValues.resolveDeferredValueSnapshot(next.getOverwrite(), this.serverSyncTree, next.getPath(), generateServerValues), next.getWriteId(), true, false);
                } else {
                    if (this.operationLogger.logsDebug()) {
                        this.operationLogger.debug("Restoring merge with id " + next.getWriteId(), new Object[0]);
                    }
                    this.connection.merge(next.getPath().asList(), next.getMerge().getValue(true), r6);
                    this.serverSyncTree.applyUserMerge(next.getPath(), next.getMerge(), ServerValues.resolveDeferredValueMerge(next.getMerge(), this.serverSyncTree, next.getPath(), generateServerValues), next.getWriteId(), false);
                }
            } else {
                throw new IllegalStateException("Write ids were not in order.");
            }
        }
    }

    public FirebaseDatabase getDatabase() {
        return this.database;
    }

    public String toString() {
        return this.repoInfo.toString();
    }

    public RepoInfo getRepoInfo() {
        return this.repoInfo;
    }

    public void scheduleNow(Runnable runnable) {
        this.ctx.requireStarted();
        this.ctx.getRunLoop().scheduleNow(runnable);
    }

    public void postEvent(Runnable runnable) {
        this.ctx.requireStarted();
        this.ctx.getEventTarget().postEvent(runnable);
    }

    /* access modifiers changed from: private */
    public void postEvents(List<? extends Event> list) {
        if (!list.isEmpty()) {
            this.eventRaiser.raiseEvents(list);
        }
    }

    public long getServerTime() {
        return this.serverClock.millis();
    }

    /* access modifiers changed from: package-private */
    public boolean hasListeners() {
        return !this.infoSyncTree.isEmpty() || !this.serverSyncTree.isEmpty();
    }

    public void onDataUpdate(List<String> list, Object obj, boolean z, Long l) {
        List<? extends Event> list2;
        Path path = new Path(list);
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("onDataUpdate: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("onDataUpdate: " + path + " " + obj, new Object[0]);
        }
        this.dataUpdateCount++;
        if (l != null) {
            try {
                Tag tag = new Tag(l.longValue());
                if (z) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new Path((String) entry.getKey()), NodeUtilities.NodeFromJSON(entry.getValue()));
                    }
                    list2 = this.serverSyncTree.applyTaggedQueryMerge(path, hashMap, tag);
                } else {
                    list2 = this.serverSyncTree.applyTaggedQueryOverwrite(path, NodeUtilities.NodeFromJSON(obj), tag);
                }
            } catch (DatabaseException e) {
                this.operationLogger.error("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (z) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new Path((String) entry2.getKey()), NodeUtilities.NodeFromJSON(entry2.getValue()));
            }
            list2 = this.serverSyncTree.applyServerMerge(path, hashMap2);
        } else {
            list2 = this.serverSyncTree.applyServerOverwrite(path, NodeUtilities.NodeFromJSON(obj));
        }
        if (list2.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(list2);
    }

    public void onRangeMergeUpdate(List<String> list, List<RangeMerge> list2, Long l) {
        List<? extends Event> list3;
        Path path = new Path(list);
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("onRangeMergeUpdate: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("onRangeMergeUpdate: " + path + " " + list2, new Object[0]);
        }
        this.dataUpdateCount++;
        ArrayList arrayList = new ArrayList(list2.size());
        for (RangeMerge rangeMerge : list2) {
            arrayList.add(new com.google.firebase.database.snapshot.RangeMerge(rangeMerge));
        }
        if (l != null) {
            list3 = this.serverSyncTree.applyTaggedRangeMerges(path, arrayList, new Tag(l.longValue()));
        } else {
            list3 = this.serverSyncTree.applyServerRangeMerges(path, arrayList);
        }
        if (list3.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(list3);
    }

    /* access modifiers changed from: package-private */
    public void callOnComplete(final DatabaseReference.CompletionListener completionListener, final DatabaseError databaseError, Path path) {
        final DatabaseReference databaseReference;
        if (completionListener != null) {
            ChildKey back = path.getBack();
            if (back == null || !back.isPriorityChildName()) {
                databaseReference = InternalHelpers.createReference(this, path);
            } else {
                databaseReference = InternalHelpers.createReference(this, path.getParent());
            }
            postEvent(new Runnable() {
                public void run() {
                    completionListener.onComplete(databaseError, databaseReference);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void ackWriteAndRerunTransactions(long j, Path path, DatabaseError databaseError) {
        if (databaseError == null || databaseError.getCode() != -25) {
            List<? extends Event> ackUserWrite = this.serverSyncTree.ackUserWrite(j, !(databaseError == null), true, this.serverClock);
            if (ackUserWrite.size() > 0) {
                rerunTransactions(path);
            }
            postEvents(ackUserWrite);
        }
    }

    public void setValue(Path path, Node node, DatabaseReference.CompletionListener completionListener) {
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("set: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.dataLogger.debug("set: " + path + " " + node, new Object[0]);
        }
        Node resolveDeferredValueSnapshot = ServerValues.resolveDeferredValueSnapshot(node, this.serverSyncTree.calcCompleteEventCache(path, new ArrayList()), ServerValues.generateServerValues(this.serverClock));
        long nextWriteId2 = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserOverwrite(path, node, resolveDeferredValueSnapshot, nextWriteId2, true, true));
        final Path path2 = path;
        final long j = nextWriteId2;
        final DatabaseReference.CompletionListener completionListener2 = completionListener;
        this.connection.put(path.asList(), node.getValue(true), new RequestResultCallback() {
            public void onRequestResult(String str, String str2) {
                DatabaseError access$600 = Repo.fromErrorCode(str, str2);
                Repo.this.warnIfWriteFailed("setValue", path2, access$600);
                Repo.this.ackWriteAndRerunTransactions(j, path2, access$600);
                Repo.this.callOnComplete(completionListener2, access$600, path2);
            }
        });
        rerunTransactions(abortTransactions(path, -9));
    }

    public Task<DataSnapshot> getValue(final Query query) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        scheduleNow(new Runnable() {
            public void run() {
                Node serverValue = Repo.this.serverSyncTree.getServerValue(query.getSpec());
                if (serverValue != null) {
                    taskCompletionSource.setResult(InternalHelpers.createDataSnapshot(query.getRef(), IndexedNode.from(serverValue)));
                    return;
                }
                Repo.this.serverSyncTree.setQueryActive(query.getSpec());
                Repo.this.connection.get(query.getPath().asList(), query.getSpec().getParams().getWireProtocolParams()).addOnCompleteListener((Executor) ((DefaultRunLoop) Repo.this.ctx.getRunLoop()).getExecutorService(), new OnCompleteListener<Object>() {
                    public void onComplete(Task<Object> task) {
                        if (!task.isSuccessful()) {
                            Repo.this.operationLogger.info("get for query " + query.getPath() + " falling back to disk cache after error: " + task.getException().getMessage());
                            DataSnapshot persistenceServerCache = Repo.this.serverSyncTree.persistenceServerCache(query);
                            if (!persistenceServerCache.exists()) {
                                taskCompletionSource.setException(task.getException());
                            } else {
                                taskCompletionSource.setResult(persistenceServerCache);
                            }
                        } else {
                            Node NodeFromJSON = NodeUtilities.NodeFromJSON(task.getResult());
                            Repo.this.postEvents(Repo.this.serverSyncTree.applyServerOverwrite(query.getPath(), NodeFromJSON));
                            taskCompletionSource.setResult(InternalHelpers.createDataSnapshot(query.getRef(), IndexedNode.from(NodeFromJSON, query.getSpec().getIndex())));
                        }
                        Repo.this.serverSyncTree.setQueryInactive(query.getSpec());
                    }
                });
            }
        });
        return taskCompletionSource.getTask();
    }

    public void updateChildren(Path path, CompoundWrite compoundWrite, DatabaseReference.CompletionListener completionListener, Map<String, Object> map) {
        Path path2 = path;
        Map<String, Object> map2 = map;
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("update: " + path2, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.dataLogger.debug("update: " + path2 + " " + map2, new Object[0]);
        }
        if (compoundWrite.isEmpty()) {
            if (this.operationLogger.logsDebug()) {
                this.operationLogger.debug("update called with no changes. No-op", new Object[0]);
            }
            callOnComplete(completionListener, (DatabaseError) null, path2);
            return;
        }
        final DatabaseReference.CompletionListener completionListener2 = completionListener;
        CompoundWrite compoundWrite2 = compoundWrite;
        CompoundWrite resolveDeferredValueMerge = ServerValues.resolveDeferredValueMerge(compoundWrite2, this.serverSyncTree, path2, ServerValues.generateServerValues(this.serverClock));
        long nextWriteId2 = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserMerge(path, compoundWrite, resolveDeferredValueMerge, nextWriteId2, true));
        final Path path3 = path;
        final long j = nextWriteId2;
        this.connection.merge(path.asList(), map2, new RequestResultCallback() {
            public void onRequestResult(String str, String str2) {
                DatabaseError access$600 = Repo.fromErrorCode(str, str2);
                Repo.this.warnIfWriteFailed("updateChildren", path3, access$600);
                Repo.this.ackWriteAndRerunTransactions(j, path3, access$600);
                Repo.this.callOnComplete(completionListener2, access$600, path3);
            }
        });
        Iterator<Map.Entry<Path, Node>> it2 = compoundWrite.iterator();
        while (it2.hasNext()) {
            rerunTransactions(abortTransactions(path2.child((Path) it2.next().getKey()), -9));
        }
    }

    public void purgeOutstandingWrites() {
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("Purging writes", new Object[0]);
        }
        postEvents(this.serverSyncTree.removeAllWrites());
        abortTransactions(Path.getEmptyPath(), -25);
        this.connection.purgeOutstandingWrites();
    }

    public void removeEventCallback(EventRegistration eventRegistration) {
        List<Event> list;
        if (Constants.DOT_INFO.equals(eventRegistration.getQuerySpec().getPath().getFront())) {
            list = this.infoSyncTree.removeEventRegistration(eventRegistration);
        } else {
            list = this.serverSyncTree.removeEventRegistration(eventRegistration);
        }
        postEvents(list);
    }

    public void onDisconnectSetValue(final Path path, final Node node, final DatabaseReference.CompletionListener completionListener) {
        this.connection.onDisconnectPut(path.asList(), node.getValue(true), new RequestResultCallback() {
            public void onRequestResult(String str, String str2) {
                DatabaseError access$600 = Repo.fromErrorCode(str, str2);
                Repo.this.warnIfWriteFailed("onDisconnect().setValue", path, access$600);
                if (access$600 == null) {
                    Repo.this.onDisconnect.remember(path, node);
                }
                Repo.this.callOnComplete(completionListener, access$600, path);
            }
        });
    }

    public void onDisconnectUpdate(final Path path, final Map<Path, Node> map, final DatabaseReference.CompletionListener completionListener, Map<String, Object> map2) {
        this.connection.onDisconnectMerge(path.asList(), map2, new RequestResultCallback() {
            public void onRequestResult(String str, String str2) {
                DatabaseError access$600 = Repo.fromErrorCode(str, str2);
                Repo.this.warnIfWriteFailed("onDisconnect().updateChildren", path, access$600);
                if (access$600 == null) {
                    for (Map.Entry entry : map.entrySet()) {
                        Repo.this.onDisconnect.remember(path.child((Path) entry.getKey()), (Node) entry.getValue());
                    }
                }
                Repo.this.callOnComplete(completionListener, access$600, path);
            }
        });
    }

    public void onDisconnectCancel(final Path path, final DatabaseReference.CompletionListener completionListener) {
        this.connection.onDisconnectCancel(path.asList(), new RequestResultCallback() {
            public void onRequestResult(String str, String str2) {
                DatabaseError access$600 = Repo.fromErrorCode(str, str2);
                if (access$600 == null) {
                    Repo.this.onDisconnect.forget(path);
                }
                Repo.this.callOnComplete(completionListener, access$600, path);
            }
        });
    }

    public void onConnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, true);
    }

    public void onDisconnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, false);
        runOnDisconnectEvents();
    }

    public void onConnectionStatus(boolean z) {
        onServerInfoUpdate(Constants.DOT_INFO_AUTHENTICATED, Boolean.valueOf(z));
    }

    public void onServerInfoUpdate(ChildKey childKey, Object obj) {
        updateInfo(childKey, obj);
    }

    public void onServerInfoUpdate(Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            updateInfo(ChildKey.fromString((String) next.getKey()), next.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void interrupt() {
        this.connection.interrupt(INTERRUPT_REASON);
    }

    /* access modifiers changed from: package-private */
    public void resume() {
        this.connection.resume(INTERRUPT_REASON);
    }

    public void addEventCallback(EventRegistration eventRegistration) {
        List<? extends Event> list;
        ChildKey front = eventRegistration.getQuerySpec().getPath().getFront();
        if (front == null || !front.equals(Constants.DOT_INFO)) {
            list = this.serverSyncTree.addEventRegistration(eventRegistration);
        } else {
            list = this.infoSyncTree.addEventRegistration(eventRegistration);
        }
        postEvents(list);
    }

    public void keepSynced(QuerySpec querySpec, boolean z) {
        Utilities.hardAssert(querySpec.getPath().isEmpty() || !querySpec.getPath().getFront().equals(Constants.DOT_INFO));
        this.serverSyncTree.keepSynced(querySpec, z);
    }

    /* access modifiers changed from: package-private */
    public PersistentConnection getConnection() {
        return this.connection;
    }

    private void updateInfo(ChildKey childKey, Object obj) {
        if (childKey.equals(Constants.DOT_INFO_SERVERTIME_OFFSET)) {
            this.serverClock.setOffset(((Long) obj).longValue());
        }
        Path path = new Path(Constants.DOT_INFO, childKey);
        try {
            Node NodeFromJSON = NodeUtilities.NodeFromJSON(obj);
            this.infoData.update(path, NodeFromJSON);
            postEvents(this.infoSyncTree.applyServerOverwrite(path, NodeFromJSON));
        } catch (DatabaseException e) {
            this.operationLogger.error("Failed to parse info update", e);
        }
    }

    private long getNextWriteId() {
        long j = this.nextWriteId;
        this.nextWriteId = 1 + j;
        return j;
    }

    private void runOnDisconnectEvents() {
        final Map<String, Object> generateServerValues = ServerValues.generateServerValues(this.serverClock);
        final ArrayList arrayList = new ArrayList();
        this.onDisconnect.forEachTree(Path.getEmptyPath(), new SparseSnapshotTree.SparseSnapshotTreeVisitor() {
            public void visitTree(Path path, Node node) {
                arrayList.addAll(Repo.this.serverSyncTree.applyServerOverwrite(path, ServerValues.resolveDeferredValueSnapshot(node, Repo.this.serverSyncTree.calcCompleteEventCache(path, new ArrayList()), (Map<String, Object>) generateServerValues)));
                Path unused = Repo.this.rerunTransactions(Repo.this.abortTransactions(path, -9));
            }
        });
        this.onDisconnect = new SparseSnapshotTree();
        postEvents(arrayList);
    }

    /* access modifiers changed from: private */
    public void warnIfWriteFailed(String str, Path path, DatabaseError databaseError) {
        if (databaseError != null && databaseError.getCode() != -1 && databaseError.getCode() != -25) {
            this.operationLogger.warn(str + " at " + path.toString() + " failed: " + databaseError.toString());
        }
    }

    private static class TransactionData implements Comparable<TransactionData> {
        /* access modifiers changed from: private */
        public DatabaseError abortReason;
        /* access modifiers changed from: private */
        public boolean applyLocally;
        /* access modifiers changed from: private */
        public Node currentInputSnapshot;
        /* access modifiers changed from: private */
        public Node currentOutputSnapshotRaw;
        /* access modifiers changed from: private */
        public Node currentOutputSnapshotResolved;
        /* access modifiers changed from: private */
        public long currentWriteId;
        /* access modifiers changed from: private */
        public Transaction.Handler handler;
        private long order;
        /* access modifiers changed from: private */
        public ValueEventListener outstandingListener;
        /* access modifiers changed from: private */
        public Path path;
        /* access modifiers changed from: private */
        public int retryCount;
        /* access modifiers changed from: private */
        public TransactionStatus status;

        static /* synthetic */ int access$2108(TransactionData transactionData) {
            int i = transactionData.retryCount;
            transactionData.retryCount = i + 1;
            return i;
        }

        private TransactionData(Path path2, Transaction.Handler handler2, ValueEventListener valueEventListener, TransactionStatus transactionStatus, boolean z, long j) {
            this.path = path2;
            this.handler = handler2;
            this.outstandingListener = valueEventListener;
            this.status = transactionStatus;
            this.retryCount = 0;
            this.applyLocally = z;
            this.order = j;
            this.abortReason = null;
            this.currentInputSnapshot = null;
            this.currentOutputSnapshotRaw = null;
            this.currentOutputSnapshotResolved = null;
        }

        public int compareTo(TransactionData transactionData) {
            long j = this.order;
            long j2 = transactionData.order;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    public void startTransaction(Path path, final Transaction.Handler handler, boolean z) {
        final DatabaseError databaseError;
        Transaction.Result result;
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("transaction: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("transaction: " + path, new Object[0]);
        }
        if (this.ctx.isPersistenceEnabled() && !this.loggedTransactionPersistenceWarning) {
            this.loggedTransactionPersistenceWarning = true;
            this.transactionLogger.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference createReference = InternalHelpers.createReference(this, path);
        AnonymousClass15 r4 = new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
            }
        };
        addEventCallback(new ValueEventRegistration(this, r4, createReference.getSpec()));
        TransactionData transactionData = new TransactionData(path, handler, r4, TransactionStatus.INITIALIZING, z, nextTransactionOrder());
        Node latestState = getLatestState(path);
        Node unused = transactionData.currentInputSnapshot = latestState;
        try {
            result = handler.doTransaction(InternalHelpers.createMutableData(latestState));
            if (result != null) {
                databaseError = null;
                if (!result.isSuccess()) {
                    Node unused2 = transactionData.currentOutputSnapshotRaw = null;
                    Node unused3 = transactionData.currentOutputSnapshotResolved = null;
                    final DataSnapshot createDataSnapshot = InternalHelpers.createDataSnapshot(createReference, IndexedNode.from(transactionData.currentInputSnapshot));
                    postEvent(new Runnable() {
                        public void run() {
                            handler.onComplete(databaseError, false, createDataSnapshot);
                        }
                    });
                    return;
                }
                TransactionStatus unused4 = transactionData.status = TransactionStatus.RUN;
                Tree<List<TransactionData>> subTree = this.transactionQueueTree.subTree(path);
                List value = subTree.getValue();
                if (value == null) {
                    value = new ArrayList();
                }
                value.add(transactionData);
                subTree.setValue(value);
                Map<String, Object> generateServerValues = ServerValues.generateServerValues(this.serverClock);
                Node node = result.getNode();
                Node resolveDeferredValueSnapshot = ServerValues.resolveDeferredValueSnapshot(node, transactionData.currentInputSnapshot, generateServerValues);
                Node unused5 = transactionData.currentOutputSnapshotRaw = node;
                Node unused6 = transactionData.currentOutputSnapshotResolved = resolveDeferredValueSnapshot;
                long unused7 = transactionData.currentWriteId = getNextWriteId();
                postEvents(this.serverSyncTree.applyUserOverwrite(path, node, resolveDeferredValueSnapshot, transactionData.currentWriteId, z, false));
                sendAllReadyTransactions();
                return;
            }
            throw new NullPointerException("Transaction returned null as result");
        } catch (Throwable th) {
            this.operationLogger.error("Caught Throwable.", th);
            databaseError = DatabaseError.fromException(th);
            result = Transaction.abort();
        }
    }

    private Node getLatestState(Path path) {
        return getLatestState(path, new ArrayList());
    }

    private Node getLatestState(Path path, List<Long> list) {
        Node calcCompleteEventCache = this.serverSyncTree.calcCompleteEventCache(path, list);
        return calcCompleteEventCache == null ? EmptyNode.Empty() : calcCompleteEventCache;
    }

    public void setHijackHash(boolean z) {
        this.hijackHash = z;
    }

    /* access modifiers changed from: private */
    public void sendAllReadyTransactions() {
        Tree<List<TransactionData>> tree = this.transactionQueueTree;
        pruneCompletedTransactions(tree);
        sendReadyTransactions(tree);
    }

    /* access modifiers changed from: private */
    public void sendReadyTransactions(Tree<List<TransactionData>> tree) {
        if (tree.getValue() != null) {
            List<TransactionData> buildTransactionQueue = buildTransactionQueue(tree);
            Utilities.hardAssert(buildTransactionQueue.size() > 0);
            Boolean bool = true;
            Iterator<TransactionData> it2 = buildTransactionQueue.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().status != TransactionStatus.RUN) {
                        bool = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (bool.booleanValue()) {
                sendTransactionQueue(buildTransactionQueue, tree.getPath());
            }
        } else if (tree.hasChildren()) {
            tree.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
                public void visitTree(Tree<List<TransactionData>> tree) {
                    Repo.this.sendReadyTransactions(tree);
                }
            });
        }
    }

    private void sendTransactionQueue(final List<TransactionData> list, final Path path) {
        ArrayList arrayList = new ArrayList();
        for (TransactionData access$1900 : list) {
            arrayList.add(Long.valueOf(access$1900.currentWriteId));
        }
        Node latestState = getLatestState(path, arrayList);
        String hash = !this.hijackHash ? latestState.getHash() : "badhash";
        Iterator<TransactionData> it2 = list.iterator();
        while (true) {
            boolean z = true;
            if (it2.hasNext()) {
                TransactionData next = it2.next();
                if (next.status != TransactionStatus.RUN) {
                    z = false;
                }
                Utilities.hardAssert(z);
                TransactionStatus unused = next.status = TransactionStatus.SENT;
                TransactionData.access$2108(next);
                latestState = latestState.updateChild(Path.getRelative(path, next.path), next.currentOutputSnapshotRaw);
            } else {
                this.connection.compareAndPut(path.asList(), latestState.getValue(true), hash, new RequestResultCallback() {
                    public void onRequestResult(String str, String str2) {
                        DatabaseError access$600 = Repo.fromErrorCode(str, str2);
                        Repo.this.warnIfWriteFailed("Transaction", path, access$600);
                        ArrayList arrayList = new ArrayList();
                        if (access$600 == null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (final TransactionData transactionData : list) {
                                TransactionStatus unused = transactionData.status = TransactionStatus.COMPLETED;
                                arrayList.addAll(Repo.this.serverSyncTree.ackUserWrite(transactionData.currentWriteId, false, false, Repo.this.serverClock));
                                final DataSnapshot createDataSnapshot = InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this, transactionData.path), IndexedNode.from(transactionData.currentOutputSnapshotResolved));
                                arrayList2.add(new Runnable() {
                                    public void run() {
                                        transactionData.handler.onComplete((DatabaseError) null, true, createDataSnapshot);
                                    }
                                });
                                Repo.this.removeEventCallback(new ValueEventRegistration(Repo.this, transactionData.outstandingListener, QuerySpec.defaultQueryAtPath(transactionData.path)));
                            }
                            Repo repo = Repo.this;
                            repo.pruneCompletedTransactions(repo.transactionQueueTree.subTree(path));
                            Repo.this.sendAllReadyTransactions();
                            this.postEvents(arrayList);
                            for (int i = 0; i < arrayList2.size(); i++) {
                                Repo.this.postEvent((Runnable) arrayList2.get(i));
                            }
                            return;
                        }
                        if (access$600.getCode() == -1) {
                            for (TransactionData transactionData2 : list) {
                                if (transactionData2.status == TransactionStatus.SENT_NEEDS_ABORT) {
                                    TransactionStatus unused2 = transactionData2.status = TransactionStatus.NEEDS_ABORT;
                                } else {
                                    TransactionStatus unused3 = transactionData2.status = TransactionStatus.RUN;
                                }
                            }
                        } else {
                            for (TransactionData transactionData3 : list) {
                                TransactionStatus unused4 = transactionData3.status = TransactionStatus.NEEDS_ABORT;
                                DatabaseError unused5 = transactionData3.abortReason = access$600;
                            }
                        }
                        Path unused6 = Repo.this.rerunTransactions(path);
                    }
                });
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void pruneCompletedTransactions(Tree<List<TransactionData>> tree) {
        List value = tree.getValue();
        if (value != null) {
            int i = 0;
            while (i < value.size()) {
                if (((TransactionData) value.get(i)).status == TransactionStatus.COMPLETED) {
                    value.remove(i);
                } else {
                    i++;
                }
            }
            if (value.size() > 0) {
                tree.setValue(value);
            } else {
                tree.setValue(null);
            }
        }
        tree.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.pruneCompletedTransactions(tree);
            }
        });
    }

    private long nextTransactionOrder() {
        long j = this.transactionOrder;
        this.transactionOrder = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    public Path rerunTransactions(Path path) {
        Tree<List<TransactionData>> ancestorTransactionNode = getAncestorTransactionNode(path);
        Path path2 = ancestorTransactionNode.getPath();
        rerunTransactionQueue(buildTransactionQueue(ancestorTransactionNode), path2);
        return path2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0033 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void rerunTransactionQueue(java.util.List<com.google.firebase.database.core.Repo.TransactionData> r23, com.google.firebase.database.core.Path r24) {
        /*
            r22 = this;
            r1 = r22
            boolean r0 = r23.isEmpty()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r0 = r23.iterator()
        L_0x0017:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x002f
            java.lang.Object r4 = r0.next()
            com.google.firebase.database.core.Repo$TransactionData r4 = (com.google.firebase.database.core.Repo.TransactionData) r4
            long r4 = r4.currentWriteId
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3.add(r4)
            goto L_0x0017
        L_0x002f:
            java.util.Iterator r4 = r23.iterator()
        L_0x0033:
            boolean r0 = r4.hasNext()
            r5 = 0
            if (r0 == 0) goto L_0x017f
            java.lang.Object r0 = r4.next()
            r6 = r0
            com.google.firebase.database.core.Repo$TransactionData r6 = (com.google.firebase.database.core.Repo.TransactionData) r6
            com.google.firebase.database.core.Path r0 = r6.path
            r7 = r24
            com.google.firebase.database.core.Path r0 = com.google.firebase.database.core.Path.getRelative(r7, r0)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r9 = 1
            if (r0 == 0) goto L_0x0055
            r0 = r9
            goto L_0x0056
        L_0x0055:
            r0 = r5
        L_0x0056:
            com.google.firebase.database.core.utilities.Utilities.hardAssert(r0)
            com.google.firebase.database.core.Repo$TransactionStatus r0 = r6.status
            com.google.firebase.database.core.Repo$TransactionStatus r10 = com.google.firebase.database.core.Repo.TransactionStatus.NEEDS_ABORT
            r11 = 0
            if (r0 != r10) goto L_0x0085
            com.google.firebase.database.DatabaseError r11 = r6.abortReason
            int r0 = r11.getCode()
            r5 = -25
            if (r0 == r5) goto L_0x0082
            com.google.firebase.database.core.SyncTree r12 = r1.serverSyncTree
            long r13 = r6.currentWriteId
            r15 = 1
            r16 = 0
            com.google.firebase.database.core.utilities.OffsetClock r0 = r1.serverClock
            r17 = r0
            java.util.List r0 = r12.ackUserWrite(r13, r15, r16, r17)
            r8.addAll(r0)
        L_0x0082:
            r5 = r9
            goto L_0x014f
        L_0x0085:
            com.google.firebase.database.core.Repo$TransactionStatus r0 = r6.status
            com.google.firebase.database.core.Repo$TransactionStatus r10 = com.google.firebase.database.core.Repo.TransactionStatus.RUN
            if (r0 != r10) goto L_0x014f
            int r0 = r6.retryCount
            r10 = 25
            if (r0 < r10) goto L_0x00b0
            java.lang.String r0 = "maxretries"
            com.google.firebase.database.DatabaseError r11 = com.google.firebase.database.DatabaseError.fromStatus(r0)
            com.google.firebase.database.core.SyncTree r12 = r1.serverSyncTree
            long r13 = r6.currentWriteId
            r15 = 1
            r16 = 0
            com.google.firebase.database.core.utilities.OffsetClock r0 = r1.serverClock
            r17 = r0
            java.util.List r0 = r12.ackUserWrite(r13, r15, r16, r17)
            r8.addAll(r0)
            goto L_0x0082
        L_0x00b0:
            com.google.firebase.database.core.Path r0 = r6.path
            com.google.firebase.database.snapshot.Node r10 = r1.getLatestState(r0, r3)
            com.google.firebase.database.snapshot.Node unused = r6.currentInputSnapshot = r10
            com.google.firebase.database.MutableData r0 = com.google.firebase.database.InternalHelpers.createMutableData(r10)
            com.google.firebase.database.Transaction$Handler r12 = r6.handler     // Catch:{ all -> 0x00c9 }
            com.google.firebase.database.Transaction$Result r0 = r12.doTransaction(r0)     // Catch:{ all -> 0x00c9 }
            r12 = r11
            goto L_0x00de
        L_0x00c9:
            r0 = move-exception
            com.google.firebase.database.logging.LogWrapper r12 = r1.operationLogger
            java.lang.String r13 = "Caught Throwable."
            r12.error(r13, r0)
            com.google.firebase.database.DatabaseError r0 = com.google.firebase.database.DatabaseError.fromException(r0)
            com.google.firebase.database.Transaction$Result r12 = com.google.firebase.database.Transaction.abort()
            r21 = r12
            r12 = r0
            r0 = r21
        L_0x00de:
            boolean r13 = r0.isSuccess()
            if (r13 == 0) goto L_0x0138
            long r12 = r6.currentWriteId
            java.lang.Long r9 = java.lang.Long.valueOf(r12)
            com.google.firebase.database.core.utilities.OffsetClock r12 = r1.serverClock
            java.util.Map r12 = com.google.firebase.database.core.ServerValues.generateServerValues(r12)
            com.google.firebase.database.snapshot.Node r15 = r0.getNode()
            com.google.firebase.database.snapshot.Node r0 = com.google.firebase.database.core.ServerValues.resolveDeferredValueSnapshot((com.google.firebase.database.snapshot.Node) r15, (com.google.firebase.database.snapshot.Node) r10, (java.util.Map<java.lang.String, java.lang.Object>) r12)
            com.google.firebase.database.snapshot.Node unused = r6.currentOutputSnapshotRaw = r15
            com.google.firebase.database.snapshot.Node unused = r6.currentOutputSnapshotResolved = r0
            long r12 = r22.getNextWriteId()
            long unused = r6.currentWriteId = r12
            r3.remove(r9)
            com.google.firebase.database.core.SyncTree r13 = r1.serverSyncTree
            com.google.firebase.database.core.Path r14 = r6.path
            long r17 = r6.currentWriteId
            boolean r19 = r6.applyLocally
            r20 = 0
            r16 = r0
            java.util.List r0 = r13.applyUserOverwrite(r14, r15, r16, r17, r19, r20)
            r8.addAll(r0)
            com.google.firebase.database.core.SyncTree r12 = r1.serverSyncTree
            long r13 = r9.longValue()
            r15 = 1
            r16 = 0
            com.google.firebase.database.core.utilities.OffsetClock r0 = r1.serverClock
            r17 = r0
            java.util.List r0 = r12.ackUserWrite(r13, r15, r16, r17)
            r8.addAll(r0)
            goto L_0x014f
        L_0x0138:
            com.google.firebase.database.core.SyncTree r13 = r1.serverSyncTree
            long r14 = r6.currentWriteId
            r16 = 1
            r17 = 0
            com.google.firebase.database.core.utilities.OffsetClock r0 = r1.serverClock
            r18 = r0
            java.util.List r0 = r13.ackUserWrite(r14, r16, r17, r18)
            r8.addAll(r0)
            r5 = r9
            r11 = r12
        L_0x014f:
            r1.postEvents(r8)
            if (r5 == 0) goto L_0x0033
            com.google.firebase.database.core.Repo$TransactionStatus r0 = com.google.firebase.database.core.Repo.TransactionStatus.COMPLETED
            com.google.firebase.database.core.Repo.TransactionStatus unused = r6.status = r0
            com.google.firebase.database.core.Path r0 = r6.path
            com.google.firebase.database.DatabaseReference r0 = com.google.firebase.database.InternalHelpers.createReference(r1, r0)
            com.google.firebase.database.snapshot.Node r5 = r6.currentInputSnapshot
            com.google.firebase.database.snapshot.IndexedNode r5 = com.google.firebase.database.snapshot.IndexedNode.from(r5)
            com.google.firebase.database.DataSnapshot r0 = com.google.firebase.database.InternalHelpers.createDataSnapshot(r0, r5)
            com.google.firebase.database.core.Repo$20 r5 = new com.google.firebase.database.core.Repo$20
            r5.<init>(r6)
            r1.scheduleNow(r5)
            com.google.firebase.database.core.Repo$21 r5 = new com.google.firebase.database.core.Repo$21
            r5.<init>(r6, r11, r0)
            r2.add(r5)
            goto L_0x0033
        L_0x017f:
            com.google.firebase.database.core.utilities.Tree<java.util.List<com.google.firebase.database.core.Repo$TransactionData>> r0 = r1.transactionQueueTree
            r1.pruneCompletedTransactions(r0)
        L_0x0184:
            int r0 = r2.size()
            if (r5 >= r0) goto L_0x0196
            java.lang.Object r0 = r2.get(r5)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r1.postEvent(r0)
            int r5 = r5 + 1
            goto L_0x0184
        L_0x0196:
            r22.sendAllReadyTransactions()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.Repo.rerunTransactionQueue(java.util.List, com.google.firebase.database.core.Path):void");
    }

    private Tree<List<TransactionData>> getAncestorTransactionNode(Path path) {
        Tree<List<TransactionData>> tree = this.transactionQueueTree;
        while (!path.isEmpty() && tree.getValue() == null) {
            tree = tree.subTree(new Path(path.getFront()));
            path = path.popFront();
        }
        return tree;
    }

    private List<TransactionData> buildTransactionQueue(Tree<List<TransactionData>> tree) {
        ArrayList arrayList = new ArrayList();
        aggregateTransactionQueues(arrayList, tree);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void aggregateTransactionQueues(final List<TransactionData> list, Tree<List<TransactionData>> tree) {
        List value = tree.getValue();
        if (value != null) {
            list.addAll(value);
        }
        tree.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.aggregateTransactionQueues(list, tree);
            }
        });
    }

    /* access modifiers changed from: private */
    public Path abortTransactions(Path path, final int i) {
        Path path2 = getAncestorTransactionNode(path).getPath();
        if (this.transactionLogger.logsDebug()) {
            this.operationLogger.debug("Aborting transactions for path: " + path + ". Affected: " + path2, new Object[0]);
        }
        Tree<List<TransactionData>> subTree = this.transactionQueueTree.subTree(path);
        subTree.forEachAncestor(new Tree.TreeFilter<List<TransactionData>>() {
            public boolean filterTreeNode(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, i);
                return false;
            }
        });
        abortTransactionsAtNode(subTree, i);
        subTree.forEachDescendant(new Tree.TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, i);
            }
        });
        return path2;
    }

    /* access modifiers changed from: private */
    public void abortTransactionsAtNode(Tree<List<TransactionData>> tree, int i) {
        final DatabaseError databaseError;
        Tree<List<TransactionData>> tree2 = tree;
        int i2 = i;
        List value = tree.getValue();
        ArrayList arrayList = new ArrayList();
        if (value != null) {
            ArrayList<Runnable> arrayList2 = new ArrayList<>();
            if (i2 == -9) {
                databaseError = DatabaseError.fromStatus(TRANSACTION_OVERRIDE_BY_SET);
            } else {
                Utilities.hardAssert(i2 == -25, "Unknown transaction abort reason: " + i2);
                databaseError = DatabaseError.fromCode(-25);
            }
            int i3 = -1;
            for (int i4 = 0; i4 < value.size(); i4++) {
                final TransactionData transactionData = (TransactionData) value.get(i4);
                if (transactionData.status != TransactionStatus.SENT_NEEDS_ABORT) {
                    if (transactionData.status == TransactionStatus.SENT) {
                        Utilities.hardAssert(i3 == i4 + -1);
                        TransactionStatus unused = transactionData.status = TransactionStatus.SENT_NEEDS_ABORT;
                        DatabaseError unused2 = transactionData.abortReason = databaseError;
                        i3 = i4;
                    } else {
                        Utilities.hardAssert(transactionData.status == TransactionStatus.RUN);
                        removeEventCallback(new ValueEventRegistration(this, transactionData.outstandingListener, QuerySpec.defaultQueryAtPath(transactionData.path)));
                        if (i2 == -9) {
                            arrayList.addAll(this.serverSyncTree.ackUserWrite(transactionData.currentWriteId, true, false, this.serverClock));
                        } else {
                            Utilities.hardAssert(i2 == -25, "Unknown transaction abort reason: " + i2);
                        }
                        arrayList2.add(new Runnable() {
                            public void run() {
                                transactionData.handler.onComplete(databaseError, false, (DataSnapshot) null);
                            }
                        });
                    }
                }
            }
            if (i3 == -1) {
                tree2.setValue(null);
            } else {
                tree2.setValue(value.subList(0, i3 + 1));
            }
            postEvents(arrayList);
            for (Runnable postEvent : arrayList2) {
                postEvent(postEvent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SyncTree getServerSyncTree() {
        return this.serverSyncTree;
    }

    /* access modifiers changed from: package-private */
    public SyncTree getInfoSyncTree() {
        return this.infoSyncTree;
    }

    /* access modifiers changed from: private */
    public static DatabaseError fromErrorCode(String str, String str2) {
        if (str != null) {
            return DatabaseError.fromStatus(str, str2);
        }
        return null;
    }
}
