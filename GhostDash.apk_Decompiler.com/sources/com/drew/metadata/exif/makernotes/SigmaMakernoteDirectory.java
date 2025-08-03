package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class SigmaMakernoteDirectory extends Directory {
    public static final int TAG_ADJUSTMENT_MODE = 21;
    public static final int TAG_AUTO_BRACKET = 25;
    public static final int TAG_AUTO_FOCUS_MODE = 5;
    public static final int TAG_COLOR_ADJUSTMENT = 20;
    public static final int TAG_COLOR_SPACE = 11;
    public static final int TAG_CONTRAST = 13;
    public static final int TAG_DRIVE_MODE = 3;
    public static final int TAG_EXPOSURE = 12;
    public static final int TAG_EXPOSURE_MODE = 8;
    public static final int TAG_FILL_LIGHT = 18;
    public static final int TAG_FIRMWARE = 23;
    public static final int TAG_FOCUS_SETTING = 6;
    public static final int TAG_HIGHLIGHT = 15;
    public static final int TAG_LENS_RANGE = 10;
    public static final int TAG_METERING_MODE = 9;
    public static final int TAG_QUALITY = 22;
    public static final int TAG_RESOLUTION_MODE = 4;
    public static final int TAG_SATURATION = 16;
    public static final int TAG_SERIAL_NUMBER = 2;
    public static final int TAG_SHADOW = 14;
    public static final int TAG_SHARPNESS = 17;
    public static final int TAG_SOFTWARE = 24;
    public static final int TAG_WHITE_BALANCE = 7;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Sigma Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(2, "Serial Number");
        hashMap.put(3, "Drive Mode");
        hashMap.put(4, "Resolution Mode");
        hashMap.put(5, "Auto Focus Mode");
        hashMap.put(6, "Focus Setting");
        hashMap.put(7, "White Balance");
        hashMap.put(8, "Exposure Mode");
        hashMap.put(9, "Metering Mode");
        hashMap.put(10, "Lens Range");
        hashMap.put(11, "Color Space");
        hashMap.put(12, "Exposure");
        hashMap.put(13, ExifInterface.TAG_CONTRAST);
        hashMap.put(14, "Shadow");
        hashMap.put(15, "Highlight");
        hashMap.put(16, ExifInterface.TAG_SATURATION);
        hashMap.put(17, ExifInterface.TAG_SHARPNESS);
        hashMap.put(18, "Fill Light");
        hashMap.put(20, "Color Adjustment");
        hashMap.put(21, "Adjustment Mode");
        hashMap.put(22, "Quality");
        hashMap.put(23, "Firmware");
        hashMap.put(24, ExifInterface.TAG_SOFTWARE);
        hashMap.put(25, "Auto Bracket");
    }

    public SigmaMakernoteDirectory() {
        setDescriptor(new SigmaMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
