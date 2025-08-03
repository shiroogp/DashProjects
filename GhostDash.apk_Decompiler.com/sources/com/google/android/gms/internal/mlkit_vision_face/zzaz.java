package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzaz extends AbstractSet {
    final /* synthetic */ zzbc zza;

    zzaz(zzbc zzbc) {
        this.zza = zzbc;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzbc zzbc = this.zza;
        Map zzj = zzbc.zzj();
        if (zzj != null) {
            return zzj.keySet().iterator();
        }
        return new zzau(zzbc);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.keySet().remove(obj);
        }
        return this.zza.zzr(obj) != zzbc.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
