package com.tonyodev.fetch2.util;

import com.tonyodev.fetch2core.FetchObserver;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/tonyodev/fetch2/util/ActiveDownloadInfo;", "", "fetchObserver", "Lcom/tonyodev/fetch2core/FetchObserver;", "", "includeAddedDownloads", "(Lcom/tonyodev/fetch2core/FetchObserver;Z)V", "getFetchObserver", "()Lcom/tonyodev/fetch2core/FetchObserver;", "getIncludeAddedDownloads", "()Z", "equals", "other", "hashCode", "", "toString", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ActiveDownloadInfo.kt */
public final class ActiveDownloadInfo {
    private final FetchObserver<Boolean> fetchObserver;
    private final boolean includeAddedDownloads;

    public ActiveDownloadInfo(FetchObserver<Boolean> fetchObserver2, boolean z) {
        Intrinsics.checkParameterIsNotNull(fetchObserver2, "fetchObserver");
        this.fetchObserver = fetchObserver2;
        this.includeAddedDownloads = z;
    }

    public final FetchObserver<Boolean> getFetchObserver() {
        return this.fetchObserver;
    }

    public final boolean getIncludeAddedDownloads() {
        return this.includeAddedDownloads;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2.util.ActiveDownloadInfo");
        } else if (!Intrinsics.areEqual((Object) this.fetchObserver, (Object) ((ActiveDownloadInfo) obj).fetchObserver)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return this.fetchObserver.hashCode();
    }

    public String toString() {
        return "ActiveDownloadInfo(fetchObserver=" + this.fetchObserver + ", includeAddedDownloads=" + this.includeAddedDownloads + ')';
    }
}
