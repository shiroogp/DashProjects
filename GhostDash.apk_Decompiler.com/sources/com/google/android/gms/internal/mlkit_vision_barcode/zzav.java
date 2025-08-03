package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzav implements Iterator<Map.Entry> {
    final Iterator<Map.Entry> zza;
    @NullableDecl
    Collection zzb;
    final /* synthetic */ zzaw zzc;

    zzav(zzaw zzaw) {
        this.zzc = zzaw;
        this.zza = zzaw.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        this.zzb = (Collection) next.getValue();
        zzaw zzaw = this.zzc;
        Object key = next.getKey();
        return new zzbx(key, zzaw.zzb.zzb(key, (Collection) next.getValue()));
    }

    public final void remove() {
        zzaq.zzd(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzbe.zzg(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
