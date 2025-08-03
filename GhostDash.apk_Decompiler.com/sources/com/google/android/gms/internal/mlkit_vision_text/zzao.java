package com.google.android.gms.internal.mlkit_vision_text;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
abstract class zzao<K, V> extends zzaq<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public transient Map<K, Collection<V>> zza;
    private transient int zzb;

    protected zzao(Map<K, Collection<V>> map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    static /* synthetic */ int zzd(zzao zzao) {
        int i = zzao.zzb;
        zzao.zzb = i + 1;
        return i;
    }

    static /* synthetic */ int zze(zzao zzao) {
        int i = zzao.zzb;
        zzao.zzb = i - 1;
        return i;
    }

    static /* synthetic */ int zzf(zzao zzao, int i) {
        int i2 = zzao.zzb + i;
        zzao.zzb = i2;
        return i2;
    }

    static /* synthetic */ int zzg(zzao zzao, int i) {
        int i2 = zzao.zzb - i;
        zzao.zzb = i2;
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
    public final List<V> zzi(@NullableDecl K k, List<V> list, @NullableDecl zzal zzal) {
        if (list instanceof RandomAccess) {
            return new zzaj(this, k, list, zzal);
        }
        return new zzan(this, k, list, zzal);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Collection<V>> zzk() {
        return new zzag(this, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> zzl() {
        return new zzai(this, this.zza);
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

    static /* synthetic */ void zzm(zzao zzao, Object obj) {
        Collection<V> collection;
        Map<K, Collection<V>> map = zzao.zza;
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
            zzao.zzb -= size;
        }
    }
}
