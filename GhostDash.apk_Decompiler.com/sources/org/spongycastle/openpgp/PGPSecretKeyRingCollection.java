package org.spongycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.bcpg.BCPGOutputStream;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.util.Iterable;
import org.spongycastle.util.Strings;

public class PGPSecretKeyRingCollection implements Iterable<PGPSecretKeyRing> {
    private List order;
    private Map secretRings;

    private PGPSecretKeyRingCollection(Map map, List list) {
        this.secretRings = new HashMap();
        this.order = new ArrayList();
        this.secretRings = map;
        this.order = list;
    }

    public PGPSecretKeyRingCollection(byte[] bArr, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException, PGPException {
        this((InputStream) new ByteArrayInputStream(bArr), keyFingerPrintCalculator);
    }

    public PGPSecretKeyRingCollection(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException, PGPException {
        this.secretRings = new HashMap();
        this.order = new ArrayList();
        PGPObjectFactory pGPObjectFactory = new PGPObjectFactory(inputStream, keyFingerPrintCalculator);
        while (true) {
            Object nextObject = pGPObjectFactory.nextObject();
            if (nextObject == null) {
                return;
            }
            if (nextObject instanceof PGPSecretKeyRing) {
                PGPSecretKeyRing pGPSecretKeyRing = (PGPSecretKeyRing) nextObject;
                Long l = new Long(pGPSecretKeyRing.getPublicKey().getKeyID());
                this.secretRings.put(l, pGPSecretKeyRing);
                this.order.add(l);
            } else {
                throw new PGPException(nextObject.getClass().getName() + " found where PGPSecretKeyRing expected");
            }
        }
    }

    public PGPSecretKeyRingCollection(Collection<PGPSecretKeyRing> collection) throws IOException, PGPException {
        this.secretRings = new HashMap();
        this.order = new ArrayList();
        for (PGPSecretKeyRing next : collection) {
            Long l = new Long(next.getPublicKey().getKeyID());
            this.secretRings.put(l, next);
            this.order.add(l);
        }
    }

    public int size() {
        return this.order.size();
    }

    public Iterator<PGPSecretKeyRing> getKeyRings() {
        return this.secretRings.values().iterator();
    }

    public Iterator<PGPSecretKeyRing> getKeyRings(String str) throws PGPException {
        return getKeyRings(str, false, false);
    }

    public Iterator<PGPSecretKeyRing> getKeyRings(String str, boolean z) throws PGPException {
        return getKeyRings(str, z, false);
    }

    public Iterator<PGPSecretKeyRing> getKeyRings(String str, boolean z, boolean z2) throws PGPException {
        Iterator<PGPSecretKeyRing> keyRings = getKeyRings();
        ArrayList arrayList = new ArrayList();
        if (z2) {
            str = Strings.toLowerCase(str);
        }
        while (keyRings.hasNext()) {
            PGPSecretKeyRing next = keyRings.next();
            Iterator userIDs = next.getSecretKey().getUserIDs();
            while (userIDs.hasNext()) {
                String str2 = (String) userIDs.next();
                if (z2) {
                    str2 = Strings.toLowerCase(str2);
                }
                if (z) {
                    if (str2.indexOf(str) > -1) {
                        arrayList.add(next);
                    }
                } else if (str2.equals(str)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList.iterator();
    }

    public PGPSecretKey getSecretKey(long j) throws PGPException {
        Iterator<PGPSecretKeyRing> keyRings = getKeyRings();
        while (keyRings.hasNext()) {
            PGPSecretKey secretKey = keyRings.next().getSecretKey(j);
            if (secretKey != null) {
                return secretKey;
            }
        }
        return null;
    }

    public PGPSecretKeyRing getSecretKeyRing(long j) throws PGPException {
        Long l = new Long(j);
        if (this.secretRings.containsKey(l)) {
            return (PGPSecretKeyRing) this.secretRings.get(l);
        }
        Iterator<PGPSecretKeyRing> keyRings = getKeyRings();
        while (keyRings.hasNext()) {
            PGPSecretKeyRing next = keyRings.next();
            if (next.getSecretKey(j) != null) {
                return next;
            }
        }
        return null;
    }

    public boolean contains(long j) throws PGPException {
        return getSecretKey(j) != null;
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
        for (Object obj : this.order) {
            ((PGPSecretKeyRing) this.secretRings.get(obj)).encode(bCPGOutputStream);
        }
    }

    public static PGPSecretKeyRingCollection addSecretKeyRing(PGPSecretKeyRingCollection pGPSecretKeyRingCollection, PGPSecretKeyRing pGPSecretKeyRing) {
        Long l = new Long(pGPSecretKeyRing.getPublicKey().getKeyID());
        if (!pGPSecretKeyRingCollection.secretRings.containsKey(l)) {
            HashMap hashMap = new HashMap(pGPSecretKeyRingCollection.secretRings);
            ArrayList arrayList = new ArrayList(pGPSecretKeyRingCollection.order);
            hashMap.put(l, pGPSecretKeyRing);
            arrayList.add(l);
            return new PGPSecretKeyRingCollection((Map) hashMap, (List) arrayList);
        }
        throw new IllegalArgumentException("Collection already contains a key with a keyID for the passed in ring.");
    }

    public static PGPSecretKeyRingCollection removeSecretKeyRing(PGPSecretKeyRingCollection pGPSecretKeyRingCollection, PGPSecretKeyRing pGPSecretKeyRing) {
        Long l = new Long(pGPSecretKeyRing.getPublicKey().getKeyID());
        if (pGPSecretKeyRingCollection.secretRings.containsKey(l)) {
            HashMap hashMap = new HashMap(pGPSecretKeyRingCollection.secretRings);
            ArrayList arrayList = new ArrayList(pGPSecretKeyRingCollection.order);
            hashMap.remove(l);
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                } else if (((Long) arrayList.get(i)).longValue() == l.longValue()) {
                    arrayList.remove(i);
                    break;
                } else {
                    i++;
                }
            }
            return new PGPSecretKeyRingCollection((Map) hashMap, (List) arrayList);
        }
        throw new IllegalArgumentException("Collection does not contain a key with a keyID for the passed in ring.");
    }

    public Iterator<PGPSecretKeyRing> iterator() {
        return this.secretRings.values().iterator();
    }
}
