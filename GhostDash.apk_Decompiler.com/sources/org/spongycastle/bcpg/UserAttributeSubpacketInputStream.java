package org.spongycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class UserAttributeSubpacketInputStream extends InputStream implements UserAttributeSubpacketTags {
    InputStream in;

    public UserAttributeSubpacketInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public int read() throws IOException {
        return this.in.read();
    }

    private void readFully(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            int read = read();
            if (read >= 0) {
                bArr[i] = (byte) read;
                i++;
                i2--;
            } else {
                throw new EOFException();
            }
        }
        while (i2 > 0) {
            int read2 = this.in.read(bArr, i, i2);
            if (read2 >= 0) {
                i += read2;
                i2 -= read2;
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.bcpg.UserAttributeSubpacket readPacket() throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r6.read()
            if (r0 >= 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            r1 = 0
            r2 = 1
            r3 = 192(0xc0, float:2.69E-43)
            if (r0 >= r3) goto L_0x0010
        L_0x000e:
            r3 = r1
            goto L_0x0047
        L_0x0010:
            r4 = 223(0xdf, float:3.12E-43)
            if (r0 > r4) goto L_0x0021
            int r0 = r0 + -192
            int r0 = r0 << 8
            java.io.InputStream r4 = r6.in
            int r4 = r4.read()
            int r0 = r0 + r4
            int r0 = r0 + r3
            goto L_0x000e
        L_0x0021:
            r3 = 255(0xff, float:3.57E-43)
            if (r0 != r3) goto L_0x006b
            java.io.InputStream r0 = r6.in
            int r0 = r0.read()
            int r0 = r0 << 24
            java.io.InputStream r3 = r6.in
            int r3 = r3.read()
            int r3 = r3 << 16
            r0 = r0 | r3
            java.io.InputStream r3 = r6.in
            int r3 = r3.read()
            int r3 = r3 << 8
            r0 = r0 | r3
            java.io.InputStream r3 = r6.in
            int r3 = r3.read()
            r0 = r0 | r3
            r3 = r2
        L_0x0047:
            java.io.InputStream r4 = r6.in
            int r4 = r4.read()
            if (r4 < 0) goto L_0x0063
            int r0 = r0 - r2
            byte[] r5 = new byte[r0]
            r6.readFully(r5, r1, r0)
            if (r4 == r2) goto L_0x005d
            org.spongycastle.bcpg.UserAttributeSubpacket r0 = new org.spongycastle.bcpg.UserAttributeSubpacket
            r0.<init>(r4, r3, r5)
            return r0
        L_0x005d:
            org.spongycastle.bcpg.attr.ImageAttribute r0 = new org.spongycastle.bcpg.attr.ImageAttribute
            r0.<init>((boolean) r3, (byte[]) r5)
            return r0
        L_0x0063:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.String r1 = "unexpected EOF reading user attribute sub packet"
            r0.<init>(r1)
            throw r0
        L_0x006b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "unrecognised length reading user attribute sub packet"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.UserAttributeSubpacketInputStream.readPacket():org.spongycastle.bcpg.UserAttributeSubpacket");
    }
}
