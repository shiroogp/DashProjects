package org.spongycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class BCPGInputStream extends InputStream implements PacketTags {
    InputStream in;
    boolean next = false;
    int nextB;

    public BCPGInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public int read() throws IOException {
        if (!this.next) {
            return this.in.read();
        }
        this.next = false;
        return this.nextB;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (!this.next) {
            return this.in.read(bArr, i, i2);
        }
        int i3 = this.nextB;
        if (i3 < 0) {
            return -1;
        }
        bArr[i] = (byte) i3;
        this.next = false;
        return 1;
    }

    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        if (Streams.readFully(this, bArr, i, i2) < i2) {
            throw new EOFException();
        }
    }

    public byte[] readAll() throws IOException {
        return Streams.readAll(this);
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    public int nextPacketTag() throws IOException {
        if (!this.next) {
            try {
                this.nextB = this.in.read();
            } catch (EOFException unused) {
                this.nextB = -1;
            }
            this.next = true;
        }
        int i = this.nextB;
        if (i < 0) {
            return i;
        }
        int i2 = i & 63;
        return (i & 64) == 0 ? i2 >> 2 : i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.bcpg.Packet readPacket() throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r6.read()
            if (r0 >= 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0145
            r1 = r0 & 64
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0014
            r1 = r3
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            if (r1 == 0) goto L_0x005e
            r0 = r0 & 63
            int r1 = r6.read()
            r4 = 192(0xc0, float:2.69E-43)
            if (r1 >= r4) goto L_0x0023
            goto L_0x009f
        L_0x0023:
            r5 = 223(0xdf, float:3.12E-43)
            if (r1 > r5) goto L_0x0034
            java.io.InputStream r3 = r6.in
            int r3 = r3.read()
            int r1 = r1 + -192
            int r1 = r1 << 8
            int r1 = r1 + r3
            int r1 = r1 + r4
            goto L_0x009f
        L_0x0034:
            r4 = 255(0xff, float:3.57E-43)
            if (r1 != r4) goto L_0x0059
            java.io.InputStream r1 = r6.in
            int r1 = r1.read()
            int r1 = r1 << 24
            java.io.InputStream r3 = r6.in
            int r3 = r3.read()
            int r3 = r3 << 16
            r1 = r1 | r3
            java.io.InputStream r3 = r6.in
            int r3 = r3.read()
            int r3 = r3 << 8
            r1 = r1 | r3
            java.io.InputStream r3 = r6.in
            int r3 = r3.read()
            goto L_0x0099
        L_0x0059:
            r1 = r1 & 31
            int r1 = r3 << r1
            goto L_0x00a0
        L_0x005e:
            r1 = r0 & 3
            r0 = r0 & 63
            r4 = 2
            int r0 = r0 >> r4
            if (r1 == 0) goto L_0x009b
            if (r1 == r3) goto L_0x008f
            if (r1 == r4) goto L_0x0076
            r4 = 3
            if (r1 != r4) goto L_0x006e
            goto L_0x00a1
        L_0x006e:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "unknown length type encountered"
            r0.<init>(r1)
            throw r0
        L_0x0076:
            int r1 = r6.read()
            int r1 = r1 << 24
            int r3 = r6.read()
            int r3 = r3 << 16
            r1 = r1 | r3
            int r3 = r6.read()
            int r3 = r3 << 8
            r1 = r1 | r3
            int r3 = r6.read()
            goto L_0x0099
        L_0x008f:
            int r1 = r6.read()
            int r1 = r1 << 8
            int r3 = r6.read()
        L_0x0099:
            r1 = r1 | r3
            goto L_0x009f
        L_0x009b:
            int r1 = r6.read()
        L_0x009f:
            r3 = r2
        L_0x00a0:
            r2 = r1
        L_0x00a1:
            if (r2 != 0) goto L_0x00a7
            if (r3 == 0) goto L_0x00a7
            r1 = r6
            goto L_0x00b1
        L_0x00a7:
            org.spongycastle.bcpg.BCPGInputStream r1 = new org.spongycastle.bcpg.BCPGInputStream
            org.spongycastle.bcpg.BCPGInputStream$PartialInputStream r4 = new org.spongycastle.bcpg.BCPGInputStream$PartialInputStream
            r4.<init>(r6, r3, r2)
            r1.<init>(r4)
        L_0x00b1:
            switch(r0) {
                case 0: goto L_0x013f;
                case 1: goto L_0x0139;
                case 2: goto L_0x0133;
                case 3: goto L_0x012d;
                case 4: goto L_0x0127;
                case 5: goto L_0x0121;
                case 6: goto L_0x011b;
                case 7: goto L_0x0115;
                case 8: goto L_0x010f;
                case 9: goto L_0x0109;
                case 10: goto L_0x0103;
                case 11: goto L_0x00fd;
                case 12: goto L_0x00f7;
                case 13: goto L_0x00f1;
                case 14: goto L_0x00eb;
                default: goto L_0x00b4;
            }
        L_0x00b4:
            switch(r0) {
                case 17: goto L_0x00e5;
                case 18: goto L_0x00df;
                case 19: goto L_0x00d9;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            switch(r0) {
                case 60: goto L_0x00d3;
                case 61: goto L_0x00d3;
                case 62: goto L_0x00d3;
                case 63: goto L_0x00d3;
                default: goto L_0x00ba;
            }
        L_0x00ba:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "unknown packet type encountered: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x00d3:
            org.spongycastle.bcpg.ExperimentalPacket r2 = new org.spongycastle.bcpg.ExperimentalPacket
            r2.<init>(r0, r1)
            return r2
        L_0x00d9:
            org.spongycastle.bcpg.ModDetectionCodePacket r0 = new org.spongycastle.bcpg.ModDetectionCodePacket
            r0.<init>((org.spongycastle.bcpg.BCPGInputStream) r1)
            return r0
        L_0x00df:
            org.spongycastle.bcpg.SymmetricEncIntegrityPacket r0 = new org.spongycastle.bcpg.SymmetricEncIntegrityPacket
            r0.<init>(r1)
            return r0
        L_0x00e5:
            org.spongycastle.bcpg.UserAttributePacket r0 = new org.spongycastle.bcpg.UserAttributePacket
            r0.<init>((org.spongycastle.bcpg.BCPGInputStream) r1)
            return r0
        L_0x00eb:
            org.spongycastle.bcpg.PublicSubkeyPacket r0 = new org.spongycastle.bcpg.PublicSubkeyPacket
            r0.<init>(r1)
            return r0
        L_0x00f1:
            org.spongycastle.bcpg.UserIDPacket r0 = new org.spongycastle.bcpg.UserIDPacket
            r0.<init>((org.spongycastle.bcpg.BCPGInputStream) r1)
            return r0
        L_0x00f7:
            org.spongycastle.bcpg.TrustPacket r0 = new org.spongycastle.bcpg.TrustPacket
            r0.<init>((org.spongycastle.bcpg.BCPGInputStream) r1)
            return r0
        L_0x00fd:
            org.spongycastle.bcpg.LiteralDataPacket r0 = new org.spongycastle.bcpg.LiteralDataPacket
            r0.<init>(r1)
            return r0
        L_0x0103:
            org.spongycastle.bcpg.MarkerPacket r0 = new org.spongycastle.bcpg.MarkerPacket
            r0.<init>(r1)
            return r0
        L_0x0109:
            org.spongycastle.bcpg.SymmetricEncDataPacket r0 = new org.spongycastle.bcpg.SymmetricEncDataPacket
            r0.<init>(r1)
            return r0
        L_0x010f:
            org.spongycastle.bcpg.CompressedDataPacket r0 = new org.spongycastle.bcpg.CompressedDataPacket
            r0.<init>(r1)
            return r0
        L_0x0115:
            org.spongycastle.bcpg.SecretSubkeyPacket r0 = new org.spongycastle.bcpg.SecretSubkeyPacket
            r0.<init>(r1)
            return r0
        L_0x011b:
            org.spongycastle.bcpg.PublicKeyPacket r0 = new org.spongycastle.bcpg.PublicKeyPacket
            r0.<init>(r1)
            return r0
        L_0x0121:
            org.spongycastle.bcpg.SecretKeyPacket r0 = new org.spongycastle.bcpg.SecretKeyPacket
            r0.<init>(r1)
            return r0
        L_0x0127:
            org.spongycastle.bcpg.OnePassSignaturePacket r0 = new org.spongycastle.bcpg.OnePassSignaturePacket
            r0.<init>(r1)
            return r0
        L_0x012d:
            org.spongycastle.bcpg.SymmetricKeyEncSessionPacket r0 = new org.spongycastle.bcpg.SymmetricKeyEncSessionPacket
            r0.<init>(r1)
            return r0
        L_0x0133:
            org.spongycastle.bcpg.SignaturePacket r0 = new org.spongycastle.bcpg.SignaturePacket
            r0.<init>(r1)
            return r0
        L_0x0139:
            org.spongycastle.bcpg.PublicKeyEncSessionPacket r0 = new org.spongycastle.bcpg.PublicKeyEncSessionPacket
            r0.<init>(r1)
            return r0
        L_0x013f:
            org.spongycastle.bcpg.InputStreamPacket r0 = new org.spongycastle.bcpg.InputStreamPacket
            r0.<init>(r1)
            return r0
        L_0x0145:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "invalid header encountered"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.BCPGInputStream.readPacket():org.spongycastle.bcpg.Packet");
    }

    public void close() throws IOException {
        this.in.close();
    }

    private static class PartialInputStream extends InputStream {
        private int dataLength;
        private BCPGInputStream in;
        private boolean partial;

        PartialInputStream(BCPGInputStream bCPGInputStream, boolean z, int i) {
            this.in = bCPGInputStream;
            this.partial = z;
            this.dataLength = i;
        }

        public int available() throws IOException {
            int available = this.in.available();
            int i = this.dataLength;
            if (available <= i || i < 0) {
                return available;
            }
            if (!this.partial || i != 0) {
                return i;
            }
            return 1;
        }

        private int loadDataLength() throws IOException {
            int read = this.in.read();
            if (read < 0) {
                return -1;
            }
            this.partial = false;
            if (read < 192) {
                this.dataLength = read;
            } else if (read <= 223) {
                this.dataLength = ((read - 192) << 8) + this.in.read() + 192;
            } else if (read == 255) {
                this.dataLength = (this.in.read() << 24) | (this.in.read() << 16) | (this.in.read() << 8) | this.in.read();
            } else {
                this.partial = true;
                this.dataLength = 1 << (read & 31);
            }
            return this.dataLength;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read(byte[] r2, int r3, int r4) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.dataLength
                if (r0 == 0) goto L_0x0020
                if (r0 > r4) goto L_0x000a
                if (r0 >= 0) goto L_0x0009
                goto L_0x000a
            L_0x0009:
                r4 = r0
            L_0x000a:
                org.spongycastle.bcpg.BCPGInputStream r0 = r1.in
                int r2 = r0.read(r2, r3, r4)
                if (r2 < 0) goto L_0x0018
                int r3 = r1.dataLength
                int r3 = r3 - r2
                r1.dataLength = r3
                return r2
            L_0x0018:
                java.io.EOFException r2 = new java.io.EOFException
                java.lang.String r3 = "premature end of stream in PartialInputStream"
                r2.<init>(r3)
                throw r2
            L_0x0020:
                boolean r0 = r1.partial
                if (r0 == 0) goto L_0x002a
                int r0 = r1.loadDataLength()
                if (r0 >= 0) goto L_0x0000
            L_0x002a:
                r2 = -1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.BCPGInputStream.PartialInputStream.read(byte[], int, int):int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r2 = this;
            L_0x0000:
                int r0 = r2.dataLength
                if (r0 == 0) goto L_0x001b
                org.spongycastle.bcpg.BCPGInputStream r0 = r2.in
                int r0 = r0.read()
                if (r0 < 0) goto L_0x0013
                int r1 = r2.dataLength
                int r1 = r1 + -1
                r2.dataLength = r1
                return r0
            L_0x0013:
                java.io.EOFException r0 = new java.io.EOFException
                java.lang.String r1 = "premature end of stream in PartialInputStream"
                r0.<init>(r1)
                throw r0
            L_0x001b:
                boolean r0 = r2.partial
                if (r0 == 0) goto L_0x0025
                int r0 = r2.loadDataLength()
                if (r0 >= 0) goto L_0x0000
            L_0x0025:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.BCPGInputStream.PartialInputStream.read():int");
        }
    }
}
