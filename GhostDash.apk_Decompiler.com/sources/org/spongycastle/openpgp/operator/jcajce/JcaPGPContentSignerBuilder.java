package org.spongycastle.openpgp.operator.jcajce;

import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPrivateKey;
import org.spongycastle.openpgp.PGPRuntimeOperationException;
import org.spongycastle.openpgp.operator.PGPContentSigner;
import org.spongycastle.openpgp.operator.PGPContentSignerBuilder;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;
import org.spongycastle.util.io.TeeOutputStream;

public class JcaPGPContentSignerBuilder implements PGPContentSignerBuilder {
    private JcaPGPDigestCalculatorProviderBuilder digestCalculatorProviderBuilder = new JcaPGPDigestCalculatorProviderBuilder();
    /* access modifiers changed from: private */
    public int hashAlgorithm;
    private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    /* access modifiers changed from: private */
    public int keyAlgorithm;
    private JcaPGPKeyConverter keyConverter = new JcaPGPKeyConverter();
    private SecureRandom random;

    public JcaPGPContentSignerBuilder(int i, int i2) {
        this.keyAlgorithm = i;
        this.hashAlgorithm = i2;
    }

    public JcaPGPContentSignerBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public JcaPGPContentSignerBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        this.keyConverter.setProvider(provider);
        this.digestCalculatorProviderBuilder.setProvider(provider);
        return this;
    }

    public JcaPGPContentSignerBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        this.keyConverter.setProvider(str);
        this.digestCalculatorProviderBuilder.setProvider(str);
        return this;
    }

    public JcaPGPContentSignerBuilder setDigestProvider(Provider provider) {
        this.digestCalculatorProviderBuilder.setProvider(provider);
        return this;
    }

    public JcaPGPContentSignerBuilder setDigestProvider(String str) {
        this.digestCalculatorProviderBuilder.setProvider(str);
        return this;
    }

    public PGPContentSigner build(int i, PGPPrivateKey pGPPrivateKey) throws PGPException {
        if (pGPPrivateKey instanceof JcaPGPPrivateKey) {
            return build(i, pGPPrivateKey.getKeyID(), ((JcaPGPPrivateKey) pGPPrivateKey).getPrivateKey());
        }
        return build(i, pGPPrivateKey.getKeyID(), this.keyConverter.getPrivateKey(pGPPrivateKey));
    }

    public PGPContentSigner build(int i, long j, PrivateKey privateKey) throws PGPException {
        final PGPDigestCalculator pGPDigestCalculator = this.digestCalculatorProviderBuilder.build().get(this.hashAlgorithm);
        final Signature createSignature = this.helper.createSignature(this.keyAlgorithm, this.hashAlgorithm);
        try {
            SecureRandom secureRandom = this.random;
            if (secureRandom != null) {
                createSignature.initSign(privateKey, secureRandom);
            } else {
                createSignature.initSign(privateKey);
            }
            final int i2 = i;
            final long j2 = j;
            return new PGPContentSigner() {
                public int getType() {
                    return i2;
                }

                public int getHashAlgorithm() {
                    return JcaPGPContentSignerBuilder.this.hashAlgorithm;
                }

                public int getKeyAlgorithm() {
                    return JcaPGPContentSignerBuilder.this.keyAlgorithm;
                }

                public long getKeyID() {
                    return j2;
                }

                public OutputStream getOutputStream() {
                    return new TeeOutputStream(new SignatureOutputStream(createSignature), pGPDigestCalculator.getOutputStream());
                }

                public byte[] getSignature() {
                    try {
                        return createSignature.sign();
                    } catch (SignatureException e) {
                        throw new PGPRuntimeOperationException("Unable to create signature: " + e.getMessage(), e);
                    }
                }

                public byte[] getDigest() {
                    return pGPDigestCalculator.getDigest();
                }
            };
        } catch (InvalidKeyException e) {
            throw new PGPException("invalid key.", e);
        }
    }
}
