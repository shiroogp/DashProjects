package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzah extends zzbu {
    final transient Map zza;
    final /* synthetic */ zzap zzb;

    zzah(zzap zzap, Map map) {
        this.zzb = zzap;
        this.zza = map;
    }

    public final void clear() {
        if (this.zza == this.zzb.zza) {
            this.zzb.zzn();
        } else {
            zzbn.zza(new zzag(this));
        }
    }

    public final boolean containsKey(Object obj) {
        return zzbv.zzb(this.zza, obj);
    }

    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzbv.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzb(obj, collection);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Set keySet() {
        return this.zzb.zzq();
    }

    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zza2 = this.zzb.zza();
        zza2.addAll(collection);
        zzap.zzg(this.zzb, collection.size());
        collection.clear();
        return zza2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    /* access modifiers changed from: protected */
    public final Set<Map.Entry> zza() {
        return new zzaf(this);
    }
}
