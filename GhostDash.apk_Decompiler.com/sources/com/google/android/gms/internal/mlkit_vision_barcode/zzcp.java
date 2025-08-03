package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzcp {
    static boolean zzb(Set<?> set, Iterator<?> it2) {
        boolean z = false;
        while (it2.hasNext()) {
            z |= set.remove(it2.next());
        }
        return z;
    }

    static boolean zza(Set<?> set, Collection<?> collection) {
        Objects.requireNonNull(collection);
        if (collection instanceof zzcm) {
            collection = ((zzcm) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzb(set, collection.iterator());
        }
        Iterator<?> it2 = set.iterator();
        Objects.requireNonNull(collection);
        boolean z = false;
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }
}
