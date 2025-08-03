package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zzks implements Runnable {
    public final /* synthetic */ zzkw zza;
    public final /* synthetic */ zzis zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzkz zzd;

    public /* synthetic */ zzks(zzkw zzkw, zzkz zzkz, zzis zzis, String str, byte[] bArr) {
        this.zza = zzkw;
        this.zzd = zzkz;
        this.zzb = zzis;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzb(this.zzd, this.zzb, this.zzc);
    }
}
