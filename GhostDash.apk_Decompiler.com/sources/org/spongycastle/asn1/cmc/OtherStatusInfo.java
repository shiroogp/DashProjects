package org.spongycastle.asn1.cmc;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

public class OtherStatusInfo extends ASN1Object implements ASN1Choice {
    private final ExtendedFailInfo extendedFailInfo;
    private final CMCFailInfo failInfo;
    private final PendInfo pendInfo;

    public static OtherStatusInfo getInstance(Object obj) {
        if (obj instanceof OtherStatusInfo) {
            return (OtherStatusInfo) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Integer) {
                return new OtherStatusInfo(CMCFailInfo.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                if (((ASN1Sequence) aSN1Primitive).getObjectAt(0) instanceof ASN1ObjectIdentifier) {
                    return new OtherStatusInfo(ExtendedFailInfo.getInstance(aSN1Primitive));
                }
                return new OtherStatusInfo(PendInfo.getInstance(aSN1Primitive));
            }
        } else if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("parsing error: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    OtherStatusInfo(CMCFailInfo cMCFailInfo) {
        this(cMCFailInfo, (PendInfo) null, (ExtendedFailInfo) null);
    }

    OtherStatusInfo(PendInfo pendInfo2) {
        this((CMCFailInfo) null, pendInfo2, (ExtendedFailInfo) null);
    }

    OtherStatusInfo(ExtendedFailInfo extendedFailInfo2) {
        this((CMCFailInfo) null, (PendInfo) null, extendedFailInfo2);
    }

    private OtherStatusInfo(CMCFailInfo cMCFailInfo, PendInfo pendInfo2, ExtendedFailInfo extendedFailInfo2) {
        this.failInfo = cMCFailInfo;
        this.pendInfo = pendInfo2;
        this.extendedFailInfo = extendedFailInfo2;
    }

    public boolean isPendingInfo() {
        return this.pendInfo != null;
    }

    public boolean isFailInfo() {
        return this.failInfo != null;
    }

    public boolean isExtendedFailInfo() {
        return this.extendedFailInfo != null;
    }

    public ASN1Primitive toASN1Primitive() {
        PendInfo pendInfo2 = this.pendInfo;
        if (pendInfo2 != null) {
            return pendInfo2.toASN1Primitive();
        }
        CMCFailInfo cMCFailInfo = this.failInfo;
        if (cMCFailInfo != null) {
            return cMCFailInfo.toASN1Primitive();
        }
        return this.extendedFailInfo.toASN1Primitive();
    }
}
