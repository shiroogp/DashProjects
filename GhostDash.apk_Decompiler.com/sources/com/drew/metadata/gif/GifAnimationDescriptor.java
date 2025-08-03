package com.drew.metadata.gif;

import com.drew.metadata.TagDescriptor;

public class GifAnimationDescriptor extends TagDescriptor<GifAnimationDirectory> {
    public GifAnimationDescriptor(GifAnimationDirectory gifAnimationDirectory) {
        super(gifAnimationDirectory);
    }

    public String getDescription(int i) {
        if (i != 1) {
            return super.getDescription(i);
        }
        return getIterationCountDescription();
    }

    public String getIterationCountDescription() {
        Integer integer = ((GifAnimationDirectory) this._directory).getInteger(1);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "Infinite";
        }
        if (integer.intValue() == 1) {
            return "Once";
        }
        return integer.intValue() == 2 ? "Twice" : integer.toString() + " times";
    }
}
