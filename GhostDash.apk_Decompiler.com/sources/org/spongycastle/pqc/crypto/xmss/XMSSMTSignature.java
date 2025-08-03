package org.spongycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;

public final class XMSSMTSignature implements XMSSStoreableObjectInterface {
    private final long index;
    private final XMSSMTParameters params;
    private final byte[] random;
    private final List<XMSSReducedSignature> reducedSignatures;

    private XMSSMTSignature(Builder builder) {
        XMSSMTParameters access$000 = builder.params;
        this.params = access$000;
        Objects.requireNonNull(access$000, "params == null");
        int digestSize = access$000.getDigestSize();
        byte[] access$100 = builder.signature;
        if (access$100 != null) {
            int len = access$000.getWOTSPlus().getParams().getLen();
            int ceil = (int) Math.ceil(((double) access$000.getHeight()) / 8.0d);
            int height = ((access$000.getHeight() / access$000.getLayers()) + len) * digestSize;
            if (access$100.length == ceil + digestSize + (access$000.getLayers() * height)) {
                long bytesToXBigEndian = XMSSUtil.bytesToXBigEndian(access$100, 0, ceil);
                this.index = bytesToXBigEndian;
                if (XMSSUtil.isIndexValid(access$000.getHeight(), bytesToXBigEndian)) {
                    int i = ceil + 0;
                    this.random = XMSSUtil.extractBytesAtOffset(access$100, i, digestSize);
                    this.reducedSignatures = new ArrayList();
                    for (int i2 = i + digestSize; i2 < access$100.length; i2 += height) {
                        this.reducedSignatures.add(new XMSSReducedSignature.Builder(this.params.getXMSSParameters()).withReducedSignature(XMSSUtil.extractBytesAtOffset(access$100, i2, height)).build());
                    }
                    return;
                }
                throw new IllegalArgumentException("index out of bounds");
            }
            throw new IllegalArgumentException("signature has wrong size");
        }
        this.index = builder.index;
        byte[] access$300 = builder.random;
        if (access$300 == null) {
            this.random = new byte[digestSize];
        } else if (access$300.length == digestSize) {
            this.random = access$300;
        } else {
            throw new IllegalArgumentException("size of random needs to be equal to size of digest");
        }
        List<XMSSReducedSignature> access$400 = builder.reducedSignatures;
        if (access$400 != null) {
            this.reducedSignatures = access$400;
        } else {
            this.reducedSignatures = new ArrayList();
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public long index = 0;
        /* access modifiers changed from: private */
        public final XMSSMTParameters params;
        /* access modifiers changed from: private */
        public byte[] random = null;
        /* access modifiers changed from: private */
        public List<XMSSReducedSignature> reducedSignatures = null;
        /* access modifiers changed from: private */
        public byte[] signature = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.params = xMSSMTParameters;
        }

        public Builder withIndex(long j) {
            this.index = j;
            return this;
        }

        public Builder withRandom(byte[] bArr) {
            this.random = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withReducedSignatures(List<XMSSReducedSignature> list) {
            this.reducedSignatures = list;
            return this;
        }

        public Builder withSignature(byte[] bArr) {
            this.signature = bArr;
            return this;
        }

        public XMSSMTSignature build() {
            return new XMSSMTSignature(this);
        }
    }

    public byte[] toByteArray() {
        int digestSize = this.params.getDigestSize();
        int len = this.params.getWOTSPlus().getParams().getLen();
        int ceil = (int) Math.ceil(((double) this.params.getHeight()) / 8.0d);
        int height = ((this.params.getHeight() / this.params.getLayers()) + len) * digestSize;
        byte[] bArr = new byte[(ceil + digestSize + (this.params.getLayers() * height))];
        XMSSUtil.copyBytesAtOffset(bArr, XMSSUtil.toBytesBigEndian(this.index, ceil), 0);
        int i = ceil + 0;
        XMSSUtil.copyBytesAtOffset(bArr, this.random, i);
        int i2 = i + digestSize;
        for (XMSSReducedSignature byteArray : this.reducedSignatures) {
            XMSSUtil.copyBytesAtOffset(bArr, byteArray.toByteArray(), i2);
            i2 += height;
        }
        return bArr;
    }

    public long getIndex() {
        return this.index;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.random);
    }

    public List<XMSSReducedSignature> getReducedSignatures() {
        return this.reducedSignatures;
    }
}
