package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.FetchNotificationManager;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/tonyodev/fetch2/fetch/ListenerCoordinator$cancelOnGoingNotifications$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: ListenerCoordinator.kt */
final class ListenerCoordinator$cancelOnGoingNotifications$$inlined$synchronized$lambda$1 implements Runnable {
    final /* synthetic */ FetchNotificationManager $fetchNotificationManager$inlined;
    final /* synthetic */ ListenerCoordinator this$0;

    ListenerCoordinator$cancelOnGoingNotifications$$inlined$synchronized$lambda$1(ListenerCoordinator listenerCoordinator, FetchNotificationManager fetchNotificationManager) {
        this.this$0 = listenerCoordinator;
        this.$fetchNotificationManager$inlined = fetchNotificationManager;
    }

    public final void run() {
        synchronized (this.this$0.lock) {
            this.$fetchNotificationManager$inlined.cancelOngoingNotifications();
            Unit unit = Unit.INSTANCE;
        }
    }
}
