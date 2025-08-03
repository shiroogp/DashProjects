package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzlm {
    private static zzlm zza;

    private zzlm() {
    }

    public static synchronized zzlm zza() {
        zzlm zzlm;
        synchronized (zzlm.class) {
            if (zza == null) {
                zza = new zzlm();
            }
            zzlm = zza;
        }
        return zzlm;
    }
}
