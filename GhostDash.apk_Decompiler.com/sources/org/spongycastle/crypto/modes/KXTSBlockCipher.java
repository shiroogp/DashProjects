package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class KXTSBlockCipher extends BufferedBlockCipher {
    private static final long RED_POLY_128 = 135;
    private static final long RED_POLY_256 = 1061;
    private static final long RED_POLY_512 = 293;
    private final int blockSize;
    private int counter = -1;
    private final long reductionPolynomial;
    private final long[] tw_current;
    private final long[] tw_init;

    public int getOutputSize(int i) {
        return i;
    }

    public int getUpdateOutputSize(int i) {
        return i;
    }

    protected static long getReductionPolynomial(int i) {
        if (i == 16) {
            return RED_POLY_128;
        }
        if (i == 32) {
            return RED_POLY_256;
        }
        if (i == 64) {
            return RED_POLY_512;
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    public KXTSBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.reductionPolynomial = getReductionPolynomial(blockSize2);
        this.tw_init = new long[(blockSize2 >>> 3)];
        this.tw_current = new long[(blockSize2 >>> 3)];
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            CipherParameters parameters = parametersWithIV.getParameters();
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            int i = this.blockSize;
            if (length == i) {
                byte[] bArr = new byte[i];
                System.arraycopy(iv, 0, bArr, 0, i);
                this.cipher.init(true, parameters);
                this.cipher.processBlock(bArr, 0, bArr, 0);
                this.cipher.init(z, parameters);
                Pack.littleEndianToLong(bArr, 0, this.tw_init);
                long[] jArr = this.tw_init;
                System.arraycopy(jArr, 0, this.tw_current, 0, jArr.length);
                this.counter = 0;
                return;
            }
            throw new IllegalArgumentException("Currently only support IVs of exactly one block");
        }
        throw new IllegalArgumentException("Invalid parameters passed");
    }

    public int processByte(byte b, byte[] bArr, int i) {
        throw new IllegalStateException("unsupported operation");
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr.length - i < i2) {
            throw new DataLengthException("Input buffer too short");
        } else if (bArr2.length - i < i2) {
            throw new OutputLengthException("Output buffer too short");
        } else if (i2 % this.blockSize == 0) {
            int i4 = 0;
            while (i4 < i2) {
                processBlock(bArr, i + i4, bArr2, i3 + i4);
                i4 += this.blockSize;
            }
            return i2;
        } else {
            throw new IllegalArgumentException("Partial blocks not supported");
        }
    }

    private void processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.counter;
        if (i3 != -1) {
            this.counter = i3 + 1;
            GF_double(this.reductionPolynomial, this.tw_current);
            byte[] bArr3 = new byte[this.blockSize];
            Pack.longToLittleEndian(this.tw_current, bArr3, 0);
            int i4 = this.blockSize;
            byte[] bArr4 = new byte[i4];
            System.arraycopy(bArr3, 0, bArr4, 0, i4);
            for (int i5 = 0; i5 < this.blockSize; i5++) {
                bArr4[i5] = (byte) (bArr4[i5] ^ bArr[i + i5]);
            }
            this.cipher.processBlock(bArr4, 0, bArr4, 0);
            for (int i6 = 0; i6 < this.blockSize; i6++) {
                bArr2[i2 + i6] = (byte) (bArr4[i6] ^ bArr3[i6]);
            }
            return;
        }
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    public int doFinal(byte[] bArr, int i) {
        reset();
        return 0;
    }

    public void reset() {
        this.cipher.reset();
        long[] jArr = this.tw_init;
        System.arraycopy(jArr, 0, this.tw_current, 0, jArr.length);
        this.counter = 0;
    }

    private static void GF_double(long j, long[] jArr) {
        long j2 = 0;
        int i = 0;
        while (i < jArr.length) {
            long j3 = jArr[i];
            jArr[i] = j2 ^ (j3 << 1);
            i++;
            j2 = j3 >>> 63;
        }
        jArr[0] = (j & (-j2)) ^ jArr[0];
    }
}
