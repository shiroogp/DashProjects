package com.drew.metadata.exif;

import com.drew.metadata.TagDescriptor;

public class PrintIMDescriptor extends TagDescriptor<PrintIMDirectory> {
    public PrintIMDescriptor(PrintIMDirectory printIMDirectory) {
        super(printIMDirectory);
    }

    public String getDescription(int i) {
        if (i == 0) {
            return super.getDescription(i);
        }
        Integer integer = ((PrintIMDirectory) this._directory).getInteger(i);
        if (integer == null) {
            return null;
        }
        return String.format("0x%08x", new Object[]{integer});
    }
}
