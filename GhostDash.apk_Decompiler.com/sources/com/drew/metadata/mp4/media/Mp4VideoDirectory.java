package com.drew.metadata.mp4.media;

import java.util.HashMap;

public class Mp4VideoDirectory extends Mp4MediaDirectory {
    public static final int TAG_COLOR_TABLE = 113;
    public static final int TAG_COMPRESSION_TYPE = 110;
    public static final int TAG_COMPRESSOR_NAME = 108;
    public static final int TAG_DEPTH = 109;
    public static final int TAG_FRAME_RATE = 114;
    public static final int TAG_GRAPHICS_MODE = 111;
    public static final int TAG_HEIGHT = 105;
    public static final int TAG_HORIZONTAL_RESOLUTION = 106;
    public static final int TAG_OPCOLOR = 112;
    public static final int TAG_SPATIAL_QUALITY = 103;
    public static final int TAG_TEMPORAL_QUALITY = 102;
    public static final int TAG_VENDOR = 101;
    public static final int TAG_VERTICAL_RESOLUTION = 107;
    public static final int TAG_WIDTH = 104;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "MP4 Video";
    }

    public Mp4VideoDirectory() {
        setDescriptor(new Mp4VideoDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        Mp4MediaDirectory.addMp4MediaTags(hashMap);
        hashMap.put(101, "Vendor");
        hashMap.put(102, "Temporal Quality");
        hashMap.put(103, "Spatial Quality");
        hashMap.put(104, "Width");
        hashMap.put(105, "Height");
        hashMap.put(106, "Horizontal Resolution");
        hashMap.put(107, "Vertical Resolution");
        hashMap.put(108, "Compressor Name");
        hashMap.put(109, "Depth");
        hashMap.put(110, "Compression Type");
        hashMap.put(111, "Graphics Mode");
        hashMap.put(112, "Opcolor");
        hashMap.put(113, "Color Table");
        hashMap.put(114, "Frame Rate");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
