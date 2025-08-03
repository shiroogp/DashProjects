package org.spongycastle.openpgp;

public class PGPKeyPair {
    protected PGPPrivateKey priv;
    protected PGPPublicKey pub;

    public PGPKeyPair(PGPPublicKey pGPPublicKey, PGPPrivateKey pGPPrivateKey) {
        this.pub = pGPPublicKey;
        this.priv = pGPPrivateKey;
    }

    protected PGPKeyPair() {
    }

    public long getKeyID() {
        return this.pub.getKeyID();
    }

    public PGPPublicKey getPublicKey() {
        return this.pub;
    }

    public PGPPrivateKey getPrivateKey() {
        return this.priv;
    }
}
