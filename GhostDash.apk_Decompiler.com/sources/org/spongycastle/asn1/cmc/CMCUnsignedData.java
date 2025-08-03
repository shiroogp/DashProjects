package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class CMCUnsignedData extends ASN1Object {
    private final BodyPartPath bodyPartPath;
    private final ASN1Encodable content;
    private final ASN1ObjectIdentifier identifier;

    public CMCUnsignedData(BodyPartPath bodyPartPath2, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.bodyPartPath = bodyPartPath2;
        this.identifier = aSN1ObjectIdentifier;
        this.content = aSN1Encodable;
    }

    private CMCUnsignedData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.bodyPartPath = BodyPartPath.getInstance(aSN1Sequence.getObjectAt(0));
            this.identifier = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.content = aSN1Sequence.getObjectAt(2);
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static CMCUnsignedData getInstance(Object obj) {
        if (obj instanceof CMCUnsignedData) {
            return (CMCUnsignedData) obj;
        }
        if (obj != null) {
            return new CMCUnsignedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.bodyPartPath);
        aSN1EncodableVector.add(this.identifier);
        aSN1EncodableVector.add(this.content);
        return new DERSequence(aSN1EncodableVector);
    }

    public BodyPartPath getBodyPartPath() {
        return this.bodyPartPath;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.identifier;
    }

    public ASN1Encodable getContent() {
        return this.content;
    }
}
