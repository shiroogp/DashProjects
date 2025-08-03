package org.spongycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

public class RSAPublicBCPGKey extends BCPGObject implements BCPGKey {
    MPInteger e;
    MPInteger n;

    public String getFormat() {
        return "PGP";
    }

    public RSAPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.n = new MPInteger(bCPGInputStream);
        this.e = new MPInteger(bCPGInputStream);
    }

    public RSAPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.n = new MPInteger(bigInteger);
        this.e = new MPInteger(bigInteger2);
    }

    public BigInteger getPublicExponent() {
        return this.e.getValue();
    }

    public BigInteger getModulus() {
        return this.n.getValue();
    }

    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.n);
        bCPGOutputStream.writeObject(this.e);
    }
}
