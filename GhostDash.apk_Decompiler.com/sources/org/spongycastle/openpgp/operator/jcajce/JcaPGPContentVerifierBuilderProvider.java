package org.spongycastle.openpgp.operator.jcajce;

import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPublicKey;
import org.spongycastle.openpgp.PGPRuntimeOperationException;
import org.spongycastle.openpgp.operator.PGPContentVerifier;
import org.spongycastle.openpgp.operator.PGPContentVerifierBuilder;
import org.spongycastle.openpgp.operator.PGPContentVerifierBuilderProvider;

public class JcaPGPContentVerifierBuilderProvider implements PGPContentVerifierBuilderProvider {
    /* access modifiers changed from: private */
    public OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    /* access modifiers changed from: private */
    public JcaPGPKeyConverter keyConverter = new JcaPGPKeyConverter();

    public JcaPGPContentVerifierBuilderProvider setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        this.keyConverter.setProvider(provider);
        return this;
    }

    public JcaPGPContentVerifierBuilderProvider setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        this.keyConverter.setProvider(str);
        return this;
    }

    public PGPContentVerifierBuilder get(int i, int i2) throws PGPException {
        return new JcaPGPContentVerifierBuilder(i, i2);
    }

    private class JcaPGPContentVerifierBuilder implements PGPContentVerifierBuilder {
        /* access modifiers changed from: private */
        public int hashAlgorithm;
        /* access modifiers changed from: private */
        public int keyAlgorithm;

        public JcaPGPContentVerifierBuilder(int i, int i2) {
            this.keyAlgorithm = i;
            this.hashAlgorithm = i2;
        }

        public PGPContentVerifier build(final PGPPublicKey pGPPublicKey) throws PGPException {
            final Signature createSignature = JcaPGPContentVerifierBuilderProvider.this.helper.createSignature(this.keyAlgorithm, this.hashAlgorithm);
            try {
                createSignature.initVerify(JcaPGPContentVerifierBuilderProvider.this.keyConverter.getPublicKey(pGPPublicKey));
                return new PGPContentVerifier() {
                    public int getHashAlgorithm() {
                        return JcaPGPContentVerifierBuilder.this.hashAlgorithm;
                    }

                    public int getKeyAlgorithm() {
                        return JcaPGPContentVerifierBuilder.this.keyAlgorithm;
                    }

                    public long getKeyID() {
                        return pGPPublicKey.getKeyID();
                    }

                    public boolean verify(byte[] bArr) {
                        try {
                            return createSignature.verify(bArr);
                        } catch (SignatureException e) {
                            throw new PGPRuntimeOperationException("unable to verify signature: " + e.getMessage(), e);
                        }
                    }

                    public OutputStream getOutputStream() {
                        return new SignatureOutputStream(createSignature);
                    }
                };
            } catch (InvalidKeyException e) {
                throw new PGPException("invalid key.", e);
            }
        }
    }
}
