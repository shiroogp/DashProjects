package org.spongycastle.openpgp;

import java.io.EOFException;
import java.io.InputStream;
import kotlin.UByte;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.InputStreamPacket;
import org.spongycastle.bcpg.SymmetricEncIntegrityPacket;
import org.spongycastle.bcpg.SymmetricKeyEncSessionPacket;
import org.spongycastle.openpgp.PGPEncryptedData;
import org.spongycastle.openpgp.operator.PBEDataDecryptorFactory;
import org.spongycastle.openpgp.operator.PGPDataDecryptor;
import org.spongycastle.util.io.TeeInputStream;

public class PGPPBEEncryptedData extends PGPEncryptedData {
    SymmetricKeyEncSessionPacket keyData;

    PGPPBEEncryptedData(SymmetricKeyEncSessionPacket symmetricKeyEncSessionPacket, InputStreamPacket inputStreamPacket) {
        super(inputStreamPacket);
        this.keyData = symmetricKeyEncSessionPacket;
    }

    public int getSymmetricAlgorithm(PBEDataDecryptorFactory pBEDataDecryptorFactory) throws PGPException {
        return pBEDataDecryptorFactory.recoverSessionData(this.keyData.getEncAlgorithm(), pBEDataDecryptorFactory.makeKeyFromPassPhrase(this.keyData.getEncAlgorithm(), this.keyData.getS2K()), this.keyData.getSecKeyData())[0];
    }

    public InputStream getDataStream(PBEDataDecryptorFactory pBEDataDecryptorFactory) throws PGPException {
        try {
            byte[] makeKeyFromPassPhrase = pBEDataDecryptorFactory.makeKeyFromPassPhrase(this.keyData.getEncAlgorithm(), this.keyData.getS2K());
            boolean z = this.encData instanceof SymmetricEncIntegrityPacket;
            byte[] recoverSessionData = pBEDataDecryptorFactory.recoverSessionData(this.keyData.getEncAlgorithm(), makeKeyFromPassPhrase, this.keyData.getSecKeyData());
            boolean z2 = true;
            int length = recoverSessionData.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(recoverSessionData, 1, bArr, 0, length);
            PGPDataDecryptor createDataDecryptor = pBEDataDecryptorFactory.createDataDecryptor(z, recoverSessionData[0] & UByte.MAX_VALUE, bArr);
            this.encStream = new BCPGInputStream(createDataDecryptor.getInputStream(this.encData.getInputStream()));
            if (z) {
                this.truncStream = new PGPEncryptedData.TruncatedStream(this.encStream);
                this.integrityCalculator = createDataDecryptor.getIntegrityCalculator();
                this.encStream = new TeeInputStream(this.truncStream, this.integrityCalculator.getOutputStream());
            }
            int blockSize = createDataDecryptor.getBlockSize();
            byte[] bArr2 = new byte[blockSize];
            int i = 0;
            while (i != blockSize) {
                int read = this.encStream.read();
                if (read >= 0) {
                    bArr2[i] = (byte) read;
                    i++;
                } else {
                    throw new EOFException("unexpected end of stream.");
                }
            }
            int read2 = this.encStream.read();
            int read3 = this.encStream.read();
            if (read2 < 0 || read3 < 0) {
                throw new EOFException("unexpected end of stream.");
            }
            boolean z3 = bArr2[blockSize + -2] == ((byte) read2) && bArr2[blockSize - 1] == ((byte) read3);
            if (read2 != 0 || read3 != 0) {
                z2 = false;
            }
            if (!z3) {
                if (!z2) {
                    throw new PGPDataValidationException("data check failed.");
                }
            }
            return this.encStream;
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception creating cipher", e2);
        }
    }
}
