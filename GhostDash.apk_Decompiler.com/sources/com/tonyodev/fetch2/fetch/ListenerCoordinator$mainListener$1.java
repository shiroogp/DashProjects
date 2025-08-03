package com.tonyodev.fetch2.fetch;

import com.brentvatne.react.ReactVideoView;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchGroup;
import com.tonyodev.fetch2.FetchGroupListener;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2core.DownloadBlock;
import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.Reason;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006!"}, d2 = {"com/tonyodev/fetch2/fetch/ListenerCoordinator$mainListener$1", "Lcom/tonyodev/fetch2/FetchListener;", "onAdded", "", "download", "Lcom/tonyodev/fetch2/Download;", "onCancelled", "onCompleted", "onDeleted", "onDownloadBlockUpdated", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlock;", "totalBlocks", "", "onError", "error", "Lcom/tonyodev/fetch2/Error;", "throwable", "", "onPaused", "onProgress", "etaInMilliSeconds", "", "downloadedBytesPerSecond", "onQueued", "waitingOnNetwork", "", "onRemoved", "onResumed", "onStarted", "downloadBlocks", "", "onWaitingNetwork", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ListenerCoordinator.kt */
public final class ListenerCoordinator$mainListener$1 implements FetchListener {
    final /* synthetic */ ListenerCoordinator this$0;

    ListenerCoordinator$mainListener$1(ListenerCoordinator listenerCoordinator) {
        this.this$0 = listenerCoordinator;
    }

    public void onAdded(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onAdded$$inlined$synchronized$lambda$1(fetchListener, this, download));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_ADDED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onAdded$$inlined$synchronized$lambda$2(fetchGroupListener, group, groupReplace, this, download));
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_ADDED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onAdded$$inlined$synchronized$lambda$3(fetchObserver, this, download));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onQueued(Download download, boolean z) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onQueued$$inlined$synchronized$lambda$1(fetchListener, this, download, z));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_QUEUED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onQueued(group, download, z, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_QUEUED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onQueued$$inlined$synchronized$lambda$2(fetchObserver, this, download, z));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onWaitingNetwork(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onWaitingNetwork$$inlined$synchronized$lambda$1(fetchListener, this, download));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_WAITING_ON_NETWORK);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onWaitingNetwork(group, download, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_WAITING_ON_NETWORK);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onWaitingNetwork$$inlined$synchronized$lambda$2(fetchObserver, this, download));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onCompleted(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onCompleted$$inlined$synchronized$lambda$1(this, download));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onCompleted$$inlined$synchronized$lambda$2(fetchListener, this, download));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_COMPLETED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onCompleted(group, download, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_COMPLETED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onCompleted$$inlined$synchronized$lambda$3(fetchObserver, this, download));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onError(Download download, Error error, Throwable th) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(error, ReactVideoView.EVENT_PROP_ERROR);
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onError$$inlined$synchronized$lambda$1(this, download, error, th));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onError$$inlined$synchronized$lambda$2(fetchListener, this, download, error, th));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_ERROR);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onError(group, download, error, th, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_ERROR);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onError$$inlined$synchronized$lambda$3(fetchObserver, this, download, error, th));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(downloadBlock, "downloadBlock");
        synchronized (this.this$0.lock) {
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        fetchListener.onDownloadBlockUpdated(download, downloadBlock, i);
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_BLOCK_UPDATED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onDownloadBlockUpdated(group, download, downloadBlock, i, groupReplace);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onStarted(Download download, List<? extends DownloadBlock> list, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(list, "downloadBlocks");
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onStarted$$inlined$synchronized$lambda$1(this, download, list, i));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onStarted$$inlined$synchronized$lambda$2(fetchListener, this, download, list, i));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_STARTED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onStarted(group, download, list, i, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_STARTED);
            }
            List<WeakReference> list2 = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list2 != null) {
                for (WeakReference weakReference : list2) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onStarted$$inlined$synchronized$lambda$3(fetchObserver, this, download, list, i));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onProgress(Download download, long j, long j2) {
        Download download2 = download;
        Intrinsics.checkParameterIsNotNull(download2, "download");
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onProgress$$inlined$synchronized$lambda$1(this, download, j, j2));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onProgress$$inlined$synchronized$lambda$2(fetchListener, this, download, j, j2));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download2, Reason.DOWNLOAD_PROGRESS_CHANGED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onProgress(group, download, j, j2, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download2, Reason.DOWNLOAD_PROGRESS_CHANGED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onProgress$$inlined$synchronized$lambda$3(fetchObserver, this, download, j, j2));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onPaused(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onPaused$$inlined$synchronized$lambda$1(this, download));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onPaused$$inlined$synchronized$lambda$2(fetchListener, this, download));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_PAUSED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onPaused(group, download, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_PAUSED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onPaused$$inlined$synchronized$lambda$3(fetchObserver, this, download));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onResumed(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onResumed$$inlined$synchronized$lambda$1(this, download));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onResumed$$inlined$synchronized$lambda$2(fetchListener, this, download));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_RESUMED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onResumed(group, download, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_RESUMED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onResumed$$inlined$synchronized$lambda$3(fetchObserver, this, download));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onCancelled(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onCancelled$$inlined$synchronized$lambda$1(this, download));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onCancelled$$inlined$synchronized$lambda$2(fetchListener, this, download));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_CANCELLED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onCancelled(group, download, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_CANCELLED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onCancelled$$inlined$synchronized$lambda$3(fetchObserver, this, download));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onRemoved(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onRemoved$$inlined$synchronized$lambda$1(this, download));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onRemoved$$inlined$synchronized$lambda$2(fetchListener, this, download));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_REMOVED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onRemoved(group, download, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_REMOVED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onRemoved$$inlined$synchronized$lambda$3(fetchObserver, this, download));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onDeleted(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.this$0.lock) {
            this.this$0.fetchNotificationHandler.post(new ListenerCoordinator$mainListener$1$onDeleted$$inlined$synchronized$lambda$1(this, download));
            for (Set it2 : this.this$0.fetchListenerMap.values()) {
                Iterator it3 = it2.iterator();
                while (it3.hasNext()) {
                    FetchListener fetchListener = (FetchListener) ((WeakReference) it3.next()).get();
                    if (fetchListener == null) {
                        it3.remove();
                    } else {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onDeleted$$inlined$synchronized$lambda$2(fetchListener, this, download));
                    }
                }
            }
            if (!this.this$0.fetchGroupListenerMap.isEmpty()) {
                int group = download.getGroup();
                FetchGroup groupReplace = this.this$0.groupInfoProvider.getGroupReplace(group, download, Reason.DOWNLOAD_DELETED);
                for (Set it4 : this.this$0.fetchGroupListenerMap.values()) {
                    Iterator it5 = it4.iterator();
                    while (it5.hasNext()) {
                        FetchGroupListener fetchGroupListener = (FetchGroupListener) ((WeakReference) it5.next()).get();
                        if (fetchGroupListener == null) {
                            it5.remove();
                        } else {
                            fetchGroupListener.onDeleted(group, download, groupReplace);
                        }
                    }
                }
            } else {
                this.this$0.groupInfoProvider.postGroupReplace(download.getGroup(), download, Reason.DOWNLOAD_DELETED);
            }
            List<WeakReference> list = (List) this.this$0.downloadsObserverMap.get(Integer.valueOf(download.getId()));
            if (list != null) {
                for (WeakReference weakReference : list) {
                    FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                    if (fetchObserver != null) {
                        this.this$0.uiHandler.post(new ListenerCoordinator$mainListener$1$onDeleted$$inlined$synchronized$lambda$3(fetchObserver, this, download));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
