package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.Reason;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: ListenerCoordinator.kt */
final class ListenerCoordinator$addFetchObserversForDownload$1$1 implements Runnable {
    final /* synthetic */ List $addedObservers;
    final /* synthetic */ Download $download;

    ListenerCoordinator$addFetchObserversForDownload$1$1(List list, Download download) {
        this.$addedObservers = list;
        this.$download = download;
    }

    public final void run() {
        for (FetchObserver onChanged : this.$addedObservers) {
            onChanged.onChanged(this.$download, Reason.OBSERVER_ATTACHED);
        }
    }
}
