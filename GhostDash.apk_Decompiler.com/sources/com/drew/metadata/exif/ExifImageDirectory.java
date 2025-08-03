package com.drew.metadata.exif;

import java.util.HashMap;

public class ExifImageDirectory extends ExifDirectoryBase {
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Exif Image";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        addExifTagNames(hashMap);
    }

    public ExifImageDirectory() {
        setDescriptor(new ExifImageDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
