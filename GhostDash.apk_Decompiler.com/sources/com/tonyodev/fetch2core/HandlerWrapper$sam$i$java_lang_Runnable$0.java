package com.tonyodev.fetch2core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: HandlerWrapper.kt */
public final class HandlerWrapper$sam$i$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    public HandlerWrapper$sam$i$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(), "invoke(...)");
    }
}
