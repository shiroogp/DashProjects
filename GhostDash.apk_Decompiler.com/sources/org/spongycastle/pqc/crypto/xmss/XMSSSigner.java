package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.StateAwareMessageSigner;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSSignature;
import org.spongycastle.util.Arrays;

public class XMSSSigner implements StateAwareMessageSigner {
    private boolean hasGenerated;
    private boolean initSign;
    private KeyedHashFunctions khf;
    private XMSSPrivateKeyParameters nextKeyGenerator;
    private XMSSParameters params;
    private XMSSPrivateKeyParameters privateKey;
    private XMSSPublicKeyParameters publicKey;

    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.initSign = true;
            this.hasGenerated = false;
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = (XMSSPrivateKeyParameters) cipherParameters;
            this.privateKey = xMSSPrivateKeyParameters;
            this.nextKeyGenerator = xMSSPrivateKeyParameters;
            XMSSParameters parameters = xMSSPrivateKeyParameters.getParameters();
            this.params = parameters;
            this.khf = parameters.getWOTSPlus().getKhf();
            return;
        }
        this.initSign = false;
        XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters) cipherParameters;
        this.publicKey = xMSSPublicKeyParameters;
        XMSSParameters parameters2 = xMSSPublicKeyParameters.getParameters();
        this.params = parameters2;
        this.khf = parameters2.getWOTSPlus().getKhf();
    }

    public byte[] generateSignature(byte[] bArr) {
        Objects.requireNonNull(bArr, "message == null");
        if (this.initSign) {
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this.privateKey;
            if (xMSSPrivateKeyParameters == null) {
                throw new IllegalStateException("signing key no longer usable");
            } else if (!xMSSPrivateKeyParameters.getBDSState().getAuthenticationPath().isEmpty()) {
                int index = this.privateKey.getIndex();
                long j = (long) index;
                if (XMSSUtil.isIndexValid(this.params.getHeight(), j)) {
                    byte[] PRF = this.khf.PRF(this.privateKey.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(j, 32));
                    XMSSSignature xMSSSignature = (XMSSSignature) new XMSSSignature.Builder(this.params).withIndex(index).withRandom(PRF).withWOTSPlusSignature(wotsSign(this.khf.HMsg(Arrays.concatenate(PRF, this.privateKey.getRoot(), XMSSUtil.toBytesBigEndian(j, this.params.getDigestSize())), bArr), (OTSHashAddress) new OTSHashAddress.Builder().withOTSAddress(index).build())).withAuthPath(this.privateKey.getBDSState().getAuthenticationPath()).build();
                    this.hasGenerated = true;
                    XMSSPrivateKeyParameters xMSSPrivateKeyParameters2 = this.nextKeyGenerator;
                    if (xMSSPrivateKeyParameters2 != null) {
                        XMSSPrivateKeyParameters nextKey = xMSSPrivateKeyParameters2.getNextKey();
                        this.privateKey = nextKey;
                        this.nextKeyGenerator = nextKey;
                    } else {
                        this.privateKey = null;
                    }
                    return xMSSSignature.toByteArray();
                }
                throw new IllegalStateException("index out of bounds");
            } else {
                throw new IllegalStateException("not initialized");
            }
        } else {
            throw new IllegalStateException("signer not initialized for signature generation");
        }
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        XMSSSignature build = new XMSSSignature.Builder(this.params).withSignature(bArr2).build();
        int index = build.getIndex();
        this.params.getWOTSPlus().importKeys(new byte[this.params.getDigestSize()], this.publicKey.getPublicSeed());
        long j = (long) index;
        byte[] HMsg = this.khf.HMsg(Arrays.concatenate(build.getRandom(), this.publicKey.getRoot(), XMSSUtil.toBytesBigEndian(j, this.params.getDigestSize())), bArr);
        int height = this.params.getHeight();
        int leafIndex = XMSSUtil.getLeafIndex(j, height);
        return Arrays.constantTimeAreEqual(XMSSVerifierUtil.getRootNodeFromSignature(this.params.getWOTSPlus(), height, HMsg, build, (OTSHashAddress) new OTSHashAddress.Builder().withOTSAddress(index).build(), leafIndex).getValue(), this.publicKey.getRoot());
    }

    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        if (this.hasGenerated) {
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this.privateKey;
            this.privateKey = null;
            this.nextKeyGenerator = null;
            return xMSSPrivateKeyParameters;
        }
        XMSSPrivateKeyParameters nextKey = this.nextKeyGenerator.getNextKey();
        this.nextKeyGenerator = null;
        return nextKey;
    }

    private WOTSPlusSignature wotsSign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr.length == this.params.getDigestSize()) {
            Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
            this.params.getWOTSPlus().importKeys(this.params.getWOTSPlus().getWOTSPlusSecretKey(this.privateKey.getSecretKeySeed(), oTSHashAddress), this.privateKey.getPublicSeed());
            return this.params.getWOTSPlus().sign(bArr, oTSHashAddress);
        }
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
}
