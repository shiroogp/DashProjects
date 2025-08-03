package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2core.DownloadBlock;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0001\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0005\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/tonyodev/fetch2/downloader/FileDownloader;", "Ljava/lang/Runnable;", "completedDownload", "", "getCompletedDownload", "()Z", "delegate", "Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "getDelegate", "()Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "setDelegate", "(Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;)V", "download", "Lcom/tonyodev/fetch2/Download;", "getDownload", "()Lcom/tonyodev/fetch2/Download;", "interrupted", "getInterrupted", "setInterrupted", "(Z)V", "terminated", "getTerminated", "setTerminated", "Delegate", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileDownloader.kt */
public interface FileDownloader extends Runnable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J \u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H&J&\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "", "interrupted", "", "getInterrupted", "()Z", "getNewDownloadInfoInstance", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "onComplete", "", "download", "Lcom/tonyodev/fetch2/Download;", "onDownloadBlockUpdated", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlock;", "totalBlocks", "", "onError", "error", "Lcom/tonyodev/fetch2/Error;", "throwable", "", "onProgress", "etaInMilliSeconds", "", "downloadedBytesPerSecond", "onStarted", "downloadBlocks", "", "saveDownloadProgress", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FileDownloader.kt */
    public interface Delegate {
        boolean getInterrupted();

        DownloadInfo getNewDownloadInfoInstance();

        void onComplete(Download download);

        void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i);

        void onError(Download download, Error error, Throwable th);

        void onProgress(Download download, long j, long j2);

        void onStarted(Download download, List<? extends DownloadBlock> list, int i);

        void saveDownloadProgress(Download download);
    }

    boolean getCompletedDownload();

    Delegate getDelegate();

    Download getDownload();

    boolean getInterrupted();

    boolean getTerminated();

    void setDelegate(Delegate delegate);

    void setInterrupted(boolean z);

    void setTerminated(boolean z);
}
