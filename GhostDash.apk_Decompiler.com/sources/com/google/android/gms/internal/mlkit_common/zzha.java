package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzha {
    /* access modifiers changed from: private */
    public zzhl zza;
    /* access modifiers changed from: private */
    public Long zzb;
    /* access modifiers changed from: private */
    public zzgu zzc;
    /* access modifiers changed from: private */
    public Long zzd;
    /* access modifiers changed from: private */
    public zzhb zze;
    /* access modifiers changed from: private */
    public Long zzf;

    public final zzha zzb(Long l) {
        this.zzf = l;
        return this;
    }

    public final zzha zzc(zzhb zzhb) {
        this.zze = zzhb;
        return this;
    }

    public final zzha zzd(zzgu zzgu) {
        this.zzc = zzgu;
        return this;
    }

    public final zzha zze(Long l) {
        this.zzd = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzha zzf(zzhl zzhl) {
        this.zza = zzhl;
        return this;
    }

    public final zzha zzg(Long l) {
        this.zzb = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzhc zzi() {
        return new zzhc(this, (zzgz) null);
    }
}
