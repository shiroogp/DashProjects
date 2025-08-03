package org.spongycastle.operator.jcajce;

import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.operator.AsymmetricKeyUnwrapper;

public class JceAsymmetricKeyUnwrapper extends AsymmetricKeyUnwrapper {
    private Map extraMappings = new HashMap();
    private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    private PrivateKey privKey;
    private boolean unwrappedKeyMustBeEncodable;

    public JceAsymmetricKeyUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        super(algorithmIdentifier);
        this.privKey = privateKey;
    }

    public JceAsymmetricKeyUnwrapper setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JceAsymmetricKeyUnwrapper setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceAsymmetricKeyUnwrapper setMustProduceEncodableUnwrappedKey(boolean z) {
        this.unwrappedKeyMustBeEncodable = z;
        return this;
    }

    public JceAsymmetricKeyUnwrapper setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        this.extraMappings.put(aSN1ObjectIdentifier, str);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r2.length != 0) goto L_0x0046;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[ExcHandler: IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:11:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.operator.GenericKey generateUnwrappedKey(org.spongycastle.asn1.x509.AlgorithmIdentifier r6, byte[] r7) throws org.spongycastle.operator.OperatorException {
        /*
            r5 = this;
            org.spongycastle.operator.jcajce.OperatorHelper r0 = r5.helper     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r5.getAlgorithmIdentifier()     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            java.util.Map r2 = r5.extraMappings     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            javax.crypto.Cipher r0 = r0.createAsymmetricWrapper(r1, r2)     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            org.spongycastle.operator.jcajce.OperatorHelper r1 = r5.helper     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r2 = r5.getAlgorithmIdentifier()     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            java.security.AlgorithmParameters r1 = r1.createAlgorithmParameters(r2)     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            r2 = 4
            r3 = 0
            if (r1 == 0) goto L_0x0024
            java.security.PrivateKey r4 = r5.privKey     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0047 }
            r0.init(r2, r4, r1)     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0047 }
            goto L_0x0029
        L_0x0024:
            java.security.PrivateKey r1 = r5.privKey     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0047 }
            r0.init(r2, r1)     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0047 }
        L_0x0029:
            org.spongycastle.operator.jcajce.OperatorHelper r1 = r5.helper     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0047 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r6.getAlgorithm()     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0047 }
            java.lang.String r1 = r1.getKeyAlgorithmName(r2)     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0047 }
            r2 = 3
            java.security.Key r1 = r0.unwrap(r7, r1, r2)     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0047 }
            boolean r2 = r5.unwrappedKeyMustBeEncodable     // Catch:{  }
            if (r2 == 0) goto L_0x0046
            byte[] r2 = r1.getEncoded()     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0046, IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0046, IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0046 }
            if (r2 == 0) goto L_0x0047
            int r2 = r2.length     // Catch:{ IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0046, IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0046, IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException -> 0x0046 }
            if (r2 != 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r3 = r1
        L_0x0047:
            if (r3 != 0) goto L_0x0060
            r1 = 2
            java.security.PrivateKey r2 = r5.privKey     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            r0.init(r1, r2)     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            javax.crypto.spec.SecretKeySpec r3 = new javax.crypto.spec.SecretKeySpec     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            byte[] r7 = r0.doFinal(r7)     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r6.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            java.lang.String r0 = r0.getId()     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            r3.<init>(r7, r0)     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
        L_0x0060:
            org.spongycastle.operator.jcajce.JceGenericKey r7 = new org.spongycastle.operator.jcajce.JceGenericKey     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            r7.<init>(r6, r3)     // Catch:{ InvalidKeyException -> 0x00a2, IllegalBlockSizeException -> 0x0084, BadPaddingException -> 0x0066 }
            return r7
        L_0x0066:
            r6 = move-exception
            org.spongycastle.operator.OperatorException r7 = new org.spongycastle.operator.OperatorException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "bad padding: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r6.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0, r6)
            throw r7
        L_0x0084:
            r6 = move-exception
            org.spongycastle.operator.OperatorException r7 = new org.spongycastle.operator.OperatorException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "illegal blocksize: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r6.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0, r6)
            throw r7
        L_0x00a2:
            r6 = move-exception
            org.spongycastle.operator.OperatorException r7 = new org.spongycastle.operator.OperatorException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "key invalid: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r6.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.operator.jcajce.JceAsymmetricKeyUnwrapper.generateUnwrappedKey(org.spongycastle.asn1.x509.AlgorithmIdentifier, byte[]):org.spongycastle.operator.GenericKey");
    }
}
