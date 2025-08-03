package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusRawInfoMakernoteDirectory extends Directory {
    public static final int TagBlackLevel2 = 1536;
    public static final int TagCmContrast = 8226;
    public static final int TagCmExposureCompensation = 8192;
    public static final int TagCmHue = 8225;
    public static final int TagCmSaturation = 8224;
    public static final int TagCmSharpness = 8227;
    public static final int TagCmWhiteBalance = 8193;
    public static final int TagCmWhiteBalanceComp = 8194;
    public static final int TagCmWhiteBalanceGrayPoint = 8208;
    public static final int TagColorMatrix2 = 512;
    public static final int TagContrastSetting = 4114;
    public static final int TagCoringFilter = 784;
    public static final int TagCoringValues = 785;
    public static final int TagCropHeight = 1557;
    public static final int TagCropLeft = 1554;
    public static final int TagCropTop = 1555;
    public static final int TagCropWidth = 1556;
    public static final int TagHueSetting = 4113;
    public static final int TagLightSource = 4096;
    public static final int TagRawInfoVersion = 0;
    public static final int TagSaturationSetting = 4112;
    public static final int TagSharpnessSetting = 4115;
    public static final int TagValidPixelDepth = 1553;
    public static final int TagWbRbLevelsAuto = 272;
    public static final int TagWbRbLevelsCloudy = 289;
    public static final int TagWbRbLevelsCoolWhiteFluor = 306;
    public static final int TagWbRbLevelsDayWhiteFluor = 305;
    public static final int TagWbRbLevelsDaylightFluor = 304;
    public static final int TagWbRbLevelsEveningSunlight = 292;
    public static final int TagWbRbLevelsFineWeather = 290;
    public static final int TagWbRbLevelsShade = 288;
    public static final int TagWbRbLevelsTungsten = 291;
    public static final int TagWbRbLevelsUsed = 256;
    public static final int TagWbRbLevelsWhiteFluorescent = 307;
    public static final int TagWhiteBalanceComp = 4097;
    public static final int TagYCbCrCoefficients = 1537;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Olympus Raw Info";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Raw Info Version");
        hashMap.put(256, "WB RB Levels Used");
        hashMap.put(272, "WB RB Levels Auto");
        hashMap.put(288, "WB RB Levels Shade");
        hashMap.put(289, "WB RB Levels Cloudy");
        hashMap.put(Integer.valueOf(TagWbRbLevelsFineWeather), "WB RB Levels Fine Weather");
        hashMap.put(291, "WB RB Levels Tungsten");
        hashMap.put(Integer.valueOf(TagWbRbLevelsEveningSunlight), "WB RB Levels Evening Sunlight");
        hashMap.put(Integer.valueOf(TagWbRbLevelsDaylightFluor), "WB RB Levels Daylight Fluor");
        hashMap.put(305, "WB RB Levels Day White Fluor");
        hashMap.put(306, "WB RB Levels Cool White Fluor");
        hashMap.put(307, "WB RB Levels White Fluorescent");
        hashMap.put(512, "Color Matrix 2");
        hashMap.put(784, "Coring Filter");
        hashMap.put(785, "Coring Values");
        hashMap.put(1536, "Black Level 2");
        hashMap.put(1537, ExifInterface.TAG_Y_CB_CR_COEFFICIENTS);
        hashMap.put(1553, "Valid Pixel Depth");
        hashMap.put(1554, "Crop Left");
        hashMap.put(1555, "Crop Top");
        hashMap.put(1556, "Crop Width");
        hashMap.put(1557, "Crop Height");
        hashMap.put(4096, "Light Source");
        hashMap.put(4097, "White Balance Comp");
        hashMap.put(4112, "Saturation Setting");
        hashMap.put(4113, "Hue Setting");
        hashMap.put(4114, "Contrast Setting");
        hashMap.put(4115, "Sharpness Setting");
        hashMap.put(8192, "CM Exposure Compensation");
        hashMap.put(8193, "CM White Balance");
        hashMap.put(8194, "CM White Balance Comp");
        hashMap.put(8208, "CM White Balance Gray Point");
        hashMap.put(8224, "CM Saturation");
        hashMap.put(Integer.valueOf(TagCmHue), "CM Hue");
        hashMap.put(8226, "CM Contrast");
        hashMap.put(Integer.valueOf(TagCmSharpness), "CM Sharpness");
    }

    public OlympusRawInfoMakernoteDirectory() {
        setDescriptor(new OlympusRawInfoMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
