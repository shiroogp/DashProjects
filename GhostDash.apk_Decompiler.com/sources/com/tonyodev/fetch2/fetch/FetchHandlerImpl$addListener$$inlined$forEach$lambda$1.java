package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.fetch.FetchHandlerImpl;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/tonyodev/fetch2/fetch/FetchHandlerImpl$addListener$2$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchHandlerImpl.kt */
final class FetchHandlerImpl$addListener$$inlined$forEach$lambda$1 implements Runnable {
    final /* synthetic */ DownloadInfo $it;
    final /* synthetic */ FetchListener $listener$inlined;
    final /* synthetic */ FetchHandlerImpl this$0;

    FetchHandlerImpl$addListener$$inlined$forEach$lambda$1(DownloadInfo downloadInfo, FetchHandlerImpl fetchHandlerImpl, FetchListener fetchListener) {
        this.$it = downloadInfo;
        this.this$0 = fetchHandlerImpl;
        this.$listener$inlined = fetchListener;
    }

    public final void run() {
        switch (FetchHandlerImpl.WhenMappings.$EnumSwitchMapping$1[this.$it.getStatus().ordinal()]) {
            case 1:
                this.$listener$inlined.onCompleted(this.$it);
                return;
            case 2:
                FetchListener fetchListener = this.$listener$inlined;
                DownloadInfo downloadInfo = this.$it;
                fetchListener.onError(downloadInfo, downloadInfo.getError(), (Throwable) null);
                return;
            case 3:
                this.$listener$inlined.onCancelled(this.$it);
                return;
            case 4:
                this.$listener$inlined.onDeleted(this.$it);
                return;
            case 5:
                this.$listener$inlined.onPaused(this.$it);
                return;
            case 6:
                this.$listener$inlined.onQueued(this.$it, false);
                return;
            case 7:
                this.$listener$inlined.onRemoved(this.$it);
                return;
            case 9:
                this.$listener$inlined.onAdded(this.$it);
                return;
            default:
                return;
        }
    }
}
