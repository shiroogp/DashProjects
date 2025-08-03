package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
class zzae<K, V> extends zzap<K, V> implements zzbo<K, V> {
    protected zzae(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public /* bridge */ /* synthetic */ Collection zza() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final Collection<V> zzb(K k, Collection<V> collection) {
        return zzi(k, (List) collection, (zzam) null);
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.util.List<V>, java.util.Collection] */
    public final List<V> zzc(@NullableDecl K k) {
        return super.zzh(k);
    }
}
