package org.reactnative.facedetector;

import android.graphics.PointF;
import android.graphics.Rect;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceLandmark;

public class FaceDetectorUtils {
    private static final String[] landmarkNames = {"bottomMouthPosition", "leftCheekPosition", "leftEarPosition", "leftEarTipPosition", "leftEyePosition", "leftMouthPosition", "noseBasePosition", "rightCheekPosition", "rightEarPosition", "rightEarTipPosition", "rightEyePosition", "rightMouthPosition"};

    public static double valueMirroredHorizontally(double d, int i, double d2) {
        return (((double) i) - (d / d2)) * d2;
    }

    public static WritableMap serializeFace(Face face) {
        return serializeFace(face, 1.0d, 1.0d, 0, 0, 0, 0);
    }

    public static WritableMap serializeFace(Face face, double d, double d2, int i, int i2, int i3, int i4) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("faceID", face.getTrackingId().intValue());
        createMap.putDouble("rollAngle", (double) face.getHeadEulerAngleZ());
        createMap.putDouble("yawAngle", (double) face.getHeadEulerAngleY());
        if (face.getSmilingProbability().floatValue() >= 0.0f) {
            createMap.putDouble("smilingProbability", (double) face.getSmilingProbability().floatValue());
        }
        if (face.getLeftEyeOpenProbability().floatValue() >= 0.0f) {
            createMap.putDouble("leftEyeOpenProbability", (double) face.getLeftEyeOpenProbability().floatValue());
        }
        if (face.getRightEyeOpenProbability().floatValue() >= 0.0f) {
            createMap.putDouble("rightEyeOpenProbability", (double) face.getRightEyeOpenProbability().floatValue());
        }
        for (FaceLandmark next : face.getAllLandmarks()) {
            createMap.putMap(landmarkNames[next.getLandmarkType()], mapFromPoint(next.getPosition(), d, d2, i, i2, i3, i4));
        }
        WritableMap createMap2 = Arguments.createMap();
        Rect boundingBox = face.getBoundingBox();
        int i5 = boundingBox.left;
        int i6 = boundingBox.top;
        int i7 = i / 2;
        if (i5 < i7) {
            i5 += i3 / 2;
        } else if (i5 > i7) {
            i5 -= i3 / 2;
        }
        int i8 = i2 / 2;
        if (i6 < i8) {
            i6 += i4 / 2;
        } else if (i6 > i8) {
            i6 -= i4 / 2;
        }
        createMap2.putDouble("x", ((double) i5) * d);
        createMap2.putDouble("y", ((double) i6) * d2);
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble("width", ((double) boundingBox.width()) * d);
        createMap3.putDouble("height", ((double) boundingBox.height()) * d2);
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putMap("origin", createMap2);
        createMap4.putMap("size", createMap3);
        createMap.putMap("bounds", createMap4);
        return createMap;
    }

    public static WritableMap rotateFaceX(WritableMap writableMap, int i, double d) {
        ReadableMap map = writableMap.getMap("bounds");
        WritableMap positionTranslatedHorizontally = positionTranslatedHorizontally(positionMirroredHorizontally(map.getMap("origin"), i, d), -map.getMap("size").getDouble("width"));
        WritableMap createMap = Arguments.createMap();
        createMap.merge(map);
        createMap.putMap("origin", positionTranslatedHorizontally);
        for (String str : landmarkNames) {
            ReadableMap map2 = writableMap.hasKey(str) ? writableMap.getMap(str) : null;
            if (map2 != null) {
                writableMap.putMap(str, positionMirroredHorizontally(map2, i, d));
            }
        }
        writableMap.putMap("bounds", createMap);
        return writableMap;
    }

    public static WritableMap changeAnglesDirection(WritableMap writableMap) {
        writableMap.putDouble("rollAngle", ((-writableMap.getDouble("rollAngle")) + 360.0d) % 360.0d);
        writableMap.putDouble("yawAngle", ((-writableMap.getDouble("yawAngle")) + 360.0d) % 360.0d);
        return writableMap;
    }

    public static WritableMap mapFromPoint(PointF pointF, double d, double d2, int i, int i2, int i3, int i4) {
        WritableMap createMap = Arguments.createMap();
        Float valueOf = Float.valueOf(pointF.x);
        Float valueOf2 = Float.valueOf(pointF.y);
        float f = (float) (i / 2);
        if (pointF.x < f) {
            Float.valueOf(valueOf.floatValue() + ((float) (i3 / 2)));
        } else if (pointF.x > f) {
            Float.valueOf(valueOf.floatValue() - ((float) (i3 / 2)));
        }
        float f2 = (float) (i2 / 2);
        if (pointF.y < f2) {
            Float.valueOf(valueOf2.floatValue() + ((float) (i4 / 2)));
        } else if (pointF.y > f2) {
            Float.valueOf(valueOf2.floatValue() - ((float) (i4 / 2)));
        }
        createMap.putDouble("x", ((double) pointF.x) * d);
        createMap.putDouble("y", ((double) pointF.y) * d2);
        return createMap;
    }

    public static WritableMap positionTranslatedHorizontally(ReadableMap readableMap, double d) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        createMap.putDouble("x", readableMap.getDouble("x") + d);
        return createMap;
    }

    public static WritableMap positionMirroredHorizontally(ReadableMap readableMap, int i, double d) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        createMap.putDouble("x", valueMirroredHorizontally(readableMap.getDouble("x"), i, d));
        return createMap;
    }
}
