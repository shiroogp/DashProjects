package com.drew.lang;

import kotlin.UByte;
import org.spongycastle.bcpg.sig.RevocationReasonTags;

public class ByteUtil {
    public static int getInt16(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = (bArr[i] & UByte.MAX_VALUE) << 8;
            i3 = bArr[i + 1] & UByte.MAX_VALUE;
        } else {
            i2 = bArr[i] & UByte.MAX_VALUE;
            i3 = (bArr[i + 1] & UByte.MAX_VALUE) << 8;
        }
        return i3 | i2;
    }

    public static int getInt32(byte[] bArr, int i, boolean z) {
        byte b;
        int i2;
        if (z) {
            b = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
            i2 = bArr[i + 3] & UByte.MAX_VALUE;
        } else {
            b = (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH);
            i2 = (bArr[i + 3] & UByte.MAX_VALUE) << 24;
        }
        return i2 | b;
    }

    public static long getLong64(byte[] bArr, int i, boolean z) {
        byte b;
        int i2;
        if (z) {
            b = ((bArr[i] & UByte.MAX_VALUE) << 56) | ((bArr[i + 1] & UByte.MAX_VALUE) << 48) | ((bArr[i + 2] & UByte.MAX_VALUE) << 40) | ((bArr[i + 3] & UByte.MAX_VALUE) << RevocationReasonTags.USER_NO_LONGER_VALID) | ((bArr[i + 4] & UByte.MAX_VALUE) << 24) | ((bArr[i + 5] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH) | ((bArr[i + 6] & UByte.MAX_VALUE) << 8);
            i2 = bArr[i + 7] & UByte.MAX_VALUE;
        } else {
            b = (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH) | ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | ((bArr[i + 4] & UByte.MAX_VALUE) << RevocationReasonTags.USER_NO_LONGER_VALID) | ((bArr[i + 5] & UByte.MAX_VALUE) << 40) | ((bArr[i + 6] & UByte.MAX_VALUE) << 48);
            i2 = (bArr[i + 7] & UByte.MAX_VALUE) << 56;
        }
        return (long) (i2 | b);
    }
}
