package org.spongycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.math.ec.ECPoint;

public abstract class ECPublicBCPGKey extends BCPGObject implements BCPGKey {
    ASN1ObjectIdentifier oid;
    BigInteger point;

    public String getFormat() {
        return "PGP";
    }

    protected ECPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.oid = ASN1ObjectIdentifier.getInstance(ASN1Primitive.fromByteArray(readBytesOfEncodedLength(bCPGInputStream)));
        this.point = new MPInteger(bCPGInputStream).getValue();
    }

    protected ECPublicBCPGKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, ECPoint eCPoint) {
        this.point = new BigInteger(1, eCPoint.getEncoded());
        this.oid = aSN1ObjectIdentifier;
    }

    protected ECPublicBCPGKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, BigInteger bigInteger) throws IOException {
        this.point = bigInteger;
        this.oid = aSN1ObjectIdentifier;
    }

    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        byte[] encoded = this.oid.getEncoded();
        bCPGOutputStream.write(encoded, 1, encoded.length - 1);
        bCPGOutputStream.writeObject(new MPInteger(this.point));
    }

    public BigInteger getEncodedPoint() {
        return this.point;
    }

    public ASN1ObjectIdentifier getCurveOID() {
        return this.oid;
    }

    protected static byte[] readBytesOfEncodedLength(BCPGInputStream bCPGInputStream) throws IOException {
        int read = bCPGInputStream.read();
        if (read == 0 || read == 255) {
            throw new IOException("future extensions not yet implemented.");
        }
        int i = read + 2;
        byte[] bArr = new byte[i];
        bCPGInputStream.readFully(bArr, 2, i - 2);
        bArr[0] = 6;
        bArr[1] = (byte) read;
        return bArr;
    }
}
