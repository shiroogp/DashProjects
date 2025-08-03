package com.google.android.gms.internal.mlkit_vision_face;

import java.lang.annotation.Annotation;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzcg implements zzcl {
    private final int zza;
    private final zzck zzb;

    zzcg(int i, zzck zzck) {
        this.zza = i;
        this.zzb = zzck;
    }

    public final Class<? extends Annotation> annotationType() {
        return zzcl.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcl)) {
            return false;
        }
        zzcl zzcl = (zzcl) obj;
        return this.zza == zzcl.zza() && this.zzb.equals(zzcl.zzb());
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

    public final zzck zzb() {
        return this.zzb;
    }
}
