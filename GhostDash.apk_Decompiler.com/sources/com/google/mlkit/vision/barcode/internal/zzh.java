package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.zzby;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlr;
import com.google.mlkit.vision.common.InputImage;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final /* synthetic */ class zzh implements zzlm {
    public final /* synthetic */ zzi zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzjb zzc;
    public final /* synthetic */ zzby zzd;
    public final /* synthetic */ zzby zze;
    public final /* synthetic */ InputImage zzf;

    public /* synthetic */ zzh(zzi zzi, long j, zzjb zzjb, zzby zzby, zzby zzby2, InputImage inputImage) {
        this.zza = zzi;
        this.zzb = j;
        this.zzc = zzjb;
        this.zzd = zzby;
        this.zze = zzby2;
        this.zzf = inputImage;
    }

    public final zzlr zza() {
        return this.zza.zzd(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
