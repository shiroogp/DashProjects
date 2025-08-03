package com.thanosfisherman.wifiutils.wifiScan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WifiScanReceiver extends BroadcastReceiver {
    private final WifiScanCallback callback;

    public WifiScanReceiver(WifiScanCallback wifiScanCallback) {
        this.callback = wifiScanCallback;
    }

    public void onReceive(Context context, Intent intent) {
        this.callback.onScanResultsReady();
    }
}
