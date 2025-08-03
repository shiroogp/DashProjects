package org.spongycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.Arrays;

public class SignatureSubpacketInputStream extends InputStream implements SignatureSubpacketTags {
    InputStream in;

    public SignatureSubpacketInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public int read() throws IOException {
        return this.in.read();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.bcpg.SignatureSubpacket readPacket() throws java.io.IOException {
        /*
            r12 = this;
            int r0 = r12.read()
            if (r0 >= 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            r1 = 0
            r2 = 16
            r3 = 1
            r4 = 8
            r5 = 192(0xc0, float:2.69E-43)
            if (r0 >= r5) goto L_0x0014
        L_0x0012:
            r5 = r1
            goto L_0x0048
        L_0x0014:
            r6 = 223(0xdf, float:3.12E-43)
            if (r0 > r6) goto L_0x0024
            int r0 = r0 + -192
            int r0 = r0 << r4
            java.io.InputStream r6 = r12.in
            int r6 = r6.read()
            int r0 = r0 + r6
            int r0 = r0 + r5
            goto L_0x0012
        L_0x0024:
            r5 = 255(0xff, float:3.57E-43)
            if (r0 != r5) goto L_0x010b
            java.io.InputStream r0 = r12.in
            int r0 = r0.read()
            int r0 = r0 << 24
            java.io.InputStream r5 = r12.in
            int r5 = r5.read()
            int r5 = r5 << r2
            r0 = r0 | r5
            java.io.InputStream r5 = r12.in
            int r5 = r5.read()
            int r5 = r5 << r4
            r0 = r0 | r5
            java.io.InputStream r5 = r12.in
            int r5 = r5.read()
            r0 = r0 | r5
            r5 = r3
        L_0x0048:
            java.io.InputStream r6 = r12.in
            int r6 = r6.read()
            if (r6 < 0) goto L_0x0103
            int r0 = r0 - r3
            byte[] r7 = new byte[r0]
            java.io.InputStream r8 = r12.in
            int r8 = org.spongycastle.util.io.Streams.readFully(r8, r7)
            r9 = r6 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x005e
            r1 = r3
        L_0x005e:
            r3 = r6 & 127(0x7f, float:1.78E-43)
            r6 = 9
            r9 = 3
            r10 = 2
            r11 = 4
            if (r8 == r0) goto L_0x0092
            if (r3 == r10) goto L_0x008c
            if (r3 == r9) goto L_0x0085
            if (r3 == r6) goto L_0x007e
            if (r3 != r2) goto L_0x0076
            java.lang.String r0 = "Issuer"
            byte[] r7 = r12.checkData(r7, r4, r8, r0)
            goto L_0x0092
        L_0x0076:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.String r1 = "truncated subpacket data."
            r0.<init>(r1)
            throw r0
        L_0x007e:
            java.lang.String r0 = "Signature Key Expiration Time"
            byte[] r7 = r12.checkData(r7, r11, r8, r0)
            goto L_0x0092
        L_0x0085:
            java.lang.String r0 = "Signature Expiration Time"
            byte[] r7 = r12.checkData(r7, r11, r8, r0)
            goto L_0x0092
        L_0x008c:
            java.lang.String r0 = "Signature Creation Time"
            byte[] r7 = r12.checkData(r7, r11, r8, r0)
        L_0x0092:
            if (r3 == r10) goto L_0x00fd
            if (r3 == r9) goto L_0x00f7
            if (r3 == r11) goto L_0x00f1
            r0 = 5
            if (r3 == r0) goto L_0x00eb
            r0 = 7
            if (r3 == r0) goto L_0x00e5
            if (r3 == r6) goto L_0x00df
            r0 = 11
            if (r3 == r0) goto L_0x00d9
            if (r3 == r2) goto L_0x00d3
            r0 = 25
            if (r3 == r0) goto L_0x00cd
            r0 = 27
            if (r3 == r0) goto L_0x00c7
            r0 = 28
            if (r3 == r0) goto L_0x00c1
            switch(r3) {
                case 20: goto L_0x00bb;
                case 21: goto L_0x00d9;
                case 22: goto L_0x00d9;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            org.spongycastle.bcpg.SignatureSubpacket r0 = new org.spongycastle.bcpg.SignatureSubpacket
            r0.<init>(r3, r1, r5, r7)
            return r0
        L_0x00bb:
            org.spongycastle.bcpg.sig.NotationData r0 = new org.spongycastle.bcpg.sig.NotationData
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00c1:
            org.spongycastle.bcpg.sig.SignerUserID r0 = new org.spongycastle.bcpg.sig.SignerUserID
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00c7:
            org.spongycastle.bcpg.sig.KeyFlags r0 = new org.spongycastle.bcpg.sig.KeyFlags
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00cd:
            org.spongycastle.bcpg.sig.PrimaryUserID r0 = new org.spongycastle.bcpg.sig.PrimaryUserID
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00d3:
            org.spongycastle.bcpg.sig.IssuerKeyID r0 = new org.spongycastle.bcpg.sig.IssuerKeyID
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00d9:
            org.spongycastle.bcpg.sig.PreferredAlgorithms r0 = new org.spongycastle.bcpg.sig.PreferredAlgorithms
            r0.<init>(r3, r1, r5, r7)
            return r0
        L_0x00df:
            org.spongycastle.bcpg.sig.KeyExpirationTime r0 = new org.spongycastle.bcpg.sig.KeyExpirationTime
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00e5:
            org.spongycastle.bcpg.sig.Revocable r0 = new org.spongycastle.bcpg.sig.Revocable
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00eb:
            org.spongycastle.bcpg.sig.TrustSignature r0 = new org.spongycastle.bcpg.sig.TrustSignature
            r0.<init>((boolean) r1, (boolean) r5, (byte[]) r7)
            return r0
        L_0x00f1:
            org.spongycastle.bcpg.sig.Exportable r0 = new org.spongycastle.bcpg.sig.Exportable
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00f7:
            org.spongycastle.bcpg.sig.SignatureExpirationTime r0 = new org.spongycastle.bcpg.sig.SignatureExpirationTime
            r0.<init>(r1, r5, r7)
            return r0
        L_0x00fd:
            org.spongycastle.bcpg.sig.SignatureCreationTime r0 = new org.spongycastle.bcpg.sig.SignatureCreationTime
            r0.<init>(r1, r5, r7)
            return r0
        L_0x0103:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.String r1 = "unexpected EOF reading signature sub packet"
            r0.<init>(r1)
            throw r0
        L_0x010b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "unexpected length header"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.bcpg.SignatureSubpacketInputStream.readPacket():org.spongycastle.bcpg.SignatureSubpacket");
    }

    private byte[] checkData(byte[] bArr, int i, int i2, String str) throws EOFException {
        if (i2 == i) {
            return Arrays.copyOfRange(bArr, 0, i);
        }
        throw new EOFException("truncated " + str + " subpacket data.");
    }
}
