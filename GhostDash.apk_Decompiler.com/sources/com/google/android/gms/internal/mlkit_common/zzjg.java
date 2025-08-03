package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzjg implements Runnable {
    public final /* synthetic */ zzjl zza;
    public final /* synthetic */ zzjc zzb;
    public final /* synthetic */ zzgv zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzjg(zzjl zzjl, zzjc zzjc, zzgv zzgv, String str) {
        this.zza = zzjl;
        this.zzb = zzjc;
        this.zzc = zzgv;
        this.zzd = str;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
