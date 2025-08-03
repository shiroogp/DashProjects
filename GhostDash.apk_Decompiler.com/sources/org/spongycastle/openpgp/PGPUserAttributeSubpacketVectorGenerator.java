package org.spongycastle.openpgp;

import java.util.ArrayList;
import java.util.List;
import org.spongycastle.bcpg.UserAttributeSubpacket;
import org.spongycastle.bcpg.attr.ImageAttribute;

public class PGPUserAttributeSubpacketVectorGenerator {
    private List list = new ArrayList();

    public void setImageAttribute(int i, byte[] bArr) {
        if (bArr != null) {
            this.list.add(new ImageAttribute(i, bArr));
            return;
        }
        throw new IllegalArgumentException("attempt to set null image");
    }

    public PGPUserAttributeSubpacketVector generate() {
        List list2 = this.list;
        return new PGPUserAttributeSubpacketVector((UserAttributeSubpacket[]) list2.toArray(new UserAttributeSubpacket[list2.size()]));
    }
}
