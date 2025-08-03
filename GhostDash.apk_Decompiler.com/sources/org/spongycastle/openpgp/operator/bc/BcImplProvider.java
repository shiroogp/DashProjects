package org.spongycastle.openpgp.operator.bc;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.TigerDigest;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.engines.BlowfishEngine;
import org.spongycastle.crypto.engines.CAST5Engine;
import org.spongycastle.crypto.engines.CamelliaEngine;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.ElGamalEngine;
import org.spongycastle.crypto.engines.IDEAEngine;
import org.spongycastle.crypto.engines.RFC3394WrapEngine;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.signers.DSADigestSigner;
import org.spongycastle.crypto.signers.DSASigner;
import org.spongycastle.crypto.signers.ECDSASigner;
import org.spongycastle.crypto.signers.RSADigestSigner;
import org.spongycastle.openpgp.PGPException;

class BcImplProvider {
    BcImplProvider() {
    }

    static Digest createDigest(int i) throws PGPException {
        switch (i) {
            case 1:
                return new MD5Digest();
            case 2:
                return new SHA1Digest();
            case 3:
                return new RIPEMD160Digest();
            case 5:
                return new MD2Digest();
            case 6:
                return new TigerDigest();
            case 8:
                return new SHA256Digest();
            case 9:
                return new SHA384Digest();
            case 10:
                return new SHA512Digest();
            case 11:
                return new SHA224Digest();
            default:
                throw new PGPException("cannot recognise digest");
        }
    }

    static Signer createSigner(int i, int i2) throws PGPException {
        if (i == 1 || i == 3) {
            return new RSADigestSigner(createDigest(i2));
        }
        if (i == 17) {
            return new DSADigestSigner(new DSASigner(), createDigest(i2));
        }
        if (i == 19) {
            return new DSADigestSigner(new ECDSASigner(), createDigest(i2));
        }
        throw new PGPException("cannot recognise keyAlgorithm: " + i);
    }

    static BlockCipher createBlockCipher(int i) throws PGPException {
        switch (i) {
            case 1:
                return new IDEAEngine();
            case 2:
                return new DESedeEngine();
            case 3:
                return new CAST5Engine();
            case 4:
                return new BlowfishEngine();
            case 6:
                return new DESEngine();
            case 7:
            case 8:
            case 9:
                return new AESEngine();
            case 10:
                return new TwofishEngine();
            case 11:
            case 12:
            case 13:
                return new CamelliaEngine();
            default:
                throw new PGPException("cannot recognise cipher");
        }
    }

    static Wrapper createWrapper(int i) throws PGPException {
        switch (i) {
            case 7:
            case 8:
            case 9:
                return new RFC3394WrapEngine(new AESFastEngine());
            case 11:
            case 12:
            case 13:
                return new RFC3394WrapEngine(new CamelliaEngine());
            default:
                throw new PGPException("unknown wrap algorithm: " + i);
        }
    }

    static AsymmetricBlockCipher createPublicKeyCipher(int i) throws PGPException {
        if (i == 1 || i == 2) {
            return new PKCS1Encoding(new RSABlindedEngine());
        }
        switch (i) {
            case 16:
            case 20:
                return new PKCS1Encoding(new ElGamalEngine());
            case 17:
                throw new PGPException("Can't use DSA for encryption.");
            case 18:
                throw new PGPException("Not implemented.");
            case 19:
                throw new PGPException("Can't use ECDSA for encryption.");
            default:
                throw new PGPException("unknown asymmetric algorithm: " + i);
        }
    }
}
