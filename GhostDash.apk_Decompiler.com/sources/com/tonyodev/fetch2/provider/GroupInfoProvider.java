package com.tonyodev.fetch2.provider;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.FetchGroup;
import com.tonyodev.fetch2.model.FetchGroupInfo;
import com.tonyodev.fetch2core.Reason;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tonyodev/fetch2/provider/GroupInfoProvider;", "", "namespace", "", "downloadProvider", "Lcom/tonyodev/fetch2/provider/DownloadProvider;", "(Ljava/lang/String;Lcom/tonyodev/fetch2/provider/DownloadProvider;)V", "groupInfoMap", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/tonyodev/fetch2/model/FetchGroupInfo;", "lock", "clean", "", "clear", "getGroupInfo", "id", "reason", "Lcom/tonyodev/fetch2core/Reason;", "getGroupReplace", "Lcom/tonyodev/fetch2/FetchGroup;", "download", "Lcom/tonyodev/fetch2/Download;", "postGroupReplace", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GroupInfoProvider.kt */
public final class GroupInfoProvider {
    private final DownloadProvider downloadProvider;
    private final Map<Integer, WeakReference<FetchGroupInfo>> groupInfoMap = new LinkedHashMap();
    private final Object lock = new Object();
    private final String namespace;

    public GroupInfoProvider(String str, DownloadProvider downloadProvider2) {
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        Intrinsics.checkParameterIsNotNull(downloadProvider2, "downloadProvider");
        this.namespace = str;
        this.downloadProvider = downloadProvider2;
    }

    public final FetchGroupInfo getGroupInfo(int i, Reason reason) {
        FetchGroupInfo fetchGroupInfo;
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        synchronized (this.lock) {
            WeakReference weakReference = this.groupInfoMap.get(Integer.valueOf(i));
            fetchGroupInfo = weakReference != null ? (FetchGroupInfo) weakReference.get() : null;
            if (fetchGroupInfo == null) {
                fetchGroupInfo = new FetchGroupInfo(i, this.namespace);
                fetchGroupInfo.update(this.downloadProvider.getByGroup(i), (Download) null, reason);
                this.groupInfoMap.put(Integer.valueOf(i), new WeakReference(fetchGroupInfo));
            }
        }
        return fetchGroupInfo;
    }

    public final FetchGroup getGroupReplace(int i, Download download, Reason reason) {
        FetchGroupInfo groupInfo;
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        synchronized (this.lock) {
            groupInfo = getGroupInfo(i, reason);
            groupInfo.update(this.downloadProvider.getByGroupReplace(i, download), download, reason);
        }
        return groupInfo;
    }

    public final void postGroupReplace(int i, Download download, Reason reason) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        synchronized (this.lock) {
            WeakReference weakReference = this.groupInfoMap.get(Integer.valueOf(i));
            FetchGroupInfo fetchGroupInfo = weakReference != null ? (FetchGroupInfo) weakReference.get() : null;
            if (fetchGroupInfo != null) {
                fetchGroupInfo.update(this.downloadProvider.getByGroupReplace(i, download), download, reason);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void clean() {
        synchronized (this.lock) {
            Iterator<Map.Entry<Integer, WeakReference<FetchGroupInfo>>> it2 = this.groupInfoMap.entrySet().iterator();
            while (it2.hasNext()) {
                if (((WeakReference) it2.next().getValue()).get() == null) {
                    it2.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.lock) {
            this.groupInfoMap.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
