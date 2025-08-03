package org.spongycastle.openpgp;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.bcpg.InputStreamPacket;
import org.spongycastle.bcpg.SymmetricEncIntegrityPacket;
import org.spongycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;
import org.spongycastle.util.Arrays;

public abstract class PGPEncryptedData implements SymmetricKeyAlgorithmTags {
    InputStreamPacket encData;
    InputStream encStream;
    PGPDigestCalculator integrityCalculator;
    TruncatedStream truncStream;

    protected class TruncatedStream extends InputStream {
        int bufPtr;
        InputStream in;
        int[] lookAhead = new int[22];

        TruncatedStream(InputStream inputStream) throws IOException {
            int i = 0;
            while (true) {
                int[] iArr = this.lookAhead;
                if (i != iArr.length) {
                    int read = inputStream.read();
                    iArr[i] = read;
                    if (read >= 0) {
                        i++;
                    } else {
                        throw new EOFException();
                    }
                } else {
                    this.bufPtr = 0;
                    this.in = inputStream;
                    return;
                }
            }
        }

        public int read() throws IOException {
            int read = this.in.read();
            if (read < 0) {
                return -1;
            }
            int[] iArr = this.lookAhead;
            int i = this.bufPtr;
            int i2 = iArr[i];
            iArr[i] = read;
            this.bufPtr = (i + 1) % iArr.length;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int[] getLookAhead() {
            int[] iArr = new int[this.lookAhead.length];
            int i = this.bufPtr;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.lookAhead;
                if (i == iArr2.length) {
                    break;
                }
                iArr[i3] = iArr2[i];
                i++;
                i3++;
            }
            while (i2 != this.bufPtr) {
                iArr[i3] = this.lookAhead[i2];
                i2++;
                i3++;
            }
            return iArr;
        }
    }

    PGPEncryptedData(InputStreamPacket inputStreamPacket) {
        this.encData = inputStreamPacket;
    }

    public InputStream getInputStream() {
        return this.encData.getInputStream();
    }

    public boolean isIntegrityProtected() {
        return this.encData instanceof SymmetricEncIntegrityPacket;
    }

    public boolean verify() throws PGPException, IOException {
        if (isIntegrityProtected()) {
            do {
            } while (this.encStream.read() >= 0);
            int[] lookAhead = this.truncStream.getLookAhead();
            OutputStream outputStream = this.integrityCalculator.getOutputStream();
            outputStream.write((byte) lookAhead[0]);
            outputStream.write((byte) lookAhead[1]);
            byte[] digest = this.integrityCalculator.getDigest();
            int length = digest.length;
            byte[] bArr = new byte[length];
            for (int i = 0; i != length; i++) {
                bArr[i] = (byte) lookAhead[i + 2];
            }
            return Arrays.constantTimeAreEqual(digest, bArr);
        }
        throw new PGPException("data not integrity protected.");
    }
}
