package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class ReconyxHyperFireMakernoteDirectory extends Directory {
    public static final int MAKERNOTE_VERSION = 61697;
    public static final int TAG_AMBIENT_TEMPERATURE = 40;
    public static final int TAG_AMBIENT_TEMPERATURE_FAHRENHEIT = 38;
    public static final int TAG_BATTERY_VOLTAGE = 84;
    public static final int TAG_BRIGHTNESS = 74;
    public static final int TAG_CONTRAST = 72;
    public static final int TAG_DATE_TIME_ORIGINAL = 22;
    public static final int TAG_EVENT_NUMBER = 18;
    public static final int TAG_FIRMWARE_VERSION = 2;
    public static final int TAG_INFRARED_ILLUMINATOR = 80;
    public static final int TAG_MAKERNOTE_VERSION = 0;
    public static final int TAG_MOON_PHASE = 36;
    public static final int TAG_MOTION_SENSITIVITY = 82;
    public static final int TAG_SATURATION = 78;
    public static final int TAG_SEQUENCE = 14;
    public static final int TAG_SERIAL_NUMBER = 42;
    public static final int TAG_SHARPNESS = 76;
    public static final int TAG_TRIGGER_MODE = 12;
    public static final int TAG_USER_LABEL = 86;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Reconyx HyperFire Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Makernote Version");
        hashMap.put(2, "Firmware Version");
        hashMap.put(12, "Trigger Mode");
        hashMap.put(14, "Sequence");
        hashMap.put(18, "Event Number");
        hashMap.put(22, "Date/Time Original");
        hashMap.put(36, "Moon Phase");
        hashMap.put(38, "Ambient Temperature Fahrenheit");
        hashMap.put(40, "Ambient Temperature");
        hashMap.put(42, "Serial Number");
        hashMap.put(72, ExifInterface.TAG_CONTRAST);
        hashMap.put(74, "Brightness");
        hashMap.put(76, ExifInterface.TAG_SHARPNESS);
        hashMap.put(78, ExifInterface.TAG_SATURATION);
        hashMap.put(80, "Infrared Illuminator");
        hashMap.put(82, "Motion Sensitivity");
        hashMap.put(84, "Battery Voltage");
        hashMap.put(86, "User Label");
    }

    public ReconyxHyperFireMakernoteDirectory() {
        setDescriptor(new ReconyxHyperFireMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
