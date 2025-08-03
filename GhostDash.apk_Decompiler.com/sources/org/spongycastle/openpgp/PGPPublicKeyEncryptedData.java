package org.spongycastle.openpgp;

import java.io.EOFException;
import java.io.InputStream;
import kotlin.UByte;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.InputStreamPacket;
import org.spongycastle.bcpg.PublicKeyEncSessionPacket;
import org.spongycastle.bcpg.SymmetricEncIntegrityPacket;
import org.spongycastle.openpgp.PGPEncryptedData;
import org.spongycastle.openpgp.operator.PGPDataDecryptor;
import org.spongycastle.openpgp.operator.PublicKeyDataDecryptorFactory;
import org.spongycastle.util.io.TeeInputStream;

public class PGPPublicKeyEncryptedData extends PGPEncryptedData {
    PublicKeyEncSessionPacket keyData;

    PGPPublicKeyEncryptedData(PublicKeyEncSessionPacket publicKeyEncSessionPacket, InputStreamPacket inputStreamPacket) {
        super(inputStreamPacket);
        this.keyData = publicKeyEncSessionPacket;
    }

    private boolean confirmCheckSum(byte[] bArr) {
        int i = 0;
        for (int i2 = 1; i2 != bArr.length - 2; i2++) {
            i += bArr[i2] & UByte.MAX_VALUE;
        }
        if (bArr[bArr.length - 2] == ((byte) (i >> 8)) && bArr[bArr.length - 1] == ((byte) i)) {
            return true;
        }
        return false;
    }

    public long getKeyID() {
        return this.keyData.getKeyID();
    }

    public int getSymmetricAlgorithm(PublicKeyDataDecryptorFactory publicKeyDataDecryptorFactory) throws PGPException {
        return publicKeyDataDecryptorFactory.recoverSessionData(this.keyData.getAlgorithm(), this.keyData.getEncSessionKey())[0];
    }

    public InputStream getDataStream(PublicKeyDataDecryptorFactory publicKeyDataDecryptorFactory) throws PGPException {
        byte[] recoverSessionData = publicKeyDataDecryptorFactory.recoverSessionData(this.keyData.getAlgorithm(), this.keyData.getEncSessionKey());
        if (confirmCheckSum(recoverSessionData)) {
            int i = 0;
            if (recoverSessionData[0] == 0) {
                return this.encData.getInputStream();
            }
            try {
                boolean z = this.encData instanceof SymmetricEncIntegrityPacket;
                int length = recoverSessionData.length - 3;
                byte[] bArr = new byte[length];
                System.arraycopy(recoverSessionData, 1, bArr, 0, length);
                PGPDataDecryptor createDataDecryptor = publicKeyDataDecryptorFactory.createDataDecryptor(z, recoverSessionData[0] & UByte.MAX_VALUE, bArr);
                this.encStream = new BCPGInputStream(createDataDecryptor.getInputStream(this.encData.getInputStream()));
                if (z) {
                    this.truncStream = new PGPEncryptedData.TruncatedStream(this.encStream);
                    this.integrityCalculator = createDataDecryptor.getIntegrityCalculator();
                    this.encStream = new TeeInputStream(this.truncStream, this.integrityCalculator.getOutputStream());
                }
                int blockSize = createDataDecryptor.getBlockSize();
                byte[] bArr2 = new byte[blockSize];
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
                if (read2 >= 0 && read3 >= 0) {
                    return this.encStream;
                }
                throw new EOFException("unexpected end of stream.");
            } catch (PGPException e) {
                throw e;
            } catch (Exception e2) {
                throw new PGPException("Exception starting decryption", e2);
            }
        } else {
            throw new PGPKeyValidationException("key checksum failed");
        }
    }
}
