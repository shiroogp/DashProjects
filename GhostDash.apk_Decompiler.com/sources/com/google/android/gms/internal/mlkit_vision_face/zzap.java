package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
abstract class zzap<K, V> extends zzar<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public transient Map<K, Collection<V>> zza;
    private transient int zzb;

    protected zzap(Map<K, Collection<V>> map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    static /* synthetic */ int zzd(zzap zzap) {
        int i = zzap.zzb;
        zzap.zzb = i + 1;
        return i;
    }

    static /* synthetic */ int zze(zzap zzap) {
        int i = zzap.zzb;
        zzap.zzb = i - 1;
        return i;
    }

    static /* synthetic */ int zzf(zzap zzap, int i) {
        int i2 = zzap.zzb + i;
        zzap.zzb = i2;
        return i2;
    }

    static /* synthetic */ int zzg(zzap zzap, int i) {
        int i2 = zzap.zzb - i;
        zzap.zzb = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public abstract Collection<V> zza();

    /* access modifiers changed from: package-private */
    public Collection<V> zzb(@NullableDecl K k, Collection<V> collection) {
        throw null;
    }

    public final Collection<V> zzh(@NullableDecl K k) {
        Collection collection = this.zza.get(k);
        if (collection == null) {
            collection = zza();
        }
        return zzb(k, collection);
    }

    /* access modifiers changed from: package-private */
    public final List<V> zzi(@NullableDecl K k, List<V> list, @NullableDecl zzam zzam) {
        if (list instanceof RandomAccess) {
            return new zzak(this, k, list, zzam);
        }
        return new zzao(this, k, list, zzam);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Collection<V>> zzk() {
        return new zzah(this, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> zzl() {
        return new zzaj(this, this.zza);
    }

    public final void zzn() {
        for (Collection<V> clear : this.zza.values()) {
            clear.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final boolean zzo(@NullableDecl K k, @NullableDecl V v) {
        Collection collection = this.zza.get(k);
        if (collection == null) {
            Collection zza2 = zza();
            if (zza2.add(v)) {
                this.zzb++;
                this.zza.put(k, zza2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }

    static /* synthetic */ void zzm(zzap zzap, Object obj) {
        Collection<V> collection;
        Map<K, Collection<V>> map = zzap.zza;
        Objects.requireNonNull(map);
        try {
            collection = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            collection = null;
        }
        Collection collection2 = collection;
        if (collection2 != null) {
            int size = collection2.size();
            collection2.clear();
            zzap.zzb -= size;
        }
    }
}
