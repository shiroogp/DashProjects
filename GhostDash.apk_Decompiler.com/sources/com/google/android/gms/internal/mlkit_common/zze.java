package com.google.android.gms.internal.mlkit_common;

import java.util.Objects;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zze {
    private final zzag<zzp> zza = zzaj.zzg();
    private Boolean zzb;

    private zze() {
    }

    public final zze zza() {
        zzz.zzd(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = false;
        return this;
    }

    public final zze zzb() {
        zzz.zzd(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = true;
        return this;
    }

    public final zzf zzc() {
        Boolean bool = this.zzb;
        Objects.requireNonNull(bool, "Must call internal() or external() when building a SourcePolicy.");
        return new zzf(bool.booleanValue(), false, this.zza.zzc(), (zzd) null);
    }

    /* synthetic */ zze(zzd zzd) {
    }
}
