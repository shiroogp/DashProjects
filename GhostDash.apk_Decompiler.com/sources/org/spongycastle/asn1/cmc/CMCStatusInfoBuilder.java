package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.cmc.CMCStatusInfo;

public class CMCStatusInfoBuilder {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private CMCStatusInfo.OtherInfo otherInfo;
    private DERUTF8String statusString;

    public CMCStatusInfoBuilder(CMCStatus cMCStatus2, BodyPartID bodyPartID) {
        this.cMCStatus = cMCStatus2;
        this.bodyList = new DERSequence((ASN1Encodable) bodyPartID);
    }

    public CMCStatusInfoBuilder(CMCStatus cMCStatus2, BodyPartID[] bodyPartIDArr) {
        this.cMCStatus = cMCStatus2;
        this.bodyList = new DERSequence((ASN1Encodable[]) bodyPartIDArr);
    }

    public CMCStatusInfoBuilder setStatusString(String str) {
        this.statusString = new DERUTF8String(str);
        return this;
    }

    public CMCStatusInfoBuilder setOtherInfo(CMCFailInfo cMCFailInfo) {
        this.otherInfo = new CMCStatusInfo.OtherInfo(cMCFailInfo);
        return this;
    }

    public CMCStatusInfoBuilder setOtherInfo(PendInfo pendInfo) {
        this.otherInfo = new CMCStatusInfo.OtherInfo(pendInfo);
        return this;
    }

    public CMCStatusInfo build() {
        return new CMCStatusInfo(this.cMCStatus, this.bodyList, this.statusString, this.otherInfo);
    }
}
