package com.drew.metadata.gif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class GifImageDirectory extends Directory {
    public static final int TAG_HAS_LOCAL_COLOUR_TABLE = 5;
    public static final int TAG_HEIGHT = 4;
    public static final int TAG_IS_COLOR_TABLE_SORTED = 7;
    public static final int TAG_IS_INTERLACED = 6;
    public static final int TAG_LEFT = 1;
    public static final int TAG_LOCAL_COLOUR_TABLE_BITS_PER_PIXEL = 8;
    public static final int TAG_TOP = 2;
    public static final int TAG_WIDTH = 3;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "GIF Image";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Left");
        hashMap.put(2, "Top");
        hashMap.put(3, "Width");
        hashMap.put(4, "Height");
        hashMap.put(5, "Has Local Colour Table");
        hashMap.put(6, "Is Interlaced");
        hashMap.put(7, "Is Local Colour Table Sorted");
        hashMap.put(8, "Local Colour Table Bits Per Pixel");
    }

    public GifImageDirectory() {
        setDescriptor(new GifImageDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
