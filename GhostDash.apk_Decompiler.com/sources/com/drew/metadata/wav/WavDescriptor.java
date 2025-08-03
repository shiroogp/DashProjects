package com.drew.metadata.wav;

import com.drew.metadata.TagDescriptor;

public class WavDescriptor extends TagDescriptor<WavDirectory> {
    public WavDescriptor(WavDirectory wavDirectory) {
        super(wavDirectory);
    }

    public String getDescription(int i) {
        return super.getDescription(i);
    }
}
