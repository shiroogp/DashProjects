package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final /* synthetic */ class zzlj implements Runnable {
    public final /* synthetic */ zzlo zza;
    public final /* synthetic */ zzjc zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzlr zzd;

    public /* synthetic */ zzlj(zzlo zzlo, zzlr zzlr, zzjc zzjc, String str, byte[] bArr) {
        this.zza = zzlo;
        this.zzd = zzlr;
        this.zzb = zzjc;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzc(this.zzd, this.zzb, this.zzc);
    }
}
