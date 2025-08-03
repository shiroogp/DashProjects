package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzax implements Iterator {
    @NullableDecl
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzay zzc;

    zzax(zzay zzay, Iterator it2) {
        this.zzc = zzay;
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
        zzaq.zzd(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzbe.zzg(this.zzc.zza, collection.size());
        collection.clear();
        this.zza = null;
    }
}
