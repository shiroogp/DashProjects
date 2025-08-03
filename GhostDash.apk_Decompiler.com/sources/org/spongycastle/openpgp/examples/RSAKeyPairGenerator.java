package org.spongycastle.openpgp.examples;

import com.pedrouid.crypto.RSA;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import java.util.Date;
import org.spongycastle.bcpg.ArmoredOutputStream;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPSecretKey;
import org.spongycastle.openpgp.PGPSignatureSubpacketVector;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPKeyPair;
import org.spongycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;

public class RSAKeyPairGenerator {
    private static void exportKeyPair(OutputStream outputStream, OutputStream outputStream2, KeyPair keyPair, String str, char[] cArr, boolean z) throws IOException, InvalidKeyException, NoSuchProviderException, SignatureException, PGPException {
        OutputStream outputStream3;
        OutputStream outputStream4;
        if (z) {
            OutputStream outputStream5 = outputStream;
            outputStream3 = new ArmoredOutputStream(outputStream);
        } else {
            outputStream3 = outputStream;
        }
        PGPDigestCalculator pGPDigestCalculator = new JcaPGPDigestCalculatorProviderBuilder().build().get(2);
        KeyPair keyPair2 = keyPair;
        JcaPGPKeyPair jcaPGPKeyPair = new JcaPGPKeyPair(1, keyPair, new Date());
        PGPSecretKey pGPSecretKey = new PGPSecretKey(16, jcaPGPKeyPair, str, pGPDigestCalculator, (PGPSignatureSubpacketVector) null, (PGPSignatureSubpacketVector) null, new JcaPGPContentSignerBuilder(jcaPGPKeyPair.getPublicKey().getAlgorithm(), 2), new JcePBESecretKeyEncryptorBuilder(3, pGPDigestCalculator).setProvider(BouncyCastleProvider.PROVIDER_NAME).build(cArr));
        pGPSecretKey.encode(outputStream3);
        outputStream3.close();
        if (z) {
            OutputStream outputStream6 = outputStream2;
            outputStream4 = new ArmoredOutputStream(outputStream2);
        } else {
            outputStream4 = outputStream2;
        }
        pGPSecretKey.getPublicKey().encode(outputStream4);
        outputStream4.close();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator instance = KeyPairGenerator.getInstance(RSA.ALGORITHM, BouncyCastleProvider.PROVIDER_NAME);
        instance.initialize(1024);
        KeyPair generateKeyPair = instance.generateKeyPair();
        if (strArr.length < 2) {
            System.out.println("RSAKeyPairGenerator [-a] identity passPhrase");
            System.exit(0);
        }
        if (strArr[0].equals("-a")) {
            if (strArr.length < 3) {
                System.out.println("RSAKeyPairGenerator [-a] identity passPhrase");
                System.exit(0);
            }
            exportKeyPair(new FileOutputStream("secret.asc"), new FileOutputStream("pub.asc"), generateKeyPair, strArr[1], strArr[2].toCharArray(), true);
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream("secret.bpg");
        FileOutputStream fileOutputStream2 = new FileOutputStream("pub.bpg");
        exportKeyPair(fileOutputStream, fileOutputStream2, generateKeyPair, strArr[0], strArr[1].toCharArray(), false);
    }
}
