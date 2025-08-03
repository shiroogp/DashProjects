package com.drew.metadata.png;

import com.drew.metadata.Directory;
import com.drew.metadata.TagDescriptor;
import java.util.HashMap;

public class PngChromaticitiesDirectory extends Directory {
    public static final int TAG_BLUE_X = 7;
    public static final int TAG_BLUE_Y = 8;
    public static final int TAG_GREEN_X = 5;
    public static final int TAG_GREEN_Y = 6;
    public static final int TAG_RED_X = 3;
    public static final int TAG_RED_Y = 4;
    public static final int TAG_WHITE_POINT_X = 1;
    public static final int TAG_WHITE_POINT_Y = 2;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "PNG Chromaticities";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "White Point X");
        hashMap.put(2, "White Point Y");
        hashMap.put(3, "Red X");
        hashMap.put(4, "Red Y");
        hashMap.put(5, "Green X");
        hashMap.put(6, "Green Y");
        hashMap.put(7, "Blue X");
        hashMap.put(8, "Blue Y");
    }

    public PngChromaticitiesDirectory() {
        setDescriptor(new TagDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
