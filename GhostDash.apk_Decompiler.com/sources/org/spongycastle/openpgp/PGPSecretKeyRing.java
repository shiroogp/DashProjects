package org.spongycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.PublicSubkeyPacket;
import org.spongycastle.bcpg.SecretKeyPacket;
import org.spongycastle.bcpg.SecretSubkeyPacket;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.spongycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.spongycastle.util.Iterable;

public class PGPSecretKeyRing extends PGPKeyRing implements Iterable<PGPSecretKey> {
    List extraPubKeys;
    List keys;

    PGPSecretKeyRing(List list) {
        this(list, (List) new ArrayList());
    }

    private PGPSecretKeyRing(List list, List list2) {
        this.keys = list;
        this.extraPubKeys = list2;
    }

    public PGPSecretKeyRing(byte[] bArr, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException, PGPException {
        this((InputStream) new ByteArrayInputStream(bArr), keyFingerPrintCalculator);
    }

    public PGPSecretKeyRing(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException, PGPException {
        KeyFingerPrintCalculator keyFingerPrintCalculator2 = keyFingerPrintCalculator;
        this.keys = new ArrayList();
        this.extraPubKeys = new ArrayList();
        BCPGInputStream wrap = wrap(inputStream);
        int nextPacketTag = wrap.nextPacketTag();
        if (nextPacketTag == 5 || nextPacketTag == 7) {
            SecretKeyPacket secretKeyPacket = (SecretKeyPacket) wrap.readPacket();
            while (wrap.nextPacketTag() == 61) {
                wrap.readPacket();
            }
            TrustPacket readOptionalTrustPacket = readOptionalTrustPacket(wrap);
            List readSignaturesAndTrust = readSignaturesAndTrust(wrap);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            readUserIDs(wrap, arrayList, arrayList2, arrayList3);
            List list = this.keys;
            PGPPublicKey pGPPublicKey = r1;
            PGPPublicKey pGPPublicKey2 = new PGPPublicKey(secretKeyPacket.getPublicKeyPacket(), readOptionalTrustPacket, readSignaturesAndTrust, arrayList, arrayList2, arrayList3, keyFingerPrintCalculator);
            list.add(new PGPSecretKey(secretKeyPacket, pGPPublicKey));
            while (true) {
                if (wrap.nextPacketTag() != 7 && wrap.nextPacketTag() != 14) {
                    return;
                }
                if (wrap.nextPacketTag() == 7) {
                    SecretSubkeyPacket secretSubkeyPacket = (SecretSubkeyPacket) wrap.readPacket();
                    while (wrap.nextPacketTag() == 61) {
                        wrap.readPacket();
                    }
                    this.keys.add(new PGPSecretKey(secretSubkeyPacket, new PGPPublicKey(secretSubkeyPacket.getPublicKeyPacket(), readOptionalTrustPacket(wrap), readSignaturesAndTrust(wrap), keyFingerPrintCalculator2)));
                } else {
                    this.extraPubKeys.add(new PGPPublicKey((PublicSubkeyPacket) wrap.readPacket(), readOptionalTrustPacket(wrap), readSignaturesAndTrust(wrap), keyFingerPrintCalculator2));
                }
            }
        } else {
            throw new IOException("secret key ring doesn't start with secret key tag: tag 0x" + Integer.toHexString(nextPacketTag));
        }
    }

    public PGPPublicKey getPublicKey() {
        return ((PGPSecretKey) this.keys.get(0)).getPublicKey();
    }

    public PGPPublicKey getPublicKey(long j) {
        PGPSecretKey secretKey = getSecretKey(j);
        if (secretKey != null) {
            return secretKey.getPublicKey();
        }
        for (int i = 0; i != this.extraPubKeys.size(); i++) {
            PGPPublicKey pGPPublicKey = (PGPPublicKey) this.keys.get(i);
            if (j == pGPPublicKey.getKeyID()) {
                return pGPPublicKey;
            }
        }
        return null;
    }

    public Iterator<PGPPublicKey> getPublicKeys() {
        ArrayList arrayList = new ArrayList();
        Iterator<PGPSecretKey> secretKeys = getSecretKeys();
        while (secretKeys.hasNext()) {
            arrayList.add(secretKeys.next().getPublicKey());
        }
        arrayList.addAll(this.extraPubKeys);
        return Collections.unmodifiableList(arrayList).iterator();
    }

    public PGPSecretKey getSecretKey() {
        return (PGPSecretKey) this.keys.get(0);
    }

    public Iterator<PGPSecretKey> getSecretKeys() {
        return Collections.unmodifiableList(this.keys).iterator();
    }

    public PGPSecretKey getSecretKey(long j) {
        for (int i = 0; i != this.keys.size(); i++) {
            PGPSecretKey pGPSecretKey = (PGPSecretKey) this.keys.get(i);
            if (j == pGPSecretKey.getKeyID()) {
                return pGPSecretKey;
            }
        }
        return null;
    }

    public Iterator<PGPPublicKey> getExtraPublicKeys() {
        return this.extraPubKeys.iterator();
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void encode(OutputStream outputStream) throws IOException {
        for (int i = 0; i != this.keys.size(); i++) {
            ((PGPSecretKey) this.keys.get(i)).encode(outputStream);
        }
        for (int i2 = 0; i2 != this.extraPubKeys.size(); i2++) {
            ((PGPPublicKey) this.extraPubKeys.get(i2)).encode(outputStream);
        }
    }

    public Iterator<PGPSecretKey> iterator() {
        return getSecretKeys();
    }

    public static PGPSecretKeyRing replacePublicKeys(PGPSecretKeyRing pGPSecretKeyRing, PGPPublicKeyRing pGPPublicKeyRing) {
        ArrayList arrayList = new ArrayList(pGPSecretKeyRing.keys.size());
        for (PGPSecretKey pGPSecretKey : pGPSecretKeyRing.keys) {
            arrayList.add(PGPSecretKey.replacePublicKey(pGPSecretKey, pGPPublicKeyRing.getPublicKey(pGPSecretKey.getKeyID())));
        }
        return new PGPSecretKeyRing(arrayList);
    }

    public static PGPSecretKeyRing copyWithNewPassword(PGPSecretKeyRing pGPSecretKeyRing, PBESecretKeyDecryptor pBESecretKeyDecryptor, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        ArrayList arrayList = new ArrayList(pGPSecretKeyRing.keys.size());
        Iterator<PGPSecretKey> secretKeys = pGPSecretKeyRing.getSecretKeys();
        while (secretKeys.hasNext()) {
            PGPSecretKey next = secretKeys.next();
            if (next.isPrivateKeyEmpty()) {
                arrayList.add(next);
            } else {
                arrayList.add(PGPSecretKey.copyWithNewPassword(next, pBESecretKeyDecryptor, pBESecretKeyEncryptor));
            }
        }
        return new PGPSecretKeyRing((List) arrayList, pGPSecretKeyRing.extraPubKeys);
    }

    public static PGPSecretKeyRing insertSecretKey(PGPSecretKeyRing pGPSecretKeyRing, PGPSecretKey pGPSecretKey) {
        ArrayList arrayList = new ArrayList(pGPSecretKeyRing.keys);
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i != arrayList.size(); i++) {
            PGPSecretKey pGPSecretKey2 = (PGPSecretKey) arrayList.get(i);
            if (pGPSecretKey2.getKeyID() == pGPSecretKey.getKeyID()) {
                arrayList.set(i, pGPSecretKey);
                z = true;
            }
            if (pGPSecretKey2.isMasterKey()) {
                z2 = true;
            }
        }
        if (!z) {
            if (!pGPSecretKey.isMasterKey()) {
                arrayList.add(pGPSecretKey);
            } else if (!z2) {
                arrayList.add(0, pGPSecretKey);
            } else {
                throw new IllegalArgumentException("cannot add a master key to a ring that already has one");
            }
        }
        return new PGPSecretKeyRing((List) arrayList, pGPSecretKeyRing.extraPubKeys);
    }

    public static PGPSecretKeyRing removeSecretKey(PGPSecretKeyRing pGPSecretKeyRing, PGPSecretKey pGPSecretKey) {
        ArrayList arrayList = new ArrayList(pGPSecretKeyRing.keys);
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((PGPSecretKey) arrayList.get(i)).getKeyID() == pGPSecretKey.getKeyID()) {
                arrayList.remove(i);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return new PGPSecretKeyRing((List) arrayList, pGPSecretKeyRing.extraPubKeys);
    }
}
