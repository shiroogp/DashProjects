package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzag implements Iterator<Map.Entry> {
    final Iterator<Map.Entry> zza;
    @NullableDecl
    Collection zzb;
    final /* synthetic */ zzah zzc;

    zzag(zzah zzah) {
        this.zzc = zzah;
        this.zza = zzah.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        this.zzb = (Collection) next.getValue();
        zzah zzah = this.zzc;
        Object key = next.getKey();
        return new zzbi(key, zzah.zzb.zzb(key, (Collection) next.getValue()));
    }

    public final void remove() {
        zzab.zzd(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzap.zzg(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
