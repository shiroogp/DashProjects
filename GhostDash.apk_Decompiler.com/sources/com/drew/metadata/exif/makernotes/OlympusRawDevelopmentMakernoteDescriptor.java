package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class OlympusRawDevelopmentMakernoteDescriptor extends TagDescriptor<OlympusRawDevelopmentMakernoteDirectory> {
    public OlympusRawDevelopmentMakernoteDescriptor(OlympusRawDevelopmentMakernoteDirectory olympusRawDevelopmentMakernoteDirectory) {
        super(olympusRawDevelopmentMakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i == 0) {
            return getRawDevVersionDescription();
        }
        switch (i) {
            case 264:
                return getRawDevColorSpaceDescription();
            case 265:
                return getRawDevEngineDescription();
            case 266:
                return getRawDevNoiseReductionDescription();
            case 267:
                return getRawDevEditStatusDescription();
            case 268:
                return getRawDevSettingsDescription();
            default:
                return super.getDescription(i);
        }
    }

    public String getRawDevVersionDescription() {
        return getVersionBytesDescription(0, 4);
    }

    public String getRawDevColorSpaceDescription() {
        return getIndexedDescription(264, "sRGB", "Adobe RGB", "Pro Photo RGB");
    }

    public String getRawDevEngineDescription() {
        return getIndexedDescription(265, "High Speed", "High Function", "Advanced High Speed", "Advanced High Function");
    }

    public String getRawDevNoiseReductionDescription() {
        Integer integer = ((OlympusRawDevelopmentMakernoteDirectory) this._directory).getInteger(266);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "(none)";
        }
        StringBuilder sb = new StringBuilder();
        int intValue = integer.intValue();
        if ((intValue & 1) != 0) {
            sb.append("Noise Reduction, ");
        }
        if (((intValue >> 1) & 1) != 0) {
            sb.append("Noise Filter, ");
        }
        if (((intValue >> 2) & 1) != 0) {
            sb.append("Noise Filter (ISO Boost), ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public String getRawDevEditStatusDescription() {
        Integer integer = ((OlympusRawDevelopmentMakernoteDirectory) this._directory).getInteger(267);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Original";
        }
        if (intValue != 1) {
            return (intValue == 6 || intValue == 8) ? "Edited (Portrait)" : "Unknown (" + integer + ")";
        }
        return "Edited (Landscape)";
    }

    public String getRawDevSettingsDescription() {
        Integer integer = ((OlympusRawDevelopmentMakernoteDirectory) this._directory).getInteger(268);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "(none)";
        }
        StringBuilder sb = new StringBuilder();
        int intValue = integer.intValue();
        if ((intValue & 1) != 0) {
            sb.append("WB Color Temp, ");
        }
        if (((intValue >> 1) & 1) != 0) {
            sb.append("WB Gray Point, ");
        }
        if (((intValue >> 2) & 1) != 0) {
            sb.append("Saturation, ");
        }
        if (((intValue >> 3) & 1) != 0) {
            sb.append("Contrast, ");
        }
        if (((intValue >> 4) & 1) != 0) {
            sb.append("Sharpness, ");
        }
        if (((intValue >> 5) & 1) != 0) {
            sb.append("Color Space, ");
        }
        if (((intValue >> 6) & 1) != 0) {
            sb.append("High Function, ");
        }
        if (((intValue >> 7) & 1) != 0) {
            sb.append("Noise Reduction, ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
