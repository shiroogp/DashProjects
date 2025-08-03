package com.google.android.gms.internal.mlkit_vision_text;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzbr<F, T> extends AbstractSequentialList<T> implements Serializable {
    final List<F> zza;
    final zzu<? super F, ? extends T> zzb;

    zzbr(List<F> list, zzu<? super F, ? extends T> zzu) {
        Objects.requireNonNull(list);
        this.zza = list;
        Objects.requireNonNull(zzu);
        this.zzb = zzu;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final ListIterator<T> listIterator(int i) {
        return new zzbq(this, this.zza.listIterator(i));
    }

    public final int size() {
        return this.zza.size();
    }
}
