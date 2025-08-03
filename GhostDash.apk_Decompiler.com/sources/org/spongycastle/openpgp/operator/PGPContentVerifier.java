package org.spongycastle.openpgp.operator;

import java.io.OutputStream;

public interface PGPContentVerifier {
    int getHashAlgorithm();

    int getKeyAlgorithm();

    long getKeyID();

    OutputStream getOutputStream();

    boolean verify(byte[] bArr);
}
