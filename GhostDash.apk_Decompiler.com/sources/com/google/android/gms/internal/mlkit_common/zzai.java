package com.google.android.gms.internal.mlkit_common;

import java.util.List;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzai extends zzaj {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzaj zzc;

    zzai(zzaj zzaj, int i, int i2) {
        this.zzc = zzaj;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzz.zza(i, this.zzb, "index");
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
    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzaj zzf(int i, int i2) {
        zzz.zzc(i, i2, this.zzb);
        zzaj zzaj = this.zzc;
        int i3 = this.zza;
        return zzaj.subList(i + i3, i2 + i3);
    }
}
