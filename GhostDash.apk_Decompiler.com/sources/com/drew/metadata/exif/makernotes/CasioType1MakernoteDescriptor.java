package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class CasioType1MakernoteDescriptor extends TagDescriptor<CasioType1MakernoteDirectory> {
    public CasioType1MakernoteDescriptor(CasioType1MakernoteDirectory casioType1MakernoteDirectory) {
        super(casioType1MakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i == 20) {
            return getCcdSensitivityDescription();
        }
        switch (i) {
            case 1:
                return getRecordingModeDescription();
            case 2:
                return getQualityDescription();
            case 3:
                return getFocusingModeDescription();
            case 4:
                return getFlashModeDescription();
            case 5:
                return getFlashIntensityDescription();
            case 6:
                return getObjectDistanceDescription();
            case 7:
                return getWhiteBalanceDescription();
            default:
                switch (i) {
                    case 10:
                        return getDigitalZoomDescription();
                    case 11:
                        return getSharpnessDescription();
                    case 12:
                        return getContrastDescription();
                    case 13:
                        return getSaturationDescription();
                    default:
                        return super.getDescription(i);
                }
        }
    }

    public String getCcdSensitivityDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(20);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 64) {
            return "Normal";
        }
        if (intValue == 80) {
            return "Normal (ISO 80 equivalent)";
        }
        if (intValue == 100) {
            return "High";
        }
        if (intValue == 125) {
            return "+1.0";
        }
        if (intValue != 244) {
            return intValue != 250 ? "Unknown (" + integer + ")" : "+2.0";
        }
        return "+3.0";
    }

    public String getSaturationDescription() {
        return getIndexedDescription(13, "Normal", "Low", "High");
    }

    public String getContrastDescription() {
        return getIndexedDescription(12, "Normal", "Low", "High");
    }

    public String getSharpnessDescription() {
        return getIndexedDescription(11, "Normal", "Soft", "Hard");
    }

    public String getDigitalZoomDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(10);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 65536) {
            return "No digital zoom";
        }
        if (intValue == 65537 || intValue == 131072) {
            return "2x digital zoom";
        }
        return intValue != 262144 ? "Unknown (" + integer + ")" : "4x digital zoom";
    }

    public String getWhiteBalanceDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(7);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 1) {
            return "Auto";
        }
        if (intValue == 2) {
            return "Tungsten";
        }
        if (intValue == 3) {
            return "Daylight";
        }
        if (intValue == 4) {
            return "Florescent";
        }
        if (intValue != 5) {
            return intValue != 129 ? "Unknown (" + integer + ")" : "Manual";
        }
        return "Shade";
    }

    public String getObjectDistanceDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(6);
        if (integer == null) {
            return null;
        }
        return getFocalLengthDescription((double) integer.intValue());
    }

    public String getFlashIntensityDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(5);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 11) {
            return "Weak";
        }
        if (intValue != 13) {
            return intValue != 15 ? "Unknown (" + integer + ")" : "Strong";
        }
        return "Normal";
    }

    public String getFlashModeDescription() {
        return getIndexedDescription(4, 1, "Auto", "On", "Off", "Red eye reduction");
    }

    public String getFocusingModeDescription() {
        return getIndexedDescription(3, 2, "Macro", "Auto focus", "Manual focus", "Infinity");
    }

    public String getQualityDescription() {
        return getIndexedDescription(2, 1, "Economy", "Normal", "Fine");
    }

    public String getRecordingModeDescription() {
        return getIndexedDescription(1, 1, "Single shutter", "Panorama", "Night scene", "Portrait", "Landscape");
    }
}
