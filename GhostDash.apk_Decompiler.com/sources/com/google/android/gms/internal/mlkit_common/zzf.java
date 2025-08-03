package com.google.android.gms.internal.mlkit_common;

import android.content.Context;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzf {
    public static final zzf zza;
    public static final zzf zzb;
    /* access modifiers changed from: private */
    public final boolean zzc;
    /* access modifiers changed from: private */
    public final boolean zzd = false;
    private final zzaj<zzp> zze;

    static {
        zze zze2 = new zze((zzd) null);
        zze2.zza();
        zza = zze2.zzc();
        zze zze3 = new zze((zzd) null);
        zze3.zzb();
        zzb = zze3.zzc();
    }

    /* synthetic */ zzf(boolean z, boolean z2, zzaj zzaj, zzd zzd2) {
        this.zzc = z;
        this.zze = zzaj;
    }

    static /* synthetic */ int zzc(zzf zzf, Context context, zzo zzo) {
        zzaj<zzp> zzaj = zzf.zze;
        int size = zzaj.size();
        int i = 0;
        while (i < size) {
            boolean z = zzf.zzc;
            int zza2 = zzaj.get(i).zza();
            int i2 = zza2 - 1;
            if (zza2 != 0) {
                i++;
                if (i2 == 0) {
                    return 1;
                }
                if (i2 == 1) {
                    return 2;
                }
            } else {
                throw null;
            }
        }
        return 3;
    }
}
