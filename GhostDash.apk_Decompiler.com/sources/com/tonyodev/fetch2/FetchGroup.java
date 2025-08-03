package com.tonyodev.fetch2;

import com.tonyodev.fetch2core.FetchObserver;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010(\u001a\u00020)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0+\"\u00020,H&¢\u0006\u0002\u0010-J!\u0010.\u001a\u00020)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0+\"\u00020,H&¢\u0006\u0002\u0010-R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0012\u0010\u0019\u001a\u00020\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001f0\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0006R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0006R\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0006¨\u0006/"}, d2 = {"Lcom/tonyodev/fetch2/FetchGroup;", "", "addedDownloads", "", "Lcom/tonyodev/fetch2/Download;", "getAddedDownloads", "()Ljava/util/List;", "cancelledDownloads", "getCancelledDownloads", "completedDownloads", "getCompletedDownloads", "deletedDownloads", "getDeletedDownloads", "downloadingDownloads", "getDownloadingDownloads", "downloads", "getDownloads", "failedDownloads", "getFailedDownloads", "groupDownloadProgress", "", "getGroupDownloadProgress", "()I", "id", "getId", "namespace", "", "getNamespace", "()Ljava/lang/String;", "observers", "", "Lcom/tonyodev/fetch2core/FetchObserver;", "getObservers", "()Ljava/util/Set;", "pausedDownloads", "getPausedDownloads", "queuedDownloads", "getQueuedDownloads", "removedDownloads", "getRemovedDownloads", "addFetchGroupObservers", "", "fetchGroupObservers", "", "Lcom/tonyodev/fetch2/FetchGroupObserver;", "([Lcom/tonyodev/fetch2/FetchGroupObserver;)V", "removeFetchGroupObservers", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchGroup.kt */
public interface FetchGroup {
    void addFetchGroupObservers(FetchGroupObserver... fetchGroupObserverArr);

    List<Download> getAddedDownloads();

    List<Download> getCancelledDownloads();

    List<Download> getCompletedDownloads();

    List<Download> getDeletedDownloads();

    List<Download> getDownloadingDownloads();

    List<Download> getDownloads();

    List<Download> getFailedDownloads();

    int getGroupDownloadProgress();

    int getId();

    String getNamespace();

    Set<FetchObserver<List<Download>>> getObservers();

    List<Download> getPausedDownloads();

    List<Download> getQueuedDownloads();

    List<Download> getRemovedDownloads();

    void removeFetchGroupObservers(FetchGroupObserver... fetchGroupObserverArr);
}
