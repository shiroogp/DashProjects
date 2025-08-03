package org.spongycastle.crypto.tls;

public class TlsFatalAlert extends TlsException {
    protected short alertDescription;

    public TlsFatalAlert(short s) {
        this(s, (Throwable) null);
    }

    public TlsFatalAlert(short s, Throwable th) {
        super(AlertDescription.getText(s), th);
        this.alertDescription = s;
    }

    public short getAlertDescription() {
        return this.alertDescription;
    }
}
