package org.reactnative.frame;

import android.graphics.Bitmap;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;
import org.reactnative.camera.utils.ImageDimensions;

public class RNFrameFactory {
    public static RNFrame buildFrame(byte[] bArr, int i, int i2, int i3) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        return new RNFrame(InputImage.fromByteBuffer(wrap, i, i2, i3, 17), new ImageDimensions(i, i2, i3));
    }

    public static RNFrame buildFrame(Bitmap bitmap) {
        return new RNFrame(InputImage.fromBitmap(bitmap, 0), new ImageDimensions(bitmap.getWidth(), bitmap.getHeight()));
    }
}
