package org.spongycastle.crypto.tls;

public class TlsFatalAlertReceived extends TlsException {
    protected short alertDescription;

    public TlsFatalAlertReceived(short s) {
        super(AlertDescription.getText(s), (Throwable) null);
        this.alertDescription = s;
    }

    public short getAlertDescription() {
        return this.alertDescription;
    }
}
