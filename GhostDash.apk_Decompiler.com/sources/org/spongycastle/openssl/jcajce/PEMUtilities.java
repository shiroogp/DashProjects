package org.spongycastle.openssl.jcajce;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.openssl.EncryptionException;
import org.spongycastle.openssl.PEMException;
import org.spongycastle.util.Integers;

class PEMUtilities {
    private static final Map KEYSIZES;
    private static final Set PKCS5_SCHEME_1;
    private static final Set PKCS5_SCHEME_2;

    PEMUtilities() {
    }

    static {
        HashMap hashMap = new HashMap();
        KEYSIZES = hashMap;
        HashSet hashSet = new HashSet();
        PKCS5_SCHEME_1 = hashSet;
        HashSet hashSet2 = new HashSet();
        PKCS5_SCHEME_2 = hashSet2;
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC);
        hashSet2.add(PKCSObjectIdentifiers.id_PBES2);
        hashSet2.add(PKCSObjectIdentifiers.des_EDE3_CBC);
        hashSet2.add(NISTObjectIdentifiers.id_aes128_CBC);
        hashSet2.add(NISTObjectIdentifiers.id_aes192_CBC);
        hashSet2.add(NISTObjectIdentifiers.id_aes256_CBC);
        hashMap.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), Integers.valueOf(192));
        hashMap.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), Integers.valueOf(128));
        hashMap.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), Integers.valueOf(192));
        hashMap.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), Integers.valueOf(256));
        hashMap.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4.getId(), Integers.valueOf(128));
        hashMap.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4, Integers.valueOf(40));
        hashMap.put(PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC, Integers.valueOf(128));
        hashMap.put(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, Integers.valueOf(192));
        hashMap.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, Integers.valueOf(128));
        hashMap.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC, Integers.valueOf(40));
    }

    static int getKeySize(String str) {
        Map map = KEYSIZES;
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        throw new IllegalStateException("no key size for algorithm: " + str);
    }

    static boolean isPKCS5Scheme1(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return PKCS5_SCHEME_1.contains(aSN1ObjectIdentifier);
    }

    static boolean isPKCS5Scheme2(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return PKCS5_SCHEME_2.contains(aSN1ObjectIdentifier);
    }

    public static boolean isPKCS12(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return aSN1ObjectIdentifier.getId().startsWith(PKCSObjectIdentifiers.pkcs_12PbeIds.getId());
    }

    public static SecretKey generateSecretKeyForPKCS5Scheme2(JcaJceHelper jcaJceHelper, String str, char[] cArr, byte[] bArr, int i) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
        return new SecretKeySpec(jcaJceHelper.createSecretKeyFactory("PBKDF2with8BIT").generateSecret(new PBEKeySpec(cArr, bArr, i, getKeySize(str))).getEncoded(), str);
    }

    static byte[] crypt(boolean z, JcaJceHelper jcaJceHelper, byte[] bArr, char[] cArr, String str, byte[] bArr2) throws PEMException {
        String str2;
        String str3;
        String str4;
        String str5;
        SecretKey secretKey;
        byte[] bArr3;
        AlgorithmParameterSpec algorithmParameterSpec;
        JcaJceHelper jcaJceHelper2 = jcaJceHelper;
        char[] cArr2 = cArr;
        String str6 = str;
        byte[] bArr4 = bArr2;
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (str6.endsWith("-CFB")) {
            str3 = "CFB";
            str2 = "NoPadding";
        } else {
            str3 = "CBC";
            str2 = "PKCS5Padding";
        }
        if (str6.endsWith("-ECB") || "DES-EDE".equals(str6) || "DES-EDE3".equals(str6)) {
            ivParameterSpec = null;
            str3 = "ECB";
        }
        AlgorithmParameterSpec algorithmParameterSpec2 = ivParameterSpec;
        if (str6.endsWith("-OFB")) {
            str5 = "OFB";
            str4 = "NoPadding";
        } else {
            str4 = str2;
            str5 = str3;
        }
        String str7 = "AES";
        int i = 1;
        if (str6.startsWith("DES-EDE")) {
            secretKey = getKey(jcaJceHelper, cArr, "DESede", 24, bArr2, !str6.startsWith("DES-EDE3"));
            str7 = "DESede";
        } else if (str6.startsWith("DES-")) {
            str7 = "DES";
            secretKey = getKey(jcaJceHelper, cArr2, str7, 8, bArr4);
        } else if (str6.startsWith("BF-")) {
            str7 = "Blowfish";
            secretKey = getKey(jcaJceHelper, cArr2, str7, 16, bArr4);
        } else {
            int i2 = 128;
            if (str6.startsWith("RC2-")) {
                str7 = "RC2";
                if (str6.startsWith("RC2-40-")) {
                    i2 = 40;
                } else if (str6.startsWith("RC2-64-")) {
                    i2 = 64;
                }
                secretKey = getKey(jcaJceHelper, cArr2, str7, i2 / 8, bArr4);
                if (algorithmParameterSpec2 == null) {
                    algorithmParameterSpec = new RC2ParameterSpec(i2);
                } else {
                    algorithmParameterSpec = new RC2ParameterSpec(i2, bArr4);
                }
                algorithmParameterSpec2 = algorithmParameterSpec;
            } else if (str6.startsWith("AES-")) {
                if (bArr4.length > 8) {
                    bArr3 = new byte[8];
                    System.arraycopy(bArr4, 0, bArr3, 0, 8);
                } else {
                    bArr3 = bArr4;
                }
                if (!str6.startsWith("AES-128-")) {
                    if (str6.startsWith("AES-192-")) {
                        i2 = 192;
                    } else if (str6.startsWith("AES-256-")) {
                        i2 = 256;
                    } else {
                        throw new EncryptionException("unknown AES encryption with private key");
                    }
                }
                secretKey = getKey(jcaJceHelper, cArr2, str7, i2 / 8, bArr3);
            } else {
                throw new EncryptionException("unknown encryption with private key");
            }
        }
        try {
            Cipher createCipher = jcaJceHelper.createCipher(str7 + "/" + str5 + "/" + str4);
            if (!z) {
                i = 2;
            }
            if (algorithmParameterSpec2 == null) {
                createCipher.init(i, secretKey);
            } else {
                createCipher.init(i, secretKey, algorithmParameterSpec2);
            }
            byte[] bArr5 = bArr;
            return createCipher.doFinal(bArr);
        } catch (Exception e) {
            throw new EncryptionException("exception using cipher - please check password and data.", e);
        }
    }

    private static SecretKey getKey(JcaJceHelper jcaJceHelper, char[] cArr, String str, int i, byte[] bArr) throws PEMException {
        return getKey(jcaJceHelper, cArr, str, i, bArr, false);
    }

    private static SecretKey getKey(JcaJceHelper jcaJceHelper, char[] cArr, String str, int i, byte[] bArr, boolean z) throws PEMException {
        try {
            byte[] encoded = jcaJceHelper.createSecretKeyFactory("PBKDF-OpenSSL").generateSecret(new PBEKeySpec(cArr, bArr, 1, i * 8)).getEncoded();
            if (z && encoded.length >= 24) {
                System.arraycopy(encoded, 0, encoded, 16, 8);
            }
            return new SecretKeySpec(encoded, str);
        } catch (GeneralSecurityException e) {
            throw new PEMException("Unable to create OpenSSL PBDKF: " + e.getMessage(), e);
        }
    }
}
