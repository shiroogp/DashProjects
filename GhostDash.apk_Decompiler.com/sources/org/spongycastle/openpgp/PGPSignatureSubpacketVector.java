package org.spongycastle.openpgp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.spongycastle.bcpg.SignaturePacket;
import org.spongycastle.bcpg.SignatureSubpacket;
import org.spongycastle.bcpg.sig.Features;
import org.spongycastle.bcpg.sig.IssuerKeyID;
import org.spongycastle.bcpg.sig.KeyExpirationTime;
import org.spongycastle.bcpg.sig.KeyFlags;
import org.spongycastle.bcpg.sig.NotationData;
import org.spongycastle.bcpg.sig.PreferredAlgorithms;
import org.spongycastle.bcpg.sig.PrimaryUserID;
import org.spongycastle.bcpg.sig.SignatureCreationTime;
import org.spongycastle.bcpg.sig.SignatureExpirationTime;
import org.spongycastle.bcpg.sig.SignerUserID;

public class PGPSignatureSubpacketVector {
    SignatureSubpacket[] packets;

    PGPSignatureSubpacketVector(SignatureSubpacket[] signatureSubpacketArr) {
        this.packets = signatureSubpacketArr;
    }

    public SignatureSubpacket getSubpacket(int i) {
        int i2 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                return null;
            }
            if (signatureSubpacketArr[i2].getType() == i) {
                return this.packets[i2];
            }
            i2++;
        }
    }

    public boolean hasSubpacket(int i) {
        return getSubpacket(i) != null;
    }

    public SignatureSubpacket[] getSubpackets(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                return (SignatureSubpacket[]) arrayList.toArray(new SignatureSubpacket[0]);
            }
            if (signatureSubpacketArr[i2].getType() == i) {
                arrayList.add(this.packets[i2]);
            }
            i2++;
        }
    }

    public PGPSignatureList getEmbeddedSignatures() throws PGPException {
        SignatureSubpacket[] subpackets = getSubpackets(32);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < subpackets.length) {
            try {
                arrayList.add(new PGPSignature(SignaturePacket.fromByteArray(subpackets[i].getData())));
                i++;
            } catch (IOException e) {
                throw new PGPException("Unable to parse signature packet: " + e.getMessage(), e);
            }
        }
        return new PGPSignatureList((PGPSignature[]) arrayList.toArray(new PGPSignature[arrayList.size()]));
    }

    public NotationData[] getNotationDataOccurrences() {
        SignatureSubpacket[] subpackets = getSubpackets(20);
        NotationData[] notationDataArr = new NotationData[subpackets.length];
        for (int i = 0; i < subpackets.length; i++) {
            notationDataArr[i] = (NotationData) subpackets[i];
        }
        return notationDataArr;
    }

    public NotationData[] getNotationDataOccurences() {
        return getNotationDataOccurrences();
    }

    public long getIssuerKeyID() {
        SignatureSubpacket subpacket = getSubpacket(16);
        if (subpacket == null) {
            return 0;
        }
        return ((IssuerKeyID) subpacket).getKeyID();
    }

    public Date getSignatureCreationTime() {
        SignatureSubpacket subpacket = getSubpacket(2);
        if (subpacket == null) {
            return null;
        }
        return ((SignatureCreationTime) subpacket).getTime();
    }

    public long getSignatureExpirationTime() {
        SignatureSubpacket subpacket = getSubpacket(3);
        if (subpacket == null) {
            return 0;
        }
        return ((SignatureExpirationTime) subpacket).getTime();
    }

    public long getKeyExpirationTime() {
        SignatureSubpacket subpacket = getSubpacket(9);
        if (subpacket == null) {
            return 0;
        }
        return ((KeyExpirationTime) subpacket).getTime();
    }

    public int[] getPreferredHashAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(21);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public int[] getPreferredSymmetricAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(11);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public int[] getPreferredCompressionAlgorithms() {
        SignatureSubpacket subpacket = getSubpacket(22);
        if (subpacket == null) {
            return null;
        }
        return ((PreferredAlgorithms) subpacket).getPreferences();
    }

    public int getKeyFlags() {
        SignatureSubpacket subpacket = getSubpacket(27);
        if (subpacket == null) {
            return 0;
        }
        return ((KeyFlags) subpacket).getFlags();
    }

    public String getSignerUserID() {
        SignatureSubpacket subpacket = getSubpacket(28);
        if (subpacket == null) {
            return null;
        }
        return ((SignerUserID) subpacket).getID();
    }

    public boolean isPrimaryUserID() {
        PrimaryUserID primaryUserID = (PrimaryUserID) getSubpacket(25);
        if (primaryUserID != null) {
            return primaryUserID.isPrimaryUserID();
        }
        return false;
    }

    public int[] getCriticalTags() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.packets;
            if (i2 == signatureSubpacketArr.length) {
                break;
            }
            if (signatureSubpacketArr[i2].isCritical()) {
                i3++;
            }
            i2++;
        }
        int[] iArr = new int[i3];
        int i4 = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr2 = this.packets;
            if (i == signatureSubpacketArr2.length) {
                return iArr;
            }
            if (signatureSubpacketArr2[i].isCritical()) {
                iArr[i4] = this.packets[i].getType();
                i4++;
            }
            i++;
        }
    }

    public Features getFeatures() {
        SignatureSubpacket subpacket = getSubpacket(30);
        if (subpacket == null) {
            return null;
        }
        return new Features(subpacket.isCritical(), subpacket.isLongLength(), subpacket.getData());
    }

    public int size() {
        return this.packets.length;
    }

    /* access modifiers changed from: package-private */
    public SignatureSubpacket[] toSubpacketArray() {
        return this.packets;
    }
}
