package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzfc extends zzzw<zzfc, zzfb> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzfc zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzfi zzf;
    /* access modifiers changed from: private */
    public zzyu zzg = zzyu.zzb;

    static {
        zzfc zzfc = new zzfc();
        zzb = zzfc;
        zzzw.zzF(zzfc.class, zzfc);
    }

    private zzfc() {
    }

    public static zzfb zzb() {
        return (zzfb) zzb.zzt();
    }

    public static zzfc zzd() {
        return zzb;
    }

    public static zzfc zze(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzfc) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzi(zzfc zzfc, zzfi zzfi) {
        zzfi.getClass();
        zzfc.zzf = zzfi;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzfi zzf() {
        zzfi zzfi = this.zzf;
        return zzfi == null ? zzfi.zzd() : zzfi;
    }

    public final zzyu zzg() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfc();
        } else {
            if (i2 == 4) {
                return new zzfb((zzfa) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
