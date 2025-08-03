package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzld {
    private final zziv zza;
    private zzkk zzb = new zzkk();
    private final int zzc;

    private zzld(zziv zziv, int i) {
        this.zza = zziv;
        zzlm.zza();
        this.zzc = i;
    }

    public static zzld zzd(zziv zziv) {
        return new zzld(zziv, 0);
    }

    public static zzld zze(zziv zziv, int i) {
        return new zzld(zziv, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        zzkl zze = this.zza.zzi().zze();
        return (zze == null || zzac.zzb(zze.zzj())) ? "NA" : (String) Preconditions.checkNotNull(zze.zzj());
    }

    public final byte[] zzc(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(i == 0));
        this.zzb.zze(false);
        this.zza.zzh(this.zzb.zzl());
        try {
            zzlm.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzhc.zza).ignoreNullValues(true).build().encode(this.zza.zzi()).getBytes("utf-8");
            }
            zziw zzi = this.zza.zzi();
            zzcp zzcp = new zzcp();
            zzhc.zza.configure(zzcp);
            return zzcp.zza().zza(zzi);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public final zzld zzf(zzit zzit) {
        this.zza.zzd(zzit);
        return this;
    }

    public final zzld zzg(zzkk zzkk) {
        this.zzb = zzkk;
        return this;
    }
}
