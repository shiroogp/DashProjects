package org.spongycastle.openpgp.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;
import org.spongycastle.openpgp.operator.PGPDigestCalculatorProvider;

public class JcaPGPDigestCalculatorProviderBuilder {
    /* access modifiers changed from: private */
    public OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());

    public JcaPGPDigestCalculatorProviderBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JcaPGPDigestCalculatorProviderBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public PGPDigestCalculatorProvider build() throws PGPException {
        return new PGPDigestCalculatorProvider() {
            public PGPDigestCalculator get(final int i) throws PGPException {
                try {
                    final MessageDigest createDigest = JcaPGPDigestCalculatorProviderBuilder.this.helper.createDigest(i);
                    final DigestOutputStream digestOutputStream = new DigestOutputStream(createDigest);
                    return new PGPDigestCalculator() {
                        public int getAlgorithm() {
                            return i;
                        }

                        public OutputStream getOutputStream() {
                            return digestOutputStream;
                        }

                        public byte[] getDigest() {
                            return digestOutputStream.getDigest();
                        }

                        public void reset() {
                            createDigest.reset();
                        }
                    };
                } catch (GeneralSecurityException e) {
                    throw new PGPException("exception on setup: " + e, e);
                }
            }
        };
    }

    private class DigestOutputStream extends OutputStream {
        private MessageDigest dig;

        DigestOutputStream(MessageDigest messageDigest) {
            this.dig = messageDigest;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.dig.update(bArr, i, i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.dig.update(bArr);
        }

        public void write(int i) throws IOException {
            this.dig.update((byte) i);
        }

        /* access modifiers changed from: package-private */
        public byte[] getDigest() {
            return this.dig.digest();
        }
    }
}
