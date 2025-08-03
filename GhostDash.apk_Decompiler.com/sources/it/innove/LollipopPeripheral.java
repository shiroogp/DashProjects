package it.innove;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.ParcelUuid;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Map;

public class LollipopPeripheral extends Peripheral {
    private ScanRecord advertisingData;
    private ScanResult scanResult;

    public LollipopPeripheral(ReactContext reactContext, ScanResult scanResult2) {
        super(scanResult2.getDevice(), scanResult2.getRssi(), scanResult2.getScanRecord().getBytes(), reactContext);
        this.advertisingData = scanResult2.getScanRecord();
        this.scanResult = scanResult2;
    }

    public LollipopPeripheral(BluetoothDevice bluetoothDevice, ReactApplicationContext reactApplicationContext) {
        super(bluetoothDevice, reactApplicationContext);
    }

    public WritableMap asWritableMap() {
        WritableMap asWritableMap = super.asWritableMap();
        WritableMap createMap = Arguments.createMap();
        try {
            createMap.putMap("manufacturerData", byteArrayToWritableMap(this.advertisingDataBytes));
            if (Build.VERSION.SDK_INT >= 26) {
                ScanResult scanResult2 = this.scanResult;
                if (scanResult2 != null) {
                    createMap.putBoolean("isConnectable", scanResult2.isConnectable());
                }
            } else {
                createMap.putBoolean("isConnectable", true);
            }
            ScanRecord scanRecord = this.advertisingData;
            if (scanRecord != null) {
                String deviceName = scanRecord.getDeviceName();
                if (deviceName != null) {
                    createMap.putString("localName", deviceName.replace("\u0000", ""));
                }
                WritableArray createArray = Arguments.createArray();
                if (!(this.advertisingData.getServiceUuids() == null || this.advertisingData.getServiceUuids().size() == 0)) {
                    for (ParcelUuid uuid : this.advertisingData.getServiceUuids()) {
                        createArray.pushString(UUIDHelper.uuidToString(uuid.getUuid()));
                    }
                }
                createMap.putArray("serviceUUIDs", createArray);
                WritableMap createMap2 = Arguments.createMap();
                if (this.advertisingData.getServiceData() != null) {
                    for (Map.Entry next : this.advertisingData.getServiceData().entrySet()) {
                        if (next.getValue() != null) {
                            createMap2.putMap(UUIDHelper.uuidToString(((ParcelUuid) next.getKey()).getUuid()), byteArrayToWritableMap((byte[]) next.getValue()));
                        }
                    }
                }
                createMap.putMap("serviceData", createMap2);
                createMap.putInt("txPowerLevel", this.advertisingData.getTxPowerLevel());
            }
            asWritableMap.putMap("advertising", createMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asWritableMap;
    }

    public void updateData(ScanResult scanResult2) {
        ScanRecord scanRecord = scanResult2.getScanRecord();
        this.advertisingData = scanRecord;
        this.advertisingDataBytes = scanRecord.getBytes();
    }
}
