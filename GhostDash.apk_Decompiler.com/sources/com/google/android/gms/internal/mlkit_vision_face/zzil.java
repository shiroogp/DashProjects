package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzil {
    /* access modifiers changed from: private */
    public Long zza;
    /* access modifiers changed from: private */
    public zzis zzb;
    /* access modifiers changed from: private */
    public Boolean zzc;
    /* access modifiers changed from: private */
    public Boolean zzd;
    /* access modifiers changed from: private */
    public Boolean zze;

    public final zzil zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzil zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzil zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzil zzd(zzis zzis) {
        this.zzb = zzis;
        return this;
    }

    public final zzil zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzim zzf() {
        return new zzim(this, (zzik) null);
    }
}
