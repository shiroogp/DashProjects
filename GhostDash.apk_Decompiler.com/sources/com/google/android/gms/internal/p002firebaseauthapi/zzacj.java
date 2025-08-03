package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzacj {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzyg.zza();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzaci zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x015a  */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            sun.misc.Unsafe r5 = zzg()
            zzc = r5
            java.lang.Class r6 = com.google.android.gms.internal.p002firebaseauthapi.zzyg.zza()
            zzd = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzv(r6)
            zze = r6
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzv(r7)
            zzf = r7
            r8 = 0
            if (r5 != 0) goto L_0x002a
            goto L_0x0039
        L_0x002a:
            if (r6 == 0) goto L_0x0032
            com.google.android.gms.internal.firebase-auth-api.zzach r8 = new com.google.android.gms.internal.firebase-auth-api.zzach
            r8.<init>(r5)
            goto L_0x0039
        L_0x0032:
            if (r7 == 0) goto L_0x0039
            com.google.android.gms.internal.firebase-auth-api.zzacg r8 = new com.google.android.gms.internal.firebase-auth-api.zzacg
            r8.<init>(r5)
        L_0x0039:
            zzg = r8
            java.lang.String r5 = "getLong"
            java.lang.String r6 = "objectFieldOffset"
            r7 = 2
            r9 = 1
            r10 = 0
            if (r8 != 0) goto L_0x0046
        L_0x0044:
            r8 = r10
            goto L_0x0073
        L_0x0046:
            sun.misc.Unsafe r8 = r8.zza
            if (r8 != 0) goto L_0x004b
            goto L_0x0044
        L_0x004b:
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x006e }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x006e }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x006e }
            r8.getMethod(r6, r11)     // Catch:{ all -> 0x006e }
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ all -> 0x006e }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x006e }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x006e }
            r11[r9] = r12     // Catch:{ all -> 0x006e }
            r8.getMethod(r5, r11)     // Catch:{ all -> 0x006e }
            java.lang.reflect.Field r8 = zzB()     // Catch:{ all -> 0x006e }
            if (r8 != 0) goto L_0x006c
            goto L_0x0044
        L_0x006c:
            r8 = r9
            goto L_0x0073
        L_0x006e:
            r8 = move-exception
            zzh(r8)
            goto L_0x0044
        L_0x0073:
            zzh = r8
            com.google.android.gms.internal.firebase-auth-api.zzaci r8 = zzg
            if (r8 != 0) goto L_0x007c
        L_0x0079:
            r5 = r10
            goto L_0x0111
        L_0x007c:
            sun.misc.Unsafe r8 = r8.zza
            if (r8 != 0) goto L_0x0081
            goto L_0x0079
        L_0x0081:
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x010b }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x010b }
            r8.getMethod(r6, r11)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "arrayBaseOffset"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "arrayIndexScale"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r6 = new java.lang.Class[r7]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r6[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r6[r9] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "getInt"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x010b }
            r6 = 3
            java.lang.Class[] r11 = new java.lang.Class[r6]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x010b }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r11[r9] = r12     // Catch:{ all -> 0x010b }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ all -> 0x010b }
            r11[r7] = r12     // Catch:{ all -> 0x010b }
            java.lang.String r12 = "putInt"
            r8.getMethod(r12, r11)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x010b }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r11[r9] = r12     // Catch:{ all -> 0x010b }
            r8.getMethod(r5, r11)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r5[r9] = r11     // Catch:{ all -> 0x010b }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r5[r7] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "putLong"
            r8.getMethod(r11, r5)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r5 = new java.lang.Class[r7]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x010b }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r5[r9] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r11 = "getObject"
            r8.getMethod(r11, r5)     // Catch:{ all -> 0x010b }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r10] = r6     // Catch:{ all -> 0x010b }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x010b }
            r5[r9] = r6     // Catch:{ all -> 0x010b }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r7] = r6     // Catch:{ all -> 0x010b }
            java.lang.String r6 = "putObject"
            r8.getMethod(r6, r5)     // Catch:{ all -> 0x010b }
            r5 = r9
            goto L_0x0111
        L_0x010b:
            r5 = move-exception
            zzh(r5)
            goto L_0x0079
        L_0x0111:
            zzi = r5
            java.lang.Class<byte[]> r5 = byte[].class
            int r5 = zzz(r5)
            long r5 = (long) r5
            zza = r5
            zzz(r4)
            zzA(r4)
            zzz(r3)
            zzA(r3)
            zzz(r2)
            zzA(r2)
            zzz(r1)
            zzA(r1)
            zzz(r0)
            zzA(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzz(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x0151
            com.google.android.gms.internal.firebase-auth-api.zzaci r1 = zzg
            if (r1 == 0) goto L_0x0151
            r1.zzl(r0)
        L_0x0151:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r9 = r10
        L_0x015b:
            zzb = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzacj.<clinit>():void");
    }

    private zzacj() {
    }

    private static int zzA(Class<?> cls) {
        if (zzi) {
            return zzg.zzi(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i = zzyg.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(Buffer.class, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzaci zzaci = zzg;
        int zzj = zzaci.zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzaci.zzn(obj, j2, ((255 & b) << i) | (zzj & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzaci zzaci = zzg;
        int i = (((int) j) & 3) << 3;
        zzaci.zzn(obj, j2, ((255 & b) << i) | (zzaci.zzj(obj, j2) & (~(255 << i))));
    }

    static double zza(Object obj, long j) {
        return zzg.zza(obj, j);
    }

    static float zzb(Object obj, long j) {
        return zzg.zzb(obj, j);
    }

    static int zzc(Object obj, long j) {
        return zzg.zzj(obj, j);
    }

    static long zzd(Object obj, long j) {
        return zzg.zzk(obj, j);
    }

    static <T> T zze(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object zzf(Object obj, long j) {
        return zzg.zzm(obj, j);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzacf());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zzh(Throwable th) {
        Logger logger = Logger.getLogger(zzacj.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
        sb.append("platform method missing - proto runtime falling back to safer methods: ");
        sb.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb.toString());
    }

    static void zzm(Object obj, long j, boolean z) {
        zzg.zzc(obj, j, z);
    }

    static void zzn(byte[] bArr, long j, byte b) {
        zzg.zzd(bArr, zza + j, b);
    }

    static void zzo(Object obj, long j, double d) {
        zzg.zze(obj, j, d);
    }

    static void zzp(Object obj, long j, float f) {
        zzg.zzf(obj, j, f);
    }

    static void zzq(Object obj, long j, int i) {
        zzg.zzn(obj, j, i);
    }

    static void zzr(Object obj, long j, long j2) {
        zzg.zzo(obj, j, j2);
    }

    static void zzs(Object obj, long j, Object obj2) {
        zzg.zzp(obj, j, obj2);
    }

    static /* synthetic */ boolean zzt(Object obj, long j) {
        return ((byte) ((zzg.zzj(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzg.zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static boolean zzv(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzyg.zza;
        try {
            Class<?> cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzw(Object obj, long j) {
        return zzg.zzg(obj, j);
    }

    static boolean zzx() {
        return zzi;
    }

    static boolean zzy() {
        return zzh;
    }

    private static int zzz(Class<?> cls) {
        if (zzi) {
            return zzg.zzh(cls);
        }
        return -1;
    }
}
