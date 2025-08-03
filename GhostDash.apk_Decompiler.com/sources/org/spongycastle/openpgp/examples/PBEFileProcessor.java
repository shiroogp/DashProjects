package org.spongycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import org.spongycastle.bcpg.ArmoredOutputStream;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.openpgp.PGPCompressedData;
import org.spongycastle.openpgp.PGPEncryptedDataGenerator;
import org.spongycastle.openpgp.PGPEncryptedDataList;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPLiteralData;
import org.spongycastle.openpgp.PGPPBEEncryptedData;
import org.spongycastle.openpgp.PGPUtil;
import org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcePBEDataDecryptorFactoryBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcePBEKeyEncryptionMethodGenerator;
import org.spongycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.spongycastle.util.io.Streams;

public class PBEFileProcessor {
    private static void decryptFile(String str, char[] cArr) throws IOException, NoSuchProviderException, PGPException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        decryptFile((InputStream) bufferedInputStream, cArr);
        bufferedInputStream.close();
    }

    private static void decryptFile(InputStream inputStream, char[] cArr) throws IOException, NoSuchProviderException, PGPException {
        PGPEncryptedDataList pGPEncryptedDataList;
        JcaPGPObjectFactory jcaPGPObjectFactory = new JcaPGPObjectFactory(PGPUtil.getDecoderStream(inputStream));
        Object nextObject = jcaPGPObjectFactory.nextObject();
        if (nextObject instanceof PGPEncryptedDataList) {
            pGPEncryptedDataList = (PGPEncryptedDataList) nextObject;
        } else {
            pGPEncryptedDataList = (PGPEncryptedDataList) jcaPGPObjectFactory.nextObject();
        }
        PGPPBEEncryptedData pGPPBEEncryptedData = (PGPPBEEncryptedData) pGPEncryptedDataList.get(0);
        Object nextObject2 = new JcaPGPObjectFactory(pGPPBEEncryptedData.getDataStream(new JcePBEDataDecryptorFactoryBuilder(new JcaPGPDigestCalculatorProviderBuilder().setProvider(BouncyCastleProvider.PROVIDER_NAME).build()).setProvider(BouncyCastleProvider.PROVIDER_NAME).build(cArr))).nextObject();
        if (nextObject2 instanceof PGPCompressedData) {
            nextObject2 = new JcaPGPObjectFactory(((PGPCompressedData) nextObject2).getDataStream()).nextObject();
        }
        PGPLiteralData pGPLiteralData = (PGPLiteralData) nextObject2;
        InputStream inputStream2 = pGPLiteralData.getInputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(pGPLiteralData.getFileName()));
        Streams.pipeAll(inputStream2, bufferedOutputStream);
        bufferedOutputStream.close();
        if (!pGPPBEEncryptedData.isIntegrityProtected()) {
            System.err.println("no message integrity check");
        } else if (!pGPPBEEncryptedData.verify()) {
            System.err.println("message failed integrity check");
        } else {
            System.err.println("message integrity check passed");
        }
    }

    private static void encryptFile(String str, String str2, char[] cArr, boolean z, boolean z2) throws IOException, NoSuchProviderException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        encryptFile((OutputStream) bufferedOutputStream, str2, cArr, z, z2);
        bufferedOutputStream.close();
    }

    private static void encryptFile(OutputStream outputStream, String str, char[] cArr, boolean z, boolean z2) throws IOException, NoSuchProviderException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        try {
            byte[] compressFile = PGPExampleUtil.compressFile(str, 1);
            PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(3).setWithIntegrityPacket(z2).setSecureRandom(new SecureRandom()).setProvider(BouncyCastleProvider.PROVIDER_NAME));
            pGPEncryptedDataGenerator.addMethod(new JcePBEKeyEncryptionMethodGenerator(cArr).setProvider(BouncyCastleProvider.PROVIDER_NAME));
            OutputStream open = pGPEncryptedDataGenerator.open(outputStream, (long) compressFile.length);
            open.write(compressFile);
            open.close();
            if (z) {
                outputStream.close();
            }
        } catch (PGPException e) {
            System.err.println(e);
            if (e.getUnderlyingException() != null) {
                e.getUnderlyingException().printStackTrace();
            }
        }
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        boolean z = false;
        if (strArr[0].equals("-e")) {
            if (strArr[1].equals("-a") || strArr[1].equals("-ai") || strArr[1].equals("-ia")) {
                String str = strArr[2] + ".asc";
                String str2 = strArr[2];
                char[] charArray = strArr[3].toCharArray();
                if (strArr[1].indexOf(105) > 0) {
                    z = true;
                }
                encryptFile(str, str2, charArray, true, z);
            } else if (strArr[1].equals("-i")) {
                encryptFile(strArr[2] + ".bpg", strArr[2], strArr[3].toCharArray(), false, true);
            } else {
                encryptFile(strArr[1] + ".bpg", strArr[1], strArr[2].toCharArray(), false, false);
            }
        } else if (strArr[0].equals("-d")) {
            decryptFile(strArr[1], strArr[2].toCharArray());
        } else {
            System.err.println("usage: PBEFileProcessor -e [-ai]|-d file passPhrase");
        }
    }
}
