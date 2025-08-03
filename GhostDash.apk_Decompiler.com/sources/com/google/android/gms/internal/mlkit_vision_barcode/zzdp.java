package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzdp {
    private final zzjb zza;
    private final Boolean zzb = null;
    private final Boolean zzc;
    private final zzir zzd;
    private final zzlb zze;
    private final zzcb<zzjo> zzf;
    private final zzcb<zzjp> zzg;

    /* synthetic */ zzdp(zzdo zzdo, zzdm zzdm) {
        this.zza = zzdo.zza;
        this.zzc = zzdo.zzb;
        this.zzd = null;
        this.zze = zzdo.zzc;
        this.zzf = zzdo.zzd;
        this.zzg = zzdo.zze;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdp)) {
            return false;
        }
        zzdp zzdp = (zzdp) obj;
        if (Objects.equal(this.zza, zzdp.zza)) {
            Boolean bool = zzdp.zzb;
            if (Objects.equal((Object) null, (Object) null) && Objects.equal(this.zzc, zzdp.zzc)) {
                zzir zzir = zzdp.zzd;
                return Objects.equal((Object) null, (Object) null) && Objects.equal(this.zze, zzdp.zze) && Objects.equal(this.zzf, zzdp.zzf) && Objects.equal(this.zzg, zzdp.zzg);
            }
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, this.zzg);
    }

    public final zzcb<zzjo> zza() {
        return this.zzf;
    }

    public final zzcb<zzjp> zzb() {
        return this.zzg;
    }

    public final zzjb zzc() {
        return this.zza;
    }

    public final zzlb zzd() {
        return this.zze;
    }

    public final Boolean zze() {
        return this.zzc;
    }
}
