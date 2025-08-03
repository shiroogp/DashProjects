package org.spongycastle.openpgp.operator;

import org.spongycastle.bcpg.S2K;
import org.spongycastle.openpgp.PGPException;

public abstract class PBEDataDecryptorFactory implements PGPDataDecryptorFactory {
    private PGPDigestCalculatorProvider calculatorProvider;
    private char[] passPhrase;

    public abstract byte[] recoverSessionData(int i, byte[] bArr, byte[] bArr2) throws PGPException;

    protected PBEDataDecryptorFactory(char[] cArr, PGPDigestCalculatorProvider pGPDigestCalculatorProvider) {
        this.passPhrase = cArr;
        this.calculatorProvider = pGPDigestCalculatorProvider;
    }

    public byte[] makeKeyFromPassPhrase(int i, S2K s2k) throws PGPException {
        return PGPUtil.makeKeyFromPassPhrase(this.calculatorProvider, i, s2k, this.passPhrase);
    }
}
