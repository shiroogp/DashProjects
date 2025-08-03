package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class ReconyxUltraFireMakernoteDirectory extends Directory {
    public static final int MAKERNOTE_ID = 65536;
    public static final int MAKERNOTE_PUBLIC_ID = 133234689;
    public static final int TAG_AMBIENT_TEMPERATURE = 70;
    public static final int TAG_AMBIENT_TEMPERATURE_FAHRENHEIT = 68;
    public static final int TAG_BATTERY_VOLTAGE = 73;
    public static final int TAG_BTL_VERSION = 38;
    public static final int TAG_CAMERA_VERSION = 24;
    public static final int TAG_DATE_TIME_ORIGINAL = 59;
    public static final int TAG_DAY_OF_WEEK = 66;
    public static final int TAG_EVENT_NUMBER = 55;
    public static final int TAG_EVENT_TYPE = 52;
    public static final int TAG_FLASH = 72;
    public static final int TAG_LABEL = 0;
    public static final int TAG_MAKERNOTE_ID = 10;
    public static final int TAG_MAKERNOTE_PUBLIC_ID = 18;
    public static final int TAG_MAKERNOTE_PUBLIC_SIZE = 22;
    public static final int TAG_MAKERNOTE_SIZE = 14;
    public static final int TAG_MOON_PHASE = 67;
    public static final int TAG_PEX_VERSION = 45;
    public static final int TAG_SEQUENCE = 53;
    public static final int TAG_SERIAL_NUMBER = 75;
    public static final int TAG_UIB_VERSION = 31;
    public static final int TAG_USER_LABEL = 80;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Reconyx UltraFire Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Makernote Label");
        hashMap.put(10, "Makernote ID");
        hashMap.put(14, "Makernote Size");
        hashMap.put(18, "Makernote Public ID");
        hashMap.put(22, "Makernote Public Size");
        hashMap.put(24, "Camera Version");
        hashMap.put(31, "Uib Version");
        hashMap.put(38, "Btl Version");
        hashMap.put(45, "Pex Version");
        hashMap.put(52, "Event Type");
        hashMap.put(53, "Sequence");
        hashMap.put(55, "Event Number");
        hashMap.put(59, "Date/Time Original");
        hashMap.put(66, "Day of Week");
        hashMap.put(67, "Moon Phase");
        hashMap.put(68, "Ambient Temperature Fahrenheit");
        hashMap.put(70, "Ambient Temperature");
        hashMap.put(72, ExifInterface.TAG_FLASH);
        hashMap.put(73, "Battery Voltage");
        hashMap.put(75, "Serial Number");
        hashMap.put(80, "User Label");
    }

    public ReconyxUltraFireMakernoteDirectory() {
        setDescriptor(new ReconyxUltraFireMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
