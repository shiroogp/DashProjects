package io.invertase.firebase.database;

import com.RNFetchBlob.RNFetchBlobConst;
import com.arthenica.ffmpegkit.reactnative.FFmpegKitReactNativeModule;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.database.ReactNativeFirebaseDatabaseQueryModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ReactNativeFirebaseDatabaseQueryModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "DatabaseQuery";
    private HashMap<String, ReactNativeFirebaseDatabaseQuery> queryMap = new HashMap<>();

    ReactNativeFirebaseDatabaseQueryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        Iterator<Map.Entry<String, ReactNativeFirebaseDatabaseQuery>> it2 = this.queryMap.entrySet().iterator();
        while (it2.hasNext()) {
            ((ReactNativeFirebaseDatabaseQuery) it2.next().getValue()).removeAllEventListeners();
            it2.remove();
        }
    }

    private ReactNativeFirebaseDatabaseQuery getDatabaseQueryInstance(DatabaseReference databaseReference, ReadableArray readableArray) {
        return new ReactNativeFirebaseDatabaseQuery(databaseReference, readableArray);
    }

    private ReactNativeFirebaseDatabaseQuery getDatabaseQueryInstance(String str, DatabaseReference databaseReference, ReadableArray readableArray) {
        ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery = this.queryMap.get(str);
        if (reactNativeFirebaseDatabaseQuery != null) {
            return reactNativeFirebaseDatabaseQuery;
        }
        ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery2 = new ReactNativeFirebaseDatabaseQuery(databaseReference, readableArray);
        this.queryMap.put(str, reactNativeFirebaseDatabaseQuery2);
        return reactNativeFirebaseDatabaseQuery2;
    }

    private void addOnceValueEventListener(ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery, final Promise promise) {
        reactNativeFirebaseDatabaseQuery.addSingleValueEventListener(new ValueEventListener() {
            public void onDataChange(@Nonnull DataSnapshot dataSnapshot) {
                Tasks.call(ReactNativeFirebaseDatabaseQueryModule.this.getExecutor(), new Callable() {
                    public final Object call() {
                        return ReactNativeFirebaseDatabaseCommon.snapshotToMap(DataSnapshot.this);
                    }
                }).addOnCompleteListener(new OnCompleteListener() {
                    public final void onComplete(Task task) {
                        ReactNativeFirebaseDatabaseQueryModule.AnonymousClass1.lambda$onDataChange$1(Promise.this, task);
                    }
                });
            }

            static /* synthetic */ void lambda$onDataChange$1(Promise promise, Task task) {
                if (task.isSuccessful()) {
                    promise.resolve(task.getResult());
                } else {
                    ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
                }
            }

            public void onCancelled(@Nonnull DatabaseError databaseError) {
                ReactNativeFirebaseDatabaseCommon.rejectPromiseDatabaseException(promise, new UniversalDatabaseException(databaseError.getCode(), databaseError.getMessage(), databaseError.toException()));
            }
        });
    }

    private void addChildOnceEventListener(final String str, final ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery, final Promise promise) {
        reactNativeFirebaseDatabaseQuery.addSingleChildEventListener(new ChildEventListener() {
            public void onChildAdded(@Nonnull DataSnapshot dataSnapshot, String str) {
                if ("child_added".equals(str)) {
                    reactNativeFirebaseDatabaseQuery.removeEventListener((ChildEventListener) this);
                    Tasks.call(ReactNativeFirebaseDatabaseQueryModule.this.getExecutor(), new Callable(str) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object call() {
                            return ReactNativeFirebaseDatabaseCommon.snapshotWithPreviousChildToMap(DataSnapshot.this, this.f$1);
                        }
                    }).addOnCompleteListener(new OnCompleteListener() {
                        public final void onComplete(Task task) {
                            ReactNativeFirebaseDatabaseQueryModule.AnonymousClass2.lambda$onChildAdded$1(Promise.this, task);
                        }
                    });
                }
            }

            static /* synthetic */ void lambda$onChildAdded$1(Promise promise, Task task) {
                if (task.isSuccessful()) {
                    promise.resolve(task.getResult());
                } else {
                    ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
                }
            }

            public void onChildChanged(@Nonnull DataSnapshot dataSnapshot, String str) {
                if ("child_changed".equals(str)) {
                    reactNativeFirebaseDatabaseQuery.removeEventListener((ChildEventListener) this);
                    Tasks.call(ReactNativeFirebaseDatabaseQueryModule.this.getExecutor(), new Callable(str) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object call() {
                            return ReactNativeFirebaseDatabaseCommon.snapshotWithPreviousChildToMap(DataSnapshot.this, this.f$1);
                        }
                    }).addOnCompleteListener(new OnCompleteListener() {
                        public final void onComplete(Task task) {
                            ReactNativeFirebaseDatabaseQueryModule.AnonymousClass2.lambda$onChildChanged$3(Promise.this, task);
                        }
                    });
                }
            }

            static /* synthetic */ void lambda$onChildChanged$3(Promise promise, Task task) {
                if (task.isSuccessful()) {
                    promise.resolve(task.getResult());
                } else {
                    ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
                }
            }

            public void onChildRemoved(@Nonnull DataSnapshot dataSnapshot) {
                if ("child_removed".equals(str)) {
                    reactNativeFirebaseDatabaseQuery.removeEventListener((ChildEventListener) this);
                    Tasks.call(ReactNativeFirebaseDatabaseQueryModule.this.getExecutor(), new Callable() {
                        public final Object call() {
                            return ReactNativeFirebaseDatabaseCommon.snapshotWithPreviousChildToMap(DataSnapshot.this, (String) null);
                        }
                    }).addOnCompleteListener(new OnCompleteListener() {
                        public final void onComplete(Task task) {
                            ReactNativeFirebaseDatabaseQueryModule.AnonymousClass2.lambda$onChildRemoved$5(Promise.this, task);
                        }
                    });
                }
            }

            static /* synthetic */ void lambda$onChildRemoved$5(Promise promise, Task task) {
                if (task.isSuccessful()) {
                    promise.resolve(task.getResult());
                } else {
                    ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
                }
            }

            public void onChildMoved(@Nonnull DataSnapshot dataSnapshot, String str) {
                if ("child_moved".equals(str)) {
                    reactNativeFirebaseDatabaseQuery.removeEventListener((ChildEventListener) this);
                    Tasks.call(ReactNativeFirebaseDatabaseQueryModule.this.getExecutor(), new Callable(str) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object call() {
                            return ReactNativeFirebaseDatabaseCommon.snapshotWithPreviousChildToMap(DataSnapshot.this, this.f$1);
                        }
                    }).addOnCompleteListener(new OnCompleteListener() {
                        public final void onComplete(Task task) {
                            ReactNativeFirebaseDatabaseQueryModule.AnonymousClass2.lambda$onChildMoved$7(Promise.this, task);
                        }
                    });
                }
            }

            static /* synthetic */ void lambda$onChildMoved$7(Promise promise, Task task) {
                if (task.isSuccessful()) {
                    promise.resolve(task.getResult());
                } else {
                    ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
                }
            }

            public void onCancelled(@Nonnull DatabaseError databaseError) {
                reactNativeFirebaseDatabaseQuery.removeEventListener((ChildEventListener) this);
                ReactNativeFirebaseDatabaseCommon.rejectPromiseDatabaseException(promise, new UniversalDatabaseException(databaseError.getCode(), databaseError.getMessage(), databaseError.toException()));
            }
        });
    }

    private void addValueEventListener(String str, ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery, ReadableMap readableMap) {
        String string = readableMap.getString("eventRegistrationKey");
        if (!reactNativeFirebaseDatabaseQuery.hasEventListener(string).booleanValue()) {
            final String str2 = str;
            final ReadableMap readableMap2 = readableMap;
            final ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery2 = reactNativeFirebaseDatabaseQuery;
            final String str3 = string;
            reactNativeFirebaseDatabaseQuery.addEventListener(string, (ValueEventListener) new ValueEventListener() {
                public void onDataChange(@Nonnull DataSnapshot dataSnapshot) {
                    ReactNativeFirebaseDatabaseQueryModule.this.handleDatabaseEvent(str2, "value", readableMap2, dataSnapshot, (String) null);
                }

                public void onCancelled(@Nonnull DatabaseError databaseError) {
                    reactNativeFirebaseDatabaseQuery2.removeEventListener(str3);
                    ReactNativeFirebaseDatabaseQueryModule.this.handleDatabaseEventError(str2, readableMap2, databaseError);
                }
            });
        }
    }

    private void addChildEventListener(String str, String str2, ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery, ReadableMap readableMap) {
        String string = readableMap.getString("eventRegistrationKey");
        if (!reactNativeFirebaseDatabaseQuery.hasEventListener(string).booleanValue()) {
            final String str3 = str2;
            final String str4 = str;
            final ReadableMap readableMap2 = readableMap;
            final ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery2 = reactNativeFirebaseDatabaseQuery;
            final String str5 = string;
            reactNativeFirebaseDatabaseQuery.addEventListener(string, (ChildEventListener) new ChildEventListener() {
                public void onChildAdded(@Nonnull DataSnapshot dataSnapshot, String str) {
                    if ("child_added".equals(str3)) {
                        ReactNativeFirebaseDatabaseQueryModule.this.handleDatabaseEvent(str4, "child_added", readableMap2, dataSnapshot, str);
                    }
                }

                public void onChildChanged(@Nonnull DataSnapshot dataSnapshot, String str) {
                    if ("child_changed".equals(str3)) {
                        ReactNativeFirebaseDatabaseQueryModule.this.handleDatabaseEvent(str4, "child_changed", readableMap2, dataSnapshot, str);
                    }
                }

                public void onChildRemoved(@Nonnull DataSnapshot dataSnapshot) {
                    if ("child_removed".equals(str3)) {
                        ReactNativeFirebaseDatabaseQueryModule.this.handleDatabaseEvent(str4, "child_removed", readableMap2, dataSnapshot, (String) null);
                    }
                }

                public void onChildMoved(@Nonnull DataSnapshot dataSnapshot, String str) {
                    if ("child_moved".equals(str3)) {
                        ReactNativeFirebaseDatabaseQueryModule.this.handleDatabaseEvent(str4, "child_moved", readableMap2, dataSnapshot, str);
                    }
                }

                public void onCancelled(@Nonnull DatabaseError databaseError) {
                    reactNativeFirebaseDatabaseQuery2.removeEventListener(str5);
                    ReactNativeFirebaseDatabaseQueryModule.this.handleDatabaseEventError(str4, readableMap2, databaseError);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleDatabaseEvent(String str, String str2, ReadableMap readableMap, DataSnapshot dataSnapshot, @Nullable String str3) {
        Tasks.call(getTransactionalExecutor(readableMap.getString("eventRegistrationKey")), new Callable(str2, dataSnapshot, str3) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ DataSnapshot f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object call() {
                return ReactNativeFirebaseDatabaseQueryModule.lambda$handleDatabaseEvent$0(this.f$0, this.f$1, this.f$2);
            }
        }).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(str, str2, readableMap) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ String f$1;
            public final /* synthetic */ ReadableMap f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseDatabaseQueryModule.lambda$handleDatabaseEvent$1(this.f$0, this.f$1, this.f$2, task);
            }
        });
    }

    static /* synthetic */ WritableMap lambda$handleDatabaseEvent$0(String str, DataSnapshot dataSnapshot, String str2) throws Exception {
        if (str.equals("value")) {
            return ReactNativeFirebaseDatabaseCommon.snapshotToMap(dataSnapshot);
        }
        return ReactNativeFirebaseDatabaseCommon.snapshotWithPreviousChildToMap(dataSnapshot, str2);
    }

    static /* synthetic */ void lambda$handleDatabaseEvent$1(String str, String str2, ReadableMap readableMap, Task task) {
        if (task.isSuccessful()) {
            WritableMap createMap = Arguments.createMap();
            createMap.putMap("data", (WritableMap) task.getResult());
            createMap.putString("key", str);
            createMap.putString("eventType", str2);
            createMap.putMap("registration", RCTConvertFirebase.readableMapToWritableMap(readableMap));
            ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseDatabaseEvent("database_sync_event", createMap));
        }
    }

    /* access modifiers changed from: private */
    public void handleDatabaseEventError(String str, ReadableMap readableMap, DatabaseError databaseError) {
        WritableMap createMap = Arguments.createMap();
        UniversalDatabaseException universalDatabaseException = new UniversalDatabaseException(databaseError.getCode(), databaseError.getMessage(), databaseError.toException());
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putString("code", universalDatabaseException.getCode());
        createMap2.putString(FFmpegKitReactNativeModule.KEY_LOG_MESSAGE, universalDatabaseException.getMessage());
        createMap.putString("key", str);
        createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, createMap2);
        createMap.putMap("registration", RCTConvertFirebase.readableMapToWritableMap(readableMap));
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseDatabaseEvent("database_sync_event", createMap));
    }

    @ReactMethod
    public void once(String str, String str2, String str3, ReadableArray readableArray, String str4, Promise promise) {
        DatabaseReference reference = UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference(str3);
        if (str4.equals("value")) {
            addOnceValueEventListener(getDatabaseQueryInstance(reference, readableArray), promise);
        } else {
            addChildOnceEventListener(str4, getDatabaseQueryInstance(reference, readableArray), promise);
        }
    }

    @ReactMethod
    public void on(String str, String str2, ReadableMap readableMap) {
        String string = readableMap.getString("key");
        ReadableArray array = readableMap.getArray("modifiers");
        String str3 = (String) Objects.requireNonNull(readableMap.getString("eventType"));
        ReadableMap readableMap2 = (ReadableMap) Objects.requireNonNull(readableMap.getMap("registration"));
        DatabaseReference reference = UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference((String) Objects.requireNonNull(readableMap.getString(RNFetchBlobConst.RNFB_RESPONSE_PATH)));
        if (str3.equals("value")) {
            addValueEventListener(string, getDatabaseQueryInstance(string, reference, array), readableMap2);
        } else {
            addChildEventListener(string, str3, getDatabaseQueryInstance(string, reference, array), readableMap2);
        }
    }

    @ReactMethod
    public void off(String str, String str2) {
        ReactNativeFirebaseDatabaseQuery reactNativeFirebaseDatabaseQuery = this.queryMap.get(str);
        if (reactNativeFirebaseDatabaseQuery != null) {
            reactNativeFirebaseDatabaseQuery.removeEventListener(str2);
            removeEventListeningExecutor(str2);
            if (!reactNativeFirebaseDatabaseQuery.hasListeners().booleanValue()) {
                this.queryMap.remove(str);
            }
        }
    }

    @ReactMethod
    public void keepSynced(String str, String str2, String str3, String str4, ReadableArray readableArray, Boolean bool, Promise promise) {
        getDatabaseQueryInstance(str3, UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference(str4), readableArray).query.keepSynced(bool.booleanValue());
        promise.resolve((Object) null);
    }
}
