package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzjb extends zzjn {
    private final zzgu zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final ModelType zze;
    private final zzhb zzf;
    private final int zzg;

    /* synthetic */ zzjb(zzgu zzgu, String str, boolean z, boolean z2, ModelType modelType, zzhb zzhb, int i, zziz zziz) {
        this.zza = zzgu;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = modelType;
        this.zzf = zzhb;
        this.zzg = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzjn) {
            zzjn zzjn = (zzjn) obj;
            return this.zza.equals(zzjn.zzc()) && this.zzb.equals(zzjn.zze()) && this.zzc == zzjn.zzg() && this.zzd == zzjn.zzf() && this.zze.equals(zzjn.zzb()) && this.zzf.equals(zzjn.zzd()) && this.zzg == zzjn.zza();
        }
    }

    public final int hashCode() {
        int i = 1237;
        int hashCode = (((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003;
        if (true == this.zzd) {
            i = 1231;
        }
        return ((((((hashCode ^ i) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode()) * 1000003) ^ this.zzg;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String str = this.zzb;
        boolean z = this.zzc;
        boolean z2 = this.zzd;
        String valueOf2 = String.valueOf(this.zze);
        String valueOf3 = String.valueOf(this.zzf);
        int i = this.zzg;
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 187 + length2 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("RemoteModelLoggingOptions{errorCode=");
        sb.append(valueOf);
        sb.append(", tfliteSchemaVersion=");
        sb.append(str);
        sb.append(", shouldLogRoughDownloadTime=");
        sb.append(z);
        sb.append(", shouldLogExactDownloadTime=");
        sb.append(z2);
        sb.append(", modelType=");
        sb.append(valueOf2);
        sb.append(", downloadStatus=");
        sb.append(valueOf3);
        sb.append(", failureStatusCode=");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }

    public final int zza() {
        return this.zzg;
    }

    public final ModelType zzb() {
        return this.zze;
    }

    public final zzgu zzc() {
        return this.zza;
    }

    public final zzhb zzd() {
        return this.zzf;
    }

    public final String zze() {
        return this.zzb;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zzc;
    }
}
