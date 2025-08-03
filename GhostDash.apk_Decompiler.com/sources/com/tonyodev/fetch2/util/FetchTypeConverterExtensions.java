package com.tonyodev.fetch2.util;

import com.tonyodev.fetch2.CompletedDownload;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2core.FetchCoreUtils;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"toDownloadInfo", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "Lcom/tonyodev/fetch2/CompletedDownload;", "downloadInfo", "Lcom/tonyodev/fetch2/Download;", "Lcom/tonyodev/fetch2/Request;", "fetch2_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: TypeConverterExtensions.kt */
public final class FetchTypeConverterExtensions {
    public static final DownloadInfo toDownloadInfo(Request request, DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(request, "$this$toDownloadInfo");
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        downloadInfo.setId(request.getId());
        downloadInfo.setUrl(request.getUrl());
        downloadInfo.setFile(request.getFile());
        downloadInfo.setPriority(request.getPriority());
        downloadInfo.setHeaders(MapsKt.toMap(request.getHeaders()));
        downloadInfo.setGroup(request.getGroupId());
        downloadInfo.setNetworkType(request.getNetworkType());
        downloadInfo.setStatus(FetchDefaults.getDefaultStatus());
        downloadInfo.setError(FetchDefaults.getDefaultNoError());
        downloadInfo.setDownloaded(0);
        downloadInfo.setTag(request.getTag());
        downloadInfo.setEnqueueAction(request.getEnqueueAction());
        downloadInfo.setIdentifier(request.getIdentifier());
        downloadInfo.setDownloadOnEnqueue(request.getDownloadOnEnqueue());
        downloadInfo.setExtras(request.getExtras());
        downloadInfo.setAutoRetryMaxAttempts(request.getAutoRetryMaxAttempts());
        downloadInfo.setAutoRetryAttempts(0);
        return downloadInfo;
    }

    public static final DownloadInfo toDownloadInfo(Download download, DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(download, "$this$toDownloadInfo");
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        downloadInfo.setId(download.getId());
        downloadInfo.setNamespace(download.getNamespace());
        downloadInfo.setUrl(download.getUrl());
        downloadInfo.setFile(download.getFile());
        downloadInfo.setGroup(download.getGroup());
        downloadInfo.setPriority(download.getPriority());
        downloadInfo.setHeaders(MapsKt.toMap(download.getHeaders()));
        downloadInfo.setDownloaded(download.getDownloaded());
        downloadInfo.setTotal(download.getTotal());
        downloadInfo.setStatus(download.getStatus());
        downloadInfo.setNetworkType(download.getNetworkType());
        downloadInfo.setError(download.getError());
        downloadInfo.setCreated(download.getCreated());
        downloadInfo.setTag(download.getTag());
        downloadInfo.setEnqueueAction(download.getEnqueueAction());
        downloadInfo.setIdentifier(download.getIdentifier());
        downloadInfo.setDownloadOnEnqueue(download.getDownloadOnEnqueue());
        downloadInfo.setExtras(download.getExtras());
        downloadInfo.setAutoRetryMaxAttempts(download.getAutoRetryMaxAttempts());
        downloadInfo.setAutoRetryAttempts(download.getAutoRetryAttempts());
        return downloadInfo;
    }

    public static final DownloadInfo toDownloadInfo(CompletedDownload completedDownload, DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(completedDownload, "$this$toDownloadInfo");
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        downloadInfo.setId(FetchCoreUtils.getUniqueId(completedDownload.getUrl(), completedDownload.getFile()));
        downloadInfo.setUrl(completedDownload.getUrl());
        downloadInfo.setFile(completedDownload.getFile());
        downloadInfo.setGroup(completedDownload.getGroup());
        downloadInfo.setPriority(Priority.NORMAL);
        downloadInfo.setHeaders(MapsKt.toMap(completedDownload.getHeaders()));
        downloadInfo.setDownloaded(completedDownload.getFileByteSize());
        downloadInfo.setTotal(completedDownload.getFileByteSize());
        downloadInfo.setStatus(Status.COMPLETED);
        downloadInfo.setNetworkType(NetworkType.ALL);
        downloadInfo.setError(Error.NONE);
        downloadInfo.setCreated(completedDownload.getCreated());
        downloadInfo.setTag(completedDownload.getTag());
        downloadInfo.setEnqueueAction(EnqueueAction.REPLACE_EXISTING);
        downloadInfo.setIdentifier(completedDownload.getIdentifier());
        downloadInfo.setDownloadOnEnqueue(true);
        downloadInfo.setExtras(completedDownload.getExtras());
        downloadInfo.setAutoRetryMaxAttempts(0);
        downloadInfo.setAutoRetryAttempts(0);
        return downloadInfo;
    }
}
