package org.spongycastle.openpgp.operator.bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.io.CipherOutputStream;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.operator.PGPDataEncryptor;
import org.spongycastle.openpgp.operator.PGPDataEncryptorBuilder;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;

public class BcPGPDataEncryptorBuilder implements PGPDataEncryptorBuilder {
    /* access modifiers changed from: private */
    public int encAlgorithm;
    private SecureRandom random;
    /* access modifiers changed from: private */
    public boolean withIntegrityPacket;

    public BcPGPDataEncryptorBuilder(int i) {
        this.encAlgorithm = i;
        if (i == 0) {
            throw new IllegalArgumentException("null cipher specified");
        }
    }

    public BcPGPDataEncryptorBuilder setWithIntegrityPacket(boolean z) {
        this.withIntegrityPacket = z;
        return this;
    }

    public BcPGPDataEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public int getAlgorithm() {
        return this.encAlgorithm;
    }

    public SecureRandom getSecureRandom() {
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        return this.random;
    }

    public PGPDataEncryptor build(byte[] bArr) throws PGPException {
        return new MyPGPDataEncryptor(bArr);
    }

    private class MyPGPDataEncryptor implements PGPDataEncryptor {
        private final BufferedBlockCipher c;

        MyPGPDataEncryptor(byte[] bArr) throws PGPException {
            try {
                this.c = BcUtil.createStreamCipher(true, BcImplProvider.createBlockCipher(BcPGPDataEncryptorBuilder.this.encAlgorithm), BcPGPDataEncryptorBuilder.this.withIntegrityPacket, bArr);
            } catch (IllegalArgumentException e) {
                throw new PGPException("invalid parameters: " + e.getMessage(), e);
            }
        }

        public OutputStream getOutputStream(OutputStream outputStream) {
            return new CipherOutputStream(outputStream, this.c);
        }

        public PGPDigestCalculator getIntegrityCalculator() {
            if (BcPGPDataEncryptorBuilder.this.withIntegrityPacket) {
                return new SHA1PGPDigestCalculator();
            }
            return null;
        }

        public int getBlockSize() {
            return this.c.getBlockSize();
        }
    }
}
