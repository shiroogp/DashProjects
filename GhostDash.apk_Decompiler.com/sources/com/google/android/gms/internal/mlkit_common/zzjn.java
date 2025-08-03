package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public abstract class zzjn {
    public static zzjm zzh() {
        zzja zzja = new zzja();
        zzja.zzg("NA");
        zzja.zzf(false);
        zzja.zze(false);
        zzja.zzd(ModelType.UNKNOWN);
        zzja.zzb(zzgu.NO_ERROR);
        zzja.zza(zzhb.UNKNOWN_STATUS);
        zzja.zzc(0);
        return zzja;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zzgu zzc();

    public abstract zzhb zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}
