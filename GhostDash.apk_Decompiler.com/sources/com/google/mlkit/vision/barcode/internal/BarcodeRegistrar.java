package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.zzcb;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public class BarcodeRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    public final List<Component<?>> getComponents() {
        return zzcb.zzh(Component.builder(zzf.class).add(Dependency.required(MlKitContext.class)).factory(zzc.zza).build(), Component.builder(zze.class).add(Dependency.required(zzf.class)).add(Dependency.required(ExecutorSelector.class)).factory(zzd.zza).build());
    }
}
