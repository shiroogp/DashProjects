package com.tonyodev.fetch2.downloader;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/tonyodev/fetch2/downloader/DownloadManagerCoordinator;", "", "namespace", "", "(Ljava/lang/String;)V", "fileDownloaderMap", "", "", "Lcom/tonyodev/fetch2/downloader/FileDownloader;", "lock", "getNamespace", "()Ljava/lang/String;", "addFileDownloader", "", "downloadId", "fileDownloader", "clearAll", "containsFileDownloader", "", "getFileDownloaderList", "", "interruptDownload", "removeFileDownloader", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadManagerCoordinator.kt */
public final class DownloadManagerCoordinator {
    private final Map<Integer, FileDownloader> fileDownloaderMap = new LinkedHashMap();
    private final Object lock = new Object();
    private final String namespace;

    public DownloadManagerCoordinator(String str) {
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        this.namespace = str;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final void interruptDownload(int i) {
        synchronized (this.lock) {
            FileDownloader fileDownloader = this.fileDownloaderMap.get(Integer.valueOf(i));
            if (fileDownloader != null) {
                fileDownloader.setInterrupted(true);
                this.fileDownloaderMap.remove(Integer.valueOf(i));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addFileDownloader(int i, FileDownloader fileDownloader) {
        synchronized (this.lock) {
            this.fileDownloaderMap.put(Integer.valueOf(i), fileDownloader);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeFileDownloader(int i) {
        synchronized (this.lock) {
            FileDownloader remove = this.fileDownloaderMap.remove(Integer.valueOf(i));
        }
    }

    public final List<FileDownloader> getFileDownloaderList() {
        List<FileDownloader> list;
        synchronized (this.lock) {
            list = CollectionsKt.toList(this.fileDownloaderMap.values());
        }
        return list;
    }

    public final boolean containsFileDownloader(int i) {
        boolean containsKey;
        synchronized (this.lock) {
            containsKey = this.fileDownloaderMap.containsKey(Integer.valueOf(i));
        }
        return containsKey;
    }

    public final void clearAll() {
        synchronized (this.lock) {
            this.fileDownloaderMap.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
