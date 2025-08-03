package org.spongycastle.cert.dane;

import java.io.IOException;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.util.Arrays;

public class DANEEntry {
    static final int CERT_USAGE = 0;
    static final int MATCHING_TYPE = 2;
    static final int SELECTOR = 1;
    private final X509CertificateHolder certHolder;
    private final String domainName;
    private final byte[] flags;

    DANEEntry(String str, byte[] bArr, X509CertificateHolder x509CertificateHolder) {
        this.flags = bArr;
        this.domainName = str;
        this.certHolder = x509CertificateHolder;
    }

    public DANEEntry(String str, byte[] bArr) throws IOException {
        this(str, Arrays.copyOfRange(bArr, 0, 3), new X509CertificateHolder(Arrays.copyOfRange(bArr, 3, bArr.length)));
    }

    public byte[] getFlags() {
        return Arrays.clone(this.flags);
    }

    public X509CertificateHolder getCertificate() {
        return this.certHolder;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public byte[] getRDATA() throws IOException {
        byte[] encoded = this.certHolder.getEncoded();
        byte[] bArr = this.flags;
        byte[] bArr2 = new byte[(bArr.length + encoded.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(encoded, 0, bArr2, this.flags.length, encoded.length);
        return bArr2;
    }

    public static boolean isValidCertificate(byte[] bArr) {
        return bArr[0] == 3 && bArr[1] == 0 && bArr[2] == 0;
    }
}
