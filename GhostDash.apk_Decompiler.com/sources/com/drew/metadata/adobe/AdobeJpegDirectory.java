package com.drew.metadata.adobe;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class AdobeJpegDirectory extends Directory {
    public static final int TAG_APP14_FLAGS0 = 1;
    public static final int TAG_APP14_FLAGS1 = 2;
    public static final int TAG_COLOR_TRANSFORM = 3;
    public static final int TAG_DCT_ENCODE_VERSION = 0;
    private static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Adobe JPEG";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "DCT Encode Version");
        hashMap.put(1, "Flags 0");
        hashMap.put(2, "Flags 1");
        hashMap.put(3, "Color Transform");
    }

    public AdobeJpegDirectory() {
        setDescriptor(new AdobeJpegDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
