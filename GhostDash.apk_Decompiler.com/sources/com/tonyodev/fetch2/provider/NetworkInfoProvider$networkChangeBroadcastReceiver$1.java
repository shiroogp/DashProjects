package com.tonyodev.fetch2.provider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/tonyodev/fetch2/provider/NetworkInfoProvider$networkChangeBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: NetworkInfoProvider.kt */
public final class NetworkInfoProvider$networkChangeBroadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ NetworkInfoProvider this$0;

    NetworkInfoProvider$networkChangeBroadcastReceiver$1(NetworkInfoProvider networkInfoProvider) {
        this.this$0 = networkInfoProvider;
    }

    public void onReceive(Context context, Intent intent) {
        this.this$0.notifyNetworkChangeListeners();
    }
}
