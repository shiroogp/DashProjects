package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text.zzir;
import com.google.android.gms.internal.mlkit_vision_text.zzkz;
import com.google.mlkit.vision.common.InputImage;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zzn {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzir zzb;
    public final /* synthetic */ InputImage zzc;

    public /* synthetic */ zzn(long j, zzir zzir, InputImage inputImage) {
        this.zza = j;
        this.zzb = zzir;
        this.zzc = inputImage;
    }

    public final zzkz zza() {
        return zzo.zzd(this.zza, this.zzb, this.zzc);
    }
}
