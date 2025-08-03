package org.spongycastle.openpgp;

import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
import org.spongycastle.bcpg.BCPGOutputStream;
import org.spongycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.spongycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator;
import org.spongycastle.openpgp.operator.PGPDataEncryptor;
import org.spongycastle.openpgp.operator.PGPDataEncryptorBuilder;
import org.spongycastle.openpgp.operator.PGPDigestCalculator;
import org.spongycastle.openpgp.operator.PGPKeyEncryptionMethodGenerator;
import org.spongycastle.util.io.TeeOutputStream;

public class PGPEncryptedDataGenerator implements SymmetricKeyAlgorithmTags, StreamGenerator {
    public static final int S2K_SHA1 = 2;
    public static final int S2K_SHA224 = 11;
    public static final int S2K_SHA256 = 8;
    public static final int S2K_SHA384 = 9;
    public static final int S2K_SHA512 = 10;
    private OutputStream cOut;
    private PGPDataEncryptorBuilder dataEncryptorBuilder;
    private int defAlgorithm;
    private PGPDigestCalculator digestCalc;
    private OutputStream genOut;
    private List methods;
    private boolean oldFormat;
    private BCPGOutputStream pOut;
    private SecureRandom rand;

    public PGPEncryptedDataGenerator(PGPDataEncryptorBuilder pGPDataEncryptorBuilder) {
        this(pGPDataEncryptorBuilder, false);
    }

    public PGPEncryptedDataGenerator(PGPDataEncryptorBuilder pGPDataEncryptorBuilder, boolean z) {
        this.oldFormat = false;
        this.methods = new ArrayList();
        this.dataEncryptorBuilder = pGPDataEncryptorBuilder;
        this.oldFormat = z;
        this.defAlgorithm = pGPDataEncryptorBuilder.getAlgorithm();
        this.rand = this.dataEncryptorBuilder.getSecureRandom();
    }

    public void addMethod(PGPKeyEncryptionMethodGenerator pGPKeyEncryptionMethodGenerator) {
        this.methods.add(pGPKeyEncryptionMethodGenerator);
    }

    private void addCheckSum(byte[] bArr) {
        int i = 0;
        for (int i2 = 1; i2 != bArr.length - 2; i2++) {
            i += bArr[i2] & UByte.MAX_VALUE;
        }
        bArr[bArr.length - 2] = (byte) (i >> 8);
        bArr[bArr.length - 1] = (byte) i;
    }

    private byte[] createSessionInfo(int i, byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 3)];
        bArr2[0] = (byte) i;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        addCheckSum(bArr2);
        return bArr2;
    }

    private OutputStream open(OutputStream outputStream, long j, byte[] bArr) throws IOException, PGPException, IllegalStateException {
        byte[] bArr2;
        if (this.cOut != null) {
            throw new IllegalStateException("generator already in open state");
        } else if (this.methods.size() != 0) {
            this.pOut = new BCPGOutputStream(outputStream);
            this.defAlgorithm = this.dataEncryptorBuilder.getAlgorithm();
            this.rand = this.dataEncryptorBuilder.getSecureRandom();
            if (this.methods.size() != 1) {
                bArr2 = PGPUtil.makeRandomKey(this.defAlgorithm, this.rand);
                byte[] createSessionInfo = createSessionInfo(this.defAlgorithm, bArr2);
                for (int i = 0; i != this.methods.size(); i++) {
                    this.pOut.writePacket(((PGPKeyEncryptionMethodGenerator) this.methods.get(i)).generate(this.defAlgorithm, createSessionInfo));
                }
            } else if (this.methods.get(0) instanceof PBEKeyEncryptionMethodGenerator) {
                bArr2 = ((PBEKeyEncryptionMethodGenerator) this.methods.get(0)).getKey(this.dataEncryptorBuilder.getAlgorithm());
                this.pOut.writePacket(((PGPKeyEncryptionMethodGenerator) this.methods.get(0)).generate(this.defAlgorithm, (byte[]) null));
            } else {
                bArr2 = PGPUtil.makeRandomKey(this.defAlgorithm, this.rand);
                this.pOut.writePacket(((PGPKeyEncryptionMethodGenerator) this.methods.get(0)).generate(this.defAlgorithm, createSessionInfo(this.defAlgorithm, bArr2)));
            }
            try {
                PGPDataEncryptor build = this.dataEncryptorBuilder.build(bArr2);
                PGPDigestCalculator integrityCalculator = build.getIntegrityCalculator();
                this.digestCalc = integrityCalculator;
                if (bArr == null) {
                    if (integrityCalculator != null) {
                        ClosableBCPGOutputStream closableBCPGOutputStream = new ClosableBCPGOutputStream(outputStream, 18, j + ((long) build.getBlockSize()) + 2 + 1 + 22);
                        this.pOut = closableBCPGOutputStream;
                        closableBCPGOutputStream.write(1);
                    } else {
                        this.pOut = new ClosableBCPGOutputStream(outputStream, 9, j + ((long) build.getBlockSize()) + 2, this.oldFormat);
                    }
                } else if (integrityCalculator != null) {
                    ClosableBCPGOutputStream closableBCPGOutputStream2 = new ClosableBCPGOutputStream(outputStream, 18, bArr);
                    this.pOut = closableBCPGOutputStream2;
                    closableBCPGOutputStream2.write(1);
                } else {
                    this.pOut = new ClosableBCPGOutputStream(outputStream, 9, bArr);
                }
                OutputStream outputStream2 = build.getOutputStream(this.pOut);
                this.cOut = outputStream2;
                this.genOut = outputStream2;
                if (this.digestCalc != null) {
                    this.genOut = new TeeOutputStream(this.digestCalc.getOutputStream(), this.cOut);
                }
                int blockSize = build.getBlockSize() + 2;
                byte[] bArr3 = new byte[blockSize];
                this.rand.nextBytes(bArr3);
                bArr3[blockSize - 1] = bArr3[blockSize - 3];
                bArr3[blockSize - 2] = bArr3[blockSize - 4];
                this.genOut.write(bArr3);
                return new WrappedGeneratorStream(this.genOut, this);
            } catch (Exception e) {
                throw new PGPException("Exception creating cipher", e);
            }
        } else {
            throw new IllegalStateException("no encryption methods specified");
        }
    }

    public OutputStream open(OutputStream outputStream, long j) throws IOException, PGPException {
        return open(outputStream, j, (byte[]) null);
    }

    public OutputStream open(OutputStream outputStream, byte[] bArr) throws IOException, PGPException {
        return open(outputStream, 0, bArr);
    }

    public void close() throws IOException {
        if (this.cOut != null) {
            if (this.digestCalc != null) {
                new BCPGOutputStream(this.genOut, 19, 20).flush();
                this.cOut.write(this.digestCalc.getDigest());
            }
            this.cOut.close();
            this.cOut = null;
            this.pOut = null;
        }
    }

    private class ClosableBCPGOutputStream extends BCPGOutputStream {
        public ClosableBCPGOutputStream(OutputStream outputStream, int i, byte[] bArr) throws IOException {
            super(outputStream, i, bArr);
        }

        public ClosableBCPGOutputStream(OutputStream outputStream, int i, long j, boolean z) throws IOException {
            super(outputStream, i, j, z);
        }

        public ClosableBCPGOutputStream(OutputStream outputStream, int i, long j) throws IOException {
            super(outputStream, i, j);
        }

        public void close() throws IOException {
            finish();
        }
    }
}
