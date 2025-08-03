package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzhj extends zzzw<zzhj, zzhi> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzhj zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public zzyu zzg = zzyu.zzb;

    static {
        zzhj zzhj = new zzhj();
        zzb = zzhj;
        zzzw.zzF(zzhj.class, zzhj);
    }

    private zzhj() {
    }

    public static zzhi zza() {
        return (zzhi) zzb.zzt();
    }

    public static zzhj zzc() {
        return zzb;
    }

    public final zzhl zzd() {
        zzhl zzb2 = zzhl.zzb(this.zze);
        return zzb2 == null ? zzhl.UNRECOGNIZED : zzb2;
    }

    public final zzhq zze() {
        zzhq zzb2 = zzhq.zzb(this.zzf);
        return zzb2 == null ? zzhq.UNRECOGNIZED : zzb2;
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
            return zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzhj();
        } else {
            if (i2 == 4) {
                return new zzhi((zzhh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
