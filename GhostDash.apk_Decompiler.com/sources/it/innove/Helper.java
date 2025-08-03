package it.innove;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class Helper {
    public static WritableMap decodeProperties(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        WritableMap createMap = Arguments.createMap();
        int properties = bluetoothGattCharacteristic.getProperties();
        if ((properties & 1) != 0) {
            createMap.putString("Broadcast", "Broadcast");
        }
        if ((properties & 2) != 0) {
            createMap.putString("Read", "Read");
        }
        if ((properties & 4) != 0) {
            createMap.putString("WriteWithoutResponse", "WriteWithoutResponse");
        }
        if ((properties & 8) != 0) {
            createMap.putString("Write", "Write");
        }
        if ((properties & 16) != 0) {
            createMap.putString("Notify", "Notify");
        }
        if ((properties & 32) != 0) {
            createMap.putString("Indicate", "Indicate");
        }
        if ((properties & 64) != 0) {
            createMap.putString("AuthenticateSignedWrites", "AuthenticateSignedWrites");
        }
        if ((properties & 128) != 0) {
            createMap.putString("ExtendedProperties", "ExtendedProperties");
        }
        return createMap;
    }

    public static WritableMap decodePermissions(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        WritableMap createMap = Arguments.createMap();
        int permissions = bluetoothGattCharacteristic.getPermissions();
        if ((permissions & 1) != 0) {
            createMap.putString("Read", "Read");
        }
        if ((permissions & 16) != 0) {
            createMap.putString("Write", "Write");
        }
        if ((permissions & 2) != 0) {
            createMap.putString("ReadEncrypted", "ReadEncrypted");
        }
        if ((permissions & 32) != 0) {
            createMap.putString("WriteEncrypted", "WriteEncrypted");
        }
        if ((permissions & 4) != 0) {
            createMap.putString("ReadEncryptedMITM", "ReadEncryptedMITM");
        }
        if ((permissions & 64) != 0) {
            createMap.putString("WriteEncryptedMITM", "WriteEncryptedMITM");
        }
        if ((permissions & 128) != 0) {
            createMap.putString("WriteSigned", "WriteSigned");
        }
        if ((permissions & 256) != 0) {
            createMap.putString("WriteSignedMITM", "WriteSignedMITM");
        }
        return createMap;
    }

    public static WritableMap decodePermissions(BluetoothGattDescriptor bluetoothGattDescriptor) {
        WritableMap createMap = Arguments.createMap();
        int permissions = bluetoothGattDescriptor.getPermissions();
        if ((permissions & 1) != 0) {
            createMap.putString("Read", "Read");
        }
        if ((permissions & 16) != 0) {
            createMap.putString("Write", "Write");
        }
        if ((permissions & 2) != 0) {
            createMap.putString("ReadEncrypted", "ReadEncrypted");
        }
        if ((permissions & 32) != 0) {
            createMap.putString("WriteEncrypted", "WriteEncrypted");
        }
        if ((permissions & 4) != 0) {
            createMap.putString("ReadEncryptedMITM", "ReadEncryptedMITM");
        }
        if ((permissions & 64) != 0) {
            createMap.putString("WriteEncryptedMITM", "WriteEncryptedMITM");
        }
        if ((permissions & 128) != 0) {
            createMap.putString("WriteSigned", "WriteSigned");
        }
        if ((permissions & 256) != 0) {
            createMap.putString("WriteSignedMITM", "WriteSignedMITM");
        }
        return createMap;
    }
}
