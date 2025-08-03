package com.google.mlkit.vision.face.internal;

import com.google.android.gms.internal.mlkit_vision_face.zzbm;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public class FaceRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    public final List<Component<?>> getComponents() {
        return zzbm.zzh(Component.builder(zze.class).add(Dependency.required(MlKitContext.class)).factory(zzk.zza).build(), Component.builder(zzd.class).add(Dependency.required(zze.class)).add(Dependency.required(ExecutorSelector.class)).factory(zzl.zza).build());
    }
}
