package org.spongycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import kotlin.UByte;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;

public class PKCS7ProcessableObject implements CMSTypedData {
    private final ASN1Encodable structure;
    private final ASN1ObjectIdentifier type;

    public PKCS7ProcessableObject(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.type = aSN1ObjectIdentifier;
        this.structure = aSN1Encodable;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.type;
    }

    public void write(OutputStream outputStream) throws IOException, CMSException {
        ASN1Encodable aSN1Encodable = this.structure;
        if (aSN1Encodable instanceof ASN1Sequence) {
            Iterator<ASN1Encodable> it2 = ASN1Sequence.getInstance(aSN1Encodable).iterator();
            while (it2.hasNext()) {
                outputStream.write(it2.next().toASN1Primitive().getEncoded(ASN1Encoding.DER));
            }
            return;
        }
        byte[] encoded = aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        int i = 1;
        while ((encoded[i] & UByte.MAX_VALUE) > Byte.MAX_VALUE) {
            i++;
        }
        int i2 = i + 1;
        outputStream.write(encoded, i2, encoded.length - i2);
    }

    public Object getContent() {
        return this.structure;
    }
}
