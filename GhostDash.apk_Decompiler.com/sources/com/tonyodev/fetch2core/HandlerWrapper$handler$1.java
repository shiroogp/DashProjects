package com.tonyodev.fetch2core;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: HandlerWrapper.kt */
final class HandlerWrapper$handler$1 extends Lambda implements Function0<Handler> {
    final /* synthetic */ HandlerWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandlerWrapper$handler$1(HandlerWrapper handlerWrapper) {
        super(0);
        this.this$0 = handlerWrapper;
    }

    public final Handler invoke() {
        HandlerThread handlerThread = new HandlerThread(this.this$0.getNamespace());
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }
}
