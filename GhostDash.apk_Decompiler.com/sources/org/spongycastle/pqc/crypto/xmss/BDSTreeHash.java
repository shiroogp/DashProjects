package org.spongycastle.pqc.crypto.xmss;

import java.io.Serializable;

class BDSTreeHash implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean finished = false;
    private int height;
    private final int initialHeight;
    private boolean initialized = false;
    private int nextIndex;
    private XMSSNode tailNode;

    BDSTreeHash(int i) {
        this.initialHeight = i;
    }

    /* access modifiers changed from: package-private */
    public void initialize(int i) {
        this.tailNode = null;
        this.height = this.initialHeight;
        this.nextIndex = i;
        this.initialized = true;
        this.finished = false;
    }

    /* JADX WARNING: type inference failed for: r7v17, types: [org.spongycastle.pqc.crypto.xmss.XMSSAddress] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(java.util.Stack<org.spongycastle.pqc.crypto.xmss.XMSSNode> r5, org.spongycastle.pqc.crypto.xmss.WOTSPlus r6, byte[] r7, byte[] r8, org.spongycastle.pqc.crypto.xmss.OTSHashAddress r9) {
        /*
            r4 = this;
            java.lang.String r0 = "otsHashAddress == null"
            java.util.Objects.requireNonNull(r9, r0)
            boolean r0 = r4.finished
            if (r0 != 0) goto L_0x0219
            boolean r0 = r4.initialized
            if (r0 == 0) goto L_0x0219
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = new org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder
            r0.<init>()
            int r1 = r9.getLayerAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r0 = r0.withLayerAddress(r1)
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = (org.spongycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r0
            long r1 = r9.getTreeAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r0 = r0.withTreeAddress(r1)
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = (org.spongycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r0
            int r1 = r4.nextIndex
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = r0.withOTSAddress(r1)
            int r1 = r9.getChainAddress()
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = r0.withChainAddress(r1)
            int r1 = r9.getHashAddress()
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = r0.withHashAddress(r1)
            int r9 = r9.getKeyAndMask()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r9 = r0.withKeyAndMask(r9)
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r9 = (org.spongycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r9
            org.spongycastle.pqc.crypto.xmss.XMSSAddress r9 = r9.build()
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress r9 = (org.spongycastle.pqc.crypto.xmss.OTSHashAddress) r9
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r0 = new org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder
            r0.<init>()
            int r1 = r9.getLayerAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r0 = r0.withLayerAddress(r1)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r0 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r0
            long r1 = r9.getTreeAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r0 = r0.withTreeAddress(r1)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r0 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r0
            int r1 = r4.nextIndex
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r0 = r0.withLTreeAddress(r1)
            org.spongycastle.pqc.crypto.xmss.XMSSAddress r0 = r0.build()
            org.spongycastle.pqc.crypto.xmss.LTreeAddress r0 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress) r0
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r1 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r1.<init>()
            int r2 = r9.getLayerAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r1 = r1.withLayerAddress(r2)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r1 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r1
            long r2 = r9.getTreeAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r1 = r1.withTreeAddress(r2)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r1 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r1
            int r2 = r4.nextIndex
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r1 = r1.withTreeIndex(r2)
            org.spongycastle.pqc.crypto.xmss.XMSSAddress r1 = r1.build()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r1 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress) r1
            byte[] r8 = r6.getWOTSPlusSecretKey(r8, r9)
            r6.importKeys(r8, r7)
            org.spongycastle.pqc.crypto.xmss.WOTSPlusPublicKeyParameters r7 = r6.getPublicKey(r9)
            org.spongycastle.pqc.crypto.xmss.XMSSNode r7 = org.spongycastle.pqc.crypto.xmss.XMSSNodeUtil.lTree(r6, r7, r0)
        L_0x00a5:
            boolean r8 = r5.isEmpty()
            r9 = 1
            if (r8 != 0) goto L_0x015c
            java.lang.Object r8 = r5.peek()
            org.spongycastle.pqc.crypto.xmss.XMSSNode r8 = (org.spongycastle.pqc.crypto.xmss.XMSSNode) r8
            int r8 = r8.getHeight()
            int r0 = r7.getHeight()
            if (r8 != r0) goto L_0x015c
            java.lang.Object r8 = r5.peek()
            org.spongycastle.pqc.crypto.xmss.XMSSNode r8 = (org.spongycastle.pqc.crypto.xmss.XMSSNode) r8
            int r8 = r8.getHeight()
            int r0 = r4.initialHeight
            if (r8 == r0) goto L_0x015c
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r8.<init>()
            int r0 = r1.getLayerAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r8 = r8.withLayerAddress(r0)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r8
            long r2 = r1.getTreeAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r8 = r8.withTreeAddress(r2)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r8
            int r0 = r1.getTreeHeight()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = r8.withTreeHeight(r0)
            int r0 = r1.getTreeIndex()
            int r0 = r0 - r9
            int r0 = r0 / 2
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = r8.withTreeIndex(r0)
            int r0 = r1.getKeyAndMask()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r8 = r8.withKeyAndMask(r0)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r8
            org.spongycastle.pqc.crypto.xmss.XMSSAddress r8 = r8.build()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r8 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress) r8
            java.lang.Object r0 = r5.pop()
            org.spongycastle.pqc.crypto.xmss.XMSSNode r0 = (org.spongycastle.pqc.crypto.xmss.XMSSNode) r0
            org.spongycastle.pqc.crypto.xmss.XMSSNode r7 = org.spongycastle.pqc.crypto.xmss.XMSSNodeUtil.randomizeHash(r6, r0, r7, r8)
            org.spongycastle.pqc.crypto.xmss.XMSSNode r0 = new org.spongycastle.pqc.crypto.xmss.XMSSNode
            int r1 = r7.getHeight()
            int r1 = r1 + r9
            byte[] r7 = r7.getValue()
            r0.<init>(r1, r7)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r7.<init>()
            int r1 = r8.getLayerAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.withLayerAddress(r1)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r7
            long r1 = r8.getTreeAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.withTreeAddress(r1)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r7
            int r1 = r8.getTreeHeight()
            int r1 = r1 + r9
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = r7.withTreeHeight(r1)
            int r9 = r8.getTreeIndex()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = r7.withTreeIndex(r9)
            int r8 = r8.getKeyAndMask()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.withKeyAndMask(r8)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r7
            org.spongycastle.pqc.crypto.xmss.XMSSAddress r7 = r7.build()
            r1 = r7
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r1 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress) r1
            r7 = r0
            goto L_0x00a5
        L_0x015c:
            org.spongycastle.pqc.crypto.xmss.XMSSNode r8 = r4.tailNode
            if (r8 != 0) goto L_0x0164
            r4.tailNode = r7
            goto L_0x0200
        L_0x0164:
            int r8 = r8.getHeight()
            int r0 = r7.getHeight()
            if (r8 != r0) goto L_0x01fd
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r5.<init>()
            int r8 = r1.getLayerAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.withLayerAddress(r8)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            long r2 = r1.getTreeAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.withTreeAddress(r2)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            int r8 = r1.getTreeHeight()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = r5.withTreeHeight(r8)
            int r8 = r1.getTreeIndex()
            int r8 = r8 - r9
            int r8 = r8 / 2
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = r5.withTreeIndex(r8)
            int r8 = r1.getKeyAndMask()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.withKeyAndMask(r8)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            org.spongycastle.pqc.crypto.xmss.XMSSAddress r5 = r5.build()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r5 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress) r5
            org.spongycastle.pqc.crypto.xmss.XMSSNode r8 = r4.tailNode
            org.spongycastle.pqc.crypto.xmss.XMSSNode r6 = org.spongycastle.pqc.crypto.xmss.XMSSNodeUtil.randomizeHash(r6, r8, r7, r5)
            org.spongycastle.pqc.crypto.xmss.XMSSNode r7 = new org.spongycastle.pqc.crypto.xmss.XMSSNode
            org.spongycastle.pqc.crypto.xmss.XMSSNode r8 = r4.tailNode
            int r8 = r8.getHeight()
            int r8 = r8 + r9
            byte[] r6 = r6.getValue()
            r7.<init>(r8, r6)
            r4.tailNode = r7
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r6.<init>()
            int r8 = r5.getLayerAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r6 = r6.withLayerAddress(r8)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r6
            long r0 = r5.getTreeAddress()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r6 = r6.withTreeAddress(r0)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r6
            int r8 = r5.getTreeHeight()
            int r8 = r8 + r9
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = r6.withTreeHeight(r8)
            int r8 = r5.getTreeIndex()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = r6.withTreeIndex(r8)
            int r5 = r5.getKeyAndMask()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r6.withKeyAndMask(r5)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            org.spongycastle.pqc.crypto.xmss.XMSSAddress r5 = r5.build()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r5 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress) r5
            goto L_0x0200
        L_0x01fd:
            r5.push(r7)
        L_0x0200:
            org.spongycastle.pqc.crypto.xmss.XMSSNode r5 = r4.tailNode
            int r5 = r5.getHeight()
            int r6 = r4.initialHeight
            if (r5 != r6) goto L_0x020d
            r4.finished = r9
            goto L_0x0218
        L_0x020d:
            int r5 = r7.getHeight()
            r4.height = r5
            int r5 = r4.nextIndex
            int r5 = r5 + r9
            r4.nextIndex = r5
        L_0x0218:
            return
        L_0x0219:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "finished or not initialized"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.xmss.BDSTreeHash.update(java.util.Stack, org.spongycastle.pqc.crypto.xmss.WOTSPlus, byte[], byte[], org.spongycastle.pqc.crypto.xmss.OTSHashAddress):void");
    }

    /* access modifiers changed from: package-private */
    public int getHeight() {
        if (!this.initialized || this.finished) {
            return Integer.MAX_VALUE;
        }
        return this.height;
    }

    /* access modifiers changed from: package-private */
    public int getIndexLeaf() {
        return this.nextIndex;
    }

    /* access modifiers changed from: package-private */
    public void setNode(XMSSNode xMSSNode) {
        this.tailNode = xMSSNode;
        int height2 = xMSSNode.getHeight();
        this.height = height2;
        if (height2 == this.initialHeight) {
            this.finished = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isFinished() {
        return this.finished;
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.initialized;
    }

    public XMSSNode getTailNode() {
        return this.tailNode.clone();
    }
}
