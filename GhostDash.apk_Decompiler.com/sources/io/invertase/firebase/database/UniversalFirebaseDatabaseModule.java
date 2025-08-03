package io.invertase.firebase.database;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import io.invertase.firebase.common.UniversalFirebaseModule;
import java.util.concurrent.Callable;

public class UniversalFirebaseDatabaseModule extends UniversalFirebaseModule {
    UniversalFirebaseDatabaseModule(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> goOnline(String str, String str2) {
        return Tasks.call(new Callable(str, str2) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object call() {
                return UniversalFirebaseDatabaseCommon.getDatabaseForApp(this.f$0, this.f$1).goOnline();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Task<Void> goOffline(String str, String str2) {
        return Tasks.call(new Callable(str, str2) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object call() {
                return UniversalFirebaseDatabaseCommon.getDatabaseForApp(this.f$0, this.f$1).goOffline();
            }
        });
    }
}
