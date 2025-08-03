package com.drew.metadata.jpeg;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class JpegCommentDirectory extends Directory {
    public static final int TAG_COMMENT = 0;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "JpegComment";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "JPEG Comment");
    }

    public JpegCommentDirectory() {
        setDescriptor(new JpegCommentDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
