package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.util.ActiveDownloadInfo;
import com.tonyodev.fetch2core.Reason;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$activeDownloadsRunnable$1 implements Runnable {
    final /* synthetic */ FetchImpl this$0;

    FetchImpl$activeDownloadsRunnable$1(FetchImpl fetchImpl) {
        this.this$0 = fetchImpl;
    }

    public final void run() {
        if (!this.this$0.isClosed()) {
            final boolean hasActiveDownloads = this.this$0.fetchHandler.hasActiveDownloads(true);
            final boolean hasActiveDownloads2 = this.this$0.fetchHandler.hasActiveDownloads(false);
            this.this$0.uiHandler.post(new Runnable(this) {
                final /* synthetic */ FetchImpl$activeDownloadsRunnable$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    if (!this.this$0.this$0.isClosed()) {
                        for (ActiveDownloadInfo activeDownloadInfo : this.this$0.this$0.activeDownloadsSet) {
                            activeDownloadInfo.getFetchObserver().onChanged(Boolean.valueOf(activeDownloadInfo.getIncludeAddedDownloads() ? hasActiveDownloads : hasActiveDownloads2), Reason.REPORTING);
                        }
                    }
                    if (!this.this$0.this$0.isClosed()) {
                        this.this$0.this$0.registerActiveDownloadsRunnable();
                    }
                }
            });
        }
    }
}
