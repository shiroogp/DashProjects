package com.drew.metadata.ico;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class IcoDirectory extends Directory {
    public static final int TAG_BITS_PER_PIXEL = 7;
    public static final int TAG_COLOUR_PALETTE_SIZE = 4;
    public static final int TAG_COLOUR_PLANES = 5;
    public static final int TAG_CURSOR_HOTSPOT_X = 6;
    public static final int TAG_CURSOR_HOTSPOT_Y = 8;
    public static final int TAG_IMAGE_HEIGHT = 3;
    public static final int TAG_IMAGE_OFFSET_BYTES = 10;
    public static final int TAG_IMAGE_SIZE_BYTES = 9;
    public static final int TAG_IMAGE_TYPE = 1;
    public static final int TAG_IMAGE_WIDTH = 2;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "ICO";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Image Type");
        hashMap.put(2, "Image Width");
        hashMap.put(3, "Image Height");
        hashMap.put(4, "Colour Palette Size");
        hashMap.put(5, "Colour Planes");
        hashMap.put(6, "Hotspot X");
        hashMap.put(7, "Bits Per Pixel");
        hashMap.put(8, "Hotspot Y");
        hashMap.put(9, "Image Size Bytes");
        hashMap.put(10, "Image Offset Bytes");
    }

    public IcoDirectory() {
        setDescriptor(new IcoDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
