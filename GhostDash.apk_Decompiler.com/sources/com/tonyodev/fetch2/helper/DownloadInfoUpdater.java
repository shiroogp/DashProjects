package com.tonyodev.fetch2.helper;

import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.database.FetchDatabaseManagerWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tonyodev/fetch2/helper/DownloadInfoUpdater;", "", "fetchDatabaseManagerWrapper", "Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "(Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;)V", "getNewDownloadInfoInstance", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "update", "", "downloadInfo", "updateFileBytesInfoAndStatusOnly", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadInfoUpdater.kt */
public final class DownloadInfoUpdater {
    private final FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper;

    public DownloadInfoUpdater(FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2) {
        Intrinsics.checkParameterIsNotNull(fetchDatabaseManagerWrapper2, "fetchDatabaseManagerWrapper");
        this.fetchDatabaseManagerWrapper = fetchDatabaseManagerWrapper2;
    }

    public final void updateFileBytesInfoAndStatusOnly(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        this.fetchDatabaseManagerWrapper.updateFileBytesInfoAndStatusOnly(downloadInfo);
    }

    public final void update(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        this.fetchDatabaseManagerWrapper.update(downloadInfo);
    }

    public final DownloadInfo getNewDownloadInfoInstance() {
        return this.fetchDatabaseManagerWrapper.getNewDownloadInfoInstance();
    }
}
