package com.tonyodev.fetch2.model;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.FetchGroup;
import com.tonyodev.fetch2.FetchGroupObserver;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.fetch.FetchModulesBuilder;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.Reason;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u00108\u001a\u0002092\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0;\"\u00020)H\u0016¢\u0006\u0002\u0010<J!\u0010=\u001a\u0002092\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0;\"\u00020)H\u0016¢\u0006\u0002\u0010<J&\u0010>\u001a\u0002092\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010?\u001a\u0004\u0018\u00010\t2\u0006\u0010@\u001a\u00020AR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR\u0014\u0010!\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0004¢\u0006\u0002\n\u0000R&\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0,0+8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R \u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\rR \u00102\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR \u00105\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000b\"\u0004\b7\u0010\r¨\u0006B"}, d2 = {"Lcom/tonyodev/fetch2/model/FetchGroupInfo;", "Lcom/tonyodev/fetch2/FetchGroup;", "id", "", "namespace", "", "(ILjava/lang/String;)V", "addedDownloads", "", "Lcom/tonyodev/fetch2/Download;", "getAddedDownloads", "()Ljava/util/List;", "setAddedDownloads", "(Ljava/util/List;)V", "cancelledDownloads", "getCancelledDownloads", "setCancelledDownloads", "completedDownloads", "getCompletedDownloads", "setCompletedDownloads", "deletedDownloads", "getDeletedDownloads", "setDeletedDownloads", "downloadingDownloads", "getDownloadingDownloads", "setDownloadingDownloads", "value", "downloads", "getDownloads", "setDownloads", "failedDownloads", "getFailedDownloads", "setFailedDownloads", "groupDownloadProgress", "getGroupDownloadProgress", "()I", "getId", "getNamespace", "()Ljava/lang/String;", "observerSet", "", "Lcom/tonyodev/fetch2/FetchGroupObserver;", "observers", "", "Lcom/tonyodev/fetch2core/FetchObserver;", "getObservers", "()Ljava/util/Set;", "pausedDownloads", "getPausedDownloads", "setPausedDownloads", "queuedDownloads", "getQueuedDownloads", "setQueuedDownloads", "removedDownloads", "getRemovedDownloads", "setRemovedDownloads", "addFetchGroupObservers", "", "fetchGroupObservers", "", "([Lcom/tonyodev/fetch2/FetchGroupObserver;)V", "removeFetchGroupObservers", "update", "triggerDownload", "reason", "Lcom/tonyodev/fetch2core/Reason;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchGroupInfo.kt */
public final class FetchGroupInfo implements FetchGroup {
    private List<? extends Download> addedDownloads;
    private List<? extends Download> cancelledDownloads;
    private List<? extends Download> completedDownloads;
    private List<? extends Download> deletedDownloads;
    private List<? extends Download> downloadingDownloads;
    private volatile List<? extends Download> downloads;
    private List<? extends Download> failedDownloads;
    private final int id;
    private final String namespace;
    /* access modifiers changed from: private */
    public final Set<FetchGroupObserver> observerSet;
    private List<? extends Download> pausedDownloads;
    private List<? extends Download> queuedDownloads;
    private List<? extends Download> removedDownloads;

    public FetchGroupInfo(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        this.id = i;
        this.namespace = str;
        this.observerSet = new LinkedHashSet();
        this.downloads = CollectionsKt.emptyList();
        this.queuedDownloads = CollectionsKt.emptyList();
        this.addedDownloads = CollectionsKt.emptyList();
        this.pausedDownloads = CollectionsKt.emptyList();
        this.downloadingDownloads = CollectionsKt.emptyList();
        this.completedDownloads = CollectionsKt.emptyList();
        this.cancelledDownloads = CollectionsKt.emptyList();
        this.failedDownloads = CollectionsKt.emptyList();
        this.deletedDownloads = CollectionsKt.emptyList();
        this.removedDownloads = CollectionsKt.emptyList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FetchGroupInfo(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str);
    }

    public int getId() {
        return this.id;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public List<Download> getDownloads() {
        return this.downloads;
    }

    public void setDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.downloads = list;
        Iterable iterable = list;
        Collection arrayList = new ArrayList();
        Iterator it2 = iterable.iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Download) next).getStatus() != Status.QUEUED) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        setQueuedDownloads((List) arrayList);
        Collection arrayList2 = new ArrayList();
        for (Object next2 : iterable) {
            if (((Download) next2).getStatus() == Status.ADDED) {
                arrayList2.add(next2);
            }
        }
        setAddedDownloads((List) arrayList2);
        Collection arrayList3 = new ArrayList();
        for (Object next3 : iterable) {
            if (((Download) next3).getStatus() == Status.PAUSED) {
                arrayList3.add(next3);
            }
        }
        setPausedDownloads((List) arrayList3);
        Collection arrayList4 = new ArrayList();
        for (Object next4 : iterable) {
            if (((Download) next4).getStatus() == Status.DOWNLOADING) {
                arrayList4.add(next4);
            }
        }
        setDownloadingDownloads((List) arrayList4);
        Collection arrayList5 = new ArrayList();
        for (Object next5 : iterable) {
            if (((Download) next5).getStatus() == Status.COMPLETED) {
                arrayList5.add(next5);
            }
        }
        setCompletedDownloads((List) arrayList5);
        Collection arrayList6 = new ArrayList();
        for (Object next6 : iterable) {
            if (((Download) next6).getStatus() == Status.CANCELLED) {
                arrayList6.add(next6);
            }
        }
        setCancelledDownloads((List) arrayList6);
        Collection arrayList7 = new ArrayList();
        for (Object next7 : iterable) {
            if (((Download) next7).getStatus() == Status.FAILED) {
                arrayList7.add(next7);
            }
        }
        setFailedDownloads((List) arrayList7);
        Collection arrayList8 = new ArrayList();
        for (Object next8 : iterable) {
            if (((Download) next8).getStatus() == Status.DELETED) {
                arrayList8.add(next8);
            }
        }
        setDeletedDownloads((List) arrayList8);
        Collection arrayList9 = new ArrayList();
        for (Object next9 : iterable) {
            if (((Download) next9).getStatus() == Status.REMOVED) {
                arrayList9.add(next9);
            }
        }
        setRemovedDownloads((List) arrayList9);
    }

    public final void update(List<? extends Download> list, Download download, Reason reason) {
        Intrinsics.checkParameterIsNotNull(list, "downloads");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        setDownloads(list);
        if (reason != Reason.DOWNLOAD_BLOCK_UPDATED) {
            FetchModulesBuilder.INSTANCE.getMainUIHandler().post(new FetchGroupInfo$update$1(this, list, reason, download));
        }
    }

    public List<Download> getQueuedDownloads() {
        return this.queuedDownloads;
    }

    public void setQueuedDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.queuedDownloads = list;
    }

    public List<Download> getAddedDownloads() {
        return this.addedDownloads;
    }

    public void setAddedDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.addedDownloads = list;
    }

    public List<Download> getPausedDownloads() {
        return this.pausedDownloads;
    }

    public void setPausedDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.pausedDownloads = list;
    }

    public List<Download> getDownloadingDownloads() {
        return this.downloadingDownloads;
    }

    public void setDownloadingDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.downloadingDownloads = list;
    }

    public List<Download> getCompletedDownloads() {
        return this.completedDownloads;
    }

    public void setCompletedDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.completedDownloads = list;
    }

    public List<Download> getCancelledDownloads() {
        return this.cancelledDownloads;
    }

    public void setCancelledDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.cancelledDownloads = list;
    }

    public List<Download> getFailedDownloads() {
        return this.failedDownloads;
    }

    public void setFailedDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.failedDownloads = list;
    }

    public List<Download> getDeletedDownloads() {
        return this.deletedDownloads;
    }

    public void setDeletedDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.deletedDownloads = list;
    }

    public List<Download> getRemovedDownloads() {
        return this.removedDownloads;
    }

    public void setRemovedDownloads(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.removedDownloads = list;
    }

    public int getGroupDownloadProgress() {
        boolean z;
        Iterable downloads2 = getDownloads();
        boolean z2 = true;
        if (!(downloads2 instanceof Collection) || !((Collection) downloads2).isEmpty()) {
            Iterator it2 = downloads2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((Download) it2.next()).getTotal() < 1) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            return -1;
        }
        long j = 0;
        long j2 = 0;
        for (Download next : getDownloads()) {
            j += next.getDownloaded();
            j2 += next.getTotal();
        }
        return FetchCoreUtils.calculateProgress(j, j2);
    }

    public Set<FetchObserver<List<Download>>> getObservers() {
        Set<FetchObserver<List<Download>>> mutableSet;
        synchronized (this.observerSet) {
            mutableSet = CollectionsKt.toMutableSet(this.observerSet);
        }
        return mutableSet;
    }

    public void addFetchGroupObservers(FetchGroupObserver... fetchGroupObserverArr) {
        Intrinsics.checkParameterIsNotNull(fetchGroupObserverArr, "fetchGroupObservers");
        synchronized (this.observerSet) {
            List<FetchGroupObserver> distinct = ArraysKt.distinct((T[]) fetchGroupObserverArr);
            List arrayList = new ArrayList();
            for (FetchGroupObserver fetchGroupObserver : distinct) {
                if (!this.observerSet.contains(fetchGroupObserver)) {
                    this.observerSet.add(fetchGroupObserver);
                    arrayList.add(fetchGroupObserver);
                }
            }
            FetchModulesBuilder.INSTANCE.getMainUIHandler().post(new FetchGroupInfo$addFetchGroupObservers$$inlined$synchronized$lambda$1(arrayList, this, fetchGroupObserverArr));
        }
    }

    public void removeFetchGroupObservers(FetchGroupObserver... fetchGroupObserverArr) {
        Intrinsics.checkParameterIsNotNull(fetchGroupObserverArr, "fetchGroupObservers");
        synchronized (this.observerSet) {
            for (FetchGroupObserver remove : fetchGroupObserverArr) {
                this.observerSet.remove(remove);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
