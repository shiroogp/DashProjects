package com.tonyodev.fetch2.database;

import com.facebook.common.util.UriUtil;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.FetchDatabaseManager;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001aH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001aH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001aH\u0016J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010.\u001a\u00020#H\u0016J$\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u00100\u001a\u00020\u001e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001aH\u0016J\b\u00101\u001a\u00020\u0002H\u0016J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\rH\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u00105\u001a\u000206H\u0016J\u001c\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r082\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J(\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r080\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\b\u00109\u001a\u00020\u0016H\u0016J\u0010\u0010:\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0016\u0010:\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\u001a\u0010;\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R4\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006?"}, d2 = {"Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "Lcom/tonyodev/fetch2/database/FetchDatabaseManager;", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "fetchDatabaseManager", "(Lcom/tonyodev/fetch2/database/FetchDatabaseManager;)V", "value", "Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;", "delegate", "getDelegate", "()Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;", "setDelegate", "(Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;)V", "isClosed", "", "()Z", "lock", "", "logger", "Lcom/tonyodev/fetch2core/Logger;", "getLogger", "()Lcom/tonyodev/fetch2core/Logger;", "close", "", "delete", "downloadInfo", "downloadInfoList", "", "deleteAll", "get", "id", "", "ids", "getAllGroupIds", "getByFile", "file", "", "getByGroup", "group", "getByStatus", "status", "Lcom/tonyodev/fetch2/Status;", "statuses", "getDownloadsByRequestIdentifier", "identifier", "", "getDownloadsByTag", "tag", "getDownloadsInGroupWithStatus", "groupId", "getNewDownloadInfoInstance", "getPendingCount", "includeAddedDownloads", "getPendingDownloadsSorted", "prioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "insert", "Lkotlin/Pair;", "sanitizeOnFirstEntry", "update", "updateExtras", "extras", "Lcom/tonyodev/fetch2core/Extras;", "updateFileBytesInfoAndStatusOnly", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchDatabaseManagerWrapper.kt */
public final class FetchDatabaseManagerWrapper implements FetchDatabaseManager<DownloadInfo> {
    private final FetchDatabaseManager<DownloadInfo> fetchDatabaseManager;
    private final Object lock = new Object();
    private final Logger logger;

    public FetchDatabaseManagerWrapper(FetchDatabaseManager<DownloadInfo> fetchDatabaseManager2) {
        Intrinsics.checkParameterIsNotNull(fetchDatabaseManager2, "fetchDatabaseManager");
        this.fetchDatabaseManager = fetchDatabaseManager2;
        this.logger = fetchDatabaseManager2.getLogger();
    }

    public Logger getLogger() {
        return this.logger;
    }

    public boolean isClosed() {
        boolean isClosed;
        synchronized (this.lock) {
            isClosed = this.fetchDatabaseManager.isClosed();
        }
        return isClosed;
    }

    public FetchDatabaseManager.Delegate<DownloadInfo> getDelegate() {
        FetchDatabaseManager.Delegate<DownloadInfo> delegate;
        synchronized (this.lock) {
            delegate = this.fetchDatabaseManager.getDelegate();
        }
        return delegate;
    }

    public void setDelegate(FetchDatabaseManager.Delegate<DownloadInfo> delegate) {
        synchronized (this.lock) {
            this.fetchDatabaseManager.setDelegate(delegate);
            Unit unit = Unit.INSTANCE;
        }
    }

    public Pair<DownloadInfo, Boolean> insert(DownloadInfo downloadInfo) {
        Pair<DownloadInfo, Boolean> insert;
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        synchronized (this.lock) {
            insert = this.fetchDatabaseManager.insert(downloadInfo);
        }
        return insert;
    }

    public List<Pair<DownloadInfo, Boolean>> insert(List<? extends DownloadInfo> list) {
        List<Pair<DownloadInfo, Boolean>> insert;
        Intrinsics.checkParameterIsNotNull(list, "downloadInfoList");
        synchronized (this.lock) {
            insert = this.fetchDatabaseManager.insert(list);
        }
        return insert;
    }

    public void delete(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        synchronized (this.lock) {
            this.fetchDatabaseManager.delete(downloadInfo);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void delete(List<? extends DownloadInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "downloadInfoList");
        synchronized (this.lock) {
            this.fetchDatabaseManager.delete(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void deleteAll() {
        synchronized (this.lock) {
            this.fetchDatabaseManager.deleteAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void update(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        synchronized (this.lock) {
            this.fetchDatabaseManager.update(downloadInfo);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void update(List<? extends DownloadInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "downloadInfoList");
        synchronized (this.lock) {
            this.fetchDatabaseManager.update(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void updateFileBytesInfoAndStatusOnly(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        synchronized (this.lock) {
            this.fetchDatabaseManager.updateFileBytesInfoAndStatusOnly(downloadInfo);
            Unit unit = Unit.INSTANCE;
        }
    }

    public List<DownloadInfo> get() {
        List<DownloadInfo> list;
        synchronized (this.lock) {
            list = this.fetchDatabaseManager.get();
        }
        return list;
    }

    public DownloadInfo get(int i) {
        DownloadInfo downloadInfo;
        synchronized (this.lock) {
            downloadInfo = this.fetchDatabaseManager.get(i);
        }
        return downloadInfo;
    }

    public List<DownloadInfo> get(List<Integer> list) {
        List<DownloadInfo> list2;
        Intrinsics.checkParameterIsNotNull(list, "ids");
        synchronized (this.lock) {
            list2 = this.fetchDatabaseManager.get(list);
        }
        return list2;
    }

    public DownloadInfo getByFile(String str) {
        DownloadInfo byFile;
        Intrinsics.checkParameterIsNotNull(str, UriUtil.LOCAL_FILE_SCHEME);
        synchronized (this.lock) {
            byFile = this.fetchDatabaseManager.getByFile(str);
        }
        return byFile;
    }

    public List<DownloadInfo> getByStatus(Status status) {
        List<DownloadInfo> byStatus;
        Intrinsics.checkParameterIsNotNull(status, "status");
        synchronized (this.lock) {
            byStatus = this.fetchDatabaseManager.getByStatus(status);
        }
        return byStatus;
    }

    public List<DownloadInfo> getByStatus(List<? extends Status> list) {
        List<DownloadInfo> byStatus;
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        synchronized (this.lock) {
            byStatus = this.fetchDatabaseManager.getByStatus(list);
        }
        return byStatus;
    }

    public List<DownloadInfo> getByGroup(int i) {
        List<DownloadInfo> byGroup;
        synchronized (this.lock) {
            byGroup = this.fetchDatabaseManager.getByGroup(i);
        }
        return byGroup;
    }

    public List<Integer> getAllGroupIds() {
        List<Integer> allGroupIds;
        synchronized (this.lock) {
            allGroupIds = this.fetchDatabaseManager.getAllGroupIds();
        }
        return allGroupIds;
    }

    public List<DownloadInfo> getDownloadsByTag(String str) {
        List<DownloadInfo> downloadsByTag;
        Intrinsics.checkParameterIsNotNull(str, "tag");
        synchronized (this.lock) {
            downloadsByTag = this.fetchDatabaseManager.getDownloadsByTag(str);
        }
        return downloadsByTag;
    }

    public List<DownloadInfo> getDownloadsInGroupWithStatus(int i, List<? extends Status> list) {
        List<DownloadInfo> downloadsInGroupWithStatus;
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        synchronized (this.lock) {
            downloadsInGroupWithStatus = this.fetchDatabaseManager.getDownloadsInGroupWithStatus(i, list);
        }
        return downloadsInGroupWithStatus;
    }

    public List<DownloadInfo> getDownloadsByRequestIdentifier(long j) {
        List<DownloadInfo> downloadsByRequestIdentifier;
        synchronized (this.lock) {
            downloadsByRequestIdentifier = this.fetchDatabaseManager.getDownloadsByRequestIdentifier(j);
        }
        return downloadsByRequestIdentifier;
    }

    public List<DownloadInfo> getPendingDownloadsSorted(PrioritySort prioritySort) {
        List<DownloadInfo> pendingDownloadsSorted;
        Intrinsics.checkParameterIsNotNull(prioritySort, "prioritySort");
        synchronized (this.lock) {
            pendingDownloadsSorted = this.fetchDatabaseManager.getPendingDownloadsSorted(prioritySort);
        }
        return pendingDownloadsSorted;
    }

    public void sanitizeOnFirstEntry() {
        synchronized (this.lock) {
            this.fetchDatabaseManager.sanitizeOnFirstEntry();
            Unit unit = Unit.INSTANCE;
        }
    }

    public DownloadInfo updateExtras(int i, Extras extras) {
        DownloadInfo updateExtras;
        Intrinsics.checkParameterIsNotNull(extras, "extras");
        synchronized (this.lock) {
            updateExtras = this.fetchDatabaseManager.updateExtras(i, extras);
        }
        return updateExtras;
    }

    public long getPendingCount(boolean z) {
        long pendingCount;
        synchronized (this.lock) {
            pendingCount = this.fetchDatabaseManager.getPendingCount(z);
        }
        return pendingCount;
    }

    public DownloadInfo getNewDownloadInfoInstance() {
        return this.fetchDatabaseManager.getNewDownloadInfoInstance();
    }

    public void close() {
        synchronized (this.lock) {
            this.fetchDatabaseManager.close();
            Unit unit = Unit.INSTANCE;
        }
    }
}
