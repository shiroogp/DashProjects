package com.drew.metadata.mov;

import com.drew.imaging.quicktime.QuickTimeHandler;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.metadata.QuickTimeMetadataDirectory;
import java.io.IOException;

public abstract class QuickTimeMetadataHandler extends QuickTimeHandler {
    /* access modifiers changed from: protected */
    public abstract void processData(byte[] bArr, SequentialByteArrayReader sequentialByteArrayReader) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void processKeys(SequentialByteArrayReader sequentialByteArrayReader) throws IOException;

    public QuickTimeMetadataHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    public QuickTimeDirectory getDirectory() {
        return new QuickTimeMetadataDirectory();
    }

    /* access modifiers changed from: protected */
    public boolean shouldAcceptAtom(Atom atom) {
        return atom.type.equals("hdlr") || atom.type.equals("keys") || atom.type.equals("data");
    }

    /* access modifiers changed from: protected */
    public boolean shouldAcceptContainer(Atom atom) {
        return atom.type.equals("ilst");
    }

    /* access modifiers changed from: protected */
    public QuickTimeHandler processAtom(Atom atom, byte[] bArr) throws IOException {
        if (bArr != null) {
            SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
            if (atom.type.equals("keys")) {
                processKeys(sequentialByteArrayReader);
            } else if (atom.type.equals("data")) {
                processData(bArr, sequentialByteArrayReader);
            }
        }
        return this;
    }
}
