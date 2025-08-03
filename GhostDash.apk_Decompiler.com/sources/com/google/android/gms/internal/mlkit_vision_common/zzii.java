package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final class zzii {
    public static void zza(zzhx zzhx, int i, int i2, long j, int i3, int i4, int i5, int i6) {
        zzhx.zzb(zzc(i, i2, j, i3, i4, i5, i6), zzfs.INPUT_IMAGE_CONSTRUCTION);
    }

    public static void zzb(zzhx zzhx, int i, int i2, long j, int i3, int i4, int i5, int i6) {
        zzhx.zzb(zzc(i, i2, j, i3, i4, i5, i6), zzfs.ODML_IMAGE);
    }

    private static zzih zzc(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        return new zzih(i, i2, i5, i3, i4, SystemClock.elapsedRealtime() - j, i6);
    }
}
