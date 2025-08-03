package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.FetchListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "run", "com/tonyodev/fetch2/fetch/ListenerCoordinator$mainListener$1$onPaused$1$2$1", "com/tonyodev/fetch2/fetch/ListenerCoordinator$mainListener$1$$special$$inlined$forEach$lambda$16"}, k = 3, mv = {1, 1, 16})
/* compiled from: ListenerCoordinator.kt */
final class ListenerCoordinator$mainListener$1$onPaused$$inlined$synchronized$lambda$2 implements Runnable {
    final /* synthetic */ Download $download$inlined;
    final /* synthetic */ FetchListener $fetchListener;
    final /* synthetic */ ListenerCoordinator$mainListener$1 this$0;

    ListenerCoordinator$mainListener$1$onPaused$$inlined$synchronized$lambda$2(FetchListener fetchListener, ListenerCoordinator$mainListener$1 listenerCoordinator$mainListener$1, Download download) {
        this.$fetchListener = fetchListener;
        this.this$0 = listenerCoordinator$mainListener$1;
        this.$download$inlined = download;
    }

    public final void run() {
        this.$fetchListener.onPaused(this.$download$inlined);
    }
}
