package com.drew.metadata.exif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PanasonicRawDistortionDirectory extends Directory {
    public static final int TagDistortionCorrection = 7;
    public static final int TagDistortionN = 12;
    public static final int TagDistortionParam02 = 2;
    public static final int TagDistortionParam04 = 4;
    public static final int TagDistortionParam08 = 8;
    public static final int TagDistortionParam09 = 9;
    public static final int TagDistortionParam11 = 11;
    public static final int TagDistortionScale = 5;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "PanasonicRaw DistortionInfo";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(2, "Distortion Param 2");
        hashMap.put(4, "Distortion Param 4");
        hashMap.put(5, "Distortion Scale");
        hashMap.put(7, "Distortion Correction");
        hashMap.put(8, "Distortion Param 8");
        hashMap.put(9, "Distortion Param 9");
        hashMap.put(11, "Distortion Param 11");
        hashMap.put(12, "Distortion N");
    }

    public PanasonicRawDistortionDirectory() {
        setDescriptor(new PanasonicRawDistortionDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
