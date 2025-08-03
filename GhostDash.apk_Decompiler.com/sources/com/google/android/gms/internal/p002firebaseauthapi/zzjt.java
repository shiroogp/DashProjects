package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzjt extends zzzw<zzjt, zzjs> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzjt zzb;
    private int zze;

    static {
        zzjt zzjt = new zzjt();
        zzb = zzjt;
        zzzw.zzF(zzjt.class, zzjt);
    }

    private zzjt() {
    }

    public static zzjt zzb() {
        return zzb;
    }

    public static zzjt zzc(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzjt) zzzw.zzw(zzb, zzyu, zzzj);
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
            return new zzjt();
        } else {
            if (i2 == 4) {
                return new zzjs((zzjr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
