package com.google.android.gms.internal.auth;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzdu implements Comparator<zzeb> {
    zzdu() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzeb zzeb = (zzeb) obj;
        zzeb zzeb2 = (zzeb) obj2;
        zzds zzds = new zzds(zzeb);
        zzds zzds2 = new zzds(zzeb2);
        while (zzds.hasNext() && zzds2.hasNext()) {
            int zza = zzdt.zza(zzds.zza() & UByte.MAX_VALUE, zzds2.zza() & UByte.MAX_VALUE);
            if (zza != 0) {
                return zza;
            }
        }
        return zzdt.zza(zzeb.zzd(), zzeb2.zzd());
    }
}
