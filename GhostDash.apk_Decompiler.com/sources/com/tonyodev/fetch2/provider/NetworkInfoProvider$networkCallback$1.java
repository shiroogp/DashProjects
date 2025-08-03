package com.tonyodev.fetch2.provider;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/tonyodev/fetch2/provider/NetworkInfoProvider$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: NetworkInfoProvider.kt */
public final class NetworkInfoProvider$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ NetworkInfoProvider this$0;

    NetworkInfoProvider$networkCallback$1(NetworkInfoProvider networkInfoProvider) {
        this.this$0 = networkInfoProvider;
    }

    public void onLost(Network network) {
        Intrinsics.checkParameterIsNotNull(network, "network");
        this.this$0.notifyNetworkChangeListeners();
    }

    public void onAvailable(Network network) {
        Intrinsics.checkParameterIsNotNull(network, "network");
        this.this$0.notifyNetworkChangeListeners();
    }
}
