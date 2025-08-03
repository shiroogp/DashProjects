package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzca extends zzcb {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzcb zzc;

    zzca(zzcb zzcb, int i, int i2) {
        this.zzc = zzcb;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzaq.zza(i, this.zzb, "index");
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

    public final zzcb zzf(int i, int i2) {
        zzaq.zzc(i, i2, this.zzb);
        zzcb zzcb = this.zzc;
        int i3 = this.zza;
        return zzcb.subList(i + i3, i2 + i3);
    }
}
