package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McEliecePublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.McEliecePublicKeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcEliecePublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    private McElieceParameters McElieceParams;
    private GF2Matrix g;
    private int n;
    private String oid;
    private int t;

    /* access modifiers changed from: protected */
    public ASN1Primitive getAlgParams() {
        return null;
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    public String getFormat() {
        return null;
    }

    public BCMcEliecePublicKey(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.n = i;
        this.t = i2;
        this.g = gF2Matrix;
    }

    public BCMcEliecePublicKey(McEliecePublicKeySpec mcEliecePublicKeySpec) {
        this(mcEliecePublicKeySpec.getOIDString(), mcEliecePublicKeySpec.getN(), mcEliecePublicKeySpec.getT(), mcEliecePublicKeySpec.getG());
    }

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this(mcEliecePublicKeyParameters.getOIDString(), mcEliecePublicKeyParameters.getN(), mcEliecePublicKeyParameters.getT(), mcEliecePublicKeyParameters.getG());
        this.McElieceParams = mcEliecePublicKeyParameters.getParameters();
    }

    public int getN() {
        return this.n;
    }

    public int getK() {
        return this.g.getNumRows();
    }

    public int getT() {
        return this.t;
    }

    public GF2Matrix getG() {
        return this.g;
    }

    public String toString() {
        return (("McEliecePublicKey:\n" + " length of the code         : " + this.n + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE) + " error correction capability: " + this.t + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE) + " generator matrix           : " + this.g.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
        if (this.n == bCMcEliecePublicKey.n && this.t == bCMcEliecePublicKey.t && this.g.equals(bCMcEliecePublicKey.g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.n + this.t + this.g.hashCode();
    }

    public String getOIDString() {
        return this.oid;
    }

    /* access modifiers changed from: protected */
    public ASN1ObjectIdentifier getOID() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    }

    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(getOID(), DERNull.INSTANCE), (ASN1Encodable) new McEliecePublicKey(new ASN1ObjectIdentifier(this.oid), this.n, this.t, this.g)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public McElieceParameters getMcElieceParameters() {
        return this.McElieceParams;
    }
}
