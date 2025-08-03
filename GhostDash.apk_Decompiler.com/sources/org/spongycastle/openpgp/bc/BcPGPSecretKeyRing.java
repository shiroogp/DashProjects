package org.spongycastle.openpgp.bc;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPSecretKeyRing;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

public class BcPGPSecretKeyRing extends PGPSecretKeyRing {
    private static KeyFingerPrintCalculator fingerPrintCalculator = new BcKeyFingerprintCalculator();

    public BcPGPSecretKeyRing(byte[] bArr) throws IOException, PGPException {
        super(bArr, fingerPrintCalculator);
    }

    public BcPGPSecretKeyRing(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, fingerPrintCalculator);
    }
}
