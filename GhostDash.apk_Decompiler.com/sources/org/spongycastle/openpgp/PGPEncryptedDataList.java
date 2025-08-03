package org.spongycastle.openpgp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.InputStreamPacket;
import org.spongycastle.bcpg.PublicKeyEncSessionPacket;
import org.spongycastle.bcpg.SymmetricKeyEncSessionPacket;
import org.spongycastle.util.Iterable;

public class PGPEncryptedDataList implements Iterable {
    InputStreamPacket data;
    List list = new ArrayList();

    public PGPEncryptedDataList(BCPGInputStream bCPGInputStream) throws IOException {
        while (true) {
            if (bCPGInputStream.nextPacketTag() != 1 && bCPGInputStream.nextPacketTag() != 3) {
                break;
            }
            this.list.add(bCPGInputStream.readPacket());
        }
        this.data = (InputStreamPacket) bCPGInputStream.readPacket();
        for (int i = 0; i != this.list.size(); i++) {
            if (this.list.get(i) instanceof SymmetricKeyEncSessionPacket) {
                this.list.set(i, new PGPPBEEncryptedData((SymmetricKeyEncSessionPacket) this.list.get(i), this.data));
            } else {
                this.list.set(i, new PGPPublicKeyEncryptedData((PublicKeyEncSessionPacket) this.list.get(i), this.data));
            }
        }
    }

    public Object get(int i) {
        return this.list.get(i);
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public Iterator getEncryptedDataObjects() {
        return this.list.iterator();
    }

    public Iterator iterator() {
        return getEncryptedDataObjects();
    }
}
