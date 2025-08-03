package org.spongycastle.openpgp.operator.jcajce;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.spongycastle.bcpg.BCPGKey;
import org.spongycastle.bcpg.MPInteger;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.bcpg.RSAPublicBCPGKey;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;

public class JcaKeyFingerprintCalculator implements KeyFingerPrintCalculator {
    public byte[] calculateFingerprint(PublicKeyPacket publicKeyPacket) throws PGPException {
        BCPGKey key = publicKeyPacket.getKey();
        if (publicKeyPacket.getVersion() <= 3) {
            RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] encoded = new MPInteger(rSAPublicBCPGKey.getModulus()).getEncoded();
                instance.update(encoded, 2, encoded.length - 2);
                byte[] encoded2 = new MPInteger(rSAPublicBCPGKey.getPublicExponent()).getEncoded();
                instance.update(encoded2, 2, encoded2.length - 2);
                return instance.digest();
            } catch (NoSuchAlgorithmException e) {
                throw new PGPException("can't find MD5", e);
            } catch (IOException e2) {
                throw new PGPException("can't encode key components: " + e2.getMessage(), e2);
            }
        } else {
            try {
                byte[] encodedContents = publicKeyPacket.getEncodedContents();
                MessageDigest instance2 = MessageDigest.getInstance("SHA1");
                instance2.update((byte) -103);
                instance2.update((byte) (encodedContents.length >> 8));
                instance2.update((byte) encodedContents.length);
                instance2.update(encodedContents);
                return instance2.digest();
            } catch (NoSuchAlgorithmException e3) {
                throw new PGPException("can't find SHA1", e3);
            } catch (IOException e4) {
                throw new PGPException("can't encode key components: " + e4.getMessage(), e4);
            }
        }
    }
}
