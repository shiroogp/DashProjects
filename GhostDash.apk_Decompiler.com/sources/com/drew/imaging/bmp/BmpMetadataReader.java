package com.drew.imaging.bmp;

import com.drew.lang.StreamReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.bmp.BmpReader;
import com.drew.metadata.file.FileSystemMetadataReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BmpMetadataReader {
    /* JADX INFO: finally extract failed */
    public static Metadata readMetadata(File file) throws IOException {
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

    public static Metadata readMetadata(InputStream inputStream) {
        Metadata metadata = new Metadata();
        new BmpReader().extract(new StreamReader(inputStream), metadata);
        return metadata;
    }
}
