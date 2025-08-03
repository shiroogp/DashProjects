package com.drew.metadata.jfxx;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.ByteArrayReader;
import com.drew.lang.RandomAccessReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataReader;
import java.io.IOException;
import java.util.Collections;

public class JfxxReader implements JpegSegmentMetadataReader, MetadataReader {
    public static final String PREAMBLE = "JFXX";

    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.APP0);
    }

    public void readJpegSegments(Iterable<byte[]> iterable, Metadata metadata, JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length >= 4 && PREAMBLE.equals(new String(next, 0, 4))) {
                extract(new ByteArrayReader(next), metadata);
            }
        }
    }

    public void extract(RandomAccessReader randomAccessReader, Metadata metadata) {
        JfxxDirectory jfxxDirectory = new JfxxDirectory();
        metadata.addDirectory(jfxxDirectory);
        try {
            jfxxDirectory.setInt(5, randomAccessReader.getUInt8(5));
        } catch (IOException e) {
            jfxxDirectory.addError(e.getMessage());
        }
    }
}
