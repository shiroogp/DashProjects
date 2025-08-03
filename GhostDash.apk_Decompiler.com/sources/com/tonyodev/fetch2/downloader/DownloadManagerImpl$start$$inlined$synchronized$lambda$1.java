package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2.Download;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/tonyodev/fetch2/downloader/DownloadManagerImpl$start$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: DownloadManagerImpl.kt */
final class DownloadManagerImpl$start$$inlined$synchronized$lambda$1 implements Runnable {
    final /* synthetic */ Download $download$inlined;
    final /* synthetic */ DownloadManagerImpl this$0;

    DownloadManagerImpl$start$$inlined$synchronized$lambda$1(DownloadManagerImpl downloadManagerImpl, Download download) {
        this.this$0 = downloadManagerImpl;
        this.$download$inlined = download;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final void run() {
        /*
            r5 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = "Thread.currentThread()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)     // Catch:{ Exception -> 0x002f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002f }
            r1.<init>()     // Catch:{ Exception -> 0x002f }
            com.tonyodev.fetch2.Download r2 = r5.$download$inlined     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = r2.getNamespace()     // Catch:{ Exception -> 0x002f }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x002f }
            r2 = 45
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x002f }
            com.tonyodev.fetch2.Download r2 = r5.$download$inlined     // Catch:{ Exception -> 0x002f }
            int r2 = r2.getId()     // Catch:{ Exception -> 0x002f }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x002f }
            r0.setName(r1)     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r0 = r5.this$0     // Catch:{ Exception -> 0x00cc }
            com.tonyodev.fetch2.Download r1 = r5.$download$inlined     // Catch:{ Exception -> 0x00cc }
            com.tonyodev.fetch2.downloader.FileDownloader r0 = r0.getNewFileDownloaderForDownload(r1)     // Catch:{ Exception -> 0x00cc }
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r1 = r5.this$0     // Catch:{ Exception -> 0x00cc }
            java.lang.Object r1 = r1.lock     // Catch:{ Exception -> 0x00cc }
            monitor-enter(r1)     // Catch:{ Exception -> 0x00cc }
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r2 = r5.this$0     // Catch:{ all -> 0x00c7 }
            java.util.HashMap r2 = r2.currentDownloadsMap     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.Download r3 = r5.$download$inlined     // Catch:{ all -> 0x00c7 }
            int r3 = r3.getId()     // Catch:{ all -> 0x00c7 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c7 }
            boolean r2 = r2.containsKey(r3)     // Catch:{ all -> 0x00c7 }
            if (r2 == 0) goto L_0x00a1
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r2 = r5.this$0     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r2 = r2.getFileDownloaderDelegate()     // Catch:{ all -> 0x00c7 }
            r0.setDelegate(r2)     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r2 = r5.this$0     // Catch:{ all -> 0x00c7 }
            java.util.HashMap r2 = r2.currentDownloadsMap     // Catch:{ all -> 0x00c7 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.Download r3 = r5.$download$inlined     // Catch:{ all -> 0x00c7 }
            int r3 = r3.getId()     // Catch:{ all -> 0x00c7 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c7 }
            r2.put(r3, r0)     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r2 = r5.this$0     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.downloader.DownloadManagerCoordinator r2 = r2.downloadManagerCoordinator     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.Download r3 = r5.$download$inlined     // Catch:{ all -> 0x00c7 }
            int r3 = r3.getId()     // Catch:{ all -> 0x00c7 }
            r2.addFileDownloader(r3, r0)     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r2 = r5.this$0     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2core.Logger r2 = r2.logger     // Catch:{ all -> 0x00c7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r3.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r4 = "DownloadManager starting download "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c7 }
            com.tonyodev.fetch2.Download r4 = r5.$download$inlined     // Catch:{ all -> 0x00c7 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c7 }
            r2.d(r3)     // Catch:{ all -> 0x00c7 }
            r2 = 1
            goto L_0x00a2
        L_0x00a1:
            r2 = 0
        L_0x00a2:
            monitor-exit(r1)     // Catch:{ Exception -> 0x00cc }
            if (r2 == 0) goto L_0x00a8
            r0.run()     // Catch:{ Exception -> 0x00cc }
        L_0x00a8:
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r0 = r5.this$0     // Catch:{ Exception -> 0x00cc }
            com.tonyodev.fetch2.Download r1 = r5.$download$inlined     // Catch:{ Exception -> 0x00cc }
            r0.removeDownloadMappings(r1)     // Catch:{ Exception -> 0x00cc }
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r0 = r5.this$0     // Catch:{ Exception -> 0x00cc }
            com.tonyodev.fetch2.provider.GroupInfoProvider r0 = r0.groupInfoProvider     // Catch:{ Exception -> 0x00cc }
            r0.clean()     // Catch:{ Exception -> 0x00cc }
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r0 = r5.this$0
            com.tonyodev.fetch2.Download r1 = r5.$download$inlined
            r0.removeDownloadMappings(r1)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET"
            r0.<init>(r1)
            goto L_0x00fb
        L_0x00c7:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ Exception -> 0x00cc }
            throw r0     // Catch:{ Exception -> 0x00cc }
        L_0x00ca:
            r0 = move-exception
            goto L_0x011d
        L_0x00cc:
            r0 = move-exception
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r1 = r5.this$0     // Catch:{ all -> 0x00ca }
            com.tonyodev.fetch2core.Logger r1 = r1.logger     // Catch:{ all -> 0x00ca }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r2.<init>()     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = "DownloadManager failed to start download "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00ca }
            com.tonyodev.fetch2.Download r3 = r5.$download$inlined     // Catch:{ all -> 0x00ca }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ca }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00ca }
            r1.e(r2, r0)     // Catch:{ all -> 0x00ca }
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r0 = r5.this$0
            com.tonyodev.fetch2.Download r1 = r5.$download$inlined
            r0.removeDownloadMappings(r1)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET"
            r0.<init>(r1)
        L_0x00fb:
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r1 = r5.this$0
            android.content.Context r1 = r1.context
            java.lang.String r1 = r1.getPackageName()
            r0.setPackage(r1)
            java.lang.String r1 = "com.tonyodev.fetch2.extra.NAMESPACE"
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r2 = r5.this$0
            java.lang.String r2 = r2.namespace
            r0.putExtra(r1, r2)
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r1 = r5.this$0
            android.content.Context r1 = r1.context
            r1.sendBroadcast(r0)
            return
        L_0x011d:
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r1 = r5.this$0
            com.tonyodev.fetch2.Download r2 = r5.$download$inlined
            r1.removeDownloadMappings(r2)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET"
            r1.<init>(r2)
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r2 = r5.this$0
            android.content.Context r2 = r2.context
            java.lang.String r2 = r2.getPackageName()
            r1.setPackage(r2)
            java.lang.String r2 = "com.tonyodev.fetch2.extra.NAMESPACE"
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r3 = r5.this$0
            java.lang.String r3 = r3.namespace
            r1.putExtra(r2, r3)
            com.tonyodev.fetch2.downloader.DownloadManagerImpl r2 = r5.this$0
            android.content.Context r2 = r2.context
            r2.sendBroadcast(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.downloader.DownloadManagerImpl$start$$inlined$synchronized$lambda$1.run():void");
    }
}
