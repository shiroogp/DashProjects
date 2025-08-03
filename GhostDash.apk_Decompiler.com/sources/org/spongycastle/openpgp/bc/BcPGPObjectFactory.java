package org.spongycastle.openpgp.bc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.spongycastle.openpgp.PGPObjectFactory;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

public class BcPGPObjectFactory extends PGPObjectFactory {
    public BcPGPObjectFactory(byte[] bArr) {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public BcPGPObjectFactory(InputStream inputStream) {
        super(inputStream, (KeyFingerPrintCalculator) new BcKeyFingerprintCalculator());
    }
}
