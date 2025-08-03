package org.spongycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;

public class PublicKeyEncSessionPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private int algorithm;
    private byte[][] data;
    private long keyID;
    private int version;

    PublicKeyEncSessionPacket(BCPGInputStream bCPGInputStream) throws IOException {
        this.version = bCPGInputStream.read();
        long read = this.keyID | (((long) bCPGInputStream.read()) << 56);
        this.keyID = read;
        long read2 = read | (((long) bCPGInputStream.read()) << 48);
        this.keyID = read2;
        long read3 = read2 | (((long) bCPGInputStream.read()) << 40);
        this.keyID = read3;
        long read4 = read3 | (((long) bCPGInputStream.read()) << 32);
        this.keyID = read4;
        long read5 = read4 | (((long) bCPGInputStream.read()) << 24);
        this.keyID = read5;
        long read6 = read5 | (((long) bCPGInputStream.read()) << 16);
        this.keyID = read6;
        long read7 = read6 | (((long) bCPGInputStream.read()) << 8);
        this.keyID = read7;
        this.keyID = read7 | ((long) bCPGInputStream.read());
        int read8 = bCPGInputStream.read();
        this.algorithm = read8;
        if (read8 == 1 || read8 == 2) {
            byte[][] bArr = new byte[1][];
            this.data = bArr;
            bArr[0] = new MPInteger(bCPGInputStream).getEncoded();
            return;
        }
        if (read8 != 16) {
            if (read8 == 18) {
                byte[][] bArr2 = new byte[1][];
                this.data = bArr2;
                bArr2[0] = Streams.readAll(bCPGInputStream);
                return;
            } else if (read8 != 20) {
                throw new IOException("unknown PGP public key algorithm encountered");
            }
        }
        byte[][] bArr3 = new byte[2][];
        this.data = bArr3;
        bArr3[0] = new MPInteger(bCPGInputStream).getEncoded();
        this.data[1] = new MPInteger(bCPGInputStream).getEncoded();
    }

    public PublicKeyEncSessionPacket(long j, int i, byte[][] bArr) {
        this.version = 3;
        this.keyID = j;
        this.algorithm = i;
        this.data = new byte[bArr.length][];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            this.data[i2] = Arrays.clone(bArr[i2]);
        }
    }

    public int getVersion() {
        return this.version;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public int getAlgorithm() {
        return this.algorithm;
    }

    public byte[][] getEncSessionKey() {
        return this.data;
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream2.write(this.version);
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 56)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 48)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 40)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 32)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 24)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 16)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 8)));
        bCPGOutputStream2.write((byte) ((int) this.keyID));
        bCPGOutputStream2.write(this.algorithm);
        int i = 0;
        while (true) {
            byte[][] bArr = this.data;
            if (i != bArr.length) {
                bCPGOutputStream2.write(bArr[i]);
                i++;
            } else {
                bCPGOutputStream2.close();
                bCPGOutputStream.writePacket(1, byteArrayOutputStream.toByteArray(), true);
                return;
            }
        }
    }
}
