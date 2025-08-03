package org.spongycastle.openpgp.operator.jcajce;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHKey;
import kotlin.UByte;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.bcpg.ECDHPublicBCPGKey;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPrivateKey;
import org.spongycastle.openpgp.PGPPublicKey;
import org.spongycastle.openpgp.operator.PGPDataDecryptor;
import org.spongycastle.openpgp.operator.PGPPad;
import org.spongycastle.openpgp.operator.PublicKeyDataDecryptorFactory;
import org.spongycastle.openpgp.operator.RFC6637Utils;

public class JcePublicKeyDataDecryptorFactoryBuilder {
    /* access modifiers changed from: private */
    public OperatorHelper contentHelper = new OperatorHelper(new DefaultJcaJceHelper());
    private JcaKeyFingerprintCalculator fingerprintCalculator = new JcaKeyFingerprintCalculator();
    private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    /* access modifiers changed from: private */
    public JcaPGPKeyConverter keyConverter = new JcaPGPKeyConverter();

    public JcePublicKeyDataDecryptorFactoryBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        this.keyConverter.setProvider(provider);
        this.contentHelper = this.helper;
        return this;
    }

    public JcePublicKeyDataDecryptorFactoryBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        this.keyConverter.setProvider(str);
        this.contentHelper = this.helper;
        return this;
    }

    public JcePublicKeyDataDecryptorFactoryBuilder setContentProvider(Provider provider) {
        this.contentHelper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JcePublicKeyDataDecryptorFactoryBuilder setContentProvider(String str) {
        this.contentHelper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public PublicKeyDataDecryptorFactory build(final PrivateKey privateKey) {
        return new PublicKeyDataDecryptorFactory() {
            public byte[] recoverSessionData(int i, byte[][] bArr) throws PGPException {
                if (i != 18) {
                    return JcePublicKeyDataDecryptorFactoryBuilder.this.decryptSessionData(i, privateKey, bArr);
                }
                throw new PGPException("ECDH requires use of PGPPrivateKey for decryption");
            }

            public PGPDataDecryptor createDataDecryptor(boolean z, int i, byte[] bArr) throws PGPException {
                return JcePublicKeyDataDecryptorFactoryBuilder.this.contentHelper.createDataDecryptor(z, i, bArr);
            }
        };
    }

    public PublicKeyDataDecryptorFactory build(final PGPPrivateKey pGPPrivateKey) {
        return new PublicKeyDataDecryptorFactory() {
            public byte[] recoverSessionData(int i, byte[][] bArr) throws PGPException {
                if (i == 18) {
                    JcePublicKeyDataDecryptorFactoryBuilder jcePublicKeyDataDecryptorFactoryBuilder = JcePublicKeyDataDecryptorFactoryBuilder.this;
                    return jcePublicKeyDataDecryptorFactoryBuilder.decryptSessionData(jcePublicKeyDataDecryptorFactoryBuilder.keyConverter, pGPPrivateKey, bArr);
                }
                JcePublicKeyDataDecryptorFactoryBuilder jcePublicKeyDataDecryptorFactoryBuilder2 = JcePublicKeyDataDecryptorFactoryBuilder.this;
                return jcePublicKeyDataDecryptorFactoryBuilder2.decryptSessionData(i, jcePublicKeyDataDecryptorFactoryBuilder2.keyConverter.getPrivateKey(pGPPrivateKey), bArr);
            }

            public PGPDataDecryptor createDataDecryptor(boolean z, int i, byte[] bArr) throws PGPException {
                return JcePublicKeyDataDecryptorFactoryBuilder.this.contentHelper.createDataDecryptor(z, i, bArr);
            }
        };
    }

    /* access modifiers changed from: private */
    public byte[] decryptSessionData(JcaPGPKeyConverter jcaPGPKeyConverter, PGPPrivateKey pGPPrivateKey, byte[][] bArr) throws PGPException {
        PublicKeyPacket publicKeyPacket = pGPPrivateKey.getPublicKeyPacket();
        ECDHPublicBCPGKey eCDHPublicBCPGKey = (ECDHPublicBCPGKey) publicKeyPacket.getKey();
        X9ECParameters byOID = NISTNamedCurves.getByOID(eCDHPublicBCPGKey.getCurveOID());
        byte[] bArr2 = bArr[0];
        int i = ((((bArr2[0] & UByte.MAX_VALUE) << 8) + (bArr2[1] & UByte.MAX_VALUE)) + 7) / 8;
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 2, bArr3, 0, i);
        int i2 = i + 2;
        byte b = bArr2[i2];
        byte[] bArr4 = new byte[b];
        System.arraycopy(bArr2, i2 + 1, bArr4, 0, b);
        ECPoint decodePoint = byOID.getCurve().decodePoint(bArr3);
        try {
            byte[] createUserKeyingMaterial = RFC6637Utils.createUserKeyingMaterial(publicKeyPacket, this.fingerprintCalculator);
            KeyAgreement createKeyAgreement = this.helper.createKeyAgreement(RFC6637Utils.getAgreementAlgorithm(publicKeyPacket));
            createKeyAgreement.init(jcaPGPKeyConverter.getPrivateKey(pGPPrivateKey), new UserKeyingMaterialSpec(createUserKeyingMaterial));
            createKeyAgreement.doPhase(jcaPGPKeyConverter.getPublicKey(new PGPPublicKey(new PublicKeyPacket(18, new Date(), new ECDHPublicBCPGKey(eCDHPublicBCPGKey.getCurveOID(), decodePoint, eCDHPublicBCPGKey.getHashAlgorithm(), eCDHPublicBCPGKey.getSymmetricKeyAlgorithm())), this.fingerprintCalculator)), true);
            SecretKey generateSecret = createKeyAgreement.generateSecret(RFC6637Utils.getKeyEncryptionOID(eCDHPublicBCPGKey.getSymmetricKeyAlgorithm()).getId());
            Cipher createKeyWrapper = this.helper.createKeyWrapper(eCDHPublicBCPGKey.getSymmetricKeyAlgorithm());
            createKeyWrapper.init(4, generateSecret);
            return PGPPad.unpadSessionData(createKeyWrapper.unwrap(bArr4, "Session", 3).getEncoded());
        } catch (InvalidKeyException e) {
            throw new PGPException("error setting asymmetric cipher", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new PGPException("error setting asymmetric cipher", e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new PGPException("error setting asymmetric cipher", e3);
        } catch (GeneralSecurityException e4) {
            throw new PGPException("error setting asymmetric cipher", e4);
        } catch (IOException e5) {
            throw new PGPException("error setting asymmetric cipher", e5);
        }
    }

    /* access modifiers changed from: private */
    public byte[] decryptSessionData(int i, PrivateKey privateKey, byte[][] bArr) throws PGPException {
        Cipher createPublicKeyCipher = this.helper.createPublicKeyCipher(i);
        try {
            createPublicKeyCipher.init(2, privateKey);
            if (i == 2 || i == 1) {
                byte[] bArr2 = bArr[0];
                createPublicKeyCipher.update(bArr2, 2, bArr2.length - 2);
            } else {
                int bitLength = (((DHKey) privateKey).getParams().getP().bitLength() + 7) / 8;
                byte[] bArr3 = new byte[bitLength];
                byte[] bArr4 = bArr[0];
                if (bArr4.length - 2 > bitLength) {
                    createPublicKeyCipher.update(bArr4, 3, bArr4.length - 3);
                } else {
                    System.arraycopy(bArr4, 2, bArr3, bitLength - (bArr4.length - 2), bArr4.length - 2);
                    createPublicKeyCipher.update(bArr3);
                }
                byte[] bArr5 = bArr[1];
                for (int i2 = 0; i2 != bitLength; i2++) {
                    bArr3[i2] = 0;
                }
                if (bArr5.length - 2 > bitLength) {
                    createPublicKeyCipher.update(bArr5, 3, bArr5.length - 3);
                } else {
                    System.arraycopy(bArr5, 2, bArr3, bitLength - (bArr5.length - 2), bArr5.length - 2);
                    createPublicKeyCipher.update(bArr3);
                }
            }
            try {
                return createPublicKeyCipher.doFinal();
            } catch (Exception e) {
                throw new PGPException("exception decrypting session data", e);
            }
        } catch (InvalidKeyException e2) {
            throw new PGPException("error setting asymmetric cipher", e2);
        }
    }
}
