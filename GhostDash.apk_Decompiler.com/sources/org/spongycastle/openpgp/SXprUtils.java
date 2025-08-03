package org.spongycastle.openpgp;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.bcpg.S2K;
import org.spongycastle.util.io.Streams;

class SXprUtils {
    SXprUtils() {
    }

    private static int readLength(InputStream inputStream, int i) throws IOException {
        int i2;
        while (true) {
            i2 = i - 48;
            int read = inputStream.read();
            if (read < 0 || read == 58) {
                return i2;
            }
            i = (i2 * 10) + read;
        }
        return i2;
    }

    static String readString(InputStream inputStream, int i) throws IOException {
        int readLength = readLength(inputStream, i);
        char[] cArr = new char[readLength];
        for (int i2 = 0; i2 != readLength; i2++) {
            cArr[i2] = (char) inputStream.read();
        }
        return new String(cArr);
    }

    static byte[] readBytes(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[readLength(inputStream, i)];
        Streams.readFully(inputStream, bArr);
        return bArr;
    }

    static S2K parseS2K(InputStream inputStream) throws IOException {
        skipOpenParenthesis(inputStream);
        readString(inputStream, inputStream.read());
        byte[] readBytes = readBytes(inputStream, inputStream.read());
        final long parseLong = Long.parseLong(readString(inputStream, inputStream.read()));
        skipCloseParenthesis(inputStream);
        return new S2K(2, readBytes, (int) parseLong) {
            public long getIterationCount() {
                return parseLong;
            }
        };
    }

    static void skipOpenParenthesis(InputStream inputStream) throws IOException {
        if (inputStream.read() != 40) {
            throw new IOException("unknown character encountered");
        }
    }

    static void skipCloseParenthesis(InputStream inputStream) throws IOException {
        if (inputStream.read() != 41) {
            throw new IOException("unknown character encountered");
        }
    }
}
