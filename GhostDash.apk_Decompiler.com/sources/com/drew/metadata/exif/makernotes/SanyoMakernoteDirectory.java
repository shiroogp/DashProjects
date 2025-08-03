package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class SanyoMakernoteDirectory extends Directory {
    public static final int TAG_CAMERA_ID = 521;
    public static final int TAG_COLOR_ADJUSTMENT_MODE = 528;
    public static final int TAG_DATA_DUMP = 3840;
    public static final int TAG_DIGITAL_ZOOM = 516;
    public static final int TAG_DIGITAL_ZOOM_ON = 539;
    public static final int TAG_FLASH_MODE = 549;
    public static final int TAG_FLICKER_REDUCE = 536;
    public static final int TAG_LIGHT_SOURCE_SPECIAL = 541;
    public static final int TAG_MACRO = 514;
    public static final int TAG_MAKERNOTE_OFFSET = 255;
    public static final int TAG_MANUAL_FOCUS_DISTANCE_OR_FACE_INFO = 547;
    public static final int TAG_OPTICAL_ZOOM_ON = 537;
    public static final int TAG_PICT_INFO = 520;
    public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
    public static final int TAG_QUICK_SHOT = 531;
    public static final int TAG_RECORD_SHUTTER_RELEASE = 535;
    public static final int TAG_RESAVED = 542;
    public static final int TAG_SANYO_QUALITY = 513;
    public static final int TAG_SANYO_THUMBNAIL = 256;
    public static final int TAG_SCENE_SELECT = 543;
    public static final int TAG_SELF_TIMER = 532;
    public static final int TAG_SEQUENCE_SHOT_INTERVAL = 548;
    public static final int TAG_SEQUENTIAL_SHOT = 526;
    public static final int TAG_SOFTWARE_VERSION = 519;
    public static final int TAG_SPECIAL_MODE = 512;
    public static final int TAG_VOICE_MEMO = 534;
    public static final int TAG_WIDE_RANGE = 527;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Sanyo Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(255, "Makernote Offset");
        hashMap.put(256, "Sanyo Thumbnail");
        hashMap.put(512, "Special Mode");
        hashMap.put(513, "Sanyo Quality");
        hashMap.put(514, "Macro");
        hashMap.put(516, "Digital Zoom");
        hashMap.put(519, "Software Version");
        hashMap.put(520, "Pict Info");
        hashMap.put(521, "Camera ID");
        hashMap.put(Integer.valueOf(TAG_SEQUENTIAL_SHOT), "Sequential Shot");
        hashMap.put(527, "Wide Range");
        hashMap.put(528, "Color Adjustment Node");
        hashMap.put(531, "Quick Shot");
        hashMap.put(532, "Self Timer");
        hashMap.put(534, "Voice Memo");
        hashMap.put(Integer.valueOf(TAG_RECORD_SHUTTER_RELEASE), "Record Shutter Release");
        hashMap.put(Integer.valueOf(TAG_FLICKER_REDUCE), "Flicker Reduce");
        hashMap.put(537, "Optical Zoom On");
        hashMap.put(539, "Digital Zoom On");
        hashMap.put(Integer.valueOf(TAG_LIGHT_SOURCE_SPECIAL), "Light Source Special");
        hashMap.put(542, "Resaved");
        hashMap.put(Integer.valueOf(TAG_SCENE_SELECT), "Scene Select");
        hashMap.put(547, "Manual Focus Distance or Face Info");
        hashMap.put(Integer.valueOf(TAG_SEQUENCE_SHOT_INTERVAL), "Sequence Shot Interval");
        hashMap.put(549, "Flash Mode");
        hashMap.put(3584, "Print IM");
        hashMap.put(3840, "Data Dump");
    }

    public SanyoMakernoteDirectory() {
        setDescriptor(new SanyoMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
