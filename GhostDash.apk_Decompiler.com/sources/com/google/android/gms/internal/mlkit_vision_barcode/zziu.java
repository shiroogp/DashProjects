package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zziu {
    /* access modifiers changed from: private */
    public Long zza;
    /* access modifiers changed from: private */
    public zzjb zzb;
    /* access modifiers changed from: private */
    public Boolean zzc;
    /* access modifiers changed from: private */
    public Boolean zzd;
    /* access modifiers changed from: private */
    public Boolean zze;

    public final zziu zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zziu zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zziu zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zziu zzd(zzjb zzjb) {
        this.zzb = zzjb;
        return this;
    }

    public final zziu zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zziv zzf() {
        return new zziv(this, (zzit) null);
    }
}
