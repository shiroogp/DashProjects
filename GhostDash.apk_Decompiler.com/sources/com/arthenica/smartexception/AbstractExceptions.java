package com.arthenica.smartexception;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractExceptions {
    public static final boolean DEFAULT_IGNORE_ALL_CAUSES = false;
    public static final int DEFAULT_MAX_DEPTH = 10;
    public static final boolean DEFAULT_PRINT_PACKAGE_INFORMATION = false;
    public static final Set<String> groupPackageSet = Collections.synchronizedSet(new HashSet());
    public static boolean ignoreAllCauses = false;
    public static final Set<String> ignoreCausePackageSet = Collections.synchronizedSet(new HashSet());
    public static final Set<String> ignorePackageSet = Collections.synchronizedSet(new HashSet());
    public static boolean printPackageInformation = false;
    public static final Set<String> rootPackageSet = Collections.synchronizedSet(new HashSet());
    public static StackTraceElementSerializer stackTraceElementSerializer;

    public static void registerRootPackage(String str) {
        rootPackageSet.add(str);
    }

    public static void clearRootPackages() {
        rootPackageSet.clear();
    }

    public static void registerGroupPackage(String str) {
        groupPackageSet.add(str);
    }

    public static void clearGroupPackages() {
        groupPackageSet.clear();
    }

    public static StackTraceElementSerializer getStackTraceElementSerializer() {
        return stackTraceElementSerializer;
    }

    public static void setStackTraceElementSerializer(StackTraceElementSerializer stackTraceElementSerializer2) {
        stackTraceElementSerializer = stackTraceElementSerializer2;
    }

    public static void registerIgnorePackage(String str, boolean z) {
        ignorePackageSet.add(str);
        if (z) {
            ignoreCausePackageSet.add(str);
        }
    }

    public static void clearIgnorePackages() {
        ignorePackageSet.clear();
        ignoreCausePackageSet.clear();
    }

    public static boolean getIgnoreAllCauses() {
        return ignoreAllCauses;
    }

    public static void setIgnoreAllCauses(boolean z) {
        ignoreAllCauses = z;
    }

    public static boolean isPrintPackageInformation() {
        return printPackageInformation;
    }

    public static void setPrintPackageInformation(boolean z) {
        printPackageInformation = z;
    }

    public static String getStackTraceString(Throwable th) {
        return getStackTraceString(th, false, rootPackageSet, groupPackageSet, ignorePackageSet, 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(Throwable th, boolean z) {
        return getStackTraceString(th, false, rootPackageSet, groupPackageSet, ignorePackageSet, 0, z, printPackageInformation);
    }

    public static String getStackTraceString(Throwable th, Set<String> set, Set<String> set2, Set<String> set3) {
        return getStackTraceString(th, false, set, set2, set3, 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(Throwable th, Set<String> set, Set<String> set2, Set<String> set3, boolean z) {
        return getStackTraceString(th, false, set, set2, set3, 0, z, printPackageInformation);
    }

    public static String getStackTraceString(Throwable th, Set<String> set, Set<String> set2, Set<String> set3, boolean z, boolean z2) {
        return getStackTraceString(th, false, set, set2, set3, 0, z, z2);
    }

    public static String getStackTraceString(Throwable th, String str) {
        return getStackTraceString(th, false, Collections.singleton(str), new HashSet(), new HashSet(), 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(Throwable th, String str, String str2) {
        return getStackTraceString(th, false, Collections.singleton(str), Collections.singleton(str2), new HashSet(), 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(Throwable th, int i) {
        return getStackTraceString(th, false, new HashSet(), new HashSet(), new HashSet(), i, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(Throwable th, int i, boolean z) {
        return getStackTraceString(th, false, new HashSet(), new HashSet(), new HashSet(), i, z, printPackageInformation);
    }

    public static String getStackTraceString(Throwable th, int i, boolean z, boolean z2) {
        return getStackTraceString(th, false, new HashSet(), new HashSet(), new HashSet(), i, z, z2);
    }

    public static String getStackTraceString(Throwable th, boolean z, Set<String> set, Set<String> set2, Set<String> set3, int i, boolean z2, boolean z3) {
        StackTraceElement[] stackTraceElementArr;
        Throwable th2 = th;
        int i2 = i;
        boolean z4 = z3;
        StringBuilder sb = new StringBuilder();
        if (th2 == null) {
            return "";
        }
        String name = th.getClass().getName();
        if (i2 > 0) {
            Set<String> set4 = set3;
            stackTraceElementArr = getStackTrace(th2, i2);
            Set<String> set5 = set;
        } else {
            stackTraceElementArr = getStackTrace(th2, set, set3);
        }
        String localizedMessage = th.getLocalizedMessage();
        if (isEmpty(localizedMessage)) {
            localizedMessage = th.getMessage();
        }
        if (z) {
            sb.append(System.lineSeparator());
            sb.append("Caused by: ");
            sb.append(name);
            if (!isEmpty(localizedMessage)) {
                sb.append(": ");
                sb.append(localizedMessage);
            }
        } else {
            sb.append(System.lineSeparator());
            sb.append(name);
            if (!isEmpty(localizedMessage)) {
                sb.append(": ");
                sb.append(localizedMessage);
            }
        }
        int length = stackTraceElementArr.length;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        StackTraceElement stackTraceElement = null;
        while (i3 < length) {
            StackTraceElement stackTraceElement2 = stackTraceElementArr[i3];
            String containingPackage = getContainingPackage(stackTraceElement2.getClassName(), set2);
            if (containingPackage == null) {
                i4 = appendStackTraceGroupElement(sb, str, i4, stackTraceElement, z4);
                sb.append(System.lineSeparator());
                sb.append("\tat ");
                StackTraceElementSerializer stackTraceElementSerializer2 = stackTraceElementSerializer;
                if (stackTraceElementSerializer2 != null) {
                    sb.append(stackTraceElementSerializer2.toString(stackTraceElement2, z4));
                    str = null;
                } else {
                    throw new IllegalArgumentException("Stack trace element serializer not initialized.");
                }
            } else if (!containingPackage.equals(str)) {
                appendStackTraceGroupElement(sb, str, i4, stackTraceElement, z4);
                sb.append(System.lineSeparator());
                sb.append("\tat ");
                i4 = 1;
                stackTraceElement = stackTraceElement2;
                str = containingPackage;
            } else {
                i4++;
            }
            i3++;
            Throwable th3 = th;
        }
        Set<String> set6 = set2;
        appendStackTraceGroupElement(sb, str, i4, stackTraceElement, z4);
        Throwable cause = th.getCause();
        if (cause != null && !containsPackage(name, ignoreCausePackageSet) && !z2) {
            sb.append(getStackTraceString(cause, true, set, set2, set3, i, z2, z3));
        }
        return sb.toString();
    }

    public static int appendStackTraceGroupElement(StringBuilder sb, String str, int i, StackTraceElement stackTraceElement, boolean z) {
        if (i > 0) {
            StackTraceElementSerializer stackTraceElementSerializer2 = stackTraceElementSerializer;
            if (stackTraceElementSerializer2 == null) {
                throw new IllegalArgumentException("Stack trace element serializer not initialized.");
            } else if (i == 1) {
                sb.append(stackTraceElementSerializer2.toString(stackTraceElement, z));
            } else {
                sb.append(String.format("%s%s ... %d more", new Object[]{stackTraceElementSerializer2.getModuleName(stackTraceElement), str, Integer.valueOf(i - 1)}));
                if (z) {
                    sb.append(stackTraceElementSerializer.getPackageInformation(stackTraceElement));
                }
            }
        }
        return 0;
    }

    public static boolean containsPackage(String str, Set<String> set) {
        return getContainingPackage(str, set) != null;
    }

    public static String getContainingPackage(String str, Set<String> set) {
        for (String next : set) {
            if (str.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    public static String getAllMessages(Throwable th) {
        StringBuilder sb = new StringBuilder();
        getAllMessages(th, sb);
        return sb.toString();
    }

    public static void getAllMessages(Throwable th, StringBuilder sb) {
        if (th != null) {
            String message = th.getMessage();
            if (!isEmpty(message)) {
                if (sb.length() != 0) {
                    sb.append(System.lineSeparator());
                    sb.append(" - Caused by: ");
                }
                sb.append(message);
            }
            getAllMessages(th.getCause(), sb);
        }
    }

    public static StackTraceElement[] getStackTrace(Throwable th, int i) {
        ArrayList arrayList = new ArrayList();
        if (th != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i2 = 0;
            while (i2 < stackTrace.length && i2 < i) {
                arrayList.add(stackTrace[i2]);
                i2++;
            }
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]);
    }

    public static StackTraceElement[] getStackTrace(Throwable th, Set<String> set, Set<String> set2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                if (!isEmpty(className)) {
                    if (containsPackage(className, set)) {
                        arrayList.addAll(arrayList2);
                        arrayList.add(stackTraceElement);
                    } else if (!containsPackage(className, set2)) {
                        arrayList2.add(stackTraceElement);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(arrayList2);
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]);
    }

    public static boolean containsCause(Throwable th, Class<?> cls) {
        return containsCause(th, cls, (String) null);
    }

    public static boolean containsCause(Throwable th, Class<?> cls, String str) {
        return searchCause(th, cls, str, 10) != null;
    }

    public static Throwable getCause(Throwable th) {
        return getCause(th, 10);
    }

    public static Throwable getCause(Throwable th, int i) {
        Throwable cause;
        if (th == null) {
            return null;
        }
        if (i > 0 && (cause = th.getCause()) != null) {
            return getCause(cause, i - 1);
        }
        return th;
    }

    public static Throwable searchCause(Throwable th, Class<?> cls) {
        return searchCause(th, cls, (String) null, 10);
    }

    public static Throwable searchCause(Throwable th, Class<?> cls, String str) {
        return searchCause(th, cls, str, 10);
    }

    public static Throwable searchCause(Throwable th, Class<?> cls, String str, int i) {
        Throwable cause;
        if (th == null) {
            return null;
        }
        if (isEmpty(str)) {
            if (th.getClass().equals(cls)) {
                return th;
            }
        } else if (th.getClass().equals(cls) && getAllMessages(th).toLowerCase().contains(str.toLowerCase())) {
            return th;
        }
        if (i > 0 && (cause = th.getCause()) != null) {
            return searchCause(cause, cls, str, i - 1);
        }
        return null;
    }

    public static Throwable searchCause(Throwable th, Class<?> cls, int i) {
        Throwable cause;
        if (th == null) {
            return null;
        }
        if (th.getClass().equals(cls)) {
            return th;
        }
        if (i > 0 && (cause = th.getCause()) != null) {
            return searchCause(cause, cls, i - 1);
        }
        return null;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String packageName(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(".")) >= 0) {
            return str.substring(0, lastIndexOf);
        }
        return "";
    }

    public static String getVersion(PackageLoader packageLoader, Class<?> cls, String str) {
        try {
            Package packageR = cls.getPackage();
            if (packageR != null) {
                return packageR.getImplementationVersion();
            }
            Package packageR2 = packageLoader.getPackage(cls.getClassLoader(), str);
            if (packageR2 != null) {
                return packageR2.getImplementationVersion();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String libraryName(Class<?> cls) {
        String url;
        int lastIndexOf;
        if (cls == null) {
            return null;
        }
        try {
            URL resource = cls.getClassLoader().getResource(cls.getName().replace('.', '/') + ".class");
            if (resource == null || (lastIndexOf = url.lastIndexOf(33)) <= 0) {
                return null;
            }
            String substring = (url = resource.toString()).substring(0, lastIndexOf);
            int lastIndexOf2 = substring.lastIndexOf(47);
            if (lastIndexOf2 > 0) {
                substring = substring.substring(lastIndexOf2 + 1);
            }
            int lastIndexOf3 = substring.lastIndexOf(92);
            return lastIndexOf3 > 0 ? substring.substring(lastIndexOf3 + 1) : substring;
        } catch (Exception unused) {
            return null;
        }
    }
}
