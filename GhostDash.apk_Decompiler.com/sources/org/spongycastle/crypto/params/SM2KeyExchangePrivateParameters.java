package org.spongycastle.crypto.params;

import java.util.Objects;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.math.ec.ECPoint;

public class SM2KeyExchangePrivateParameters implements CipherParameters {
    private final ECPrivateKeyParameters ephemeralPrivateKey;
    private final ECPoint ephemeralPublicPoint;
    private final boolean initiator;
    private final ECPrivateKeyParameters staticPrivateKey;
    private final ECPoint staticPublicPoint;

    public SM2KeyExchangePrivateParameters(boolean z, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2) {
        Objects.requireNonNull(eCPrivateKeyParameters, "staticPrivateKey cannot be null");
        Objects.requireNonNull(eCPrivateKeyParameters2, "ephemeralPrivateKey cannot be null");
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        if (parameters.equals(eCPrivateKeyParameters2.getParameters())) {
            this.initiator = z;
            this.staticPrivateKey = eCPrivateKeyParameters;
            this.staticPublicPoint = parameters.getG().multiply(eCPrivateKeyParameters.getD()).normalize();
            this.ephemeralPrivateKey = eCPrivateKeyParameters2;
            this.ephemeralPublicPoint = parameters.getG().multiply(eCPrivateKeyParameters2.getD()).normalize();
            return;
        }
        throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
    }

    public boolean isInitiator() {
        return this.initiator;
    }

    public ECPrivateKeyParameters getStaticPrivateKey() {
        return this.staticPrivateKey;
    }

    public ECPoint getStaticPublicPoint() {
        return this.staticPublicPoint;
    }

    public ECPrivateKeyParameters getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public ECPoint getEphemeralPublicPoint() {
        return this.ephemeralPublicPoint;
    }
}
