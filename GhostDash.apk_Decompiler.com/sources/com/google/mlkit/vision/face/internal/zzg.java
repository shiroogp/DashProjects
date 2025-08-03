package com.google.mlkit.vision.face.internal;

import com.google.android.gms.internal.mlkit_vision_face.zzis;
import com.google.android.gms.internal.mlkit_vision_face.zzky;
import com.google.android.gms.internal.mlkit_vision_face.zzld;
import com.google.mlkit.vision.common.InputImage;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final /* synthetic */ class zzg implements zzky {
    public final /* synthetic */ zzh zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzis zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ InputImage zzf;

    public /* synthetic */ zzg(zzh zzh, long j, zzis zzis, int i, int i2, InputImage inputImage) {
        this.zza = zzh;
        this.zzb = j;
        this.zzc = zzis;
        this.zzd = i;
        this.zze = i2;
        this.zzf = inputImage;
    }

    public final zzld zza() {
        return this.zza.zze(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
