package org.spongycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

public class ECSecretBCPGKey extends BCPGObject implements BCPGKey {
    MPInteger x;

    public String getFormat() {
        return "PGP";
    }

    public ECSecretBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.x = new MPInteger(bCPGInputStream);
    }

    public ECSecretBCPGKey(BigInteger bigInteger) {
        this.x = new MPInteger(bigInteger);
    }

    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.x);
    }

    public BigInteger getX() {
        return this.x.getValue();
    }
}
