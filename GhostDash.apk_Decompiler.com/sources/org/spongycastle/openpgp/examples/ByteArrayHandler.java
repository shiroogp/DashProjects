package org.spongycastle.openpgp.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import org.spongycastle.bcpg.ArmoredOutputStream;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.openpgp.PGPCompressedData;
import org.spongycastle.openpgp.PGPCompressedDataGenerator;
import org.spongycastle.openpgp.PGPEncryptedDataGenerator;
import org.spongycastle.openpgp.PGPEncryptedDataList;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPLiteralData;
import org.spongycastle.openpgp.PGPLiteralDataGenerator;
import org.spongycastle.openpgp.PGPPBEEncryptedData;
import org.spongycastle.openpgp.PGPUtil;
import org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcePBEDataDecryptorFactoryBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcePBEKeyEncryptionMethodGenerator;
import org.spongycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.spongycastle.util.encoders.Hex;
import org.spongycastle.util.io.Streams;

public class ByteArrayHandler {
    public static byte[] decrypt(byte[] bArr, char[] cArr) throws IOException, PGPException, NoSuchProviderException {
        PGPEncryptedDataList pGPEncryptedDataList;
        JcaPGPObjectFactory jcaPGPObjectFactory = new JcaPGPObjectFactory(PGPUtil.getDecoderStream(new ByteArrayInputStream(bArr)));
        Object nextObject = jcaPGPObjectFactory.nextObject();
        if (nextObject instanceof PGPEncryptedDataList) {
            pGPEncryptedDataList = (PGPEncryptedDataList) nextObject;
        } else {
            pGPEncryptedDataList = (PGPEncryptedDataList) jcaPGPObjectFactory.nextObject();
        }
        return Streams.readAll(((PGPLiteralData) new JcaPGPObjectFactory(((PGPCompressedData) new JcaPGPObjectFactory(((PGPPBEEncryptedData) pGPEncryptedDataList.get(0)).getDataStream(new JcePBEDataDecryptorFactoryBuilder(new JcaPGPDigestCalculatorProviderBuilder().setProvider(BouncyCastleProvider.PROVIDER_NAME).build()).setProvider(BouncyCastleProvider.PROVIDER_NAME).build(cArr))).nextObject()).getDataStream()).nextObject()).getInputStream());
    }

    public static byte[] encrypt(byte[] bArr, char[] cArr, String str, int i, boolean z) throws IOException, PGPException, NoSuchProviderException {
        if (str == null) {
            str = "_CONSOLE";
        }
        byte[] compress = compress(bArr, str, 1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream armoredOutputStream = z ? new ArmoredOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
        PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(i).setSecureRandom(new SecureRandom()).setProvider(BouncyCastleProvider.PROVIDER_NAME));
        pGPEncryptedDataGenerator.addMethod(new JcePBEKeyEncryptionMethodGenerator(cArr).setProvider(BouncyCastleProvider.PROVIDER_NAME));
        OutputStream open = pGPEncryptedDataGenerator.open(armoredOutputStream, (long) compress.length);
        open.write(compress);
        open.close();
        if (z) {
            armoredOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] compress(byte[] bArr, String str, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(i);
        OutputStream open = new PGPLiteralDataGenerator().open(pGPCompressedDataGenerator.open(byteArrayOutputStream), 'b', str, (long) bArr.length, new Date());
        open.write(bArr);
        open.close();
        pGPCompressedDataGenerator.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        char[] charArray = "Dick Beck".toCharArray();
        byte[] bytes = "Hello world".getBytes();
        System.out.println("Starting PGP test");
        byte[] encrypt = encrypt(bytes, charArray, "iway", 3, true);
        System.out.println("\nencrypted data = '" + new String(encrypt) + "'");
        System.out.println("\ndecrypted data = '" + new String(decrypt(encrypt, charArray)) + "'");
        byte[] encrypt2 = encrypt(bytes, charArray, "iway", 9, false);
        System.out.println("\nencrypted data = '" + new String(Hex.encode(encrypt2)) + "'");
        System.out.println("\ndecrypted data = '" + new String(decrypt(encrypt2, charArray)) + "'");
    }
}
