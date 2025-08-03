package com.drew.imaging.jpeg;

import com.drew.metadata.Metadata;

public interface JpegSegmentMetadataReader {
    Iterable<JpegSegmentType> getSegmentTypes();

    void readJpegSegments(Iterable<byte[]> iterable, Metadata metadata, JpegSegmentType jpegSegmentType);
}
