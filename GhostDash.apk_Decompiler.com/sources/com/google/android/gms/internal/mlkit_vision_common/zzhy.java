package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final class zzhy {
    private final zzfu zza;
    private zzhf zzb = new zzhf();

    private zzhy(zzfu zzfu, int i) {
        this.zza = zzfu;
        zzik.zza();
    }

    public static zzhy zzc(zzfu zzfu) {
        return new zzhy(zzfu, 0);
    }

    public final String zza() {
        zzhg zzc = this.zza.zzf().zzc();
        return (zzc == null || zzg.zzb(zzc.zzj())) ? "NA" : (String) Preconditions.checkNotNull(zzc.zzj());
    }

    public final byte[] zzb(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(i == 0));
        this.zzb.zze(false);
        this.zza.zze(this.zzb.zzl());
        try {
            zzik.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzel.zza).ignoreNullValues(true).build().encode(this.zza.zzf()).getBytes("utf-8");
            }
            zzfv zzf = this.zza.zzf();
            zzab zzab = new zzab();
            zzel.zza.configure(zzab);
            return zzab.zza().zza(zzf);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public final zzhy zzd(zzfs zzfs) {
        this.zza.zzc(zzfs);
        return this;
    }

    public final zzhy zze(zzhf zzhf) {
        this.zzb = zzhf;
        return this;
    }
}
