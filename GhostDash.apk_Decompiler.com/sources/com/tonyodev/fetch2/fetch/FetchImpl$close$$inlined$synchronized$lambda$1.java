package com.tonyodev.fetch2.fetch;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$close$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$close$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$close$$inlined$synchronized$lambda$1(FetchImpl fetchImpl) {
        super(0);
        this.this$0 = fetchImpl;
    }

    public final void invoke() {
        try {
            this.this$0.fetchHandler.close();
        } catch (Exception e) {
            this.this$0.logger.e("exception occurred whiles shutting down Fetch with namespace:" + this.this$0.getNamespace(), e);
        }
    }
}
