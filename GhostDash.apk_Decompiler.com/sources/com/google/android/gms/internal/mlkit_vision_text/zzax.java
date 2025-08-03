package com.google.android.gms.internal.mlkit_vision_text;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
abstract class zzax<T> implements Iterator<T> {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzbb zze;

    /* synthetic */ zzax(zzbb zzbb, zzat zzat) {
        this.zze = zzbb;
        this.zzb = zzbb.zzf;
        this.zzc = zzbb.zze();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    public final T next() {
        zzb();
        if (hasNext()) {
            int i = this.zzc;
            this.zzd = i;
            T zza = zza(i);
            this.zzc = this.zze.zzf(this.zzc);
            return zza;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        zzb();
        zzaa.zzd(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzbb zzbb = this.zze;
        zzbb.remove(zzbb.zzb[this.zzd]);
        this.zzc--;
        this.zzd = -1;
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(int i);
}
