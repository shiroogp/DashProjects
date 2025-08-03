package org.spongycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.spongycastle.util.Encodable;

public abstract class BCPGObject implements Encodable {
    public abstract void encode(BCPGOutputStream bCPGOutputStream) throws IOException;

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream.writeObject(this);
        bCPGOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
