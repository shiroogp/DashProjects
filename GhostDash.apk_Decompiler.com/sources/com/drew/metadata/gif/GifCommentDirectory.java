package com.drew.metadata.gif;

import com.drew.metadata.Directory;
import com.drew.metadata.StringValue;
import java.util.HashMap;

public class GifCommentDirectory extends Directory {
    public static final int TAG_COMMENT = 1;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "GIF Comment";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Comment");
    }

    public GifCommentDirectory(StringValue stringValue) {
        setDescriptor(new GifCommentDescriptor(this));
        setStringValue(1, stringValue);
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
