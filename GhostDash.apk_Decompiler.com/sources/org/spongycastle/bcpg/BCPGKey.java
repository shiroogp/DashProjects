package org.spongycastle.bcpg;

import org.spongycastle.util.Encodable;

public interface BCPGKey extends Encodable {
    byte[] getEncoded();

    String getFormat();
}
