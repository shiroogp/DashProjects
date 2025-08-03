package org.reactnative.facedetector;

import android.content.Context;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.List;
import org.reactnative.camera.utils.ImageDimensions;
import org.reactnative.frame.RNFrame;

public class RNFaceDetector {
    public static int ACCURATE_MODE = 2;
    public static int ALL_CLASSIFICATIONS = 2;
    public static int ALL_LANDMARKS = 2;
    public static int FAST_MODE = 1;
    public static int NO_CLASSIFICATIONS = 1;
    public static int NO_LANDMARKS = 1;
    private FaceDetectorOptions.Builder mBuilder = null;
    private int mClassificationType = NO_CLASSIFICATIONS;
    private FaceDetector mFaceDetector = null;
    private int mLandmarkType = NO_LANDMARKS;
    private float mMinFaceSize = 0.15f;
    private int mMode = FAST_MODE;
    private ImageDimensions mPreviousDimensions;

    public RNFaceDetector(Context context) {
        FaceDetectorOptions.Builder builder = new FaceDetectorOptions.Builder();
        this.mBuilder = builder;
        builder.setMinFaceSize(this.mMinFaceSize);
        this.mBuilder.setPerformanceMode(this.mMode);
        this.mBuilder.setLandmarkMode(this.mLandmarkType);
        this.mBuilder.setClassificationMode(this.mClassificationType);
    }

    public boolean isOperational() {
        if (this.mFaceDetector != null) {
            return true;
        }
        createFaceDetector();
        return true;
    }

    public List<Face> detect(RNFrame rNFrame) {
        if (!rNFrame.getDimensions().equals(this.mPreviousDimensions)) {
            releaseFaceDetector();
        }
        if (this.mFaceDetector == null) {
            createFaceDetector();
            this.mPreviousDimensions = rNFrame.getDimensions();
        }
        return this.mFaceDetector.process(rNFrame.getFrame()).getResult();
    }

    public void setTracking(boolean z) {
        release();
        if (z) {
            this.mBuilder.enableTracking();
        }
    }

    public void setClassificationType(int i) {
        if (i != this.mClassificationType) {
            release();
            this.mBuilder.setClassificationMode(i);
            this.mClassificationType = i;
        }
    }

    public void setLandmarkType(int i) {
        if (i != this.mLandmarkType) {
            release();
            this.mBuilder.setLandmarkMode(i);
            this.mLandmarkType = i;
        }
    }

    public void setMode(int i) {
        if (i != this.mMode) {
            release();
            this.mBuilder.setPerformanceMode(i);
            this.mMode = i;
        }
    }

    public void release() {
        releaseFaceDetector();
        this.mPreviousDimensions = null;
    }

    private void releaseFaceDetector() {
        FaceDetector faceDetector = this.mFaceDetector;
        if (faceDetector != null) {
            faceDetector.close();
            this.mFaceDetector = null;
        }
    }

    private void createFaceDetector() {
        this.mFaceDetector = FaceDetection.getClient(this.mBuilder.build());
    }
}
