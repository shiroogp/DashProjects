package com.drew.metadata.jfxx;

import com.drew.metadata.Directory;
import com.drew.metadata.MetadataException;
import java.util.HashMap;

public class JfxxDirectory extends Directory {
    public static final int TAG_EXTENSION_CODE = 5;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return JfxxReader.PREAMBLE;
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(5, "Extension Code");
    }

    public JfxxDirectory() {
        setDescriptor(new JfxxDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    public int getExtensionCode() throws MetadataException {
        return getInt(5);
    }
}
