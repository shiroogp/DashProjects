package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.adobe.xmp.XMPError;
import com.drew.metadata.TagDescriptor;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import java.text.DecimalFormat;
import java.util.HashMap;
import org.spongycastle.asn1.eac.CertificateBody;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;

public class CanonMakernoteDescriptor extends TagDescriptor<CanonMakernoteDirectory> {
    private static final HashMap<Integer, String> _lensTypeById;

    private double decodeCanonEv(int i) {
        int i2;
        if (i < 0) {
            i = -i;
            i2 = -1;
        } else {
            i2 = 1;
        }
        int i3 = i & 31;
        int i4 = i - i3;
        if (i3 == 12) {
            i3 = 10;
        } else if (i3 == 20) {
            i3 = 21;
        }
        return ((double) (i2 * (i4 + i3))) / 32.0d;
    }

    public CanonMakernoteDescriptor(CanonMakernoteDirectory canonMakernoteDirectory) {
        super(canonMakernoteDirectory);
    }

    public String getDescription(int i) {
        switch (i) {
            case 12:
                return getSerialNumberDescription();
            case CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_MODE_1:
                return getFocusMode1Description();
            case CanonMakernoteDirectory.CameraSettings.TAG_COLOR_TONE:
                return getColorToneDescription();
            case CanonMakernoteDirectory.CameraSettings.TAG_SRAW_QUALITY:
                return getSRawQualityDescription();
            case CanonMakernoteDirectory.FocalLength.TAG_WHITE_BALANCE:
                return getWhiteBalanceDescription();
            case CanonMakernoteDirectory.AFInfo.TAG_AF_POINTS_IN_FOCUS:
                return getTagAfPointsInFocus();
            default:
                switch (i) {
                    case CanonMakernoteDirectory.CameraSettings.TAG_MACRO_MODE:
                        return getMacroModeDescription();
                    case CanonMakernoteDirectory.CameraSettings.TAG_SELF_TIMER_DELAY:
                        return getSelfTimerDelayDescription();
                    case CanonMakernoteDirectory.CameraSettings.TAG_QUALITY:
                        return getQualityDescription();
                    case CanonMakernoteDirectory.CameraSettings.TAG_FLASH_MODE:
                        return getFlashModeDescription();
                    case CanonMakernoteDirectory.CameraSettings.TAG_CONTINUOUS_DRIVE_MODE:
                        return getContinuousDriveModeDescription();
                    default:
                        switch (i) {
                            case CanonMakernoteDirectory.CameraSettings.TAG_RECORD_MODE:
                                return getRecordModeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_IMAGE_SIZE:
                                return getImageSizeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_EASY_SHOOTING_MODE:
                                return getEasyShootingModeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_DIGITAL_ZOOM:
                                return getDigitalZoomDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_CONTRAST:
                                return getContrastDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_SATURATION:
                                return getSaturationDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_SHARPNESS:
                                return getSharpnessDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_ISO:
                                return getIsoDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_METERING_MODE:
                                return getMeteringModeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_TYPE:
                                return getFocusTypeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_AF_POINT_SELECTED:
                                return getAfPointSelectedDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_EXPOSURE_MODE:
                                return getExposureModeDescription();
                            default:
                                switch (i) {
                                    case CanonMakernoteDirectory.CameraSettings.TAG_LENS_TYPE:
                                        return getLensTypeDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_LONG_FOCAL_LENGTH:
                                        return getLongFocalLengthDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_SHORT_FOCAL_LENGTH:
                                        return getShortFocalLengthDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FOCAL_UNITS_PER_MM:
                                        return getFocalUnitsPerMillimetreDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_MAX_APERTURE:
                                        return getMaxApertureDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_MIN_APERTURE:
                                        return getMinApertureDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FLASH_ACTIVITY:
                                        return getFlashActivityDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FLASH_DETAILS:
                                        return getFlashDetailsDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_CONTINUOUS:
                                        return getFocusContinuousDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_AE_SETTING:
                                        return getAESettingDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_MODE_2:
                                        return getFocusMode2Description();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_DISPLAY_APERTURE:
                                        return getDisplayApertureDescription();
                                    default:
                                        switch (i) {
                                            case CanonMakernoteDirectory.CameraSettings.TAG_SPOT_METERING_MODE:
                                                return getSpotMeteringModeDescription();
                                            case CanonMakernoteDirectory.CameraSettings.TAG_PHOTO_EFFECT:
                                                return getPhotoEffectDescription();
                                            case CanonMakernoteDirectory.CameraSettings.TAG_MANUAL_FLASH_OUTPUT:
                                                return getManualFlashOutputDescription();
                                            default:
                                                switch (i) {
                                                    case CanonMakernoteDirectory.FocalLength.TAG_AF_POINT_USED:
                                                        return getAfPointUsedDescription();
                                                    case CanonMakernoteDirectory.FocalLength.TAG_FLASH_BIAS:
                                                        return getFlashBiasDescription();
                                                    default:
                                                        return super.getDescription(i);
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public String getSerialNumberDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(12);
        if (integer == null) {
            return null;
        }
        return String.format("%04X%05d", new Object[]{Integer.valueOf((integer.intValue() >> 8) & 255), Integer.valueOf(integer.intValue() & 255)});
    }

    public String getFlashBiasDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.FocalLength.TAG_FLASH_BIAS);
        if (integer == null) {
            return null;
        }
        boolean z = false;
        if (integer.intValue() > 61440) {
            integer = Integer.valueOf(Integer.valueOf(65535 - integer.intValue()).intValue() + 1);
            z = true;
        }
        return (z ? "-" : "") + Float.toString(((float) integer.intValue()) / 32.0f) + " EV";
    }

    public String getAfPointUsedDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.FocalLength.TAG_AF_POINT_USED);
        if (integer == null) {
            return null;
        }
        if ((integer.intValue() & 7) == 0) {
            return "Right";
        }
        if ((integer.intValue() & 7) == 1) {
            return "Centre";
        }
        if ((integer.intValue() & 7) == 2) {
            return "Left";
        }
        return "Unknown (" + integer + ")";
    }

    public String getTagAfPointsInFocus() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.AFInfo.TAG_AF_POINTS_IN_FOCUS);
        if (integer == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if ((integer.intValue() & (1 << i)) != 0) {
                if (sb.length() != 0) {
                    sb.append(',');
                }
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "None" : sb.toString();
    }

    public String getWhiteBalanceDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.FocalLength.TAG_WHITE_BALANCE, "Auto", "Sunny", "Cloudy", "Tungsten", "Florescent", ExifInterface.TAG_FLASH, "Custom");
    }

    public String getFocusMode2Description() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_MODE_2, "Single", "Continuous");
    }

    public String getFlashDetailsDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_FLASH_DETAILS);
        if (integer == null) {
            return null;
        }
        if (((integer.intValue() >> 14) & 1) != 0) {
            return "External E-TTL";
        }
        if (((integer.intValue() >> 13) & 1) != 0) {
            return "Internal flash";
        }
        if (((integer.intValue() >> 11) & 1) != 0) {
            return "FP sync used";
        }
        if (((integer.intValue() >> 4) & 1) != 0) {
            return "FP sync enabled";
        }
        return "Unknown (" + integer + ")";
    }

    public String getFocalUnitsPerMillimetreDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_FOCAL_UNITS_PER_MM);
        if (integer == null) {
            return null;
        }
        return integer.intValue() != 0 ? Integer.toString(integer.intValue()) : "";
    }

    public String getShortFocalLengthDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SHORT_FOCAL_LENGTH);
        if (integer == null) {
            return null;
        }
        return Integer.toString(integer.intValue()) + " " + getFocalUnitsPerMillimetreDescription();
    }

    public String getLongFocalLengthDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_LONG_FOCAL_LENGTH);
        if (integer == null) {
            return null;
        }
        return Integer.toString(integer.intValue()) + " " + getFocalUnitsPerMillimetreDescription();
    }

    public String getExposureModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_EXPOSURE_MODE, "Easy shooting", "Program", "Tv-priority", "Av-priority", "Manual", "A-DEP");
    }

    public String getLensTypeDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_LENS_TYPE);
        if (integer == null) {
            return null;
        }
        HashMap<Integer, String> hashMap = _lensTypeById;
        if (hashMap.containsKey(integer)) {
            return hashMap.get(integer);
        }
        return String.format("Unknown (%d)", new Object[]{integer});
    }

    public String getMaxApertureDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_MAX_APERTURE);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() <= 512) {
            return getFStopDescription(Math.exp((decodeCanonEv(integer.intValue()) * Math.log(2.0d)) / 2.0d));
        }
        return String.format("Unknown (%d)", new Object[]{integer});
    }

    public String getMinApertureDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_MIN_APERTURE);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() <= 512) {
            return getFStopDescription(Math.exp((decodeCanonEv(integer.intValue()) * Math.log(2.0d)) / 2.0d));
        }
        return String.format("Unknown (%d)", new Object[]{integer});
    }

    public String getAfPointSelectedDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_AF_POINT_SELECTED, 12288, "None (MF)", "Auto selected", "Right", "Centre", "Left");
    }

    public String getMeteringModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_METERING_MODE, 3, "Evaluative", "Partial", "Centre weighted");
    }

    public String getIsoDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_ISO);
        if (integer == null) {
            return null;
        }
        if ((integer.intValue() & 16384) != 0) {
            return "" + (integer.intValue() & -16385);
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Not specified (see ISOSpeedRatings tag)";
        }
        switch (intValue) {
            case 15:
                return "Auto";
            case 16:
                return "50";
            case 17:
                return "100";
            case 18:
                return "200";
            case 19:
                return "400";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    public String getSharpnessDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SHARPNESS);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue != 1) {
            return intValue != 65535 ? "Unknown (" + integer + ")" : "Low";
        }
        return "High";
    }

    public String getSaturationDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SATURATION);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue != 1) {
            return intValue != 65535 ? "Unknown (" + integer + ")" : "Low";
        }
        return "High";
    }

    public String getContrastDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_CONTRAST);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue != 1) {
            return intValue != 65535 ? "Unknown (" + integer + ")" : "Low";
        }
        return "High";
    }

    public String getEasyShootingModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_EASY_SHOOTING_MODE, "Full auto", "Manual", "Landscape", "Fast shutter", "Slow shutter", "Night", "B&W", "Sepia", "Portrait", "Sports", "Macro / Closeup", "Pan focus");
    }

    public String getImageSizeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_IMAGE_SIZE, "Large", "Medium", "Small");
    }

    public String getFocusMode1Description() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_MODE_1, "One-shot", "AI Servo", "AI Focus", "Manual Focus", "Single", "Continuous", "Manual Focus");
    }

    public String getContinuousDriveModeDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_CONTINUOUS_DRIVE_MODE);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            Integer integer2 = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SELF_TIMER_DELAY);
            if (integer2 != null) {
                return integer2.intValue() == 0 ? "Single shot" : "Single shot with self-timer";
            }
            return "Continuous";
        } else if (intValue != 1) {
            return "Unknown (" + integer + ")";
        } else {
            return "Continuous";
        }
    }

    public String getFlashModeDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_FLASH_MODE);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 16) {
            return "External flash";
        }
        switch (intValue) {
            case 0:
                return "No flash fired";
            case 1:
                return "Auto";
            case 2:
                return "On";
            case 3:
                return "Red-eye reduction";
            case 4:
                return "Slow-synchro";
            case 5:
                return "Auto and red-eye reduction";
            case 6:
                return "On and red-eye reduction";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    public String getSelfTimerDelayDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SELF_TIMER_DELAY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "Self timer not used";
        }
        return new DecimalFormat("0.##").format(((double) integer.intValue()) * 0.1d) + " sec";
    }

    public String getMacroModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_MACRO_MODE, 1, "Macro", "Normal");
    }

    public String getQualityDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_QUALITY, 2, "Normal", "Fine", null, "Superfine");
    }

    public String getDigitalZoomDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_DIGITAL_ZOOM, "No digital zoom", "2x", "4x");
    }

    public String getRecordModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_RECORD_MODE, 1, "JPEG", "CRW+THM", "AVI+THM", "TIF", "TIF+JPEG", "CR2", "CR2+JPEG", null, "MOV", "MP4");
    }

    public String getFocusTypeDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_TYPE);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Manual";
        }
        if (intValue == 1) {
            return "Auto";
        }
        if (intValue != 3) {
            return intValue != 8 ? "Unknown (" + integer + ")" : "Locked (Pan Mode)";
        }
        return "Close-up (Macro)";
    }

    public String getFlashActivityDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_FLASH_ACTIVITY, "Flash did not fire", "Flash fired");
    }

    public String getFocusContinuousDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_CONTINUOUS, 0, "Single", "Continuous", null, null, null, null, null, null, "Manual");
    }

    public String getAESettingDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_AE_SETTING, 0, "Normal AE", "Exposure Compensation", "AE Lock", "AE Lock + Exposure Comp.", "No AE");
    }

    public String getDisplayApertureDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_DISPLAY_APERTURE);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 65535) {
            return integer.toString();
        }
        return getFStopDescription((double) (((float) integer.intValue()) / 10.0f));
    }

    public String getSpotMeteringModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_SPOT_METERING_MODE, 0, "Center", "AF Point");
    }

    public String getPhotoEffectDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_PHOTO_EFFECT);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 100) {
            return "My Color Data";
        }
        switch (intValue) {
            case 0:
                return "Off";
            case 1:
                return "Vivid";
            case 2:
                return "Neutral";
            case 3:
                return "Smooth";
            case 4:
                return "Sepia";
            case 5:
                return "B&W";
            case 6:
                return "Custom";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    public String getManualFlashOutputDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_MANUAL_FLASH_OUTPUT);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "n/a";
        }
        if (intValue == 1280) {
            return "Full";
        }
        if (intValue == 1282) {
            return "Medium";
        }
        if (intValue != 1284) {
            return intValue != 32767 ? "Unknown (" + integer + ")" : "n/a";
        }
        return "Low";
    }

    public String getColorToneDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_COLOR_TONE);
        if (integer == null) {
            return null;
        }
        return integer.intValue() == 32767 ? "n/a" : integer.toString();
    }

    public String getSRawQualityDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_SRAW_QUALITY, 0, "n/a", "sRAW1 (mRAW)", "sRAW2 (sRAW)");
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _lensTypeById = hashMap;
        hashMap.put(1, "Canon EF 50mm f/1.8");
        hashMap.put(2, "Canon EF 28mm f/2.8");
        hashMap.put(3, "Canon EF 135mm f/2.8 Soft");
        hashMap.put(4, "Canon EF 35-105mm f/3.5-4.5 or Sigma Lens");
        hashMap.put(5, "Canon EF 35-70mm f/3.5-4.5");
        hashMap.put(6, "Canon EF 28-70mm f/3.5-4.5 or Sigma or Tokina Lens");
        hashMap.put(7, "Canon EF 100-300mm f/5.6L");
        hashMap.put(8, "Canon EF 100-300mm f/5.6 or Sigma or Tokina Lens");
        hashMap.put(9, "Canon EF 70-210mm f/4");
        hashMap.put(10, "Canon EF 50mm f/2.5 Macro or Sigma Lens");
        hashMap.put(11, "Canon EF 35mm f/2");
        hashMap.put(13, "Canon EF 15mm f/2.8 Fisheye");
        hashMap.put(14, "Canon EF 50-200mm f/3.5-4.5L");
        hashMap.put(15, "Canon EF 50-200mm f/3.5-4.5");
        hashMap.put(16, "Canon EF 35-135mm f/3.5-4.5");
        hashMap.put(17, "Canon EF 35-70mm f/3.5-4.5A");
        hashMap.put(18, "Canon EF 28-70mm f/3.5-4.5");
        hashMap.put(20, "Canon EF 100-200mm f/4.5A");
        hashMap.put(21, "Canon EF 80-200mm f/2.8L");
        hashMap.put(22, "Canon EF 20-35mm f/2.8L or Tokina Lens");
        hashMap.put(23, "Canon EF 35-105mm f/3.5-4.5");
        hashMap.put(24, "Canon EF 35-80mm f/4-5.6 Power Zoom");
        hashMap.put(25, "Canon EF 35-80mm f/4-5.6 Power Zoom");
        hashMap.put(26, "Canon EF 100mm f/2.8 Macro or Other Lens");
        hashMap.put(27, "Canon EF 35-80mm f/4-5.6");
        hashMap.put(28, "Canon EF 80-200mm f/4.5-5.6 or Tamron Lens");
        hashMap.put(29, "Canon EF 50mm f/1.8 II");
        hashMap.put(30, "Canon EF 35-105mm f/4.5-5.6");
        hashMap.put(31, "Canon EF 75-300mm f/4-5.6 or Tamron Lens");
        hashMap.put(32, "Canon EF 24mm f/2.8 or Sigma Lens");
        hashMap.put(33, "Voigtlander or Carl Zeiss Lens");
        hashMap.put(35, "Canon EF 35-80mm f/4-5.6");
        hashMap.put(36, "Canon EF 38-76mm f/4.5-5.6");
        hashMap.put(37, "Canon EF 35-80mm f/4-5.6 or Tamron Lens");
        hashMap.put(38, "Canon EF 80-200mm f/4.5-5.6");
        hashMap.put(39, "Canon EF 75-300mm f/4-5.6");
        hashMap.put(40, "Canon EF 28-80mm f/3.5-5.6");
        hashMap.put(41, "Canon EF 28-90mm f/4-5.6");
        hashMap.put(42, "Canon EF 28-200mm f/3.5-5.6 or Tamron Lens");
        hashMap.put(43, "Canon EF 28-105mm f/4-5.6");
        hashMap.put(44, "Canon EF 90-300mm f/4.5-5.6");
        hashMap.put(45, "Canon EF-S 18-55mm f/3.5-5.6 [II]");
        hashMap.put(46, "Canon EF 28-90mm f/4-5.6");
        hashMap.put(47, "Zeiss Milvus 35mm f/2 or 50mm f/2");
        hashMap.put(48, "Canon EF-S 18-55mm f/3.5-5.6 IS");
        hashMap.put(49, "Canon EF-S 55-250mm f/4-5.6 IS");
        hashMap.put(50, "Canon EF-S 18-200mm f/3.5-5.6 IS");
        hashMap.put(51, "Canon EF-S 18-135mm f/3.5-5.6 IS");
        hashMap.put(52, "Canon EF-S 18-55mm f/3.5-5.6 IS II");
        hashMap.put(53, "Canon EF-S 18-55mm f/3.5-5.6 III");
        hashMap.put(54, "Canon EF-S 55-250mm f/4-5.6 IS II");
        hashMap.put(94, "Canon TS-E 17mm f/4L");
        hashMap.put(95, "Canon TS-E 24.0mm f/3.5 L II");
        hashMap.put(124, "Canon MP-E 65mm f/2.8 1-5x Macro Photo");
        hashMap.put(125, "Canon TS-E 24mm f/3.5L");
        hashMap.put(126, "Canon TS-E 45mm f/2.8");
        hashMap.put(Integer.valueOf(CertificateBody.profileType), "Canon TS-E 90mm f/2.8");
        hashMap.put(129, "Canon EF 300mm f/2.8L");
        hashMap.put(Integer.valueOf(NikonType2MakernoteDirectory.TAG_ADAPTER), "Canon EF 50mm f/1.0L");
        hashMap.put(131, "Canon EF 28-80mm f/2.8-4L or Sigma Lens");
        hashMap.put(132, "Canon EF 1200mm f/5.6L");
        hashMap.put(134, "Canon EF 600mm f/4L IS");
        hashMap.put(135, "Canon EF 200mm f/1.8L");
        hashMap.put(136, "Canon EF 300mm f/2.8L");
        hashMap.put(137, "Canon EF 85mm f/1.2L or Sigma or Tamron Lens");
        hashMap.put(138, "Canon EF 28-80mm f/2.8-4L");
        hashMap.put(139, "Canon EF 400mm f/2.8L");
        hashMap.put(140, "Canon EF 500mm f/4.5L");
        hashMap.put(141, "Canon EF 500mm f/4.5L");
        hashMap.put(142, "Canon EF 300mm f/2.8L IS");
        hashMap.put(143, "Canon EF 500mm f/4L IS or Sigma Lens");
        hashMap.put(144, "Canon EF 35-135mm f/4-5.6 USM");
        hashMap.put(145, "Canon EF 100-300mm f/4.5-5.6 USM");
        hashMap.put(146, "Canon EF 70-210mm f/3.5-4.5 USM");
        hashMap.put(147, "Canon EF 35-135mm f/4-5.6 USM");
        hashMap.put(148, "Canon EF 28-80mm f/3.5-5.6 USM");
        hashMap.put(149, "Canon EF 100mm f/2 USM");
        hashMap.put(150, "Canon EF 14mm f/2.8L or Sigma Lens");
        hashMap.put(151, "Canon EF 200mm f/2.8L");
        hashMap.put(152, "Canon EF 300mm f/4L IS or Sigma Lens");
        hashMap.put(153, "Canon EF 35-350mm f/3.5-5.6L or Sigma or Tamron Lens");
        hashMap.put(154, "Canon EF 20mm f/2.8 USM or Zeiss Lens");
        hashMap.put(155, "Canon EF 85mm f/1.8 USM");
        hashMap.put(156, "Canon EF 28-105mm f/3.5-4.5 USM or Tamron Lens");
        hashMap.put(160, "Canon EF 20-35mm f/3.5-4.5 USM or Tamron or Tokina Lens");
        hashMap.put(161, "Canon EF 28-70mm f/2.8L or Sigma or Tamron Lens");
        hashMap.put(162, "Canon EF 200mm f/2.8L");
        hashMap.put(163, "Canon EF 300mm f/4L");
        hashMap.put(164, "Canon EF 400mm f/5.6L");
        hashMap.put(165, "Canon EF 70-200mm f/2.8 L");
        hashMap.put(166, "Canon EF 70-200mm f/2.8 L + 1.4x");
        hashMap.put(167, "Canon EF 70-200mm f/2.8 L + 2x");
        hashMap.put(168, "Canon EF 28mm f/1.8 USM or Sigma Lens");
        hashMap.put(169, "Canon EF 17-35mm f/2.8L or Sigma Lens");
        hashMap.put(170, "Canon EF 200mm f/2.8L II");
        hashMap.put(171, "Canon EF 300mm f/4L");
        hashMap.put(172, "Canon EF 400mm f/5.6L or Sigma Lens");
        hashMap.put(173, "Canon EF 180mm Macro f/3.5L or Sigma Lens");
        hashMap.put(174, "Canon EF 135mm f/2L or Other Lens");
        hashMap.put(175, "Canon EF 400mm f/2.8L");
        hashMap.put(176, "Canon EF 24-85mm f/3.5-4.5 USM");
        hashMap.put(177, "Canon EF 300mm f/4L IS");
        hashMap.put(178, "Canon EF 28-135mm f/3.5-5.6 IS");
        hashMap.put(179, "Canon EF 24mm f/1.4L");
        hashMap.put(180, "Canon EF 35mm f/1.4L or Other Lens");
        hashMap.put(181, "Canon EF 100-400mm f/4.5-5.6L IS + 1.4x or Sigma Lens");
        hashMap.put(182, "Canon EF 100-400mm f/4.5-5.6L IS + 2x or Sigma Lens");
        hashMap.put(183, "Canon EF 100-400mm f/4.5-5.6L IS or Sigma Lens");
        hashMap.put(184, "Canon EF 400mm f/2.8L + 2x");
        hashMap.put(185, "Canon EF 600mm f/4L IS");
        hashMap.put(Integer.valueOf(CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256), "Canon EF 70-200mm f/4L");
        hashMap.put(187, "Canon EF 70-200mm f/4L + 1.4x");
        hashMap.put(188, "Canon EF 70-200mm f/4L + 2x");
        hashMap.put(189, "Canon EF 70-200mm f/4L + 2.8x");
        hashMap.put(Integer.valueOf(CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256), "Canon EF 100mm f/2.8 Macro USM");
        hashMap.put(Integer.valueOf(CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256), "Canon EF 400mm f/4 DO IS");
        hashMap.put(Integer.valueOf(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256), "Canon EF 35-80mm f/4-5.6 USM");
        hashMap.put(Integer.valueOf(CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256), "Canon EF 80-200mm f/4.5-5.6 USM");
        hashMap.put(Integer.valueOf(CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256), "Canon EF 35-105mm f/4.5-5.6 USM");
        hashMap.put(Integer.valueOf(CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256), "Canon EF 75-300mm f/4-5.6 USM");
        hashMap.put(Integer.valueOf(CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256), "Canon EF 75-300mm f/4-5.6 IS USM");
        hashMap.put(198, "Canon EF 50mm f/1.4 USM or Zeiss Lens");
        hashMap.put(199, "Canon EF 28-80mm f/3.5-5.6 USM");
        hashMap.put(200, "Canon EF 75-300mm f/4-5.6 USM");
        hashMap.put(Integer.valueOf(XMPError.BADXML), "Canon EF 28-80mm f/3.5-5.6 USM");
        hashMap.put(Integer.valueOf(XMPError.BADRDF), "Canon EF 28-80mm f/3.5-5.6 USM IV");
        hashMap.put(208, "Canon EF 22-55mm f/4-5.6 USM");
        hashMap.put(209, "Canon EF 55-200mm f/4.5-5.6");
        hashMap.put(210, "Canon EF 28-90mm f/4-5.6 USM");
        hashMap.put(Integer.valueOf(Primes.SMALL_FACTOR_LIMIT), "Canon EF 28-200mm f/3.5-5.6 USM");
        hashMap.put(212, "Canon EF 28-105mm f/4-5.6 USM");
        hashMap.put(213, "Canon EF 90-300mm f/4.5-5.6 USM or Tamron Lens");
        hashMap.put(214, "Canon EF-S 18-55mm f/3.5-5.6 USM");
        hashMap.put(Integer.valueOf(JfifUtil.MARKER_RST7), "Canon EF 55-200mm f/4.5-5.6 II USM");
        hashMap.put(Integer.valueOf(JfifUtil.MARKER_EOI), "Tamron AF 18-270mm f/3.5-6.3 Di II VC PZD");
        hashMap.put(Integer.valueOf(CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY), "Canon EF 70-200mm f/2.8L IS");
        hashMap.put(Integer.valueOf(JfifUtil.MARKER_APP1), "Canon EF 70-200mm f/2.8L IS + 1.4x");
        hashMap.put(226, "Canon EF 70-200mm f/2.8L IS + 2x");
        hashMap.put(227, "Canon EF 70-200mm f/2.8L IS + 2.8x");
        hashMap.put(228, "Canon EF 28-105mm f/3.5-4.5 USM");
        hashMap.put(229, "Canon EF 16-35mm f/2.8L");
        hashMap.put(230, "Canon EF 24-70mm f/2.8L");
        hashMap.put(231, "Canon EF 17-40mm f/4L");
        hashMap.put(232, "Canon EF 70-300mm f/4.5-5.6 DO IS USM");
        hashMap.put(233, "Canon EF 28-300mm f/3.5-5.6L IS");
        hashMap.put(234, "Canon EF-S 17-85mm f/4-5.6 IS USM or Tokina Lens");
        hashMap.put(235, "Canon EF-S 10-22mm f/3.5-4.5 USM");
        hashMap.put(236, "Canon EF-S 60mm f/2.8 Macro USM");
        hashMap.put(237, "Canon EF 24-105mm f/4L IS");
        hashMap.put(238, "Canon EF 70-300mm f/4-5.6 IS USM");
        hashMap.put(239, "Canon EF 85mm f/1.2L II");
        hashMap.put(240, "Canon EF-S 17-55mm f/2.8 IS USM");
        hashMap.put(241, "Canon EF 50mm f/1.2L");
        hashMap.put(242, "Canon EF 70-200mm f/4L IS");
        hashMap.put(243, "Canon EF 70-200mm f/4L IS + 1.4x");
        hashMap.put(244, "Canon EF 70-200mm f/4L IS + 2x");
        hashMap.put(245, "Canon EF 70-200mm f/4L IS + 2.8x");
        hashMap.put(246, "Canon EF 16-35mm f/2.8L II");
        hashMap.put(247, "Canon EF 14mm f/2.8L II USM");
        hashMap.put(248, "Canon EF 200mm f/2L IS or Sigma Lens");
        hashMap.put(249, "Canon EF 800mm f/5.6L IS");
        hashMap.put(250, "Canon EF 24mm f/1.4L II or Sigma Lens");
        hashMap.put(251, "Canon EF 70-200mm f/2.8L IS II USM");
        hashMap.put(252, "Canon EF 70-200mm f/2.8L IS II USM + 1.4x");
        hashMap.put(253, "Canon EF 70-200mm f/2.8L IS II USM + 2x");
        hashMap.put(254, "Canon EF 100mm f/2.8L Macro IS USM");
        hashMap.put(255, "Sigma 24-105mm f/4 DG OS HSM | A or Other Sigma Lens");
        hashMap.put(488, "Canon EF-S 15-85mm f/3.5-5.6 IS USM");
        hashMap.put(489, "Canon EF 70-300mm f/4-5.6L IS USM");
        hashMap.put(490, "Canon EF 8-15mm f/4L Fisheye USM");
        hashMap.put(491, "Canon EF 300mm f/2.8L IS II USM");
        hashMap.put(492, "Canon EF 400mm f/2.8L IS II USM");
        hashMap.put(493, "Canon EF 500mm f/4L IS II USM or EF 24-105mm f4L IS USM");
        hashMap.put(494, "Canon EF 600mm f/4.0L IS II USM");
        hashMap.put(495, "Canon EF 24-70mm f/2.8L II USM");
        hashMap.put(496, "Canon EF 200-400mm f/4L IS USM");
        hashMap.put(499, "Canon EF 200-400mm f/4L IS USM + 1.4x");
        hashMap.put(502, "Canon EF 28mm f/2.8 IS USM");
        hashMap.put(503, "Canon EF 24mm f/2.8 IS USM");
        hashMap.put(504, "Canon EF 24-70mm f/4L IS USM");
        hashMap.put(505, "Canon EF 35mm f/2 IS USM");
        hashMap.put(506, "Canon EF 400mm f/4 DO IS II USM");
        hashMap.put(507, "Canon EF 16-35mm f/4L IS USM");
        hashMap.put(508, "Canon EF 11-24mm f/4L USM");
        hashMap.put(747, "Canon EF 100-400mm f/4.5-5.6L IS II USM");
        hashMap.put(750, "Canon EF 35mm f/1.4L II USM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_OLYMPUS_IMAGE_WIDTH), "Canon EF-S 18-135mm f/3.5-5.6 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_OLYMPUS_IMAGE_HEIGHT), "Canon EF-M 18-55mm f/3.5-5.6 IS STM or Tamron Lens");
        hashMap.put(4144, "Canon EF 40mm f/2.8 STM");
        hashMap.put(4145, "Canon EF-M 22mm f/2 STM");
        hashMap.put(4146, "Canon EF-S 18-55mm f/3.5-5.6 IS STM");
        hashMap.put(4147, "Canon EF-M 11-22mm f/4-5.6 IS STM");
        hashMap.put(4148, "Canon EF-S 55-250mm f/4-5.6 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE_VALID), "Canon EF-M 55-200mm f/4.5-6.3 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE_START), "Canon EF-S 10-18mm f/4.5-5.6 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_AF_RESULT), "Canon EF 24-105mm f/3.5-5.6 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_CCD_SCAN_MODE), "Canon EF-M 15-45mm f/3.5-6.3 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_NOISE_REDUCTION), "Canon EF-S 24mm f/2.8 STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_NEAR_LENS_STEP), "Canon EF 50mm f/1.8 STM");
        hashMap.put(36912, "Canon EF-S 18-135mm f/3.5-5.6 IS USM");
        hashMap.put(65535, "N/A");
    }
}
