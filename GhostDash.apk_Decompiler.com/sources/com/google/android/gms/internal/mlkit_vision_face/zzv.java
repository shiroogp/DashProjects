package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzv {
    private final String zza;
    private final zzu zzb;
    private zzu zzc;

    /* synthetic */ zzv(String str, zzs zzs) {
        zzu zzu = new zzu((zzs) null);
        this.zzb = zzu;
        this.zzc = zzu;
        this.zza = str;
    }

    private final zzv zze(String str, Object obj) {
        zzt zzt = new zzt((zzs) null);
        this.zzc.zzc = zzt;
        this.zzc = zzt;
        zzt.zzb = obj;
        zzt.zza = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzu zzu = this.zzb.zzc;
        String str = "";
        while (zzu != null) {
            Object obj = zzu.zzb;
            sb.append(str);
            String str2 = zzu.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzu = zzu.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzv zza(String str, float f) {
        zze(str, String.valueOf(f));
        return this;
    }

    public final zzv zzb(String str, int i) {
        zze(str, String.valueOf(i));
        return this;
    }

    public final zzv zzc(String str, @CheckForNull Object obj) {
        zzu zzu = new zzu((zzs) null);
        this.zzc.zzc = zzu;
        this.zzc = zzu;
        zzu.zzb = obj;
        Objects.requireNonNull(str);
        zzu.zza = str;
        return this;
    }

    public final zzv zzd(String str, boolean z) {
        zze("trackingEnabled", String.valueOf(z));
        return this;
    }
}
