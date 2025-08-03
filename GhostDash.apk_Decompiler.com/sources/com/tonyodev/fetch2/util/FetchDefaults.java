package com.tonyodev.fetch2.util;

import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchFileServerDownloader;
import com.tonyodev.fetch2.HttpUrlConnectionDownloader;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreDefaults;
import com.tonyodev.fetch2core.FetchLogger;
import com.tonyodev.fetch2core.FileServerDownloader;
import com.tonyodev.fetch2core.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u001b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\"\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&\"\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*\"\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.\"\u0011\u0010/\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*\"\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104\"\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108\"\u0011\u00109\u001a\u00020:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<\"\u0011\u0010=\u001a\u00020>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006A"}, d2 = {"DEFAULT_AUTO_RETRY_ATTEMPTS", "", "DEFAULT_AUTO_START", "", "DEFAULT_CONCURRENT_LIMIT", "DEFAULT_CREATE_FILE_ON_ENQUEUE", "DEFAULT_DOWNLOAD_ON_ENQUEUE", "DEFAULT_DOWNLOAD_SPEED_REPORTING_INTERVAL_IN_MILLISECONDS", "", "DEFAULT_ENABLE_LISTENER_AUTOSTART_ON_ATTACHED", "DEFAULT_ENABLE_LISTENER_NOTIFY_ON_ATTACHED", "DEFAULT_ENABLE_LISTENER_NOTIFY_ON_REQUEST_UPDATED", "DEFAULT_FILE_EXIST_CHECKS", "DEFAULT_FILE_SLICE_NO_LIMIT_SET", "DEFAULT_GLOBAL_AUTO_RETRY_ATTEMPTS", "DEFAULT_GROUP_ID", "DEFAULT_HASH_CHECK_ENABLED", "DEFAULT_HAS_ACTIVE_DOWNLOADS_INTERVAL_IN_MILLISECONDS", "DEFAULT_INSTANCE_NAMESPACE", "", "DEFAULT_NOTIFICATION_TIMEOUT_AFTER", "DEFAULT_NOTIFICATION_TIMEOUT_AFTER_RESET", "DEFAULT_PREALLOCATE_FILE_ON_CREATE", "DEFAULT_PRIORITY_QUEUE_INTERVAL_IN_MILLISECONDS", "DEFAULT_RETRY_ON_NETWORK_GAIN", "DEFAULT_UNIQUE_IDENTIFIER", "EMPTY_JSON_OBJECT_STRING", "defaultDownloader", "Lcom/tonyodev/fetch2core/Downloader;", "getDefaultDownloader", "()Lcom/tonyodev/fetch2core/Downloader;", "defaultEnqueueAction", "Lcom/tonyodev/fetch2/EnqueueAction;", "getDefaultEnqueueAction", "()Lcom/tonyodev/fetch2/EnqueueAction;", "defaultFileServerDownloader", "Lcom/tonyodev/fetch2core/FileServerDownloader;", "getDefaultFileServerDownloader", "()Lcom/tonyodev/fetch2core/FileServerDownloader;", "defaultGlobalNetworkType", "Lcom/tonyodev/fetch2/NetworkType;", "getDefaultGlobalNetworkType", "()Lcom/tonyodev/fetch2/NetworkType;", "defaultLogger", "Lcom/tonyodev/fetch2core/Logger;", "getDefaultLogger", "()Lcom/tonyodev/fetch2core/Logger;", "defaultNetworkType", "getDefaultNetworkType", "defaultNoError", "Lcom/tonyodev/fetch2/Error;", "getDefaultNoError", "()Lcom/tonyodev/fetch2/Error;", "defaultPriority", "Lcom/tonyodev/fetch2/Priority;", "getDefaultPriority", "()Lcom/tonyodev/fetch2/Priority;", "defaultPrioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "getDefaultPrioritySort", "()Lcom/tonyodev/fetch2/PrioritySort;", "defaultStatus", "Lcom/tonyodev/fetch2/Status;", "getDefaultStatus", "()Lcom/tonyodev/fetch2/Status;", "fetch2_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: Defaults.kt */
public final class FetchDefaults {
    public static final int DEFAULT_AUTO_RETRY_ATTEMPTS = 0;
    public static final boolean DEFAULT_AUTO_START = true;
    public static final int DEFAULT_CONCURRENT_LIMIT = 1;
    public static final boolean DEFAULT_CREATE_FILE_ON_ENQUEUE = true;
    public static final boolean DEFAULT_DOWNLOAD_ON_ENQUEUE = true;
    public static final long DEFAULT_DOWNLOAD_SPEED_REPORTING_INTERVAL_IN_MILLISECONDS = 1000;
    public static final boolean DEFAULT_ENABLE_LISTENER_AUTOSTART_ON_ATTACHED = false;
    public static final boolean DEFAULT_ENABLE_LISTENER_NOTIFY_ON_ATTACHED = false;
    public static final boolean DEFAULT_ENABLE_LISTENER_NOTIFY_ON_REQUEST_UPDATED = true;
    public static final boolean DEFAULT_FILE_EXIST_CHECKS = true;
    public static final int DEFAULT_FILE_SLICE_NO_LIMIT_SET = -1;
    public static final int DEFAULT_GLOBAL_AUTO_RETRY_ATTEMPTS = -1;
    public static final int DEFAULT_GROUP_ID = 0;
    public static final boolean DEFAULT_HASH_CHECK_ENABLED = false;
    public static final long DEFAULT_HAS_ACTIVE_DOWNLOADS_INTERVAL_IN_MILLISECONDS = 300000;
    public static final String DEFAULT_INSTANCE_NAMESPACE = "LibGlobalFetchLib";
    public static final long DEFAULT_NOTIFICATION_TIMEOUT_AFTER = 10000;
    public static final long DEFAULT_NOTIFICATION_TIMEOUT_AFTER_RESET = 31104000000L;
    public static final boolean DEFAULT_PREALLOCATE_FILE_ON_CREATE = true;
    public static final long DEFAULT_PRIORITY_QUEUE_INTERVAL_IN_MILLISECONDS = 500;
    public static final boolean DEFAULT_RETRY_ON_NETWORK_GAIN = true;
    public static final long DEFAULT_UNIQUE_IDENTIFIER = 0;
    public static final String EMPTY_JSON_OBJECT_STRING = "{}";
    private static final Downloader<?, ?> defaultDownloader = new HttpUrlConnectionDownloader((HttpUrlConnectionDownloader.HttpUrlConnectionPreferences) null, (Downloader.FileDownloaderType) null, 3, (DefaultConstructorMarker) null);
    private static final EnqueueAction defaultEnqueueAction = EnqueueAction.UPDATE_ACCORDINGLY;
    private static final FileServerDownloader defaultFileServerDownloader = new FetchFileServerDownloader((Downloader.FileDownloaderType) null, 0, 3, (DefaultConstructorMarker) null);
    private static final NetworkType defaultGlobalNetworkType = NetworkType.GLOBAL_OFF;
    private static final Logger defaultLogger = new FetchLogger(false, FetchCoreDefaults.DEFAULT_TAG);
    private static final NetworkType defaultNetworkType = NetworkType.ALL;
    private static final Error defaultNoError = Error.NONE;
    private static final Priority defaultPriority = Priority.NORMAL;
    private static final PrioritySort defaultPrioritySort = PrioritySort.ASC;
    private static final Status defaultStatus = Status.NONE;

    public static final NetworkType getDefaultNetworkType() {
        return defaultNetworkType;
    }

    public static final NetworkType getDefaultGlobalNetworkType() {
        return defaultGlobalNetworkType;
    }

    public static final Priority getDefaultPriority() {
        return defaultPriority;
    }

    public static final Error getDefaultNoError() {
        return defaultNoError;
    }

    public static final Status getDefaultStatus() {
        return defaultStatus;
    }

    public static final PrioritySort getDefaultPrioritySort() {
        return defaultPrioritySort;
    }

    public static final EnqueueAction getDefaultEnqueueAction() {
        return defaultEnqueueAction;
    }

    public static final Downloader<?, ?> getDefaultDownloader() {
        return defaultDownloader;
    }

    public static final FileServerDownloader getDefaultFileServerDownloader() {
        return defaultFileServerDownloader;
    }

    public static final Logger getDefaultLogger() {
        return defaultLogger;
    }
}
