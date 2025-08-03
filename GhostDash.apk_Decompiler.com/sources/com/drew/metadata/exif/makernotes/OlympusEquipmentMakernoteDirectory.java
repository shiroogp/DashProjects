package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusEquipmentMakernoteDirectory extends Directory {
    public static final int TAG_BODY_FIRMWARE_VERSION = 260;
    public static final int TAG_CAMERA_TYPE_2 = 256;
    public static final int TAG_CONVERSION_LENS = 1027;
    public static final int TAG_EQUIPMENT_VERSION = 0;
    public static final int TAG_EXTENDER = 769;
    public static final int TAG_EXTENDER_FIRMWARE_VERSION = 772;
    public static final int TAG_EXTENDER_MODEL = 771;
    public static final int TAG_EXTENDER_SERIAL_NUMBER = 770;
    public static final int TAG_FLASH_FIRMWARE_VERSION = 4098;
    public static final int TAG_FLASH_MODEL = 4097;
    public static final int TAG_FLASH_SERIAL_NUMBER = 4099;
    public static final int TAG_FLASH_TYPE = 4096;
    public static final int TAG_FOCAL_PLANE_DIAGONAL = 259;
    public static final int TAG_INTERNAL_SERIAL_NUMBER = 258;
    public static final int TAG_LENS_FIRMWARE_VERSION = 516;
    public static final int TAG_LENS_MODEL = 515;
    public static final int TAG_LENS_PROPERTIES = 523;
    public static final int TAG_LENS_SERIAL_NUMBER = 514;
    public static final int TAG_LENS_TYPE = 513;
    public static final int TAG_MAX_APERTURE = 522;
    public static final int TAG_MAX_APERTURE_AT_MAX_FOCAL = 518;
    public static final int TAG_MAX_APERTURE_AT_MIN_FOCAL = 517;
    public static final int TAG_MAX_FOCAL_LENGTH = 520;
    public static final int TAG_MIN_FOCAL_LENGTH = 519;
    public static final int TAG_SERIAL_NUMBER = 257;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Olympus Equipment";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Equipment Version");
        hashMap.put(256, "Camera Type 2");
        hashMap.put(257, "Serial Number");
        hashMap.put(258, "Internal Serial Number");
        hashMap.put(259, "Focal Plane Diagonal");
        hashMap.put(260, "Body Firmware Version");
        hashMap.put(513, "Lens Type");
        hashMap.put(514, "Lens Serial Number");
        hashMap.put(515, "Lens Model");
        hashMap.put(516, "Lens Firmware Version");
        hashMap.put(517, "Max Aperture At Min Focal");
        hashMap.put(518, "Max Aperture At Max Focal");
        hashMap.put(519, "Min Focal Length");
        hashMap.put(520, "Max Focal Length");
        hashMap.put(522, "Max Aperture");
        hashMap.put(523, "Lens Properties");
        hashMap.put(769, "Extender");
        hashMap.put(770, "Extender Serial Number");
        hashMap.put(771, "Extender Model");
        hashMap.put(772, "Extender Firmware Version");
        hashMap.put(1027, "Conversion Lens");
        hashMap.put(4096, "Flash Type");
        hashMap.put(4097, "Flash Model");
        hashMap.put(4098, "Flash Firmware Version");
        hashMap.put(4099, "Flash Serial Number");
    }

    public OlympusEquipmentMakernoteDirectory() {
        setDescriptor(new OlympusEquipmentMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
