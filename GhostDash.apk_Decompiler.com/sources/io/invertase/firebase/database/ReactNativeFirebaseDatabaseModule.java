package io.invertase.firebase.database;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.UniversalFirebasePreferences;

public class ReactNativeFirebaseDatabaseModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Database";
    private final UniversalFirebaseDatabaseModule module;

    ReactNativeFirebaseDatabaseModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseDatabaseModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void goOnline(String str, String str2, Promise promise) {
        this.module.goOnline(str, str2).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseModule.lambda$goOnline$0(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$goOnline$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void goOffline(String str, String str2, Promise promise) {
        this.module.goOffline(str, str2).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseModule.lambda$goOffline$1(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$goOffline$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setPersistenceEnabled(String str, String str2, boolean z) {
        UniversalFirebasePreferences.getSharedInstance().setBooleanValue(UniversalDatabaseStatics.DATABASE_PERSISTENCE_ENABLED, z);
    }

    @ReactMethod
    public void setLoggingEnabled(String str, String str2, boolean z) {
        UniversalFirebasePreferences.getSharedInstance().setBooleanValue(UniversalDatabaseStatics.DATABASE_LOGGING_ENABLED, z);
    }

    @ReactMethod
    public void setPersistenceCacheSizeBytes(String str, String str2, double d) {
        UniversalFirebasePreferences.getSharedInstance().setLongValue(UniversalDatabaseStatics.DATABASE_PERSISTENCE_CACHE_SIZE, (long) d);
    }

    @ReactMethod
    public void useEmulator(String str, String str2, String str3, int i) {
        UniversalFirebaseDatabaseCommon.addEmulatorConfig(str, str2, str3, i);
    }
}
