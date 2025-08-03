package org.spongycastle.openpgp.operator;

import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPrivateKey;

public interface PGPContentSignerBuilder {
    PGPContentSigner build(int i, PGPPrivateKey pGPPrivateKey) throws PGPException;
}
