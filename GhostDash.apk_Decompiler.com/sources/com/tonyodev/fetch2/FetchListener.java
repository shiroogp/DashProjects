package com.tonyodev.fetch2;

import com.tonyodev.fetch2core.DownloadBlock;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006!"}, d2 = {"Lcom/tonyodev/fetch2/FetchListener;", "", "onAdded", "", "download", "Lcom/tonyodev/fetch2/Download;", "onCancelled", "onCompleted", "onDeleted", "onDownloadBlockUpdated", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlock;", "totalBlocks", "", "onError", "error", "Lcom/tonyodev/fetch2/Error;", "throwable", "", "onPaused", "onProgress", "etaInMilliSeconds", "", "downloadedBytesPerSecond", "onQueued", "waitingOnNetwork", "", "onRemoved", "onResumed", "onStarted", "downloadBlocks", "", "onWaitingNetwork", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchListener.kt */
public interface FetchListener {
    void onAdded(Download download);

    void onCancelled(Download download);

    void onCompleted(Download download);

    void onDeleted(Download download);

    void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i);

    void onError(Download download, Error error, Throwable th);

    void onPaused(Download download);

    void onProgress(Download download, long j, long j2);

    void onQueued(Download download, boolean z);

    void onRemoved(Download download);

    void onResumed(Download download);

    void onStarted(Download download, List<? extends DownloadBlock> list, int i);

    void onWaitingNetwork(Download download);
}
