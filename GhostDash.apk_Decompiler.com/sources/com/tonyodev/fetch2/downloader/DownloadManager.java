package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.downloader.FileDownloader;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H&J\b\u0010\u0019\u001a\u00020\u001aH&J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u0014H&J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0014H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/tonyodev/fetch2/downloader/DownloadManager;", "Ljava/io/Closeable;", "concurrentLimit", "", "getConcurrentLimit", "()I", "setConcurrentLimit", "(I)V", "isClosed", "", "()Z", "canAccommodateNewDownload", "cancel", "downloadId", "cancelAll", "", "contains", "getActiveDownloadCount", "getActiveDownloads", "", "Lcom/tonyodev/fetch2/Download;", "getActiveDownloadsIds", "getDownloadFileTempDir", "", "download", "getFileDownloaderDelegate", "Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "getNewFileDownloaderForDownload", "Lcom/tonyodev/fetch2/downloader/FileDownloader;", "start", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadManager.kt */
public interface DownloadManager extends Closeable {
    boolean canAccommodateNewDownload();

    boolean cancel(int i);

    void cancelAll();

    boolean contains(int i);

    int getActiveDownloadCount();

    List<Download> getActiveDownloads();

    List<Integer> getActiveDownloadsIds();

    int getConcurrentLimit();

    String getDownloadFileTempDir(Download download);

    FileDownloader.Delegate getFileDownloaderDelegate();

    FileDownloader getNewFileDownloaderForDownload(Download download);

    boolean isClosed();

    void setConcurrentLimit(int i);

    boolean start(Download download);
}
