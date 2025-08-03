package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzjc extends zzzw<zzjc, zzjb> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzjc zzb;
    private String zze = "";

    static {
        zzjc zzjc = new zzjc();
        zzb = zzjc;
        zzzw.zzF(zzjc.class, zzjc);
    }

    private zzjc() {
    }

    public static zzjc zzb() {
        return zzb;
    }

    public static zzjc zzc(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzjc) zzzw.zzw(zzb, zzyu, zzzj);
    }

    public final String zzd() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzjc();
        } else {
            if (i2 == 4) {
                return new zzjb((zzja) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
