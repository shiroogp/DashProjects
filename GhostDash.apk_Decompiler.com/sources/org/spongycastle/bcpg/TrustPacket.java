package org.spongycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TrustPacket extends ContainedPacket {
    byte[] levelAndTrustAmount;

    public TrustPacket(BCPGInputStream bCPGInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = bCPGInputStream.read();
            if (read >= 0) {
                byteArrayOutputStream.write(read);
            } else {
                this.levelAndTrustAmount = byteArrayOutputStream.toByteArray();
                return;
            }
        }
    }

    public TrustPacket(int i) {
        byte[] bArr = new byte[1];
        this.levelAndTrustAmount = bArr;
        bArr[0] = (byte) i;
    }

    public byte[] getLevelAndTrustAmount() {
        return this.levelAndTrustAmount;
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(12, this.levelAndTrustAmount, true);
    }
}
