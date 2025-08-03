package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
abstract class zzaq<K, V> implements zzca<K, V> {
    @NullableDecl
    private transient Set<K> zza;
    @NullableDecl
    private transient Map<K, Collection<V>> zzb;

    zzaq() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzca)) {
            return false;
        }
        return zzp().equals(((zzca) obj).zzp());
    }

    public final int hashCode() {
        return zzp().hashCode();
    }

    public final String toString() {
        return ((zzag) zzp()).zza.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract Map<K, Collection<V>> zzk();

    /* access modifiers changed from: package-private */
    public abstract Set<K> zzl();

    public boolean zzo(@NullableDecl K k, @NullableDecl V v) {
        throw null;
    }

    public final Map<K, Collection<V>> zzp() {
        Map<K, Collection<V>> map = this.zzb;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzk = zzk();
        this.zzb = zzk;
        return zzk;
    }

    public final Set<K> zzq() {
        Set<K> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<K> zzl = zzl();
        this.zza = zzl;
        return zzl;
    }
}
