package org.spongycastle.openpgp.operator.jcajce;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import org.spongycastle.openpgp.PGPAlgorithmParameters;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPKeyPair;
import org.spongycastle.openpgp.PGPPrivateKey;
import org.spongycastle.openpgp.PGPPublicKey;

public class JcaPGPKeyPair extends PGPKeyPair {
    private static PGPPublicKey getPublicKey(int i, PublicKey publicKey, Date date) throws PGPException {
        return new JcaPGPKeyConverter().getPGPPublicKey(i, publicKey, date);
    }

    private static PGPPublicKey getPublicKey(int i, PGPAlgorithmParameters pGPAlgorithmParameters, PublicKey publicKey, Date date) throws PGPException {
        return new JcaPGPKeyConverter().getPGPPublicKey(i, pGPAlgorithmParameters, publicKey, date);
    }

    private static PGPPrivateKey getPrivateKey(PGPPublicKey pGPPublicKey, PrivateKey privateKey) throws PGPException {
        return new JcaPGPKeyConverter().getPGPPrivateKey(pGPPublicKey, privateKey);
    }

    public JcaPGPKeyPair(int i, KeyPair keyPair, Date date) throws PGPException {
        this.pub = getPublicKey(i, keyPair.getPublic(), date);
        this.priv = getPrivateKey(this.pub, keyPair.getPrivate());
    }

    public JcaPGPKeyPair(int i, PGPAlgorithmParameters pGPAlgorithmParameters, KeyPair keyPair, Date date) throws PGPException {
        this.pub = getPublicKey(i, pGPAlgorithmParameters, keyPair.getPublic(), date);
        this.priv = getPrivateKey(this.pub, keyPair.getPrivate());
    }
}
