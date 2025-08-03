package org.spongycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import kotlin.UByte;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.BCPGObject;
import org.spongycastle.bcpg.BCPGOutputStream;
import org.spongycastle.bcpg.ContainedPacket;
import org.spongycastle.bcpg.DSASecretBCPGKey;
import org.spongycastle.bcpg.ECDSAPublicBCPGKey;
import org.spongycastle.bcpg.ECSecretBCPGKey;
import org.spongycastle.bcpg.ElGamalSecretBCPGKey;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.bcpg.RSASecretBCPGKey;
import org.spongycastle.bcpg.S2K;
import org.spongycastle.bcpg.SecretKeyPacket;
import org.spongycastle.bcpg.SecretSubkeyPacket;
import org.spongycastle.bcpg.UserAttributePacket;
import org.spongycastle.bcpg.UserIDPacket;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.openpgp.operator.PBEProtectionRemoverFactory;
import org.spongycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.spongycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.spongycastle.openpgp.operator.PGPContentSignerBuilder;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;

public class PGPSecretKey {
    PGPPublicKey pub;
    SecretKeyPacket secret;

    PGPSecretKey(SecretKeyPacket secretKeyPacket, PGPPublicKey pGPPublicKey) {
        this.secret = secretKeyPacket;
        this.pub = pGPPublicKey;
    }

    PGPSecretKey(PGPPrivateKey pGPPrivateKey, PGPPublicKey pGPPublicKey, PGPDigestCalculator pGPDigestCalculator, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this(pGPPrivateKey, pGPPublicKey, pGPDigestCalculator, false, pBESecretKeyEncryptor);
    }

    public PGPSecretKey(PGPPrivateKey pGPPrivateKey, PGPPublicKey pGPPublicKey, PGPDigestCalculator pGPDigestCalculator, boolean z, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this.pub = pGPPublicKey;
        this.secret = buildSecretKeyPacket(z, pGPPrivateKey, pGPPublicKey, pBESecretKeyEncryptor, pGPDigestCalculator);
    }

    private static SecretKeyPacket buildSecretKeyPacket(boolean z, PGPPrivateKey pGPPrivateKey, PGPPublicKey pGPPublicKey, PBESecretKeyEncryptor pBESecretKeyEncryptor, PGPDigestCalculator pGPDigestCalculator) throws PGPException {
        int i;
        PGPPublicKey pGPPublicKey2 = pGPPublicKey;
        PBESecretKeyEncryptor pBESecretKeyEncryptor2 = pBESecretKeyEncryptor;
        PGPDigestCalculator pGPDigestCalculator2 = pGPDigestCalculator;
        BCPGObject bCPGObject = (BCPGObject) pGPPrivateKey.getPrivateKeyDataPacket();
        if (bCPGObject != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
                bCPGOutputStream.writeObject(bCPGObject);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bCPGOutputStream.write(checksum(pGPDigestCalculator2, byteArray, byteArray.length));
                int algorithm = pBESecretKeyEncryptor2 != null ? pBESecretKeyEncryptor.getAlgorithm() : 0;
                if (algorithm != 0) {
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    byte[] encryptKeyData = pBESecretKeyEncryptor2.encryptKeyData(byteArray2, 0, byteArray2.length);
                    byte[] cipherIV = pBESecretKeyEncryptor.getCipherIV();
                    S2K s2k = pBESecretKeyEncryptor.getS2K();
                    if (pGPDigestCalculator2 == null) {
                        i = 255;
                    } else if (pGPDigestCalculator.getAlgorithm() == 2) {
                        i = 254;
                    } else {
                        throw new PGPException("only SHA1 supported for key checksum calculations.");
                    }
                    int i2 = i;
                    if (z) {
                        return new SecretKeyPacket(pGPPublicKey2.publicPk, algorithm, i2, s2k, cipherIV, encryptKeyData);
                    }
                    return new SecretSubkeyPacket(pGPPublicKey2.publicPk, algorithm, i2, s2k, cipherIV, encryptKeyData);
                } else if (z) {
                    return new SecretKeyPacket(pGPPublicKey2.publicPk, algorithm, (S2K) null, (byte[]) null, byteArrayOutputStream.toByteArray());
                } else {
                    return new SecretSubkeyPacket(pGPPublicKey2.publicPk, algorithm, (S2K) null, (byte[]) null, byteArrayOutputStream.toByteArray());
                }
            } catch (PGPException e) {
                throw e;
            } catch (Exception e2) {
                throw new PGPException("Exception encrypting key", e2);
            }
        } else if (z) {
            return new SecretKeyPacket(pGPPublicKey2.publicPk, 0, (S2K) null, (byte[]) null, new byte[0]);
        } else {
            return new SecretSubkeyPacket(pGPPublicKey2.publicPk, 0, (S2K) null, (byte[]) null, new byte[0]);
        }
    }

    public PGPSecretKey(int i, PGPKeyPair pGPKeyPair, String str, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, PGPContentSignerBuilder pGPContentSignerBuilder, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this(i, pGPKeyPair, str, (PGPDigestCalculator) null, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, pGPContentSignerBuilder, pBESecretKeyEncryptor);
    }

    public PGPSecretKey(int i, PGPKeyPair pGPKeyPair, String str, PGPDigestCalculator pGPDigestCalculator, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, PGPContentSignerBuilder pGPContentSignerBuilder, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this(pGPKeyPair.getPrivateKey(), certifiedPublicKey(i, pGPKeyPair, str, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, pGPContentSignerBuilder), pGPDigestCalculator, true, pBESecretKeyEncryptor);
    }

    private static PGPPublicKey certifiedPublicKey(int i, PGPKeyPair pGPKeyPair, String str, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, PGPContentSignerBuilder pGPContentSignerBuilder) throws PGPException {
        try {
            PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(pGPContentSignerBuilder);
            pGPSignatureGenerator.init(i, pGPKeyPair.getPrivateKey());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketVector);
            pGPSignatureGenerator.setUnhashedSubpackets(pGPSignatureSubpacketVector2);
            try {
                return PGPPublicKey.addCertification(pGPKeyPair.getPublicKey(), str, pGPSignatureGenerator.generateCertification(str, pGPKeyPair.getPublicKey()));
            } catch (Exception e) {
                throw new PGPException("exception doing certification: " + e, e);
            }
        } catch (Exception e2) {
            throw new PGPException("creating signature generator: " + e2, e2);
        }
    }

    public boolean isSigningKey() {
        int algorithm = this.pub.getAlgorithm();
        return algorithm == 1 || algorithm == 3 || algorithm == 17 || algorithm == 19 || algorithm == 20;
    }

    public boolean isMasterKey() {
        return this.pub.isMasterKey();
    }

    public boolean isPrivateKeyEmpty() {
        byte[] secretKeyData = this.secret.getSecretKeyData();
        if (secretKeyData == null || secretKeyData.length < 1) {
            return true;
        }
        return false;
    }

    public int getKeyEncryptionAlgorithm() {
        return this.secret.getEncAlgorithm();
    }

    public long getKeyID() {
        return this.pub.getKeyID();
    }

    public int getS2KUsage() {
        return this.secret.getS2KUsage();
    }

    public S2K getS2K() {
        return this.secret.getS2K();
    }

    public PGPPublicKey getPublicKey() {
        return this.pub;
    }

    public Iterator getUserIDs() {
        return this.pub.getUserIDs();
    }

    public Iterator getUserAttributes() {
        return this.pub.getUserAttributes();
    }

    private byte[] extractKeyData(PBESecretKeyDecryptor pBESecretKeyDecryptor) throws PGPException {
        int i;
        PBESecretKeyDecryptor pBESecretKeyDecryptor2 = pBESecretKeyDecryptor;
        byte[] secretKeyData = this.secret.getSecretKeyData();
        if (this.secret.getEncAlgorithm() == 0) {
            return secretKeyData;
        }
        try {
            int i2 = 0;
            if (this.secret.getPublicKeyPacket().getVersion() == 4) {
                byte[] recoverKeyData = pBESecretKeyDecryptor.recoverKeyData(this.secret.getEncAlgorithm(), pBESecretKeyDecryptor2.makeKeyFromPassPhrase(this.secret.getEncAlgorithm(), this.secret.getS2K()), this.secret.getIV(), secretKeyData, 0, secretKeyData.length);
                boolean z = this.secret.getS2KUsage() == 254;
                byte[] checksum = checksum(z ? pBESecretKeyDecryptor2.getChecksumCalculator(2) : null, recoverKeyData, z ? recoverKeyData.length - 20 : recoverKeyData.length - 2);
                while (i2 != checksum.length) {
                    if (checksum[i2] == recoverKeyData[(recoverKeyData.length - checksum.length) + i2]) {
                        i2++;
                    } else {
                        throw new PGPException("checksum mismatch at " + i2 + " of " + checksum.length);
                    }
                }
                return recoverKeyData;
            }
            byte[] makeKeyFromPassPhrase = pBESecretKeyDecryptor2.makeKeyFromPassPhrase(this.secret.getEncAlgorithm(), this.secret.getS2K());
            int length = secretKeyData.length;
            byte[] bArr = new byte[length];
            int length2 = this.secret.getIV().length;
            byte[] bArr2 = new byte[length2];
            System.arraycopy(this.secret.getIV(), 0, bArr2, 0, length2);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 4; i3 != i5; i5 = 4) {
                int i6 = i4 + 1;
                int i7 = (((secretKeyData[i4] << 8) | (secretKeyData[i6] & UByte.MAX_VALUE)) + 7) / 8;
                bArr[i4] = secretKeyData[i4];
                bArr[i6] = secretKeyData[i6];
                int i8 = i4 + 2;
                int i9 = i3;
                byte[] bArr3 = bArr2;
                int i10 = length2;
                byte[] recoverKeyData2 = pBESecretKeyDecryptor.recoverKeyData(this.secret.getEncAlgorithm(), makeKeyFromPassPhrase, bArr2, secretKeyData, i8, i7);
                System.arraycopy(recoverKeyData2, 0, bArr, i8, recoverKeyData2.length);
                i4 += i7 + 2;
                if (i9 != 3) {
                    i = i10;
                    System.arraycopy(secretKeyData, i4 - i, bArr3, 0, i);
                } else {
                    i = i10;
                }
                i3 = i9 + 1;
                length2 = i;
                bArr2 = bArr3;
            }
            bArr[i4] = secretKeyData[i4];
            int i11 = i4 + 1;
            bArr[i11] = secretKeyData[i11];
            byte b = (secretKeyData[i11] & UByte.MAX_VALUE) | ((secretKeyData[i4] << 8) & 65280);
            int i12 = 0;
            while (i2 < length - 2) {
                i12 += bArr[i2] & UByte.MAX_VALUE;
                i2++;
            }
            byte b2 = i12 & UByte.MAX_VALUE;
            if (b2 == b) {
                return bArr;
            }
            throw new PGPException("checksum mismatch: passphrase wrong, expected " + Integer.toHexString(b) + " found " + Integer.toHexString(b2));
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception decrypting key", e2);
        }
    }

    public PGPPrivateKey extractPrivateKey(PBESecretKeyDecryptor pBESecretKeyDecryptor) throws PGPException {
        if (isPrivateKeyEmpty()) {
            return null;
        }
        PublicKeyPacket publicKeyPacket = this.secret.getPublicKeyPacket();
        try {
            BCPGInputStream bCPGInputStream = new BCPGInputStream(new ByteArrayInputStream(extractKeyData(pBESecretKeyDecryptor)));
            int algorithm = publicKeyPacket.getAlgorithm();
            if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
                return new PGPPrivateKey(getKeyID(), publicKeyPacket, new RSASecretBCPGKey(bCPGInputStream));
            }
            switch (algorithm) {
                case 16:
                case 20:
                    return new PGPPrivateKey(getKeyID(), publicKeyPacket, new ElGamalSecretBCPGKey(bCPGInputStream));
                case 17:
                    return new PGPPrivateKey(getKeyID(), publicKeyPacket, new DSASecretBCPGKey(bCPGInputStream));
                case 18:
                case 19:
                    return new PGPPrivateKey(getKeyID(), publicKeyPacket, new ECSecretBCPGKey(bCPGInputStream));
                default:
                    throw new PGPException("unknown public key algorithm encountered");
            }
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception constructing key", e2);
        }
    }

    private static byte[] checksum(PGPDigestCalculator pGPDigestCalculator, byte[] bArr, int i) throws PGPException {
        if (pGPDigestCalculator != null) {
            OutputStream outputStream = pGPDigestCalculator.getOutputStream();
            try {
                outputStream.write(bArr, 0, i);
                outputStream.close();
                return pGPDigestCalculator.getDigest();
            } catch (Exception e) {
                throw new PGPException("checksum digest calculation failed: " + e.getMessage(), e);
            }
        } else {
            int i2 = 0;
            for (int i3 = 0; i3 != i; i3++) {
                i2 += bArr[i3] & UByte.MAX_VALUE;
            }
            return new byte[]{(byte) (i2 >> 8), (byte) i2};
        }
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void encode(OutputStream outputStream) throws IOException {
        BCPGOutputStream bCPGOutputStream;
        if (outputStream instanceof BCPGOutputStream) {
            bCPGOutputStream = (BCPGOutputStream) outputStream;
        } else {
            bCPGOutputStream = new BCPGOutputStream(outputStream);
        }
        bCPGOutputStream.writePacket(this.secret);
        if (this.pub.trustPk != null) {
            bCPGOutputStream.writePacket(this.pub.trustPk);
        }
        if (this.pub.subSigs == null) {
            for (int i = 0; i != this.pub.keySigs.size(); i++) {
                ((PGPSignature) this.pub.keySigs.get(i)).encode(bCPGOutputStream);
            }
            for (int i2 = 0; i2 != this.pub.ids.size(); i2++) {
                if (this.pub.ids.get(i2) instanceof UserIDPacket) {
                    bCPGOutputStream.writePacket((UserIDPacket) this.pub.ids.get(i2));
                } else {
                    bCPGOutputStream.writePacket(new UserAttributePacket(((PGPUserAttributeSubpacketVector) this.pub.ids.get(i2)).toSubpacketArray()));
                }
                if (this.pub.idTrusts.get(i2) != null) {
                    bCPGOutputStream.writePacket((ContainedPacket) this.pub.idTrusts.get(i2));
                }
                ArrayList arrayList = (ArrayList) this.pub.idSigs.get(i2);
                for (int i3 = 0; i3 != arrayList.size(); i3++) {
                    ((PGPSignature) arrayList.get(i3)).encode(bCPGOutputStream);
                }
            }
            return;
        }
        for (int i4 = 0; i4 != this.pub.subSigs.size(); i4++) {
            ((PGPSignature) this.pub.subSigs.get(i4)).encode(bCPGOutputStream);
        }
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [org.spongycastle.bcpg.SecretKeyPacket] */
    /* JADX WARNING: type inference failed for: r11v2, types: [org.spongycastle.bcpg.SecretKeyPacket] */
    /* JADX WARNING: type inference failed for: r11v3, types: [org.spongycastle.bcpg.SecretSubkeyPacket] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.spongycastle.openpgp.PGPSecretKey copyWithNewPassword(org.spongycastle.openpgp.PGPSecretKey r20, org.spongycastle.openpgp.operator.PBESecretKeyDecryptor r21, org.spongycastle.openpgp.operator.PBESecretKeyEncryptor r22) throws org.spongycastle.openpgp.PGPException {
        /*
            r0 = r20
            r7 = r22
            boolean r1 = r20.isPrivateKeyEmpty()
            if (r1 != 0) goto L_0x012d
            byte[] r8 = r20.extractKeyData(r21)
            org.spongycastle.bcpg.SecretKeyPacket r1 = r0.secret
            int r1 = r1.getS2KUsage()
            r2 = 0
            r9 = 1
            r10 = 0
            if (r7 == 0) goto L_0x00d8
            int r3 = r22.getAlgorithm()
            if (r3 != 0) goto L_0x0021
            goto L_0x00d8
        L_0x0021:
            r11 = 255(0xff, float:3.57E-43)
            if (r1 != 0) goto L_0x0027
            r12 = r11
            goto L_0x0028
        L_0x0027:
            r12 = r1
        L_0x0028:
            org.spongycastle.bcpg.SecretKeyPacket r1 = r0.secret
            org.spongycastle.bcpg.PublicKeyPacket r1 = r1.getPublicKeyPacket()
            int r1 = r1.getVersion()
            r13 = 4
            if (r1 >= r13) goto L_0x00bf
            byte[] r14 = r22.getKey()
            int r1 = r8.length
            byte[] r15 = new byte[r1]
            int r1 = r22.getHashAlgorithm()
            if (r1 != r9) goto L_0x00b7
            r6 = r2
            r5 = r10
            r16 = r5
        L_0x0046:
            if (r5 == r13) goto L_0x009b
            byte r1 = r8[r16]
            int r1 = r1 << 8
            int r2 = r16 + 1
            byte r3 = r8[r2]
            r3 = r3 & r11
            r1 = r1 | r3
            int r1 = r1 + 7
            int r4 = r1 / 8
            byte r1 = r8[r16]
            r15[r16] = r1
            byte r1 = r8[r2]
            r15[r2] = r1
            if (r5 != 0) goto L_0x006f
            int r1 = r16 + 2
            byte[] r1 = r7.encryptKeyData(r14, r8, r1, r4)
            byte[] r6 = r22.getCipherIV()
            r18 = r4
            r19 = r5
            goto L_0x008e
        L_0x006f:
            int r1 = r6.length
            byte[] r3 = new byte[r1]
            int r2 = r6.length
            int r2 = r16 - r2
            java.lang.System.arraycopy(r15, r2, r3, r10, r1)
            int r17 = r16 + 2
            r1 = r22
            r2 = r14
            r18 = r4
            r4 = r8
            r19 = r5
            r5 = r17
            r17 = r6
            r6 = r18
            byte[] r1 = r1.encryptKeyData(r2, r3, r4, r5, r6)
            r6 = r17
        L_0x008e:
            int r2 = r16 + 2
            int r3 = r1.length
            java.lang.System.arraycopy(r1, r10, r15, r2, r3)
            int r4 = r18 + 2
            int r16 = r16 + r4
            int r5 = r19 + 1
            goto L_0x0046
        L_0x009b:
            r17 = r6
            byte r1 = r8[r16]
            r15[r16] = r1
            int r16 = r16 + 1
            byte r1 = r8[r16]
            r15[r16] = r1
            org.spongycastle.bcpg.S2K r2 = r22.getS2K()
            int r10 = r22.getAlgorithm()
            r13 = r10
            r14 = r12
            r16 = r17
            r17 = r15
            r15 = r2
            goto L_0x0106
        L_0x00b7:
            org.spongycastle.openpgp.PGPException r0 = new org.spongycastle.openpgp.PGPException
            java.lang.String r1 = "MD5 Digest Calculator required for version 3 key encryptor."
            r0.<init>(r1)
            throw r0
        L_0x00bf:
            int r1 = r8.length
            byte[] r8 = r7.encryptKeyData(r8, r10, r1)
            byte[] r2 = r22.getCipherIV()
            org.spongycastle.bcpg.S2K r1 = r22.getS2K()
            int r10 = r22.getAlgorithm()
            r15 = r1
            r16 = r2
            r17 = r8
            r13 = r10
            r14 = r12
            goto L_0x0106
        L_0x00d8:
            org.spongycastle.bcpg.SecretKeyPacket r1 = r0.secret
            int r1 = r1.getS2KUsage()
            r3 = 254(0xfe, float:3.56E-43)
            if (r1 != r3) goto L_0x00ff
            int r1 = r8.length
            int r1 = r1 + -18
            byte[] r3 = new byte[r1]
            int r4 = r1 + -2
            java.lang.System.arraycopy(r8, r10, r3, r10, r4)
            byte[] r5 = checksum(r2, r3, r4)
            byte r6 = r5[r10]
            r3[r4] = r6
            int r1 = r1 - r9
            byte r4 = r5[r9]
            r3[r1] = r4
            r15 = r2
            r16 = r15
            r17 = r3
            goto L_0x0104
        L_0x00ff:
            r15 = r2
            r16 = r15
            r17 = r8
        L_0x0104:
            r13 = r10
            r14 = r13
        L_0x0106:
            org.spongycastle.bcpg.SecretKeyPacket r1 = r0.secret
            boolean r1 = r1 instanceof org.spongycastle.bcpg.SecretSubkeyPacket
            if (r1 == 0) goto L_0x0119
            org.spongycastle.bcpg.SecretSubkeyPacket r1 = new org.spongycastle.bcpg.SecretSubkeyPacket
            org.spongycastle.bcpg.SecretKeyPacket r2 = r0.secret
            org.spongycastle.bcpg.PublicKeyPacket r12 = r2.getPublicKeyPacket()
            r11 = r1
            r11.<init>(r12, r13, r14, r15, r16, r17)
            goto L_0x0125
        L_0x0119:
            org.spongycastle.bcpg.SecretKeyPacket r1 = new org.spongycastle.bcpg.SecretKeyPacket
            org.spongycastle.bcpg.SecretKeyPacket r2 = r0.secret
            org.spongycastle.bcpg.PublicKeyPacket r12 = r2.getPublicKeyPacket()
            r11 = r1
            r11.<init>(r12, r13, r14, r15, r16, r17)
        L_0x0125:
            org.spongycastle.openpgp.PGPSecretKey r2 = new org.spongycastle.openpgp.PGPSecretKey
            org.spongycastle.openpgp.PGPPublicKey r0 = r0.pub
            r2.<init>(r1, r0)
            return r2
        L_0x012d:
            org.spongycastle.openpgp.PGPException r0 = new org.spongycastle.openpgp.PGPException
            java.lang.String r1 = "no private key in this SecretKey - public key present only."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.openpgp.PGPSecretKey.copyWithNewPassword(org.spongycastle.openpgp.PGPSecretKey, org.spongycastle.openpgp.operator.PBESecretKeyDecryptor, org.spongycastle.openpgp.operator.PBESecretKeyEncryptor):org.spongycastle.openpgp.PGPSecretKey");
    }

    public static PGPSecretKey replacePublicKey(PGPSecretKey pGPSecretKey, PGPPublicKey pGPPublicKey) {
        if (pGPPublicKey.getKeyID() == pGPSecretKey.getKeyID()) {
            return new PGPSecretKey(pGPSecretKey.secret, pGPPublicKey);
        }
        throw new IllegalArgumentException("keyIDs do not match");
    }

    public static PGPSecretKey parseSecretKeyFromSExpr(InputStream inputStream, PBEProtectionRemoverFactory pBEProtectionRemoverFactory, PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        SXprUtils.skipOpenParenthesis(inputStream);
        if (SXprUtils.readString(inputStream, inputStream.read()).equals("protected-private-key")) {
            SXprUtils.skipOpenParenthesis(inputStream);
            if (SXprUtils.readString(inputStream, inputStream.read()).equals("ecc")) {
                SXprUtils.skipOpenParenthesis(inputStream);
                SXprUtils.readString(inputStream, inputStream.read());
                String readString = SXprUtils.readString(inputStream, inputStream.read());
                SXprUtils.skipCloseParenthesis(inputStream);
                SXprUtils.skipOpenParenthesis(inputStream);
                if (SXprUtils.readString(inputStream, inputStream.read()).equals("q")) {
                    SXprUtils.readBytes(inputStream, inputStream.read());
                    SXprUtils.skipCloseParenthesis(inputStream);
                    return new PGPSecretKey(new SecretKeyPacket(pGPPublicKey.getPublicKeyPacket(), 0, (S2K) null, (byte[]) null, new ECSecretBCPGKey(new BigInteger(1, getDValue(inputStream, pBEProtectionRemoverFactory, readString))).getEncoded()), pGPPublicKey);
                }
                throw new PGPException("no q value found");
            }
            throw new PGPException("no curve details found");
        }
        throw new PGPException("unknown key type found");
    }

    public static PGPSecretKey parseSecretKeyFromSExpr(InputStream inputStream, PBEProtectionRemoverFactory pBEProtectionRemoverFactory, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException, PGPException {
        SXprUtils.skipOpenParenthesis(inputStream);
        if (SXprUtils.readString(inputStream, inputStream.read()).equals("protected-private-key")) {
            SXprUtils.skipOpenParenthesis(inputStream);
            if (SXprUtils.readString(inputStream, inputStream.read()).equals("ecc")) {
                SXprUtils.skipOpenParenthesis(inputStream);
                SXprUtils.readString(inputStream, inputStream.read());
                String readString = SXprUtils.readString(inputStream, inputStream.read());
                if (readString.startsWith("NIST ")) {
                    readString = readString.substring(5);
                }
                SXprUtils.skipCloseParenthesis(inputStream);
                SXprUtils.skipOpenParenthesis(inputStream);
                if (SXprUtils.readString(inputStream, inputStream.read()).equals("q")) {
                    PublicKeyPacket publicKeyPacket = new PublicKeyPacket(19, new Date(), new ECDSAPublicBCPGKey(ECNamedCurveTable.getOID(readString), new BigInteger(1, SXprUtils.readBytes(inputStream, inputStream.read()))));
                    SXprUtils.skipCloseParenthesis(inputStream);
                    return new PGPSecretKey(new SecretKeyPacket(publicKeyPacket, 0, (S2K) null, (byte[]) null, new ECSecretBCPGKey(new BigInteger(1, getDValue(inputStream, pBEProtectionRemoverFactory, readString))).getEncoded()), new PGPPublicKey(publicKeyPacket, keyFingerPrintCalculator));
                }
                throw new PGPException("no q value found");
            }
            throw new PGPException("no curve details found");
        }
        throw new PGPException("unknown key type found");
    }

    private static byte[] getDValue(InputStream inputStream, PBEProtectionRemoverFactory pBEProtectionRemoverFactory, String str) throws IOException, PGPException {
        SXprUtils.skipOpenParenthesis(inputStream);
        if (SXprUtils.readString(inputStream, inputStream.read()).equals("protected")) {
            String readString = SXprUtils.readString(inputStream, inputStream.read());
            SXprUtils.skipOpenParenthesis(inputStream);
            S2K parseS2K = SXprUtils.parseS2K(inputStream);
            byte[] readBytes = SXprUtils.readBytes(inputStream, inputStream.read());
            SXprUtils.skipCloseParenthesis(inputStream);
            byte[] readBytes2 = SXprUtils.readBytes(inputStream, inputStream.read());
            PBESecretKeyDecryptor createDecryptor = pBEProtectionRemoverFactory.createDecryptor(readString);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(createDecryptor.recoverKeyData(7, createDecryptor.makeKeyFromPassPhrase(7, parseS2K), readBytes, readBytes2, 0, readBytes2.length));
            SXprUtils.skipOpenParenthesis(byteArrayInputStream);
            SXprUtils.skipOpenParenthesis(byteArrayInputStream);
            SXprUtils.skipOpenParenthesis(byteArrayInputStream);
            SXprUtils.readString(byteArrayInputStream, byteArrayInputStream.read());
            return SXprUtils.readBytes(byteArrayInputStream, byteArrayInputStream.read());
        }
        throw new PGPException("protected block not found");
    }
}
