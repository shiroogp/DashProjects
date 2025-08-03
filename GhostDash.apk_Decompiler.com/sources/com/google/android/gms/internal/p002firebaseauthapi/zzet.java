package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzet  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzet extends zzzw<zzet, zzes> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzet zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzet zzet = new zzet();
        zzb = zzet;
        zzzw.zzF(zzet.class, zzet);
    }

    private zzet() {
    }

    public static zzes zzb() {
        return (zzes) zzb.zzt();
    }

    public static zzet zzd() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzet();
        } else {
            if (i2 == 4) {
                return new zzes((zzer) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
