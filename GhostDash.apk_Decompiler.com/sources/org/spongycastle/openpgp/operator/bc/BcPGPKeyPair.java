package org.spongycastle.openpgp.operator.bc;

import java.util.Date;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.openpgp.PGPAlgorithmParameters;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPKeyPair;
import org.spongycastle.openpgp.PGPPrivateKey;
import org.spongycastle.openpgp.PGPPublicKey;

public class BcPGPKeyPair extends PGPKeyPair {
    private static PGPPublicKey getPublicKey(int i, PGPAlgorithmParameters pGPAlgorithmParameters, AsymmetricKeyParameter asymmetricKeyParameter, Date date) throws PGPException {
        return new BcPGPKeyConverter().getPGPPublicKey(i, pGPAlgorithmParameters, asymmetricKeyParameter, date);
    }

    private static PGPPrivateKey getPrivateKey(PGPPublicKey pGPPublicKey, AsymmetricKeyParameter asymmetricKeyParameter) throws PGPException {
        return new BcPGPKeyConverter().getPGPPrivateKey(pGPPublicKey, asymmetricKeyParameter);
    }

    public BcPGPKeyPair(int i, AsymmetricCipherKeyPair asymmetricCipherKeyPair, Date date) throws PGPException {
        this.pub = getPublicKey(i, (PGPAlgorithmParameters) null, asymmetricCipherKeyPair.getPublic(), date);
        this.priv = getPrivateKey(this.pub, asymmetricCipherKeyPair.getPrivate());
    }

    public BcPGPKeyPair(int i, PGPAlgorithmParameters pGPAlgorithmParameters, AsymmetricCipherKeyPair asymmetricCipherKeyPair, Date date) throws PGPException {
        this.pub = getPublicKey(i, pGPAlgorithmParameters, asymmetricCipherKeyPair.getPublic(), date);
        this.priv = getPrivateKey(this.pub, asymmetricCipherKeyPair.getPrivate());
    }
}
