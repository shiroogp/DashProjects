package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.CompletedDownload;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchGroup;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2core.DownloadBlock;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.FileResource;
import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\"\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0016\u001a\u00020\u0005H&J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H&J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0012H&J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001e\u001a\u00020\u001cH&J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0016\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000fH&J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H&J(\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020$0#0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0012H&J(\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0#0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0012H&J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H&J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u0012H&J\b\u0010/\u001a\u00020\u0003H&J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&J\u0018\u00101\u001a\u0002022\u0006\u0010%\u001a\u00020&2\u0006\u00103\u001a\u00020\u000fH&J\u0012\u00104\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0005H&J\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00122\u0006\u0010\u0016\u001a\u00020\u0005H&J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H&J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010:\u001a\u000202H&J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010<\u001a\u00020=H&J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0016\u001a\u00020\u0005H&J$\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0012H&J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001e\u001a\u00020\u001cH&J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0012H&J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00122\u0006\u0010%\u001a\u00020&H&J\u0010\u0010C\u001a\u00020D2\u0006\u0010\u0016\u001a\u00020\u0005H&J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\r0FH&J\b\u0010G\u001a\u000202H&J(\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020=2\u0016\b\u0002\u0010K\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=\u0018\u00010LH&J\u0010\u0010M\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u000fH&J\b\u0010O\u001a\u00020\u0003H&J\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H&J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0016\u001a\u00020\u0005H&J\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H&J$\u0010U\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0012H&J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001e\u001a\u00020\u001cH&J5\u0010W\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\"\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0002\u0010\nJ\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0016\u001a\u00020\u0005H&J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010Z\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010[\u001a\u00020=H&J\u0018\u0010\\\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010]\u001a\u00020^H&J\u001a\u0010_\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u000fH&J\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&J\u000e\u0010b\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H&J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u0016\u001a\u00020\u0005H&J\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&J\u0010\u0010e\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\u0005H&J\u0010\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020iH&J\b\u0010j\u001a\u00020\u0003H&J$\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0#2\u0006\u0010l\u001a\u00020\u00052\u0006\u0010m\u001a\u00020&H&¨\u0006n"}, d2 = {"Lcom/tonyodev/fetch2/fetch/FetchHandler;", "Ljava/io/Closeable;", "addFetchObserversForDownload", "", "downloadId", "", "fetchObservers", "", "Lcom/tonyodev/fetch2core/FetchObserver;", "Lcom/tonyodev/fetch2/Download;", "(I[Lcom/tonyodev/fetch2core/FetchObserver;)V", "addListener", "listener", "Lcom/tonyodev/fetch2/FetchListener;", "notify", "", "autoStart", "cancel", "", "ids", "cancelAll", "cancelGroup", "id", "delete", "deleteAll", "deleteAllInGroupWithStatus", "groupId", "statuses", "Lcom/tonyodev/fetch2/Status;", "deleteAllWithStatus", "status", "deleteGroup", "enableLogging", "enabled", "enqueue", "Lkotlin/Pair;", "Lcom/tonyodev/fetch2/Error;", "request", "Lcom/tonyodev/fetch2/Request;", "requests", "enqueueBatch", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "enqueueCompletedDownload", "completedDownload", "Lcom/tonyodev/fetch2/CompletedDownload;", "enqueueCompletedDownloads", "completedDownloads", "freeze", "getAllGroupIds", "getContentLengthForRequest", "", "fromServer", "getDownload", "getDownloadBlocks", "Lcom/tonyodev/fetch2core/DownloadBlock;", "getDownloads", "idList", "getDownloadsByRequestIdentifier", "identifier", "getDownloadsByTag", "tag", "", "getDownloadsInGroup", "getDownloadsInGroupWithStatus", "getDownloadsWithStatus", "getFetchFileServerCatalog", "Lcom/tonyodev/fetch2core/FileResource;", "getFetchGroup", "Lcom/tonyodev/fetch2/FetchGroup;", "getListenerSet", "", "getPendingCount", "getServerResponse", "Lcom/tonyodev/fetch2core/Downloader$Response;", "url", "header", "", "hasActiveDownloads", "includeAddedDownloads", "init", "pause", "pauseAll", "pausedGroup", "remove", "removeAll", "removeAllInGroupWithStatus", "removeAllWithStatus", "removeFetchObserversForDownload", "removeGroup", "removeListener", "renameCompletedDownloadFile", "newFileName", "replaceExtras", "extras", "Lcom/tonyodev/fetch2core/Extras;", "resetAutoRetryAttempts", "retryDownload", "resume", "resumeAll", "resumeGroup", "retry", "setDownloadConcurrentLimit", "downloadConcurrentLimit", "setGlobalNetworkType", "networkType", "Lcom/tonyodev/fetch2/NetworkType;", "unfreeze", "updateRequest", "requestId", "newRequest", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchHandler.kt */
public interface FetchHandler extends Closeable {
    void addFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr);

    void addListener(FetchListener fetchListener, boolean z, boolean z2);

    List<Download> cancel(List<Integer> list);

    List<Download> cancelAll();

    List<Download> cancelGroup(int i);

    List<Download> delete(List<Integer> list);

    List<Download> deleteAll();

    List<Download> deleteAllInGroupWithStatus(int i, List<? extends Status> list);

    List<Download> deleteAllWithStatus(Status status);

    List<Download> deleteGroup(int i);

    void enableLogging(boolean z);

    List<Pair<Download, Error>> enqueue(List<? extends Request> list);

    Pair<Download, Error> enqueue(Request request);

    List<Pair<DownloadInfo, Boolean>> enqueueBatch(List<? extends Request> list);

    Download enqueueCompletedDownload(CompletedDownload completedDownload);

    List<Download> enqueueCompletedDownloads(List<? extends CompletedDownload> list);

    void freeze();

    List<Integer> getAllGroupIds();

    long getContentLengthForRequest(Request request, boolean z);

    Download getDownload(int i);

    List<DownloadBlock> getDownloadBlocks(int i);

    List<Download> getDownloads();

    List<Download> getDownloads(List<Integer> list);

    List<Download> getDownloadsByRequestIdentifier(long j);

    List<Download> getDownloadsByTag(String str);

    List<Download> getDownloadsInGroup(int i);

    List<Download> getDownloadsInGroupWithStatus(int i, List<? extends Status> list);

    List<Download> getDownloadsWithStatus(Status status);

    List<Download> getDownloadsWithStatus(List<? extends Status> list);

    List<FileResource> getFetchFileServerCatalog(Request request);

    FetchGroup getFetchGroup(int i);

    Set<FetchListener> getListenerSet();

    long getPendingCount();

    Downloader.Response getServerResponse(String str, Map<String, String> map);

    boolean hasActiveDownloads(boolean z);

    void init();

    List<Download> pause(List<Integer> list);

    List<Download> pauseAll();

    List<Download> pausedGroup(int i);

    List<Download> remove(List<Integer> list);

    List<Download> removeAll();

    List<Download> removeAllInGroupWithStatus(int i, List<? extends Status> list);

    List<Download> removeAllWithStatus(Status status);

    void removeFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr);

    List<Download> removeGroup(int i);

    void removeListener(FetchListener fetchListener);

    Download renameCompletedDownloadFile(int i, String str);

    Download replaceExtras(int i, Extras extras);

    Download resetAutoRetryAttempts(int i, boolean z);

    List<Download> resume(List<Integer> list);

    List<Download> resumeAll();

    List<Download> resumeGroup(int i);

    List<Download> retry(List<Integer> list);

    void setDownloadConcurrentLimit(int i);

    void setGlobalNetworkType(NetworkType networkType);

    void unfreeze();

    Pair<Download, Boolean> updateRequest(int i, Request request);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* compiled from: FetchHandler.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Downloader.Response getServerResponse$default(FetchHandler fetchHandler, String str, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = null;
                }
                return fetchHandler.getServerResponse(str, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getServerResponse");
        }
    }
}
