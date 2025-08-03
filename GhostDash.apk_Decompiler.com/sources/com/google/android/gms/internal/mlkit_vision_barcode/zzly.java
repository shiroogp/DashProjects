package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzly extends LazyInstanceMap<zzlh, zzlo> {
    private zzly() {
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzlh zzlh = (zzlh) obj;
        MlKitContext instance = MlKitContext.getInstance();
        return new zzlo(instance.getApplicationContext(), (SharedPrefManager) instance.get(SharedPrefManager.class), new zzli(MlKitContext.getInstance().getApplicationContext(), zzlh), zzlh.zzb());
    }

    /* synthetic */ zzly(zzlx zzlx) {
    }
}
