package org.reactnative.camera.tasks;

import android.os.AsyncTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.mlkit.vision.face.Face;
import java.util.List;
import org.reactnative.camera.utils.ImageDimensions;
import org.reactnative.facedetector.FaceDetectorUtils;
import org.reactnative.facedetector.RNFaceDetector;
import org.reactnative.frame.RNFrameFactory;

public class FaceDetectorAsyncTask extends AsyncTask<Void, Void, List<Face>> {
    private FaceDetectorAsyncTaskDelegate mDelegate;
    private RNFaceDetector mFaceDetector;
    private int mHeight;
    private byte[] mImageData;
    private ImageDimensions mImageDimensions;
    private int mPaddingLeft;
    private int mPaddingTop;
    private int mRotation;
    private double mScaleX;
    private double mScaleY;
    private int mWidth;

    public FaceDetectorAsyncTask(FaceDetectorAsyncTaskDelegate faceDetectorAsyncTaskDelegate, RNFaceDetector rNFaceDetector, byte[] bArr, int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, int i8) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotation = i3;
        this.mDelegate = faceDetectorAsyncTaskDelegate;
        this.mFaceDetector = rNFaceDetector;
        ImageDimensions imageDimensions = new ImageDimensions(i, i2, i3, i4);
        this.mImageDimensions = imageDimensions;
        this.mScaleX = ((double) i5) / ((double) (((float) imageDimensions.getWidth()) * f));
        this.mScaleY = ((double) i6) / ((double) (((float) this.mImageDimensions.getHeight()) * f));
        this.mPaddingLeft = i7;
        this.mPaddingTop = i8;
    }

    /* access modifiers changed from: protected */
    public List<Face> doInBackground(Void... voidArr) {
        RNFaceDetector rNFaceDetector;
        if (isCancelled() || this.mDelegate == null || (rNFaceDetector = this.mFaceDetector) == null || !rNFaceDetector.isOperational()) {
            return null;
        }
        return this.mFaceDetector.detect(RNFrameFactory.buildFrame(this.mImageData, this.mWidth, this.mHeight, this.mRotation));
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<Face> list) {
        super.onPostExecute(list);
        if (list == null) {
            this.mDelegate.onFaceDetectionError(this.mFaceDetector);
            return;
        }
        if (list.size() > 0) {
            this.mDelegate.onFacesDetected(serializeEventData(list));
        }
        this.mDelegate.onFaceDetectingTaskCompleted();
    }

    private WritableArray serializeEventData(List<Face> list) {
        WritableMap writableMap;
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < list.size(); i++) {
            WritableMap serializeFace = FaceDetectorUtils.serializeFace(list.get(i), this.mScaleX, this.mScaleY, this.mWidth, this.mHeight, this.mPaddingLeft, this.mPaddingTop);
            if (this.mImageDimensions.getFacing() == 1) {
                writableMap = FaceDetectorUtils.rotateFaceX(serializeFace, this.mImageDimensions.getWidth(), this.mScaleX);
            } else {
                writableMap = FaceDetectorUtils.changeAnglesDirection(serializeFace);
            }
            createArray.pushMap(writableMap);
        }
        return createArray;
    }
}
