package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;
import java.util.HashMap;

public class OlympusRawDevelopment2MakernoteDescriptor extends TagDescriptor<OlympusRawDevelopment2MakernoteDirectory> {
    private static final HashMap<Integer, String> _filters;

    public OlympusRawDevelopment2MakernoteDescriptor(OlympusRawDevelopment2MakernoteDirectory olympusRawDevelopment2MakernoteDirectory) {
        super(olympusRawDevelopment2MakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i == 0) {
            return getRawDevVersionDescription();
        }
        if (i == 256) {
            return getRawDevExposureBiasValueDescription();
        }
        if (i == 289) {
            return getRawDevArtFilterDescription();
        }
        if (i == 272) {
            return getRawDevPmBwFilterDescription();
        }
        if (i == 273) {
            return getRawDevPmPictureToneDescription();
        }
        switch (i) {
            case 265:
                return getRawDevColorSpaceDescription();
            case 266:
                return getRawDevNoiseReductionDescription();
            case 267:
                return getRawDevEngineDescription();
            case 268:
                return getRawDevPictureModeDescription();
            default:
                return super.getDescription(i);
        }
    }

    public String getRawDevVersionDescription() {
        return getVersionBytesDescription(0, 4);
    }

    public String getRawDevExposureBiasValueDescription() {
        return getIndexedDescription(256, 1, "Color Temperature", "Gray Point");
    }

    public String getRawDevColorSpaceDescription() {
        return getIndexedDescription(265, "sRGB", "Adobe RGB", "Pro Photo RGB");
    }

    public String getRawDevNoiseReductionDescription() {
        Integer integer = ((OlympusRawDevelopment2MakernoteDirectory) this._directory).getInteger(266);
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

    public String getRawDevEngineDescription() {
        return getIndexedDescription(267, "High Speed", "High Function", "Advanced High Speed", "Advanced High Function");
    }

    public String getRawDevPictureModeDescription() {
        Integer integer = ((OlympusRawDevelopment2MakernoteDirectory) this._directory).getInteger(268);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 1) {
            return "Vivid";
        }
        if (intValue == 2) {
            return "Natural";
        }
        if (intValue == 3) {
            return "Muted";
        }
        if (intValue != 256) {
            return intValue != 512 ? "Unknown (" + integer + ")" : "Sepia";
        }
        return "Monotone";
    }

    public String getRawDevPmBwFilterDescription() {
        return getIndexedDescription(272, "Neutral", "Yellow", "Orange", "Red", "Green");
    }

    public String getRawDevPmPictureToneDescription() {
        return getIndexedDescription(273, "Neutral", "Sepia", "Blue", "Purple", "Green");
    }

    public String getRawDevArtFilterDescription() {
        return getFilterDescription(289);
    }

    public String getFilterDescription(int i) {
        int[] intArray = ((OlympusRawDevelopment2MakernoteDirectory) this._directory).getIntArray(i);
        if (intArray == null || intArray.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < intArray.length; i2++) {
            if (i2 == 0) {
                HashMap<Integer, String> hashMap = _filters;
                sb.append(hashMap.containsKey(Integer.valueOf(intArray[i2])) ? hashMap.get(Integer.valueOf(intArray[i2])) : "[unknown]");
            } else {
                sb.append(intArray[i2]).append("; ");
            }
            sb.append("; ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _filters = hashMap;
        hashMap.put(0, "Off");
        hashMap.put(1, "Soft Focus");
        hashMap.put(2, "Pop Art");
        hashMap.put(3, "Pale & Light Color");
        hashMap.put(4, "Light Tone");
        hashMap.put(5, "Pin Hole");
        hashMap.put(6, "Grainy Film");
        hashMap.put(9, "Diorama");
        hashMap.put(10, "Cross Process");
        hashMap.put(12, "Fish Eye");
        hashMap.put(13, "Drawing");
        hashMap.put(14, "Gentle Sepia");
        hashMap.put(15, "Pale & Light Color II");
        hashMap.put(16, "Pop Art II");
        hashMap.put(17, "Pin Hole II");
        hashMap.put(18, "Pin Hole III");
        hashMap.put(19, "Grainy Film II");
        hashMap.put(20, "Dramatic Tone");
        hashMap.put(21, "Punk");
        hashMap.put(22, "Soft Focus 2");
        hashMap.put(23, "Sparkle");
        hashMap.put(24, "Watercolor");
        hashMap.put(25, "Key Line");
        hashMap.put(26, "Key Line II");
        hashMap.put(27, "Miniature");
        hashMap.put(28, "Reflection");
        hashMap.put(29, "Fragmented");
        hashMap.put(31, "Cross Process II");
        hashMap.put(32, "Dramatic Tone II");
        hashMap.put(33, "Watercolor I");
        hashMap.put(34, "Watercolor II");
        hashMap.put(35, "Diorama II");
        hashMap.put(36, "Vintage");
        hashMap.put(37, "Vintage II");
        hashMap.put(38, "Vintage III");
        hashMap.put(39, "Partial Color");
        hashMap.put(40, "Partial Color II");
        hashMap.put(41, "Partial Color III");
    }
}
