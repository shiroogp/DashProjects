package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
abstract class zzcf<F, T> implements Iterator<T> {
    final Iterator<? extends F> zzb;

    zzcf(Iterator<? extends F> it2) {
        Objects.requireNonNull(it2);
        this.zzb = it2;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final T next() {
        return zza(this.zzb.next());
    }

    public final void remove() {
        this.zzb.remove();
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(F f);
}
