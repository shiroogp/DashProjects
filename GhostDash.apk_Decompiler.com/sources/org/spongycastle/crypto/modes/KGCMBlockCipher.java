package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class KGCMBlockCipher implements AEADBlockCipher {
    private static final int BITS_IN_BYTE = 8;
    private static final BigInteger MASK_1_128 = new BigInteger("340282366920938463463374607431768211456", 10);
    private static final BigInteger MASK_1_256 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639936", 10);
    private static final BigInteger MASK_1_512 = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084096", 10);
    private static final BigInteger MASK_2_128 = new BigInteger("340282366920938463463374607431768211455", 10);
    private static final BigInteger MASK_2_256 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639935", 10);
    private static final BigInteger MASK_2_512 = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084095", 10);
    private static final int MIN_MAC_BITS = 64;
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger POLYRED_128 = new BigInteger("135", 10);
    private static final BigInteger POLYRED_256 = new BigInteger("1061", 10);
    private static final BigInteger POLYRED_512 = new BigInteger("293", 10);
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private byte[] H;
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();
    private byte[] b;
    private BufferedBlockCipher ctrEngine;
    private ExposedByteArrayOutputStream data = new ExposedByteArrayOutputStream();
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private byte[] iv;
    private int lambda_c;
    private int lambda_o;
    private byte[] macBlock;
    private int macSize;
    private byte[] temp;

    public int getUpdateOutputSize(int i) {
        return i;
    }

    public KGCMBlockCipher(BlockCipher blockCipher) {
        this.engine = blockCipher;
        this.ctrEngine = new BufferedBlockCipher(new KCTRBlockCipher(this.engine));
        this.macSize = 0;
        this.initialAssociatedText = new byte[this.engine.getBlockSize()];
        this.iv = new byte[this.engine.getBlockSize()];
        this.H = new byte[this.engine.getBlockSize()];
        this.b = new byte[this.engine.getBlockSize()];
        this.temp = new byte[this.engine.getBlockSize()];
        this.lambda_c = 0;
        this.lambda_o = 0;
        this.macBlock = null;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            byte[] nonce = aEADParameters.getNonce();
            byte[] bArr = this.iv;
            Arrays.fill(bArr, (byte) 0);
            System.arraycopy(nonce, 0, this.iv, bArr.length - nonce.length, nonce.length);
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize2 = aEADParameters.getMacSize();
            if (macSize2 < 64 || macSize2 > this.engine.getBlockSize() * 8 || macSize2 % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize2);
            }
            this.macSize = macSize2 / 8;
            keyParameter = aEADParameters.getKey();
            byte[] bArr2 = this.initialAssociatedText;
            if (bArr2 != null) {
                processAADBytes(bArr2, 0, bArr2.length);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            byte[] bArr3 = this.iv;
            Arrays.fill(bArr3, (byte) 0);
            System.arraycopy(iv2, 0, this.iv, bArr3.length - iv2.length, iv2.length);
            this.initialAssociatedText = null;
            this.macSize = this.engine.getBlockSize();
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Invalid parameter passed");
        }
        this.macBlock = new byte[this.engine.getBlockSize()];
        this.ctrEngine.init(true, new ParametersWithIV(keyParameter, this.iv));
        this.engine.init(true, keyParameter);
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KGCM";
    }

    public BlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void processAADByte(byte b2) {
        this.associatedText.write(b2);
    }

    public void processAADBytes(byte[] bArr, int i, int i2) {
        this.associatedText.write(bArr, i, i2);
    }

    private void processAAD(byte[] bArr, int i, int i2) {
        this.lambda_o = i2 * 8;
        BlockCipher blockCipher = this.engine;
        byte[] bArr2 = this.H;
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        while (i2 > 0) {
            for (int i3 = 0; i3 < this.engine.getBlockSize(); i3++) {
                byte[] bArr3 = this.b;
                bArr3[i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
            }
            multiplyOverField(this.engine.getBlockSize() * 8, this.b, this.H, this.temp);
            byte[] reverse = Arrays.reverse(this.temp);
            this.temp = reverse;
            System.arraycopy(reverse, 0, this.b, 0, this.engine.getBlockSize());
            i2 -= this.engine.getBlockSize();
            i += this.engine.getBlockSize();
        }
    }

    public int processByte(byte b2, byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        this.data.write(b2);
        return 0;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i + i2) {
            this.data.write(bArr, i, i2);
            return 0;
        }
        throw new DataLengthException("input buffer too short");
    }

    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        int i2;
        int size = this.data.size();
        if (this.associatedText.size() > 0) {
            processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size());
        }
        if (!this.forEncryption) {
            this.lambda_c = (size - this.macSize) * 8;
            calculateMac(this.data.getBuffer(), 0, size - this.macSize);
            int processBytes = this.ctrEngine.processBytes(this.data.getBuffer(), 0, size - this.macSize, bArr, i);
            i2 = processBytes + this.ctrEngine.doFinal(bArr, i + processBytes);
        } else if (bArr.length - i >= this.macSize + size) {
            this.lambda_c = size * 8;
            int processBytes2 = this.ctrEngine.processBytes(this.data.getBuffer(), 0, size, bArr, i);
            i2 = processBytes2 + this.ctrEngine.doFinal(bArr, i + processBytes2);
            calculateMac(bArr, i, size);
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
        int i3 = i + i2;
        byte[] bArr2 = this.macBlock;
        if (bArr2 == null) {
            throw new IllegalStateException("mac is not calculated");
        } else if (this.forEncryption) {
            System.arraycopy(bArr2, 0, bArr, i3, this.macSize);
            reset();
            return i2 + this.macSize;
        } else {
            byte[] bArr3 = new byte[this.macSize];
            System.arraycopy(this.data.getBuffer(), i2, bArr3, 0, this.macSize);
            int i4 = this.macSize;
            byte[] bArr4 = new byte[i4];
            System.arraycopy(this.macBlock, 0, bArr4, 0, i4);
            if (Arrays.constantTimeAreEqual(bArr3, bArr4)) {
                reset();
                return i2;
            }
            throw new InvalidCipherTextException("mac verification failed");
        }
    }

    public byte[] getMac() {
        int i = this.macSize;
        byte[] bArr = new byte[i];
        System.arraycopy(this.macBlock, 0, bArr, 0, i);
        return bArr;
    }

    public int getOutputSize(int i) {
        if (this.forEncryption) {
            return i;
        }
        return i + this.macSize;
    }

    public void reset() {
        this.H = new byte[this.engine.getBlockSize()];
        this.b = new byte[this.engine.getBlockSize()];
        this.temp = new byte[this.engine.getBlockSize()];
        this.lambda_c = 0;
        this.lambda_o = 0;
        this.engine.reset();
        this.data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    private void calculateMac(byte[] bArr, int i, int i2) {
        this.macBlock = new byte[this.engine.getBlockSize()];
        while (i2 > 0) {
            for (int i3 = 0; i3 < this.engine.getBlockSize(); i3++) {
                byte[] bArr2 = this.b;
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i3 + i]);
            }
            multiplyOverField(this.engine.getBlockSize() * 8, this.b, this.H, this.temp);
            byte[] reverse = Arrays.reverse(this.temp);
            this.temp = reverse;
            System.arraycopy(reverse, 0, this.b, 0, this.engine.getBlockSize());
            i2 -= this.engine.getBlockSize();
            i += this.engine.getBlockSize();
        }
        Arrays.fill(this.temp, (byte) 0);
        intToBytes(this.lambda_o, this.temp, 0);
        intToBytes(this.lambda_c, this.temp, this.engine.getBlockSize() / 2);
        for (int i4 = 0; i4 < this.engine.getBlockSize(); i4++) {
            byte[] bArr3 = this.b;
            bArr3[i4] = (byte) (bArr3[i4] ^ this.temp[i4]);
        }
        this.engine.processBlock(this.b, 0, this.macBlock, 0);
    }

    private void intToBytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >> 24);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2] = (byte) i;
    }

    private void multiplyOverField(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        byte[] bArr4 = new byte[this.engine.getBlockSize()];
        byte[] bArr5 = new byte[this.engine.getBlockSize()];
        System.arraycopy(bArr, 0, bArr4, 0, this.engine.getBlockSize());
        System.arraycopy(bArr2, 0, bArr5, 0, this.engine.getBlockSize());
        byte[] reverse = Arrays.reverse(bArr4);
        byte[] reverse2 = Arrays.reverse(bArr5);
        if (i == 128) {
            bigInteger = MASK_1_128;
            bigInteger3 = MASK_2_128;
            bigInteger2 = POLYRED_128;
        } else if (i == 256) {
            bigInteger = MASK_1_256;
            bigInteger3 = MASK_2_256;
            bigInteger2 = POLYRED_256;
        } else if (i != 512) {
            bigInteger = MASK_1_128;
            bigInteger3 = MASK_2_128;
            bigInteger2 = POLYRED_128;
        } else {
            bigInteger = MASK_1_512;
            bigInteger3 = MASK_2_512;
            bigInteger2 = POLYRED_512;
        }
        BigInteger bigInteger4 = ZERO;
        BigInteger bigInteger5 = new BigInteger(1, reverse);
        BigInteger bigInteger6 = new BigInteger(1, reverse2);
        while (true) {
            BigInteger bigInteger7 = ZERO;
            if (!bigInteger6.equals(bigInteger7)) {
                BigInteger bigInteger8 = ONE;
                if (bigInteger6.and(bigInteger8).equals(bigInteger8)) {
                    bigInteger4 = bigInteger4.xor(bigInteger5);
                }
                bigInteger5 = bigInteger5.shiftLeft(1);
                if (!bigInteger5.and(bigInteger).equals(bigInteger7)) {
                    bigInteger5 = bigInteger5.xor(bigInteger2);
                }
                bigInteger6 = bigInteger6.shiftRight(1);
            } else {
                byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger4.and(bigInteger3));
                Arrays.fill(bArr3, (byte) 0);
                System.arraycopy(asUnsignedByteArray, 0, bArr3, 0, asUnsignedByteArray.length);
                return;
            }
        }
    }

    private class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }
}
