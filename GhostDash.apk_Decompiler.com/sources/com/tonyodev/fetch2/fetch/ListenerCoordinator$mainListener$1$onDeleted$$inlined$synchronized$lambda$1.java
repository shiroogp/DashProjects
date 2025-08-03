package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/tonyodev/fetch2/fetch/ListenerCoordinator$mainListener$1$onDeleted$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: ListenerCoordinator.kt */
final class ListenerCoordinator$mainListener$1$onDeleted$$inlined$synchronized$lambda$1 implements Runnable {
    final /* synthetic */ Download $download$inlined;
    final /* synthetic */ ListenerCoordinator$mainListener$1 this$0;

    ListenerCoordinator$mainListener$1$onDeleted$$inlined$synchronized$lambda$1(ListenerCoordinator$mainListener$1 listenerCoordinator$mainListener$1, Download download) {
        this.this$0 = listenerCoordinator$mainListener$1;
        this.$download$inlined = download;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0015 A[LOOP:0: B:4:0x0015->B:7:0x0027, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            com.tonyodev.fetch2.fetch.ListenerCoordinator$mainListener$1 r0 = r4.this$0
            com.tonyodev.fetch2.fetch.ListenerCoordinator r0 = r0.this$0
            java.lang.Object r0 = r0.lock
            monitor-enter(r0)
            com.tonyodev.fetch2.fetch.ListenerCoordinator$mainListener$1 r1 = r4.this$0     // Catch:{ all -> 0x002d }
            com.tonyodev.fetch2.fetch.ListenerCoordinator r1 = r1.this$0     // Catch:{ all -> 0x002d }
            java.util.List r1 = r1.fetchNotificationManagerList     // Catch:{ all -> 0x002d }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x002d }
        L_0x0015:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x002d }
            com.tonyodev.fetch2.FetchNotificationManager r2 = (com.tonyodev.fetch2.FetchNotificationManager) r2     // Catch:{ all -> 0x002d }
            com.tonyodev.fetch2.Download r3 = r4.$download$inlined     // Catch:{ all -> 0x002d }
            boolean r2 = r2.postDownloadUpdate(r3)     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0015
        L_0x0029:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002d }
            monitor-exit(r0)
            return
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.fetch.ListenerCoordinator$mainListener$1$onDeleted$$inlined$synchronized$lambda$1.run():void");
    }
}
