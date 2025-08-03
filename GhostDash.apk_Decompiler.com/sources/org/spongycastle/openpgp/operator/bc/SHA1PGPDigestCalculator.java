package org.spongycastle.openpgp.operator.bc;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;

class SHA1PGPDigestCalculator implements PGPDigestCalculator {
    private Digest digest = new SHA1Digest();

    public int getAlgorithm() {
        return 2;
    }

    SHA1PGPDigestCalculator() {
    }

    public OutputStream getOutputStream() {
        return new DigestOutputStream(this.digest);
    }

    public byte[] getDigest() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public void reset() {
        this.digest.reset();
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
    }
}
