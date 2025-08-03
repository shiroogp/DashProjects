package org.spongycastle.bcpg;

import java.io.IOException;
import org.spongycastle.util.Arrays;

public class ExperimentalPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private byte[] contents;
    private int tag;

    ExperimentalPacket(int i, BCPGInputStream bCPGInputStream) throws IOException {
        this.tag = i;
        this.contents = bCPGInputStream.readAll();
    }

    public int getTag() {
        return this.tag;
    }

    public byte[] getContents() {
        return Arrays.clone(this.contents);
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(this.tag, this.contents, true);
    }
}
