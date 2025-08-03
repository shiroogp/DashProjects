package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;

public class CMCStatusInfo extends ASN1Object {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private final OtherInfo otherInfo;
    private final DERUTF8String statusString;

    CMCStatusInfo(CMCStatus cMCStatus2, ASN1Sequence aSN1Sequence, DERUTF8String dERUTF8String, OtherInfo otherInfo2) {
        this.cMCStatus = cMCStatus2;
        this.bodyList = aSN1Sequence;
        this.statusString = dERUTF8String;
        this.otherInfo = otherInfo2;
    }

    private CMCStatusInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 4) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.cMCStatus = CMCStatus.getInstance(aSN1Sequence.getObjectAt(0));
        this.bodyList = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 3) {
            this.statusString = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(2));
            this.otherInfo = OtherInfo.getInstance(aSN1Sequence.getObjectAt(3));
        } else if (aSN1Sequence.size() <= 2) {
            this.statusString = null;
            this.otherInfo = null;
        } else if (aSN1Sequence.getObjectAt(2) instanceof DERUTF8String) {
            this.statusString = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(2));
            this.otherInfo = null;
        } else {
            this.statusString = null;
            this.otherInfo = OtherInfo.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static CMCStatusInfo getInstance(Object obj) {
        if (obj instanceof CMCStatusInfo) {
            return (CMCStatusInfo) obj;
        }
        if (obj != null) {
            return new CMCStatusInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.cMCStatus);
        aSN1EncodableVector.add(this.bodyList);
        DERUTF8String dERUTF8String = this.statusString;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        OtherInfo otherInfo2 = this.otherInfo;
        if (otherInfo2 != null) {
            aSN1EncodableVector.add(otherInfo2);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CMCStatus getCMCStatus() {
        return this.cMCStatus;
    }

    public BodyPartID[] getBodyList() {
        return Utils.toBodyPartIDArray(this.bodyList);
    }

    public DERUTF8String getStatusString() {
        return this.statusString;
    }

    public boolean hasOtherInfo() {
        return this.otherInfo != null;
    }

    public OtherInfo getOtherInfo() {
        return this.otherInfo;
    }

    public static class OtherInfo extends ASN1Object implements ASN1Choice {
        private final CMCFailInfo failInfo;
        private final PendInfo pendInfo;

        /* access modifiers changed from: private */
        public static OtherInfo getInstance(Object obj) {
            if (obj instanceof OtherInfo) {
                return (OtherInfo) obj;
            }
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Integer) {
                    return new OtherInfo(CMCFailInfo.getInstance(aSN1Primitive));
                }
                if (aSN1Primitive instanceof ASN1Sequence) {
                    return new OtherInfo(PendInfo.getInstance(aSN1Primitive));
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
        }

        OtherInfo(CMCFailInfo cMCFailInfo) {
            this(cMCFailInfo, (PendInfo) null);
        }

        OtherInfo(PendInfo pendInfo2) {
            this((CMCFailInfo) null, pendInfo2);
        }

        private OtherInfo(CMCFailInfo cMCFailInfo, PendInfo pendInfo2) {
            this.failInfo = cMCFailInfo;
            this.pendInfo = pendInfo2;
        }

        public boolean isFailInfo() {
            return this.failInfo != null;
        }

        public ASN1Primitive toASN1Primitive() {
            PendInfo pendInfo2 = this.pendInfo;
            if (pendInfo2 != null) {
                return pendInfo2.toASN1Primitive();
            }
            return this.failInfo.toASN1Primitive();
        }
    }
}
