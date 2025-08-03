package com.google.mlkit.vision.common.internal;

import com.google.android.odml.image.MlImage;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final /* synthetic */ class zzc implements Callable {
    public final /* synthetic */ MobileVisionBase zza;
    public final /* synthetic */ MlImage zzb;

    public /* synthetic */ zzc(MobileVisionBase mobileVisionBase, MlImage mlImage) {
        this.zza = mobileVisionBase;
        this.zzb = mlImage;
    }

    public final Object call() {
        return this.zza.zzb(this.zzb);
    }
}
