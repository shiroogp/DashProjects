package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Xof;

final class KeyedHashFunctions {
    private final Digest digest;
    private final int digestSize;

    protected KeyedHashFunctions(Digest digest2, int i) {
        Objects.requireNonNull(digest2, "digest == null");
        this.digest = digest2;
        this.digestSize = i;
    }

    private byte[] coreDigest(int i, byte[] bArr, byte[] bArr2) {
        byte[] bytesBigEndian = XMSSUtil.toBytesBigEndian((long) i, this.digestSize);
        this.digest.update(bytesBigEndian, 0, bytesBigEndian.length);
        this.digest.update(bArr, 0, bArr.length);
        this.digest.update(bArr2, 0, bArr2.length);
        int i2 = this.digestSize;
        byte[] bArr3 = new byte[i2];
        Digest digest2 = this.digest;
        if (digest2 instanceof Xof) {
            ((Xof) digest2).doFinal(bArr3, 0, i2);
        } else {
            digest2.doFinal(bArr3, 0);
        }
        return bArr3;
    }

    /* access modifiers changed from: protected */
    public byte[] F(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.digestSize;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == i) {
            return coreDigest(0, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong in length");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] H(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.digestSize;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == i * 2) {
            return coreDigest(1, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong in length");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] HMsg(byte[] bArr, byte[] bArr2) {
        if (bArr.length == this.digestSize * 3) {
            return coreDigest(2, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong key length");
    }

    /* access modifiers changed from: protected */
    public byte[] PRF(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.digestSize) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == 32) {
            return coreDigest(3, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong address length");
        }
    }
}
