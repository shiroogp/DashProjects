package org.reactnative.camera.tasks;

import android.os.AsyncTask;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeScannerAsyncTask extends AsyncTask<Void, Void, Result> {
    private int mCameraViewHeight;
    private int mCameraViewWidth;
    private BarCodeScannerAsyncTaskDelegate mDelegate;
    private int mHeight;
    private byte[] mImageData;
    private boolean mLimitScanArea;
    private final MultiFormatReader mMultiFormatReader;
    private float mRatio;
    private float mScanAreaHeight;
    private float mScanAreaWidth;
    private float mScanAreaX;
    private float mScanAreaY;
    private int mWidth;

    public BarCodeScannerAsyncTask(BarCodeScannerAsyncTaskDelegate barCodeScannerAsyncTaskDelegate, MultiFormatReader multiFormatReader, byte[] bArr, int i, int i2, boolean z, float f, float f2, float f3, float f4, int i3, int i4, float f5) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mDelegate = barCodeScannerAsyncTaskDelegate;
        this.mMultiFormatReader = multiFormatReader;
        this.mLimitScanArea = z;
        this.mScanAreaX = f;
        this.mScanAreaY = f2;
        this.mScanAreaWidth = f3;
        this.mScanAreaHeight = f4;
        this.mCameraViewWidth = i3;
        this.mCameraViewHeight = i4;
        this.mRatio = f5;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2 = rotateImage(r10.mImageData, r10.mWidth, r10.mHeight);
        r3 = r10.mHeight;
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0075, code lost:
        return r10.mMultiFormatReader.decodeWithState(generateBitmapFromImageData(r2, r3, r10.mWidth, false, (r3 - r0) - r13, r12, r0, r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r2 = r10.mImageData;
        r3 = r10.mWidth;
        r4 = r10.mHeight;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0092, code lost:
        return r10.mMultiFormatReader.decodeWithState(generateBitmapFromImageData(r2, r3, r4, true, (r3 - r14) - r12, (r4 - r0) - r13, r14, r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = rotateImage(r10.mImageData, r10.mWidth, r10.mHeight);
        r3 = r10.mHeight;
        r4 = r10.mWidth;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b4, code lost:
        return r10.mMultiFormatReader.decodeWithState(generateBitmapFromImageData(r2, r3, r4, true, r13, (r4 - r14) - r12, r0, r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b5, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0076 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0093 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0054 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0052 A[ExcHandler: all (r0v13 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:5:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result doInBackground(java.lang.Void... r16) {
        /*
            r15 = this;
            r10 = r15
            boolean r0 = r15.isCancelled()
            r11 = 0
            if (r0 != 0) goto L_0x00b8
            org.reactnative.camera.tasks.BarCodeScannerAsyncTaskDelegate r0 = r10.mDelegate
            if (r0 != 0) goto L_0x000e
            goto L_0x00b8
        L_0x000e:
            int r0 = r10.mCameraViewHeight
            float r0 = (float) r0
            float r1 = r10.mRatio
            float r0 = r0 / r1
            int r0 = (int) r0
            int r1 = r10.mCameraViewWidth
            int r2 = r0 - r1
            int r2 = r2 / 2
            float r2 = (float) r2
            float r3 = r10.mScanAreaY
            float r4 = (float) r1
            float r3 = r3 * r4
            float r2 = r2 + r3
            float r0 = (float) r0
            float r2 = r2 / r0
            float r3 = r10.mScanAreaX
            int r4 = r10.mWidth
            float r5 = (float) r4
            float r3 = r3 * r5
            int r12 = (int) r3
            int r5 = r10.mHeight
            float r3 = (float) r5
            float r2 = r2 * r3
            int r13 = (int) r2
            float r2 = r10.mScanAreaWidth
            float r3 = (float) r4
            float r2 = r2 * r3
            int r14 = (int) r2
            float r2 = r10.mScanAreaHeight
            float r1 = (float) r1
            float r2 = r2 * r1
            float r2 = r2 / r0
            float r0 = (float) r5
            float r2 = r2 * r0
            int r0 = (int) r2
            byte[] r2 = r10.mImageData     // Catch:{ NotFoundException -> 0x0054, all -> 0x0052 }
            r6 = 0
            r1 = r15
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r0
            com.google.zxing.BinaryBitmap r1 = r1.generateBitmapFromImageData(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ NotFoundException -> 0x0054, all -> 0x0052 }
            com.google.zxing.MultiFormatReader r2 = r10.mMultiFormatReader     // Catch:{ NotFoundException -> 0x0054, all -> 0x0052 }
            com.google.zxing.Result r0 = r2.decodeWithState(r1)     // Catch:{ NotFoundException -> 0x0054, all -> 0x0052 }
            return r0
        L_0x0052:
            r0 = move-exception
            goto L_0x00b5
        L_0x0054:
            byte[] r1 = r10.mImageData     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            int r2 = r10.mWidth     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            int r3 = r10.mHeight     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            byte[] r2 = r15.rotateImage(r1, r2, r3)     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            int r3 = r10.mHeight     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            int r4 = r10.mWidth     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            r5 = 0
            int r1 = r3 - r0
            int r6 = r1 - r13
            r1 = r15
            r7 = r12
            r8 = r0
            r9 = r14
            com.google.zxing.BinaryBitmap r1 = r1.generateBitmapFromImageData(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            com.google.zxing.MultiFormatReader r2 = r10.mMultiFormatReader     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            com.google.zxing.Result r0 = r2.decodeWithState(r1)     // Catch:{ NotFoundException -> 0x0076, all -> 0x0052 }
            return r0
        L_0x0076:
            byte[] r2 = r10.mImageData     // Catch:{ NotFoundException -> 0x0093, all -> 0x0052 }
            int r3 = r10.mWidth     // Catch:{ NotFoundException -> 0x0093, all -> 0x0052 }
            int r4 = r10.mHeight     // Catch:{ NotFoundException -> 0x0093, all -> 0x0052 }
            r5 = 1
            int r1 = r3 - r14
            int r6 = r1 - r12
            int r1 = r4 - r0
            int r7 = r1 - r13
            r1 = r15
            r8 = r14
            r9 = r0
            com.google.zxing.BinaryBitmap r1 = r1.generateBitmapFromImageData(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ NotFoundException -> 0x0093, all -> 0x0052 }
            com.google.zxing.MultiFormatReader r2 = r10.mMultiFormatReader     // Catch:{ NotFoundException -> 0x0093, all -> 0x0052 }
            com.google.zxing.Result r0 = r2.decodeWithState(r1)     // Catch:{ NotFoundException -> 0x0093, all -> 0x0052 }
            return r0
        L_0x0093:
            byte[] r1 = r10.mImageData     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            int r2 = r10.mWidth     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            int r3 = r10.mHeight     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            byte[] r2 = r15.rotateImage(r1, r2, r3)     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            int r3 = r10.mHeight     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            int r4 = r10.mWidth     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            r5 = 1
            int r1 = r4 - r14
            int r7 = r1 - r12
            r1 = r15
            r6 = r13
            r8 = r0
            r9 = r14
            com.google.zxing.BinaryBitmap r0 = r1.generateBitmapFromImageData(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            com.google.zxing.MultiFormatReader r1 = r10.mMultiFormatReader     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            com.google.zxing.Result r0 = r1.decodeWithState(r0)     // Catch:{ NotFoundException -> 0x00b8, all -> 0x0052 }
            return r0
        L_0x00b5:
            r0.printStackTrace()
        L_0x00b8:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.tasks.BarCodeScannerAsyncTask.doInBackground(java.lang.Void[]):com.google.zxing.Result");
    }

    private byte[] rotateImage(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
        super.onPostExecute(result);
        if (result != null) {
            this.mDelegate.onBarCodeRead(result, this.mWidth, this.mHeight, this.mImageData);
        }
        this.mDelegate.onBarCodeScanningTaskCompleted();
    }

    private BinaryBitmap generateBitmapFromImageData(byte[] bArr, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        if (this.mLimitScanArea) {
            planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, i3, i4, i5, i6, false);
        } else {
            planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
        }
        if (z) {
            return new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource.invert()));
        }
        return new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource));
    }
}
