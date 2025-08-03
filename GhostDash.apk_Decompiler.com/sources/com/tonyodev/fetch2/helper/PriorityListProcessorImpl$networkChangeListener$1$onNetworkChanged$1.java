package com.tonyodev.fetch2.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PriorityListProcessorImpl.kt */
final class PriorityListProcessorImpl$networkChangeListener$1$onNetworkChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PriorityListProcessorImpl$networkChangeListener$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PriorityListProcessorImpl$networkChangeListener$1$onNetworkChanged$1(PriorityListProcessorImpl$networkChangeListener$1 priorityListProcessorImpl$networkChangeListener$1) {
        super(0);
        this.this$0 = priorityListProcessorImpl$networkChangeListener$1;
    }

    public final void invoke() {
        if (!this.this$0.this$0.stopped && !this.this$0.this$0.paused && this.this$0.this$0.networkInfoProvider.isNetworkAvailable() && this.this$0.this$0.backOffTime > 500) {
            this.this$0.this$0.resetBackOffTime();
        }
    }
}
