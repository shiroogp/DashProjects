package org.spongycastle.bcpg.sig;

import java.util.Date;
import kotlin.UByte;
import org.spongycastle.bcpg.SignatureSubpacket;

public class SignatureCreationTime extends SignatureSubpacket {
    protected static byte[] timeToBytes(Date date) {
        long time = date.getTime() / 1000;
        return new byte[]{(byte) ((int) (time >> 24)), (byte) ((int) (time >> 16)), (byte) ((int) (time >> 8)), (byte) ((int) time)};
    }

    public SignatureCreationTime(boolean z, boolean z2, byte[] bArr) {
        super(2, z, z2, bArr);
    }

    public SignatureCreationTime(boolean z, Date date) {
        super(2, z, false, timeToBytes(date));
    }

    public Date getTime() {
        return new Date(((((long) (this.data[0] & UByte.MAX_VALUE)) << 24) | ((long) ((this.data[1] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH)) | ((long) ((this.data[2] & UByte.MAX_VALUE) << 8)) | ((long) (this.data[3] & UByte.MAX_VALUE))) * 1000);
    }
}
