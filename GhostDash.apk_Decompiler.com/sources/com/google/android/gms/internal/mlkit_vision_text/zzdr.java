package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzdr {
    private final zzir zza;
    private final Boolean zzb = null;
    private final Boolean zzc;
    private final zzih zzd;

    /* synthetic */ zzdr(zzdq zzdq, zzdo zzdo) {
        this.zza = zzdq.zza;
        this.zzc = zzdq.zzb;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdr)) {
            return false;
        }
        zzdr zzdr = (zzdr) obj;
        if (Objects.equal(this.zza, zzdr.zza)) {
            Boolean bool = zzdr.zzb;
            if (Objects.equal((Object) null, (Object) null) && Objects.equal(this.zzc, zzdr.zzc)) {
                zzih zzih = zzdr.zzd;
                if (Objects.equal((Object) null, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null);
    }

    public final zzir zza() {
        return this.zza;
    }

    public final Boolean zzb() {
        return this.zzc;
    }
}
