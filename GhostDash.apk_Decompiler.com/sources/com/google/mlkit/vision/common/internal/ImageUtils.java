package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.os.Build;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        return zzb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r0 == 842094169) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.dynamic.IObjectWrapper getImageDataWrapper(com.google.mlkit.vision.common.InputImage r4) throws com.google.mlkit.common.MlKitException {
        /*
            r3 = this;
            int r0 = r4.getFormat()
            r1 = -1
            if (r0 == r1) goto L_0x0051
            r1 = 17
            if (r0 == r1) goto L_0x0042
            r1 = 35
            if (r0 == r1) goto L_0x0015
            r1 = 842094169(0x32315659, float:1.0322389E-8)
            if (r0 != r1) goto L_0x0024
            goto L_0x0042
        L_0x0015:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L_0x0024
            android.media.Image r4 = r4.getMediaImage()
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)
            return r4
        L_0x0024:
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException
            int r4 = r4.getFormat()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 37
            r1.<init>(r2)
            java.lang.String r2 = "Unsupported image format: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r1 = 3
            r0.<init>(r4, r1)
            throw r0
        L_0x0042:
            java.nio.ByteBuffer r4 = r4.getByteBuffer()
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)
            return r4
        L_0x0051:
            android.graphics.Bitmap r4 = r4.getBitmapInternal()
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.common.internal.ImageUtils.getImageDataWrapper(com.google.mlkit.vision.common.InputImage):com.google.android.gms.dynamic.IObjectWrapper");
    }

    public int getMobileVisionImageFormat(InputImage inputImage) {
        return inputImage.getFormat();
    }

    public int getMobileVisionImageSize(InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
            }
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getByteCount();
        } else if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
        } else {
            if (inputImage.getFormat() != 35) {
                return 0;
            }
            return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
        }
    }

    public Matrix getUprightRotationMatrix(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(((float) (-i)) / 2.0f, ((float) (-i2)) / 2.0f);
        matrix.postRotate((float) (i3 * 90));
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(((float) i5) / 2.0f, ((float) i) / 2.0f);
        return matrix;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006a A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008c A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090 A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097 A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2 A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6 A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ad A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c2 A[Catch:{ FileNotFoundException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[Catch:{ FileNotFoundException -> 0x00cf }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap zza(android.content.ContentResolver r11, android.net.Uri r12) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "MLKitImageUtils"
            android.graphics.Bitmap r8 = android.provider.MediaStore.Images.Media.getBitmap(r11, r12)     // Catch:{ FileNotFoundException -> 0x00cf }
            if (r8 == 0) goto L_0x00c7
            java.lang.String r1 = "content"
            java.lang.String r2 = r12.getScheme()     // Catch:{ FileNotFoundException -> 0x00cf }
            boolean r1 = r1.equals(r2)     // Catch:{ FileNotFoundException -> 0x00cf }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = "file"
            java.lang.String r4 = r12.getScheme()     // Catch:{ FileNotFoundException -> 0x00cf }
            boolean r1 = r1.equals(r4)     // Catch:{ FileNotFoundException -> 0x00cf }
            if (r1 != 0) goto L_0x0023
            goto L_0x0072
        L_0x0023:
            java.io.InputStream r11 = r11.openInputStream(r12)     // Catch:{ IOException -> 0x0042 }
            if (r11 == 0) goto L_0x0039
            androidx.exifinterface.media.ExifInterface r1 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x002f }
            r1.<init>((java.io.InputStream) r11)     // Catch:{ all -> 0x002f }
            goto L_0x003a
        L_0x002f:
            r1 = move-exception
            r11.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r11 = move-exception
            r1.addSuppressed(r11)     // Catch:{ IOException -> 0x0042 }
        L_0x0038:
            throw r1     // Catch:{ IOException -> 0x0042 }
        L_0x0039:
            r1 = r3
        L_0x003a:
            if (r11 == 0) goto L_0x0068
            r11.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0068
        L_0x0040:
            r11 = move-exception
            goto L_0x0044
        L_0x0042:
            r11 = move-exception
            r1 = r3
        L_0x0044:
            com.google.android.gms.common.internal.GmsLogger r4 = zza     // Catch:{ FileNotFoundException -> 0x00cf }
            java.lang.String r5 = java.lang.String.valueOf(r12)     // Catch:{ FileNotFoundException -> 0x00cf }
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch:{ FileNotFoundException -> 0x00cf }
            int r6 = r6.length()     // Catch:{ FileNotFoundException -> 0x00cf }
            int r6 = r6 + 48
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00cf }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00cf }
            java.lang.String r6 = "failed to open file to read rotation meta data: "
            r7.append(r6)     // Catch:{ FileNotFoundException -> 0x00cf }
            r7.append(r5)     // Catch:{ FileNotFoundException -> 0x00cf }
            java.lang.String r5 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00cf }
            r4.e(r0, r5, r11)     // Catch:{ FileNotFoundException -> 0x00cf }
        L_0x0068:
            if (r1 != 0) goto L_0x006b
            goto L_0x0072
        L_0x006b:
            java.lang.String r11 = "Orientation"
            r2 = 1
            int r2 = r1.getAttributeInt(r11, r2)     // Catch:{ FileNotFoundException -> 0x00cf }
        L_0x0072:
            android.graphics.Matrix r11 = new android.graphics.Matrix     // Catch:{ FileNotFoundException -> 0x00cf }
            r11.<init>()     // Catch:{ FileNotFoundException -> 0x00cf }
            int r4 = r8.getWidth()     // Catch:{ FileNotFoundException -> 0x00cf }
            int r5 = r8.getHeight()     // Catch:{ FileNotFoundException -> 0x00cf }
            r1 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r6 = 1119092736(0x42b40000, float:90.0)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = 1065353216(0x3f800000, float:1.0)
            switch(r2) {
                case 2: goto L_0x00ad;
                case 3: goto L_0x00a6;
                case 4: goto L_0x00a2;
                case 5: goto L_0x009b;
                case 6: goto L_0x0097;
                case 7: goto L_0x0090;
                case 8: goto L_0x008c;
                default: goto L_0x008a;
            }     // Catch:{ FileNotFoundException -> 0x00cf }
        L_0x008a:
            r6 = r3
            goto L_0x00b6
        L_0x008c:
            r11.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x00cf }
            goto L_0x00ab
        L_0x0090:
            r11.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x00cf }
            r11.postScale(r7, r9)     // Catch:{ FileNotFoundException -> 0x00cf }
            goto L_0x00ab
        L_0x0097:
            r11.postRotate(r6)     // Catch:{ FileNotFoundException -> 0x00cf }
            goto L_0x00ab
        L_0x009b:
            r11.postRotate(r6)     // Catch:{ FileNotFoundException -> 0x00cf }
            r11.postScale(r7, r9)     // Catch:{ FileNotFoundException -> 0x00cf }
            goto L_0x00ab
        L_0x00a2:
            r11.postScale(r9, r7)     // Catch:{ FileNotFoundException -> 0x00cf }
            goto L_0x00ab
        L_0x00a6:
            r1 = 1127481344(0x43340000, float:180.0)
            r11.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x00cf }
        L_0x00ab:
            r6 = r11
            goto L_0x00b6
        L_0x00ad:
            android.graphics.Matrix r11 = new android.graphics.Matrix     // Catch:{ FileNotFoundException -> 0x00cf }
            r11.<init>()     // Catch:{ FileNotFoundException -> 0x00cf }
            r11.postScale(r7, r9)     // Catch:{ FileNotFoundException -> 0x00cf }
            goto L_0x00ab
        L_0x00b6:
            if (r6 == 0) goto L_0x00c6
            r2 = 0
            r3 = 0
            r7 = 1
            r1 = r8
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ FileNotFoundException -> 0x00cf }
            if (r8 == r11) goto L_0x00c6
            r8.recycle()     // Catch:{ FileNotFoundException -> 0x00cf }
            r8 = r11
        L_0x00c6:
            return r8
        L_0x00c7:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ FileNotFoundException -> 0x00cf }
            java.lang.String r1 = "The image Uri could not be resolved."
            r11.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00cf }
            throw r11     // Catch:{ FileNotFoundException -> 0x00cf }
        L_0x00cf:
            r11 = move-exception
            com.google.android.gms.common.internal.GmsLogger r1 = zza
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r2 = java.lang.String.valueOf(r12)
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = r2 + 21
            r3.<init>(r2)
            java.lang.String r2 = "Could not open file: "
            r3.append(r2)
            r3.append(r12)
            java.lang.String r12 = r3.toString()
            r1.e(r0, r12, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.common.internal.ImageUtils.zza(android.content.ContentResolver, android.net.Uri):android.graphics.Bitmap");
    }
}
