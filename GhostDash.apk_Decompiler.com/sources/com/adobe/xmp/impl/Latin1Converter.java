package com.adobe.xmp.impl;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import kotlin.UByte;
import org.spongycastle.bcpg.sig.RevocationReasonTags;

public class Latin1Converter {
    private static final int STATE_START = 0;
    private static final int STATE_UTF8CHAR = 11;

    private Latin1Converter() {
    }

    public static ByteBuffer convert(ByteBuffer byteBuffer) {
        if (!Key.STRING_CHARSET_NAME.equals(byteBuffer.getEncoding())) {
            return byteBuffer;
        }
        byte[] bArr = new byte[8];
        ByteBuffer byteBuffer2 = new ByteBuffer((byteBuffer.length() * 4) / 3);
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (i < byteBuffer.length()) {
            int charAt = byteBuffer.charAt(i);
            if (z) {
                if (i2 <= 0 || (charAt & 192) != 128) {
                    byteBuffer2.append(convertToUTF8(bArr[0]));
                    i -= i3;
                } else {
                    int i4 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    i2--;
                    if (i2 == 0) {
                        byteBuffer2.append(bArr, 0, i4);
                    } else {
                        i3 = i4;
                    }
                }
                z = false;
                i3 = 0;
            } else if (charAt < 127) {
                byteBuffer2.append((byte) charAt);
            } else if (charAt >= 192) {
                i2 = -1;
                int i5 = charAt;
                while (i2 < 8 && (i5 & 128) == 128) {
                    i2++;
                    i5 <<= 1;
                }
                bArr[i3] = (byte) charAt;
                i3++;
                z = true;
            } else {
                byteBuffer2.append(convertToUTF8((byte) charAt));
            }
            i++;
        }
        if (z) {
            for (int i6 = 0; i6 < i3; i6++) {
                byteBuffer2.append(convertToUTF8(bArr[i6]));
            }
        }
        return byteBuffer2;
    }

    private static byte[] convertToUTF8(byte b) {
        byte b2 = b & UByte.MAX_VALUE;
        if (b2 >= 128) {
            if (b2 == 129 || b2 == 141 || b2 == 143 || b2 == 144 || b2 == 157) {
                return new byte[]{RevocationReasonTags.USER_NO_LONGER_VALID};
            }
            try {
                return new String(new byte[]{b}, "cp1252").getBytes(Key.STRING_CHARSET_NAME);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new byte[]{b};
    }
}
