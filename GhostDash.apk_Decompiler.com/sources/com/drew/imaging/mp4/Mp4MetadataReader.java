package com.drew.imaging.mp4;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.file.FileSystemMetadataReader;
import com.drew.metadata.mp4.Mp4BoxHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Mp4MetadataReader {
    /* JADX INFO: finally extract failed */
    public static Metadata readMetadata(File file) throws ImageProcessingException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Metadata readMetadata = readMetadata((InputStream) fileInputStream);
            fileInputStream.close();
            new FileSystemMetadataReader().read(file, readMetadata);
            return readMetadata;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    public static Metadata readMetadata(InputStream inputStream) throws IOException {
        Metadata metadata = new Metadata();
        Mp4Reader.extract(inputStream, new Mp4BoxHandler(metadata));
        return metadata;
    }
}
