package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzma {
    private static zzma zza;

    private zzma() {
    }

    public static synchronized zzma zza() {
        zzma zzma;
        synchronized (zzma.class) {
            if (zza == null) {
                zza = new zzma();
            }
            zzma = zza;
        }
        return zzma;
    }
}
