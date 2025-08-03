package com.google.mlkit.vision.barcode.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final /* synthetic */ class zzd implements ComponentFactory {
    public static final /* synthetic */ zzd zza = new zzd();

    private /* synthetic */ zzd() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new zze((zzf) componentContainer.get(zzf.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class));
    }
}
