package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
abstract class zzbv<K, V> extends zzcd<Map.Entry<K, V>> {
    zzbv() {
    }

    public final void clear() {
        zza().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object zza = zzbz.zza(zza(), key);
        if (!zzw.zza(zza, entry.getValue())) {
            return false;
        }
        if (zza != null) {
            return true;
        }
        if (!zzbz.zzb(((zzag) zza()).zza, key)) {
            return false;
        }
        return true;
    }

    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    public boolean remove(Object obj) {
        if (contains(obj)) {
            return ((zzag) zza()).zzb.zzq().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    public final int size() {
        return zza().size();
    }

    /* access modifiers changed from: package-private */
    public abstract Map<K, V> zza();

    public final boolean removeAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        try {
            return zzce.zza(this, collection);
        } catch (UnsupportedOperationException unused) {
            return zzce.zzb(this, collection.iterator());
        }
    }

    public final boolean retainAll(Collection<?> collection) {
        int i;
        Objects.requireNonNull(collection);
        try {
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size >= 3) {
                i = size < 1073741824 ? (int) ((((float) size) / 0.75f) + 1.0f) : Integer.MAX_VALUE;
            } else if (size >= 0) {
                i = size + 1;
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("expectedSize cannot be negative but was: ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            }
            HashSet hashSet = new HashSet(i);
            for (Object next : collection) {
                if (contains(next)) {
                    hashSet.add(((Map.Entry) next).getKey());
                }
            }
            return ((zzag) zza()).zzb.zzq().retainAll(hashSet);
        }
    }
}
