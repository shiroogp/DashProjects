package com.google.android.gms.internal.auth;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzds extends zzdv {
    final /* synthetic */ zzeb zza;
    private int zzb = 0;
    private final int zzc;

    zzds(zzeb zzeb) {
        this.zza = zzeb;
        this.zzc = zzeb.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
