package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzdp {
    /* access modifiers changed from: private */
    public zzdr zza;
    /* access modifiers changed from: private */
    public Integer zzb;
    /* access modifiers changed from: private */
    public zzib zzc;

    public final zzdp zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdp zzb(zzib zzib) {
        this.zzc = zzib;
        return this;
    }

    public final zzdp zzc(zzdr zzdr) {
        this.zza = zzdr;
        return this;
    }

    public final zzds zze() {
        return new zzds(this, (zzdo) null);
    }
}
