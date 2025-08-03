package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.annotation.Annotation;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzs implements zzx {
    private final int zza;
    private final zzw zzb;

    zzs(int i, zzw zzw) {
        this.zza = i;
        this.zzb = zzw;
    }

    public final Class<? extends Annotation> annotationType() {
        return zzx.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzx)) {
            return false;
        }
        zzx zzx = (zzx) obj;
        return this.zza == zzx.zza() && this.zzb.equals(zzx.zzb());
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

    public final zzw zzb() {
        return this.zzb;
    }
}
