package org.spongycastle.openpgp;

import org.spongycastle.bcpg.BCPGKey;
import org.spongycastle.bcpg.PublicKeyPacket;

public class PGPPrivateKey {
    private long keyID;
    private BCPGKey privateKeyDataPacket;
    private PublicKeyPacket publicKeyPacket;

    public PGPPrivateKey(long j, PublicKeyPacket publicKeyPacket2, BCPGKey bCPGKey) {
        this.keyID = j;
        this.publicKeyPacket = publicKeyPacket2;
        this.privateKeyDataPacket = bCPGKey;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public PublicKeyPacket getPublicKeyPacket() {
        return this.publicKeyPacket;
    }

    public BCPGKey getPrivateKeyDataPacket() {
        return this.privateKeyDataPacket;
    }
}
