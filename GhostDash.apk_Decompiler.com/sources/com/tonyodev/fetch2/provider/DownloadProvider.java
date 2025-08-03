package com.tonyodev.fetch2.provider;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.FetchDatabaseManagerWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\tJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tonyodev/fetch2/provider/DownloadProvider;", "", "fetchDatabaseManagerWrapper", "Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "(Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;)V", "getByGroup", "", "Lcom/tonyodev/fetch2/Download;", "group", "", "getByGroupReplace", "download", "getByStatus", "status", "Lcom/tonyodev/fetch2/Status;", "getDownload", "id", "getDownloads", "ids", "getPendingDownloadsSorted", "prioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadProvider.kt */
public final class DownloadProvider {
    private final FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper;

    public DownloadProvider(FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2) {
        Intrinsics.checkParameterIsNotNull(fetchDatabaseManagerWrapper2, "fetchDatabaseManagerWrapper");
        this.fetchDatabaseManagerWrapper = fetchDatabaseManagerWrapper2;
    }

    public final List<Download> getDownloads() {
        return this.fetchDatabaseManagerWrapper.get();
    }

    public final Download getDownload(int i) {
        return this.fetchDatabaseManagerWrapper.get(i);
    }

    public final List<Download> getDownloads(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return this.fetchDatabaseManagerWrapper.get(list);
    }

    public final List<Download> getByGroup(int i) {
        return this.fetchDatabaseManagerWrapper.getByGroup(i);
    }

    public final List<Download> getByGroupReplace(int i, Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        List<Download> byGroup = getByGroup(i);
        if (byGroup != null) {
            ArrayList arrayList = (ArrayList) byGroup;
            List<Download> list = arrayList;
            Iterator<Download> it2 = list.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it2.next().getId() == download.getId()) {
                    break;
                }
                i2++;
            }
            if (i2 != -1) {
                arrayList.set(i2, download);
            }
            return list;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<com.tonyodev.fetch2.Download>");
    }

    public final List<Download> getByStatus(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return this.fetchDatabaseManagerWrapper.getByStatus(status);
    }

    public final List<Download> getPendingDownloadsSorted(PrioritySort prioritySort) {
        Intrinsics.checkParameterIsNotNull(prioritySort, "prioritySort");
        return this.fetchDatabaseManagerWrapper.getPendingDownloadsSorted(prioritySort);
    }
}
