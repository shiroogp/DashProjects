package org.spongycastle.cms.jcajce;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cms.ecc.ECCCMSSharedInfo;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.cms.CMSException;
import org.spongycastle.cms.KeyAgreeRecipient;
import org.spongycastle.operator.DefaultSecretKeySizeProvider;
import org.spongycastle.operator.SecretKeySizeProvider;
import org.spongycastle.util.Pack;

public abstract class JceKeyAgreeRecipient implements KeyAgreeRecipient {
    private static KeyMaterialGenerator ecc_cms_Generator = new RFC5753KeyMaterialGenerator();
    private static KeyMaterialGenerator old_ecc_cms_Generator = new KeyMaterialGenerator() {
        public byte[] generateKDFMaterial(AlgorithmIdentifier algorithmIdentifier, int i, byte[] bArr) {
            try {
                return new ECCCMSSharedInfo(new AlgorithmIdentifier(algorithmIdentifier.getAlgorithm(), DERNull.INSTANCE), bArr, Pack.intToBigEndian(i)).getEncoded(ASN1Encoding.DER);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to create KDF material: " + e);
            }
        }
    };
    private static final Set possibleOldMessages;
    protected EnvelopedDataHelper contentHelper;
    protected EnvelopedDataHelper helper;
    private SecretKeySizeProvider keySizeProvider = new DefaultSecretKeySizeProvider();
    private PrivateKey recipientKey;

    static {
        HashSet hashSet = new HashSet();
        possibleOldMessages = hashSet;
        hashSet.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
        hashSet.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
    }

    public JceKeyAgreeRecipient(PrivateKey privateKey) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
        this.helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        this.recipientKey = privateKey;
    }

    public JceKeyAgreeRecipient setProvider(Provider provider) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        this.helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        return this;
    }

    public JceKeyAgreeRecipient setProvider(String str) {
        EnvelopedDataHelper envelopedDataHelper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        this.helper = envelopedDataHelper;
        this.contentHelper = envelopedDataHelper;
        return this;
    }

    public JceKeyAgreeRecipient setContentProvider(Provider provider) {
        this.contentHelper = CMSUtils.createContentHelper(provider);
        return this;
    }

    public JceKeyAgreeRecipient setContentProvider(String str) {
        this.contentHelper = CMSUtils.createContentHelper(str);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.security.spec.AlgorithmParameterSpec] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.crypto.SecretKey calculateAgreedWrapKey(org.spongycastle.asn1.x509.AlgorithmIdentifier r6, org.spongycastle.asn1.x509.AlgorithmIdentifier r7, java.security.PublicKey r8, org.spongycastle.asn1.ASN1OctetString r9, java.security.PrivateKey r10, org.spongycastle.cms.jcajce.KeyMaterialGenerator r11) throws org.spongycastle.cms.CMSException, java.security.GeneralSecurityException, java.io.IOException {
        /*
            r5 = this;
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r6.getAlgorithm()
            boolean r0 = org.spongycastle.cms.jcajce.CMSUtils.isMQV(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x007e
            byte[] r9 = r9.getOctets()
            org.spongycastle.asn1.cms.ecc.MQVuserKeyingMaterial r9 = org.spongycastle.asn1.cms.ecc.MQVuserKeyingMaterial.getInstance(r9)
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r0 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = r5.getPrivateKeyAlgorithmIdentifier()
            org.spongycastle.asn1.cms.OriginatorPublicKey r4 = r9.getEphemeralPublicKey()
            org.spongycastle.asn1.DERBitString r4 = r4.getPublicKey()
            byte[] r4 = r4.getBytes()
            r0.<init>((org.spongycastle.asn1.x509.AlgorithmIdentifier) r3, (byte[]) r4)
            java.security.spec.X509EncodedKeySpec r3 = new java.security.spec.X509EncodedKeySpec
            byte[] r0 = r0.getEncoded()
            r3.<init>(r0)
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r0 = r5.helper
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r6.getAlgorithm()
            java.security.KeyFactory r0 = r0.createKeyFactory(r4)
            java.security.PublicKey r0 = r0.generatePublic(r3)
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r3 = r5.helper
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r6.getAlgorithm()
            javax.crypto.KeyAgreement r6 = r3.createKeyAgreement(r6)
            org.spongycastle.asn1.ASN1OctetString r3 = r9.getAddedukm()
            if (r3 == 0) goto L_0x0058
            org.spongycastle.asn1.ASN1OctetString r9 = r9.getAddedukm()
            byte[] r2 = r9.getOctets()
        L_0x0058:
            org.spongycastle.cms.jcajce.KeyMaterialGenerator r9 = old_ecc_cms_Generator
            if (r11 != r9) goto L_0x0066
            org.spongycastle.operator.SecretKeySizeProvider r11 = r5.keySizeProvider
            int r11 = r11.getKeySize((org.spongycastle.asn1.x509.AlgorithmIdentifier) r7)
            byte[] r2 = r9.generateKDFMaterial(r7, r11, r2)
        L_0x0066:
            org.spongycastle.jcajce.spec.MQVParameterSpec r9 = new org.spongycastle.jcajce.spec.MQVParameterSpec
            r9.<init>((java.security.PrivateKey) r10, (java.security.PublicKey) r0, (byte[]) r2)
            r6.init(r10, r9)
            r6.doPhase(r8, r1)
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = r7.getAlgorithm()
            java.lang.String r7 = r7.getId()
            javax.crypto.SecretKey r6 = r6.generateSecret(r7)
            return r6
        L_0x007e:
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r0 = r5.helper
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r6.getAlgorithm()
            javax.crypto.KeyAgreement r0 = r0.createKeyAgreement(r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r6.getAlgorithm()
            boolean r3 = org.spongycastle.cms.jcajce.CMSUtils.isEC(r3)
            if (r3 == 0) goto L_0x00b8
            if (r9 == 0) goto L_0x00a8
            org.spongycastle.operator.SecretKeySizeProvider r6 = r5.keySizeProvider
            int r6 = r6.getKeySize((org.spongycastle.asn1.x509.AlgorithmIdentifier) r7)
            byte[] r9 = r9.getOctets()
            byte[] r6 = r11.generateKDFMaterial(r7, r6, r9)
            org.spongycastle.jcajce.spec.UserKeyingMaterialSpec r2 = new org.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            r2.<init>(r6)
            goto L_0x00cd
        L_0x00a8:
            org.spongycastle.operator.SecretKeySizeProvider r6 = r5.keySizeProvider
            int r6 = r6.getKeySize((org.spongycastle.asn1.x509.AlgorithmIdentifier) r7)
            byte[] r6 = r11.generateKDFMaterial(r7, r6, r2)
            org.spongycastle.jcajce.spec.UserKeyingMaterialSpec r2 = new org.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            r2.<init>(r6)
            goto L_0x00cd
        L_0x00b8:
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = r6.getAlgorithm()
            boolean r11 = org.spongycastle.cms.jcajce.CMSUtils.isRFC2631(r11)
            if (r11 == 0) goto L_0x00e0
            if (r9 == 0) goto L_0x00cd
            org.spongycastle.jcajce.spec.UserKeyingMaterialSpec r2 = new org.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            byte[] r6 = r9.getOctets()
            r2.<init>(r6)
        L_0x00cd:
            r0.init(r10, r2)
            r0.doPhase(r8, r1)
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r7.getAlgorithm()
            java.lang.String r6 = r6.getId()
            javax.crypto.SecretKey r6 = r0.generateSecret(r6)
            return r6
        L_0x00e0:
            org.spongycastle.cms.CMSException r7 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unknown key agreement algorithm: "
            java.lang.StringBuilder r8 = r8.append(r9)
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r6.getAlgorithm()
            java.lang.StringBuilder r6 = r8.append(r6)
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.JceKeyAgreeRecipient.calculateAgreedWrapKey(org.spongycastle.asn1.x509.AlgorithmIdentifier, org.spongycastle.asn1.x509.AlgorithmIdentifier, java.security.PublicKey, org.spongycastle.asn1.ASN1OctetString, java.security.PrivateKey, org.spongycastle.cms.jcajce.KeyMaterialGenerator):javax.crypto.SecretKey");
    }

    private Key unwrapSessionKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey, ASN1ObjectIdentifier aSN1ObjectIdentifier2, byte[] bArr) throws CMSException, InvalidKeyException, NoSuchAlgorithmException {
        Cipher createCipher = this.helper.createCipher(aSN1ObjectIdentifier);
        createCipher.init(4, secretKey);
        return createCipher.unwrap(bArr, this.helper.getBaseCipherName(aSN1ObjectIdentifier2), 3);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        throw new org.spongycastle.cms.CMSException("originator key invalid.", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
        throw new org.spongycastle.cms.CMSException("required padding not supported.", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007f, code lost:
        throw new org.spongycastle.cms.CMSException("originator key spec invalid.", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
        throw new org.spongycastle.cms.CMSException("can't find algorithm.", r9);
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065 A[ExcHandler: Exception (r9v5 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e A[ExcHandler: NoSuchPaddingException (r9v4 'e' javax.crypto.NoSuchPaddingException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077 A[ExcHandler: InvalidKeySpecException (r9v3 'e' java.security.spec.InvalidKeySpecException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089 A[ExcHandler: NoSuchAlgorithmException (r9v1 'e' java.security.NoSuchAlgorithmException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.Key extractSecretKey(org.spongycastle.asn1.x509.AlgorithmIdentifier r9, org.spongycastle.asn1.x509.AlgorithmIdentifier r10, org.spongycastle.asn1.x509.SubjectPublicKeyInfo r11, org.spongycastle.asn1.ASN1OctetString r12, byte[] r13) throws org.spongycastle.cms.CMSException {
        /*
            r8 = this;
            org.spongycastle.asn1.ASN1Encodable r0 = r9.getParameters()     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = org.spongycastle.asn1.x509.AlgorithmIdentifier.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            java.security.spec.X509EncodedKeySpec r1 = new java.security.spec.X509EncodedKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            byte[] r2 = r11.getEncoded()     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            r1.<init>(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r2 = r8.helper     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r11 = r11.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = r11.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            java.security.KeyFactory r11 = r2.createKeyFactory(r11)     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            java.security.PublicKey r11 = r11.generatePublic(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            java.security.PrivateKey r6 = r8.recipientKey     // Catch:{ InvalidKeyException -> 0x003d, NoSuchAlgorithmException -> 0x0089, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.cms.jcajce.KeyMaterialGenerator r7 = ecc_cms_Generator     // Catch:{ InvalidKeyException -> 0x003d, NoSuchAlgorithmException -> 0x0089, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            r1 = r8
            r2 = r9
            r3 = r0
            r4 = r11
            r5 = r12
            javax.crypto.SecretKey r1 = r1.calculateAgreedWrapKey(r2, r3, r4, r5, r6, r7)     // Catch:{ InvalidKeyException -> 0x003d, NoSuchAlgorithmException -> 0x0089, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r0.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x003d, NoSuchAlgorithmException -> 0x0089, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r10.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x003d, NoSuchAlgorithmException -> 0x0089, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            java.security.Key r9 = r8.unwrapSessionKey(r2, r1, r3, r13)     // Catch:{ InvalidKeyException -> 0x003d, NoSuchAlgorithmException -> 0x0089, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            return r9
        L_0x003d:
            r1 = move-exception
            java.util.Set r2 = possibleOldMessages     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r9.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            boolean r2 = r2.contains(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            if (r2 == 0) goto L_0x0064
            java.security.PrivateKey r6 = r8.recipientKey     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.cms.jcajce.KeyMaterialGenerator r7 = old_ecc_cms_Generator     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            r1 = r8
            r2 = r9
            r3 = r0
            r4 = r11
            r5 = r12
            javax.crypto.SecretKey r9 = r1.calculateAgreedWrapKey(r2, r3, r4, r5, r6, r7)     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = r0.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = r10.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            java.security.Key r9 = r8.unwrapSessionKey(r11, r9, r10, r13)     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
            return r9
        L_0x0064:
            throw r1     // Catch:{ NoSuchAlgorithmException -> 0x0089, InvalidKeyException -> 0x0080, InvalidKeySpecException -> 0x0077, NoSuchPaddingException -> 0x006e, Exception -> 0x0065 }
        L_0x0065:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "originator key invalid."
            r10.<init>(r11, r9)
            throw r10
        L_0x006e:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "required padding not supported."
            r10.<init>(r11, r9)
            throw r10
        L_0x0077:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "originator key spec invalid."
            r10.<init>(r11, r9)
            throw r10
        L_0x0080:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "key invalid in message."
            r10.<init>(r11, r9)
            throw r10
        L_0x0089:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "can't find algorithm."
            r10.<init>(r11, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.JceKeyAgreeRecipient.extractSecretKey(org.spongycastle.asn1.x509.AlgorithmIdentifier, org.spongycastle.asn1.x509.AlgorithmIdentifier, org.spongycastle.asn1.x509.SubjectPublicKeyInfo, org.spongycastle.asn1.ASN1OctetString, byte[]):java.security.Key");
    }

    public AlgorithmIdentifier getPrivateKeyAlgorithmIdentifier() {
        return PrivateKeyInfo.getInstance(this.recipientKey.getEncoded()).getPrivateKeyAlgorithm();
    }
}
