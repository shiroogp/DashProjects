package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class Features extends SignatureSubpacket {
    public static final byte FEATURE_MODIFICATION_DETECTION = 1;

    private static final byte[] featureToByteArray(byte b) {
        return new byte[]{b};
    }

    public Features(boolean z, boolean z2, byte[] bArr) {
        super(30, z, z2, bArr);
    }

    public Features(boolean z, byte b) {
        super(30, z, false, featureToByteArray(b));
    }

    public boolean supportsModificationDetection() {
        return supportsFeature((byte) 1);
    }

    public boolean supportsFeature(byte b) {
        for (byte b2 : this.data) {
            if (b2 == b) {
                return true;
            }
        }
        return false;
    }

    private void setSupportsFeature(byte b, boolean z) {
        if (b == 0) {
            throw new IllegalArgumentException("feature == 0");
        } else if (supportsFeature(b) == z) {
        } else {
            if (z) {
                byte[] bArr = new byte[(this.data.length + 1)];
                System.arraycopy(this.data, 0, bArr, 0, this.data.length);
                bArr[this.data.length] = b;
                this.data = bArr;
                return;
            }
            for (int i = 0; i < this.data.length; i++) {
                if (this.data[i] == b) {
                    int length = this.data.length - 1;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(this.data, 0, bArr2, 0, i);
                    System.arraycopy(this.data, i + 1, bArr2, i, length - i);
                    this.data = bArr2;
                    return;
                }
            }
        }
    }
}
