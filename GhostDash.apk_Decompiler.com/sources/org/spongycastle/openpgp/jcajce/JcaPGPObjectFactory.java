package org.spongycastle.openpgp.jcajce;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.spongycastle.openpgp.PGPObjectFactory;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

public class JcaPGPObjectFactory extends PGPObjectFactory {
    public JcaPGPObjectFactory(byte[] bArr) {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public JcaPGPObjectFactory(InputStream inputStream) {
        super(inputStream, (KeyFingerPrintCalculator) new JcaKeyFingerprintCalculator());
    }
}
