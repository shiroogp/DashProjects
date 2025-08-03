package com.thanosfisherman.wifiutils;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import androidx.core.util.Consumer;
import com.thanosfisherman.wifiutils.WifiConnectorBuilder;
import com.thanosfisherman.wifiutils.WifiUtils;
import com.thanosfisherman.wifiutils.utils.Elvis;
import com.thanosfisherman.wifiutils.utils.VersionUtils;
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionErrorCode;
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionScanResultsListener;
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionSuccessListener;
import com.thanosfisherman.wifiutils.wifiConnect.DisconnectCallbackHolder;
import com.thanosfisherman.wifiutils.wifiConnect.TimeoutHandler;
import com.thanosfisherman.wifiutils.wifiConnect.WifiConnectionCallback;
import com.thanosfisherman.wifiutils.wifiConnect.WifiConnectionReceiver;
import com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionErrorCode;
import com.thanosfisherman.wifiutils.wifiDisconnect.DisconnectionSuccessListener;
import com.thanosfisherman.wifiutils.wifiRemove.RemoveErrorCode;
import com.thanosfisherman.wifiutils.wifiRemove.RemoveSuccessListener;
import com.thanosfisherman.wifiutils.wifiScan.ScanResultsListener;
import com.thanosfisherman.wifiutils.wifiScan.WifiScanCallback;
import com.thanosfisherman.wifiutils.wifiScan.WifiScanReceiver;
import com.thanosfisherman.wifiutils.wifiState.WifiStateCallback;
import com.thanosfisherman.wifiutils.wifiState.WifiStateListener;
import com.thanosfisherman.wifiutils.wifiState.WifiStateReceiver;
import com.thanosfisherman.wifiutils.wifiWps.ConnectionWpsListener;
import java.util.List;

public final class WifiUtils implements WifiConnectorBuilder, WifiConnectorBuilder.WifiUtilsBuilder, WifiConnectorBuilder.WifiSuccessListener, WifiConnectorBuilder.WifiWpsSuccessListener {
    private static final String TAG = "WifiUtils";
    private static Logger customLogger = null;
    private static boolean mEnableLog = true;
    /* access modifiers changed from: private */
    public String mBssid;
    /* access modifiers changed from: private */
    public ConnectionScanResultsListener mConnectionScanResultsListener;
    /* access modifiers changed from: private */
    public ConnectionSuccessListener mConnectionSuccessListener;
    /* access modifiers changed from: private */
    public ConnectionWpsListener mConnectionWpsListener;
    /* access modifiers changed from: private */
    public final ConnectivityManager mConnectivityManager;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public WeakHandler mHandler;
    /* access modifiers changed from: private */
    public String mPassword;
    /* access modifiers changed from: private */
    public boolean mPatternMatch;
    /* access modifiers changed from: private */
    public ScanResultsListener mScanResultsListener;
    /* access modifiers changed from: private */
    public ScanResult mSingleScanResult;
    /* access modifiers changed from: private */
    public String mSsid;
    /* access modifiers changed from: private */
    public final TimeoutHandler mTimeoutHandler;
    /* access modifiers changed from: private */
    public long mTimeoutMillis = 30000;
    /* access modifiers changed from: private */
    public final WifiConnectionCallback mWifiConnectionCallback;
    /* access modifiers changed from: private */
    public final WifiConnectionReceiver mWifiConnectionReceiver;
    /* access modifiers changed from: private */
    public final WifiManager mWifiManager;
    /* access modifiers changed from: private */
    public final WifiScanReceiver mWifiScanReceiver;
    private final WifiScanCallback mWifiScanResultsCallback;
    private final WifiStateCallback mWifiStateCallback;
    /* access modifiers changed from: private */
    public WifiStateListener mWifiStateListener;
    /* access modifiers changed from: private */
    public final WifiStateReceiver mWifiStateReceiver;
    /* access modifiers changed from: private */
    public long mWpsTimeoutMillis = 30000;
    /* access modifiers changed from: private */
    public String type;

    private WifiUtils(Context context) {
        AnonymousClass1 r0 = new WifiStateCallback() {
            public void onWifiEnabled() {
                WifiUtils.wifiLog("WIFI ENABLED...");
                ConnectorUtils.unregisterReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiStateReceiver);
                Elvis.of(WifiUtils.this.mWifiStateListener).ifPresent($$Lambda$WifiUtils$1$nTtZ_iRqHfHDFWUecywhPZRONk.INSTANCE);
                if (WifiUtils.this.mScanResultsListener != null || WifiUtils.this.mPassword != null) {
                    WifiUtils.wifiLog("START SCANNING....");
                    if (WifiUtils.this.mWifiManager.startScan()) {
                        ConnectorUtils.registerReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiScanReceiver, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                        return;
                    }
                    Elvis.of(WifiUtils.this.mScanResultsListener).ifPresent($$Lambda$WifiUtils$1$U8fx6yfl8uLhWlBmoy91ZW9sWws.INSTANCE);
                    Elvis.of(WifiUtils.this.mConnectionWpsListener).ifPresent($$Lambda$WifiUtils$1$F7Izdu75aTDFqGxMd58TOkkUUU.INSTANCE);
                    WifiUtils.this.mWifiConnectionCallback.errorConnect(ConnectionErrorCode.COULD_NOT_SCAN);
                    WifiUtils.wifiLog("ERROR COULDN'T SCAN");
                }
            }
        };
        this.mWifiStateCallback = r0;
        AnonymousClass2 r1 = new WifiScanCallback() {
            public void onScanResultsReady() {
                WifiUtils.wifiLog("GOT SCAN RESULTS");
                ConnectorUtils.unregisterReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiScanReceiver);
                List<ScanResult> scanResults = WifiUtils.this.mWifiManager.getScanResults();
                Elvis.of(WifiUtils.this.mScanResultsListener).ifPresent(new Consumer(scanResults) {
                    public final /* synthetic */ List f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void accept(Object obj) {
                        ((ScanResultsListener) obj).onScanResults(this.f$0);
                    }
                });
                Elvis.of(WifiUtils.this.mConnectionScanResultsListener).ifPresent(new Consumer(scanResults) {
                    public final /* synthetic */ List f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void accept(Object obj) {
                        WifiUtils.AnonymousClass2.this.lambda$onScanResultsReady$1$WifiUtils$2(this.f$1, (ConnectionScanResultsListener) obj);
                    }
                });
                if (WifiUtils.this.mConnectionWpsListener == null || WifiUtils.this.mBssid == null || WifiUtils.this.mPassword == null) {
                    if (WifiUtils.this.mSsid != null) {
                        if (WifiUtils.this.mBssid != null) {
                            WifiUtils wifiUtils = WifiUtils.this;
                            ScanResult unused = wifiUtils.mSingleScanResult = ConnectorUtils.matchScanResult(wifiUtils.mSsid, WifiUtils.this.mBssid, scanResults);
                        } else {
                            WifiUtils wifiUtils2 = WifiUtils.this;
                            ScanResult unused2 = wifiUtils2.mSingleScanResult = ConnectorUtils.matchScanResultSsid(wifiUtils2.mSsid, scanResults, WifiUtils.this.mPatternMatch);
                        }
                    }
                    if (WifiUtils.this.mSingleScanResult == null || WifiUtils.this.mPassword == null) {
                        if (ConnectorUtils.connectToWifiHidden(WifiUtils.this.mContext, WifiUtils.this.mWifiManager, WifiUtils.this.mConnectivityManager, WifiUtils.this.mHandler, WifiUtils.this.mSsid, WifiUtils.this.type, WifiUtils.this.mPassword, WifiUtils.this.mWifiConnectionCallback)) {
                            ConnectorUtils.registerReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiConnectionReceiver.connectWith(WifiUtils.this.mSsid, WifiUtils.this.mPassword, WifiUtils.this.mConnectivityManager), new IntentFilter("android.net.wifi.supplicant.STATE_CHANGE"));
                            ConnectorUtils.registerReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiConnectionReceiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
                            WifiUtils.this.mTimeoutHandler.startTimeout(WifiUtils.this.mSingleScanResult, WifiUtils.this.mTimeoutMillis);
                            return;
                        }
                        WifiUtils.this.mWifiConnectionCallback.errorConnect(ConnectionErrorCode.COULD_NOT_CONNECT);
                    } else if (ConnectorUtils.connectToWifi(WifiUtils.this.mContext, WifiUtils.this.mWifiManager, WifiUtils.this.mConnectivityManager, WifiUtils.this.mHandler, WifiUtils.this.mSingleScanResult, WifiUtils.this.mPassword, WifiUtils.this.mWifiConnectionCallback, WifiUtils.this.mPatternMatch, WifiUtils.this.mSsid)) {
                        ConnectorUtils.registerReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiConnectionReceiver.connectWith(WifiUtils.this.mSingleScanResult, WifiUtils.this.mPassword, WifiUtils.this.mConnectivityManager), new IntentFilter("android.net.wifi.supplicant.STATE_CHANGE"));
                        ConnectorUtils.registerReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiConnectionReceiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
                        WifiUtils.this.mTimeoutHandler.startTimeout(WifiUtils.this.mSingleScanResult, WifiUtils.this.mTimeoutMillis);
                    } else {
                        WifiUtils.this.mWifiConnectionCallback.errorConnect(ConnectionErrorCode.COULD_NOT_CONNECT);
                    }
                } else {
                    WifiUtils wifiUtils3 = WifiUtils.this;
                    ScanResult unused3 = wifiUtils3.mSingleScanResult = ConnectorUtils.matchScanResultBssid(wifiUtils3.mBssid, scanResults);
                    if (WifiUtils.this.mSingleScanResult == null || !VersionUtils.isLollipopOrLater()) {
                        if (WifiUtils.this.mSingleScanResult == null) {
                            WifiUtils.wifiLog("Couldn't find network. Possibly out of range");
                        }
                        WifiUtils.this.mConnectionWpsListener.isSuccessful(false);
                        return;
                    }
                    ConnectorUtils.connectWps(WifiUtils.this.mWifiManager, WifiUtils.this.mHandler, WifiUtils.this.mSingleScanResult, WifiUtils.this.mPassword, WifiUtils.this.mWpsTimeoutMillis, WifiUtils.this.mConnectionWpsListener);
                }
            }

            public /* synthetic */ void lambda$onScanResultsReady$1$WifiUtils$2(List list, ConnectionScanResultsListener connectionScanResultsListener) {
                ScanResult unused = WifiUtils.this.mSingleScanResult = connectionScanResultsListener.onConnectWithScanResult(list);
            }
        };
        this.mWifiScanResultsCallback = r1;
        AnonymousClass3 r2 = new WifiConnectionCallback() {
            public void successfulConnect() {
                WifiUtils.wifiLog("CONNECTED SUCCESSFULLY");
                ConnectorUtils.unregisterReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiConnectionReceiver);
                WifiUtils.this.mTimeoutHandler.stopTimeout();
                Elvis.of(WifiUtils.this.mConnectionSuccessListener).ifPresent($$Lambda$xs_1uPJanyI4BxeKPRlIAUNDqyo.INSTANCE);
            }

            public void errorConnect(ConnectionErrorCode connectionErrorCode) {
                ConnectorUtils.unregisterReceiver(WifiUtils.this.mContext, WifiUtils.this.mWifiConnectionReceiver);
                WifiUtils.this.mTimeoutHandler.stopTimeout();
                if (VersionUtils.isAndroidQOrLater()) {
                    DisconnectCallbackHolder.getInstance().disconnect();
                }
                ConnectorUtils.reenableAllHotspots(WifiUtils.this.mWifiManager);
                Elvis.of(WifiUtils.this.mConnectionSuccessListener).ifPresent(new Consumer() {
                    public final void accept(Object obj) {
                        WifiUtils.AnonymousClass3.lambda$errorConnect$0(ConnectionErrorCode.this, (ConnectionSuccessListener) obj);
                    }
                });
            }

            static /* synthetic */ void lambda$errorConnect$0(ConnectionErrorCode connectionErrorCode, ConnectionSuccessListener connectionSuccessListener) {
                connectionSuccessListener.failed(connectionErrorCode);
                WifiUtils.wifiLog("DIDN'T CONNECT TO WIFI " + connectionErrorCode);
            }
        };
        this.mWifiConnectionCallback = r2;
        this.mContext = context;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.mWifiManager = wifiManager;
        if (wifiManager != null) {
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.mWifiStateReceiver = new WifiStateReceiver(r0);
            this.mWifiScanReceiver = new WifiScanReceiver(r1);
            this.mHandler = new WeakHandler();
            this.mWifiConnectionReceiver = new WifiConnectionReceiver(r2, wifiManager);
            this.mTimeoutHandler = new TimeoutHandler(wifiManager, this.mHandler, r2);
            return;
        }
        throw new RuntimeException("WifiManager is not supposed to be null");
    }

    public static WifiConnectorBuilder.WifiUtilsBuilder withContext(Context context) {
        return new WifiUtils(context);
    }

    public static void wifiLog(String str) {
        if (mEnableLog) {
            ((Logger) Elvis.of(customLogger).orElse($$Lambda$WifiUtils$82rVwykjOul7ZpegdhGjXQQrCQU.INSTANCE)).log(2, TAG, str);
        }
    }

    public static void enableLog(boolean z) {
        mEnableLog = z;
    }

    public static void forwardLog(Logger logger) {
        customLogger = logger;
    }

    public void enableWifi(WifiStateListener wifiStateListener) {
        this.mWifiStateListener = wifiStateListener;
        if (this.mWifiManager.isWifiEnabled()) {
            this.mWifiStateCallback.onWifiEnabled();
        } else if (this.mWifiManager.setWifiEnabled(true)) {
            ConnectorUtils.registerReceiver(this.mContext, this.mWifiStateReceiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        } else {
            Elvis.of(wifiStateListener).ifPresent($$Lambda$WifiUtils$oyjHixzRFQMkfD8N100Rfz8PGQ.INSTANCE);
            Elvis.of(this.mScanResultsListener).ifPresent($$Lambda$WifiUtils$E_fK7bhgiSAjBbk9qX0fiis87K0.INSTANCE);
            Elvis.of(this.mConnectionWpsListener).ifPresent($$Lambda$WifiUtils$B3_bUh3vVjxkomylwVMvlNSscI.INSTANCE);
            this.mWifiConnectionCallback.errorConnect(ConnectionErrorCode.COULD_NOT_ENABLE_WIFI);
            wifiLog("COULDN'T ENABLE WIFI");
        }
    }

    public void enableWifi() {
        enableWifi((WifiStateListener) null);
    }

    public WifiConnectorBuilder scanWifi(ScanResultsListener scanResultsListener) {
        this.mScanResultsListener = scanResultsListener;
        return this;
    }

    @Deprecated
    public void disconnectFrom(String str, DisconnectionSuccessListener disconnectionSuccessListener) {
        disconnect(disconnectionSuccessListener);
    }

    public void disconnect(DisconnectionSuccessListener disconnectionSuccessListener) {
        if (this.mConnectivityManager == null) {
            disconnectionSuccessListener.failed(DisconnectionErrorCode.COULD_NOT_GET_CONNECTIVITY_MANAGER);
        } else if (this.mWifiManager == null) {
            disconnectionSuccessListener.failed(DisconnectionErrorCode.COULD_NOT_GET_WIFI_MANAGER);
        } else if (VersionUtils.isAndroidQOrLater()) {
            DisconnectCallbackHolder.getInstance().unbindProcessFromNetwork();
            DisconnectCallbackHolder.getInstance().disconnect();
            disconnectionSuccessListener.success();
        } else if (ConnectorUtils.disconnectFromWifi(this.mWifiManager)) {
            disconnectionSuccessListener.success();
        } else {
            disconnectionSuccessListener.failed(DisconnectionErrorCode.COULD_NOT_DISCONNECT);
        }
    }

    public void remove(String str, RemoveSuccessListener removeSuccessListener) {
        if (this.mConnectivityManager == null) {
            removeSuccessListener.failed(RemoveErrorCode.COULD_NOT_GET_CONNECTIVITY_MANAGER);
        } else if (this.mWifiManager == null) {
            removeSuccessListener.failed(RemoveErrorCode.COULD_NOT_GET_WIFI_MANAGER);
        } else if (VersionUtils.isAndroidQOrLater()) {
            DisconnectCallbackHolder.getInstance().disconnect();
            removeSuccessListener.success();
        } else if (ConnectorUtils.removeWifi(this.mWifiManager, str)) {
            removeSuccessListener.success();
        } else {
            removeSuccessListener.failed(RemoveErrorCode.COULD_NOT_REMOVE);
        }
    }

    public WifiConnectorBuilder.WifiUtilsBuilder patternMatch() {
        this.mPatternMatch = true;
        return this;
    }

    public WifiConnectorBuilder.WifiSuccessListener connectWith(String str) {
        this.mSsid = str;
        this.mPassword = "";
        return this;
    }

    public WifiConnectorBuilder.WifiSuccessListener connectWith(String str, String str2) {
        this.mSsid = str;
        this.mPassword = str2;
        return this;
    }

    public WifiConnectorBuilder.WifiSuccessListener connectWith(String str, String str2, TypeEnum typeEnum) {
        this.mSsid = str;
        this.mPassword = str2;
        this.type = typeEnum.name();
        return this;
    }

    public WifiConnectorBuilder.WifiSuccessListener connectWith(String str, String str2, String str3) {
        this.mSsid = str;
        this.mBssid = str2;
        this.mPassword = str3;
        return this;
    }

    public WifiConnectorBuilder.WifiSuccessListener connectWithScanResult(String str, ConnectionScanResultsListener connectionScanResultsListener) {
        this.mConnectionScanResultsListener = connectionScanResultsListener;
        this.mPassword = str;
        return this;
    }

    public WifiConnectorBuilder.WifiWpsSuccessListener connectWithWps(String str, String str2) {
        this.mBssid = str;
        this.mPassword = str2;
        return this;
    }

    public void cancelAutoConnect() {
        ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiStateReceiver);
        ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiScanReceiver);
        ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiConnectionReceiver);
        Elvis.of(this.mSingleScanResult).ifPresent(new Consumer() {
            public final void accept(Object obj) {
                WifiUtils.this.lambda$cancelAutoConnect$4$WifiUtils((ScanResult) obj);
            }
        });
        ConnectorUtils.reenableAllHotspots(this.mWifiManager);
    }

    public /* synthetic */ void lambda$cancelAutoConnect$4$WifiUtils(ScanResult scanResult) {
        ConnectorUtils.cleanPreviousConfiguration(this.mWifiManager, scanResult);
    }

    public boolean isWifiConnected(String str) {
        return ConnectorUtils.isAlreadyConnected(this.mWifiManager, this.mConnectivityManager, str);
    }

    public boolean isWifiConnected() {
        return ConnectorUtils.isAlreadyConnected(this.mConnectivityManager);
    }

    public WifiConnectorBuilder.WifiSuccessListener setTimeout(long j) {
        this.mTimeoutMillis = j;
        return this;
    }

    public WifiConnectorBuilder.WifiWpsSuccessListener setWpsTimeout(long j) {
        this.mWpsTimeoutMillis = j;
        return this;
    }

    public WifiConnectorBuilder onConnectionWpsResult(ConnectionWpsListener connectionWpsListener) {
        this.mConnectionWpsListener = connectionWpsListener;
        return this;
    }

    public WifiConnectorBuilder onConnectionResult(ConnectionSuccessListener connectionSuccessListener) {
        this.mConnectionSuccessListener = connectionSuccessListener;
        return this;
    }

    public void start() {
        ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiStateReceiver);
        ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiScanReceiver);
        ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiConnectionReceiver);
        enableWifi((WifiStateListener) null);
    }

    public void disableWifi() {
        if (this.mWifiManager.isWifiEnabled()) {
            this.mWifiManager.setWifiEnabled(false);
            ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiStateReceiver);
            ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiScanReceiver);
            ConnectorUtils.unregisterReceiver(this.mContext, this.mWifiConnectionReceiver);
        }
        wifiLog("WiFi Disabled");
    }
}
