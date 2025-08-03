package com.drew.metadata.photoshop;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PsdHeaderDirectory extends Directory {
    public static final int TAG_BITS_PER_CHANNEL = 4;
    public static final int TAG_CHANNEL_COUNT = 1;
    public static final int TAG_COLOR_MODE = 5;
    public static final int TAG_IMAGE_HEIGHT = 2;
    public static final int TAG_IMAGE_WIDTH = 3;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "PSD Header";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Channel Count");
        hashMap.put(2, "Image Height");
        hashMap.put(3, "Image Width");
        hashMap.put(4, "Bits Per Channel");
        hashMap.put(5, "Color Mode");
    }

    public PsdHeaderDirectory() {
        setDescriptor(new PsdHeaderDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
