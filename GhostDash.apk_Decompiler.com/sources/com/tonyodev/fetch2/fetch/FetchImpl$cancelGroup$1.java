package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tonyodev/fetch2/Download;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$cancelGroup$1 extends Lambda implements Function0<List<? extends Download>> {
    final /* synthetic */ int $id;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$cancelGroup$1(FetchImpl fetchImpl, int i) {
        super(0);
        this.this$0 = fetchImpl;
        this.$id = i;
    }

    public final List<Download> invoke() {
        return this.this$0.fetchHandler.cancelGroup(this.$id);
    }
}
