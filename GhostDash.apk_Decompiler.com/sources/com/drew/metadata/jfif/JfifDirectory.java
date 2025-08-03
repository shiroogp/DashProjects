package com.drew.metadata.jfif;

import com.drew.metadata.Directory;
import com.drew.metadata.MetadataException;
import java.util.HashMap;

public class JfifDirectory extends Directory {
    public static final int TAG_RESX = 8;
    public static final int TAG_RESY = 10;
    public static final int TAG_THUMB_HEIGHT = 13;
    public static final int TAG_THUMB_WIDTH = 12;
    public static final int TAG_UNITS = 7;
    public static final int TAG_VERSION = 5;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return JfifReader.PREAMBLE;
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(5, "Version");
        hashMap.put(7, "Resolution Units");
        hashMap.put(10, "Y Resolution");
        hashMap.put(8, "X Resolution");
        hashMap.put(12, "Thumbnail Width Pixels");
        hashMap.put(13, "Thumbnail Height Pixels");
    }

    public JfifDirectory() {
        setDescriptor(new JfifDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    public int getVersion() throws MetadataException {
        return getInt(5);
    }

    public int getResUnits() throws MetadataException {
        return getInt(7);
    }

    @Deprecated
    public int getImageWidth() throws MetadataException {
        return getInt(10);
    }

    public int getResY() throws MetadataException {
        return getInt(10);
    }

    @Deprecated
    public int getImageHeight() throws MetadataException {
        return getInt(8);
    }

    public int getResX() throws MetadataException {
        return getInt(8);
    }
}
