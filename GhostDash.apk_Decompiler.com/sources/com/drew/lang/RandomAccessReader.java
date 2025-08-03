package com.drew.lang;

import com.drew.metadata.StringValue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import kotlin.UByte;

public abstract class RandomAccessReader {
    private boolean _isMotorolaByteOrder = true;

    public abstract byte getByte(int i) throws IOException;

    public abstract byte[] getBytes(int i, int i2) throws IOException;

    public abstract long getLength() throws IOException;

    /* access modifiers changed from: protected */
    public abstract boolean isValidIndex(int i, int i2) throws IOException;

    public abstract int toUnshiftedOffset(int i);

    /* access modifiers changed from: protected */
    public abstract void validateIndex(int i, int i2) throws IOException;

    public void setMotorolaByteOrder(boolean z) {
        this._isMotorolaByteOrder = z;
    }

    public boolean isMotorolaByteOrder() {
        return this._isMotorolaByteOrder;
    }

    public boolean getBit(int i) throws IOException {
        int i2 = i / 8;
        validateIndex(i2, 1);
        if (((getByte(i2) >> (i % 8)) & 1) == 1) {
            return true;
        }
        return false;
    }

    public short getUInt8(int i) throws IOException {
        validateIndex(i, 1);
        return (short) (getByte(i) & UByte.MAX_VALUE);
    }

    public byte getInt8(int i) throws IOException {
        validateIndex(i, 1);
        return getByte(i);
    }

    public int getUInt16(int i) throws IOException {
        byte b;
        byte b2;
        validateIndex(i, 2);
        if (this._isMotorolaByteOrder) {
            b = (getByte(i) << 8) & 65280;
            b2 = getByte(i + 1);
        } else {
            b = (getByte(i + 1) << 8) & 65280;
            b2 = getByte(i);
        }
        return (b2 & UByte.MAX_VALUE) | b;
    }

    public short getInt16(int i) throws IOException {
        short s;
        byte b;
        validateIndex(i, 2);
        if (this._isMotorolaByteOrder) {
            s = (((short) getByte(i)) << 8) & -256;
            b = getByte(i + 1);
        } else {
            s = (((short) getByte(i + 1)) << 8) & -256;
            b = getByte(i);
        }
        return (short) ((((short) b) & 255) | s);
    }

    public int getInt24(int i) throws IOException {
        byte b;
        byte b2;
        validateIndex(i, 3);
        if (this._isMotorolaByteOrder) {
            b = ((getByte(i) << Tnaf.POW_2_WIDTH) & 16711680) | (65280 & (getByte(i + 1) << 8));
            b2 = getByte(i + 2);
        } else {
            b = ((getByte(i + 2) << Tnaf.POW_2_WIDTH) & 16711680) | (65280 & (getByte(i + 1) << 8));
            b2 = getByte(i);
        }
        return (b2 & UByte.MAX_VALUE) | b;
    }

    public long getUInt32(int i) throws IOException {
        long j;
        byte b;
        validateIndex(i, 4);
        if (this._isMotorolaByteOrder) {
            long j2 = 4278190080L & (((long) getByte(i)) << 24);
            j = (65280 & (((long) getByte(i + 2)) << 8)) | (16711680 & (((long) getByte(i + 1)) << 16)) | j2;
            b = getByte(i + 3);
        } else {
            long j3 = 4278190080L & (((long) getByte(i + 3)) << 24);
            j = (65280 & (((long) getByte(i + 1)) << 8)) | (16711680 & (((long) getByte(i + 2)) << 16)) | j3;
            b = getByte(i);
        }
        return (((long) b) & 255) | j;
    }

    public int getInt32(int i) throws IOException {
        byte b;
        byte b2;
        validateIndex(i, 4);
        if (this._isMotorolaByteOrder) {
            b = ((getByte(i) << 24) & -16777216) | (16711680 & (getByte(i + 1) << Tnaf.POW_2_WIDTH)) | (65280 & (getByte(i + 2) << 8));
            b2 = getByte(i + 3);
        } else {
            b = ((getByte(i + 3) << 24) & -16777216) | (16711680 & (getByte(i + 2) << Tnaf.POW_2_WIDTH)) | (65280 & (getByte(i + 1) << 8));
            b2 = getByte(i);
        }
        return (b2 & UByte.MAX_VALUE) | b;
    }

    public long getInt64(int i) throws IOException {
        long j;
        byte b;
        int i2 = i;
        validateIndex(i2, 8);
        if (this._isMotorolaByteOrder) {
            j = ((((long) getByte(i)) << 56) & -72057594037927936L) | ((((long) getByte(i2 + 1)) << 48) & 71776119061217280L) | ((((long) getByte(i2 + 2)) << 40) & 280375465082880L) | ((((long) getByte(i2 + 3)) << 32) & 1095216660480L) | ((((long) getByte(i2 + 4)) << 24) & 4278190080L) | ((((long) getByte(i2 + 5)) << 16) & 16711680) | ((((long) getByte(i2 + 6)) << 8) & 65280);
            b = getByte(i2 + 7);
        } else {
            j = ((((long) getByte(i2 + 7)) << 56) & -72057594037927936L) | ((((long) getByte(i2 + 6)) << 48) & 71776119061217280L) | ((((long) getByte(i2 + 5)) << 40) & 280375465082880L) | ((((long) getByte(i2 + 4)) << 32) & 1095216660480L) | ((((long) getByte(i2 + 3)) << 24) & 4278190080L) | ((((long) getByte(i2 + 2)) << 16) & 16711680) | ((((long) getByte(i2 + 1)) << 8) & 65280);
            b = getByte(i);
        }
        return j | (((long) b) & 255);
    }

    public float getS15Fixed16(int i) throws IOException {
        float f;
        int i2;
        byte b;
        validateIndex(i, 4);
        if (this._isMotorolaByteOrder) {
            f = (float) (((getByte(i) & UByte.MAX_VALUE) << 8) | (getByte(i + 1) & UByte.MAX_VALUE));
            i2 = (getByte(i + 2) & UByte.MAX_VALUE) << 8;
            b = getByte(i + 3);
        } else {
            f = (float) (((getByte(i + 3) & UByte.MAX_VALUE) << 8) | (getByte(i + 2) & UByte.MAX_VALUE));
            i2 = (getByte(i + 1) & UByte.MAX_VALUE) << 8;
            b = getByte(i);
        }
        return (float) (((double) f) + (((double) ((b & UByte.MAX_VALUE) | i2)) / 65536.0d));
    }

    public float getFloat32(int i) throws IOException {
        return Float.intBitsToFloat(getInt32(i));
    }

    public double getDouble64(int i) throws IOException {
        return Double.longBitsToDouble(getInt64(i));
    }

    public StringValue getStringValue(int i, int i2, Charset charset) throws IOException {
        return new StringValue(getBytes(i, i2), charset);
    }

    public String getString(int i, int i2, Charset charset) throws IOException {
        return new String(getBytes(i, i2), charset.name());
    }

    public String getString(int i, int i2, String str) throws IOException {
        byte[] bytes = getBytes(i, i2);
        try {
            return new String(bytes, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bytes);
        }
    }

    public String getNullTerminatedString(int i, int i2, Charset charset) throws IOException {
        return new String(getNullTerminatedBytes(i, i2), charset.name());
    }

    public StringValue getNullTerminatedStringValue(int i, int i2, Charset charset) throws IOException {
        return new StringValue(getNullTerminatedBytes(i, i2), charset);
    }

    public byte[] getNullTerminatedBytes(int i, int i2) throws IOException {
        byte[] bytes = getBytes(i, i2);
        int i3 = 0;
        while (i3 < bytes.length && bytes[i3] != 0) {
            i3++;
        }
        if (i3 == i2) {
            return bytes;
        }
        byte[] bArr = new byte[i3];
        if (i3 > 0) {
            System.arraycopy(bytes, 0, bArr, 0, i3);
        }
        return bArr;
    }
}
