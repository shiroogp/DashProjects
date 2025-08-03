package org.spongycastle.cert.dane;

public class DANEException extends Exception {
    private Throwable cause;

    public DANEException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public DANEException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }
}
