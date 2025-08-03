package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final /* synthetic */ class zzkv implements Runnable {
    public final /* synthetic */ zzla zza;
    public final /* synthetic */ zzit zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzld zzd;

    public /* synthetic */ zzkv(zzla zzla, zzld zzld, zzit zzit, String str, byte[] bArr) {
        this.zza = zzla;
        this.zzd = zzld;
        this.zzb = zzit;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzc(this.zzd, this.zzb, this.zzc);
    }
}
