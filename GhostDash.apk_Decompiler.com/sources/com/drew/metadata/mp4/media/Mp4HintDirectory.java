package com.drew.metadata.mp4.media;

import java.util.HashMap;

public class Mp4HintDirectory extends Mp4MediaDirectory {
    public static final int TAG_AVERAGE_BITRATE = 104;
    public static final int TAG_AVERAGE_PDU_SIZE = 102;
    public static final int TAG_MAX_BITRATE = 103;
    public static final int TAG_MAX_PDU_SIZE = 101;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "MP4 Hint";
    }

    public Mp4HintDirectory() {
        setDescriptor(new Mp4HintDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        Mp4MediaDirectory.addMp4MediaTags(hashMap);
        hashMap.put(101, "Max PDU Size");
        hashMap.put(102, "Average PDU Size");
        hashMap.put(103, "Max Bitrate");
        hashMap.put(104, "Average Bitrate");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
