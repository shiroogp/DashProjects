package com.google.android.gms.internal.mlkit_vision_text;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzbp<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
    final List<F> zza;
    final zzu<? super F, ? extends T> zzb;

    zzbp(List<F> list, zzu<? super F, ? extends T> zzu) {
        Objects.requireNonNull(list);
        this.zza = list;
        Objects.requireNonNull(zzu);
        this.zzb = zzu;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final T get(int i) {
        return this.zzb.zza(this.zza.get(i));
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final Iterator<T> iterator() {
        return listIterator();
    }

    public final ListIterator<T> listIterator(int i) {
        return new zzbo(this, this.zza.listIterator(i));
    }

    public final T remove(int i) {
        return this.zzb.zza(this.zza.remove(i));
    }

    public final int size() {
        return this.zza.size();
    }
}
