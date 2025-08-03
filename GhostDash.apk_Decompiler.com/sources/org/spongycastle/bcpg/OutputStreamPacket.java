package org.spongycastle.bcpg;

import java.io.IOException;

public abstract class OutputStreamPacket {
    protected BCPGOutputStream out;

    public abstract void close() throws IOException;

    public abstract BCPGOutputStream open() throws IOException;

    public OutputStreamPacket(BCPGOutputStream bCPGOutputStream) {
        this.out = bCPGOutputStream;
    }
}
