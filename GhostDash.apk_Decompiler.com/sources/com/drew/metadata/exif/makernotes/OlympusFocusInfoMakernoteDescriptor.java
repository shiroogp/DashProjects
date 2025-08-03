package com.drew.metadata.exif.makernotes;

import com.drew.lang.Rational;
import com.drew.metadata.TagDescriptor;
import org.spongycastle.asn1.cmc.BodyPartID;

public class OlympusFocusInfoMakernoteDescriptor extends TagDescriptor<OlympusFocusInfoMakernoteDirectory> {
    public OlympusFocusInfoMakernoteDescriptor(OlympusFocusInfoMakernoteDirectory olympusFocusInfoMakernoteDirectory) {
        super(olympusFocusInfoMakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i == 0) {
            return getFocusInfoVersionDescription();
        }
        if (i == 521) {
            return getAutoFocusDescription();
        }
        if (i == 773) {
            return getFocusDistanceDescription();
        }
        if (i == 776) {
            return getAfPointDescription();
        }
        if (i == 4609) {
            return getExternalFlashDescription();
        }
        if (i == 5376) {
            return getSensorTemperatureDescription();
        }
        if (i == 5632) {
            return getImageStabilizationDescription();
        }
        if (i == 4612) {
            return getExternalFlashBounceDescription();
        }
        if (i == 4613) {
            return getExternalFlashZoomDescription();
        }
        if (i == 4617) {
            return getManualFlashDescription();
        }
        if (i != 4618) {
            return super.getDescription(i);
        }
        return getMacroLedDescription();
    }

    public String getFocusInfoVersionDescription() {
        return getVersionBytesDescription(0, 4);
    }

    public String getAutoFocusDescription() {
        return getIndexedDescription(521, "Off", "On");
    }

    public String getFocusDistanceDescription() {
        Rational rational = ((OlympusFocusInfoMakernoteDirectory) this._directory).getRational(773);
        if (rational == null || rational.getNumerator() == BodyPartID.bodyIdMax || rational.getNumerator() == 0) {
            return "inf";
        }
        return (((double) rational.getNumerator()) / 1000.0d) + " m";
    }

    public String getAfPointDescription() {
        Integer integer = ((OlympusFocusInfoMakernoteDirectory) this._directory).getInteger(OlympusFocusInfoMakernoteDirectory.TagAfPoint);
        if (integer == null) {
            return null;
        }
        return integer.toString();
    }

    public String getExternalFlashDescription() {
        int[] intArray = ((OlympusFocusInfoMakernoteDirectory) this._directory).getIntArray(4609);
        if (intArray == null || intArray.length < 2) {
            return null;
        }
        String format = String.format("%d %d", new Object[]{Short.valueOf((short) intArray[0]), Short.valueOf((short) intArray[1])});
        if (format.equals("0 0")) {
            return "Off";
        }
        if (format.equals("1 0")) {
            return "On";
        }
        return "Unknown (" + format + ")";
    }

    public String getExternalFlashBounceDescription() {
        return getIndexedDescription(OlympusFocusInfoMakernoteDirectory.TagExternalFlashBounce, "Bounce or Off", "Direct");
    }

    public String getExternalFlashZoomDescription() {
        int[] intArray = ((OlympusFocusInfoMakernoteDirectory) this._directory).getIntArray(OlympusFocusInfoMakernoteDirectory.TagExternalFlashZoom);
        if (intArray == null) {
            Integer integer = ((OlympusFocusInfoMakernoteDirectory) this._directory).getInteger(OlympusFocusInfoMakernoteDirectory.TagExternalFlashZoom);
            if (integer == null) {
                return null;
            }
            intArray = new int[]{integer.intValue()};
        }
        if (intArray.length == 0) {
            return null;
        }
        String format = String.format("%d", new Object[]{Short.valueOf((short) intArray[0])});
        if (intArray.length > 1) {
            format = format + " " + String.format("%d", new Object[]{Short.valueOf((short) intArray[1])});
        }
        if (format.equals("0")) {
            return "Off";
        }
        if (format.equals("1")) {
            return "On";
        }
        if (format.equals("0 0")) {
            return "Off";
        }
        if (format.equals("1 0")) {
            return "On";
        }
        return "Unknown (" + format + ")";
    }

    public String getManualFlashDescription() {
        int[] intArray = ((OlympusFocusInfoMakernoteDirectory) this._directory).getIntArray(OlympusFocusInfoMakernoteDirectory.TagManualFlash);
        if (intArray == null) {
            return null;
        }
        if (((short) intArray[0]) == 0) {
            return "Off";
        }
        if (((short) intArray[1]) == 1) {
            return "Full";
        }
        return "On (1/" + ((short) intArray[1]) + " strength)";
    }

    public String getMacroLedDescription() {
        return getIndexedDescription(OlympusFocusInfoMakernoteDirectory.TagMacroLed, "Off", "On");
    }

    public String getSensorTemperatureDescription() {
        return ((OlympusFocusInfoMakernoteDirectory) this._directory).getString(OlympusFocusInfoMakernoteDirectory.TagSensorTemperature);
    }

    public String getImageStabilizationDescription() {
        byte[] byteArray = ((OlympusFocusInfoMakernoteDirectory) this._directory).getByteArray(OlympusFocusInfoMakernoteDirectory.TagImageStabilization);
        if (byteArray == null) {
            return null;
        }
        if ((byteArray[0] | byteArray[1] | byteArray[2] | byteArray[3]) == 0) {
            return "Off";
        }
        return "On, " + ((byteArray[43] & 1) > 0 ? "Mode 1" : "Mode 2");
    }
}
