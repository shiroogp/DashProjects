package org.spongycastle.openpgp.operator.bc;

import java.io.IOException;
import kotlin.UByte;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.bcpg.ECDHPublicBCPGKey;
import org.spongycastle.bcpg.ECSecretBCPGKey;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.BufferedAsymmetricBlockCipher;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPrivateKey;
import org.spongycastle.openpgp.operator.PGPDataDecryptor;
import org.spongycastle.openpgp.operator.PGPPad;
import org.spongycastle.openpgp.operator.PublicKeyDataDecryptorFactory;
import org.spongycastle.openpgp.operator.RFC6637Utils;

public class BcPublicKeyDataDecryptorFactory implements PublicKeyDataDecryptorFactory {
    private BcPGPKeyConverter keyConverter = new BcPGPKeyConverter();
    private PGPPrivateKey privKey;

    public BcPublicKeyDataDecryptorFactory(PGPPrivateKey pGPPrivateKey) {
        this.privKey = pGPPrivateKey;
    }

    public byte[] recoverSessionData(int i, byte[][] bArr) throws PGPException {
        if (i != 18) {
            try {
                AsymmetricBlockCipher createPublicKeyCipher = BcImplProvider.createPublicKeyCipher(i);
                AsymmetricKeyParameter privateKey = this.keyConverter.getPrivateKey(this.privKey);
                BufferedAsymmetricBlockCipher bufferedAsymmetricBlockCipher = new BufferedAsymmetricBlockCipher(createPublicKeyCipher);
                bufferedAsymmetricBlockCipher.init(false, privateKey);
                if (i != 2) {
                    if (i != 1) {
                        int bitLength = (((ElGamalPrivateKeyParameters) new BcPGPKeyConverter().getPrivateKey(this.privKey)).getParameters().getP().bitLength() + 7) / 8;
                        byte[] bArr2 = new byte[bitLength];
                        byte[] bArr3 = bArr[0];
                        if (bArr3.length - 2 > bitLength) {
                            bufferedAsymmetricBlockCipher.processBytes(bArr3, 3, bArr3.length - 3);
                        } else {
                            System.arraycopy(bArr3, 2, bArr2, bitLength - (bArr3.length - 2), bArr3.length - 2);
                            bufferedAsymmetricBlockCipher.processBytes(bArr2, 0, bitLength);
                        }
                        byte[] bArr4 = bArr[1];
                        for (int i2 = 0; i2 != bitLength; i2++) {
                            bArr2[i2] = 0;
                        }
                        if (bArr4.length - 2 > bitLength) {
                            bufferedAsymmetricBlockCipher.processBytes(bArr4, 3, bArr4.length - 3);
                        } else {
                            System.arraycopy(bArr4, 2, bArr2, bitLength - (bArr4.length - 2), bArr4.length - 2);
                            bufferedAsymmetricBlockCipher.processBytes(bArr2, 0, bitLength);
                        }
                        return bufferedAsymmetricBlockCipher.doFinal();
                    }
                }
                byte[] bArr5 = bArr[0];
                bufferedAsymmetricBlockCipher.processBytes(bArr5, 2, bArr5.length - 2);
                return bufferedAsymmetricBlockCipher.doFinal();
            } catch (IOException e) {
                throw new PGPException("exception creating user keying material: " + e.getMessage(), e);
            } catch (InvalidCipherTextException e2) {
                throw new PGPException("exception encrypting session info: " + e2.getMessage(), e2);
            }
        } else {
            ECDHPublicBCPGKey eCDHPublicBCPGKey = (ECDHPublicBCPGKey) this.privKey.getPublicKeyPacket().getKey();
            X9ECParameters byOID = NISTNamedCurves.getByOID(eCDHPublicBCPGKey.getCurveOID());
            byte[] bArr6 = bArr[0];
            int i3 = ((((bArr6[0] & UByte.MAX_VALUE) << 8) + (bArr6[1] & UByte.MAX_VALUE)) + 7) / 8;
            byte[] bArr7 = new byte[i3];
            System.arraycopy(bArr6, 2, bArr7, 0, i3);
            int i4 = i3 + 2;
            byte b = bArr6[i4];
            byte[] bArr8 = new byte[b];
            System.arraycopy(bArr6, i4 + 1, bArr8, 0, b);
            Wrapper createWrapper = BcImplProvider.createWrapper(eCDHPublicBCPGKey.getSymmetricKeyAlgorithm());
            createWrapper.init(false, new KeyParameter(new RFC6637KDFCalculator(new BcPGPDigestCalculatorProvider().get(eCDHPublicBCPGKey.getHashAlgorithm()), eCDHPublicBCPGKey.getSymmetricKeyAlgorithm()).createKey(byOID.getCurve().decodePoint(bArr7).multiply(((ECSecretBCPGKey) this.privKey.getPrivateKeyDataPacket()).getX()).normalize(), RFC6637Utils.createUserKeyingMaterial(this.privKey.getPublicKeyPacket(), new BcKeyFingerprintCalculator()))));
            return PGPPad.unpadSessionData(createWrapper.unwrap(bArr8, 0, b));
        }
    }

    public PGPDataDecryptor createDataDecryptor(boolean z, int i, byte[] bArr) throws PGPException {
        return BcUtil.createDataDecryptor(z, BcImplProvider.createBlockCipher(i), bArr);
    }
}
