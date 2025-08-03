package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzjo implements zzjc {
    private final zzgx zza;
    private zzir zzb = new zzir();

    private zzjo(zzgx zzgx, int i) {
        this.zza = zzgx;
        zzjy.zza();
    }

    public static zzjc zzf(zzgx zzgx) {
        return new zzjo(zzgx, 0);
    }

    public static zzjc zzg() {
        return new zzjo(new zzgx(), 0);
    }

    public final zzjc zza(zzgv zzgv) {
        this.zza.zzf(zzgv);
        return this;
    }

    public final zzjc zzb(zzhc zzhc) {
        this.zza.zzi(zzhc);
        return this;
    }

    public final zzjc zzc(zzir zzir) {
        this.zzb = zzir;
        return this;
    }

    public final String zzd() {
        zzis zzf = this.zza.zzk().zzf();
        return (zzf == null || zzaa.zzc(zzf.zzj())) ? "NA" : (String) Preconditions.checkNotNull(zzf.zzj());
    }

    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(i == 0));
        this.zzb.zze(false);
        this.zza.zzj(this.zzb.zzl());
        try {
            zzjy.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzfk.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzgy zzk = this.zza.zzk();
            zzba zzba = new zzba();
            zzfk.zza.configure(zzba);
            return zzba.zza().zza(zzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
