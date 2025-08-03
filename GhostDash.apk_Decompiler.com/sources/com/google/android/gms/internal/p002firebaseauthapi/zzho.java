package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzho  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzho extends zzzw<zzho, zzhn> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzho zzb;
    /* access modifiers changed from: private */
    public zzyu zze = zzyu.zzb;
    private zziw zzf;

    static {
        zzho zzho = new zzho();
        zzb = zzho;
        zzzw.zzF(zzho.class, zzho);
    }

    private zzho() {
    }

    public static zzhn zza() {
        return (zzhn) zzb.zzt();
    }

    public static zzho zzc(byte[] bArr, zzzj zzzj) throws zzaae {
        return (zzho) zzzw.zzx(zzb, bArr, zzzj);
    }

    static /* synthetic */ void zzf(zzho zzho, zziw zziw) {
        zziw.getClass();
        zzho.zzf = zziw;
    }

    public final zzyu zzd() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzho();
        } else {
            if (i2 == 4) {
                return new zzhn((zzhm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
