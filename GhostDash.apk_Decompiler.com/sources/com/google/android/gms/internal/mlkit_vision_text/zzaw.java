package com.google.android.gms.internal.mlkit_vision_text;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzaw extends AbstractSet<Map.Entry> {
    final /* synthetic */ zzbb zza;

    zzaw(zzbb zzbb) {
        this.zza = zzbb;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@NullableDecl Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzb = this.zza.zzp(entry.getKey());
            if (zzb == -1 || !zzw.zza(this.zza.zzc[zzb], entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry> iterator() {
        zzbb zzbb = this.zza;
        Map zzj = zzbb.zzj();
        if (zzj != null) {
            return zzj.entrySet().iterator();
        }
        return new zzau(zzbb);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.zza.zzn()) {
            return false;
        }
        int zzc = this.zza.zzo();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzi = this.zza.zze;
        zzbb zzbb = this.zza;
        int zzb = zzbc.zzb(key, value, zzc, zzi, zzbb.zza, zzbb.zzb, zzbb.zzc);
        if (zzb == -1) {
            return false;
        }
        this.zza.zzm(zzb, zzc);
        zzbb.zzd(this.zza);
        this.zza.zzk();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
