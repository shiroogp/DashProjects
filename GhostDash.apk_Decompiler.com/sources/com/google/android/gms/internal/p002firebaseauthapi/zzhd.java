package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzhd extends zzzw<zzhd, zzhc> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzhd zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzhg zzf;
    /* access modifiers changed from: private */
    public zzyu zzg = zzyu.zzb;

    static {
        zzhd zzhd = new zzhd();
        zzb = zzhd;
        zzzw.zzF(zzhd.class, zzhd);
    }

    private zzhd() {
    }

    public static zzhc zzb() {
        return (zzhc) zzb.zzt();
    }

    public static zzhd zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzhd) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzh(zzhd zzhd, zzhg zzhg) {
        zzhg.getClass();
        zzhd.zzf = zzhg;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzhg zze() {
        zzhg zzhg = this.zzf;
        return zzhg == null ? zzhg.zze() : zzhg;
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
            return new zzhd();
        } else {
            if (i2 == 4) {
                return new zzhc((zzhb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
