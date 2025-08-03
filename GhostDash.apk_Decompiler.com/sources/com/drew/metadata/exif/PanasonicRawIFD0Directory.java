package com.drew.metadata.exif;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class PanasonicRawIFD0Directory extends Directory {
    public static final int TagBlackLevel1 = 8;
    public static final int TagBlackLevel2 = 9;
    public static final int TagBlackLevel3 = 10;
    public static final int TagBlackLevelBlue = 30;
    public static final int TagBlackLevelGreen = 29;
    public static final int TagBlackLevelRed = 28;
    public static final int TagBlueBalance = 18;
    public static final int TagCropBottom = 49;
    public static final int TagCropLeft = 48;
    public static final int TagCropRight = 50;
    public static final int TagCropTop = 47;
    public static final int TagDistortionInfo = 281;
    public static final int TagHighIsoMultiplierBlue = 26;
    public static final int TagHighIsoMultiplierGreen = 25;
    public static final int TagHighIsoMultiplierRed = 24;
    public static final int TagIso = 23;
    public static final int TagJpgFromRaw = 46;
    public static final int TagLinearityLimitBlue = 16;
    public static final int TagLinearityLimitGreen = 15;
    public static final int TagLinearityLimitRed = 14;
    public static final int TagMake = 271;
    public static final int TagModel = 272;
    public static final int TagOrientation = 274;
    public static final int TagPanasonicRawVersion = 1;
    public static final int TagRawDataOffset = 280;
    public static final int TagRedBalance = 17;
    public static final int TagRowsPerStrip = 278;
    public static final int TagSensorBottomBorder = 6;
    public static final int TagSensorHeight = 3;
    public static final int TagSensorLeftBorder = 5;
    public static final int TagSensorRightBorder = 7;
    public static final int TagSensorTopBorder = 4;
    public static final int TagSensorWidth = 2;
    public static final int TagStripByteCounts = 279;
    public static final int TagStripOffsets = 273;
    public static final int TagWbBlueLevel = 38;
    public static final int TagWbGreenLevel = 37;
    public static final int TagWbInfo = 19;
    public static final int TagWbInfo2 = 39;
    public static final int TagWbRedLevel = 36;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "PanasonicRaw Exif IFD0";
    }

    public PanasonicRawIFD0Directory() {
        setDescriptor(new PanasonicRawIFD0Descriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Panasonic Raw Version");
        hashMap.put(2, "Sensor Width");
        hashMap.put(3, "Sensor Height");
        hashMap.put(4, "Sensor Top Border");
        hashMap.put(5, "Sensor Left Border");
        hashMap.put(6, "Sensor Bottom Border");
        hashMap.put(7, "Sensor Right Border");
        hashMap.put(8, "Black Level 1");
        hashMap.put(9, "Black Level 2");
        hashMap.put(10, "Black Level 3");
        hashMap.put(14, "Linearity Limit Red");
        hashMap.put(15, "Linearity Limit Green");
        hashMap.put(16, "Linearity Limit Blue");
        hashMap.put(17, "Red Balance");
        hashMap.put(18, "Blue Balance");
        hashMap.put(23, ExifInterface.TAG_RW2_ISO);
        hashMap.put(24, "High ISO Multiplier Red");
        hashMap.put(25, "High ISO Multiplier Green");
        hashMap.put(26, "High ISO Multiplier Blue");
        hashMap.put(28, "Black Level Red");
        hashMap.put(29, "Black Level Green");
        hashMap.put(30, "Black Level Blue");
        hashMap.put(36, "WB Red Level");
        hashMap.put(37, "WB Green Level");
        hashMap.put(38, "WB Blue Level");
        hashMap.put(46, "Jpg From Raw");
        hashMap.put(47, "Crop Top");
        hashMap.put(48, "Crop Left");
        hashMap.put(49, "Crop Bottom");
        hashMap.put(50, "Crop Right");
        hashMap.put(271, ExifInterface.TAG_MAKE);
        hashMap.put(272, ExifInterface.TAG_MODEL);
        hashMap.put(273, "Strip Offsets");
        hashMap.put(274, ExifInterface.TAG_ORIENTATION);
        hashMap.put(278, "Rows Per Strip");
        hashMap.put(279, "Strip Byte Counts");
        hashMap.put(280, "Raw Data Offset");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
