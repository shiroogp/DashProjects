package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzbm extends AbstractSet<Map.Entry> {
    final /* synthetic */ zzbr zza;

    zzbm(zzbr zzbr) {
        this.zza = zzbr;
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
            if (zzb == -1 || !zzam.zza(this.zza.zzc[zzb], entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry> iterator() {
        zzbr zzbr = this.zza;
        Map zzj = zzbr.zzj();
        if (zzj != null) {
            return zzj.entrySet().iterator();
        }
        return new zzbk(zzbr);
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
        zzbr zzbr = this.zza;
        int zzb = zzbs.zzb(key, value, zzc, zzi, zzbr.zza, zzbr.zzb, zzbr.zzc);
        if (zzb == -1) {
            return false;
        }
        this.zza.zzm(zzb, zzc);
        zzbr.zzd(this.zza);
        this.zza.zzk();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
