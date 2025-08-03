package org.spongycastle.openpgp.operator;

import org.spongycastle.openpgp.PGPException;

public interface PublicKeyDataDecryptorFactory extends PGPDataDecryptorFactory {
    byte[] recoverSessionData(int i, byte[][] bArr) throws PGPException;
}
