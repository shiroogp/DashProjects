package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzlh {
    private static zzlg zza;

    public static synchronized zzkw zza(zzkq zzkq) {
        zzkw zzkw;
        synchronized (zzlh.class) {
            if (zza == null) {
                zza = new zzlg((zzlf) null);
            }
            zzkw = (zzkw) zza.get(zzkq);
        }
        return zzkw;
    }

    public static synchronized zzkw zzb(String str) {
        zzkw zza2;
        synchronized (zzlh.class) {
            zza2 = zza(zzkq.zzd(str).zzd());
        }
        return zza2;
    }
}
