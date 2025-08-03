package io.invertase.firebase.analytics;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

public class ReactNativeFirebaseAnalyticsModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Analytics";
    private final UniversalFirebaseAnalyticsModule module;

    ReactNativeFirebaseAnalyticsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseAnalyticsModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void logEvent(String str, @Nullable ReadableMap readableMap, Promise promise) {
        this.module.logEvent(str, toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$logEvent$0(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$logEvent$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setAnalyticsCollectionEnabled(Boolean bool, Promise promise) {
        this.module.setAnalyticsCollectionEnabled(bool).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setAnalyticsCollectionEnabled$1(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$setAnalyticsCollectionEnabled$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setSessionTimeoutDuration(double d, Promise promise) {
        this.module.setSessionTimeoutDuration((long) d).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setSessionTimeoutDuration$2(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$setSessionTimeoutDuration$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void getAppInstanceId(Promise promise) {
        this.module.getAppInstanceId().addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$getAppInstanceId$3(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$getAppInstanceId$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserId(String str, Promise promise) {
        this.module.setUserId(str).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserId$4(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserId$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserProperty(String str, String str2, Promise promise) {
        this.module.setUserProperty(str, str2).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserProperty$5(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserProperty$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setUserProperties(ReadableMap readableMap, Promise promise) {
        this.module.setUserProperties(Arguments.toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setUserProperties$6(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserProperties$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void resetAnalyticsData(Promise promise) {
        this.module.resetAnalyticsData().addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$resetAnalyticsData$7(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$resetAnalyticsData$7(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setDefaultEventParameters(@Nullable ReadableMap readableMap, Promise promise) {
        this.module.setDefaultEventParameters(toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseAnalyticsModule.lambda$setDefaultEventParameters$8(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$setDefaultEventParameters$8(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    private Bundle toBundle(ReadableMap readableMap) {
        Bundle bundle = Arguments.toBundle(readableMap);
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) bundle.getSerializable(FirebaseAnalytics.Param.ITEMS);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof Bundle) {
                Bundle bundle2 = (Bundle) next;
                if (bundle2.containsKey(FirebaseAnalytics.Param.QUANTITY)) {
                    bundle2.putInt(FirebaseAnalytics.Param.QUANTITY, (int) bundle2.getDouble(FirebaseAnalytics.Param.QUANTITY));
                }
            }
        }
        if (bundle.containsKey(FirebaseAnalytics.Param.EXTEND_SESSION)) {
            bundle.putLong(FirebaseAnalytics.Param.EXTEND_SESSION, (long) bundle.getDouble(FirebaseAnalytics.Param.EXTEND_SESSION));
        }
        return bundle;
    }
}
