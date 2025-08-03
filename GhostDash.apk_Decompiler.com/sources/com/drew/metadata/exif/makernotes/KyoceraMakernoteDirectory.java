package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class KyoceraMakernoteDirectory extends Directory {
    public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
    public static final int TAG_PROPRIETARY_THUMBNAIL = 1;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Kyocera/Contax Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Proprietary Thumbnail Format Data");
        hashMap.put(3584, "Print Image Matching (PIM) Info");
    }

    public KyoceraMakernoteDirectory() {
        setDescriptor(new KyoceraMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
