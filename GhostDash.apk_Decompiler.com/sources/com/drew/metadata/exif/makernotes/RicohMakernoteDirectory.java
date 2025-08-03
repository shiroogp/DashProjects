package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class RicohMakernoteDirectory extends Directory {
    public static final int TAG_MAKERNOTE_DATA_TYPE = 1;
    public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
    public static final int TAG_RICOH_CAMERA_INFO_MAKERNOTE_SUB_IFD_POINTER = 8193;
    public static final int TAG_VERSION = 2;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Ricoh Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Makernote Data Type");
        hashMap.put(2, "Version");
        hashMap.put(3584, "Print Image Matching (PIM) Info");
        hashMap.put(8193, "Ricoh Camera Info Makernote Sub-IFD");
    }

    public RicohMakernoteDirectory() {
        setDescriptor(new RicohMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
