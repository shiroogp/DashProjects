package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public final class XMSSMTPublicKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    private final XMSSMTParameters params;
    private final byte[] publicSeed;
    private final byte[] root;

    private XMSSMTPublicKeyParameters(Builder builder) {
        super(false);
        XMSSMTParameters access$000 = builder.params;
        this.params = access$000;
        Objects.requireNonNull(access$000, "params == null");
        int digestSize = access$000.getDigestSize();
        byte[] access$100 = builder.publicKey;
        if (access$100 != null) {
            if (access$100.length == digestSize + digestSize) {
                this.root = XMSSUtil.extractBytesAtOffset(access$100, 0, digestSize);
                this.publicSeed = XMSSUtil.extractBytesAtOffset(access$100, digestSize + 0, digestSize);
                return;
            }
            throw new IllegalArgumentException("public key has wrong size");
        }
        byte[] access$200 = builder.root;
        if (access$200 == null) {
            this.root = new byte[digestSize];
        } else if (access$200.length == digestSize) {
            this.root = access$200;
        } else {
            throw new IllegalArgumentException("length of root must be equal to length of digest");
        }
        byte[] access$300 = builder.publicSeed;
        if (access$300 == null) {
            this.publicSeed = new byte[digestSize];
        } else if (access$300.length == digestSize) {
            this.publicSeed = access$300;
        } else {
            throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public final XMSSMTParameters params;
        /* access modifiers changed from: private */
        public byte[] publicKey = null;
        /* access modifiers changed from: private */
        public byte[] publicSeed = null;
        /* access modifiers changed from: private */
        public byte[] root = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.params = xMSSMTParameters;
        }

        public Builder withRoot(byte[] bArr) {
            this.root = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withPublicKey(byte[] bArr) {
            this.publicKey = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public XMSSMTPublicKeyParameters build() {
            return new XMSSMTPublicKeyParameters(this);
        }
    }

    public byte[] toByteArray() {
        int digestSize = this.params.getDigestSize();
        byte[] bArr = new byte[(digestSize + digestSize)];
        XMSSUtil.copyBytesAtOffset(bArr, this.root, 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, digestSize + 0);
        return bArr;
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.root);
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    public XMSSMTParameters getParameters() {
        return this.params;
    }
}
