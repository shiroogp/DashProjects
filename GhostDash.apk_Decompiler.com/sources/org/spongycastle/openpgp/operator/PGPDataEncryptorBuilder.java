package org.spongycastle.openpgp.operator;

import java.security.SecureRandom;
import org.spongycastle.openpgp.PGPException;

public interface PGPDataEncryptorBuilder {
    PGPDataEncryptor build(byte[] bArr) throws PGPException;

    int getAlgorithm();

    SecureRandom getSecureRandom();
}
