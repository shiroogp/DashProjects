package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzfx extends zzzw<zzfx, zzfw> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzfx zzb;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzfx zzfx = new zzfx();
        zzb = zzfx;
        zzzw.zzF(zzfx.class, zzfx);
    }

    private zzfx() {
    }

    public static zzfw zzb() {
        return (zzfw) zzb.zzt();
    }

    public static zzfx zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzfx) zzzw.zzw(zzb, zzyu, zzzj);
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
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfx();
        } else {
            if (i2 == 4) {
                return new zzfw((zzfv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
