package com.google.android.gms.internal.mlkit_vision_text;

import java.lang.annotation.Annotation;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzcl implements zzcq {
    private final int zza;
    private final zzcp zzb;

    zzcl(int i, zzcp zzcp) {
        this.zza = i;
        this.zzb = zzcp;
    }

    public final Class<? extends Annotation> annotationType() {
        return zzcq.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcq)) {
            return false;
        }
        zzcq zzcq = (zzcq) obj;
        return this.zza == zzcq.zza() && this.zzb.equals(zzcq.zzb());
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

    public final zzcp zzb() {
        return this.zzb;
    }
}
