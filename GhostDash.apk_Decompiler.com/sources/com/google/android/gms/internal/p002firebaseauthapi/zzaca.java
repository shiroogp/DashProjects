package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaca  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzaca {
    private static final zzaca zza = new zzaca(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzaca() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaca(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzaca zzc() {
        return zza;
    }

    static zzaca zzd(zzaca zzaca, zzaca zzaca2) {
        int i = zzaca.zzb + zzaca2.zzb;
        int[] copyOf = Arrays.copyOf(zzaca.zzc, i);
        System.arraycopy(zzaca2.zzc, 0, copyOf, zzaca.zzb, zzaca2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzaca.zzd, i);
        System.arraycopy(zzaca2.zzd, 0, copyOf2, zzaca.zzb, zzaca2.zzb);
        return new zzaca(i, copyOf, copyOf2, true);
    }

    static zzaca zze() {
        return new zzaca(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaca)) {
            return false;
        }
        zzaca zzaca = (zzaca) obj;
        int i = this.zzb;
        if (i == zzaca.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzaca.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzaca.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i = zzze.zzE(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int zzE = zzze.zzE(i8 << 3);
                    int zzd2 = ((zzyu) this.zzd[i6]).zzd();
                    i5 += zzE + zzze.zzE(zzd2) + zzd2;
                } else if (i9 == 3) {
                    int zzD = zzze.zzD(i8);
                    i3 = zzD + zzD;
                    i2 = ((zzaca) this.zzd[i6]).zza();
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzze.zzE(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzaae.zza());
                }
                i5 += i;
            } else {
                long longValue = ((Long) this.zzd[i6]).longValue();
                i3 = zzze.zzE(i8 << 3);
                i2 = zzze.zzF(longValue);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int zzE = zzze.zzE(8);
            int zzd2 = ((zzyu) this.zzd[i3]).zzd();
            i2 += zzE + zzE + zzze.zzE(16) + zzze.zzE(i4 >>> 3) + zzze.zzE(24) + zzze.zzE(zzd2) + zzd2;
        }
        this.zze = i2;
        return i2;
    }

    public final void zzf() {
        this.zzf = false;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzabb.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            int[] iArr = this.zzc;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(iArr, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr2 = this.zzc;
            int i4 = this.zzb;
            iArr2[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zzzf zzzf) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzzf.zzt(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzzf.zzm(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzzf.zzd(i3, (zzyu) obj);
                } else if (i4 == 3) {
                    zzzf.zzE(i3);
                    ((zzaca) obj).zzi(zzzf);
                    zzzf.zzh(i3);
                } else if (i4 == 5) {
                    zzzf.zzk(i3, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzaae.zza());
                }
            }
        }
    }
}
