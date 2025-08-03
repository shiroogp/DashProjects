package com.thanosfisherman.wifiutils.wifiConnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import com.thanosfisherman.wifiutils.ConnectorUtils;
import com.thanosfisherman.wifiutils.WifiUtils;
import com.thanosfisherman.wifiutils.utils.Elvis;
import com.thanosfisherman.wifiutils.utils.VersionUtils;
import java.util.Objects;

public final class WifiConnectionReceiver extends BroadcastReceiver {
    private ScanResult mScanResult;
    private final WifiConnectionCallback mWifiConnectionCallback;
    private final WifiManager mWifiManager;
    private String ssid;

    public WifiConnectionReceiver(WifiConnectionCallback wifiConnectionCallback, WifiManager wifiManager) {
        this.mWifiConnectionCallback = wifiConnectionCallback;
        this.mWifiManager = wifiManager;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        WifiUtils.wifiLog("Connection Broadcast action: " + action);
        if (VersionUtils.isAndroidQOrLater()) {
            if (Objects.equals("android.net.wifi.supplicant.STATE_CHANGE", action)) {
                SupplicantState supplicantState = (SupplicantState) intent.getParcelableExtra("newState");
                int intExtra = intent.getIntExtra("supplicantError", -1);
                WifiUtils.wifiLog("Connection Broadcast state: " + supplicantState);
                WifiUtils.wifiLog("suppl_error: " + intExtra);
                if (this.mScanResult == null && isAlreadyConnected2(this.mWifiManager, this.ssid)) {
                    this.mWifiConnectionCallback.successfulConnect();
                }
                if (supplicantState == SupplicantState.DISCONNECTED && intExtra == 1) {
                    this.mWifiConnectionCallback.errorConnect(ConnectionErrorCode.AUTHENTICATION_ERROR_OCCURRED);
                }
            }
        } else if (Objects.equals("android.net.wifi.STATE_CHANGE", action)) {
            if (ConnectorUtils.isAlreadyConnected(this.mWifiManager, (String) Elvis.of(this.mScanResult).next($$Lambda$WifiConnectionReceiver$__Ij3KRTWCcrJYqIlJm1DQ5zm9o.INSTANCE).get())) {
                this.mWifiConnectionCallback.successfulConnect();
            }
        } else if (Objects.equals("android.net.wifi.supplicant.STATE_CHANGE", action)) {
            SupplicantState supplicantState2 = (SupplicantState) intent.getParcelableExtra("newState");
            int intExtra2 = intent.getIntExtra("supplicantError", -1);
            if (supplicantState2 == null) {
                this.mWifiConnectionCallback.errorConnect(ConnectionErrorCode.COULD_NOT_CONNECT);
                return;
            }
            WifiUtils.wifiLog("Connection Broadcast state: " + supplicantState2);
            int i = AnonymousClass1.$SwitchMap$android$net$wifi$SupplicantState[supplicantState2.ordinal()];
            if (i == 1 || i == 2) {
                if (this.mScanResult == null && isAlreadyConnected2(this.mWifiManager, this.ssid)) {
                    this.mWifiConnectionCallback.successfulConnect();
                } else if (ConnectorUtils.isAlreadyConnected(this.mWifiManager, (String) Elvis.of(this.mScanResult).next($$Lambda$WifiConnectionReceiver$Syl4clIte3aXK3_6ZbSrCZnywyw.INSTANCE).get())) {
                    this.mWifiConnectionCallback.successfulConnect();
                }
            } else if (i == 3) {
                if (intExtra2 == 1) {
                    WifiUtils.wifiLog("Authentication error...");
                    this.mWifiConnectionCallback.errorConnect(ConnectionErrorCode.AUTHENTICATION_ERROR_OCCURRED);
                    return;
                }
                WifiUtils.wifiLog("Disconnected. Re-attempting to connect...");
                ConnectorUtils.reEnableNetworkIfPossible(this.mWifiManager, this.mScanResult);
            }
        }
    }

    /* renamed from: com.thanosfisherman.wifiutils.wifiConnect.WifiConnectionReceiver$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$net$wifi$SupplicantState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.net.wifi.SupplicantState[] r0 = android.net.wifi.SupplicantState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$net$wifi$SupplicantState = r0
                android.net.wifi.SupplicantState r1 = android.net.wifi.SupplicantState.COMPLETED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$net$wifi$SupplicantState     // Catch:{ NoSuchFieldError -> 0x001d }
                android.net.wifi.SupplicantState r1 = android.net.wifi.SupplicantState.FOUR_WAY_HANDSHAKE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$net$wifi$SupplicantState     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.net.wifi.SupplicantState r1 = android.net.wifi.SupplicantState.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.thanosfisherman.wifiutils.wifiConnect.WifiConnectionReceiver.AnonymousClass1.<clinit>():void");
        }
    }

    public static boolean isAlreadyConnected2(WifiManager wifiManager, String str) {
        if (str == null || wifiManager == null || wifiManager.getConnectionInfo() == null || wifiManager.getConnectionInfo().getSSID() == null || wifiManager.getConnectionInfo().getIpAddress() == 0 || !Objects.equals(str, wifiManager.getConnectionInfo().getSSID())) {
            return false;
        }
        WifiUtils.wifiLog("Already connected to: " + wifiManager.getConnectionInfo().getSSID() + "  BSSID: " + wifiManager.getConnectionInfo().getBSSID());
        return true;
    }

    public WifiConnectionReceiver connectWith(ScanResult scanResult, String str, ConnectivityManager connectivityManager) {
        this.mScanResult = scanResult;
        return this;
    }

    public WifiConnectionReceiver connectWith(String str, String str2, ConnectivityManager connectivityManager) {
        this.ssid = str;
        return this;
    }
}
