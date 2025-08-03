package org.spongycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.spongycastle.util.Iterable;

public class PGPObjectFactory implements Iterable {
    private KeyFingerPrintCalculator fingerPrintCalculator;
    private BCPGInputStream in;

    public PGPObjectFactory(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        this.in = new BCPGInputStream(inputStream);
        this.fingerPrintCalculator = keyFingerPrintCalculator;
    }

    public PGPObjectFactory(byte[] bArr, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        this((InputStream) new ByteArrayInputStream(bArr), keyFingerPrintCalculator);
    }

    public Object nextObject() throws IOException {
        int nextPacketTag = this.in.nextPacketTag();
        if (nextPacketTag == -1) {
            return null;
        }
        if (nextPacketTag == 8) {
            return new PGPCompressedData(this.in);
        }
        if (nextPacketTag == 14) {
            try {
                return PGPPublicKeyRing.readSubkey(this.in, this.fingerPrintCalculator);
            } catch (PGPException e) {
                throw new IOException("processing error: " + e.getMessage());
            }
        } else if (nextPacketTag == 10) {
            return new PGPMarker(this.in);
        } else {
            if (nextPacketTag == 11) {
                return new PGPLiteralData(this.in);
            }
            switch (nextPacketTag) {
                case 1:
                case 3:
                    return new PGPEncryptedDataList(this.in);
                case 2:
                    ArrayList arrayList = new ArrayList();
                    while (this.in.nextPacketTag() == 2) {
                        try {
                            arrayList.add(new PGPSignature(this.in));
                        } catch (PGPException e2) {
                            throw new IOException("can't create signature object: " + e2);
                        }
                    }
                    return new PGPSignatureList((PGPSignature[]) arrayList.toArray(new PGPSignature[arrayList.size()]));
                case 4:
                    ArrayList arrayList2 = new ArrayList();
                    while (this.in.nextPacketTag() == 4) {
                        try {
                            arrayList2.add(new PGPOnePassSignature(this.in));
                        } catch (PGPException e3) {
                            throw new IOException("can't create one pass signature object: " + e3);
                        }
                    }
                    return new PGPOnePassSignatureList((PGPOnePassSignature[]) arrayList2.toArray(new PGPOnePassSignature[arrayList2.size()]));
                case 5:
                    try {
                        return new PGPSecretKeyRing((InputStream) this.in, this.fingerPrintCalculator);
                    } catch (PGPException e4) {
                        throw new IOException("can't create secret key object: " + e4);
                    }
                case 6:
                    return new PGPPublicKeyRing((InputStream) this.in, this.fingerPrintCalculator);
                default:
                    switch (nextPacketTag) {
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                            return this.in.readPacket();
                        default:
                            throw new IOException("unknown object in stream: " + this.in.nextPacketTag());
                    }
            }
        }
    }

    public Iterator iterator() {
        return new Iterator() {
            private Object obj = getObject();

            public boolean hasNext() {
                return this.obj != null;
            }

            public Object next() {
                Object obj2 = this.obj;
                this.obj = getObject();
                return obj2;
            }

            public void remove() {
                throw new UnsupportedOperationException("Cannot remove element from factory.");
            }

            private Object getObject() {
                try {
                    return PGPObjectFactory.this.nextObject();
                } catch (IOException e) {
                    throw new PGPRuntimeOperationException("Iterator failed to get next object: " + e.getMessage(), e);
                }
            }
        };
    }
}
