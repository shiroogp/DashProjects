package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzda {
    /* access modifiers changed from: private */
    public zzdc zza;
    /* access modifiers changed from: private */
    public Integer zzb;
    /* access modifiers changed from: private */
    public zzhw zzc;

    public final zzda zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzda zzb(zzhw zzhw) {
        this.zzc = zzhw;
        return this;
    }

    public final zzda zzc(zzdc zzdc) {
        this.zza = zzdc;
        return this;
    }

    public final zzdd zze() {
        return new zzdd(this, (zzcz) null);
    }
}
