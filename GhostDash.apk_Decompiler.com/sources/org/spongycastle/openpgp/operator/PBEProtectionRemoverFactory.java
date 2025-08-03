package org.spongycastle.openpgp.operator;

import org.spongycastle.openpgp.PGPException;

public interface PBEProtectionRemoverFactory {
    PBESecretKeyDecryptor createDecryptor(String str) throws PGPException;
}
