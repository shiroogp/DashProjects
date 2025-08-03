package org.spongycastle.openpgp.operator.bc;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;
import org.spongycastle.openpgp.operator.PGPDigestCalculatorProvider;

public class BcPGPDigestCalculatorProvider implements PGPDigestCalculatorProvider {
    public PGPDigestCalculator get(final int i) throws PGPException {
        final Digest createDigest = BcImplProvider.createDigest(i);
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
    }

    private class DigestOutputStream extends OutputStream {
        private Digest dig;

        DigestOutputStream(Digest digest) {
            this.dig = digest;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.dig.update(bArr, i, i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.dig.update(bArr, 0, bArr.length);
        }

        public void write(int i) throws IOException {
            this.dig.update((byte) i);
        }

        /* access modifiers changed from: package-private */
        public byte[] getDigest() {
            byte[] bArr = new byte[this.dig.getDigestSize()];
            this.dig.doFinal(bArr, 0);
            return bArr;
        }
    }
}
