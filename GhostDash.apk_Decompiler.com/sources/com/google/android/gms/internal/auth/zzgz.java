package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzgz {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc = zzdo.zza();
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzgy zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0156  */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            sun.misc.Unsafe r5 = zzg()
            zzb = r5
            java.lang.Class r6 = com.google.android.gms.internal.auth.zzdo.zza()
            zzc = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzs(r6)
            zzd = r6
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzs(r7)
            zze = r7
            r8 = 0
            if (r5 != 0) goto L_0x002a
            goto L_0x0039
        L_0x002a:
            if (r6 == 0) goto L_0x0032
            com.google.android.gms.internal.auth.zzgx r8 = new com.google.android.gms.internal.auth.zzgx
            r8.<init>(r5)
            goto L_0x0039
        L_0x0032:
            if (r7 == 0) goto L_0x0039
            com.google.android.gms.internal.auth.zzgw r8 = new com.google.android.gms.internal.auth.zzgw
            r8.<init>(r5)
        L_0x0039:
            zzf = r8
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
            java.lang.reflect.Field r8 = zzy()     // Catch:{ all -> 0x006e }
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
            zzg = r8
            com.google.android.gms.internal.auth.zzgy r8 = zzf
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
            zzh = r5
            java.lang.Class<byte[]> r5 = byte[].class
            zzw(r5)
            zzw(r4)
            zzx(r4)
            zzw(r3)
            zzx(r3)
            zzw(r2)
            zzx(r2)
            zzw(r1)
            zzx(r1)
            zzw(r0)
            zzx(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzw(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzx(r0)
            java.lang.reflect.Field r0 = zzy()
            if (r0 == 0) goto L_0x014d
            com.google.android.gms.internal.auth.zzgy r1 = zzf
            if (r1 == 0) goto L_0x014d
            r1.zzk(r0)
        L_0x014d:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0156
            goto L_0x0157
        L_0x0156:
            r9 = r10
        L_0x0157:
            zza = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzgz.<clinit>():void");
    }

    private zzgz() {
    }

    static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    static int zzc(Object obj, long j) {
        return zzf.zzi(obj, j);
    }

    static long zzd(Object obj, long j) {
        return zzf.zzj(obj, j);
    }

    static <T> T zze(Class<T> cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object zzf(Object obj, long j) {
        return zzf.zzl(obj, j);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgv());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zzh(Throwable th) {
        Logger logger = Logger.getLogger(zzgz.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
        sb.append("platform method missing - proto runtime falling back to safer methods: ");
        sb.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb.toString());
    }

    static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        long j2 = -4 & j;
        zzgy zzgy = zzf;
        int zzi = zzgy.zzi(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzgy.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzi));
    }

    static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        long j2 = -4 & j;
        zzgy zzgy = zzf;
        int zzi = zzgy.zzi(obj, j2);
        int i = (((int) j) & 3) << 3;
        zzgy.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzi));
    }

    static void zzk(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    static void zzl(Object obj, long j, double d) {
        zzf.zzd(obj, j, d);
    }

    static void zzm(Object obj, long j, float f) {
        zzf.zze(obj, j, f);
    }

    static void zzn(Object obj, long j, int i) {
        zzf.zzm(obj, j, i);
    }

    static void zzo(Object obj, long j, long j2) {
        zzf.zzn(obj, j, j2);
    }

    static void zzp(Object obj, long j, Object obj2) {
        zzf.zzo(obj, j, obj2);
    }

    static /* synthetic */ boolean zzq(Object obj, long j) {
        return ((byte) ((zzf.zzi(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzr(Object obj, long j) {
        return ((byte) ((zzf.zzi(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static boolean zzs(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzdo.zza;
        try {
            Class<?> cls3 = zzc;
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

    static boolean zzt(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    static boolean zzu() {
        return zzh;
    }

    static boolean zzv() {
        return zzg;
    }

    private static int zzw(Class<?> cls) {
        if (zzh) {
            return zzf.zzg(cls);
        }
        return -1;
    }

    private static int zzx(Class<?> cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzdo.zza;
        Field zzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (zzz != null) {
            return zzz;
        }
        Field zzz2 = zzz(Buffer.class, "address");
        if (zzz2 == null || zzz2.getType() != Long.TYPE) {
            return null;
        }
        return zzz2;
    }

    private static Field zzz(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
