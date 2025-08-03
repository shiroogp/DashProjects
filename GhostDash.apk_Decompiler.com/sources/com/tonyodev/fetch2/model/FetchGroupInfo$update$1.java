package com.tonyodev.fetch2.model;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.FetchGroupObserver;
import com.tonyodev.fetch2core.Reason;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchGroupInfo.kt */
final class FetchGroupInfo$update$1 implements Runnable {
    final /* synthetic */ List $downloads;
    final /* synthetic */ Reason $reason;
    final /* synthetic */ Download $triggerDownload;
    final /* synthetic */ FetchGroupInfo this$0;

    FetchGroupInfo$update$1(FetchGroupInfo fetchGroupInfo, List list, Reason reason, Download download) {
        this.this$0 = fetchGroupInfo;
        this.$downloads = list;
        this.$reason = reason;
        this.$triggerDownload = download;
    }

    public final void run() {
        synchronized (this.this$0.observerSet) {
            for (FetchGroupObserver fetchGroupObserver : this.this$0.observerSet) {
                fetchGroupObserver.onChanged(this.$downloads, this.$reason);
                Download download = this.$triggerDownload;
                if (download != null) {
                    fetchGroupObserver.onChanged(this.$downloads, download, this.$reason);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
