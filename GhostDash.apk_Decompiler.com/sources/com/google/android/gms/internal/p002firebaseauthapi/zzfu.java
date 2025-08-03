package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzfu extends zzzw<zzfu, zzft> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzfu zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzyu zzf = zzyu.zzb;

    static {
        zzfu zzfu = new zzfu();
        zzb = zzfu;
        zzzw.zzF(zzfu.class, zzfu);
    }

    private zzfu() {
    }

    public static zzft zzb() {
        return (zzft) zzb.zzt();
    }

    public static zzfu zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzfu) zzzw.zzw(zzb, zzyu, zzzj);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzyu zze() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfu();
        } else {
            if (i2 == 4) {
                return new zzft((zzfs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
