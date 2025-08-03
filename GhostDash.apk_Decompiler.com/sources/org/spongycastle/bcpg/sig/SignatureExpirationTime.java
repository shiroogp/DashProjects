package org.spongycastle.bcpg.sig;

import kotlin.UByte;
import org.spongycastle.bcpg.SignatureSubpacket;

public class SignatureExpirationTime extends SignatureSubpacket {
    protected static byte[] timeToBytes(long j) {
        return new byte[]{(byte) ((int) (j >> 24)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 8)), (byte) ((int) j)};
    }

    public SignatureExpirationTime(boolean z, boolean z2, byte[] bArr) {
        super(3, z, z2, bArr);
    }

    public SignatureExpirationTime(boolean z, long j) {
        super(3, z, false, timeToBytes(j));
    }

    public long getTime() {
        return (((long) (this.data[0] & UByte.MAX_VALUE)) << 24) | ((long) ((this.data[1] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH)) | ((long) ((this.data[2] & UByte.MAX_VALUE) << 8)) | ((long) (this.data[3] & UByte.MAX_VALUE));
    }
}
