package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.x9.X9IntegerConverter;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.agreement.ECDHCBasicAgreement;
import org.spongycastle.crypto.agreement.ECMQVBasicAgreement;
import org.spongycastle.crypto.agreement.kdf.ConcatenationKDFGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.spec.MQVParameterSpec;
import org.spongycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.MQVPublicKey;

public class KeyAgreementSpi extends BaseAgreementSpi {
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private BasicAgreement agreement;
    private String kaAlgorithm;
    private MQVParameterSpec mqvParameters;
    private ECDomainParameters parameters;

    protected KeyAgreementSpi(String str, BasicAgreement basicAgreement, DerivationFunction derivationFunction) {
        super(str, derivationFunction);
        this.kaAlgorithm = str;
        this.agreement = basicAgreement;
    }

    /* access modifiers changed from: protected */
    public byte[] bigIntToBytes(BigInteger bigInteger) {
        X9IntegerConverter x9IntegerConverter = converter;
        return x9IntegerConverter.integerToBytes(bigInteger, x9IntegerConverter.getByteLength(this.parameters.getCurve()));
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        CipherParameters cipherParameters;
        if (this.parameters == null) {
            throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
        } else if (z) {
            if (this.agreement instanceof ECMQVBasicAgreement) {
                if (!(key instanceof MQVPublicKey)) {
                    cipherParameters = new MQVPublicParameters((ECPublicKeyParameters) ECUtil.generatePublicKeyParameter((PublicKey) key), (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(this.mqvParameters.getOtherPartyEphemeralKey()));
                } else {
                    MQVPublicKey mQVPublicKey = (MQVPublicKey) key;
                    cipherParameters = new MQVPublicParameters((ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getStaticKey()), (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getEphemeralKey()));
                }
            } else if (key instanceof PublicKey) {
                cipherParameters = ECUtil.generatePublicKeyParameter((PublicKey) key);
            } else {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPublicKey.class) + " for doPhase");
            }
            this.result = this.agreement.calculateAgreement(cipherParameters);
            return null;
        } else {
            throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof MQVParameterSpec) || (algorithmParameterSpec instanceof UserKeyingMaterialSpec)) {
            initFromKey(key, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        initFromKey(key, (AlgorithmParameterSpec) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: org.spongycastle.crypto.params.ECPublicKeyParameters} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initFromKey(java.security.Key r6, java.security.spec.AlgorithmParameterSpec r7) throws java.security.InvalidKeyException {
        /*
            r5 = this;
            org.spongycastle.crypto.BasicAgreement r0 = r5.agreement
            boolean r0 = r0 instanceof org.spongycastle.crypto.agreement.ECMQVBasicAgreement
            java.lang.String r1 = " for initialisation"
            java.lang.String r2 = " key agreement requires "
            r3 = 0
            if (r0 == 0) goto L_0x00a6
            r5.mqvParameters = r3
            boolean r0 = r6 instanceof org.spongycastle.jce.interfaces.MQVPrivateKey
            if (r0 != 0) goto L_0x003d
            boolean r4 = r7 instanceof org.spongycastle.jcajce.spec.MQVParameterSpec
            if (r4 == 0) goto L_0x0016
            goto L_0x003d
        L_0x0016:
            java.security.InvalidKeyException r6 = new java.security.InvalidKeyException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = r5.kaAlgorithm
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.StringBuilder r7 = r7.append(r2)
            java.lang.Class<org.spongycastle.jcajce.spec.MQVParameterSpec> r0 = org.spongycastle.jcajce.spec.MQVParameterSpec.class
            java.lang.String r0 = getSimpleName(r0)
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x003d:
            if (r0 == 0) goto L_0x0067
            org.spongycastle.jce.interfaces.MQVPrivateKey r6 = (org.spongycastle.jce.interfaces.MQVPrivateKey) r6
            java.security.PrivateKey r7 = r6.getStaticPrivateKey()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r7 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r7)
            org.spongycastle.crypto.params.ECPrivateKeyParameters r7 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r7
            java.security.PrivateKey r0 = r6.getEphemeralPrivateKey()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r0)
            org.spongycastle.crypto.params.ECPrivateKeyParameters r0 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r0
            java.security.PublicKey r1 = r6.getEphemeralPublicKey()
            if (r1 == 0) goto L_0x0095
            java.security.PublicKey r6 = r6.getEphemeralPublicKey()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r6 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePublicKeyParameter(r6)
            r3 = r6
            org.spongycastle.crypto.params.ECPublicKeyParameters r3 = (org.spongycastle.crypto.params.ECPublicKeyParameters) r3
            goto L_0x0095
        L_0x0067:
            org.spongycastle.jcajce.spec.MQVParameterSpec r7 = (org.spongycastle.jcajce.spec.MQVParameterSpec) r7
            java.security.PrivateKey r6 = (java.security.PrivateKey) r6
            org.spongycastle.crypto.params.AsymmetricKeyParameter r6 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r6)
            org.spongycastle.crypto.params.ECPrivateKeyParameters r6 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r6
            java.security.PrivateKey r0 = r7.getEphemeralPrivateKey()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r0)
            org.spongycastle.crypto.params.ECPrivateKeyParameters r0 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r0
            java.security.PublicKey r1 = r7.getEphemeralPublicKey()
            if (r1 == 0) goto L_0x008c
            java.security.PublicKey r1 = r7.getEphemeralPublicKey()
            org.spongycastle.crypto.params.AsymmetricKeyParameter r1 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePublicKeyParameter(r1)
            r3 = r1
            org.spongycastle.crypto.params.ECPublicKeyParameters r3 = (org.spongycastle.crypto.params.ECPublicKeyParameters) r3
        L_0x008c:
            r5.mqvParameters = r7
            byte[] r7 = r7.getUserKeyingMaterial()
            r5.ukmParameters = r7
            r7 = r6
        L_0x0095:
            org.spongycastle.crypto.params.MQVPrivateParameters r6 = new org.spongycastle.crypto.params.MQVPrivateParameters
            r6.<init>(r7, r0, r3)
            org.spongycastle.crypto.params.ECDomainParameters r7 = r7.getParameters()
            r5.parameters = r7
            org.spongycastle.crypto.BasicAgreement r7 = r5.agreement
            r7.init(r6)
            goto L_0x00c9
        L_0x00a6:
            boolean r0 = r6 instanceof java.security.PrivateKey
            if (r0 == 0) goto L_0x00ca
            java.security.PrivateKey r6 = (java.security.PrivateKey) r6
            org.spongycastle.crypto.params.AsymmetricKeyParameter r6 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.generatePrivateKeyParameter(r6)
            org.spongycastle.crypto.params.ECPrivateKeyParameters r6 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r6
            org.spongycastle.crypto.params.ECDomainParameters r0 = r6.getParameters()
            r5.parameters = r0
            boolean r0 = r7 instanceof org.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            if (r0 == 0) goto L_0x00c2
            org.spongycastle.jcajce.spec.UserKeyingMaterialSpec r7 = (org.spongycastle.jcajce.spec.UserKeyingMaterialSpec) r7
            byte[] r3 = r7.getUserKeyingMaterial()
        L_0x00c2:
            r5.ukmParameters = r3
            org.spongycastle.crypto.BasicAgreement r7 = r5.agreement
            r7.init(r6)
        L_0x00c9:
            return
        L_0x00ca:
            java.security.InvalidKeyException r6 = new java.security.InvalidKeyException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = r5.kaAlgorithm
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.StringBuilder r7 = r7.append(r2)
            java.lang.Class<org.spongycastle.jce.interfaces.ECPrivateKey> r0 = org.spongycastle.jce.interfaces.ECPrivateKey.class
            java.lang.String r0 = getSimpleName(r0)
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi.initFromKey(java.security.Key, java.security.spec.AlgorithmParameterSpec):void");
    }

    private static String getSimpleName(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    public static class DH extends KeyAgreementSpi {
        public DH() {
            super("ECDH", new ECDHBasicAgreement(), (DerivationFunction) null);
        }
    }

    public static class DHC extends KeyAgreementSpi {
        public DHC() {
            super("ECDHC", new ECDHCBasicAgreement(), (DerivationFunction) null);
        }
    }

    public static class MQV extends KeyAgreementSpi {
        public MQV() {
            super("ECMQV", new ECMQVBasicAgreement(), (DerivationFunction) null);
        }
    }

    public static class DHwithSHA1KDF extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA1KDFAndSharedInfo() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class CDHwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA1KDFAndSharedInfo() {
            super("ECCDHwithSHA1KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA224KDFAndSharedInfo() {
            super("ECDHwithSHA224KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class CDHwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA224KDFAndSharedInfo() {
            super("ECCDHwithSHA224KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class DHwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA256KDFAndSharedInfo() {
            super("ECDHwithSHA256KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class CDHwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA256KDFAndSharedInfo() {
            super("ECCDHwithSHA256KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class DHwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA384KDFAndSharedInfo() {
            super("ECDHwithSHA384KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class CDHwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA384KDFAndSharedInfo() {
            super("ECCDHwithSHA384KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class DHwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA512KDFAndSharedInfo() {
            super("ECDHwithSHA512KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
        }
    }

    public static class CDHwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA512KDFAndSharedInfo() {
            super("ECCDHwithSHA512KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
        }
    }

    public static class MQVwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA1KDFAndSharedInfo() {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class MQVwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA224KDFAndSharedInfo() {
            super("ECMQVwithSHA224KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class MQVwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA256KDFAndSharedInfo() {
            super("ECMQVwithSHA256KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class MQVwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA384KDFAndSharedInfo() {
            super("ECMQVwithSHA384KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class MQVwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA512KDFAndSharedInfo() {
            super("ECMQVwithSHA512KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
        }
    }

    public static class DHwithSHA1CKDF extends KeyAgreementSpi {
        public DHwithSHA1CKDF() {
            super("ECDHwithSHA1CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA256CKDF extends KeyAgreementSpi {
        public DHwithSHA256CKDF() {
            super("ECDHwithSHA256CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA256Digest()));
        }
    }

    public static class DHwithSHA384CKDF extends KeyAgreementSpi {
        public DHwithSHA384CKDF() {
            super("ECDHwithSHA384CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA384Digest()));
        }
    }

    public static class DHwithSHA512CKDF extends KeyAgreementSpi {
        public DHwithSHA512CKDF() {
            super("ECDHwithSHA512CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA512Digest()));
        }
    }

    public static class MQVwithSHA1CKDF extends KeyAgreementSpi {
        public MQVwithSHA1CKDF() {
            super("ECMQVwithSHA1CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA1Digest()));
        }
    }

    public static class MQVwithSHA224CKDF extends KeyAgreementSpi {
        public MQVwithSHA224CKDF() {
            super("ECMQVwithSHA224CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA224Digest()));
        }
    }

    public static class MQVwithSHA256CKDF extends KeyAgreementSpi {
        public MQVwithSHA256CKDF() {
            super("ECMQVwithSHA256CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA256Digest()));
        }
    }

    public static class MQVwithSHA384CKDF extends KeyAgreementSpi {
        public MQVwithSHA384CKDF() {
            super("ECMQVwithSHA384CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA384Digest()));
        }
    }

    public static class MQVwithSHA512CKDF extends KeyAgreementSpi {
        public MQVwithSHA512CKDF() {
            super("ECMQVwithSHA512CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA512Digest()));
        }
    }
}
