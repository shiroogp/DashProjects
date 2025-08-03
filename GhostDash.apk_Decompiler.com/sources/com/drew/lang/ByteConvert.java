package com.drew.lang;

import kotlin.UByte;

public class ByteConvert {
    public static int toInt32BigEndian(byte[] bArr) {
        return (bArr[3] & UByte.MAX_VALUE) | ((bArr[0] << 24) & -16777216) | ((bArr[1] << Tnaf.POW_2_WIDTH) & 16711680) | ((bArr[2] << 8) & 65280);
    }

    public static int toInt32LittleEndian(byte[] bArr) {
        return ((bArr[3] << 24) & -16777216) | (bArr[0] & UByte.MAX_VALUE) | ((bArr[1] << 8) & 65280) | ((bArr[2] << Tnaf.POW_2_WIDTH) & 16711680);
    }
}
