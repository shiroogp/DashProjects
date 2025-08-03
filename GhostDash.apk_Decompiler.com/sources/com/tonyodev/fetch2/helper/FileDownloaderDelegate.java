package com.tonyodev.fetch2.helper;

import com.brentvatne.react.ReactVideoView;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.downloader.FileDownloader;
import com.tonyodev.fetch2.util.FetchDefaults;
import com.tonyodev.fetch2core.DownloadBlock;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016J\"\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J&\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180%2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/tonyodev/fetch2/helper/FileDownloaderDelegate;", "Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "downloadInfoUpdater", "Lcom/tonyodev/fetch2/helper/DownloadInfoUpdater;", "fetchListener", "Lcom/tonyodev/fetch2/FetchListener;", "retryOnNetworkGain", "", "globalAutoRetryMaxAttempts", "", "(Lcom/tonyodev/fetch2/helper/DownloadInfoUpdater;Lcom/tonyodev/fetch2/FetchListener;ZI)V", "interrupted", "getInterrupted", "()Z", "setInterrupted", "(Z)V", "getNewDownloadInfoInstance", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "onComplete", "", "download", "Lcom/tonyodev/fetch2/Download;", "onDownloadBlockUpdated", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlock;", "totalBlocks", "onError", "error", "Lcom/tonyodev/fetch2/Error;", "throwable", "", "onProgress", "etaInMilliSeconds", "", "downloadedBytesPerSecond", "onStarted", "downloadBlocks", "", "saveDownloadProgress", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileDownloaderDelegate.kt */
public final class FileDownloaderDelegate implements FileDownloader.Delegate {
    private final DownloadInfoUpdater downloadInfoUpdater;
    private final FetchListener fetchListener;
    private final int globalAutoRetryMaxAttempts;
    private volatile boolean interrupted;
    private final boolean retryOnNetworkGain;

    public FileDownloaderDelegate(DownloadInfoUpdater downloadInfoUpdater2, FetchListener fetchListener2, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(downloadInfoUpdater2, "downloadInfoUpdater");
        Intrinsics.checkParameterIsNotNull(fetchListener2, "fetchListener");
        this.downloadInfoUpdater = downloadInfoUpdater2;
        this.fetchListener = fetchListener2;
        this.retryOnNetworkGain = z;
        this.globalAutoRetryMaxAttempts = i;
    }

    public boolean getInterrupted() {
        return this.interrupted;
    }

    public void setInterrupted(boolean z) {
        this.interrupted = z;
    }

    public void onStarted(Download download, List<? extends DownloadBlock> list, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(list, "downloadBlocks");
        if (!getInterrupted()) {
            DownloadInfo downloadInfo = (DownloadInfo) download;
            downloadInfo.setStatus(Status.DOWNLOADING);
            this.downloadInfoUpdater.update(downloadInfo);
            this.fetchListener.onStarted(download, list, i);
        }
    }

    public void onProgress(Download download, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        if (!getInterrupted()) {
            this.fetchListener.onProgress(download, j, j2);
        }
    }

    public void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(downloadBlock, "downloadBlock");
        if (!getInterrupted()) {
            this.fetchListener.onDownloadBlockUpdated(download, downloadBlock, i);
        }
    }

    public void onError(Download download, Error error, Throwable th) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(error, ReactVideoView.EVENT_PROP_ERROR);
        if (!getInterrupted()) {
            int i = this.globalAutoRetryMaxAttempts;
            if (i == -1) {
                i = download.getAutoRetryMaxAttempts();
            }
            DownloadInfo downloadInfo = (DownloadInfo) download;
            if (this.retryOnNetworkGain && downloadInfo.getError() == Error.NO_NETWORK_CONNECTION) {
                downloadInfo.setStatus(Status.QUEUED);
                downloadInfo.setError(FetchDefaults.getDefaultNoError());
                this.downloadInfoUpdater.update(downloadInfo);
                this.fetchListener.onQueued(download, true);
            } else if (downloadInfo.getAutoRetryAttempts() < i) {
                downloadInfo.setAutoRetryAttempts(downloadInfo.getAutoRetryAttempts() + 1);
                downloadInfo.setStatus(Status.QUEUED);
                downloadInfo.setError(FetchDefaults.getDefaultNoError());
                this.downloadInfoUpdater.update(downloadInfo);
                this.fetchListener.onQueued(download, true);
            } else {
                downloadInfo.setStatus(Status.FAILED);
                this.downloadInfoUpdater.update(downloadInfo);
                this.fetchListener.onError(download, error, th);
            }
        }
    }

    public void onComplete(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        if (!getInterrupted()) {
            DownloadInfo downloadInfo = (DownloadInfo) download;
            downloadInfo.setStatus(Status.COMPLETED);
            this.downloadInfoUpdater.update(downloadInfo);
            this.fetchListener.onCompleted(download);
        }
    }

    public void saveDownloadProgress(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        if (!getInterrupted()) {
            DownloadInfo downloadInfo = (DownloadInfo) download;
            downloadInfo.setStatus(Status.DOWNLOADING);
            this.downloadInfoUpdater.updateFileBytesInfoAndStatusOnly(downloadInfo);
        }
    }

    public DownloadInfo getNewDownloadInfoInstance() {
        return this.downloadInfoUpdater.getNewDownloadInfoInstance();
    }
}
