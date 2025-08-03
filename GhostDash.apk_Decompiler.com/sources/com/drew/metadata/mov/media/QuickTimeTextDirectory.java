package com.drew.metadata.mov.media;

import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public class QuickTimeTextDirectory extends QuickTimeDirectory {
    public static final int TAG_ANTI_ALIAS = 9;
    public static final int TAG_AUTO_SCALE = 1;
    public static final int TAG_BACKGROUND_COLOR = 12;
    public static final int TAG_CONTINUOUS_SCROLL = 7;
    public static final int TAG_DEFAULT_TEXT_BOX = 13;
    public static final int TAG_DROP_SHADOW = 8;
    public static final int TAG_FONT_FACE = 15;
    public static final int TAG_FONT_NUMBER = 14;
    public static final int TAG_FOREGROUND_COLOR = 16;
    public static final int TAG_HORIZONTAL_SCROLL = 5;
    public static final int TAG_JUSTIFICATION = 11;
    public static final int TAG_KEY_TEXT = 10;
    public static final int TAG_MOVIE_BACKGROUND_COLOR = 2;
    public static final int TAG_NAME = 17;
    public static final int TAG_REVERSE_SCROLL = 6;
    public static final int TAG_SCROLL_IN = 3;
    public static final int TAG_SCROLL_OUT = 4;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "QuickTime Text";
    }

    public QuickTimeTextDirectory() {
        setDescriptor(new QuickTimeTextDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        QuickTimeMediaDirectory.addQuickTimeMediaTags(hashMap);
        hashMap.put(1, "Auto Scale");
        hashMap.put(2, "Use Background Color");
        hashMap.put(3, "Scroll In");
        hashMap.put(4, "Scroll Out");
        hashMap.put(5, "Scroll Orientation");
        hashMap.put(6, "Scroll Direction");
        hashMap.put(7, "Continuous Scroll");
        hashMap.put(8, "Drop Shadow");
        hashMap.put(9, "Anti-aliasing");
        hashMap.put(10, "Display Text Background Color");
        hashMap.put(11, "Alignment");
        hashMap.put(12, "Background Color");
        hashMap.put(13, "Default Text Box");
        hashMap.put(14, "Font Number");
        hashMap.put(15, "Font Face");
        hashMap.put(16, "Foreground Color");
        hashMap.put(17, "Font Name");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
