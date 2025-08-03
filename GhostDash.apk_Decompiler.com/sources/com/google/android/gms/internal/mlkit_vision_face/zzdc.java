package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzdc {
    private final zzis zza;
    private final Boolean zzb;
    private final zzii zzc = null;
    private final zzie zzd;
    private final Integer zze;
    private final Integer zzf;

    /* synthetic */ zzdc(zzdb zzdb, zzcz zzcz) {
        this.zza = zzdb.zza;
        this.zzb = zzdb.zzb;
        this.zzd = zzdb.zzc;
        this.zze = zzdb.zzd;
        this.zzf = zzdb.zze;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdc)) {
            return false;
        }
        zzdc zzdc = (zzdc) obj;
        if (Objects.equal(this.zza, zzdc.zza) && Objects.equal(this.zzb, zzdc.zzb)) {
            zzii zzii = zzdc.zzc;
            return Objects.equal((Object) null, (Object) null) && Objects.equal(this.zzd, zzdc.zzd) && Objects.equal(this.zze, zzdc.zze) && Objects.equal(this.zzf, zzdc.zzf);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, this.zzd, this.zze, this.zzf);
    }

    public final zzie zza() {
        return this.zzd;
    }

    public final zzis zzb() {
        return this.zza;
    }

    public final Boolean zzc() {
        return this.zzb;
    }

    public final Integer zzd() {
        return this.zze;
    }

    public final Integer zze() {
        return this.zzf;
    }
}
