package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzik {
    /* access modifiers changed from: private */
    public Long zza;
    /* access modifiers changed from: private */
    public zzir zzb;
    /* access modifiers changed from: private */
    public Boolean zzc;
    /* access modifiers changed from: private */
    public Boolean zzd;
    /* access modifiers changed from: private */
    public Boolean zze;

    public final zzik zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzik zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzik zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzik zzd(zzir zzir) {
        this.zzb = zzir;
        return this;
    }

    public final zzik zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzil zzf() {
        return new zzil(this, (zzij) null);
    }
}
