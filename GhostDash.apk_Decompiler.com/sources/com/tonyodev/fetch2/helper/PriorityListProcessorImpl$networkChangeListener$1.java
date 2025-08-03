package com.tonyodev.fetch2.helper;

import com.tonyodev.fetch2.provider.NetworkInfoProvider;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tonyodev/fetch2/helper/PriorityListProcessorImpl$networkChangeListener$1", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider$NetworkChangeListener;", "onNetworkChanged", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PriorityListProcessorImpl.kt */
public final class PriorityListProcessorImpl$networkChangeListener$1 implements NetworkInfoProvider.NetworkChangeListener {
    final /* synthetic */ PriorityListProcessorImpl this$0;

    PriorityListProcessorImpl$networkChangeListener$1(PriorityListProcessorImpl priorityListProcessorImpl) {
        this.this$0 = priorityListProcessorImpl;
    }

    public void onNetworkChanged() {
        this.this$0.handlerWrapper.post(new PriorityListProcessorImpl$networkChangeListener$1$onNetworkChanged$1(this));
    }
}
