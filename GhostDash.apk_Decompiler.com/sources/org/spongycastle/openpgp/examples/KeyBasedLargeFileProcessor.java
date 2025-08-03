package org.spongycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
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
import org.spongycastle.openpgp.PGPCompressedDataGenerator;
import org.spongycastle.openpgp.PGPEncryptedDataGenerator;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPublicKey;
import org.spongycastle.openpgp.PGPUtil;
import org.spongycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;

public class KeyBasedLargeFileProcessor {
    private static void decryptFile(String str, String str2, char[] cArr, String str3) throws IOException, NoSuchProviderException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str2));
        decryptFile((InputStream) bufferedInputStream, (InputStream) bufferedInputStream2, cArr, str3);
        bufferedInputStream2.close();
        bufferedInputStream.close();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: org.spongycastle.openpgp.PGPPublicKeyEncryptedData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decryptFile(java.io.InputStream r4, java.io.InputStream r5, char[] r6, java.lang.String r7) throws java.io.IOException, java.security.NoSuchProviderException {
        /*
            java.io.InputStream r4 = org.spongycastle.openpgp.PGPUtil.getDecoderStream(r4)
            org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory r0 = new org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory     // Catch:{ PGPException -> 0x00de }
            r0.<init>((java.io.InputStream) r4)     // Catch:{ PGPException -> 0x00de }
            java.lang.Object r4 = r0.nextObject()     // Catch:{ PGPException -> 0x00de }
            boolean r1 = r4 instanceof org.spongycastle.openpgp.PGPEncryptedDataList     // Catch:{ PGPException -> 0x00de }
            if (r1 == 0) goto L_0x0014
            org.spongycastle.openpgp.PGPEncryptedDataList r4 = (org.spongycastle.openpgp.PGPEncryptedDataList) r4     // Catch:{ PGPException -> 0x00de }
            goto L_0x001a
        L_0x0014:
            java.lang.Object r4 = r0.nextObject()     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.openpgp.PGPEncryptedDataList r4 = (org.spongycastle.openpgp.PGPEncryptedDataList) r4     // Catch:{ PGPException -> 0x00de }
        L_0x001a:
            java.util.Iterator r4 = r4.getEncryptedDataObjects()     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.openpgp.PGPSecretKeyRingCollection r0 = new org.spongycastle.openpgp.PGPSecretKeyRingCollection     // Catch:{ PGPException -> 0x00de }
            java.io.InputStream r5 = org.spongycastle.openpgp.PGPUtil.getDecoderStream(r5)     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator r1 = new org.spongycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator     // Catch:{ PGPException -> 0x00de }
            r1.<init>()     // Catch:{ PGPException -> 0x00de }
            r0.<init>((java.io.InputStream) r5, (org.spongycastle.openpgp.operator.KeyFingerPrintCalculator) r1)     // Catch:{ PGPException -> 0x00de }
            r5 = 0
            r1 = r5
        L_0x002e:
            if (r5 != 0) goto L_0x0046
            boolean r2 = r4.hasNext()     // Catch:{ PGPException -> 0x00de }
            if (r2 == 0) goto L_0x0046
            java.lang.Object r5 = r4.next()     // Catch:{ PGPException -> 0x00de }
            r1 = r5
            org.spongycastle.openpgp.PGPPublicKeyEncryptedData r1 = (org.spongycastle.openpgp.PGPPublicKeyEncryptedData) r1     // Catch:{ PGPException -> 0x00de }
            long r2 = r1.getKeyID()     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.openpgp.PGPPrivateKey r5 = org.spongycastle.openpgp.examples.PGPExampleUtil.findSecretKey(r0, r2, r6)     // Catch:{ PGPException -> 0x00de }
            goto L_0x002e
        L_0x0046:
            if (r5 == 0) goto L_0x00d6
            org.spongycastle.openpgp.operator.jcajce.JcePublicKeyDataDecryptorFactoryBuilder r4 = new org.spongycastle.openpgp.operator.jcajce.JcePublicKeyDataDecryptorFactoryBuilder     // Catch:{ PGPException -> 0x00de }
            r4.<init>()     // Catch:{ PGPException -> 0x00de }
            java.lang.String r6 = "SC"
            org.spongycastle.openpgp.operator.jcajce.JcePublicKeyDataDecryptorFactoryBuilder r4 = r4.setProvider((java.lang.String) r6)     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.openpgp.operator.PublicKeyDataDecryptorFactory r4 = r4.build((org.spongycastle.openpgp.PGPPrivateKey) r5)     // Catch:{ PGPException -> 0x00de }
            java.io.InputStream r4 = r1.getDataStream(r4)     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory r5 = new org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory     // Catch:{ PGPException -> 0x00de }
            r5.<init>((java.io.InputStream) r4)     // Catch:{ PGPException -> 0x00de }
            java.lang.Object r4 = r5.nextObject()     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.openpgp.PGPCompressedData r4 = (org.spongycastle.openpgp.PGPCompressedData) r4     // Catch:{ PGPException -> 0x00de }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ PGPException -> 0x00de }
            java.io.InputStream r4 = r4.getDataStream()     // Catch:{ PGPException -> 0x00de }
            r5.<init>(r4)     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory r4 = new org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory     // Catch:{ PGPException -> 0x00de }
            r4.<init>((java.io.InputStream) r5)     // Catch:{ PGPException -> 0x00de }
            java.lang.Object r4 = r4.nextObject()     // Catch:{ PGPException -> 0x00de }
            boolean r5 = r4 instanceof org.spongycastle.openpgp.PGPLiteralData     // Catch:{ PGPException -> 0x00de }
            if (r5 == 0) goto L_0x00c2
            org.spongycastle.openpgp.PGPLiteralData r4 = (org.spongycastle.openpgp.PGPLiteralData) r4     // Catch:{ PGPException -> 0x00de }
            java.lang.String r5 = r4.getFileName()     // Catch:{ PGPException -> 0x00de }
            int r6 = r5.length()     // Catch:{ PGPException -> 0x00de }
            if (r6 != 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r7 = r5
        L_0x008a:
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ PGPException -> 0x00de }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ PGPException -> 0x00de }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ PGPException -> 0x00de }
            r6.<init>(r7)     // Catch:{ PGPException -> 0x00de }
            r5.<init>(r6)     // Catch:{ PGPException -> 0x00de }
            org.spongycastle.util.io.Streams.pipeAll(r4, r5)     // Catch:{ PGPException -> 0x00de }
            r5.close()     // Catch:{ PGPException -> 0x00de }
            boolean r4 = r1.isIntegrityProtected()     // Catch:{ PGPException -> 0x00de }
            if (r4 == 0) goto L_0x00ba
            boolean r4 = r1.verify()     // Catch:{ PGPException -> 0x00de }
            if (r4 != 0) goto L_0x00b2
            java.io.PrintStream r4 = java.lang.System.err     // Catch:{ PGPException -> 0x00de }
            java.lang.String r5 = "message failed integrity check"
            r4.println(r5)     // Catch:{ PGPException -> 0x00de }
            goto L_0x00f1
        L_0x00b2:
            java.io.PrintStream r4 = java.lang.System.err     // Catch:{ PGPException -> 0x00de }
            java.lang.String r5 = "message integrity check passed"
            r4.println(r5)     // Catch:{ PGPException -> 0x00de }
            goto L_0x00f1
        L_0x00ba:
            java.io.PrintStream r4 = java.lang.System.err     // Catch:{ PGPException -> 0x00de }
            java.lang.String r5 = "no message integrity check"
            r4.println(r5)     // Catch:{ PGPException -> 0x00de }
            goto L_0x00f1
        L_0x00c2:
            boolean r4 = r4 instanceof org.spongycastle.openpgp.PGPOnePassSignatureList     // Catch:{ PGPException -> 0x00de }
            if (r4 == 0) goto L_0x00ce
            org.spongycastle.openpgp.PGPException r4 = new org.spongycastle.openpgp.PGPException     // Catch:{ PGPException -> 0x00de }
            java.lang.String r5 = "encrypted message contains a signed message - not literal data."
            r4.<init>(r5)     // Catch:{ PGPException -> 0x00de }
            throw r4     // Catch:{ PGPException -> 0x00de }
        L_0x00ce:
            org.spongycastle.openpgp.PGPException r4 = new org.spongycastle.openpgp.PGPException     // Catch:{ PGPException -> 0x00de }
            java.lang.String r5 = "message is not a simple encrypted file - type unknown."
            r4.<init>(r5)     // Catch:{ PGPException -> 0x00de }
            throw r4     // Catch:{ PGPException -> 0x00de }
        L_0x00d6:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ PGPException -> 0x00de }
            java.lang.String r5 = "secret key for message not found."
            r4.<init>(r5)     // Catch:{ PGPException -> 0x00de }
            throw r4     // Catch:{ PGPException -> 0x00de }
        L_0x00de:
            r4 = move-exception
            java.io.PrintStream r5 = java.lang.System.err
            r5.println(r4)
            java.lang.Exception r5 = r4.getUnderlyingException()
            if (r5 == 0) goto L_0x00f1
            java.lang.Exception r4 = r4.getUnderlyingException()
            r4.printStackTrace()
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.openpgp.examples.KeyBasedLargeFileProcessor.decryptFile(java.io.InputStream, java.io.InputStream, char[], java.lang.String):void");
    }

    private static void encryptFile(String str, String str2, String str3, boolean z, boolean z2) throws IOException, NoSuchProviderException, PGPException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        encryptFile((OutputStream) bufferedOutputStream, str2, PGPExampleUtil.readPublicKey(str3), z, z2);
        bufferedOutputStream.close();
    }

    private static void encryptFile(OutputStream outputStream, String str, PGPPublicKey pGPPublicKey, boolean z, boolean z2) throws IOException, NoSuchProviderException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        try {
            PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(3).setWithIntegrityPacket(z2).setSecureRandom(new SecureRandom()).setProvider(BouncyCastleProvider.PROVIDER_NAME));
            pGPEncryptedDataGenerator.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(pGPPublicKey).setProvider(BouncyCastleProvider.PROVIDER_NAME));
            OutputStream open = pGPEncryptedDataGenerator.open(outputStream, new byte[65536]);
            PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(1);
            PGPUtil.writeFileToLiteralData(pGPCompressedDataGenerator.open(open), 'b', new File(str), new byte[65536]);
            pGPCompressedDataGenerator.close();
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
        if (strArr.length == 0) {
            System.err.println("usage: KeyBasedLargeFileProcessor -e|-d [-a|ai] file [secretKeyFile passPhrase|pubKeyFile]");
            return;
        }
        boolean z = false;
        if (strArr[0].equals("-e")) {
            if (strArr[1].equals("-a") || strArr[1].equals("-ai") || strArr[1].equals("-ia")) {
                String str = strArr[2] + ".asc";
                String str2 = strArr[2];
                String str3 = strArr[3];
                if (strArr[1].indexOf(105) > 0) {
                    z = true;
                }
                encryptFile(str, str2, str3, true, z);
            } else if (strArr[1].equals("-i")) {
                encryptFile(strArr[2] + ".bpg", strArr[2], strArr[3], false, true);
            } else {
                encryptFile(strArr[1] + ".bpg", strArr[1], strArr[2], false, false);
            }
        } else if (strArr[0].equals("-d")) {
            decryptFile(strArr[1], strArr[2], strArr[3].toCharArray(), new File(strArr[1]).getName() + ".out");
        } else {
            System.err.println("usage: KeyBasedLargeFileProcessor -d|-e [-a|ai] file [secretKeyFile passPhrase|pubKeyFile]");
        }
    }
}
