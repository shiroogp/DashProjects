package com.drew.imaging.avi;

import com.drew.imaging.riff.RiffProcessingException;
import com.drew.imaging.riff.RiffReader;
import com.drew.lang.StreamReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.avi.AviRiffHandler;
import com.drew.metadata.file.FileSystemMetadataReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AviMetadataReader {
    /* JADX INFO: finally extract failed */
    public static Metadata readMetadata(File file) throws IOException, RiffProcessingException {
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

    public static Metadata readMetadata(InputStream inputStream) throws IOException, RiffProcessingException {
        Metadata metadata = new Metadata();
        new RiffReader().processRiff(new StreamReader(inputStream), new AviRiffHandler(metadata));
        return metadata;
    }
}
