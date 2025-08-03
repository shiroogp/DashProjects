package com.drew.metadata.mov.media;

import com.drew.lang.SequentialReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeMediaHandler;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.atoms.TextSampleDescriptionAtom;
import java.io.IOException;

public class QuickTimeTextHandler extends QuickTimeMediaHandler<QuickTimeTextDirectory> {
    /* access modifiers changed from: protected */
    public String getMediaInformation() {
        return "gmhd";
    }

    /* access modifiers changed from: protected */
    public void processMediaInformation(SequentialReader sequentialReader, Atom atom) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void processTimeToSample(SequentialReader sequentialReader, Atom atom) throws IOException {
    }

    public QuickTimeTextHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    public QuickTimeTextDirectory getDirectory() {
        return new QuickTimeTextDirectory();
    }

    /* access modifiers changed from: protected */
    public void processSampleDescription(SequentialReader sequentialReader, Atom atom) throws IOException {
        new TextSampleDescriptionAtom(sequentialReader, atom).addMetadata((QuickTimeTextDirectory) this.directory);
    }
}
