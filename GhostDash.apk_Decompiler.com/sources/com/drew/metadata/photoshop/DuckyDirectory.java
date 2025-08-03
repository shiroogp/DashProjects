package com.drew.metadata.photoshop;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import com.drew.metadata.TagDescriptor;
import java.util.HashMap;

public class DuckyDirectory extends Directory {
    public static final int TAG_COMMENT = 2;
    public static final int TAG_COPYRIGHT = 3;
    public static final int TAG_QUALITY = 1;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Ducky";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Quality");
        hashMap.put(2, "Comment");
        hashMap.put(3, ExifInterface.TAG_COPYRIGHT);
    }

    public DuckyDirectory() {
        setDescriptor(new TagDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
