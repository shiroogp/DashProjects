package org.spongycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SecretKeyPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    public static final int USAGE_CHECKSUM = 255;
    public static final int USAGE_NONE = 0;
    public static final int USAGE_SHA1 = 254;
    private int encAlgorithm;
    private byte[] iv;
    private PublicKeyPacket pubKeyPacket;
    private S2K s2k;
    private int s2kUsage;
    private byte[] secKeyData;

    SecretKeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        if (this instanceof SecretSubkeyPacket) {
            this.pubKeyPacket = new PublicSubkeyPacket(bCPGInputStream);
        } else {
            this.pubKeyPacket = new PublicKeyPacket(bCPGInputStream);
        }
        int read = bCPGInputStream.read();
        this.s2kUsage = read;
        if (read == 255 || read == 254) {
            this.encAlgorithm = bCPGInputStream.read();
            this.s2k = new S2K((InputStream) bCPGInputStream);
        } else {
            this.encAlgorithm = read;
        }
        S2K s2k2 = this.s2k;
        if (!((s2k2 != null && s2k2.getType() == 101 && this.s2k.getProtectionMode() == 1) || this.s2kUsage == 0)) {
            if (this.encAlgorithm < 7) {
                this.iv = new byte[8];
            } else {
                this.iv = new byte[16];
            }
            byte[] bArr = this.iv;
            bCPGInputStream.readFully(bArr, 0, bArr.length);
        }
        this.secKeyData = bCPGInputStream.readAll();
    }

    public SecretKeyPacket(PublicKeyPacket publicKeyPacket, int i, S2K s2k2, byte[] bArr, byte[] bArr2) {
        this.pubKeyPacket = publicKeyPacket;
        this.encAlgorithm = i;
        if (i != 0) {
            this.s2kUsage = 255;
        } else {
            this.s2kUsage = 0;
        }
        this.s2k = s2k2;
        this.iv = bArr;
        this.secKeyData = bArr2;
    }

    public SecretKeyPacket(PublicKeyPacket publicKeyPacket, int i, int i2, S2K s2k2, byte[] bArr, byte[] bArr2) {
        this.pubKeyPacket = publicKeyPacket;
        this.encAlgorithm = i;
        this.s2kUsage = i2;
        this.s2k = s2k2;
        this.iv = bArr;
        this.secKeyData = bArr2;
    }

    public int getEncAlgorithm() {
        return this.encAlgorithm;
    }

    public int getS2KUsage() {
        return this.s2kUsage;
    }

    public byte[] getIV() {
        return this.iv;
    }

    public S2K getS2K() {
        return this.s2k;
    }

    public PublicKeyPacket getPublicKeyPacket() {
        return this.pubKeyPacket;
    }

    public byte[] getSecretKeyData() {
        return this.secKeyData;
    }

    public byte[] getEncodedContents() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream.write(this.pubKeyPacket.getEncodedContents());
        bCPGOutputStream.write(this.s2kUsage);
        int i = this.s2kUsage;
        if (i == 255 || i == 254) {
            bCPGOutputStream.write(this.encAlgorithm);
            bCPGOutputStream.writeObject(this.s2k);
        }
        byte[] bArr = this.iv;
        if (bArr != null) {
            bCPGOutputStream.write(bArr);
        }
        byte[] bArr2 = this.secKeyData;
        if (bArr2 != null && bArr2.length > 0) {
            bCPGOutputStream.write(bArr2);
        }
        bCPGOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(5, getEncodedContents(), true);
    }
}
