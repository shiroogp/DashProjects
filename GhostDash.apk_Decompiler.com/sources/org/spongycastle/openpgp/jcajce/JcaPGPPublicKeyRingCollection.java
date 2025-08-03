package org.spongycastle.openpgp.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPublicKeyRingCollection;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

public class JcaPGPPublicKeyRingCollection extends PGPPublicKeyRingCollection {
    public JcaPGPPublicKeyRingCollection(byte[] bArr) throws IOException, PGPException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public JcaPGPPublicKeyRingCollection(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, (KeyFingerPrintCalculator) new JcaKeyFingerprintCalculator());
    }

    public JcaPGPPublicKeyRingCollection(Collection collection) throws IOException, PGPException {
        super(collection);
    }
}
