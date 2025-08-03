package org.spongycastle.openpgp.operator;

import java.io.OutputStream;

public interface PGPDigestCalculator {
    int getAlgorithm();

    byte[] getDigest();

    OutputStream getOutputStream();

    void reset();
}
