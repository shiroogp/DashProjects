package org.spongycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

public class ElGamalSecretBCPGKey extends BCPGObject implements BCPGKey {
    MPInteger x;

    public String getFormat() {
        return "PGP";
    }

    public ElGamalSecretBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.x = new MPInteger(bCPGInputStream);
    }

    public ElGamalSecretBCPGKey(BigInteger bigInteger) {
        this.x = new MPInteger(bigInteger);
    }

    public BigInteger getX() {
        return this.x.getValue();
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
}
