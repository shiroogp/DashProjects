package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzjh {
    /* access modifiers changed from: private */
    public zzim zza;
    /* access modifiers changed from: private */
    public zzii zzb;
    /* access modifiers changed from: private */
    public zzie zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public Integer zze;

    public final zzjh zzd(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzjh zze(zzie zzie) {
        this.zzc = zzie;
        return this;
    }

    public final zzjh zzf(zzii zzii) {
        this.zzb = zzii;
        return this;
    }

    public final zzjh zzg(zzim zzim) {
        this.zza = zzim;
        return this;
    }

    public final zzjh zzh(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzji zzi() {
        return new zzji(this, (zzjg) null);
    }
}
