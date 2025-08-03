package com.drew.metadata;

import com.drew.lang.RandomAccessReader;

public interface MetadataReader {
    void extract(RandomAccessReader randomAccessReader, Metadata metadata);
}
