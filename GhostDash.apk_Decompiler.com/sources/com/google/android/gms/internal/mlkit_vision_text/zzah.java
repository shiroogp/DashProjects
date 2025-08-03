package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzah implements Iterator {
    @NullableDecl
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzai zzc;

    zzah(zzai zzai, Iterator it2) {
        this.zzc = zzai;
        this.zzb = it2;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    public final void remove() {
        zzaa.zzd(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzao.zzg(this.zzc.zza, collection.size());
        collection.clear();
        this.zza = null;
    }
}
