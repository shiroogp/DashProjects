package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.internal.mlkit_vision_common.zzig;
import com.google.android.gms.internal.mlkit_vision_common.zzii;
import com.google.android.odml.image.BitmapExtractor;
import com.google.android.odml.image.ByteBufferExtractor;
import com.google.android.odml.image.ImageProperties;
import com.google.android.odml.image.MediaImageExtractor;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public class CommonConvertUtils {
    public static int convertToAndroidImageFormat(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (i == 17) {
                return 17;
            }
            if (i == 35) {
                return 35;
            }
            if (i != 842094169) {
                return 0;
            }
            return InputImage.IMAGE_FORMAT_YV12;
        } else if (i == 17) {
            return 17;
        } else {
            if (i != 842094169) {
                return 0;
            }
            return InputImage.IMAGE_FORMAT_YV12;
        }
    }

    public static int convertToMVRotation(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 90) {
            return 1;
        }
        if (i == 180) {
            return 2;
        }
        if (i == 270) {
            return 3;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Invalid rotation: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    static InputImage zza(MlImage mlImage) {
        int i;
        Integer num;
        int i2;
        ImageProperties imageProperties = mlImage.getContainedImageProperties().get(0);
        int storageType = imageProperties.getStorageType();
        if (storageType == 1) {
            Bitmap extract = BitmapExtractor.extract(mlImage);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int height = mlImage.getHeight();
            int width = mlImage.getWidth();
            if (Build.VERSION.SDK_INT > 19) {
                i = extract.getAllocationByteCount();
            } else {
                i = extract.getByteCount();
            }
            zzb(-1, 1, elapsedRealtime, height, width, i, mlImage.getRotation());
            return InputImage.fromBitmap(extract, mlImage.getRotation());
        } else if (storageType == 2) {
            ByteBuffer extract2 = ByteBufferExtractor.extract(mlImage);
            int imageFormat = imageProperties.getImageFormat();
            if (imageFormat == 4) {
                num = 17;
            } else if (imageFormat != 5) {
                num = null;
            } else {
                num = Integer.valueOf(InputImage.IMAGE_FORMAT_YV12);
            }
            if (num == null) {
                return null;
            }
            zzb(num.intValue(), 3, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), extract2.limit(), mlImage.getRotation());
            return InputImage.fromByteBuffer(extract2, mlImage.getWidth(), mlImage.getHeight(), mlImage.getRotation(), num.intValue());
        } else if (storageType != 3 || Build.VERSION.SDK_INT < 19) {
            return null;
        } else {
            Image extract3 = MediaImageExtractor.extract(mlImage);
            if (extract3.getFormat() == 256) {
                i2 = extract3.getPlanes()[0].getBuffer().limit();
            } else {
                i2 = (extract3.getPlanes()[0].getBuffer().limit() * 3) / 2;
            }
            zzb(extract3.getFormat(), 5, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), i2, mlImage.getRotation());
            return InputImage.fromMediaImage(extract3, mlImage.getRotation());
        }
    }

    private static void zzb(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        zzii.zzb(zzig.zzb("vision-common"), i, i2, j, i3, i4, i5, i6);
    }
}
