package org.spongycastle.openpgp.operator;

import java.io.InputStream;

public interface PGPDataDecryptor {
    int getBlockSize();

    InputStream getInputStream(InputStream inputStream);

    PGPDigestCalculator getIntegrityCalculator();
}
