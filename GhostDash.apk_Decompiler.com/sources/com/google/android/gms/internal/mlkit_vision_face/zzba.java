package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzba extends zzaq {
    final /* synthetic */ zzbc zza;
    @NullableDecl
    private final Object zzb;
    private int zzc;

    zzba(zzbc zzbc, int i) {
        this.zza = zzbc;
        this.zzb = zzbc.zzb[i];
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i == -1 || i >= this.zza.size() || !zzx.zza(this.zzb, this.zza.zzb[this.zzc])) {
            this.zzc = this.zza.zzp(this.zzb);
        }
    }

    @NullableDecl
    public final Object getKey() {
        return this.zzb;
    }

    @NullableDecl
    public final Object getValue() {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return this.zza.zzc[i];
    }

    public final Object setValue(Object obj) {
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object[] objArr = this.zza.zzc;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }
}
