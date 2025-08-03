package com.google.android.gms.internal.mlkit_vision_text;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzba extends AbstractCollection {
    final /* synthetic */ zzbb zza;

    zzba(zzbb zzbb) {
        this.zza = zzbb;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzbb zzbb = this.zza;
        Map zzj = zzbb.zzj();
        if (zzj != null) {
            return zzj.values().iterator();
        }
        return new zzav(zzbb);
    }

    public final int size() {
        return this.zza.size();
    }
}
