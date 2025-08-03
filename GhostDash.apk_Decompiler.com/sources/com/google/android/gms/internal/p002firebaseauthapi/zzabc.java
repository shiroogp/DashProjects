package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzabc<T> implements zzabl<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzacj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzaaz zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzaan zzn;
    private final zzabz<?, ?> zzo;
    private final zzzk<?> zzp;
    private final zzabe zzq;
    private final zzaau zzr;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaaz} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.google.android.gms.internal.firebase-auth-api.zzabe} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaau} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.firebase-auth-api.zzzk<?>, com.google.android.gms.internal.firebase-auth-api.zzzk] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [int] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.firebase-auth-api.zzaan] */
    /* JADX WARNING: type inference failed for: r3v13, types: [com.google.android.gms.internal.firebase-auth-api.zzabz<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzabc(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.p002firebaseauthapi.zzaaz r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.p002firebaseauthapi.zzabe r17, com.google.android.gms.internal.p002firebaseauthapi.zzaan r18, com.google.android.gms.internal.p002firebaseauthapi.zzabz<?, ?> r19, com.google.android.gms.internal.p002firebaseauthapi.zzzk<?> r20, com.google.android.gms.internal.p002firebaseauthapi.zzaau r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            boolean r3 = r1 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzzw
            r0.zzi = r3
            r3 = r11
            r0.zzj = r3
            r3 = 0
            if (r2 == 0) goto L_0x0024
            boolean r4 = r2.zzh(r10)
            if (r4 == 0) goto L_0x0024
            r3 = 1
        L_0x0024:
            r0.zzh = r3
            r3 = r13
            r0.zzk = r3
            r3 = r14
            r0.zzl = r3
            r3 = r15
            r0.zzm = r3
            r3 = r16
            r0.zzq = r3
            r3 = r17
            r0.zzn = r3
            r3 = r18
            r0.zzo = r3
            r0.zzp = r2
            r0.zzg = r1
            r1 = r20
            r0.zzr = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.firebase-auth-api.zzaaz, boolean, boolean, int[], int, int, com.google.android.gms.internal.firebase-auth-api.zzabe, com.google.android.gms.internal.firebase-auth-api.zzaan, com.google.android.gms.internal.firebase-auth-api.zzabz, com.google.android.gms.internal.firebase-auth-api.zzzk, com.google.android.gms.internal.firebase-auth-api.zzaau, byte[]):void");
    }

    private final int zzA(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzB(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzC(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzD(T t, long j) {
        return ((Long) zzacj.zzf(t, j)).longValue();
    }

    private final zzaaa zzE(int i) {
        int i2 = i / 3;
        return (zzaaa) this.zzd[i2 + i2 + 1];
    }

    private final zzabl zzF(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzabl zzabl = (zzabl) this.zzd[i3];
        if (zzabl != null) {
            return zzabl;
        }
        zzabl zzb2 = zzabh.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final <UT, UB> UB zzG(Object obj, int i, UB ub, zzabz<UT, UB> zzabz) {
        int i2 = this.zzc[i];
        Object zzf2 = zzacj.zzf(obj, (long) (zzC(i) & 1048575));
        if (zzf2 == null || zzE(i) == null) {
            return ub;
        }
        zzaat zzaat = (zzaat) zzf2;
        zzaas zzaas = (zzaas) zzH(i);
        throw null;
    }

    private final Object zzH(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzI(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzJ(T t, T t2, int i) {
        long zzC = (long) (zzC(i) & 1048575);
        if (zzQ(t2, i)) {
            Object zzf2 = zzacj.zzf(t, zzC);
            Object zzf3 = zzacj.zzf(t2, zzC);
            if (zzf2 != null && zzf3 != null) {
                zzacj.zzs(t, zzC, zzaac.zzg(zzf2, zzf3));
                zzM(t, i);
            } else if (zzf3 != null) {
                zzacj.zzs(t, zzC, zzf3);
                zzM(t, i);
            }
        }
    }

    private final void zzK(T t, T t2, int i) {
        int zzC = zzC(i);
        int i2 = this.zzc[i];
        long j = (long) (zzC & 1048575);
        if (zzT(t2, i2, i)) {
            Object zzf2 = zzT(t, i2, i) ? zzacj.zzf(t, j) : null;
            Object zzf3 = zzacj.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzacj.zzs(t, j, zzaac.zzg(zzf2, zzf3));
                zzN(t, i2, i);
            } else if (zzf3 != null) {
                zzacj.zzs(t, j, zzf3);
                zzN(t, i2, i);
            }
        }
    }

    private final void zzL(Object obj, int i, zzabk zzabk) throws IOException {
        if (zzP(i)) {
            zzacj.zzs(obj, (long) (i & 1048575), zzabk.zzu());
        } else if (this.zzi) {
            zzacj.zzs(obj, (long) (i & 1048575), zzabk.zzt());
        } else {
            zzacj.zzs(obj, (long) (i & 1048575), zzabk.zzp());
        }
    }

    private final void zzM(T t, int i) {
        int zzz = zzz(i);
        long j = (long) (1048575 & zzz);
        if (j != 1048575) {
            zzacj.zzq(t, j, (1 << (zzz >>> 20)) | zzacj.zzc(t, j));
        }
    }

    private final void zzN(T t, int i, int i2) {
        zzacj.zzq(t, (long) (zzz(i2) & 1048575), i);
    }

    private final boolean zzO(T t, T t2, int i) {
        return zzQ(t, i) == zzQ(t2, i);
    }

    private static boolean zzP(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzQ(T t, int i) {
        int zzz = zzz(i);
        long j = (long) (zzz & 1048575);
        if (j != 1048575) {
            return (zzacj.zzc(t, j) & (1 << (zzz >>> 20))) != 0;
        }
        int zzC = zzC(i);
        long j2 = (long) (zzC & 1048575);
        switch (zzB(zzC)) {
            case 0:
                return zzacj.zza(t, j2) != 0.0d;
            case 1:
                return zzacj.zzb(t, j2) != 0.0f;
            case 2:
                return zzacj.zzd(t, j2) != 0;
            case 3:
                return zzacj.zzd(t, j2) != 0;
            case 4:
                return zzacj.zzc(t, j2) != 0;
            case 5:
                return zzacj.zzd(t, j2) != 0;
            case 6:
                return zzacj.zzc(t, j2) != 0;
            case 7:
                return zzacj.zzw(t, j2);
            case 8:
                Object zzf2 = zzacj.zzf(t, j2);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zzyu) {
                    return !zzyu.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzacj.zzf(t, j2) != null;
            case 10:
                return !zzyu.zzb.equals(zzacj.zzf(t, j2));
            case 11:
                return zzacj.zzc(t, j2) != 0;
            case 12:
                return zzacj.zzc(t, j2) != 0;
            case 13:
                return zzacj.zzc(t, j2) != 0;
            case 14:
                return zzacj.zzd(t, j2) != 0;
            case 15:
                return zzacj.zzc(t, j2) != 0;
            case 16:
                return zzacj.zzd(t, j2) != 0;
            case 17:
                return zzacj.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzR(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzQ(t, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzS(Object obj, int i, zzabl zzabl) {
        return zzabl.zzk(zzacj.zzf(obj, (long) (i & 1048575)));
    }

    private final boolean zzT(T t, int i, int i2) {
        return zzacj.zzc(t, (long) (zzz(i2) & 1048575)) == i;
    }

    private static <T> boolean zzU(T t, long j) {
        return ((Boolean) zzacj.zzf(t, j)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044e, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029d, code lost:
        r12 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzV(T r17, com.google.android.gms.internal.p002firebaseauthapi.zzzf r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x045f
            int[] r3 = r0.zzc
            int r3 = r3.length
            sun.misc.Unsafe r4 = zzb
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r5
            r7 = 0
            r8 = 0
        L_0x0015:
            if (r7 >= r3) goto L_0x0455
            int r10 = r0.zzC(r7)
            int[] r11 = r0.zzc
            r11 = r11[r7]
            int r12 = zzB(r10)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x003d
            int[] r13 = r0.zzc
            int r15 = r7 + 2
            r13 = r13[r15]
            r15 = r13 & r5
            if (r15 == r9) goto L_0x0038
            long r8 = (long) r15
            int r8 = r4.getInt(r1, r8)
            r9 = r15
        L_0x0038:
            int r13 = r13 >>> 20
            int r13 = r14 << r13
            goto L_0x003e
        L_0x003d:
            r13 = 0
        L_0x003e:
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r12) {
                case 0: goto L_0x0442;
                case 1: goto L_0x0435;
                case 2: goto L_0x0428;
                case 3: goto L_0x041b;
                case 4: goto L_0x040e;
                case 5: goto L_0x0401;
                case 6: goto L_0x03f4;
                case 7: goto L_0x03e7;
                case 8: goto L_0x03d9;
                case 9: goto L_0x03c7;
                case 10: goto L_0x03b7;
                case 11: goto L_0x03a9;
                case 12: goto L_0x039b;
                case 13: goto L_0x038d;
                case 14: goto L_0x037f;
                case 15: goto L_0x0371;
                case 16: goto L_0x0363;
                case 17: goto L_0x0351;
                case 18: goto L_0x0341;
                case 19: goto L_0x0331;
                case 20: goto L_0x0321;
                case 21: goto L_0x0311;
                case 22: goto L_0x0301;
                case 23: goto L_0x02f1;
                case 24: goto L_0x02e1;
                case 25: goto L_0x02d1;
                case 26: goto L_0x02c2;
                case 27: goto L_0x02af;
                case 28: goto L_0x02a0;
                case 29: goto L_0x028f;
                case 30: goto L_0x0280;
                case 31: goto L_0x0271;
                case 32: goto L_0x0262;
                case 33: goto L_0x0253;
                case 34: goto L_0x0244;
                case 35: goto L_0x0235;
                case 36: goto L_0x0226;
                case 37: goto L_0x0217;
                case 38: goto L_0x0208;
                case 39: goto L_0x01f9;
                case 40: goto L_0x01ea;
                case 41: goto L_0x01db;
                case 42: goto L_0x01cc;
                case 43: goto L_0x01bd;
                case 44: goto L_0x01ae;
                case 45: goto L_0x019f;
                case 46: goto L_0x0190;
                case 47: goto L_0x0181;
                case 48: goto L_0x0172;
                case 49: goto L_0x015f;
                case 50: goto L_0x0156;
                case 51: goto L_0x0147;
                case 52: goto L_0x0138;
                case 53: goto L_0x0129;
                case 54: goto L_0x011a;
                case 55: goto L_0x010b;
                case 56: goto L_0x00fc;
                case 57: goto L_0x00ed;
                case 58: goto L_0x00de;
                case 59: goto L_0x00cf;
                case 60: goto L_0x00bc;
                case 61: goto L_0x00ac;
                case 62: goto L_0x009e;
                case 63: goto L_0x0090;
                case 64: goto L_0x0082;
                case 65: goto L_0x0074;
                case 66: goto L_0x0066;
                case 67: goto L_0x0058;
                case 68: goto L_0x0046;
                default: goto L_0x0043;
            }
        L_0x0043:
            r12 = 0
            goto L_0x044e
        L_0x0046:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.firebase-auth-api.zzabl r6 = r0.zzF(r7)
            r2.zzq(r11, r5, r6)
            goto L_0x0043
        L_0x0058:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzC(r11, r5)
            goto L_0x0043
        L_0x0066:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzA(r11, r5)
            goto L_0x0043
        L_0x0074:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzy(r11, r5)
            goto L_0x0043
        L_0x0082:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzw(r11, r5)
            goto L_0x0043
        L_0x0090:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzi(r11, r5)
            goto L_0x0043
        L_0x009e:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzH(r11, r5)
            goto L_0x0043
        L_0x00ac:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.firebase-auth-api.zzyu r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r5
            r2.zzd(r11, r5)
            goto L_0x0043
        L_0x00bc:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.firebase-auth-api.zzabl r6 = r0.zzF(r7)
            r2.zzv(r11, r5, r6)
            goto L_0x0043
        L_0x00cf:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzX(r11, r5, r2)
            goto L_0x0043
        L_0x00de:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            boolean r5 = zzU(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x0043
        L_0x00ed:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzk(r11, r5)
            goto L_0x0043
        L_0x00fc:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzm(r11, r5)
            goto L_0x0043
        L_0x010b:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzr(r11, r5)
            goto L_0x0043
        L_0x011a:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzJ(r11, r5)
            goto L_0x0043
        L_0x0129:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzt(r11, r5)
            goto L_0x0043
        L_0x0138:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            float r5 = zzp(r1, r5)
            r2.zzo(r11, r5)
            goto L_0x0043
        L_0x0147:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            double r5 = zzo(r1, r5)
            r2.zzf(r11, r5)
            goto L_0x0043
        L_0x0156:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.zzW(r2, r11, r5, r7)
            goto L_0x0043
        L_0x015f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.firebase-auth-api.zzabl r6 = r0.zzF(r7)
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzQ(r10, r5, r2, r6)
            goto L_0x0043
        L_0x0172:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzX(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0181:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzW(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0190:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzV(r10, r5, r2, r14)
            goto L_0x0043
        L_0x019f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzU(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ae:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzM(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01bd:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzZ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01cc:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzJ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01db:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzN(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ea:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzO(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01f9:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzR(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0208:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzaa(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0217:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzS(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0226:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzP(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0235:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzL(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0244:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzX(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0253:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzW(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0262:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzV(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0271:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzU(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0280:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzM(r10, r5, r2, r11)
            goto L_0x029d
        L_0x028f:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzZ(r10, r5, r2, r11)
        L_0x029d:
            r12 = r11
            goto L_0x044e
        L_0x02a0:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzK(r10, r5, r2)
            goto L_0x0043
        L_0x02af:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.firebase-auth-api.zzabl r6 = r0.zzF(r7)
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzT(r10, r5, r2, r6)
            goto L_0x0043
        L_0x02c2:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzY(r10, r5, r2)
            goto L_0x0043
        L_0x02d1:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzJ(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02e1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzN(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02f1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzO(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0301:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzR(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0311:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzaa(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0321:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzS(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0331:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzP(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0341:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzL(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0351:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.firebase-auth-api.zzabl r6 = r0.zzF(r7)
            r2.zzq(r11, r5, r6)
            goto L_0x044e
        L_0x0363:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzC(r11, r5)
            goto L_0x044e
        L_0x0371:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzA(r11, r5)
            goto L_0x044e
        L_0x037f:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzy(r11, r5)
            goto L_0x044e
        L_0x038d:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzw(r11, r5)
            goto L_0x044e
        L_0x039b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzi(r11, r5)
            goto L_0x044e
        L_0x03a9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzH(r11, r5)
            goto L_0x044e
        L_0x03b7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.firebase-auth-api.zzyu r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r5
            r2.zzd(r11, r5)
            goto L_0x044e
        L_0x03c7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.firebase-auth-api.zzabl r6 = r0.zzF(r7)
            r2.zzv(r11, r5, r6)
            goto L_0x044e
        L_0x03d9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzX(r11, r5, r2)
            goto L_0x044e
        L_0x03e7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            boolean r5 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzw(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x044e
        L_0x03f4:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzk(r11, r5)
            goto L_0x044e
        L_0x0401:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzm(r11, r5)
            goto L_0x044e
        L_0x040e:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzr(r11, r5)
            goto L_0x044e
        L_0x041b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzJ(r11, r5)
            goto L_0x044e
        L_0x0428:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzt(r11, r5)
            goto L_0x044e
        L_0x0435:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            float r5 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzb(r1, r5)
            r2.zzo(r11, r5)
            goto L_0x044e
        L_0x0442:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            double r5 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zza(r1, r5)
            r2.zzf(r11, r5)
        L_0x044e:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0455:
            com.google.android.gms.internal.firebase-auth-api.zzabz<?, ?> r3 = r0.zzo
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzr(r1, r2)
            return
        L_0x045f:
            com.google.android.gms.internal.firebase-auth-api.zzzk<?> r2 = r0.zzp
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzV(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzzf):void");
    }

    private final <K, V> void zzW(zzzf zzzf, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzaas zzaas = (zzaas) zzH(i2);
            throw null;
        }
    }

    private static final void zzX(int i, Object obj, zzzf zzzf) throws IOException {
        if (obj instanceof String) {
            zzzf.zzF(i, (String) obj);
        } else {
            zzzf.zzd(i, (zzyu) obj);
        }
    }

    static zzaca zzd(Object obj) {
        zzzw zzzw = (zzzw) obj;
        zzaca zzaca = zzzw.zzc;
        if (zzaca != zzaca.zzc()) {
            return zzaca;
        }
        zzaca zze2 = zzaca.zze();
        zzzw.zzc = zze2;
        return zze2;
    }

    static <T> zzabc<T> zzl(Class<T> cls, zzaaw zzaaw, zzabe zzabe, zzaan zzaan, zzabz<?, ?> zzabz, zzzk<?> zzzk, zzaau zzaau) {
        if (zzaaw instanceof zzabj) {
            return zzm((zzabj) zzaaw, zzabe, zzaan, zzabz, zzzk, zzaau);
        }
        zzabw zzabw = (zzabw) zzaaw;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0379  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.p002firebaseauthapi.zzabc<T> zzm(com.google.android.gms.internal.p002firebaseauthapi.zzabj r34, com.google.android.gms.internal.p002firebaseauthapi.zzabe r35, com.google.android.gms.internal.p002firebaseauthapi.zzaan r36, com.google.android.gms.internal.p002firebaseauthapi.zzabz<?, ?> r37, com.google.android.gms.internal.p002firebaseauthapi.zzzk<?> r38, com.google.android.gms.internal.p002firebaseauthapi.zzaau r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r1
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = zza
            r8 = r1
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.firebase-auth-api.zzaaz r18 = r34.zza()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0194:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a6
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0194
        L_0x01a6:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ae
        L_0x01ac:
            r2 = r24
        L_0x01ae:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01db
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d5
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bc
        L_0x01d5:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r3
            r3 = r24
        L_0x01df:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x0296
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0223
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0248
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x0248
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0257
            if (r10 != 0) goto L_0x0257
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0255
        L_0x0248:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0255:
            r16 = r14
        L_0x0257:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0261
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0269
        L_0x0261:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzI(r1, r12)
            r17[r3] = r12
        L_0x0269:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r3 = r3 + 1
            r8 = r17[r3]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027c
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0284
        L_0x027c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzI(r1, r8)
            r17[r3] = r8
        L_0x0284:
            r3 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r8 = r1
            r0 = r7
            r29 = r11
            r25 = 1
            r7 = r3
            r3 = 0
            goto L_0x0391
        L_0x0296:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzI(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030e
            r12 = 17
            if (r5 != r12) goto L_0x02ae
            goto L_0x030e
        L_0x02ae:
            r12 = 27
            if (r5 == r12) goto L_0x02fe
            r12 = 49
            if (r5 != r12) goto L_0x02b7
            goto L_0x02fe
        L_0x02b7:
            r12 = 12
            if (r5 == r12) goto L_0x02ee
            r12 = 30
            if (r5 == r12) goto L_0x02ee
            r12 = 44
            if (r5 != r12) goto L_0x02c4
            goto L_0x02ee
        L_0x02c4:
            r12 = 50
            if (r5 != r12) goto L_0x02e4
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e7
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e4:
            r25 = 1
            goto L_0x031b
        L_0x02e7:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031c
        L_0x02ee:
            if (r10 != 0) goto L_0x02e4
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030b
        L_0x02fe:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030b:
            r12 = r27
            goto L_0x031c
        L_0x030e:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031b:
            r12 = r7
        L_0x031c:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x0379
            r8 = 17
            if (r5 > r8) goto L_0x0379
            int r8 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0355
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033f:
            int r27 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0351
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r26
            r3 = r3 | r8
            int r26 = r26 + 13
            r8 = r27
            goto L_0x033f
        L_0x0351:
            int r8 = r8 << r26
            r3 = r3 | r8
            goto L_0x0357
        L_0x0355:
            r27 = r8
        L_0x0357:
            int r8 = r6 + r6
            int r26 = r3 / 32
            int r8 = r8 + r26
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0368
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x0370
        L_0x0368:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzI(r1, r11)
            r17[r8] = r11
        L_0x0370:
            r8 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r0 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0379:
            r30 = r0
            r8 = r1
            r0 = r27
            r27 = r3
            r3 = 0
        L_0x0381:
            r1 = 18
            if (r5 < r1) goto L_0x038f
            r1 = 49
            if (r5 > r1) goto L_0x038f
            int r1 = r23 + 1
            r13[r23] = r7
            r23 = r1
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r1 = r9 + 1
            r31[r9] = r4
            int r4 = r1 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r7
            r31[r1] = r2
            int r9 = r4 + 1
            int r1 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r8
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.firebase-auth-api.zzabc r0 = new com.google.android.gms.internal.firebase-auth-api.zzabc
            r4 = r0
            com.google.android.gms.internal.firebase-auth-api.zzaaz r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzm(com.google.android.gms.internal.firebase-auth-api.zzabj, com.google.android.gms.internal.firebase-auth-api.zzabe, com.google.android.gms.internal.firebase-auth-api.zzaan, com.google.android.gms.internal.firebase-auth-api.zzabz, com.google.android.gms.internal.firebase-auth-api.zzzk, com.google.android.gms.internal.firebase-auth-api.zzaau):com.google.android.gms.internal.firebase-auth-api.zzabc");
    }

    private static <T> double zzo(T t, long j) {
        return ((Double) zzacj.zzf(t, j)).doubleValue();
    }

    private static <T> float zzp(T t, long j) {
        return ((Float) zzacj.zzf(t, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0302, code lost:
        r8 = r8 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0469, code lost:
        r8 = r8 + (r9 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04b3, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04de, code lost:
        r8 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04df, code lost:
        r4 = r4 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0506, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0513, code lost:
        r7 = r7 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0521, code lost:
        r7 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0525, code lost:
        r3 = r3 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r2 = 0
            r6 = r1
            r3 = r2
            r4 = r3
            r5 = r4
        L_0x000a:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x0529
            int r7 = r14.zzC(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzB(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0035
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r1
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0036
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0036
        L_0x0035:
            r10 = r2
        L_0x0036:
            r7 = r7 & r1
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0517;
                case 1: goto L_0x0509;
                case 2: goto L_0x04f4;
                case 3: goto L_0x04e1;
                case 4: goto L_0x04cc;
                case 5: goto L_0x04c1;
                case 6: goto L_0x04b6;
                case 7: goto L_0x04a9;
                case 8: goto L_0x047f;
                case 9: goto L_0x046d;
                case 10: goto L_0x0451;
                case 11: goto L_0x043d;
                case 12: goto L_0x0429;
                case 13: goto L_0x041d;
                case 14: goto L_0x0411;
                case 15: goto L_0x03f8;
                case 16: goto L_0x03e0;
                case 17: goto L_0x03cd;
                case 18: goto L_0x03c0;
                case 19: goto L_0x03b5;
                case 20: goto L_0x03aa;
                case 21: goto L_0x039f;
                case 22: goto L_0x0394;
                case 23: goto L_0x0389;
                case 24: goto L_0x037e;
                case 25: goto L_0x0373;
                case 26: goto L_0x0368;
                case 27: goto L_0x0359;
                case 28: goto L_0x034d;
                case 29: goto L_0x0341;
                case 30: goto L_0x0335;
                case 31: goto L_0x0329;
                case 32: goto L_0x031d;
                case 33: goto L_0x0311;
                case 34: goto L_0x0305;
                case 35: goto L_0x02ee;
                case 36: goto L_0x02d9;
                case 37: goto L_0x02c4;
                case 38: goto L_0x02af;
                case 39: goto L_0x029a;
                case 40: goto L_0x0285;
                case 41: goto L_0x026f;
                case 42: goto L_0x0259;
                case 43: goto L_0x0243;
                case 44: goto L_0x022d;
                case 45: goto L_0x0217;
                case 46: goto L_0x0201;
                case 47: goto L_0x01eb;
                case 48: goto L_0x01d5;
                case 49: goto L_0x01c5;
                case 50: goto L_0x01b8;
                case 51: goto L_0x01aa;
                case 52: goto L_0x019c;
                case 53: goto L_0x0186;
                case 54: goto L_0x0170;
                case 55: goto L_0x015a;
                case 56: goto L_0x014c;
                case 57: goto L_0x013e;
                case 58: goto L_0x0130;
                case 59: goto L_0x0102;
                case 60: goto L_0x00ee;
                case 61: goto L_0x00d2;
                case 62: goto L_0x00bc;
                case 63: goto L_0x00a6;
                case 64: goto L_0x0098;
                case 65: goto L_0x008a;
                case 66: goto L_0x006f;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0525
        L_0x003f:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.firebase-auth-api.zzaaz r7 = (com.google.android.gms.internal.p002firebaseauthapi.zzaaz) r7
            com.google.android.gms.internal.firebase-auth-api.zzabl r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzx(r8, r7, r9)
            goto L_0x03ca
        L_0x0055:
            boolean r9 = r14.zzT(r15, r8, r3)
            if (r9 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r9)
            goto L_0x04de
        L_0x006f:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x04de
        L_0x008a:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0521
        L_0x0098:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0513
        L_0x00a6:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzy(r7)
            goto L_0x04de
        L_0x00bc:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x04de
        L_0x00d2:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.firebase-auth-api.zzyu r7 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0469
        L_0x00ee:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.firebase-auth-api.zzabl r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x0102:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzyu
            if (r9 == 0) goto L_0x0122
            com.google.android.gms.internal.firebase-auth-api.zzyu r7 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0469
        L_0x0122:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzC(r7)
            goto L_0x04de
        L_0x0130:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x04b3
        L_0x013e:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0513
        L_0x014c:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0521
        L_0x015a:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzy(r7)
            goto L_0x04de
        L_0x0170:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r9)
            goto L_0x0506
        L_0x0186:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r9)
            goto L_0x0506
        L_0x019c:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0513
        L_0x01aa:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0521
        L_0x01b8:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzH(r3)
            com.google.android.gms.internal.p002firebaseauthapi.zzaau.zza(r8, r7, r9)
            goto L_0x0525
        L_0x01c5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-auth-api.zzabl r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzj(r8, r7, r9)
            goto L_0x03ca
        L_0x01d5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzt(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x01eb:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzr(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x0201:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x0217:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x022d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zze(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x0243:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzw(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x0259:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzb(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x026f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x0285:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x029a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzl(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x02af:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzy(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x02c4:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzn(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x02d9:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0302
        L_0x02ee:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r8)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
        L_0x0302:
            int r8 = r8 + r9
            goto L_0x04de
        L_0x0305:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzs(r8, r7, r2)
            goto L_0x03ca
        L_0x0311:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzq(r8, r7, r2)
            goto L_0x03ca
        L_0x031d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzh(r8, r7, r2)
            goto L_0x03ca
        L_0x0329:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x0335:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzd(r8, r7, r2)
            goto L_0x03ca
        L_0x0341:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzv(r8, r7, r2)
            goto L_0x03ca
        L_0x034d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzc(r8, r7)
            goto L_0x03ca
        L_0x0359:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-auth-api.zzabl r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzp(r8, r7, r9)
            goto L_0x03ca
        L_0x0368:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzu(r8, r7)
            goto L_0x03ca
        L_0x0373:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zza(r8, r7, r2)
            goto L_0x03ca
        L_0x037e:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x0389:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzh(r8, r7, r2)
            goto L_0x03ca
        L_0x0394:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzk(r8, r7, r2)
            goto L_0x03ca
        L_0x039f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzx(r8, r7, r2)
            goto L_0x03ca
        L_0x03aa:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzm(r8, r7, r2)
            goto L_0x03ca
        L_0x03b5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x03c0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzh(r8, r7, r2)
        L_0x03ca:
            int r4 = r4 + r7
            goto L_0x0525
        L_0x03cd:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.firebase-auth-api.zzaaz r7 = (com.google.android.gms.internal.p002firebaseauthapi.zzaaz) r7
            com.google.android.gms.internal.firebase-auth-api.zzabl r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzx(r8, r7, r9)
            goto L_0x03ca
        L_0x03e0:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r9)
            goto L_0x04de
        L_0x03f8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x04de
        L_0x0411:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0521
        L_0x041d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0513
        L_0x0429:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzy(r7)
            goto L_0x04de
        L_0x043d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x04de
        L_0x0451:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.firebase-auth-api.zzyu r7 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
        L_0x0469:
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x04df
        L_0x046d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.firebase-auth-api.zzabl r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x047f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzyu
            if (r9 == 0) goto L_0x049c
            com.google.android.gms.internal.firebase-auth-api.zzyu r7 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0469
        L_0x049c:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzC(r7)
            goto L_0x04de
        L_0x04a9:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
        L_0x04b3:
            int r7 = r7 + r11
            goto L_0x03ca
        L_0x04b6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0513
        L_0x04c1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            goto L_0x0521
        L_0x04cc:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r8)
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzy(r7)
        L_0x04de:
            int r8 = r8 + r7
        L_0x04df:
            int r4 = r4 + r8
            goto L_0x0525
        L_0x04e1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r9)
            goto L_0x0506
        L_0x04f4:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r9)
        L_0x0506:
            int r7 = r7 + r8
            goto L_0x03ca
        L_0x0509:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
        L_0x0513:
            int r7 = r7 + 4
            goto L_0x03ca
        L_0x0517:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r7)
        L_0x0521:
            int r7 = r7 + 8
            goto L_0x03ca
        L_0x0525:
            int r3 = r3 + 3
            goto L_0x000a
        L_0x0529:
            com.google.android.gms.internal.firebase-auth-api.zzabz<?, ?> r0 = r14.zzo
            java.lang.Object r1 = r0.zzd(r15)
            int r0 = r0.zza(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzh
            if (r0 != 0) goto L_0x0539
            return r4
        L_0x0539:
            com.google.android.gms.internal.firebase-auth-api.zzzk<?> r0 = r14.zzp
            r0.zza(r15)
            r15 = 0
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzq(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzr(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzC(r2)
            int r5 = zzB(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.firebase-auth-api.zzzp r4 = com.google.android.gms.internal.p002firebaseauthapi.zzzp.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.firebase-auth-api.zzzp r4 = com.google.android.gms.internal.p002firebaseauthapi.zzzp.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzaaz r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzaaz) r4
            com.google.android.gms.internal.firebase-auth-api.zzabl r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzx(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzT(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzD(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzy(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzyu r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzabl r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzyu
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.firebase-auth-api.zzyu r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzC(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzy(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzD(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r6)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzD(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r6)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.lang.Object r5 = r11.zzH(r2)
            com.google.android.gms.internal.p002firebaseauthapi.zzaau.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-auth-api.zzabl r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzD(r6)
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-auth-api.zzabl r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzaaz r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzaaz) r4
            com.google.android.gms.internal.firebase-auth-api.zzabl r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzx(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzQ(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzy(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzyu r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            com.google.android.gms.internal.firebase-auth-api.zzabl r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzyu
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.firebase-auth-api.zzyu r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzyu) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzC(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r5)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzy(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r6)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r6)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzF(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzze.zzE(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.firebase-auth-api.zzabz<?, ?> r0 = r11.zzo
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzr(java.lang.Object):int");
    }

    private static <T> int zzs(T t, long j) {
        return ((Integer) zzacj.zzf(t, j)).intValue();
    }

    private final <K, V> int zzt(T t, byte[] bArr, int i, int i2, int i3, long j, zzyh zzyh) throws IOException {
        Unsafe unsafe = zzb;
        Object zzH = zzH(i3);
        Object object = unsafe.getObject(t, j);
        if (zzaau.zzb(object)) {
            zzaat zzb2 = zzaat.zza().zzb();
            zzaau.zzc(zzb2, object);
            unsafe.putObject(t, j, zzb2);
        }
        zzaas zzaas = (zzaas) zzH;
        throw null;
    }

    private final int zzu(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzyh zzyh) throws IOException {
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzyh zzyh2 = zzyh;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(Double.longBitsToDouble(zzyi.zzn(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(Float.intBitsToFloat(zzyi.zzb(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm2 = zzyi.zzm(bArr2, i9, zzyh2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzyh2.zzb));
                    unsafe.putInt(t2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzyi.zzj(bArr2, i9, zzyh2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzyh2.zza));
                    unsafe.putInt(t2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzyi.zzn(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzyi.zzb(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzyi.zzm(bArr2, i9, zzyh2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzyh2.zzb != 0));
                    unsafe.putInt(t2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzyi.zzj(bArr2, i9, zzyh2);
                    int i14 = zzyh2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzaco.zzf(bArr2, zzj3, zzj3 + i14)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zzj3, i14, zzaac.zza));
                        zzj3 += i14;
                    } else {
                        throw zzaae.zzd();
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd2 = zzyi.zzd(zzF(i13), bArr2, i9, i2, zzyh2);
                    Object object = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzyh2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzaac.zzg(object, zzyh2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzd2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzyi.zza(bArr2, i9, zzyh2);
                    unsafe.putObject(t2, j2, zzyh2.zzc);
                    unsafe.putInt(t2, j3, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj4 = zzyi.zzj(bArr2, i9, zzyh2);
                    int i15 = zzyh2.zza;
                    zzaaa zzE = zzE(i13);
                    if (zzE == null || zzE.zza()) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i15));
                        unsafe.putInt(t2, j3, i11);
                    } else {
                        zzd(t).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj5 = zzyi.zzj(bArr2, i9, zzyh2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzyx.zzs(zzyh2.zza)));
                    unsafe.putInt(t2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzyi.zzm(bArr2, i9, zzyh2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzyx.zzt(zzyh2.zzb)));
                    unsafe.putInt(t2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc2 = zzyi.zzc(zzF(i13), bArr, i, i2, (i10 & -8) | 4, zzyh);
                    Object object2 = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, zzyh2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzaac.zzg(object2, zzyh2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzc2;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a9, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02c1, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02f4, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0317, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f9, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fd, code lost:
        r1 = r20;
        r8 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0186, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r8 = r19;
        r1 = r20;
        r10 = -1;
        r29 = r13;
        r13 = r2;
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x020a, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x020d, code lost:
        r2 = r4;
        r28 = r10;
        r19 = r13;
        r18 = -1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzv(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.p002firebaseauthapi.zzyh r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r7 = r8
            r1 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x0341
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003b
            int r2 = r2 / 3
            int r0 = r15.zzy(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzx(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r10) goto L_0x004d
            r2 = r4
            r20 = r5
            r28 = r9
            r18 = r10
            r19 = r16
            goto L_0x031a
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzB(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x0216
            int[] r10 = r15.zzc
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            if (r10 == r7) goto L_0x008f
            r23 = r1
            r20 = r2
            if (r7 == r13) goto L_0x0080
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0082
        L_0x0080:
            r7 = r19
        L_0x0082:
            if (r10 == r13) goto L_0x0089
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
        L_0x0089:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0095
        L_0x008f:
            r23 = r1
            r20 = r2
            r10 = r19
        L_0x0095:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01f5;
                case 1: goto L_0x01df;
                case 2: goto L_0x01c2;
                case 3: goto L_0x01c2;
                case 4: goto L_0x01b0;
                case 5: goto L_0x0195;
                case 6: goto L_0x0173;
                case 7: goto L_0x0156;
                case 8: goto L_0x0136;
                case 9: goto L_0x0104;
                case 10: goto L_0x00e9;
                case 11: goto L_0x01b0;
                case 12: goto L_0x00d9;
                case 13: goto L_0x0173;
                case 14: goto L_0x0195;
                case 15: goto L_0x00c5;
                case 16: goto L_0x00a1;
                default: goto L_0x0099;
            }
        L_0x0099:
            r19 = r13
            r13 = r20
            r20 = r33
            goto L_0x020d
        L_0x00a1:
            if (r3 != 0) goto L_0x00bf
            int r17 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzt(r0)
            r0 = r10
            r1 = r31
            r13 = r20
            r2 = r8
            r20 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x00fd
        L_0x00bf:
            r13 = r20
            r20 = r33
            goto L_0x0131
        L_0x00c5:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0131
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzs(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x00f9
        L_0x00d9:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0131
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x00f9
        L_0x00e9:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0131
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
        L_0x00f9:
            r6 = r6 | r21
            r9 = r10
            r2 = r13
        L_0x00fd:
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x025e
        L_0x0104:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x012f
            com.google.android.gms.internal.firebase-auth-api.zzabl r0 = r15.zzF(r13)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzd(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0125
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x0125:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzg(r1, r3)
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x012f:
            r2 = r34
        L_0x0131:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x020d
        L_0x0136:
            r2 = r34
            r19 = r13
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x020d
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x014c
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzg(r12, r4, r11)
            goto L_0x0150
        L_0x014c:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzh(r12, r4, r11)
        L_0x0150:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x0156:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r5 = r16
        L_0x016f:
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzm(r14, r8, r5)
            goto L_0x0186
        L_0x0173:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r1) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
        L_0x0186:
            r6 = r6 | r21
            r9 = r10
            r8 = r19
            r1 = r20
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x0019
        L_0x0195:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r5) goto L_0x020d
            long r22 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x020a
        L_0x01b0:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x020a
        L_0x01c2:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r17 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x025a
        L_0x01df:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r1) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzp(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x020a
        L_0x01f5:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r5) goto L_0x020d
            long r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzo(r14, r8, r0)
            int r0 = r4 + 8
        L_0x020a:
            r6 = r6 | r21
            goto L_0x0258
        L_0x020d:
            r2 = r4
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x031a
        L_0x0216:
            r20 = r33
            r23 = r1
            r13 = r2
            r10 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x0270
            r1 = 2
            if (r3 != r1) goto L_0x0263
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.firebase-auth-api.zzaab r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaab) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0244
            int r1 = r0.size()
            if (r1 != 0) goto L_0x023c
            r1 = 10
            goto L_0x023d
        L_0x023c:
            int r1 = r1 + r1
        L_0x023d:
            com.google.android.gms.internal.firebase-auth-api.zzaab r0 = r0.zzd(r1)
            r10.putObject(r14, r8, r0)
        L_0x0244:
            r5 = r0
            com.google.android.gms.internal.firebase-auth-api.zzabl r0 = r15.zzF(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x0258:
            r9 = r10
            r2 = r13
        L_0x025a:
            r8 = r19
            r1 = r20
        L_0x025e:
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x0263:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x02f7
        L_0x0270:
            r1 = 49
            if (r0 > r1) goto L_0x02c3
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = r19
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r19 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02c1
        L_0x02ab:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            goto L_0x033a
        L_0x02c1:
            r2 = r0
            goto L_0x02f8
        L_0x02c3:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r19 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x02fd
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x02f7
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r26
            r8 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02c1
            goto L_0x02ab
        L_0x02f7:
            r2 = r15
        L_0x02f8:
            r6 = r24
            r7 = r25
            goto L_0x031a
        L_0x02fd:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r26
            r12 = r19
            r13 = r35
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02c1
            goto L_0x02ab
        L_0x031a:
            com.google.android.gms.internal.firebase-auth-api.zzaca r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
        L_0x033a:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0341:
            r24 = r6
            r1 = r8
            r28 = r9
            if (r7 == r1) goto L_0x0352
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0352:
            r1 = r34
            if (r0 != r1) goto L_0x0357
            return r0
        L_0x0357:
            com.google.android.gms.internal.firebase-auth-api.zzaae r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzv(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzyh):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0450 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzw(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.p002firebaseauthapi.zzyh r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.firebase-auth-api.zzaab r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzaab) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.firebase-auth-api.zzaab r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzabl r1 = r15.zzF(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.firebase-auth-api.zzaao r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzaao) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzt(r4)
            r12.zzf(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzaao r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzaao) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzt(r8)
            r12.zzf(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzt(r8)
            r12.zzf(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.firebase-auth-api.zzzx r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzzx) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzs(r4)
            r12.zzf(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzzx r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzzx) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzs(r4)
            r12.zzf(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzs(r4)
            r12.zzf(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.firebase-auth-api.zzzw r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzzw) r1
            com.google.android.gms.internal.firebase-auth-api.zzaca r3 = r1.zzc
            com.google.android.gms.internal.firebase-auth-api.zzaca r4 = com.google.android.gms.internal.p002firebaseauthapi.zzaca.zzc()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.firebase-auth-api.zzaaa r4 = r15.zzE(r8)
            com.google.android.gms.internal.firebase-auth-api.zzabz<?, ?> r5 = r0.zzo
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzC(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.firebase-auth-api.zzaca r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzaca) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.firebase-auth-api.zzyu r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyu.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.firebase-auth-api.zzyu r6 = com.google.android.gms.internal.p002firebaseauthapi.zzyu.zzo(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.firebase-auth-api.zzyu r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyu.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.firebase-auth-api.zzyu r6 = com.google.android.gms.internal.p002firebaseauthapi.zzyu.zzo(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzf()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzf()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.firebase-auth-api.zzabl r1 = r15.zzF(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fa
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f5
            if (r4 != 0) goto L_0x01c2
            r12.add(r6)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zza
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01cc:
            int r1 = r1 + r4
        L_0x01cd:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f0
            if (r4 != 0) goto L_0x01e5
            r12.add(r6)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zza
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzf()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzf()
            throw r1
        L_0x01fa:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0255
            if (r4 != 0) goto L_0x0208
            r12.add(r6)
            goto L_0x021b
        L_0x0208:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.p002firebaseauthapi.zzaco.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zza
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x021a:
            r1 = r8
        L_0x021b:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024b
            if (r4 != 0) goto L_0x0233
            r12.add(r6)
            goto L_0x021b
        L_0x0233:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.p002firebaseauthapi.zzaco.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zza
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzd()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzf()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzd()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzf()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.firebase-auth-api.zzyj r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzyj) r12
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0274
            r5 = r13
            goto L_0x0275
        L_0x0274:
            r5 = r1
        L_0x0275:
            r12.zze(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzyj r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzyj) r12
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = r13
            goto L_0x0294
        L_0x0293:
            r6 = r1
        L_0x0294:
            r12.zze(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r12.zze(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.firebase-auth-api.zzzx r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzzx) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r3, r1)
            r12.zzf(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzzx r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzzx) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r17, r18)
            r12.zzf(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r3, r4)
            r12.zzf(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.firebase-auth-api.zzaao r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzaao) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r3, r1)
            r12.zzf(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzaao r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzaao) r12
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r17, r18)
            r12.zzf(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r3, r4)
            r12.zzf(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzf(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.firebase-auth-api.zzaao r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzaao) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzf(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzaao r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzaao) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.firebase-auth-api.zzzq r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzzq) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzzq r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzzq) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.firebase-auth-api.zzzg r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzzg) r12
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.firebase-auth-api.zzaae r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzi()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.firebase-auth-api.zzzg r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzzg) r12
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzw(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.firebase-auth-api.zzyh):int");
    }

    private final int zzx(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzA(i, 0);
    }

    private final int zzy(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzA(i, i2);
    }

    private final int zzz(int i) {
        return this.zzc[i + 2];
    }

    public final int zza(T t) {
        return this.zzj ? zzr(t) : zzq(t);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzC(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzB(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzU(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzp(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-auth-api.zzabz<?, ?> r0 = r8.zzo
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.firebase-auth-api.zzzk<?> r0 = r8.zzp
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzb(java.lang.Object):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0342, code lost:
        if (r0 != r15) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x035e, code lost:
        r7 = r33;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0388, code lost:
        if (r0 != r15) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03ac, code lost:
        if (r0 != r15) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x020d, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0248, code lost:
        r5 = r6 | r24;
        r3 = r7;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0285, code lost:
        r5 = r6 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0287, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0288, code lost:
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x029f, code lost:
        r18 = r6;
        r19 = r7;
        r26 = r10;
        r8 = r11;
        r23 = r20;
        r6 = r25;
        r7 = r33;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.p002firebaseauthapi.zzyh r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r31
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x0420
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            goto L_0x002e
        L_0x0029:
            r27 = r1
            r1 = r0
            r0 = r27
        L_0x002e:
            int r7 = r1 >>> 3
            r8 = r1 & 7
            r4 = 3
            if (r7 <= r2) goto L_0x003b
            int r3 = r3 / r4
            int r2 = r15.zzy(r7, r3)
            goto L_0x003f
        L_0x003b:
            int r2 = r15.zzx(r7)
        L_0x003f:
            r3 = -1
            if (r2 != r3) goto L_0x0051
            r2 = r0
            r8 = r1
            r17 = r3
            r18 = r5
            r23 = r7
            r26 = r10
            r7 = r11
            r19 = r16
            goto L_0x03af
        L_0x0051:
            int[] r3 = r15.zzc
            int r19 = r2 + 1
            r3 = r3[r19]
            int r4 = zzB(r3)
            r20 = r1
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r3 & r17
            r21 = r0
            long r0 = (long) r1
            r22 = r0
            r0 = 17
            if (r4 > r0) goto L_0x02ae
            int[] r0 = r15.zzc
            int r24 = r2 + 2
            r0 = r0[r24]
            int r24 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r24
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r11
            if (r0 == r6) goto L_0x008c
            r17 = r2
            if (r6 == r11) goto L_0x0084
            long r1 = (long) r6
            r10.putInt(r14, r1, r5)
        L_0x0084:
            long r1 = (long) r0
            int r5 = r10.getInt(r14, r1)
            r25 = r0
            goto L_0x0090
        L_0x008c:
            r17 = r2
            r25 = r6
        L_0x0090:
            r6 = r5
            r0 = 5
            switch(r4) {
                case 0: goto L_0x0269;
                case 1: goto L_0x024d;
                case 2: goto L_0x0229;
                case 3: goto L_0x0229;
                case 4: goto L_0x0210;
                case 5: goto L_0x01ec;
                case 6: goto L_0x01d3;
                case 7: goto L_0x01b0;
                case 8: goto L_0x018c;
                case 9: goto L_0x015b;
                case 10: goto L_0x0141;
                case 11: goto L_0x0210;
                case 12: goto L_0x010c;
                case 13: goto L_0x01d3;
                case 14: goto L_0x01ec;
                case 15: goto L_0x00ef;
                case 16: goto L_0x00c3;
                default: goto L_0x0095;
            }
        L_0x0095:
            r11 = r20
            r2 = r21
            r4 = r22
            r0 = 3
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029f
            com.google.android.gms.internal.firebase-auth-api.zzabl r0 = r15.zzF(r7)
            int r1 = r20 << 3
            r8 = r1 | 4
            r1 = r30
            r3 = r32
            r12 = r4
            r4 = r8
            r5 = r34
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x028b
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x0298
        L_0x00c3:
            if (r8 != 0) goto L_0x00e3
            r1 = r21
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r12, r1, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzt(r0)
            r2 = r22
            r0 = r10
            r11 = r20
            r1 = r29
            r20 = r7
            r7 = r17
            r17 = -1
            r0.putLong(r1, r2, r4)
            goto L_0x0248
        L_0x00e3:
            r11 = r20
            r20 = r7
            r7 = r17
            r17 = -1
            r2 = r21
            goto L_0x029f
        L_0x00ef:
            r11 = r20
            r1 = r21
            r2 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyx.zzs(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0285
        L_0x010c:
            r11 = r20
            r1 = r21
            r2 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.firebase-auth-api.zzaaa r4 = r15.zzE(r7)
            if (r4 == 0) goto L_0x013c
            boolean r4 = r4.zza()
            if (r4 == 0) goto L_0x012d
            goto L_0x013c
        L_0x012d:
            com.google.android.gms.internal.firebase-auth-api.zzaca r2 = zzd(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r5 = r6
            goto L_0x0287
        L_0x013c:
            r10.putInt(r14, r2, r1)
            goto L_0x0285
        L_0x0141:
            r11 = r20
            r1 = r21
            r2 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zza(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0285
        L_0x015b:
            r11 = r20
            r1 = r21
            r2 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020d
            com.google.android.gms.internal.firebase-auth-api.zzabl r0 = r15.zzF(r7)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzd(r0, r12, r1, r13, r9)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x017d
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0285
        L_0x017d:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzg(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0285
        L_0x018c:
            r11 = r20
            r1 = r21
            r4 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020d
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x01a5
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzg(r12, r1, r9)
            goto L_0x01a9
        L_0x01a5:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzh(r12, r1, r9)
        L_0x01a9:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x0285
        L_0x01b0:
            r11 = r20
            r1 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r12, r1, r9)
            long r1 = r9.zzb
            r21 = 0
            int r1 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r1 == 0) goto L_0x01cc
            r1 = 1
            goto L_0x01ce
        L_0x01cc:
            r1 = r16
        L_0x01ce:
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzm(r14, r4, r1)
            goto L_0x0285
        L_0x01d3:
            r11 = r20
            r1 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r12, r1)
            r10.putInt(r14, r4, r0)
            int r0 = r1 + 4
            goto L_0x0285
        L_0x01ec:
            r11 = r20
            r1 = r21
            r4 = r22
            r0 = 1
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020d
            long r21 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r12, r1)
            r8 = r1
            r0 = r10
            r1 = r29
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0285
        L_0x020d:
            r2 = r1
            goto L_0x029f
        L_0x0210:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x029f
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzj(r12, r2, r9)
            int r1 = r9.zza
            r10.putInt(r14, r4, r1)
            goto L_0x0285
        L_0x0229:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x029f
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzm(r12, r2, r9)
            long r2 = r9.zzb
            r0 = r10
            r1 = r29
            r21 = r2
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
        L_0x0248:
            r5 = r6 | r24
            r3 = r7
            r0 = r8
            goto L_0x0288
        L_0x024d:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029f
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzb(r12, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzp(r14, r4, r0)
            int r0 = r2 + 4
            goto L_0x0285
        L_0x0269:
            r11 = r20
            r2 = r21
            r4 = r22
            r0 = 1
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029f
            long r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzn(r12, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzo(r14, r4, r0)
            int r0 = r2 + 8
        L_0x0285:
            r5 = r6 | r24
        L_0x0287:
            r3 = r7
        L_0x0288:
            r1 = r11
            goto L_0x02fa
        L_0x028b:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzg(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x0298:
            r5 = r6 | r24
            r12 = r30
            r13 = r32
            goto L_0x0287
        L_0x029f:
            r18 = r6
            r19 = r7
            r26 = r10
            r8 = r11
            r23 = r20
            r6 = r25
            r7 = r33
            goto L_0x03af
        L_0x02ae:
            r11 = r20
            r12 = r22
            r17 = -1
            r20 = r7
            r7 = r2
            r2 = r21
            r0 = 27
            if (r4 != r0) goto L_0x0311
            r0 = 2
            if (r8 != r0) goto L_0x0302
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.firebase-auth-api.zzaab r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaab) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02dd
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02d5
            r1 = 10
            goto L_0x02d6
        L_0x02d5:
            int r1 = r1 + r1
        L_0x02d6:
            com.google.android.gms.internal.firebase-auth-api.zzaab r0 = r0.zzd(r1)
            r10.putObject(r14, r12, r0)
        L_0x02dd:
            r8 = r0
            com.google.android.gms.internal.firebase-auth-api.zzabl r0 = r15.zzF(r7)
            r1 = r11
            r3 = r2
            r2 = r30
            r4 = r32
            r18 = r5
            r5 = r8
            r25 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zze(r0, r1, r2, r3, r4, r5, r6)
            r12 = r30
            r13 = r32
            r3 = r7
            r5 = r18
        L_0x02fa:
            r2 = r20
            r6 = r25
            r11 = r33
            goto L_0x001a
        L_0x0302:
            r18 = r5
            r25 = r6
            r15 = r2
            r19 = r7
            r26 = r10
            r23 = r20
            r20 = r11
            goto L_0x038b
        L_0x0311:
            r18 = r5
            r25 = r6
            r6 = r2
            r0 = 49
            if (r4 > r0) goto L_0x0362
            long r2 = (long) r3
            r0 = r28
            r1 = r29
            r21 = r2
            r2 = r30
            r3 = r6
            r5 = r4
            r4 = r32
            r31 = r5
            r5 = r11
            r15 = r6
            r6 = r20
            r19 = r7
            r23 = r20
            r7 = r8
            r8 = r19
            r26 = r10
            r9 = r21
            r20 = r11
            r11 = r31
            r14 = r34
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x035e
        L_0x0344:
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            r5 = r18
            r3 = r19
            r1 = r20
            r2 = r23
            r6 = r25
            r10 = r26
            goto L_0x001a
        L_0x035e:
            r7 = r33
            r2 = r0
            goto L_0x038e
        L_0x0362:
            r31 = r4
            r15 = r6
            r19 = r7
            r26 = r10
            r23 = r20
            r20 = r11
            r0 = 50
            r9 = r31
            if (r9 != r0) goto L_0x0393
            r0 = 2
            if (r8 != r0) goto L_0x038b
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r19
            r6 = r12
            r8 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x035e
            goto L_0x0344
        L_0x038b:
            r7 = r33
            r2 = r15
        L_0x038e:
            r8 = r20
            r6 = r25
            goto L_0x03af
        L_0x0393:
            r0 = r28
            r1 = r29
            r2 = r30
            r10 = r3
            r3 = r15
            r4 = r32
            r5 = r20
            r6 = r23
            r7 = r8
            r8 = r10
            r10 = r12
            r12 = r19
            r13 = r34
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x035e
            goto L_0x0344
        L_0x03af:
            if (r8 != r7) goto L_0x03c1
            if (r7 == 0) goto L_0x03c1
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r28
            r12 = r29
            r0 = r2
            r1 = r8
            r5 = r18
            r2 = 0
            goto L_0x042d
        L_0x03c1:
            r9 = r28
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x03f9
            r10 = r34
            com.google.android.gms.internal.firebase-auth-api.zzzj r0 = r10.zzd
            com.google.android.gms.internal.firebase-auth-api.zzzj r1 = com.google.android.gms.internal.p002firebaseauthapi.zzzj.zza()
            if (r0 == r1) goto L_0x03f6
            com.google.android.gms.internal.firebase-auth-api.zzaaz r0 = r9.zzg
            com.google.android.gms.internal.firebase-auth-api.zzzj r1 = r10.zzd
            r11 = r23
            com.google.android.gms.internal.firebase-auth-api.zzzu r0 = r1.zzb(r0, r11)
            if (r0 != 0) goto L_0x03ef
            com.google.android.gms.internal.firebase-auth-api.zzaca r4 = zzd(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x040e
        L_0x03ef:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.firebase-auth-api.zzzt r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzzt) r0
            r2 = 0
            throw r2
        L_0x03f6:
            r12 = r29
            goto L_0x03fd
        L_0x03f9:
            r12 = r29
            r10 = r34
        L_0x03fd:
            r11 = r23
            com.google.android.gms.internal.firebase-auth-api.zzaca r4 = zzd(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zzi(r0, r1, r2, r3, r4, r5)
        L_0x040e:
            r13 = r32
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r5 = r18
            r3 = r19
            r10 = r26
            r12 = r30
            r11 = r7
            goto L_0x001a
        L_0x0420:
            r18 = r5
            r25 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
            r2 = 0
            r3 = 1048575(0xfffff, float:1.469367E-39)
        L_0x042d:
            if (r6 == r3) goto L_0x0435
            long r3 = (long) r6
            r6 = r26
            r6.putInt(r12, r3, r5)
        L_0x0435:
            int r3 = r9.zzl
        L_0x0437:
            int r4 = r9.zzm
            if (r3 >= r4) goto L_0x0447
            int[] r4 = r9.zzk
            r4 = r4[r3]
            com.google.android.gms.internal.firebase-auth-api.zzabz<?, ?> r5 = r9.zzo
            r9.zzG(r12, r4, r2, r5)
            int r3 = r3 + 1
            goto L_0x0437
        L_0x0447:
            if (r7 != 0) goto L_0x0453
            r2 = r32
            if (r0 != r2) goto L_0x044e
            goto L_0x0459
        L_0x044e:
            com.google.android.gms.internal.firebase-auth-api.zzaae r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzg()
            throw r0
        L_0x0453:
            r2 = r32
            if (r0 > r2) goto L_0x045a
            if (r1 != r7) goto L_0x045a
        L_0x0459:
            return r0
        L_0x045a:
            com.google.android.gms.internal.firebase-auth-api.zzaae r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaae.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzyh):int");
    }

    public final T zze() {
        return ((zzzw) this.zzg).zzj(4, (Object) null, (Object) null);
    }

    public final void zzf(T t) {
        int i;
        int i2 = this.zzl;
        while (true) {
            i = this.zzm;
            if (i2 >= i) {
                break;
            }
            long zzC = (long) (zzC(this.zzk[i2]) & 1048575);
            Object zzf2 = zzacj.zzf(t, zzC);
            if (zzf2 != null) {
                ((zzaat) zzf2).zzc();
                zzacj.zzs(t, zzC, zzf2);
            }
            i2++;
        }
        int length = this.zzk.length;
        while (i < length) {
            this.zzn.zzb(t, (long) this.zzk[i]);
            i++;
        }
        this.zzo.zzm(t);
        if (this.zzh) {
            this.zzp.zze(t);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zzh(T r13, com.google.android.gms.internal.p002firebaseauthapi.zzabk r14, com.google.android.gms.internal.p002firebaseauthapi.zzzj r15) throws java.io.IOException {
        /*
            r12 = this;
            java.util.Objects.requireNonNull(r15)
            com.google.android.gms.internal.firebase-auth-api.zzabz<?, ?> r7 = r12.zzo
            com.google.android.gms.internal.firebase-auth-api.zzzk<?> r8 = r12.zzp
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x000a:
            int r1 = r14.zzc()     // Catch:{ all -> 0x0078 }
            int r2 = r12.zzx(r1)     // Catch:{ all -> 0x0078 }
            if (r2 >= 0) goto L_0x007b
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0030
            int r14 = r12.zzl
        L_0x001b:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x002a
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x002a:
            if (r10 == 0) goto L_0x05c2
            r7.zzn(r13, r10)
            return
        L_0x0030:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x0036
            r2 = r9
            goto L_0x003d
        L_0x0036:
            com.google.android.gms.internal.firebase-auth-api.zzaaz r2 = r12.zzg     // Catch:{ all -> 0x0078 }
            java.lang.Object r1 = r8.zzc(r15, r2, r1)     // Catch:{ all -> 0x0078 }
            r2 = r1
        L_0x003d:
            if (r2 == 0) goto L_0x0052
            if (r0 != 0) goto L_0x0045
            com.google.android.gms.internal.firebase-auth-api.zzzo r0 = r8.zzb(r13)     // Catch:{ all -> 0x0078 }
        L_0x0045:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zzd(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0078 }
            r0 = r11
            goto L_0x000a
        L_0x0052:
            r7.zzq(r14)     // Catch:{ all -> 0x0078 }
            if (r10 != 0) goto L_0x005b
            java.lang.Object r10 = r7.zzc(r13)     // Catch:{ all -> 0x0078 }
        L_0x005b:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ all -> 0x0078 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x0063:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0072
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0063
        L_0x0072:
            if (r10 == 0) goto L_0x05c2
            r7.zzn(r13, r10)
            return
        L_0x0078:
            r14 = move-exception
            goto L_0x05c3
        L_0x007b:
            int r3 = r12.zzC(r2)     // Catch:{ all -> 0x0078 }
            int r4 = zzB(r3)     // Catch:{ zzaad -> 0x059c }
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0570;
                case 1: goto L_0x0561;
                case 2: goto L_0x0552;
                case 3: goto L_0x0543;
                case 4: goto L_0x0534;
                case 5: goto L_0x0525;
                case 6: goto L_0x0516;
                case 7: goto L_0x0507;
                case 8: goto L_0x04ff;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04bf;
                case 11: goto L_0x04b0;
                case 12: goto L_0x048e;
                case 13: goto L_0x047f;
                case 14: goto L_0x0470;
                case 15: goto L_0x0461;
                case 16: goto L_0x0452;
                case 17: goto L_0x0421;
                case 18: goto L_0x0413;
                case 19: goto L_0x0405;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e9;
                case 22: goto L_0x03db;
                case 23: goto L_0x03cd;
                case 24: goto L_0x03bf;
                case 25: goto L_0x03b1;
                case 26: goto L_0x0387;
                case 27: goto L_0x0375;
                case 28: goto L_0x0367;
                case 29: goto L_0x0359;
                case 30: goto L_0x0344;
                case 31: goto L_0x0336;
                case 32: goto L_0x0328;
                case 33: goto L_0x031a;
                case 34: goto L_0x030c;
                case 35: goto L_0x02fe;
                case 36: goto L_0x02f0;
                case 37: goto L_0x02e2;
                case 38: goto L_0x02d4;
                case 39: goto L_0x02c6;
                case 40: goto L_0x02b8;
                case 41: goto L_0x02aa;
                case 42: goto L_0x029c;
                case 43: goto L_0x028e;
                case 44: goto L_0x0279;
                case 45: goto L_0x026b;
                case 46: goto L_0x025d;
                case 47: goto L_0x024f;
                case 48: goto L_0x0241;
                case 49: goto L_0x022f;
                case 50: goto L_0x01f9;
                case 51: goto L_0x01e7;
                case 52: goto L_0x01d5;
                case 53: goto L_0x01c3;
                case 54: goto L_0x01b1;
                case 55: goto L_0x019f;
                case 56: goto L_0x018d;
                case 57: goto L_0x017b;
                case 58: goto L_0x0169;
                case 59: goto L_0x0161;
                case 60: goto L_0x0130;
                case 61: goto L_0x0122;
                case 62: goto L_0x0110;
                case 63: goto L_0x00eb;
                case 64: goto L_0x00d9;
                case 65: goto L_0x00c7;
                case 66: goto L_0x00b5;
                case 67: goto L_0x00a3;
                case 68: goto L_0x0091;
                default: goto L_0x0089;
            }     // Catch:{ zzaad -> 0x059c }
        L_0x0089:
            if (r10 != 0) goto L_0x057f
            java.lang.Object r10 = r7.zzf()     // Catch:{ zzaad -> 0x059c }
            goto L_0x057f
        L_0x0091:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzabl r5 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r5 = r14.zzr(r5, r15)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x00a3:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzn()     // Catch:{ zzaad -> 0x059c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x00b5:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            int r5 = r14.zzi()     // Catch:{ zzaad -> 0x059c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x00c7:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzm()     // Catch:{ zzaad -> 0x059c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x00d9:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            int r5 = r14.zzh()     // Catch:{ zzaad -> 0x059c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x00eb:
            int r4 = r14.zze()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaaa r6 = r12.zzE(r2)     // Catch:{ zzaad -> 0x059c }
            if (r6 == 0) goto L_0x0102
            boolean r6 = r6.zza()     // Catch:{ zzaad -> 0x059c }
            if (r6 == 0) goto L_0x00fc
            goto L_0x0102
        L_0x00fc:
            java.lang.Object r10 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzD(r1, r4, r10, r7)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0102:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzaad -> 0x059c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r5, r3)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0110:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            int r5 = r14.zzj()     // Catch:{ zzaad -> 0x059c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0122:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzyu r5 = r14.zzp()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0130:
            boolean r4 = r12.zzT(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            if (r4 == 0) goto L_0x014c
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r13, r3)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzabl r6 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r6 = r14.zzs(r6, r15)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzg(r5, r6)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            goto L_0x015c
        L_0x014c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzabl r5 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r5 = r14.zzs(r5, r15)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
        L_0x015c:
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0161:
            r12.zzL(r13, r3, r14)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0169:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            boolean r5 = r14.zzN()     // Catch:{ zzaad -> 0x059c }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x017b:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            int r5 = r14.zzf()     // Catch:{ zzaad -> 0x059c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x018d:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzk()     // Catch:{ zzaad -> 0x059c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x019f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            int r5 = r14.zzg()     // Catch:{ zzaad -> 0x059c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x01b1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzo()     // Catch:{ zzaad -> 0x059c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x01c3:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzl()     // Catch:{ zzaad -> 0x059c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x01d5:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            float r5 = r14.zzb()     // Catch:{ zzaad -> 0x059c }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x01e7:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzaad -> 0x059c }
            double r5 = r14.zza()     // Catch:{ zzaad -> 0x059c }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzN(r13, r1, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x01f9:
            java.lang.Object r1 = r12.zzH(r2)     // Catch:{ zzaad -> 0x059c }
            int r2 = r12.zzC(r2)     // Catch:{ zzaad -> 0x059c }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r13, r2)     // Catch:{ zzaad -> 0x059c }
            if (r4 == 0) goto L_0x021f
            boolean r5 = com.google.android.gms.internal.p002firebaseauthapi.zzaau.zzb(r4)     // Catch:{ zzaad -> 0x059c }
            if (r5 == 0) goto L_0x022a
            com.google.android.gms.internal.firebase-auth-api.zzaat r5 = com.google.android.gms.internal.p002firebaseauthapi.zzaat.zza()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaat r5 = r5.zzb()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzaau.zzc(r5, r4)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r2, r5)     // Catch:{ zzaad -> 0x059c }
            r4 = r5
            goto L_0x022a
        L_0x021f:
            com.google.android.gms.internal.firebase-auth-api.zzaat r4 = com.google.android.gms.internal.p002firebaseauthapi.zzaat.zza()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaat r4 = r4.zzb()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r2, r4)     // Catch:{ zzaad -> 0x059c }
        L_0x022a:
            com.google.android.gms.internal.firebase-auth-api.zzaat r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzaat) r4     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaas r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzaas) r1     // Catch:{ zzaad -> 0x059c }
            throw r9     // Catch:{ zzaad -> 0x059c }
        L_0x022f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzabl r1 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaan r2 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzaad -> 0x059c }
            r14.zzC(r2, r1, r15)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0241:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzJ(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x024f:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzI(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x025d:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzH(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x026b:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzG(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0279:
            com.google.android.gms.internal.firebase-auth-api.zzaan r4 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzaad -> 0x059c }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzaad -> 0x059c }
            r14.zzy(r3)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaaa r2 = r12.zzE(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r10 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzC(r1, r3, r2, r10, r7)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x028e:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzL(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x029c:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzv(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x02aa:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzz(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x02b8:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzA(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x02c6:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzD(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x02d4:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzM(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x02e2:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzE(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x02f0:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzB(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x02fe:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzx(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x030c:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzJ(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x031a:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzI(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0328:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzH(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0336:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzG(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0344:
            com.google.android.gms.internal.firebase-auth-api.zzaan r4 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzaad -> 0x059c }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzaad -> 0x059c }
            r14.zzy(r3)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaaa r2 = r12.zzE(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r10 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzC(r1, r3, r2, r10, r7)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0359:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzL(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0367:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzw(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0375:
            com.google.android.gms.internal.firebase-auth-api.zzabl r1 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaan r4 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzF(r2, r1, r15)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0387:
            boolean r1 = zzP(r3)     // Catch:{ zzaad -> 0x059c }
            if (r1 == 0) goto L_0x039f
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r2 = r14
            com.google.android.gms.internal.firebase-auth-api.zzyy r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzyy) r2     // Catch:{ zzaad -> 0x059c }
            r3 = 1
            r2.zzK(r1, r3)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x039f:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r2 = r14
            com.google.android.gms.internal.firebase-auth-api.zzyy r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzyy) r2     // Catch:{ zzaad -> 0x059c }
            r3 = 0
            r2.zzK(r1, r3)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x03b1:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzv(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x03bf:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzz(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x03cd:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzA(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x03db:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzD(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x03e9:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzM(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x03f7:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzE(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0405:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzB(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0413:
            com.google.android.gms.internal.firebase-auth-api.zzaan r1 = r12.zzn     // Catch:{ zzaad -> 0x059c }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzaad -> 0x059c }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzaad -> 0x059c }
            r14.zzx(r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0421:
            boolean r1 = r12.zzQ(r13, r2)     // Catch:{ zzaad -> 0x059c }
            if (r1 == 0) goto L_0x043f
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r13, r3)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzabl r2 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r2 = r14.zzr(r2, r15)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzg(r1, r2)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x043f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzabl r1 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r1 = r14.zzr(r1, r15)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0452:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzn()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzr(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0461:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            int r1 = r14.zzi()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzq(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0470:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzm()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzr(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x047f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            int r1 = r14.zzh()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzq(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x048e:
            int r4 = r14.zze()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzaaa r6 = r12.zzE(r2)     // Catch:{ zzaad -> 0x059c }
            if (r6 == 0) goto L_0x04a5
            boolean r6 = r6.zza()     // Catch:{ zzaad -> 0x059c }
            if (r6 == 0) goto L_0x049f
            goto L_0x04a5
        L_0x049f:
            java.lang.Object r10 = com.google.android.gms.internal.p002firebaseauthapi.zzabn.zzD(r1, r4, r10, r7)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x04a5:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzq(r13, r5, r4)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x04b0:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            int r1 = r14.zzj()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzq(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x04bf:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzyu r1 = r14.zzp()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x04ce:
            boolean r1 = r12.zzQ(r13, r2)     // Catch:{ zzaad -> 0x059c }
            if (r1 == 0) goto L_0x04ec
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzf(r13, r3)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzabl r2 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r2 = r14.zzs(r2, r15)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaac.zzg(r1, r2)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x04ec:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.firebase-auth-api.zzabl r1 = r12.zzF(r2)     // Catch:{ zzaad -> 0x059c }
            java.lang.Object r1 = r14.zzs(r1, r15)     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzs(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x04ff:
            r12.zzL(r13, r3, r14)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0507:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            boolean r1 = r14.zzN()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzm(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0516:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            int r1 = r14.zzf()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzq(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0525:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzk()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzr(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0534:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            int r1 = r14.zzg()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzq(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0543:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzo()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzr(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0552:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            long r5 = r14.zzl()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzr(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0561:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            float r1 = r14.zzb()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzp(r13, r3, r1)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x0570:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzaad -> 0x059c }
            double r5 = r14.zza()     // Catch:{ zzaad -> 0x059c }
            com.google.android.gms.internal.p002firebaseauthapi.zzacj.zzo(r13, r3, r5)     // Catch:{ zzaad -> 0x059c }
            r12.zzM(r13, r2)     // Catch:{ zzaad -> 0x059c }
            goto L_0x000a
        L_0x057f:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ zzaad -> 0x059c }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x0587:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0596
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0587
        L_0x0596:
            if (r10 == 0) goto L_0x05c2
            r7.zzn(r13, r10)
            return
        L_0x059c:
            r7.zzq(r14)     // Catch:{ all -> 0x0078 }
            if (r10 != 0) goto L_0x05a6
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x0078 }
            r10 = r1
        L_0x05a6:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ all -> 0x0078 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x05ae:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x05bd
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05ae
        L_0x05bd:
            if (r10 == 0) goto L_0x05c2
            r7.zzn(r13, r10)
        L_0x05c2:
            return
        L_0x05c3:
            int r15 = r12.zzl
        L_0x05c5:
            int r0 = r12.zzm
            if (r15 >= r0) goto L_0x05d4
            int[] r0 = r12.zzk
            r0 = r0[r15]
            java.lang.Object r10 = r12.zzG(r13, r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05c5
        L_0x05d4:
            if (r10 == 0) goto L_0x05d9
            r7.zzn(r13, r10)
        L_0x05d9:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabc.zzh(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzabk, com.google.android.gms.internal.firebase-auth-api.zzzj):void");
    }

    public final void zzi(T t, byte[] bArr, int i, int i2, zzyh zzyh) throws IOException {
        if (this.zzj) {
            zzv(t, bArr, i, i2, zzyh);
        } else {
            zzc(t, bArr, i, i2, 0, zzyh);
        }
    }

    public final boolean zzj(T t, T t2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzC = zzC(i);
            long j = (long) (zzC & 1048575);
            switch (zzB(zzC)) {
                case 0:
                    if (zzO(t, t2, i) && Double.doubleToLongBits(zzacj.zza(t, j)) == Double.doubleToLongBits(zzacj.zza(t2, j))) {
                        continue;
                    }
                case 1:
                    if (zzO(t, t2, i) && Float.floatToIntBits(zzacj.zzb(t, j)) == Float.floatToIntBits(zzacj.zzb(t2, j))) {
                        continue;
                    }
                case 2:
                    if (zzO(t, t2, i) && zzacj.zzd(t, j) == zzacj.zzd(t2, j)) {
                        continue;
                    }
                case 3:
                    if (zzO(t, t2, i) && zzacj.zzd(t, j) == zzacj.zzd(t2, j)) {
                        continue;
                    }
                case 4:
                    if (zzO(t, t2, i) && zzacj.zzc(t, j) == zzacj.zzc(t2, j)) {
                        continue;
                    }
                case 5:
                    if (zzO(t, t2, i) && zzacj.zzd(t, j) == zzacj.zzd(t2, j)) {
                        continue;
                    }
                case 6:
                    if (zzO(t, t2, i) && zzacj.zzc(t, j) == zzacj.zzc(t2, j)) {
                        continue;
                    }
                case 7:
                    if (zzO(t, t2, i) && zzacj.zzw(t, j) == zzacj.zzw(t2, j)) {
                        continue;
                    }
                case 8:
                    if (zzO(t, t2, i) && zzabn.zzH(zzacj.zzf(t, j), zzacj.zzf(t2, j))) {
                        continue;
                    }
                case 9:
                    if (zzO(t, t2, i) && zzabn.zzH(zzacj.zzf(t, j), zzacj.zzf(t2, j))) {
                        continue;
                    }
                case 10:
                    if (zzO(t, t2, i) && zzabn.zzH(zzacj.zzf(t, j), zzacj.zzf(t2, j))) {
                        continue;
                    }
                case 11:
                    if (zzO(t, t2, i) && zzacj.zzc(t, j) == zzacj.zzc(t2, j)) {
                        continue;
                    }
                case 12:
                    if (zzO(t, t2, i) && zzacj.zzc(t, j) == zzacj.zzc(t2, j)) {
                        continue;
                    }
                case 13:
                    if (zzO(t, t2, i) && zzacj.zzc(t, j) == zzacj.zzc(t2, j)) {
                        continue;
                    }
                case 14:
                    if (zzO(t, t2, i) && zzacj.zzd(t, j) == zzacj.zzd(t2, j)) {
                        continue;
                    }
                case 15:
                    if (zzO(t, t2, i) && zzacj.zzc(t, j) == zzacj.zzc(t2, j)) {
                        continue;
                    }
                case 16:
                    if (zzO(t, t2, i) && zzacj.zzd(t, j) == zzacj.zzd(t2, j)) {
                        continue;
                    }
                case 17:
                    if (zzO(t, t2, i) && zzabn.zzH(zzacj.zzf(t, j), zzacj.zzf(t2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzabn.zzH(zzacj.zzf(t, j), zzacj.zzf(t2, j));
                    break;
                case 50:
                    z = zzabn.zzH(zzacj.zzf(t, j), zzacj.zzf(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzz = (long) (zzz(i) & 1048575);
                    if (zzacj.zzc(t, zzz) == zzacj.zzc(t2, zzz) && zzabn.zzH(zzacj.zzf(t, j), zzacj.zzf(t2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzo.zzd(t).equals(this.zzo.zzd(t2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(t);
        this.zzp.zza(t2);
        throw null;
    }

    public final boolean zzk(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzl) {
            int i6 = this.zzk[i5];
            int i7 = this.zzc[i6];
            int zzC = zzC(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzC) != 0 && !zzR(t, i6, i2, i, i10)) {
                return false;
            }
            int zzB = zzB(zzC);
            if (zzB != 9 && zzB != 17) {
                if (zzB != 27) {
                    if (zzB == 60 || zzB == 68) {
                        if (zzT(t2, i7, i6) && !zzS(t2, zzC, zzF(i6))) {
                            return false;
                        }
                    } else if (zzB != 49) {
                        if (zzB == 50 && !((zzaat) zzacj.zzf(t2, (long) (zzC & 1048575))).isEmpty()) {
                            zzaas zzaas = (zzaas) zzH(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzacj.zzf(t2, (long) (zzC & 1048575));
                if (!list.isEmpty()) {
                    zzabl zzF = zzF(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzF.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzR(t, i6, i2, i, i10) && !zzS(t2, zzC, zzF(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(t2);
        throw null;
    }

    public final void zzn(T t, zzzf zzzf) throws IOException {
        if (!this.zzj) {
            zzV(t, zzzf);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzC = zzC(i);
                int i2 = this.zzc[i];
                switch (zzB(zzC)) {
                    case 0:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzf(i2, zzacj.zza(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzo(i2, zzacj.zzb(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzt(i2, zzacj.zzd(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzJ(i2, zzacj.zzd(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzr(i2, zzacj.zzc(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzm(i2, zzacj.zzd(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzk(i2, zzacj.zzc(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzb(i2, zzacj.zzw(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzX(i2, zzacj.zzf(t, (long) (zzC & 1048575)), zzzf);
                            break;
                        }
                    case 9:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzv(i2, zzacj.zzf(t, (long) (zzC & 1048575)), zzF(i));
                            break;
                        }
                    case 10:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzd(i2, (zzyu) zzacj.zzf(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzH(i2, zzacj.zzc(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzi(i2, zzacj.zzc(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzw(i2, zzacj.zzc(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzy(i2, zzacj.zzd(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzA(i2, zzacj.zzc(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzC(i2, zzacj.zzd(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzQ(t, i)) {
                            break;
                        } else {
                            zzzf.zzq(i2, zzacj.zzf(t, (long) (zzC & 1048575)), zzF(i));
                            break;
                        }
                    case 18:
                        zzabn.zzL(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 19:
                        zzabn.zzP(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 20:
                        zzabn.zzS(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 21:
                        zzabn.zzaa(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 22:
                        zzabn.zzR(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 23:
                        zzabn.zzO(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 24:
                        zzabn.zzN(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 25:
                        zzabn.zzJ(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 26:
                        zzabn.zzY(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf);
                        break;
                    case 27:
                        zzabn.zzT(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, zzF(i));
                        break;
                    case 28:
                        zzabn.zzK(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf);
                        break;
                    case 29:
                        zzabn.zzZ(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 30:
                        zzabn.zzM(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 31:
                        zzabn.zzU(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 32:
                        zzabn.zzV(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 33:
                        zzabn.zzW(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 34:
                        zzabn.zzX(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, false);
                        break;
                    case 35:
                        zzabn.zzL(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 36:
                        zzabn.zzP(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 37:
                        zzabn.zzS(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 38:
                        zzabn.zzaa(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 39:
                        zzabn.zzR(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 40:
                        zzabn.zzO(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 41:
                        zzabn.zzN(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 42:
                        zzabn.zzJ(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 43:
                        zzabn.zzZ(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 44:
                        zzabn.zzM(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 45:
                        zzabn.zzU(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 46:
                        zzabn.zzV(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 47:
                        zzabn.zzW(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 48:
                        zzabn.zzX(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, true);
                        break;
                    case 49:
                        zzabn.zzQ(this.zzc[i], (List) zzacj.zzf(t, (long) (zzC & 1048575)), zzzf, zzF(i));
                        break;
                    case 50:
                        zzW(zzzf, i2, zzacj.zzf(t, (long) (zzC & 1048575)), i);
                        break;
                    case 51:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzf(i2, zzo(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzo(i2, zzp(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzt(i2, zzD(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzJ(i2, zzD(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzr(i2, zzs(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzm(i2, zzD(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzk(i2, zzs(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzb(i2, zzU(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzX(i2, zzacj.zzf(t, (long) (zzC & 1048575)), zzzf);
                            break;
                        }
                    case 60:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzv(i2, zzacj.zzf(t, (long) (zzC & 1048575)), zzF(i));
                            break;
                        }
                    case 61:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzd(i2, (zzyu) zzacj.zzf(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzH(i2, zzs(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzi(i2, zzs(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzw(i2, zzs(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzy(i2, zzD(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzA(i2, zzs(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzC(i2, zzD(t, (long) (zzC & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzT(t, i2, i)) {
                            break;
                        } else {
                            zzzf.zzq(i2, zzacj.zzf(t, (long) (zzC & 1048575)), zzF(i));
                            break;
                        }
                }
            }
            zzabz<?, ?> zzabz = this.zzo;
            zzabz.zzr(zzabz.zzd(t), zzzf);
        } else {
            this.zzp.zza(t);
            throw null;
        }
    }

    public final void zzg(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzC = zzC(i);
            long j = (long) (1048575 & zzC);
            int i2 = this.zzc[i];
            switch (zzB(zzC)) {
                case 0:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzo(t, j, zzacj.zza(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 1:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzp(t, j, zzacj.zzb(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 2:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzr(t, j, zzacj.zzd(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 3:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzr(t, j, zzacj.zzd(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 4:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzq(t, j, zzacj.zzc(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 5:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzr(t, j, zzacj.zzd(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 6:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzq(t, j, zzacj.zzc(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 7:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzm(t, j, zzacj.zzw(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 8:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzs(t, j, zzacj.zzf(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 9:
                    zzJ(t, t2, i);
                    break;
                case 10:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzs(t, j, zzacj.zzf(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 11:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzq(t, j, zzacj.zzc(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 12:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzq(t, j, zzacj.zzc(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 13:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzq(t, j, zzacj.zzc(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 14:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzr(t, j, zzacj.zzd(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 15:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzq(t, j, zzacj.zzc(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 16:
                    if (!zzQ(t2, i)) {
                        break;
                    } else {
                        zzacj.zzr(t, j, zzacj.zzd(t2, j));
                        zzM(t, i);
                        break;
                    }
                case 17:
                    zzJ(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzn.zzc(t, t2, j);
                    break;
                case 50:
                    zzabn.zzI(this.zzr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzT(t2, i2, i)) {
                        break;
                    } else {
                        zzacj.zzs(t, j, zzacj.zzf(t2, j));
                        zzN(t, i2, i);
                        break;
                    }
                case 60:
                    zzK(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzT(t2, i2, i)) {
                        break;
                    } else {
                        zzacj.zzs(t, j, zzacj.zzf(t2, j));
                        zzN(t, i2, i);
                        break;
                    }
                case 68:
                    zzK(t, t2, i);
                    break;
            }
        }
        zzabn.zzF(this.zzo, t, t2);
        if (this.zzh) {
            zzabn.zzE(this.zzp, t, t2);
        }
    }
}
