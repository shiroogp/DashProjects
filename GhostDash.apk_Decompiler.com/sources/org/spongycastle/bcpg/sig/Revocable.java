package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class Revocable extends SignatureSubpacket {
    private static byte[] booleanToByteArray(boolean z) {
        byte[] bArr = new byte[1];
        if (z) {
            bArr[0] = 1;
        }
        return bArr;
    }

    public Revocable(boolean z, boolean z2, byte[] bArr) {
        super(7, z, z2, bArr);
    }

    public Revocable(boolean z, boolean z2) {
        super(7, z, false, booleanToByteArray(z2));
    }

    public boolean isRevocable() {
        return this.data[0] != 0;
    }
}
