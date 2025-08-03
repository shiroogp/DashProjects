package org.spongycastle.openpgp.operator;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.bcpg.HashAlgorithmTags;
import org.spongycastle.bcpg.S2K;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.util.Strings;

class PGPUtil implements HashAlgorithmTags {
    PGPUtil() {
    }

    static byte[] makeKeyFromPassPhrase(PGPDigestCalculator pGPDigestCalculator, int i, S2K s2k, char[] cArr) throws PGPException {
        int i2 = i;
        int i3 = 256;
        switch (i2) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 11:
                i3 = 128;
                break;
            case 2:
            case 8:
            case 12:
                i3 = 192;
                break;
            case 6:
                i3 = 64;
                break;
            case 9:
            case 10:
            case 13:
                break;
            default:
                throw new PGPException("unknown symmetric algorithm: " + i2);
        }
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(cArr);
        int i4 = (i3 + 7) / 8;
        byte[] bArr = new byte[i4];
        if (s2k != null) {
            if (s2k.getHashAlgorithm() != pGPDigestCalculator.getAlgorithm()) {
                throw new PGPException("s2k/digestCalculator mismatch");
            }
        } else if (pGPDigestCalculator.getAlgorithm() != 1) {
            throw new PGPException("digestCalculator not for MD5");
        }
        OutputStream outputStream = pGPDigestCalculator.getOutputStream();
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            if (s2k != null) {
                int i7 = 0;
                while (i7 != i6) {
                    try {
                        outputStream.write(0);
                        i7++;
                    } catch (IOException e) {
                        throw new PGPException("exception calculating digest: " + e.getMessage(), e);
                    }
                }
                byte[] iv = s2k.getIV();
                int type = s2k.getType();
                if (type == 0) {
                    outputStream.write(uTF8ByteArray);
                } else if (type == 1) {
                    outputStream.write(iv);
                    outputStream.write(uTF8ByteArray);
                } else if (type == 3) {
                    long iterationCount = s2k.getIterationCount();
                    outputStream.write(iv);
                    outputStream.write(uTF8ByteArray);
                    long length = iterationCount - ((long) (iv.length + uTF8ByteArray.length));
                    while (true) {
                        if (length > 0) {
                            if (length < ((long) iv.length)) {
                                outputStream.write(iv, 0, (int) length);
                            } else {
                                outputStream.write(iv);
                                long length2 = length - ((long) iv.length);
                                if (length2 < ((long) uTF8ByteArray.length)) {
                                    outputStream.write(uTF8ByteArray, 0, (int) length2);
                                    length = 0;
                                } else {
                                    outputStream.write(uTF8ByteArray);
                                    length = length2 - ((long) uTF8ByteArray.length);
                                }
                            }
                        }
                    }
                } else {
                    throw new PGPException("unknown S2K type: " + s2k.getType());
                }
            } else {
                for (int i8 = 0; i8 != i6; i8++) {
                    outputStream.write(0);
                }
                outputStream.write(uTF8ByteArray);
            }
            outputStream.close();
            byte[] digest = pGPDigestCalculator.getDigest();
            int i9 = i4 - i5;
            if (digest.length > i9) {
                System.arraycopy(digest, 0, bArr, i5, i9);
            } else {
                System.arraycopy(digest, 0, bArr, i5, digest.length);
            }
            i5 += digest.length;
            i6++;
        }
        for (int i10 = 0; i10 != uTF8ByteArray.length; i10++) {
            uTF8ByteArray[i10] = 0;
        }
        return bArr;
    }

    public static byte[] makeKeyFromPassPhrase(PGPDigestCalculatorProvider pGPDigestCalculatorProvider, int i, S2K s2k, char[] cArr) throws PGPException {
        PGPDigestCalculator pGPDigestCalculator;
        if (s2k != null) {
            pGPDigestCalculator = pGPDigestCalculatorProvider.get(s2k.getHashAlgorithm());
        } else {
            pGPDigestCalculator = pGPDigestCalculatorProvider.get(1);
        }
        return makeKeyFromPassPhrase(pGPDigestCalculator, i, s2k, cArr);
    }
}
