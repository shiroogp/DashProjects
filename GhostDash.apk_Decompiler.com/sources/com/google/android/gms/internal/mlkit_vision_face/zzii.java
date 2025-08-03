package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzii {
    private final zzih zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzii(zzig zzig, zzif zzif) {
        this.zza = zzig.zza;
        this.zzb = zzig.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzii)) {
            return false;
        }
        zzii zzii = (zzii) obj;
        if (Objects.equal(this.zza, zzii.zza) && Objects.equal(this.zzb, zzii.zzb)) {
            Integer num = zzii.zzc;
            if (Objects.equal((Object) null, (Object) null)) {
                Boolean bool = zzii.zzd;
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

    public final zzih zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
