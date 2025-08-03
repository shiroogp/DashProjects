package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class SonyType6MakernoteDirectory extends Directory {
    public static final int TAG_MAKERNOTE_THUMB_LENGTH = 1300;
    public static final int TAG_MAKERNOTE_THUMB_OFFSET = 1299;
    public static final int TAG_MAKERNOTE_THUMB_VERSION = 8192;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Sony Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(Integer.valueOf(TAG_MAKERNOTE_THUMB_OFFSET), "Makernote Thumb Offset");
        hashMap.put(Integer.valueOf(TAG_MAKERNOTE_THUMB_LENGTH), "Makernote Thumb Length");
        hashMap.put(8192, "Makernote Thumb Version");
    }

    public SonyType6MakernoteDirectory() {
        setDescriptor(new SonyType6MakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
