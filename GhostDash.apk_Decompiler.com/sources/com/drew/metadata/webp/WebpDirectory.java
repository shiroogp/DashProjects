package com.drew.metadata.webp;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class WebpDirectory extends Directory {
    public static final String CHUNK_EXIF = "EXIF";
    public static final String CHUNK_ICCP = "ICCP";
    public static final String CHUNK_VP8 = "VP8 ";
    public static final String CHUNK_VP8L = "VP8L";
    public static final String CHUNK_VP8X = "VP8X";
    public static final String CHUNK_XMP = "XMP ";
    public static final String FORMAT = "WEBP";
    public static final int TAG_HAS_ALPHA = 3;
    public static final int TAG_IMAGE_HEIGHT = 1;
    public static final int TAG_IMAGE_WIDTH = 2;
    public static final int TAG_IS_ANIMATION = 4;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "WebP";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Image Height");
        hashMap.put(2, "Image Width");
        hashMap.put(3, "Has Alpha");
        hashMap.put(4, "Is Animation");
    }

    public WebpDirectory() {
        setDescriptor(new WebpDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
