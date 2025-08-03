package org.spongycastle.jcajce.provider.asymmetric.util;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.jce.spec.IESParameterSpec;

public class IESUtil {
    public static IESParameterSpec guessParameterSpec(BufferedBlockCipher bufferedBlockCipher) {
        if (bufferedBlockCipher == null) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 128);
        }
        BlockCipher underlyingCipher = bufferedBlockCipher.getUnderlyingCipher();
        if (underlyingCipher.getAlgorithmName().equals("DES") || underlyingCipher.getAlgorithmName().equals("RC2") || underlyingCipher.getAlgorithmName().equals("RC5-32") || underlyingCipher.getAlgorithmName().equals("RC5-64")) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 64, 64);
        }
        if (underlyingCipher.getAlgorithmName().equals("SKIPJACK")) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 80, 80);
        }
        if (underlyingCipher.getAlgorithmName().equals("GOST28147")) {
            return new IESParameterSpec((byte[]) null, (byte[]) null, 256, 256);
        }
        return new IESParameterSpec((byte[]) null, (byte[]) null, 128, 128);
    }
}
