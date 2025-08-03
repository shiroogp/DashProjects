package org.spongycastle.bcpg.sig;

import kotlin.UByte;
import org.spongycastle.bcpg.SignatureSubpacket;

public class PreferredAlgorithms extends SignatureSubpacket {
    private static byte[] intToByteArray(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i != iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    public PreferredAlgorithms(int i, boolean z, boolean z2, byte[] bArr) {
        super(i, z, z2, bArr);
    }

    public PreferredAlgorithms(int i, boolean z, int[] iArr) {
        super(i, z, false, intToByteArray(iArr));
    }

    public int[] getPreferrences() {
        return getPreferences();
    }

    public int[] getPreferences() {
        int length = this.data.length;
        int[] iArr = new int[length];
        for (int i = 0; i != length; i++) {
            iArr[i] = this.data[i] & UByte.MAX_VALUE;
        }
        return iArr;
    }
}
