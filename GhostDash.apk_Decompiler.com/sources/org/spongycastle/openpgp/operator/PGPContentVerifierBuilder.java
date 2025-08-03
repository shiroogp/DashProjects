package org.spongycastle.openpgp.operator;

import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPublicKey;

public interface PGPContentVerifierBuilder {
    PGPContentVerifier build(PGPPublicKey pGPPublicKey) throws PGPException;
}
