package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2core.InterruptMonitor;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"com/tonyodev/fetch2/downloader/SequentialFileDownloaderImpl$interruptMonitor$1", "Lcom/tonyodev/fetch2core/InterruptMonitor;", "isInterrupted", "", "()Z", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SequentialFileDownloaderImpl.kt */
public final class SequentialFileDownloaderImpl$interruptMonitor$1 implements InterruptMonitor {
    final /* synthetic */ SequentialFileDownloaderImpl this$0;

    SequentialFileDownloaderImpl$interruptMonitor$1(SequentialFileDownloaderImpl sequentialFileDownloaderImpl) {
        this.this$0 = sequentialFileDownloaderImpl;
    }

    public boolean isInterrupted() {
        return this.this$0.getInterrupted();
    }
}
