package com.google.android.gms.internal.mlkit_vision_face;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzbl extends zzbm {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzbm zzc;

    zzbl(zzbm zzbm, int i, int i2) {
        this.zzc = zzbm;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzab.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzbm zzf(int i, int i2) {
        zzab.zzc(i, i2, this.zzb);
        zzbm zzbm = this.zzc;
        int i3 = this.zza;
        return zzbm.subList(i + i3, i2 + i3);
    }
}
