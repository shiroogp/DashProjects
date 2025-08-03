package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;
import java.util.Objects;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzja extends zzjm {
    private zzgu zza;
    private String zzb;
    private Boolean zzc;
    private Boolean zzd;
    private ModelType zze;
    private zzhb zzf;
    private Integer zzg;

    zzja() {
    }

    public final zzjm zza(zzhb zzhb) {
        Objects.requireNonNull(zzhb, "Null downloadStatus");
        this.zzf = zzhb;
        return this;
    }

    public final zzjm zzb(zzgu zzgu) {
        Objects.requireNonNull(zzgu, "Null errorCode");
        this.zza = zzgu;
        return this;
    }

    public final zzjm zzc(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    public final zzjm zzd(ModelType modelType) {
        Objects.requireNonNull(modelType, "Null modelType");
        this.zze = modelType;
        return this;
    }

    public final zzjm zze(boolean z) {
        this.zzd = Boolean.valueOf(z);
        return this;
    }

    public final zzjm zzf(boolean z) {
        this.zzc = Boolean.valueOf(z);
        return this;
    }

    public final zzjm zzg(String str) {
        this.zzb = "NA";
        return this;
    }

    public final zzjn zzh() {
        String str = this.zza == null ? " errorCode" : "";
        if (this.zzb == null) {
            str = str.concat(" tfliteSchemaVersion");
        }
        if (this.zzc == null) {
            str = String.valueOf(str).concat(" shouldLogRoughDownloadTime");
        }
        if (this.zzd == null) {
            str = String.valueOf(str).concat(" shouldLogExactDownloadTime");
        }
        if (this.zze == null) {
            str = String.valueOf(str).concat(" modelType");
        }
        if (this.zzf == null) {
            str = String.valueOf(str).concat(" downloadStatus");
        }
        if (this.zzg == null) {
            str = String.valueOf(str).concat(" failureStatusCode");
        }
        if (str.isEmpty()) {
            return new zzjb(this.zza, this.zzb, this.zzc.booleanValue(), this.zzd.booleanValue(), this.zze, this.zzf, this.zzg.intValue(), (zziz) null);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
