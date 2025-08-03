package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.downloader.FileDownloader;
import com.tonyodev.fetch2.util.FetchTypeConverterExtensions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: SequentialFileDownloaderImpl.kt */
final class SequentialFileDownloaderImpl$downloadInfo$2 extends Lambda implements Function0<DownloadInfo> {
    final /* synthetic */ SequentialFileDownloaderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequentialFileDownloaderImpl$downloadInfo$2(SequentialFileDownloaderImpl sequentialFileDownloaderImpl) {
        super(0);
        this.this$0 = sequentialFileDownloaderImpl;
    }

    public final DownloadInfo invoke() {
        Download access$getInitialDownload$p = this.this$0.initialDownload;
        FileDownloader.Delegate delegate = this.this$0.getDelegate();
        if (delegate == null) {
            Intrinsics.throwNpe();
        }
        return FetchTypeConverterExtensions.toDownloadInfo(access$getInitialDownload$p, delegate.getNewDownloadInfoInstance());
    }
}
