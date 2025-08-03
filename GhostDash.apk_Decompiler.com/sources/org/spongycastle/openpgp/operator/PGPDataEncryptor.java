package org.spongycastle.openpgp.operator;

import java.io.OutputStream;

public interface PGPDataEncryptor {
    int getBlockSize();

    PGPDigestCalculator getIntegrityCalculator();

    OutputStream getOutputStream(OutputStream outputStream);
}
