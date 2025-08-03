package com.drew.imaging.quicktime;

import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeDirectory;
import com.drew.metadata.mov.atoms.Atom;
import java.io.IOException;

public abstract class QuickTimeHandler<T extends QuickTimeDirectory> {
    protected T directory;
    protected Metadata metadata;

    /* access modifiers changed from: protected */
    public abstract T getDirectory();

    /* access modifiers changed from: protected */
    public abstract QuickTimeHandler processAtom(Atom atom, byte[] bArr) throws IOException;

    /* access modifiers changed from: protected */
    public abstract boolean shouldAcceptAtom(Atom atom);

    /* access modifiers changed from: protected */
    public abstract boolean shouldAcceptContainer(Atom atom);

    public QuickTimeHandler(Metadata metadata2) {
        this.metadata = metadata2;
        T directory2 = getDirectory();
        this.directory = directory2;
        metadata2.addDirectory(directory2);
    }

    /* access modifiers changed from: protected */
    public QuickTimeHandler processContainer(Atom atom) throws IOException {
        return processAtom(atom, (byte[]) null);
    }

    public void addError(String str) {
        this.directory.addError(str);
    }
}
