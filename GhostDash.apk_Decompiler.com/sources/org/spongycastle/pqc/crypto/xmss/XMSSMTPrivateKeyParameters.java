package org.spongycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;

public final class XMSSMTPrivateKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    private final BDSStateMap bdsState;
    private final long index;
    private final XMSSMTParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    private XMSSMTPrivateKeyParameters(Builder builder) {
        super(true);
        XMSSMTParameters access$000 = builder.params;
        this.params = access$000;
        Objects.requireNonNull(access$000, "params == null");
        int digestSize = access$000.getDigestSize();
        byte[] access$100 = builder.privateKey;
        if (access$100 != null) {
            Objects.requireNonNull(builder.xmss, "xmss == null");
            int height = access$000.getHeight();
            int i = (height + 7) / 8;
            long bytesToXBigEndian = XMSSUtil.bytesToXBigEndian(access$100, 0, i);
            this.index = bytesToXBigEndian;
            if (XMSSUtil.isIndexValid(height, bytesToXBigEndian)) {
                int i2 = i + 0;
                this.secretKeySeed = XMSSUtil.extractBytesAtOffset(access$100, i2, digestSize);
                int i3 = i2 + digestSize;
                this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(access$100, i3, digestSize);
                int i4 = i3 + digestSize;
                this.publicSeed = XMSSUtil.extractBytesAtOffset(access$100, i4, digestSize);
                int i5 = i4 + digestSize;
                this.root = XMSSUtil.extractBytesAtOffset(access$100, i5, digestSize);
                int i6 = i5 + digestSize;
                byte[] extractBytesAtOffset = XMSSUtil.extractBytesAtOffset(access$100, i6, access$100.length - i6);
                BDSStateMap bDSStateMap = null;
                try {
                    bDSStateMap = (BDSStateMap) XMSSUtil.deserialize(extractBytesAtOffset);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                }
                bDSStateMap.setXMSS(builder.xmss);
                this.bdsState = bDSStateMap;
                return;
            }
            throw new IllegalArgumentException("index out of bounds");
        }
        this.index = builder.index;
        byte[] access$400 = builder.secretKeySeed;
        if (access$400 == null) {
            this.secretKeySeed = new byte[digestSize];
        } else if (access$400.length == digestSize) {
            this.secretKeySeed = access$400;
        } else {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
        }
        byte[] access$500 = builder.secretKeyPRF;
        if (access$500 == null) {
            this.secretKeyPRF = new byte[digestSize];
        } else if (access$500.length == digestSize) {
            this.secretKeyPRF = access$500;
        } else {
            throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
        }
        byte[] access$600 = builder.publicSeed;
        if (access$600 == null) {
            this.publicSeed = new byte[digestSize];
        } else if (access$600.length == digestSize) {
            this.publicSeed = access$600;
        } else {
            throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
        }
        byte[] access$700 = builder.root;
        if (access$700 == null) {
            this.root = new byte[digestSize];
        } else if (access$700.length == digestSize) {
            this.root = access$700;
        } else {
            throw new IllegalArgumentException("size of root needs to be equal size of digest");
        }
        BDSStateMap access$800 = builder.bdsState;
        if (access$800 != null) {
            this.bdsState = access$800;
            return;
        }
        if (!XMSSUtil.isIndexValid(access$000.getHeight(), builder.index) || access$600 == null || access$400 == null) {
            this.bdsState = new BDSStateMap();
        } else {
            this.bdsState = new BDSStateMap(access$000, builder.index, access$600, access$400);
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public BDSStateMap bdsState = null;
        /* access modifiers changed from: private */
        public long index = 0;
        /* access modifiers changed from: private */
        public final XMSSMTParameters params;
        /* access modifiers changed from: private */
        public byte[] privateKey = null;
        /* access modifiers changed from: private */
        public byte[] publicSeed = null;
        /* access modifiers changed from: private */
        public byte[] root = null;
        /* access modifiers changed from: private */
        public byte[] secretKeyPRF = null;
        /* access modifiers changed from: private */
        public byte[] secretKeySeed = null;
        /* access modifiers changed from: private */
        public XMSSParameters xmss = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.params = xMSSMTParameters;
        }

        public Builder withIndex(long j) {
            this.index = j;
            return this;
        }

        public Builder withSecretKeySeed(byte[] bArr) {
            this.secretKeySeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeyPRF(byte[] bArr) {
            this.secretKeyPRF = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withRoot(byte[] bArr) {
            this.root = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withBDSState(BDSStateMap bDSStateMap) {
            this.bdsState = bDSStateMap;
            return this;
        }

        public Builder withPrivateKey(byte[] bArr, XMSSParameters xMSSParameters) {
            this.privateKey = XMSSUtil.cloneArray(bArr);
            this.xmss = xMSSParameters;
            return this;
        }

        public XMSSMTPrivateKeyParameters build() {
            return new XMSSMTPrivateKeyParameters(this);
        }
    }

    public byte[] toByteArray() {
        int digestSize = this.params.getDigestSize();
        int height = (this.params.getHeight() + 7) / 8;
        byte[] bArr = new byte[(height + digestSize + digestSize + digestSize + digestSize)];
        XMSSUtil.copyBytesAtOffset(bArr, XMSSUtil.toBytesBigEndian(this.index, height), 0);
        int i = height + 0;
        XMSSUtil.copyBytesAtOffset(bArr, this.secretKeySeed, i);
        int i2 = i + digestSize;
        XMSSUtil.copyBytesAtOffset(bArr, this.secretKeyPRF, i2);
        int i3 = i2 + digestSize;
        XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i3);
        XMSSUtil.copyBytesAtOffset(bArr, this.root, i3 + digestSize);
        try {
            return Arrays.concatenate(bArr, XMSSUtil.serialize(this.bdsState));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("error serializing bds state");
        }
    }

    public long getIndex() {
        return this.index;
    }

    public byte[] getSecretKeySeed() {
        return XMSSUtil.cloneArray(this.secretKeySeed);
    }

    public byte[] getSecretKeyPRF() {
        return XMSSUtil.cloneArray(this.secretKeyPRF);
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.root);
    }

    /* access modifiers changed from: package-private */
    public BDSStateMap getBDSState() {
        return this.bdsState;
    }

    public XMSSMTParameters getParameters() {
        return this.params;
    }

    public XMSSMTPrivateKeyParameters getNextKey() {
        return new Builder(this.params).withIndex(this.index + 1).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root).withBDSState(new BDSStateMap(this.bdsState, this.params, getIndex(), this.publicSeed, this.secretKeySeed)).build();
    }
}
