package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzdn {
    /* access modifiers changed from: private */
    public zzdp zza;
    /* access modifiers changed from: private */
    public Integer zzb;
    /* access modifiers changed from: private */
    public zzil zzc;

    public final zzdn zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdn zzb(zzil zzil) {
        this.zzc = zzil;
        return this;
    }

    public final zzdn zzc(zzdp zzdp) {
        this.zza = zzdp;
        return this;
    }

    public final zzdq zze() {
        return new zzdq(this, (zzdm) null);
    }
}
