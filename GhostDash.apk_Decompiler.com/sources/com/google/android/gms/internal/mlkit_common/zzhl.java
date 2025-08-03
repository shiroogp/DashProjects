package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzhl {
    private final zzhh zza;
    private final zzhk zzb = null;
    private final zzhk zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzhl(zzhj zzhj, zzhi zzhi) {
        this.zza = zzhj.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhl)) {
            return false;
        }
        zzhl zzhl = (zzhl) obj;
        if (Objects.equal(this.zza, zzhl.zza)) {
            zzhk zzhk = zzhl.zzb;
            if (Objects.equal((Object) null, (Object) null)) {
                zzhk zzhk2 = zzhl.zzc;
                if (Objects.equal((Object) null, (Object) null)) {
                    Boolean bool = zzhl.zzd;
                    if (Objects.equal((Object) null, (Object) null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    public final zzhh zza() {
        return this.zza;
    }
}
