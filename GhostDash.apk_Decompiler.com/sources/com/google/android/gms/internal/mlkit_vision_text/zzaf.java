package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzaf implements Iterator<Map.Entry> {
    final Iterator<Map.Entry> zza;
    @NullableDecl
    Collection zzb;
    final /* synthetic */ zzag zzc;

    zzaf(zzag zzag) {
        this.zzc = zzag;
        this.zza = zzag.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        this.zzb = (Collection) next.getValue();
        zzag zzag = this.zzc;
        Object key = next.getKey();
        return new zzbh(key, zzag.zzb.zzb(key, (Collection) next.getValue()));
    }

    public final void remove() {
        zzaa.zzd(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzao.zzg(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
