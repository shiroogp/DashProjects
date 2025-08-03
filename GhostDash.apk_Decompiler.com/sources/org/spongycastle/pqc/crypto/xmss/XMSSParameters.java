package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.crypto.Digest;

public final class XMSSParameters {
    private final int height;
    private final int k;
    private final XMSSOid oid;
    private final WOTSPlus wotsPlus;

    public XMSSParameters(int i, Digest digest) {
        if (i >= 2) {
            Objects.requireNonNull(digest, "digest == null");
            WOTSPlus wOTSPlus = new WOTSPlus(new WOTSPlusParameters(digest));
            this.wotsPlus = wOTSPlus;
            this.height = i;
            this.k = determineMinK();
            this.oid = DefaultXMSSOid.lookup(getDigest().getAlgorithmName(), getDigestSize(), getWinternitzParameter(), wOTSPlus.getParams().getLen(), i);
            return;
        }
        throw new IllegalArgumentException("height must be >= 2");
    }

    private int determineMinK() {
        int i = 2;
        while (true) {
            int i2 = this.height;
            if (i > i2) {
                throw new IllegalStateException("should never happen...");
            } else if ((i2 - i) % 2 == 0) {
                return i;
            } else {
                i++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Digest getDigest() {
        return this.wotsPlus.getParams().getDigest();
    }

    public int getDigestSize() {
        return this.wotsPlus.getParams().getDigestSize();
    }

    public int getWinternitzParameter() {
        return this.wotsPlus.getParams().getWinternitzParameter();
    }

    public int getHeight() {
        return this.height;
    }

    /* access modifiers changed from: package-private */
    public WOTSPlus getWOTSPlus() {
        return this.wotsPlus;
    }

    /* access modifiers changed from: package-private */
    public int getK() {
        return this.k;
    }
}
