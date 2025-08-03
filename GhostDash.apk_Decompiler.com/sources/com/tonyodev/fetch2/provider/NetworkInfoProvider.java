package com.tonyodev.fetch2.provider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import com.arthenica.ffmpegkit.reactnative.FFmpegKitReactNativeModule;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2core.FetchAndroidExtensions;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "", "context", "Landroid/content/Context;", "internetCheckUrl", "", "(Landroid/content/Context;Ljava/lang/String;)V", "broadcastRegistered", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "isNetworkAvailable", "()Z", "lock", "networkCallback", "networkChangeBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "networkChangeListenerSet", "Ljava/util/HashSet;", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider$NetworkChangeListener;", "Lkotlin/collections/HashSet;", "isOnAllowedNetwork", "networkType", "Lcom/tonyodev/fetch2/NetworkType;", "notifyNetworkChangeListeners", "", "registerNetworkChangeListener", "networkChangeListener", "unregisterAllNetworkChangeListeners", "unregisterNetworkChangeListener", "NetworkChangeListener", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: NetworkInfoProvider.kt */
public final class NetworkInfoProvider {
    private boolean broadcastRegistered;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private final String internetCheckUrl;
    private final Object lock = new Object();
    private Object networkCallback;
    private final BroadcastReceiver networkChangeBroadcastReceiver;
    private final HashSet<NetworkChangeListener> networkChangeListenerSet = new HashSet<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/tonyodev/fetch2/provider/NetworkInfoProvider$NetworkChangeListener;", "", "onNetworkChanged", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: NetworkInfoProvider.kt */
    public interface NetworkChangeListener {
        void onNetworkChanged();
    }

    public NetworkInfoProvider(Context context2, String str) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        this.internetCheckUrl = str;
        Object systemService = context2.getSystemService("connectivity");
        ConnectivityManager connectivityManager2 = (ConnectivityManager) (!(systemService instanceof ConnectivityManager) ? null : systemService);
        this.connectivityManager = connectivityManager2;
        BroadcastReceiver networkInfoProvider$networkChangeBroadcastReceiver$1 = new NetworkInfoProvider$networkChangeBroadcastReceiver$1(this);
        this.networkChangeBroadcastReceiver = networkInfoProvider$networkChangeBroadcastReceiver$1;
        if (Build.VERSION.SDK_INT < 21 || connectivityManager2 == null) {
            try {
                context2.registerReceiver(networkInfoProvider$networkChangeBroadcastReceiver$1, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
                this.broadcastRegistered = true;
            } catch (Exception unused) {
            }
        } else {
            NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(3).build();
            ConnectivityManager.NetworkCallback networkInfoProvider$networkCallback$1 = new NetworkInfoProvider$networkCallback$1(this);
            this.networkCallback = networkInfoProvider$networkCallback$1;
            connectivityManager2.registerNetworkCallback(build, networkInfoProvider$networkCallback$1);
        }
    }

    /* access modifiers changed from: private */
    public final void notifyNetworkChangeListeners() {
        synchronized (this.lock) {
            Iterator<NetworkChangeListener> it2 = this.networkChangeListenerSet.iterator();
            Intrinsics.checkExpressionValueIsNotNull(it2, "networkChangeListenerSet.iterator()");
            while (it2.hasNext()) {
                it2.next().onNetworkChanged();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void registerNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        Intrinsics.checkParameterIsNotNull(networkChangeListener, "networkChangeListener");
        synchronized (this.lock) {
            this.networkChangeListenerSet.add(networkChangeListener);
        }
    }

    public final void unregisterNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        Intrinsics.checkParameterIsNotNull(networkChangeListener, "networkChangeListener");
        synchronized (this.lock) {
            this.networkChangeListenerSet.remove(networkChangeListener);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|(2:5|6)|7|8|(2:12|(1:14))|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void unregisterAllNetworkChangeListeners() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            java.util.HashSet<com.tonyodev.fetch2.provider.NetworkInfoProvider$NetworkChangeListener> r1 = r4.networkChangeListenerSet     // Catch:{ all -> 0x002c }
            r1.clear()     // Catch:{ all -> 0x002c }
            boolean r1 = r4.broadcastRegistered     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0013
            android.content.Context r1 = r4.context     // Catch:{ Exception -> 0x0013 }
            android.content.BroadcastReceiver r2 = r4.networkChangeBroadcastReceiver     // Catch:{ Exception -> 0x0013 }
            r1.unregisterReceiver(r2)     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x002c }
            r2 = 21
            if (r1 < r2) goto L_0x0028
            android.net.ConnectivityManager r1 = r4.connectivityManager     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0028
            java.lang.Object r2 = r4.networkCallback     // Catch:{ all -> 0x002c }
            boolean r3 = r2 instanceof android.net.ConnectivityManager.NetworkCallback     // Catch:{ all -> 0x002c }
            if (r3 == 0) goto L_0x0028
            android.net.ConnectivityManager$NetworkCallback r2 = (android.net.ConnectivityManager.NetworkCallback) r2     // Catch:{ all -> 0x002c }
            r1.unregisterNetworkCallback(r2)     // Catch:{ all -> 0x002c }
        L_0x0028:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002c }
            monitor-exit(r0)
            return
        L_0x002c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.provider.NetworkInfoProvider.unregisterAllNetworkChangeListeners():void");
    }

    public final boolean isOnAllowedNetwork(NetworkType networkType) {
        Intrinsics.checkParameterIsNotNull(networkType, "networkType");
        if (networkType == NetworkType.WIFI_ONLY && FetchAndroidExtensions.isOnWiFi(this.context)) {
            return true;
        }
        if (networkType == NetworkType.UNMETERED && !FetchAndroidExtensions.isOnMeteredConnection(this.context)) {
            return true;
        }
        if (networkType != NetworkType.ALL || !FetchAndroidExtensions.isNetworkAvailable(this.context)) {
            return false;
        }
        return true;
    }

    public final boolean isNetworkAvailable() {
        String str = this.internetCheckUrl;
        if (str == null) {
            return FetchAndroidExtensions.isNetworkAvailable(this.context);
        }
        boolean z = false;
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(FFmpegKitReactNativeModule.WRITABLE_REQUEST_CODE);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() != -1) {
                    z = true;
                }
                httpURLConnection.disconnect();
                return z;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
        } catch (Exception unused) {
            return false;
        }
    }
}
