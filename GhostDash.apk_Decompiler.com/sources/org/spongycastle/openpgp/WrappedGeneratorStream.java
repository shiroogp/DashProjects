package org.spongycastle.openpgp;

import java.io.IOException;
import java.io.OutputStream;

class WrappedGeneratorStream extends OutputStream {
    private final OutputStream _out;
    private final StreamGenerator _sGen;

    public WrappedGeneratorStream(OutputStream outputStream, StreamGenerator streamGenerator) {
        this._out = outputStream;
        this._sGen = streamGenerator;
    }

    public void write(byte[] bArr) throws IOException {
        this._out.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this._out.write(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        this._out.write(i);
    }

    public void flush() throws IOException {
        this._out.flush();
    }

    public void close() throws IOException {
        this._sGen.close();
    }
}
