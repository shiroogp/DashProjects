package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final class zzig {
    private static zzif zza;

    public static synchronized zzhx zza(zzhr zzhr) {
        zzhx zzhx;
        synchronized (zzig.class) {
            if (zza == null) {
                zza = new zzif((zzie) null);
            }
            zzhx = (zzhx) zza.get(zzhr);
        }
        return zzhx;
    }

    public static synchronized zzhx zzb(String str) {
        zzhx zza2;
        synchronized (zzig.class) {
            zza2 = zza(zzhr.zzd("vision-common").zzd());
        }
        return zza2;
    }
}
