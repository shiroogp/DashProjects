package com.arthenica.smartexception.java;

import com.arthenica.smartexception.AbstractExceptions;
import com.arthenica.smartexception.ClassLoader;
import com.arthenica.smartexception.PackageLoader;
import com.arthenica.smartexception.StackTraceElementSerializer;
import java.util.Set;

public class Exceptions {
    static ClassLoader classLoader = new JavaClassLoader();
    static PackageLoader packageLoader = new JavaPackageLoader();

    static {
        AbstractExceptions.setStackTraceElementSerializer(new StackTraceElementSerializer() {
            public String getModuleName(StackTraceElement stackTraceElement) {
                return "";
            }

            public String getNativeMethodDefinition() {
                return "(Native Method)";
            }

            public String getUnknownSourceDefinition() {
                return "(Unknown Source)";
            }

            public String toString(StackTraceElement stackTraceElement, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append(stackTraceElement.getClassName());
                sb.append(".");
                sb.append(stackTraceElement.getMethodName());
                if (stackTraceElement.isNativeMethod()) {
                    sb.append(getNativeMethodDefinition());
                } else if (stackTraceElement.getFileName() == null || stackTraceElement.getFileName().length() <= 0) {
                    sb.append(getUnknownSourceDefinition());
                } else {
                    sb.append("(");
                    sb.append(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sb.append(":");
                        sb.append(stackTraceElement.getLineNumber());
                    }
                    sb.append(")");
                }
                if (z) {
                    sb.append(getPackageInformation(stackTraceElement));
                }
                return sb.toString();
            }

            public String getPackageInformation(StackTraceElement stackTraceElement) {
                StringBuilder sb = new StringBuilder();
                String className = stackTraceElement.getClassName();
                Class<?> loadClass = Exceptions.classLoader.loadClass(className);
                if (loadClass != null) {
                    String libraryName = AbstractExceptions.libraryName(loadClass);
                    String version = AbstractExceptions.getVersion(Exceptions.packageLoader, loadClass, AbstractExceptions.packageName(className));
                    if (!(libraryName == null && version == null)) {
                        sb.append(" [");
                        sb.append(libraryName);
                        if (!(libraryName == null || version == null || libraryName.contains(version))) {
                            sb.append(":");
                            sb.append(version);
                        }
                        sb.append("]");
                    }
                }
                return sb.toString();
            }
        });
    }

    public static void registerRootPackage(String str) {
        AbstractExceptions.registerRootPackage(str);
    }

    public static void clearRootPackages() {
        AbstractExceptions.clearRootPackages();
    }

    public static void registerGroupPackage(String str) {
        AbstractExceptions.registerGroupPackage(str);
    }

    public static void clearGroupPackages() {
        AbstractExceptions.clearGroupPackages();
    }

    public static StackTraceElementSerializer getStackTraceElementSerializer() {
        return AbstractExceptions.getStackTraceElementSerializer();
    }

    public static void setStackTraceElementSerializer(StackTraceElementSerializer stackTraceElementSerializer) {
        AbstractExceptions.setStackTraceElementSerializer(stackTraceElementSerializer);
    }

    public static void registerIgnorePackage(String str, boolean z) {
        AbstractExceptions.registerIgnorePackage(str, z);
    }

    public static void clearIgnorePackages() {
        AbstractExceptions.clearIgnorePackages();
    }

    public static boolean getIgnoreAllCauses() {
        return AbstractExceptions.getIgnoreAllCauses();
    }

    public static void setIgnoreAllCauses(boolean z) {
        AbstractExceptions.setIgnoreAllCauses(z);
    }

    public static boolean isPrintPackageInformation() {
        return AbstractExceptions.isPrintPackageInformation();
    }

    public static void setPrintPackageInformation(boolean z) {
        AbstractExceptions.setPrintPackageInformation(z);
    }

    public static String getStackTraceString(Throwable th) {
        return AbstractExceptions.getStackTraceString(th);
    }

    public static String getStackTraceString(Throwable th, boolean z) {
        return AbstractExceptions.getStackTraceString(th, z);
    }

    public static String getStackTraceString(Throwable th, Set<String> set, Set<String> set2, Set<String> set3) {
        return AbstractExceptions.getStackTraceString(th, set, set2, set3);
    }

    public static String getStackTraceString(Throwable th, Set<String> set, Set<String> set2, Set<String> set3, boolean z) {
        return AbstractExceptions.getStackTraceString(th, set, set2, set3, z);
    }

    public static String getStackTraceString(Throwable th, Set<String> set, Set<String> set2, Set<String> set3, boolean z, boolean z2) {
        return AbstractExceptions.getStackTraceString(th, set, set2, set3, z, z2);
    }

    public static String getStackTraceString(Throwable th, String str) {
        return AbstractExceptions.getStackTraceString(th, str);
    }

    public static String getStackTraceString(Throwable th, String str, String str2) {
        return AbstractExceptions.getStackTraceString(th, str, str2);
    }

    public static String getStackTraceString(Throwable th, int i) {
        return AbstractExceptions.getStackTraceString(th, i);
    }

    public static String getStackTraceString(Throwable th, int i, boolean z) {
        return AbstractExceptions.getStackTraceString(th, i, z);
    }

    public static String getStackTraceString(Throwable th, int i, boolean z, boolean z2) {
        return AbstractExceptions.getStackTraceString(th, i, z, z2);
    }

    public static String getAllMessages(Throwable th) {
        return AbstractExceptions.getAllMessages(th);
    }

    public static boolean containsCause(Throwable th, Class<?> cls) {
        return AbstractExceptions.containsCause(th, cls);
    }

    public static boolean containsCause(Throwable th, Class<?> cls, String str) {
        return AbstractExceptions.containsCause(th, cls, str);
    }

    public static Throwable getCause(Throwable th) {
        return AbstractExceptions.getCause(th);
    }

    public static Throwable getCause(Throwable th, int i) {
        return AbstractExceptions.getCause(th, i);
    }

    public static Throwable searchCause(Throwable th, Class<?> cls) {
        return AbstractExceptions.searchCause(th, cls);
    }

    public static Throwable searchCause(Throwable th, Class<?> cls, String str) {
        return AbstractExceptions.searchCause(th, cls, str);
    }

    public static Throwable searchCause(Throwable th, Class<?> cls, String str, int i) {
        return AbstractExceptions.searchCause(th, cls, str, i);
    }

    public static Throwable searchCause(Throwable th, Class<?> cls, int i) {
        return AbstractExceptions.searchCause(th, cls, i);
    }
}
