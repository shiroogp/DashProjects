package org.spongycastle.openpgp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.LiteralDataPacket;

public class PGPLiteralData {
    public static final char BINARY = 'b';
    public static final String CONSOLE = "_CONSOLE";
    public static final Date NOW = new Date(0);
    public static final char TEXT = 't';
    public static final char UTF8 = 'u';
    LiteralDataPacket data;

    public PGPLiteralData(BCPGInputStream bCPGInputStream) throws IOException {
        this.data = (LiteralDataPacket) bCPGInputStream.readPacket();
    }

    public int getFormat() {
        return this.data.getFormat();
    }

    public String getFileName() {
        return this.data.getFileName();
    }

    public byte[] getRawFileName() {
        return this.data.getRawFileName();
    }

    public Date getModificationTime() {
        return new Date(this.data.getModificationTime());
    }

    public InputStream getInputStream() {
        return this.data.getInputStream();
    }

    public InputStream getDataStream() {
        return getInputStream();
    }
}
