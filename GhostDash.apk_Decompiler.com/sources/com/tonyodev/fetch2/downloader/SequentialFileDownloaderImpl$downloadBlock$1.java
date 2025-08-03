package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2core.DownloadBlockInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tonyodev/fetch2core/DownloadBlockInfo;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: SequentialFileDownloaderImpl.kt */
final class SequentialFileDownloaderImpl$downloadBlock$1 extends Lambda implements Function0<DownloadBlockInfo> {
    final /* synthetic */ SequentialFileDownloaderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequentialFileDownloaderImpl$downloadBlock$1(SequentialFileDownloaderImpl sequentialFileDownloaderImpl) {
        super(0);
        this.this$0 = sequentialFileDownloaderImpl;
    }

    public final DownloadBlockInfo invoke() {
        DownloadBlockInfo downloadBlockInfo = new DownloadBlockInfo();
        downloadBlockInfo.setBlockPosition(1);
        downloadBlockInfo.setDownloadId(this.this$0.initialDownload.getId());
        return downloadBlockInfo;
    }
}
