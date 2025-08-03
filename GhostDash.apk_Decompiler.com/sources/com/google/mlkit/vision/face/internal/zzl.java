package com.google.mlkit.vision.face.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final /* synthetic */ class zzl implements ComponentFactory {
    public static final /* synthetic */ zzl zza = new zzl();

    private /* synthetic */ zzl() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new zzd((zze) componentContainer.get(zze.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class));
    }
}
