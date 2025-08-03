package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzfl extends zzzw<zzfl, zzfk> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzfl zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzfr zzf;
    /* access modifiers changed from: private */
    public zzyu zzg = zzyu.zzb;

    static {
        zzfl zzfl = new zzfl();
        zzb = zzfl;
        zzzw.zzF(zzfl.class, zzfl);
    }

    private zzfl() {
    }

    public static zzfk zzb() {
        return (zzfk) zzb.zzt();
    }

    public static zzfl zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzfl) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzh(zzfl zzfl, zzfr zzfr) {
        zzfr.getClass();
        zzfl.zzf = zzfr;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzfr zze() {
        zzfr zzfr = this.zzf;
        return zzfr == null ? zzfr.zzd() : zzfr;
    }

    public final zzyu zzf() {
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
            return new zzfl();
        } else {
            if (i2 == 4) {
                return new zzfk((zzfj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
