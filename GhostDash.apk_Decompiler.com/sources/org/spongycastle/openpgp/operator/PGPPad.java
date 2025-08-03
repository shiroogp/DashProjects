package org.spongycastle.openpgp.operator;

import org.spongycastle.openpgp.PGPException;

public class PGPPad {
    private PGPPad() {
    }

    public static byte[] padSessionData(byte[] bArr) {
        byte[] bArr2 = new byte[40];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        byte length = (byte) (40 - bArr.length);
        for (int length2 = bArr.length; length2 != 40; length2++) {
            bArr2[length2] = length;
        }
        return bArr2;
    }

    public static byte[] unpadSessionData(byte[] bArr) throws PGPException {
        byte b = bArr[bArr.length - 1];
        int length = bArr.length - b;
        while (length != bArr.length) {
            if (bArr[length] == b) {
                length++;
            } else {
                throw new PGPException("bad padding found in session data");
            }
        }
        int length2 = bArr.length - b;
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, length2);
        return bArr2;
    }
}
