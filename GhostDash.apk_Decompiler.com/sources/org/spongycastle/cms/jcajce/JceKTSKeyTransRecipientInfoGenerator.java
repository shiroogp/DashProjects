package org.spongycastle.cms.jcajce;

import java.io.IOException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cms.IssuerAndSerialNumber;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.cms.KeyTransRecipientInfoGenerator;
import org.spongycastle.operator.AsymmetricKeyWrapper;
import org.spongycastle.operator.jcajce.JceAsymmetricKeyWrapper;
import org.spongycastle.operator.jcajce.JceKTSKeyWrapper;
import org.spongycastle.util.encoders.Hex;

public class JceKTSKeyTransRecipientInfoGenerator extends KeyTransRecipientInfoGenerator {
    private static final byte[] ANONYMOUS_SENDER = Hex.decode("0c14416e6f6e796d6f75732053656e64657220202020");

    private JceKTSKeyTransRecipientInfoGenerator(X509Certificate x509Certificate, IssuerAndSerialNumber issuerAndSerialNumber, String str, int i) throws CertificateEncodingException {
        super(issuerAndSerialNumber, (AsymmetricKeyWrapper) new JceKTSKeyWrapper(x509Certificate, str, i, ANONYMOUS_SENDER, getEncodedRecipID(issuerAndSerialNumber)));
    }

    public JceKTSKeyTransRecipientInfoGenerator(X509Certificate x509Certificate, String str, int i) throws CertificateEncodingException {
        this(x509Certificate, new IssuerAndSerialNumber(new JcaX509CertificateHolder(x509Certificate).toASN1Structure()), str, i);
    }

    public JceKTSKeyTransRecipientInfoGenerator(byte[] bArr, PublicKey publicKey, String str, int i) {
        super(bArr, (AsymmetricKeyWrapper) new JceKTSKeyWrapper(publicKey, str, i, ANONYMOUS_SENDER, getEncodedSubKeyId(bArr)));
    }

    private static byte[] getEncodedRecipID(IssuerAndSerialNumber issuerAndSerialNumber) throws CertificateEncodingException {
        try {
            return issuerAndSerialNumber.getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CertificateEncodingException("Cannot process extracted IssuerAndSerialNumber: " + e.getMessage()) {
                public Throwable getCause() {
                    return e;
                }
            };
        }
    }

    private static byte[] getEncodedSubKeyId(byte[] bArr) {
        try {
            return new DEROctetString(bArr).getEncoded();
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot process subject key identifier: " + e.getMessage()) {
                public Throwable getCause() {
                    return e;
                }
            };
        }
    }

    public JceKTSKeyTransRecipientInfoGenerator(X509Certificate x509Certificate, AlgorithmIdentifier algorithmIdentifier) throws CertificateEncodingException {
        super(new IssuerAndSerialNumber(new JcaX509CertificateHolder(x509Certificate).toASN1Structure()), (AsymmetricKeyWrapper) new JceAsymmetricKeyWrapper(algorithmIdentifier, x509Certificate.getPublicKey()));
    }

    public JceKTSKeyTransRecipientInfoGenerator(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) {
        super(bArr, (AsymmetricKeyWrapper) new JceAsymmetricKeyWrapper(algorithmIdentifier, publicKey));
    }

    public JceKTSKeyTransRecipientInfoGenerator setProvider(String str) {
        ((JceKTSKeyWrapper) this.wrapper).setProvider(str);
        return this;
    }

    public JceKTSKeyTransRecipientInfoGenerator setProvider(Provider provider) {
        ((JceKTSKeyWrapper) this.wrapper).setProvider(provider);
        return this;
    }
}
