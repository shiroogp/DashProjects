package com.drew.metadata.pcx;

import com.drew.metadata.TagDescriptor;

public class PcxDescriptor extends TagDescriptor<PcxDirectory> {
    public PcxDescriptor(PcxDirectory pcxDirectory) {
        super(pcxDirectory);
    }

    public String getDescription(int i) {
        if (i == 1) {
            return getVersionDescription();
        }
        if (i == 10) {
            return getColorPlanesDescription();
        }
        if (i != 12) {
            return super.getDescription(i);
        }
        return getPaletteTypeDescription();
    }

    public String getVersionDescription() {
        return getIndexedDescription(1, "2.5 with fixed EGA palette information", null, "2.8 with modifiable EGA palette information", "2.8 without palette information (default palette)", "PC Paintbrush for Windows", "3.0 or better");
    }

    public String getColorPlanesDescription() {
        return getIndexedDescription(10, 3, "24-bit color", "16 colors");
    }

    public String getPaletteTypeDescription() {
        return getIndexedDescription(12, 1, "Color or B&W", "Grayscale");
    }
}
