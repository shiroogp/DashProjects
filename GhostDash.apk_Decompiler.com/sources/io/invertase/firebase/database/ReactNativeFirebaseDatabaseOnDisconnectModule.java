package io.invertase.firebase.database;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.Map;

public class ReactNativeFirebaseDatabaseOnDisconnectModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "DatabaseOnDisconnect";
    private final UniversalFirebaseDatabaseOnDisconnectModule module;

    ReactNativeFirebaseDatabaseOnDisconnectModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseDatabaseOnDisconnectModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void onDisconnectCancel(String str, String str2, String str3, Promise promise) {
        this.module.onDisconnectCancel(str, str2, str3).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseOnDisconnectModule.lambda$onDisconnectCancel$0(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$onDisconnectCancel$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void onDisconnectRemove(String str, String str2, String str3, Promise promise) {
        this.module.onDisconnectRemove(str, str2, str3).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseOnDisconnectModule.lambda$onDisconnectRemove$1(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$onDisconnectRemove$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void onDisconnectSet(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        this.module.onDisconnectSet(str, str2, str3, RCTConvertFirebase.toHashMap(readableMap).get("value")).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseOnDisconnectModule.lambda$onDisconnectSet$2(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$onDisconnectSet$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void onDisconnectSetWithPriority(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        this.module.onDisconnectSetWithPriority(str, str2, str3, RCTConvertFirebase.toHashMap(readableMap).get("value"), RCTConvertFirebase.toHashMap(readableMap).get("priority")).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseOnDisconnectModule.lambda$onDisconnectSetWithPriority$3(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$onDisconnectSetWithPriority$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void onDisconnectUpdate(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        this.module.onDisconnectUpdate(str, str2, str3, (Map) RCTConvertFirebase.toHashMap(readableMap).get("values")).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseOnDisconnectModule.lambda$onDisconnectUpdate$4(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$onDisconnectUpdate$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }
}
