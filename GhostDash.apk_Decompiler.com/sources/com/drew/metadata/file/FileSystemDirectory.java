package com.drew.metadata.file;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class FileSystemDirectory extends Directory {
    public static final int TAG_FILE_MODIFIED_DATE = 3;
    public static final int TAG_FILE_NAME = 1;
    public static final int TAG_FILE_SIZE = 2;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "File";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "File Name");
        hashMap.put(2, "File Size");
        hashMap.put(3, "File Modified Date");
    }

    public FileSystemDirectory() {
        setDescriptor(new FileSystemDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
