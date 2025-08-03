package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class SignerUserID extends SignatureSubpacket {
    public SignerUserID(boolean z, boolean z2, byte[] bArr) {
        super(28, z, z2, bArr);
    }

    public SignerUserID(boolean z, String str) {
        super(28, z, false, Strings.toUTF8ByteArray(str));
    }

    public String getID() {
        return Strings.fromUTF8ByteArray(this.data);
    }

    public byte[] getRawID() {
        return Arrays.clone(this.data);
    }
}
