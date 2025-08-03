package com.drew.metadata.mov.media;

import com.drew.lang.SequentialReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeMediaHandler;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.atoms.SubtitleSampleDescriptionAtom;
import java.io.IOException;

public class QuickTimeSubtitleHandler extends QuickTimeMediaHandler<QuickTimeSubtitleDirectory> {
    /* access modifiers changed from: protected */
    public String getMediaInformation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void processMediaInformation(SequentialReader sequentialReader, Atom atom) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void processTimeToSample(SequentialReader sequentialReader, Atom atom) throws IOException {
    }

    public QuickTimeSubtitleHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    public QuickTimeSubtitleDirectory getDirectory() {
        return new QuickTimeSubtitleDirectory();
    }

    /* access modifiers changed from: protected */
    public void processSampleDescription(SequentialReader sequentialReader, Atom atom) throws IOException {
        new SubtitleSampleDescriptionAtom(sequentialReader, atom).addMetadata((QuickTimeSubtitleDirectory) this.directory);
    }
}
