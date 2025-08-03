package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzaq {
    private final zzij zza;

    private zzaq(zzij zzij) {
        this.zza = zzij;
    }

    public static zzaq zze(String str, byte[] bArr, int i) {
        zzjk zzjk;
        zzii zza2 = zzij.zza();
        zza2.zzb(str);
        zza2.zzc(zzyu.zzn(bArr));
        zzjk zzjk2 = zzjk.UNKNOWN_PREFIX;
        int i2 = i - 1;
        if (i2 != 0) {
            zzjk = i2 != 1 ? i2 != 2 ? zzjk.CRUNCHY : zzjk.RAW : zzjk.LEGACY;
        } else {
            zzjk = zzjk.TINK;
        }
        zza2.zza(zzjk);
        return new zzaq((zzij) zza2.zzk());
    }

    /* access modifiers changed from: package-private */
    public final zzij zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zza.zzf();
    }

    public final byte[] zzc() {
        return this.zza.zze().zzs();
    }

    public final int zzd() {
        zzjk zzd = this.zza.zzd();
        zzjk zzjk = zzjk.UNKNOWN_PREFIX;
        int ordinal = zzd.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
            }
        }
        return i;
    }
}
