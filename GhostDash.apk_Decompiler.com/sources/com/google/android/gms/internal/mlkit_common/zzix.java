package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzix extends zzjd {
    private String zza;
    private Boolean zzb;
    private Integer zzc;

    zzix() {
    }

    public final zzjd zza(boolean z) {
        this.zzb = true;
        return this;
    }

    public final zzjd zzb(int i) {
        this.zzc = 1;
        return this;
    }

    public final zzjd zzc(String str) {
        this.zza = "common";
        return this;
    }

    public final zzje zzd() {
        String str = this.zza == null ? " libraryName" : "";
        if (this.zzb == null) {
            str = str.concat(" enableFirelog");
        }
        if (this.zzc == null) {
            str = String.valueOf(str).concat(" firelogEventType");
        }
        if (str.isEmpty()) {
            return new zziy(this.zza, this.zzb.booleanValue(), this.zzc.intValue(), (zziw) null);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
