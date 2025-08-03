package org.spongycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.bcpg.BCPGKey;
import org.spongycastle.bcpg.BCPGOutputStream;
import org.spongycastle.bcpg.ContainedPacket;
import org.spongycastle.bcpg.DSAPublicBCPGKey;
import org.spongycastle.bcpg.ECPublicBCPGKey;
import org.spongycastle.bcpg.ElGamalPublicBCPGKey;
import org.spongycastle.bcpg.PublicKeyAlgorithmTags;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.bcpg.RSAPublicBCPGKey;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.bcpg.UserAttributePacket;
import org.spongycastle.bcpg.UserIDPacket;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.util.Arrays;

public class PGPPublicKey implements PublicKeyAlgorithmTags {
    private static final int[] MASTER_KEY_CERTIFICATION_TYPES = {19, 18, 17, 16};
    private byte[] fingerprint;
    List idSigs = new ArrayList();
    List idTrusts = new ArrayList();
    List ids = new ArrayList();
    private long keyID;
    List keySigs = new ArrayList();
    private int keyStrength;
    PublicKeyPacket publicPk;
    List subSigs = null;
    TrustPacket trustPk;

    private void init(KeyFingerPrintCalculator keyFingerPrintCalculator) throws PGPException {
        BCPGKey key = this.publicPk.getKey();
        this.fingerprint = keyFingerPrintCalculator.calculateFingerprint(this.publicPk);
        if (this.publicPk.getVersion() <= 3) {
            RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
            this.keyID = rSAPublicBCPGKey.getModulus().longValue();
            this.keyStrength = rSAPublicBCPGKey.getModulus().bitLength();
            return;
        }
        byte[] bArr = this.fingerprint;
        this.keyID = (((long) (bArr[bArr.length - 3] & UByte.MAX_VALUE)) << 16) | (((long) (bArr[bArr.length - 8] & UByte.MAX_VALUE)) << 56) | (((long) (bArr[bArr.length - 7] & UByte.MAX_VALUE)) << 48) | (((long) (bArr[bArr.length - 6] & UByte.MAX_VALUE)) << 40) | (((long) (bArr[bArr.length - 5] & UByte.MAX_VALUE)) << 32) | (((long) (bArr[bArr.length - 4] & UByte.MAX_VALUE)) << 24) | (((long) (bArr[bArr.length - 2] & UByte.MAX_VALUE)) << 8) | ((long) (bArr[bArr.length - 1] & UByte.MAX_VALUE));
        if (key instanceof RSAPublicBCPGKey) {
            this.keyStrength = ((RSAPublicBCPGKey) key).getModulus().bitLength();
        } else if (key instanceof DSAPublicBCPGKey) {
            this.keyStrength = ((DSAPublicBCPGKey) key).getP().bitLength();
        } else if (key instanceof ElGamalPublicBCPGKey) {
            this.keyStrength = ((ElGamalPublicBCPGKey) key).getP().bitLength();
        } else if (key instanceof ECPublicBCPGKey) {
            this.keyStrength = ECNamedCurveTable.getByOID(((ECPublicBCPGKey) key).getCurveOID()).getCurve().getFieldSize();
        }
    }

    public PGPPublicKey(PublicKeyPacket publicKeyPacket, KeyFingerPrintCalculator keyFingerPrintCalculator) throws PGPException {
        this.publicPk = publicKeyPacket;
        this.ids = new ArrayList();
        this.idSigs = new ArrayList();
        init(keyFingerPrintCalculator);
    }

    PGPPublicKey(PublicKeyPacket publicKeyPacket, TrustPacket trustPacket, List list, KeyFingerPrintCalculator keyFingerPrintCalculator) throws PGPException {
        this.publicPk = publicKeyPacket;
        this.trustPk = trustPacket;
        this.subSigs = list;
        init(keyFingerPrintCalculator);
    }

    PGPPublicKey(PGPPublicKey pGPPublicKey, TrustPacket trustPacket, List list) {
        this.publicPk = pGPPublicKey.publicPk;
        this.trustPk = trustPacket;
        this.subSigs = list;
        this.fingerprint = pGPPublicKey.fingerprint;
        this.keyID = pGPPublicKey.keyID;
        this.keyStrength = pGPPublicKey.keyStrength;
    }

    PGPPublicKey(PGPPublicKey pGPPublicKey) {
        this.publicPk = pGPPublicKey.publicPk;
        this.keySigs = new ArrayList(pGPPublicKey.keySigs);
        this.ids = new ArrayList(pGPPublicKey.ids);
        this.idTrusts = new ArrayList(pGPPublicKey.idTrusts);
        this.idSigs = new ArrayList(pGPPublicKey.idSigs.size());
        for (int i = 0; i != pGPPublicKey.idSigs.size(); i++) {
            this.idSigs.add(new ArrayList((ArrayList) pGPPublicKey.idSigs.get(i)));
        }
        if (pGPPublicKey.subSigs != null) {
            this.subSigs = new ArrayList(pGPPublicKey.subSigs.size());
            for (int i2 = 0; i2 != pGPPublicKey.subSigs.size(); i2++) {
                this.subSigs.add(pGPPublicKey.subSigs.get(i2));
            }
        }
        this.fingerprint = pGPPublicKey.fingerprint;
        this.keyID = pGPPublicKey.keyID;
        this.keyStrength = pGPPublicKey.keyStrength;
    }

    PGPPublicKey(PublicKeyPacket publicKeyPacket, TrustPacket trustPacket, List list, List list2, List list3, List list4, KeyFingerPrintCalculator keyFingerPrintCalculator) throws PGPException {
        this.publicPk = publicKeyPacket;
        this.trustPk = trustPacket;
        this.keySigs = list;
        this.ids = list2;
        this.idTrusts = list3;
        this.idSigs = list4;
        init(keyFingerPrintCalculator);
    }

    public int getVersion() {
        return this.publicPk.getVersion();
    }

    public Date getCreationTime() {
        return this.publicPk.getTime();
    }

    public int getValidDays() {
        if (this.publicPk.getVersion() <= 3) {
            return this.publicPk.getValidDays();
        }
        int validSeconds = (int) (getValidSeconds() / 86400);
        if (getValidSeconds() % 86400 <= 0 || validSeconds != 0) {
            return validSeconds;
        }
        return 1;
    }

    public byte[] getTrustData() {
        TrustPacket trustPacket = this.trustPk;
        if (trustPacket == null) {
            return null;
        }
        return Arrays.clone(trustPacket.getLevelAndTrustAmount());
    }

    public long getValidSeconds() {
        if (this.publicPk.getVersion() <= 3) {
            return ((long) this.publicPk.getValidDays()) * 24 * 60 * 60;
        }
        int i = 0;
        if (isMasterKey()) {
            while (true) {
                int[] iArr = MASTER_KEY_CERTIFICATION_TYPES;
                if (i == iArr.length) {
                    break;
                }
                long expirationTimeFromSig = getExpirationTimeFromSig(true, iArr[i]);
                if (expirationTimeFromSig >= 0) {
                    return expirationTimeFromSig;
                }
                i++;
            }
        } else {
            long expirationTimeFromSig2 = getExpirationTimeFromSig(false, 24);
            if (expirationTimeFromSig2 >= 0) {
                return expirationTimeFromSig2;
            }
        }
        return 0;
    }

    private long getExpirationTimeFromSig(boolean z, int i) {
        Iterator signaturesOfType = getSignaturesOfType(i);
        long j = -1;
        while (signaturesOfType.hasNext()) {
            PGPSignature pGPSignature = (PGPSignature) signaturesOfType.next();
            if (!z || pGPSignature.getKeyID() == getKeyID()) {
                PGPSignatureSubpacketVector hashedSubPackets = pGPSignature.getHashedSubPackets();
                if (hashedSubPackets == null) {
                    return 0;
                }
                long keyExpirationTime = hashedSubPackets.getKeyExpirationTime();
                if (keyExpirationTime == 0 || keyExpirationTime > j) {
                    j = keyExpirationTime;
                }
            }
        }
        return j;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public byte[] getFingerprint() {
        byte[] bArr = this.fingerprint;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean isEncryptionKey() {
        int algorithm = this.publicPk.getAlgorithm();
        return algorithm == 1 || algorithm == 2 || algorithm == 16 || algorithm == 20 || algorithm == 18;
    }

    public boolean isMasterKey() {
        return this.subSigs == null;
    }

    public int getAlgorithm() {
        return this.publicPk.getAlgorithm();
    }

    public int getBitStrength() {
        return this.keyStrength;
    }

    public Iterator getUserIDs() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.ids.size(); i++) {
            if (this.ids.get(i) instanceof UserIDPacket) {
                arrayList.add(((UserIDPacket) this.ids.get(i)).getID());
            }
        }
        return arrayList.iterator();
    }

    public Iterator getRawUserIDs() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.ids.size(); i++) {
            if (this.ids.get(i) instanceof UserIDPacket) {
                arrayList.add(((UserIDPacket) this.ids.get(i)).getRawID());
            }
        }
        return arrayList.iterator();
    }

    public Iterator getUserAttributes() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.ids.size(); i++) {
            if (this.ids.get(i) instanceof PGPUserAttributeSubpacketVector) {
                arrayList.add(this.ids.get(i));
            }
        }
        return arrayList.iterator();
    }

    public Iterator getSignaturesForID(String str) {
        return getSignaturesForID(new UserIDPacket(str));
    }

    public Iterator getSignaturesForID(byte[] bArr) {
        return getSignaturesForID(new UserIDPacket(bArr));
    }

    private Iterator getSignaturesForID(UserIDPacket userIDPacket) {
        for (int i = 0; i != this.ids.size(); i++) {
            if (userIDPacket.equals(this.ids.get(i))) {
                return ((ArrayList) this.idSigs.get(i)).iterator();
            }
        }
        return null;
    }

    public Iterator getSignaturesForUserAttribute(PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector) {
        for (int i = 0; i != this.ids.size(); i++) {
            if (pGPUserAttributeSubpacketVector.equals(this.ids.get(i))) {
                return ((ArrayList) this.idSigs.get(i)).iterator();
            }
        }
        return null;
    }

    public Iterator getSignaturesOfType(int i) {
        ArrayList arrayList = new ArrayList();
        Iterator signatures = getSignatures();
        while (signatures.hasNext()) {
            PGPSignature pGPSignature = (PGPSignature) signatures.next();
            if (pGPSignature.getSignatureType() == i) {
                arrayList.add(pGPSignature);
            }
        }
        return arrayList.iterator();
    }

    public Iterator getSignatures() {
        List list = this.subSigs;
        if (list != null) {
            return list.iterator();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.keySigs);
        for (int i = 0; i != this.idSigs.size(); i++) {
            arrayList.addAll((Collection) this.idSigs.get(i));
        }
        return arrayList.iterator();
    }

    public Iterator getKeySignatures() {
        List list = this.subSigs;
        if (list != null) {
            return list.iterator();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.keySigs);
        return arrayList.iterator();
    }

    public PublicKeyPacket getPublicKeyPacket() {
        return this.publicPk;
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void encode(OutputStream outputStream) throws IOException {
        BCPGOutputStream bCPGOutputStream;
        if (outputStream instanceof BCPGOutputStream) {
            bCPGOutputStream = (BCPGOutputStream) outputStream;
        } else {
            bCPGOutputStream = new BCPGOutputStream(outputStream);
        }
        bCPGOutputStream.writePacket(this.publicPk);
        TrustPacket trustPacket = this.trustPk;
        if (trustPacket != null) {
            bCPGOutputStream.writePacket(trustPacket);
        }
        if (this.subSigs == null) {
            for (int i = 0; i != this.keySigs.size(); i++) {
                ((PGPSignature) this.keySigs.get(i)).encode(bCPGOutputStream);
            }
            for (int i2 = 0; i2 != this.ids.size(); i2++) {
                if (this.ids.get(i2) instanceof UserIDPacket) {
                    bCPGOutputStream.writePacket((UserIDPacket) this.ids.get(i2));
                } else {
                    bCPGOutputStream.writePacket(new UserAttributePacket(((PGPUserAttributeSubpacketVector) this.ids.get(i2)).toSubpacketArray()));
                }
                if (this.idTrusts.get(i2) != null) {
                    bCPGOutputStream.writePacket((ContainedPacket) this.idTrusts.get(i2));
                }
                List list = (List) this.idSigs.get(i2);
                for (int i3 = 0; i3 != list.size(); i3++) {
                    ((PGPSignature) list.get(i3)).encode(bCPGOutputStream);
                }
            }
            return;
        }
        for (int i4 = 0; i4 != this.subSigs.size(); i4++) {
            ((PGPSignature) this.subSigs.get(i4)).encode(bCPGOutputStream);
        }
    }

    public boolean isRevoked() {
        return hasRevocation();
    }

    public boolean hasRevocation() {
        boolean z = false;
        if (isMasterKey()) {
            int i = 0;
            while (!z && i < this.keySigs.size()) {
                int i2 = i + 1;
                if (((PGPSignature) this.keySigs.get(i)).getSignatureType() == 32) {
                    z = true;
                }
                i = i2;
            }
        } else {
            int i3 = 0;
            while (!z && i3 < this.subSigs.size()) {
                int i4 = i3 + 1;
                if (((PGPSignature) this.subSigs.get(i3)).getSignatureType() == 40) {
                    z = true;
                }
                i3 = i4;
            }
        }
        return z;
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, byte[] bArr, PGPSignature pGPSignature) {
        return addCert(pGPPublicKey, new UserIDPacket(bArr), pGPSignature);
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, String str, PGPSignature pGPSignature) {
        return addCert(pGPPublicKey, new UserIDPacket(str), pGPSignature);
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPSignature pGPSignature) {
        return addCert(pGPPublicKey, pGPUserAttributeSubpacketVector, pGPSignature);
    }

    private static PGPPublicKey addCert(PGPPublicKey pGPPublicKey, Object obj, PGPSignature pGPSignature) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = null;
        for (int i = 0; i != pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                list = (List) pGPPublicKey2.idSigs.get(i);
            }
        }
        if (list != null) {
            list.add(pGPSignature);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(pGPSignature);
            pGPPublicKey2.ids.add(obj);
            pGPPublicKey2.idTrusts.add((Object) null);
            pGPPublicKey2.idSigs.add(arrayList);
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector) {
        return removeCert(pGPPublicKey, pGPUserAttributeSubpacketVector);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, String str) {
        return removeCert(pGPPublicKey, new UserIDPacket(str));
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, byte[] bArr) {
        return removeCert(pGPPublicKey, new UserIDPacket(bArr));
    }

    private static PGPPublicKey removeCert(PGPPublicKey pGPPublicKey, Object obj) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        boolean z = false;
        for (int i = 0; i < pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                pGPPublicKey2.ids.remove(i);
                pGPPublicKey2.idTrusts.remove(i);
                pGPPublicKey2.idSigs.remove(i);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, byte[] bArr, PGPSignature pGPSignature) {
        return removeCert(pGPPublicKey, new UserIDPacket(bArr), pGPSignature);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, String str, PGPSignature pGPSignature) {
        return removeCert(pGPPublicKey, new UserIDPacket(str), pGPSignature);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPSignature pGPSignature) {
        return removeCert(pGPPublicKey, pGPUserAttributeSubpacketVector, pGPSignature);
    }

    private static PGPPublicKey removeCert(PGPPublicKey pGPPublicKey, Object obj, PGPSignature pGPSignature) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        boolean z = false;
        for (int i = 0; i < pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                z = ((List) pGPPublicKey2.idSigs.get(i)).remove(pGPSignature);
            }
        }
        if (!z) {
            return null;
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, PGPSignature pGPSignature) {
        if (pGPPublicKey.isMasterKey()) {
            if (pGPSignature.getSignatureType() == 40) {
                throw new IllegalArgumentException("signature type incorrect for master key revocation.");
            }
        } else if (pGPSignature.getSignatureType() == 32) {
            throw new IllegalArgumentException("signature type incorrect for sub-key revocation.");
        }
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = pGPPublicKey2.subSigs;
        if (list != null) {
            list.add(pGPSignature);
        } else {
            pGPPublicKey2.keySigs.add(pGPSignature);
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPSignature pGPSignature) {
        boolean z;
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = pGPPublicKey2.subSigs;
        if (list != null) {
            z = list.remove(pGPSignature);
        } else {
            z = pGPPublicKey2.keySigs.remove(pGPSignature);
        }
        if (!z) {
            Iterator userIDs = pGPPublicKey.getUserIDs();
            while (userIDs.hasNext()) {
                UserIDPacket userIDPacket = (UserIDPacket) userIDs.next();
                Iterator signaturesForID = pGPPublicKey.getSignaturesForID(userIDPacket);
                while (signaturesForID.hasNext()) {
                    if (pGPSignature == signaturesForID.next()) {
                        z = true;
                        pGPPublicKey2 = removeCertification(pGPPublicKey2, userIDPacket.getRawID(), pGPSignature);
                    }
                }
            }
            if (!z) {
                Iterator userAttributes = pGPPublicKey.getUserAttributes();
                while (userAttributes.hasNext()) {
                    PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector = (PGPUserAttributeSubpacketVector) userAttributes.next();
                    Iterator signaturesForUserAttribute = pGPPublicKey.getSignaturesForUserAttribute(pGPUserAttributeSubpacketVector);
                    while (signaturesForUserAttribute.hasNext()) {
                        if (pGPSignature == signaturesForUserAttribute.next()) {
                            pGPPublicKey2 = removeCertification(pGPPublicKey2, pGPUserAttributeSubpacketVector, pGPSignature);
                        }
                    }
                }
            }
        }
        return pGPPublicKey2;
    }
}
