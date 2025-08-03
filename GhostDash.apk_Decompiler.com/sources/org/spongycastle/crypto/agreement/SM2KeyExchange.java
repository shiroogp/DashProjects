package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithID;
import org.spongycastle.crypto.params.SM2KeyExchangePrivateParameters;
import org.spongycastle.crypto.params.SM2KeyExchangePublicParameters;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class SM2KeyExchange {
    private int curveLength;
    private final Digest digest;
    private ECDomainParameters ecParams;
    private ECPrivateKeyParameters ephemeralKey;
    private ECPoint ephemeralPubPoint;
    private boolean initiator;
    private ECPrivateKeyParameters staticKey;
    private ECPoint staticPubPoint;
    private byte[] userID;
    private int w;

    public SM2KeyExchange() {
        this(new SM3Digest());
    }

    public SM2KeyExchange(Digest digest2) {
        this.digest = digest2;
    }

    public void init(CipherParameters cipherParameters) {
        SM2KeyExchangePrivateParameters sM2KeyExchangePrivateParameters;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) parametersWithID.getParameters();
            this.userID = parametersWithID.getID();
        } else {
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) cipherParameters;
            this.userID = new byte[0];
        }
        this.initiator = sM2KeyExchangePrivateParameters.isInitiator();
        this.staticKey = sM2KeyExchangePrivateParameters.getStaticPrivateKey();
        this.ephemeralKey = sM2KeyExchangePrivateParameters.getEphemeralPrivateKey();
        this.ecParams = this.staticKey.getParameters();
        this.staticPubPoint = sM2KeyExchangePrivateParameters.getStaticPublicPoint();
        this.ephemeralPubPoint = sM2KeyExchangePrivateParameters.getEphemeralPublicPoint();
        this.curveLength = (this.ecParams.getCurve().getFieldSize() + 7) / 8;
        this.w = (this.ecParams.getCurve().getFieldSize() / 2) - 1;
    }

    public int getFieldSize() {
        return (this.staticKey.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public byte[] calculateKey(int i, CipherParameters cipherParameters) {
        byte[] bArr;
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArr = parametersWithID.getID();
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters;
            bArr = new byte[0];
        }
        byte[] z = getZ(this.digest, this.userID, this.staticPubPoint);
        byte[] z2 = getZ(this.digest, bArr, sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
        ECPoint calculateU = calculateU(sM2KeyExchangePublicParameters);
        if (this.initiator) {
            return kdf(calculateU, z, z2, i);
        }
        return kdf(calculateU, z2, z, i);
    }

    public byte[][] calculateKeyWithConfirmation(int i, byte[] bArr, CipherParameters cipherParameters) {
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        byte[] bArr2;
        int i2 = i;
        byte[] bArr3 = bArr;
        CipherParameters cipherParameters2 = cipherParameters;
        if (cipherParameters2 instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters2;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArr2 = parametersWithID.getID();
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters2;
            bArr2 = new byte[0];
        }
        if (!this.initiator || bArr3 != null) {
            byte[] z = getZ(this.digest, this.userID, this.staticPubPoint);
            byte[] z2 = getZ(this.digest, bArr2, sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
            ECPoint calculateU = calculateU(sM2KeyExchangePublicParameters);
            if (this.initiator) {
                byte[] kdf = kdf(calculateU, z, z2, i2);
                byte[] calculateInnerHash = calculateInnerHash(this.digest, calculateU, z, z2, this.ephemeralPubPoint, sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ());
                if (Arrays.constantTimeAreEqual(S1(this.digest, calculateU, calculateInnerHash), bArr3)) {
                    return new byte[][]{kdf, S2(this.digest, calculateU, calculateInnerHash)};
                }
                throw new IllegalStateException("confirmation tag mismatch");
            }
            byte[] kdf2 = kdf(calculateU, z2, z, i2);
            byte[] calculateInnerHash2 = calculateInnerHash(this.digest, calculateU, z2, z, sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ(), this.ephemeralPubPoint);
            return new byte[][]{kdf2, S1(this.digest, calculateU, calculateInnerHash2), S2(this.digest, calculateU, calculateInnerHash2)};
        }
        throw new IllegalArgumentException("if initiating, confirmationTag must be set");
    }

    private ECPoint calculateU(SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters) {
        BigInteger mod = this.staticKey.getD().add(reduce(this.ephemeralPubPoint.getAffineXCoord().toBigInteger()).multiply(this.ephemeralKey.getD())).mod(this.ecParams.getN());
        return sM2KeyExchangePublicParameters.getStaticPublicKey().getQ().add(sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ().multiply(reduce(sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ().getAffineXCoord().toBigInteger())).normalize()).normalize().multiply(this.ecParams.getH().multiply(mod)).normalize();
    }

    private byte[] kdf(ECPoint eCPoint, byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int digestSize = this.digest.getDigestSize() * 8;
        int digestSize2 = this.digest.getDigestSize();
        byte[] bArr5 = new byte[digestSize2];
        int i2 = (i + 7) / 8;
        byte[] bArr6 = new byte[i2];
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i3 <= ((i + digestSize) - 1) / digestSize) {
            addFieldElement(this.digest, eCPoint.getAffineXCoord());
            addFieldElement(this.digest, eCPoint.getAffineYCoord());
            this.digest.update(bArr3, 0, bArr3.length);
            this.digest.update(bArr4, 0, bArr4.length);
            this.digest.update((byte) (i4 >> 24));
            this.digest.update((byte) (i4 >> 16));
            this.digest.update((byte) (i4 >> 8));
            this.digest.update((byte) i4);
            this.digest.doFinal(bArr5, 0);
            int i6 = i5 + digestSize2;
            if (i6 < i2) {
                System.arraycopy(bArr5, 0, bArr6, i5, digestSize2);
            } else {
                System.arraycopy(bArr5, 0, bArr6, i5, i2 - i5);
            }
            i4++;
            i3++;
            i5 = i6;
        }
        return bArr6;
    }

    private BigInteger reduce(BigInteger bigInteger) {
        return bigInteger.and(BigInteger.valueOf(1).shiftLeft(this.w).subtract(BigInteger.valueOf(1))).setBit(this.w);
    }

    private byte[] S1(Digest digest2, ECPoint eCPoint, byte[] bArr) {
        byte[] bArr2 = new byte[digest2.getDigestSize()];
        digest2.update((byte) 2);
        addFieldElement(digest2, eCPoint.getAffineYCoord());
        digest2.update(bArr, 0, bArr.length);
        digest2.doFinal(bArr2, 0);
        return bArr2;
    }

    private byte[] calculateInnerHash(Digest digest2, ECPoint eCPoint, byte[] bArr, byte[] bArr2, ECPoint eCPoint2, ECPoint eCPoint3) {
        addFieldElement(digest2, eCPoint.getAffineXCoord());
        digest2.update(bArr, 0, bArr.length);
        digest2.update(bArr2, 0, bArr2.length);
        addFieldElement(digest2, eCPoint2.getAffineXCoord());
        addFieldElement(digest2, eCPoint2.getAffineYCoord());
        addFieldElement(digest2, eCPoint3.getAffineXCoord());
        addFieldElement(digest2, eCPoint3.getAffineYCoord());
        byte[] bArr3 = new byte[digest2.getDigestSize()];
        digest2.doFinal(bArr3, 0);
        return bArr3;
    }

    private byte[] S2(Digest digest2, ECPoint eCPoint, byte[] bArr) {
        byte[] bArr2 = new byte[digest2.getDigestSize()];
        digest2.update((byte) 3);
        addFieldElement(digest2, eCPoint.getAffineYCoord());
        digest2.update(bArr, 0, bArr.length);
        digest2.doFinal(bArr2, 0);
        return bArr2;
    }

    private byte[] getZ(Digest digest2, byte[] bArr, ECPoint eCPoint) {
        addUserID(digest2, bArr);
        addFieldElement(digest2, this.ecParams.getCurve().getA());
        addFieldElement(digest2, this.ecParams.getCurve().getB());
        addFieldElement(digest2, this.ecParams.getG().getAffineXCoord());
        addFieldElement(digest2, this.ecParams.getG().getAffineYCoord());
        addFieldElement(digest2, eCPoint.getAffineXCoord());
        addFieldElement(digest2, eCPoint.getAffineYCoord());
        byte[] bArr2 = new byte[digest2.getDigestSize()];
        digest2.doFinal(bArr2, 0);
        return bArr2;
    }

    private void addUserID(Digest digest2, byte[] bArr) {
        int length = bArr.length * 8;
        digest2.update((byte) ((length >> 8) & 255));
        digest2.update((byte) (length & 255));
        digest2.update(bArr, 0, bArr.length);
    }

    private void addFieldElement(Digest digest2, ECFieldElement eCFieldElement) {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.curveLength, eCFieldElement.toBigInteger());
        digest2.update(asUnsignedByteArray, 0, asUnsignedByteArray.length);
    }
}
