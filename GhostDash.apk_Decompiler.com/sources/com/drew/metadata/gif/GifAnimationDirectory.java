package com.drew.metadata.gif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class GifAnimationDirectory extends Directory {
    public static final int TAG_ITERATION_COUNT = 1;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "GIF Animation";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Iteration Count");
    }

    public GifAnimationDirectory() {
        setDescriptor(new GifAnimationDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
