package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzdb {
    /* access modifiers changed from: private */
    public zzis zza;
    /* access modifiers changed from: private */
    public Boolean zzb;
    /* access modifiers changed from: private */
    public zzie zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public Integer zze;

    public final zzdb zza(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdb zzb(zzie zzie) {
        this.zzc = zzie;
        return this;
    }

    public final zzdb zzc(zzis zzis) {
        this.zza = zzis;
        return this;
    }

    public final zzdb zzd(Boolean bool) {
        this.zzb = bool;
        return this;
    }

    public final zzdb zze(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdc zzf() {
        return new zzdc(this, (zzcz) null);
    }
}
