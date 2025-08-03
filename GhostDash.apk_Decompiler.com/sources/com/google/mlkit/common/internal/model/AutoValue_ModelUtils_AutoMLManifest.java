package com.google.mlkit.common.internal.model;

import com.google.mlkit.common.internal.model.ModelUtils;
import java.util.Objects;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class AutoValue_ModelUtils_AutoMLManifest extends ModelUtils.AutoMLManifest {
    private final String zza;
    private final String zzb;
    private final String zzc;

    AutoValue_ModelUtils_AutoMLManifest(String str, String str2, String str3) {
        Objects.requireNonNull(str, "Null modelType");
        this.zza = str;
        Objects.requireNonNull(str2, "Null modelFile");
        this.zzb = str2;
        Objects.requireNonNull(str3, "Null labelsFile");
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.AutoMLManifest) {
            ModelUtils.AutoMLManifest autoMLManifest = (ModelUtils.AutoMLManifest) obj;
            return this.zza.equals(autoMLManifest.getModelType()) && this.zzb.equals(autoMLManifest.getModelFile()) && this.zzc.equals(autoMLManifest.getLabelsFile());
        }
    }

    public String getLabelsFile() {
        return this.zzc;
    }

    public String getModelFile() {
        return this.zzb;
    }

    public String getModelType() {
        return this.zza;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String str3 = this.zzc;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 51 + str2.length() + str3.length());
        sb.append("AutoMLManifest{modelType=");
        sb.append(str);
        sb.append(", modelFile=");
        sb.append(str2);
        sb.append(", labelsFile=");
        sb.append(str3);
        sb.append("}");
        return sb.toString();
    }
}
