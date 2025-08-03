package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzll {
    private static zzlk zza;

    public static synchronized zzla zza(zzkt zzkt) {
        zzla zzla;
        synchronized (zzll.class) {
            if (zza == null) {
                zza = new zzlk((zzlj) null);
            }
            zzla = (zzla) zza.get(zzkt);
        }
        return zzla;
    }

    public static synchronized zzla zzb(String str) {
        zzla zza2;
        synchronized (zzll.class) {
            zza2 = zza(zzkt.zzd(str).zzd());
        }
        return zza2;
    }
}
