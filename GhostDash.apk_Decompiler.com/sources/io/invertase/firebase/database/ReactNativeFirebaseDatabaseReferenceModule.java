package io.invertase.firebase.database;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class ReactNativeFirebaseDatabaseReferenceModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "DatabaseReference";
    private final UniversalFirebaseDatabaseReferenceModule module;

    ReactNativeFirebaseDatabaseReferenceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseDatabaseReferenceModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void set(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        Tasks.call(getTransactionalExecutor(), new Callable() {
            public final Object call() {
                return RCTConvertFirebase.toHashMap(ReadableMap.this).get("value");
            }
        }).onSuccessTask(new SuccessContinuation(str, str2, str3) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Task then(Object obj) {
                return ReactNativeFirebaseDatabaseReferenceModule.this.lambda$set$1$ReactNativeFirebaseDatabaseReferenceModule(this.f$1, this.f$2, this.f$3, obj);
            }
        }).addOnCompleteListener((Executor) getTransactionalExecutor(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseReferenceModule.lambda$set$2(Promise.this, task);
            }
        });
    }

    public /* synthetic */ Task lambda$set$1$ReactNativeFirebaseDatabaseReferenceModule(String str, String str2, String str3, Object obj) throws Exception {
        return this.module.set(str, str2, str3, obj);
    }

    static /* synthetic */ void lambda$set$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseDatabaseCommon.rejectPromiseDatabaseException(promise, task.getException());
        }
    }

    @ReactMethod
    public void update(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        Tasks.call(getTransactionalExecutor(), new Callable() {
            public final Object call() {
                return RCTConvertFirebase.toHashMap(ReadableMap.this).get("values");
            }
        }).onSuccessTask(new SuccessContinuation(str, str2, str3) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Task then(Object obj) {
                return ReactNativeFirebaseDatabaseReferenceModule.this.lambda$update$4$ReactNativeFirebaseDatabaseReferenceModule(this.f$1, this.f$2, this.f$3, obj);
            }
        }).addOnCompleteListener((Executor) getTransactionalExecutor(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseReferenceModule.lambda$update$5(Promise.this, task);
            }
        });
    }

    public /* synthetic */ Task lambda$update$4$ReactNativeFirebaseDatabaseReferenceModule(String str, String str2, String str3, Object obj) throws Exception {
        return this.module.update(str, str2, str3, (Map) obj);
    }

    static /* synthetic */ void lambda$update$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseDatabaseCommon.rejectPromiseDatabaseException(promise, task.getException());
        }
    }

    @ReactMethod
    public void setWithPriority(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        Tasks.call(getTransactionalExecutor(), new Callable() {
            public final Object call() {
                return RCTConvertFirebase.toHashMap(ReadableMap.this);
            }
        }).onSuccessTask(new SuccessContinuation(str, str2, str3) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Task then(Object obj) {
                return ReactNativeFirebaseDatabaseReferenceModule.this.lambda$setWithPriority$7$ReactNativeFirebaseDatabaseReferenceModule(this.f$1, this.f$2, this.f$3, (Map) obj);
            }
        }).addOnCompleteListener((Executor) getTransactionalExecutor(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseReferenceModule.lambda$setWithPriority$8(Promise.this, task);
            }
        });
    }

    public /* synthetic */ Task lambda$setWithPriority$7$ReactNativeFirebaseDatabaseReferenceModule(String str, String str2, String str3, Map map) throws Exception {
        return this.module.setWithPriority(str, str2, str3, map.get("value"), map.get("priority"));
    }

    static /* synthetic */ void lambda$setWithPriority$8(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseDatabaseCommon.rejectPromiseDatabaseException(promise, task.getException());
        }
    }

    @ReactMethod
    public void remove(String str, String str2, String str3, Promise promise) {
        this.module.remove(str, str2, str3).addOnCompleteListener((Executor) getTransactionalExecutor(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseReferenceModule.lambda$remove$9(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$remove$9(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseDatabaseCommon.rejectPromiseDatabaseException(promise, task.getException());
        }
    }

    @ReactMethod
    public void setPriority(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        this.module.setPriority(str, str2, str3, RCTConvertFirebase.toHashMap(readableMap).get("priority")).addOnCompleteListener((Executor) getTransactionalExecutor(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseReferenceModule.lambda$setPriority$10(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$setPriority$10(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseDatabaseCommon.rejectPromiseDatabaseException(promise, task.getException());
        }
    }
}
