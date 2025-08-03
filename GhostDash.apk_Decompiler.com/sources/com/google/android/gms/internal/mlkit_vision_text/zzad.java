package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
class zzad<K, V> extends zzao<K, V> implements zzbn<K, V> {
    protected zzad(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public /* bridge */ /* synthetic */ Collection zza() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final Collection<V> zzb(K k, Collection<V> collection) {
        return zzi(k, (List) collection, (zzal) null);
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.util.List<V>, java.util.Collection] */
    public final List<V> zzc(@NullableDecl K k) {
        return super.zzh(k);
    }
}
