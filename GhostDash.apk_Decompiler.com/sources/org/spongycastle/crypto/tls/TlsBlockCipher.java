package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.security.SecureRandom;
import kotlin.UByte;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class TlsBlockCipher implements TlsCipher {
    protected TlsContext context;
    protected BlockCipher decryptCipher;
    protected BlockCipher encryptCipher;
    protected boolean encryptThenMAC;
    protected byte[] randomData = new byte[256];
    protected TlsMac readMac;
    protected boolean useExplicitIV;
    protected TlsMac writeMac;

    /* access modifiers changed from: protected */
    public int lowestBitSet(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }

    public TlsMac getWriteMac() {
        return this.writeMac;
    }

    public TlsMac getReadMac() {
        return this.readMac;
    }

    public TlsBlockCipher(TlsContext tlsContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int i) throws IOException {
        byte[] bArr;
        byte[] bArr2;
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        TlsContext tlsContext2 = tlsContext;
        BlockCipher blockCipher3 = blockCipher;
        BlockCipher blockCipher4 = blockCipher2;
        int i2 = i;
        this.context = tlsContext2;
        tlsContext.getNonceRandomGenerator().nextBytes(this.randomData);
        this.useExplicitIV = TlsUtils.isTLSv11(tlsContext);
        this.encryptThenMAC = tlsContext.getSecurityParameters().encryptThenMAC;
        int digestSize = (i2 * 2) + digest.getDigestSize() + digest2.getDigestSize();
        int blockSize = !this.useExplicitIV ? digestSize + blockCipher.getBlockSize() + blockCipher2.getBlockSize() : digestSize;
        byte[] calculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext2, blockSize);
        TlsContext tlsContext3 = tlsContext;
        byte[] bArr3 = calculateKeyBlock;
        TlsMac tlsMac = new TlsMac(tlsContext3, digest, bArr3, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        TlsMac tlsMac2 = r1;
        TlsMac tlsMac3 = new TlsMac(tlsContext3, digest2, bArr3, digestSize2, digest2.getDigestSize());
        int digestSize3 = digestSize2 + digest2.getDigestSize();
        KeyParameter keyParameter = new KeyParameter(calculateKeyBlock, digestSize3, i2);
        int i3 = digestSize3 + i2;
        KeyParameter keyParameter2 = new KeyParameter(calculateKeyBlock, i3, i2);
        int i4 = i3 + i2;
        if (this.useExplicitIV) {
            bArr2 = new byte[blockCipher.getBlockSize()];
            bArr = new byte[blockCipher2.getBlockSize()];
        } else {
            bArr2 = Arrays.copyOfRange(calculateKeyBlock, i4, blockCipher.getBlockSize() + i4);
            int blockSize2 = i4 + blockCipher.getBlockSize();
            bArr = Arrays.copyOfRange(calculateKeyBlock, blockSize2, blockCipher2.getBlockSize() + blockSize2);
            i4 = blockSize2 + blockCipher2.getBlockSize();
        }
        if (i4 == blockSize) {
            if (tlsContext.isServer()) {
                this.writeMac = tlsMac2;
                this.readMac = tlsMac;
                this.encryptCipher = blockCipher4;
                this.decryptCipher = blockCipher3;
                parametersWithIV = new ParametersWithIV(keyParameter2, bArr);
                parametersWithIV2 = new ParametersWithIV(keyParameter, bArr2);
            } else {
                this.writeMac = tlsMac;
                this.readMac = tlsMac2;
                this.encryptCipher = blockCipher3;
                this.decryptCipher = blockCipher4;
                parametersWithIV = new ParametersWithIV(keyParameter, bArr2);
                parametersWithIV2 = new ParametersWithIV(keyParameter2, bArr);
            }
            this.encryptCipher.init(true, parametersWithIV);
            this.decryptCipher.init(false, parametersWithIV2);
            return;
        }
        throw new TlsFatalAlert(80);
    }

    public int getPlaintextLimit(int i) {
        int i2;
        int blockSize = this.encryptCipher.getBlockSize();
        int size = this.writeMac.getSize();
        if (this.useExplicitIV) {
            i -= blockSize;
        }
        if (this.encryptThenMAC) {
            int i3 = i - size;
            i2 = i3 - (i3 % blockSize);
        } else {
            i2 = (i - (i % blockSize)) - size;
        }
        return i2 - 1;
    }

    public byte[] encodePlaintext(long j, short s, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2;
        int i5 = i2;
        int blockSize = this.encryptCipher.getBlockSize();
        int size = this.writeMac.getSize();
        ProtocolVersion serverVersion = this.context.getServerVersion();
        boolean z = this.encryptThenMAC;
        int i6 = (blockSize - 1) - ((!z ? i5 + size : i5) % blockSize);
        if ((z || !this.context.getSecurityParameters().truncatedHMac) && !serverVersion.isDTLS() && !serverVersion.isSSL()) {
            i6 += chooseExtraPadBlocks(this.context.getSecureRandom(), (255 - i6) / blockSize) * blockSize;
        }
        int i7 = i6;
        int i8 = size + i5 + i7 + 1;
        boolean z2 = this.useExplicitIV;
        if (z2) {
            i8 += blockSize;
        }
        byte[] bArr3 = new byte[i8];
        if (z2) {
            byte[] bArr4 = new byte[blockSize];
            this.context.getNonceRandomGenerator().nextBytes(bArr4);
            this.encryptCipher.init(true, new ParametersWithIV((CipherParameters) null, bArr4));
            System.arraycopy(bArr4, 0, bArr3, 0, blockSize);
            bArr2 = bArr;
            i4 = i;
            i3 = blockSize + 0;
        } else {
            bArr2 = bArr;
            i4 = i;
            i3 = 0;
        }
        System.arraycopy(bArr2, i4, bArr3, i3, i5);
        int i9 = i3 + i5;
        if (!this.encryptThenMAC) {
            byte[] calculateMac = this.writeMac.calculateMac(j, s, bArr, i, i2);
            System.arraycopy(calculateMac, 0, bArr3, i9, calculateMac.length);
            i9 += calculateMac.length;
        }
        int i10 = i9;
        int i11 = 0;
        while (i11 <= i7) {
            bArr3[i10] = (byte) i7;
            i11++;
            i10++;
        }
        while (i3 < i10) {
            this.encryptCipher.processBlock(bArr3, i3, bArr3, i3);
            i3 += blockSize;
        }
        if (!this.encryptThenMAC) {
            return bArr3;
        }
        byte[] bArr5 = bArr3;
        byte[] calculateMac2 = this.writeMac.calculateMac(j, s, bArr3, 0, i10);
        System.arraycopy(calculateMac2, 0, bArr5, i10, calculateMac2.length);
        int length = calculateMac2.length;
        return bArr5;
    }

    public byte[] decodeCiphertext(long j, short s, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2;
        byte[] bArr3 = bArr;
        int i5 = i;
        int i6 = i2;
        int blockSize = this.decryptCipher.getBlockSize();
        int size = this.readMac.getSize();
        if (this.encryptThenMAC) {
            i3 = blockSize + size;
        } else {
            i3 = Math.max(blockSize, size + 1);
        }
        if (this.useExplicitIV) {
            i3 += blockSize;
        }
        if (i6 >= i3) {
            boolean z = this.encryptThenMAC;
            int i7 = z ? i6 - size : i6;
            if (i7 % blockSize == 0) {
                if (z) {
                    int i8 = i5 + i6;
                    if (!Arrays.constantTimeAreEqual(this.readMac.calculateMac(j, s, bArr, i, i6 - size), Arrays.copyOfRange(bArr3, i8 - size, i8))) {
                        throw new TlsFatalAlert(20);
                    }
                }
                if (this.useExplicitIV) {
                    this.decryptCipher.init(false, new ParametersWithIV((CipherParameters) null, bArr3, i5, blockSize));
                    i5 += blockSize;
                    i7 -= blockSize;
                }
                int i9 = i5;
                int i10 = i7;
                for (int i11 = 0; i11 < i10; i11 += blockSize) {
                    int i12 = i9 + i11;
                    this.decryptCipher.processBlock(bArr3, i12, bArr3, i12);
                }
                int checkPaddingConstantTime = checkPaddingConstantTime(bArr, i9, i10, blockSize, this.encryptThenMAC ? 0 : size);
                boolean z2 = checkPaddingConstantTime == 0;
                int i13 = i10 - checkPaddingConstantTime;
                if (!this.encryptThenMAC) {
                    i13 -= size;
                    int i14 = i9 + i13;
                    i4 = i9;
                    bArr2 = bArr3;
                    z2 |= !Arrays.constantTimeAreEqual(this.readMac.calculateMacConstantTime(j, s, bArr, i9, i13, i10 - size, this.randomData), Arrays.copyOfRange(bArr3, i14, i14 + size));
                } else {
                    i4 = i9;
                    bArr2 = bArr3;
                }
                if (!z2) {
                    return Arrays.copyOfRange(bArr2, i4, i4 + i13);
                }
                throw new TlsFatalAlert(20);
            }
            throw new TlsFatalAlert(21);
        }
        throw new TlsFatalAlert(50);
    }

    /* access modifiers changed from: protected */
    public int checkPaddingConstantTime(byte[] bArr, int i, int i2, int i3, int i4) {
        byte b;
        int i5;
        int i6 = i + i2;
        byte b2 = bArr[i6 - 1];
        int i7 = (b2 & UByte.MAX_VALUE) + 1;
        if ((!TlsUtils.isSSL(this.context) || i7 <= i3) && i4 + i7 <= i2) {
            int i8 = i6 - i7;
            b = 0;
            while (true) {
                int i9 = i8 + 1;
                b = (byte) ((bArr[i8] ^ b2) | b);
                if (i9 >= i6) {
                    break;
                }
                i8 = i9;
            }
            i5 = i7;
            if (b != 0) {
                i7 = 0;
            }
        } else {
            i5 = 0;
            b = 0;
            i7 = 0;
        }
        byte[] bArr2 = this.randomData;
        while (i5 < 256) {
            b = (byte) ((bArr2[i5] ^ b2) | b);
            i5++;
        }
        bArr2[0] = (byte) (bArr2[0] ^ b);
        return i7;
    }

    /* access modifiers changed from: protected */
    public int chooseExtraPadBlocks(SecureRandom secureRandom, int i) {
        return Math.min(lowestBitSet(secureRandom.nextInt()), i);
    }
}
