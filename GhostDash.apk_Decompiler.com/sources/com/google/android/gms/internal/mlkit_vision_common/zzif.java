package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzif extends LazyInstanceMap<zzhr, zzhx> {
    private zzif() {
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzhr zzhr = (zzhr) obj;
        MlKitContext instance = MlKitContext.getInstance();
        return new zzhx(instance.getApplicationContext(), (SharedPrefManager) instance.get(SharedPrefManager.class), new zzhs(MlKitContext.getInstance().getApplicationContext(), zzhr), zzhr.zzb());
    }

    /* synthetic */ zzif(zzie zzie) {
    }
}
