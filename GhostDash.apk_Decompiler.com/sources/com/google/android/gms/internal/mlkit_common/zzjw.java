package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzjw {
    private static zzjv zza;

    public static synchronized zzjl zza(zzje zzje) {
        zzjl zzjl;
        synchronized (zzjw.class) {
            if (zza == null) {
                zza = new zzjv((zzju) null);
            }
            zzjl = (zzjl) zza.get(zzje);
        }
        return zzjl;
    }

    public static synchronized zzjl zzb(String str) {
        zzjl zza2;
        synchronized (zzjw.class) {
            zza2 = zza(zzje.zzd("common").zzd());
        }
        return zza2;
    }
}
