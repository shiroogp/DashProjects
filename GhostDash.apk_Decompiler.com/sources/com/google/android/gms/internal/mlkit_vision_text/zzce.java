package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzce {
    static boolean zzb(Set<?> set, Iterator<?> it2) {
        boolean z = false;
        while (it2.hasNext()) {
            z |= set.remove(it2.next());
        }
        return z;
    }

    static boolean zza(Set<?> set, Collection<?> collection) {
        Objects.requireNonNull(collection);
        if (collection instanceof zzcb) {
            collection = ((zzcb) collection).zza();
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
