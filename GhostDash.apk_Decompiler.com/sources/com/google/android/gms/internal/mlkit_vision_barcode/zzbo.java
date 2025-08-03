package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzbo extends AbstractSet {
    final /* synthetic */ zzbr zza;

    zzbo(zzbr zzbr) {
        this.zza = zzbr;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzbr zzbr = this.zza;
        Map zzj = zzbr.zzj();
        if (zzj != null) {
            return zzj.keySet().iterator();
        }
        return new zzbj(zzbr);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.keySet().remove(obj);
        }
        return this.zza.zzr(obj) != zzbr.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
