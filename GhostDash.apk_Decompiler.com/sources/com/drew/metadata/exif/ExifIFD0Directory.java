package com.drew.metadata.exif;

import java.util.HashMap;

public class ExifIFD0Directory extends ExifDirectoryBase {
    public static final int TAG_EXIF_SUB_IFD_OFFSET = 34665;
    public static final int TAG_GPS_INFO_OFFSET = 34853;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Exif IFD0";
    }

    public ExifIFD0Directory() {
        setDescriptor(new ExifIFD0Descriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        addExifTagNames(hashMap);
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
