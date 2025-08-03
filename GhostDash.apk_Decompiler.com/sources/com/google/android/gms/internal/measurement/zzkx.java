package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
final class zzkx {
    zzkx() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzkw zzkw = (zzkw) obj;
        zzkv zzkv = (zzkv) obj2;
        if (zzkw.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzkw.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzkw zzkw = (zzkw) obj;
        zzkw zzkw2 = (zzkw) obj2;
        if (!zzkw2.isEmpty()) {
            if (!zzkw.zze()) {
                zzkw = zzkw.zzb();
            }
            zzkw.zzd(zzkw2);
        }
        return zzkw;
    }
}
