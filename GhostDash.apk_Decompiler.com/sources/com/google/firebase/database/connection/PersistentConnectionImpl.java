package com.google.firebase.database.connection;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.connection.Connection;
import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.util.GAuthToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;

public class PersistentConnectionImpl implements Connection.Delegate, PersistentConnection {
    private static final long GET_CONNECT_TIMEOUT = 3000;
    private static final String IDLE_INTERRUPT_REASON = "connection_idle";
    private static final long IDLE_TIMEOUT = 60000;
    private static final String INVALID_APP_CHECK_TOKEN = "Invalid appcheck token";
    private static final long INVALID_TOKEN_THRESHOLD = 3;
    private static final String REQUEST_ACTION = "a";
    private static final String REQUEST_ACTION_APPCHECK = "appcheck";
    private static final String REQUEST_ACTION_AUTH = "auth";
    private static final String REQUEST_ACTION_GAUTH = "gauth";
    private static final String REQUEST_ACTION_GET = "g";
    private static final String REQUEST_ACTION_MERGE = "m";
    private static final String REQUEST_ACTION_ONDISCONNECT_CANCEL = "oc";
    private static final String REQUEST_ACTION_ONDISCONNECT_MERGE = "om";
    private static final String REQUEST_ACTION_ONDISCONNECT_PUT = "o";
    private static final String REQUEST_ACTION_PUT = "p";
    private static final String REQUEST_ACTION_QUERY = "q";
    private static final String REQUEST_ACTION_QUERY_UNLISTEN = "n";
    private static final String REQUEST_ACTION_STATS = "s";
    private static final String REQUEST_ACTION_UNAPPCHECK = "unappcheck";
    private static final String REQUEST_ACTION_UNAUTH = "unauth";
    private static final String REQUEST_APPCHECK_TOKEN = "token";
    private static final String REQUEST_AUTHVAR = "authvar";
    private static final String REQUEST_COMPOUND_HASH = "ch";
    private static final String REQUEST_COMPOUND_HASH_HASHES = "hs";
    private static final String REQUEST_COMPOUND_HASH_PATHS = "ps";
    private static final String REQUEST_COUNTERS = "c";
    private static final String REQUEST_CREDENTIAL = "cred";
    private static final String REQUEST_DATA_HASH = "h";
    private static final String REQUEST_DATA_PAYLOAD = "d";
    private static final String REQUEST_ERROR = "error";
    private static final String REQUEST_NUMBER = "r";
    private static final String REQUEST_PATH = "p";
    private static final String REQUEST_PAYLOAD = "b";
    private static final String REQUEST_QUERIES = "q";
    private static final String REQUEST_STATUS = "s";
    private static final String REQUEST_TAG = "t";
    private static final String RESPONSE_FOR_REQUEST = "b";
    private static final String SERVER_ASYNC_ACTION = "a";
    private static final String SERVER_ASYNC_APP_CHECK_REVOKED = "apc";
    private static final String SERVER_ASYNC_AUTH_REVOKED = "ac";
    private static final String SERVER_ASYNC_DATA_MERGE = "m";
    private static final String SERVER_ASYNC_DATA_RANGE_MERGE = "rm";
    private static final String SERVER_ASYNC_DATA_UPDATE = "d";
    private static final String SERVER_ASYNC_LISTEN_CANCELLED = "c";
    private static final String SERVER_ASYNC_PAYLOAD = "b";
    private static final String SERVER_ASYNC_SECURITY_DEBUG = "sd";
    private static final String SERVER_DATA_END_PATH = "e";
    private static final String SERVER_DATA_RANGE_MERGE = "m";
    private static final String SERVER_DATA_START_PATH = "s";
    private static final String SERVER_DATA_TAG = "t";
    private static final String SERVER_DATA_UPDATE_BODY = "d";
    private static final String SERVER_DATA_UPDATE_PATH = "p";
    private static final String SERVER_DATA_WARNINGS = "w";
    private static final String SERVER_KILL_INTERRUPT_REASON = "server_kill";
    private static final String SERVER_RESPONSE_DATA = "d";
    private static final long SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY = 30000;
    private static final String TOKEN_REFRESH_INTERRUPT_REASON = "token_refresh";
    private static long connectionIds;
    private String appCheckToken;
    private final ConnectionTokenProvider appCheckTokenProvider;
    /* access modifiers changed from: private */
    public String authToken;
    private final ConnectionTokenProvider authTokenProvider;
    private String cachedHost;
    /* access modifiers changed from: private */
    public ConnectionState connectionState = ConnectionState.Disconnected;
    private final ConnectionContext context;
    private long currentGetTokenAttempt = 0;
    /* access modifiers changed from: private */
    public final PersistentConnection.Delegate delegate;
    private final ScheduledExecutorService executorService;
    private boolean firstConnection = true;
    private boolean forceAppCheckTokenRefresh;
    /* access modifiers changed from: private */
    public boolean forceAuthTokenRefresh;
    private boolean hasOnDisconnects;
    private final HostInfo hostInfo;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> inactivityTimer = null;
    private HashSet<String> interruptReasons = new HashSet<>();
    private int invalidAppCheckTokenCount = 0;
    /* access modifiers changed from: private */
    public int invalidAuthTokenCount = 0;
    private long lastConnectionEstablishedTime;
    private String lastSessionId;
    private long lastWriteTimestamp;
    /* access modifiers changed from: private */
    public Map<QuerySpec, OutstandingListen> listens;
    /* access modifiers changed from: private */
    public final LogWrapper logger;
    private List<OutstandingDisconnect> onDisconnectRequestQueue;
    /* access modifiers changed from: private */
    public Map<Long, OutstandingGet> outstandingGets;
    /* access modifiers changed from: private */
    public Map<Long, OutstandingPut> outstandingPuts;
    private long readCounter = 0;
    /* access modifiers changed from: private */
    public Connection realtime;
    private Map<Long, ConnectionRequestCallback> requestCBHash;
    private long requestCounter = 0;
    /* access modifiers changed from: private */
    public final RetryHelper retryHelper;
    private long writeCounter = 0;

    private interface ConnectionRequestCallback {
        void onResponse(Map<String, Object> map);
    }

    private enum ConnectionState {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    static /* synthetic */ int access$1008(PersistentConnectionImpl persistentConnectionImpl) {
        int i = persistentConnectionImpl.invalidAuthTokenCount;
        persistentConnectionImpl.invalidAuthTokenCount = i + 1;
        return i;
    }

    private static class QuerySpec {
        /* access modifiers changed from: private */
        public final List<String> path;
        /* access modifiers changed from: private */
        public final Map<String, Object> queryParams;

        public QuerySpec(List<String> list, Map<String, Object> map) {
            this.path = list;
            this.queryParams = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuerySpec)) {
                return false;
            }
            QuerySpec querySpec = (QuerySpec) obj;
            if (!this.path.equals(querySpec.path)) {
                return false;
            }
            return this.queryParams.equals(querySpec.queryParams);
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + this.queryParams.hashCode();
        }

        public String toString() {
            return ConnectionUtils.pathToString(this.path) + " (params: " + this.queryParams + ")";
        }
    }

    private static class OutstandingListen {
        private final ListenHashProvider hashFunction;
        /* access modifiers changed from: private */
        public final QuerySpec query;
        /* access modifiers changed from: private */
        public final RequestResultCallback resultCallback;
        private final Long tag;

        private OutstandingListen(RequestResultCallback requestResultCallback, QuerySpec querySpec, Long l, ListenHashProvider listenHashProvider) {
            this.resultCallback = requestResultCallback;
            this.query = querySpec;
            this.hashFunction = listenHashProvider;
            this.tag = l;
        }

        public QuerySpec getQuery() {
            return this.query;
        }

        public Long getTag() {
            return this.tag;
        }

        public ListenHashProvider getHashFunction() {
            return this.hashFunction;
        }

        public String toString() {
            return this.query.toString() + " (Tag: " + this.tag + ")";
        }
    }

    private static class OutstandingGet {
        private final ConnectionRequestCallback onComplete;
        private final Map<String, Object> request;
        private boolean sent;

        private OutstandingGet(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
            this.request = map;
            this.onComplete = connectionRequestCallback;
            this.sent = false;
        }

        /* access modifiers changed from: private */
        public ConnectionRequestCallback getOnComplete() {
            return this.onComplete;
        }

        /* access modifiers changed from: private */
        public Map<String, Object> getRequest() {
            return this.request;
        }

        /* access modifiers changed from: private */
        public boolean markSent() {
            if (this.sent) {
                return false;
            }
            this.sent = true;
            return true;
        }
    }

    private static class OutstandingPut {
        private String action;
        /* access modifiers changed from: private */
        public RequestResultCallback onComplete;
        private Map<String, Object> request;
        private boolean sent;

        private OutstandingPut(String str, Map<String, Object> map, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.request = map;
            this.onComplete = requestResultCallback;
        }

        public String getAction() {
            return this.action;
        }

        public Map<String, Object> getRequest() {
            return this.request;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public void markSent() {
            this.sent = true;
        }

        public boolean wasSent() {
            return this.sent;
        }
    }

    private static class OutstandingDisconnect {
        private final String action;
        private final Object data;
        /* access modifiers changed from: private */
        public final RequestResultCallback onComplete;
        private final List<String> path;

        private OutstandingDisconnect(String str, List<String> list, Object obj, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.path = list;
            this.data = obj;
            this.onComplete = requestResultCallback;
        }

        public String getAction() {
            return this.action;
        }

        public List<String> getPath() {
            return this.path;
        }

        public Object getData() {
            return this.data;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }
    }

    public PersistentConnectionImpl(ConnectionContext connectionContext, HostInfo hostInfo2, PersistentConnection.Delegate delegate2) {
        this.delegate = delegate2;
        this.context = connectionContext;
        ScheduledExecutorService executorService2 = connectionContext.getExecutorService();
        this.executorService = executorService2;
        this.authTokenProvider = connectionContext.getAuthTokenProvider();
        this.appCheckTokenProvider = connectionContext.getAppCheckTokenProvider();
        this.hostInfo = hostInfo2;
        this.listens = new HashMap();
        this.requestCBHash = new HashMap();
        this.outstandingPuts = new HashMap();
        this.outstandingGets = new ConcurrentHashMap();
        this.onDisconnectRequestQueue = new ArrayList();
        this.retryHelper = new RetryHelper.Builder(executorService2, connectionContext.getLogger(), "ConnectionRetryHelper").withMinDelayAfterFailure(1000).withRetryExponent(1.3d).withMaxDelay(SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY).withJitterFactor(0.7d).build();
        long j = connectionIds;
        connectionIds = 1 + j;
        this.logger = new LogWrapper(connectionContext.getLogger(), "PersistentConnection", "pc_" + j);
        this.lastSessionId = null;
        doIdleCheck();
    }

    public void onReady(long j, String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("onReady", new Object[0]);
        }
        this.lastConnectionEstablishedTime = System.currentTimeMillis();
        handleTimestamp(j);
        if (this.firstConnection) {
            sendConnectStats();
        }
        restoreTokens();
        this.firstConnection = false;
        this.lastSessionId = str;
        this.delegate.onConnect();
    }

    public void onCacheHost(String str) {
        this.cachedHost = str;
    }

    public void listen(List<String> list, Map<String, Object> map, ListenHashProvider listenHashProvider, Long l, RequestResultCallback requestResultCallback) {
        QuerySpec querySpec = new QuerySpec(list, map);
        if (this.logger.logsDebug()) {
            this.logger.debug("Listening on " + querySpec, new Object[0]);
        }
        ConnectionUtils.hardAssert(!this.listens.containsKey(querySpec), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.logger.logsDebug()) {
            this.logger.debug("Adding listen query: " + querySpec, new Object[0]);
        }
        OutstandingListen outstandingListen = new OutstandingListen(requestResultCallback, querySpec, l, listenHashProvider);
        this.listens.put(querySpec, outstandingListen);
        if (connected()) {
            sendListen(outstandingListen);
        }
        doIdleCheck();
    }

    public Task<Object> get(List<String> list, Map<String, Object> map) {
        QuerySpec querySpec = new QuerySpec(list, map);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        long j = this.readCounter;
        this.readCounter = 1 + j;
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(querySpec.path));
        hashMap.put("q", querySpec.queryParams);
        OutstandingGet outstandingGet = new OutstandingGet(REQUEST_ACTION_GET, hashMap, new ConnectionRequestCallback(querySpec, taskCompletionSource) {
            public final /* synthetic */ PersistentConnectionImpl.QuerySpec f$1;
            public final /* synthetic */ TaskCompletionSource f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onResponse(Map map) {
                PersistentConnectionImpl.this.lambda$get$0$PersistentConnectionImpl(this.f$1, this.f$2, map);
            }
        });
        this.outstandingGets.put(Long.valueOf(j), outstandingGet);
        if (!connected()) {
            this.executorService.schedule(new Runnable(outstandingGet, j, taskCompletionSource) {
                public final /* synthetic */ PersistentConnectionImpl.OutstandingGet f$1;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ TaskCompletionSource f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r5;
                }

                public final void run() {
                    PersistentConnectionImpl.this.lambda$get$1$PersistentConnectionImpl(this.f$1, this.f$2, this.f$3);
                }
            }, GET_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        }
        if (canSendReads()) {
            sendGet(Long.valueOf(j));
        }
        doIdleCheck();
        return taskCompletionSource.getTask();
    }

    public /* synthetic */ void lambda$get$0$PersistentConnectionImpl(QuerySpec querySpec, TaskCompletionSource taskCompletionSource, Map map) {
        if (((String) map.get("s")).equals("ok")) {
            Object obj = map.get("d");
            this.delegate.onDataUpdate(querySpec.path, obj, false, (Long) null);
            taskCompletionSource.setResult(obj);
            return;
        }
        taskCompletionSource.setException(new Exception((String) map.get("d")));
    }

    public /* synthetic */ void lambda$get$1$PersistentConnectionImpl(OutstandingGet outstandingGet, long j, TaskCompletionSource taskCompletionSource) {
        if (outstandingGet.markSent()) {
            if (this.logger.logsDebug()) {
                this.logger.debug("get " + j + " timed out waiting for connection", new Object[0]);
            }
            this.outstandingGets.remove(Long.valueOf(j));
            taskCompletionSource.setException(new Exception("Client is offline"));
        }
    }

    public void initialize() {
        tryScheduleReconnect();
    }

    public void shutdown() {
        interrupt("shutdown");
    }

    public void put(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        putInternal("p", list, obj, (String) null, requestResultCallback);
    }

    public void compareAndPut(List<String> list, Object obj, String str, RequestResultCallback requestResultCallback) {
        putInternal("p", list, obj, str, requestResultCallback);
    }

    public void merge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        putInternal("m", list, map, (String) null, requestResultCallback);
    }

    public void purgeOutstandingWrites() {
        for (OutstandingPut next : this.outstandingPuts.values()) {
            if (next.onComplete != null) {
                next.onComplete.onRequestResult("write_canceled", (String) null);
            }
        }
        for (OutstandingDisconnect next2 : this.onDisconnectRequestQueue) {
            if (next2.onComplete != null) {
                next2.onComplete.onRequestResult("write_canceled", (String) null);
            }
        }
        this.outstandingPuts.clear();
        this.onDisconnectRequestQueue.clear();
        if (!connected()) {
            this.hasOnDisconnects = false;
        }
        doIdleCheck();
    }

    public void onDataMessage(Map<String, Object> map) {
        if (map.containsKey(REQUEST_NUMBER)) {
            ConnectionRequestCallback remove = this.requestCBHash.remove(Long.valueOf((long) ((Integer) map.get(REQUEST_NUMBER)).intValue()));
            if (remove != null) {
                remove.onResponse((Map) map.get("b"));
            }
        } else if (!map.containsKey("error")) {
            if (map.containsKey("a")) {
                onDataPush((String) map.get("a"), (Map) map.get("b"));
            } else if (this.logger.logsDebug()) {
                this.logger.debug("Ignoring unknown message: " + map, new Object[0]);
            }
        }
    }

    public void onDisconnect(Connection.DisconnectReason disconnectReason) {
        boolean z = false;
        if (this.logger.logsDebug()) {
            this.logger.debug("Got on disconnect due to " + disconnectReason.name(), new Object[0]);
        }
        this.connectionState = ConnectionState.Disconnected;
        this.realtime = null;
        this.hasOnDisconnects = false;
        this.requestCBHash.clear();
        cancelSentTransactions();
        if (shouldReconnect()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.lastConnectionEstablishedTime;
            long j2 = currentTimeMillis - j;
            if (j > 0 && j2 > SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY) {
                z = true;
            }
            if (disconnectReason == Connection.DisconnectReason.SERVER_RESET || z) {
                this.retryHelper.signalSuccess();
            }
            tryScheduleReconnect();
        }
        this.lastConnectionEstablishedTime = 0;
        this.delegate.onDisconnect();
    }

    public void onKill(String str) {
        if (str.equals(INVALID_APP_CHECK_TOKEN)) {
            int i = this.invalidAppCheckTokenCount;
            if (((long) i) < 3) {
                this.invalidAppCheckTokenCount = i + 1;
                this.logger.warn("Detected invalid AppCheck token. Reconnecting (" + (3 - ((long) this.invalidAppCheckTokenCount)) + " attempts remaining)");
                return;
            }
        }
        this.logger.warn("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: " + str);
        interrupt(SERVER_KILL_INTERRUPT_REASON);
    }

    public void unlisten(List<String> list, Map<String, Object> map) {
        QuerySpec querySpec = new QuerySpec(list, map);
        if (this.logger.logsDebug()) {
            this.logger.debug("unlistening on " + querySpec, new Object[0]);
        }
        OutstandingListen removeListen = removeListen(querySpec);
        if (removeListen != null && connected()) {
            sendUnlisten(removeListen);
        }
        doIdleCheck();
    }

    private boolean connected() {
        return this.connectionState == ConnectionState.Authenticating || this.connectionState == ConnectionState.Connected;
    }

    public void onDisconnectPut(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_PUT, list, obj, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_PUT, list, obj, requestResultCallback));
        }
        doIdleCheck();
    }

    private boolean canSendWrites() {
        return this.connectionState == ConnectionState.Connected;
    }

    private boolean canSendReads() {
        return this.connectionState == ConnectionState.Connected;
    }

    public void onDisconnectMerge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback));
        }
        doIdleCheck();
    }

    public void onDisconnectCancel(List<String> list, RequestResultCallback requestResultCallback) {
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, (Object) null, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, (Object) null, requestResultCallback));
        }
        doIdleCheck();
    }

    public void interrupt(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("Connection interrupted for: " + str, new Object[0]);
        }
        this.interruptReasons.add(str);
        Connection connection = this.realtime;
        if (connection != null) {
            connection.close();
            this.realtime = null;
        } else {
            this.retryHelper.cancel();
            this.connectionState = ConnectionState.Disconnected;
        }
        this.retryHelper.signalSuccess();
    }

    public void resume(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("Connection no longer interrupted for: " + str, new Object[0]);
        }
        this.interruptReasons.remove(str);
        if (shouldReconnect() && this.connectionState == ConnectionState.Disconnected) {
            tryScheduleReconnect();
        }
    }

    public boolean isInterrupted(String str) {
        return this.interruptReasons.contains(str);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldReconnect() {
        return this.interruptReasons.size() == 0;
    }

    public void refreshAuthToken() {
        this.logger.debug("Auth token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    public void refreshAuthToken(String str) {
        this.logger.debug("Auth token refreshed.", new Object[0]);
        this.authToken = str;
        if (!connected()) {
            return;
        }
        if (str != null) {
            upgradeAuth();
        } else {
            sendUnauth();
        }
    }

    public void refreshAppCheckToken() {
        this.logger.debug("App check token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    public void refreshAppCheckToken(String str) {
        this.logger.debug("App check token refreshed.", new Object[0]);
        this.appCheckToken = str;
        if (!connected()) {
            return;
        }
        if (str != null) {
            upgradeAppCheck();
        } else {
            sendUnAppCheck();
        }
    }

    private void tryScheduleReconnect() {
        if (shouldReconnect()) {
            ConnectionUtils.hardAssert(this.connectionState == ConnectionState.Disconnected, "Not in disconnected state: %s", this.connectionState);
            boolean z = this.forceAuthTokenRefresh;
            boolean z2 = this.forceAppCheckTokenRefresh;
            this.logger.debug("Scheduling connection attempt", new Object[0]);
            this.forceAuthTokenRefresh = false;
            this.forceAppCheckTokenRefresh = false;
            this.retryHelper.retry(new Runnable(z, z2) {
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    PersistentConnectionImpl.this.lambda$tryScheduleReconnect$4$PersistentConnectionImpl(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$tryScheduleReconnect$4$PersistentConnectionImpl(boolean z, boolean z2) {
        ConnectionUtils.hardAssert(this.connectionState == ConnectionState.Disconnected, "Not in disconnected state: %s", this.connectionState);
        this.connectionState = ConnectionState.GettingToken;
        long j = this.currentGetTokenAttempt + 1;
        this.currentGetTokenAttempt = j;
        Task<String> fetchAuthToken = fetchAuthToken(z);
        Task<String> fetchAppCheckToken = fetchAppCheckToken(z2);
        Tasks.whenAll((Task<?>[]) new Task[]{fetchAuthToken, fetchAppCheckToken}).addOnSuccessListener((Executor) this.executorService, new OnSuccessListener(j, fetchAuthToken, fetchAppCheckToken) {
            public final /* synthetic */ long f$1;
            public final /* synthetic */ Task f$2;
            public final /* synthetic */ Task f$3;

            {
                this.f$1 = r2;
                this.f$2 = r4;
                this.f$3 = r5;
            }

            public final void onSuccess(Object obj) {
                PersistentConnectionImpl.this.lambda$tryScheduleReconnect$2$PersistentConnectionImpl(this.f$1, this.f$2, this.f$3, (Void) obj);
            }
        }).addOnFailureListener((Executor) this.executorService, (OnFailureListener) new OnFailureListener(j) {
            public final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                PersistentConnectionImpl.this.lambda$tryScheduleReconnect$3$PersistentConnectionImpl(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$tryScheduleReconnect$2$PersistentConnectionImpl(long j, Task task, Task task2, Void voidR) {
        if (j != this.currentGetTokenAttempt) {
            this.logger.debug("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
        } else if (this.connectionState == ConnectionState.GettingToken) {
            this.logger.debug("Successfully fetched token, opening connection", new Object[0]);
            openNetworkConnection((String) task.getResult(), (String) task2.getResult());
        } else if (this.connectionState == ConnectionState.Disconnected) {
            this.logger.debug("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
        }
    }

    public /* synthetic */ void lambda$tryScheduleReconnect$3$PersistentConnectionImpl(long j, Exception exc) {
        if (j == this.currentGetTokenAttempt) {
            this.connectionState = ConnectionState.Disconnected;
            this.logger.debug("Error fetching token: " + exc, new Object[0]);
            tryScheduleReconnect();
            return;
        }
        this.logger.debug("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
    }

    private Task<String> fetchAuthToken(boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.logger.debug("Trying to fetch auth token", new Object[0]);
        this.authTokenProvider.getToken(z, new ConnectionTokenProvider.GetTokenCallback() {
            public void onSuccess(String str) {
                taskCompletionSource.setResult(str);
            }

            public void onError(String str) {
                taskCompletionSource.setException(new Exception(str));
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<String> fetchAppCheckToken(boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.logger.debug("Trying to fetch app check token", new Object[0]);
        this.appCheckTokenProvider.getToken(z, new ConnectionTokenProvider.GetTokenCallback() {
            public void onSuccess(String str) {
                taskCompletionSource.setResult(str);
            }

            public void onError(String str) {
                taskCompletionSource.setException(new Exception(str));
            }
        });
        return taskCompletionSource.getTask();
    }

    public void openNetworkConnection(String str, String str2) {
        ConnectionUtils.hardAssert(this.connectionState == ConnectionState.GettingToken, "Trying to open network connection while in the wrong state: %s", this.connectionState);
        if (str == null) {
            this.delegate.onConnectionStatus(false);
        }
        this.authToken = str;
        this.appCheckToken = str2;
        this.connectionState = ConnectionState.Connecting;
        Connection connection = new Connection(this.context, this.hostInfo, this.cachedHost, this, this.lastSessionId, str2);
        this.realtime = connection;
        connection.open();
    }

    private void sendOnDisconnect(String str, List<String> list, Object obj, final RequestResultCallback requestResultCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(list));
        hashMap.put("d", obj);
        sendAction(str, hashMap, new ConnectionRequestCallback() {
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                String str2 = null;
                if (!str.equals("ok")) {
                    str2 = (String) map.get("d");
                } else {
                    str = null;
                }
                RequestResultCallback requestResultCallback = requestResultCallback;
                if (requestResultCallback != null) {
                    requestResultCallback.onRequestResult(str, str2);
                }
            }
        });
    }

    private void cancelSentTransactions() {
        ArrayList<OutstandingPut> arrayList = new ArrayList<>();
        Iterator<Map.Entry<Long, OutstandingPut>> it2 = this.outstandingPuts.entrySet().iterator();
        while (it2.hasNext()) {
            OutstandingPut outstandingPut = (OutstandingPut) it2.next().getValue();
            if (outstandingPut.getRequest().containsKey(REQUEST_DATA_HASH) && outstandingPut.wasSent()) {
                arrayList.add(outstandingPut);
                it2.remove();
            }
        }
        for (OutstandingPut onComplete : arrayList) {
            onComplete.getOnComplete().onRequestResult("disconnected", (String) null);
        }
    }

    private void sendUnlisten(OutstandingListen outstandingListen) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(outstandingListen.query.path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put("q", outstandingListen.getQuery().queryParams);
            hashMap.put("t", tag);
        }
        sendAction(REQUEST_ACTION_QUERY_UNLISTEN, hashMap, (ConnectionRequestCallback) null);
    }

    /* access modifiers changed from: private */
    public OutstandingListen removeListen(QuerySpec querySpec) {
        if (this.logger.logsDebug()) {
            this.logger.debug("removing query " + querySpec, new Object[0]);
        }
        if (this.listens.containsKey(querySpec)) {
            OutstandingListen outstandingListen = this.listens.get(querySpec);
            this.listens.remove(querySpec);
            doIdleCheck();
            return outstandingListen;
        } else if (!this.logger.logsDebug()) {
            return null;
        } else {
            this.logger.debug("Trying to remove listener for QuerySpec " + querySpec + " but no listener exists.", new Object[0]);
            return null;
        }
    }

    private Collection<OutstandingListen> removeListens(List<String> list) {
        if (this.logger.logsDebug()) {
            this.logger.debug("removing all listens at path " + list, new Object[0]);
        }
        ArrayList<OutstandingListen> arrayList = new ArrayList<>();
        for (Map.Entry next : this.listens.entrySet()) {
            OutstandingListen outstandingListen = (OutstandingListen) next.getValue();
            if (((QuerySpec) next.getKey()).path.equals(list)) {
                arrayList.add(outstandingListen);
            }
        }
        for (OutstandingListen query : arrayList) {
            this.listens.remove(query.getQuery());
        }
        doIdleCheck();
        return arrayList;
    }

    private void onDataPush(String str, Map<String, Object> map) {
        if (this.logger.logsDebug()) {
            this.logger.debug("handleServerMessage: " + str + " " + map, new Object[0]);
        }
        if (str.equals("d") || str.equals("m")) {
            boolean equals = str.equals("m");
            String str2 = (String) map.get("p");
            Object obj = map.get("d");
            Long longFromObject = ConnectionUtils.longFromObject(map.get("t"));
            if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.delegate.onDataUpdate(ConnectionUtils.stringToPath(str2), obj, equals, longFromObject);
            } else if (this.logger.logsDebug()) {
                this.logger.debug("ignoring empty merge for path " + str2, new Object[0]);
            }
        } else if (str.equals(SERVER_ASYNC_DATA_RANGE_MERGE)) {
            String str3 = (String) map.get("p");
            List<String> stringToPath = ConnectionUtils.stringToPath(str3);
            Object obj2 = map.get("d");
            Long longFromObject2 = ConnectionUtils.longFromObject(map.get("t"));
            ArrayList arrayList = new ArrayList();
            for (Map map2 : (List) obj2) {
                String str4 = (String) map2.get("s");
                String str5 = (String) map2.get(SERVER_DATA_END_PATH);
                List<String> list = null;
                List<String> stringToPath2 = str4 != null ? ConnectionUtils.stringToPath(str4) : null;
                if (str5 != null) {
                    list = ConnectionUtils.stringToPath(str5);
                }
                arrayList.add(new RangeMerge(stringToPath2, list, map2.get("m")));
            }
            if (!arrayList.isEmpty()) {
                this.delegate.onRangeMergeUpdate(stringToPath, arrayList, longFromObject2);
            } else if (this.logger.logsDebug()) {
                this.logger.debug("Ignoring empty range merge for path " + str3, new Object[0]);
            }
        } else if (str.equals("c")) {
            onListenRevoked(ConnectionUtils.stringToPath((String) map.get("p")));
        } else if (str.equals(SERVER_ASYNC_AUTH_REVOKED)) {
            onAuthRevoked((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals(SERVER_ASYNC_APP_CHECK_REVOKED)) {
            onAppCheckRevoked((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals(SERVER_ASYNC_SECURITY_DEBUG)) {
            onSecurityDebugPacket(map);
        } else if (this.logger.logsDebug()) {
            this.logger.debug("Unrecognized action from server: " + str, new Object[0]);
        }
    }

    private void onListenRevoked(List<String> list) {
        Collection<OutstandingListen> removeListens = removeListens(list);
        if (removeListens != null) {
            for (OutstandingListen access$800 : removeListens) {
                access$800.resultCallback.onRequestResult("permission_denied", (String) null);
            }
        }
    }

    private void onAuthRevoked(String str, String str2) {
        this.logger.debug("Auth token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.authToken = null;
        this.forceAuthTokenRefresh = true;
        this.delegate.onConnectionStatus(false);
        this.realtime.close();
    }

    private void onAppCheckRevoked(String str, String str2) {
        this.logger.debug("App check token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.appCheckToken = null;
        this.forceAppCheckTokenRefresh = true;
    }

    private void onSecurityDebugPacket(Map<String, Object> map) {
        this.logger.info((String) map.get(NotificationCompat.CATEGORY_MESSAGE));
    }

    private void upgradeAuth() {
        sendAuthHelper(false);
    }

    private void upgradeAppCheck() {
        sendAppCheckTokenHelper(false);
    }

    private void sendAuthAndRestoreState() {
        sendAuthHelper(true);
    }

    private void sendAuthHelper(final boolean z) {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending auth.", new Object[0]);
        }
        AnonymousClass4 r0 = new ConnectionRequestCallback() {
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    ConnectionState unused = PersistentConnectionImpl.this.connectionState = ConnectionState.Connected;
                    int unused2 = PersistentConnectionImpl.this.invalidAuthTokenCount = 0;
                    PersistentConnectionImpl.this.sendAppCheckTokenHelper(z);
                    return;
                }
                String unused3 = PersistentConnectionImpl.this.authToken = null;
                boolean unused4 = PersistentConnectionImpl.this.forceAuthTokenRefresh = true;
                PersistentConnectionImpl.this.delegate.onConnectionStatus(false);
                PersistentConnectionImpl.this.logger.debug("Authentication failed: " + str + " (" + ((String) map.get("d")) + ")", new Object[0]);
                PersistentConnectionImpl.this.realtime.close();
                if (str.equals("invalid_token")) {
                    PersistentConnectionImpl.access$1008(PersistentConnectionImpl.this);
                    if (((long) PersistentConnectionImpl.this.invalidAuthTokenCount) >= 3) {
                        PersistentConnectionImpl.this.retryHelper.setMaxDelay();
                        PersistentConnectionImpl.this.logger.warn("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                    }
                }
            }
        };
        HashMap hashMap = new HashMap();
        GAuthToken tryParseFromString = GAuthToken.tryParseFromString(this.authToken);
        if (tryParseFromString != null) {
            hashMap.put(REQUEST_CREDENTIAL, tryParseFromString.getToken());
            if (tryParseFromString.getAuth() != null) {
                hashMap.put(REQUEST_AUTHVAR, tryParseFromString.getAuth());
            }
            sendSensitive(REQUEST_ACTION_GAUTH, true, hashMap, r0);
            return;
        }
        hashMap.put(REQUEST_CREDENTIAL, this.authToken);
        sendSensitive(REQUEST_ACTION_AUTH, true, hashMap, r0);
    }

    /* access modifiers changed from: private */
    public void sendAppCheckTokenHelper(boolean z) {
        if (this.appCheckToken == null) {
            restoreState();
            return;
        }
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending app check.", new Object[0]);
        }
        $$Lambda$PersistentConnectionImpl$VjiellejRLwMybObY56JkAvcTGw r0 = new ConnectionRequestCallback(z) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void onResponse(Map map) {
                PersistentConnectionImpl.this.lambda$sendAppCheckTokenHelper$5$PersistentConnectionImpl(this.f$1, map);
            }
        };
        HashMap hashMap = new HashMap();
        ConnectionUtils.hardAssert(this.appCheckToken != null, "App check token must be set!", new Object[0]);
        hashMap.put(REQUEST_APPCHECK_TOKEN, this.appCheckToken);
        sendSensitive(REQUEST_ACTION_APPCHECK, true, hashMap, r0);
    }

    public /* synthetic */ void lambda$sendAppCheckTokenHelper$5$PersistentConnectionImpl(boolean z, Map map) {
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            this.invalidAppCheckTokenCount = 0;
        } else {
            this.appCheckToken = null;
            this.forceAppCheckTokenRefresh = true;
            this.logger.debug("App check failed: " + str + " (" + ((String) map.get("d")) + ")", new Object[0]);
        }
        if (z) {
            restoreState();
        }
    }

    private void sendUnauth() {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        ConnectionUtils.hardAssert(this.authToken == null, "Auth token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAUTH, Collections.emptyMap(), (ConnectionRequestCallback) null);
    }

    private void sendUnAppCheck() {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        ConnectionUtils.hardAssert(this.appCheckToken == null, "App check token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAPPCHECK, Collections.emptyMap(), (ConnectionRequestCallback) null);
    }

    private void restoreTokens() {
        if (this.logger.logsDebug()) {
            this.logger.debug("calling restore tokens", new Object[0]);
        }
        ConnectionUtils.hardAssert(this.connectionState == ConnectionState.Connecting, "Wanted to restore tokens, but was in wrong state: %s", this.connectionState);
        if (this.authToken != null) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring auth.", new Object[0]);
            }
            this.connectionState = ConnectionState.Authenticating;
            sendAuthAndRestoreState();
            return;
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Not restoring auth because auth token is null.", new Object[0]);
        }
        this.connectionState = ConnectionState.Connected;
        sendAppCheckTokenHelper(true);
    }

    private void restoreState() {
        ConnectionUtils.hardAssert(this.connectionState == ConnectionState.Connected, "Should be connected if we're restoring state, but we are: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring outstanding listens", new Object[0]);
        }
        for (OutstandingListen next : this.listens.values()) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring listen " + next.getQuery(), new Object[0]);
            }
            sendListen(next);
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.outstandingPuts.keySet());
        Collections.sort(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            sendPut(((Long) it2.next()).longValue());
        }
        for (OutstandingDisconnect next2 : this.onDisconnectRequestQueue) {
            sendOnDisconnect(next2.getAction(), next2.getPath(), next2.getData(), next2.getOnComplete());
        }
        this.onDisconnectRequestQueue.clear();
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring reads.", new Object[0]);
        }
        ArrayList arrayList2 = new ArrayList(this.outstandingGets.keySet());
        Collections.sort(arrayList2);
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            sendGet((Long) it3.next());
        }
    }

    private void handleTimestamp(long j) {
        if (this.logger.logsDebug()) {
            this.logger.debug("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.DOT_INFO_SERVERTIME_OFFSET, Long.valueOf(currentTimeMillis));
        this.delegate.onServerInfoUpdate(hashMap);
    }

    private Map<String, Object> getPutObject(List<String> list, Object obj, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(list));
        hashMap.put("d", obj);
        if (str != null) {
            hashMap.put(REQUEST_DATA_HASH, str);
        }
        return hashMap;
    }

    private void putInternal(String str, List<String> list, Object obj, String str2, RequestResultCallback requestResultCallback) {
        Map<String, Object> putObject = getPutObject(list, obj, str2);
        long j = this.writeCounter;
        this.writeCounter = 1 + j;
        this.outstandingPuts.put(Long.valueOf(j), new OutstandingPut(str, putObject, requestResultCallback));
        if (canSendWrites()) {
            sendPut(j);
        }
        this.lastWriteTimestamp = System.currentTimeMillis();
        doIdleCheck();
    }

    private void sendPut(long j) {
        ConnectionUtils.hardAssert(canSendWrites(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        final OutstandingPut outstandingPut = this.outstandingPuts.get(Long.valueOf(j));
        final RequestResultCallback onComplete = outstandingPut.getOnComplete();
        String action = outstandingPut.getAction();
        outstandingPut.markSent();
        final String str = action;
        final long j2 = j;
        sendAction(action, outstandingPut.getRequest(), new ConnectionRequestCallback() {
            public void onResponse(Map<String, Object> map) {
                if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    PersistentConnectionImpl.this.logger.debug(str + " response: " + map, new Object[0]);
                }
                if (((OutstandingPut) PersistentConnectionImpl.this.outstandingPuts.get(Long.valueOf(j2))) == outstandingPut) {
                    PersistentConnectionImpl.this.outstandingPuts.remove(Long.valueOf(j2));
                    if (onComplete != null) {
                        String str = (String) map.get("s");
                        if (str.equals("ok")) {
                            onComplete.onRequestResult((String) null, (String) null);
                        } else {
                            onComplete.onRequestResult(str, (String) map.get("d"));
                        }
                    }
                } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    PersistentConnectionImpl.this.logger.debug("Ignoring on complete for put " + j2 + " because it was removed already.", new Object[0]);
                }
                PersistentConnectionImpl.this.doIdleCheck();
            }
        });
    }

    private void sendGet(final Long l) {
        ConnectionUtils.hardAssert(canSendReads(), "sendGet called when we can't send gets", new Object[0]);
        final OutstandingGet outstandingGet = this.outstandingGets.get(l);
        if (outstandingGet.markSent() || !this.logger.logsDebug()) {
            sendAction(REQUEST_ACTION_GET, outstandingGet.getRequest(), new ConnectionRequestCallback() {
                public void onResponse(Map<String, Object> map) {
                    if (((OutstandingGet) PersistentConnectionImpl.this.outstandingGets.get(l)) == outstandingGet) {
                        PersistentConnectionImpl.this.outstandingGets.remove(l);
                        outstandingGet.getOnComplete().onResponse(map);
                    } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                        PersistentConnectionImpl.this.logger.debug("Ignoring on complete for get " + l + " because it was removed already.", new Object[0]);
                    }
                }
            });
        } else {
            this.logger.debug("get" + l + " cancelled, ignoring.", new Object[0]);
        }
    }

    private void sendListen(final OutstandingListen outstandingListen) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(outstandingListen.getQuery().path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put("q", outstandingListen.query.queryParams);
            hashMap.put("t", tag);
        }
        ListenHashProvider hashFunction = outstandingListen.getHashFunction();
        hashMap.put(REQUEST_DATA_HASH, hashFunction.getSimpleHash());
        if (hashFunction.shouldIncludeCompoundHash()) {
            CompoundHash compoundHash = hashFunction.getCompoundHash();
            ArrayList arrayList = new ArrayList();
            for (List<String> pathToString : compoundHash.getPosts()) {
                arrayList.add(ConnectionUtils.pathToString(pathToString));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(REQUEST_COMPOUND_HASH_HASHES, compoundHash.getHashes());
            hashMap2.put(REQUEST_COMPOUND_HASH_PATHS, arrayList);
            hashMap.put(REQUEST_COMPOUND_HASH, hashMap2);
        }
        sendAction("q", hashMap, new ConnectionRequestCallback() {
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    Map map2 = (Map) map.get("d");
                    if (map2.containsKey(PersistentConnectionImpl.SERVER_DATA_WARNINGS)) {
                        PersistentConnectionImpl.this.warnOnListenerWarnings((List) map2.get(PersistentConnectionImpl.SERVER_DATA_WARNINGS), outstandingListen.query);
                    }
                }
                if (((OutstandingListen) PersistentConnectionImpl.this.listens.get(outstandingListen.getQuery())) != outstandingListen) {
                    return;
                }
                if (!str.equals("ok")) {
                    OutstandingListen unused = PersistentConnectionImpl.this.removeListen(outstandingListen.getQuery());
                    outstandingListen.resultCallback.onRequestResult(str, (String) map.get("d"));
                    return;
                }
                outstandingListen.resultCallback.onRequestResult((String) null, (String) null);
            }
        });
    }

    private void sendStats(Map<String, Integer> map) {
        if (!map.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("c", map);
            sendAction("s", hashMap, new ConnectionRequestCallback() {
                public void onResponse(Map<String, Object> map) {
                    String str = (String) map.get("s");
                    if (!str.equals("ok")) {
                        String str2 = (String) map.get("d");
                        if (PersistentConnectionImpl.this.logger.logsDebug()) {
                            PersistentConnectionImpl.this.logger.debug("Failed to send stats: " + str + " (message: " + str2 + ")", new Object[0]);
                        }
                    }
                }
            });
        } else if (this.logger.logsDebug()) {
            this.logger.debug("Not sending stats because stats are empty", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void warnOnListenerWarnings(List<String> list, QuerySpec querySpec) {
        if (list.contains("no_index")) {
            this.logger.warn("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '" + ("\".indexOn\": \"" + querySpec.queryParams.get("i") + Typography.quote) + "' at " + ConnectionUtils.pathToString(querySpec.path) + " to your security and Firebase Database rules for better performance");
        }
    }

    private void sendConnectStats() {
        HashMap hashMap = new HashMap();
        if (this.context.isPersistenceEnabled()) {
            hashMap.put("persistence.android.enabled", 1);
        }
        hashMap.put("sdk.android." + this.context.getClientSdkVersion().replace('.', '-'), 1);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending first connection stats", new Object[0]);
        }
        sendStats(hashMap);
    }

    private void sendAction(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        sendSensitive(str, false, map, connectionRequestCallback);
    }

    private void sendSensitive(String str, boolean z, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        long nextRequestNumber = nextRequestNumber();
        HashMap hashMap = new HashMap();
        hashMap.put(REQUEST_NUMBER, Long.valueOf(nextRequestNumber));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.realtime.sendRequest(hashMap, z);
        this.requestCBHash.put(Long.valueOf(nextRequestNumber), connectionRequestCallback);
    }

    private long nextRequestNumber() {
        long j = this.requestCounter;
        this.requestCounter = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    public void doIdleCheck() {
        if (isIdle()) {
            ScheduledFuture<?> scheduledFuture = this.inactivityTimer;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.inactivityTimer = this.executorService.schedule(new Runnable() {
                public void run() {
                    ScheduledFuture unused = PersistentConnectionImpl.this.inactivityTimer = null;
                    if (PersistentConnectionImpl.this.idleHasTimedOut()) {
                        PersistentConnectionImpl.this.interrupt(PersistentConnectionImpl.IDLE_INTERRUPT_REASON);
                    } else {
                        PersistentConnectionImpl.this.doIdleCheck();
                    }
                }
            }, IDLE_TIMEOUT, TimeUnit.MILLISECONDS);
        } else if (isInterrupted(IDLE_INTERRUPT_REASON)) {
            ConnectionUtils.hardAssert(!isIdle());
            resume(IDLE_INTERRUPT_REASON);
        }
    }

    private boolean isIdle() {
        return this.listens.isEmpty() && this.outstandingGets.isEmpty() && this.requestCBHash.isEmpty() && !this.hasOnDisconnects && this.outstandingPuts.isEmpty();
    }

    /* access modifiers changed from: private */
    public boolean idleHasTimedOut() {
        return isIdle() && System.currentTimeMillis() > this.lastWriteTimestamp + IDLE_TIMEOUT;
    }

    public void injectConnectionFailure() {
        Connection connection = this.realtime;
        if (connection != null) {
            connection.injectConnectionFailure();
        }
    }
}
