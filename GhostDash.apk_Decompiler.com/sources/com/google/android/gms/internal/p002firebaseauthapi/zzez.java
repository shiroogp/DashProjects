package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzez  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzez extends zzzw<zzez, zzey> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzez zzb;
    private zzff zze;
    private zzhw zzf;

    static {
        zzez zzez = new zzez();
        zzb = zzez;
        zzzw.zzF(zzez.class, zzez);
    }

    private zzez() {
    }

    public static zzey zza() {
        return (zzey) zzb.zzt();
    }

    public static zzez zzc(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzez) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzf(zzez zzez, zzff zzff) {
        zzff.getClass();
        zzez.zze = zzff;
    }

    static /* synthetic */ void zzg(zzez zzez, zzhw zzhw) {
        zzhw.getClass();
        zzez.zzf = zzhw;
    }

    public final zzff zzd() {
        zzff zzff = this.zze;
        return zzff == null ? zzff.zzd() : zzff;
    }

    public final zzhw zze() {
        zzhw zzhw = this.zzf;
        return zzhw == null ? zzhw.zzd() : zzhw;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzez();
        } else {
            if (i2 == 4) {
                return new zzey((zzex) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
