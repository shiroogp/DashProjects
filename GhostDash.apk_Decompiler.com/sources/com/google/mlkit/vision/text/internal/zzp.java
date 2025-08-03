package com.google.mlkit.vision.text.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zzp implements ComponentFactory {
    public static final /* synthetic */ zzp zza = new zzp();

    private /* synthetic */ zzp() {
    }

    public final Object create(ComponentContainer componentContainer) {
        int i = TextRegistrar.zza;
        return new zzl((MlKitContext) componentContainer.get(MlKitContext.class));
    }
}
