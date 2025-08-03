package com.google.android.gms.internal.mlkit_common;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzy {
    private static final Logger zza = Logger.getLogger(zzy.class.getName());
    private static final zzx zzb = new zzx((zzw) null);

    private zzy() {
    }

    static String zza(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    static boolean zzb(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }
}
