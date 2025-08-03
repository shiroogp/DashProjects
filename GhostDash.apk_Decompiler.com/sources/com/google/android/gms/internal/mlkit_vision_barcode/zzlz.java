package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzlz {
    private static zzly zza;

    public static synchronized zzlo zza(zzlh zzlh) {
        zzlo zzlo;
        synchronized (zzlz.class) {
            if (zza == null) {
                zza = new zzly((zzlx) null);
            }
            zzlo = (zzlo) zza.get(zzlh);
        }
        return zzlo;
    }

    public static synchronized zzlo zzb(String str) {
        zzlo zza2;
        synchronized (zzlz.class) {
            zza2 = zza(zzlh.zzd(str).zzd());
        }
        return zza2;
    }
}
