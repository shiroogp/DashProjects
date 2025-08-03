package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class AppleMakernoteDirectory extends Directory {
    public static final int TAG_BURST_UUID = 11;
    public static final int TAG_HDR_IMAGE_TYPE = 10;
    public static final int TAG_RUN_TIME = 3;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Apple Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(3, "Run Time");
        hashMap.put(10, "HDR Image Type");
        hashMap.put(11, "Burst UUID");
    }

    public AppleMakernoteDirectory() {
        setDescriptor(new AppleMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
