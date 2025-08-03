package org.spongycastle.openpgp.operator.jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;

public class JcePBEKeyEncryptionMethodGenerator extends PBEKeyEncryptionMethodGenerator {
    private OperatorHelper helper;

    public JcePBEKeyEncryptionMethodGenerator(char[] cArr, PGPDigestCalculator pGPDigestCalculator) {
        super(cArr, pGPDigestCalculator);
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
    }

    public JcePBEKeyEncryptionMethodGenerator(char[] cArr) {
        this(cArr, (PGPDigestCalculator) new SHA1PGPDigestCalculator());
    }

    public JcePBEKeyEncryptionMethodGenerator(char[] cArr, PGPDigestCalculator pGPDigestCalculator, int i) {
        super(cArr, pGPDigestCalculator, i);
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
    }

    public JcePBEKeyEncryptionMethodGenerator(char[] cArr, int i) {
        super(cArr, new SHA1PGPDigestCalculator(), i);
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
    }

    public JcePBEKeyEncryptionMethodGenerator setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JcePBEKeyEncryptionMethodGenerator setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public PBEKeyEncryptionMethodGenerator setSecureRandom(SecureRandom secureRandom) {
        super.setSecureRandom(secureRandom);
        return this;
    }

    /* access modifiers changed from: protected */
    public byte[] encryptSessionInfo(int i, byte[] bArr, byte[] bArr2) throws PGPException {
        try {
            Cipher createCipher = this.helper.createCipher(PGPUtil.getSymmetricCipherName(i) + "/CFB/NoPadding");
            createCipher.init(1, new SecretKeySpec(bArr, PGPUtil.getSymmetricCipherName(i)), new IvParameterSpec(new byte[createCipher.getBlockSize()]));
            return createCipher.doFinal(bArr2, 0, bArr2.length);
        } catch (IllegalBlockSizeException e) {
            throw new PGPException("illegal block size: " + e.getMessage(), e);
        } catch (BadPaddingException e2) {
            throw new PGPException("bad padding: " + e2.getMessage(), e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new PGPException("IV invalid: " + e3.getMessage(), e3);
        } catch (InvalidKeyException e4) {
            throw new PGPException("key invalid: " + e4.getMessage(), e4);
        }
    }
}
