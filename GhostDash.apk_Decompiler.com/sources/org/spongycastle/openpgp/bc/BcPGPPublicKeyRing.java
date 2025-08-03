package org.spongycastle.openpgp.bc;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.openpgp.PGPPublicKeyRing;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

public class BcPGPPublicKeyRing extends PGPPublicKeyRing {
    private static KeyFingerPrintCalculator fingerPrintCalculator = new BcKeyFingerprintCalculator();

    public BcPGPPublicKeyRing(byte[] bArr) throws IOException {
        super(bArr, fingerPrintCalculator);
    }

    public BcPGPPublicKeyRing(InputStream inputStream) throws IOException {
        super(inputStream, fingerPrintCalculator);
    }
}
