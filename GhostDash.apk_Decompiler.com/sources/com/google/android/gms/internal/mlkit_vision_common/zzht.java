package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final /* synthetic */ class zzht implements Runnable {
    public final /* synthetic */ zzhx zza;
    public final /* synthetic */ zzfs zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzhy zzd;

    public /* synthetic */ zzht(zzhx zzhx, zzhy zzhy, zzfs zzfs, String str, byte[] bArr) {
        this.zza = zzhx;
        this.zzd = zzhy;
        this.zzb = zzfs;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zza(this.zzd, this.zzb, this.zzc);
    }
}
