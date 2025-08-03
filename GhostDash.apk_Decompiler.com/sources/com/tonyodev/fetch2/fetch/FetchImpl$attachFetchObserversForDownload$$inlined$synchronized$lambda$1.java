package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2core.FetchObserver;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$attachFetchObserversForDownload$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$attachFetchObserversForDownload$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $downloadId$inlined;
    final /* synthetic */ FetchObserver[] $fetchObservers$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$attachFetchObserversForDownload$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, int i, FetchObserver[] fetchObserverArr) {
        super(0);
        this.this$0 = fetchImpl;
        this.$downloadId$inlined = i;
        this.$fetchObservers$inlined = fetchObserverArr;
    }

    public final void invoke() {
        FetchHandler access$getFetchHandler$p = this.this$0.fetchHandler;
        int i = this.$downloadId$inlined;
        FetchObserver[] fetchObserverArr = this.$fetchObservers$inlined;
        access$getFetchHandler$p.addFetchObserversForDownload(i, (FetchObserver[]) Arrays.copyOf(fetchObserverArr, fetchObserverArr.length));
    }
}
