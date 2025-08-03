package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzle extends zzlg {
    private String zza;
    private Boolean zzb;
    private Integer zzc;

    zzle() {
    }

    public final zzlg zza(boolean z) {
        this.zzb = true;
        return this;
    }

    public final zzlg zzb(int i) {
        this.zzc = 1;
        return this;
    }

    public final zzlg zzc(String str) {
        Objects.requireNonNull(str, "Null libraryName");
        this.zza = str;
        return this;
    }

    public final zzlh zzd() {
        Boolean bool;
        String str = this.zza;
        if (str != null && (bool = this.zzb) != null && this.zzc != null) {
            return new zzlf(str, bool.booleanValue(), this.zzc.intValue(), (zzld) null);
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
