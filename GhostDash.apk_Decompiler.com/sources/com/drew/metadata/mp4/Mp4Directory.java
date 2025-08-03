package com.drew.metadata.mp4;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class Mp4Directory extends Directory {
    public static final int TAG_COMPATIBLE_BRANDS = 3;
    public static final int TAG_CREATION_TIME = 256;
    public static final int TAG_CURRENT_TIME = 269;
    public static final int TAG_DURATION = 259;
    public static final int TAG_MAJOR_BRAND = 1;
    public static final int TAG_MEDIA_TIME_SCALE = 774;
    public static final int TAG_MINOR_VERSION = 2;
    public static final int TAG_MODIFICATION_TIME = 257;
    public static final int TAG_NEXT_TRACK_ID = 270;
    public static final int TAG_POSTER_TIME = 266;
    public static final int TAG_PREFERRED_RATE = 260;
    public static final int TAG_PREFERRED_VOLUME = 261;
    public static final int TAG_PREVIEW_DURATION = 265;
    public static final int TAG_PREVIEW_TIME = 264;
    public static final int TAG_SELECTION_DURATION = 268;
    public static final int TAG_SELECTION_TIME = 267;
    public static final int TAG_TIME_SCALE = 258;
    public static final int TAG_TRANSFORMATION_MATRIX = 271;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "MP4";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Major Brand");
        hashMap.put(2, "Minor Version");
        hashMap.put(3, "Compatible Brands");
        hashMap.put(256, "Creation Time");
        hashMap.put(257, "Modification Time");
        hashMap.put(258, "Media Time Scale");
        hashMap.put(259, "Duration");
        hashMap.put(260, "Preferred Rate");
        hashMap.put(261, "Preferred Volume");
        hashMap.put(264, "Preview Time");
        hashMap.put(265, "Preview Duration");
        hashMap.put(266, "Poster Time");
        hashMap.put(267, "Selection Time");
        hashMap.put(268, "Selection Duration");
        hashMap.put(269, "Current Time");
        hashMap.put(270, "Next Track ID");
        hashMap.put(271, "Transformation Matrix");
        hashMap.put(774, "Media Time Scale");
    }

    public Mp4Directory() {
        setDescriptor(new Mp4Descriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
