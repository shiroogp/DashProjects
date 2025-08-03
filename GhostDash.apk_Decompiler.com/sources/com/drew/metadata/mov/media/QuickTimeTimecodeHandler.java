package com.drew.metadata.mov.media;

import com.drew.lang.SequentialReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.mov.QuickTimeAtomTypes;
import com.drew.metadata.mov.QuickTimeMediaHandler;
import com.drew.metadata.mov.atoms.Atom;
import com.drew.metadata.mov.atoms.TimecodeInformationMediaAtom;
import com.drew.metadata.mov.atoms.TimecodeSampleDescriptionAtom;
import java.io.IOException;

public class QuickTimeTimecodeHandler extends QuickTimeMediaHandler<QuickTimeTimecodeDirectory> {
    /* access modifiers changed from: protected */
    public String getMediaInformation() {
        return QuickTimeAtomTypes.ATOM_TIMECODE_MEDIA_INFO;
    }

    /* access modifiers changed from: protected */
    public void processTimeToSample(SequentialReader sequentialReader, Atom atom) throws IOException {
    }

    public QuickTimeTimecodeHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    public QuickTimeTimecodeDirectory getDirectory() {
        return new QuickTimeTimecodeDirectory();
    }

    public void processSampleDescription(SequentialReader sequentialReader, Atom atom) throws IOException {
        new TimecodeSampleDescriptionAtom(sequentialReader, atom).addMetadata((QuickTimeTimecodeDirectory) this.directory);
    }

    public void processMediaInformation(SequentialReader sequentialReader, Atom atom) throws IOException {
        new TimecodeInformationMediaAtom(sequentialReader, atom).addMetadata((QuickTimeTimecodeDirectory) this.directory);
    }
}
