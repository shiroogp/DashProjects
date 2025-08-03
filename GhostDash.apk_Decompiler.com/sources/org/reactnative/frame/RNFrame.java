package org.reactnative.frame;

import com.google.mlkit.vision.common.InputImage;
import org.reactnative.camera.utils.ImageDimensions;

public class RNFrame {
    private ImageDimensions mDimensions;
    private InputImage mFrame;

    public RNFrame(InputImage inputImage, ImageDimensions imageDimensions) {
        this.mFrame = inputImage;
        this.mDimensions = imageDimensions;
    }

    public InputImage getFrame() {
        return this.mFrame;
    }

    public ImageDimensions getDimensions() {
        return this.mDimensions;
    }
}
