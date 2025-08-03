package org.spongycastle.openpgp;

import java.util.Iterator;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Iterable;

public class PGPOnePassSignatureList implements Iterable<PGPOnePassSignature> {
    PGPOnePassSignature[] sigs;

    public PGPOnePassSignatureList(PGPOnePassSignature[] pGPOnePassSignatureArr) {
        PGPOnePassSignature[] pGPOnePassSignatureArr2 = new PGPOnePassSignature[pGPOnePassSignatureArr.length];
        this.sigs = pGPOnePassSignatureArr2;
        System.arraycopy(pGPOnePassSignatureArr, 0, pGPOnePassSignatureArr2, 0, pGPOnePassSignatureArr.length);
    }

    public PGPOnePassSignatureList(PGPOnePassSignature pGPOnePassSignature) {
        PGPOnePassSignature[] pGPOnePassSignatureArr = new PGPOnePassSignature[1];
        this.sigs = pGPOnePassSignatureArr;
        pGPOnePassSignatureArr[0] = pGPOnePassSignature;
    }

    public PGPOnePassSignature get(int i) {
        return this.sigs[i];
    }

    public int size() {
        return this.sigs.length;
    }

    public boolean isEmpty() {
        return this.sigs.length == 0;
    }

    public Iterator<PGPOnePassSignature> iterator() {
        return new Arrays.Iterator(this.sigs);
    }
}
