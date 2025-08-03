package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final class zzik {
    private static zzik zza;

    private zzik() {
    }

    public static synchronized zzik zza() {
        zzik zzik;
        synchronized (zzik.class) {
            if (zza == null) {
                zza = new zzik();
            }
            zzik = zza;
        }
        return zzik;
    }

    public static final boolean zzb() {
        return zzij.zza("mlkit-dev-profiling");
    }
}
