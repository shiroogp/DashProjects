package com.tonyodev.fetch2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.database.FetchDatabaseManager;
import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2.fetch.FetchHandler;
import com.tonyodev.fetch2.util.FetchDefaults;
import com.tonyodev.fetch2core.DefaultStorageResolver;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreDefaults;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.FetchLogger;
import com.tonyodev.fetch2core.FileServerDownloader;
import com.tonyodev.fetch2core.Logger;
import com.tonyodev.fetch2core.StorageResolver;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001XBß\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0006\u0010!\u001a\u00020\"\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\u0006\u0010&\u001a\u00020\u0007\u0012\u0006\u0010'\u001a\u00020\u000b\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010*J\u0013\u0010R\u001a\u00020\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010T\u001a\u00020UJ\b\u0010V\u001a\u00020\u0007H\u0016J\b\u0010W\u001a\u00020\u0005H\u0016R\u0011\u0010$\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010%\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u00100R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u00100R\u0019\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0011\u0010&\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u00104R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010ER\u0011\u0010'\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bN\u0010,R\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bO\u00100R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bP\u0010Q¨\u0006Y"}, d2 = {"Lcom/tonyodev/fetch2/FetchConfiguration;", "", "appContext", "Landroid/content/Context;", "namespace", "", "concurrentLimit", "", "progressReportingIntervalMillis", "", "loggingEnabled", "", "httpDownloader", "Lcom/tonyodev/fetch2core/Downloader;", "globalNetworkType", "Lcom/tonyodev/fetch2/NetworkType;", "logger", "Lcom/tonyodev/fetch2core/Logger;", "autoStart", "retryOnNetworkGain", "fileServerDownloader", "Lcom/tonyodev/fetch2core/FileServerDownloader;", "hashCheckingEnabled", "fileExistChecksEnabled", "storageResolver", "Lcom/tonyodev/fetch2core/StorageResolver;", "fetchNotificationManager", "Lcom/tonyodev/fetch2/FetchNotificationManager;", "fetchDatabaseManager", "Lcom/tonyodev/fetch2/database/FetchDatabaseManager;", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "backgroundHandler", "Landroid/os/Handler;", "prioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "internetCheckUrl", "activeDownloadsCheckInterval", "createFileOnEnqueue", "maxAutoRetryAttempts", "preAllocateFileOnCreation", "fetchHandler", "Lcom/tonyodev/fetch2/fetch/FetchHandler;", "(Landroid/content/Context;Ljava/lang/String;IJZLcom/tonyodev/fetch2core/Downloader;Lcom/tonyodev/fetch2/NetworkType;Lcom/tonyodev/fetch2core/Logger;ZZLcom/tonyodev/fetch2core/FileServerDownloader;ZZLcom/tonyodev/fetch2core/StorageResolver;Lcom/tonyodev/fetch2/FetchNotificationManager;Lcom/tonyodev/fetch2/database/FetchDatabaseManager;Landroid/os/Handler;Lcom/tonyodev/fetch2/PrioritySort;Ljava/lang/String;JZIZLcom/tonyodev/fetch2/fetch/FetchHandler;)V", "getActiveDownloadsCheckInterval", "()J", "getAppContext", "()Landroid/content/Context;", "getAutoStart", "()Z", "getBackgroundHandler", "()Landroid/os/Handler;", "getConcurrentLimit", "()I", "getCreateFileOnEnqueue", "getFetchDatabaseManager", "()Lcom/tonyodev/fetch2/database/FetchDatabaseManager;", "getFetchHandler", "()Lcom/tonyodev/fetch2/fetch/FetchHandler;", "getFetchNotificationManager", "()Lcom/tonyodev/fetch2/FetchNotificationManager;", "getFileExistChecksEnabled", "getFileServerDownloader", "()Lcom/tonyodev/fetch2core/FileServerDownloader;", "getGlobalNetworkType", "()Lcom/tonyodev/fetch2/NetworkType;", "getHashCheckingEnabled", "getHttpDownloader", "()Lcom/tonyodev/fetch2core/Downloader;", "getInternetCheckUrl", "()Ljava/lang/String;", "getLogger", "()Lcom/tonyodev/fetch2core/Logger;", "getLoggingEnabled", "getMaxAutoRetryAttempts", "getNamespace", "getPreAllocateFileOnCreation", "getPrioritySort", "()Lcom/tonyodev/fetch2/PrioritySort;", "getProgressReportingIntervalMillis", "getRetryOnNetworkGain", "getStorageResolver", "()Lcom/tonyodev/fetch2core/StorageResolver;", "equals", "other", "getNewFetchInstanceFromConfiguration", "Lcom/tonyodev/fetch2/Fetch;", "hashCode", "toString", "Builder", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchConfiguration.kt */
public final class FetchConfiguration {
    private final long activeDownloadsCheckInterval;
    private final Context appContext;
    private final boolean autoStart;
    private final Handler backgroundHandler;
    private final int concurrentLimit;
    private final boolean createFileOnEnqueue;
    private final FetchDatabaseManager<DownloadInfo> fetchDatabaseManager;
    private final FetchHandler fetchHandler;
    private final FetchNotificationManager fetchNotificationManager;
    private final boolean fileExistChecksEnabled;
    private final FileServerDownloader fileServerDownloader;
    private final NetworkType globalNetworkType;
    private final boolean hashCheckingEnabled;
    private final Downloader<?, ?> httpDownloader;
    private final String internetCheckUrl;
    private final Logger logger;
    private final boolean loggingEnabled;
    private final int maxAutoRetryAttempts;
    private final String namespace;
    private final boolean preAllocateFileOnCreation;
    private final PrioritySort prioritySort;
    private final long progressReportingIntervalMillis;
    private final boolean retryOnNetworkGain;
    private final StorageResolver storageResolver;

    private FetchConfiguration(Context context, String str, int i, long j, boolean z, Downloader<?, ?> downloader, NetworkType networkType, Logger logger2, boolean z2, boolean z3, FileServerDownloader fileServerDownloader2, boolean z4, boolean z5, StorageResolver storageResolver2, FetchNotificationManager fetchNotificationManager2, FetchDatabaseManager<DownloadInfo> fetchDatabaseManager2, Handler handler, PrioritySort prioritySort2, String str2, long j2, boolean z6, int i2, boolean z7, FetchHandler fetchHandler2) {
        this.appContext = context;
        this.namespace = str;
        this.concurrentLimit = i;
        this.progressReportingIntervalMillis = j;
        this.loggingEnabled = z;
        this.httpDownloader = downloader;
        this.globalNetworkType = networkType;
        this.logger = logger2;
        this.autoStart = z2;
        this.retryOnNetworkGain = z3;
        this.fileServerDownloader = fileServerDownloader2;
        this.hashCheckingEnabled = z4;
        this.fileExistChecksEnabled = z5;
        this.storageResolver = storageResolver2;
        this.fetchNotificationManager = fetchNotificationManager2;
        this.fetchDatabaseManager = fetchDatabaseManager2;
        this.backgroundHandler = handler;
        this.prioritySort = prioritySort2;
        this.internetCheckUrl = str2;
        this.activeDownloadsCheckInterval = j2;
        this.createFileOnEnqueue = z6;
        this.maxAutoRetryAttempts = i2;
        this.preAllocateFileOnCreation = z7;
        this.fetchHandler = fetchHandler2;
    }

    public /* synthetic */ FetchConfiguration(Context context, String str, int i, long j, boolean z, Downloader downloader, NetworkType networkType, Logger logger2, boolean z2, boolean z3, FileServerDownloader fileServerDownloader2, boolean z4, boolean z5, StorageResolver storageResolver2, FetchNotificationManager fetchNotificationManager2, FetchDatabaseManager fetchDatabaseManager2, Handler handler, PrioritySort prioritySort2, String str2, long j2, boolean z6, int i2, boolean z7, FetchHandler fetchHandler2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, i, j, z, downloader, networkType, logger2, z2, z3, fileServerDownloader2, z4, z5, storageResolver2, fetchNotificationManager2, fetchDatabaseManager2, handler, prioritySort2, str2, j2, z6, i2, z7, fetchHandler2);
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final int getConcurrentLimit() {
        return this.concurrentLimit;
    }

    public final long getProgressReportingIntervalMillis() {
        return this.progressReportingIntervalMillis;
    }

    public final boolean getLoggingEnabled() {
        return this.loggingEnabled;
    }

    public final Downloader<?, ?> getHttpDownloader() {
        return this.httpDownloader;
    }

    public final NetworkType getGlobalNetworkType() {
        return this.globalNetworkType;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final boolean getAutoStart() {
        return this.autoStart;
    }

    public final boolean getRetryOnNetworkGain() {
        return this.retryOnNetworkGain;
    }

    public final FileServerDownloader getFileServerDownloader() {
        return this.fileServerDownloader;
    }

    public final boolean getHashCheckingEnabled() {
        return this.hashCheckingEnabled;
    }

    public final boolean getFileExistChecksEnabled() {
        return this.fileExistChecksEnabled;
    }

    public final StorageResolver getStorageResolver() {
        return this.storageResolver;
    }

    public final FetchNotificationManager getFetchNotificationManager() {
        return this.fetchNotificationManager;
    }

    public final FetchDatabaseManager<DownloadInfo> getFetchDatabaseManager() {
        return this.fetchDatabaseManager;
    }

    public final Handler getBackgroundHandler() {
        return this.backgroundHandler;
    }

    public final PrioritySort getPrioritySort() {
        return this.prioritySort;
    }

    public final String getInternetCheckUrl() {
        return this.internetCheckUrl;
    }

    public final long getActiveDownloadsCheckInterval() {
        return this.activeDownloadsCheckInterval;
    }

    public final boolean getCreateFileOnEnqueue() {
        return this.createFileOnEnqueue;
    }

    public final int getMaxAutoRetryAttempts() {
        return this.maxAutoRetryAttempts;
    }

    public final boolean getPreAllocateFileOnCreation() {
        return this.preAllocateFileOnCreation;
    }

    public final FetchHandler getFetchHandler() {
        return this.fetchHandler;
    }

    public final Fetch getNewFetchInstanceFromConfiguration() {
        return Fetch.Impl.getInstance(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\nJ\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\nJ\u000e\u00104\u001a\u00020\u00002\u0006\u00102\u001a\u00020\nJ\u000e\u00105\u001a\u00020\u00002\u0006\u00102\u001a\u00020\nJ\u000e\u00106\u001a\u00020\u00002\u0006\u00102\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u00002\u0006\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u000eJ\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\fJ\u0016\u0010<\u001a\u00020\u00002\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001bJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0006J\u0016\u0010E\u001a\u00020\u00002\u000e\u0010F\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001eJ\u0010\u0010G\u001a\u00020\u00002\b\u0010H\u001a\u0004\u0018\u00010 J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0012\u0010J\u001a\u00020\u00002\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 J\u0010\u0010K\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/tonyodev/fetch2/FetchConfiguration$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activeDownloadCheckInterval", "", "appContext", "kotlin.jvm.PlatformType", "autoStart", "", "backgroundHandler", "Landroid/os/Handler;", "concurrentLimit", "", "createFileOnEnqueue", "fetchDatabaseManager", "Lcom/tonyodev/fetch2/database/FetchDatabaseManager;", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "fetchHandler", "Lcom/tonyodev/fetch2/fetch/FetchHandler;", "fetchNotificationManager", "Lcom/tonyodev/fetch2/FetchNotificationManager;", "fileExistChecksEnabled", "fileServerDownloader", "Lcom/tonyodev/fetch2core/FileServerDownloader;", "globalNetworkType", "Lcom/tonyodev/fetch2/NetworkType;", "hashCheckEnabled", "httpDownloader", "Lcom/tonyodev/fetch2core/Downloader;", "internetCheckUrl", "", "logger", "Lcom/tonyodev/fetch2core/Logger;", "loggingEnabled", "maxAutoRetryAttempts", "namespace", "preAllocateFileOnCreation", "prioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "progressReportingIntervalMillis", "retryOnNetworkGain", "storageResolver", "Lcom/tonyodev/fetch2core/StorageResolver;", "build", "Lcom/tonyodev/fetch2/FetchConfiguration;", "createDownloadFileOnEnqueue", "create", "enableAutoStart", "enabled", "enableFileExistChecks", "enableHashCheck", "enableLogging", "enableRetryOnNetworkGain", "preAllocateFile", "setAutoRetryMaxAttempts", "autoRetryMaxAttempts", "setBackgroundHandler", "handler", "setDatabaseManager", "setDownloadConcurrentLimit", "downloadConcurrentLimit", "setFetchHandler", "setFileServerDownloader", "setGlobalNetworkType", "networkType", "setHasActiveDownloadsCheckInterval", "intervalInMillis", "setHttpDownloader", "downloader", "setInternetAccessUrlCheck", "url", "setLogger", "setNamespace", "setNotificationManager", "setPrioritySort", "setProgressReportingInterval", "setStorageResolver", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FetchConfiguration.kt */
    public static final class Builder {
        private long activeDownloadCheckInterval;
        private final Context appContext;
        private boolean autoStart = true;
        private Handler backgroundHandler;
        private int concurrentLimit = 1;
        private boolean createFileOnEnqueue;
        private FetchDatabaseManager<DownloadInfo> fetchDatabaseManager;
        private FetchHandler fetchHandler;
        private FetchNotificationManager fetchNotificationManager;
        private boolean fileExistChecksEnabled = true;
        private FileServerDownloader fileServerDownloader = FetchDefaults.getDefaultFileServerDownloader();
        private NetworkType globalNetworkType = FetchDefaults.getDefaultGlobalNetworkType();
        private boolean hashCheckEnabled;
        private Downloader<?, ?> httpDownloader = FetchDefaults.getDefaultDownloader();
        private String internetCheckUrl;
        private Logger logger = FetchDefaults.getDefaultLogger();
        private boolean loggingEnabled;
        private int maxAutoRetryAttempts;
        private String namespace = FetchDefaults.DEFAULT_INSTANCE_NAMESPACE;
        private boolean preAllocateFileOnCreation;
        private PrioritySort prioritySort;
        private long progressReportingIntervalMillis = FetchCoreDefaults.DEFAULT_PROGRESS_REPORTING_INTERVAL_IN_MILLISECONDS;
        private boolean retryOnNetworkGain = true;
        private StorageResolver storageResolver;

        public Builder(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Context applicationContext = context.getApplicationContext();
            this.appContext = applicationContext;
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "appContext");
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "appContext");
            this.storageResolver = new DefaultStorageResolver(applicationContext, FetchCoreUtils.getFileTempDir(applicationContext));
            this.prioritySort = FetchDefaults.getDefaultPrioritySort();
            this.activeDownloadCheckInterval = FetchDefaults.DEFAULT_HAS_ACTIVE_DOWNLOADS_INTERVAL_IN_MILLISECONDS;
            this.createFileOnEnqueue = true;
            this.maxAutoRetryAttempts = -1;
            this.preAllocateFileOnCreation = true;
        }

        public static /* synthetic */ Builder setNamespace$default(Builder builder, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return builder.setNamespace(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
            if ((r2.length() == 0) != false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tonyodev.fetch2.FetchConfiguration.Builder setNamespace(java.lang.String r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L_0x0010
                r0 = r2
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                int r0 = r0.length()
                if (r0 != 0) goto L_0x000d
                r0 = 1
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                if (r0 == 0) goto L_0x0012
            L_0x0010:
                java.lang.String r2 = "LibGlobalFetchLib"
            L_0x0012:
                r1.namespace = r2
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.FetchConfiguration.Builder.setNamespace(java.lang.String):com.tonyodev.fetch2.FetchConfiguration$Builder");
        }

        public final Builder setHttpDownloader(Downloader<?, ?> downloader) {
            Intrinsics.checkParameterIsNotNull(downloader, "downloader");
            this.httpDownloader = downloader;
            return this;
        }

        public final Builder setFileServerDownloader(FileServerDownloader fileServerDownloader2) {
            Intrinsics.checkParameterIsNotNull(fileServerDownloader2, "fileServerDownloader");
            this.fileServerDownloader = fileServerDownloader2;
            return this;
        }

        public final Builder setProgressReportingInterval(long j) {
            if (j >= 0) {
                this.progressReportingIntervalMillis = j;
                return this;
            }
            throw new FetchException("progressReportingIntervalMillis cannot be less than 0");
        }

        public final Builder setDownloadConcurrentLimit(int i) {
            if (i >= 0) {
                this.concurrentLimit = i;
                return this;
            }
            throw new FetchException("Concurrent limit cannot be less than 0");
        }

        public final Builder setGlobalNetworkType(NetworkType networkType) {
            Intrinsics.checkParameterIsNotNull(networkType, "networkType");
            this.globalNetworkType = networkType;
            return this;
        }

        public final Builder enableLogging(boolean z) {
            this.loggingEnabled = z;
            return this;
        }

        public final Builder setLogger(Logger logger2) {
            Intrinsics.checkParameterIsNotNull(logger2, "logger");
            this.logger = logger2;
            return this;
        }

        public final Builder enableAutoStart(boolean z) {
            this.autoStart = z;
            return this;
        }

        public final Builder enableRetryOnNetworkGain(boolean z) {
            this.retryOnNetworkGain = z;
            return this;
        }

        public final Builder enableHashCheck(boolean z) {
            this.hashCheckEnabled = z;
            return this;
        }

        public final Builder enableFileExistChecks(boolean z) {
            this.fileExistChecksEnabled = z;
            return this;
        }

        public final Builder setStorageResolver(StorageResolver storageResolver2) {
            Intrinsics.checkParameterIsNotNull(storageResolver2, "storageResolver");
            this.storageResolver = storageResolver2;
            return this;
        }

        public final Builder setNotificationManager(FetchNotificationManager fetchNotificationManager2) {
            this.fetchNotificationManager = fetchNotificationManager2;
            return this;
        }

        public final Builder setDatabaseManager(FetchDatabaseManager<DownloadInfo> fetchDatabaseManager2) {
            this.fetchDatabaseManager = fetchDatabaseManager2;
            return this;
        }

        public final Builder setBackgroundHandler(Handler handler) {
            Intrinsics.checkParameterIsNotNull(handler, "handler");
            Looper looper = handler.getLooper();
            Intrinsics.checkExpressionValueIsNotNull(looper, "handler.looper");
            Thread thread = looper.getThread();
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
            if (!Intrinsics.areEqual((Object) thread, (Object) mainLooper.getThread())) {
                this.backgroundHandler = handler;
                return this;
            }
            throw new IllegalAccessException("The background handler cannot use the main/ui thread");
        }

        public final Builder setFetchHandler(FetchHandler fetchHandler2) {
            Intrinsics.checkParameterIsNotNull(fetchHandler2, "fetchHandler");
            this.fetchHandler = fetchHandler2;
            return this;
        }

        public final Builder setPrioritySort(PrioritySort prioritySort2) {
            Intrinsics.checkParameterIsNotNull(prioritySort2, "prioritySort");
            this.prioritySort = prioritySort2;
            return this;
        }

        public final Builder setInternetAccessUrlCheck(String str) {
            this.internetCheckUrl = str;
            return this;
        }

        public final Builder setHasActiveDownloadsCheckInterval(long j) {
            if (j >= 0) {
                this.activeDownloadCheckInterval = j;
                return this;
            }
            throw new FetchException("intervalInMillis cannot be less than 0");
        }

        public final Builder createDownloadFileOnEnqueue(boolean z) {
            this.createFileOnEnqueue = z;
            return this;
        }

        public final Builder setAutoRetryMaxAttempts(int i) {
            if (i >= 0) {
                this.maxAutoRetryAttempts = i;
                return this;
            }
            throw new IllegalArgumentException("The AutoRetryMaxAttempts has to be greater than -1");
        }

        public final Builder preAllocateFileOnCreation(boolean z) {
            this.preAllocateFileOnCreation = z;
            return this;
        }

        public final FetchConfiguration build() {
            Logger logger2 = this.logger;
            if (logger2 instanceof FetchLogger) {
                logger2.setEnabled(this.loggingEnabled);
                FetchLogger fetchLogger = (FetchLogger) logger2;
                if (Intrinsics.areEqual((Object) fetchLogger.getTag(), (Object) FetchCoreDefaults.DEFAULT_TAG)) {
                    fetchLogger.setTag(this.namespace);
                }
            } else {
                logger2.setEnabled(this.loggingEnabled);
            }
            Context context = this.appContext;
            Intrinsics.checkExpressionValueIsNotNull(context, "appContext");
            return new FetchConfiguration(context, this.namespace, this.concurrentLimit, this.progressReportingIntervalMillis, this.loggingEnabled, this.httpDownloader, this.globalNetworkType, logger2, this.autoStart, this.retryOnNetworkGain, this.fileServerDownloader, this.hashCheckEnabled, this.fileExistChecksEnabled, this.storageResolver, this.fetchNotificationManager, this.fetchDatabaseManager, this.backgroundHandler, this.prioritySort, this.internetCheckUrl, this.activeDownloadCheckInterval, this.createFileOnEnqueue, this.maxAutoRetryAttempts, this.preAllocateFileOnCreation, this.fetchHandler, (DefaultConstructorMarker) null);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            FetchConfiguration fetchConfiguration = (FetchConfiguration) obj;
            if (!(!Intrinsics.areEqual((Object) this.appContext, (Object) fetchConfiguration.appContext)) && !(!Intrinsics.areEqual((Object) this.namespace, (Object) fetchConfiguration.namespace)) && this.concurrentLimit == fetchConfiguration.concurrentLimit && this.progressReportingIntervalMillis == fetchConfiguration.progressReportingIntervalMillis && this.loggingEnabled == fetchConfiguration.loggingEnabled && !(!Intrinsics.areEqual((Object) this.httpDownloader, (Object) fetchConfiguration.httpDownloader)) && this.globalNetworkType == fetchConfiguration.globalNetworkType && !(!Intrinsics.areEqual((Object) this.logger, (Object) fetchConfiguration.logger)) && this.autoStart == fetchConfiguration.autoStart && this.retryOnNetworkGain == fetchConfiguration.retryOnNetworkGain && !(!Intrinsics.areEqual((Object) this.fileServerDownloader, (Object) fetchConfiguration.fileServerDownloader)) && this.hashCheckingEnabled == fetchConfiguration.hashCheckingEnabled && this.fileExistChecksEnabled == fetchConfiguration.fileExistChecksEnabled && !(!Intrinsics.areEqual((Object) this.storageResolver, (Object) fetchConfiguration.storageResolver)) && !(!Intrinsics.areEqual((Object) this.fetchNotificationManager, (Object) fetchConfiguration.fetchNotificationManager)) && !(!Intrinsics.areEqual((Object) this.fetchDatabaseManager, (Object) fetchConfiguration.fetchDatabaseManager)) && !(!Intrinsics.areEqual((Object) this.backgroundHandler, (Object) fetchConfiguration.backgroundHandler)) && this.prioritySort == fetchConfiguration.prioritySort && !(!Intrinsics.areEqual((Object) this.internetCheckUrl, (Object) fetchConfiguration.internetCheckUrl)) && this.activeDownloadsCheckInterval == fetchConfiguration.activeDownloadsCheckInterval && this.createFileOnEnqueue == fetchConfiguration.createFileOnEnqueue && this.maxAutoRetryAttempts == fetchConfiguration.maxAutoRetryAttempts && this.preAllocateFileOnCreation == fetchConfiguration.preAllocateFileOnCreation && !(!Intrinsics.areEqual((Object) this.fetchHandler, (Object) fetchConfiguration.fetchHandler))) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2.FetchConfiguration");
    }

    public int hashCode() {
        int hashCode = (((((((((((((((((((((((((this.appContext.hashCode() * 31) + this.namespace.hashCode()) * 31) + this.concurrentLimit) * 31) + Long.valueOf(this.progressReportingIntervalMillis).hashCode()) * 31) + Boolean.valueOf(this.loggingEnabled).hashCode()) * 31) + this.httpDownloader.hashCode()) * 31) + this.globalNetworkType.hashCode()) * 31) + this.logger.hashCode()) * 31) + Boolean.valueOf(this.autoStart).hashCode()) * 31) + Boolean.valueOf(this.retryOnNetworkGain).hashCode()) * 31) + this.fileServerDownloader.hashCode()) * 31) + Boolean.valueOf(this.hashCheckingEnabled).hashCode()) * 31) + Boolean.valueOf(this.fileExistChecksEnabled).hashCode()) * 31) + this.storageResolver.hashCode();
        FetchNotificationManager fetchNotificationManager2 = this.fetchNotificationManager;
        if (fetchNotificationManager2 != null) {
            hashCode = (hashCode * 31) + fetchNotificationManager2.hashCode();
        }
        FetchDatabaseManager<DownloadInfo> fetchDatabaseManager2 = this.fetchDatabaseManager;
        if (fetchDatabaseManager2 != null) {
            hashCode = (hashCode * 31) + fetchDatabaseManager2.hashCode();
        }
        Handler handler = this.backgroundHandler;
        if (handler != null) {
            hashCode = (hashCode * 31) + handler.hashCode();
        }
        FetchHandler fetchHandler2 = this.fetchHandler;
        if (fetchHandler2 != null) {
            hashCode = (hashCode * 31) + fetchHandler2.hashCode();
        }
        int hashCode2 = (hashCode * 31) + this.prioritySort.hashCode();
        String str = this.internetCheckUrl;
        if (str != null) {
            hashCode2 = (hashCode2 * 31) + str.hashCode();
        }
        return (((((((hashCode2 * 31) + Long.valueOf(this.activeDownloadsCheckInterval).hashCode()) * 31) + Boolean.valueOf(this.createFileOnEnqueue).hashCode()) * 31) + Integer.valueOf(this.maxAutoRetryAttempts).hashCode()) * 31) + Boolean.valueOf(this.preAllocateFileOnCreation).hashCode();
    }

    public String toString() {
        return "FetchConfiguration(appContext=" + this.appContext + ", namespace='" + this.namespace + "', " + "concurrentLimit=" + this.concurrentLimit + ", progressReportingIntervalMillis=" + this.progressReportingIntervalMillis + ", " + "loggingEnabled=" + this.loggingEnabled + ", httpDownloader=" + this.httpDownloader + ", globalNetworkType=" + this.globalNetworkType + ',' + " logger=" + this.logger + ", autoStart=" + this.autoStart + ", retryOnNetworkGain=" + this.retryOnNetworkGain + ", " + "fileServerDownloader=" + this.fileServerDownloader + ", hashCheckingEnabled=" + this.hashCheckingEnabled + ", " + "fileExistChecksEnabled=" + this.fileExistChecksEnabled + ", storageResolver=" + this.storageResolver + ", " + "fetchNotificationManager=" + this.fetchNotificationManager + ", fetchDatabaseManager=" + this.fetchDatabaseManager + ',' + " backgroundHandler=" + this.backgroundHandler + ", prioritySort=" + this.prioritySort + ", internetCheckUrl=" + this.internetCheckUrl + ',' + " activeDownloadsCheckInterval=" + this.activeDownloadsCheckInterval + ", createFileOnEnqueue=" + this.createFileOnEnqueue + ',' + " preAllocateFileOnCreation=" + this.preAllocateFileOnCreation + ", " + "maxAutoRetryAttempts=" + this.maxAutoRetryAttempts + ',' + " fetchHandler=" + this.fetchHandler + ')';
    }
}
