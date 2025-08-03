package org.spongycastle.openpgp.operator.bc;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.io.CipherInputStream;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.openpgp.operator.PGPDataDecryptor;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;
import org.spongycastle.util.BigIntegers;

class BcUtil {
    BcUtil() {
    }

    static BufferedBlockCipher createStreamCipher(boolean z, BlockCipher blockCipher, boolean z2, byte[] bArr) {
        BufferedBlockCipher bufferedBlockCipher;
        if (z2) {
            bufferedBlockCipher = new BufferedBlockCipher(new CFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
        } else {
            bufferedBlockCipher = new BufferedBlockCipher(new OpenPGPCFBBlockCipher(blockCipher));
        }
        KeyParameter keyParameter = new KeyParameter(bArr);
        if (z2) {
            bufferedBlockCipher.init(z, new ParametersWithIV(keyParameter, new byte[blockCipher.getBlockSize()]));
        } else {
            bufferedBlockCipher.init(z, keyParameter);
        }
        return bufferedBlockCipher;
    }

    public static PGPDataDecryptor createDataDecryptor(boolean z, BlockCipher blockCipher, byte[] bArr) {
        final BufferedBlockCipher createStreamCipher = createStreamCipher(false, blockCipher, z, bArr);
        return new PGPDataDecryptor() {
            public InputStream getInputStream(InputStream inputStream) {
                return new CipherInputStream(inputStream, createStreamCipher);
            }

            public int getBlockSize() {
                return createStreamCipher.getBlockSize();
            }

            public PGPDigestCalculator getIntegrityCalculator() {
                return new SHA1PGPDigestCalculator();
            }
        };
    }

    public static BufferedBlockCipher createSymmetricKeyWrapper(boolean z, BlockCipher blockCipher, byte[] bArr, byte[] bArr2) {
        BufferedBlockCipher bufferedBlockCipher = new BufferedBlockCipher(new CFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
        bufferedBlockCipher.init(z, new ParametersWithIV(new KeyParameter(bArr), bArr2));
        return bufferedBlockCipher;
    }

    static X9ECParameters getX9Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = CustomNamedCurves.getByOID(aSN1ObjectIdentifier);
        return byOID == null ? ECNamedCurveTable.getByOID(aSN1ObjectIdentifier) : byOID;
    }

    static ECPoint decodePoint(BigInteger bigInteger, ECCurve eCCurve) throws IOException {
        return eCCurve.decodePoint(BigIntegers.asUnsignedByteArray(bigInteger));
    }
}
