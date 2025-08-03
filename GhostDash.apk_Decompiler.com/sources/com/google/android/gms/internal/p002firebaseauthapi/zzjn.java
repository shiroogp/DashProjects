package com.google.android.gms.internal.p002firebaseauthapi;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzjn extends zzzw<zzjn, zzjm> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzjn zzb;
    private String zze = "";
    private zzaab<zzim> zzf = zzz();

    static {
        zzjn zzjn = new zzjn();
        zzb = zzjn;
        zzzw.zzF(zzjn.class, zzjn);
    }

    private zzjn() {
    }

    public static zzjn zzb() {
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzim.class});
        } else if (i2 == 3) {
            return new zzjn();
        } else {
            if (i2 == 4) {
                return new zzjm((zzjl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
