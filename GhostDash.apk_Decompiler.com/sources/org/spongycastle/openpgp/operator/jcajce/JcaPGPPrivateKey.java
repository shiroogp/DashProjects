package org.spongycastle.openpgp.operator.jcajce;

import java.security.PrivateKey;
import org.spongycastle.bcpg.BCPGKey;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.openpgp.PGPPrivateKey;
import org.spongycastle.openpgp.PGPPublicKey;

public class JcaPGPPrivateKey extends PGPPrivateKey {
    private final PrivateKey privateKey;

    public JcaPGPPrivateKey(long j, PrivateKey privateKey2) {
        super(j, (PublicKeyPacket) null, (BCPGKey) null);
        this.privateKey = privateKey2;
    }

    public JcaPGPPrivateKey(PGPPublicKey pGPPublicKey, PrivateKey privateKey2) {
        super(pGPPublicKey.getKeyID(), pGPPublicKey.getPublicKeyPacket(), (BCPGKey) null);
        this.privateKey = privateKey2;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }
}
