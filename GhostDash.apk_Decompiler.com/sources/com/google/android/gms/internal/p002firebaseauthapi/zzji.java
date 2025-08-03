package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzji  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzji extends zzzw<zzji, zzjh> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzji zzb;
    private String zze = "";
    private zzij zzf;

    static {
        zzji zzji = new zzji();
        zzb = zzji;
        zzzw.zzF(zzji.class, zzji);
    }

    private zzji() {
    }

    public static zzji zzc() {
        return zzb;
    }

    public static zzji zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzji) zzzw.zzw(zzb, zzyu, zzzj);
    }

    public final zzij zza() {
        zzij zzij = this.zzf;
        return zzij == null ? zzij.zzc() : zzij;
    }

    public final String zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return this.zzf != null;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzji();
        } else {
            if (i2 == 4) {
                return new zzjh((zzjg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
