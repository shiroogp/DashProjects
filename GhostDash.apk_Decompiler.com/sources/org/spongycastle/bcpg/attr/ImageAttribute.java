package org.spongycastle.bcpg.attr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.UByte;
import org.spongycastle.bcpg.UserAttributeSubpacket;

public class ImageAttribute extends UserAttributeSubpacket {
    public static final int JPEG = 1;
    private static final byte[] ZEROES = new byte[12];
    private int encoding;
    private int hdrLength;
    private byte[] imageData;
    private int version;

    public ImageAttribute(byte[] bArr) {
        this(false, bArr);
    }

    public ImageAttribute(boolean z, byte[] bArr) {
        super(1, z, bArr);
        byte b = ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE);
        this.hdrLength = b;
        this.version = bArr[2] & UByte.MAX_VALUE;
        this.encoding = bArr[3] & UByte.MAX_VALUE;
        byte[] bArr2 = new byte[(bArr.length - b)];
        this.imageData = bArr2;
        System.arraycopy(bArr, b, bArr2, 0, bArr2.length);
    }

    public ImageAttribute(int i, byte[] bArr) {
        this(toByteArray(i, bArr));
    }

    private static byte[] toByteArray(int i, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(16);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(1);
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(ZEROES);
            byteArrayOutputStream.write(bArr);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new RuntimeException("unable to encode to byte array!");
        }
    }

    public int version() {
        return this.version;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public byte[] getImageData() {
        return this.imageData;
    }
}
