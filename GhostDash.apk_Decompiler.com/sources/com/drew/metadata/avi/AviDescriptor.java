package com.drew.metadata.avi;

import com.drew.metadata.TagDescriptor;

public class AviDescriptor extends TagDescriptor<AviDirectory> {
    public AviDescriptor(AviDirectory aviDirectory) {
        super(aviDirectory);
    }

    public String getDescription(int i) {
        if (i == 6 || i == 7) {
            return getSizeDescription(i);
        }
        return super.getDescription(i);
    }

    public String getSizeDescription(int i) {
        return ((AviDirectory) this._directory).getString(i) + " pixels";
    }
}
