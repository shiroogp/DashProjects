package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2core.FileSlice;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: ParallelFileDownloaderImpl.kt */
final class ParallelFileDownloaderImpl$downloadSliceFiles$1 implements Runnable {
    final /* synthetic */ FileSlice $fileSlice;
    final /* synthetic */ ParallelFileDownloaderImpl this$0;

    ParallelFileDownloaderImpl$downloadSliceFiles$1(ParallelFileDownloaderImpl parallelFileDownloaderImpl, FileSlice fileSlice) {
        this.this$0 = parallelFileDownloaderImpl;
        this.$fileSlice = fileSlice;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void run() {
        /*
            r31 = this;
            r1 = r31
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = "Thread.currentThread()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0049 }
            r2.<init>()     // Catch:{ Exception -> 0x0049 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r3 = r1.this$0     // Catch:{ Exception -> 0x0049 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r3.getDownloadInfo()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r3 = r3.getNamespace()     // Catch:{ Exception -> 0x0049 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0049 }
            r3 = 45
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0049 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r3 = r1.this$0     // Catch:{ Exception -> 0x0049 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r3.getDownloadInfo()     // Catch:{ Exception -> 0x0049 }
            int r3 = r3.getId()     // Catch:{ Exception -> 0x0049 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r3 = "-Slice-"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0049 }
            com.tonyodev.fetch2core.FileSlice r3 = r1.$fileSlice     // Catch:{ Exception -> 0x0049 }
            int r3 = r3.getPosition()     // Catch:{ Exception -> 0x0049 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0049 }
            r0.setName(r2)     // Catch:{ Exception -> 0x0049 }
        L_0x0049:
            com.tonyodev.fetch2core.DownloadBlockInfo r0 = new com.tonyodev.fetch2core.DownloadBlockInfo
            r0.<init>()
            com.tonyodev.fetch2core.FileSlice r2 = r1.$fileSlice
            int r2 = r2.getId()
            r0.setDownloadId(r2)
            com.tonyodev.fetch2core.FileSlice r2 = r1.$fileSlice
            int r2 = r2.getPosition()
            r0.setBlockPosition(r2)
            com.tonyodev.fetch2core.FileSlice r2 = r1.$fileSlice
            long r2 = r2.getDownloaded()
            r0.setDownloadedBytes(r2)
            com.tonyodev.fetch2core.FileSlice r2 = r1.$fileSlice
            long r2 = r2.getStartBytes()
            r0.setStartByte(r2)
            com.tonyodev.fetch2core.FileSlice r2 = r1.$fileSlice
            long r2 = r2.getEndBytes()
            r0.setEndByte(r2)
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r2 = r1.this$0
            com.tonyodev.fetch2.database.DownloadInfo r2 = r2.getDownloadInfo()
            r3 = r2
            com.tonyodev.fetch2.Download r3 = (com.tonyodev.fetch2.Download) r3
            com.tonyodev.fetch2core.FileSlice r2 = r1.$fileSlice
            long r4 = r2.getStartBytes()
            com.tonyodev.fetch2core.FileSlice r2 = r1.$fileSlice
            long r6 = r2.getDownloaded()
            long r4 = r4 + r6
            r6 = 0
            r8 = 0
            com.tonyodev.fetch2core.FileSlice r2 = r1.$fileSlice
            int r2 = r2.getPosition()
            r12 = 1
            int r9 = r2 + 1
            r10 = 12
            r11 = 0
            com.tonyodev.fetch2core.Downloader$ServerRequest r2 = com.tonyodev.fetch2.util.FetchUtils.getRequestForDownload$default(r3, r4, r6, r8, r9, r10, r11)
            r3 = 0
            r4 = r3
            com.tonyodev.fetch2core.Downloader$Response r4 = (com.tonyodev.fetch2core.Downloader.Response) r4
            java.io.RandomAccessFile r3 = (java.io.RandomAccessFile) r3
            com.tonyodev.fetch2core.FileSlice r5 = r1.$fileSlice     // Catch:{ Exception -> 0x0381 }
            int r5 = r5.getId()     // Catch:{ Exception -> 0x0381 }
            com.tonyodev.fetch2core.FileSlice r6 = r1.$fileSlice     // Catch:{ Exception -> 0x0381 }
            int r6 = r6.getPosition()     // Catch:{ Exception -> 0x0381 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r7 = r1.this$0     // Catch:{ Exception -> 0x0381 }
            java.lang.String r7 = r7.fileTempDir     // Catch:{ Exception -> 0x0381 }
            java.lang.String r5 = com.tonyodev.fetch2.util.FetchUtils.getDownloadedInfoFilePath(r5, r6, r7)     // Catch:{ Exception -> 0x0381 }
            java.io.File r5 = com.tonyodev.fetch2core.FetchCoreUtils.getFile(r5)     // Catch:{ Exception -> 0x0381 }
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0381 }
            java.lang.String r7 = "rw"
            r6.<init>(r5, r7)     // Catch:{ Exception -> 0x0381 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r3 = r1.this$0     // Catch:{ Exception -> 0x037b, all -> 0x0377 }
            com.tonyodev.fetch2core.Downloader r3 = r3.downloader     // Catch:{ Exception -> 0x037b, all -> 0x0377 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r5 = r1.this$0     // Catch:{ Exception -> 0x037b, all -> 0x0377 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl$interruptMonitor$1 r5 = r5.interruptMonitor     // Catch:{ Exception -> 0x037b, all -> 0x0377 }
            com.tonyodev.fetch2core.InterruptMonitor r5 = (com.tonyodev.fetch2core.InterruptMonitor) r5     // Catch:{ Exception -> 0x037b, all -> 0x0377 }
            com.tonyodev.fetch2core.Downloader$Response r4 = r3.execute(r2, r5)     // Catch:{ Exception -> 0x037b, all -> 0x0377 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r3 = r1.this$0     // Catch:{ Exception -> 0x0374, all -> 0x0370 }
            boolean r3 = r3.getTerminated()     // Catch:{ Exception -> 0x0374, all -> 0x0370 }
            if (r3 != 0) goto L_0x02d7
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r3 = r1.this$0     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            boolean r3 = r3.getInterrupted()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            if (r3 != 0) goto L_0x02d7
            if (r4 == 0) goto L_0x02d7
            boolean r3 = r4.isSuccessful()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            if (r3 != r12) goto L_0x02d7
            kotlin.jvm.internal.Ref$LongRef r3 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            r3.<init>()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r5 = r1.this$0     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            com.tonyodev.fetch2core.Downloader r5 = r5.downloader     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            int r2 = r5.getRequestBufferSize(r2)     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            byte[] r5 = new byte[r2]     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            java.io.InputStream r7 = r4.getByteStream()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            r8 = 0
            if (r7 == 0) goto L_0x0112
            int r7 = r7.read(r5, r8, r2)     // Catch:{ Exception -> 0x037b, all -> 0x0377 }
            goto L_0x0113
        L_0x0112:
            r7 = -1
        L_0x0113:
            com.tonyodev.fetch2core.FileSlice r10 = r1.$fileSlice     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            long r10 = r10.getEndBytes()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            r12 = 1
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r11 = 0
            if (r10 >= 0) goto L_0x0123
            r13 = r11
            goto L_0x0129
        L_0x0123:
            com.tonyodev.fetch2core.FileSlice r10 = r1.$fileSlice     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            long r13 = r10.getEndBytes()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
        L_0x0129:
            com.tonyodev.fetch2core.FileSlice r10 = r1.$fileSlice     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            long r15 = r10.getStartBytes()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            com.tonyodev.fetch2core.FileSlice r10 = r1.$fileSlice     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            long r17 = r10.getDownloaded()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            long r15 = r15 + r17
            long r15 = r13 - r15
            long r17 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            kotlin.jvm.internal.Ref$IntRef r10 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            r10.<init>()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            kotlin.jvm.internal.Ref$LongRef r8 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            r8.<init>()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            r29 = r15
            r16 = r10
            r9 = r29
        L_0x014d:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r15 = r1.this$0     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            boolean r15 = r15.totalUnknown     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            if (r15 != 0) goto L_0x0159
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 <= 0) goto L_0x02c9
        L_0x0159:
            r15 = -1
            if (r7 == r15) goto L_0x02c9
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r15 = r1.this$0     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            boolean r15 = r15.getInterrupted()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            if (r15 != 0) goto L_0x02c9
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r15 = r1.this$0     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            boolean r15 = r15.getTerminated()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            if (r15 != 0) goto L_0x02c9
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r15 = r1.this$0     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            boolean r15 = r15.totalUnknown     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            if (r15 != 0) goto L_0x017f
            long r11 = (long) r7     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x017a
            goto L_0x017f
        L_0x017a:
            int r7 = (int) r9     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            r12 = r16
            r11 = -1
            goto L_0x0182
        L_0x017f:
            r11 = r7
            r12 = r16
        L_0x0182:
            r12.element = r7     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            com.tonyodev.fetch2core.FileSlice r7 = r1.$fileSlice     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            long r15 = r7.getStartBytes()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            com.tonyodev.fetch2core.FileSlice r7 = r1.$fileSlice     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            long r19 = r7.getDownloaded()     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            r25 = r9
            long r9 = r15 + r19
            r8.element = r9     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r7 = r1.this$0     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            java.lang.Object r7 = r7.lock     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            monitor-enter(r7)     // Catch:{ Exception -> 0x02d2, all -> 0x02cd }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r9 = r1.this$0     // Catch:{ all -> 0x02c4 }
            boolean r9 = r9.getInterrupted()     // Catch:{ all -> 0x02c4 }
            if (r9 != 0) goto L_0x0263
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r9 = r1.this$0     // Catch:{ all -> 0x02c4 }
            boolean r9 = r9.getTerminated()     // Catch:{ all -> 0x02c4 }
            if (r9 != 0) goto L_0x0263
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r9 = r1.this$0     // Catch:{ all -> 0x02c4 }
            com.tonyodev.fetch2core.OutputResourceWrapper r9 = r9.outputResourceWrapper     // Catch:{ all -> 0x02c4 }
            if (r9 == 0) goto L_0x01bc
            r15 = r13
            long r13 = r8.element     // Catch:{ all -> 0x02c4 }
            r9.setWriteOffset(r13)     // Catch:{ all -> 0x02c4 }
            goto L_0x01bd
        L_0x01bc:
            r15 = r13
        L_0x01bd:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r9 = r1.this$0     // Catch:{ all -> 0x02c4 }
            com.tonyodev.fetch2core.OutputResourceWrapper r9 = r9.outputResourceWrapper     // Catch:{ all -> 0x02c4 }
            if (r9 == 0) goto L_0x01cb
            int r10 = r12.element     // Catch:{ all -> 0x02c4 }
            r13 = 0
            r9.write(r5, r13, r10)     // Catch:{ all -> 0x02c4 }
        L_0x01cb:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r9 = r1.this$0     // Catch:{ all -> 0x02c4 }
            boolean r9 = r9.getInterrupted()     // Catch:{ all -> 0x02c4 }
            if (r9 != 0) goto L_0x020b
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r9 = r1.this$0     // Catch:{ all -> 0x02c4 }
            boolean r9 = r9.getTerminated()     // Catch:{ all -> 0x02c4 }
            if (r9 != 0) goto L_0x020b
            com.tonyodev.fetch2core.FileSlice r9 = r1.$fileSlice     // Catch:{ all -> 0x02c4 }
            long r13 = r9.getDownloaded()     // Catch:{ all -> 0x02c4 }
            int r10 = r12.element     // Catch:{ all -> 0x02c4 }
            r27 = r4
            r28 = r5
            long r4 = (long) r10
            long r13 = r13 + r4
            r9.setDownloaded(r13)     // Catch:{ all -> 0x02c2 }
            r4 = 0
            r6.seek(r4)     // Catch:{ all -> 0x02c2 }
            r6.setLength(r4)     // Catch:{ all -> 0x02c2 }
            com.tonyodev.fetch2core.FileSlice r9 = r1.$fileSlice     // Catch:{ all -> 0x02c2 }
            long r9 = r9.getDownloaded()     // Catch:{ all -> 0x02c2 }
            r6.writeLong(r9)     // Catch:{ all -> 0x02c2 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r9 = r1.this$0     // Catch:{ all -> 0x02c2 }
            long r13 = r9.downloaded     // Catch:{ all -> 0x02c2 }
            int r10 = r12.element     // Catch:{ all -> 0x02c2 }
            long r4 = (long) r10     // Catch:{ all -> 0x02c2 }
            long r13 = r13 + r4
            r9.downloaded = r13     // Catch:{ all -> 0x02c2 }
            goto L_0x020f
        L_0x020b:
            r27 = r4
            r28 = r5
        L_0x020f:
            long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x02c2 }
            r3.element = r4     // Catch:{ all -> 0x02c2 }
            long r4 = r3.element     // Catch:{ all -> 0x02c2 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r9 = r1.this$0     // Catch:{ all -> 0x02c2 }
            long r23 = r9.progressReportingIntervalMillis     // Catch:{ all -> 0x02c2 }
            r19 = r17
            r21 = r4
            boolean r4 = com.tonyodev.fetch2core.FetchCoreUtils.hasIntervalTimeElapsed(r19, r21, r23)     // Catch:{ all -> 0x02c2 }
            if (r4 == 0) goto L_0x0268
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r4 = r1.this$0     // Catch:{ all -> 0x02c2 }
            boolean r4 = r4.getInterrupted()     // Catch:{ all -> 0x02c2 }
            if (r4 != 0) goto L_0x025c
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r4 = r1.this$0     // Catch:{ all -> 0x02c2 }
            boolean r4 = r4.getTerminated()     // Catch:{ all -> 0x02c2 }
            if (r4 != 0) goto L_0x025c
            com.tonyodev.fetch2core.FileSlice r4 = r1.$fileSlice     // Catch:{ all -> 0x02c2 }
            long r4 = r4.getDownloaded()     // Catch:{ all -> 0x02c2 }
            r0.setDownloadedBytes(r4)     // Catch:{ all -> 0x02c2 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r4 = r1.this$0     // Catch:{ all -> 0x02c2 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r4 = r4.getDelegate()     // Catch:{ all -> 0x02c2 }
            if (r4 == 0) goto L_0x025c
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r5 = r1.this$0     // Catch:{ all -> 0x02c2 }
            com.tonyodev.fetch2.database.DownloadInfo r5 = r5.getDownloadInfo()     // Catch:{ all -> 0x02c2 }
            com.tonyodev.fetch2.Download r5 = (com.tonyodev.fetch2.Download) r5     // Catch:{ all -> 0x02c2 }
            r9 = r0
            com.tonyodev.fetch2core.DownloadBlock r9 = (com.tonyodev.fetch2core.DownloadBlock) r9     // Catch:{ all -> 0x02c2 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r10 = r1.this$0     // Catch:{ all -> 0x02c2 }
            int r10 = r10.totalDownloadBlocks     // Catch:{ all -> 0x02c2 }
            r4.onDownloadBlockUpdated(r5, r9, r10)     // Catch:{ all -> 0x02c2 }
        L_0x025c:
            long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x02c2 }
            r17 = r4
            goto L_0x0268
        L_0x0263:
            r27 = r4
            r28 = r5
            r15 = r13
        L_0x0268:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x02c2 }
            monitor-exit(r7)     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r4 = r1.this$0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            boolean r4 = r4.getInterrupted()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r4 != 0) goto L_0x02ae
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r4 = r1.this$0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            boolean r4 = r4.getTerminated()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r4 != 0) goto L_0x02ae
            r4 = -1
            if (r11 == r4) goto L_0x02ab
            java.io.InputStream r5 = r27.getByteStream()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r5 == 0) goto L_0x028c
            r7 = r28
            r9 = 0
            int r19 = r5.read(r7, r9, r2)     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            goto L_0x0291
        L_0x028c:
            r7 = r28
            r9 = 0
            r19 = r4
        L_0x0291:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r5 = r1.this$0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            boolean r5 = r5.totalUnknown     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r5 != 0) goto L_0x02b4
            com.tonyodev.fetch2core.FileSlice r5 = r1.$fileSlice     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            long r10 = r5.getStartBytes()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            com.tonyodev.fetch2core.FileSlice r5 = r1.$fileSlice     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            long r13 = r5.getDownloaded()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            long r10 = r10 + r13
            long r13 = r15 - r10
            r25 = r13
            goto L_0x02b4
        L_0x02ab:
            r7 = r28
            goto L_0x02b1
        L_0x02ae:
            r7 = r28
            r4 = -1
        L_0x02b1:
            r9 = 0
            r19 = r11
        L_0x02b4:
            r5 = r7
            r13 = r15
            r7 = r19
            r9 = r25
            r4 = r27
            r16 = r12
            r11 = 0
            goto L_0x014d
        L_0x02c2:
            r0 = move-exception
            goto L_0x02c7
        L_0x02c4:
            r0 = move-exception
            r27 = r4
        L_0x02c7:
            monitor-exit(r7)     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            throw r0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
        L_0x02c9:
            r27 = r4
            goto L_0x0341
        L_0x02cd:
            r0 = move-exception
            r27 = r4
            goto L_0x0378
        L_0x02d2:
            r0 = move-exception
            r27 = r4
            goto L_0x037c
        L_0x02d7:
            r27 = r4
            if (r27 != 0) goto L_0x0303
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            boolean r0 = r0.getInterrupted()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r0 != 0) goto L_0x0303
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            boolean r0 = r0.getTerminated()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r0 == 0) goto L_0x02ec
            goto L_0x0303
        L_0x02ec:
            com.tonyodev.fetch2.exception.FetchException r0 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            java.lang.String r2 = "empty_response_body"
            r0.<init>(r2)     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            throw r0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
        L_0x02f6:
            r0 = move-exception
            r2 = r0
            r3 = r6
            r4 = r27
            goto L_0x03df
        L_0x02fd:
            r0 = move-exception
            r3 = r6
            r4 = r27
            goto L_0x0382
        L_0x0303:
            if (r27 == 0) goto L_0x0326
            boolean r0 = r27.isSuccessful()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r0 != 0) goto L_0x0326
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            boolean r0 = r0.getInterrupted()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r0 != 0) goto L_0x0326
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            boolean r0 = r0.getTerminated()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r0 == 0) goto L_0x031c
            goto L_0x0326
        L_0x031c:
            com.tonyodev.fetch2.exception.FetchException r0 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            java.lang.String r2 = "request_not_successful"
            r0.<init>(r2)     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            throw r0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
        L_0x0326:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x036b, all -> 0x0366 }
            boolean r0 = r0.getInterrupted()     // Catch:{ Exception -> 0x036b, all -> 0x0366 }
            if (r0 != 0) goto L_0x0341
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            boolean r0 = r0.getTerminated()     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            if (r0 == 0) goto L_0x0337
            goto L_0x0341
        L_0x0337:
            com.tonyodev.fetch2.exception.FetchException r0 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            java.lang.String r2 = "unknown"
            r0.<init>(r2)     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
            throw r0     // Catch:{ Exception -> 0x02fd, all -> 0x02f6 }
        L_0x0341:
            if (r27 == 0) goto L_0x035d
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x034f }
            com.tonyodev.fetch2core.Downloader r0 = r0.downloader     // Catch:{ Exception -> 0x034f }
            r2 = r27
            r0.disconnect(r2)     // Catch:{ Exception -> 0x034f }
            goto L_0x035d
        L_0x034f:
            r0 = move-exception
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r2 = r1.this$0
            com.tonyodev.fetch2core.Logger r2 = r2.logger
            java.lang.String r3 = "FileDownloader"
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.e(r3, r0)
        L_0x035d:
            r6.close()     // Catch:{ Exception -> 0x0362 }
            goto L_0x03d9
        L_0x0362:
            r0 = move-exception
            r2 = r0
            goto L_0x03cc
        L_0x0366:
            r0 = move-exception
            r2 = r27
            r4 = r2
            goto L_0x0372
        L_0x036b:
            r0 = move-exception
            r2 = r27
            r4 = r2
            goto L_0x037c
        L_0x0370:
            r0 = move-exception
            r2 = r4
        L_0x0372:
            r3 = r6
            goto L_0x037f
        L_0x0374:
            r0 = move-exception
            r2 = r4
            goto L_0x037c
        L_0x0377:
            r0 = move-exception
        L_0x0378:
            r2 = r0
            r3 = r6
            goto L_0x03df
        L_0x037b:
            r0 = move-exception
        L_0x037c:
            r3 = r6
            goto L_0x0382
        L_0x037e:
            r0 = move-exception
        L_0x037f:
            r2 = r0
            goto L_0x03df
        L_0x0381:
            r0 = move-exception
        L_0x0382:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r2 = r1.this$0     // Catch:{ all -> 0x037e }
            com.tonyodev.fetch2core.Logger r2 = r2.logger     // Catch:{ all -> 0x037e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x037e }
            r5.<init>()     // Catch:{ all -> 0x037e }
            java.lang.String r6 = "FileDownloader downloads slice "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x037e }
            com.tonyodev.fetch2core.FileSlice r6 = r1.$fileSlice     // Catch:{ all -> 0x037e }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x037e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x037e }
            r6 = r0
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x037e }
            r2.e(r5, r6)     // Catch:{ all -> 0x037e }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r2 = r1.this$0     // Catch:{ all -> 0x037e }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x037e }
            r2.throwable = r0     // Catch:{ all -> 0x037e }
            if (r4 == 0) goto L_0x03c4
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x03b6 }
            com.tonyodev.fetch2core.Downloader r0 = r0.downloader     // Catch:{ Exception -> 0x03b6 }
            r0.disconnect(r4)     // Catch:{ Exception -> 0x03b6 }
            goto L_0x03c4
        L_0x03b6:
            r0 = move-exception
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r2 = r1.this$0
            com.tonyodev.fetch2core.Logger r2 = r2.logger
            java.lang.String r4 = "FileDownloader"
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.e(r4, r0)
        L_0x03c4:
            if (r3 == 0) goto L_0x03d9
            r3.close()     // Catch:{ Exception -> 0x03ca }
            goto L_0x03d9
        L_0x03ca:
            r0 = move-exception
            r2 = r0
        L_0x03cc:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0
            com.tonyodev.fetch2core.Logger r0 = r0.logger
            java.lang.String r3 = "FileDownloader"
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r0.e(r3, r2)
        L_0x03d9:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0
            r0.incrementActionCompletedCount()
            return
        L_0x03df:
            if (r4 == 0) goto L_0x03f9
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0     // Catch:{ Exception -> 0x03eb }
            com.tonyodev.fetch2core.Downloader r0 = r0.downloader     // Catch:{ Exception -> 0x03eb }
            r0.disconnect(r4)     // Catch:{ Exception -> 0x03eb }
            goto L_0x03f9
        L_0x03eb:
            r0 = move-exception
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r4 = r1.this$0
            com.tonyodev.fetch2core.Logger r4 = r4.logger
            java.lang.String r5 = "FileDownloader"
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r4.e(r5, r0)
        L_0x03f9:
            if (r3 == 0) goto L_0x040e
            r3.close()     // Catch:{ Exception -> 0x03ff }
            goto L_0x040e
        L_0x03ff:
            r0 = move-exception
            r3 = r0
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0
            com.tonyodev.fetch2core.Logger r0 = r0.logger
            java.lang.String r4 = "FileDownloader"
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r0.e(r4, r3)
        L_0x040e:
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl r0 = r1.this$0
            r0.incrementActionCompletedCount()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl$downloadSliceFiles$1.run():void");
    }
}
