package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzgp extends zzzw<zzgp, zzgo> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzgp zzb;

    static {
        zzgp zzgp = new zzgp();
        zzb = zzgp;
        zzzw.zzF(zzgp.class, zzgp);
    }

    private zzgp() {
    }

    public static zzgp zzb() {
        return zzb;
    }

    public static zzgp zzc(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzgp) zzzw.zzw(zzb, zzyu, zzzj);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0000", (Object[]) null);
        }
        if (i2 == 3) {
            return new zzgp();
        }
        if (i2 == 4) {
            return new zzgo((zzgn) null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
