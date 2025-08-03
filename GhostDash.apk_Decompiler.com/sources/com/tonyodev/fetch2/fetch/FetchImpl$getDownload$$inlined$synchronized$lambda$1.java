package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2core.Func2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$getDownload$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$getDownload$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Func2 $func2$inlined;
    final /* synthetic */ int $id$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$getDownload$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, int i, Func2 func2) {
        super(0);
        this.this$0 = fetchImpl;
        this.$id$inlined = i;
        this.$func2$inlined = func2;
    }

    public final void invoke() {
        final Download download = this.this$0.fetchHandler.getDownload(this.$id$inlined);
        this.this$0.uiHandler.post(new Runnable(this) {
            final /* synthetic */ FetchImpl$getDownload$$inlined$synchronized$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.$func2$inlined.call(download);
            }
        });
    }
}
