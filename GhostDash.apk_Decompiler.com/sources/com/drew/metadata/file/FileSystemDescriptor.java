package com.drew.metadata.file;

import com.drew.metadata.TagDescriptor;

public class FileSystemDescriptor extends TagDescriptor<FileSystemDirectory> {
    public FileSystemDescriptor(FileSystemDirectory fileSystemDirectory) {
        super(fileSystemDirectory);
    }

    public String getDescription(int i) {
        if (i != 2) {
            return super.getDescription(i);
        }
        return getFileSizeDescription();
    }

    private String getFileSizeDescription() {
        Long longObject = ((FileSystemDirectory) this._directory).getLongObject(2);
        if (longObject == null) {
            return null;
        }
        return Long.toString(longObject.longValue()) + " bytes";
    }
}
