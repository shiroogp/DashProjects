package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
class zzak implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzal zzc;

    zzak(zzal zzal) {
        Iterator it2;
        this.zzc = zzal;
        this.zzb = zzal.zzb;
        Collection collection = zzal.zzb;
        if (collection instanceof List) {
            it2 = ((List) collection).listIterator();
        } else {
            it2 = collection.iterator();
        }
        this.zza = it2;
    }

    zzak(zzal zzal, Iterator it2) {
        this.zzc = zzal;
        this.zzb = zzal.zzb;
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
        zzao.zze(this.zzc.zze);
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
