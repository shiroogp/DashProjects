package com.thanosfisherman.wifiutils.wifiConnect;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.thanosfisherman.wifiutils.ConnectorUtils;
import com.thanosfisherman.wifiutils.WeakHandler;
import com.thanosfisherman.wifiutils.WifiUtils;
import com.thanosfisherman.wifiutils.utils.Elvis;
import com.thanosfisherman.wifiutils.utils.VersionUtils;

public class TimeoutHandler {
    /* access modifiers changed from: private */
    public final WeakHandler mHandler;
    /* access modifiers changed from: private */
    public ScanResult mScanResult;
    /* access modifiers changed from: private */
    public final WifiConnectionCallback mWifiConnectionCallback;
    /* access modifiers changed from: private */
    public final WifiManager mWifiManager;
    private final Runnable timeoutCallback = new Runnable() {
        public void run() {
            WifiUtils.wifiLog("Connection Timed out...");
            if (!VersionUtils.isAndroidQOrLater()) {
                ConnectorUtils.reEnableNetworkIfPossible(TimeoutHandler.this.mWifiManager, TimeoutHandler.this.mScanResult);
            }
            if (ConnectorUtils.isAlreadyConnected(TimeoutHandler.this.mWifiManager, (String) Elvis.of(TimeoutHandler.this.mScanResult).next($$Lambda$TimeoutHandler$1$gBk2DqUip7Jc5LW6L_Mk07R2Exc.INSTANCE).get())) {
                TimeoutHandler.this.mWifiConnectionCallback.successfulConnect();
            } else {
                TimeoutHandler.this.mWifiConnectionCallback.errorConnect(ConnectionErrorCode.TIMEOUT_OCCURRED);
            }
            TimeoutHandler.this.mHandler.removeCallbacks(this);
        }
    };

    public TimeoutHandler(WifiManager wifiManager, WeakHandler weakHandler, WifiConnectionCallback wifiConnectionCallback) {
        this.mWifiManager = wifiManager;
        this.mHandler = weakHandler;
        this.mWifiConnectionCallback = wifiConnectionCallback;
    }

    public void startTimeout(ScanResult scanResult, long j) {
        this.mHandler.removeCallbacks(this.timeoutCallback);
        this.mScanResult = scanResult;
        this.mHandler.postDelayed(this.timeoutCallback, j);
    }

    public void stopTimeout() {
        this.mHandler.removeCallbacks(this.timeoutCallback);
    }
}
