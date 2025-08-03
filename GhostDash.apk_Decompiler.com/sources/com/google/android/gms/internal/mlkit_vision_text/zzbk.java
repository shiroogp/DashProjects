package com.google.android.gms.internal.mlkit_vision_text;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzbk extends zzbl {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzbl zzc;

    zzbk(zzbl zzbl, int i, int i2) {
        this.zzc = zzbl;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzaa.zza(i, this.zzb, "index");
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

    public final zzbl zzf(int i, int i2) {
        zzaa.zzc(i, i2, this.zzb);
        zzbl zzbl = this.zzc;
        int i3 = this.zza;
        return zzbl.subList(i + i3, i2 + i3);
    }
}
