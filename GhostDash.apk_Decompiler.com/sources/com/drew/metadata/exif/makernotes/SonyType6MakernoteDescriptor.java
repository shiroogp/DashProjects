package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class SonyType6MakernoteDescriptor extends TagDescriptor<SonyType6MakernoteDirectory> {
    public SonyType6MakernoteDescriptor(SonyType6MakernoteDirectory sonyType6MakernoteDirectory) {
        super(sonyType6MakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i != 8192) {
            return super.getDescription(i);
        }
        return getMakernoteThumbVersionDescription();
    }

    public String getMakernoteThumbVersionDescription() {
        return getVersionBytesDescription(8192, 2);
    }
}
