package com.google.mlkit.vision.common.internal;

import com.google.android.gms.internal.mlkit_vision_common.zzo;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public class VisionCommonRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    public final List<Component<?>> getComponents() {
        return zzo.zzh(Component.builder(MultiFlavorDetectorCreator.class).add(Dependency.setOf(MultiFlavorDetectorCreator.Registration.class)).factory(zzf.zza).build());
    }
}
