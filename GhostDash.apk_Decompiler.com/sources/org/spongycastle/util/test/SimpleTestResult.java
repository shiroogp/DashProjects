package org.spongycastle.util.test;

import org.spongycastle.util.Strings;

public class SimpleTestResult implements TestResult {
    private static final String SEPARATOR = Strings.lineSeparator();
    private Throwable exception;
    private String message;
    private boolean success;

    public SimpleTestResult(boolean z, String str) {
        this.success = z;
        this.message = str;
    }

    public SimpleTestResult(boolean z, String str, Throwable th) {
        this.success = z;
        this.message = str;
        this.exception = th;
    }

    public static TestResult successful(Test test, String str) {
        return new SimpleTestResult(true, test.getName() + ": " + str);
    }

    public static TestResult failed(Test test, String str) {
        return new SimpleTestResult(false, test.getName() + ": " + str);
    }

    public static TestResult failed(Test test, String str, Throwable th) {
        return new SimpleTestResult(false, test.getName() + ": " + str, th);
    }

    public static TestResult failed(Test test, String str, Object obj, Object obj2) {
        StringBuilder append = new StringBuilder().append(str);
        String str2 = SEPARATOR;
        return failed(test, append.append(str2).append("Expected: ").append(obj).append(str2).append("Found   : ").append(obj2).toString());
    }

    public static String failedMessage(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(" failing ").append(str2);
        String str5 = SEPARATOR;
        stringBuffer.append(str5).append("    expected: ").append(str3);
        stringBuffer.append(str5).append("    got     : ").append(str4);
        return stringBuffer.toString();
    }

    public boolean isSuccessful() {
        return this.success;
    }

    public String toString() {
        return this.message;
    }

    public Throwable getException() {
        return this.exception;
    }
}
