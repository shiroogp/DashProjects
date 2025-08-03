package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final class zzfl {
    /* access modifiers changed from: private */
    public Long zza;
    /* access modifiers changed from: private */
    public zzfm zzb;
    /* access modifiers changed from: private */
    public zzfg zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public Integer zze;
    /* access modifiers changed from: private */
    public Integer zzf;
    /* access modifiers changed from: private */
    public Integer zzg;

    public final zzfl zzb(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzfl zzc(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzfl zzd(zzfg zzfg) {
        this.zzc = zzfg;
        return this;
    }

    public final zzfl zze(Integer num) {
        this.zzf = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzfl zzf(zzfm zzfm) {
        this.zzb = zzfm;
        return this;
    }

    public final zzfl zzg(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzfl zzh(Integer num) {
        this.zzg = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzfn zzj() {
        return new zzfn(this, (zzfk) null);
    }
}
