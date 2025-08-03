package org.spongycastle.openpgp.operator.jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.spongycastle.openpgp.operator.PGPDigestCalculatorProvider;

public class JcePBESecretKeyDecryptorBuilder {
    private PGPDigestCalculatorProvider calculatorProvider;
    private JcaPGPDigestCalculatorProviderBuilder calculatorProviderBuilder;
    /* access modifiers changed from: private */
    public OperatorHelper helper;

    public JcePBESecretKeyDecryptorBuilder() {
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.calculatorProviderBuilder = new JcaPGPDigestCalculatorProviderBuilder();
    }

    public JcePBESecretKeyDecryptorBuilder(PGPDigestCalculatorProvider pGPDigestCalculatorProvider) {
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.calculatorProvider = pGPDigestCalculatorProvider;
    }

    public JcePBESecretKeyDecryptorBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        JcaPGPDigestCalculatorProviderBuilder jcaPGPDigestCalculatorProviderBuilder = this.calculatorProviderBuilder;
        if (jcaPGPDigestCalculatorProviderBuilder != null) {
            jcaPGPDigestCalculatorProviderBuilder.setProvider(provider);
        }
        return this;
    }

    public JcePBESecretKeyDecryptorBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        JcaPGPDigestCalculatorProviderBuilder jcaPGPDigestCalculatorProviderBuilder = this.calculatorProviderBuilder;
        if (jcaPGPDigestCalculatorProviderBuilder != null) {
            jcaPGPDigestCalculatorProviderBuilder.setProvider(str);
        }
        return this;
    }

    public PBESecretKeyDecryptor build(char[] cArr) throws PGPException {
        if (this.calculatorProvider == null) {
            this.calculatorProvider = this.calculatorProviderBuilder.build();
        }
        return new PBESecretKeyDecryptor(cArr, this.calculatorProvider) {
            public byte[] recoverKeyData(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3) throws PGPException {
                try {
                    Cipher createCipher = JcePBESecretKeyDecryptorBuilder.this.helper.createCipher(PGPUtil.getSymmetricCipherName(i) + "/CFB/NoPadding");
                    createCipher.init(2, PGPUtil.makeSymmetricKey(i, bArr), new IvParameterSpec(bArr2));
                    return createCipher.doFinal(bArr3, i2, i3);
                } catch (IllegalBlockSizeException e) {
                    throw new PGPException("illegal block size: " + e.getMessage(), e);
                } catch (BadPaddingException e2) {
                    throw new PGPException("bad padding: " + e2.getMessage(), e2);
                } catch (InvalidAlgorithmParameterException e3) {
                    throw new PGPException("invalid parameter: " + e3.getMessage(), e3);
                } catch (InvalidKeyException e4) {
                    throw new PGPException("invalid key: " + e4.getMessage(), e4);
                }
            }
        };
    }
}
