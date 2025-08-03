package org.reactnative.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.CamcorderProfile;
import android.os.Build;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.zxing.Result;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.events.BarCodeReadEvent;
import org.reactnative.camera.events.BarcodeDetectionErrorEvent;
import org.reactnative.camera.events.BarcodesDetectedEvent;
import org.reactnative.camera.events.CameraMountErrorEvent;
import org.reactnative.camera.events.CameraReadyEvent;
import org.reactnative.camera.events.FaceDetectionErrorEvent;
import org.reactnative.camera.events.FacesDetectedEvent;
import org.reactnative.camera.events.PictureSavedEvent;
import org.reactnative.camera.events.PictureTakenEvent;
import org.reactnative.camera.events.RecordingEndEvent;
import org.reactnative.camera.events.RecordingStartEvent;
import org.reactnative.camera.events.TextRecognizedEvent;
import org.reactnative.camera.events.TouchEvent;
import org.reactnative.facedetector.RNFaceDetector;

public class RNCameraViewHelper {
    public static final String[][] exifTags = {new String[]{"string", ExifInterface.TAG_ARTIST}, new String[]{"int", ExifInterface.TAG_BITS_PER_SAMPLE}, new String[]{"int", ExifInterface.TAG_COMPRESSION}, new String[]{"string", ExifInterface.TAG_COPYRIGHT}, new String[]{"string", ExifInterface.TAG_DATETIME}, new String[]{"string", ExifInterface.TAG_IMAGE_DESCRIPTION}, new String[]{"int", ExifInterface.TAG_IMAGE_LENGTH}, new String[]{"int", ExifInterface.TAG_IMAGE_WIDTH}, new String[]{"int", ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT}, new String[]{"int", ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH}, new String[]{"string", ExifInterface.TAG_MAKE}, new String[]{"string", ExifInterface.TAG_MODEL}, new String[]{"int", ExifInterface.TAG_ORIENTATION}, new String[]{"int", ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION}, new String[]{"int", ExifInterface.TAG_PLANAR_CONFIGURATION}, new String[]{"double", ExifInterface.TAG_PRIMARY_CHROMATICITIES}, new String[]{"double", ExifInterface.TAG_REFERENCE_BLACK_WHITE}, new String[]{"int", ExifInterface.TAG_RESOLUTION_UNIT}, new String[]{"int", ExifInterface.TAG_ROWS_PER_STRIP}, new String[]{"int", ExifInterface.TAG_SAMPLES_PER_PIXEL}, new String[]{"string", ExifInterface.TAG_SOFTWARE}, new String[]{"int", ExifInterface.TAG_STRIP_BYTE_COUNTS}, new String[]{"int", ExifInterface.TAG_STRIP_OFFSETS}, new String[]{"int", ExifInterface.TAG_TRANSFER_FUNCTION}, new String[]{"double", ExifInterface.TAG_WHITE_POINT}, new String[]{"double", ExifInterface.TAG_X_RESOLUTION}, new String[]{"double", ExifInterface.TAG_Y_CB_CR_COEFFICIENTS}, new String[]{"int", ExifInterface.TAG_Y_CB_CR_POSITIONING}, new String[]{"int", ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING}, new String[]{"double", ExifInterface.TAG_Y_RESOLUTION}, new String[]{"double", ExifInterface.TAG_APERTURE_VALUE}, new String[]{"double", ExifInterface.TAG_BRIGHTNESS_VALUE}, new String[]{"string", ExifInterface.TAG_CFA_PATTERN}, new String[]{"int", ExifInterface.TAG_COLOR_SPACE}, new String[]{"string", ExifInterface.TAG_COMPONENTS_CONFIGURATION}, new String[]{"double", ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL}, new String[]{"int", ExifInterface.TAG_CONTRAST}, new String[]{"int", ExifInterface.TAG_CUSTOM_RENDERED}, new String[]{"string", ExifInterface.TAG_DATETIME_DIGITIZED}, new String[]{"string", ExifInterface.TAG_DATETIME_ORIGINAL}, new String[]{"string", ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION}, new String[]{"double", ExifInterface.TAG_DIGITAL_ZOOM_RATIO}, new String[]{"string", ExifInterface.TAG_EXIF_VERSION}, new String[]{"double", ExifInterface.TAG_EXPOSURE_BIAS_VALUE}, new String[]{"double", ExifInterface.TAG_EXPOSURE_INDEX}, new String[]{"int", ExifInterface.TAG_EXPOSURE_MODE}, new String[]{"int", ExifInterface.TAG_EXPOSURE_PROGRAM}, new String[]{"double", ExifInterface.TAG_EXPOSURE_TIME}, new String[]{"double", ExifInterface.TAG_F_NUMBER}, new String[]{"string", ExifInterface.TAG_FILE_SOURCE}, new String[]{"int", ExifInterface.TAG_FLASH}, new String[]{"double", ExifInterface.TAG_FLASH_ENERGY}, new String[]{"string", ExifInterface.TAG_FLASHPIX_VERSION}, new String[]{"double", ExifInterface.TAG_FOCAL_LENGTH}, new String[]{"int", ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM}, new String[]{"int", ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT}, new String[]{"double", ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION}, new String[]{"double", ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION}, new String[]{"int", ExifInterface.TAG_GAIN_CONTROL}, new String[]{"int", ExifInterface.TAG_ISO_SPEED_RATINGS}, new String[]{"string", ExifInterface.TAG_IMAGE_UNIQUE_ID}, new String[]{"int", ExifInterface.TAG_LIGHT_SOURCE}, new String[]{"string", ExifInterface.TAG_MAKER_NOTE}, new String[]{"double", ExifInterface.TAG_MAX_APERTURE_VALUE}, new String[]{"int", ExifInterface.TAG_METERING_MODE}, new String[]{"int", ExifInterface.TAG_NEW_SUBFILE_TYPE}, new String[]{"string", ExifInterface.TAG_OECF}, new String[]{"int", ExifInterface.TAG_PIXEL_X_DIMENSION}, new String[]{"int", ExifInterface.TAG_PIXEL_Y_DIMENSION}, new String[]{"string", ExifInterface.TAG_RELATED_SOUND_FILE}, new String[]{"int", ExifInterface.TAG_SATURATION}, new String[]{"int", ExifInterface.TAG_SCENE_CAPTURE_TYPE}, new String[]{"string", ExifInterface.TAG_SCENE_TYPE}, new String[]{"int", ExifInterface.TAG_SENSING_METHOD}, new String[]{"int", ExifInterface.TAG_SHARPNESS}, new String[]{"double", ExifInterface.TAG_SHUTTER_SPEED_VALUE}, new String[]{"string", ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE}, new String[]{"string", ExifInterface.TAG_SPECTRAL_SENSITIVITY}, new String[]{"int", ExifInterface.TAG_SUBFILE_TYPE}, new String[]{"string", ExifInterface.TAG_SUBSEC_TIME}, new String[]{"string", ExifInterface.TAG_SUBSEC_TIME_DIGITIZED}, new String[]{"string", ExifInterface.TAG_SUBSEC_TIME_ORIGINAL}, new String[]{"int", ExifInterface.TAG_SUBJECT_AREA}, new String[]{"double", ExifInterface.TAG_SUBJECT_DISTANCE}, new String[]{"int", ExifInterface.TAG_SUBJECT_DISTANCE_RANGE}, new String[]{"int", ExifInterface.TAG_SUBJECT_LOCATION}, new String[]{"string", ExifInterface.TAG_USER_COMMENT}, new String[]{"int", ExifInterface.TAG_WHITE_BALANCE}, new String[]{"int", ExifInterface.TAG_GPS_ALTITUDE_REF}, new String[]{"string", ExifInterface.TAG_GPS_AREA_INFORMATION}, new String[]{"double", ExifInterface.TAG_GPS_DOP}, new String[]{"string", ExifInterface.TAG_GPS_DATESTAMP}, new String[]{"double", ExifInterface.TAG_GPS_DEST_BEARING}, new String[]{"string", ExifInterface.TAG_GPS_DEST_BEARING_REF}, new String[]{"double", ExifInterface.TAG_GPS_DEST_DISTANCE}, new String[]{"string", ExifInterface.TAG_GPS_DEST_DISTANCE_REF}, new String[]{"double", ExifInterface.TAG_GPS_DEST_LATITUDE}, new String[]{"string", ExifInterface.TAG_GPS_DEST_LATITUDE_REF}, new String[]{"double", ExifInterface.TAG_GPS_DEST_LONGITUDE}, new String[]{"string", ExifInterface.TAG_GPS_DEST_LONGITUDE_REF}, new String[]{"int", ExifInterface.TAG_GPS_DIFFERENTIAL}, new String[]{"double", ExifInterface.TAG_GPS_IMG_DIRECTION}, new String[]{"string", ExifInterface.TAG_GPS_IMG_DIRECTION_REF}, new String[]{"string", ExifInterface.TAG_GPS_LATITUDE_REF}, new String[]{"string", ExifInterface.TAG_GPS_LONGITUDE_REF}, new String[]{"string", ExifInterface.TAG_GPS_MAP_DATUM}, new String[]{"string", ExifInterface.TAG_GPS_MEASURE_MODE}, new String[]{"string", ExifInterface.TAG_GPS_PROCESSING_METHOD}, new String[]{"string", ExifInterface.TAG_GPS_SATELLITES}, new String[]{"double", ExifInterface.TAG_GPS_SPEED}, new String[]{"string", ExifInterface.TAG_GPS_SPEED_REF}, new String[]{"string", ExifInterface.TAG_GPS_STATUS}, new String[]{"string", ExifInterface.TAG_GPS_TIMESTAMP}, new String[]{"double", ExifInterface.TAG_GPS_TRACK}, new String[]{"string", ExifInterface.TAG_GPS_TRACK_REF}, new String[]{"string", ExifInterface.TAG_GPS_VERSION_ID}, new String[]{"string", ExifInterface.TAG_INTEROPERABILITY_INDEX}, new String[]{"int", ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH}, new String[]{"int", ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH}, new String[]{"int", ExifInterface.TAG_DNG_VERSION}, new String[]{"int", ExifInterface.TAG_DEFAULT_CROP_SIZE}, new String[]{"int", ExifInterface.TAG_ORF_PREVIEW_IMAGE_START}, new String[]{"int", ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH}, new String[]{"int", ExifInterface.TAG_ORF_ASPECT_FRAME}, new String[]{"int", ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER}, new String[]{"int", ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER}, new String[]{"int", ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER}, new String[]{"int", ExifInterface.TAG_RW2_SENSOR_TOP_BORDER}, new String[]{"int", ExifInterface.TAG_RW2_ISO}};

    private static boolean rotationIsLandscape(int i) {
        return i == 90 || i == 270;
    }

    public static void emitMountErrorEvent(final ViewGroup viewGroup, final String str) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(CameraMountErrorEvent.obtain(viewGroup.getId(), str));
            }
        });
    }

    public static void emitCameraReadyEvent(final ViewGroup viewGroup) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(CameraReadyEvent.obtain(viewGroup.getId()));
            }
        });
    }

    public static void emitPictureSavedEvent(final ViewGroup viewGroup, final WritableMap writableMap) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(PictureSavedEvent.obtain(viewGroup.getId(), writableMap));
            }
        });
    }

    public static void emitPictureTakenEvent(final ViewGroup viewGroup) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(PictureTakenEvent.obtain(viewGroup.getId()));
            }
        });
    }

    public static void emitRecordingStartEvent(final ViewGroup viewGroup, final WritableMap writableMap) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(RecordingStartEvent.obtain(viewGroup.getId(), writableMap));
            }
        });
    }

    public static void emitRecordingEndEvent(final ViewGroup viewGroup) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(RecordingEndEvent.obtain(viewGroup.getId()));
            }
        });
    }

    public static void emitTouchEvent(ViewGroup viewGroup, boolean z, int i, int i2) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        final ViewGroup viewGroup2 = viewGroup;
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final ReactContext reactContext2 = reactContext;
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext2.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(TouchEvent.obtain(viewGroup2.getId(), z2, i3, i4));
            }
        });
    }

    public static void emitFacesDetectedEvent(final ViewGroup viewGroup, final WritableArray writableArray) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(FacesDetectedEvent.obtain(viewGroup.getId(), writableArray));
            }
        });
    }

    public static void emitFaceDetectionErrorEvent(final ViewGroup viewGroup, final RNFaceDetector rNFaceDetector) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(FaceDetectionErrorEvent.obtain(viewGroup.getId(), rNFaceDetector));
            }
        });
    }

    public static void emitBarcodesDetectedEvent(final ViewGroup viewGroup, final WritableArray writableArray, final byte[] bArr) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(BarcodesDetectedEvent.obtain(viewGroup.getId(), writableArray, bArr));
            }
        });
    }

    public static void emitBarcodeDetectionErrorEvent(final ViewGroup viewGroup, final RNBarcodeDetector rNBarcodeDetector) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(BarcodeDetectionErrorEvent.obtain(viewGroup.getId(), rNBarcodeDetector));
            }
        });
    }

    public static void emitBarCodeReadEvent(ViewGroup viewGroup, Result result, int i, int i2, byte[] bArr) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        final ViewGroup viewGroup2 = viewGroup;
        final Result result2 = result;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        final ReactContext reactContext2 = reactContext;
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext2.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(BarCodeReadEvent.obtain(viewGroup2.getId(), result2, i3, i4, bArr2));
            }
        });
    }

    public static void emitTextRecognizedEvent(final ViewGroup viewGroup, final WritableArray writableArray) {
        final ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(TextRecognizedEvent.obtain(viewGroup.getId(), writableArray));
            }
        });
    }

    public static int getCorrectCameraRotation(int i, int i2, int i3) {
        if (i2 == 1) {
            return (i3 + i) % 360;
        }
        return ((i3 - i) + (rotationIsLandscape(i) ? 180 : 0)) % 360;
    }

    private static int getCamcorderProfileQualityFromCameraModuleConstant(int i) {
        if (i == 0) {
            return Build.VERSION.SDK_INT >= 21 ? 8 : 6;
        }
        if (i == 1) {
            return 6;
        }
        if (i != 2) {
            return (i == 3 || i == 4) ? 4 : 1;
        }
        return 5;
    }

    public static CamcorderProfile getCamcorderProfile(int i) {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        int camcorderProfileQualityFromCameraModuleConstant = getCamcorderProfileQualityFromCameraModuleConstant(i);
        if (CamcorderProfile.hasProfile(camcorderProfileQualityFromCameraModuleConstant)) {
            camcorderProfile = CamcorderProfile.get(camcorderProfileQualityFromCameraModuleConstant);
            if (i == 4) {
                camcorderProfile.videoFrameWidth = OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE;
            }
        }
        return camcorderProfile;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r8.equals("string") == false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.react.bridge.WritableMap getExifData(androidx.exifinterface.media.ExifInterface r12) {
        /*
            com.facebook.react.bridge.WritableMap r0 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String[][] r1 = exifTags
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L_0x0009:
            r5 = 0
            r7 = 1
            if (r4 >= r2) goto L_0x0063
            r8 = r1[r4]
            r9 = r8[r7]
            java.lang.String r10 = r12.getAttribute(r9)
            if (r10 == 0) goto L_0x0060
            r8 = r8[r3]
            r8.hashCode()
            r10 = -1
            int r11 = r8.hashCode()
            switch(r11) {
                case -1325958191: goto L_0x003b;
                case -891985903: goto L_0x0032;
                case 104431: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            r7 = r10
            goto L_0x0045
        L_0x0027:
            java.lang.String r7 = "int"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x0030
            goto L_0x0025
        L_0x0030:
            r7 = 2
            goto L_0x0045
        L_0x0032:
            java.lang.String r11 = "string"
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L_0x0045
            goto L_0x0025
        L_0x003b:
            java.lang.String r7 = "double"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x0044
            goto L_0x0025
        L_0x0044:
            r7 = r3
        L_0x0045:
            switch(r7) {
                case 0: goto L_0x0059;
                case 1: goto L_0x0051;
                case 2: goto L_0x0049;
                default: goto L_0x0048;
            }
        L_0x0048:
            goto L_0x0060
        L_0x0049:
            int r5 = r12.getAttributeInt(r9, r3)
            r0.putInt(r9, r5)
            goto L_0x0060
        L_0x0051:
            java.lang.String r5 = r12.getAttribute(r9)
            r0.putString(r9, r5)
            goto L_0x0060
        L_0x0059:
            double r5 = r12.getAttributeDouble(r9, r5)
            r0.putDouble(r9, r5)
        L_0x0060:
            int r4 = r4 + 1
            goto L_0x0009
        L_0x0063:
            double[] r1 = r12.getLatLong()
            if (r1 == 0) goto L_0x0080
            r2 = r1[r3]
            java.lang.String r4 = "GPSLatitude"
            r0.putDouble(r4, r2)
            r2 = r1[r7]
            java.lang.String r1 = "GPSLongitude"
            r0.putDouble(r1, r2)
            double r1 = r12.getAltitude(r5)
            java.lang.String r12 = "GPSAltitude"
            r0.putDouble(r12, r1)
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.RNCameraViewHelper.getExifData(androidx.exifinterface.media.ExifInterface):com.facebook.react.bridge.WritableMap");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r4.equals("string") == false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setExifData(androidx.exifinterface.media.ExifInterface r9, com.facebook.react.bridge.ReadableMap r10) {
        /*
            java.lang.String[][] r0 = exifTags
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x0005:
            if (r3 >= r1) goto L_0x006b
            r4 = r0[r3]
            r5 = 1
            r6 = r4[r5]
            boolean r7 = r10.hasKey(r6)
            if (r7 == 0) goto L_0x0068
            r4 = r4[r2]
            r4.hashCode()
            r7 = -1
            int r8 = r4.hashCode()
            switch(r8) {
                case -1325958191: goto L_0x0035;
                case -891985903: goto L_0x002c;
                case 104431: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            r5 = r7
            goto L_0x003f
        L_0x0021:
            java.lang.String r5 = "int"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x002a
            goto L_0x001f
        L_0x002a:
            r5 = 2
            goto L_0x003f
        L_0x002c:
            java.lang.String r8 = "string"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x003f
            goto L_0x001f
        L_0x0035:
            java.lang.String r5 = "double"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x003e
            goto L_0x001f
        L_0x003e:
            r5 = r2
        L_0x003f:
            switch(r5) {
                case 0: goto L_0x005a;
                case 1: goto L_0x0052;
                case 2: goto L_0x0043;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x0068
        L_0x0043:
            int r4 = r10.getInt(r6)
            java.lang.String r4 = java.lang.Integer.toString(r4)
            r9.setAttribute(r6, r4)
            r10.getInt(r6)
            goto L_0x0068
        L_0x0052:
            java.lang.String r4 = r10.getString(r6)
            r9.setAttribute(r6, r4)
            goto L_0x0068
        L_0x005a:
            double r4 = r10.getDouble(r6)
            java.lang.String r4 = java.lang.Double.toString(r4)
            r9.setAttribute(r6, r4)
            r10.getDouble(r6)
        L_0x0068:
            int r3 = r3 + 1
            goto L_0x0005
        L_0x006b:
            java.lang.String r0 = "GPSLatitude"
            boolean r1 = r10.hasKey(r0)
            if (r1 == 0) goto L_0x0086
            java.lang.String r1 = "GPSLongitude"
            boolean r2 = r10.hasKey(r1)
            if (r2 == 0) goto L_0x0086
            double r2 = r10.getDouble(r0)
            double r0 = r10.getDouble(r1)
            r9.setLatLong(r2, r0)
        L_0x0086:
            java.lang.String r0 = "GPSAltitude"
            boolean r1 = r10.hasKey(r0)
            if (r1 == 0) goto L_0x0095
            double r0 = r10.getDouble(r0)
            r9.setAltitude(r0)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.RNCameraViewHelper.setExifData(androidx.exifinterface.media.ExifInterface, com.facebook.react.bridge.ReadableMap):void");
    }

    public static void clearExifData(ExifInterface exifInterface) {
        for (String[] strArr : exifTags) {
            exifInterface.setAttribute(strArr[1], (String) null);
        }
        exifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE, (String) null);
        exifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, (String) null);
        exifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE, (String) null);
    }

    public static Bitmap generateSimulatorPhoto(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        float f = (float) i;
        float f2 = (float) i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(InputDeviceCompat.SOURCE_ANY);
        paint2.setTextSize(35.0f);
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G '->' HH:mm:ss z");
        canvas.drawText(simpleDateFormat.format(instance.getTime()), 0.1f * f, f2 * 0.2f, paint2);
        canvas.drawText(simpleDateFormat.format(instance.getTime()), 0.2f * f, f2 * 0.4f, paint2);
        canvas.drawText(simpleDateFormat.format(instance.getTime()), 0.3f * f, 0.6f * f2, paint2);
        canvas.drawText(simpleDateFormat.format(instance.getTime()), f * 0.4f, f2 * 0.8f, paint2);
        return createBitmap;
    }
}
