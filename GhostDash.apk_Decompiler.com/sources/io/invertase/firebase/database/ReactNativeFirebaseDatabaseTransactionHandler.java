package io.invertase.firebase.database;

import com.arthenica.ffmpegkit.reactnative.FFmpegKitReactNativeModule;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.MutableData;
import com.tonyodev.fetch2core.FetchErrorStrings;
import io.invertase.firebase.common.RCTConvertFirebase;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;

public class ReactNativeFirebaseDatabaseTransactionHandler {
    boolean abort = false;
    private String appName;
    private final Condition condition;
    private Map<String, Object> data;
    private String dbURL;
    boolean interrupted;
    private final ReentrantLock lock;
    private boolean signalled;
    boolean timeout = false;
    private int transactionId;
    public Object value;

    ReactNativeFirebaseDatabaseTransactionHandler(int i, String str, String str2) {
        this.appName = str;
        this.dbURL = str2;
        this.transactionId = i;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    /* access modifiers changed from: package-private */
    public void signalUpdateReceived(ReadableMap readableMap) {
        Map<String, Object> hashMap = RCTConvertFirebase.toHashMap(readableMap);
        this.lock.lock();
        this.value = hashMap.get("value");
        this.abort = ((Boolean) hashMap.get("abort")).booleanValue();
        try {
            if (!this.signalled) {
                this.signalled = true;
                this.data = hashMap;
                this.condition.signalAll();
                this.lock.unlock();
                return;
            }
            throw new IllegalStateException("This transactionUpdateHandler has already been signalled.");
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void await() throws InterruptedException {
        boolean z;
        this.lock.lock();
        this.signalled = false;
        long currentTimeMillis = System.currentTimeMillis() + 5000;
        while (!this.timeout && !this.condition.await(250, TimeUnit.MILLISECONDS) && !(z = this.signalled)) {
            try {
                if (!z && System.currentTimeMillis() > currentTimeMillis) {
                    this.timeout = true;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getUpdates() {
        return this.data;
    }

    /* access modifiers changed from: package-private */
    public WritableMap createUpdateMap(MutableData mutableData) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "update");
        if (!mutableData.hasChildren()) {
            RCTConvertFirebase.mapPutValue("value", mutableData.getValue(), createMap);
        } else {
            Object castValue = ReactNativeFirebaseDatabaseCommon.castValue(mutableData);
            if (castValue instanceof WritableNativeArray) {
                createMap.putArray("value", (WritableArray) castValue);
            } else {
                createMap.putMap("value", (WritableMap) castValue);
            }
        }
        return createMap;
    }

    /* access modifiers changed from: package-private */
    public WritableMap createResultMap(@Nullable DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot) {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean(FetchErrorStrings.CONNECTION_TIMEOUT, this.timeout);
        createMap.putBoolean("committed", z);
        createMap.putBoolean("interrupted", this.interrupted);
        if (databaseError != null || this.timeout || this.interrupted) {
            createMap.putString("type", ReactVideoView.EVENT_PROP_ERROR);
            if (databaseError != null) {
                UniversalDatabaseException universalDatabaseException = new UniversalDatabaseException(databaseError.getCode(), databaseError.getMessage(), databaseError.toException());
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString("code", universalDatabaseException.getCode());
                createMap2.putString(FFmpegKitReactNativeModule.KEY_LOG_MESSAGE, universalDatabaseException.getMessage());
                createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, createMap2);
            }
            if (databaseError == null && this.timeout) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putString("code", "database/internal-timeout");
                createMap3.putString(FFmpegKitReactNativeModule.KEY_LOG_MESSAGE, "A timeout occurred whilst waiting for React Native JavaScript thread to send transaction updates.");
                createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, createMap3);
            }
        } else {
            createMap.putString("type", "complete");
            createMap.putMap("snapshot", ReactNativeFirebaseDatabaseCommon.snapshotToMap(dataSnapshot));
        }
        return createMap;
    }
}
