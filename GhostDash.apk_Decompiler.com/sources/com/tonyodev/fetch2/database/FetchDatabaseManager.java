package com.tonyodev.fetch2.database;

import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.Logger;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001@J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H&J\b\u0010\u0017\u001a\u00020\u0012H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H&J\u0017\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0019\u001a\u00020\u001aH&¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H&J\u0017\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001f\u001a\u00020 H&¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010#\u001a\u00020\u001aH&J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010%\u001a\u00020&H&J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0016H&J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010)\u001a\u00020*H&J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010,\u001a\u00020 H&J$\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010.\u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0016H&J\r\u0010/\u001a\u00028\u0000H&¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u000bH&J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u00104\u001a\u000205H&J!\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b072\u0006\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u00108J(\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b070\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H&J\b\u00109\u001a\u00020\u0012H&J\u0015\u0010:\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014J\u0016\u0010:\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H&J\u001f\u0010;\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020=H&¢\u0006\u0002\u0010>J\u0015\u0010?\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014R \u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006A"}, d2 = {"Lcom/tonyodev/fetch2/database/FetchDatabaseManager;", "T", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "Ljava/io/Closeable;", "delegate", "Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;", "getDelegate", "()Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;", "setDelegate", "(Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;)V", "isClosed", "", "()Z", "logger", "Lcom/tonyodev/fetch2core/Logger;", "getLogger", "()Lcom/tonyodev/fetch2core/Logger;", "delete", "", "downloadInfo", "(Lcom/tonyodev/fetch2/database/DownloadInfo;)V", "downloadInfoList", "", "deleteAll", "get", "id", "", "(I)Lcom/tonyodev/fetch2/database/DownloadInfo;", "ids", "getAllGroupIds", "getByFile", "file", "", "(Ljava/lang/String;)Lcom/tonyodev/fetch2/database/DownloadInfo;", "getByGroup", "group", "getByStatus", "status", "Lcom/tonyodev/fetch2/Status;", "statuses", "getDownloadsByRequestIdentifier", "identifier", "", "getDownloadsByTag", "tag", "getDownloadsInGroupWithStatus", "groupId", "getNewDownloadInfoInstance", "()Lcom/tonyodev/fetch2/database/DownloadInfo;", "getPendingCount", "includeAddedDownloads", "getPendingDownloadsSorted", "prioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "insert", "Lkotlin/Pair;", "(Lcom/tonyodev/fetch2/database/DownloadInfo;)Lkotlin/Pair;", "sanitizeOnFirstEntry", "update", "updateExtras", "extras", "Lcom/tonyodev/fetch2core/Extras;", "(ILcom/tonyodev/fetch2core/Extras;)Lcom/tonyodev/fetch2/database/DownloadInfo;", "updateFileBytesInfoAndStatusOnly", "Delegate", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchDatabaseManager.kt */
public interface FetchDatabaseManager<T extends DownloadInfo> extends Closeable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;", "T", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "", "deleteTempFilesForDownload", "", "downloadInfo", "(Lcom/tonyodev/fetch2/database/DownloadInfo;)V", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FetchDatabaseManager.kt */
    public interface Delegate<T extends DownloadInfo> {
        void deleteTempFilesForDownload(T t);
    }

    void delete(T t);

    void delete(List<? extends T> list);

    void deleteAll();

    T get(int i);

    List<T> get();

    List<T> get(List<Integer> list);

    List<Integer> getAllGroupIds();

    T getByFile(String str);

    List<T> getByGroup(int i);

    List<T> getByStatus(Status status);

    List<T> getByStatus(List<? extends Status> list);

    Delegate<T> getDelegate();

    List<T> getDownloadsByRequestIdentifier(long j);

    List<T> getDownloadsByTag(String str);

    List<T> getDownloadsInGroupWithStatus(int i, List<? extends Status> list);

    Logger getLogger();

    T getNewDownloadInfoInstance();

    long getPendingCount(boolean z);

    List<T> getPendingDownloadsSorted(PrioritySort prioritySort);

    List<Pair<T, Boolean>> insert(List<? extends T> list);

    Pair<T, Boolean> insert(T t);

    boolean isClosed();

    void sanitizeOnFirstEntry();

    void setDelegate(Delegate<T> delegate);

    void update(T t);

    void update(List<? extends T> list);

    T updateExtras(int i, Extras extras);

    void updateFileBytesInfoAndStatusOnly(T t);
}
