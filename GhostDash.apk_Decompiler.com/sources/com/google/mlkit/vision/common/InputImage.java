package com.google.mlkit.vision.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzig;
import com.google.android.gms.internal.mlkit_vision_common.zzii;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public class InputImage implements MLTaskInput {
    public static final int IMAGE_FORMAT_BITMAP = -1;
    public static final int IMAGE_FORMAT_NV21 = 17;
    public static final int IMAGE_FORMAT_YUV_420_888 = 35;
    public static final int IMAGE_FORMAT_YV12 = 842094169;
    private volatile Bitmap zza;
    private volatile ByteBuffer zzb;
    private volatile zzb zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.mlkit:vision-common@@16.5.0 */
    public @interface ImageFormat {
    }

    private InputImage(Bitmap bitmap, int i) {
        this.zza = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.zzd = bitmap.getWidth();
        this.zze = bitmap.getHeight();
        this.zzf = i;
        this.zzg = -1;
    }

    public static InputImage fromBitmap(Bitmap bitmap, int i) {
        int i2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(bitmap, i);
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if (Build.VERSION.SDK_INT > 19) {
            i2 = bitmap.getAllocationByteCount();
        } else {
            i2 = bitmap.getByteCount();
        }
        zza(-1, 1, elapsedRealtime, height, width, i2, i);
        return inputImage;
    }

    public static InputImage fromByteArray(byte[] bArr, int i, int i2, int i3, int i4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(ByteBuffer.wrap((byte[]) Preconditions.checkNotNull(bArr)), i, i2, i3, i4);
        zza(i4, 2, elapsedRealtime, i2, i, bArr.length, i3);
        return inputImage;
    }

    public static InputImage fromByteBuffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(byteBuffer, i, i2, i3, i4);
        zza(i4, 3, elapsedRealtime, i2, i, byteBuffer.limit(), i3);
        return inputImage;
    }

    public static InputImage fromFilePath(Context context, Uri uri) throws IOException {
        int i;
        Preconditions.checkNotNull(context, "Please provide a valid Context");
        Preconditions.checkNotNull(uri, "Please provide a valid imageUri");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Bitmap zza2 = ImageUtils.getInstance().zza(context.getContentResolver(), uri);
        InputImage inputImage = new InputImage(zza2, 0);
        int height = zza2.getHeight();
        int width = zza2.getWidth();
        if (Build.VERSION.SDK_INT > 19) {
            i = zza2.getAllocationByteCount();
        } else {
            i = zza2.getByteCount();
        }
        zza(-1, 4, elapsedRealtime, height, width, i, 0);
        return inputImage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.mlkit.vision.common.InputImage fromMediaImage(android.media.Image r8, int r9) {
        /*
            long r2 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r0 = "Please provide a valid image"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8, r0)
            r0 = 270(0x10e, float:3.78E-43)
            r1 = 0
            r4 = 1
            if (r9 == 0) goto L_0x001e
            r5 = 90
            if (r9 == r5) goto L_0x001e
            r5 = 180(0xb4, float:2.52E-43)
            if (r9 == r5) goto L_0x001e
            if (r9 != r0) goto L_0x001b
            r7 = r0
            goto L_0x001f
        L_0x001b:
            r7 = r9
            r9 = r1
            goto L_0x0020
        L_0x001e:
            r7 = r9
        L_0x001f:
            r9 = r4
        L_0x0020:
            java.lang.String r0 = "Invalid rotation. Only 0, 90, 180, 270 are supported currently."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r9, r0)
            int r9 = r8.getFormat()
            r0 = 256(0x100, float:3.59E-43)
            if (r9 == r0) goto L_0x0037
            int r9 = r8.getFormat()
            r5 = 35
            if (r9 != r5) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r4 = r1
        L_0x0037:
            java.lang.String r9 = "Only JPEG and YUV_420_888 are supported now"
            com.google.android.gms.common.internal.Preconditions.checkArgument(r4, r9)
            android.media.Image$Plane[] r9 = r8.getPlanes()
            int r4 = r8.getFormat()
            if (r4 != r0) goto L_0x0064
            android.media.Image$Plane[] r9 = r8.getPlanes()
            r9 = r9[r1]
            java.nio.ByteBuffer r9 = r9.getBuffer()
            int r9 = r9.limit()
            com.google.mlkit.vision.common.InputImage r0 = new com.google.mlkit.vision.common.InputImage
            com.google.mlkit.vision.common.internal.ImageConvertUtils r4 = com.google.mlkit.vision.common.internal.ImageConvertUtils.getInstance()
            android.graphics.Bitmap r4 = r4.convertJpegToUpRightBitmap(r8, r7)
            r0.<init>(r4, r1)
        L_0x0061:
            r6 = r9
            r9 = r0
            goto L_0x009a
        L_0x0064:
            int r0 = r9.length
            r4 = r1
        L_0x0066:
            if (r4 >= r0) goto L_0x007a
            r5 = r9[r4]
            java.nio.ByteBuffer r6 = r5.getBuffer()
            if (r6 == 0) goto L_0x0077
            java.nio.ByteBuffer r5 = r5.getBuffer()
            r5.rewind()
        L_0x0077:
            int r4 = r4 + 1
            goto L_0x0066
        L_0x007a:
            com.google.mlkit.vision.common.InputImage r0 = new com.google.mlkit.vision.common.InputImage
            int r9 = r8.getWidth()
            int r4 = r8.getHeight()
            r0.<init>(r8, r9, r4, r7)
            android.media.Image$Plane[] r9 = r8.getPlanes()
            r9 = r9[r1]
            java.nio.ByteBuffer r9 = r9.getBuffer()
            int r9 = r9.limit()
            int r9 = r9 * 3
            int r9 = r9 / 2
            goto L_0x0061
        L_0x009a:
            int r0 = r8.getFormat()
            r1 = 5
            int r4 = r8.getHeight()
            int r5 = r8.getWidth()
            zza(r0, r1, r2, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.common.InputImage.fromMediaImage(android.media.Image, int):com.google.mlkit.vision.common.InputImage");
    }

    private static void zza(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        zzii.zza(zzig.zzb("vision-common"), i, i2, j, i3, i4, i5, i6);
    }

    public Bitmap getBitmapInternal() {
        return this.zza;
    }

    public ByteBuffer getByteBuffer() {
        return this.zzb;
    }

    public int getFormat() {
        return this.zzg;
    }

    public int getHeight() {
        return this.zze;
    }

    public Image getMediaImage() {
        if (this.zzc == null) {
            return null;
        }
        return this.zzc.zza();
    }

    public Image.Plane[] getPlanes() {
        if (this.zzc == null) {
            return null;
        }
        return this.zzc.zzb();
    }

    public int getRotationDegrees() {
        return this.zzf;
    }

    public int getWidth() {
        return this.zzd;
    }

    private InputImage(Image image, int i, int i2, int i3) {
        Preconditions.checkNotNull(image);
        this.zzc = new zzb(image);
        this.zzd = i;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = 35;
    }

    private InputImage(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        boolean z = true;
        if (i4 != 842094169) {
            if (i4 == 17) {
                i4 = 17;
            } else {
                z = false;
            }
        }
        Preconditions.checkArgument(z);
        this.zzb = (ByteBuffer) Preconditions.checkNotNull(byteBuffer);
        byteBuffer.rewind();
        this.zzd = i;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = i4;
    }
}
