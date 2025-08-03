package com.drew.metadata.mov.media;

import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public class QuickTimeMusicDirectory extends QuickTimeDirectory {
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "QuickTime Music";
    }

    public QuickTimeMusicDirectory() {
        setDescriptor(new QuickTimeMusicDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        QuickTimeMediaDirectory.addQuickTimeMediaTags(hashMap);
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
