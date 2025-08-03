package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzac implements Iterator {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ Iterator zzb;

    zzac(zzae zzae, Iterator it2, Iterator it3) {
        this.zza = it2;
        this.zzb = it3;
    }

    public final boolean hasNext() {
        if (this.zza.hasNext()) {
            return true;
        }
        return this.zzb.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.zza.hasNext()) {
            return new zzat(((Integer) this.zza.next()).toString());
        }
        if (this.zzb.hasNext()) {
            return new zzat((String) this.zzb.next());
        }
        throw new NoSuchElementException();
    }
}
