package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeySpec implements KeySpec {
    private GF2Matrix g;
    private int n;
    private String oid;
    private int t;

    public McEliecePublicKeySpec(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.n = i;
        this.t = i2;
        this.g = new GF2Matrix(gF2Matrix);
    }

    public McEliecePublicKeySpec(String str, int i, int i2, byte[] bArr) {
        this.oid = str;
        this.n = i2;
        this.t = i;
        this.g = new GF2Matrix(bArr);
    }

    public int getN() {
        return this.n;
    }

    public int getT() {
        return this.t;
    }

    public GF2Matrix getG() {
        return this.g;
    }

    public String getOIDString() {
        return this.oid;
    }
}
