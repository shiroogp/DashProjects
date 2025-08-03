package com.drew.metadata.mp4.media;

import com.drew.lang.SequentialReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.mp4.Mp4MediaHandler;
import com.drew.metadata.mp4.boxes.Box;
import java.io.IOException;

public class Mp4MetaHandler extends Mp4MediaHandler<Mp4MetaDirectory> {
    /* access modifiers changed from: protected */
    public String getMediaInformation() {
        return "nmhd";
    }

    /* access modifiers changed from: protected */
    public void processMediaInformation(SequentialReader sequentialReader, Box box) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void processSampleDescription(SequentialReader sequentialReader, Box box) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void processTimeToSample(SequentialReader sequentialReader, Box box) throws IOException {
    }

    public Mp4MetaHandler(Metadata metadata) {
        super(metadata);
    }

    /* access modifiers changed from: protected */
    public Mp4MetaDirectory getDirectory() {
        return (Mp4MetaDirectory) this.directory;
    }
}
