package org.spongycastle.openpgp.operator.jcajce;

import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.operator.PGPDataEncryptor;
import org.spongycastle.openpgp.operator.PGPDataEncryptorBuilder;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;

public class JcePGPDataEncryptorBuilder implements PGPDataEncryptorBuilder {
    /* access modifiers changed from: private */
    public int encAlgorithm;
    /* access modifiers changed from: private */
    public OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    private SecureRandom random;
    /* access modifiers changed from: private */
    public boolean withIntegrityPacket;

    public JcePGPDataEncryptorBuilder(int i) {
        this.encAlgorithm = i;
        if (i == 0) {
            throw new IllegalArgumentException("null cipher specified");
        }
    }

    public JcePGPDataEncryptorBuilder setWithIntegrityPacket(boolean z) {
        this.withIntegrityPacket = z;
        return this;
    }

    public JcePGPDataEncryptorBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JcePGPDataEncryptorBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcePGPDataEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
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
        private final Cipher c;

        MyPGPDataEncryptor(byte[] bArr) throws PGPException {
            Cipher createStreamCipher = JcePGPDataEncryptorBuilder.this.helper.createStreamCipher(JcePGPDataEncryptorBuilder.this.encAlgorithm, JcePGPDataEncryptorBuilder.this.withIntegrityPacket);
            this.c = createStreamCipher;
            try {
                if (JcePGPDataEncryptorBuilder.this.withIntegrityPacket) {
                    createStreamCipher.init(1, PGPUtil.makeSymmetricKey(JcePGPDataEncryptorBuilder.this.encAlgorithm, bArr), new IvParameterSpec(new byte[createStreamCipher.getBlockSize()]));
                } else {
                    createStreamCipher.init(1, PGPUtil.makeSymmetricKey(JcePGPDataEncryptorBuilder.this.encAlgorithm, bArr));
                }
            } catch (InvalidKeyException e) {
                throw new PGPException("invalid key: " + e.getMessage(), e);
            } catch (InvalidAlgorithmParameterException e2) {
                throw new PGPException("imvalid algorithm parameter: " + e2.getMessage(), e2);
            }
        }

        public OutputStream getOutputStream(OutputStream outputStream) {
            return new CipherOutputStream(outputStream, this.c);
        }

        public PGPDigestCalculator getIntegrityCalculator() {
            if (JcePGPDataEncryptorBuilder.this.withIntegrityPacket) {
                return new SHA1PGPDigestCalculator();
            }
            return null;
        }

        public int getBlockSize() {
            return this.c.getBlockSize();
        }
    }
}
