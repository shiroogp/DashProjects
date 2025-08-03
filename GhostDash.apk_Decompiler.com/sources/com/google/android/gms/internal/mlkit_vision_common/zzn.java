package com.google.android.gms.internal.mlkit_vision_common;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzn extends zzo {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzo zzc;

    zzn(zzo zzo, int i, int i2) {
        this.zzc = zzo;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzf.zza(i, this.zzb, "index");
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

    public final zzo zzf(int i, int i2) {
        zzf.zzc(i, i2, this.zzb);
        zzo zzo = this.zzc;
        int i3 = this.zza;
        return zzo.subList(i + i3, i2 + i3);
    }
}
