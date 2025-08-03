package org.spongycastle.voms;

import java.util.ArrayList;
import java.util.List;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.x509.Attribute;
import org.spongycastle.asn1.x509.IetfAttrSyntax;
import org.spongycastle.cert.X509AttributeCertificateHolder;

public class VOMSAttribute {
    public static final String VOMS_ATTR_OID = "1.3.6.1.4.1.8005.100.100.4";
    private X509AttributeCertificateHolder myAC;
    private List myFQANs = new ArrayList();
    private String myHostPort;
    private List myStringList = new ArrayList();
    private String myVo;

    public VOMSAttribute(X509AttributeCertificateHolder x509AttributeCertificateHolder) {
        if (x509AttributeCertificateHolder != null) {
            this.myAC = x509AttributeCertificateHolder;
            Attribute[] attributes = x509AttributeCertificateHolder.getAttributes(new ASN1ObjectIdentifier(VOMS_ATTR_OID));
            if (attributes != null) {
                int i = 0;
                while (i != attributes.length) {
                    try {
                        IetfAttrSyntax instance = IetfAttrSyntax.getInstance(attributes[i].getAttributeValues()[0]);
                        String string = ((DERIA5String) instance.getPolicyAuthority().getNames()[0].getName()).getString();
                        int indexOf = string.indexOf("://");
                        if (indexOf < 0 || indexOf == string.length() - 1) {
                            throw new IllegalArgumentException("Bad encoding of VOMS policyAuthority : [" + string + "]");
                        }
                        this.myVo = string.substring(0, indexOf);
                        this.myHostPort = string.substring(indexOf + 3);
                        if (instance.getValueType() == 1) {
                            ASN1OctetString[] aSN1OctetStringArr = (ASN1OctetString[]) instance.getValues();
                            for (int i2 = 0; i2 != aSN1OctetStringArr.length; i2++) {
                                String str = new String(aSN1OctetStringArr[i2].getOctets());
                                FQAN fqan = new FQAN(str);
                                if (!this.myStringList.contains(str) && str.startsWith("/" + this.myVo + "/")) {
                                    this.myStringList.add(str);
                                    this.myFQANs.add(fqan);
                                }
                            }
                            i++;
                        } else {
                            throw new IllegalArgumentException("VOMS attribute values are not encoded as octet strings, policyAuthority = " + string);
                        }
                    } catch (IllegalArgumentException e) {
                        throw e;
                    } catch (Exception unused) {
                        throw new IllegalArgumentException("Badly encoded VOMS extension in AC issued by " + x509AttributeCertificateHolder.getIssuer());
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("VOMSAttribute: AttributeCertificate is NULL");
    }

    public X509AttributeCertificateHolder getAC() {
        return this.myAC;
    }

    public List getFullyQualifiedAttributes() {
        return this.myStringList;
    }

    public List getListOfFQAN() {
        return this.myFQANs;
    }

    public String getHostPort() {
        return this.myHostPort;
    }

    public String getVO() {
        return this.myVo;
    }

    public String toString() {
        return "VO      :" + this.myVo + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + "HostPort:" + this.myHostPort + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + "FQANs   :" + this.myFQANs;
    }

    public class FQAN {
        String capability;
        String fqan;
        String group;
        String role;

        public FQAN(String str) {
            this.fqan = str;
        }

        public FQAN(String str, String str2, String str3) {
            this.group = str;
            this.role = str2;
            this.capability = str3;
        }

        public String getFQAN() {
            String str = this.fqan;
            if (str != null) {
                return str;
            }
            StringBuilder append = new StringBuilder().append(this.group).append("/Role=");
            String str2 = this.role;
            String str3 = "";
            if (str2 == null) {
                str2 = str3;
            }
            StringBuilder append2 = append.append(str2);
            if (this.capability != null) {
                str3 = "/Capability=" + this.capability;
            }
            String sb = append2.append(str3).toString();
            this.fqan = sb;
            return sb;
        }

        /* access modifiers changed from: protected */
        public void split() {
            String str;
            this.fqan.length();
            int indexOf = this.fqan.indexOf("/Role=");
            if (indexOf >= 0) {
                this.group = this.fqan.substring(0, indexOf);
                int i = indexOf + 6;
                int indexOf2 = this.fqan.indexOf("/Capability=", i);
                String str2 = this.fqan;
                String substring = indexOf2 < 0 ? str2.substring(i) : str2.substring(i, indexOf2);
                String str3 = null;
                if (substring.length() == 0) {
                    substring = null;
                }
                this.role = substring;
                if (indexOf2 < 0) {
                    str = null;
                } else {
                    str = this.fqan.substring(indexOf2 + 12);
                }
                if (!(str == null || str.length() == 0)) {
                    str3 = str;
                }
                this.capability = str3;
            }
        }

        public String getGroup() {
            if (this.group == null && this.fqan != null) {
                split();
            }
            return this.group;
        }

        public String getRole() {
            if (this.group == null && this.fqan != null) {
                split();
            }
            return this.role;
        }

        public String getCapability() {
            if (this.group == null && this.fqan != null) {
                split();
            }
            return this.capability;
        }

        public String toString() {
            return getFQAN();
        }
    }
}
