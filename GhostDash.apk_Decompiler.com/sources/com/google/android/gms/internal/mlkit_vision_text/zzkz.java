package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzkz {
    private final zziu zza;
    private zzkh zzb = new zzkh();
    private final int zzc;

    private zzkz(zziu zziu, int i) {
        this.zza = zziu;
        zzli.zza();
        this.zzc = i;
    }

    public static zzkz zzd(zziu zziu) {
        return new zzkz(zziu, 0);
    }

    public static zzkz zze(zziu zziu, int i) {
        return new zzkz(zziu, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        zzki zzd = this.zza.zzh().zzd();
        return (zzd == null || zzab.zzb(zzd.zzj())) ? "NA" : (String) Preconditions.checkNotNull(zzd.zzj());
    }

    public final byte[] zzc(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(i == 0));
        this.zzb.zze(false);
        this.zza.zzg(this.zzb.zzl());
        try {
            zzli.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzhh.zza).ignoreNullValues(true).build().encode(this.zza.zzh()).getBytes("utf-8");
            }
            zziv zzh = this.zza.zzh();
            zzcu zzcu = new zzcu();
            zzhh.zza.configure(zzcu);
            return zzcu.zza().zza(zzh);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public final zzkz zzf(zzis zzis) {
        this.zza.zzd(zzis);
        return this;
    }

    public final zzkz zzg(zzkh zzkh) {
        this.zzb = zzkh;
        return this;
    }
}
