package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzlr {
    private final zzje zza;
    private zzkv zzb = new zzkv();
    private final int zzc;

    private zzlr(zzje zzje, int i) {
        this.zza = zzje;
        zzma.zza();
        this.zzc = i;
    }

    public static zzlr zzd(zzje zzje) {
        return new zzlr(zzje, 0);
    }

    public static zzlr zze(zzje zzje, int i) {
        return new zzlr(zzje, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        zzkw zze = this.zza.zzi().zze();
        return (zze == null || zzar.zzb(zze.zzj())) ? "NA" : (String) Preconditions.checkNotNull(zze.zzj());
    }

    public final byte[] zzc(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(i == 0));
        this.zzb.zze(false);
        this.zza.zzh(this.zzb.zzl());
        try {
            zzma.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzhr.zza).ignoreNullValues(true).build().encode(this.zza.zzi()).getBytes("utf-8");
            }
            zzjf zzi = this.zza.zzi();
            zzde zzde = new zzde();
            zzhr.zza.configure(zzde);
            return zzde.zza().zza(zzi);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public final zzlr zzf(zzjc zzjc) {
        this.zza.zzd(zzjc);
        return this;
    }

    public final zzlr zzg(zzkv zzkv) {
        this.zzb = zzkv;
        return this;
    }
}
