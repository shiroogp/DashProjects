package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzie {
    private final zzic zza;
    private final zzia zzb;
    private final zzid zzc;
    private final zzib zzd;
    private final Boolean zze;
    private final Float zzf;

    /* synthetic */ zzie(zzhz zzhz, zzhy zzhy) {
        this.zza = zzhz.zza;
        this.zzb = zzhz.zzb;
        this.zzc = zzhz.zzc;
        this.zzd = zzhz.zzd;
        this.zze = zzhz.zze;
        this.zzf = zzhz.zzf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzie)) {
            return false;
        }
        zzie zzie = (zzie) obj;
        return Objects.equal(this.zza, zzie.zza) && Objects.equal(this.zzb, zzie.zzb) && Objects.equal(this.zzc, zzie.zzc) && Objects.equal(this.zzd, zzie.zzd) && Objects.equal(this.zze, zzie.zze) && Objects.equal(this.zzf, zzie.zzf);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    public final zzia zza() {
        return this.zzb;
    }

    public final zzib zzb() {
        return this.zzd;
    }

    public final zzic zzc() {
        return this.zza;
    }

    public final zzid zzd() {
        return this.zzc;
    }

    public final Boolean zze() {
        return this.zze;
    }

    public final Float zzf() {
        return this.zzf;
    }
}
