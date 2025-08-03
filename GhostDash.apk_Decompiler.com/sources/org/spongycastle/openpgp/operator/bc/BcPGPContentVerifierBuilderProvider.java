package org.spongycastle.openpgp.operator.bc;

import java.io.OutputStream;
import org.spongycastle.crypto.Signer;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPublicKey;
import org.spongycastle.openpgp.operator.PGPContentVerifier;
import org.spongycastle.openpgp.operator.PGPContentVerifierBuilder;
import org.spongycastle.openpgp.operator.PGPContentVerifierBuilderProvider;

public class BcPGPContentVerifierBuilderProvider implements PGPContentVerifierBuilderProvider {
    /* access modifiers changed from: private */
    public BcPGPKeyConverter keyConverter = new BcPGPKeyConverter();

    public PGPContentVerifierBuilder get(int i, int i2) throws PGPException {
        return new BcPGPContentVerifierBuilder(i, i2);
    }

    private class BcPGPContentVerifierBuilder implements PGPContentVerifierBuilder {
        /* access modifiers changed from: private */
        public int hashAlgorithm;
        /* access modifiers changed from: private */
        public int keyAlgorithm;

        public BcPGPContentVerifierBuilder(int i, int i2) {
            this.keyAlgorithm = i;
            this.hashAlgorithm = i2;
        }

        public PGPContentVerifier build(final PGPPublicKey pGPPublicKey) throws PGPException {
            final Signer createSigner = BcImplProvider.createSigner(this.keyAlgorithm, this.hashAlgorithm);
            createSigner.init(false, BcPGPContentVerifierBuilderProvider.this.keyConverter.getPublicKey(pGPPublicKey));
            return new PGPContentVerifier() {
                public int getHashAlgorithm() {
                    return BcPGPContentVerifierBuilder.this.hashAlgorithm;
                }

                public int getKeyAlgorithm() {
                    return BcPGPContentVerifierBuilder.this.keyAlgorithm;
                }

                public long getKeyID() {
                    return pGPPublicKey.getKeyID();
                }

                public boolean verify(byte[] bArr) {
                    return createSigner.verifySignature(bArr);
                }

                public OutputStream getOutputStream() {
                    return new SignerOutputStream(createSigner);
                }
            };
        }
    }
}
