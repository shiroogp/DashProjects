package com.thanosfisherman.wifiutils;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.net.wifi.WpsInfo;
import android.os.PatternMatcher;
import android.provider.Settings;
import com.thanosfisherman.wifiutils.ConnectorUtils;
import com.thanosfisherman.wifiutils.utils.Elvis;
import com.thanosfisherman.wifiutils.utils.SSIDUtils;
import com.thanosfisherman.wifiutils.utils.VersionUtils;
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionErrorCode;
import com.thanosfisherman.wifiutils.wifiConnect.DisconnectCallbackHolder;
import com.thanosfisherman.wifiutils.wifiConnect.WifiConnectionCallback;
import com.thanosfisherman.wifiutils.wifiWps.ConnectionWpsListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class ConnectorUtils {
    private static final int MAX_PRIORITY = 99999;

    public static int getPowerPercentage(int i) {
        if (i <= -93) {
            return 0;
        }
        if (-25 > i || i > 0) {
            return i + 125;
        }
        return 100;
    }

    public static boolean isAlreadyConnected(WifiManager wifiManager, String str) {
        if (str == null || wifiManager == null || wifiManager.getConnectionInfo() == null || wifiManager.getConnectionInfo().getBSSID() == null || wifiManager.getConnectionInfo().getIpAddress() == 0 || !Objects.equals(str, wifiManager.getConnectionInfo().getBSSID())) {
            return false;
        }
        WifiUtils.wifiLog("Already connected to: " + wifiManager.getConnectionInfo().getSSID() + "  BSSID: " + wifiManager.getConnectionInfo().getBSSID());
        return true;
    }

    public static boolean isAlreadyConnected2(WifiManager wifiManager, String str) {
        if (str == null || wifiManager == null || wifiManager.getConnectionInfo() == null || wifiManager.getConnectionInfo().getSSID() == null || wifiManager.getConnectionInfo().getIpAddress() == 0 || !Objects.equals(str, wifiManager.getConnectionInfo().getSSID())) {
            return false;
        }
        WifiUtils.wifiLog("Already connected to: " + wifiManager.getConnectionInfo().getSSID() + "  BSSID: " + wifiManager.getConnectionInfo().getBSSID());
        return true;
    }

    private static boolean isConnectedToNetworkLollipop(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            return false;
        }
        boolean z = false;
        for (Network networkInfo : connectivityManager.getAllNetworks()) {
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(networkInfo);
            if (networkInfo2 != null && 1 == networkInfo2.getType()) {
                z |= networkInfo2.isConnected();
            }
        }
        return z;
    }

    public static boolean isAlreadyConnected(ConnectivityManager connectivityManager) {
        if (VersionUtils.isLollipopOrLater()) {
            return isConnectedToNetworkLollipop(connectivityManager);
        }
        return Elvis.of(connectivityManager).next($$Lambda$ConnectorUtils$xHcNDFCgUnUjBAwiusO0maarZNQ.INSTANCE).next($$Lambda$ConnectorUtils$erdCQvdsWyfHa01O1ehPO1DY_a4.INSTANCE).next($$Lambda$ConnectorUtils$2Ji8grn_5z_82nd0vygivxhFKI.INSTANCE).getBoolean();
    }

    static /* synthetic */ Boolean lambda$isAlreadyConnected$1(NetworkInfo.State state) {
        return Boolean.valueOf(state == NetworkInfo.State.CONNECTED);
    }

    public static boolean isAlreadyConnected(WifiManager wifiManager, ConnectivityManager connectivityManager, String str) {
        boolean isAlreadyConnected = isAlreadyConnected(connectivityManager);
        if (!isAlreadyConnected || str == null || wifiManager == null) {
            return isAlreadyConnected;
        }
        if (VersionUtils.isJellyBeanOrLater()) {
            str = SSIDUtils.convertToQuotedString(str);
        }
        String ssid = wifiManager.getConnectionInfo().getSSID();
        return ssid != null && ssid.equals(str);
    }

    private static boolean checkForExcessOpenNetworkAndSave(ContentResolver contentResolver, WifiManager wifiManager) {
        int i;
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        sortByPriority(configuredNetworks);
        if (VersionUtils.isJellyBeanOrLater()) {
            i = Settings.Secure.getInt(contentResolver, "wifi_num_open_networks_kept", 10);
        } else {
            i = Settings.Secure.getInt(contentResolver, "wifi_num_open_networks_kept", 10);
        }
        boolean z = false;
        int i2 = 0;
        for (int size = configuredNetworks.size() - 1; size >= 0; size--) {
            WifiConfiguration wifiConfiguration = configuredNetworks.get(size);
            if (Objects.equals("OPEN", ConfigSecurities.getSecurity(wifiConfiguration)) && (i2 = i2 + 1) >= i) {
                wifiManager.removeNetwork(wifiConfiguration.networkId);
                z = true;
            }
        }
        if (!z || wifiManager.saveConfiguration()) {
            return true;
        }
        return false;
    }

    private static int getMaxPriority(WifiManager wifiManager) {
        int i = 0;
        if (wifiManager == null) {
            return 0;
        }
        for (WifiConfiguration next : wifiManager.getConfiguredNetworks()) {
            if (next.priority > i) {
                i = next.priority;
            }
        }
        return i;
    }

    private static int shiftPriorityAndSave(WifiManager wifiManager) {
        if (wifiManager == null) {
            return 0;
        }
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        sortByPriority(configuredNetworks);
        int size = configuredNetworks.size();
        for (int i = 0; i < size; i++) {
            WifiConfiguration wifiConfiguration = configuredNetworks.get(i);
            wifiConfiguration.priority = i;
            wifiManager.updateNetwork(wifiConfiguration);
        }
        wifiManager.saveConfiguration();
        return size;
    }

    private static String trimQuotes(String str) {
        return (str == null || str.isEmpty()) ? str : str.replaceAll("^\"*", "").replaceAll("\"*$", "");
    }

    public static boolean isHexWepKey(String str) {
        int length = str == null ? 0 : str.length();
        if ((length == 10 || length == 26 || length == 58) && str.matches("[0-9A-Fa-f]*")) {
            return true;
        }
        return false;
    }

    static /* synthetic */ int lambda$sortByPriority$2(WifiConfiguration wifiConfiguration, WifiConfiguration wifiConfiguration2) {
        return wifiConfiguration.priority - wifiConfiguration2.priority;
    }

    private static void sortByPriority(List<WifiConfiguration> list) {
        Collections.sort(list, $$Lambda$ConnectorUtils$ZuxQRZn2nCxLMJI92xEN0dF42sw.INSTANCE);
    }

    public static int frequencyToChannel(int i) {
        if (2412 <= i && i <= 2484) {
            return ((i - 2412) / 5) + 1;
        }
        if (5170 > i || i > 5825) {
            return -1;
        }
        return ((i - 5170) / 5) + 34;
    }

    static void registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver != null) {
            try {
                context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    static boolean connectToWifi(Context context, WifiManager wifiManager, ConnectivityManager connectivityManager, WeakHandler weakHandler, ScanResult scanResult, String str, WifiConnectionCallback wifiConnectionCallback, boolean z, String str2) {
        if (wifiManager == null || connectivityManager == null) {
            return false;
        }
        if (VersionUtils.isAndroidQOrLater()) {
            return connectAndroidQ(wifiManager, connectivityManager, weakHandler, wifiConnectionCallback, scanResult, str, z, str2);
        }
        Context context2 = context;
        ScanResult scanResult2 = scanResult;
        String str3 = str;
        return connectPreAndroidQ(context, wifiManager, scanResult, str);
    }

    static boolean connectToWifiHidden(Context context, WifiManager wifiManager, ConnectivityManager connectivityManager, WeakHandler weakHandler, String str, String str2, String str3, WifiConnectionCallback wifiConnectionCallback) {
        if (wifiManager == null || connectivityManager == null || str2 == null) {
            return false;
        }
        if (VersionUtils.isAndroidQOrLater()) {
            return connectAndroidQHidden(wifiManager, connectivityManager, weakHandler, wifiConnectionCallback, str, str2, str3);
        }
        return connectPreAndroidQHidden(context, wifiManager, str, str2, str3);
    }

    private static boolean connectPreAndroidQ(Context context, WifiManager wifiManager, ScanResult scanResult, String str) {
        if (wifiManager == null) {
            return false;
        }
        WifiConfiguration wifiConfiguration = ConfigSecurities.getWifiConfiguration(wifiManager, scanResult);
        if (wifiConfiguration != null && str.isEmpty()) {
            WifiUtils.wifiLog("PASSWORD WAS EMPTY. TRYING TO CONNECT TO EXISTING NETWORK CONFIGURATION");
            return connectToConfiguredNetwork(wifiManager, wifiConfiguration, true);
        } else if (!cleanPreviousConfiguration(wifiManager, wifiConfiguration)) {
            WifiUtils.wifiLog("COULDN'T REMOVE PREVIOUS CONFIG, CONNECTING TO EXISTING ONE");
            return connectToConfiguredNetwork(wifiManager, wifiConfiguration, true);
        } else {
            String security = ConfigSecurities.getSecurity(scanResult);
            if (Objects.equals("OPEN", security)) {
                checkForExcessOpenNetworkAndSave(context.getContentResolver(), wifiManager);
            }
            WifiConfiguration wifiConfiguration2 = new WifiConfiguration();
            wifiConfiguration2.SSID = SSIDUtils.convertToQuotedString(scanResult.SSID);
            wifiConfiguration2.BSSID = scanResult.BSSID;
            ConfigSecurities.setupSecurity(wifiConfiguration2, security, str);
            int addNetwork = wifiManager.addNetwork(wifiConfiguration2);
            WifiUtils.wifiLog("Network ID: " + addNetwork);
            if (addNetwork == -1) {
                return false;
            }
            if (!wifiManager.saveConfiguration()) {
                WifiUtils.wifiLog("Couldn't save wifi config");
                return false;
            }
            WifiConfiguration wifiConfiguration3 = ConfigSecurities.getWifiConfiguration(wifiManager, wifiConfiguration2);
            if (wifiConfiguration3 != null) {
                return connectToConfiguredNetwork(wifiManager, wifiConfiguration3, true);
            }
            WifiUtils.wifiLog("Error getting wifi config after save. (config == null)");
            return false;
        }
    }

    private static boolean connectPreAndroidQHidden(Context context, WifiManager wifiManager, String str, String str2, String str3) {
        if (wifiManager == null) {
            return false;
        }
        String security = ConfigSecurities.getSecurity(str2);
        if (Objects.equals("OPEN", security)) {
            checkForExcessOpenNetworkAndSave(context.getContentResolver(), wifiManager);
        }
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = SSIDUtils.convertToQuotedString(str);
        ConfigSecurities.setupSecurityHidden(wifiConfiguration, security, str3);
        int addNetwork = wifiManager.addNetwork(wifiConfiguration);
        WifiUtils.wifiLog("Hidden-Network ID: " + addNetwork);
        if (addNetwork == -1) {
            return false;
        }
        if (!wifiManager.saveConfiguration()) {
            WifiUtils.wifiLog("Couldn't save wifi config");
            return false;
        }
        WifiConfiguration wifiConfiguration2 = ConfigSecurities.getWifiConfiguration(wifiManager, wifiConfiguration);
        if (wifiConfiguration2 != null) {
            return connectToConfiguredNetwork(wifiManager, wifiConfiguration2, true);
        }
        WifiUtils.wifiLog("Error getting wifi config after save. (config == null)");
        return false;
    }

    private static boolean connectToConfiguredNetwork(WifiManager wifiManager, WifiConfiguration wifiConfiguration, boolean z) {
        WifiConfiguration wifiConfiguration2;
        if (wifiConfiguration == null || wifiManager == null) {
            return false;
        }
        if (!VersionUtils.isMarshmallowOrLater()) {
            int maxPriority = getMaxPriority(wifiManager) + 1;
            if (maxPriority > MAX_PRIORITY) {
                maxPriority = shiftPriorityAndSave(wifiManager);
                wifiConfiguration = ConfigSecurities.getWifiConfiguration(wifiManager, wifiConfiguration);
                if (wifiConfiguration == null) {
                    return false;
                }
            }
            wifiConfiguration.priority = maxPriority;
            int updateNetwork = wifiManager.updateNetwork(wifiConfiguration);
            if (updateNetwork == -1 || !wifiManager.enableNetwork(updateNetwork, false) || !wifiManager.saveConfiguration() || (wifiConfiguration2 = ConfigSecurities.getWifiConfiguration(wifiManager, wifiConfiguration)) == null || !disableAllButOne(wifiManager, wifiConfiguration2)) {
                return false;
            }
            if (z) {
                if (!wifiManager.reassociate()) {
                    return false;
                }
            } else if (!wifiManager.reconnect()) {
                return false;
            }
            return true;
        } else if (!disableAllButOne(wifiManager, wifiConfiguration)) {
            return false;
        } else {
            if (z) {
                if (!wifiManager.reassociate()) {
                    return false;
                }
            } else if (!wifiManager.reconnect()) {
                return false;
            }
            return true;
        }
    }

    private static boolean connectAndroidQ(WifiManager wifiManager, ConnectivityManager connectivityManager, WeakHandler weakHandler, WifiConnectionCallback wifiConnectionCallback, ScanResult scanResult, String str, boolean z, String str2) {
        if (connectivityManager == null) {
            return false;
        }
        WifiNetworkSpecifier.Builder builder = new WifiNetworkSpecifier.Builder();
        if (z) {
            if (str2 == null) {
                str2 = scanResult.SSID;
            }
            builder.setSsidPattern(new PatternMatcher(str2, 1));
        } else {
            builder.setSsid(scanResult.SSID).setBssid(MacAddress.fromString(scanResult.BSSID));
        }
        ConfigSecurities.setupWifiNetworkSpecifierSecurities(builder, ConfigSecurities.getSecurity(scanResult), str);
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier(builder.build()).addCapability(13).build();
        DisconnectCallbackHolder.getInstance().disconnect();
        final ConnectivityManager connectivityManager2 = connectivityManager;
        final WeakHandler weakHandler2 = weakHandler;
        final WifiManager wifiManager2 = wifiManager;
        final ScanResult scanResult2 = scanResult;
        final WifiConnectionCallback wifiConnectionCallback2 = wifiConnectionCallback;
        DisconnectCallbackHolder.getInstance().addNetworkCallback(new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                super.onAvailable(network);
                WifiUtils.wifiLog("AndroidQ+ connected to wifi ");
                DisconnectCallbackHolder.getInstance().bindProcessToNetwork(network);
                connectivityManager2.setNetworkPreference(1);
                weakHandler2.postDelayed(new Runnable(wifiManager2, scanResult2, wifiConnectionCallback2) {
                    public final /* synthetic */ WifiManager f$0;
                    public final /* synthetic */ ScanResult f$1;
                    public final /* synthetic */ WifiConnectionCallback f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        ConnectorUtils.AnonymousClass1.lambda$onAvailable$1(this.f$0, this.f$1, this.f$2);
                    }
                }, 500);
            }

            static /* synthetic */ void lambda$onAvailable$1(WifiManager wifiManager, ScanResult scanResult, WifiConnectionCallback wifiConnectionCallback) {
                if (ConnectorUtils.isAlreadyConnected(wifiManager, (String) Elvis.of(scanResult).next($$Lambda$ConnectorUtils$1$til_TjkZd3qE1TGYgtroOhjuTM.INSTANCE).get())) {
                    wifiConnectionCallback.successfulConnect();
                } else {
                    wifiConnectionCallback.errorConnect(ConnectionErrorCode.ANDROID_10_IMMEDIATELY_DROPPED_CONNECTION);
                }
            }

            public void onUnavailable() {
                super.onUnavailable();
                WifiUtils.wifiLog("AndroidQ+ could not connect to wifi");
                wifiConnectionCallback2.errorConnect(ConnectionErrorCode.USER_CANCELLED);
            }

            public void onLost(Network network) {
                super.onLost(network);
                WifiUtils.wifiLog("onLost");
                DisconnectCallbackHolder.getInstance().unbindProcessFromNetwork();
                DisconnectCallbackHolder.getInstance().disconnect();
            }
        }, connectivityManager);
        WifiUtils.wifiLog("connecting with Android 10");
        DisconnectCallbackHolder.getInstance().requestNetwork(build);
        return true;
    }

    private static boolean connectAndroidQHidden(WifiManager wifiManager, ConnectivityManager connectivityManager, WeakHandler weakHandler, WifiConnectionCallback wifiConnectionCallback, String str, String str2, String str3) {
        if (connectivityManager == null) {
            return false;
        }
        WifiNetworkSpecifier.Builder ssid = new WifiNetworkSpecifier.Builder().setIsHiddenSsid(true).setSsid(str);
        ConfigSecurities.setupWifiNetworkSpecifierSecurities(ssid, ConfigSecurities.getSecurity(str2), str3);
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).addCapability(12).addCapability(13).setNetworkSpecifier(ssid.build()).build();
        DisconnectCallbackHolder.getInstance().disconnect();
        final ConnectivityManager connectivityManager2 = connectivityManager;
        final WeakHandler weakHandler2 = weakHandler;
        final WifiManager wifiManager2 = wifiManager;
        final String str4 = str;
        final WifiConnectionCallback wifiConnectionCallback2 = wifiConnectionCallback;
        DisconnectCallbackHolder.getInstance().addNetworkCallback(new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                super.onAvailable(network);
                WifiUtils.wifiLog("AndroidQ+ connected to wifi ");
                DisconnectCallbackHolder.getInstance().bindProcessToNetwork(network);
                connectivityManager2.setNetworkPreference(1);
                weakHandler2.postDelayed(new Runnable(wifiManager2, str4, wifiConnectionCallback2) {
                    public final /* synthetic */ WifiManager f$0;
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ WifiConnectionCallback f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        ConnectorUtils.AnonymousClass2.lambda$onAvailable$0(this.f$0, this.f$1, this.f$2);
                    }
                }, 500);
            }

            static /* synthetic */ void lambda$onAvailable$0(WifiManager wifiManager, String str, WifiConnectionCallback wifiConnectionCallback) {
                if (ConnectorUtils.isAlreadyConnected(wifiManager, str)) {
                    wifiConnectionCallback.successfulConnect();
                } else {
                    wifiConnectionCallback.errorConnect(ConnectionErrorCode.ANDROID_10_IMMEDIATELY_DROPPED_CONNECTION);
                }
            }

            public void onUnavailable() {
                super.onUnavailable();
                WifiUtils.wifiLog("AndroidQ+ could not connect to wifi");
                wifiConnectionCallback2.errorConnect(ConnectionErrorCode.USER_CANCELLED);
            }

            public void onLost(Network network) {
                super.onLost(network);
                WifiUtils.wifiLog("onLost");
                DisconnectCallbackHolder.getInstance().unbindProcessFromNetwork();
                DisconnectCallbackHolder.getInstance().disconnect();
            }

            public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties);
                WifiUtils.wifiLog("onLost");
            }
        }, connectivityManager);
        WifiUtils.wifiLog("connecting with Android 10");
        DisconnectCallbackHolder.getInstance().requestNetwork(build);
        return true;
    }

    private static boolean disableAllButOne(WifiManager wifiManager, WifiConfiguration wifiConfiguration) {
        boolean z = false;
        if (wifiManager == null) {
            return false;
        }
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (!(configuredNetworks == null || wifiConfiguration == null || configuredNetworks.isEmpty())) {
            for (WifiConfiguration next : configuredNetworks) {
                if (next != null) {
                    if (next.networkId == wifiConfiguration.networkId) {
                        z = wifiManager.enableNetwork(next.networkId, true);
                    } else {
                        wifiManager.disableNetwork(next.networkId);
                    }
                }
            }
            WifiUtils.wifiLog("disableAllButOne " + z);
        }
        return z;
    }

    private static boolean disableAllButOne(WifiManager wifiManager, ScanResult scanResult) {
        boolean z = false;
        if (wifiManager == null) {
            return false;
        }
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (!(configuredNetworks == null || scanResult == null || configuredNetworks.isEmpty())) {
            for (WifiConfiguration next : configuredNetworks) {
                if (next != null) {
                    if (!Objects.equals(scanResult.BSSID, next.BSSID) || !Objects.equals(scanResult.SSID, trimQuotes(next.SSID))) {
                        wifiManager.disableNetwork(next.networkId);
                    } else {
                        z = wifiManager.enableNetwork(next.networkId, true);
                    }
                }
            }
        }
        return z;
    }

    public static boolean reEnableNetworkIfPossible(WifiManager wifiManager, ScanResult scanResult) {
        boolean z = false;
        if (wifiManager == null) {
            return false;
        }
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (!(configuredNetworks == null || scanResult == null || configuredNetworks.isEmpty())) {
            Iterator<WifiConfiguration> it2 = configuredNetworks.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WifiConfiguration next = it2.next();
                if (Objects.equals(scanResult.BSSID, next.BSSID) && Objects.equals(scanResult.SSID, trimQuotes(next.SSID))) {
                    z = wifiManager.enableNetwork(next.networkId, true);
                    break;
                }
            }
            WifiUtils.wifiLog("reEnableNetworkIfPossible " + z);
        }
        return z;
    }

    static void connectWps(final WifiManager wifiManager, final WeakHandler weakHandler, final ScanResult scanResult, String str, long j, final ConnectionWpsListener connectionWpsListener) {
        if (wifiManager == null) {
            connectionWpsListener.isSuccessful(false);
            return;
        }
        WpsInfo wpsInfo = new WpsInfo();
        AnonymousClass3 r7 = new Runnable() {
            public void run() {
                wifiManager.cancelWps((WifiManager.WpsCallback) null);
                WifiUtils.wifiLog("Connection with WPS has timed out");
                ConnectorUtils.cleanPreviousConfiguration(wifiManager, scanResult);
                connectionWpsListener.isSuccessful(false);
                weakHandler.removeCallbacks(this);
            }
        };
        final WeakHandler weakHandler2 = weakHandler;
        final AnonymousClass3 r3 = r7;
        final ConnectionWpsListener connectionWpsListener2 = connectionWpsListener;
        final WifiManager wifiManager2 = wifiManager;
        final ScanResult scanResult2 = scanResult;
        AnonymousClass4 r1 = new WifiManager.WpsCallback() {
            public void onStarted(String str) {
            }

            public void onSucceeded() {
                WeakHandler.this.removeCallbacks(r3);
                WifiUtils.wifiLog("CONNECTED With WPS successfully");
                connectionWpsListener2.isSuccessful(true);
            }

            public void onFailed(int i) {
                WeakHandler.this.removeCallbacks(r3);
                WifiUtils.wifiLog("FAILED to connect with WPS. Reason: " + (i != 3 ? i != 4 ? i != 5 ? i != 6 ? i != 7 ? String.valueOf(i) : "WPS_TIMED_OUT" : "WPS_AUTH_FAILURE" : "WPS_TKIP_ONLY_PROHIBITED" : "WPS_WEP_PROHIBITED" : "WPS_OVERLAP_ERROR"));
                ConnectorUtils.cleanPreviousConfiguration(wifiManager2, scanResult2);
                ConnectorUtils.reenableAllHotspots(wifiManager2);
                connectionWpsListener2.isSuccessful(false);
            }
        };
        WifiUtils.wifiLog("Connecting with WPS...");
        wpsInfo.setup = 2;
        wpsInfo.BSSID = scanResult.BSSID;
        wpsInfo.pin = str;
        wifiManager.cancelWps((WifiManager.WpsCallback) null);
        if (!cleanPreviousConfiguration(wifiManager, scanResult)) {
            disableAllButOne(wifiManager, scanResult);
        }
        weakHandler.postDelayed(r7, j);
        wifiManager.startWps(wpsInfo, r1);
    }

    static boolean disconnectFromWifi(WifiManager wifiManager) {
        return wifiManager.disconnect();
    }

    static boolean removeWifi(WifiManager wifiManager, String str) {
        return cleanPreviousConfiguration(wifiManager, ConfigSecurities.getWifiConfiguration(wifiManager, str));
    }

    static boolean cleanPreviousConfiguration(WifiManager wifiManager, ScanResult scanResult) {
        if (wifiManager == null) {
            return false;
        }
        WifiConfiguration wifiConfiguration = ConfigSecurities.getWifiConfiguration(wifiManager, scanResult);
        WifiUtils.wifiLog("Attempting to remove previous network config...");
        if (wifiConfiguration == null) {
            return true;
        }
        if (!wifiManager.removeNetwork(wifiConfiguration.networkId)) {
            return false;
        }
        wifiManager.saveConfiguration();
        return true;
    }

    static boolean cleanPreviousConfiguration(WifiManager wifiManager, WifiConfiguration wifiConfiguration) {
        if (wifiManager == null) {
            return false;
        }
        WifiUtils.wifiLog("Attempting to remove previous network config...");
        if (wifiConfiguration == null) {
            return true;
        }
        if (!wifiManager.removeNetwork(wifiConfiguration.networkId)) {
            return false;
        }
        wifiManager.saveConfiguration();
        return true;
    }

    static void reenableAllHotspots(WifiManager wifiManager) {
        List<WifiConfiguration> configuredNetworks;
        if (wifiManager != null && (configuredNetworks = wifiManager.getConfiguredNetworks()) != null && !configuredNetworks.isEmpty()) {
            for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                wifiManager.enableNetwork(wifiConfiguration.networkId, false);
            }
        }
    }

    static ScanResult matchScanResultSsid(String str, Iterable<ScanResult> iterable, boolean z) {
        for (ScanResult next : iterable) {
            String str2 = next.SSID;
            if (z) {
                if (str2.startsWith(str)) {
                }
            } else if (Objects.equals(str2, str)) {
            }
            return next;
        }
        return null;
    }

    static ScanResult matchScanResult(String str, String str2, Iterable<ScanResult> iterable) {
        for (ScanResult next : iterable) {
            if (Objects.equals(next.SSID, str) && Objects.equals(next.BSSID, str2)) {
                return next;
            }
        }
        return null;
    }

    static ScanResult matchScanResultBssid(String str, Iterable<ScanResult> iterable) {
        for (ScanResult next : iterable) {
            if (Objects.equals(next.BSSID, str)) {
                return next;
            }
        }
        return null;
    }
}
