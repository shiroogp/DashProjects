package com.google.android.gms.internal.mlkit_vision_barcode;

import java.lang.annotation.Annotation;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzcv implements zzda {
    private final int zza;
    private final zzcz zzb;

    zzcv(int i, zzcz zzcz) {
        this.zza = i;
        this.zzb = zzcz;
    }

    public final Class<? extends Annotation> annotationType() {
        return zzda.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzda)) {
            return false;
        }
        zzda zzda = (zzda) obj;
        return this.zza == zzda.zza() && this.zzb.equals(zzda.zzb());
    }

    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf" + "(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    public final int zza() {
        return this.zza;
    }

    public final zzcz zzb() {
        return this.zzb;
    }
}
