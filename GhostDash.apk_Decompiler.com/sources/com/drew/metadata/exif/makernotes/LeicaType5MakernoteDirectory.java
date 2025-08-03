package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class LeicaType5MakernoteDirectory extends Directory {
    public static final int TagExposureMode = 1037;
    public static final int TagFilmMode = 1042;
    public static final int TagLensModel = 771;
    public static final int TagOriginalDirectory = 1032;
    public static final int TagOriginalFileName = 1031;
    public static final int TagShotInfo = 1040;
    public static final int TagWbRgbLevels = 1043;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Leica Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(771, "Lens Model");
        hashMap.put(Integer.valueOf(TagOriginalFileName), "Original File Name");
        hashMap.put(1032, "Original Directory");
        hashMap.put(1037, "Exposure Mode");
        hashMap.put(1040, "Shot Info");
        hashMap.put(1042, "Film Mode");
        hashMap.put(1043, "WB RGB Levels");
    }

    public LeicaType5MakernoteDirectory() {
        setDescriptor(new LeicaType5MakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
