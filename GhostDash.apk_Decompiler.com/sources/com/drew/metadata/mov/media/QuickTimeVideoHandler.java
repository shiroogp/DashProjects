package com.drew.metadata.mov.media;

import com.drew.lang.SequentialReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeMediaHandler;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.atoms.TimeToSampleAtom;
import com.drew.metadata.mov.atoms.VideoInformationMediaHeaderAtom;
import com.drew.metadata.mov.atoms.VideoSampleDescriptionAtom;
import java.io.IOException;

public class QuickTimeVideoHandler extends QuickTimeMediaHandler<QuickTimeVideoDirectory> {
    /* access modifiers changed from: protected */
    public String getMediaInformation() {
        return "vmhd";
    }

    public QuickTimeVideoHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    public QuickTimeVideoDirectory getDirectory() {
        return new QuickTimeVideoDirectory();
    }

    public void processSampleDescription(SequentialReader sequentialReader, Atom atom) throws IOException {
        new VideoSampleDescriptionAtom(sequentialReader, atom).addMetadata((QuickTimeVideoDirectory) this.directory);
    }

    public void processMediaInformation(SequentialReader sequentialReader, Atom atom) throws IOException {
        new VideoInformationMediaHeaderAtom(sequentialReader, atom).addMetadata((QuickTimeVideoDirectory) this.directory);
    }

    public void processTimeToSample(SequentialReader sequentialReader, Atom atom) throws IOException {
        new TimeToSampleAtom(sequentialReader, atom).addMetadata((QuickTimeVideoDirectory) this.directory);
    }
}
