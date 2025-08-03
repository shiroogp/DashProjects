package com.tonyodev.fetch2.fetch;

import android.os.Handler;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.FetchGroupListener;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.FetchNotificationManager;
import com.tonyodev.fetch2.provider.DownloadProvider;
import com.tonyodev.fetch2.provider.GroupInfoProvider;
import com.tonyodev.fetch2core.FetchObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ3\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\u001e\u0010#\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100$\"\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0019J\u0006\u0010,\u001a\u00020!J3\u0010-\u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\u001e\u0010#\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100$\"\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010%J\u0016\u0010.\u001a\u00020!2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0016J\u000e\u0010/\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u000e0\fX\u0004¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000f0\u00130\fX\u0004¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000f0\u00130\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "", "namespace", "", "groupInfoProvider", "Lcom/tonyodev/fetch2/provider/GroupInfoProvider;", "downloadProvider", "Lcom/tonyodev/fetch2/provider/DownloadProvider;", "uiHandler", "Landroid/os/Handler;", "(Ljava/lang/String;Lcom/tonyodev/fetch2/provider/GroupInfoProvider;Lcom/tonyodev/fetch2/provider/DownloadProvider;Landroid/os/Handler;)V", "downloadsObserverMap", "", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/tonyodev/fetch2core/FetchObserver;", "Lcom/tonyodev/fetch2/Download;", "fetchGroupListenerMap", "", "Lcom/tonyodev/fetch2/FetchGroupListener;", "fetchListenerMap", "Lcom/tonyodev/fetch2/FetchListener;", "fetchNotificationHandler", "fetchNotificationManagerList", "Lcom/tonyodev/fetch2/FetchNotificationManager;", "lock", "mainListener", "getMainListener", "()Lcom/tonyodev/fetch2/FetchListener;", "getNamespace", "()Ljava/lang/String;", "addFetchObserversForDownload", "", "downloadId", "fetchObservers", "", "(I[Lcom/tonyodev/fetch2core/FetchObserver;)V", "addListener", "id", "fetchListener", "addNotificationManager", "fetchNotificationManager", "cancelOnGoingNotifications", "clearAll", "removeFetchObserversForDownload", "removeListener", "removeNotificationManager", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ListenerCoordinator.kt */
public final class ListenerCoordinator {
    private final DownloadProvider downloadProvider;
    /* access modifiers changed from: private */
    public final Map<Integer, List<WeakReference<FetchObserver<Download>>>> downloadsObserverMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<Integer, Set<WeakReference<FetchGroupListener>>> fetchGroupListenerMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<Integer, Set<WeakReference<FetchListener>>> fetchListenerMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Handler fetchNotificationHandler = ((Handler) ListenerCoordinator$fetchNotificationHandler$1.INSTANCE.invoke());
    /* access modifiers changed from: private */
    public final List<FetchNotificationManager> fetchNotificationManagerList = new ArrayList();
    /* access modifiers changed from: private */
    public final GroupInfoProvider groupInfoProvider;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final FetchListener mainListener = new ListenerCoordinator$mainListener$1(this);
    private final String namespace;
    /* access modifiers changed from: private */
    public final Handler uiHandler;

    public ListenerCoordinator(String str, GroupInfoProvider groupInfoProvider2, DownloadProvider downloadProvider2, Handler handler) {
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        Intrinsics.checkParameterIsNotNull(groupInfoProvider2, "groupInfoProvider");
        Intrinsics.checkParameterIsNotNull(downloadProvider2, "downloadProvider");
        Intrinsics.checkParameterIsNotNull(handler, "uiHandler");
        this.namespace = str;
        this.groupInfoProvider = groupInfoProvider2;
        this.downloadProvider = downloadProvider2;
        this.uiHandler = handler;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final void addListener(int i, FetchListener fetchListener) {
        Intrinsics.checkParameterIsNotNull(fetchListener, "fetchListener");
        synchronized (this.lock) {
            Set set = this.fetchListenerMap.get(Integer.valueOf(i));
            if (set == null) {
                set = new LinkedHashSet();
            }
            set.add(new WeakReference(fetchListener));
            this.fetchListenerMap.put(Integer.valueOf(i), set);
            if (fetchListener instanceof FetchGroupListener) {
                Set set2 = this.fetchGroupListenerMap.get(Integer.valueOf(i));
                if (set2 == null) {
                    set2 = new LinkedHashSet();
                }
                set2.add(new WeakReference(fetchListener));
                this.fetchGroupListenerMap.put(Integer.valueOf(i), set2);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeListener(int i, FetchListener fetchListener) {
        Intrinsics.checkParameterIsNotNull(fetchListener, "fetchListener");
        synchronized (this.lock) {
            Set set = this.fetchListenerMap.get(Integer.valueOf(i));
            Iterator it2 = null;
            Iterator it3 = set != null ? set.iterator() : null;
            if (it3 != null) {
                while (true) {
                    if (it3.hasNext()) {
                        if (Intrinsics.areEqual((Object) (FetchListener) ((WeakReference) it3.next()).get(), (Object) fetchListener)) {
                            it3.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (fetchListener instanceof FetchGroupListener) {
                Set set2 = this.fetchGroupListenerMap.get(Integer.valueOf(i));
                if (set2 != null) {
                    it2 = set2.iterator();
                }
                if (it2 != null) {
                    while (true) {
                        if (it2.hasNext()) {
                            if (Intrinsics.areEqual((Object) (FetchGroupListener) ((WeakReference) it2.next()).get(), (Object) fetchListener)) {
                                it2.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addNotificationManager(FetchNotificationManager fetchNotificationManager) {
        Intrinsics.checkParameterIsNotNull(fetchNotificationManager, "fetchNotificationManager");
        synchronized (this.lock) {
            if (!this.fetchNotificationManagerList.contains(fetchNotificationManager)) {
                this.fetchNotificationManagerList.add(fetchNotificationManager);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeNotificationManager(FetchNotificationManager fetchNotificationManager) {
        Intrinsics.checkParameterIsNotNull(fetchNotificationManager, "fetchNotificationManager");
        synchronized (this.lock) {
            this.fetchNotificationManagerList.remove(fetchNotificationManager);
        }
    }

    public final void cancelOnGoingNotifications(FetchNotificationManager fetchNotificationManager) {
        Intrinsics.checkParameterIsNotNull(fetchNotificationManager, "fetchNotificationManager");
        synchronized (this.lock) {
            this.fetchNotificationHandler.post(new ListenerCoordinator$cancelOnGoingNotifications$$inlined$synchronized$lambda$1(this, fetchNotificationManager));
        }
    }

    public final FetchListener getMainListener() {
        return this.mainListener;
    }

    public final void clearAll() {
        synchronized (this.lock) {
            this.fetchListenerMap.clear();
            this.fetchGroupListenerMap.clear();
            this.fetchNotificationManagerList.clear();
            this.downloadsObserverMap.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr) {
        Intrinsics.checkParameterIsNotNull(fetchObserverArr, "fetchObservers");
        synchronized (this.lock) {
            List<FetchObserver> distinct = ArraysKt.distinct((T[]) fetchObserverArr);
            List<WeakReference> list = this.downloadsObserverMap.get(Integer.valueOf(i));
            if (list == null) {
                list = new ArrayList<>();
            }
            Collection arrayList = new ArrayList();
            for (WeakReference weakReference : list) {
                FetchObserver fetchObserver = (FetchObserver) weakReference.get();
                if (fetchObserver != null) {
                    arrayList.add(fetchObserver);
                }
            }
            List list2 = (List) arrayList;
            List arrayList2 = new ArrayList();
            for (FetchObserver fetchObserver2 : distinct) {
                if (!list2.contains(fetchObserver2)) {
                    list.add(new WeakReference(fetchObserver2));
                    arrayList2.add(fetchObserver2);
                }
            }
            Download download = this.downloadProvider.getDownload(i);
            if (download != null) {
                this.uiHandler.post(new ListenerCoordinator$addFetchObserversForDownload$1$1(arrayList2, download));
            }
            this.downloadsObserverMap.put(Integer.valueOf(i), list);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr) {
        Intrinsics.checkParameterIsNotNull(fetchObserverArr, "fetchObservers");
        synchronized (this.lock) {
            for (FetchObserver<Download> fetchObserver : fetchObserverArr) {
                List list = this.downloadsObserverMap.get(Integer.valueOf(i));
                Iterator it2 = list != null ? list.iterator() : null;
                if (it2 != null) {
                    while (true) {
                        if (it2.hasNext()) {
                            if (Intrinsics.areEqual((Object) (FetchObserver) ((WeakReference) it2.next()).get(), (Object) fetchObserver)) {
                                it2.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
