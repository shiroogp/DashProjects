package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzir {
    private final zziq zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzir(zzip zzip, zzio zzio) {
        this.zza = zzip.zza;
        this.zzb = zzip.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzir)) {
            return false;
        }
        zzir zzir = (zzir) obj;
        if (Objects.equal(this.zza, zzir.zza) && Objects.equal(this.zzb, zzir.zzb)) {
            Integer num = zzir.zzc;
            if (Objects.equal((Object) null, (Object) null)) {
                Boolean bool = zzir.zzd;
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

    public final zziq zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
