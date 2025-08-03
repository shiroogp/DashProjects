package com.tonyodev.fetch2.downloader;

import android.content.Context;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.downloader.FileDownloader;
import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2.fetch.ListenerCoordinator;
import com.tonyodev.fetch2.helper.DownloadInfoUpdater;
import com.tonyodev.fetch2.helper.FileDownloaderDelegate;
import com.tonyodev.fetch2.provider.GroupInfoProvider;
import com.tonyodev.fetch2.provider.NetworkInfoProvider;
import com.tonyodev.fetch2.util.FetchUtils;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.FileServerDownloader;
import com.tonyodev.fetch2core.Logger;
import com.tonyodev.fetch2core.StorageResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\r¢\u0006\u0002\u0010!J\b\u00103\u001a\u00020\rH\u0016J\u0010\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000207H\u0002J\u0010\u00109\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0005H\u0002J\b\u0010:\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0016J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050>H\u0016J\u0010\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020?H\u0016J \u0010C\u001a\u00020*2\u0006\u0010B\u001a\u00020?2\u000e\u0010D\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0002J\b\u0010E\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010.2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010H\u001a\u00020*2\u0006\u0010B\u001a\u00020?H\u0016J\u0010\u0010I\u001a\u0002072\u0006\u0010B\u001a\u00020?H\u0002J\u0010\u0010J\u001a\u00020\r2\u0006\u0010B\u001a\u00020?H\u0016J\b\u0010K\u001a\u000207H\u0002J\b\u0010L\u001a\u000207H\u0002R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R.\u0010(\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010*0)j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010*`+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/tonyodev/fetch2/downloader/DownloadManagerImpl;", "Lcom/tonyodev/fetch2/downloader/DownloadManager;", "httpDownloader", "Lcom/tonyodev/fetch2core/Downloader;", "concurrentLimit", "", "progressReportingIntervalMillis", "", "logger", "Lcom/tonyodev/fetch2core/Logger;", "networkInfoProvider", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "retryOnNetworkGain", "", "downloadInfoUpdater", "Lcom/tonyodev/fetch2/helper/DownloadInfoUpdater;", "downloadManagerCoordinator", "Lcom/tonyodev/fetch2/downloader/DownloadManagerCoordinator;", "listenerCoordinator", "Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "fileServerDownloader", "Lcom/tonyodev/fetch2core/FileServerDownloader;", "hashCheckingEnabled", "storageResolver", "Lcom/tonyodev/fetch2core/StorageResolver;", "context", "Landroid/content/Context;", "namespace", "", "groupInfoProvider", "Lcom/tonyodev/fetch2/provider/GroupInfoProvider;", "globalAutoRetryMaxAttempts", "preAllocateFileOnCreation", "(Lcom/tonyodev/fetch2core/Downloader;IJLcom/tonyodev/fetch2core/Logger;Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;ZLcom/tonyodev/fetch2/helper/DownloadInfoUpdater;Lcom/tonyodev/fetch2/downloader/DownloadManagerCoordinator;Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;Lcom/tonyodev/fetch2core/FileServerDownloader;ZLcom/tonyodev/fetch2core/StorageResolver;Landroid/content/Context;Ljava/lang/String;Lcom/tonyodev/fetch2/provider/GroupInfoProvider;IZ)V", "closed", "value", "getConcurrentLimit", "()I", "setConcurrentLimit", "(I)V", "currentDownloadsMap", "Ljava/util/HashMap;", "Lcom/tonyodev/fetch2/downloader/FileDownloader;", "Lkotlin/collections/HashMap;", "downloadCounter", "executor", "Ljava/util/concurrent/ExecutorService;", "isClosed", "()Z", "lock", "", "canAccommodateNewDownload", "cancel", "downloadId", "cancelAll", "", "cancelAllDownloads", "cancelDownloadNoLock", "close", "contains", "getActiveDownloadCount", "getActiveDownloads", "", "Lcom/tonyodev/fetch2/Download;", "getActiveDownloadsIds", "getDownloadFileTempDir", "download", "getFileDownloader", "downloader", "getFileDownloaderDelegate", "Lcom/tonyodev/fetch2/downloader/FileDownloader$Delegate;", "getNewDownloadExecutorService", "getNewFileDownloaderForDownload", "removeDownloadMappings", "start", "terminateAllDownloads", "throwExceptionIfClosed", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadManagerImpl.kt */
public final class DownloadManagerImpl implements DownloadManager {
    private volatile boolean closed;
    private volatile int concurrentLimit;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final HashMap<Integer, FileDownloader> currentDownloadsMap;
    private volatile int downloadCounter;
    private final DownloadInfoUpdater downloadInfoUpdater;
    /* access modifiers changed from: private */
    public final DownloadManagerCoordinator downloadManagerCoordinator;
    private ExecutorService executor;
    private final FileServerDownloader fileServerDownloader;
    private final int globalAutoRetryMaxAttempts;
    /* access modifiers changed from: private */
    public final GroupInfoProvider groupInfoProvider;
    private final boolean hashCheckingEnabled;
    private final Downloader<?, ?> httpDownloader;
    private final ListenerCoordinator listenerCoordinator;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Logger logger;
    /* access modifiers changed from: private */
    public final String namespace;
    private final NetworkInfoProvider networkInfoProvider;
    private final boolean preAllocateFileOnCreation;
    private final long progressReportingIntervalMillis;
    private final boolean retryOnNetworkGain;
    private final StorageResolver storageResolver;

    public DownloadManagerImpl(Downloader<?, ?> downloader, int i, long j, Logger logger2, NetworkInfoProvider networkInfoProvider2, boolean z, DownloadInfoUpdater downloadInfoUpdater2, DownloadManagerCoordinator downloadManagerCoordinator2, ListenerCoordinator listenerCoordinator2, FileServerDownloader fileServerDownloader2, boolean z2, StorageResolver storageResolver2, Context context2, String str, GroupInfoProvider groupInfoProvider2, int i2, boolean z3) {
        Downloader<?, ?> downloader2 = downloader;
        int i3 = i;
        Logger logger3 = logger2;
        NetworkInfoProvider networkInfoProvider3 = networkInfoProvider2;
        DownloadInfoUpdater downloadInfoUpdater3 = downloadInfoUpdater2;
        DownloadManagerCoordinator downloadManagerCoordinator3 = downloadManagerCoordinator2;
        ListenerCoordinator listenerCoordinator3 = listenerCoordinator2;
        FileServerDownloader fileServerDownloader3 = fileServerDownloader2;
        StorageResolver storageResolver3 = storageResolver2;
        Context context3 = context2;
        String str2 = str;
        GroupInfoProvider groupInfoProvider3 = groupInfoProvider2;
        Intrinsics.checkParameterIsNotNull(downloader2, "httpDownloader");
        Intrinsics.checkParameterIsNotNull(logger3, "logger");
        Intrinsics.checkParameterIsNotNull(networkInfoProvider3, "networkInfoProvider");
        Intrinsics.checkParameterIsNotNull(downloadInfoUpdater3, "downloadInfoUpdater");
        Intrinsics.checkParameterIsNotNull(downloadManagerCoordinator3, "downloadManagerCoordinator");
        Intrinsics.checkParameterIsNotNull(listenerCoordinator3, "listenerCoordinator");
        Intrinsics.checkParameterIsNotNull(fileServerDownloader3, "fileServerDownloader");
        Intrinsics.checkParameterIsNotNull(storageResolver3, "storageResolver");
        Intrinsics.checkParameterIsNotNull(context3, "context");
        Intrinsics.checkParameterIsNotNull(str2, "namespace");
        Intrinsics.checkParameterIsNotNull(groupInfoProvider3, "groupInfoProvider");
        this.httpDownloader = downloader2;
        this.progressReportingIntervalMillis = j;
        this.logger = logger3;
        this.networkInfoProvider = networkInfoProvider3;
        this.retryOnNetworkGain = z;
        this.downloadInfoUpdater = downloadInfoUpdater3;
        this.downloadManagerCoordinator = downloadManagerCoordinator3;
        this.listenerCoordinator = listenerCoordinator3;
        this.fileServerDownloader = fileServerDownloader3;
        this.hashCheckingEnabled = z2;
        this.storageResolver = storageResolver3;
        this.context = context3;
        this.namespace = str2;
        this.groupInfoProvider = groupInfoProvider3;
        this.globalAutoRetryMaxAttempts = i2;
        this.preAllocateFileOnCreation = z3;
        this.executor = getNewDownloadExecutorService(i3);
        this.concurrentLimit = i3;
        this.currentDownloadsMap = new HashMap<>();
    }

    public int getConcurrentLimit() {
        return this.concurrentLimit;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:2|3|(2:6|4)|8|9|(1:11)|12|13|14) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0023 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027 A[Catch:{ Exception -> 0x002a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setConcurrentLimit(int r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            java.util.List r1 = r4.getActiveDownloadsIds()     // Catch:{ Exception -> 0x0023 }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x0023 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0023 }
        L_0x000d:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0023 }
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0023 }
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ Exception -> 0x0023 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0023 }
            r4.cancelDownloadNoLock(r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x000d
        L_0x0021:
            r5 = move-exception
            goto L_0x005a
        L_0x0023:
            java.util.concurrent.ExecutorService r1 = r4.executor     // Catch:{ Exception -> 0x002a }
            if (r1 == 0) goto L_0x002a
            r1.shutdown()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            java.util.concurrent.ExecutorService r1 = r4.getNewDownloadExecutorService(r5)     // Catch:{ all -> 0x0021 }
            r4.executor = r1     // Catch:{ all -> 0x0021 }
            r4.concurrentLimit = r5     // Catch:{ all -> 0x0021 }
            com.tonyodev.fetch2core.Logger r1 = r4.logger     // Catch:{ all -> 0x0021 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
            r2.<init>()     // Catch:{ all -> 0x0021 }
            java.lang.String r3 = "DownloadManager concurrentLimit changed from "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0021 }
            int r3 = r4.concurrentLimit     // Catch:{ all -> 0x0021 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0021 }
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0021 }
            java.lang.StringBuilder r5 = r2.append(r5)     // Catch:{ all -> 0x0021 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0021 }
            r1.d(r5)     // Catch:{ all -> 0x0021 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)
            return
        L_0x005a:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.downloader.DownloadManagerImpl.setConcurrentLimit(int):void");
    }

    public boolean isClosed() {
        return this.closed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean start(com.tonyodev.fetch2.Download r7) {
        /*
            r6 = this;
            java.lang.String r0 = "download"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r6.throwExceptionIfClosed()     // Catch:{ all -> 0x009b }
            java.util.HashMap<java.lang.Integer, com.tonyodev.fetch2.downloader.FileDownloader> r1 = r6.currentDownloadsMap     // Catch:{ all -> 0x009b }
            int r2 = r7.getId()     // Catch:{ all -> 0x009b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x009b }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x009b }
            r2 = 0
            if (r1 == 0) goto L_0x0036
            com.tonyodev.fetch2core.Logger r1 = r6.logger     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r3.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r4 = "DownloadManager already running download "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r7 = r3.append(r7)     // Catch:{ all -> 0x009b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x009b }
            r1.d(r7)     // Catch:{ all -> 0x009b }
            monitor-exit(r0)
            return r2
        L_0x0036:
            int r1 = r6.downloadCounter     // Catch:{ all -> 0x009b }
            int r3 = r6.getConcurrentLimit()     // Catch:{ all -> 0x009b }
            if (r1 < r3) goto L_0x0064
            com.tonyodev.fetch2core.Logger r1 = r6.logger     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r3.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r4 = "DownloadManager cannot init download "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r7 = r3.append(r7)     // Catch:{ all -> 0x009b }
            java.lang.String r3 = " because "
            java.lang.StringBuilder r7 = r7.append(r3)     // Catch:{ all -> 0x009b }
            java.lang.String r3 = "the download queue is full"
            java.lang.StringBuilder r7 = r7.append(r3)     // Catch:{ all -> 0x009b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x009b }
            r1.d(r7)     // Catch:{ all -> 0x009b }
            monitor-exit(r0)
            return r2
        L_0x0064:
            int r1 = r6.downloadCounter     // Catch:{ all -> 0x009b }
            r3 = 1
            int r1 = r1 + r3
            r6.downloadCounter = r1     // Catch:{ all -> 0x009b }
            java.util.HashMap<java.lang.Integer, com.tonyodev.fetch2.downloader.FileDownloader> r1 = r6.currentDownloadsMap     // Catch:{ all -> 0x009b }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x009b }
            int r4 = r7.getId()     // Catch:{ all -> 0x009b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x009b }
            r5 = 0
            r1.put(r4, r5)     // Catch:{ all -> 0x009b }
            com.tonyodev.fetch2.downloader.DownloadManagerCoordinator r1 = r6.downloadManagerCoordinator     // Catch:{ all -> 0x009b }
            int r4 = r7.getId()     // Catch:{ all -> 0x009b }
            r1.addFileDownloader(r4, r5)     // Catch:{ all -> 0x009b }
            java.util.concurrent.ExecutorService r1 = r6.executor     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0099
            boolean r4 = r1.isShutdown()     // Catch:{ all -> 0x009b }
            if (r4 != 0) goto L_0x0099
            com.tonyodev.fetch2.downloader.DownloadManagerImpl$start$$inlined$synchronized$lambda$1 r2 = new com.tonyodev.fetch2.downloader.DownloadManagerImpl$start$$inlined$synchronized$lambda$1     // Catch:{ all -> 0x009b }
            r2.<init>(r6, r7)     // Catch:{ all -> 0x009b }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x009b }
            r1.execute(r2)     // Catch:{ all -> 0x009b }
            monitor-exit(r0)
            return r3
        L_0x0099:
            monitor-exit(r0)
            return r2
        L_0x009b:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.downloader.DownloadManagerImpl.start(com.tonyodev.fetch2.Download):boolean");
    }

    /* access modifiers changed from: private */
    public final void removeDownloadMappings(Download download) {
        synchronized (this.lock) {
            if (this.currentDownloadsMap.containsKey(Integer.valueOf(download.getId()))) {
                this.currentDownloadsMap.remove(Integer.valueOf(download.getId()));
                this.downloadCounter--;
            }
            this.downloadManagerCoordinator.removeFileDownloader(download.getId());
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean cancel(int i) {
        boolean cancelDownloadNoLock;
        synchronized (this.lock) {
            cancelDownloadNoLock = cancelDownloadNoLock(i);
        }
        return cancelDownloadNoLock;
    }

    private final boolean cancelDownloadNoLock(int i) {
        throwExceptionIfClosed();
        FileDownloader fileDownloader = this.currentDownloadsMap.get(Integer.valueOf(i));
        if (fileDownloader != null) {
            fileDownloader.setInterrupted(true);
            this.currentDownloadsMap.remove(Integer.valueOf(i));
            this.downloadCounter--;
            this.downloadManagerCoordinator.removeFileDownloader(i);
            this.logger.d("DownloadManager cancelled download " + fileDownloader.getDownload());
            return fileDownloader.getInterrupted();
        }
        this.downloadManagerCoordinator.interruptDownload(i);
        return false;
    }

    public void cancelAll() {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            cancelAllDownloads();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void cancelAllDownloads() {
        if (getConcurrentLimit() > 0) {
            for (FileDownloader next : this.downloadManagerCoordinator.getFileDownloaderList()) {
                if (next != null) {
                    next.setInterrupted(true);
                    this.downloadManagerCoordinator.removeFileDownloader(next.getDownload().getId());
                    this.logger.d("DownloadManager cancelled download " + next.getDownload());
                }
            }
        }
        this.currentDownloadsMap.clear();
        this.downloadCounter = 0;
    }

    private final void terminateAllDownloads() {
        for (Map.Entry entry : this.currentDownloadsMap.entrySet()) {
            FileDownloader fileDownloader = (FileDownloader) entry.getValue();
            if (fileDownloader != null) {
                fileDownloader.setTerminated(true);
                this.logger.d("DownloadManager terminated download " + fileDownloader.getDownload());
                this.downloadManagerCoordinator.removeFileDownloader(((Number) entry.getKey()).intValue());
            }
        }
        this.currentDownloadsMap.clear();
        this.downloadCounter = 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            boolean r1 = r3.closed     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 1
            r3.closed = r1     // Catch:{ all -> 0x002a }
            int r1 = r3.getConcurrentLimit()     // Catch:{ all -> 0x002a }
            if (r1 <= 0) goto L_0x0015
            r3.terminateAllDownloads()     // Catch:{ all -> 0x002a }
        L_0x0015:
            com.tonyodev.fetch2core.Logger r1 = r3.logger     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "DownloadManager closing download manager"
            r1.d(r2)     // Catch:{ all -> 0x002a }
            java.util.concurrent.ExecutorService r1 = r3.executor     // Catch:{ Exception -> 0x0026 }
            if (r1 == 0) goto L_0x0028
            r1.shutdown()     // Catch:{ Exception -> 0x0026 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002a }
        L_0x0028:
            monitor-exit(r0)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.downloader.DownloadManagerImpl.close():void");
    }

    public boolean contains(int i) {
        boolean z;
        synchronized (this.lock) {
            z = !isClosed() && this.downloadManagerCoordinator.containsFileDownloader(i);
        }
        return z;
    }

    public boolean canAccommodateNewDownload() {
        boolean z;
        synchronized (this.lock) {
            z = !this.closed && this.downloadCounter < getConcurrentLimit();
        }
        return z;
    }

    public int getActiveDownloadCount() {
        int i;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            i = this.downloadCounter;
        }
        return i;
    }

    public List<Download> getActiveDownloads() {
        List<Download> list;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            Collection<FileDownloader> values = this.currentDownloadsMap.values();
            Intrinsics.checkExpressionValueIsNotNull(values, "currentDownloadsMap.values");
            Iterable<FileDownloader> filterNotNull = CollectionsKt.filterNotNull(values);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterNotNull, 10));
            for (FileDownloader download : filterNotNull) {
                arrayList.add(download.getDownload());
            }
            list = (List) arrayList;
        }
        return list;
    }

    public List<Integer> getActiveDownloadsIds() {
        List<Integer> list;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            Map linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : this.currentDownloadsMap.entrySet()) {
                if (entry.getValue() != null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Collection arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry key : linkedHashMap.entrySet()) {
                arrayList.add(Integer.valueOf(((Number) key.getKey()).intValue()));
            }
            list = (List) arrayList;
        }
        return list;
    }

    private final void throwExceptionIfClosed() {
        if (this.closed) {
            throw new FetchException("DownloadManager is already shutdown.");
        }
    }

    public FileDownloader getNewFileDownloaderForDownload(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        if (!FetchCoreUtils.isFetchFileServerUrl(download.getUrl())) {
            return getFileDownloader(download, this.httpDownloader);
        }
        return getFileDownloader(download, this.fileServerDownloader);
    }

    private final FileDownloader getFileDownloader(Download download, Downloader<?, ?> downloader) {
        Download download2 = download;
        Downloader<?, ?> downloader2 = downloader;
        Downloader.ServerRequest requestForDownload$default = FetchUtils.getRequestForDownload$default(download, (String) null, 2, (Object) null);
        if (downloader2.getHeadRequestMethodSupported(requestForDownload$default)) {
            requestForDownload$default = FetchUtils.getRequestForDownload(download, FetchCoreUtils.HEAD_REQUEST_METHOD);
        }
        if (downloader2.getRequestFileDownloaderType(requestForDownload$default, downloader2.getRequestSupportedFileDownloaderTypes(requestForDownload$default)) == Downloader.FileDownloaderType.SEQUENTIAL) {
            return new SequentialFileDownloaderImpl(download, downloader, this.progressReportingIntervalMillis, this.logger, this.networkInfoProvider, this.retryOnNetworkGain, this.hashCheckingEnabled, this.storageResolver, this.preAllocateFileOnCreation);
        }
        return new ParallelFileDownloaderImpl(download, downloader, this.progressReportingIntervalMillis, this.logger, this.networkInfoProvider, this.retryOnNetworkGain, this.storageResolver.getDirectoryForFileDownloaderTypeParallel(requestForDownload$default), this.hashCheckingEnabled, this.storageResolver, this.preAllocateFileOnCreation);
    }

    public FileDownloader.Delegate getFileDownloaderDelegate() {
        return new FileDownloaderDelegate(this.downloadInfoUpdater, this.listenerCoordinator.getMainListener(), this.retryOnNetworkGain, this.globalAutoRetryMaxAttempts);
    }

    public String getDownloadFileTempDir(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        return this.storageResolver.getDirectoryForFileDownloaderTypeParallel(FetchUtils.getRequestForDownload$default(download, (String) null, 2, (Object) null));
    }

    private final ExecutorService getNewDownloadExecutorService(int i) {
        if (i > 0) {
            return Executors.newFixedThreadPool(i);
        }
        return null;
    }
}
