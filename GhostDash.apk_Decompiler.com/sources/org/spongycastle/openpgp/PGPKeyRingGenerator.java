package org.spongycastle.openpgp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.bcpg.PublicSubkeyPacket;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.spongycastle.openpgp.operator.PGPContentSignerBuilder;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;

public class PGPKeyRingGenerator {
    private PGPDigestCalculator checksumCalculator;
    private PGPSignatureSubpacketVector hashedPcks;
    private PBESecretKeyEncryptor keyEncryptor;
    private PGPContentSignerBuilder keySignerBuilder;
    List keys;
    private PGPKeyPair masterKey;
    private PGPSignatureSubpacketVector unhashedPcks;

    public PGPKeyRingGenerator(int i, PGPKeyPair pGPKeyPair, String str, PGPDigestCalculator pGPDigestCalculator, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, PGPContentSignerBuilder pGPContentSignerBuilder, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        ArrayList arrayList = new ArrayList();
        this.keys = arrayList;
        PGPKeyPair pGPKeyPair2 = pGPKeyPair;
        this.masterKey = pGPKeyPair2;
        PBESecretKeyEncryptor pBESecretKeyEncryptor2 = pBESecretKeyEncryptor;
        this.keyEncryptor = pBESecretKeyEncryptor2;
        PGPDigestCalculator pGPDigestCalculator2 = pGPDigestCalculator;
        this.checksumCalculator = pGPDigestCalculator2;
        PGPContentSignerBuilder pGPContentSignerBuilder2 = pGPContentSignerBuilder;
        this.keySignerBuilder = pGPContentSignerBuilder2;
        PGPSignatureSubpacketVector pGPSignatureSubpacketVector3 = pGPSignatureSubpacketVector;
        this.hashedPcks = pGPSignatureSubpacketVector3;
        PGPSignatureSubpacketVector pGPSignatureSubpacketVector4 = pGPSignatureSubpacketVector2;
        this.unhashedPcks = pGPSignatureSubpacketVector4;
        arrayList.add(new PGPSecretKey(i, pGPKeyPair2, str, pGPDigestCalculator2, pGPSignatureSubpacketVector3, pGPSignatureSubpacketVector4, pGPContentSignerBuilder2, pBESecretKeyEncryptor2));
    }

    public void addSubKey(PGPKeyPair pGPKeyPair) throws PGPException {
        addSubKey(pGPKeyPair, this.hashedPcks, this.unhashedPcks);
    }

    public void addSubKey(PGPKeyPair pGPKeyPair, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2) throws PGPException {
        try {
            PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(this.keySignerBuilder);
            pGPSignatureGenerator.init(24, this.masterKey.getPrivateKey());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketVector);
            pGPSignatureGenerator.setUnhashedSubpackets(pGPSignatureSubpacketVector2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(pGPSignatureGenerator.generateCertification(this.masterKey.getPublicKey(), pGPKeyPair.getPublicKey()));
            this.keys.add(new PGPSecretKey(pGPKeyPair.getPrivateKey(), new PGPPublicKey(pGPKeyPair.getPublicKey(), (TrustPacket) null, arrayList), this.checksumCalculator, this.keyEncryptor));
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("exception adding subkey: ", e2);
        }
    }

    public PGPSecretKeyRing generateSecretKeyRing() {
        return new PGPSecretKeyRing(this.keys);
    }

    public PGPPublicKeyRing generatePublicKeyRing() {
        Iterator it2 = this.keys.iterator();
        ArrayList arrayList = new ArrayList();
        arrayList.add(((PGPSecretKey) it2.next()).getPublicKey());
        while (it2.hasNext()) {
            PGPPublicKey pGPPublicKey = new PGPPublicKey(((PGPSecretKey) it2.next()).getPublicKey());
            pGPPublicKey.publicPk = new PublicSubkeyPacket(pGPPublicKey.getAlgorithm(), pGPPublicKey.getCreationTime(), pGPPublicKey.publicPk.getKey());
            arrayList.add(pGPPublicKey);
        }
        return new PGPPublicKeyRing(arrayList);
    }
}
