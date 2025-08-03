package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
class zzal implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzam zzc;

    zzal(zzam zzam) {
        Iterator it2;
        this.zzc = zzam;
        this.zzb = zzam.zzb;
        Collection collection = zzam.zzb;
        if (collection instanceof List) {
            it2 = ((List) collection).listIterator();
        } else {
            it2 = collection.iterator();
        }
        this.zza = it2;
    }

    zzal(zzam zzam, Iterator it2) {
        this.zzc = zzam;
        this.zzb = zzam.zzb;
        this.zza = it2;
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzap.zze(this.zzc.zze);
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
