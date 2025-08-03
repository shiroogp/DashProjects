package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzhh {
    private final String zza;
    private final String zzb = null;
    private final zzhg zzc;
    private final String zzd;
    private final String zze;
    private final zzhf zzf;
    private final Long zzg;
    private final Boolean zzh;
    private final Boolean zzi;

    /* synthetic */ zzhh(zzhe zzhe, zzhd zzhd) {
        this.zza = zzhe.zza;
        this.zzc = zzhe.zzb;
        this.zzd = null;
        this.zze = zzhe.zzc;
        this.zzf = zzhe.zzd;
        this.zzg = null;
        this.zzh = null;
        this.zzi = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhh)) {
            return false;
        }
        zzhh zzhh = (zzhh) obj;
        if (Objects.equal(this.zza, zzhh.zza)) {
            String str = zzhh.zzb;
            if (Objects.equal((Object) null, (Object) null) && Objects.equal(this.zzc, zzhh.zzc)) {
                String str2 = zzhh.zzd;
                if (Objects.equal((Object) null, (Object) null) && Objects.equal(this.zze, zzhh.zze) && Objects.equal(this.zzf, zzhh.zzf)) {
                    Long l = zzhh.zzg;
                    if (Objects.equal((Object) null, (Object) null)) {
                        Boolean bool = zzhh.zzh;
                        if (Objects.equal((Object) null, (Object) null)) {
                            Boolean bool2 = zzhh.zzi;
                            if (Objects.equal((Object) null, (Object) null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    public final zzhf zza() {
        return this.zzf;
    }

    public final zzhg zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zza;
    }
}
