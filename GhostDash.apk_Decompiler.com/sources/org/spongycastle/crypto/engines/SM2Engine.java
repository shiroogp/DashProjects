package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class SM2Engine {
    private int curveLength;
    private final Digest digest;
    private ECKeyParameters ecKey;
    private ECDomainParameters ecParams;
    private boolean forEncryption;
    private SecureRandom random;

    public SM2Engine() {
        this(new SM3Digest());
    }

    public SM2Engine(Digest digest2) {
        this.digest = digest2;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (z) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            ECKeyParameters eCKeyParameters = (ECKeyParameters) parametersWithRandom.getParameters();
            this.ecKey = eCKeyParameters;
            this.ecParams = eCKeyParameters.getParameters();
            if (!((ECPublicKeyParameters) this.ecKey).getQ().multiply(this.ecParams.getH()).isInfinity()) {
                this.random = parametersWithRandom.getRandom();
            } else {
                throw new IllegalArgumentException("invalid key: [h]Q at infinity");
            }
        } else {
            ECKeyParameters eCKeyParameters2 = (ECKeyParameters) cipherParameters;
            this.ecKey = eCKeyParameters2;
            this.ecParams = eCKeyParameters2.getParameters();
        }
        this.curveLength = (this.ecParams.getCurve().getFieldSize() + 7) / 8;
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return encrypt(bArr, i, i2);
        }
        return decrypt(bArr, i, i2);
    }

    private byte[] encrypt(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] encoded;
        ECPoint normalize;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        do {
            BigInteger nextK = nextK();
            encoded = this.ecParams.getG().multiply(nextK).normalize().getEncoded(false);
            normalize = ((ECPublicKeyParameters) this.ecKey).getQ().multiply(nextK).normalize();
            kdf(this.digest, normalize, bArr2);
        } while (notEncrypted(bArr2, bArr, i));
        byte[] bArr3 = new byte[this.digest.getDigestSize()];
        addFieldElement(this.digest, normalize.getAffineXCoord());
        this.digest.update(bArr, i, i2);
        addFieldElement(this.digest, normalize.getAffineYCoord());
        this.digest.doFinal(bArr3, 0);
        return Arrays.concatenate(encoded, bArr2, bArr3);
    }

    private byte[] decrypt(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        int i3 = (this.curveLength * 2) + 1;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        ECPoint decodePoint = this.ecParams.getCurve().decodePoint(bArr2);
        if (!decodePoint.multiply(this.ecParams.getH()).isInfinity()) {
            ECPoint normalize = decodePoint.multiply(((ECPrivateKeyParameters) this.ecKey).getD()).normalize();
            int digestSize = (i2 - i3) - this.digest.getDigestSize();
            byte[] bArr3 = new byte[digestSize];
            System.arraycopy(bArr, i + i3, bArr3, 0, digestSize);
            kdf(this.digest, normalize, bArr3);
            int digestSize2 = this.digest.getDigestSize();
            byte[] bArr4 = new byte[digestSize2];
            addFieldElement(this.digest, normalize.getAffineXCoord());
            this.digest.update(bArr3, 0, digestSize);
            addFieldElement(this.digest, normalize.getAffineYCoord());
            this.digest.doFinal(bArr4, 0);
            byte b = 0;
            for (int i4 = 0; i4 != digestSize2; i4++) {
                b |= bArr4[i4] ^ bArr[(i3 + digestSize) + i4];
            }
            clearBlock(bArr2);
            clearBlock(bArr4);
            if (b == 0) {
                return bArr3;
            }
            clearBlock(bArr3);
            throw new InvalidCipherTextException("invalid cipher text");
        }
        throw new InvalidCipherTextException("[h]C1 at infinity");
    }

    private boolean notEncrypted(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 != bArr.length; i2++) {
            if (bArr[i2] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void kdf(Digest digest2, ECPoint eCPoint, byte[] bArr) {
        int digestSize = digest2.getDigestSize();
        int digestSize2 = digest2.getDigestSize();
        byte[] bArr2 = new byte[digestSize2];
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i2 <= ((bArr.length + digestSize) - 1) / digestSize) {
            addFieldElement(digest2, eCPoint.getAffineXCoord());
            addFieldElement(digest2, eCPoint.getAffineYCoord());
            digest2.update((byte) (i3 >> 24));
            digest2.update((byte) (i3 >> 16));
            digest2.update((byte) (i3 >> 8));
            digest2.update((byte) i3);
            digest2.doFinal(bArr2, 0);
            int i4 = i + digestSize2;
            if (i4 < bArr.length) {
                xor(bArr, bArr2, i, digestSize2);
            } else {
                xor(bArr, bArr2, i, bArr.length - i);
            }
            i3++;
            i2++;
            i = i4;
        }
    }

    private void xor(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 != i2; i3++) {
            int i4 = i + i3;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i3]);
        }
    }

    private BigInteger nextK() {
        int bitLength = this.ecParams.getN().bitLength();
        while (true) {
            BigInteger bigInteger = new BigInteger(bitLength, this.random);
            if (!bigInteger.equals(ECConstants.ZERO) && bigInteger.compareTo(this.ecParams.getN()) < 0) {
                return bigInteger;
            }
        }
    }

    private void addFieldElement(Digest digest2, ECFieldElement eCFieldElement) {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.curveLength, eCFieldElement.toBigInteger());
        digest2.update(asUnsignedByteArray, 0, asUnsignedByteArray.length);
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }
}
