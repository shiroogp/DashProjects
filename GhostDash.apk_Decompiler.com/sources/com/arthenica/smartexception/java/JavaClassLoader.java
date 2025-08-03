package com.arthenica.smartexception.java;

import com.arthenica.smartexception.ClassLoader;

public class JavaClassLoader implements ClassLoader {
    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|(2:3|4)|5|6|(2:8|9)|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015 A[Catch:{ ClassNotFoundException | Error | IllegalStateException | SecurityException -> 0x001a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?> loadClass(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ ClassNotFoundException | SecurityException -> 0x000f }
            java.lang.ClassLoader r0 = r0.getContextClassLoader()     // Catch:{ ClassNotFoundException | SecurityException -> 0x000f }
            if (r0 == 0) goto L_0x000f
            java.lang.Class r2 = r0.loadClass(r2)     // Catch:{ ClassNotFoundException | SecurityException -> 0x000f }
            return r2
        L_0x000f:
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ ClassNotFoundException | Error | IllegalStateException | SecurityException -> 0x001a }
            if (r0 == 0) goto L_0x001a
            java.lang.Class r2 = r0.loadClass(r2)     // Catch:{ ClassNotFoundException | Error | IllegalStateException | SecurityException -> 0x001a }
            return r2
        L_0x001a:
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | LinkageError -> 0x001f }
            return r2
        L_0x001f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arthenica.smartexception.java.JavaClassLoader.loadClass(java.lang.String):java.lang.Class");
    }
}
