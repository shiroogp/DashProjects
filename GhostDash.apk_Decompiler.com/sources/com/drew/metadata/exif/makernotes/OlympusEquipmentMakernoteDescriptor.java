package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;
import java.text.DecimalFormat;
import java.util.HashMap;

public class OlympusEquipmentMakernoteDescriptor extends TagDescriptor<OlympusEquipmentMakernoteDirectory> {
    private static final HashMap<String, String> _olympusExtenderTypes;
    private static final HashMap<String, String> _olympusLensTypes;

    public OlympusEquipmentMakernoteDescriptor(OlympusEquipmentMakernoteDirectory olympusEquipmentMakernoteDirectory) {
        super(olympusEquipmentMakernoteDirectory);
    }

    public String getDescription(int i) {
        if (i == 0) {
            return getEquipmentVersionDescription();
        }
        if (i == 256) {
            return getCameraType2Description();
        }
        if (i == 513) {
            return getLensTypeDescription();
        }
        if (i == 769) {
            return getExtenderDescription();
        }
        if (i == 259) {
            return getFocalPlaneDiagonalDescription();
        }
        if (i == 260) {
            return getBodyFirmwareVersionDescription();
        }
        if (i == 522) {
            return getMaxApertureDescription();
        }
        if (i == 523) {
            return getLensPropertiesDescription();
        }
        if (i == 4096) {
            return getFlashTypeDescription();
        }
        if (i == 4097) {
            return getFlashModelDescription();
        }
        switch (i) {
            case 516:
                return getLensFirmwareVersionDescription();
            case 517:
                return getMaxApertureAtMinFocalDescription();
            case 518:
                return getMaxApertureAtMaxFocalDescription();
            default:
                return super.getDescription(i);
        }
    }

    public String getEquipmentVersionDescription() {
        return getVersionBytesDescription(0, 4);
    }

    public String getCameraType2Description() {
        String string = ((OlympusEquipmentMakernoteDirectory) this._directory).getString(256);
        if (string == null) {
            return null;
        }
        return OlympusMakernoteDirectory.OlympusCameraTypes.containsKey(string) ? OlympusMakernoteDirectory.OlympusCameraTypes.get(string) : string;
    }

    public String getFocalPlaneDiagonalDescription() {
        return ((OlympusEquipmentMakernoteDirectory) this._directory).getString(259) + " mm";
    }

    public String getBodyFirmwareVersionDescription() {
        Integer integer = ((OlympusEquipmentMakernoteDirectory) this._directory).getInteger(260);
        if (integer == null) {
            return null;
        }
        String format = String.format("%04X", new Object[]{integer});
        return String.format("%s.%s", new Object[]{format.substring(0, format.length() - 3), format.substring(format.length() - 3)});
    }

    public String getLensTypeDescription() {
        String string = ((OlympusEquipmentMakernoteDirectory) this._directory).getString(513);
        if (string == null) {
            return null;
        }
        String[] split = string.split(" ");
        if (split.length < 6) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[2]);
            int parseInt3 = Integer.parseInt(split[3]);
            return _olympusLensTypes.get(String.format("%X %02X %02X", new Object[]{Integer.valueOf(parseInt), Integer.valueOf(parseInt2), Integer.valueOf(parseInt3)}));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public String getLensFirmwareVersionDescription() {
        Integer integer = ((OlympusEquipmentMakernoteDirectory) this._directory).getInteger(516);
        if (integer == null) {
            return null;
        }
        String format = String.format("%04X", new Object[]{integer});
        return String.format("%s.%s", new Object[]{format.substring(0, format.length() - 3), format.substring(format.length() - 3)});
    }

    public String getMaxApertureAtMinFocalDescription() {
        Integer integer = ((OlympusEquipmentMakernoteDirectory) this._directory).getInteger(517);
        if (integer == null) {
            return null;
        }
        return new DecimalFormat("0.#").format(CalcMaxAperture(integer.intValue()));
    }

    public String getMaxApertureAtMaxFocalDescription() {
        Integer integer = ((OlympusEquipmentMakernoteDirectory) this._directory).getInteger(518);
        if (integer == null) {
            return null;
        }
        return new DecimalFormat("0.#").format(CalcMaxAperture(integer.intValue()));
    }

    public String getMaxApertureDescription() {
        Integer integer = ((OlympusEquipmentMakernoteDirectory) this._directory).getInteger(522);
        if (integer == null) {
            return null;
        }
        return new DecimalFormat("0.#").format(CalcMaxAperture(integer.intValue()));
    }

    private static double CalcMaxAperture(int i) {
        return Math.pow(Math.sqrt(2.0d), ((double) i) / 256.0d);
    }

    public String getLensPropertiesDescription() {
        Integer integer = ((OlympusEquipmentMakernoteDirectory) this._directory).getInteger(523);
        if (integer == null) {
            return null;
        }
        return String.format("0x%04X", new Object[]{integer});
    }

    public String getExtenderDescription() {
        String string = ((OlympusEquipmentMakernoteDirectory) this._directory).getString(769);
        if (string == null) {
            return null;
        }
        String[] split = string.split(" ");
        if (split.length < 6) {
            return null;
        }
        try {
            return _olympusExtenderTypes.get(String.format("%X %02X", new Object[]{Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[2]))}));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public String getFlashTypeDescription() {
        return getIndexedDescription(4096, "None", null, "Simple E-System", "E-System");
    }

    public String getFlashModelDescription() {
        return getIndexedDescription(4097, "None", "FL-20", "FL-50", "RF-11", "TF-22", "FL-36", "FL-50R", "FL-36R");
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        _olympusLensTypes = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        _olympusExtenderTypes = hashMap2;
        hashMap.put("0 00 00", "None");
        hashMap.put("0 01 00", "Olympus Zuiko Digital ED 50mm F2.0 Macro");
        hashMap.put("0 01 01", "Olympus Zuiko Digital 40-150mm F3.5-4.5");
        hashMap.put("0 01 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6");
        hashMap.put("0 02 00", "Olympus Zuiko Digital ED 150mm F2.0");
        hashMap.put("0 02 10", "Olympus M.Zuiko Digital 17mm F2.8 Pancake");
        hashMap.put("0 03 00", "Olympus Zuiko Digital ED 300mm F2.8");
        hashMap.put("0 03 10", "Olympus M.Zuiko Digital ED 14-150mm F4.0-5.6 [II]");
        hashMap.put("0 04 10", "Olympus M.Zuiko Digital ED 9-18mm F4.0-5.6");
        hashMap.put("0 05 00", "Olympus Zuiko Digital 14-54mm F2.8-3.5");
        hashMap.put("0 05 01", "Olympus Zuiko Digital Pro ED 90-250mm F2.8");
        hashMap.put("0 05 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6 L");
        hashMap.put("0 06 00", "Olympus Zuiko Digital ED 50-200mm F2.8-3.5");
        hashMap.put("0 06 01", "Olympus Zuiko Digital ED 8mm F3.5 Fisheye");
        hashMap.put("0 06 10", "Olympus M.Zuiko Digital ED 40-150mm F4.0-5.6");
        hashMap.put("0 07 00", "Olympus Zuiko Digital 11-22mm F2.8-3.5");
        hashMap.put("0 07 01", "Olympus Zuiko Digital 18-180mm F3.5-6.3");
        hashMap.put("0 07 10", "Olympus M.Zuiko Digital ED 12mm F2.0");
        hashMap.put("0 08 01", "Olympus Zuiko Digital 70-300mm F4.0-5.6");
        hashMap.put("0 08 10", "Olympus M.Zuiko Digital ED 75-300mm F4.8-6.7");
        hashMap.put("0 09 10", "Olympus M.Zuiko Digital 14-42mm F3.5-5.6 II");
        hashMap.put("0 10 01", "Kenko Tokina Reflex 300mm F6.3 MF Macro");
        hashMap.put("0 10 10", "Olympus M.Zuiko Digital ED 12-50mm F3.5-6.3 EZ");
        hashMap.put("0 11 10", "Olympus M.Zuiko Digital 45mm F1.8");
        hashMap.put("0 12 10", "Olympus M.Zuiko Digital ED 60mm F2.8 Macro");
        hashMap.put("0 13 10", "Olympus M.Zuiko Digital 14-42mm F3.5-5.6 II R");
        hashMap.put("0 14 10", "Olympus M.Zuiko Digital ED 40-150mm F4.0-5.6 R");
        hashMap.put("0 15 00", "Olympus Zuiko Digital ED 7-14mm F4.0");
        hashMap.put("0 15 10", "Olympus M.Zuiko Digital ED 75mm F1.8");
        hashMap.put("0 16 10", "Olympus M.Zuiko Digital 17mm F1.8");
        hashMap.put("0 17 00", "Olympus Zuiko Digital Pro ED 35-100mm F2.0");
        hashMap.put("0 18 00", "Olympus Zuiko Digital 14-45mm F3.5-5.6");
        hashMap.put("0 18 10", "Olympus M.Zuiko Digital ED 75-300mm F4.8-6.7 II");
        hashMap.put("0 19 10", "Olympus M.Zuiko Digital ED 12-40mm F2.8 Pro");
        hashMap.put("0 20 00", "Olympus Zuiko Digital 35mm F3.5 Macro");
        hashMap.put("0 20 10", "Olympus M.Zuiko Digital ED 40-150mm F2.8 Pro");
        hashMap.put("0 21 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6 EZ");
        hashMap.put("0 22 00", "Olympus Zuiko Digital 17.5-45mm F3.5-5.6");
        hashMap.put("0 22 10", "Olympus M.Zuiko Digital 25mm F1.8");
        hashMap.put("0 23 00", "Olympus Zuiko Digital ED 14-42mm F3.5-5.6");
        hashMap.put("0 23 10", "Olympus M.Zuiko Digital ED 7-14mm F2.8 Pro");
        hashMap.put("0 24 00", "Olympus Zuiko Digital ED 40-150mm F4.0-5.6");
        hashMap.put("0 24 10", "Olympus M.Zuiko Digital ED 300mm F4.0 IS Pro");
        hashMap.put("0 25 10", "Olympus M.Zuiko Digital ED 8mm F1.8 Fisheye Pro");
        hashMap.put("0 30 00", "Olympus Zuiko Digital ED 50-200mm F2.8-3.5 SWD");
        hashMap.put("0 31 00", "Olympus Zuiko Digital ED 12-60mm F2.8-4.0 SWD");
        hashMap.put("0 32 00", "Olympus Zuiko Digital ED 14-35mm F2.0 SWD");
        hashMap.put("0 33 00", "Olympus Zuiko Digital 25mm F2.8");
        hashMap.put("0 34 00", "Olympus Zuiko Digital ED 9-18mm F4.0-5.6");
        hashMap.put("0 35 00", "Olympus Zuiko Digital 14-54mm F2.8-3.5 II");
        hashMap.put("1 01 00", "Sigma 18-50mm F3.5-5.6 DC");
        hashMap.put("1 01 10", "Sigma 30mm F2.8 EX DN");
        hashMap.put("1 02 00", "Sigma 55-200mm F4.0-5.6 DC");
        hashMap.put("1 02 10", "Sigma 19mm F2.8 EX DN");
        hashMap.put("1 03 00", "Sigma 18-125mm F3.5-5.6 DC");
        hashMap.put("1 03 10", "Sigma 30mm F2.8 DN | A");
        hashMap.put("1 04 00", "Sigma 18-125mm F3.5-5.6 DC");
        hashMap.put("1 04 10", "Sigma 19mm F2.8 DN | A");
        hashMap.put("1 05 00", "Sigma 30mm F1.4 EX DC HSM");
        hashMap.put("1 05 10", "Sigma 60mm F2.8 DN | A");
        hashMap.put("1 06 00", "Sigma APO 50-500mm F4.0-6.3 EX DG HSM");
        hashMap.put("1 07 00", "Sigma Macro 105mm F2.8 EX DG");
        hashMap.put("1 08 00", "Sigma APO Macro 150mm F2.8 EX DG HSM");
        hashMap.put("1 09 00", "Sigma 18-50mm F2.8 EX DC Macro");
        hashMap.put("1 10 00", "Sigma 24mm F1.8 EX DG Aspherical Macro");
        hashMap.put("1 11 00", "Sigma APO 135-400mm F4.5-5.6 DG");
        hashMap.put("1 12 00", "Sigma APO 300-800mm F5.6 EX DG HSM");
        hashMap.put("1 13 00", "Sigma 30mm F1.4 EX DC HSM");
        hashMap.put("1 14 00", "Sigma APO 50-500mm F4.0-6.3 EX DG HSM");
        hashMap.put("1 15 00", "Sigma 10-20mm F4.0-5.6 EX DC HSM");
        hashMap.put("1 16 00", "Sigma APO 70-200mm F2.8 II EX DG Macro HSM");
        hashMap.put("1 17 00", "Sigma 50mm F1.4 EX DG HSM");
        hashMap.put("2 01 00", "Leica D Vario Elmarit 14-50mm F2.8-3.5 Asph.");
        hashMap.put("2 01 10", "Lumix G Vario 14-45mm F3.5-5.6 Asph. Mega OIS");
        hashMap.put("2 02 00", "Leica D Summilux 25mm F1.4 Asph.");
        hashMap.put("2 02 10", "Lumix G Vario 45-200mm F4.0-5.6 Mega OIS");
        hashMap.put("2 03 00", "Leica D Vario Elmar 14-50mm F3.8-5.6 Asph. Mega OIS");
        hashMap.put("2 03 01", "Leica D Vario Elmar 14-50mm F3.8-5.6 Asph.");
        hashMap.put("2 03 10", "Lumix G Vario HD 14-140mm F4.0-5.8 Asph. Mega OIS");
        hashMap.put("2 04 00", "Leica D Vario Elmar 14-150mm F3.5-5.6");
        hashMap.put("2 04 10", "Lumix G Vario 7-14mm F4.0 Asph.");
        hashMap.put("2 05 10", "Lumix G 20mm F1.7 Asph.");
        hashMap.put("2 06 10", "Leica DG Macro-Elmarit 45mm F2.8 Asph. Mega OIS");
        hashMap.put("2 07 10", "Lumix G Vario 14-42mm F3.5-5.6 Asph. Mega OIS");
        hashMap.put("2 08 10", "Lumix G Fisheye 8mm F3.5");
        hashMap.put("2 09 10", "Lumix G Vario 100-300mm F4.0-5.6 Mega OIS");
        hashMap.put("2 10 10", "Lumix G 14mm F2.5 Asph.");
        hashMap.put("2 11 10", "Lumix G 12.5mm F12 3D");
        hashMap.put("2 12 10", "Leica DG Summilux 25mm F1.4 Asph.");
        hashMap.put("2 13 10", "Lumix G X Vario PZ 45-175mm F4.0-5.6 Asph. Power OIS");
        hashMap.put("2 14 10", "Lumix G X Vario PZ 14-42mm F3.5-5.6 Asph. Power OIS");
        hashMap.put("2 15 10", "Lumix G X Vario 12-35mm F2.8 Asph. Power OIS");
        hashMap.put("2 16 10", "Lumix G Vario 45-150mm F4.0-5.6 Asph. Mega OIS");
        hashMap.put("2 17 10", "Lumix G X Vario 35-100mm F2.8 Power OIS");
        hashMap.put("2 18 10", "Lumix G Vario 14-42mm F3.5-5.6 II Asph. Mega OIS");
        hashMap.put("2 19 10", "Lumix G Vario 14-140mm F3.5-5.6 Asph. Power OIS");
        hashMap.put("2 20 10", "Lumix G Vario 12-32mm F3.5-5.6 Asph. Mega OIS");
        hashMap.put("2 21 10", "Leica DG Nocticron 42.5mm F1.2 Asph. Power OIS");
        hashMap.put("2 22 10", "Leica DG Summilux 15mm F1.7 Asph.");
        hashMap.put("2 24 10", "Lumix G Macro 30mm F2.8 Asph. Mega OIS");
        hashMap.put("2 25 10", "Lumix G 42.5mm F1.7 Asph. Power OIS");
        hashMap.put("3 01 00", "Leica D Vario Elmarit 14-50mm F2.8-3.5 Asph.");
        hashMap.put("3 02 00", "Leica D Summilux 25mm F1.4 Asph.");
        hashMap.put("5 01 10", "Tamron 14-150mm F3.5-5.8 Di III");
        hashMap2.put("0 00", "None");
        hashMap2.put("0 04", "Olympus Zuiko Digital EC-14 1.4x Teleconverter");
        hashMap2.put("0 08", "Olympus EX-25 Extension Tube");
        hashMap2.put("0 10", "Olympus Zuiko Digital EC-20 2.0x Teleconverter");
    }
}
