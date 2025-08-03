package org.spongycastle.bcpg;

import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class UserIDPacket extends ContainedPacket {
    private byte[] idData;

    public UserIDPacket(BCPGInputStream bCPGInputStream) throws IOException {
        this.idData = bCPGInputStream.readAll();
    }

    public UserIDPacket(String str) {
        this.idData = Strings.toUTF8ByteArray(str);
    }

    public UserIDPacket(byte[] bArr) {
        this.idData = Arrays.clone(bArr);
    }

    public String getID() {
        return Strings.fromUTF8ByteArray(this.idData);
    }

    public byte[] getRawID() {
        return Arrays.clone(this.idData);
    }

    public boolean equals(Object obj) {
        if (obj instanceof UserIDPacket) {
            return Arrays.areEqual(this.idData, ((UserIDPacket) obj).idData);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.idData);
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(13, this.idData, true);
    }
}
