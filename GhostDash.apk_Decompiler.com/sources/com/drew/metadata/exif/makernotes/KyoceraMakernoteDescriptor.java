package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class KyoceraMakernoteDescriptor extends TagDescriptor<KyoceraMakernoteDirectory> {
    public KyoceraMakernoteDescriptor(KyoceraMakernoteDirectory kyoceraMakernoteDirectory) {
        super(kyoceraMakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i != 1) {
            return super.getDescription(i);
        }
        return getProprietaryThumbnailDataDescription();
    }

    public String getProprietaryThumbnailDataDescription() {
        return getByteLengthDescription(1);
    }
}
