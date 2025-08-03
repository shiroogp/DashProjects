package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzih {
    private final zzig zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzih(zzif zzif, zzie zzie) {
        this.zza = zzif.zza;
        this.zzb = zzif.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzih)) {
            return false;
        }
        zzih zzih = (zzih) obj;
        if (Objects.equal(this.zza, zzih.zza) && Objects.equal(this.zzb, zzih.zzb)) {
            Integer num = zzih.zzc;
            if (Objects.equal((Object) null, (Object) null)) {
                Boolean bool = zzih.zzd;
                if (Objects.equal((Object) null, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    public final zzig zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
