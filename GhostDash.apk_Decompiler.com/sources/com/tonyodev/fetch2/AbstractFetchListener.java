package com.tonyodev.fetch2;

import com.brentvatne.react.ReactVideoView;
import com.tonyodev.fetch2core.DownloadBlock;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0 2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\""}, d2 = {"Lcom/tonyodev/fetch2/AbstractFetchListener;", "Lcom/tonyodev/fetch2/FetchListener;", "()V", "onAdded", "", "download", "Lcom/tonyodev/fetch2/Download;", "onCancelled", "onCompleted", "onDeleted", "onDownloadBlockUpdated", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlock;", "totalBlocks", "", "onError", "error", "Lcom/tonyodev/fetch2/Error;", "throwable", "", "onPaused", "onProgress", "etaInMilliSeconds", "", "downloadedBytesPerSecond", "onQueued", "waitingOnNetwork", "", "onRemoved", "onResumed", "onStarted", "downloadBlocks", "", "onWaitingNetwork", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractFetchListener.kt */
public abstract class AbstractFetchListener implements FetchListener {
    public void onAdded(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onCancelled(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onCompleted(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onDeleted(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(downloadBlock, "downloadBlock");
    }

    public void onError(Download download, Error error, Throwable th) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(error, ReactVideoView.EVENT_PROP_ERROR);
    }

    public void onPaused(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onProgress(Download download, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onQueued(Download download, boolean z) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onRemoved(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onResumed(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onStarted(Download download, List<? extends DownloadBlock> list, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(list, "downloadBlocks");
    }

    public void onWaitingNetwork(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }
}
