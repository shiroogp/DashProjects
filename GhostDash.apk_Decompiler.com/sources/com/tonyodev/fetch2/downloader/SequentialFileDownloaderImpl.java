package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.downloader.FileDownloader;
import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2.helper.FileDownloaderDelegate;
import com.tonyodev.fetch2.provider.NetworkInfoProvider;
import com.tonyodev.fetch2core.AverageCalculator;
import com.tonyodev.fetch2core.DownloadBlockInfo;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.FetchErrorStrings;
import com.tonyodev.fetch2core.Logger;
import com.tonyodev.fetch2core.OutputResourceWrapper;
import com.tonyodev.fetch2core.StorageResolver;
import java.io.BufferedInputStream;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001,\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0002\u0010\u0012J\b\u0010<\u001a\u00020\u0007H\u0002J\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020\rH\u0002J\b\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0002J\"\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020:H\u0002R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0004¢\u0006\u0004\n\u0002\u0010-R$\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u00102R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u00102R\u000e\u00108\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:XD¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/tonyodev/fetch2/downloader/SequentialFileDownloaderImpl;", "Lcom/tonyodev/fetch2/downloader/FileDownloader;", "initialDownload", "Lcom/tonyodev/fetch2/Download;", "downloader", "Lcom/tonyodev/fetch2core/Downloader;", "progressReportingIntervalMillis", "", "logger", "Lcom/tonyodev/fetch2core/Logger;", "networkInfoProvider", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "retryOnNetworkGain", "", "hashCheckingEnabled", "storageResolver", "Lcom/tonyodev/fetch2core/StorageResolver;", "preAllocateFileOnCreation", "(Lcom/tonyodev/fetch2/Download;Lcom/tonyodev/fetch2core/Downloader;JLcom/tonyodev/fetch2core/Logger;Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;ZZLcom/tonyodev/fetch2core/StorageResolver;Z)V", "averageDownloadedBytesPerSecond", "", "completedDownload", "getCompletedDownload", "()Z", "delegate", "Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "getDelegate", "()Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "setDelegate", "(Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;)V", "download", "getDownload", "()Lcom/tonyodev/fetch2/Download;", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlockInfo;", "downloadInfo", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "getDownloadInfo", "()Lcom/tonyodev/fetch2/database/DownloadInfo;", "downloadInfo$delegate", "Lkotlin/Lazy;", "downloaded", "estimatedTimeRemainingInMilliseconds", "interruptMonitor", "com/tonyodev/fetch2/downloader/SequentialFileDownloaderImpl$interruptMonitor$1", "Lcom/tonyodev/fetch2/downloader/SequentialFileDownloaderImpl$interruptMonitor$1;", "value", "interrupted", "getInterrupted", "setInterrupted", "(Z)V", "movingAverageCalculator", "Lcom/tonyodev/fetch2core/AverageCalculator;", "terminated", "getTerminated", "setTerminated", "total", "totalDownloadBlocks", "", "totalUnknown", "getAverageDownloadedBytesPerSecond", "getRequest", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "isDownloadComplete", "run", "", "setIsTotalUnknown", "response", "Lcom/tonyodev/fetch2core/Downloader$Response;", "verifyDownloadCompletion", "writeToOutput", "input", "Ljava/io/BufferedInputStream;", "outputResourceWrapper", "Lcom/tonyodev/fetch2core/OutputResourceWrapper;", "bufferSize", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SequentialFileDownloaderImpl.kt */
public final class SequentialFileDownloaderImpl implements FileDownloader {
    private double averageDownloadedBytesPerSecond;
    private FileDownloader.Delegate delegate;
    private final DownloadBlockInfo downloadBlock = ((DownloadBlockInfo) new SequentialFileDownloaderImpl$downloadBlock$1(this).invoke());
    private final Lazy downloadInfo$delegate = LazyKt.lazy(new SequentialFileDownloaderImpl$downloadInfo$2(this));
    private volatile long downloaded;
    private final Downloader<?, ?> downloader;
    private long estimatedTimeRemainingInMilliseconds = -1;
    private final boolean hashCheckingEnabled;
    /* access modifiers changed from: private */
    public final Download initialDownload;
    private final SequentialFileDownloaderImpl$interruptMonitor$1 interruptMonitor = new SequentialFileDownloaderImpl$interruptMonitor$1(this);
    private volatile boolean interrupted;
    private final Logger logger;
    private final AverageCalculator movingAverageCalculator = new AverageCalculator(5);
    private final NetworkInfoProvider networkInfoProvider;
    private final boolean preAllocateFileOnCreation;
    private final long progressReportingIntervalMillis;
    private final boolean retryOnNetworkGain;
    private final StorageResolver storageResolver;
    private volatile boolean terminated;
    private volatile long total = -1;
    private final int totalDownloadBlocks = 1;
    private volatile boolean totalUnknown;

    private final DownloadInfo getDownloadInfo() {
        return (DownloadInfo) this.downloadInfo$delegate.getValue();
    }

    public SequentialFileDownloaderImpl(Download download, Downloader<?, ?> downloader2, long j, Logger logger2, NetworkInfoProvider networkInfoProvider2, boolean z, boolean z2, StorageResolver storageResolver2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(download, "initialDownload");
        Intrinsics.checkParameterIsNotNull(downloader2, "downloader");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(networkInfoProvider2, "networkInfoProvider");
        Intrinsics.checkParameterIsNotNull(storageResolver2, "storageResolver");
        this.initialDownload = download;
        this.downloader = downloader2;
        this.progressReportingIntervalMillis = j;
        this.logger = logger2;
        this.networkInfoProvider = networkInfoProvider2;
        this.retryOnNetworkGain = z;
        this.hashCheckingEnabled = z2;
        this.storageResolver = storageResolver2;
        this.preAllocateFileOnCreation = z3;
    }

    public boolean getInterrupted() {
        return this.interrupted;
    }

    public void setInterrupted(boolean z) {
        FileDownloader.Delegate delegate2 = getDelegate();
        if (!(delegate2 instanceof FileDownloaderDelegate)) {
            delegate2 = null;
        }
        FileDownloaderDelegate fileDownloaderDelegate = (FileDownloaderDelegate) delegate2;
        if (fileDownloaderDelegate != null) {
            fileDownloaderDelegate.setInterrupted(z);
        }
        this.interrupted = z;
    }

    public boolean getTerminated() {
        return this.terminated;
    }

    public void setTerminated(boolean z) {
        FileDownloader.Delegate delegate2 = getDelegate();
        if (!(delegate2 instanceof FileDownloaderDelegate)) {
            delegate2 = null;
        }
        FileDownloaderDelegate fileDownloaderDelegate = (FileDownloaderDelegate) delegate2;
        if (fileDownloaderDelegate != null) {
            fileDownloaderDelegate.setInterrupted(z);
        }
        this.terminated = z;
    }

    public boolean getCompletedDownload() {
        return isDownloadComplete();
    }

    public FileDownloader.Delegate getDelegate() {
        return this.delegate;
    }

    public void setDelegate(FileDownloader.Delegate delegate2) {
        this.delegate = delegate2;
    }

    public Download getDownload() {
        getDownloadInfo().setDownloaded(this.downloaded);
        getDownloadInfo().setTotal(this.total);
        return getDownloadInfo();
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x031b A[Catch:{ InterruptedException -> 0x0345, all -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0326 A[Catch:{ InterruptedException -> 0x0345, all -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0399 A[Catch:{ InterruptedException -> 0x0345, all -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03a6 A[SYNTHETIC, Splitter:B:166:0x03a6] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03b5 A[SYNTHETIC, Splitter:B:171:0x03b5] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03c5 A[SYNTHETIC, Splitter:B:176:0x03c5] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03d8 A[SYNTHETIC, Splitter:B:184:0x03d8] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03e7 A[SYNTHETIC, Splitter:B:189:0x03e7] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03f7 A[SYNTHETIC, Splitter:B:194:0x03f7] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ Exception -> 0x02df }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b1 A[Catch:{ Exception -> 0x02df }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00eb A[Catch:{ Exception -> 0x02df }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0103 A[Catch:{ Exception -> 0x02df }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017d A[Catch:{ Exception -> 0x01ae, all -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0194 A[Catch:{ Exception -> 0x01ae, all -> 0x01a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "FileDownloader"
            r0 = 0
            r3 = r0
            com.tonyodev.fetch2core.OutputResourceWrapper r3 = (com.tonyodev.fetch2core.OutputResourceWrapper) r3
            r4 = r0
            java.io.BufferedInputStream r4 = (java.io.BufferedInputStream) r4
            r5 = r0
            com.tonyodev.fetch2core.Downloader$Response r5 = (com.tonyodev.fetch2core.Downloader.Response) r5
            r6 = -1
            r8 = 1
            com.tonyodev.fetch2.Download r0 = r1.initialDownload     // Catch:{ Exception -> 0x02df }
            long r9 = r0.getDownloaded()     // Catch:{ Exception -> 0x02df }
            r1.downloaded = r9     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.Download r0 = r1.initialDownload     // Catch:{ Exception -> 0x02df }
            long r9 = r0.getTotal()     // Catch:{ Exception -> 0x02df }
            r1.total = r9     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r9 = r1.downloaded     // Catch:{ Exception -> 0x02df }
            r0.setDownloaded(r9)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r9 = r1.total     // Catch:{ Exception -> 0x02df }
            r0.setTotal(r9)     // Catch:{ Exception -> 0x02df }
            boolean r0 = r17.getInterrupted()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x020f
            boolean r0 = r17.getTerminated()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x020f
            com.tonyodev.fetch2core.Downloader$ServerRequest r0 = r17.getRequest()     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.Downloader<?, ?> r9 = r1.downloader     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.downloader.SequentialFileDownloaderImpl$interruptMonitor$1 r10 = r1.interruptMonitor     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.InterruptMonitor r10 = (com.tonyodev.fetch2core.InterruptMonitor) r10     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.Downloader$Response r5 = r9.execute(r0, r10)     // Catch:{ Exception -> 0x02df }
            if (r5 == 0) goto L_0x0052
            r1.setIsTotalUnknown(r5)     // Catch:{ Exception -> 0x02df }
        L_0x0052:
            r9 = 0
            if (r5 == 0) goto L_0x005a
            boolean r10 = r5.isSuccessful()     // Catch:{ Exception -> 0x02df }
            goto L_0x005b
        L_0x005a:
            r10 = r9
        L_0x005b:
            boolean r11 = r17.getInterrupted()     // Catch:{ Exception -> 0x02df }
            if (r11 != 0) goto L_0x01b2
            boolean r11 = r17.getTerminated()     // Catch:{ Exception -> 0x02df }
            if (r11 != 0) goto L_0x01b2
            if (r5 == 0) goto L_0x01b2
            if (r10 == 0) goto L_0x01b2
            int r10 = r5.getCode()     // Catch:{ Exception -> 0x02df }
            r11 = 0
            r13 = 206(0xce, float:2.89E-43)
            if (r10 == r13) goto L_0x007e
            boolean r10 = r5.getAcceptsRanges()     // Catch:{ Exception -> 0x02df }
            if (r10 == 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r14 = r11
            goto L_0x0084
        L_0x007e:
            com.tonyodev.fetch2.Download r10 = r1.initialDownload     // Catch:{ Exception -> 0x02df }
            long r14 = r10.getDownloaded()     // Catch:{ Exception -> 0x02df }
        L_0x0084:
            r1.downloaded = r14     // Catch:{ Exception -> 0x02df }
            long r14 = r5.getContentLength()     // Catch:{ Exception -> 0x02df }
            r1.total = r14     // Catch:{ Exception -> 0x02df }
            int r10 = r5.getCode()     // Catch:{ Exception -> 0x02df }
            if (r10 != r13) goto L_0x00b1
            com.tonyodev.fetch2core.Logger r10 = r1.logger     // Catch:{ Exception -> 0x02df }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02df }
            r11.<init>()     // Catch:{ Exception -> 0x02df }
            java.lang.String r12 = "FileDownloader resuming Download "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.Download r12 = r17.getDownload()     // Catch:{ Exception -> 0x02df }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x02df }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x02df }
            r10.d(r11)     // Catch:{ Exception -> 0x02df }
            long r11 = r1.downloaded     // Catch:{ Exception -> 0x02df }
            goto L_0x00cd
        L_0x00b1:
            com.tonyodev.fetch2core.Logger r10 = r1.logger     // Catch:{ Exception -> 0x02df }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02df }
            r13.<init>()     // Catch:{ Exception -> 0x02df }
            java.lang.String r14 = "FileDownloader starting Download "
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.Download r14 = r17.getDownload()     // Catch:{ Exception -> 0x02df }
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x02df }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x02df }
            r10.d(r13)     // Catch:{ Exception -> 0x02df }
        L_0x00cd:
            com.tonyodev.fetch2.database.DownloadInfo r10 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r13 = r1.downloaded     // Catch:{ Exception -> 0x02df }
            r10.setDownloaded(r13)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r10 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r13 = r1.total     // Catch:{ Exception -> 0x02df }
            r10.setTotal(r13)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.StorageResolver r10 = r1.storageResolver     // Catch:{ Exception -> 0x02df }
            java.lang.String r13 = r0.getFile()     // Catch:{ Exception -> 0x02df }
            boolean r10 = r10.fileExists(r13)     // Catch:{ Exception -> 0x02df }
            if (r10 != 0) goto L_0x00ff
            com.tonyodev.fetch2core.StorageResolver r10 = r1.storageResolver     // Catch:{ Exception -> 0x02df }
            java.lang.String r13 = r0.getFile()     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.Download r14 = r1.initialDownload     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.EnqueueAction r14 = r14.getEnqueueAction()     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.EnqueueAction r15 = com.tonyodev.fetch2.EnqueueAction.INCREMENT_FILE_NAME     // Catch:{ Exception -> 0x02df }
            if (r14 != r15) goto L_0x00fc
            r9 = r8
        L_0x00fc:
            r10.createFile(r13, r9)     // Catch:{ Exception -> 0x02df }
        L_0x00ff:
            boolean r9 = r1.preAllocateFileOnCreation     // Catch:{ Exception -> 0x02df }
            if (r9 == 0) goto L_0x0114
            com.tonyodev.fetch2core.StorageResolver r9 = r1.storageResolver     // Catch:{ Exception -> 0x02df }
            java.lang.String r10 = r0.getFile()     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r13 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r13 = r13.getTotal()     // Catch:{ Exception -> 0x02df }
            r9.preAllocateFile(r10, r13)     // Catch:{ Exception -> 0x02df }
        L_0x0114:
            com.tonyodev.fetch2core.StorageResolver r9 = r1.storageResolver     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.OutputResourceWrapper r3 = r9.getRequestOutputResourceWrapper(r0)     // Catch:{ Exception -> 0x02df }
            r3.setWriteOffset(r11)     // Catch:{ Exception -> 0x02df }
            boolean r9 = r17.getInterrupted()     // Catch:{ Exception -> 0x02df }
            if (r9 != 0) goto L_0x020f
            boolean r9 = r17.getTerminated()     // Catch:{ Exception -> 0x02df }
            if (r9 != 0) goto L_0x020f
            com.tonyodev.fetch2core.Downloader<?, ?> r9 = r1.downloader     // Catch:{ Exception -> 0x02df }
            int r0 = r9.getRequestBufferSize(r0)     // Catch:{ Exception -> 0x02df }
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x02df }
            java.io.InputStream r10 = r5.getByteStream()     // Catch:{ Exception -> 0x02df }
            r9.<init>(r10, r0)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r4 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            long r13 = r1.downloaded     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.setDownloaded(r13)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2.database.DownloadInfo r4 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            long r13 = r1.total     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.setTotal(r13)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2core.DownloadBlockInfo r4 = r1.downloadBlock     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            long r13 = r1.downloaded     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.setDownloadedBytes(r13)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2core.DownloadBlockInfo r4 = r1.downloadBlock     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.setStartByte(r11)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2core.DownloadBlockInfo r4 = r1.downloadBlock     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            long r10 = r1.total     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.setEndByte(r10)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            boolean r4 = r17.getTerminated()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            if (r4 != 0) goto L_0x01a3
            boolean r4 = r17.getInterrupted()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            if (r4 != 0) goto L_0x01a3
            com.tonyodev.fetch2.database.DownloadInfo r4 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.setEtaInMilliSeconds(r6)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2.database.DownloadInfo r4 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.setDownloadedBytesPerSecond(r6)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r4 = r17.getDelegate()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            if (r4 == 0) goto L_0x018e
            com.tonyodev.fetch2.database.DownloadInfo r10 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2.Download r10 = (com.tonyodev.fetch2.Download) r10     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2core.DownloadBlockInfo r11 = r1.downloadBlock     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r11)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            int r12 = r1.totalDownloadBlocks     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.onStarted(r10, r11, r12)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
        L_0x018e:
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r4 = r17.getDelegate()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            if (r4 == 0) goto L_0x01a3
            com.tonyodev.fetch2.database.DownloadInfo r10 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2.Download r10 = (com.tonyodev.fetch2.Download) r10     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2core.DownloadBlockInfo r11 = r1.downloadBlock     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            com.tonyodev.fetch2core.DownloadBlock r11 = (com.tonyodev.fetch2core.DownloadBlock) r11     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            int r12 = r1.totalDownloadBlocks     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4.onDownloadBlockUpdated(r10, r11, r12)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
        L_0x01a3:
            r1.writeToOutput(r9, r3, r0)     // Catch:{ Exception -> 0x01ae, all -> 0x01a9 }
            r4 = r9
            goto L_0x020f
        L_0x01a9:
            r0 = move-exception
            r6 = r0
            r4 = r9
            goto L_0x03d6
        L_0x01ae:
            r0 = move-exception
            r4 = r9
            goto L_0x02e0
        L_0x01b2:
            if (r5 != 0) goto L_0x01d1
            boolean r0 = r17.getInterrupted()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x01d1
            boolean r0 = r17.getTerminated()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x01d1
            boolean r0 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x02df }
            if (r0 == 0) goto L_0x01c7
            goto L_0x01d1
        L_0x01c7:
            com.tonyodev.fetch2.exception.FetchException r0 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x02df }
            java.lang.String r9 = "empty_response_body"
            r0.<init>(r9)     // Catch:{ Exception -> 0x02df }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x02df }
            throw r0     // Catch:{ Exception -> 0x02df }
        L_0x01d1:
            if (r10 != 0) goto L_0x01ea
            boolean r0 = r17.getInterrupted()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x01ea
            boolean r0 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x02df }
            if (r0 == 0) goto L_0x01e0
            goto L_0x01ea
        L_0x01e0:
            com.tonyodev.fetch2.exception.FetchException r0 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x02df }
            java.lang.String r9 = "request_not_successful"
            r0.<init>(r9)     // Catch:{ Exception -> 0x02df }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x02df }
            throw r0     // Catch:{ Exception -> 0x02df }
        L_0x01ea:
            boolean r0 = r17.getInterrupted()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x020f
            boolean r0 = r17.getTerminated()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x020f
            long r9 = r1.downloaded     // Catch:{ Exception -> 0x02df }
            long r11 = r1.total     // Catch:{ Exception -> 0x02df }
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x020f
            boolean r0 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x02df }
            if (r0 == 0) goto L_0x0205
            goto L_0x020f
        L_0x0205:
            com.tonyodev.fetch2.exception.FetchException r0 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x02df }
            java.lang.String r9 = "unknown"
            r0.<init>(r9)     // Catch:{ Exception -> 0x02df }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x02df }
            throw r0     // Catch:{ Exception -> 0x02df }
        L_0x020f:
            boolean r0 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x02a6
            boolean r0 = r17.getTerminated()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x02a6
            boolean r0 = r17.getInterrupted()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x02a6
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r9 = r1.downloaded     // Catch:{ Exception -> 0x02df }
            r0.setDownloaded(r9)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r9 = r1.total     // Catch:{ Exception -> 0x02df }
            r0.setTotal(r9)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.DownloadBlockInfo r0 = r1.downloadBlock     // Catch:{ Exception -> 0x02df }
            long r9 = r1.downloaded     // Catch:{ Exception -> 0x02df }
            r0.setDownloadedBytes(r9)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.DownloadBlockInfo r0 = r1.downloadBlock     // Catch:{ Exception -> 0x02df }
            long r9 = r1.total     // Catch:{ Exception -> 0x02df }
            r0.setEndByte(r9)     // Catch:{ Exception -> 0x02df }
            boolean r0 = r17.getTerminated()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x02b1
            boolean r0 = r17.getInterrupted()     // Catch:{ Exception -> 0x02df }
            if (r0 != 0) goto L_0x02b1
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r0 = r17.getDelegate()     // Catch:{ Exception -> 0x02df }
            if (r0 == 0) goto L_0x025c
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.Download r9 = (com.tonyodev.fetch2.Download) r9     // Catch:{ Exception -> 0x02df }
            r0.saveDownloadProgress(r9)     // Catch:{ Exception -> 0x02df }
        L_0x025c:
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r0 = r17.getDelegate()     // Catch:{ Exception -> 0x02df }
            if (r0 == 0) goto L_0x0271
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.Download r9 = (com.tonyodev.fetch2.Download) r9     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.DownloadBlockInfo r10 = r1.downloadBlock     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2core.DownloadBlock r10 = (com.tonyodev.fetch2core.DownloadBlock) r10     // Catch:{ Exception -> 0x02df }
            int r11 = r1.totalDownloadBlocks     // Catch:{ Exception -> 0x02df }
            r0.onDownloadBlockUpdated(r9, r10, r11)     // Catch:{ Exception -> 0x02df }
        L_0x0271:
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r9 = r1.estimatedTimeRemainingInMilliseconds     // Catch:{ Exception -> 0x02df }
            r0.setEtaInMilliSeconds(r9)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r9 = r17.getAverageDownloadedBytesPerSecond()     // Catch:{ Exception -> 0x02df }
            r0.setDownloadedBytesPerSecond(r9)     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r11 = r17.getDelegate()     // Catch:{ Exception -> 0x02df }
            if (r11 == 0) goto L_0x02b1
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            r12 = r0
            com.tonyodev.fetch2.Download r12 = (com.tonyodev.fetch2.Download) r12     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r13 = r0.getEtaInMilliSeconds()     // Catch:{ Exception -> 0x02df }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x02df }
            long r15 = r0.getDownloadedBytesPerSecond()     // Catch:{ Exception -> 0x02df }
            r11.onProgress(r12, r13, r15)     // Catch:{ Exception -> 0x02df }
            goto L_0x02b1
        L_0x02a6:
            boolean r0 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x02df }
            if (r0 == 0) goto L_0x02b1
            if (r5 == 0) goto L_0x02b1
            r1.verifyDownloadCompletion(r5)     // Catch:{ Exception -> 0x02df }
        L_0x02b1:
            if (r4 == 0) goto L_0x02c0
            r4.close()     // Catch:{ Exception -> 0x02b7 }
            goto L_0x02c0
        L_0x02b7:
            r0 = move-exception
            r4 = r0
            com.tonyodev.fetch2core.Logger r0 = r1.logger
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r0.e(r2, r4)
        L_0x02c0:
            if (r5 == 0) goto L_0x02d0
            com.tonyodev.fetch2core.Downloader<?, ?> r0 = r1.downloader     // Catch:{ Exception -> 0x02c8 }
            r0.disconnect(r5)     // Catch:{ Exception -> 0x02c8 }
            goto L_0x02d0
        L_0x02c8:
            r0 = move-exception
            com.tonyodev.fetch2core.Logger r4 = r1.logger
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r4.e(r2, r0)
        L_0x02d0:
            if (r3 == 0) goto L_0x03d2
            r3.close()     // Catch:{ Exception -> 0x02d7 }
            goto L_0x03d2
        L_0x02d7:
            r0 = move-exception
            r3 = r0
            goto L_0x03cb
        L_0x02db:
            r0 = move-exception
            r6 = r0
            goto L_0x03d6
        L_0x02df:
            r0 = move-exception
        L_0x02e0:
            r9 = r0
            boolean r0 = r17.getInterrupted()     // Catch:{ all -> 0x02db }
            if (r0 != 0) goto L_0x03a4
            boolean r0 = r17.getTerminated()     // Catch:{ all -> 0x02db }
            if (r0 != 0) goto L_0x03a4
            com.tonyodev.fetch2core.Logger r0 = r1.logger     // Catch:{ all -> 0x02db }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02db }
            r10.<init>()     // Catch:{ all -> 0x02db }
            java.lang.String r11 = "FileDownloader download:"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2.Download r11 = r17.getDownload()     // Catch:{ all -> 0x02db }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x02db }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x02db }
            r11 = r9
            java.lang.Throwable r11 = (java.lang.Throwable) r11     // Catch:{ all -> 0x02db }
            r0.e(r10, r11)     // Catch:{ all -> 0x02db }
            r0 = r9
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2.Error r10 = com.tonyodev.fetch2.FetchErrorUtils.getErrorFromThrowable(r0)     // Catch:{ all -> 0x02db }
            r0 = r9
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x02db }
            r10.setThrowable(r0)     // Catch:{ all -> 0x02db }
            if (r5 == 0) goto L_0x0322
            com.tonyodev.fetch2core.Downloader$Response r0 = com.tonyodev.fetch2core.FetchCoreUtils.copyDownloadResponseNoStream(r5)     // Catch:{ all -> 0x02db }
            r10.setHttpResponse(r0)     // Catch:{ all -> 0x02db }
        L_0x0322:
            boolean r0 = r1.retryOnNetworkGain     // Catch:{ all -> 0x02db }
            if (r0 == 0) goto L_0x0352
            com.tonyodev.fetch2.provider.NetworkInfoProvider r0 = r1.networkInfoProvider     // Catch:{ all -> 0x02db }
            boolean r0 = r0.isNetworkAvailable()     // Catch:{ all -> 0x02db }
            r11 = r0 ^ 1
            r0 = 10
            r12 = r8
        L_0x0331:
            if (r12 > r0) goto L_0x034e
            r13 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r13)     // Catch:{ InterruptedException -> 0x0345 }
            com.tonyodev.fetch2.provider.NetworkInfoProvider r13 = r1.networkInfoProvider     // Catch:{ all -> 0x02db }
            boolean r13 = r13.isNetworkAvailable()     // Catch:{ all -> 0x02db }
            if (r13 != 0) goto L_0x0342
            r11 = r8
            goto L_0x034e
        L_0x0342:
            int r12 = r12 + 1
            goto L_0x0331
        L_0x0345:
            r0 = move-exception
            r12 = r0
            com.tonyodev.fetch2core.Logger r0 = r1.logger     // Catch:{ all -> 0x02db }
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch:{ all -> 0x02db }
            r0.e(r2, r12)     // Catch:{ all -> 0x02db }
        L_0x034e:
            if (r11 == 0) goto L_0x0352
            com.tonyodev.fetch2.Error r10 = com.tonyodev.fetch2.Error.NO_NETWORK_CONNECTION     // Catch:{ all -> 0x02db }
        L_0x0352:
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ all -> 0x02db }
            long r11 = r1.downloaded     // Catch:{ all -> 0x02db }
            r0.setDownloaded(r11)     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ all -> 0x02db }
            long r11 = r1.total     // Catch:{ all -> 0x02db }
            r0.setTotal(r11)     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ all -> 0x02db }
            r0.setError(r10)     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2core.DownloadBlockInfo r0 = r1.downloadBlock     // Catch:{ all -> 0x02db }
            long r11 = r1.downloaded     // Catch:{ all -> 0x02db }
            r0.setDownloadedBytes(r11)     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2core.DownloadBlockInfo r0 = r1.downloadBlock     // Catch:{ all -> 0x02db }
            long r11 = r1.total     // Catch:{ all -> 0x02db }
            r0.setEndByte(r11)     // Catch:{ all -> 0x02db }
            boolean r0 = r17.getTerminated()     // Catch:{ all -> 0x02db }
            if (r0 != 0) goto L_0x03a4
            boolean r0 = r17.getInterrupted()     // Catch:{ all -> 0x02db }
            if (r0 != 0) goto L_0x03a4
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ all -> 0x02db }
            r0.setEtaInMilliSeconds(r6)     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2.database.DownloadInfo r0 = r17.getDownloadInfo()     // Catch:{ all -> 0x02db }
            r0.setDownloadedBytesPerSecond(r6)     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r0 = r17.getDelegate()     // Catch:{ all -> 0x02db }
            if (r0 == 0) goto L_0x03a4
            com.tonyodev.fetch2.database.DownloadInfo r6 = r17.getDownloadInfo()     // Catch:{ all -> 0x02db }
            com.tonyodev.fetch2.Download r6 = (com.tonyodev.fetch2.Download) r6     // Catch:{ all -> 0x02db }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x02db }
            r0.onError(r6, r10, r9)     // Catch:{ all -> 0x02db }
        L_0x03a4:
            if (r4 == 0) goto L_0x03b3
            r4.close()     // Catch:{ Exception -> 0x03aa }
            goto L_0x03b3
        L_0x03aa:
            r0 = move-exception
            r4 = r0
            com.tonyodev.fetch2core.Logger r0 = r1.logger
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r0.e(r2, r4)
        L_0x03b3:
            if (r5 == 0) goto L_0x03c3
            com.tonyodev.fetch2core.Downloader<?, ?> r0 = r1.downloader     // Catch:{ Exception -> 0x03bb }
            r0.disconnect(r5)     // Catch:{ Exception -> 0x03bb }
            goto L_0x03c3
        L_0x03bb:
            r0 = move-exception
            com.tonyodev.fetch2core.Logger r4 = r1.logger
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r4.e(r2, r0)
        L_0x03c3:
            if (r3 == 0) goto L_0x03d2
            r3.close()     // Catch:{ Exception -> 0x03c9 }
            goto L_0x03d2
        L_0x03c9:
            r0 = move-exception
            r3 = r0
        L_0x03cb:
            com.tonyodev.fetch2core.Logger r0 = r1.logger
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r0.e(r2, r3)
        L_0x03d2:
            r1.setTerminated(r8)
            return
        L_0x03d6:
            if (r4 == 0) goto L_0x03e5
            r4.close()     // Catch:{ Exception -> 0x03dc }
            goto L_0x03e5
        L_0x03dc:
            r0 = move-exception
            r4 = r0
            com.tonyodev.fetch2core.Logger r0 = r1.logger
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r0.e(r2, r4)
        L_0x03e5:
            if (r5 == 0) goto L_0x03f5
            com.tonyodev.fetch2core.Downloader<?, ?> r0 = r1.downloader     // Catch:{ Exception -> 0x03ed }
            r0.disconnect(r5)     // Catch:{ Exception -> 0x03ed }
            goto L_0x03f5
        L_0x03ed:
            r0 = move-exception
            com.tonyodev.fetch2core.Logger r4 = r1.logger
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r4.e(r2, r0)
        L_0x03f5:
            if (r3 == 0) goto L_0x0404
            r3.close()     // Catch:{ Exception -> 0x03fb }
            goto L_0x0404
        L_0x03fb:
            r0 = move-exception
            r3 = r0
            com.tonyodev.fetch2core.Logger r0 = r1.logger
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r0.e(r2, r3)
        L_0x0404:
            r1.setTerminated(r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.downloader.SequentialFileDownloaderImpl.run():void");
    }

    private final boolean isDownloadComplete() {
        return ((this.downloaded > 0 && this.total > 0) || this.totalUnknown) && this.downloaded >= this.total;
    }

    private final void setIsTotalUnknown(Downloader.Response response) {
        if (response.isSuccessful() && response.getContentLength() == -1) {
            this.totalUnknown = true;
        }
    }

    private final void writeToOutput(BufferedInputStream bufferedInputStream, OutputResourceWrapper outputResourceWrapper, int i) {
        BufferedInputStream bufferedInputStream2 = bufferedInputStream;
        OutputResourceWrapper outputResourceWrapper2 = outputResourceWrapper;
        int i2 = i;
        long j = this.downloaded;
        byte[] bArr = new byte[i2];
        long nanoTime = System.nanoTime();
        long nanoTime2 = System.nanoTime();
        int i3 = 0;
        int read = bufferedInputStream2.read(bArr, 0, i2);
        while (!getInterrupted() && !getTerminated() && read != -1) {
            if (outputResourceWrapper2 != null) {
                outputResourceWrapper2.write(bArr, i3, read);
            }
            if (!getTerminated() && !getInterrupted()) {
                this.downloaded += (long) read;
                getDownloadInfo().setDownloaded(this.downloaded);
                getDownloadInfo().setTotal(this.total);
                this.downloadBlock.setDownloadedBytes(this.downloaded);
                this.downloadBlock.setEndByte(this.total);
                boolean hasIntervalTimeElapsed = FetchCoreUtils.hasIntervalTimeElapsed(nanoTime2, System.nanoTime(), 1000);
                if (hasIntervalTimeElapsed) {
                    this.movingAverageCalculator.add((double) (this.downloaded - j));
                    this.averageDownloadedBytesPerSecond = AverageCalculator.getMovingAverageWithWeightOnRecentValues$default(this.movingAverageCalculator, 0, 1, (Object) null);
                    this.estimatedTimeRemainingInMilliseconds = FetchCoreUtils.calculateEstimatedTimeRemainingInMilliseconds(this.downloaded, this.total, getAverageDownloadedBytesPerSecond());
                    j = this.downloaded;
                }
                if (FetchCoreUtils.hasIntervalTimeElapsed(nanoTime, System.nanoTime(), this.progressReportingIntervalMillis)) {
                    this.downloadBlock.setDownloadedBytes(this.downloaded);
                    if (!getTerminated() && !getInterrupted()) {
                        FileDownloader.Delegate delegate2 = getDelegate();
                        if (delegate2 != null) {
                            delegate2.saveDownloadProgress(getDownloadInfo());
                        }
                        FileDownloader.Delegate delegate3 = getDelegate();
                        if (delegate3 != null) {
                            delegate3.onDownloadBlockUpdated(getDownloadInfo(), this.downloadBlock, this.totalDownloadBlocks);
                        }
                        getDownloadInfo().setEtaInMilliSeconds(this.estimatedTimeRemainingInMilliseconds);
                        getDownloadInfo().setDownloadedBytesPerSecond(getAverageDownloadedBytesPerSecond());
                        FileDownloader.Delegate delegate4 = getDelegate();
                        if (delegate4 != null) {
                            delegate4.onProgress(getDownloadInfo(), getDownloadInfo().getEtaInMilliSeconds(), getDownloadInfo().getDownloadedBytesPerSecond());
                        }
                    }
                    nanoTime = System.nanoTime();
                }
                if (hasIntervalTimeElapsed) {
                    nanoTime2 = System.nanoTime();
                }
                i3 = 0;
                read = bufferedInputStream2.read(bArr, 0, i2);
            }
        }
        if (outputResourceWrapper2 != null) {
            outputResourceWrapper.flush();
        }
    }

    private final void verifyDownloadCompletion(Downloader.Response response) {
        if (!getInterrupted() && !getTerminated() && isDownloadComplete()) {
            this.total = this.downloaded;
            getDownloadInfo().setDownloaded(this.downloaded);
            getDownloadInfo().setTotal(this.total);
            this.downloadBlock.setDownloadedBytes(this.downloaded);
            this.downloadBlock.setEndByte(this.total);
            if (this.hashCheckingEnabled) {
                if (!this.downloader.verifyContentHash(response.getRequest(), response.getHash())) {
                    throw new FetchException(FetchErrorStrings.INVALID_CONTENT_HASH);
                } else if (!getTerminated() && !getInterrupted()) {
                    FileDownloader.Delegate delegate2 = getDelegate();
                    if (delegate2 != null) {
                        delegate2.saveDownloadProgress(getDownloadInfo());
                    }
                    FileDownloader.Delegate delegate3 = getDelegate();
                    if (delegate3 != null) {
                        delegate3.onDownloadBlockUpdated(getDownloadInfo(), this.downloadBlock, this.totalDownloadBlocks);
                    }
                    getDownloadInfo().setEtaInMilliSeconds(this.estimatedTimeRemainingInMilliseconds);
                    getDownloadInfo().setDownloadedBytesPerSecond(getAverageDownloadedBytesPerSecond());
                    Download copy = getDownloadInfo().copy();
                    FileDownloader.Delegate delegate4 = getDelegate();
                    if (delegate4 != null) {
                        delegate4.onProgress(getDownloadInfo(), getDownloadInfo().getEtaInMilliSeconds(), getDownloadInfo().getDownloadedBytesPerSecond());
                    }
                    getDownloadInfo().setEtaInMilliSeconds(-1);
                    getDownloadInfo().setDownloadedBytesPerSecond(-1);
                    FileDownloader.Delegate delegate5 = getDelegate();
                    if (delegate5 != null) {
                        delegate5.onComplete(copy);
                    }
                }
            } else if (!getTerminated() && !getInterrupted()) {
                FileDownloader.Delegate delegate6 = getDelegate();
                if (delegate6 != null) {
                    delegate6.saveDownloadProgress(getDownloadInfo());
                }
                FileDownloader.Delegate delegate7 = getDelegate();
                if (delegate7 != null) {
                    delegate7.onDownloadBlockUpdated(getDownloadInfo(), this.downloadBlock, this.totalDownloadBlocks);
                }
                getDownloadInfo().setEtaInMilliSeconds(this.estimatedTimeRemainingInMilliseconds);
                getDownloadInfo().setDownloadedBytesPerSecond(getAverageDownloadedBytesPerSecond());
                Download copy2 = getDownloadInfo().copy();
                FileDownloader.Delegate delegate8 = getDelegate();
                if (delegate8 != null) {
                    delegate8.onProgress(getDownloadInfo(), getDownloadInfo().getEtaInMilliSeconds(), getDownloadInfo().getDownloadedBytesPerSecond());
                }
                getDownloadInfo().setEtaInMilliSeconds(-1);
                getDownloadInfo().setDownloadedBytesPerSecond(-1);
                FileDownloader.Delegate delegate9 = getDelegate();
                if (delegate9 != null) {
                    delegate9.onComplete(copy2);
                }
            }
        }
    }

    private final Downloader.ServerRequest getRequest() {
        Map<String, String> mutableMap = MapsKt.toMutableMap(this.initialDownload.getHeaders());
        mutableMap.put("Range", "bytes=" + this.downloaded + '-');
        return new Downloader.ServerRequest(this.initialDownload.getId(), this.initialDownload.getUrl(), mutableMap, this.initialDownload.getFile(), FetchCoreUtils.getFileUri(this.initialDownload.getFile()), this.initialDownload.getTag(), this.initialDownload.getIdentifier(), FetchCoreUtils.GET_REQUEST_METHOD, this.initialDownload.getExtras(), false, "", 1);
    }

    private final long getAverageDownloadedBytesPerSecond() {
        double d = this.averageDownloadedBytesPerSecond;
        if (d < ((double) 1)) {
            return 0;
        }
        return (long) Math.ceil(d);
    }
}
