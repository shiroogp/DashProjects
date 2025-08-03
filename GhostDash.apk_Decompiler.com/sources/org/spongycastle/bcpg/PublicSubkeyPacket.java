package org.spongycastle.bcpg;

import java.io.IOException;
import java.util.Date;

public class PublicSubkeyPacket extends PublicKeyPacket {
    PublicSubkeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
    }

    public PublicSubkeyPacket(int i, Date date, BCPGKey bCPGKey) {
        super(i, date, bCPGKey);
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(14, getEncodedContents(), true);
    }
}
