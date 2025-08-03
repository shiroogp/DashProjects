package com.arthenica.smartexception;

public interface PackageLoader {
    Package getPackage(ClassLoader classLoader, String str);
}
