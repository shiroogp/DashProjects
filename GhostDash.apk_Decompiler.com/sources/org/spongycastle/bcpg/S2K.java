package org.spongycastle.bcpg;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class S2K extends BCPGObject {
    private static final int EXPBIAS = 6;
    public static final int GNU_DUMMY_S2K = 101;
    public static final int GNU_PROTECTION_MODE_DIVERT_TO_CARD = 2;
    public static final int GNU_PROTECTION_MODE_NO_PRIVATE_KEY = 1;
    public static final int SALTED = 1;
    public static final int SALTED_AND_ITERATED = 3;
    public static final int SIMPLE = 0;
    int algorithm;
    int itCount;
    byte[] iv;
    int protectionMode;
    int type;

    S2K(InputStream inputStream) throws IOException {
        this.itCount = -1;
        this.protectionMode = -1;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.type = dataInputStream.read();
        this.algorithm = dataInputStream.read();
        int i = this.type;
        if (i == 101) {
            dataInputStream.read();
            dataInputStream.read();
            dataInputStream.read();
            this.protectionMode = dataInputStream.read();
        } else if (i != 0) {
            byte[] bArr = new byte[8];
            this.iv = bArr;
            dataInputStream.readFully(bArr, 0, bArr.length);
            if (this.type == 3) {
                this.itCount = dataInputStream.read();
            }
        }
    }

    public S2K(int i) {
        this.itCount = -1;
        this.protectionMode = -1;
        this.type = 0;
        this.algorithm = i;
    }

    public S2K(int i, byte[] bArr) {
        this.itCount = -1;
        this.protectionMode = -1;
        this.type = 1;
        this.algorithm = i;
        this.iv = bArr;
    }

    public S2K(int i, byte[] bArr, int i2) {
        this.itCount = -1;
        this.protectionMode = -1;
        this.type = 3;
        this.algorithm = i;
        this.iv = bArr;
        this.itCount = i2;
    }

    public int getType() {
        return this.type;
    }

    public int getHashAlgorithm() {
        return this.algorithm;
    }

    public byte[] getIV() {
        return this.iv;
    }

    public long getIterationCount() {
        int i = this.itCount;
        return (long) (((i & 15) + 16) << ((i >> 4) + 6));
    }

    public int getProtectionMode() {
        return this.protectionMode;
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.write(this.type);
        bCPGOutputStream.write(this.algorithm);
        int i = this.type;
        if (i != 101) {
            if (i != 0) {
                bCPGOutputStream.write(this.iv);
            }
            if (this.type == 3) {
                bCPGOutputStream.write(this.itCount);
                return;
            }
            return;
        }
        bCPGOutputStream.write(71);
        bCPGOutputStream.write(78);
        bCPGOutputStream.write(85);
        bCPGOutputStream.write(this.protectionMode);
    }
}
