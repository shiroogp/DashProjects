package com.reactlibrary.rnwifi.mappers;

import android.net.wifi.ScanResult;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.firebase.database.core.ServerValues;
import java.util.List;

public class WifiScanResultsMapper {
    private WifiScanResultsMapper() {
    }

    private static String parseSSID(ScanResult scanResult) {
        if (scanResult.SSID.equals("")) {
            return "(hidden SSID)";
        }
        return scanResult.SSID;
    }

    public static WritableArray mapWifiScanResults(List<ScanResult> list) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (ScanResult next : list) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("SSID", parseSSID(next));
            writableNativeMap.putString("BSSID", next.BSSID);
            writableNativeMap.putString("capabilities", next.capabilities);
            writableNativeMap.putInt("frequency", next.frequency);
            writableNativeMap.putInt("level", next.level);
            writableNativeMap.putDouble(ServerValues.NAME_OP_TIMESTAMP, (double) next.timestamp);
            writableNativeArray.pushMap(writableNativeMap);
        }
        return writableNativeArray;
    }
}
