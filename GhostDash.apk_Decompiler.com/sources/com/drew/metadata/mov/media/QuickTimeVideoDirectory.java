package com.drew.metadata.mov.media;

import java.util.HashMap;

public class QuickTimeVideoDirectory extends QuickTimeMediaDirectory {
    public static final int TAG_COLOR_TABLE = 13;
    public static final int TAG_COMPRESSION_TYPE = 10;
    public static final int TAG_COMPRESSOR_NAME = 8;
    public static final int TAG_DEPTH = 9;
    public static final int TAG_FRAME_RATE = 14;
    public static final int TAG_GRAPHICS_MODE = 11;
    public static final int TAG_HEIGHT = 5;
    public static final int TAG_HORIZONTAL_RESOLUTION = 6;
    public static final int TAG_OPCOLOR = 12;
    public static final int TAG_SPATIAL_QUALITY = 3;
    public static final int TAG_TEMPORAL_QUALITY = 2;
    public static final int TAG_VENDOR = 1;
    public static final int TAG_VERTICAL_RESOLUTION = 7;
    public static final int TAG_WIDTH = 4;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "QuickTime Video";
    }

    public QuickTimeVideoDirectory() {
        setDescriptor(new QuickTimeVideoDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        QuickTimeMediaDirectory.addQuickTimeMediaTags(hashMap);
        hashMap.put(1, "Vendor");
        hashMap.put(2, "Temporal Quality");
        hashMap.put(3, "Spatial Quality");
        hashMap.put(4, "Width");
        hashMap.put(5, "Height");
        hashMap.put(6, "Horizontal Resolution");
        hashMap.put(7, "Vertical Resolution");
        hashMap.put(8, "Compressor Name");
        hashMap.put(9, "Depth");
        hashMap.put(10, "Compression Type");
        hashMap.put(11, "Graphics Mode");
        hashMap.put(12, "Opcolor");
        hashMap.put(13, "Color Table");
        hashMap.put(14, "Frame Rate");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
