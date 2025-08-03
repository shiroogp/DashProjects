package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class FujifilmMakernoteDirectory extends Directory {
    public static final int TAG_AUTO_BRACKETING = 4352;
    public static final int TAG_AUTO_DYNAMIC_RANGE = 5131;
    public static final int TAG_AUTO_EXPOSURE_WARNING = 4866;
    public static final int TAG_BLUR_WARNING = 4864;
    public static final int TAG_COLOR_SATURATION = 4099;
    public static final int TAG_COLOR_TEMPERATURE = 4101;
    public static final int TAG_CONTRAST = 4102;
    public static final int TAG_DEVELOPMENT_DYNAMIC_RANGE = 5123;
    public static final int TAG_DYNAMIC_RANGE = 5120;
    public static final int TAG_DYNAMIC_RANGE_SETTING = 5122;
    public static final int TAG_EXR_AUTO = 4147;
    public static final int TAG_EXR_MODE = 4148;
    public static final int TAG_FACES_DETECTED = 16640;
    public static final int TAG_FACE_POSITIONS = 16643;
    public static final int TAG_FACE_REC_INFO = 17026;
    public static final int TAG_FILE_SOURCE = 32768;
    public static final int TAG_FILM_MODE = 5121;
    public static final int TAG_FINE_PIX_COLOR = 4624;
    public static final int TAG_FLASH_EV = 4113;
    public static final int TAG_FLASH_MODE = 4112;
    public static final int TAG_FOCUS_MODE = 4129;
    public static final int TAG_FOCUS_PIXEL = 4131;
    public static final int TAG_FOCUS_WARNING = 4865;
    public static final int TAG_FRAME_NUMBER = 32771;
    public static final int TAG_GE_IMAGE_SIZE = 4868;
    public static final int TAG_HIGH_ISO_NOISE_REDUCTION = 4110;
    public static final int TAG_MACRO = 4128;
    public static final int TAG_MAKERNOTE_VERSION = 0;
    public static final int TAG_MAX_APERTURE_AT_MAX_FOCAL = 5127;
    public static final int TAG_MAX_APERTURE_AT_MIN_FOCAL = 5126;
    public static final int TAG_MAX_FOCAL_LENGTH = 5125;
    public static final int TAG_MIN_FOCAL_LENGTH = 5124;
    public static final int TAG_NOISE_REDUCTION = 4107;
    public static final int TAG_ORDER_NUMBER = 32770;
    public static final int TAG_PARALLAX = 45585;
    public static final int TAG_PICTURE_MODE = 4145;
    public static final int TAG_QUALITY = 4096;
    public static final int TAG_SEQUENCE_NUMBER = 4353;
    public static final int TAG_SERIAL_NUMBER = 16;
    public static final int TAG_SHARPNESS = 4097;
    public static final int TAG_SLOW_SYNC = 4144;
    public static final int TAG_TONE = 4100;
    public static final int TAG_WHITE_BALANCE = 4098;
    public static final int TAG_WHITE_BALANCE_FINE_TUNE = 4106;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Fujifilm Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Makernote Version");
        hashMap.put(16, "Serial Number");
        hashMap.put(4096, "Quality");
        hashMap.put(4097, ExifInterface.TAG_SHARPNESS);
        hashMap.put(4098, "White Balance");
        hashMap.put(4099, "Color Saturation");
        hashMap.put(4100, "Tone (Contrast)");
        hashMap.put(4101, "Color Temperature");
        hashMap.put(4102, ExifInterface.TAG_CONTRAST);
        hashMap.put(4106, "White Balance Fine Tune");
        hashMap.put(4107, "Noise Reduction");
        hashMap.put(4110, "High ISO Noise Reduction");
        hashMap.put(4112, "Flash Mode");
        hashMap.put(4113, "Flash Strength");
        hashMap.put(4128, "Macro");
        hashMap.put(4129, "Focus Mode");
        hashMap.put(4131, "Focus Pixel");
        hashMap.put(4144, "Slow Sync");
        hashMap.put(4145, "Picture Mode");
        hashMap.put(4147, "EXR Auto");
        hashMap.put(4148, "EXR Mode");
        hashMap.put(Integer.valueOf(TAG_AUTO_BRACKETING), "Auto Bracketing");
        hashMap.put(Integer.valueOf(TAG_SEQUENCE_NUMBER), "Sequence Number");
        hashMap.put(Integer.valueOf(TAG_FINE_PIX_COLOR), "FinePix Color Setting");
        hashMap.put(Integer.valueOf(TAG_BLUR_WARNING), "Blur Warning");
        hashMap.put(Integer.valueOf(TAG_FOCUS_WARNING), "Focus Warning");
        hashMap.put(Integer.valueOf(TAG_AUTO_EXPOSURE_WARNING), "AE Warning");
        hashMap.put(Integer.valueOf(TAG_GE_IMAGE_SIZE), "GE Image Size");
        hashMap.put(Integer.valueOf(TAG_DYNAMIC_RANGE), "Dynamic Range");
        hashMap.put(Integer.valueOf(TAG_FILM_MODE), "Film Mode");
        hashMap.put(Integer.valueOf(TAG_DYNAMIC_RANGE_SETTING), "Dynamic Range Setting");
        hashMap.put(Integer.valueOf(TAG_DEVELOPMENT_DYNAMIC_RANGE), "Development Dynamic Range");
        hashMap.put(Integer.valueOf(TAG_MIN_FOCAL_LENGTH), "Minimum Focal Length");
        hashMap.put(Integer.valueOf(TAG_MAX_FOCAL_LENGTH), "Maximum Focal Length");
        hashMap.put(Integer.valueOf(TAG_MAX_APERTURE_AT_MIN_FOCAL), "Maximum Aperture at Minimum Focal Length");
        hashMap.put(Integer.valueOf(TAG_MAX_APERTURE_AT_MAX_FOCAL), "Maximum Aperture at Maximum Focal Length");
        hashMap.put(Integer.valueOf(TAG_AUTO_DYNAMIC_RANGE), "Auto Dynamic Range");
        hashMap.put(Integer.valueOf(TAG_FACES_DETECTED), "Faces Detected");
        hashMap.put(Integer.valueOf(TAG_FACE_POSITIONS), "Face Positions");
        hashMap.put(17026, "Face Detection Data");
        hashMap.put(32768, "File Source");
        hashMap.put(Integer.valueOf(TAG_ORDER_NUMBER), "Order Number");
        hashMap.put(Integer.valueOf(TAG_FRAME_NUMBER), "Frame Number");
        hashMap.put(Integer.valueOf(TAG_PARALLAX), "Parallax");
    }

    public FujifilmMakernoteDirectory() {
        setDescriptor(new FujifilmMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
