package org.spongycastle.openpgp.operator;

import org.spongycastle.openpgp.PGPException;

public interface PGPContentVerifierBuilderProvider {
    PGPContentVerifierBuilder get(int i, int i2) throws PGPException;
}
