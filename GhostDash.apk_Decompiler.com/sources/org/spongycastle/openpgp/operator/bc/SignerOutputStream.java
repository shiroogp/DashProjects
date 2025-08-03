package org.spongycastle.openpgp.operator.bc;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.crypto.Signer;

class SignerOutputStream extends OutputStream {
    private Signer sig;

    SignerOutputStream(Signer signer) {
        this.sig = signer;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.sig.update(bArr, i, i2);
    }

    public void write(byte[] bArr) throws IOException {
        this.sig.update(bArr, 0, bArr.length);
    }

    public void write(int i) throws IOException {
        this.sig.update((byte) i);
    }
}
