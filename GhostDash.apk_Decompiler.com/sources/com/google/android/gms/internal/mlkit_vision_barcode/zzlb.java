package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzlb {
    private final zzcb<zzky> zza;

    /* synthetic */ zzlb(zzla zzla, zzkz zzkz) {
        this.zza = zzla.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlb)) {
            return false;
        }
        return Objects.equal(this.zza, ((zzlb) obj).zza);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public final zzcb<zzky> zza() {
        return this.zza;
    }
}
