package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.metadata.ErrorDirectory;
import com.drew.metadata.Metadata;
import java.io.IOException;
import java.util.Collections;

public class JpegDnlReader implements JpegSegmentMetadataReader {
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.DNL);
    }

    public void readJpegSegments(Iterable<byte[]> iterable, Metadata metadata, JpegSegmentType jpegSegmentType) {
        for (byte[] extract : iterable) {
            extract(extract, metadata, jpegSegmentType);
        }
    }

    public void extract(byte[] bArr, Metadata metadata, JpegSegmentType jpegSegmentType) {
        JpegDirectory jpegDirectory = (JpegDirectory) metadata.getFirstDirectoryOfType(JpegDirectory.class);
        if (jpegDirectory == null) {
            ErrorDirectory errorDirectory = new ErrorDirectory();
            metadata.addDirectory(errorDirectory);
            errorDirectory.addError("DNL segment found without SOFx - illegal JPEG format");
            return;
        }
        SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(bArr);
        try {
            Integer integer = jpegDirectory.getInteger(1);
            if (integer == null || integer.intValue() == 0) {
                jpegDirectory.setInt(1, sequentialByteArrayReader.getUInt16());
            }
        } catch (IOException e) {
            jpegDirectory.addError(e.getMessage());
        }
    }
}
