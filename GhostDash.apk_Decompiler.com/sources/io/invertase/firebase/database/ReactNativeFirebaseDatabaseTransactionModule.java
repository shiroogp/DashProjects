package io.invertase.firebase.database;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import javax.annotation.Nonnull;

public class ReactNativeFirebaseDatabaseTransactionModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "DatabaseTransaction";
    /* access modifiers changed from: private */
    public static SparseArray<ReactNativeFirebaseDatabaseTransactionHandler> transactionHandlers = new SparseArray<>();

    ReactNativeFirebaseDatabaseTransactionModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void transactionStart(String str, String str2, String str3, int i, Boolean bool) {
        AsyncTask.execute(new Runnable(str, str2, str3, i, bool) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;
            public final /* synthetic */ int f$4;
            public final /* synthetic */ Boolean f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                ReactNativeFirebaseDatabaseTransactionModule.this.lambda$transactionStart$0$ReactNativeFirebaseDatabaseTransactionModule(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        });
    }

    public /* synthetic */ void lambda$transactionStart$0$ReactNativeFirebaseDatabaseTransactionModule(final String str, final String str2, String str3, final int i, Boolean bool) {
        UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference(str3).runTransaction(new Transaction.Handler() {
            @Nonnull
            public Transaction.Result doTransaction(@Nonnull MutableData mutableData) {
                ReactNativeFirebaseDatabaseTransactionHandler reactNativeFirebaseDatabaseTransactionHandler = new ReactNativeFirebaseDatabaseTransactionHandler(i, str, str2);
                ReactNativeFirebaseDatabaseTransactionModule.transactionHandlers.put(i, reactNativeFirebaseDatabaseTransactionHandler);
                AsyncTask.execute(new Runnable(str, i) {
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseTransactionEvent("database_transaction_event", WritableMap.this, this.f$1, this.f$2));
                    }
                });
                try {
                    reactNativeFirebaseDatabaseTransactionHandler.await();
                    if (reactNativeFirebaseDatabaseTransactionHandler.abort) {
                        return Transaction.abort();
                    }
                    if (reactNativeFirebaseDatabaseTransactionHandler.timeout) {
                        return Transaction.abort();
                    }
                    mutableData.setValue(reactNativeFirebaseDatabaseTransactionHandler.value);
                    return Transaction.success(mutableData);
                } catch (InterruptedException unused) {
                    reactNativeFirebaseDatabaseTransactionHandler.interrupted = true;
                    return Transaction.abort();
                }
            }

            public void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot) {
                ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseTransactionEvent("database_transaction_event", ((ReactNativeFirebaseDatabaseTransactionHandler) ReactNativeFirebaseDatabaseTransactionModule.transactionHandlers.get(i)).createResultMap(databaseError, z, dataSnapshot), str, i));
                ReactNativeFirebaseDatabaseTransactionModule.transactionHandlers.delete(i);
            }
        }, bool.booleanValue());
    }

    @ReactMethod
    public void transactionTryCommit(String str, String str2, int i, ReadableMap readableMap) {
        ReactNativeFirebaseDatabaseTransactionHandler reactNativeFirebaseDatabaseTransactionHandler = transactionHandlers.get(i);
        if (reactNativeFirebaseDatabaseTransactionHandler != null) {
            reactNativeFirebaseDatabaseTransactionHandler.signalUpdateReceived(readableMap);
        }
    }
}
