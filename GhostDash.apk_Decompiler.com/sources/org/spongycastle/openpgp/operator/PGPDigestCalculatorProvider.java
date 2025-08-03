package org.spongycastle.openpgp.operator;

import org.spongycastle.openpgp.PGPException;

public interface PGPDigestCalculatorProvider {
    PGPDigestCalculator get(int i) throws PGPException;
}
