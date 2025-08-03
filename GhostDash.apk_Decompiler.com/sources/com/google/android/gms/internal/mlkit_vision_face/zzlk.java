package com.google.android.gms.internal.mlkit_vision_face;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzlk extends LazyInstanceMap<zzkt, zzla> {
    private zzlk() {
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzkt zzkt = (zzkt) obj;
        MlKitContext instance = MlKitContext.getInstance();
        return new zzla(instance.getApplicationContext(), (SharedPrefManager) instance.get(SharedPrefManager.class), new zzku(MlKitContext.getInstance().getApplicationContext(), zzkt), zzkt.zzb());
    }

    /* synthetic */ zzlk(zzlj zzlj) {
    }
}
