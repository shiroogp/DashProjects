package com.drew.metadata.mov.media;

import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public class QuickTimeSoundDirectory extends QuickTimeDirectory {
    public static final int TAG_AUDIO_FORMAT = 769;
    public static final int TAG_AUDIO_SAMPLE_RATE = 772;
    public static final int TAG_AUDIO_SAMPLE_SIZE = 771;
    public static final int TAG_NUMBER_OF_CHANNELS = 770;
    public static final int TAG_SOUND_BALANCE = 773;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "QuickTime Sound";
    }

    public QuickTimeSoundDirectory() {
        setDescriptor(new QuickTimeSoundDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        QuickTimeMediaDirectory.addQuickTimeMediaTags(hashMap);
        hashMap.put(769, "Format");
        hashMap.put(770, "Number of Channels");
        hashMap.put(771, "Sample Size");
        hashMap.put(772, "Sample Rate");
        hashMap.put(773, "Balance");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
