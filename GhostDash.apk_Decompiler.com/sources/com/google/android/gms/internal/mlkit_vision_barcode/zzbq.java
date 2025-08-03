package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzbq extends AbstractCollection {
    final /* synthetic */ zzbr zza;

    zzbq(zzbr zzbr) {
        this.zza = zzbr;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzbr zzbr = this.zza;
        Map zzj = zzbr.zzj();
        if (zzj != null) {
            return zzj.values().iterator();
        }
        return new zzbl(zzbr);
    }

    public final int size() {
        return this.zza.size();
    }
}
