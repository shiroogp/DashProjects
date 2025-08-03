package org.spongycastle.openpgp.operator;

import org.spongycastle.openpgp.PGPException;

public interface PGPDataDecryptorFactory {
    PGPDataDecryptor createDataDecryptor(boolean z, int i, byte[] bArr) throws PGPException;
}
