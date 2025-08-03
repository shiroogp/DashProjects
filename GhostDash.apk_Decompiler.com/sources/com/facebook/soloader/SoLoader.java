package com.facebook.soloader;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.nativeloader.NativeLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;

public class SoLoader {
    static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    private static final String SO_STORE_NAME_SPLIT = "lib-";
    static final boolean SYSTRACE_LIBRARY_LOADING;
    static final String TAG = "SoLoader";
    private static boolean isSystemApp;
    @Nullable
    private static ApplicationSoSource sApplicationSoSource;
    @Nullable
    private static UnpackingSoSource[] sBackupSoSources;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private */
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    /* access modifiers changed from: private */
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    @Nullable
    static SoFileLoader sSoFileLoader;
    /* access modifiers changed from: private */
    @Nullable
    public static SoSource[] sSoSources = null;
    /* access modifiers changed from: private */
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    private static volatile int sSoSourcesVersion = 0;
    @Nullable
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    static /* synthetic */ int access$208() {
        int i = sSoSourcesVersion;
        sSoSourcesVersion = i + 1;
        return i;
    }

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        SYSTRACE_LIBRARY_LOADING = z;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, (SoFileLoader) null);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            isSystemApp = checkIfSystemApp(context, i);
            initSoLoader(soFileLoader);
            initSoSources(context, i, soFileLoader);
            if (!NativeLoader.isInitialized()) {
                NativeLoader.init(new NativeLoaderToSoLoaderDelegate());
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initSoSources(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        int i2;
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                Log.d(TAG, "init start");
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = SysUtil.is64Bit() ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String str2 : str.split(":")) {
                    Log.d(TAG, "adding system library source: " + str2);
                    arrayList.add(new DirectorySoSource(new File(str2), 2));
                }
                if (context != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSources = null;
                        Log.d(TAG, "adding exo package source: lib-main");
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        if (isSystemApp) {
                            i2 = 0;
                        } else {
                            sApplicationSoSource = new ApplicationSoSource(context, Build.VERSION.SDK_INT <= 17 ? 1 : 0);
                            Log.d(TAG, "adding application source: " + sApplicationSoSource.toString());
                            arrayList.add(0, sApplicationSoSource);
                            i2 = 1;
                        }
                        if ((sFlags & 8) != 0) {
                            sBackupSoSources = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            ApkSoSource apkSoSource = new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i2);
                            arrayList2.add(apkSoSource);
                            Log.d(TAG, "adding backup source from : " + apkSoSource.toString());
                            if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d(TAG, "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < length) {
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, new File(strArr[i3]), SO_STORE_NAME_SPLIT + i4, i2);
                                    Log.d(TAG, "adding backup source: " + apkSoSource2.toString());
                                    arrayList2.add(apkSoSource2);
                                    i3++;
                                    i4++;
                                }
                            }
                            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length2 = soSourceArr.length;
                while (true) {
                    int i5 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    Log.d(TAG, "Preparing SO source: " + soSourceArr[i5]);
                    soSourceArr[i5].prepare(makePrepareFlags);
                    length2 = i5;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion++;
                Log.d(TAG, "init finish: " + sSoSources.length + " SO sources prepared");
            }
        } finally {
            Log.d(TAG, "init exiting");
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static int makePrepareFlags() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            int i = (sFlags & 2) != 0 ? 1 : 0;
            reentrantReadWriteLock.writeLock().unlock();
            return i;
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    private static synchronized void initSoLoader(@Nullable SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() {
                /* JADX WARNING: type inference failed for: r1v0 */
                /* JADX WARNING: type inference failed for: r1v12 */
                /* JADX WARNING: type inference failed for: r1v14 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                    if (r1 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
                    android.util.Log.e(com.facebook.soloader.SoLoader.TAG, "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r9) + " search path is " + r10);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
                    return;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void load(java.lang.String r9, int r10) {
                    /*
                        r8 = this;
                        boolean r0 = r2
                        if (r0 == 0) goto L_0x00d7
                        r0 = 4
                        r10 = r10 & r0
                        r1 = 1
                        r2 = 0
                        if (r10 != r0) goto L_0x000c
                        r10 = r1
                        goto L_0x000d
                    L_0x000c:
                        r10 = r2
                    L_0x000d:
                        if (r10 == 0) goto L_0x0012
                        java.lang.String r10 = r3
                        goto L_0x0014
                    L_0x0012:
                        java.lang.String r10 = r4
                    L_0x0014:
                        r0 = 0
                        java.lang.Runtime r3 = r5     // Catch:{ IllegalAccessException -> 0x0086, IllegalArgumentException -> 0x0084, InvocationTargetException -> 0x0082, all -> 0x007d }
                        monitor-enter(r3)     // Catch:{ IllegalAccessException -> 0x0086, IllegalArgumentException -> 0x0084, InvocationTargetException -> 0x0082, all -> 0x007d }
                        java.lang.reflect.Method r4 = r6     // Catch:{ all -> 0x006f }
                        java.lang.Runtime r5 = r5     // Catch:{ all -> 0x006f }
                        r6 = 3
                        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x006f }
                        r6[r2] = r9     // Catch:{ all -> 0x006f }
                        java.lang.Class<com.facebook.soloader.SoLoader> r2 = com.facebook.soloader.SoLoader.class
                        java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x006f }
                        r6[r1] = r2     // Catch:{ all -> 0x006f }
                        r1 = 2
                        r6[r1] = r10     // Catch:{ all -> 0x006f }
                        java.lang.Object r1 = r4.invoke(r5, r6)     // Catch:{ all -> 0x006f }
                        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x006f }
                        if (r1 != 0) goto L_0x0069
                        monitor-exit(r3)     // Catch:{ all -> 0x007b }
                        if (r1 == 0) goto L_0x00da
                        java.lang.String r0 = "SoLoader"
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Error when loading lib: "
                        java.lang.StringBuilder r2 = r2.append(r3)
                        java.lang.StringBuilder r1 = r2.append(r1)
                        java.lang.String r2 = " lib hash: "
                        java.lang.StringBuilder r1 = r1.append(r2)
                        java.lang.String r9 = r8.getLibHash(r9)
                        java.lang.StringBuilder r9 = r1.append(r9)
                        java.lang.String r1 = " search path is "
                        java.lang.StringBuilder r9 = r9.append(r1)
                        java.lang.StringBuilder r9 = r9.append(r10)
                        java.lang.String r9 = r9.toString()
                        android.util.Log.e(r0, r9)
                        goto L_0x00da
                    L_0x0069:
                        java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x007b }
                        r0.<init>(r1)     // Catch:{ all -> 0x007b }
                        throw r0     // Catch:{ all -> 0x007b }
                    L_0x006f:
                        r1 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                    L_0x0073:
                        monitor-exit(r3)     // Catch:{ all -> 0x007b }
                        throw r0     // Catch:{ IllegalAccessException -> 0x0079, IllegalArgumentException -> 0x0077, InvocationTargetException -> 0x0075 }
                    L_0x0075:
                        r0 = move-exception
                        goto L_0x008a
                    L_0x0077:
                        r0 = move-exception
                        goto L_0x008a
                    L_0x0079:
                        r0 = move-exception
                        goto L_0x008a
                    L_0x007b:
                        r0 = move-exception
                        goto L_0x0073
                    L_0x007d:
                        r1 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                        goto L_0x00a4
                    L_0x0082:
                        r1 = move-exception
                        goto L_0x0087
                    L_0x0084:
                        r1 = move-exception
                        goto L_0x0087
                    L_0x0086:
                        r1 = move-exception
                    L_0x0087:
                        r7 = r1
                        r1 = r0
                        r0 = r7
                    L_0x008a:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
                        r2.<init>()     // Catch:{ all -> 0x00a3 }
                        java.lang.String r3 = "Error: Cannot load "
                        java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00a3 }
                        java.lang.StringBuilder r2 = r2.append(r9)     // Catch:{ all -> 0x00a3 }
                        java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00a3 }
                        java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x00a3 }
                        r2.<init>(r1, r0)     // Catch:{ all -> 0x00a3 }
                        throw r2     // Catch:{ all -> 0x00a3 }
                    L_0x00a3:
                        r0 = move-exception
                    L_0x00a4:
                        if (r1 == 0) goto L_0x00d6
                        java.lang.String r2 = "SoLoader"
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        java.lang.String r4 = "Error when loading lib: "
                        java.lang.StringBuilder r3 = r3.append(r4)
                        java.lang.StringBuilder r1 = r3.append(r1)
                        java.lang.String r3 = " lib hash: "
                        java.lang.StringBuilder r1 = r1.append(r3)
                        java.lang.String r9 = r8.getLibHash(r9)
                        java.lang.StringBuilder r9 = r1.append(r9)
                        java.lang.String r1 = " search path is "
                        java.lang.StringBuilder r9 = r9.append(r1)
                        java.lang.StringBuilder r9 = r9.append(r10)
                        java.lang.String r9 = r9.toString()
                        android.util.Log.e(r2, r9)
                    L_0x00d6:
                        throw r0
                    L_0x00d7:
                        java.lang.System.load(r9)
                    L_0x00da:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.AnonymousClass1.load(java.lang.String, int):void");
                }

                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
                    if (r7 != null) goto L_0x003c;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                    r1.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
                    r1.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
                    throw r0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private java.lang.String getLibHash(java.lang.String r7) {
                    /*
                        r6 = this;
                        java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                        r0.<init>(r7)     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                        java.lang.String r7 = "MD5"
                        java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r7)     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                        r1.<init>(r0)     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                        r0 = 4096(0x1000, float:5.74E-42)
                        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0037 }
                    L_0x0014:
                        int r2 = r1.read(r0)     // Catch:{ all -> 0x0037 }
                        r3 = 0
                        if (r2 <= 0) goto L_0x001f
                        r7.update(r0, r3, r2)     // Catch:{ all -> 0x0037 }
                        goto L_0x0014
                    L_0x001f:
                        java.lang.String r0 = "%32x"
                        r2 = 1
                        java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0037 }
                        java.math.BigInteger r5 = new java.math.BigInteger     // Catch:{ all -> 0x0037 }
                        byte[] r7 = r7.digest()     // Catch:{ all -> 0x0037 }
                        r5.<init>(r2, r7)     // Catch:{ all -> 0x0037 }
                        r4[r3] = r5     // Catch:{ all -> 0x0037 }
                        java.lang.String r7 = java.lang.String.format(r0, r4)     // Catch:{ all -> 0x0037 }
                        r1.close()     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                        goto L_0x005a
                    L_0x0037:
                        r7 = move-exception
                        throw r7     // Catch:{ all -> 0x0039 }
                    L_0x0039:
                        r0 = move-exception
                        if (r7 == 0) goto L_0x0045
                        r1.close()     // Catch:{ all -> 0x0040 }
                        goto L_0x0048
                    L_0x0040:
                        r1 = move-exception
                        r7.addSuppressed(r1)     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                        goto L_0x0048
                    L_0x0045:
                        r1.close()     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                    L_0x0048:
                        throw r0     // Catch:{ IOException -> 0x0055, SecurityException -> 0x004f, NoSuchAlgorithmException -> 0x0049 }
                    L_0x0049:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                        goto L_0x005a
                    L_0x004f:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                        goto L_0x005a
                    L_0x0055:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                    L_0x005a:
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.AnonymousClass1.getLibHash(java.lang.String):java.lang.String");
                }
            };
        }
    }

    @Nullable
    private static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e) {
                Log.w(TAG, "Cannot get nativeLoad method", e);
            }
        }
        return null;
    }

    private static boolean checkIfSystemApp(Context context, int i) {
        return ((i & 32) != 0 || context == null || (context.getApplicationInfo().flags & 129) == 0) ? false : true;
    }

    public static void setInTestMode() {
        TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        TestOnlyUtils.setSoSources((SoSource[]) null);
    }

    static class TestOnlyUtils {
        TestOnlyUtils() {
        }

        static void setSoSources(SoSource[] soSourceArr) {
            SoLoader.sSoSourcesLock.writeLock().lock();
            try {
                SoSource[] unused = SoLoader.sSoSources = soSourceArr;
                SoLoader.access$208();
            } finally {
                SoLoader.sSoSourcesLock.writeLock().unlock();
            }
        }

        static void setSoFileLoader(SoFileLoader soFileLoader) {
            SoLoader.sSoFileLoader = soFileLoader;
        }

        static void resetStatus() {
            synchronized (SoLoader.class) {
                SoLoader.sLoadedLibraries.clear();
                SoLoader.sLoadingLibraries.clear();
                SoLoader.sSoFileLoader = null;
            }
            setSoSources((SoSource[]) null);
        }
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    @Nullable
    public static String getLibraryPath(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String str2 = null;
            if (sSoSources != null) {
                int i = 0;
                while (str2 == null) {
                    SoSource[] soSourceArr = sSoSources;
                    if (i >= soSourceArr.length) {
                        break;
                    }
                    str2 = soSourceArr[i].getLibraryPath(str);
                    i++;
                }
            }
            return str2;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static String[] getLibraryDependencies(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String[] strArr = null;
            if (sSoSources != null) {
                int i = 0;
                while (strArr == null) {
                    SoSource[] soSourceArr = sSoSources;
                    if (i >= soSourceArr.length) {
                        break;
                    }
                    strArr = soSourceArr[i].getLibraryDependencies(str);
                    i++;
                }
            }
            return strArr;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        z = !sLoadedLibraries.contains(str);
                        if (z) {
                            SystemLoadLibraryWrapper systemLoadLibraryWrapper2 = sSystemLoadLibraryWrapper;
                            if (systemLoadLibraryWrapper2 != null) {
                                systemLoadLibraryWrapper2.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return z;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            if (!isSystemApp || (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) == null) {
                String mapLibName = MergedSoMapping.mapLibName(str);
                return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i, (StrictMode.ThreadPolicy) null);
            }
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoNameImpl(str, (String) null, (String) null, i, threadPolicy);
    }

    private static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        boolean z2 = false;
        do {
            try {
                z2 = loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
                z = false;
                continue;
            } catch (UnsatisfiedLinkError e) {
                int i2 = sSoSourcesVersion;
                sSoSourcesLock.writeLock().lock();
                try {
                    z = true;
                    if (sApplicationSoSource == null || !sApplicationSoSource.checkAndMaybeUpdate()) {
                        z = false;
                    } else {
                        Log.w(TAG, "sApplicationSoSource updated during load: " + str + ", attempting load again.");
                        sSoSourcesVersion++;
                    }
                    sSoSourcesLock.writeLock().unlock();
                    if (sSoSourcesVersion == i2) {
                        throw e;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    sSoSourcesLock.writeLock().unlock();
                    throw th;
                }
            }
        } while (z);
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r3 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r1.contains(r9) == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (r11 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004b, code lost:
        if (r3 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        android.util.Log.d(TAG, "About to load: " + r9);
        doLoadLibraryBySoName(r9, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        android.util.Log.d(TAG, "Loaded: " + r9);
        r1.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0089, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x008a, code lost:
        r10 = r9.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008e, code lost:
        if (r10 == null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a9, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r9, r10.substring(r10.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00aa, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00b0, code lost:
        if ((r12 & 16) != 0) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b6, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00be, code lost:
        if (sLoadedAndMergedLibraries.contains(r10) == false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c0, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c1, code lost:
        if (r11 == null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00c3, code lost:
        if (r2 != false) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00c5, code lost:
        r11 = SYSTRACE_LIBRARY_LOADING;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00c7, code lost:
        if (r11 == false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00c9, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r10, "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        android.util.Log.d(TAG, "About to merge: " + r10 + " / " + r9);
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r10);
        sLoadedAndMergedLibraries.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00fa, code lost:
        if (r11 == false) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0100, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0102, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x012b, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r10 + "', which has been merged into '" + r9 + "'.  See comment for details.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x012e, code lost:
        if (SYSTRACE_LIBRARY_LOADING != false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0130, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0133, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0134, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0137, code lost:
        return !r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadLibraryBySoNameImpl(java.lang.String r9, @javax.annotation.Nullable java.lang.String r10, @javax.annotation.Nullable java.lang.String r11, int r12, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r13) {
        /*
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            r2 = 0
            if (r1 != 0) goto L_0x0012
            java.util.Set<java.lang.String> r1 = sLoadedAndMergedLibraries
            boolean r1 = r1.contains(r10)
            if (r1 == 0) goto L_0x0012
            return r2
        L_0x0012:
            monitor-enter(r0)
            java.util.HashSet<java.lang.String> r1 = sLoadedLibraries     // Catch:{ all -> 0x013b }
            boolean r3 = r1.contains(r9)     // Catch:{ all -> 0x013b }
            r4 = 1
            if (r3 == 0) goto L_0x0022
            if (r11 != 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x013b }
            return r2
        L_0x0020:
            r3 = r4
            goto L_0x0023
        L_0x0022:
            r3 = r2
        L_0x0023:
            java.util.Map<java.lang.String, java.lang.Object> r5 = sLoadingLibraries     // Catch:{ all -> 0x013b }
            boolean r6 = r5.containsKey(r9)     // Catch:{ all -> 0x013b }
            if (r6 == 0) goto L_0x0030
            java.lang.Object r5 = r5.get(r9)     // Catch:{ all -> 0x013b }
            goto L_0x0039
        L_0x0030:
            java.lang.Object r6 = new java.lang.Object     // Catch:{ all -> 0x013b }
            r6.<init>()     // Catch:{ all -> 0x013b }
            r5.put(r9, r6)     // Catch:{ all -> 0x013b }
            r5 = r6
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x013b }
            monitor-enter(r5)
            if (r3 != 0) goto L_0x00ae
            monitor-enter(r0)     // Catch:{ all -> 0x0138 }
            boolean r6 = r1.contains(r9)     // Catch:{ all -> 0x00ab }
            if (r6 == 0) goto L_0x004a
            if (r11 != 0) goto L_0x0049
            monitor-exit(r0)     // Catch:{ all -> 0x00ab }
            monitor-exit(r5)     // Catch:{ all -> 0x0138 }
            return r2
        L_0x0049:
            r3 = r4
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x00ab }
            if (r3 != 0) goto L_0x00ae
            java.lang.String r6 = "SoLoader"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            java.lang.String r8 = "About to load: "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            android.util.Log.d(r6, r7)     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            doLoadLibraryBySoName(r9, r12, r13)     // Catch:{ UnsatisfiedLinkError -> 0x0089 }
            monitor-enter(r0)     // Catch:{ all -> 0x0138 }
            java.lang.String r13 = "SoLoader"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r6.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r7 = "Loaded: "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r6 = r6.append(r9)     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0086 }
            android.util.Log.d(r13, r6)     // Catch:{ all -> 0x0086 }
            r1.add(r9)     // Catch:{ all -> 0x0086 }
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            goto L_0x00ae
        L_0x0086:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            throw r9     // Catch:{ all -> 0x0138 }
        L_0x0089:
            r9 = move-exception
            java.lang.String r10 = r9.getMessage()     // Catch:{ all -> 0x0138 }
            if (r10 == 0) goto L_0x00aa
            java.lang.String r11 = "unexpected e_machine:"
            boolean r11 = r10.contains(r11)     // Catch:{ all -> 0x0138 }
            if (r11 == 0) goto L_0x00aa
            java.lang.String r11 = "unexpected e_machine:"
            int r11 = r10.lastIndexOf(r11)     // Catch:{ all -> 0x0138 }
            java.lang.String r10 = r10.substring(r11)     // Catch:{ all -> 0x0138 }
            com.facebook.soloader.SoLoader$WrongAbiError r11 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x0138 }
            r11.<init>(r9, r10)     // Catch:{ all -> 0x0138 }
            throw r11     // Catch:{ all -> 0x0138 }
        L_0x00aa:
            throw r9     // Catch:{ all -> 0x0138 }
        L_0x00ab:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ab }
            throw r9     // Catch:{ all -> 0x0138 }
        L_0x00ae:
            r12 = r12 & 16
            if (r12 != 0) goto L_0x0134
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0138 }
            if (r12 != 0) goto L_0x00c1
            java.util.Set<java.lang.String> r12 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x0138 }
            boolean r12 = r12.contains(r10)     // Catch:{ all -> 0x0138 }
            if (r12 == 0) goto L_0x00c1
            r2 = r4
        L_0x00c1:
            if (r11 == 0) goto L_0x0134
            if (r2 != 0) goto L_0x0134
            boolean r11 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0138 }
            if (r11 == 0) goto L_0x00d0
            java.lang.String r12 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r13 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r12, r10, r13)     // Catch:{ all -> 0x0138 }
        L_0x00d0:
            java.lang.String r12 = "SoLoader"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            r13.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            java.lang.String r0 = "About to merge: "
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            java.lang.StringBuilder r13 = r13.append(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            java.lang.String r0 = " / "
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            java.lang.StringBuilder r13 = r13.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            java.lang.String r13 = r13.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            android.util.Log.d(r12, r13)     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            com.facebook.soloader.MergedSoMapping.invokeJniOnload(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            java.util.Set<java.lang.String> r12 = sLoadedAndMergedLibraries     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            r12.add(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0102 }
            if (r11 == 0) goto L_0x0134
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x0138 }
            goto L_0x0134
        L_0x0100:
            r9 = move-exception
            goto L_0x012c
        L_0x0102:
            r11 = move-exception
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ all -> 0x0100 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0100 }
            r13.<init>()     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "Failed to call JNI_OnLoad from '"
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch:{ all -> 0x0100 }
            java.lang.StringBuilder r10 = r13.append(r10)     // Catch:{ all -> 0x0100 }
            java.lang.String r13 = "', which has been merged into '"
            java.lang.StringBuilder r10 = r10.append(r13)     // Catch:{ all -> 0x0100 }
            java.lang.StringBuilder r9 = r10.append(r9)     // Catch:{ all -> 0x0100 }
            java.lang.String r10 = "'.  See comment for details."
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x0100 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0100 }
            r12.<init>(r9, r11)     // Catch:{ all -> 0x0100 }
            throw r12     // Catch:{ all -> 0x0100 }
        L_0x012c:
            boolean r10 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0138 }
            if (r10 == 0) goto L_0x0133
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x0138 }
        L_0x0133:
            throw r9     // Catch:{ all -> 0x0138 }
        L_0x0134:
            monitor-exit(r5)     // Catch:{ all -> 0x0138 }
            r9 = r3 ^ 1
            return r9
        L_0x0138:
            r9 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0138 }
            throw r9
        L_0x013b:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x013b }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoNameImpl(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doLoadLibraryBySoName(java.lang.String r16, int r17, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r18) throws java.lang.UnsatisfiedLinkError {
        /*
            r1 = r16
            r0 = r17
            java.lang.String r2 = "\n"
            java.lang.String r3 = "\n\tNative lib dir: "
            java.lang.String r4 = " result: "
            java.lang.String r5 = ": "
            java.lang.String r6 = "\n\tSoSource "
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r8 = r7.readLock()
            r8.lock()
            com.facebook.soloader.SoSource[] r8 = sSoSources     // Catch:{ all -> 0x01f2 }
            java.lang.String r9 = "couldn't find DSO to load: "
            java.lang.String r10 = "SoLoader"
            if (r8 == 0) goto L_0x01bf
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r8 = r7.readLock()
            r8.unlock()
            if (r18 != 0) goto L_0x002e
            android.os.StrictMode$ThreadPolicy r12 = android.os.StrictMode.allowThreadDiskReads()
            r13 = 1
            goto L_0x0031
        L_0x002e:
            r12 = r18
            r13 = 0
        L_0x0031:
            boolean r14 = SYSTRACE_LIBRARY_LOADING
            if (r14 == 0) goto L_0x003c
            java.lang.String r14 = "SoLoader.loadLibrary["
            java.lang.String r15 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r14, r1, r15)
        L_0x003c:
            r14 = 3
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r7 = r7.readLock()     // Catch:{ all -> 0x0123 }
            r7.lock()     // Catch:{ all -> 0x0123 }
            r7 = 0
            r15 = 0
        L_0x0046:
            if (r7 != 0) goto L_0x009b
            com.facebook.soloader.SoSource[] r11 = sSoSources     // Catch:{ all -> 0x0090 }
            int r8 = r11.length     // Catch:{ all -> 0x0090 }
            if (r15 >= r8) goto L_0x009b
            r8 = r11[r15]     // Catch:{ all -> 0x0090 }
            int r7 = r8.loadLibrary(r1, r0, r12)     // Catch:{ all -> 0x0090 }
            if (r7 != r14) goto L_0x0089
            com.facebook.soloader.UnpackingSoSource[] r8 = sBackupSoSources     // Catch:{ all -> 0x0090 }
            if (r8 == 0) goto L_0x0089
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r8.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r11 = "Trying backup SoSource for "
            java.lang.StringBuilder r8 = r8.append(r11)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r8 = r8.append(r1)     // Catch:{ all -> 0x0090 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0090 }
            android.util.Log.d(r10, r8)     // Catch:{ all -> 0x0090 }
            com.facebook.soloader.UnpackingSoSource[] r8 = sBackupSoSources     // Catch:{ all -> 0x0090 }
            int r11 = r8.length     // Catch:{ all -> 0x0090 }
            r15 = 0
        L_0x0073:
            if (r15 >= r11) goto L_0x009b
            r14 = r8[r15]     // Catch:{ all -> 0x0090 }
            r14.prepare((java.lang.String) r1)     // Catch:{ all -> 0x0090 }
            int r14 = r14.loadLibrary(r1, r0, r12)     // Catch:{ all -> 0x0090 }
            r0 = 1
            if (r14 != r0) goto L_0x0083
            r7 = r14
            goto L_0x009b
        L_0x0083:
            int r15 = r15 + 1
            r0 = r17
            r14 = 3
            goto L_0x0073
        L_0x0089:
            r0 = 1
            int r15 = r15 + 1
            r0 = r17
            r14 = 3
            goto L_0x0046
        L_0x0090:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r8 = sSoSourcesLock     // Catch:{ all -> 0x0121 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r8 = r8.readLock()     // Catch:{ all -> 0x0121 }
            r8.unlock()     // Catch:{ all -> 0x0121 }
            throw r0     // Catch:{ all -> 0x0121 }
        L_0x009b:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock     // Catch:{ all -> 0x0121 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r8 = r0.readLock()     // Catch:{ all -> 0x0121 }
            r8.unlock()     // Catch:{ all -> 0x0121 }
            boolean r8 = SYSTRACE_LIBRARY_LOADING
            if (r8 == 0) goto L_0x00ab
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x00ab:
            if (r13 == 0) goto L_0x00b0
            android.os.StrictMode.setThreadPolicy(r12)
        L_0x00b0:
            if (r7 == 0) goto L_0x00b5
            r8 = 3
            if (r7 != r8) goto L_0x0137
        L_0x00b5:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r1 = r8.append(r1)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            r11 = 0
        L_0x00ca:
            com.facebook.soloader.SoSource[] r0 = sSoSources
            int r0 = r0.length
            if (r11 >= r0) goto L_0x00e9
            java.lang.StringBuilder r0 = r1.append(r6)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r5)
            com.facebook.soloader.SoSource[] r8 = sSoSources
            r8 = r8[r11]
            java.lang.String r8 = r8.toString()
            r0.append(r8)
            int r11 = r11 + 1
            goto L_0x00ca
        L_0x00e9:
            com.facebook.soloader.ApplicationSoSource r0 = sApplicationSoSource
            if (r0 == 0) goto L_0x0104
            android.content.Context r0 = r0.getUpdatedContext()
            java.io.File r0 = com.facebook.soloader.ApplicationSoSource.getNativeLibDirFromContext(r0)
            java.lang.StringBuilder r3 = r1.append(r3)
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.StringBuilder r0 = r3.append(r0)
            r0.append(r2)
        L_0x0104:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            java.lang.StringBuilder r0 = r1.append(r4)
            r0.append(r7)
            java.lang.String r0 = r1.toString()
            android.util.Log.e(r10, r0)
            java.lang.UnsatisfiedLinkError r1 = new java.lang.UnsatisfiedLinkError
            r1.<init>(r0)
            throw r1
        L_0x0121:
            r0 = move-exception
            goto L_0x0125
        L_0x0123:
            r0 = move-exception
            r7 = 0
        L_0x0125:
            boolean r8 = SYSTRACE_LIBRARY_LOADING
            if (r8 == 0) goto L_0x012c
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x012c:
            if (r13 == 0) goto L_0x0131
            android.os.StrictMode.setThreadPolicy(r12)
        L_0x0131:
            if (r7 == 0) goto L_0x0138
            r8 = 3
            if (r7 != r8) goto L_0x0137
            goto L_0x0138
        L_0x0137:
            return
        L_0x0138:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r1 = r8.append(r1)
            if (r0 == 0) goto L_0x015e
            java.lang.String r2 = r0.getMessage()
            if (r2 != 0) goto L_0x0151
            java.lang.String r2 = r0.toString()
        L_0x0151:
            java.lang.String r3 = " caused by: "
            java.lang.StringBuilder r3 = r1.append(r3)
            r3.append(r2)
            r0.printStackTrace()
            goto L_0x01ab
        L_0x015e:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            r11 = 0
        L_0x0168:
            com.facebook.soloader.SoSource[] r0 = sSoSources
            int r0 = r0.length
            if (r11 >= r0) goto L_0x0187
            java.lang.StringBuilder r0 = r1.append(r6)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r5)
            com.facebook.soloader.SoSource[] r8 = sSoSources
            r8 = r8[r11]
            java.lang.String r8 = r8.toString()
            r0.append(r8)
            int r11 = r11 + 1
            goto L_0x0168
        L_0x0187:
            com.facebook.soloader.ApplicationSoSource r0 = sApplicationSoSource
            if (r0 == 0) goto L_0x01a2
            android.content.Context r0 = r0.getUpdatedContext()
            java.io.File r0 = com.facebook.soloader.ApplicationSoSource.getNativeLibDirFromContext(r0)
            java.lang.StringBuilder r3 = r1.append(r3)
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.StringBuilder r0 = r3.append(r0)
            r0.append(r2)
        L_0x01a2:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
        L_0x01ab:
            java.lang.StringBuilder r0 = r1.append(r4)
            r0.append(r7)
            java.lang.String r0 = r1.toString()
            android.util.Log.e(r10, r0)
            java.lang.UnsatisfiedLinkError r1 = new java.lang.UnsatisfiedLinkError
            r1.<init>(r0)
            throw r1
        L_0x01bf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f2 }
            r0.<init>()     // Catch:{ all -> 0x01f2 }
            java.lang.String r2 = "Could not load: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x01f2 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x01f2 }
            java.lang.String r2 = " because no SO source exists"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x01f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01f2 }
            android.util.Log.e(r10, r0)     // Catch:{ all -> 0x01f2 }
            java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x01f2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f2 }
            r2.<init>()     // Catch:{ all -> 0x01f2 }
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch:{ all -> 0x01f2 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x01f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01f2 }
            r0.<init>(r1)     // Catch:{ all -> 0x01f2 }
            throw r0     // Catch:{ all -> 0x01f2 }
        L_0x01f2:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.doLoadLibraryBySoName(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource unpackLibrary : sSoSources) {
                File unpackLibrary2 = unpackLibrary.unpackLibrary(str);
                if (unpackLibrary2 != null) {
                    return unpackLibrary2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new RuntimeException("SoLoader.init() not yet called");
        }
    }

    public static boolean isInitialized() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            boolean z = sSoSources != null;
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion;
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            Log.d(TAG, "Prepending to SO sources: " + soSource);
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = sSoSources;
            SoSource[] soSourceArr2 = new SoSource[(soSourceArr.length + 1)];
            soSourceArr2[0] = soSource;
            System.arraycopy(soSourceArr, 0, soSourceArr2, 1, soSourceArr.length);
            sSoSources = soSourceArr2;
            sSoSourcesVersion++;
            Log.d(TAG, "Prepended to SO sources: " + soSource);
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            Log.d(TAG, "makeLdLibraryPath");
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            if (soSourceArr != null) {
                for (SoSource addToLdLibraryPath : soSourceArr) {
                    addToLdLibraryPath.addToLdLibraryPath(arrayList);
                }
            }
            String join = TextUtils.join(":", arrayList);
            Log.d(TAG, "makeLdLibraryPath final path: " + join);
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean areSoSourcesAbisSupported() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSourceAbis : sSoSources) {
                    String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
                    int length = soSourceAbis2.length;
                    int i = 0;
                    while (i < length) {
                        String str = soSourceAbis2[i];
                        boolean z = false;
                        for (int i2 = 0; i2 < supportedAbis.length && !z; i2++) {
                            z = str.equals(supportedAbis[i2]);
                        }
                        if (!z) {
                            Log.e(TAG, "abi not supported: " + str);
                            reentrantReadWriteLock = sSoSourcesLock;
                        } else {
                            i++;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            reentrantReadWriteLock.readLock().unlock();
            return false;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    private static class Api14Utils {
        private Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            } else {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
        }
    }
}
