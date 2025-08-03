package org.spongycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import org.spongycastle.util.StringList;
import org.spongycastle.util.Strings;

public class ArmoredInputStream extends InputStream {
    private static final byte[] decodingTable = new byte[128];
    int bufPtr;
    boolean clearText;
    CRC24 crc;
    boolean crcFound;
    boolean hasHeaders;
    String header;
    StringList headerList;
    InputStream in;
    boolean isEndOfStream;
    int lastC;
    boolean newLineFound;
    int[] outBuf;
    boolean restart;
    boolean start;

    static {
        for (int i = 65; i <= 90; i++) {
            decodingTable[i] = (byte) (i - 65);
        }
        for (int i2 = 97; i2 <= 122; i2++) {
            decodingTable[i2] = (byte) ((i2 - 97) + 26);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            decodingTable[i3] = (byte) ((i3 - 48) + 52);
        }
        byte[] bArr = decodingTable;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    private int decode(int i, int i2, int i3, int i4, int[] iArr) throws EOFException {
        if (i4 < 0) {
            throw new EOFException("unexpected end of file in armored stream.");
        } else if (i3 == 61) {
            byte[] bArr = decodingTable;
            iArr[2] = (((bArr[i] & UByte.MAX_VALUE) << 2) | ((bArr[i2] & UByte.MAX_VALUE) >> 4)) & 255;
            return 2;
        } else if (i4 == 61) {
            byte[] bArr2 = decodingTable;
            byte b = bArr2[i];
            byte b2 = bArr2[i2];
            byte b3 = bArr2[i3];
            iArr[1] = ((b << 2) | (b2 >> 4)) & 255;
            iArr[2] = ((b2 << 4) | (b3 >> 2)) & 255;
            return 1;
        } else {
            byte[] bArr3 = decodingTable;
            byte b4 = bArr3[i];
            byte b5 = bArr3[i2];
            byte b6 = bArr3[i3];
            byte b7 = bArr3[i4];
            iArr[0] = ((b4 << 2) | (b5 >> 4)) & 255;
            iArr[1] = ((b5 << 4) | (b6 >> 2)) & 255;
            iArr[2] = ((b6 << 6) | b7) & UByte.MAX_VALUE;
            return 0;
        }
    }

    public ArmoredInputStream(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public ArmoredInputStream(InputStream inputStream, boolean z) throws IOException {
        this.start = true;
        this.outBuf = new int[3];
        this.bufPtr = 3;
        this.crc = new CRC24();
        this.crcFound = false;
        this.hasHeaders = true;
        this.header = null;
        this.newLineFound = false;
        this.clearText = false;
        this.restart = false;
        this.headerList = Strings.newList();
        this.lastC = 0;
        this.in = inputStream;
        this.hasHeaders = z;
        if (z) {
            parseHeaders();
        }
        this.start = false;
    }

    public int available() throws IOException {
        return this.in.available();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean parseHeaders() throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            r12.header = r0
            org.spongycastle.util.StringList r0 = org.spongycastle.util.Strings.newList()
            r12.headerList = r0
            boolean r0 = r12.restart
            r1 = 45
            r2 = 1
            r3 = 10
            r4 = 0
            r5 = 13
            if (r0 == 0) goto L_0x0018
            r6 = r2
            r0 = r4
            goto L_0x002e
        L_0x0018:
            r0 = r4
        L_0x0019:
            java.io.InputStream r6 = r12.in
            int r6 = r6.read()
            if (r6 < 0) goto L_0x002d
            if (r6 != r1) goto L_0x002b
            if (r0 == 0) goto L_0x0029
            if (r0 == r3) goto L_0x0029
            if (r0 != r5) goto L_0x002b
        L_0x0029:
            r6 = r2
            goto L_0x002e
        L_0x002b:
            r0 = r6
            goto L_0x0019
        L_0x002d:
            r6 = r4
        L_0x002e:
            if (r6 == 0) goto L_0x0090
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            java.lang.String r8 = "-"
            r7.<init>(r8)
            boolean r8 = r12.restart
            if (r8 == 0) goto L_0x003e
            r7.append(r1)
        L_0x003e:
            r1 = r4
            r8 = r1
        L_0x0040:
            java.io.InputStream r9 = r12.in
            int r9 = r9.read()
            if (r9 < 0) goto L_0x0089
            if (r0 != r5) goto L_0x004d
            if (r9 != r3) goto L_0x004d
            r8 = r2
        L_0x004d:
            if (r1 == 0) goto L_0x0054
            if (r0 == r5) goto L_0x0054
            if (r9 != r3) goto L_0x0054
            goto L_0x0089
        L_0x0054:
            if (r1 == 0) goto L_0x0059
            if (r9 != r5) goto L_0x0059
            goto L_0x0089
        L_0x0059:
            if (r9 == r5) goto L_0x005f
            if (r0 == r5) goto L_0x0076
            if (r9 != r3) goto L_0x0076
        L_0x005f:
            java.lang.String r10 = r7.toString()
            java.lang.String r11 = r10.trim()
            int r11 = r11.length()
            if (r11 != 0) goto L_0x006e
            goto L_0x0089
        L_0x006e:
            org.spongycastle.util.StringList r11 = r12.headerList
            r11.add(r10)
            r7.setLength(r4)
        L_0x0076:
            if (r9 == r3) goto L_0x0080
            if (r9 == r5) goto L_0x0080
            char r0 = (char) r9
            r7.append(r0)
            r1 = r4
            goto L_0x0087
        L_0x0080:
            if (r9 == r5) goto L_0x0086
            if (r0 == r5) goto L_0x0087
            if (r9 != r3) goto L_0x0087
        L_0x0086:
            r1 = r2
        L_0x0087:
            r0 = r9
            goto L_0x0040
        L_0x0089:
            if (r8 == 0) goto L_0x0090
            java.io.InputStream r0 = r12.in
            r0.read()
        L_0x0090:
            org.spongycastle.util.StringList r0 = r12.headerList
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00a0
            org.spongycastle.util.StringList r0 = r12.headerList
            java.lang.String r0 = r0.get(r4)
            r12.header = r0
        L_0x00a0:
            java.lang.String r0 = r12.header
            java.lang.String r1 = "-----BEGIN PGP SIGNED MESSAGE-----"
            boolean r0 = r1.equals(r0)
            r12.clearText = r0
            r12.newLineFound = r2
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.ArmoredInputStream.parseHeaders():boolean");
    }

    public boolean isClearText() {
        return this.clearText;
    }

    public boolean isEndOfStream() {
        return this.isEndOfStream;
    }

    public String getArmorHeaderLine() {
        return this.header;
    }

    public String[] getArmorHeaders() {
        if (this.headerList.size() <= 1) {
            return null;
        }
        StringList stringList = this.headerList;
        return stringList.toStringArray(1, stringList.size());
    }

    private int readIgnoreSpace() throws IOException {
        int read = this.in.read();
        while (true) {
            if (read != 32 && read != 9) {
                return read;
            }
            read = this.in.read();
        }
    }

    public int read() throws IOException {
        int read;
        if (this.start) {
            if (this.hasHeaders) {
                parseHeaders();
            }
            this.crc.reset();
            this.start = false;
        }
        if (this.clearText) {
            int read2 = this.in.read();
            if (read2 == 13 || (read2 == 10 && this.lastC != 13)) {
                this.newLineFound = true;
            } else if (this.newLineFound && read2 == 45) {
                read2 = this.in.read();
                if (read2 == 45) {
                    this.clearText = false;
                    this.start = true;
                    this.restart = true;
                } else {
                    read2 = this.in.read();
                }
                this.newLineFound = false;
            } else if (!(read2 == 10 || this.lastC == 13)) {
                this.newLineFound = false;
            }
            this.lastC = read2;
            if (read2 < 0) {
                this.isEndOfStream = true;
            }
            return read2;
        }
        if (this.bufPtr > 2 || this.crcFound) {
            int readIgnoreSpace = readIgnoreSpace();
            if (readIgnoreSpace == 13 || readIgnoreSpace == 10) {
                int readIgnoreSpace2 = readIgnoreSpace();
                while (true) {
                    if (readIgnoreSpace2 != 10 && readIgnoreSpace2 != 13) {
                        break;
                    }
                    readIgnoreSpace2 = readIgnoreSpace();
                }
                if (readIgnoreSpace2 < 0) {
                    this.isEndOfStream = true;
                    return -1;
                } else if (readIgnoreSpace2 == 61) {
                    int decode = decode(readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
                    this.bufPtr = decode;
                    if (decode == 0) {
                        int[] iArr = this.outBuf;
                        int i = (iArr[2] & 255) | ((iArr[0] & 255) << 16) | ((iArr[1] & 255) << 8);
                        this.crcFound = true;
                        if (i == this.crc.getValue()) {
                            return read();
                        }
                        throw new IOException("crc check failed in armored message.");
                    }
                    throw new IOException("no crc found in armored message.");
                } else if (readIgnoreSpace2 == 45) {
                    do {
                        read = this.in.read();
                        if (read < 0 || read == 10) {
                        }
                    } while (read != 13);
                    if (this.crcFound) {
                        this.crcFound = false;
                        this.start = true;
                        this.bufPtr = 3;
                        if (read < 0) {
                            this.isEndOfStream = true;
                        }
                        return -1;
                    }
                    throw new IOException("crc check not found.");
                } else {
                    this.bufPtr = decode(readIgnoreSpace2, readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
                }
            } else if (readIgnoreSpace >= 0) {
                this.bufPtr = decode(readIgnoreSpace, readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
            } else {
                this.isEndOfStream = true;
                return -1;
            }
        }
        int[] iArr2 = this.outBuf;
        int i2 = this.bufPtr;
        this.bufPtr = i2 + 1;
        int i3 = iArr2[i2];
        this.crc.update(i3);
        return i3;
    }

    public void close() throws IOException {
        this.in.close();
    }
}
