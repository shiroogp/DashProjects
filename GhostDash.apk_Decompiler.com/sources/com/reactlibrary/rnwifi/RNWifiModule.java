package com.reactlibrary.rnwifi;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Build;
import android.provider.Settings;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.reactlibrary.rnwifi.errors.ConnectErrorCodes;
import com.reactlibrary.rnwifi.errors.GetCurrentWifiSSIDErrorCodes;
import com.reactlibrary.rnwifi.errors.IsRemoveWifiNetworkErrorCodes;
import com.reactlibrary.rnwifi.errors.LoadWifiListErrorCodes;
import com.reactlibrary.rnwifi.mappers.WifiScanResultsMapper;
import com.reactlibrary.rnwifi.receivers.WifiScanResultReceiver;
import com.reactlibrary.rnwifi.utils.LocationUtils;
import com.reactlibrary.rnwifi.utils.PermissionUtils;
import com.thanosfisherman.wifiutils.WifiUtils;
import com.thanosfisherman.wifiutils.wifiConnect.DisconnectCallbackHolder;
import com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionSuccessListener;
import com.thanosfisherman.wifiutils.wifiRemove.RemoveSuccessListener;

public class RNWifiModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext context;
    private final WifiManager wifi;

    public String getName() {
        return "WifiManager";
    }

    RNWifiModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.wifi = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
        this.context = reactApplicationContext;
    }

    @ReactMethod
    public void loadWifiList(Promise promise) {
        if (assertLocationPermissionGranted(promise)) {
            try {
                promise.resolve(WifiScanResultsMapper.mapWifiScanResults(this.wifi.getScanResults()));
            } catch (Exception e) {
                promise.reject(LoadWifiListErrorCodes.exception.toString(), e.getMessage());
            }
        }
    }

    @Deprecated
    @ReactMethod
    public void forceWifiUsage(boolean z, Promise promise) {
        forceWifiUsageWithOptions(z, (ReadableMap) null, promise);
    }

    @ReactMethod
    public void forceWifiUsageWithOptions(boolean z, ReadableMap readableMap, final Promise promise) {
        if (z) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    boolean canWrite = Settings.System.canWrite(this.context);
                    int checkCallingOrSelfPermission = this.context.checkCallingOrSelfPermission("android.permission.CHANGE_NETWORK_STATE");
                    if (!canWrite && checkCallingOrSelfPermission != 0) {
                        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
                        intent.addFlags(268435456);
                        this.context.startActivity(intent);
                    }
                }
            } catch (Exception e) {
                promise.reject("", e.getMessage());
                return;
            }
        }
        final ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        if (connectivityManager == null) {
            promise.reject(ForceWifiUsageErrorCodes.couldNotGetConnectivityManager.toString(), "Failed to get the ConnectivityManager.");
        } else if (z) {
            NetworkRequest.Builder addTransportType = new NetworkRequest.Builder().addTransportType(1);
            if (readableMap != null && readableMap.getBoolean("noInternet")) {
                addTransportType.removeCapability(12);
            }
            connectivityManager.requestNetwork(addTransportType.build(), new ConnectivityManager.NetworkCallback() {
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    if (Build.VERSION.SDK_INT >= 23) {
                        connectivityManager.bindProcessToNetwork(network);
                    } else {
                        ConnectivityManager.setProcessDefaultNetwork(network);
                    }
                    connectivityManager.unregisterNetworkCallback(this);
                    promise.resolve((Object) null);
                }
            });
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                connectivityManager.bindProcessToNetwork((Network) null);
            } else {
                ConnectivityManager.setProcessDefaultNetwork((Network) null);
            }
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void isEnabled(Promise promise) {
        WifiManager wifiManager = this.wifi;
        if (wifiManager == null) {
            promise.reject(IsEnabledErrorCodes.couldNotGetWifiManager.toString(), "Failed to initialize the WifiManager.");
        } else {
            promise.resolve(Boolean.valueOf(wifiManager.isWifiEnabled()));
        }
    }

    @ReactMethod
    public void setEnabled(boolean z) {
        if (isAndroidTenOrLater()) {
            openWifiSettings();
        } else {
            this.wifi.setWifiEnabled(z);
        }
    }

    @ReactMethod
    public void openWifiSettings() {
        Intent intent = new Intent("android.settings.panel.action.WIFI");
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    @ReactMethod
    public void connectToProtectedSSID(String str, String str2, boolean z, boolean z2, Promise promise) {
        if (assertLocationPermissionGranted(promise)) {
            if (this.wifi.isWifiEnabled() || this.wifi.setWifiEnabled(true)) {
                removeWifiNetwork(str, promise, new Runnable(str, str2, z2, promise) {
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ String f$2;
                    public final /* synthetic */ boolean f$3;
                    public final /* synthetic */ Promise f$4;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                    }

                    public final void run() {
                        RNWifiModule.this.lambda$connectToProtectedSSID$0$RNWifiModule(this.f$1, this.f$2, this.f$3, this.f$4);
                    }
                });
            } else {
                promise.reject(ConnectErrorCodes.couldNotEnableWifi.toString(), "On Android 10, the user has to enable wifi manually.");
            }
        }
    }

    @ReactMethod
    public void connectionStatus(Promise promise) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getReactApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            promise.resolve(false);
            return;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo == null) {
            promise.resolve(false);
        } else {
            promise.resolve(Boolean.valueOf(networkInfo.isConnected()));
        }
    }

    @ReactMethod
    public void disconnect(final Promise promise) {
        WifiUtils.withContext(this.context).disconnect(new DisconnectionSuccessListener() {
            public void success() {
                promise.resolve(true);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
                if (r3 != 2) goto L_0x0029;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void failed(com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode r3) {
                /*
                    r2 = this;
                    int[] r0 = com.reactlibrary.rnwifi.RNWifiModule.AnonymousClass5.$SwitchMap$com$thanosfisherman$wifiutils$wifiDisconnect$DisconnectionErrorCode
                    int r3 = r3.ordinal()
                    r3 = r0[r3]
                    r0 = 1
                    if (r3 == r0) goto L_0x000f
                    r0 = 2
                    if (r3 == r0) goto L_0x001c
                    goto L_0x0029
                L_0x000f:
                    com.facebook.react.bridge.Promise r3 = r3
                    com.reactlibrary.rnwifi.errors.DisconnectErrorCodes r0 = com.reactlibrary.rnwifi.errors.DisconnectErrorCodes.couldNotGetWifiManager
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "Could not get WifiManager."
                    r3.reject((java.lang.String) r0, (java.lang.String) r1)
                L_0x001c:
                    com.facebook.react.bridge.Promise r3 = r3
                    com.reactlibrary.rnwifi.errors.DisconnectErrorCodes r0 = com.reactlibrary.rnwifi.errors.DisconnectErrorCodes.couldNotGetConnectivityManager
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "Could not get Connectivity Manager."
                    r3.reject((java.lang.String) r0, (java.lang.String) r1)
                L_0x0029:
                    com.facebook.react.bridge.Promise r3 = r3
                    r0 = 0
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                    r3.resolve(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.reactlibrary.rnwifi.RNWifiModule.AnonymousClass2.failed(com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode):void");
            }
        });
    }

    @ReactMethod
    public void getCurrentWifiSSID(Promise promise) {
        if (assertLocationPermissionGranted(promise)) {
            String wifiSSID = getWifiSSID();
            if (wifiSSID == null) {
                promise.reject(GetCurrentWifiSSIDErrorCodes.couldNotDetectSSID.toString(), "Not connected or connecting.");
            } else {
                promise.resolve(wifiSSID);
            }
        }
    }

    @ReactMethod
    public void getBSSID(Promise promise) {
        promise.resolve(this.wifi.getConnectionInfo().getBSSID().toUpperCase());
    }

    @ReactMethod
    public void getCurrentSignalStrength(Promise promise) {
        promise.resolve(Integer.valueOf(this.wifi.getConnectionInfo().getRssi()));
    }

    @ReactMethod
    public void getFrequency(Promise promise) {
        promise.resolve(Integer.valueOf(this.wifi.getConnectionInfo().getFrequency()));
    }

    @ReactMethod
    public void getIP(Promise promise) {
        promise.resolve(longToIP(this.wifi.getConnectionInfo().getIpAddress()));
    }

    @ReactMethod
    public void isRemoveWifiNetwork(String str, Promise promise) {
        removeWifiNetwork(str, promise, (Runnable) null);
    }

    private void removeWifiNetwork(String str, final Promise promise, final Runnable runnable) {
        if (!PermissionUtils.isLocationPermissionGranted(this.context)) {
            promise.reject(IsRemoveWifiNetworkErrorCodes.locationPermissionMissing.toString(), "Location permission (ACCESS_FINE_LOCATION) is not granted");
        } else {
            WifiUtils.withContext(this.context).remove(str, new RemoveSuccessListener() {
                public void success() {
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        promise.resolve(true);
                    }
                }

                /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
                    if (r3 != 2) goto L_0x0029;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void failed(com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode r3) {
                    /*
                        r2 = this;
                        int[] r0 = com.reactlibrary.rnwifi.RNWifiModule.AnonymousClass5.$SwitchMap$com$thanosfisherman$wifiutils$wifiRemove$RemoveErrorCode
                        int r3 = r3.ordinal()
                        r3 = r0[r3]
                        r0 = 1
                        if (r3 == r0) goto L_0x000f
                        r0 = 2
                        if (r3 == r0) goto L_0x001c
                        goto L_0x0029
                    L_0x000f:
                        com.facebook.react.bridge.Promise r3 = r4
                        com.reactlibrary.rnwifi.errors.IsRemoveWifiNetworkErrorCodes r0 = com.reactlibrary.rnwifi.errors.IsRemoveWifiNetworkErrorCodes.couldNotGetWifiManager
                        java.lang.String r0 = r0.toString()
                        java.lang.String r1 = "Could not get WifiManager."
                        r3.reject((java.lang.String) r0, (java.lang.String) r1)
                    L_0x001c:
                        com.facebook.react.bridge.Promise r3 = r4
                        com.reactlibrary.rnwifi.errors.IsRemoveWifiNetworkErrorCodes r0 = com.reactlibrary.rnwifi.errors.IsRemoveWifiNetworkErrorCodes.couldNotGetConnectivityManager
                        java.lang.String r0 = r0.toString()
                        java.lang.String r1 = "Could not get Connectivity Manager."
                        r3.reject((java.lang.String) r0, (java.lang.String) r1)
                    L_0x0029:
                        java.lang.Runnable r3 = r5
                        if (r3 == 0) goto L_0x0031
                        r3.run()
                        return
                    L_0x0031:
                        com.facebook.react.bridge.Promise r3 = r4
                        r0 = 0
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                        r3.resolve(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.reactlibrary.rnwifi.RNWifiModule.AnonymousClass3.failed(com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode):void");
                }
            });
        }
    }

    /* renamed from: com.reactlibrary.rnwifi.RNWifiModule$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$thanosfisherman$wifiutils$wifiDisconnect$DisconnectionErrorCode;
        static final /* synthetic */ int[] $SwitchMap$com$thanosfisherman$wifiutils$wifiRemove$RemoveErrorCode;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode[] r0 = com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$thanosfisherman$wifiutils$wifiRemove$RemoveErrorCode = r0
                r1 = 1
                com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode r2 = com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode.COULD_NOT_GET_WIFI_MANAGER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$thanosfisherman$wifiutils$wifiRemove$RemoveErrorCode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode r3 = com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode.COULD_NOT_GET_CONNECTIVITY_MANAGER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$thanosfisherman$wifiutils$wifiRemove$RemoveErrorCode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode r4 = com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode.COULD_NOT_REMOVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode[] r3 = com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$thanosfisherman$wifiutils$wifiDisconnect$DisconnectionErrorCode = r3
                com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode r4 = com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode.COULD_NOT_GET_WIFI_MANAGER     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$thanosfisherman$wifiutils$wifiDisconnect$DisconnectionErrorCode     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode r3 = com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode.COULD_NOT_GET_CONNECTIVITY_MANAGER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$thanosfisherman$wifiutils$wifiDisconnect$DisconnectionErrorCode     // Catch:{ NoSuchFieldError -> 0x004d }
                com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode r1 = com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode.COULD_NOT_DISCONNECT     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactlibrary.rnwifi.RNWifiModule.AnonymousClass5.<clinit>():void");
        }
    }

    @ReactMethod
    public void reScanAndLoadWifiList(Promise promise) {
        if (assertLocationPermissionGranted(promise)) {
            getReactApplicationContext().registerReceiver(new WifiScanResultReceiver(this.wifi, promise), new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            this.wifi.startScan();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: connectToWifiDirectly */
    public void lambda$connectToProtectedSSID$0$RNWifiModule(String str, String str2, boolean z, Promise promise) {
        if (isAndroidTenOrLater()) {
            connectAndroidQ(str, str2, z, promise);
        } else {
            connectPreAndroidQ(str, str2, promise);
        }
    }

    private void connectPreAndroidQ(String str, String str2, Promise promise) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = formatWithBackslashes(str);
        if (!isNullOrEmpty(str2)) {
            stuffWifiConfigurationWithWPA2(wifiConfiguration, str2);
        } else {
            stuffWifiConfigurationWithoutEncryption(wifiConfiguration);
        }
        int addNetwork = this.wifi.addNetwork(wifiConfiguration);
        if (addNetwork == -1) {
            promise.reject(ConnectErrorCodes.unableToConnect.toString(), String.format("Could not add or update network configuration with SSID %s", new Object[]{str}));
        } else if (!this.wifi.enableNetwork(addNetwork, true)) {
            promise.reject(ConnectErrorCodes.unableToConnect.toString(), String.format("Failed to enable network with %s", new Object[]{str}));
        } else if (!this.wifi.reconnect()) {
            promise.reject(ConnectErrorCodes.unableToConnect.toString(), String.format("Failed to reconnect with %s", new Object[]{str}));
        } else if (!pollForValidSSID(10, str)) {
            promise.reject(ConnectErrorCodes.unableToConnect.toString(), String.format("Failed to connect with %s", new Object[]{str}));
        } else {
            promise.resolve("connected");
        }
    }

    private void connectAndroidQ(final String str, String str2, boolean z, final Promise promise) {
        WifiNetworkSpecifier.Builder ssid = new WifiNetworkSpecifier.Builder().setIsHiddenSsid(z).setSsid(str);
        if (!isNullOrEmpty(str2)) {
            ssid.setWpa2Passphrase(str2);
        }
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier(ssid.build()).addCapability(13).build();
        final ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        DisconnectCallbackHolder.getInstance().addNetworkCallback(new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                super.onAvailable(network);
                DisconnectCallbackHolder.getInstance().bindProcessToNetwork(network);
                connectivityManager.setNetworkPreference(1);
                if (!RNWifiModule.this.pollForValidSSID(3, str)) {
                    promise.reject(ConnectErrorCodes.android10ImmediatelyDroppedConnection.toString(), "Firmware bugs on OnePlus prevent it from connecting on some firmware versions.");
                } else {
                    promise.resolve("connected");
                }
            }

            public void onUnavailable() {
                super.onUnavailable();
                promise.reject(ConnectErrorCodes.didNotFindNetwork.toString(), "Network not found or network request cannot be fulfilled.");
            }

            public void onLost(Network network) {
                super.onLost(network);
                DisconnectCallbackHolder.getInstance().unbindProcessFromNetwork();
                DisconnectCallbackHolder.getInstance().disconnect();
            }
        }, connectivityManager);
        DisconnectCallbackHolder.getInstance().requestNetwork(build);
    }

    private static String longToIP(int i) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[4];
        strArr[3] = String.valueOf(i >>> 24);
        strArr[2] = String.valueOf((16777215 & i) >>> 16);
        strArr[1] = String.valueOf((65535 & i) >>> 8);
        strArr[0] = String.valueOf(i & 255);
        sb.append(strArr[0]);
        sb.append(".");
        sb.append(strArr[1]);
        sb.append(".");
        sb.append(strArr[2]);
        sb.append(".");
        sb.append(strArr[3]);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public boolean pollForValidSSID(int i, String str) {
        int i2 = 0;
        while (i2 < i) {
            try {
                String wifiSSID = getWifiSSID();
                if (wifiSSID != null && wifiSSID.equalsIgnoreCase(str)) {
                    return true;
                }
                Thread.sleep(1000);
                i2++;
            } catch (InterruptedException unused) {
            }
        }
        return false;
    }

    private String getWifiSSID() {
        String ssid = this.wifi.getConnectionInfo().getSSID();
        if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        if (ssid.equals("<unknown ssid>")) {
            return null;
        }
        return ssid;
    }

    private boolean isAndroidTenOrLater() {
        return Build.VERSION.SDK_INT >= 29;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    private void stuffWifiConfigurationWithWPA2(WifiConfiguration wifiConfiguration, String str) {
        if (str.matches("[0-9A-Fa-f]{64}")) {
            wifiConfiguration.preSharedKey = str;
        } else {
            wifiConfiguration.preSharedKey = formatWithBackslashes(str);
        }
        wifiConfiguration.allowedProtocols.set(1);
        wifiConfiguration.allowedProtocols.set(0);
        wifiConfiguration.allowedKeyManagement.set(1);
        wifiConfiguration.status = 2;
        wifiConfiguration.allowedGroupCiphers.set(2);
        wifiConfiguration.allowedGroupCiphers.set(3);
        wifiConfiguration.allowedPairwiseCiphers.set(1);
        wifiConfiguration.allowedPairwiseCiphers.set(2);
    }

    private void stuffWifiConfigurationWithoutEncryption(WifiConfiguration wifiConfiguration) {
        wifiConfiguration.allowedKeyManagement.set(0);
    }

    private String formatWithBackslashes(String str) {
        return String.format("\"%s\"", new Object[]{str});
    }

    private boolean assertLocationPermissionGranted(Promise promise) {
        if (!PermissionUtils.isLocationPermissionGranted(this.context)) {
            promise.reject(ConnectErrorCodes.locationPermissionMissing.toString(), "Location permission (ACCESS_FINE_LOCATION) is not granted");
            return false;
        } else if (LocationUtils.isLocationOn(this.context)) {
            return true;
        } else {
            promise.reject(ConnectErrorCodes.locationServicesOff.toString(), "Location service is turned off");
            return false;
        }
    }
}
