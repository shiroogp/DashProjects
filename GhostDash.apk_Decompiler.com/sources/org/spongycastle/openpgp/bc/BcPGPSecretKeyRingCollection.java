package org.spongycastle.openpgp.bc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPSecretKeyRingCollection;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

public class BcPGPSecretKeyRingCollection extends PGPSecretKeyRingCollection {
    public BcPGPSecretKeyRingCollection(byte[] bArr) throws IOException, PGPException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public BcPGPSecretKeyRingCollection(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, (KeyFingerPrintCalculator) new BcKeyFingerprintCalculator());
    }

    public BcPGPSecretKeyRingCollection(Collection collection) throws IOException, PGPException {
        super(collection);
    }
}
