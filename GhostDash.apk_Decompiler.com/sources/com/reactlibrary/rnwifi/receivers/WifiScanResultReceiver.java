package com.reactlibrary.rnwifi.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.facebook.react.bridge.Promise;
import com.reactlibrary.rnwifi.mappers.WifiScanResultsMapper;

public class WifiScanResultReceiver extends BroadcastReceiver {
    private final Promise promise;
    private final WifiManager wifiManager;

    public WifiScanResultReceiver(WifiManager wifiManager2, Promise promise2) {
        this.promise = promise2;
        this.wifiManager = wifiManager2;
    }

    public void onReceive(Context context, Intent intent) {
        context.unregisterReceiver(this);
        try {
            this.promise.resolve(WifiScanResultsMapper.mapWifiScanResults(this.wifiManager.getScanResults()));
        } catch (Exception e) {
            this.promise.reject("exception", e.getMessage());
        }
    }
}
