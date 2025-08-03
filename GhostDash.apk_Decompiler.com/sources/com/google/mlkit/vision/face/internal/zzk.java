package com.google.mlkit.vision.face.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final /* synthetic */ class zzk implements ComponentFactory {
    public static final /* synthetic */ zzk zza = new zzk();

    private /* synthetic */ zzk() {
    }

    public final Object create(ComponentContainer componentContainer) {
        int i = FaceRegistrar.zza;
        return new zze((MlKitContext) componentContainer.get(MlKitContext.class));
    }
}
