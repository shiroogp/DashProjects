package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzkq extends zzks {
    private String zza;
    private Boolean zzb;
    private Integer zzc;

    zzkq() {
    }

    public final zzks zza(boolean z) {
        this.zzb = true;
        return this;
    }

    public final zzks zzb(int i) {
        this.zzc = 1;
        return this;
    }

    public final zzks zzc(String str) {
        Objects.requireNonNull(str, "Null libraryName");
        this.zza = str;
        return this;
    }

    public final zzkt zzd() {
        Boolean bool;
        String str = this.zza;
        if (str != null && (bool = this.zzb) != null && this.zzc != null) {
            return new zzkr(str, bool.booleanValue(), this.zzc.intValue(), (zzkp) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" libraryName");
        }
        if (this.zzb == null) {
            sb.append(" enableFirelog");
        }
        if (this.zzc == null) {
            sb.append(" firelogEventType");
        }
        String valueOf = String.valueOf(sb);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 28);
        sb2.append("Missing required properties:");
        sb2.append(valueOf);
        throw new IllegalStateException(sb2.toString());
    }
}
