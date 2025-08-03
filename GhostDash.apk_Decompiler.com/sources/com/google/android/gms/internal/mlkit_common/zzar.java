package com.google.android.gms.internal.mlkit_common;

import java.lang.annotation.Annotation;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzar implements zzaw {
    private final int zza;
    private final zzav zzb;

    zzar(int i, zzav zzav) {
        this.zza = i;
        this.zzb = zzav;
    }

    public final Class<? extends Annotation> annotationType() {
        return zzaw.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzaw = (zzaw) obj;
        return this.zza == zzaw.zza() && this.zzb.equals(zzaw.zzb());
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

    public final zzav zzb() {
        return this.zzb;
    }
}
