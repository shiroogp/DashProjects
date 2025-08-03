package com.tonyodev.fetch2.model;

import com.tonyodev.fetch2.FetchGroupObserver;
import com.tonyodev.fetch2core.Reason;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/tonyodev/fetch2/model/FetchGroupInfo$addFetchGroupObservers$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchGroupInfo.kt */
final class FetchGroupInfo$addFetchGroupObservers$$inlined$synchronized$lambda$1 implements Runnable {
    final /* synthetic */ List $addedObservers;
    final /* synthetic */ FetchGroupObserver[] $fetchGroupObservers$inlined;
    final /* synthetic */ FetchGroupInfo this$0;

    FetchGroupInfo$addFetchGroupObservers$$inlined$synchronized$lambda$1(List list, FetchGroupInfo fetchGroupInfo, FetchGroupObserver[] fetchGroupObserverArr) {
        this.$addedObservers = list;
        this.this$0 = fetchGroupInfo;
        this.$fetchGroupObservers$inlined = fetchGroupObserverArr;
    }

    public final void run() {
        for (FetchGroupObserver onChanged : this.$addedObservers) {
            onChanged.onChanged(this.this$0.getDownloads(), Reason.OBSERVER_ATTACHED);
        }
    }
}
