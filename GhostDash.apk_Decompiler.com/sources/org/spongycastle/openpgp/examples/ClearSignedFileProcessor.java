package org.spongycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import java.util.Iterator;
import org.spongycastle.bcpg.ArmoredInputStream;
import org.spongycastle.bcpg.ArmoredOutputStream;
import org.spongycastle.bcpg.BCPGOutputStream;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPPrivateKey;
import org.spongycastle.openpgp.PGPPublicKeyRingCollection;
import org.spongycastle.openpgp.PGPSecretKey;
import org.spongycastle.openpgp.PGPSignature;
import org.spongycastle.openpgp.PGPSignatureGenerator;
import org.spongycastle.openpgp.PGPSignatureList;
import org.spongycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.spongycastle.openpgp.PGPUtil;
import org.spongycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;
import org.spongycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;
import org.spongycastle.util.Strings;

public class ClearSignedFileProcessor {
    private static boolean isLineEnding(byte b) {
        return b == 13 || b == 10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0009  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int readInputLine(java.io.ByteArrayOutputStream r2, java.io.InputStream r3) throws java.io.IOException {
        /*
            r2.reset()
        L_0x0003:
            int r0 = r3.read()
            if (r0 < 0) goto L_0x0019
            r2.write(r0)
            r1 = 13
            if (r0 == r1) goto L_0x0014
            r1 = 10
            if (r0 != r1) goto L_0x0003
        L_0x0014:
            int r2 = readPassedEOL(r2, r0, r3)
            goto L_0x001a
        L_0x0019:
            r2 = -1
        L_0x001a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.openpgp.examples.ClearSignedFileProcessor.readInputLine(java.io.ByteArrayOutputStream, java.io.InputStream):int");
    }

    private static int readInputLine(ByteArrayOutputStream byteArrayOutputStream, int i, InputStream inputStream) throws IOException {
        byteArrayOutputStream.reset();
        int i2 = i;
        while (true) {
            byteArrayOutputStream.write(i2);
            if (i2 != 13 && i2 != 10) {
                i2 = inputStream.read();
                if (i2 < 0) {
                    break;
                }
            } else {
                i = readPassedEOL(byteArrayOutputStream, i2, inputStream);
            }
        }
        i = readPassedEOL(byteArrayOutputStream, i2, inputStream);
        if (i2 < 0) {
            return -1;
        }
        return i;
    }

    private static int readPassedEOL(ByteArrayOutputStream byteArrayOutputStream, int i, InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (i != 13 || read != 10) {
            return read;
        }
        byteArrayOutputStream.write(read);
        return inputStream.read();
    }

    private static void verifyFile(InputStream inputStream, InputStream inputStream2, String str) throws Exception {
        ArmoredInputStream armoredInputStream = new ArmoredInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int readInputLine = readInputLine(byteArrayOutputStream, armoredInputStream);
        byte[] lineSeparator = getLineSeparator();
        if (readInputLine != -1 && armoredInputStream.isClearText()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedOutputStream.write(byteArray, 0, getLengthWithoutSeparatorOrTrailingWhitespace(byteArray));
            bufferedOutputStream.write(lineSeparator);
            while (readInputLine != -1 && armoredInputStream.isClearText()) {
                readInputLine = readInputLine(byteArrayOutputStream, readInputLine, armoredInputStream);
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                bufferedOutputStream.write(byteArray2, 0, getLengthWithoutSeparatorOrTrailingWhitespace(byteArray2));
                bufferedOutputStream.write(lineSeparator);
            }
        } else if (readInputLine != -1) {
            byte[] byteArray3 = byteArrayOutputStream.toByteArray();
            bufferedOutputStream.write(byteArray3, 0, getLengthWithoutSeparatorOrTrailingWhitespace(byteArray3));
            bufferedOutputStream.write(lineSeparator);
        }
        bufferedOutputStream.close();
        PGPPublicKeyRingCollection pGPPublicKeyRingCollection = new PGPPublicKeyRingCollection(inputStream2, (KeyFingerPrintCalculator) new JcaKeyFingerprintCalculator());
        PGPSignature pGPSignature = ((PGPSignatureList) new JcaPGPObjectFactory((InputStream) armoredInputStream).nextObject()).get(0);
        pGPSignature.init(new JcaPGPContentVerifierBuilderProvider().setProvider(BouncyCastleProvider.PROVIDER_NAME), pGPPublicKeyRingCollection.getPublicKey(pGPSignature.getKeyID()));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        int readInputLine2 = readInputLine(byteArrayOutputStream, bufferedInputStream);
        processLine(pGPSignature, byteArrayOutputStream.toByteArray());
        if (readInputLine2 != -1) {
            do {
                readInputLine2 = readInputLine(byteArrayOutputStream, readInputLine2, bufferedInputStream);
                pGPSignature.update((byte) 13);
                pGPSignature.update((byte) 10);
                processLine(pGPSignature, byteArrayOutputStream.toByteArray());
            } while (readInputLine2 != -1);
        }
        bufferedInputStream.close();
        if (pGPSignature.verify()) {
            System.out.println("signature verified.");
        } else {
            System.out.println("signature verification failed.");
        }
    }

    private static byte[] getLineSeparator() {
        String lineSeparator = Strings.lineSeparator();
        int length = lineSeparator.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) lineSeparator.charAt(i);
        }
        return bArr;
    }

    private static void signFile(String str, InputStream inputStream, OutputStream outputStream, char[] cArr, String str2) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, PGPException, SignatureException {
        int i;
        if (str2.equals(McElieceCCA2ParameterSpec.DEFAULT_MD)) {
            i = 8;
        } else if (str2.equals("SHA384")) {
            i = 9;
        } else if (str2.equals("SHA512")) {
            i = 10;
        } else if (str2.equals("MD5")) {
            i = 1;
        } else {
            i = str2.equals("RIPEMD160") ? 3 : 2;
        }
        PGPSecretKey readSecretKey = PGPExampleUtil.readSecretKey(inputStream);
        PGPPrivateKey extractPrivateKey = readSecretKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider(BouncyCastleProvider.PROVIDER_NAME).build(cArr));
        PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(new JcaPGPContentSignerBuilder(readSecretKey.getPublicKey().getAlgorithm(), i).setProvider(BouncyCastleProvider.PROVIDER_NAME));
        PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator = new PGPSignatureSubpacketGenerator();
        pGPSignatureGenerator.init(1, extractPrivateKey);
        Iterator userIDs = readSecretKey.getPublicKey().getUserIDs();
        if (userIDs.hasNext()) {
            pGPSignatureSubpacketGenerator.setSignerUserID(false, (String) userIDs.next());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketGenerator.generate());
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        ArmoredOutputStream armoredOutputStream = new ArmoredOutputStream(outputStream);
        armoredOutputStream.beginClearText(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int readInputLine = readInputLine(byteArrayOutputStream, bufferedInputStream);
        processLine(armoredOutputStream, pGPSignatureGenerator, byteArrayOutputStream.toByteArray());
        if (readInputLine != -1) {
            do {
                readInputLine = readInputLine(byteArrayOutputStream, readInputLine, bufferedInputStream);
                pGPSignatureGenerator.update((byte) 13);
                pGPSignatureGenerator.update((byte) 10);
                processLine(armoredOutputStream, pGPSignatureGenerator, byteArrayOutputStream.toByteArray());
            } while (readInputLine != -1);
        }
        bufferedInputStream.close();
        armoredOutputStream.endClearText();
        pGPSignatureGenerator.generate().encode(new BCPGOutputStream(armoredOutputStream));
        armoredOutputStream.close();
    }

    private static void processLine(PGPSignature pGPSignature, byte[] bArr) throws SignatureException, IOException {
        int lengthWithoutWhiteSpace = getLengthWithoutWhiteSpace(bArr);
        if (lengthWithoutWhiteSpace > 0) {
            pGPSignature.update(bArr, 0, lengthWithoutWhiteSpace);
        }
    }

    private static void processLine(OutputStream outputStream, PGPSignatureGenerator pGPSignatureGenerator, byte[] bArr) throws SignatureException, IOException {
        int lengthWithoutWhiteSpace = getLengthWithoutWhiteSpace(bArr);
        if (lengthWithoutWhiteSpace > 0) {
            pGPSignatureGenerator.update(bArr, 0, lengthWithoutWhiteSpace);
        }
        outputStream.write(bArr, 0, bArr.length);
    }

    private static int getLengthWithoutSeparatorOrTrailingWhitespace(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && isWhiteSpace(bArr[length])) {
            length--;
        }
        return length + 1;
    }

    private static int getLengthWithoutWhiteSpace(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && isWhiteSpace(bArr[length])) {
            length--;
        }
        return length + 1;
    }

    private static boolean isWhiteSpace(byte b) {
        return isLineEnding(b) || b == 9 || b == 32;
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (strArr[0].equals("-s")) {
            InputStream decoderStream = PGPUtil.getDecoderStream(new FileInputStream(strArr[2]));
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[1] + ".asc");
            if (strArr.length == 4) {
                signFile(strArr[1], decoderStream, fileOutputStream, strArr[3].toCharArray(), "SHA1");
            } else {
                signFile(strArr[1], decoderStream, fileOutputStream, strArr[3].toCharArray(), strArr[4]);
            }
        } else if (strArr[0].equals("-v")) {
            if (strArr[1].indexOf(".asc") < 0) {
                System.err.println("file needs to end in \".asc\"");
                System.exit(1);
            }
            verifyFile(new FileInputStream(strArr[1]), PGPUtil.getDecoderStream(new FileInputStream(strArr[2])), strArr[1].substring(0, strArr[1].length() - 4));
        } else {
            System.err.println("usage: ClearSignedFileProcessor [-s file keyfile passPhrase]|[-v sigFile keyFile]");
        }
    }
}
