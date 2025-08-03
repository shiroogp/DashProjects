package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
abstract class zzcq<F, T> implements Iterator<T> {
    final Iterator<? extends F> zza;

    zzcq(Iterator<? extends F> it2) {
        Objects.requireNonNull(it2);
        this.zza = it2;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final T next() {
        return zza(this.zza.next());
    }

    public final void remove() {
        this.zza.remove();
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(F f);
}
