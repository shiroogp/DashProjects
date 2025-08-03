package com.pedrouid.crypto;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Calendar;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.pkcs.RSAPrivateKey;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.util.io.pem.PemObject;
import org.spongycastle.util.io.pem.PemReader;
import org.spongycastle.util.io.pem.PemWriter;

public class RSA {
    public static final String ALGORITHM = "RSA";
    public static Charset CharsetUTF_8 = null;
    private static final String PRIVATE_HEADER = "RSA PRIVATE KEY";
    private static final String PUBLIC_HEADER = "RSA PUBLIC KEY";
    private String keyTag;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSA() {
        setupCharset();
    }

    public RSA(String str) throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, IOException, CertificateException {
        setupCharset();
        this.keyTag = str;
        loadFromKeystore();
    }

    private void setupCharset() {
        if (Build.VERSION.SDK_INT >= 19) {
            CharsetUTF_8 = StandardCharsets.UTF_8;
        } else {
            CharsetUTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
        }
    }

    public String getPublicKey() throws IOException {
        return dataToPem(PUBLIC_HEADER, publicKeyToPkcs1(this.publicKey));
    }

    public String getPrivateKey() throws IOException {
        return dataToPem(PRIVATE_HEADER, privateKeyToPkcs1(this.privateKey));
    }

    public void setPublicKey(String str) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        this.publicKey = pkcs1ToPublicKey(str);
    }

    public void setPrivateKey(String str) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        this.privateKey = pkcs1ToPrivateKey(pemToData(str));
    }

    private byte[] encrypt(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        Cipher instance = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        instance.init(1, this.publicKey);
        return instance.doFinal(bArr);
    }

    public String encrypt64(String str) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        return Base64.encodeToString(encrypt(Base64.decode(str, 0)), 0);
    }

    public String encrypt(String str) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        return Base64.encodeToString(encrypt(str.getBytes(CharsetUTF_8)), 0);
    }

    private byte[] decrypt(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        Cipher instance = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        instance.init(2, this.privateKey);
        return instance.doFinal(bArr);
    }

    public String decrypt(String str) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        return new String(decrypt(Base64.decode(str, 0)), CharsetUTF_8);
    }

    public String decrypt64(String str) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        return Base64.encodeToString(decrypt(Base64.decode(str, 0)), 0);
    }

    private String sign(byte[] bArr, String str) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, SignatureException {
        Signature instance = Signature.getInstance(str);
        instance.initSign(this.privateKey);
        instance.update(bArr);
        return Base64.encodeToString(instance.sign(), 0);
    }

    public String sign64(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, SignatureException {
        return sign(Base64.decode(str, 0), str2);
    }

    public String sign(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, SignatureException {
        return sign(str.getBytes(CharsetUTF_8), str2);
    }

    private boolean verify(byte[] bArr, byte[] bArr2, String str) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, SignatureException {
        Signature instance = Signature.getInstance(str);
        instance.initVerify(this.publicKey);
        instance.update(bArr2);
        return instance.verify(bArr);
    }

    public boolean verify64(String str, String str2, String str3) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, SignatureException {
        Signature.getInstance(str3).initVerify(this.publicKey);
        return verify(Base64.decode(str, 0), Base64.decode(str2, 0), str3);
    }

    public boolean verify(String str, String str2, String str3) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, SignatureException {
        Signature.getInstance(str3).initVerify(this.publicKey);
        return verify(Base64.decode(str, 0), str2.getBytes(CharsetUTF_8), str3);
    }

    private String dataToPem(String str, byte[] bArr) throws IOException {
        PemObject pemObject = new PemObject(str, bArr);
        StringWriter stringWriter = new StringWriter();
        PemWriter pemWriter = new PemWriter(stringWriter);
        pemWriter.writeObject(pemObject);
        pemWriter.close();
        return stringWriter.toString();
    }

    private byte[] pemToData(String str) throws IOException {
        return new PemReader(new StringReader(str)).readPemObject().getContent();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.security.PublicKey pkcs1ToPublicKey(java.lang.String r3) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException {
        /*
            r2 = this;
            r0 = 0
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ all -> 0x002b }
            r1.<init>(r3)     // Catch:{ all -> 0x002b }
            org.spongycastle.openssl.PEMParser r3 = new org.spongycastle.openssl.PEMParser     // Catch:{ all -> 0x0028 }
            r3.<init>(r1)     // Catch:{ all -> 0x0028 }
            java.lang.Object r3 = r3.readObject()     // Catch:{ all -> 0x0028 }
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r3 = (org.spongycastle.asn1.x509.SubjectPublicKeyInfo) r3     // Catch:{ all -> 0x0028 }
            java.security.spec.X509EncodedKeySpec r0 = new java.security.spec.X509EncodedKeySpec     // Catch:{ all -> 0x0028 }
            byte[] r3 = r3.getEncoded()     // Catch:{ all -> 0x0028 }
            r0.<init>(r3)     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = "RSA"
            java.security.KeyFactory r3 = java.security.KeyFactory.getInstance(r3)     // Catch:{ all -> 0x0028 }
            java.security.PublicKey r3 = r3.generatePublic(r0)     // Catch:{ all -> 0x0028 }
            r1.close()
            return r3
        L_0x0028:
            r3 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r3 = move-exception
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()
        L_0x0031:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pedrouid.crypto.RSA.pkcs1ToPublicKey(java.lang.String):java.security.PublicKey");
    }

    private PrivateKey pkcs1ToPrivateKey(byte[] bArr) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        RSAPrivateKey instance = RSAPrivateKey.getInstance(new ASN1InputStream(bArr).readObject());
        return KeyFactory.getInstance(ALGORITHM).generatePrivate(new RSAPrivateKeySpec(instance.getModulus(), instance.getPrivateExponent()));
    }

    private byte[] publicKeyToPkcs1(PublicKey publicKey2) throws IOException {
        return SubjectPublicKeyInfo.getInstance(publicKey2.getEncoded()).parsePublicKey().getEncoded();
    }

    private byte[] privateKeyToPkcs1(PrivateKey privateKey2) throws IOException {
        return PrivateKeyInfo.getInstance(privateKey2.getEncoded()).parsePrivateKey().toASN1Primitive().getEncoded();
    }

    public void loadFromKeystore() throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, IOException, CertificateException {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) instance.getEntry(this.keyTag, (KeyStore.ProtectionParameter) null);
        if (privateKeyEntry != null) {
            this.privateKey = privateKeyEntry.getPrivateKey();
            this.publicKey = privateKeyEntry.getCertificate().getPublicKey();
        }
    }

    public void deletePrivateKey() throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, IOException, CertificateException {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        instance.deleteEntry(this.keyTag);
        this.privateKey = null;
        this.publicKey = null;
    }

    public void generate() throws IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        generate(2048);
    }

    public void generate(int i) throws IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator instance = KeyPairGenerator.getInstance(ALGORITHM);
        instance.initialize(i);
        KeyPair genKeyPair = instance.genKeyPair();
        this.publicKey = genKeyPair.getPublic();
        this.privateKey = genKeyPair.getPrivate();
    }

    public void generate(String str, Context context) throws IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException {
        generate(str, 2048, context);
    }

    public void generate(String str, int i, Context context) throws IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException {
        KeyPairGenerator instance = KeyPairGenerator.getInstance(ALGORITHM, "AndroidKeyStore");
        if (Build.VERSION.SDK_INT >= 23) {
            instance.initialize(new KeyGenParameterSpec.Builder(str, 15).setKeySize(i).setDigests(new String[]{"SHA-512"}).setEncryptionPaddings(new String[]{"PKCS1Padding"}).setSignaturePaddings(new String[]{"PKCS1"}).build());
        } else {
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 1);
            KeyPairGeneratorSpec.Builder endDate = new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal(String.format("CN=%s, OU=%s", new Object[]{str, context.getPackageName()}))).setSerialNumber(BigInteger.ONE).setStartDate(Calendar.getInstance().getTime()).setEndDate(instance2.getTime());
            if (Build.VERSION.SDK_INT >= 19) {
                endDate.setKeySize(i).setKeyType(ALGORITHM);
            }
            instance.initialize(endDate.build());
        }
        this.publicKey = instance.genKeyPair().getPublic();
    }
}
