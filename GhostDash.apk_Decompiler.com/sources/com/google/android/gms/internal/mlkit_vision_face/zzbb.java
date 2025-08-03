package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzbb extends AbstractCollection {
    final /* synthetic */ zzbc zza;

    zzbb(zzbc zzbc) {
        this.zza = zzbc;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzbc zzbc = this.zza;
        Map zzj = zzbc.zzj();
        if (zzj != null) {
            return zzj.values().iterator();
        }
        return new zzaw(zzbc);
    }

    public final int size() {
        return this.zza.size();
    }
}
