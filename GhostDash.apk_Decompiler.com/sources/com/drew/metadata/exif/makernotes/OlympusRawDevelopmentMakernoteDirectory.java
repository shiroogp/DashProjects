package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusRawDevelopmentMakernoteDirectory extends Directory {
    public static final int TagRawDevColorSpace = 264;
    public static final int TagRawDevContrastValue = 262;
    public static final int TagRawDevEditStatus = 267;
    public static final int TagRawDevEngine = 265;
    public static final int TagRawDevExposureBiasValue = 256;
    public static final int TagRawDevGrayPoint = 259;
    public static final int TagRawDevMemoryColorEmphasis = 261;
    public static final int TagRawDevNoiseReduction = 266;
    public static final int TagRawDevSaturationEmphasis = 260;
    public static final int TagRawDevSettings = 268;
    public static final int TagRawDevSharpnessValue = 263;
    public static final int TagRawDevVersion = 0;
    public static final int TagRawDevWbFineAdjustment = 258;
    public static final int TagRawDevWhiteBalanceValue = 257;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Olympus Raw Development";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Raw Dev Version");
        hashMap.put(256, "Raw Dev Exposure Bias Value");
        hashMap.put(257, "Raw Dev White Balance Value");
        hashMap.put(258, "Raw Dev WB Fine Adjustment");
        hashMap.put(259, "Raw Dev Gray Point");
        hashMap.put(260, "Raw Dev Saturation Emphasis");
        hashMap.put(261, "Raw Dev Memory Color Emphasis");
        hashMap.put(262, "Raw Dev Contrast Value");
        hashMap.put(263, "Raw Dev Sharpness Value");
        hashMap.put(264, "Raw Dev Color Space");
        hashMap.put(265, "Raw Dev Engine");
        hashMap.put(266, "Raw Dev Noise Reduction");
        hashMap.put(267, "Raw Dev Edit Status");
        hashMap.put(268, "Raw Dev Settings");
    }

    public OlympusRawDevelopmentMakernoteDirectory() {
        setDescriptor(new OlympusRawDevelopmentMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
