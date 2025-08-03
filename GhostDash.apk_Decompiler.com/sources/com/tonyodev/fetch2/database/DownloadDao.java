package com.tonyodev.fetch2.database;

import com.tonyodev.fetch2.Status;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\b\u0010\b\u001a\u00020\u0003H'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H'J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0012\u001a\u00020\u000bH'J)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0007H'J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0018\u001a\u00020\u0015H'J!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0007H'J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u001a\u001a\u00020\u001bH'J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u001d\u001a\u00020\u0010H'J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0018\u001a\u00020\u0015H'J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0018\u001a\u00020\u0015H'J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0005H'J\u0016\u0010!\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'¨\u0006#"}, d2 = {"Lcom/tonyodev/fetch2/database/DownloadDao;", "", "delete", "", "downloadInfo", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "downloadInfoList", "", "deleteAll", "get", "id", "", "ids", "getAllGroupIds", "getByFile", "file", "", "getByGroup", "group", "getByGroupWithStatus", "statuses", "Lcom/tonyodev/fetch2/Status;", "Lkotlin/jvm/JvmSuppressWildcards;", "getByStatus", "status", "getDownloadsByRequestIdentifier", "identifier", "", "getDownloadsByTag", "tag", "getPendingDownloadsSorted", "getPendingDownloadsSortedDesc", "insert", "update", "download", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadDao.kt */
public interface DownloadDao {
    void delete(DownloadInfo downloadInfo);

    void delete(List<? extends DownloadInfo> list);

    void deleteAll();

    DownloadInfo get(int i);

    List<DownloadInfo> get();

    List<DownloadInfo> get(List<Integer> list);

    List<Integer> getAllGroupIds();

    DownloadInfo getByFile(String str);

    List<DownloadInfo> getByGroup(int i);

    List<DownloadInfo> getByGroupWithStatus(int i, List<Status> list);

    List<DownloadInfo> getByStatus(Status status);

    List<DownloadInfo> getByStatus(List<Status> list);

    List<DownloadInfo> getDownloadsByRequestIdentifier(long j);

    List<DownloadInfo> getDownloadsByTag(String str);

    List<DownloadInfo> getPendingDownloadsSorted(Status status);

    List<DownloadInfo> getPendingDownloadsSortedDesc(Status status);

    long insert(DownloadInfo downloadInfo);

    List<Long> insert(List<? extends DownloadInfo> list);

    void update(DownloadInfo downloadInfo);

    void update(List<? extends DownloadInfo> list);
}
