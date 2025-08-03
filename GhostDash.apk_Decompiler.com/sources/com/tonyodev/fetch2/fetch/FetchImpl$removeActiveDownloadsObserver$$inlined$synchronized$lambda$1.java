package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.util.ActiveDownloadInfo;
import com.tonyodev.fetch2core.FetchObserver;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$removeActiveDownloadsObserver$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$removeActiveDownloadsObserver$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FetchObserver $fetchObserver$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$removeActiveDownloadsObserver$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, FetchObserver fetchObserver) {
        super(0);
        this.this$0 = fetchImpl;
        this.$fetchObserver$inlined = fetchObserver;
    }

    public final void invoke() {
        Iterator it2 = this.this$0.activeDownloadsSet.iterator();
        while (it2.hasNext()) {
            if (Intrinsics.areEqual((Object) ((ActiveDownloadInfo) it2.next()).getFetchObserver(), (Object) this.$fetchObserver$inlined)) {
                it2.remove();
                this.this$0.logger.d("Removed ActiveDownload FetchObserver " + this.$fetchObserver$inlined);
                return;
            }
        }
    }
}
