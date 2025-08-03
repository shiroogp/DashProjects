package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class LeicaMakernoteDirectory extends Directory {
    public static final int TAG_APPROXIMATE_F_NUMBER = 787;
    public static final int TAG_CAMERA_TEMPERATURE = 800;
    public static final int TAG_CCD_BOARD_VERSION = 817;
    public static final int TAG_CCD_VERSION = 816;
    public static final int TAG_COLOR_TEMPERATURE = 801;
    public static final int TAG_CONTROLLER_BOARD_VERSION = 818;
    public static final int TAG_EXTERNAL_SENSOR_BRIGHTNESS_VALUE = 785;
    public static final int TAG_IMAGE_ID_NUMBER = 832;
    public static final int TAG_LENS_TYPE = 784;
    public static final int TAG_M16_C_VERSION = 819;
    public static final int TAG_MEASURED_LV = 786;
    public static final int TAG_QUALITY = 768;
    public static final int TAG_SERIAL_NUMBER = 771;
    public static final int TAG_USER_PROFILE = 770;
    public static final int TAG_WB_BLUE_LEVEL = 804;
    public static final int TAG_WB_GREEN_LEVEL = 803;
    public static final int TAG_WB_RED_LEVEL = 802;
    public static final int TAG_WHITE_BALANCE = 772;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Leica Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(768, "Quality");
        hashMap.put(770, "User Profile");
        hashMap.put(771, "Serial Number");
        hashMap.put(772, "White Balance");
        hashMap.put(784, "Lens Type");
        hashMap.put(785, "External Sensor Brightness Value");
        hashMap.put(Integer.valueOf(TAG_MEASURED_LV), "Measured LV");
        hashMap.put(Integer.valueOf(TAG_APPROXIMATE_F_NUMBER), "Approximate F Number");
        hashMap.put(Integer.valueOf(TAG_CAMERA_TEMPERATURE), "Camera Temperature");
        hashMap.put(Integer.valueOf(TAG_COLOR_TEMPERATURE), "Color Temperature");
        hashMap.put(Integer.valueOf(TAG_WB_RED_LEVEL), "WB Red Level");
        hashMap.put(Integer.valueOf(TAG_WB_GREEN_LEVEL), "WB Green Level");
        hashMap.put(Integer.valueOf(TAG_WB_BLUE_LEVEL), "WB Blue Level");
        hashMap.put(Integer.valueOf(TAG_CCD_VERSION), "CCD Version");
        hashMap.put(Integer.valueOf(TAG_CCD_BOARD_VERSION), "CCD Board Version");
        hashMap.put(Integer.valueOf(TAG_CONTROLLER_BOARD_VERSION), "Controller Board Version");
        hashMap.put(Integer.valueOf(TAG_M16_C_VERSION), "M16 C Version");
        hashMap.put(Integer.valueOf(TAG_IMAGE_ID_NUMBER), "Image ID Number");
    }

    public LeicaMakernoteDirectory() {
        setDescriptor(new LeicaMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
