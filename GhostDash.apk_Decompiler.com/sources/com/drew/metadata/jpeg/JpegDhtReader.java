package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.jpeg.HuffmanTablesDirectory;
import java.io.IOException;
import java.util.Collections;
import kotlin.UByte;

public class JpegDhtReader implements JpegSegmentMetadataReader {
    public Iterable<JpegSegmentType> getSegmentTypes() {
        return Collections.singletonList(JpegSegmentType.DHT);
    }

    public void readJpegSegments(Iterable<byte[]> iterable, Metadata metadata, JpegSegmentType jpegSegmentType) {
        for (byte[] sequentialByteArrayReader : iterable) {
            extract(new SequentialByteArrayReader(sequentialByteArrayReader), metadata);
        }
    }

    public void extract(SequentialReader sequentialReader, Metadata metadata) {
        HuffmanTablesDirectory huffmanTablesDirectory = (HuffmanTablesDirectory) metadata.getFirstDirectoryOfType(HuffmanTablesDirectory.class);
        if (huffmanTablesDirectory == null) {
            huffmanTablesDirectory = new HuffmanTablesDirectory();
            metadata.addDirectory(huffmanTablesDirectory);
        }
        while (sequentialReader.available() > 0) {
            try {
                byte b = sequentialReader.getByte();
                HuffmanTablesDirectory.HuffmanTable.HuffmanTableClass typeOf = HuffmanTablesDirectory.HuffmanTable.HuffmanTableClass.typeOf((b & 240) >> 4);
                byte b2 = b & 15;
                byte[] bytes = getBytes(sequentialReader, 16);
                int i = 0;
                for (byte b3 : bytes) {
                    i += b3 & UByte.MAX_VALUE;
                }
                huffmanTablesDirectory.getTables().add(new HuffmanTablesDirectory.HuffmanTable(typeOf, b2, bytes, getBytes(sequentialReader, i)));
            } catch (IOException e) {
                huffmanTablesDirectory.addError(e.getMessage());
            }
        }
        huffmanTablesDirectory.setInt(1, huffmanTablesDirectory.getTables().size());
    }

    private byte[] getBytes(SequentialReader sequentialReader, int i) throws IOException {
        byte b;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            byte b2 = sequentialReader.getByte();
            if ((b2 & UByte.MAX_VALUE) != 255 || (b = sequentialReader.getByte()) == 0) {
                bArr[i2] = b2;
                i2++;
            } else {
                throw new IOException("Marker " + JpegSegmentType.fromByte(b) + " found inside DHT segment");
            }
        }
        return bArr;
    }
}
