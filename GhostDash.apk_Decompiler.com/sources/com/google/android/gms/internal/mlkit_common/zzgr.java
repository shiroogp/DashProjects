package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public enum zzgr implements zzau {
    UNKNOWN(0),
    TRANSLATE(1);
    
    private final int zzd;

    private zzgr(int i) {
        this.zzd = i;
    }

    public static zzgr zzb(int i) {
        for (zzgr zzgr : values()) {
            if (zzgr.zzd == i) {
                return zzgr;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.zzd;
    }
}
