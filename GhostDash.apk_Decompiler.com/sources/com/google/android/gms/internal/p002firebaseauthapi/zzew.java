package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzew  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzew extends zzzw<zzew, zzev> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzew zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzfc zzf;
    private zzht zzg;

    static {
        zzew zzew = new zzew();
        zzb = zzew;
        zzzw.zzF(zzew.class, zzew);
    }

    private zzew() {
    }

    public static zzev zzb() {
        return (zzev) zzb.zzt();
    }

    public static zzew zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzew) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzh(zzew zzew, zzfc zzfc) {
        zzfc.getClass();
        zzew.zzf = zzfc;
    }

    static /* synthetic */ void zzi(zzew zzew, zzht zzht) {
        zzht.getClass();
        zzew.zzg = zzht;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzfc zze() {
        zzfc zzfc = this.zzf;
        return zzfc == null ? zzfc.zzd() : zzfc;
    }

    public final zzht zzf() {
        zzht zzht = this.zzg;
        return zzht == null ? zzht.zzd() : zzht;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzew();
        } else {
            if (i2 == 4) {
                return new zzev((zzeu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
