package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;

    public BitmapEncoder(ArrayPool arrayPool2) {
        this.arrayPool = arrayPool2;
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|(2:39|40)|41|42) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r6 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r6 == null) goto L_0x006b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00cb */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8 A[SYNTHETIC, Splitter:B:39:0x00c8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r9, java.io.File r10, com.bumptech.glide.load.Options r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.getFormat(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = COMPRESSION_QUALITY     // Catch:{ all -> 0x00cc }
            java.lang.Object r4 = r11.get(r4)     // Catch:{ all -> 0x00cc }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00cc }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00cc }
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x005b }
            r7.<init>(r10)     // Catch:{ IOException -> 0x005b }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r10 = r8.arrayPool     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            if (r10 == 0) goto L_0x0045
            com.bumptech.glide.load.data.BufferedOutputStream r10 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r8.arrayPool     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            r10.<init>(r7, r6)     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            r6 = r10
            goto L_0x0046
        L_0x0045:
            r6 = r7
        L_0x0046:
            r9.compress(r1, r4, r6)     // Catch:{ IOException -> 0x005b }
            r6.close()     // Catch:{ IOException -> 0x005b }
            r5 = 1
            if (r6 == 0) goto L_0x006b
        L_0x004f:
            r6.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006b
        L_0x0053:
            r9 = move-exception
            r6 = r7
            goto L_0x00c6
        L_0x0056:
            r10 = move-exception
            r6 = r7
            goto L_0x005c
        L_0x0059:
            r9 = move-exception
            goto L_0x00c6
        L_0x005b:
            r10 = move-exception
        L_0x005c:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x0059 }
            if (r4 == 0) goto L_0x0068
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r10)     // Catch:{ all -> 0x0059 }
        L_0x0068:
            if (r6 == 0) goto L_0x006b
            goto L_0x004f
        L_0x006b:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x00cc }
            if (r10 == 0) goto L_0x00c2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cc }
            r10.<init>()     // Catch:{ all -> 0x00cc }
            java.lang.String r4 = "Compressed with type: "
            java.lang.StringBuilder r10 = r10.append(r4)     // Catch:{ all -> 0x00cc }
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = " of size "
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch:{ all -> 0x00cc }
            int r1 = com.bumptech.glide.util.Util.getBitmapByteSize(r9)     // Catch:{ all -> 0x00cc }
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = " in "
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch:{ all -> 0x00cc }
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch:{ all -> 0x00cc }
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = ", options format: "
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r1 = COMPRESSION_FORMAT     // Catch:{ all -> 0x00cc }
            java.lang.Object r11 = r11.get(r1)     // Catch:{ all -> 0x00cc }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x00cc }
            java.lang.String r11 = ", hasAlpha: "
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x00cc }
            boolean r9 = r9.hasAlpha()     // Catch:{ all -> 0x00cc }
            java.lang.StringBuilder r9 = r10.append(r9)     // Catch:{ all -> 0x00cc }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00cc }
            android.util.Log.v(r0, r9)     // Catch:{ all -> 0x00cc }
        L_0x00c2:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r5
        L_0x00c6:
            if (r6 == 0) goto L_0x00cb
            r6.close()     // Catch:{ IOException -> 0x00cb }
        L_0x00cb:
            throw r9     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r9 = move-exception
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
