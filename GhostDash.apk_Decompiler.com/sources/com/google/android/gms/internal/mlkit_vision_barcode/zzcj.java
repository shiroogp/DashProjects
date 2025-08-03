package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
abstract class zzcj<K, V> extends AbstractMap<K, V> {
    @NullableDecl
    private transient Set<Map.Entry<K, V>> zza;
    @NullableDecl
    private transient Set<K> zzb;
    @NullableDecl
    private transient Collection<V> zzc;

    zzcj() {
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> zza2 = zza();
        this.zza = zza2;
        return zza2;
    }

    public Set<K> keySet() {
        Set<K> set = this.zzb;
        if (set != null) {
            return set;
        }
        zzch zzch = new zzch(this);
        this.zzb = zzch;
        return zzch;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzci zzci = new zzci(this);
        this.zzc = zzci;
        return zzci;
    }

    /* access modifiers changed from: package-private */
    public abstract Set<Map.Entry<K, V>> zza();
}
