package org.spongycastle.openpgp.jcajce;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPSecretKeyRing;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

public class JcaPGPSecretKeyRing extends PGPSecretKeyRing {
    private static KeyFingerPrintCalculator fingerPrintCalculator = new JcaKeyFingerprintCalculator();

    public JcaPGPSecretKeyRing(byte[] bArr) throws IOException, PGPException {
        super(bArr, fingerPrintCalculator);
    }

    public JcaPGPSecretKeyRing(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, fingerPrintCalculator);
    }
}
