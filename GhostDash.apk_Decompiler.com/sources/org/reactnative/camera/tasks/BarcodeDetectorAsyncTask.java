package org.reactnative.camera.tasks;

import android.graphics.Rect;
import android.os.AsyncTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.mlkit.vision.barcode.Barcode;
import java.util.List;
import org.reactnative.barcodedetector.BarcodeFormatUtils;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.utils.ImageDimensions;
import org.reactnative.frame.RNFrameFactory;

public class BarcodeDetectorAsyncTask extends AsyncTask<Void, Void, List<Barcode>> {
    private RNBarcodeDetector mBarcodeDetector;
    private BarcodeDetectorAsyncTaskDelegate mDelegate;
    private int mHeight;
    private byte[] mImageData;
    private ImageDimensions mImageDimensions;
    private int mPaddingLeft;
    private int mPaddingTop;
    private int mRotation;
    private double mScaleX;
    private double mScaleY;
    private int mWidth;

    public BarcodeDetectorAsyncTask(BarcodeDetectorAsyncTaskDelegate barcodeDetectorAsyncTaskDelegate, RNBarcodeDetector rNBarcodeDetector, byte[] bArr, int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, int i8) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotation = i3;
        this.mDelegate = barcodeDetectorAsyncTaskDelegate;
        this.mBarcodeDetector = rNBarcodeDetector;
        ImageDimensions imageDimensions = new ImageDimensions(i, i2, i3, i4);
        this.mImageDimensions = imageDimensions;
        this.mScaleX = ((double) i5) / ((double) (((float) imageDimensions.getWidth()) * f));
        this.mScaleY = ((double) i6) / ((double) (((float) this.mImageDimensions.getHeight()) * f));
        this.mPaddingLeft = i7;
        this.mPaddingTop = i8;
    }

    /* access modifiers changed from: protected */
    public List<Barcode> doInBackground(Void... voidArr) {
        RNBarcodeDetector rNBarcodeDetector;
        if (isCancelled() || this.mDelegate == null || (rNBarcodeDetector = this.mBarcodeDetector) == null || !rNBarcodeDetector.isOperational()) {
            return null;
        }
        return this.mBarcodeDetector.detect(RNFrameFactory.buildFrame(this.mImageData, this.mWidth, this.mHeight, this.mRotation));
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<Barcode> list) {
        super.onPostExecute(list);
        if (list == null) {
            this.mDelegate.onBarcodeDetectionError(this.mBarcodeDetector);
            return;
        }
        if (list.size() > 0) {
            this.mDelegate.onBarcodesDetected(serializeEventData(list), this.mWidth, this.mHeight, this.mImageData);
        }
        this.mDelegate.onBarcodeDetectingTaskCompleted();
    }

    private WritableArray serializeEventData(List<Barcode> list) {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < list.size(); i++) {
            Barcode barcode = list.get(i);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("data", barcode.getDisplayValue());
            createMap.putString("rawData", barcode.getRawValue());
            createMap.putString("type", BarcodeFormatUtils.get(barcode.getFormat()));
            createMap.putMap("bounds", processBounds(barcode.getBoundingBox()));
            createArray.pushMap(createMap);
        }
        return createArray;
    }

    private WritableMap processBounds(Rect rect) {
        WritableMap createMap = Arguments.createMap();
        int i = rect.left;
        int i2 = rect.top;
        if (rect.left < this.mWidth / 2) {
            i += this.mPaddingLeft / 2;
        } else if (rect.left > this.mWidth / 2) {
            i -= this.mPaddingLeft / 2;
        }
        if (rect.top < this.mHeight / 2) {
            i2 += this.mPaddingTop / 2;
        } else if (rect.top > this.mHeight / 2) {
            i2 -= this.mPaddingTop / 2;
        }
        createMap.putDouble("x", ((double) i) * this.mScaleX);
        createMap.putDouble("y", ((double) i2) * this.mScaleY);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("width", ((double) rect.width()) * this.mScaleX);
        createMap2.putDouble("height", ((double) rect.height()) * this.mScaleY);
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putMap("origin", createMap);
        createMap3.putMap("size", createMap2);
        return createMap3;
    }
}
