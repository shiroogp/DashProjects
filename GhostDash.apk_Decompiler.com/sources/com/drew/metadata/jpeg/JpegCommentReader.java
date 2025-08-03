package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import java.nio.charset.Charset;
import java.util.Collections;

public class JpegCommentReader implements JpegSegmentMetadataReader {
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.COM);
    }

    public void readJpegSegments(Iterable<byte[]> iterable, Metadata metadata, JpegSegmentType jpegSegmentType) {
        for (byte[] stringValue : iterable) {
            JpegCommentDirectory jpegCommentDirectory = new JpegCommentDirectory();
            metadata.addDirectory(jpegCommentDirectory);
            jpegCommentDirectory.setStringValue(0, new StringValue(stringValue, (Charset) null));
        }
    }
}
