package com.google.mlkit.vision.text.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zzq implements ComponentFactory {
    public static final /* synthetic */ zzq zza = new zzq();

    private /* synthetic */ zzq() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new zzk((zzl) componentContainer.get(zzl.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class));
    }
}
