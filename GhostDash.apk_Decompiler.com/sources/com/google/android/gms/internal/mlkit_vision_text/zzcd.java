package com.google.android.gms.internal.mlkit_vision_text;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
abstract class zzcd<E> extends AbstractSet<E> {
    zzcd() {
    }

    public boolean removeAll(Collection<?> collection) {
        return zzce.zza(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        return super.retainAll(collection);
    }
}
