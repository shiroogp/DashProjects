package org.spongycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

public class DSAPublicBCPGKey extends BCPGObject implements BCPGKey {
    MPInteger g;
    MPInteger p;
    MPInteger q;
    MPInteger y;

    public String getFormat() {
        return "PGP";
    }

    public DSAPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.p = new MPInteger(bCPGInputStream);
        this.q = new MPInteger(bCPGInputStream);
        this.g = new MPInteger(bCPGInputStream);
        this.y = new MPInteger(bCPGInputStream);
    }

    public DSAPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.p = new MPInteger(bigInteger);
        this.q = new MPInteger(bigInteger2);
        this.g = new MPInteger(bigInteger3);
        this.y = new MPInteger(bigInteger4);
    }

    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.p);
        bCPGOutputStream.writeObject(this.q);
        bCPGOutputStream.writeObject(this.g);
        bCPGOutputStream.writeObject(this.y);
    }

    public BigInteger getG() {
        return this.g.getValue();
    }

    public BigInteger getP() {
        return this.p.getValue();
    }

    public BigInteger getQ() {
        return this.q.getValue();
    }

    public BigInteger getY() {
        return this.y.getValue();
    }
}
