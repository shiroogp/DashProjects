package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.Reason;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "run", "com/tonyodev/fetch2/fetch/ListenerCoordinator$mainListener$1$onProgress$1$4$1", "com/tonyodev/fetch2/fetch/ListenerCoordinator$mainListener$1$$special$$inlined$forEach$lambda$15"}, k = 3, mv = {1, 1, 16})
/* compiled from: ListenerCoordinator.kt */
final class ListenerCoordinator$mainListener$1$onProgress$$inlined$synchronized$lambda$3 implements Runnable {
    final /* synthetic */ Download $download$inlined;
    final /* synthetic */ long $downloadedBytesPerSecond$inlined;
    final /* synthetic */ long $etaInMilliSeconds$inlined;
    final /* synthetic */ FetchObserver $observer;
    final /* synthetic */ ListenerCoordinator$mainListener$1 this$0;

    ListenerCoordinator$mainListener$1$onProgress$$inlined$synchronized$lambda$3(FetchObserver fetchObserver, ListenerCoordinator$mainListener$1 listenerCoordinator$mainListener$1, Download download, long j, long j2) {
        this.$observer = fetchObserver;
        this.this$0 = listenerCoordinator$mainListener$1;
        this.$download$inlined = download;
        this.$etaInMilliSeconds$inlined = j;
        this.$downloadedBytesPerSecond$inlined = j2;
    }

    public final void run() {
        this.$observer.onChanged(this.$download$inlined, Reason.DOWNLOAD_PROGRESS_CHANGED);
    }
}
