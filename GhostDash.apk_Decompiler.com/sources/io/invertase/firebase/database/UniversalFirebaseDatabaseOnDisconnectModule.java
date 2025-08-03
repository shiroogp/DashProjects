package io.invertase.firebase.database;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.OnDisconnect;
import io.invertase.firebase.common.UniversalFirebaseModule;
import java.util.Map;

public class UniversalFirebaseDatabaseOnDisconnectModule extends UniversalFirebaseModule {
    UniversalFirebaseDatabaseOnDisconnectModule(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> onDisconnectCancel(String str, String str2, String str3) {
        return UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference(str3).onDisconnect().cancel();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> onDisconnectRemove(String str, String str2, String str3) {
        return UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference(str3).onDisconnect().removeValue();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> onDisconnectSet(String str, String str2, String str3, Object obj) {
        return UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference(str3).onDisconnect().setValue(obj);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> onDisconnectSetWithPriority(String str, String str2, String str3, Object obj, Object obj2) {
        OnDisconnect onDisconnect = UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference(str3).onDisconnect();
        if (obj2 instanceof String) {
            return onDisconnect.setValue(obj, (String) obj2);
        }
        return onDisconnect.setValue(obj, ((Double) obj2).doubleValue());
    }

    /* access modifiers changed from: package-private */
    public Task<Void> onDisconnectUpdate(String str, String str2, String str3, Map<String, Object> map) {
        return UniversalFirebaseDatabaseCommon.getDatabaseForApp(str, str2).getReference(str3).onDisconnect().updateChildren(map);
    }
}
