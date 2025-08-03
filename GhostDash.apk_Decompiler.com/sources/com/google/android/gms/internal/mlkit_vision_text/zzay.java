package com.google.android.gms.internal.mlkit_vision_text;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzay extends AbstractSet {
    final /* synthetic */ zzbb zza;

    zzay(zzbb zzbb) {
        this.zza = zzbb;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzbb zzbb = this.zza;
        Map zzj = zzbb.zzj();
        if (zzj != null) {
            return zzj.keySet().iterator();
        }
        return new zzat(zzbb);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.keySet().remove(obj);
        }
        return this.zza.zzr(obj) != zzbb.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
