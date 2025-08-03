package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzho extends zzhq {
    private String zza;
    private Boolean zzb;
    private Integer zzc;

    zzho() {
    }

    public final zzhq zza(boolean z) {
        this.zzb = true;
        return this;
    }

    public final zzhq zzb(int i) {
        this.zzc = 1;
        return this;
    }

    public final zzhq zzc(String str) {
        this.zza = "vision-common";
        return this;
    }

    public final zzhr zzd() {
        Boolean bool;
        String str = this.zza;
        if (str != null && (bool = this.zzb) != null && this.zzc != null) {
            return new zzhp(str, bool.booleanValue(), this.zzc.intValue(), (zzhn) null);
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
