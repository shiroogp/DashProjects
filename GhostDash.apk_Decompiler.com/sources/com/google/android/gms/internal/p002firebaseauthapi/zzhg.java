package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzhg extends zzzw<zzhg, zzhf> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzhg zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzha zzf;
    /* access modifiers changed from: private */
    public zzyu zzg = zzyu.zzb;
    /* access modifiers changed from: private */
    public zzyu zzh = zzyu.zzb;

    static {
        zzhg zzhg = new zzhg();
        zzb = zzhg;
        zzzw.zzF(zzhg.class, zzhg);
    }

    private zzhg() {
    }

    public static zzhf zzc() {
        return (zzhf) zzb.zzt();
    }

    public static zzhg zze() {
        return zzb;
    }

    public static zzhg zzf(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzhg) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzk(zzhg zzhg, zzha zzha) {
        zzha.getClass();
        zzhg.zzf = zzha;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzha zzb() {
        zzha zzha = this.zzf;
        return zzha == null ? zzha.zze() : zzha;
    }

    public final zzyu zzg() {
        return this.zzg;
    }

    public final zzyu zzh() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzhg();
        } else {
            if (i2 == 4) {
                return new zzhf((zzhe) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
