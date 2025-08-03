package com.drew.metadata.exif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PanasonicRawWbInfo2Directory extends Directory {
    public static final int TagNumWbEntries = 0;
    public static final int TagWbRgbLevels1 = 2;
    public static final int TagWbRgbLevels2 = 6;
    public static final int TagWbRgbLevels3 = 10;
    public static final int TagWbRgbLevels4 = 14;
    public static final int TagWbRgbLevels5 = 18;
    public static final int TagWbRgbLevels6 = 22;
    public static final int TagWbRgbLevels7 = 26;
    public static final int TagWbType1 = 1;
    public static final int TagWbType2 = 5;
    public static final int TagWbType3 = 9;
    public static final int TagWbType4 = 13;
    public static final int TagWbType5 = 17;
    public static final int TagWbType6 = 21;
    public static final int TagWbType7 = 25;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "PanasonicRaw WbInfo2";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Num WB Entries");
        hashMap.put(0, "Num WB Entries");
        hashMap.put(1, "WB Type 1");
        hashMap.put(2, "WB RGB Levels 1");
        hashMap.put(5, "WB Type 2");
        hashMap.put(6, "WB RGB Levels 2");
        hashMap.put(9, "WB Type 3");
        hashMap.put(10, "WB RGB Levels 3");
        hashMap.put(13, "WB Type 4");
        hashMap.put(14, "WB RGB Levels 4");
        hashMap.put(17, "WB Type 5");
        hashMap.put(18, "WB RGB Levels 5");
        hashMap.put(21, "WB Type 6");
        hashMap.put(22, "WB RGB Levels 6");
        hashMap.put(25, "WB Type 7");
        hashMap.put(26, "WB RGB Levels 7");
    }

    public PanasonicRawWbInfo2Directory() {
        setDescriptor(new PanasonicRawWbInfo2Descriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
