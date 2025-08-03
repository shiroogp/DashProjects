package com.google.android.gms.internal.measurement;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
final class zziq implements Comparator {
    zziq() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzix zzix = (zzix) obj;
        zzix zzix2 = (zzix) obj2;
        zzio zzio = new zzio(zzix);
        zzio zzio2 = new zzio(zzix2);
        while (zzio.hasNext() && zzio2.hasNext()) {
            int zza = zzip.zza(zzio.zza() & UByte.MAX_VALUE, zzio2.zza() & UByte.MAX_VALUE);
            if (zza != 0) {
                return zza;
            }
        }
        return zzip.zza(zzix.zzd(), zzix2.zzd());
    }
}
