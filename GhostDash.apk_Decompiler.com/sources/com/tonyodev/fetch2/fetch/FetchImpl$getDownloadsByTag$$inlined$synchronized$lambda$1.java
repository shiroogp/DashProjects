package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2core.Func;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$getDownloadsByTag$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$getDownloadsByTag$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Func $func$inlined;
    final /* synthetic */ String $tag$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$getDownloadsByTag$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, String str, Func func) {
        super(0);
        this.this$0 = fetchImpl;
        this.$tag$inlined = str;
        this.$func$inlined = func;
    }

    public final void invoke() {
        final List<Download> downloadsByTag = this.this$0.fetchHandler.getDownloadsByTag(this.$tag$inlined);
        this.this$0.uiHandler.post(new Runnable(this) {
            final /* synthetic */ FetchImpl$getDownloadsByTag$$inlined$synchronized$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.$func$inlined.call(downloadsByTag);
            }
        });
    }
}
