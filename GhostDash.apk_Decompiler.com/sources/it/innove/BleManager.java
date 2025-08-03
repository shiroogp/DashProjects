package it.innove;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.uimanager.ViewProps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.UByte;

class BleManager extends ReactContextBaseJavaModule {
    private static final int ENABLE_REQUEST = 539;
    public static final String LOG_TAG = "ReactNativeBleManager";
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothManager bluetoothManager;
    /* access modifiers changed from: private */
    public BondRequest bondRequest;
    private Context context;
    /* access modifiers changed from: private */
    public Callback enableBluetoothCallback;
    /* access modifiers changed from: private */
    public boolean forceLegacy;
    private final ActivityEventListener mActivityEventListener;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String str;
            Peripheral peripheral;
            Log.d(BleManager.LOG_TAG, "onReceive");
            String action = intent.getAction();
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                String str2 = "off";
                switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) {
                    case 10:
                        BleManager.this.clearPeripherals();
                        break;
                    case 11:
                        str2 = "turning_on";
                        break;
                    case 12:
                        str2 = ViewProps.ON;
                        break;
                    case 13:
                        BleManager.this.disconnectPeripherals();
                        str2 = "turning_off";
                        break;
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putString("state", str2);
                Log.d(BleManager.LOG_TAG, "state: " + str2);
                BleManager.this.sendEvent("BleManagerDidUpdateState", createMap);
            } else if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                switch (intExtra) {
                    case 10:
                        str = "BOND_NONE";
                        break;
                    case 11:
                        str = "BOND_BONDING";
                        break;
                    case 12:
                        str = "BOND_BONDED";
                        break;
                    default:
                        str = "UNKNOWN";
                        break;
                }
                Log.d(BleManager.LOG_TAG, "bond state: " + str);
                if (BleManager.this.bondRequest != null && BleManager.this.bondRequest.uuid.equals(bluetoothDevice.getAddress())) {
                    if (intExtra == 12) {
                        BleManager.this.bondRequest.callback.invoke(new Object[0]);
                        BondRequest unused = BleManager.this.bondRequest = null;
                    } else if (intExtra == 10 || intExtra == Integer.MIN_VALUE) {
                        BleManager.this.bondRequest.callback.invoke("Bond request has been denied");
                        BondRequest unused2 = BleManager.this.bondRequest = null;
                    }
                }
                if (intExtra == 12) {
                    if (Build.VERSION.SDK_INT < 21 || BleManager.this.forceLegacy) {
                        peripheral = new Peripheral(bluetoothDevice, BleManager.this.reactContext);
                    } else {
                        peripheral = new LollipopPeripheral(bluetoothDevice, BleManager.this.reactContext);
                    }
                    BleManager.this.sendEvent("BleManagerPeripheralDidBond", peripheral.asWritableMap());
                }
                if (BleManager.this.removeBondRequest != null && BleManager.this.removeBondRequest.uuid.equals(bluetoothDevice.getAddress()) && intExtra == 10 && intExtra2 == 12) {
                    BleManager.this.removeBondRequest.callback.invoke(new Object[0]);
                    BondRequest unused3 = BleManager.this.removeBondRequest = null;
                }
            } else if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (BleManager.this.bondRequest != null && BleManager.this.bondRequest.uuid.equals(bluetoothDevice2.getAddress()) && BleManager.this.bondRequest.pin != null) {
                    bluetoothDevice2.setPin(BleManager.this.bondRequest.pin.getBytes());
                    bluetoothDevice2.createBond();
                }
            }
        }
    };
    private final Map<String, Peripheral> peripherals = new LinkedHashMap();
    /* access modifiers changed from: private */
    public ReactApplicationContext reactContext;
    /* access modifiers changed from: private */
    public BondRequest removeBondRequest;
    private ScanManager scanManager;

    static /* synthetic */ void lambda$onCatalystInstanceDestroy$0(Object[] objArr) {
    }

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return "BleManager";
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    private class BondRequest {
        /* access modifiers changed from: private */
        public Callback callback;
        /* access modifiers changed from: private */
        public String pin;
        /* access modifiers changed from: private */
        public String uuid;

        BondRequest(String str, Callback callback2) {
            this.uuid = str;
            this.callback = callback2;
        }

        BondRequest(String str, String str2, Callback callback2) {
            this.uuid = str;
            this.pin = str2;
            this.callback = callback2;
        }
    }

    public ReactApplicationContext getReactContext() {
        return this.reactContext;
    }

    public BleManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        AnonymousClass1 r0 = new BaseActivityEventListener() {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                Log.d(BleManager.LOG_TAG, "onActivityResult");
                if (i == 539 && BleManager.this.enableBluetoothCallback != null) {
                    if (i2 == -1) {
                        BleManager.this.enableBluetoothCallback.invoke(new Object[0]);
                    } else {
                        BleManager.this.enableBluetoothCallback.invoke("User refused to enable");
                    }
                    Callback unused = BleManager.this.enableBluetoothCallback = null;
                }
            }
        };
        this.mActivityEventListener = r0;
        this.context = reactApplicationContext;
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(r0);
        Log.d(LOG_TAG, "BleManager created");
    }

    private BluetoothAdapter getBluetoothAdapter() {
        if (this.bluetoothAdapter == null) {
            this.bluetoothAdapter = ((BluetoothManager) this.context.getSystemService("bluetooth")).getAdapter();
        }
        return this.bluetoothAdapter;
    }

    private BluetoothManager getBluetoothManager() {
        if (this.bluetoothManager == null) {
            this.bluetoothManager = (BluetoothManager) this.context.getSystemService("bluetooth");
        }
        return this.bluetoothManager;
    }

    public void sendEvent(String str, WritableMap writableMap) {
        ((RCTNativeAppEventEmitter) getReactApplicationContext().getJSModule(RCTNativeAppEventEmitter.class)).emit(str, writableMap);
    }

    @ReactMethod
    public void start(ReadableMap readableMap, Callback callback) {
        Log.d(LOG_TAG, "start");
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
            return;
        }
        this.forceLegacy = false;
        if (readableMap.hasKey("forceLegacy")) {
            this.forceLegacy = readableMap.getBoolean("forceLegacy");
        }
        if (Build.VERSION.SDK_INT < 21 || this.forceLegacy) {
            this.scanManager = new LegacyScanManager(this.reactContext, this);
        } else {
            this.scanManager = new LollipopScanManager(this.reactContext, this);
        }
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        this.context.registerReceiver(this.mReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter("android.bluetooth.device.action.PAIRING_REQUEST");
        intentFilter2.setPriority(1000);
        this.context.registerReceiver(this.mReceiver, intentFilter2);
        callback.invoke(new Object[0]);
        Log.d(LOG_TAG, "BleManager initialized");
    }

    @ReactMethod
    public void enableBluetooth(Callback callback) {
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
        } else if (!getBluetoothAdapter().isEnabled()) {
            this.enableBluetoothCallback = callback;
            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
            if (getCurrentActivity() == null) {
                callback.invoke("Current activity not available");
                return;
            }
            getCurrentActivity().startActivityForResult(intent, 539);
        } else {
            callback.invoke(new Object[0]);
        }
    }

    @ReactMethod
    public void scan(ReadableArray readableArray, int i, boolean z, ReadableMap readableMap, Callback callback) {
        Log.d(LOG_TAG, "scan");
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
        } else if (getBluetoothAdapter().isEnabled()) {
            synchronized (this.peripherals) {
                Iterator<Map.Entry<String, Peripheral>> it2 = this.peripherals.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry next = it2.next();
                    if (!((Peripheral) next.getValue()).isConnected() && !((Peripheral) next.getValue()).isConnecting()) {
                        it2.remove();
                    }
                }
            }
            ScanManager scanManager2 = this.scanManager;
            if (scanManager2 != null) {
                scanManager2.scan(readableArray, i, readableMap, callback);
            }
        }
    }

    @ReactMethod
    public void stopScan(Callback callback) {
        Log.d(LOG_TAG, "Stop scan");
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
        } else if (!getBluetoothAdapter().isEnabled()) {
            callback.invoke(new Object[0]);
        } else {
            ScanManager scanManager2 = this.scanManager;
            if (scanManager2 != null) {
                scanManager2.stopScan(callback);
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("status", 0);
                sendEvent("BleManagerStopScan", createMap);
            }
        }
    }

    @ReactMethod
    public void createBond(String str, String str2, Callback callback) {
        Log.d(LOG_TAG, "Request bond to: " + str);
        for (BluetoothDevice address : getBluetoothAdapter().getBondedDevices()) {
            if (str.equalsIgnoreCase(address.getAddress())) {
                callback.invoke(new Object[0]);
                return;
            }
        }
        Peripheral retrieveOrCreatePeripheral = retrieveOrCreatePeripheral(str);
        if (retrieveOrCreatePeripheral == null) {
            callback.invoke("Invalid peripheral uuid");
        } else if (this.bondRequest != null) {
            callback.invoke("Only allow one bond request at a time");
        } else if (retrieveOrCreatePeripheral.getDevice().createBond()) {
            Log.d(LOG_TAG, "Request bond successful for: " + str);
            this.bondRequest = new BondRequest(str, str2, callback);
        } else {
            callback.invoke("Create bond request fail");
        }
    }

    @ReactMethod
    private void removeBond(String str, Callback callback) {
        Log.d(LOG_TAG, "Remove bond to: " + str);
        Peripheral retrieveOrCreatePeripheral = retrieveOrCreatePeripheral(str);
        if (retrieveOrCreatePeripheral == null) {
            callback.invoke("Invalid peripheral uuid");
            return;
        }
        try {
            retrieveOrCreatePeripheral.getDevice().getClass().getMethod("removeBond", (Class[]) null).invoke(retrieveOrCreatePeripheral.getDevice(), (Object[]) null);
            this.removeBondRequest = new BondRequest(str, callback);
        } catch (Exception e) {
            Log.d(LOG_TAG, "Error in remove bond: " + str, e);
            callback.invoke("Remove bond request fail");
        }
    }

    @ReactMethod
    public void connect(String str, Callback callback) {
        Log.d(LOG_TAG, "Connect to: " + str);
        Peripheral retrieveOrCreatePeripheral = retrieveOrCreatePeripheral(str);
        if (retrieveOrCreatePeripheral == null) {
            callback.invoke("Invalid peripheral uuid");
            return;
        }
        retrieveOrCreatePeripheral.connect(callback, getCurrentActivity());
    }

    @ReactMethod
    public void disconnect(String str, boolean z, Callback callback) {
        Log.d(LOG_TAG, "Disconnect from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.disconnect(callback, z);
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void startNotificationUseBuffer(String str, String str2, String str3, Integer num, Callback callback) {
        Log.d(LOG_TAG, "startNotification");
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.registerNotify(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), num, callback);
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void startNotification(String str, String str2, String str3, Callback callback) {
        Log.d(LOG_TAG, "startNotification");
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.registerNotify(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), 1, callback);
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void stopNotification(String str, String str2, String str3, Callback callback) {
        Log.d(LOG_TAG, "stopNotification");
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.removeNotify(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), callback);
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void write(String str, String str2, String str3, ReadableArray readableArray, Integer num, Callback callback) {
        String str4 = str;
        Callback callback2 = callback;
        Log.d(LOG_TAG, "Write to: " + str);
        if (str2 == null || str3 == null) {
            callback2.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            int size = readableArray.size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableArray readableArray2 = readableArray;
                bArr[i] = new Integer(readableArray.getInt(i)).byteValue();
            }
            Log.d(LOG_TAG, "Message(" + size + "): " + bytesToHex(bArr));
            peripheral.write(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), bArr, num, (Integer) null, callback, 2);
            return;
        }
        callback2.invoke("Peripheral not found");
    }

    @ReactMethod
    public void writeWithoutResponse(String str, String str2, String str3, ReadableArray readableArray, Integer num, Integer num2, Callback callback) {
        String str4 = str;
        Callback callback2 = callback;
        Log.d(LOG_TAG, "Write without response to: " + str);
        if (str2 == null || str3 == null) {
            callback2.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            int size = readableArray.size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableArray readableArray2 = readableArray;
                bArr[i] = new Integer(readableArray.getInt(i)).byteValue();
            }
            Log.d(LOG_TAG, "Message(" + size + "): " + bytesToHex(bArr));
            peripheral.write(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), bArr, num, num2, callback, 1);
            return;
        }
        callback2.invoke("Peripheral not found");
    }

    @ReactMethod
    public void read(String str, String str2, String str3, Callback callback) {
        Log.d(LOG_TAG, "Read from: " + str);
        if (str2 == null || str3 == null) {
            callback.invoke("ServiceUUID and characteristicUUID required.");
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.read(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), callback);
            return;
        }
        callback.invoke("Peripheral not found", null);
    }

    @ReactMethod
    public void readDescriptor(String str, String str2, String str3, String str4, Callback callback) {
        Log.d(LOG_TAG, "Read descriptor from: " + str);
        if (str2 == null || str3 == null || str4 == null) {
            callback.invoke("ServiceUUID, CharacteristicUUID and descriptorUUID required.", null);
            return;
        }
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral == null) {
            callback.invoke("Peripheral not found", null);
        }
        peripheral.readDescriptor(UUIDHelper.uuidFromString(str2), UUIDHelper.uuidFromString(str3), UUIDHelper.uuidFromString(str4), callback);
    }

    @ReactMethod
    public void retrieveServices(String str, ReadableArray readableArray, Callback callback) {
        Log.d(LOG_TAG, "Retrieve services from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.retrieveServices(callback);
            return;
        }
        callback.invoke("Peripheral not found", null);
    }

    @ReactMethod
    public void refreshCache(String str, Callback callback) {
        Log.d(LOG_TAG, "Refershing cache for: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.refreshCache(callback);
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void readRSSI(String str, Callback callback) {
        Log.d(LOG_TAG, "Read RSSI from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.readRSSI(callback);
            return;
        }
        callback.invoke("Peripheral not found", null);
    }

    private Peripheral savePeripheral(BluetoothDevice bluetoothDevice) {
        Object obj;
        String address = bluetoothDevice.getAddress();
        synchronized (this.peripherals) {
            if (!this.peripherals.containsKey(address)) {
                if (Build.VERSION.SDK_INT < 21 || this.forceLegacy) {
                    obj = new Peripheral(bluetoothDevice, this.reactContext);
                } else {
                    obj = new LollipopPeripheral(bluetoothDevice, this.reactContext);
                }
                this.peripherals.put(bluetoothDevice.getAddress(), obj);
            }
        }
        return this.peripherals.get(address);
    }

    public Peripheral getPeripheral(BluetoothDevice bluetoothDevice) {
        return this.peripherals.get(bluetoothDevice.getAddress());
    }

    public Peripheral savePeripheral(Peripheral peripheral) {
        synchronized (this.peripherals) {
            this.peripherals.put(peripheral.getDevice().getAddress(), peripheral);
        }
        return peripheral;
    }

    @ReactMethod
    public void checkState(Callback callback) {
        Log.d(LOG_TAG, "checkState");
        BluetoothAdapter bluetoothAdapter2 = getBluetoothAdapter();
        String str = "off";
        if (this.context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            if (bluetoothAdapter2 != null) {
                switch (bluetoothAdapter2.getState()) {
                    case 11:
                        str = "turning_on";
                        break;
                    case 12:
                        str = ViewProps.ON;
                        break;
                    case 13:
                        str = "turning_off";
                        break;
                }
            }
        } else {
            str = "unsupported";
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("state", str);
        Log.d(LOG_TAG, "state:" + str);
        sendEvent("BleManagerDidUpdateState", createMap);
        callback.invoke(str);
    }

    @ReactMethod
    public void setName(String str) {
        getBluetoothAdapter().setName(str);
    }

    /* access modifiers changed from: private */
    public void clearPeripherals() {
        if (!this.peripherals.isEmpty()) {
            synchronized (this.peripherals) {
                this.peripherals.clear();
            }
        }
    }

    /* access modifiers changed from: private */
    public void disconnectPeripherals() {
        if (!this.peripherals.isEmpty()) {
            synchronized (this.peripherals) {
                for (Peripheral next : this.peripherals.values()) {
                    if (next.isConnected()) {
                        next.disconnect((Callback) null, true);
                    }
                }
            }
        }
    }

    @ReactMethod
    public void getDiscoveredPeripherals(Callback callback) {
        Log.d(LOG_TAG, "Get discovered peripherals");
        WritableArray createArray = Arguments.createArray();
        synchronized (this.peripherals) {
            for (Map.Entry<String, Peripheral> value : this.peripherals.entrySet()) {
                createArray.pushMap(((Peripheral) value.getValue()).asWritableMap());
            }
        }
        callback.invoke(null, createArray);
    }

    @ReactMethod
    public void getConnectedPeripherals(ReadableArray readableArray, Callback callback) {
        Log.d(LOG_TAG, "Get connected peripherals");
        WritableArray createArray = Arguments.createArray();
        if (getBluetoothAdapter() == null) {
            Log.d(LOG_TAG, "No bluetooth support");
            callback.invoke("No bluetooth support");
            return;
        }
        for (BluetoothDevice savePeripheral : getBluetoothManager().getConnectedDevices(7)) {
            createArray.pushMap(savePeripheral(savePeripheral).asWritableMap());
        }
        callback.invoke(null, createArray);
    }

    @ReactMethod
    public void getBondedPeripherals(Callback callback) {
        Peripheral peripheral;
        Log.d(LOG_TAG, "Get bonded peripherals");
        WritableArray createArray = Arguments.createArray();
        for (BluetoothDevice next : getBluetoothAdapter().getBondedDevices()) {
            if (Build.VERSION.SDK_INT < 21 || this.forceLegacy) {
                peripheral = new Peripheral(next, this.reactContext);
            } else {
                peripheral = new LollipopPeripheral(next, this.reactContext);
            }
            createArray.pushMap(peripheral.asWritableMap());
        }
        callback.invoke(null, createArray);
    }

    @ReactMethod
    public void removePeripheral(String str, Callback callback) {
        Log.d(LOG_TAG, "Removing from list: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            synchronized (this.peripherals) {
                if (peripheral.isConnected()) {
                    callback.invoke("Peripheral can not be removed while connected");
                } else {
                    this.peripherals.remove(str);
                    callback.invoke(new Object[0]);
                }
            }
            return;
        }
        callback.invoke("Peripheral not found");
    }

    @ReactMethod
    public void requestConnectionPriority(String str, int i, Callback callback) {
        Log.d(LOG_TAG, "Request connection priority of " + i + " from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.requestConnectionPriority(i, callback);
            return;
        }
        callback.invoke("Peripheral not found", null);
    }

    @ReactMethod
    public void requestMTU(String str, int i, Callback callback) {
        Log.d(LOG_TAG, "Request MTU of " + i + " bytes from: " + str);
        Peripheral peripheral = this.peripherals.get(str);
        if (peripheral != null) {
            peripheral.requestMTU(i, callback);
            return;
        }
        callback.invoke("Peripheral not found", null);
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & UByte.MAX_VALUE;
            int i2 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static WritableArray bytesToWritableArray(byte[] bArr) {
        WritableArray createArray = Arguments.createArray();
        for (byte b : bArr) {
            createArray.pushInt(b & UByte.MAX_VALUE);
        }
        return createArray;
    }

    private Peripheral retrieveOrCreatePeripheral(String str) {
        Peripheral peripheral;
        Peripheral peripheral2 = this.peripherals.get(str);
        if (peripheral2 == null) {
            synchronized (this.peripherals) {
                if (str != null) {
                    str = str.toUpperCase();
                }
                if (BluetoothAdapter.checkBluetoothAddress(str)) {
                    BluetoothDevice remoteDevice = this.bluetoothAdapter.getRemoteDevice(str);
                    if (Build.VERSION.SDK_INT < 21 || this.forceLegacy) {
                        peripheral = new Peripheral(remoteDevice, this.reactContext);
                    } else {
                        peripheral = new LollipopPeripheral(remoteDevice, this.reactContext);
                    }
                    this.peripherals.put(str, peripheral);
                    peripheral2 = peripheral;
                }
            }
        }
        return peripheral2;
    }

    public void onCatalystInstanceDestroy() {
        try {
            disconnectPeripherals();
        } catch (Exception e) {
            Log.d(LOG_TAG, "Could not disconnect peripherals", e);
        }
        ScanManager scanManager2 = this.scanManager;
        if (scanManager2 != null) {
            scanManager2.stopScan($$Lambda$BleManager$h6y4lUJmweH1NoS40t2D2bbUfiQ.INSTANCE);
        }
    }
}
