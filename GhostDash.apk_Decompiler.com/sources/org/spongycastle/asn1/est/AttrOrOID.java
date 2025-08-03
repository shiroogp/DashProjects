package org.spongycastle.asn1.est;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.Attribute;

public class AttrOrOID extends ASN1Object implements ASN1Choice {
    private final Attribute attribute;
    private final ASN1ObjectIdentifier oid;

    public AttrOrOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.oid = aSN1ObjectIdentifier;
        this.attribute = null;
    }

    public AttrOrOID(Attribute attribute2) {
        this.oid = null;
        this.attribute = attribute2;
    }

    public static AttrOrOID getInstance(Object obj) {
        if (obj instanceof AttrOrOID) {
            return (AttrOrOID) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                return new AttrOrOID(ASN1ObjectIdentifier.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                return new AttrOrOID(Attribute.getInstance(aSN1Primitive));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
        }
    }

    public boolean isOid() {
        return this.oid != null;
    }

    public ASN1ObjectIdentifier getOid() {
        return this.oid;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.oid;
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        return this.attribute.toASN1Primitive();
    }
}
