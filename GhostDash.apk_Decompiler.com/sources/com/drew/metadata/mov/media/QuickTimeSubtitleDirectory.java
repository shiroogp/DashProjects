package com.drew.metadata.mov.media;

import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public class QuickTimeSubtitleDirectory extends QuickTimeDirectory {
    public static final int TAG_ALL_SAMPLES_FORCED = 3;
    public static final int TAG_DEFAULT_TEXT_BOX = 4;
    public static final int TAG_FONT_FACE = 6;
    public static final int TAG_FONT_IDENTIFIER = 5;
    public static final int TAG_FONT_SIZE = 7;
    public static final int TAG_FOREGROUND_COLOR = 8;
    public static final int TAG_SOME_SAMPLES_FORCED = 2;
    public static final int TAG_VERTICAL_PLACEMENT = 1;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "QuickTime Subtitle";
    }

    public QuickTimeSubtitleDirectory() {
        setDescriptor(new QuickTimeSubtitleDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        QuickTimeMediaDirectory.addQuickTimeMediaTags(hashMap);
        hashMap.put(1, "Vertical Placement");
        hashMap.put(2, "Some Samples Forced");
        hashMap.put(3, "All Samples Forced");
        hashMap.put(4, "Default Text Box");
        hashMap.put(5, "Font Identifier");
        hashMap.put(6, "Font Face");
        hashMap.put(7, "Font Size");
        hashMap.put(8, "Foreground Color");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
