package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzax extends AbstractSet<Map.Entry> {
    final /* synthetic */ zzbc zza;

    zzax(zzbc zzbc) {
        this.zza = zzbc;
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
            if (zzb == -1 || !zzx.zza(this.zza.zzc[zzb], entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry> iterator() {
        zzbc zzbc = this.zza;
        Map zzj = zzbc.zzj();
        if (zzj != null) {
            return zzj.entrySet().iterator();
        }
        return new zzav(zzbc);
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
        zzbc zzbc = this.zza;
        int zzb = zzbd.zzb(key, value, zzc, zzi, zzbc.zza, zzbc.zzb, zzbc.zzc);
        if (zzb == -1) {
            return false;
        }
        this.zza.zzm(zzb, zzc);
        zzbc.zzd(this.zza);
        this.zza.zzk();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
