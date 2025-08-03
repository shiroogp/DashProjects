package com.drew.metadata.mov.media;

import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public class QuickTimeTimecodeDirectory extends QuickTimeDirectory {
    public static final int TAG_24_HOUR_MAX = 2;
    public static final int TAG_BACKGROUND_COLOR = 9;
    public static final int TAG_COUNTER = 4;
    public static final int TAG_DROP_FRAME = 1;
    public static final int TAG_FONT_NAME = 10;
    public static final int TAG_NEGATIVE_TIMES_OK = 3;
    public static final int TAG_TEXT_COLOR = 8;
    public static final int TAG_TEXT_FACE = 6;
    public static final int TAG_TEXT_FONT = 5;
    public static final int TAG_TEXT_SIZE = 7;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "QuickTime Timecode";
    }

    public QuickTimeTimecodeDirectory() {
        setDescriptor(new QuickTimeTimecodeDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        QuickTimeMediaDirectory.addQuickTimeMediaTags(hashMap);
        hashMap.put(1, "Drop Frame");
        hashMap.put(2, "24 Hour Max");
        hashMap.put(3, "Negative Times OK");
        hashMap.put(4, "Counter");
        hashMap.put(5, "Text Font");
        hashMap.put(6, "Text Face");
        hashMap.put(7, "Text Size");
        hashMap.put(8, "Text Color");
        hashMap.put(9, "Background Color");
        hashMap.put(10, "Font Name");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
