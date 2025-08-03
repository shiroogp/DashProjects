package com.drew.metadata.iptc;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import kotlin.UByte;

public final class Iso2022Converter {
    private static final int DOT = 14844066;
    private static final byte ESC = 27;
    private static final String ISO_8859_1 = "ISO-8859-1";
    private static final byte LATIN_CAPITAL_A = 65;
    private static final byte LATIN_CAPITAL_G = 71;
    private static final byte PERCENT_SIGN = 37;
    private static final String UTF_8 = "UTF-8";

    public static String convertISO2022CharsetToJavaCharset(byte[] bArr) {
        if (bArr.length > 2 && bArr[0] == 27 && bArr[1] == 37 && bArr[2] == 71) {
            return "UTF-8";
        }
        if (bArr.length > 3 && bArr[0] == 27 && ((bArr[3] & UByte.MAX_VALUE) | ((bArr[2] & UByte.MAX_VALUE) << 8) | ((bArr[1] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH)) == DOT && bArr[4] == 65) {
            return "ISO-8859-1";
        }
        return null;
    }

    static Charset guessCharSet(byte[] bArr) {
        int i = 0;
        String[] strArr = {"UTF-8", System.getProperty("file.encoding"), "ISO-8859-1"};
        while (i < 3) {
            Charset forName = Charset.forName(strArr[i]);
            try {
                forName.newDecoder().decode(ByteBuffer.wrap(bArr));
                return forName;
            } catch (CharacterCodingException unused) {
                i++;
            }
        }
        return null;
    }

    private Iso2022Converter() {
    }
}
