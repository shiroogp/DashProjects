package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;
import kotlin.UByte;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzyn implements Comparator<zzyu> {
    zzyn() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzyu zzyu = (zzyu) obj;
        zzyu zzyu2 = (zzyu) obj2;
        zzyl zzyl = new zzyl(zzyu);
        zzyl zzyl2 = new zzyl(zzyu2);
        while (zzyl.hasNext() && zzyl2.hasNext()) {
            int zza = zzym.zza(zzyl.zza() & UByte.MAX_VALUE, zzyl2.zza() & UByte.MAX_VALUE);
            if (zza != 0) {
                return zza;
            }
        }
        return zzym.zza(zzyu.zzd(), zzyu2.zzd());
    }
}
