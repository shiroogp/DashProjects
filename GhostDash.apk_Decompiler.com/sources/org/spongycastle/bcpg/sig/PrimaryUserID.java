package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class PrimaryUserID extends SignatureSubpacket {
    private static byte[] booleanToByteArray(boolean z) {
        byte[] bArr = new byte[1];
        if (z) {
            bArr[0] = 1;
        }
        return bArr;
    }

    public PrimaryUserID(boolean z, boolean z2, byte[] bArr) {
        super(25, z, z2, bArr);
    }

    public PrimaryUserID(boolean z, boolean z2) {
        super(25, z, false, booleanToByteArray(z2));
    }

    public boolean isPrimaryUserID() {
        return this.data[0] != 0;
    }
}
