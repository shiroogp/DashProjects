package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzeq extends zzzw<zzeq, zzep> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzeq zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzet zzf;

    static {
        zzeq zzeq = new zzeq();
        zzb = zzeq;
        zzzw.zzF(zzeq.class, zzeq);
    }

    private zzeq() {
    }

    public static zzep zzb() {
        return (zzep) zzb.zzt();
    }

    public static zzeq zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzeq) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzg(zzeq zzeq, zzet zzet) {
        zzet.getClass();
        zzeq.zzf = zzet;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzet zze() {
        zzet zzet = this.zzf;
        return zzet == null ? zzet.zzd() : zzet;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzeq();
        } else {
            if (i2 == 4) {
                return new zzep((zzeo) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
