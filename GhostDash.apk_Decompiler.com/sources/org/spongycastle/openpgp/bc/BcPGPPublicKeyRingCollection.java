package org.spongycastle.openpgp.bc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPublicKeyRingCollection;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

public class BcPGPPublicKeyRingCollection extends PGPPublicKeyRingCollection {
    public BcPGPPublicKeyRingCollection(byte[] bArr) throws IOException, PGPException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public BcPGPPublicKeyRingCollection(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, (KeyFingerPrintCalculator) new BcKeyFingerprintCalculator());
    }

    public BcPGPPublicKeyRingCollection(Collection collection) throws IOException, PGPException {
        super(collection);
    }
}
