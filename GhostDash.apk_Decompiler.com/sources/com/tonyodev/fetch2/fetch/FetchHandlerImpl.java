package com.tonyodev.fetch2.fetch;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tonyodev.fetch2.CompletedDownload;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchErrorUtils;
import com.tonyodev.fetch2.FetchGroup;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.FetchNotificationManager;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadDatabase;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.database.FetchDatabaseManager;
import com.tonyodev.fetch2.database.FetchDatabaseManagerWrapper;
import com.tonyodev.fetch2.downloader.DownloadManager;
import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2.helper.PriorityListProcessor;
import com.tonyodev.fetch2.provider.GroupInfoProvider;
import com.tonyodev.fetch2.util.FetchDefaults;
import com.tonyodev.fetch2.util.FetchTypeConverterExtensions;
import com.tonyodev.fetch2.util.FetchUtils;
import com.tonyodev.fetch2core.DownloadBlock;
import com.tonyodev.fetch2core.DownloadBlockInfo;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.FetchErrorStrings;
import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.FileResource;
import com.tonyodev.fetch2core.FileServerDownloader;
import com.tonyodev.fetch2core.FileSliceInfo;
import com.tonyodev.fetch2core.Logger;
import com.tonyodev.fetch2core.Reason;
import com.tonyodev.fetch2core.StorageResolver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020\u000e¢\u0006\u0002\u0010 J5\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020#2\u001e\u0010*\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\n0,0+\"\b\u0012\u0004\u0012\u00020\n0,H\u0016¢\u0006\u0002\u0010-J \u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00103\u001a\b\u0012\u0004\u0012\u00020#02H\u0016J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020\n02H\u0016J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00106\u001a\b\u0012\u0004\u0012\u00020702H\u0002J\u0016\u00108\u001a\u00020(2\f\u00106\u001a\b\u0012\u0004\u0012\u00020702H\u0002J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010:\u001a\u00020#H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00103\u001a\b\u0012\u0004\u0012\u00020#02H\u0016J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020\n02H\u0016J$\u0010>\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010?\u001a\u00020#2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A02H\u0016J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010C\u001a\u00020AH\u0016J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00106\u001a\b\u0012\u0004\u0012\u00020702H\u0002J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010:\u001a\u00020#H\u0016J\u0010\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020\u000eH\u0016J\u001c\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020J0I2\u0006\u0010K\u001a\u00020LH\u0016J(\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020J0I022\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L02H\u0016J(\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u000e0I022\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L02H\u0016J\u0010\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020QH\u0016J\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\n022\f\u0010S\u001a\b\u0012\u0004\u0012\u00020Q02H\u0016J(\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020J0I022\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L02H\u0002J\b\u0010U\u001a\u00020(H\u0016J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020#02H\u0016J\u0018\u0010W\u001a\u00020X2\u0006\u0010K\u001a\u00020L2\u0006\u0010Y\u001a\u00020\u000eH\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010\n2\u0006\u0010:\u001a\u00020#H\u0016J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\\022\u0006\u0010:\u001a\u00020#H\u0016J\u000e\u0010]\u001a\b\u0012\u0004\u0012\u00020\n02H\u0016J\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\n022\f\u0010^\u001a\b\u0012\u0004\u0012\u00020#02H\u0016J\u0016\u0010_\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010`\u001a\u00020XH\u0016J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010b\u001a\u00020\u0003H\u0016J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010:\u001a\u00020#H\u0016J$\u0010d\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010?\u001a\u00020#2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A02H\u0016J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010C\u001a\u00020AH\u0016J\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020\n022\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A02H\u0016J\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020g022\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010h\u001a\u00020i2\u0006\u0010:\u001a\u00020#H\u0016J\u000e\u0010j\u001a\b\u0012\u0004\u0012\u00020&0kH\u0016J\b\u0010l\u001a\u00020XH\u0016J&\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u00032\u0014\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010qH\u0016J\u0010\u0010r\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020\u000eH\u0016J\b\u0010t\u001a\u00020(H\u0016J\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00103\u001a\b\u0012\u0004\u0012\u00020#02H\u0016J\u000e\u0010v\u001a\b\u0012\u0004\u0012\u00020\n02H\u0016J\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00106\u001a\b\u0012\u0004\u0012\u00020702H\u0002J\u0016\u0010x\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010:\u001a\u00020#H\u0016J\u0010\u0010y\u001a\u00020(2\u0006\u0010z\u001a\u000207H\u0002J\u0010\u0010{\u001a\u00020\u000e2\u0006\u0010z\u001a\u000207H\u0002J\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00103\u001a\b\u0012\u0004\u0012\u00020#02H\u0016J\u000e\u0010}\u001a\b\u0012\u0004\u0012\u00020\n02H\u0016J$\u0010~\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010?\u001a\u00020#2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A02H\u0016J\u0016\u0010\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010C\u001a\u00020AH\u0016J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00106\u001a\b\u0012\u0004\u0012\u00020702H\u0002J6\u0010\u0001\u001a\u00020(2\u0006\u0010)\u001a\u00020#2\u001e\u0010*\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\n0,0+\"\b\u0012\u0004\u0012\u00020\n0,H\u0016¢\u0006\u0002\u0010-J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010:\u001a\u00020#H\u0016J\u0011\u0010\u0001\u001a\u00020(2\u0006\u0010/\u001a\u00020&H\u0016J\u001a\u0010\u0001\u001a\u00020\n2\u0006\u0010:\u001a\u00020#2\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u001b\u0010\u0001\u001a\u00020\n2\u0006\u0010:\u001a\u00020#2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001c\u0010\u0001\u001a\u0004\u0018\u00010\n2\u0006\u0010)\u001a\u00020#2\u0007\u0010\u0001\u001a\u00020\u000eH\u0016J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00103\u001a\b\u0012\u0004\u0012\u00020#02H\u0016J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n02H\u0016J\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n022\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020#02H\u0002J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010:\u001a\u00020#H\u0016J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n022\f\u00103\u001a\b\u0012\u0004\u0012\u00020#02H\u0016J\u0012\u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020#H\u0016J\u0013\u0010\u0001\u001a\u00020(2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020(H\u0002J\t\u0010\u0001\u001a\u00020(H\u0016J'\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0I2\u0007\u0010\u0001\u001a\u00020#2\u0007\u0010\u0001\u001a\u00020LH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/tonyodev/fetch2/fetch/FetchHandlerImpl;", "Lcom/tonyodev/fetch2/fetch/FetchHandler;", "namespace", "", "fetchDatabaseManagerWrapper", "Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "downloadManager", "Lcom/tonyodev/fetch2/downloader/DownloadManager;", "priorityListProcessor", "Lcom/tonyodev/fetch2/helper/PriorityListProcessor;", "Lcom/tonyodev/fetch2/Download;", "logger", "Lcom/tonyodev/fetch2core/Logger;", "autoStart", "", "httpDownloader", "Lcom/tonyodev/fetch2core/Downloader;", "fileServerDownloader", "Lcom/tonyodev/fetch2core/FileServerDownloader;", "listenerCoordinator", "Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "uiHandler", "Landroid/os/Handler;", "storageResolver", "Lcom/tonyodev/fetch2core/StorageResolver;", "fetchNotificationManager", "Lcom/tonyodev/fetch2/FetchNotificationManager;", "groupInfoProvider", "Lcom/tonyodev/fetch2/provider/GroupInfoProvider;", "prioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "createFileOnEnqueue", "(Ljava/lang/String;Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;Lcom/tonyodev/fetch2/downloader/DownloadManager;Lcom/tonyodev/fetch2/helper/PriorityListProcessor;Lcom/tonyodev/fetch2core/Logger;ZLcom/tonyodev/fetch2core/Downloader;Lcom/tonyodev/fetch2core/FileServerDownloader;Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;Landroid/os/Handler;Lcom/tonyodev/fetch2core/StorageResolver;Lcom/tonyodev/fetch2/FetchNotificationManager;Lcom/tonyodev/fetch2/provider/GroupInfoProvider;Lcom/tonyodev/fetch2/PrioritySort;Z)V", "isTerminating", "listenerId", "", "listenerSet", "", "Lcom/tonyodev/fetch2/FetchListener;", "addFetchObserversForDownload", "", "downloadId", "fetchObservers", "", "Lcom/tonyodev/fetch2core/FetchObserver;", "(I[Lcom/tonyodev/fetch2core/FetchObserver;)V", "addListener", "listener", "notify", "cancel", "", "ids", "cancelAll", "cancelDownloads", "downloads", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "cancelDownloadsIfDownloading", "cancelGroup", "id", "close", "delete", "deleteAll", "deleteAllInGroupWithStatus", "groupId", "statuses", "Lcom/tonyodev/fetch2/Status;", "deleteAllWithStatus", "status", "deleteDownloads", "deleteGroup", "enableLogging", "enabled", "enqueue", "Lkotlin/Pair;", "Lcom/tonyodev/fetch2/Error;", "request", "Lcom/tonyodev/fetch2/Request;", "requests", "enqueueBatch", "enqueueCompletedDownload", "completedDownload", "Lcom/tonyodev/fetch2/CompletedDownload;", "enqueueCompletedDownloads", "completedDownloads", "enqueueRequests", "freeze", "getAllGroupIds", "getContentLengthForRequest", "", "fromServer", "getDownload", "getDownloadBlocks", "Lcom/tonyodev/fetch2core/DownloadBlock;", "getDownloads", "idList", "getDownloadsByRequestIdentifier", "identifier", "getDownloadsByTag", "tag", "getDownloadsInGroup", "getDownloadsInGroupWithStatus", "getDownloadsWithStatus", "getFetchFileServerCatalog", "Lcom/tonyodev/fetch2core/FileResource;", "getFetchGroup", "Lcom/tonyodev/fetch2/FetchGroup;", "getListenerSet", "", "getPendingCount", "getServerResponse", "Lcom/tonyodev/fetch2core/Downloader$Response;", "url", "header", "", "hasActiveDownloads", "includeAddedDownloads", "init", "pause", "pauseAll", "pauseDownloads", "pausedGroup", "prepareCompletedDownloadInfoForEnqueue", "downloadInfo", "prepareDownloadInfoForEnqueue", "remove", "removeAll", "removeAllInGroupWithStatus", "removeAllWithStatus", "removeDownloads", "removeFetchObserversForDownload", "removeGroup", "removeListener", "renameCompletedDownloadFile", "newFileName", "replaceExtras", "extras", "Lcom/tonyodev/fetch2core/Extras;", "resetAutoRetryAttempts", "retryDownload", "resume", "resumeAll", "resumeDownloads", "downloadIds", "resumeGroup", "retry", "setDownloadConcurrentLimit", "downloadConcurrentLimit", "setGlobalNetworkType", "networkType", "Lcom/tonyodev/fetch2/NetworkType;", "startPriorityQueueIfNotStarted", "unfreeze", "updateRequest", "requestId", "newRequest", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchHandlerImpl.kt */
public final class FetchHandlerImpl implements FetchHandler {
    private final boolean autoStart;
    private final boolean createFileOnEnqueue;
    private final DownloadManager downloadManager;
    private final FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper;
    private final FetchNotificationManager fetchNotificationManager;
    private final FileServerDownloader fileServerDownloader;
    private final GroupInfoProvider groupInfoProvider;
    private final Downloader<?, ?> httpDownloader;
    private volatile boolean isTerminating;
    private final ListenerCoordinator listenerCoordinator;
    private final int listenerId = UUID.randomUUID().hashCode();
    private final Set<FetchListener> listenerSet = new LinkedHashSet();
    private final Logger logger;
    private final String namespace;
    private final PriorityListProcessor<Download> priorityListProcessor;
    private final PrioritySort prioritySort;
    private final StorageResolver storageResolver;
    private final Handler uiHandler;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EnqueueAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EnqueueAction.UPDATE_ACCORDINGLY.ordinal()] = 1;
            iArr[EnqueueAction.DO_NOT_ENQUEUE_IF_EXISTING.ordinal()] = 2;
            iArr[EnqueueAction.REPLACE_EXISTING.ordinal()] = 3;
            iArr[EnqueueAction.INCREMENT_FILE_NAME.ordinal()] = 4;
            int[] iArr2 = new int[Status.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Status.COMPLETED.ordinal()] = 1;
            iArr2[Status.FAILED.ordinal()] = 2;
            iArr2[Status.CANCELLED.ordinal()] = 3;
            iArr2[Status.DELETED.ordinal()] = 4;
            iArr2[Status.PAUSED.ordinal()] = 5;
            iArr2[Status.QUEUED.ordinal()] = 6;
            iArr2[Status.REMOVED.ordinal()] = 7;
            iArr2[Status.DOWNLOADING.ordinal()] = 8;
            iArr2[Status.ADDED.ordinal()] = 9;
            iArr2[Status.NONE.ordinal()] = 10;
        }
    }

    public FetchHandlerImpl(String str, FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2, DownloadManager downloadManager2, PriorityListProcessor<? extends Download> priorityListProcessor2, Logger logger2, boolean z, Downloader<?, ?> downloader, FileServerDownloader fileServerDownloader2, ListenerCoordinator listenerCoordinator2, Handler handler, StorageResolver storageResolver2, FetchNotificationManager fetchNotificationManager2, GroupInfoProvider groupInfoProvider2, PrioritySort prioritySort2, boolean z2) {
        FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper3 = fetchDatabaseManagerWrapper2;
        DownloadManager downloadManager3 = downloadManager2;
        PriorityListProcessor<? extends Download> priorityListProcessor3 = priorityListProcessor2;
        Logger logger3 = logger2;
        Downloader<?, ?> downloader2 = downloader;
        FileServerDownloader fileServerDownloader3 = fileServerDownloader2;
        ListenerCoordinator listenerCoordinator3 = listenerCoordinator2;
        Handler handler2 = handler;
        StorageResolver storageResolver3 = storageResolver2;
        GroupInfoProvider groupInfoProvider3 = groupInfoProvider2;
        PrioritySort prioritySort3 = prioritySort2;
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        Intrinsics.checkParameterIsNotNull(fetchDatabaseManagerWrapper3, "fetchDatabaseManagerWrapper");
        Intrinsics.checkParameterIsNotNull(downloadManager3, "downloadManager");
        Intrinsics.checkParameterIsNotNull(priorityListProcessor3, "priorityListProcessor");
        Intrinsics.checkParameterIsNotNull(logger3, "logger");
        Intrinsics.checkParameterIsNotNull(downloader2, "httpDownloader");
        Intrinsics.checkParameterIsNotNull(fileServerDownloader3, "fileServerDownloader");
        Intrinsics.checkParameterIsNotNull(listenerCoordinator3, "listenerCoordinator");
        Intrinsics.checkParameterIsNotNull(handler2, "uiHandler");
        Intrinsics.checkParameterIsNotNull(storageResolver3, "storageResolver");
        Intrinsics.checkParameterIsNotNull(groupInfoProvider3, "groupInfoProvider");
        Intrinsics.checkParameterIsNotNull(prioritySort3, "prioritySort");
        this.namespace = str;
        this.fetchDatabaseManagerWrapper = fetchDatabaseManagerWrapper3;
        this.downloadManager = downloadManager3;
        this.priorityListProcessor = priorityListProcessor3;
        this.logger = logger3;
        this.autoStart = z;
        this.httpDownloader = downloader2;
        this.fileServerDownloader = fileServerDownloader3;
        this.listenerCoordinator = listenerCoordinator3;
        this.uiHandler = handler2;
        this.storageResolver = storageResolver3;
        this.fetchNotificationManager = fetchNotificationManager2;
        this.groupInfoProvider = groupInfoProvider3;
        this.prioritySort = prioritySort3;
        this.createFileOnEnqueue = z2;
    }

    public void init() {
        FetchNotificationManager fetchNotificationManager2 = this.fetchNotificationManager;
        if (fetchNotificationManager2 != null) {
            this.listenerCoordinator.addNotificationManager(fetchNotificationManager2);
        }
        this.fetchDatabaseManagerWrapper.sanitizeOnFirstEntry();
        if (this.autoStart) {
            this.priorityListProcessor.start();
        }
    }

    public Pair<Download, Error> enqueue(Request request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        return (Pair) CollectionsKt.first(enqueueRequests(CollectionsKt.listOf(request)));
    }

    public List<Pair<Download, Error>> enqueue(List<? extends Request> list) {
        Intrinsics.checkParameterIsNotNull(list, DownloadDatabase.TABLE_NAME);
        return enqueueRequests(list);
    }

    public List<Pair<DownloadInfo, Boolean>> enqueueBatch(List<? extends Request> list) {
        Status status;
        Intrinsics.checkParameterIsNotNull(list, DownloadDatabase.TABLE_NAME);
        List arrayList = new ArrayList();
        for (Request request : list) {
            DownloadInfo downloadInfo = FetchTypeConverterExtensions.toDownloadInfo(request, this.fetchDatabaseManagerWrapper.getNewDownloadInfoInstance());
            downloadInfo.setNamespace(this.namespace);
            boolean prepareDownloadInfoForEnqueue = prepareDownloadInfoForEnqueue(downloadInfo);
            if (request.getDownloadOnEnqueue()) {
                status = Status.QUEUED;
            } else {
                status = Status.ADDED;
            }
            downloadInfo.setStatus(status);
            if (downloadInfo.getStatus() != Status.COMPLETED && !prepareDownloadInfoForEnqueue) {
                arrayList.add(downloadInfo);
            }
        }
        List<Pair<DownloadInfo, Boolean>> insert = this.fetchDatabaseManagerWrapper.insert((List<? extends DownloadInfo>) arrayList);
        startPriorityQueueIfNotStarted();
        return insert;
    }

    private final List<Pair<Download, Error>> enqueueRequests(List<? extends Request> list) {
        Status status;
        List<Pair<Download, Error>> arrayList = new ArrayList<>();
        for (Request request : list) {
            DownloadInfo downloadInfo = FetchTypeConverterExtensions.toDownloadInfo(request, this.fetchDatabaseManagerWrapper.getNewDownloadInfoInstance());
            downloadInfo.setNamespace(this.namespace);
            try {
                boolean prepareDownloadInfoForEnqueue = prepareDownloadInfoForEnqueue(downloadInfo);
                if (downloadInfo.getStatus() != Status.COMPLETED) {
                    if (request.getDownloadOnEnqueue()) {
                        status = Status.QUEUED;
                    } else {
                        status = Status.ADDED;
                    }
                    downloadInfo.setStatus(status);
                    if (!prepareDownloadInfoForEnqueue) {
                        Pair<DownloadInfo, Boolean> insert = this.fetchDatabaseManagerWrapper.insert(downloadInfo);
                        this.logger.d("Enqueued download " + insert.getFirst());
                        arrayList.add(new Pair(insert.getFirst(), Error.NONE));
                        startPriorityQueueIfNotStarted();
                    } else {
                        this.fetchDatabaseManagerWrapper.update(downloadInfo);
                        this.logger.d("Updated download " + downloadInfo);
                        arrayList.add(new Pair(downloadInfo, Error.NONE));
                    }
                } else {
                    arrayList.add(new Pair(downloadInfo, Error.NONE));
                }
                if (this.prioritySort == PrioritySort.DESC && !this.downloadManager.canAccommodateNewDownload()) {
                    this.priorityListProcessor.pause();
                }
            } catch (Exception e) {
                Throwable th = e;
                Error errorFromThrowable = FetchErrorUtils.getErrorFromThrowable(th);
                errorFromThrowable.setThrowable(th);
                arrayList.add(new Pair(downloadInfo, errorFromThrowable));
            }
        }
        startPriorityQueueIfNotStarted();
        return arrayList;
    }

    private final boolean prepareDownloadInfoForEnqueue(DownloadInfo downloadInfo) {
        cancelDownloadsIfDownloading(CollectionsKt.listOf(downloadInfo));
        DownloadInfo byFile = this.fetchDatabaseManagerWrapper.getByFile(downloadInfo.getFile());
        if (byFile != null) {
            cancelDownloadsIfDownloading(CollectionsKt.listOf(byFile));
            byFile = this.fetchDatabaseManagerWrapper.getByFile(downloadInfo.getFile());
            String str = "";
            if (byFile == null || byFile.getStatus() != Status.DOWNLOADING) {
                if ((byFile != null ? byFile.getStatus() : null) == Status.COMPLETED && downloadInfo.getEnqueueAction() == EnqueueAction.UPDATE_ACCORDINGLY && !this.storageResolver.fileExists(byFile.getFile())) {
                    try {
                        this.fetchDatabaseManagerWrapper.delete(byFile);
                    } catch (Exception e) {
                        Logger logger2 = this.logger;
                        String message = e.getMessage();
                        if (message != null) {
                            str = message;
                        }
                        logger2.e(str, e);
                    }
                    byFile = null;
                    if (downloadInfo.getEnqueueAction() != EnqueueAction.INCREMENT_FILE_NAME && this.createFileOnEnqueue) {
                        StorageResolver.DefaultImpls.createFile$default(this.storageResolver, downloadInfo.getFile(), false, 2, (Object) null);
                    }
                }
            } else {
                byFile.setStatus(Status.QUEUED);
                try {
                    this.fetchDatabaseManagerWrapper.update(byFile);
                } catch (Exception e2) {
                    Logger logger3 = this.logger;
                    String message2 = e2.getMessage();
                    if (message2 != null) {
                        str = message2;
                    }
                    logger3.e(str, e2);
                }
            }
        } else if (downloadInfo.getEnqueueAction() != EnqueueAction.INCREMENT_FILE_NAME && this.createFileOnEnqueue) {
            StorageResolver.DefaultImpls.createFile$default(this.storageResolver, downloadInfo.getFile(), false, 2, (Object) null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[downloadInfo.getEnqueueAction().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (byFile != null) {
                        deleteDownloads(CollectionsKt.listOf(byFile));
                    }
                    deleteDownloads(CollectionsKt.listOf(downloadInfo));
                    return false;
                } else if (i == 4) {
                    if (this.createFileOnEnqueue) {
                        this.storageResolver.createFile(downloadInfo.getFile(), true);
                    }
                    downloadInfo.setFile(downloadInfo.getFile());
                    downloadInfo.setId(FetchCoreUtils.getUniqueId(downloadInfo.getUrl(), downloadInfo.getFile()));
                    return false;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (byFile == null) {
                return false;
            } else {
                throw new FetchException(FetchErrorStrings.REQUEST_WITH_FILE_PATH_ALREADY_EXIST);
            }
        } else if (byFile == null) {
            return false;
        } else {
            downloadInfo.setDownloaded(byFile.getDownloaded());
            downloadInfo.setTotal(byFile.getTotal());
            downloadInfo.setError(byFile.getError());
            downloadInfo.setStatus(byFile.getStatus());
            if (downloadInfo.getStatus() != Status.COMPLETED) {
                downloadInfo.setStatus(Status.QUEUED);
                downloadInfo.setError(FetchDefaults.getDefaultNoError());
            }
            if (downloadInfo.getStatus() == Status.COMPLETED && !this.storageResolver.fileExists(downloadInfo.getFile())) {
                if (this.createFileOnEnqueue) {
                    StorageResolver.DefaultImpls.createFile$default(this.storageResolver, downloadInfo.getFile(), false, 2, (Object) null);
                }
                downloadInfo.setDownloaded(0);
                downloadInfo.setTotal(-1);
                downloadInfo.setStatus(Status.QUEUED);
                downloadInfo.setError(FetchDefaults.getDefaultNoError());
            }
            return true;
        }
    }

    public Download enqueueCompletedDownload(CompletedDownload completedDownload) {
        Intrinsics.checkParameterIsNotNull(completedDownload, "completedDownload");
        return (Download) CollectionsKt.first(enqueueCompletedDownloads(CollectionsKt.listOf(completedDownload)));
    }

    public List<Download> enqueueCompletedDownloads(List<? extends CompletedDownload> list) {
        Intrinsics.checkParameterIsNotNull(list, "completedDownloads");
        Iterable<CompletedDownload> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (CompletedDownload downloadInfo : iterable) {
            DownloadInfo downloadInfo2 = FetchTypeConverterExtensions.toDownloadInfo(downloadInfo, this.fetchDatabaseManagerWrapper.getNewDownloadInfoInstance());
            downloadInfo2.setNamespace(this.namespace);
            downloadInfo2.setStatus(Status.COMPLETED);
            prepareCompletedDownloadInfoForEnqueue(downloadInfo2);
            Pair<DownloadInfo, Boolean> insert = this.fetchDatabaseManagerWrapper.insert(downloadInfo2);
            this.logger.d("Enqueued CompletedDownload " + insert.getFirst());
            arrayList.add(insert.getFirst());
        }
        return (List) arrayList;
    }

    private final void prepareCompletedDownloadInfoForEnqueue(DownloadInfo downloadInfo) {
        if (this.fetchDatabaseManagerWrapper.getByFile(downloadInfo.getFile()) != null) {
            deleteDownloads(CollectionsKt.listOf(downloadInfo));
        }
    }

    public List<Download> pause(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return pauseDownloads(CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(list)));
    }

    public List<Download> pausedGroup(int i) {
        return pauseDownloads(this.fetchDatabaseManagerWrapper.getByGroup(i));
    }

    private final List<Download> pauseDownloads(List<? extends DownloadInfo> list) {
        cancelDownloadsIfDownloading(list);
        List<Download> arrayList = new ArrayList<>();
        for (DownloadInfo downloadInfo : list) {
            if (FetchUtils.canPauseDownload(downloadInfo)) {
                downloadInfo.setStatus(Status.PAUSED);
                arrayList.add(downloadInfo);
            }
        }
        this.fetchDatabaseManagerWrapper.update((List<? extends DownloadInfo>) arrayList);
        return arrayList;
    }

    public List<Download> pauseAll() {
        return pauseDownloads(this.fetchDatabaseManagerWrapper.get());
    }

    public void freeze() {
        this.priorityListProcessor.pause();
        this.downloadManager.cancelAll();
    }

    public void unfreeze() {
        this.priorityListProcessor.resume();
    }

    public List<Download> resume(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return resumeDownloads(list);
    }

    public List<Download> resumeGroup(int i) {
        Iterable<DownloadInfo> byGroup = this.fetchDatabaseManagerWrapper.getByGroup(i);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(byGroup, 10));
        for (DownloadInfo id : byGroup) {
            arrayList.add(Integer.valueOf(id.getId()));
        }
        return resumeDownloads((List) arrayList);
    }

    private final List<Download> resumeDownloads(List<Integer> list) {
        List<DownloadInfo> filterNotNull = CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(list));
        List<Download> arrayList = new ArrayList<>();
        for (DownloadInfo downloadInfo : filterNotNull) {
            if (!this.downloadManager.contains(downloadInfo.getId()) && FetchUtils.canResumeDownload(downloadInfo)) {
                downloadInfo.setStatus(Status.QUEUED);
                arrayList.add(downloadInfo);
            }
        }
        this.fetchDatabaseManagerWrapper.update((List<? extends DownloadInfo>) arrayList);
        startPriorityQueueIfNotStarted();
        return arrayList;
    }

    public List<Download> resumeAll() {
        Iterable<DownloadInfo> iterable = this.fetchDatabaseManagerWrapper.get();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DownloadInfo id : iterable) {
            arrayList.add(Integer.valueOf(id.getId()));
        }
        return resumeDownloads((List) arrayList);
    }

    public List<Download> remove(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return removeDownloads(CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(list)));
    }

    public List<Download> removeGroup(int i) {
        return removeDownloads(this.fetchDatabaseManagerWrapper.getByGroup(i));
    }

    public List<Download> removeAll() {
        return removeDownloads(this.fetchDatabaseManagerWrapper.get());
    }

    public List<Download> removeAllWithStatus(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return removeDownloads(this.fetchDatabaseManagerWrapper.getByStatus(status));
    }

    public List<Download> removeAllInGroupWithStatus(int i, List<? extends Status> list) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        return removeDownloads(this.fetchDatabaseManagerWrapper.getDownloadsInGroupWithStatus(i, list));
    }

    private final List<Download> removeDownloads(List<? extends DownloadInfo> list) {
        cancelDownloadsIfDownloading(list);
        this.fetchDatabaseManagerWrapper.delete(list);
        for (DownloadInfo downloadInfo : list) {
            downloadInfo.setStatus(Status.REMOVED);
            FetchDatabaseManager.Delegate<DownloadInfo> delegate = this.fetchDatabaseManagerWrapper.getDelegate();
            if (delegate != null) {
                delegate.deleteTempFilesForDownload(downloadInfo);
            }
        }
        return list;
    }

    public List<Download> delete(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return deleteDownloads(CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(list)));
    }

    public List<Download> deleteGroup(int i) {
        return deleteDownloads(this.fetchDatabaseManagerWrapper.getByGroup(i));
    }

    public List<Download> deleteAll() {
        return deleteDownloads(this.fetchDatabaseManagerWrapper.get());
    }

    public List<Download> deleteAllWithStatus(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return deleteDownloads(this.fetchDatabaseManagerWrapper.getByStatus(status));
    }

    public List<Download> deleteAllInGroupWithStatus(int i, List<? extends Status> list) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        return deleteDownloads(this.fetchDatabaseManagerWrapper.getDownloadsInGroupWithStatus(i, list));
    }

    private final List<Download> deleteDownloads(List<? extends DownloadInfo> list) {
        cancelDownloadsIfDownloading(list);
        this.fetchDatabaseManagerWrapper.delete(list);
        for (DownloadInfo downloadInfo : list) {
            downloadInfo.setStatus(Status.DELETED);
            this.storageResolver.deleteFile(downloadInfo.getFile());
            FetchDatabaseManager.Delegate<DownloadInfo> delegate = this.fetchDatabaseManagerWrapper.getDelegate();
            if (delegate != null) {
                delegate.deleteTempFilesForDownload(downloadInfo);
            }
        }
        return list;
    }

    public List<Download> cancel(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return cancelDownloads(CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(list)));
    }

    public List<Download> cancelGroup(int i) {
        return cancelDownloads(this.fetchDatabaseManagerWrapper.getByGroup(i));
    }

    public List<Download> cancelAll() {
        return cancelDownloads(this.fetchDatabaseManagerWrapper.get());
    }

    private final List<Download> cancelDownloads(List<? extends DownloadInfo> list) {
        cancelDownloadsIfDownloading(list);
        List<Download> arrayList = new ArrayList<>();
        for (DownloadInfo downloadInfo : list) {
            if (FetchUtils.canCancelDownload(downloadInfo)) {
                downloadInfo.setStatus(Status.CANCELLED);
                downloadInfo.setError(FetchDefaults.getDefaultNoError());
                arrayList.add(downloadInfo);
            }
        }
        this.fetchDatabaseManagerWrapper.update((List<? extends DownloadInfo>) arrayList);
        return arrayList;
    }

    public List<Download> retry(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        List<DownloadInfo> filterNotNull = CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(list));
        List<Download> arrayList = new ArrayList<>();
        for (DownloadInfo downloadInfo : filterNotNull) {
            if (FetchUtils.canRetryDownload(downloadInfo)) {
                downloadInfo.setStatus(Status.QUEUED);
                downloadInfo.setError(FetchDefaults.getDefaultNoError());
                arrayList.add(downloadInfo);
            }
        }
        this.fetchDatabaseManagerWrapper.update((List<? extends DownloadInfo>) arrayList);
        startPriorityQueueIfNotStarted();
        return arrayList;
    }

    public Download resetAutoRetryAttempts(int i, boolean z) {
        DownloadInfo downloadInfo = this.fetchDatabaseManagerWrapper.get(i);
        if (downloadInfo != null) {
            cancelDownloadsIfDownloading(CollectionsKt.listOf(downloadInfo));
            if (z && FetchUtils.canRetryDownload(downloadInfo)) {
                downloadInfo.setStatus(Status.QUEUED);
                downloadInfo.setError(FetchDefaults.getDefaultNoError());
            }
            downloadInfo.setAutoRetryAttempts(0);
            this.fetchDatabaseManagerWrapper.update(downloadInfo);
            startPriorityQueueIfNotStarted();
        }
        return downloadInfo;
    }

    public Pair<Download, Boolean> updateRequest(int i, Request request) {
        Intrinsics.checkParameterIsNotNull(request, "newRequest");
        DownloadInfo downloadInfo = this.fetchDatabaseManagerWrapper.get(i);
        if (downloadInfo != null) {
            cancelDownloadsIfDownloading(CollectionsKt.listOf(downloadInfo));
            downloadInfo = this.fetchDatabaseManagerWrapper.get(i);
        }
        if (downloadInfo != null) {
            boolean z = true;
            if (Intrinsics.areEqual((Object) request.getFile(), (Object) downloadInfo.getFile())) {
                DownloadInfo downloadInfo2 = FetchTypeConverterExtensions.toDownloadInfo(request, this.fetchDatabaseManagerWrapper.getNewDownloadInfoInstance());
                downloadInfo2.setNamespace(this.namespace);
                downloadInfo2.setDownloaded(downloadInfo.getDownloaded());
                downloadInfo2.setTotal(downloadInfo.getTotal());
                if (downloadInfo.getStatus() == Status.DOWNLOADING) {
                    downloadInfo2.setStatus(Status.QUEUED);
                    downloadInfo2.setError(FetchDefaults.getDefaultNoError());
                } else {
                    downloadInfo2.setStatus(downloadInfo.getStatus());
                    downloadInfo2.setError(downloadInfo.getError());
                }
                this.fetchDatabaseManagerWrapper.delete(downloadInfo);
                this.listenerCoordinator.getMainListener().onDeleted(downloadInfo);
                this.fetchDatabaseManagerWrapper.insert(downloadInfo2);
                startPriorityQueueIfNotStarted();
                return new Pair<>(downloadInfo2, true);
            }
            delete(CollectionsKt.listOf(Integer.valueOf(i)));
            Pair<Download, Error> enqueue = enqueue(request);
            Download first = enqueue.getFirst();
            if (enqueue.getSecond() != Error.NONE) {
                z = false;
            }
            return new Pair<>(first, Boolean.valueOf(z));
        }
        throw new FetchException(FetchErrorStrings.REQUEST_DOES_NOT_EXIST);
    }

    public Download renameCompletedDownloadFile(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "newFileName");
        DownloadInfo downloadInfo = this.fetchDatabaseManagerWrapper.get(i);
        if (downloadInfo == null) {
            throw new FetchException(FetchErrorStrings.REQUEST_DOES_NOT_EXIST);
        } else if (downloadInfo.getStatus() != Status.COMPLETED) {
            throw new FetchException(FetchErrorStrings.FAILED_RENAME_FILE_ASSOCIATED_WITH_INCOMPLETE_DOWNLOAD);
        } else if (this.fetchDatabaseManagerWrapper.getByFile(str) == null) {
            DownloadInfo downloadInfo2 = FetchTypeConverterExtensions.toDownloadInfo((Download) downloadInfo, this.fetchDatabaseManagerWrapper.getNewDownloadInfoInstance());
            downloadInfo2.setId(FetchCoreUtils.getUniqueId(downloadInfo.getUrl(), str));
            downloadInfo2.setFile(str);
            Pair<DownloadInfo, Boolean> insert = this.fetchDatabaseManagerWrapper.insert(downloadInfo2);
            if (!insert.getSecond().booleanValue()) {
                throw new FetchException(FetchErrorStrings.FILE_CANNOT_BE_RENAMED);
            } else if (this.storageResolver.renameFile(downloadInfo.getFile(), str)) {
                this.fetchDatabaseManagerWrapper.delete(downloadInfo);
                return insert.getFirst();
            } else {
                this.fetchDatabaseManagerWrapper.delete(downloadInfo2);
                throw new FetchException(FetchErrorStrings.FILE_CANNOT_BE_RENAMED);
            }
        } else {
            throw new FetchException(FetchErrorStrings.REQUEST_WITH_FILE_PATH_ALREADY_EXIST);
        }
    }

    public Download replaceExtras(int i, Extras extras) {
        Intrinsics.checkParameterIsNotNull(extras, "extras");
        DownloadInfo downloadInfo = this.fetchDatabaseManagerWrapper.get(i);
        if (downloadInfo != null) {
            cancelDownloadsIfDownloading(CollectionsKt.listOf(downloadInfo));
            downloadInfo = this.fetchDatabaseManagerWrapper.get(i);
        }
        if (downloadInfo != null) {
            DownloadInfo updateExtras = this.fetchDatabaseManagerWrapper.updateExtras(i, extras);
            if (updateExtras != null) {
                return updateExtras;
            }
            throw new FetchException(FetchErrorStrings.REQUEST_DOES_NOT_EXIST);
        }
        throw new FetchException(FetchErrorStrings.REQUEST_DOES_NOT_EXIST);
    }

    public List<Download> getDownloads() {
        return this.fetchDatabaseManagerWrapper.get();
    }

    public Download getDownload(int i) {
        return this.fetchDatabaseManagerWrapper.get(i);
    }

    public List<Download> getDownloads(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "idList");
        return CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(list));
    }

    public List<Download> getDownloadsInGroup(int i) {
        return this.fetchDatabaseManagerWrapper.getByGroup(i);
    }

    public List<Download> getDownloadsWithStatus(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return this.fetchDatabaseManagerWrapper.getByStatus(status);
    }

    public List<Download> getDownloadsWithStatus(List<? extends Status> list) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        return this.fetchDatabaseManagerWrapper.getByStatus(list);
    }

    public List<Download> getDownloadsInGroupWithStatus(int i, List<? extends Status> list) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        return this.fetchDatabaseManagerWrapper.getDownloadsInGroupWithStatus(i, list);
    }

    public List<Download> getDownloadsByRequestIdentifier(long j) {
        return this.fetchDatabaseManagerWrapper.getDownloadsByRequestIdentifier(j);
    }

    public List<Integer> getAllGroupIds() {
        return this.fetchDatabaseManagerWrapper.getAllGroupIds();
    }

    public List<Download> getDownloadsByTag(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        return this.fetchDatabaseManagerWrapper.getDownloadsByTag(str);
    }

    public List<DownloadBlock> getDownloadBlocks(int i) {
        long j;
        DownloadInfo downloadInfo = this.fetchDatabaseManagerWrapper.get(i);
        if (downloadInfo == null) {
            return CollectionsKt.emptyList();
        }
        String downloadFileTempDir = this.downloadManager.getDownloadFileTempDir(downloadInfo);
        FileSliceInfo fileSliceInfo = FetchUtils.getFileSliceInfo(FetchUtils.getPreviousSliceCount(downloadInfo.getId(), downloadFileTempDir), downloadInfo.getTotal());
        if (downloadInfo.getTotal() < 1) {
            return CollectionsKt.emptyList();
        }
        long j2 = 0;
        int i2 = 1;
        if (fileSliceInfo.getSlicingCount() < 2) {
            DownloadBlockInfo downloadBlockInfo = new DownloadBlockInfo();
            downloadBlockInfo.setDownloadId(downloadInfo.getId());
            downloadBlockInfo.setBlockPosition(1);
            downloadBlockInfo.setStartByte(0);
            downloadBlockInfo.setEndByte(downloadInfo.getTotal());
            downloadBlockInfo.setDownloadedBytes(downloadInfo.getDownloaded());
            return CollectionsKt.listOf(downloadBlockInfo);
        }
        List<DownloadBlock> arrayList = new ArrayList<>();
        int slicingCount = fileSliceInfo.getSlicingCount();
        if (1 <= slicingCount) {
            while (true) {
                if (fileSliceInfo.getSlicingCount() == i2) {
                    j = downloadInfo.getTotal();
                } else {
                    j = fileSliceInfo.getBytesPerFileSlice() + j2;
                }
                DownloadBlockInfo downloadBlockInfo2 = new DownloadBlockInfo();
                downloadBlockInfo2.setDownloadId(downloadInfo.getId());
                downloadBlockInfo2.setBlockPosition(i2);
                downloadBlockInfo2.setStartByte(j2);
                downloadBlockInfo2.setEndByte(j);
                downloadBlockInfo2.setDownloadedBytes(FetchUtils.getSavedDownloadedInfo(downloadInfo.getId(), i2, downloadFileTempDir));
                arrayList.add(downloadBlockInfo2);
                if (i2 == slicingCount) {
                    break;
                }
                i2++;
                j2 = j;
            }
        }
        return arrayList;
    }

    public long getContentLengthForRequest(Request request, boolean z) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        DownloadInfo downloadInfo = this.fetchDatabaseManagerWrapper.get(request.getId());
        if (downloadInfo != null && downloadInfo.getTotal() > 0) {
            return downloadInfo.getTotal();
        }
        if (!z) {
            return -1;
        }
        if (FetchCoreUtils.isFetchFileServerUrl(request.getUrl())) {
            return this.fileServerDownloader.getRequestContentLength(FetchUtils.getServerRequestFromRequest(request));
        }
        return this.httpDownloader.getRequestContentLength(FetchUtils.getServerRequestFromRequest(request));
    }

    public Downloader.Response getServerResponse(String str, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        Request request = new Request(str, "");
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                request.addHeader((String) next.getKey(), (String) next.getValue());
            }
        }
        Downloader.ServerRequest serverRequestFromRequest = FetchUtils.getServerRequestFromRequest(request);
        FetchHandlerImpl$getServerResponse$interruptMonitor$1 fetchHandlerImpl$getServerResponse$interruptMonitor$1 = new FetchHandlerImpl$getServerResponse$interruptMonitor$1();
        if (FetchCoreUtils.isFetchFileServerUrl(request.getUrl())) {
            Downloader.Response execute = this.fileServerDownloader.execute(serverRequestFromRequest, fetchHandlerImpl$getServerResponse$interruptMonitor$1);
            if (execute != null) {
                Downloader.Response copyDownloadResponseNoStream = FetchCoreUtils.copyDownloadResponseNoStream(execute);
                this.fileServerDownloader.disconnect(execute);
                return copyDownloadResponseNoStream;
            }
        } else {
            Downloader.Response execute2 = this.httpDownloader.execute(serverRequestFromRequest, fetchHandlerImpl$getServerResponse$interruptMonitor$1);
            if (execute2 != null) {
                Downloader.Response copyDownloadResponseNoStream2 = FetchCoreUtils.copyDownloadResponseNoStream(execute2);
                this.httpDownloader.disconnect(execute2);
                return copyDownloadResponseNoStream2;
            }
        }
        throw new IOException(FetchErrorStrings.RESPONSE_NOT_SUCCESSFUL);
    }

    public List<FileResource> getFetchFileServerCatalog(Request request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        return this.fileServerDownloader.getFetchFileServerCatalog(FetchUtils.getCatalogServerRequestFromRequest(request));
    }

    public void close() {
        if (!this.isTerminating) {
            this.isTerminating = true;
            synchronized (this.listenerSet) {
                for (FetchListener removeListener : this.listenerSet) {
                    this.listenerCoordinator.removeListener(this.listenerId, removeListener);
                }
                this.listenerSet.clear();
                Unit unit = Unit.INSTANCE;
            }
            FetchNotificationManager fetchNotificationManager2 = this.fetchNotificationManager;
            if (fetchNotificationManager2 != null) {
                this.listenerCoordinator.removeNotificationManager(fetchNotificationManager2);
                this.listenerCoordinator.cancelOnGoingNotifications(this.fetchNotificationManager);
            }
            this.priorityListProcessor.stop();
            this.priorityListProcessor.close();
            this.downloadManager.close();
            FetchModulesBuilder.INSTANCE.removeNamespaceInstanceReference(this.namespace);
        }
    }

    public void setGlobalNetworkType(NetworkType networkType) {
        Intrinsics.checkParameterIsNotNull(networkType, "networkType");
        this.priorityListProcessor.stop();
        this.priorityListProcessor.setGlobalNetworkType(networkType);
        List<Integer> activeDownloadsIds = this.downloadManager.getActiveDownloadsIds();
        if (!activeDownloadsIds.isEmpty()) {
            List filterNotNull = CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(activeDownloadsIds));
            if (!filterNotNull.isEmpty()) {
                cancelDownloadsIfDownloading(filterNotNull);
                List<DownloadInfo> filterNotNull2 = CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(activeDownloadsIds));
                for (DownloadInfo downloadInfo : filterNotNull2) {
                    if (downloadInfo.getStatus() == Status.DOWNLOADING) {
                        downloadInfo.setStatus(Status.QUEUED);
                        downloadInfo.setError(FetchDefaults.getDefaultNoError());
                    }
                }
                this.fetchDatabaseManagerWrapper.update((List<? extends DownloadInfo>) filterNotNull2);
            }
        }
        this.priorityListProcessor.start();
    }

    public void setDownloadConcurrentLimit(int i) {
        this.priorityListProcessor.stop();
        List<Integer> activeDownloadsIds = this.downloadManager.getActiveDownloadsIds();
        if (!activeDownloadsIds.isEmpty()) {
            List filterNotNull = CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(activeDownloadsIds));
            if (!filterNotNull.isEmpty()) {
                cancelDownloadsIfDownloading(filterNotNull);
                List<DownloadInfo> filterNotNull2 = CollectionsKt.filterNotNull(this.fetchDatabaseManagerWrapper.get(activeDownloadsIds));
                this.downloadManager.setConcurrentLimit(i);
                this.priorityListProcessor.setDownloadConcurrentLimit(i);
                for (DownloadInfo downloadInfo : filterNotNull2) {
                    if (downloadInfo.getStatus() == Status.DOWNLOADING) {
                        downloadInfo.setStatus(Status.QUEUED);
                        downloadInfo.setError(FetchDefaults.getDefaultNoError());
                    }
                }
                this.fetchDatabaseManagerWrapper.update((List<? extends DownloadInfo>) filterNotNull2);
            }
        }
        this.priorityListProcessor.start();
    }

    public void enableLogging(boolean z) {
        this.logger.d("Enable logging - " + z);
        this.logger.setEnabled(z);
    }

    public void addListener(FetchListener fetchListener, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(fetchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.listenerSet) {
            this.listenerSet.add(fetchListener);
        }
        this.listenerCoordinator.addListener(this.listenerId, fetchListener);
        if (z) {
            for (DownloadInfo fetchHandlerImpl$addListener$$inlined$forEach$lambda$1 : this.fetchDatabaseManagerWrapper.get()) {
                this.uiHandler.post(new FetchHandlerImpl$addListener$$inlined$forEach$lambda$1(fetchHandlerImpl$addListener$$inlined$forEach$lambda$1, this, fetchListener));
            }
        }
        this.logger.d("Added listener " + fetchListener);
        if (z2) {
            startPriorityQueueIfNotStarted();
        }
    }

    public void removeListener(FetchListener fetchListener) {
        Intrinsics.checkParameterIsNotNull(fetchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.listenerSet) {
            Iterator<FetchListener> it2 = this.listenerSet.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (Intrinsics.areEqual((Object) it2.next(), (Object) fetchListener)) {
                        it2.remove();
                        this.logger.d("Removed listener " + fetchListener);
                        break;
                    }
                } else {
                    break;
                }
            }
            this.listenerCoordinator.removeListener(this.listenerId, fetchListener);
            Unit unit = Unit.INSTANCE;
        }
    }

    public Set<FetchListener> getListenerSet() {
        Set<FetchListener> set;
        synchronized (this.listenerSet) {
            set = CollectionsKt.toSet(this.listenerSet);
        }
        return set;
    }

    public boolean hasActiveDownloads(boolean z) {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        if (!Intrinsics.areEqual((Object) currentThread, (Object) mainLooper.getThread())) {
            return this.fetchDatabaseManagerWrapper.getPendingCount(z) > 0;
        }
        throw new FetchException(FetchErrorStrings.BLOCKING_CALL_ON_UI_THREAD);
    }

    public long getPendingCount() {
        return this.fetchDatabaseManagerWrapper.getPendingCount(false);
    }

    private final void cancelDownloadsIfDownloading(List<? extends DownloadInfo> list) {
        for (DownloadInfo id : list) {
            this.downloadManager.cancel(id.getId());
        }
    }

    private final void startPriorityQueueIfNotStarted() {
        this.priorityListProcessor.sendBackOffResetSignal();
        if (this.priorityListProcessor.isStopped() && !this.isTerminating) {
            this.priorityListProcessor.start();
        }
        if (this.priorityListProcessor.isPaused() && !this.isTerminating) {
            this.priorityListProcessor.resume();
        }
    }

    public FetchGroup getFetchGroup(int i) {
        return this.groupInfoProvider.getGroupInfo(i, Reason.OBSERVER_ATTACHED);
    }

    public void addFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr) {
        Intrinsics.checkParameterIsNotNull(fetchObserverArr, "fetchObservers");
        this.listenerCoordinator.addFetchObserversForDownload(i, (FetchObserver[]) Arrays.copyOf(fetchObserverArr, fetchObserverArr.length));
    }

    public void removeFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr) {
        Intrinsics.checkParameterIsNotNull(fetchObserverArr, "fetchObservers");
        this.listenerCoordinator.removeFetchObserversForDownload(i, (FetchObserver[]) Arrays.copyOf(fetchObserverArr, fetchObserverArr.length));
    }
}
