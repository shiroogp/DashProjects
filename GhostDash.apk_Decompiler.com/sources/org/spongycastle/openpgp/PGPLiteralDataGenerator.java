package org.spongycastle.openpgp;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import org.spongycastle.bcpg.BCPGOutputStream;
import org.spongycastle.util.Strings;

public class PGPLiteralDataGenerator implements StreamGenerator {
    public static final char BINARY = 'b';
    public static final String CONSOLE = "_CONSOLE";
    public static final Date NOW = PGPLiteralData.NOW;
    public static final char TEXT = 't';
    public static final char UTF8 = 'u';
    private boolean oldFormat = false;
    private BCPGOutputStream pkOut;

    public PGPLiteralDataGenerator() {
    }

    public PGPLiteralDataGenerator(boolean z) {
        this.oldFormat = z;
    }

    private void writeHeader(OutputStream outputStream, char c, byte[] bArr, long j) throws IOException {
        outputStream.write(c);
        outputStream.write((byte) bArr.length);
        for (int i = 0; i != bArr.length; i++) {
            outputStream.write(bArr[i]);
        }
        long j2 = j / 1000;
        outputStream.write((byte) ((int) (j2 >> 24)));
        outputStream.write((byte) ((int) (j2 >> 16)));
        outputStream.write((byte) ((int) (j2 >> 8)));
        outputStream.write((byte) ((int) j2));
    }

    public OutputStream open(OutputStream outputStream, char c, String str, long j, Date date) throws IOException {
        if (this.pkOut == null) {
            byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
            BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream, 11, j + 2 + ((long) uTF8ByteArray.length) + 4, this.oldFormat);
            this.pkOut = bCPGOutputStream;
            writeHeader(bCPGOutputStream, c, uTF8ByteArray, date.getTime());
            return new WrappedGeneratorStream(this.pkOut, this);
        }
        throw new IllegalStateException("generator already in open state");
    }

    public OutputStream open(OutputStream outputStream, char c, String str, Date date, byte[] bArr) throws IOException {
        if (this.pkOut == null) {
            this.pkOut = new BCPGOutputStream(outputStream, 11, bArr);
            char c2 = c;
            writeHeader(this.pkOut, c2, Strings.toUTF8ByteArray(str), date.getTime());
            return new WrappedGeneratorStream(this.pkOut, this);
        }
        throw new IllegalStateException("generator already in open state");
    }

    public OutputStream open(OutputStream outputStream, char c, File file) throws IOException {
        return open(outputStream, c, file.getName(), file.length(), new Date(file.lastModified()));
    }

    public void close() throws IOException {
        BCPGOutputStream bCPGOutputStream = this.pkOut;
        if (bCPGOutputStream != null) {
            bCPGOutputStream.finish();
            this.pkOut.flush();
            this.pkOut = null;
        }
    }
}
