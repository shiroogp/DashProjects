package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;
import org.spongycastle.util.Strings;

public class RevocationReason extends SignatureSubpacket {
    public RevocationReason(boolean z, boolean z2, byte[] bArr) {
        super(29, z, z2, bArr);
    }

    public RevocationReason(boolean z, byte b, String str) {
        super(29, z, false, createData(b, str));
    }

    private static byte[] createData(byte b, String str) {
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
        byte[] bArr = new byte[(uTF8ByteArray.length + 1)];
        bArr[0] = b;
        System.arraycopy(uTF8ByteArray, 0, bArr, 1, uTF8ByteArray.length);
        return bArr;
    }

    public byte getRevocationReason() {
        return getData()[0];
    }

    public String getRevocationDescription() {
        byte[] data = getData();
        if (data.length == 1) {
            return "";
        }
        int length = data.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(data, 1, bArr, 0, length);
        return Strings.fromUTF8ByteArray(bArr);
    }
}
