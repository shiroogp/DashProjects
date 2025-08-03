package org.spongycastle.openpgp.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;

class SHA1PGPDigestCalculator implements PGPDigestCalculator {
    private MessageDigest digest;

    public int getAlgorithm() {
        return 2;
    }

    SHA1PGPDigestCalculator() {
        try {
            this.digest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("cannot find SHA-1: " + e.getMessage());
        }
    }

    public OutputStream getOutputStream() {
        return new DigestOutputStream(this.digest);
    }

    public byte[] getDigest() {
        return this.digest.digest();
    }

    public void reset() {
        this.digest.reset();
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
