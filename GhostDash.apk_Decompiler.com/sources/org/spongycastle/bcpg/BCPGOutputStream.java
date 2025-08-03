package org.spongycastle.bcpg;

import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.asn1.cmc.BodyPartID;

public class BCPGOutputStream extends OutputStream implements PacketTags, CompressionAlgorithmTags {
    private static final int BUF_SIZE_POWER = 16;
    OutputStream out;
    private byte[] partialBuffer;
    private int partialBufferLength;
    private int partialOffset;
    private int partialPower;

    public BCPGOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public BCPGOutputStream(OutputStream outputStream, int i) throws IOException {
        this.out = outputStream;
        writeHeader(i, true, true, 0);
    }

    public BCPGOutputStream(OutputStream outputStream, int i, long j, boolean z) throws IOException {
        this.out = outputStream;
        if (j > BodyPartID.bodyIdMax) {
            writeHeader(i, false, true, 0);
            this.partialBufferLength = 65536;
            this.partialBuffer = new byte[65536];
            this.partialPower = 16;
            this.partialOffset = 0;
            return;
        }
        writeHeader(i, z, false, j);
    }

    public BCPGOutputStream(OutputStream outputStream, int i, long j) throws IOException {
        this.out = outputStream;
        writeHeader(i, false, false, j);
    }

    public BCPGOutputStream(OutputStream outputStream, int i, byte[] bArr) throws IOException {
        this.out = outputStream;
        writeHeader(i, false, true, 0);
        this.partialBuffer = bArr;
        int length = bArr.length;
        this.partialPower = 0;
        while (length != 1) {
            length >>>= 1;
            this.partialPower++;
        }
        int i2 = this.partialPower;
        if (i2 <= 30) {
            this.partialBufferLength = 1 << i2;
            this.partialOffset = 0;
            return;
        }
        throw new IOException("Buffer cannot be greater than 2^30 in length.");
    }

    private void writeNewPacketLength(long j) throws IOException {
        if (j < 192) {
            this.out.write((byte) ((int) j));
        } else if (j <= 8383) {
            long j2 = j - 192;
            this.out.write((byte) ((int) (((j2 >> 8) & 255) + 192)));
            this.out.write((byte) ((int) j2));
        } else {
            this.out.write(255);
            this.out.write((byte) ((int) (j >> 24)));
            this.out.write((byte) ((int) (j >> 16)));
            this.out.write((byte) ((int) (j >> 8)));
            this.out.write((byte) ((int) j));
        }
    }

    private void writeHeader(int i, boolean z, boolean z2, long j) throws IOException {
        if (this.partialBuffer != null) {
            partialFlush(true);
            this.partialBuffer = null;
        }
        if (z) {
            int i2 = (i << 2) | 128;
            if (z2) {
                write(i2 | 3);
            } else if (j <= 255) {
                write(i2);
                write((byte) ((int) j));
            } else if (j <= 65535) {
                write(i2 | 1);
                write((byte) ((int) (j >> 8)));
                write((byte) ((int) j));
            } else {
                write(i2 | 2);
                write((byte) ((int) (j >> 24)));
                write((byte) ((int) (j >> 16)));
                write((byte) ((int) (j >> 8)));
                write((byte) ((int) j));
            }
        } else {
            write(i | 64 | 128);
            if (z2) {
                this.partialOffset = 0;
            } else {
                writeNewPacketLength(j);
            }
        }
    }

    private void partialFlush(boolean z) throws IOException {
        if (z) {
            writeNewPacketLength((long) this.partialOffset);
            this.out.write(this.partialBuffer, 0, this.partialOffset);
        } else {
            this.out.write(this.partialPower | CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY);
            this.out.write(this.partialBuffer, 0, this.partialBufferLength);
        }
        this.partialOffset = 0;
    }

    private void writePartial(byte b) throws IOException {
        if (this.partialOffset == this.partialBufferLength) {
            partialFlush(false);
        }
        byte[] bArr = this.partialBuffer;
        int i = this.partialOffset;
        this.partialOffset = i + 1;
        bArr[i] = b;
    }

    private void writePartial(byte[] bArr, int i, int i2) throws IOException {
        if (this.partialOffset == this.partialBufferLength) {
            partialFlush(false);
        }
        int i3 = this.partialBufferLength;
        int i4 = this.partialOffset;
        if (i2 <= i3 - i4) {
            System.arraycopy(bArr, i, this.partialBuffer, i4, i2);
            this.partialOffset += i2;
            return;
        }
        System.arraycopy(bArr, i, this.partialBuffer, i4, i3 - i4);
        int i5 = this.partialBufferLength;
        int i6 = this.partialOffset;
        int i7 = i + (i5 - i6);
        int i8 = i2 - (i5 - i6);
        partialFlush(false);
        while (true) {
            int i9 = this.partialBufferLength;
            if (i8 > i9) {
                System.arraycopy(bArr, i7, this.partialBuffer, 0, i9);
                int i10 = this.partialBufferLength;
                i7 += i10;
                i8 -= i10;
                partialFlush(false);
            } else {
                System.arraycopy(bArr, i7, this.partialBuffer, 0, i8);
                this.partialOffset += i8;
                return;
            }
        }
    }

    public void write(int i) throws IOException {
        if (this.partialBuffer != null) {
            writePartial((byte) i);
        } else {
            this.out.write(i);
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.partialBuffer != null) {
            writePartial(bArr, i, i2);
        } else {
            this.out.write(bArr, i, i2);
        }
    }

    public void writePacket(ContainedPacket containedPacket) throws IOException {
        containedPacket.encode(this);
    }

    /* access modifiers changed from: package-private */
    public void writePacket(int i, byte[] bArr, boolean z) throws IOException {
        writeHeader(i, z, false, (long) bArr.length);
        write(bArr);
    }

    public void writeObject(BCPGObject bCPGObject) throws IOException {
        bCPGObject.encode(this);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void finish() throws IOException {
        if (this.partialBuffer != null) {
            partialFlush(true);
            this.partialBuffer = null;
        }
    }

    public void close() throws IOException {
        finish();
        this.out.flush();
        this.out.close();
    }
}
