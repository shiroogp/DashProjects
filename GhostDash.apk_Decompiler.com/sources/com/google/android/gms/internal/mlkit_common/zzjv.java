package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzjv extends LazyInstanceMap<zzje, zzjl> {
    private zzjv() {
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzje zzje = (zzje) obj;
        MlKitContext instance = MlKitContext.getInstance();
        return new zzjl(instance.getApplicationContext(), (SharedPrefManager) instance.get(SharedPrefManager.class), new zzjf(MlKitContext.getInstance().getApplicationContext(), zzje), zzje.zzb());
    }

    /* synthetic */ zzjv(zzju zzju) {
    }
}
