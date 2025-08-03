package org.spongycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import org.spongycastle.bcpg.MPInteger;
import org.spongycastle.bcpg.OnePassSignaturePacket;
import org.spongycastle.bcpg.SignaturePacket;
import org.spongycastle.openpgp.operator.PGPContentSigner;
import org.spongycastle.openpgp.operator.PGPContentSignerBuilder;

public class PGPV3SignatureGenerator {
    private PGPContentSigner contentSigner;
    private PGPContentSignerBuilder contentSignerBuilder;
    private byte lastb;
    private int providedKeyAlgorithm = -1;
    private OutputStream sigOut;
    private int sigType;

    public PGPV3SignatureGenerator(PGPContentSignerBuilder pGPContentSignerBuilder) {
        this.contentSignerBuilder = pGPContentSignerBuilder;
    }

    public void init(int i, PGPPrivateKey pGPPrivateKey) throws PGPException {
        PGPContentSigner build = this.contentSignerBuilder.build(i, pGPPrivateKey);
        this.contentSigner = build;
        this.sigOut = build.getOutputStream();
        this.sigType = this.contentSigner.getType();
        this.lastb = 0;
        int i2 = this.providedKeyAlgorithm;
        if (i2 >= 0 && i2 != this.contentSigner.getKeyAlgorithm()) {
            throw new PGPException("key algorithm mismatch");
        }
    }

    public void update(byte b) {
        if (this.sigType == 1) {
            if (b == 13) {
                byteUpdate((byte) 13);
                byteUpdate((byte) 10);
            } else if (b != 10) {
                byteUpdate(b);
            } else if (this.lastb != 13) {
                byteUpdate((byte) 13);
                byteUpdate((byte) 10);
            }
            this.lastb = b;
            return;
        }
        byteUpdate(b);
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void update(byte[] bArr, int i, int i2) {
        if (this.sigType == 1) {
            int i3 = i2 + i;
            while (i != i3) {
                update(bArr[i]);
                i++;
            }
            return;
        }
        blockUpdate(bArr, i, i2);
    }

    private void byteUpdate(byte b) {
        try {
            this.sigOut.write(b);
        } catch (IOException e) {
            throw new PGPRuntimeOperationException("unable to update signature: " + e.getMessage(), e);
        }
    }

    private void blockUpdate(byte[] bArr, int i, int i2) {
        try {
            this.sigOut.write(bArr, i, i2);
        } catch (IOException e) {
            throw new PGPRuntimeOperationException("unable to update signature: " + e.getMessage(), e);
        }
    }

    public PGPOnePassSignature generateOnePassVersion(boolean z) throws PGPException {
        return new PGPOnePassSignature(new OnePassSignaturePacket(this.sigType, this.contentSigner.getHashAlgorithm(), this.contentSigner.getKeyAlgorithm(), this.contentSigner.getKeyID(), z));
    }

    public PGPSignature generate() throws PGPException {
        long time = new Date().getTime() / 1000;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.sigType);
        byteArrayOutputStream.write((byte) ((int) (time >> 24)));
        byteArrayOutputStream.write((byte) ((int) (time >> 16)));
        byteArrayOutputStream.write((byte) ((int) (time >> 8)));
        byteArrayOutputStream.write((byte) ((int) time));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        blockUpdate(byteArray, 0, byteArray.length);
        MPInteger[] dsaSigToMpi = (this.contentSigner.getKeyAlgorithm() == 3 || this.contentSigner.getKeyAlgorithm() == 1) ? new MPInteger[]{new MPInteger(new BigInteger(1, this.contentSigner.getSignature()))} : PGPUtil.dsaSigToMpi(this.contentSigner.getSignature());
        byte[] digest = this.contentSigner.getDigest();
        return new PGPSignature(new SignaturePacket(3, this.contentSigner.getType(), this.contentSigner.getKeyID(), this.contentSigner.getKeyAlgorithm(), this.contentSigner.getHashAlgorithm(), time * 1000, new byte[]{digest[0], digest[1]}, dsaSigToMpi));
    }
}
