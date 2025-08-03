package org.spongycastle.cms;

import com.pedrouid.crypto.RSA;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cms.Attribute;
import org.spongycastle.asn1.cms.AttributeTable;
import org.spongycastle.asn1.cms.CMSAlgorithmProtection;
import org.spongycastle.asn1.cms.CMSAttributes;
import org.spongycastle.asn1.cms.IssuerAndSerialNumber;
import org.spongycastle.asn1.cms.SignerIdentifier;
import org.spongycastle.asn1.cms.SignerInfo;
import org.spongycastle.asn1.cms.Time;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.operator.ContentVerifier;
import org.spongycastle.operator.DigestCalculator;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.operator.RawContentVerifier;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.TeeOutputStream;

public class SignerInformation {
    private final CMSProcessable content;
    private final ASN1ObjectIdentifier contentType;
    protected final AlgorithmIdentifier digestAlgorithm;
    protected final AlgorithmIdentifier encryptionAlgorithm;
    protected final SignerInfo info;
    private final boolean isCounterSignature;
    private byte[] resultDigest;
    private final SignerId sid;
    private final byte[] signature;
    protected final ASN1Set signedAttributeSet;
    private AttributeTable signedAttributeValues;
    protected final ASN1Set unsignedAttributeSet;
    private AttributeTable unsignedAttributeValues;

    SignerInformation(SignerInfo signerInfo, ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSProcessable cMSProcessable, byte[] bArr) {
        this.info = signerInfo;
        this.contentType = aSN1ObjectIdentifier;
        this.isCounterSignature = aSN1ObjectIdentifier == null;
        SignerIdentifier sid2 = signerInfo.getSID();
        if (sid2.isTagged()) {
            this.sid = new SignerId(ASN1OctetString.getInstance(sid2.getId()).getOctets());
        } else {
            IssuerAndSerialNumber instance = IssuerAndSerialNumber.getInstance(sid2.getId());
            this.sid = new SignerId(instance.getName(), instance.getSerialNumber().getValue());
        }
        this.digestAlgorithm = signerInfo.getDigestAlgorithm();
        this.signedAttributeSet = signerInfo.getAuthenticatedAttributes();
        this.unsignedAttributeSet = signerInfo.getUnauthenticatedAttributes();
        this.encryptionAlgorithm = signerInfo.getDigestEncryptionAlgorithm();
        this.signature = signerInfo.getEncryptedDigest().getOctets();
        this.content = cMSProcessable;
        this.resultDigest = bArr;
    }

    protected SignerInformation(SignerInformation signerInformation) {
        SignerInfo signerInfo = signerInformation.info;
        this.info = signerInfo;
        this.contentType = signerInformation.contentType;
        this.isCounterSignature = signerInformation.isCounterSignature();
        this.sid = signerInformation.getSID();
        this.digestAlgorithm = signerInfo.getDigestAlgorithm();
        this.signedAttributeSet = signerInfo.getAuthenticatedAttributes();
        this.unsignedAttributeSet = signerInfo.getUnauthenticatedAttributes();
        this.encryptionAlgorithm = signerInfo.getDigestEncryptionAlgorithm();
        this.signature = signerInfo.getEncryptedDigest().getOctets();
        this.content = signerInformation.content;
        this.resultDigest = signerInformation.resultDigest;
    }

    public boolean isCounterSignature() {
        return this.isCounterSignature;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    private byte[] encodeObj(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable != null) {
            return aSN1Encodable.toASN1Primitive().getEncoded();
        }
        return null;
    }

    public SignerId getSID() {
        return this.sid;
    }

    public int getVersion() {
        return this.info.getVersion().getValue().intValue();
    }

    public AlgorithmIdentifier getDigestAlgorithmID() {
        return this.digestAlgorithm;
    }

    public String getDigestAlgOID() {
        return this.digestAlgorithm.getAlgorithm().getId();
    }

    public byte[] getDigestAlgParams() {
        try {
            return encodeObj(this.digestAlgorithm.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting digest parameters " + e);
        }
    }

    public byte[] getContentDigest() {
        byte[] bArr = this.resultDigest;
        if (bArr != null) {
            return Arrays.clone(bArr);
        }
        throw new IllegalStateException("method can only be called after verify.");
    }

    public String getEncryptionAlgOID() {
        return this.encryptionAlgorithm.getAlgorithm().getId();
    }

    public byte[] getEncryptionAlgParams() {
        try {
            return encodeObj(this.encryptionAlgorithm.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AttributeTable getSignedAttributes() {
        if (this.signedAttributeSet != null && this.signedAttributeValues == null) {
            this.signedAttributeValues = new AttributeTable(this.signedAttributeSet);
        }
        return this.signedAttributeValues;
    }

    public AttributeTable getUnsignedAttributes() {
        if (this.unsignedAttributeSet != null && this.unsignedAttributeValues == null) {
            this.unsignedAttributeValues = new AttributeTable(this.unsignedAttributeSet);
        }
        return this.unsignedAttributeValues;
    }

    public byte[] getSignature() {
        return Arrays.clone(this.signature);
    }

    public SignerInformationStore getCounterSignatures() {
        AttributeTable unsignedAttributes = getUnsignedAttributes();
        if (unsignedAttributes == null) {
            return new SignerInformationStore((Collection<SignerInformation>) new ArrayList(0));
        }
        ArrayList arrayList = new ArrayList();
        ASN1EncodableVector all = unsignedAttributes.getAll(CMSAttributes.counterSignature);
        for (int i = 0; i < all.size(); i++) {
            ASN1Set attrValues = ((Attribute) all.get(i)).getAttrValues();
            attrValues.size();
            Enumeration objects = attrValues.getObjects();
            while (objects.hasMoreElements()) {
                arrayList.add(new SignerInformation(SignerInfo.getInstance(objects.nextElement()), (ASN1ObjectIdentifier) null, new CMSProcessableByteArray(getSignature()), (byte[]) null));
            }
        }
        return new SignerInformationStore((Collection<SignerInformation>) arrayList);
    }

    public byte[] getEncodedSignedAttributes() throws IOException {
        ASN1Set aSN1Set = this.signedAttributeSet;
        if (aSN1Set != null) {
            return aSN1Set.getEncoded(ASN1Encoding.DER);
        }
        return null;
    }

    private boolean doVerify(SignerInformationVerifier signerInformationVerifier) throws CMSException {
        String encryptionAlgName = CMSSignedHelper.INSTANCE.getEncryptionAlgName(getEncryptionAlgOID());
        try {
            ContentVerifier contentVerifier = signerInformationVerifier.getContentVerifier(this.encryptionAlgorithm, this.info.getDigestAlgorithm());
            try {
                OutputStream outputStream = contentVerifier.getOutputStream();
                if (this.resultDigest == null) {
                    DigestCalculator digestCalculator = signerInformationVerifier.getDigestCalculator(getDigestAlgorithmID());
                    if (this.content != null) {
                        OutputStream outputStream2 = digestCalculator.getOutputStream();
                        if (this.signedAttributeSet != null) {
                            this.content.write(outputStream2);
                            outputStream.write(getEncodedSignedAttributes());
                        } else if (contentVerifier instanceof RawContentVerifier) {
                            this.content.write(outputStream2);
                        } else {
                            TeeOutputStream teeOutputStream = new TeeOutputStream(outputStream2, outputStream);
                            this.content.write(teeOutputStream);
                            teeOutputStream.close();
                        }
                        outputStream2.close();
                    } else if (this.signedAttributeSet != null) {
                        outputStream.write(getEncodedSignedAttributes());
                    } else {
                        throw new CMSException("data not encapsulated in signature - use detached constructor.");
                    }
                    this.resultDigest = digestCalculator.getDigest();
                } else if (this.signedAttributeSet == null) {
                    CMSProcessable cMSProcessable = this.content;
                    if (cMSProcessable != null) {
                        cMSProcessable.write(outputStream);
                    }
                } else {
                    outputStream.write(getEncodedSignedAttributes());
                }
                outputStream.close();
                ASN1Primitive singleValuedSignedAttribute = getSingleValuedSignedAttribute(CMSAttributes.contentType, "content-type");
                if (singleValuedSignedAttribute == null) {
                    if (!this.isCounterSignature && this.signedAttributeSet != null) {
                        throw new CMSException("The content-type attribute type MUST be present whenever signed attributes are present in signed-data");
                    }
                } else if (this.isCounterSignature) {
                    throw new CMSException("[For counter signatures,] the signedAttributes field MUST NOT contain a content-type attribute");
                } else if (!(singleValuedSignedAttribute instanceof ASN1ObjectIdentifier)) {
                    throw new CMSException("content-type attribute value not of ASN.1 type 'OBJECT IDENTIFIER'");
                } else if (!((ASN1ObjectIdentifier) singleValuedSignedAttribute).equals(this.contentType)) {
                    throw new CMSException("content-type attribute value does not match eContentType");
                }
                AttributeTable signedAttributes = getSignedAttributes();
                AttributeTable unsignedAttributes = getUnsignedAttributes();
                if (unsignedAttributes == null || unsignedAttributes.getAll(CMSAttributes.cmsAlgorithmProtect).size() <= 0) {
                    int i = 0;
                    if (signedAttributes != null) {
                        ASN1EncodableVector all = signedAttributes.getAll(CMSAttributes.cmsAlgorithmProtect);
                        if (all.size() > 1) {
                            throw new CMSException("Only one instance of a cmsAlgorithmProtect attribute can be present");
                        } else if (all.size() > 0) {
                            Attribute instance = Attribute.getInstance(all.get(0));
                            if (instance.getAttrValues().size() == 1) {
                                CMSAlgorithmProtection instance2 = CMSAlgorithmProtection.getInstance(instance.getAttributeValues()[0]);
                                if (!CMSUtils.isEquivalent(instance2.getDigestAlgorithm(), this.info.getDigestAlgorithm())) {
                                    throw new CMSException("CMS Algorithm Identifier Protection check failed for digestAlgorithm");
                                } else if (!CMSUtils.isEquivalent(instance2.getSignatureAlgorithm(), this.info.getDigestEncryptionAlgorithm())) {
                                    throw new CMSException("CMS Algorithm Identifier Protection check failed for signatureAlgorithm");
                                }
                            } else {
                                throw new CMSException("A cmsAlgorithmProtect attribute MUST contain exactly one value");
                            }
                        }
                    }
                    ASN1Primitive singleValuedSignedAttribute2 = getSingleValuedSignedAttribute(CMSAttributes.messageDigest, "message-digest");
                    if (singleValuedSignedAttribute2 == null) {
                        if (this.signedAttributeSet != null) {
                            throw new CMSException("the message-digest signed attribute type MUST be present when there are any signed attributes present");
                        }
                    } else if (!(singleValuedSignedAttribute2 instanceof ASN1OctetString)) {
                        throw new CMSException("message-digest attribute value not of ASN.1 type 'OCTET STRING'");
                    } else if (!Arrays.constantTimeAreEqual(this.resultDigest, ((ASN1OctetString) singleValuedSignedAttribute2).getOctets())) {
                        throw new CMSSignerDigestMismatchException("message-digest attribute value does not match calculated value");
                    }
                    if (signedAttributes == null || signedAttributes.getAll(CMSAttributes.counterSignature).size() <= 0) {
                        AttributeTable unsignedAttributes2 = getUnsignedAttributes();
                        if (unsignedAttributes2 != null) {
                            ASN1EncodableVector all2 = unsignedAttributes2.getAll(CMSAttributes.counterSignature);
                            while (i < all2.size()) {
                                if (Attribute.getInstance(all2.get(i)).getAttrValues().size() >= 1) {
                                    i++;
                                } else {
                                    throw new CMSException("A countersignature attribute MUST contain at least one AttributeValue");
                                }
                            }
                        }
                        try {
                            if (this.signedAttributeSet != null || this.resultDigest == null || !(contentVerifier instanceof RawContentVerifier)) {
                                return contentVerifier.verify(getSignature());
                            }
                            RawContentVerifier rawContentVerifier = (RawContentVerifier) contentVerifier;
                            if (encryptionAlgName.equals(RSA.ALGORITHM)) {
                                return rawContentVerifier.verify(new DigestInfo(new AlgorithmIdentifier(this.digestAlgorithm.getAlgorithm(), DERNull.INSTANCE), this.resultDigest).getEncoded(ASN1Encoding.DER), getSignature());
                            }
                            return rawContentVerifier.verify(this.resultDigest, getSignature());
                        } catch (IOException e) {
                            throw new CMSException("can't process mime object to create signature.", e);
                        }
                    } else {
                        throw new CMSException("A countersignature attribute MUST NOT be a signed attribute");
                    }
                } else {
                    throw new CMSException("A cmsAlgorithmProtect attribute MUST be a signed attribute");
                }
            } catch (IOException e2) {
                throw new CMSException("can't process mime object to create signature.", e2);
            } catch (OperatorCreationException e3) {
                throw new CMSException("can't create digest calculator: " + e3.getMessage(), e3);
            }
        } catch (OperatorCreationException e4) {
            throw new CMSException("can't create content verifier: " + e4.getMessage(), e4);
        }
    }

    public boolean verify(SignerInformationVerifier signerInformationVerifier) throws CMSException {
        Time signingTime = getSigningTime();
        if (!signerInformationVerifier.hasAssociatedCertificate() || signingTime == null || signerInformationVerifier.getAssociatedCertificate().isValidOn(signingTime.getDate())) {
            return doVerify(signerInformationVerifier);
        }
        throw new CMSVerifierCertificateNotValidException("verifier not valid at signingTime");
    }

    public SignerInfo toASN1Structure() {
        return this.info;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        r4 = r0.getAll(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.spongycastle.asn1.ASN1Primitive getSingleValuedSignedAttribute(org.spongycastle.asn1.ASN1ObjectIdentifier r4, java.lang.String r5) throws org.spongycastle.cms.CMSException {
        /*
            r3 = this;
            org.spongycastle.asn1.cms.AttributeTable r0 = r3.getUnsignedAttributes()
            if (r0 == 0) goto L_0x0030
            org.spongycastle.asn1.ASN1EncodableVector r0 = r0.getAll(r4)
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0011
            goto L_0x0030
        L_0x0011:
            org.spongycastle.cms.CMSException r4 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r0 = " attribute MUST NOT be an unsigned attribute"
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x0030:
            org.spongycastle.asn1.cms.AttributeTable r0 = r3.getSignedAttributes()
            r1 = 0
            if (r0 != 0) goto L_0x0038
            return r1
        L_0x0038:
            org.spongycastle.asn1.ASN1EncodableVector r4 = r0.getAll(r4)
            int r0 = r4.size()
            if (r0 == 0) goto L_0x009d
            r1 = 1
            if (r0 != r1) goto L_0x007e
            r0 = 0
            org.spongycastle.asn1.ASN1Encodable r4 = r4.get(r0)
            org.spongycastle.asn1.cms.Attribute r4 = (org.spongycastle.asn1.cms.Attribute) r4
            org.spongycastle.asn1.ASN1Set r4 = r4.getAttrValues()
            int r2 = r4.size()
            if (r2 != r1) goto L_0x005f
            org.spongycastle.asn1.ASN1Encodable r4 = r4.getObjectAt(r0)
            org.spongycastle.asn1.ASN1Primitive r4 = r4.toASN1Primitive()
            return r4
        L_0x005f:
            org.spongycastle.cms.CMSException r4 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "A "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r0 = " attribute MUST have a single attribute value"
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x007e:
            org.spongycastle.cms.CMSException r4 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The SignedAttributes in a signerInfo MUST NOT include multiple instances of the "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r0 = " attribute"
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x009d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.SignerInformation.getSingleValuedSignedAttribute(org.spongycastle.asn1.ASN1ObjectIdentifier, java.lang.String):org.spongycastle.asn1.ASN1Primitive");
    }

    private Time getSigningTime() throws CMSException {
        ASN1Primitive singleValuedSignedAttribute = getSingleValuedSignedAttribute(CMSAttributes.signingTime, "signing-time");
        if (singleValuedSignedAttribute == null) {
            return null;
        }
        try {
            return Time.getInstance(singleValuedSignedAttribute);
        } catch (IllegalArgumentException unused) {
            throw new CMSException("signing-time attribute value not a valid 'Time' structure");
        }
    }

    public static SignerInformation replaceUnsignedAttributes(SignerInformation signerInformation, AttributeTable attributeTable) {
        SignerInfo signerInfo = signerInformation.info;
        return new SignerInformation(new SignerInfo(signerInfo.getSID(), signerInfo.getDigestAlgorithm(), signerInfo.getAuthenticatedAttributes(), signerInfo.getDigestEncryptionAlgorithm(), signerInfo.getEncryptedDigest(), (ASN1Set) attributeTable != null ? new DERSet(attributeTable.toASN1EncodableVector()) : null), signerInformation.contentType, signerInformation.content, (byte[]) null);
    }

    public static SignerInformation addCounterSigners(SignerInformation signerInformation, SignerInformationStore signerInformationStore) {
        ASN1EncodableVector aSN1EncodableVector;
        SignerInfo signerInfo = signerInformation.info;
        AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        if (unsignedAttributes != null) {
            aSN1EncodableVector = unsignedAttributes.toASN1EncodableVector();
        } else {
            aSN1EncodableVector = new ASN1EncodableVector();
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (SignerInformation aSN1Structure : signerInformationStore.getSigners()) {
            aSN1EncodableVector2.add(aSN1Structure.toASN1Structure());
        }
        aSN1EncodableVector.add(new Attribute(CMSAttributes.counterSignature, new DERSet(aSN1EncodableVector2)));
        return new SignerInformation(new SignerInfo(signerInfo.getSID(), signerInfo.getDigestAlgorithm(), signerInfo.getAuthenticatedAttributes(), signerInfo.getDigestEncryptionAlgorithm(), signerInfo.getEncryptedDigest(), (ASN1Set) new DERSet(aSN1EncodableVector)), signerInformation.contentType, signerInformation.content, (byte[]) null);
    }
}
