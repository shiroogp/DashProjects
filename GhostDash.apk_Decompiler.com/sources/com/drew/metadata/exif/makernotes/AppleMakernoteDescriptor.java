package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class AppleMakernoteDescriptor extends TagDescriptor<AppleMakernoteDirectory> {
    public AppleMakernoteDescriptor(AppleMakernoteDirectory appleMakernoteDirectory) {
        super(appleMakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i != 10) {
            return super.getDescription(i);
        }
        return getHdrImageTypeDescription();
    }

    public String getHdrImageTypeDescription() {
        return getIndexedDescription(10, 3, "HDR Image", "Original Image");
    }
}
