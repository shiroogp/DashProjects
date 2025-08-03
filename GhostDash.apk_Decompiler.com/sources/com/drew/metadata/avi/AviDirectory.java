package com.drew.metadata.avi;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class AviDirectory extends Directory {
    public static final String CHUNK_MAIN_HEADER = "avih";
    public static final String CHUNK_STREAM_HEADER = "strh";
    public static final String FORMAT = "AVI ";
    public static final String LIST_HEADER = "hdrl";
    public static final String LIST_STREAM_HEADER = "strl";
    public static final int TAG_AUDIO_CODEC = 5;
    public static final int TAG_DURATION = 3;
    public static final int TAG_FRAMES_PER_SECOND = 1;
    public static final int TAG_HEIGHT = 7;
    public static final int TAG_SAMPLES_PER_SECOND = 2;
    public static final int TAG_STREAMS = 8;
    public static final int TAG_VIDEO_CODEC = 4;
    public static final int TAG_WIDTH = 6;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "AVI";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Frames Per Second");
        hashMap.put(2, "Samples Per Second");
        hashMap.put(3, "Duration");
        hashMap.put(4, "Video Codec");
        hashMap.put(5, "Audio Codec");
        hashMap.put(6, "Width");
        hashMap.put(7, "Height");
        hashMap.put(8, "Stream Count");
    }

    public AviDirectory() {
        setDescriptor(new AviDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
