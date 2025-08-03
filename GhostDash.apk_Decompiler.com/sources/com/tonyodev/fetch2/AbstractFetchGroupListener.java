package com.tonyodev.fetch2;

import com.brentvatne.react.ReactVideoView;
import com.tonyodev.fetch2core.DownloadBlock;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J2\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J0\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J(\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100$2\u0006\u0010\u0011\u001a\u00020\bH\u0016J6\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100$2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006&"}, d2 = {"Lcom/tonyodev/fetch2/AbstractFetchGroupListener;", "Lcom/tonyodev/fetch2/FetchGroupListener;", "()V", "onAdded", "", "download", "Lcom/tonyodev/fetch2/Download;", "groupId", "", "fetchGroup", "Lcom/tonyodev/fetch2/FetchGroup;", "onCancelled", "onCompleted", "onDeleted", "onDownloadBlockUpdated", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlock;", "totalBlocks", "onError", "error", "Lcom/tonyodev/fetch2/Error;", "throwable", "", "onPaused", "onProgress", "etaInMilliSeconds", "", "downloadedBytesPerSecond", "onQueued", "waitingOnNetwork", "", "waitingNetwork", "onRemoved", "onResumed", "onStarted", "downloadBlocks", "", "onWaitingNetwork", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractFetchGroupListener.kt */
public abstract class AbstractFetchGroupListener implements FetchGroupListener {
    public void onAdded(int i, Download download, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onAdded(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onCancelled(int i, Download download, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onCancelled(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onCompleted(int i, Download download, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onCompleted(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onDeleted(int i, Download download, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onDeleted(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onDownloadBlockUpdated(int i, Download download, DownloadBlock downloadBlock, int i2, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(downloadBlock, "downloadBlock");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(downloadBlock, "downloadBlock");
    }

    public void onError(int i, Download download, Error error, Throwable th, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(error, ReactVideoView.EVENT_PROP_ERROR);
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onError(Download download, Error error, Throwable th) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(error, ReactVideoView.EVENT_PROP_ERROR);
    }

    public void onPaused(int i, Download download, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onPaused(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onProgress(int i, Download download, long j, long j2, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onProgress(Download download, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onQueued(int i, Download download, boolean z, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onQueued(Download download, boolean z) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onRemoved(int i, Download download, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onRemoved(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onResumed(int i, Download download, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onResumed(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }

    public void onStarted(int i, Download download, List<? extends DownloadBlock> list, int i2, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(list, "downloadBlocks");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onStarted(Download download, List<? extends DownloadBlock> list, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(list, "downloadBlocks");
    }

    public void onWaitingNetwork(int i, Download download, FetchGroup fetchGroup) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(fetchGroup, "fetchGroup");
    }

    public void onWaitingNetwork(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
    }
}
