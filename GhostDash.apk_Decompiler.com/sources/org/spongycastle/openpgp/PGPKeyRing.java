package org.spongycastle.openpgp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.Packet;
import org.spongycastle.bcpg.SignaturePacket;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.bcpg.UserAttributePacket;
import org.spongycastle.bcpg.UserIDPacket;

public abstract class PGPKeyRing {
    public abstract void encode(OutputStream outputStream) throws IOException;

    public abstract byte[] getEncoded() throws IOException;

    public abstract PGPPublicKey getPublicKey();

    public abstract PGPPublicKey getPublicKey(long j);

    public abstract Iterator getPublicKeys();

    PGPKeyRing() {
    }

    static BCPGInputStream wrap(InputStream inputStream) {
        if (inputStream instanceof BCPGInputStream) {
            return (BCPGInputStream) inputStream;
        }
        return new BCPGInputStream(inputStream);
    }

    static TrustPacket readOptionalTrustPacket(BCPGInputStream bCPGInputStream) throws IOException {
        if (bCPGInputStream.nextPacketTag() == 12) {
            return (TrustPacket) bCPGInputStream.readPacket();
        }
        return null;
    }

    static List readSignaturesAndTrust(BCPGInputStream bCPGInputStream) throws IOException {
        try {
            ArrayList arrayList = new ArrayList();
            while (bCPGInputStream.nextPacketTag() == 2) {
                arrayList.add(new PGPSignature((SignaturePacket) bCPGInputStream.readPacket(), readOptionalTrustPacket(bCPGInputStream)));
            }
            return arrayList;
        } catch (PGPException e) {
            throw new IOException("can't create signature object: " + e.getMessage() + ", cause: " + e.getUnderlyingException().toString());
        }
    }

    static void readUserIDs(BCPGInputStream bCPGInputStream, List list, List list2, List list3) throws IOException {
        while (true) {
            if (bCPGInputStream.nextPacketTag() == 13 || bCPGInputStream.nextPacketTag() == 17) {
                Packet readPacket = bCPGInputStream.readPacket();
                if (readPacket instanceof UserIDPacket) {
                    list.add((UserIDPacket) readPacket);
                } else {
                    list.add(new PGPUserAttributeSubpacketVector(((UserAttributePacket) readPacket).getSubpackets()));
                }
                list2.add(readOptionalTrustPacket(bCPGInputStream));
                list3.add(readSignaturesAndTrust(bCPGInputStream));
            } else {
                return;
            }
        }
    }
}
