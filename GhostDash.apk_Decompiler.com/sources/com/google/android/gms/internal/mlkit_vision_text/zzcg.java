package com.google.android.gms.internal.mlkit_vision_text;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
abstract class zzcg<F, T> extends zzcf<F, T> implements ListIterator<T> {
    zzcg(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    public final void add(T t) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasPrevious() {
        return ((ListIterator) this.zzb).hasPrevious();
    }

    public final int nextIndex() {
        return ((ListIterator) this.zzb).nextIndex();
    }

    public final T previous() {
        return zza(((ListIterator) this.zzb).previous());
    }

    public final int previousIndex() {
        return ((ListIterator) this.zzb).previousIndex();
    }

    public final void set(T t) {
        throw new UnsupportedOperationException();
    }
}
