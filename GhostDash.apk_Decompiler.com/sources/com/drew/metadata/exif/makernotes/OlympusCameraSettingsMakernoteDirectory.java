package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusCameraSettingsMakernoteDirectory extends Directory {
    public static final int TagAeLock = 513;
    public static final int TagAfAreas = 772;
    public static final int TagAfFineTune = 774;
    public static final int TagAfFineTuneAdj = 775;
    public static final int TagAfPointSelected = 773;
    public static final int TagAfSearch = 771;
    public static final int TagArtFilter = 1321;
    public static final int TagArtFilterEffect = 1327;
    public static final int TagCameraSettingsVersion = 0;
    public static final int TagColorCreatorEffect = 1330;
    public static final int TagColorSpace = 1287;
    public static final int TagCompressionFactor = 1293;
    public static final int TagContrastSetting = 1285;
    public static final int TagCustomSaturation = 1283;
    public static final int TagDateTimeUtc = 2312;
    public static final int TagDistortionCorrection = 1291;
    public static final int TagDriveMode = 1536;
    public static final int TagExposureMode = 512;
    public static final int TagExposureShift = 515;
    public static final int TagExtendedWBDetect = 2306;
    public static final int TagFlashControlMode = 1028;
    public static final int TagFlashExposureComp = 1025;
    public static final int TagFlashIntensity = 1029;
    public static final int TagFlashMode = 1024;
    public static final int TagFlashRemoteControl = 1027;
    public static final int TagFocusMode = 769;
    public static final int TagFocusProcess = 770;
    public static final int TagGradation = 1295;
    public static final int TagImageQuality2 = 1539;
    public static final int TagImageStabilization = 1540;
    public static final int TagMacroMode = 768;
    public static final int TagMagicFilter = 1324;
    public static final int TagManometerPressure = 2304;
    public static final int TagManometerReading = 2305;
    public static final int TagManualFlashStrength = 1030;
    public static final int TagMeteringMode = 514;
    public static final int TagModifiedSaturation = 1284;
    public static final int TagNdFilter = 516;
    public static final int TagNoiseFilter = 1319;
    public static final int TagNoiseReduction = 1290;
    public static final int TagPanoramaMode = 1537;
    public static final int TagPictureMode = 1312;
    public static final int TagPictureModeBWFilter = 1317;
    public static final int TagPictureModeContrast = 1315;
    public static final int TagPictureModeEffect = 1325;
    public static final int TagPictureModeHue = 1314;
    public static final int TagPictureModeSaturation = 1313;
    public static final int TagPictureModeSharpness = 1316;
    public static final int TagPictureModeTone = 1318;
    public static final int TagPitchAngle = 2308;
    public static final int TagPreviewImageLength = 258;
    public static final int TagPreviewImageStart = 257;
    public static final int TagPreviewImageValid = 256;
    public static final int TagRollAngle = 2307;
    public static final int TagSceneMode = 1289;
    public static final int TagShadingCompensation = 1292;
    public static final int TagSharpnessSetting = 1286;
    public static final int TagStackedImage = 2052;
    public static final int TagToneLevel = 1326;
    public static final int TagWhiteBalance2 = 1280;
    public static final int TagWhiteBalanceBracket = 1282;
    public static final int TagWhiteBalanceTemperature = 1281;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Olympus Camera Settings";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Camera Settings Version");
        hashMap.put(256, "Preview Image Valid");
        hashMap.put(257, "Preview Image Start");
        hashMap.put(258, "Preview Image Length");
        hashMap.put(512, "Exposure Mode");
        hashMap.put(513, "AE Lock");
        hashMap.put(514, "Metering Mode");
        hashMap.put(515, "Exposure Shift");
        hashMap.put(516, "ND Filter");
        hashMap.put(768, "Macro Mode");
        hashMap.put(769, "Focus Mode");
        hashMap.put(770, "Focus Process");
        hashMap.put(771, "AF Search");
        hashMap.put(772, "AF Areas");
        hashMap.put(773, "AF Point Selected");
        hashMap.put(774, "AF Fine Tune");
        hashMap.put(Integer.valueOf(TagAfFineTuneAdj), "AF Fine Tune Adj");
        hashMap.put(1024, "Flash Mode");
        hashMap.put(1025, "Flash Exposure Comp");
        hashMap.put(1027, "Flash Remote Control");
        hashMap.put(1028, "Flash Control Mode");
        hashMap.put(1029, "Flash Intensity");
        hashMap.put(1030, "Manual Flash Strength");
        hashMap.put(Integer.valueOf(TagWhiteBalance2), "White Balance 2");
        hashMap.put(Integer.valueOf(TagWhiteBalanceTemperature), "White Balance Temperature");
        hashMap.put(Integer.valueOf(TagWhiteBalanceBracket), "White Balance Bracket");
        hashMap.put(Integer.valueOf(TagCustomSaturation), "Custom Saturation");
        hashMap.put(Integer.valueOf(TagModifiedSaturation), "Modified Saturation");
        hashMap.put(Integer.valueOf(TagContrastSetting), "Contrast Setting");
        hashMap.put(Integer.valueOf(TagSharpnessSetting), "Sharpness Setting");
        hashMap.put(Integer.valueOf(TagColorSpace), "Color Space");
        hashMap.put(Integer.valueOf(TagSceneMode), "Scene Mode");
        hashMap.put(Integer.valueOf(TagNoiseReduction), "Noise Reduction");
        hashMap.put(Integer.valueOf(TagDistortionCorrection), "Distortion Correction");
        hashMap.put(Integer.valueOf(TagShadingCompensation), "Shading Compensation");
        hashMap.put(Integer.valueOf(TagCompressionFactor), "Compression Factor");
        hashMap.put(Integer.valueOf(TagGradation), "Gradation");
        hashMap.put(Integer.valueOf(TagPictureMode), "Picture Mode");
        hashMap.put(Integer.valueOf(TagPictureModeSaturation), "Picture Mode Saturation");
        hashMap.put(Integer.valueOf(TagPictureModeHue), "Picture Mode Hue");
        hashMap.put(Integer.valueOf(TagPictureModeContrast), "Picture Mode Contrast");
        hashMap.put(Integer.valueOf(TagPictureModeSharpness), "Picture Mode Sharpness");
        hashMap.put(Integer.valueOf(TagPictureModeBWFilter), "Picture Mode BW Filter");
        hashMap.put(Integer.valueOf(TagPictureModeTone), "Picture Mode Tone");
        hashMap.put(Integer.valueOf(TagNoiseFilter), "Noise Filter");
        hashMap.put(Integer.valueOf(TagArtFilter), "Art Filter");
        hashMap.put(Integer.valueOf(TagMagicFilter), "Magic Filter");
        hashMap.put(Integer.valueOf(TagPictureModeEffect), "Picture Mode Effect");
        hashMap.put(Integer.valueOf(TagToneLevel), "Tone Level");
        hashMap.put(Integer.valueOf(TagArtFilterEffect), "Art Filter Effect");
        hashMap.put(Integer.valueOf(TagColorCreatorEffect), "Color Creator Effect");
        hashMap.put(1536, "Drive Mode");
        hashMap.put(1537, "Panorama Mode");
        hashMap.put(Integer.valueOf(TagImageQuality2), "Image Quality 2");
        hashMap.put(Integer.valueOf(TagImageStabilization), "Image Stabilization");
        hashMap.put(Integer.valueOf(TagStackedImage), "Stacked Image");
        hashMap.put(Integer.valueOf(TagManometerPressure), "Manometer Pressure");
        hashMap.put(Integer.valueOf(TagManometerReading), "Manometer Reading");
        hashMap.put(Integer.valueOf(TagExtendedWBDetect), "Extended WB Detect");
        hashMap.put(Integer.valueOf(TagRollAngle), "Roll Angle");
        hashMap.put(Integer.valueOf(TagPitchAngle), "Pitch Angle");
        hashMap.put(Integer.valueOf(TagDateTimeUtc), "Date Time UTC");
    }

    public OlympusCameraSettingsMakernoteDirectory() {
        setDescriptor(new OlympusCameraSettingsMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
