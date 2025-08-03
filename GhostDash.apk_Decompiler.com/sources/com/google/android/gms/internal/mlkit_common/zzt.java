package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzt {
    private final String zza;
    private final zzs zzb;
    private zzs zzc;

    /* synthetic */ zzt(String str, zzr zzr) {
        zzs zzs = new zzs((zzr) null);
        this.zzb = zzs;
        this.zzc = zzs;
        Objects.requireNonNull(str);
        this.zza = str;
    }

    private final zzt zzc(String str, @NullableDecl Object obj) {
        zzs zzs = new zzs((zzr) null);
        this.zzc.zzc = zzs;
        this.zzc = zzs;
        zzs.zzb = obj;
        zzs.zza = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzs zzs = this.zzb.zzc;
        String str = "";
        while (zzs != null) {
            Object obj = zzs.zzb;
            sb.append(str);
            String str2 = zzs.zza;
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
            zzs = zzs.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzt zza(String str, @NullableDecl Object obj) {
        zzc(str, obj);
        return this;
    }

    public final zzt zzb(String str, boolean z) {
        zzc("isManifestFile", String.valueOf(z));
        return this;
    }
}
