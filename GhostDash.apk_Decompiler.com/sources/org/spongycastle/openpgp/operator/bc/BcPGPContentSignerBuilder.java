package org.spongycastle.openpgp.operator.bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPrivateKey;
import org.spongycastle.openpgp.operator.PGPContentSigner;
import org.spongycastle.openpgp.operator.PGPContentSignerBuilder;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;
import org.spongycastle.util.io.TeeOutputStream;

public class BcPGPContentSignerBuilder implements PGPContentSignerBuilder {
    private BcPGPDigestCalculatorProvider digestCalculatorProvider = new BcPGPDigestCalculatorProvider();
    /* access modifiers changed from: private */
    public int hashAlgorithm;
    /* access modifiers changed from: private */
    public int keyAlgorithm;
    private BcPGPKeyConverter keyConverter = new BcPGPKeyConverter();
    private SecureRandom random;

    public BcPGPContentSignerBuilder(int i, int i2) {
        this.keyAlgorithm = i;
        this.hashAlgorithm = i2;
    }

    public BcPGPContentSignerBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public PGPContentSigner build(int i, PGPPrivateKey pGPPrivateKey) throws PGPException {
        final PGPDigestCalculator pGPDigestCalculator = this.digestCalculatorProvider.get(this.hashAlgorithm);
        final Signer createSigner = BcImplProvider.createSigner(this.keyAlgorithm, this.hashAlgorithm);
        if (this.random != null) {
            createSigner.init(true, new ParametersWithRandom(this.keyConverter.getPrivateKey(pGPPrivateKey), this.random));
        } else {
            createSigner.init(true, this.keyConverter.getPrivateKey(pGPPrivateKey));
        }
        final int i2 = i;
        final PGPPrivateKey pGPPrivateKey2 = pGPPrivateKey;
        return new PGPContentSigner() {
            public int getType() {
                return i2;
            }

            public int getHashAlgorithm() {
                return BcPGPContentSignerBuilder.this.hashAlgorithm;
            }

            public int getKeyAlgorithm() {
                return BcPGPContentSignerBuilder.this.keyAlgorithm;
            }

            public long getKeyID() {
                return pGPPrivateKey2.getKeyID();
            }

            public OutputStream getOutputStream() {
                return new TeeOutputStream(new SignerOutputStream(createSigner), pGPDigestCalculator.getOutputStream());
            }

            public byte[] getSignature() {
                try {
                    return createSigner.generateSignature();
                } catch (CryptoException unused) {
                    throw new IllegalStateException("unable to create signature");
                }
            }

            public byte[] getDigest() {
                return pGPDigestCalculator.getDigest();
            }
        };
    }
}
