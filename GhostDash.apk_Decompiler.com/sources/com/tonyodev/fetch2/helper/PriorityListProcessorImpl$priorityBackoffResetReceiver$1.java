package com.tonyodev.fetch2.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tonyodev.fetch2.FetchIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/tonyodev/fetch2/helper/PriorityListProcessorImpl$priorityBackoffResetReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PriorityListProcessorImpl.kt */
public final class PriorityListProcessorImpl$priorityBackoffResetReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ PriorityListProcessorImpl this$0;

    PriorityListProcessorImpl$priorityBackoffResetReceiver$1(PriorityListProcessorImpl priorityListProcessorImpl) {
        this.this$0 = priorityListProcessorImpl;
    }

    public void onReceive(Context context, Intent intent) {
        String action;
        if (context != null && intent != null && (action = intent.getAction()) != null && action.hashCode() == -1500940653 && action.equals(FetchIntent.ACTION_QUEUE_BACKOFF_RESET) && !this.this$0.stopped && !this.this$0.paused && Intrinsics.areEqual((Object) this.this$0.namespace, (Object) intent.getStringExtra(FetchIntent.EXTRA_NAMESPACE))) {
            this.this$0.resetBackOffTime();
        }
    }
}
