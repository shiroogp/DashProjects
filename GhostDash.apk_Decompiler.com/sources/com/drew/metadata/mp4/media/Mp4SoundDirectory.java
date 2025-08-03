package com.drew.metadata.mp4.media;

import java.util.HashMap;

public class Mp4SoundDirectory extends Mp4MediaDirectory {
    public static final int TAG_AUDIO_FORMAT = 101;
    public static final int TAG_AUDIO_SAMPLE_RATE = 104;
    public static final int TAG_AUDIO_SAMPLE_SIZE = 103;
    public static final int TAG_NUMBER_OF_CHANNELS = 102;
    public static final int TAG_SOUND_BALANCE = 105;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "MP4 Sound";
    }

    public Mp4SoundDirectory() {
        setDescriptor(new Mp4SoundDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        Mp4MediaDirectory.addMp4MediaTags(hashMap);
        hashMap.put(101, "Format");
        hashMap.put(102, "Number of Channels");
        hashMap.put(103, "Sample Size");
        hashMap.put(104, "Sample Rate");
        hashMap.put(105, "Balance");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
