package com.google.android.gms.internal.mlkit_vision_text;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzlg extends LazyInstanceMap<zzkq, zzkw> {
    private zzlg() {
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzkq zzkq = (zzkq) obj;
        MlKitContext instance = MlKitContext.getInstance();
        return new zzkw(instance.getApplicationContext(), (SharedPrefManager) instance.get(SharedPrefManager.class), new zzkr(MlKitContext.getInstance().getApplicationContext(), zzkq), zzkq.zzb());
    }

    /* synthetic */ zzlg(zzlf zzlf) {
    }
}
