package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.FetchListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$addListener$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$addListener$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $autoStart$inlined;
    final /* synthetic */ FetchListener $listener$inlined;
    final /* synthetic */ boolean $notify$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$addListener$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, FetchListener fetchListener, boolean z, boolean z2) {
        super(0);
        this.this$0 = fetchImpl;
        this.$listener$inlined = fetchListener;
        this.$notify$inlined = z;
        this.$autoStart$inlined = z2;
    }

    public final void invoke() {
        this.this$0.fetchHandler.addListener(this.$listener$inlined, this.$notify$inlined, this.$autoStart$inlined);
    }
}
