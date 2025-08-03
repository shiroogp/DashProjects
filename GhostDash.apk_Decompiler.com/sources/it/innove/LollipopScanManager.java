package it.innove;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.List;

public class LollipopScanManager extends ScanManager {
    /* access modifiers changed from: private */
    public final ScanCallback mScanCallback = new ScanCallback() {
        public void onScanResult(int i, final ScanResult scanResult) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    LollipopScanManager.this.onDiscoveredPeripheral(scanResult);
                }
            });
        }

        public void onBatchScanResults(final List<ScanResult> list) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (!list.isEmpty()) {
                        for (ScanResult access$200 : list) {
                            LollipopScanManager.this.onDiscoveredPeripheral(access$200);
                        }
                    }
                }
            });
        }

        public void onScanFailed(int i) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("status", i);
            LollipopScanManager.this.bleManager.sendEvent("BleManagerStopScan", createMap);
        }
    };

    public LollipopScanManager(ReactApplicationContext reactApplicationContext, BleManager bleManager) {
        super(reactApplicationContext, bleManager);
    }

    public void stopScan(Callback callback) {
        this.scanSessionId.incrementAndGet();
        getBluetoothAdapter().getBluetoothLeScanner().stopScan(this.mScanCallback);
        callback.invoke(new Object[0]);
    }

    public void scan(ReadableArray readableArray, final int i, ReadableMap readableMap, Callback callback) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 26 && readableMap.hasKey("legacy")) {
            builder.setLegacy(readableMap.getBoolean("legacy"));
        }
        if (readableMap.hasKey("scanMode")) {
            builder.setScanMode(readableMap.getInt("scanMode"));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (readableMap.hasKey("numberOfMatches")) {
                builder.setNumOfMatches(readableMap.getInt("numberOfMatches"));
            }
            if (readableMap.hasKey("matchMode")) {
                builder.setMatchMode(readableMap.getInt("matchMode"));
            }
            if (readableMap.hasKey("callbackType")) {
                builder.setCallbackType(readableMap.getInt("callbackType"));
            }
        }
        if (readableMap.hasKey("reportDelay")) {
            builder.setReportDelay((long) readableMap.getInt("reportDelay"));
        }
        if (Build.VERSION.SDK_INT >= 26 && readableMap.hasKey("phy")) {
            int i2 = readableMap.getInt("phy");
            if (i2 == 3 && getBluetoothAdapter().isLeCodedPhySupported()) {
                builder.setPhy(3);
            }
            if (i2 == 2 && getBluetoothAdapter().isLe2MPhySupported()) {
                builder.setPhy(2);
            }
        }
        if (readableArray.size() > 0) {
            for (int i3 = 0; i3 < readableArray.size(); i3++) {
                arrayList.add(new ScanFilter.Builder().setServiceUuid(new ParcelUuid(UUIDHelper.uuidFromString(readableArray.getString(i3)))).build());
                Log.d(BleManager.LOG_TAG, "Filter service: " + readableArray.getString(i3));
            }
        }
        if (readableMap.hasKey("exactAdvertisingName")) {
            String string = readableMap.getString("exactAdvertisingName");
            Log.d(BleManager.LOG_TAG, "Filter on advertising name:" + string);
            arrayList.add(new ScanFilter.Builder().setDeviceName(string).build());
        }
        getBluetoothAdapter().getBluetoothLeScanner().startScan(arrayList, builder.build(), this.mScanCallback);
        if (i > 0) {
            new Thread() {
                /* access modifiers changed from: private */
                public int currentScanSession;

                {
                    this.currentScanSession = LollipopScanManager.this.scanSessionId.incrementAndGet();
                }

                public void run() {
                    try {
                        Thread.sleep((long) (i * 1000));
                    } catch (InterruptedException unused) {
                    }
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            BluetoothAdapter bluetoothAdapter = LollipopScanManager.this.getBluetoothAdapter();
                            if (LollipopScanManager.this.scanSessionId.intValue() == AnonymousClass1.this.currentScanSession) {
                                if (bluetoothAdapter.getState() == 12) {
                                    bluetoothAdapter.getBluetoothLeScanner().stopScan(LollipopScanManager.this.mScanCallback);
                                }
                                WritableMap createMap = Arguments.createMap();
                                createMap.putInt("status", 10);
                                LollipopScanManager.this.bleManager.sendEvent("BleManagerStopScan", createMap);
                            }
                        }
                    });
                }
            }.start();
        }
        callback.invoke(new Object[0]);
    }

    /* access modifiers changed from: private */
    public void onDiscoveredPeripheral(ScanResult scanResult) {
        String str;
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord != null) {
            str = scanRecord.getDeviceName();
        } else if (ActivityCompat.checkSelfPermission(this.context, "android.permission.BLUETOOTH_CONNECT") == 0) {
            str = scanResult.getDevice().getName();
        } else {
            str = scanResult.toString();
        }
        Log.i(BleManager.LOG_TAG, "DiscoverPeripheral: " + str);
        LollipopPeripheral lollipopPeripheral = (LollipopPeripheral) this.bleManager.getPeripheral(scanResult.getDevice());
        if (lollipopPeripheral == null) {
            lollipopPeripheral = new LollipopPeripheral((ReactContext) this.bleManager.getReactContext(), scanResult);
        } else {
            lollipopPeripheral.updateData(scanResult);
            lollipopPeripheral.updateRssi(scanResult.getRssi());
        }
        this.bleManager.savePeripheral((Peripheral) lollipopPeripheral);
        this.bleManager.sendEvent("BleManagerDiscoverPeripheral", lollipopPeripheral.asWritableMap());
    }
}
