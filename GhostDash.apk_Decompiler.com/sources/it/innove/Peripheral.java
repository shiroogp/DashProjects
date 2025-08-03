package it.innove;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.arthenica.ffmpegkit.Chapter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.UByte;
import org.json.JSONException;

public class Peripheral extends BluetoothGattCallback {
    private static final String CHARACTERISTIC_NOTIFICATION_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    public static final int GATT_AUTH_FAIL = 137;
    public static final int GATT_INSUFFICIENT_AUTHENTICATION = 5;
    protected volatile byte[] advertisingDataBytes = new byte[0];
    protected volatile int advertisingRSSI;
    private final Map<String, NotifyBufferContainer> bufferedCharacteristics;
    private final Queue<Runnable> commandQueue = new ConcurrentLinkedQueue();
    private boolean commandQueueBusy = false;
    private LinkedList<Callback> connectCallbacks = new LinkedList<>();
    private volatile boolean connected = false;
    private volatile boolean connecting = false;
    private final BluetoothDevice device;
    /* access modifiers changed from: private */
    public Runnable discoverServicesRunnable;
    /* access modifiers changed from: private */
    public BluetoothGatt gatt;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private ReactContext reactContext;
    private LinkedList<Callback> readCallbacks = new LinkedList<>();
    private LinkedList<Callback> readDescriptorCallbacks = new LinkedList<>();
    private LinkedList<Callback> readRSSICallbacks = new LinkedList<>();
    private LinkedList<Callback> registerNotifyCallbacks = new LinkedList<>();
    private LinkedList<Callback> requestMTUCallbacks = new LinkedList<>();
    private LinkedList<Callback> retrieveServicesCallbacks = new LinkedList<>();
    /* access modifiers changed from: private */
    public LinkedList<Callback> writeCallbacks = new LinkedList<>();
    private List<byte[]> writeQueue = new ArrayList();

    public int unsignedToBytes(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public Peripheral(BluetoothDevice bluetoothDevice, int i, byte[] bArr, ReactContext reactContext2) {
        this.device = bluetoothDevice;
        this.bufferedCharacteristics = new ConcurrentHashMap();
        this.advertisingRSSI = i;
        this.advertisingDataBytes = bArr;
        this.reactContext = reactContext2;
    }

    public Peripheral(BluetoothDevice bluetoothDevice, ReactContext reactContext2) {
        this.device = bluetoothDevice;
        this.bufferedCharacteristics = new ConcurrentHashMap();
        this.reactContext = reactContext2;
    }

    private void sendEvent(String str, WritableMap writableMap) {
        synchronized (this.reactContext) {
            ((RCTNativeAppEventEmitter) this.reactContext.getJSModule(RCTNativeAppEventEmitter.class)).emit(str, writableMap);
        }
    }

    private void sendConnectionEvent(BluetoothDevice bluetoothDevice, String str, int i) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("peripheral", bluetoothDevice.getAddress());
        if (i != -1) {
            createMap.putInt("status", i);
        }
        sendEvent(str, createMap);
        Log.d(BleManager.LOG_TAG, "Peripheral event (" + str + "):" + bluetoothDevice.getAddress());
    }

    public void connect(Callback callback, Activity activity) {
        this.mainHandler.post(new Runnable(callback, activity) {
            public final /* synthetic */ Callback f$1;
            public final /* synthetic */ Activity f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$connect$0$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$connect$0$Peripheral(Callback callback, Activity activity) {
        if (!this.connected) {
            BluetoothDevice device2 = getDevice();
            this.connectCallbacks.addLast(callback);
            this.connecting = true;
            if (Build.VERSION.SDK_INT >= 23) {
                Log.d(BleManager.LOG_TAG, " Is Or Greater than M $mBluetoothDevice");
                this.gatt = device2.connectGatt(activity, false, this, 2);
                return;
            }
            Log.d(BleManager.LOG_TAG, " Less than M");
            try {
                Log.d(BleManager.LOG_TAG, " Trying TRANPORT LE with reflection");
                Method declaredMethod = device2.getClass().getDeclaredMethod("connectGatt", new Class[]{Context.class, Boolean.class, BluetoothGattCallback.class, Integer.class});
                declaredMethod.setAccessible(true);
                this.gatt = (BluetoothGatt) declaredMethod.invoke(device2, new Object[]{activity, false, this, Integer.valueOf(device2.getClass().getDeclaredField("TRANSPORT_LE").getInt((Object) null))});
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(ReactConstants.TAG, " Catch to call normal connection");
                this.gatt = device2.connectGatt(activity, false, this);
            }
        } else if (this.gatt != null) {
            callback.invoke(new Object[0]);
        } else {
            callback.invoke("BluetoothGatt is null");
        }
    }

    public void disconnect(Callback callback, boolean z) {
        this.mainHandler.post(new Runnable(z, callback) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ Callback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$disconnect$1$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$disconnect$1$Peripheral(boolean z, Callback callback) {
        Iterator it2 = this.connectCallbacks.iterator();
        while (it2.hasNext()) {
            ((Callback) it2.next()).invoke("Disconnect called before connect callback invoked");
        }
        this.connectCallbacks.clear();
        this.connected = false;
        clearBuffers();
        this.commandQueue.clear();
        this.commandQueueBusy = false;
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt != null) {
            try {
                bluetoothGatt.disconnect();
                if (z) {
                    this.gatt.close();
                    this.gatt = null;
                    sendConnectionEvent(this.device, "BleManagerDisconnectPeripheral", 0);
                }
                Log.d(BleManager.LOG_TAG, "Disconnect");
            } catch (Exception e) {
                sendConnectionEvent(this.device, "BleManagerDisconnectPeripheral", 257);
                Log.d(BleManager.LOG_TAG, "Error on disconnect", e);
            }
        } else {
            Log.d(BleManager.LOG_TAG, "GATT is null");
        }
        if (callback != null) {
            callback.invoke(new Object[0]);
        }
    }

    public WritableMap asWritableMap() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        try {
            createMap.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, this.device.getName());
            createMap.putString(Chapter.KEY_ID, this.device.getAddress());
            createMap.putInt("rssi", this.advertisingRSSI);
            String name = this.device.getName();
            if (name != null) {
                createMap2.putString("localName", name);
            }
            createMap2.putMap("manufacturerData", byteArrayToWritableMap(this.advertisingDataBytes));
            createMap2.putBoolean("isConnectable", true);
            createMap.putMap("advertising", createMap2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createMap;
    }

    public WritableMap asWritableMap(BluetoothGatt bluetoothGatt) {
        Iterator<BluetoothGattService> it2;
        WritableMap asWritableMap = asWritableMap();
        WritableArray createArray = Arguments.createArray();
        WritableArray createArray2 = Arguments.createArray();
        if (this.connected && bluetoothGatt != null) {
            Iterator<BluetoothGattService> it3 = bluetoothGatt.getServices().iterator();
            while (it3.hasNext()) {
                BluetoothGattService next = it3.next();
                WritableMap createMap = Arguments.createMap();
                createMap.putString("uuid", UUIDHelper.uuidToString(next.getUuid()));
                for (BluetoothGattCharacteristic next2 : next.getCharacteristics()) {
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString(NotificationCompat.CATEGORY_SERVICE, UUIDHelper.uuidToString(next.getUuid()));
                    createMap2.putString("characteristic", UUIDHelper.uuidToString(next2.getUuid()));
                    createMap2.putMap("properties", Helper.decodeProperties(next2));
                    if (next2.getPermissions() > 0) {
                        createMap2.putMap("permissions", Helper.decodePermissions(next2));
                    }
                    WritableArray createArray3 = Arguments.createArray();
                    for (BluetoothGattDescriptor next3 : next2.getDescriptors()) {
                        WritableMap createMap3 = Arguments.createMap();
                        createMap3.putString("uuid", UUIDHelper.uuidToString(next3.getUuid()));
                        if (next3.getValue() != null) {
                            it2 = it3;
                            createMap3.putString("value", Base64.encodeToString(next3.getValue(), 2));
                        } else {
                            it2 = it3;
                            createMap3.putString("value", (String) null);
                        }
                        if (next3.getPermissions() > 0) {
                            createMap3.putMap("permissions", Helper.decodePermissions(next3));
                        }
                        createArray3.pushMap(createMap3);
                        it3 = it2;
                    }
                    Iterator<BluetoothGattService> it4 = it3;
                    if (createArray3.size() > 0) {
                        createMap2.putArray("descriptors", createArray3);
                    }
                    createArray2.pushMap(createMap2);
                    it3 = it4;
                }
                Iterator<BluetoothGattService> it5 = it3;
                createArray.pushMap(createMap);
            }
            asWritableMap.putArray("services", createArray);
            asWritableMap.putArray("characteristics", createArray2);
        }
        return asWritableMap;
    }

    static WritableMap byteArrayToWritableMap(byte[] bArr) throws JSONException {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("CDVType", "ArrayBuffer");
        WritableArray writableArray = null;
        createMap.putString("data", bArr != null ? Base64.encodeToString(bArr, 2) : null);
        if (bArr != null) {
            writableArray = BleManager.bytesToWritableArray(bArr);
        }
        createMap.putArray("bytes", writableArray);
        return createMap;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public boolean isConnecting() {
        return this.connecting;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        super.onServicesDiscovered(bluetoothGatt, i);
        this.mainHandler.post(new Runnable(bluetoothGatt) {
            public final /* synthetic */ BluetoothGatt f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Peripheral.this.lambda$onServicesDiscovered$2$Peripheral(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onServicesDiscovered$2$Peripheral(BluetoothGatt bluetoothGatt) {
        WritableMap asWritableMap = asWritableMap(bluetoothGatt);
        Iterator it2 = this.retrieveServicesCallbacks.iterator();
        while (it2.hasNext()) {
            ((Callback) it2.next()).invoke(null, asWritableMap);
        }
        this.retrieveServicesCallbacks.clear();
        completedCommand();
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        Log.d(BleManager.LOG_TAG, "onConnectionStateChange to " + i2 + " on peripheral: " + this.device.getAddress() + " with status " + i);
        this.mainHandler.post(new Runnable(bluetoothGatt, i, i2) {
            public final /* synthetic */ BluetoothGatt f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                Peripheral.this.lambda$onConnectionStateChange$3$Peripheral(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public /* synthetic */ void lambda$onConnectionStateChange$3$Peripheral(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.gatt = bluetoothGatt;
        if (i != 0) {
            bluetoothGatt.close();
        }
        this.connecting = false;
        if (i2 == 2 && i == 0) {
            this.connected = true;
            AnonymousClass1 r7 = new Runnable() {
                public void run() {
                    try {
                        Peripheral.this.gatt.discoverServices();
                    } catch (NullPointerException unused) {
                        Log.d(BleManager.LOG_TAG, "onConnectionStateChange connected but gatt of Run method was null");
                    }
                    Runnable unused2 = Peripheral.this.discoverServicesRunnable = null;
                }
            };
            this.discoverServicesRunnable = r7;
            this.mainHandler.post(r7);
            sendConnectionEvent(this.device, "BleManagerConnectPeripheral", i);
            Log.d(BleManager.LOG_TAG, "Connected to: " + this.device.getAddress());
            Iterator it2 = this.connectCallbacks.iterator();
            while (it2.hasNext()) {
                ((Callback) it2.next()).invoke(new Object[0]);
            }
            this.connectCallbacks.clear();
        } else if (i2 == 0 || i != 0) {
            Runnable runnable = this.discoverServicesRunnable;
            if (runnable != null) {
                this.mainHandler.removeCallbacks(runnable);
                this.discoverServicesRunnable = null;
            }
            Iterator it3 = this.writeCallbacks.iterator();
            while (it3.hasNext()) {
                ((Callback) it3.next()).invoke("Device disconnected");
            }
            this.writeCallbacks.clear();
            Iterator it4 = this.retrieveServicesCallbacks.iterator();
            while (it4.hasNext()) {
                ((Callback) it4.next()).invoke("Device disconnected");
            }
            this.retrieveServicesCallbacks.clear();
            Iterator it5 = this.readRSSICallbacks.iterator();
            while (it5.hasNext()) {
                ((Callback) it5.next()).invoke("Device disconnected");
            }
            this.readRSSICallbacks.clear();
            Iterator it6 = this.registerNotifyCallbacks.iterator();
            while (it6.hasNext()) {
                ((Callback) it6.next()).invoke("Device disconnected");
            }
            this.registerNotifyCallbacks.clear();
            Iterator it7 = this.requestMTUCallbacks.iterator();
            while (it7.hasNext()) {
                ((Callback) it7.next()).invoke("Device disconnected");
            }
            this.requestMTUCallbacks.clear();
            Iterator it8 = this.readCallbacks.iterator();
            while (it8.hasNext()) {
                ((Callback) it8.next()).invoke("Device disconnected");
            }
            this.readCallbacks.clear();
            Iterator it9 = this.readDescriptorCallbacks.iterator();
            while (it9.hasNext()) {
                ((Callback) it9.next()).invoke("Device disconnected");
            }
            this.readDescriptorCallbacks.clear();
            Iterator it10 = this.connectCallbacks.iterator();
            while (it10.hasNext()) {
                ((Callback) it10.next()).invoke("Connection error");
            }
            this.connectCallbacks.clear();
            this.writeQueue.clear();
            this.commandQueue.clear();
            this.commandQueueBusy = false;
            this.connected = false;
            clearBuffers();
            this.commandQueue.clear();
            this.commandQueueBusy = false;
            this.gatt.disconnect();
            this.gatt.close();
            this.gatt = null;
            sendConnectionEvent(this.device, "BleManagerDisconnectPeripheral", 0);
        }
    }

    public void updateRssi(int i) {
        this.advertisingRSSI = i;
    }

    public void updateData(byte[] bArr) {
        this.advertisingDataBytes = bArr;
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        try {
            String uuid = bluetoothGattCharacteristic.getUuid().toString();
            String uuid2 = bluetoothGattCharacteristic.getService().getUuid().toString();
            NotifyBufferContainer notifyBufferContainer = this.bufferedCharacteristics.get(bufferedCharacteristicsKey(uuid2, uuid));
            byte[] value = bluetoothGattCharacteristic.getValue();
            while (value != null) {
                byte[] bArr = null;
                if (notifyBufferContainer != null) {
                    byte[] put = notifyBufferContainer.put(value);
                    Log.d(BleManager.LOG_TAG, "onCharacteristicChanged-buffering: " + notifyBufferContainer.size() + " from peripheral: " + this.device.getAddress());
                    if (notifyBufferContainer.isBufferFull()) {
                        Log.d(BleManager.LOG_TAG, "onCharacteristicChanged sending buffered data " + notifyBufferContainer.size());
                        byte[] array = notifyBufferContainer.items.array();
                        notifyBufferContainer.resetBuffer();
                        byte[] bArr2 = array;
                        bArr = put;
                        value = bArr2;
                    } else {
                        return;
                    }
                }
                Log.d(BleManager.LOG_TAG, "onCharacteristicChanged: " + BleManager.bytesToHex(value) + " from peripheral: " + this.device.getAddress());
                WritableMap createMap = Arguments.createMap();
                createMap.putString("peripheral", this.device.getAddress());
                createMap.putString("characteristic", uuid);
                createMap.putString(NotificationCompat.CATEGORY_SERVICE, uuid2);
                createMap.putArray("value", BleManager.bytesToWritableArray(value));
                sendEvent("BleManagerDidUpdateValueForCharacteristic", createMap);
                value = bArr;
            }
        } catch (Exception e) {
            Log.d(BleManager.LOG_TAG, "onCharacteristicChanged ERROR: " + e);
        }
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        this.mainHandler.post(new Runnable(i, bluetoothGattCharacteristic) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ BluetoothGattCharacteristic f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$onCharacteristicRead$4$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onCharacteristicRead$4$Peripheral(int i, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (i != 0) {
            if (i == 137 || i == 5) {
                Log.d(BleManager.LOG_TAG, "Read needs bonding");
            }
            Iterator it2 = this.readCallbacks.iterator();
            while (it2.hasNext()) {
                ((Callback) it2.next()).invoke("Error reading " + bluetoothGattCharacteristic.getUuid() + " status=" + i, null);
            }
            this.readCallbacks.clear();
        } else if (!this.readCallbacks.isEmpty()) {
            byte[] copyOf = copyOf(bluetoothGattCharacteristic.getValue());
            Iterator it3 = this.readCallbacks.iterator();
            while (it3.hasNext()) {
                ((Callback) it3.next()).invoke(null, BleManager.bytesToWritableArray(copyOf));
            }
            this.readCallbacks.clear();
        }
        completedCommand();
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        this.mainHandler.post(new Runnable(bluetoothGattCharacteristic, i) {
            public final /* synthetic */ BluetoothGattCharacteristic f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$onCharacteristicWrite$5$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onCharacteristicWrite$5$Peripheral(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (this.writeQueue.size() > 0) {
            this.writeQueue.remove(0);
            doWrite(bluetoothGattCharacteristic, this.writeQueue.get(0), (Callback) null);
        } else if (i != 0) {
            if (i == 137 || i == 5) {
                Log.d(BleManager.LOG_TAG, "Write needs bonding");
                return;
            }
            Iterator it2 = this.writeCallbacks.iterator();
            while (it2.hasNext()) {
                ((Callback) it2.next()).invoke("Error writing " + bluetoothGattCharacteristic.getUuid() + " status=" + i, null);
            }
            this.writeCallbacks.clear();
        } else if (!this.writeCallbacks.isEmpty()) {
            Iterator it3 = this.writeCallbacks.iterator();
            while (it3.hasNext()) {
                ((Callback) it3.next()).invoke(new Object[0]);
            }
            this.writeCallbacks.clear();
        }
        completedCommand();
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.mainHandler.post(new Runnable(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Peripheral.this.lambda$onDescriptorWrite$6$Peripheral(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onDescriptorWrite$6$Peripheral(int i) {
        if (!this.registerNotifyCallbacks.isEmpty()) {
            if (i == 0) {
                Iterator it2 = this.registerNotifyCallbacks.iterator();
                while (it2.hasNext()) {
                    ((Callback) it2.next()).invoke(new Object[0]);
                }
                Log.d(BleManager.LOG_TAG, "onDescriptorWrite success");
            } else {
                Iterator it3 = this.registerNotifyCallbacks.iterator();
                while (it3.hasNext()) {
                    ((Callback) it3.next()).invoke("Error writing descriptor status=" + i, null);
                }
                Log.e(BleManager.LOG_TAG, "Error writing descriptor status=" + i);
            }
            this.registerNotifyCallbacks.clear();
        } else {
            Log.e(BleManager.LOG_TAG, "onDescriptorWrite with no callback");
        }
        completedCommand();
    }

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        this.mainHandler.post(new Runnable(i, bluetoothGattDescriptor) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ BluetoothGattDescriptor f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$onDescriptorRead$7$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onDescriptorRead$7$Peripheral(int i, BluetoothGattDescriptor bluetoothGattDescriptor) {
        if (i != 0) {
            if (i == 137 || i == 5) {
                Log.d(BleManager.LOG_TAG, "Read needs bonding");
            }
            Iterator it2 = this.readDescriptorCallbacks.iterator();
            while (it2.hasNext()) {
                ((Callback) it2.next()).invoke("Error reading descriptor " + bluetoothGattDescriptor.getUuid() + " status=" + i, null);
            }
            this.readDescriptorCallbacks.clear();
        } else if (!this.readDescriptorCallbacks.isEmpty()) {
            byte[] copyOf = copyOf(bluetoothGattDescriptor.getValue());
            Iterator it3 = this.readDescriptorCallbacks.iterator();
            while (it3.hasNext()) {
                ((Callback) it3.next()).invoke(null, BleManager.bytesToWritableArray(copyOf));
            }
            this.readDescriptorCallbacks.clear();
        }
        completedCommand();
    }

    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onReadRemoteRssi(bluetoothGatt, i, i2);
        this.mainHandler.post(new Runnable(i2, i) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$onReadRemoteRssi$8$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onReadRemoteRssi$8$Peripheral(int i, int i2) {
        if (!this.readRSSICallbacks.isEmpty()) {
            if (i == 0) {
                updateRssi(i2);
                Iterator it2 = this.readRSSICallbacks.iterator();
                while (it2.hasNext()) {
                    ((Callback) it2.next()).invoke(null, Integer.valueOf(i2));
                }
            } else {
                Iterator it3 = this.readRSSICallbacks.iterator();
                while (it3.hasNext()) {
                    ((Callback) it3.next()).invoke("Error reading RSSI status=" + i, null);
                }
            }
            this.readRSSICallbacks.clear();
        }
        completedCommand();
    }

    private String bufferedCharacteristicsKey(String str, String str2) {
        return str + "-" + str2;
    }

    private void clearBuffers() {
        for (Map.Entry<String, NotifyBufferContainer> value : this.bufferedCharacteristics.entrySet()) {
            ((NotifyBufferContainer) value.getValue()).resetBuffer();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setNotify(java.util.UUID r9, java.util.UUID r10, java.lang.Boolean r11, com.facebook.react.bridge.Callback r12) {
        /*
            r8 = this;
            boolean r0 = r8.isConnected()
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x017e
            android.bluetooth.BluetoothGatt r0 = r8.gatt
            if (r0 != 0) goto L_0x0010
            goto L_0x017e
        L_0x0010:
            android.bluetooth.BluetoothGattService r9 = r0.getService(r9)
            android.bluetooth.BluetoothGattCharacteristic r9 = r8.findNotifyCharacteristic(r9, r10)
            java.lang.String r0 = "Characteristic "
            if (r9 != 0) goto L_0x003e
            java.lang.Object[] r9 = new java.lang.Object[r3]
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.StringBuilder r10 = r11.append(r10)
            java.lang.String r11 = " not found"
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9[r4] = r10
            r12.invoke(r9)
            r8.completedCommand()
            return
        L_0x003e:
            android.bluetooth.BluetoothGatt r5 = r8.gatt
            boolean r6 = r11.booleanValue()
            boolean r5 = r5.setCharacteristicNotification(r9, r6)
            if (r5 != 0) goto L_0x0068
            java.lang.Object[] r9 = new java.lang.Object[r3]
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Failed to register notification for "
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.StringBuilder r10 = r11.append(r10)
            java.lang.String r10 = r10.toString()
            r9[r4] = r10
            r12.invoke(r9)
            r8.completedCommand()
            return
        L_0x0068:
            java.lang.String r5 = "00002902-0000-1000-8000-00805f9b34fb"
            java.util.UUID r5 = it.innove.UUIDHelper.uuidFromString(r5)
            android.bluetooth.BluetoothGattDescriptor r5 = r9.getDescriptor(r5)
            if (r5 != 0) goto L_0x0092
            java.lang.Object[] r9 = new java.lang.Object[r3]
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Set notification failed for "
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.StringBuilder r10 = r11.append(r10)
            java.lang.String r10 = r10.toString()
            r9[r4] = r10
            r12.invoke(r9)
            r8.completedCommand()
            return
        L_0x0092:
            int r6 = r9.getProperties()
            r6 = r6 & 16
            java.lang.String r7 = "ReactNativeBleManager"
            if (r6 == 0) goto L_0x00c2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r0 = r6.append(r0)
            java.lang.StringBuilder r10 = r0.append(r10)
            java.lang.String r0 = " set NOTIFY"
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r7, r10)
            boolean r10 = r11.booleanValue()
            if (r10 == 0) goto L_0x00bf
            byte[] r10 = android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            goto L_0x00ef
        L_0x00bf:
            byte[] r10 = android.bluetooth.BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
            goto L_0x00ef
        L_0x00c2:
            int r6 = r9.getProperties()
            r6 = r6 & 32
            if (r6 == 0) goto L_0x0159
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r0 = r6.append(r0)
            java.lang.StringBuilder r10 = r0.append(r10)
            java.lang.String r0 = " set INDICATE"
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r7, r10)
            boolean r10 = r11.booleanValue()
            if (r10 == 0) goto L_0x00ed
            byte[] r10 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
            goto L_0x00ef
        L_0x00ed:
            byte[] r10 = android.bluetooth.BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
        L_0x00ef:
            boolean r0 = r11.booleanValue()
            if (r0 == 0) goto L_0x00f6
            goto L_0x00f8
        L_0x00f6:
            byte[] r10 = android.bluetooth.BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
        L_0x00f8:
            android.bluetooth.BluetoothGatt r0 = r8.gatt     // Catch:{ Exception -> 0x0114 }
            boolean r11 = r11.booleanValue()     // Catch:{ Exception -> 0x0114 }
            boolean r9 = r0.setCharacteristicNotification(r9, r11)     // Catch:{ Exception -> 0x0114 }
            r5.setValue(r10)     // Catch:{ Exception -> 0x0112 }
            java.util.LinkedList<com.facebook.react.bridge.Callback> r10 = r8.registerNotifyCallbacks     // Catch:{ Exception -> 0x0112 }
            r10.addLast(r12)     // Catch:{ Exception -> 0x0112 }
            android.bluetooth.BluetoothGatt r10 = r8.gatt     // Catch:{ Exception -> 0x0112 }
            boolean r10 = r10.writeDescriptor(r5)     // Catch:{ Exception -> 0x0112 }
            r9 = r9 & r10
            goto L_0x011b
        L_0x0112:
            r10 = move-exception
            goto L_0x0116
        L_0x0114:
            r10 = move-exception
            r9 = r4
        L_0x0116:
            java.lang.String r11 = "Exception in setNotify"
            android.util.Log.d(r7, r11, r10)
        L_0x011b:
            if (r9 != 0) goto L_0x0158
            java.util.LinkedList<com.facebook.react.bridge.Callback> r9 = r8.registerNotifyCallbacks
            java.util.Iterator r9 = r9.iterator()
        L_0x0123:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0150
            java.lang.Object r10 = r9.next()
            com.facebook.react.bridge.Callback r10 = (com.facebook.react.bridge.Callback) r10
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "writeDescriptor failed for descriptor: "
            java.lang.StringBuilder r12 = r12.append(r0)
            java.util.UUID r0 = r5.getUuid()
            java.lang.StringBuilder r12 = r12.append(r0)
            java.lang.String r12 = r12.toString()
            r11[r4] = r12
            r11[r3] = r1
            r10.invoke(r11)
            goto L_0x0123
        L_0x0150:
            java.util.LinkedList<com.facebook.react.bridge.Callback> r9 = r8.registerNotifyCallbacks
            r9.clear()
            r8.completedCommand()
        L_0x0158:
            return
        L_0x0159:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = " does not have NOTIFY or INDICATE property set"
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r7, r9)
            java.lang.Object[] r10 = new java.lang.Object[r3]
            r10[r4] = r9
            r12.invoke(r10)
            r8.completedCommand()
            return
        L_0x017e:
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r10 = "Device is not connected"
            r9[r4] = r10
            r9[r3] = r1
            r12.invoke(r9)
            r8.completedCommand()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.innove.Peripheral.setNotify(java.util.UUID, java.util.UUID, java.lang.Boolean, com.facebook.react.bridge.Callback):void");
    }

    public void registerNotify(UUID uuid, UUID uuid2, Integer num, Callback callback) {
        if (!enqueue(new Runnable(num, uuid, uuid2, callback) {
            public final /* synthetic */ Integer f$1;
            public final /* synthetic */ UUID f$2;
            public final /* synthetic */ UUID f$3;
            public final /* synthetic */ Callback f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                Peripheral.this.lambda$registerNotify$9$Peripheral(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        })) {
            Log.e(BleManager.LOG_TAG, "Could not enqueue setNotify command to register notify");
        }
    }

    public /* synthetic */ void lambda$registerNotify$9$Peripheral(Integer num, UUID uuid, UUID uuid2, Callback callback) {
        Log.d(BleManager.LOG_TAG, "registerNotify");
        if (num.intValue() > 1) {
            Log.d(BleManager.LOG_TAG, "registerNotify using buffer");
            this.bufferedCharacteristics.put(bufferedCharacteristicsKey(uuid.toString(), uuid2.toString()), new NotifyBufferContainer(num.intValue()));
        }
        setNotify(uuid, uuid2, true, callback);
    }

    public void removeNotify(UUID uuid, UUID uuid2, Callback callback) {
        if (!enqueue(new Runnable(uuid, uuid2, callback) {
            public final /* synthetic */ UUID f$1;
            public final /* synthetic */ UUID f$2;
            public final /* synthetic */ Callback f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                Peripheral.this.lambda$removeNotify$10$Peripheral(this.f$1, this.f$2, this.f$3);
            }
        })) {
            Log.e(BleManager.LOG_TAG, "Could not enqueue setNotify command to remove notify");
        }
    }

    public /* synthetic */ void lambda$removeNotify$10$Peripheral(UUID uuid, UUID uuid2, Callback callback) {
        Log.d(BleManager.LOG_TAG, "removeNotify");
        String bufferedCharacteristicsKey = bufferedCharacteristicsKey(uuid.toString(), uuid2.toString());
        if (this.bufferedCharacteristics.containsKey(bufferedCharacteristicsKey)) {
            NotifyBufferContainer notifyBufferContainer = this.bufferedCharacteristics.get(bufferedCharacteristicsKey);
            this.bufferedCharacteristics.remove(bufferedCharacteristicsKey);
        }
        setNotify(uuid, uuid2, false, callback);
    }

    private BluetoothGattCharacteristic findNotifyCharacteristic(BluetoothGattService bluetoothGattService, UUID uuid) {
        try {
            List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
            for (BluetoothGattCharacteristic next : characteristics) {
                if ((next.getProperties() & 16) != 0 && uuid.equals(next.getUuid())) {
                    return next;
                }
            }
            for (BluetoothGattCharacteristic next2 : characteristics) {
                if ((next2.getProperties() & 32) != 0 && uuid.equals(next2.getUuid())) {
                    return next2;
                }
            }
            return bluetoothGattService.getCharacteristic(uuid);
        } catch (Exception e) {
            Log.e(BleManager.LOG_TAG, "Error retriving characteristic " + uuid, e);
            return null;
        }
    }

    public void read(UUID uuid, UUID uuid2, Callback callback) {
        enqueue(new Runnable(callback, uuid, uuid2) {
            public final /* synthetic */ Callback f$1;
            public final /* synthetic */ UUID f$2;
            public final /* synthetic */ UUID f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                Peripheral.this.lambda$read$11$Peripheral(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public /* synthetic */ void lambda$read$11$Peripheral(Callback callback, UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        if (!isConnected() || (bluetoothGatt = this.gatt) == null) {
            callback.invoke("Device is not connected", null);
            completedCommand();
            return;
        }
        BluetoothGattCharacteristic findReadableCharacteristic = findReadableCharacteristic(bluetoothGatt.getService(uuid), uuid2);
        if (findReadableCharacteristic == null) {
            callback.invoke("Characteristic " + uuid2 + " not found.", null);
            completedCommand();
            return;
        }
        this.readCallbacks.addLast(callback);
        if (!this.gatt.readCharacteristic(findReadableCharacteristic)) {
            Iterator it2 = this.readCallbacks.iterator();
            while (it2.hasNext()) {
                ((Callback) it2.next()).invoke("Read failed", null);
            }
            this.readCallbacks.clear();
            completedCommand();
        }
    }

    public void readDescriptor(UUID uuid, UUID uuid2, UUID uuid3, Callback callback) {
        enqueue(new Runnable(callback, uuid, uuid2, uuid3) {
            public final /* synthetic */ Callback f$1;
            public final /* synthetic */ UUID f$2;
            public final /* synthetic */ UUID f$3;
            public final /* synthetic */ UUID f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                Peripheral.this.lambda$readDescriptor$12$Peripheral(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
    }

    public /* synthetic */ void lambda$readDescriptor$12$Peripheral(Callback callback, UUID uuid, UUID uuid2, UUID uuid3) {
        BluetoothGatt bluetoothGatt;
        if (!isConnected() || (bluetoothGatt = this.gatt) == null) {
            callback.invoke("Device is not connected", null);
            completedCommand();
            return;
        }
        BluetoothGattCharacteristic findReadableCharacteristic = findReadableCharacteristic(bluetoothGatt.getService(uuid), uuid2);
        if (findReadableCharacteristic == null) {
            callback.invoke("Characteristic " + uuid2 + " not found.", null);
            completedCommand();
            return;
        }
        BluetoothGattDescriptor descriptor = findReadableCharacteristic.getDescriptor(uuid3);
        if (descriptor == null) {
            callback.invoke("Read descriptor failed for " + uuid3, null);
            completedCommand();
        } else if ((descriptor.getPermissions() & 7) != 0) {
            callback.invoke("Read descriptor failed for " + uuid3 + ": Descriptor is missing read permission", null);
            completedCommand();
        } else {
            this.readDescriptorCallbacks.addLast(callback);
            if (!this.gatt.readDescriptor(descriptor)) {
                Iterator it2 = this.readDescriptorCallbacks.iterator();
                while (it2.hasNext()) {
                    ((Callback) it2.next()).invoke("Reading descriptor failed", null);
                }
                this.readDescriptorCallbacks.clear();
                completedCommand();
            }
        }
    }

    private byte[] copyOf(byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private boolean enqueue(Runnable runnable) {
        boolean add = this.commandQueue.add(runnable);
        if (add) {
            nextCommand();
        } else {
            Log.d(BleManager.LOG_TAG, "could not enqueue command");
        }
        return add;
    }

    /* access modifiers changed from: private */
    public void completedCommand() {
        this.commandQueue.poll();
        this.commandQueueBusy = false;
        nextCommand();
    }

    private void nextCommand() {
        synchronized (this) {
            if (this.commandQueueBusy) {
                Log.d(BleManager.LOG_TAG, "Command queue busy");
                return;
            }
            final Runnable peek = this.commandQueue.peek();
            if (peek == null) {
                Log.d(BleManager.LOG_TAG, "Command queue empty");
            } else if (this.gatt == null) {
                Log.d(BleManager.LOG_TAG, "Error, gatt is null");
                this.commandQueue.clear();
                this.commandQueueBusy = false;
            } else {
                this.commandQueueBusy = true;
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        try {
                            peek.run();
                        } catch (Exception unused) {
                            Log.d(BleManager.LOG_TAG, "Error, command exception");
                            Peripheral.this.completedCommand();
                        }
                    }
                });
            }
        }
    }

    public void readRSSI(Callback callback) {
        if (!enqueue(new Runnable(callback) {
            public final /* synthetic */ Callback f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Peripheral.this.lambda$readRSSI$13$Peripheral(this.f$1);
            }
        })) {
            Log.d(BleManager.LOG_TAG, "Could not queue readRemoteRssi command");
        }
    }

    public /* synthetic */ void lambda$readRSSI$13$Peripheral(Callback callback) {
        if (!isConnected()) {
            callback.invoke("Device is not connected", null);
            completedCommand();
        } else if (this.gatt == null) {
            callback.invoke("BluetoothGatt is null", null);
            completedCommand();
        } else {
            this.readRSSICallbacks.addLast(callback);
            if (!this.gatt.readRemoteRssi()) {
                Iterator it2 = this.readRSSICallbacks.iterator();
                while (it2.hasNext()) {
                    ((Callback) it2.next()).invoke("Read RSSI failed", null);
                }
                this.readRSSICallbacks.clear();
                completedCommand();
            }
        }
    }

    public void refreshCache(Callback callback) {
        enqueue(new Runnable(callback) {
            public final /* synthetic */ Callback f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Peripheral.this.lambda$refreshCache$14$Peripheral(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$refreshCache$14$Peripheral(Callback callback) {
        try {
            Method method = this.gatt.getClass().getMethod("refresh", new Class[0]);
            if (method != null) {
                callback.invoke(null, Boolean.valueOf(((Boolean) method.invoke(this.gatt, new Object[0])).booleanValue()));
            } else {
                callback.invoke("Could not refresh cache for device.");
            }
        } catch (Exception e) {
            Log.e(ReactConstants.TAG, "An exception occured while refreshing device");
            callback.invoke(e.getMessage());
        } catch (Throwable th) {
            completedCommand();
            throw th;
        }
        completedCommand();
    }

    public void retrieveServices(Callback callback) {
        enqueue(new Runnable(callback) {
            public final /* synthetic */ Callback f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Peripheral.this.lambda$retrieveServices$15$Peripheral(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$retrieveServices$15$Peripheral(Callback callback) {
        if (!isConnected()) {
            callback.invoke("Device is not connected", null);
            completedCommand();
        } else if (this.gatt == null) {
            callback.invoke("BluetoothGatt is null", null);
            completedCommand();
        } else {
            this.retrieveServicesCallbacks.addLast(callback);
            this.gatt.discoverServices();
        }
    }

    private BluetoothGattCharacteristic findReadableCharacteristic(BluetoothGattService bluetoothGattService, UUID uuid) {
        if (bluetoothGattService == null) {
            return null;
        }
        for (BluetoothGattCharacteristic next : bluetoothGattService.getCharacteristics()) {
            if ((next.getProperties() & 2) != 0 && uuid.equals(next.getUuid())) {
                return next;
            }
        }
        return bluetoothGattService.getCharacteristic(uuid);
    }

    public boolean doWrite(final BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, final Callback callback) {
        final byte[] copyOf = copyOf(bArr);
        return enqueue(new Runnable() {
            public void run() {
                bluetoothGattCharacteristic.setValue(copyOf);
                if (bluetoothGattCharacteristic.getWriteType() == 2 && callback != null) {
                    Peripheral.this.writeCallbacks.addLast(callback);
                }
                if (!Peripheral.this.gatt.writeCharacteristic(bluetoothGattCharacteristic)) {
                    Iterator it2 = Peripheral.this.writeCallbacks.iterator();
                    while (it2.hasNext()) {
                        Callback callback = (Callback) it2.next();
                        callback.invoke("Write failed", callback);
                    }
                    Peripheral.this.writeCallbacks.clear();
                    Peripheral.this.completedCommand();
                }
            }
        });
    }

    public void write(UUID uuid, UUID uuid2, byte[] bArr, Integer num, Integer num2, Callback callback, int i) {
        enqueue(new Runnable(callback, uuid, uuid2, i, bArr, num, num2) {
            public final /* synthetic */ Callback f$1;
            public final /* synthetic */ UUID f$2;
            public final /* synthetic */ UUID f$3;
            public final /* synthetic */ int f$4;
            public final /* synthetic */ byte[] f$5;
            public final /* synthetic */ Integer f$6;
            public final /* synthetic */ Integer f$7;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
                this.f$7 = r8;
            }

            public final void run() {
                Peripheral.this.lambda$write$16$Peripheral(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
            }
        });
    }

    public /* synthetic */ void lambda$write$16$Peripheral(Callback callback, UUID uuid, UUID uuid2, int i, byte[] bArr, Integer num, Integer num2) {
        BluetoothGatt bluetoothGatt;
        boolean z;
        Callback callback2 = callback;
        UUID uuid3 = uuid2;
        int i2 = i;
        byte[] bArr2 = bArr;
        byte[] bArr3 = null;
        if (!isConnected() || (bluetoothGatt = this.gatt) == null) {
            callback2.invoke("Device is not connected", null);
            completedCommand();
            return;
        }
        BluetoothGattCharacteristic findWritableCharacteristic = findWritableCharacteristic(bluetoothGatt.getService(uuid), uuid3, i2);
        if (findWritableCharacteristic == null) {
            callback2.invoke("Characteristic " + uuid3 + " not found.");
            completedCommand();
            return;
        }
        findWritableCharacteristic.setWriteType(i2);
        if (bArr2.length > num.intValue()) {
            int length = bArr2.length;
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < length && length - i3 > num.intValue()) {
                if (i3 == 0) {
                    bArr3 = Arrays.copyOfRange(bArr2, i3, num.intValue() + i3);
                } else {
                    arrayList.add(Arrays.copyOfRange(bArr2, i3, num.intValue() + i3));
                }
                i3 += num.intValue();
            }
            if (i3 < length) {
                arrayList.add(Arrays.copyOfRange(bArr2, i3, bArr2.length));
            }
            if (2 == i2) {
                this.writeQueue.addAll(arrayList);
                if (!doWrite(findWritableCharacteristic, bArr3, callback2)) {
                    this.writeQueue.clear();
                    callback2.invoke("Write failed");
                }
            } else {
                try {
                    if (!doWrite(findWritableCharacteristic, bArr3, callback2)) {
                        callback2.invoke("Write failed");
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Thread.sleep((long) num2.intValue());
                        Iterator it2 = arrayList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            } else if (!doWrite(findWritableCharacteristic, (byte[]) it2.next(), callback2)) {
                                callback2.invoke("Write failed");
                                z = true;
                                break;
                            } else {
                                Thread.sleep((long) num2.intValue());
                            }
                        }
                        if (!z) {
                            callback2.invoke(new Object[0]);
                        }
                    }
                } catch (InterruptedException unused) {
                    callback2.invoke("Error during writing");
                }
            }
        } else if (!doWrite(findWritableCharacteristic, bArr2, callback2)) {
            callback2.invoke("Write failed");
        } else if (1 == i2) {
            callback2.invoke(new Object[0]);
        }
        completedCommand();
    }

    public void requestConnectionPriority(int i, Callback callback) {
        enqueue(new Runnable(i, callback) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ Callback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$requestConnectionPriority$17$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$requestConnectionPriority$17$Peripheral(int i, Callback callback) {
        if (this.gatt == null) {
            callback.invoke("BluetoothGatt is null", null);
        } else if (Build.VERSION.SDK_INT >= 21) {
            callback.invoke(null, Boolean.valueOf(this.gatt.requestConnectionPriority(i)));
        } else {
            callback.invoke("Requesting connection priority requires at least API level 21", null);
        }
        completedCommand();
    }

    public void requestMTU(int i, Callback callback) {
        enqueue(new Runnable(callback, i) {
            public final /* synthetic */ Callback f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$requestMTU$18$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$requestMTU$18$Peripheral(Callback callback, int i) {
        if (!isConnected()) {
            callback.invoke("Device is not connected", null);
            completedCommand();
        } else if (this.gatt == null) {
            callback.invoke("BluetoothGatt is null", null);
            completedCommand();
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.requestMTUCallbacks.addLast(callback);
            if (!this.gatt.requestMtu(i)) {
                Iterator it2 = this.requestMTUCallbacks.iterator();
                while (it2.hasNext()) {
                    ((Callback) it2.next()).invoke("Request MTU failed", null);
                }
                this.requestMTUCallbacks.clear();
                completedCommand();
            }
        } else {
            callback.invoke("Requesting MTU requires at least API level 21", null);
            completedCommand();
        }
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onMtuChanged(bluetoothGatt, i, i2);
        this.mainHandler.post(new Runnable(i2, i) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Peripheral.this.lambda$onMtuChanged$19$Peripheral(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onMtuChanged$19$Peripheral(int i, int i2) {
        if (!this.requestMTUCallbacks.isEmpty()) {
            if (i == 0) {
                Iterator it2 = this.requestMTUCallbacks.iterator();
                while (it2.hasNext()) {
                    ((Callback) it2.next()).invoke(null, Integer.valueOf(i2));
                }
            } else {
                Iterator it3 = this.requestMTUCallbacks.iterator();
                while (it3.hasNext()) {
                    ((Callback) it3.next()).invoke("Error requesting MTU status = " + i, null);
                }
            }
            this.requestMTUCallbacks.clear();
        }
        completedCommand();
    }

    private BluetoothGattCharacteristic findWritableCharacteristic(BluetoothGattService bluetoothGattService, UUID uuid, int i) {
        int i2 = 8;
        if (i == 1) {
            i2 = 4;
        }
        try {
            for (BluetoothGattCharacteristic next : bluetoothGattService.getCharacteristics()) {
                if ((next.getProperties() & i2) != 0 && uuid.equals(next.getUuid())) {
                    return next;
                }
            }
            return bluetoothGattService.getCharacteristic(uuid);
        } catch (Exception e) {
            Log.e(BleManager.LOG_TAG, "Error on findWritableCharacteristic", e);
            return null;
        }
    }

    private String generateHashKey(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return generateHashKey(bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic);
    }

    private String generateHashKey(UUID uuid, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return uuid + "|" + bluetoothGattCharacteristic.getUuid() + "|" + bluetoothGattCharacteristic.getInstanceId();
    }
}
