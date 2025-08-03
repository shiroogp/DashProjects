package io.invertase.firebase.database;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.MutableData;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.SharedUtils;
import javax.annotation.Nullable;

public class ReactNativeFirebaseDatabaseCommon {
    private static final String TAG = "DatabaseCommon";

    public static void rejectPromiseDatabaseException(Promise promise, @Nullable Exception exc) {
        UniversalDatabaseException universalDatabaseException = (UniversalDatabaseException) exc;
        ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, universalDatabaseException.getCode(), universalDatabaseException.getMessage());
    }

    public static WritableMap snapshotWithPreviousChildToMap(DataSnapshot dataSnapshot, @Nullable String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("snapshot", snapshotToMap(dataSnapshot));
        createMap.putString("previousChildName", str);
        return createMap;
    }

    public static WritableMap snapshotToMap(DataSnapshot dataSnapshot) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("key", dataSnapshot.getKey());
        createMap.putBoolean("exists", dataSnapshot.exists());
        createMap.putBoolean("hasChildren", dataSnapshot.hasChildren());
        createMap.putDouble("childrenCount", (double) dataSnapshot.getChildrenCount());
        createMap.putArray("childKeys", getChildKeys(dataSnapshot));
        SharedUtils.mapPutValue("priority", dataSnapshot.getPriority(), createMap);
        if (!dataSnapshot.hasChildren()) {
            SharedUtils.mapPutValue("value", dataSnapshot.getValue(), createMap);
        } else {
            Object castValue = castValue(dataSnapshot);
            if (castValue instanceof WritableNativeArray) {
                createMap.putArray("value", (WritableArray) castValue);
            } else {
                createMap.putMap("value", (WritableMap) castValue);
            }
        }
        return createMap;
    }

    public static <Any> Any castValue(DataSnapshot dataSnapshot) {
        if (dataSnapshot.hasChildren()) {
            if (isArray(dataSnapshot)) {
                return buildArray(dataSnapshot);
            }
            return buildMap(dataSnapshot);
        } else if (dataSnapshot.getValue() == null) {
            return null;
        } else {
            String name = dataSnapshot.getValue().getClass().getName();
            name.hashCode();
            char c = 65535;
            switch (name.hashCode()) {
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        c = 0;
                        break;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        c = 1;
                        break;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1195259493:
                    if (name.equals("java.lang.String")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return dataSnapshot.getValue();
                default:
                    Log.w(TAG, "Invalid type: " + name);
                    return null;
            }
        }
    }

    public static <Any> Any castValue(MutableData mutableData) {
        if (mutableData.hasChildren()) {
            if (isArray(mutableData)) {
                return buildArray(mutableData);
            }
            return buildMap(mutableData);
        } else if (mutableData.getValue() == null) {
            return null;
        } else {
            String name = mutableData.getValue().getClass().getName();
            name.hashCode();
            char c = 65535;
            switch (name.hashCode()) {
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        c = 0;
                        break;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        c = 1;
                        break;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1195259493:
                    if (name.equals("java.lang.String")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return mutableData.getValue();
                default:
                    Log.w(TAG, "Invalid type: " + name);
                    return null;
            }
        }
    }

    private static boolean isArray(DataSnapshot dataSnapshot) {
        long childrenCount = (dataSnapshot.getChildrenCount() * 2) - 1;
        long j = -1;
        for (DataSnapshot key : dataSnapshot.getChildren()) {
            try {
                long parseLong = Long.parseLong(key.getKey());
                if (parseLong > j && parseLong <= childrenCount) {
                    j = parseLong;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    private static boolean isArray(MutableData mutableData) {
        long childrenCount = (mutableData.getChildrenCount() * 2) - 1;
        long j = -1;
        for (MutableData key : mutableData.getChildren()) {
            try {
                long parseLong = Long.parseLong(key.getKey());
                if (parseLong > j && parseLong <= childrenCount) {
                    j++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    private static <Any> WritableArray buildArray(DataSnapshot dataSnapshot) {
        WritableArray createArray = Arguments.createArray();
        long j = 0;
        for (DataSnapshot next : dataSnapshot.getChildren()) {
            long parseLong = Long.parseLong(next.getKey());
            if (parseLong > j) {
                while (j < parseLong) {
                    createArray.pushNull();
                    j++;
                }
                j = parseLong;
            }
            Object castValue = castValue(next);
            String name = castValue.getClass().getName();
            name.hashCode();
            char c = 65535;
            switch (name.hashCode()) {
                case -1658217206:
                    if (name.equals("com.facebook.react.bridge.WritableNativeMap")) {
                        c = 0;
                        break;
                    }
                    break;
                case -124438905:
                    if (name.equals("com.facebook.react.bridge.WritableNativeArray")) {
                        c = 1;
                        break;
                    }
                    break;
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        c = 2;
                        break;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        c = 3;
                        break;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1195259493:
                    if (name.equals("java.lang.String")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    createArray.pushMap((WritableMap) castValue);
                    break;
                case 1:
                    createArray.pushArray((WritableArray) castValue);
                    break;
                case 2:
                    createArray.pushBoolean(((Boolean) castValue).booleanValue());
                    break;
                case 3:
                    createArray.pushDouble((double) ((Long) castValue).longValue());
                    break;
                case 4:
                    createArray.pushDouble(((Double) castValue).doubleValue());
                    break;
                case 5:
                    createArray.pushString((String) castValue);
                    break;
                default:
                    Log.w(TAG, "Invalid type: " + castValue.getClass().getName());
                    break;
            }
            j++;
        }
        return createArray;
    }

    private static <Any> WritableArray buildArray(MutableData mutableData) {
        WritableArray createArray = Arguments.createArray();
        long j = 0;
        for (MutableData next : mutableData.getChildren()) {
            long parseLong = Long.parseLong(next.getKey());
            if (parseLong > j) {
                while (j < parseLong) {
                    createArray.pushNull();
                    j++;
                }
                j = parseLong;
            }
            Object castValue = castValue(next);
            String name = castValue.getClass().getName();
            name.hashCode();
            char c = 65535;
            switch (name.hashCode()) {
                case -1658217206:
                    if (name.equals("com.facebook.react.bridge.WritableNativeMap")) {
                        c = 0;
                        break;
                    }
                    break;
                case -124438905:
                    if (name.equals("com.facebook.react.bridge.WritableNativeArray")) {
                        c = 1;
                        break;
                    }
                    break;
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        c = 2;
                        break;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        c = 3;
                        break;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1195259493:
                    if (name.equals("java.lang.String")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    createArray.pushMap((WritableMap) castValue);
                    break;
                case 1:
                    createArray.pushArray((WritableArray) castValue);
                    break;
                case 2:
                    createArray.pushBoolean(((Boolean) castValue).booleanValue());
                    break;
                case 3:
                    createArray.pushDouble((double) ((Long) castValue).longValue());
                    break;
                case 4:
                    createArray.pushDouble(((Double) castValue).doubleValue());
                    break;
                case 5:
                    createArray.pushString((String) castValue);
                    break;
                default:
                    Log.w(TAG, "Invalid type: " + castValue.getClass().getName());
                    break;
            }
            j++;
        }
        return createArray;
    }

    private static <Any> WritableMap buildMap(DataSnapshot dataSnapshot) {
        WritableMap createMap = Arguments.createMap();
        for (DataSnapshot next : dataSnapshot.getChildren()) {
            Object castValue = castValue(next);
            String name = castValue.getClass().getName();
            name.hashCode();
            char c = 65535;
            switch (name.hashCode()) {
                case -1658217206:
                    if (name.equals("com.facebook.react.bridge.WritableNativeMap")) {
                        c = 0;
                        break;
                    }
                    break;
                case -124438905:
                    if (name.equals("com.facebook.react.bridge.WritableNativeArray")) {
                        c = 1;
                        break;
                    }
                    break;
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        c = 2;
                        break;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        c = 3;
                        break;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1195259493:
                    if (name.equals("java.lang.String")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    createMap.putMap(next.getKey(), (WritableMap) castValue);
                    break;
                case 1:
                    createMap.putArray(next.getKey(), (WritableArray) castValue);
                    break;
                case 2:
                    createMap.putBoolean(next.getKey(), ((Boolean) castValue).booleanValue());
                    break;
                case 3:
                    createMap.putDouble(next.getKey(), (double) ((Long) castValue).longValue());
                    break;
                case 4:
                    createMap.putDouble(next.getKey(), ((Double) castValue).doubleValue());
                    break;
                case 5:
                    createMap.putString(next.getKey(), (String) castValue);
                    break;
                default:
                    Log.w(TAG, "Invalid type: " + castValue.getClass().getName());
                    break;
            }
        }
        return createMap;
    }

    private static <Any> WritableMap buildMap(MutableData mutableData) {
        WritableMap createMap = Arguments.createMap();
        for (MutableData next : mutableData.getChildren()) {
            Object castValue = castValue(next);
            String name = castValue.getClass().getName();
            name.hashCode();
            char c = 65535;
            switch (name.hashCode()) {
                case -1658217206:
                    if (name.equals("com.facebook.react.bridge.WritableNativeMap")) {
                        c = 0;
                        break;
                    }
                    break;
                case -124438905:
                    if (name.equals("com.facebook.react.bridge.WritableNativeArray")) {
                        c = 1;
                        break;
                    }
                    break;
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        c = 2;
                        break;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        c = 3;
                        break;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1195259493:
                    if (name.equals("java.lang.String")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    createMap.putMap(next.getKey(), (WritableMap) castValue);
                    break;
                case 1:
                    createMap.putArray(next.getKey(), (WritableArray) castValue);
                    break;
                case 2:
                    createMap.putBoolean(next.getKey(), ((Boolean) castValue).booleanValue());
                    break;
                case 3:
                    createMap.putDouble(next.getKey(), (double) ((Long) castValue).longValue());
                    break;
                case 4:
                    createMap.putDouble(next.getKey(), ((Double) castValue).doubleValue());
                    break;
                case 5:
                    createMap.putString(next.getKey(), (String) castValue);
                    break;
                default:
                    Log.w(TAG, "Invalid type: " + castValue.getClass().getName());
                    break;
            }
        }
        return createMap;
    }

    public static WritableArray getChildKeys(DataSnapshot dataSnapshot) {
        WritableArray createArray = Arguments.createArray();
        if (dataSnapshot.hasChildren()) {
            for (DataSnapshot key : dataSnapshot.getChildren()) {
                createArray.pushString(key.getKey());
            }
        }
        return createArray;
    }
}
