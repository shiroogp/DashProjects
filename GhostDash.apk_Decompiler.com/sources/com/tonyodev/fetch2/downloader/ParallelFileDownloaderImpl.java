package com.tonyodev.fetch2.downloader;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.downloader.FileDownloader;
import com.tonyodev.fetch2.helper.FileDownloaderDelegate;
import com.tonyodev.fetch2.provider.NetworkInfoProvider;
import com.tonyodev.fetch2.util.FetchUtils;
import com.tonyodev.fetch2core.AverageCalculator;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.FileSlice;
import com.tonyodev.fetch2core.FileSliceInfo;
import com.tonyodev.fetch2core.Logger;
import com.tonyodev.fetch2core.OutputResourceWrapper;
import com.tonyodev.fetch2core.StorageResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00014\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0002\u0010\u0014J\u001e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010K\u001a\u00020LH\u0002J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010R\u001a\u00020\r2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010S\u001a\u00020JH\u0002J\b\u0010T\u001a\u00020\rH\u0002J\b\u0010U\u001a\u00020JH\u0016J\u0010\u0010V\u001a\u00020J2\u0006\u0010W\u001a\u00020XH\u0002J\b\u0010Y\u001a\u00020JH\u0002J\b\u0010Z\u001a\u00020JH\u0002R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0004¢\u0006\u0004\n\u0002\u00105R$\u00107\u001a\u00020\r2\u0006\u00106\u001a\u00020\r@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R$\u0010A\u001a\u00020\r2\u0006\u00106\u001a\u00020\r@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010:R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/tonyodev/fetch2/downloader/ParallelFileDownloaderImpl;", "Lcom/tonyodev/fetch2/downloader/FileDownloader;", "initialDownload", "Lcom/tonyodev/fetch2/Download;", "downloader", "Lcom/tonyodev/fetch2core/Downloader;", "progressReportingIntervalMillis", "", "logger", "Lcom/tonyodev/fetch2core/Logger;", "networkInfoProvider", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "retryOnNetworkGain", "", "fileTempDir", "", "hashCheckingEnabled", "storageResolver", "Lcom/tonyodev/fetch2core/StorageResolver;", "preAllocateFileOnCreation", "(Lcom/tonyodev/fetch2/Download;Lcom/tonyodev/fetch2core/Downloader;JLcom/tonyodev/fetch2core/Logger;Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;ZLjava/lang/String;ZLcom/tonyodev/fetch2core/StorageResolver;Z)V", "actionsCounter", "", "actionsTotal", "averageDownloadedBytesPerSecond", "", "completedDownload", "getCompletedDownload", "()Z", "delegate", "Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "getDelegate", "()Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "setDelegate", "(Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;)V", "download", "getDownload", "()Lcom/tonyodev/fetch2/Download;", "downloadInfo", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "getDownloadInfo", "()Lcom/tonyodev/fetch2/database/DownloadInfo;", "downloadInfo$delegate", "Lkotlin/Lazy;", "downloaded", "estimatedTimeRemainingInMilliseconds", "executorService", "Ljava/util/concurrent/ExecutorService;", "fileSlices", "", "Lcom/tonyodev/fetch2core/FileSlice;", "interruptMonitor", "com/tonyodev/fetch2/downloader/ParallelFileDownloaderImpl$interruptMonitor$1", "Lcom/tonyodev/fetch2/downloader/ParallelFileDownloaderImpl$interruptMonitor$1;", "value", "interrupted", "getInterrupted", "setInterrupted", "(Z)V", "lock", "Ljava/lang/Object;", "movingAverageCalculator", "Lcom/tonyodev/fetch2core/AverageCalculator;", "outputResourceWrapper", "Lcom/tonyodev/fetch2core/OutputResourceWrapper;", "terminated", "getTerminated", "setTerminated", "throwable", "", "total", "totalDownloadBlocks", "totalUnknown", "downloadSliceFiles", "", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "fileSlicesDownloadsList", "getAverageDownloadedBytesPerSecond", "getChuckInfo", "Lcom/tonyodev/fetch2core/FileSliceInfo;", "getFileSliceList", "acceptsRanges", "incrementActionCompletedCount", "isDownloadComplete", "run", "setIsTotalUnknown", "response", "Lcom/tonyodev/fetch2core/Downloader$Response;", "throwExceptionIfFound", "waitAndPerformProgressReporting", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ParallelFileDownloaderImpl.kt */
public final class ParallelFileDownloaderImpl implements FileDownloader {
    private volatile int actionsCounter;
    private int actionsTotal;
    private double averageDownloadedBytesPerSecond;
    private FileDownloader.Delegate delegate;
    private final Lazy downloadInfo$delegate = LazyKt.lazy(new ParallelFileDownloaderImpl$downloadInfo$2(this));
    /* access modifiers changed from: private */
    public volatile long downloaded;
    /* access modifiers changed from: private */
    public final Downloader<?, ?> downloader;
    private long estimatedTimeRemainingInMilliseconds = -1;
    private ExecutorService executorService;
    private List<FileSlice> fileSlices = CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public final String fileTempDir;
    private final boolean hashCheckingEnabled;
    /* access modifiers changed from: private */
    public final Download initialDownload;
    /* access modifiers changed from: private */
    public final ParallelFileDownloaderImpl$interruptMonitor$1 interruptMonitor = new ParallelFileDownloaderImpl$interruptMonitor$1(this);
    private volatile boolean interrupted;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Logger logger;
    private final AverageCalculator movingAverageCalculator = new AverageCalculator(5);
    private final NetworkInfoProvider networkInfoProvider;
    /* access modifiers changed from: private */
    public OutputResourceWrapper outputResourceWrapper;
    private final boolean preAllocateFileOnCreation;
    /* access modifiers changed from: private */
    public final long progressReportingIntervalMillis;
    private final boolean retryOnNetworkGain;
    private final StorageResolver storageResolver;
    private volatile boolean terminated;
    /* access modifiers changed from: private */
    public volatile Throwable throwable;
    private volatile long total = -1;
    /* access modifiers changed from: private */
    public int totalDownloadBlocks;
    /* access modifiers changed from: private */
    public volatile boolean totalUnknown;

    /* access modifiers changed from: private */
    public final DownloadInfo getDownloadInfo() {
        return (DownloadInfo) this.downloadInfo$delegate.getValue();
    }

    public ParallelFileDownloaderImpl(Download download, Downloader<?, ?> downloader2, long j, Logger logger2, NetworkInfoProvider networkInfoProvider2, boolean z, String str, boolean z2, StorageResolver storageResolver2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(download, "initialDownload");
        Intrinsics.checkParameterIsNotNull(downloader2, "downloader");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(networkInfoProvider2, "networkInfoProvider");
        Intrinsics.checkParameterIsNotNull(str, "fileTempDir");
        Intrinsics.checkParameterIsNotNull(storageResolver2, "storageResolver");
        this.initialDownload = download;
        this.downloader = downloader2;
        this.progressReportingIntervalMillis = j;
        this.logger = logger2;
        this.networkInfoProvider = networkInfoProvider2;
        this.retryOnNetworkGain = z;
        this.fileTempDir = str;
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

    /* JADX WARNING: Removed duplicated region for block: B:100:0x025e A[Catch:{ Exception -> 0x0465, all -> 0x0461 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02a7 A[Catch:{ Exception -> 0x0465, all -> 0x0461 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0432 A[Catch:{ Exception -> 0x0438 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0445 A[Catch:{ Exception -> 0x044b }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0456 A[SYNTHETIC, Splitter:B:169:0x0456] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "FileDownloader"
            r3 = 0
            r4 = r3
            com.tonyodev.fetch2core.Downloader$Response r4 = (com.tonyodev.fetch2core.Downloader.Response) r4
            r5 = 10
            r6 = -1
            r8 = 1
            com.tonyodev.fetch2.Download r9 = r1.initialDownload     // Catch:{ Exception -> 0x0465 }
            long r9 = r9.getDownloaded()     // Catch:{ Exception -> 0x0465 }
            r1.downloaded = r9     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r9 = r1.initialDownload     // Catch:{ Exception -> 0x0465 }
            long r9 = r9.getTotal()     // Catch:{ Exception -> 0x0465 }
            r1.total = r9     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r10 = r1.downloaded     // Catch:{ Exception -> 0x0465 }
            r9.setDownloaded(r10)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r10 = r1.total     // Catch:{ Exception -> 0x0465 }
            r9.setTotal(r10)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.Downloader<?, ?> r9 = r1.downloader     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r10 = r1.initialDownload     // Catch:{ Exception -> 0x0465 }
            r11 = 2
            com.tonyodev.fetch2core.Downloader$ServerRequest r10 = com.tonyodev.fetch2.util.FetchUtils.getRequestForDownload$default(r10, r3, r11, r3)     // Catch:{ Exception -> 0x0465 }
            boolean r9 = r9.getHeadRequestMethodSupported(r10)     // Catch:{ Exception -> 0x0465 }
            if (r9 == 0) goto L_0x0047
            com.tonyodev.fetch2.Download r3 = r1.initialDownload     // Catch:{ Exception -> 0x0465 }
            java.lang.String r9 = "HEAD"
            com.tonyodev.fetch2core.Downloader$ServerRequest r3 = com.tonyodev.fetch2.util.FetchUtils.getRequestForDownload(r3, r9)     // Catch:{ Exception -> 0x0465 }
            goto L_0x004d
        L_0x0047:
            com.tonyodev.fetch2.Download r9 = r1.initialDownload     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.Downloader$ServerRequest r3 = com.tonyodev.fetch2.util.FetchUtils.getRequestForDownload$default(r9, r3, r11, r3)     // Catch:{ Exception -> 0x0465 }
        L_0x004d:
            com.tonyodev.fetch2core.Downloader<?, ?> r9 = r1.downloader     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl$interruptMonitor$1 r10 = r1.interruptMonitor     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.InterruptMonitor r10 = (com.tonyodev.fetch2core.InterruptMonitor) r10     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.Downloader$Response r4 = r9.execute(r3, r10)     // Catch:{ Exception -> 0x0465 }
            if (r4 == 0) goto L_0x005c
            r1.setIsTotalUnknown(r4)     // Catch:{ Exception -> 0x0465 }
        L_0x005c:
            boolean r9 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            java.lang.String r10 = "empty_response_body"
            r11 = 0
            if (r9 != 0) goto L_0x01d8
            boolean r9 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r9 != 0) goto L_0x01d8
            if (r4 == 0) goto L_0x01d8
            boolean r9 = r4.isSuccessful()     // Catch:{ Exception -> 0x0465 }
            if (r9 != r8) goto L_0x01d8
            long r13 = r4.getContentLength()     // Catch:{ Exception -> 0x0465 }
            r1.total = r13     // Catch:{ Exception -> 0x0465 }
            boolean r9 = r1.totalUnknown     // Catch:{ Exception -> 0x0465 }
            if (r9 != 0) goto L_0x008d
            long r13 = r1.total     // Catch:{ Exception -> 0x0465 }
            int r9 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x0085
            goto L_0x008d
        L_0x0085:
            com.tonyodev.fetch2.exception.FetchException r3 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x0465 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x0465 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x0465 }
            throw r3     // Catch:{ Exception -> 0x0465 }
        L_0x008d:
            r1.downloaded = r11     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r13 = r1.downloaded     // Catch:{ Exception -> 0x0465 }
            r9.setDownloaded(r13)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r13 = r1.total     // Catch:{ Exception -> 0x0465 }
            r9.setTotal(r13)     // Catch:{ Exception -> 0x0465 }
            boolean r9 = r4.getAcceptsRanges()     // Catch:{ Exception -> 0x0465 }
            java.util.List r9 = r1.getFileSliceList(r9, r3)     // Catch:{ Exception -> 0x0465 }
            r1.fileSlices = r9     // Catch:{ Exception -> 0x0465 }
            int r9 = r9.size()     // Catch:{ Exception -> 0x0465 }
            r1.totalDownloadBlocks = r9     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.Downloader<?, ?> r9 = r1.downloader     // Catch:{ Exception -> 0x00b7 }
            r9.disconnect(r4)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00c0
        L_0x00b7:
            r0 = move-exception
            r9 = r0
            com.tonyodev.fetch2core.Logger r10 = r1.logger     // Catch:{ Exception -> 0x0465 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ Exception -> 0x0465 }
            r10.e(r2, r9)     // Catch:{ Exception -> 0x0465 }
        L_0x00c0:
            java.util.List<com.tonyodev.fetch2core.FileSlice> r9 = r1.fileSlices     // Catch:{ Exception -> 0x0465 }
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ Exception -> 0x0465 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0465 }
            r10.<init>()     // Catch:{ Exception -> 0x0465 }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ Exception -> 0x0465 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0465 }
        L_0x00cf:
            boolean r13 = r9.hasNext()     // Catch:{ Exception -> 0x0465 }
            if (r13 == 0) goto L_0x00e7
            java.lang.Object r13 = r9.next()     // Catch:{ Exception -> 0x0465 }
            r14 = r13
            com.tonyodev.fetch2core.FileSlice r14 = (com.tonyodev.fetch2core.FileSlice) r14     // Catch:{ Exception -> 0x0465 }
            boolean r14 = r14.isDownloaded()     // Catch:{ Exception -> 0x0465 }
            r14 = r14 ^ r8
            if (r14 == 0) goto L_0x00cf
            r10.add(r13)     // Catch:{ Exception -> 0x0465 }
            goto L_0x00cf
        L_0x00e7:
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x0465 }
            boolean r9 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r9 != 0) goto L_0x0237
            boolean r9 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r9 != 0) goto L_0x0237
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r13 = r1.downloaded     // Catch:{ Exception -> 0x0465 }
            r9.setDownloaded(r13)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r13 = r1.total     // Catch:{ Exception -> 0x0465 }
            r9.setTotal(r13)     // Catch:{ Exception -> 0x0465 }
            java.util.List<com.tonyodev.fetch2core.FileSlice> r9 = r1.fileSlices     // Catch:{ Exception -> 0x0465 }
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ Exception -> 0x0465 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x0465 }
            int r14 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r5)     // Catch:{ Exception -> 0x0465 }
            r13.<init>(r14)     // Catch:{ Exception -> 0x0465 }
            java.util.Collection r13 = (java.util.Collection) r13     // Catch:{ Exception -> 0x0465 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0465 }
        L_0x011a:
            boolean r14 = r9.hasNext()     // Catch:{ Exception -> 0x0465 }
            if (r14 == 0) goto L_0x0154
            java.lang.Object r14 = r9.next()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.FileSlice r14 = (com.tonyodev.fetch2core.FileSlice) r14     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.DownloadBlockInfo r15 = new com.tonyodev.fetch2core.DownloadBlockInfo     // Catch:{ Exception -> 0x0465 }
            r15.<init>()     // Catch:{ Exception -> 0x0465 }
            int r11 = r14.getId()     // Catch:{ Exception -> 0x0465 }
            r15.setDownloadId(r11)     // Catch:{ Exception -> 0x0465 }
            int r11 = r14.getPosition()     // Catch:{ Exception -> 0x0465 }
            r15.setBlockPosition(r11)     // Catch:{ Exception -> 0x0465 }
            long r11 = r14.getDownloaded()     // Catch:{ Exception -> 0x0465 }
            r15.setDownloadedBytes(r11)     // Catch:{ Exception -> 0x0465 }
            long r11 = r14.getStartBytes()     // Catch:{ Exception -> 0x0465 }
            r15.setStartByte(r11)     // Catch:{ Exception -> 0x0465 }
            long r11 = r14.getEndBytes()     // Catch:{ Exception -> 0x0465 }
            r15.setEndByte(r11)     // Catch:{ Exception -> 0x0465 }
            r13.add(r15)     // Catch:{ Exception -> 0x0465 }
            r11 = 0
            goto L_0x011a
        L_0x0154:
            java.util.List r13 = (java.util.List) r13     // Catch:{ Exception -> 0x0465 }
            boolean r9 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r9 != 0) goto L_0x01ab
            boolean r9 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r9 != 0) goto L_0x01ab
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            r9.setEtaInMilliSeconds(r6)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            r9.setDownloadedBytesPerSecond(r6)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r9 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r9 == 0) goto L_0x0183
            com.tonyodev.fetch2.database.DownloadInfo r11 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r11 = (com.tonyodev.fetch2.Download) r11     // Catch:{ Exception -> 0x0465 }
            int r12 = r1.totalDownloadBlocks     // Catch:{ Exception -> 0x0465 }
            r9.onStarted(r11, r13, r12)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
        L_0x0183:
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch:{ Exception -> 0x0465 }
            java.util.Iterator r9 = r13.iterator()     // Catch:{ Exception -> 0x0465 }
        L_0x0189:
            boolean r11 = r9.hasNext()     // Catch:{ Exception -> 0x0465 }
            if (r11 == 0) goto L_0x01ab
            java.lang.Object r11 = r9.next()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.DownloadBlockInfo r11 = (com.tonyodev.fetch2core.DownloadBlockInfo) r11     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r12 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r12 == 0) goto L_0x0189
            com.tonyodev.fetch2.database.DownloadInfo r13 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r13 = (com.tonyodev.fetch2.Download) r13     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.DownloadBlock r11 = (com.tonyodev.fetch2core.DownloadBlock) r11     // Catch:{ Exception -> 0x0465 }
            int r14 = r1.totalDownloadBlocks     // Catch:{ Exception -> 0x0465 }
            r12.onDownloadBlockUpdated(r13, r11, r14)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
            goto L_0x0189
        L_0x01ab:
            r9 = r10
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ Exception -> 0x0465 }
            boolean r9 = r9.isEmpty()     // Catch:{ Exception -> 0x0465 }
            r9 = r9 ^ r8
            if (r9 == 0) goto L_0x01bf
            int r9 = r10.size()     // Catch:{ Exception -> 0x0465 }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newFixedThreadPool(r9)     // Catch:{ Exception -> 0x0465 }
            r1.executorService = r9     // Catch:{ Exception -> 0x0465 }
        L_0x01bf:
            r1.downloadSliceFiles(r3, r10)     // Catch:{ Exception -> 0x0465 }
            r17.waitAndPerformProgressReporting()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.downloaded     // Catch:{ Exception -> 0x0465 }
            r3.setDownloaded(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.total     // Catch:{ Exception -> 0x0465 }
            r3.setTotal(r9)     // Catch:{ Exception -> 0x0465 }
            goto L_0x0237
        L_0x01d8:
            if (r4 != 0) goto L_0x01f5
            boolean r3 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x01f5
            boolean r3 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x01f5
            boolean r3 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x01ed
            goto L_0x01f5
        L_0x01ed:
            com.tonyodev.fetch2.exception.FetchException r3 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x0465 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x0465 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x0465 }
            throw r3     // Catch:{ Exception -> 0x0465 }
        L_0x01f5:
            if (r4 == 0) goto L_0x021a
            boolean r3 = r4.isSuccessful()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x021a
            boolean r3 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x021a
            boolean r3 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x021a
            boolean r3 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x0210
            goto L_0x021a
        L_0x0210:
            com.tonyodev.fetch2.exception.FetchException r3 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x0465 }
            java.lang.String r9 = "request_not_successful"
            r3.<init>(r9)     // Catch:{ Exception -> 0x0465 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x0465 }
            throw r3     // Catch:{ Exception -> 0x0465 }
        L_0x021a:
            boolean r3 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x0237
            boolean r3 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x0237
            boolean r3 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x022d
            goto L_0x0237
        L_0x022d:
            com.tonyodev.fetch2.exception.FetchException r3 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x0465 }
            java.lang.String r9 = "unknown"
            r3.<init>(r9)     // Catch:{ Exception -> 0x0465 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x0465 }
            throw r3     // Catch:{ Exception -> 0x0465 }
        L_0x0237:
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.downloaded     // Catch:{ Exception -> 0x0465 }
            r3.setDownloaded(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.total     // Catch:{ Exception -> 0x0465 }
            r3.setTotal(r9)     // Catch:{ Exception -> 0x0465 }
            r17.throwExceptionIfFound()     // Catch:{ Exception -> 0x0465 }
            boolean r3 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x02a7
            boolean r3 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x02a7
            boolean r3 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x02a7
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r3 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x026f
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r9 = (com.tonyodev.fetch2.Download) r9     // Catch:{ Exception -> 0x0465 }
            r3.saveDownloadProgress(r9)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
        L_0x026f:
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.estimatedTimeRemainingInMilliseconds     // Catch:{ Exception -> 0x0465 }
            r3.setEtaInMilliSeconds(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r17.getAverageDownloadedBytesPerSecond()     // Catch:{ Exception -> 0x0465 }
            r3.setDownloadedBytesPerSecond(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r11 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r11 == 0) goto L_0x042e
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            r12 = r3
            com.tonyodev.fetch2.Download r12 = (com.tonyodev.fetch2.Download) r12     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r13 = r3.getEtaInMilliSeconds()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r15 = r3.getDownloadedBytesPerSecond()     // Catch:{ Exception -> 0x0465 }
            r11.onProgress(r12, r13, r15)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
            goto L_0x042e
        L_0x02a7:
            boolean r3 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x042e
            boolean r3 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x042e
            boolean r3 = r17.isDownloadComplete()     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x042e
            boolean r3 = r1.totalUnknown     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x02ee
            java.util.List<com.tonyodev.fetch2core.FileSlice> r3 = r1.fileSlices     // Catch:{ Exception -> 0x0465 }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ Exception -> 0x0465 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0465 }
            r11 = 0
        L_0x02c7:
            boolean r9 = r3.hasNext()     // Catch:{ Exception -> 0x0465 }
            if (r9 == 0) goto L_0x02d9
            java.lang.Object r9 = r3.next()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.FileSlice r9 = (com.tonyodev.fetch2core.FileSlice) r9     // Catch:{ Exception -> 0x0465 }
            long r9 = r9.getDownloaded()     // Catch:{ Exception -> 0x0465 }
            long r11 = r11 + r9
            goto L_0x02c7
        L_0x02d9:
            long r9 = r1.total     // Catch:{ Exception -> 0x0465 }
            int r3 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0304
            com.tonyodev.fetch2.exception.FetchException r3 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x0465 }
            java.lang.String r9 = "download_incomplete"
            r3.<init>(r9)     // Catch:{ Exception -> 0x0465 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x0465 }
            r1.throwable = r3     // Catch:{ Exception -> 0x0465 }
            r17.throwExceptionIfFound()     // Catch:{ Exception -> 0x0465 }
            goto L_0x0304
        L_0x02ee:
            long r9 = r1.downloaded     // Catch:{ Exception -> 0x0465 }
            r1.total = r9     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.downloaded     // Catch:{ Exception -> 0x0465 }
            r3.setDownloaded(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.total     // Catch:{ Exception -> 0x0465 }
            r3.setTotal(r9)     // Catch:{ Exception -> 0x0465 }
        L_0x0304:
            boolean r3 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x0321
            boolean r3 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x0321
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r3 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x0321
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r9 = (com.tonyodev.fetch2.Download) r9     // Catch:{ Exception -> 0x0465 }
            r3.saveDownloadProgress(r9)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
        L_0x0321:
            boolean r3 = r1.hashCheckingEnabled     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x03bf
            if (r4 == 0) goto L_0x03a8
            com.tonyodev.fetch2core.Downloader<?, ?> r3 = r1.downloader     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2core.Downloader$ServerRequest r9 = r4.getRequest()     // Catch:{ Exception -> 0x0465 }
            java.lang.String r10 = r4.getHash()     // Catch:{ Exception -> 0x0465 }
            boolean r3 = r3.verifyContentHash(r9, r10)     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x03a8
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            int r3 = r3.getId()     // Catch:{ Exception -> 0x0465 }
            java.lang.String r9 = r1.fileTempDir     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.util.FetchUtils.deleteAllInFolderForId(r3, r9)     // Catch:{ Exception -> 0x0465 }
            boolean r3 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x042e
            boolean r3 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x042e
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.estimatedTimeRemainingInMilliseconds     // Catch:{ Exception -> 0x0465 }
            r3.setEtaInMilliSeconds(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r17.getAverageDownloadedBytesPerSecond()     // Catch:{ Exception -> 0x0465 }
            r3.setDownloadedBytesPerSecond(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r3 = r3.copy()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r9 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r9 == 0) goto L_0x038d
            com.tonyodev.fetch2.database.DownloadInfo r10 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r10 = (com.tonyodev.fetch2.Download) r10     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r11 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r11 = r11.getEtaInMilliSeconds()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r13 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r13 = r13.getDownloadedBytesPerSecond()     // Catch:{ Exception -> 0x0465 }
            r9.onProgress(r10, r11, r13)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
        L_0x038d:
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            r9.setEtaInMilliSeconds(r6)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            r9.setDownloadedBytesPerSecond(r6)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r9 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r9 == 0) goto L_0x042e
            r9.onComplete(r3)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
            goto L_0x042e
        L_0x03a8:
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            int r3 = r3.getId()     // Catch:{ Exception -> 0x0465 }
            java.lang.String r9 = r1.fileTempDir     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.util.FetchUtils.deleteAllInFolderForId(r3, r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.exception.FetchException r3 = new com.tonyodev.fetch2.exception.FetchException     // Catch:{ Exception -> 0x0465 }
            java.lang.String r9 = "invalid content hash"
            r3.<init>(r9)     // Catch:{ Exception -> 0x0465 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x0465 }
            throw r3     // Catch:{ Exception -> 0x0465 }
        L_0x03bf:
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            int r3 = r3.getId()     // Catch:{ Exception -> 0x0465 }
            java.lang.String r9 = r1.fileTempDir     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.util.FetchUtils.deleteAllInFolderForId(r3, r9)     // Catch:{ Exception -> 0x0465 }
            boolean r3 = r17.getInterrupted()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x042e
            boolean r3 = r17.getTerminated()     // Catch:{ Exception -> 0x0465 }
            if (r3 != 0) goto L_0x042e
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r1.estimatedTimeRemainingInMilliseconds     // Catch:{ Exception -> 0x0465 }
            r3.setEtaInMilliSeconds(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r9 = r17.getAverageDownloadedBytesPerSecond()     // Catch:{ Exception -> 0x0465 }
            r3.setDownloadedBytesPerSecond(r9)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r3 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r3 = r3.copy()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r9 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r9 == 0) goto L_0x0415
            com.tonyodev.fetch2.database.DownloadInfo r10 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.Download r10 = (com.tonyodev.fetch2.Download) r10     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r11 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r11 = r11.getEtaInMilliSeconds()     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r13 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            long r13 = r13.getDownloadedBytesPerSecond()     // Catch:{ Exception -> 0x0465 }
            r9.onProgress(r10, r11, r13)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
        L_0x0415:
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            r9.setEtaInMilliSeconds(r6)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.database.DownloadInfo r9 = r17.getDownloadInfo()     // Catch:{ Exception -> 0x0465 }
            r9.setDownloadedBytesPerSecond(r6)     // Catch:{ Exception -> 0x0465 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r9 = r17.getDelegate()     // Catch:{ Exception -> 0x0465 }
            if (r9 == 0) goto L_0x042e
            r9.onComplete(r3)     // Catch:{ Exception -> 0x0465 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0465 }
        L_0x042e:
            java.util.concurrent.ExecutorService r3 = r1.executorService     // Catch:{ Exception -> 0x0438 }
            if (r3 == 0) goto L_0x0441
            r3.shutdown()     // Catch:{ Exception -> 0x0438 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0438 }
            goto L_0x0441
        L_0x0438:
            r0 = move-exception
            r3 = r0
            com.tonyodev.fetch2core.Logger r5 = r1.logger
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r5.e(r2, r3)
        L_0x0441:
            com.tonyodev.fetch2core.OutputResourceWrapper r3 = r1.outputResourceWrapper     // Catch:{ Exception -> 0x044b }
            if (r3 == 0) goto L_0x0454
            r3.close()     // Catch:{ Exception -> 0x044b }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x044b }
            goto L_0x0454
        L_0x044b:
            r0 = move-exception
            r3 = r0
            com.tonyodev.fetch2core.Logger r5 = r1.logger
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r5.e(r2, r3)
        L_0x0454:
            if (r4 == 0) goto L_0x0552
            com.tonyodev.fetch2core.Downloader<?, ?> r3 = r1.downloader     // Catch:{ Exception -> 0x045d }
            r3.disconnect(r4)     // Catch:{ Exception -> 0x045d }
            goto L_0x0552
        L_0x045d:
            r0 = move-exception
            r3 = r0
            goto L_0x054b
        L_0x0461:
            r0 = move-exception
            r3 = r0
            goto L_0x0556
        L_0x0465:
            r0 = move-exception
            r3 = r0
            boolean r9 = r17.getInterrupted()     // Catch:{ all -> 0x0461 }
            if (r9 != 0) goto L_0x051b
            boolean r9 = r17.getTerminated()     // Catch:{ all -> 0x0461 }
            if (r9 != 0) goto L_0x051b
            com.tonyodev.fetch2core.Logger r9 = r1.logger     // Catch:{ all -> 0x0461 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0461 }
            r10.<init>()     // Catch:{ all -> 0x0461 }
            java.lang.String r11 = "FileDownloader download:"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x0461 }
            com.tonyodev.fetch2.Download r11 = r17.getDownload()     // Catch:{ all -> 0x0461 }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x0461 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0461 }
            r11 = r3
            java.lang.Throwable r11 = (java.lang.Throwable) r11     // Catch:{ all -> 0x0461 }
            r9.e(r10, r11)     // Catch:{ all -> 0x0461 }
            r9 = r3
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x0461 }
            com.tonyodev.fetch2.Error r9 = com.tonyodev.fetch2.FetchErrorUtils.getErrorFromThrowable(r9)     // Catch:{ all -> 0x0461 }
            r10 = r3
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ all -> 0x0461 }
            r9.setThrowable(r10)     // Catch:{ all -> 0x0461 }
            if (r4 == 0) goto L_0x04a8
            com.tonyodev.fetch2core.Downloader$Response r10 = com.tonyodev.fetch2core.FetchCoreUtils.copyDownloadResponseNoStream(r4)     // Catch:{ all -> 0x0461 }
            r9.setHttpResponse(r10)     // Catch:{ all -> 0x0461 }
        L_0x04a8:
            boolean r10 = r1.retryOnNetworkGain     // Catch:{ all -> 0x0461 }
            if (r10 == 0) goto L_0x04d5
            com.tonyodev.fetch2.provider.NetworkInfoProvider r10 = r1.networkInfoProvider     // Catch:{ all -> 0x0461 }
            boolean r10 = r10.isNetworkAvailable()     // Catch:{ all -> 0x0461 }
            r10 = r10 ^ r8
            r11 = r8
        L_0x04b4:
            if (r11 > r5) goto L_0x04d1
            r12 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r12)     // Catch:{ InterruptedException -> 0x04c8 }
            com.tonyodev.fetch2.provider.NetworkInfoProvider r12 = r1.networkInfoProvider     // Catch:{ all -> 0x0461 }
            boolean r12 = r12.isNetworkAvailable()     // Catch:{ all -> 0x0461 }
            if (r12 != 0) goto L_0x04c5
            r10 = r8
            goto L_0x04d1
        L_0x04c5:
            int r11 = r11 + 1
            goto L_0x04b4
        L_0x04c8:
            r0 = move-exception
            r5 = r0
            com.tonyodev.fetch2core.Logger r11 = r1.logger     // Catch:{ all -> 0x0461 }
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x0461 }
            r11.e(r2, r5)     // Catch:{ all -> 0x0461 }
        L_0x04d1:
            if (r10 == 0) goto L_0x04d5
            com.tonyodev.fetch2.Error r9 = com.tonyodev.fetch2.Error.NO_NETWORK_CONNECTION     // Catch:{ all -> 0x0461 }
        L_0x04d5:
            com.tonyodev.fetch2.database.DownloadInfo r5 = r17.getDownloadInfo()     // Catch:{ all -> 0x0461 }
            long r10 = r1.downloaded     // Catch:{ all -> 0x0461 }
            r5.setDownloaded(r10)     // Catch:{ all -> 0x0461 }
            com.tonyodev.fetch2.database.DownloadInfo r5 = r17.getDownloadInfo()     // Catch:{ all -> 0x0461 }
            long r10 = r1.total     // Catch:{ all -> 0x0461 }
            r5.setTotal(r10)     // Catch:{ all -> 0x0461 }
            com.tonyodev.fetch2.database.DownloadInfo r5 = r17.getDownloadInfo()     // Catch:{ all -> 0x0461 }
            r5.setError(r9)     // Catch:{ all -> 0x0461 }
            boolean r5 = r17.getTerminated()     // Catch:{ all -> 0x0461 }
            if (r5 != 0) goto L_0x051b
            boolean r5 = r17.getInterrupted()     // Catch:{ all -> 0x0461 }
            if (r5 != 0) goto L_0x051b
            com.tonyodev.fetch2.database.DownloadInfo r5 = r17.getDownloadInfo()     // Catch:{ all -> 0x0461 }
            r5.setEtaInMilliSeconds(r6)     // Catch:{ all -> 0x0461 }
            com.tonyodev.fetch2.database.DownloadInfo r5 = r17.getDownloadInfo()     // Catch:{ all -> 0x0461 }
            r5.setDownloadedBytesPerSecond(r6)     // Catch:{ all -> 0x0461 }
            com.tonyodev.fetch2.downloader.FileDownloader$Delegate r5 = r17.getDelegate()     // Catch:{ all -> 0x0461 }
            if (r5 == 0) goto L_0x051b
            com.tonyodev.fetch2.database.DownloadInfo r6 = r17.getDownloadInfo()     // Catch:{ all -> 0x0461 }
            com.tonyodev.fetch2.Download r6 = (com.tonyodev.fetch2.Download) r6     // Catch:{ all -> 0x0461 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x0461 }
            r5.onError(r6, r9, r3)     // Catch:{ all -> 0x0461 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0461 }
        L_0x051b:
            java.util.concurrent.ExecutorService r3 = r1.executorService     // Catch:{ Exception -> 0x0525 }
            if (r3 == 0) goto L_0x052e
            r3.shutdown()     // Catch:{ Exception -> 0x0525 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0525 }
            goto L_0x052e
        L_0x0525:
            r0 = move-exception
            r3 = r0
            com.tonyodev.fetch2core.Logger r5 = r1.logger
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r5.e(r2, r3)
        L_0x052e:
            com.tonyodev.fetch2core.OutputResourceWrapper r3 = r1.outputResourceWrapper     // Catch:{ Exception -> 0x0538 }
            if (r3 == 0) goto L_0x0541
            r3.close()     // Catch:{ Exception -> 0x0538 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0538 }
            goto L_0x0541
        L_0x0538:
            r0 = move-exception
            r3 = r0
            com.tonyodev.fetch2core.Logger r5 = r1.logger
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r5.e(r2, r3)
        L_0x0541:
            if (r4 == 0) goto L_0x0552
            com.tonyodev.fetch2core.Downloader<?, ?> r3 = r1.downloader     // Catch:{ Exception -> 0x0549 }
            r3.disconnect(r4)     // Catch:{ Exception -> 0x0549 }
            goto L_0x0552
        L_0x0549:
            r0 = move-exception
            r3 = r0
        L_0x054b:
            com.tonyodev.fetch2core.Logger r4 = r1.logger
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r4.e(r2, r3)
        L_0x0552:
            r1.setTerminated(r8)
            return
        L_0x0556:
            java.util.concurrent.ExecutorService r5 = r1.executorService     // Catch:{ Exception -> 0x0560 }
            if (r5 == 0) goto L_0x0569
            r5.shutdown()     // Catch:{ Exception -> 0x0560 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0560 }
            goto L_0x0569
        L_0x0560:
            r0 = move-exception
            r5 = r0
            com.tonyodev.fetch2core.Logger r6 = r1.logger
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.e(r2, r5)
        L_0x0569:
            com.tonyodev.fetch2core.OutputResourceWrapper r5 = r1.outputResourceWrapper     // Catch:{ Exception -> 0x0573 }
            if (r5 == 0) goto L_0x057c
            r5.close()     // Catch:{ Exception -> 0x0573 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0573 }
            goto L_0x057c
        L_0x0573:
            r0 = move-exception
            r5 = r0
            com.tonyodev.fetch2core.Logger r6 = r1.logger
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.e(r2, r5)
        L_0x057c:
            if (r4 == 0) goto L_0x058d
            com.tonyodev.fetch2core.Downloader<?, ?> r5 = r1.downloader     // Catch:{ Exception -> 0x0584 }
            r5.disconnect(r4)     // Catch:{ Exception -> 0x0584 }
            goto L_0x058d
        L_0x0584:
            r0 = move-exception
            r4 = r0
            com.tonyodev.fetch2core.Logger r5 = r1.logger
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r5.e(r2, r4)
        L_0x058d:
            r1.setTerminated(r8)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.downloader.ParallelFileDownloaderImpl.run():void");
    }

    private final List<FileSlice> getFileSliceList(boolean z, Downloader.ServerRequest serverRequest) {
        if (!this.storageResolver.fileExists(getDownloadInfo().getFile())) {
            FetchUtils.deleteAllInFolderForId(getDownloadInfo().getId(), this.fileTempDir);
        }
        int previousSliceCount = FetchUtils.getPreviousSliceCount(getDownloadInfo().getId(), this.fileTempDir);
        int i = 1;
        if (!z || this.totalUnknown) {
            if (previousSliceCount != 1) {
                FetchUtils.deleteAllInFolderForId(getDownloadInfo().getId(), this.fileTempDir);
            }
            FetchUtils.saveCurrentSliceCount(getDownloadInfo().getId(), 1, this.fileTempDir);
            FileSlice fileSlice = new FileSlice(getDownloadInfo().getId(), 1, 0, this.total, FetchUtils.getSavedDownloadedInfo(getDownloadInfo().getId(), 1, this.fileTempDir));
            this.downloaded += fileSlice.getDownloaded();
            return CollectionsKt.listOf(fileSlice);
        }
        FileSliceInfo chuckInfo = getChuckInfo(serverRequest);
        if (previousSliceCount != chuckInfo.getSlicingCount()) {
            FetchUtils.deleteAllInFolderForId(getDownloadInfo().getId(), this.fileTempDir);
        }
        FetchUtils.saveCurrentSliceCount(getDownloadInfo().getId(), chuckInfo.getSlicingCount(), this.fileTempDir);
        long j = 0;
        List<FileSlice> arrayList = new ArrayList<>();
        int slicingCount = chuckInfo.getSlicingCount();
        if (1 > slicingCount) {
            return arrayList;
        }
        while (true) {
            long j2 = j;
            if (getInterrupted() || getTerminated()) {
                return arrayList;
            }
            if (chuckInfo.getSlicingCount() == i) {
                j = this.total;
            } else {
                j = chuckInfo.getBytesPerFileSlice() + j2;
            }
            FileSlice fileSlice2 = r7;
            FileSlice fileSlice3 = new FileSlice(getDownloadInfo().getId(), i, j2, j, FetchUtils.getSavedDownloadedInfo(getDownloadInfo().getId(), i, this.fileTempDir));
            this.downloaded += fileSlice2.getDownloaded();
            arrayList.add(fileSlice2);
            if (i == slicingCount) {
                return arrayList;
            }
            i++;
        }
    }

    private final FileSliceInfo getChuckInfo(Downloader.ServerRequest serverRequest) {
        Integer fileSlicingCount = this.downloader.getFileSlicingCount(serverRequest, this.total);
        return FetchUtils.getFileSliceInfo(fileSlicingCount != null ? fileSlicingCount.intValue() : -1, this.total);
    }

    private final long getAverageDownloadedBytesPerSecond() {
        double d = this.averageDownloadedBytesPerSecond;
        if (d < ((double) 1)) {
            return 0;
        }
        return (long) Math.ceil(d);
    }

    private final void waitAndPerformProgressReporting() {
        long j = this.downloaded;
        long nanoTime = System.nanoTime();
        long nanoTime2 = System.nanoTime();
        while (this.actionsCounter != this.actionsTotal && !getInterrupted() && !getTerminated()) {
            getDownloadInfo().setDownloaded(this.downloaded);
            getDownloadInfo().setTotal(this.total);
            boolean hasIntervalTimeElapsed = FetchCoreUtils.hasIntervalTimeElapsed(nanoTime2, System.nanoTime(), 1000);
            if (hasIntervalTimeElapsed) {
                this.movingAverageCalculator.add((double) (this.downloaded - j));
                this.averageDownloadedBytesPerSecond = AverageCalculator.getMovingAverageWithWeightOnRecentValues$default(this.movingAverageCalculator, 0, 1, (Object) null);
                this.estimatedTimeRemainingInMilliseconds = FetchCoreUtils.calculateEstimatedTimeRemainingInMilliseconds(this.downloaded, this.total, getAverageDownloadedBytesPerSecond());
                j = this.downloaded;
            }
            if (FetchCoreUtils.hasIntervalTimeElapsed(nanoTime, System.nanoTime(), this.progressReportingIntervalMillis)) {
                synchronized (this.lock) {
                    if (!getInterrupted() && !getTerminated()) {
                        getDownloadInfo().setDownloaded(this.downloaded);
                        getDownloadInfo().setTotal(this.total);
                        FileDownloader.Delegate delegate2 = getDelegate();
                        if (delegate2 != null) {
                            delegate2.saveDownloadProgress(getDownloadInfo());
                        }
                        getDownloadInfo().setEtaInMilliSeconds(this.estimatedTimeRemainingInMilliseconds);
                        getDownloadInfo().setDownloadedBytesPerSecond(getAverageDownloadedBytesPerSecond());
                        FileDownloader.Delegate delegate3 = getDelegate();
                        if (delegate3 != null) {
                            delegate3.onProgress(getDownloadInfo(), getDownloadInfo().getEtaInMilliSeconds(), getDownloadInfo().getDownloadedBytesPerSecond());
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                nanoTime = System.nanoTime();
            }
            if (hasIntervalTimeElapsed) {
                nanoTime2 = System.nanoTime();
            }
            try {
                Thread.sleep(this.progressReportingIntervalMillis);
            } catch (InterruptedException e) {
                this.logger.e("FileDownloader", e);
            }
        }
    }

    private final void downloadSliceFiles(Downloader.ServerRequest serverRequest, List<FileSlice> list) {
        boolean z = false;
        this.actionsCounter = 0;
        this.actionsTotal = list.size();
        if (!this.storageResolver.fileExists(serverRequest.getFile())) {
            StorageResolver storageResolver2 = this.storageResolver;
            String file = serverRequest.getFile();
            if (this.initialDownload.getEnqueueAction() == EnqueueAction.INCREMENT_FILE_NAME) {
                z = true;
            }
            storageResolver2.createFile(file, z);
        }
        if (this.preAllocateFileOnCreation) {
            this.storageResolver.preAllocateFile(serverRequest.getFile(), getDownloadInfo().getTotal());
        }
        OutputResourceWrapper requestOutputResourceWrapper = this.storageResolver.getRequestOutputResourceWrapper(serverRequest);
        this.outputResourceWrapper = requestOutputResourceWrapper;
        if (requestOutputResourceWrapper != null) {
            requestOutputResourceWrapper.setWriteOffset(0);
        }
        for (FileSlice next : list) {
            if (!getInterrupted() && !getTerminated()) {
                ExecutorService executorService2 = this.executorService;
                if (executorService2 != null) {
                    executorService2.execute(new ParallelFileDownloaderImpl$downloadSliceFiles$1(this, next));
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void incrementActionCompletedCount() {
        synchronized (this.lock) {
            this.actionsCounter++;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean isDownloadComplete() {
        return ((this.downloaded > 0 && this.total > 0) || this.totalUnknown) && this.downloaded >= this.total;
    }

    private final void setIsTotalUnknown(Downloader.Response response) {
        if (response.isSuccessful() && response.getContentLength() == -1) {
            this.totalUnknown = true;
        }
    }

    private final void throwExceptionIfFound() {
        Throwable th = this.throwable;
        if (th != null) {
            throw th;
        }
    }
}
