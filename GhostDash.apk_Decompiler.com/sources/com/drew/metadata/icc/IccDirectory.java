package com.drew.metadata.icc;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class IccDirectory extends Directory {
    public static final int TAG_APPLE_MULTI_LANGUAGE_PROFILE_NAME = 1685283693;
    public static final int TAG_CMM_FLAGS = 44;
    public static final int TAG_CMM_TYPE = 4;
    public static final int TAG_COLOR_SPACE = 16;
    public static final int TAG_DEVICE_ATTR = 56;
    public static final int TAG_DEVICE_MAKE = 48;
    public static final int TAG_DEVICE_MODEL = 52;
    public static final int TAG_PLATFORM = 40;
    public static final int TAG_PROFILE_BYTE_COUNT = 0;
    public static final int TAG_PROFILE_CLASS = 12;
    public static final int TAG_PROFILE_CONNECTION_SPACE = 20;
    public static final int TAG_PROFILE_CREATOR = 80;
    public static final int TAG_PROFILE_DATETIME = 24;
    public static final int TAG_PROFILE_VERSION = 8;
    public static final int TAG_RENDERING_INTENT = 64;
    public static final int TAG_SIGNATURE = 36;
    public static final int TAG_TAG_A2B0 = 1093812784;
    public static final int TAG_TAG_A2B1 = 1093812785;
    public static final int TAG_TAG_A2B2 = 1093812786;
    public static final int TAG_TAG_B2A0 = 1110589744;
    public static final int TAG_TAG_B2A1 = 1110589745;
    public static final int TAG_TAG_B2A2 = 1110589746;
    public static final int TAG_TAG_COUNT = 128;
    public static final int TAG_TAG_bTRC = 1649693251;
    public static final int TAG_TAG_bXYZ = 1649957210;
    public static final int TAG_TAG_bfd = 1650877472;
    public static final int TAG_TAG_bkpt = 1651208308;
    public static final int TAG_TAG_calt = 1667329140;
    public static final int TAG_TAG_chad = 1667785060;
    public static final int TAG_TAG_chrm = 1667789421;
    public static final int TAG_TAG_cprt = 1668313716;
    public static final int TAG_TAG_crdi = 1668441193;
    public static final int TAG_TAG_desc = 1684370275;
    public static final int TAG_TAG_devs = 1684371059;
    public static final int TAG_TAG_dmdd = 1684890724;
    public static final int TAG_TAG_dmnd = 1684893284;
    public static final int TAG_TAG_gTRC = 1733579331;
    public static final int TAG_TAG_gXYZ = 1733843290;
    public static final int TAG_TAG_gamt = 1734438260;
    public static final int TAG_TAG_kTRC = 1800688195;
    public static final int TAG_TAG_lumi = 1819635049;
    public static final int TAG_TAG_meas = 1835360627;
    public static final int TAG_TAG_ncl2 = 1852009522;
    public static final int TAG_TAG_ncol = 1852010348;
    public static final int TAG_TAG_pre0 = 1886545200;
    public static final int TAG_TAG_pre1 = 1886545201;
    public static final int TAG_TAG_pre2 = 1886545202;
    public static final int TAG_TAG_ps2i = 1886597737;
    public static final int TAG_TAG_ps2s = 1886597747;
    public static final int TAG_TAG_psd0 = 1886610480;
    public static final int TAG_TAG_psd1 = 1886610481;
    public static final int TAG_TAG_psd2 = 1886610482;
    public static final int TAG_TAG_psd3 = 1886610483;
    public static final int TAG_TAG_pseq = 1886610801;
    public static final int TAG_TAG_rTRC = 1918128707;
    public static final int TAG_TAG_rXYZ = 1918392666;
    public static final int TAG_TAG_resp = 1919251312;
    public static final int TAG_TAG_scrd = 1935897188;
    public static final int TAG_TAG_scrn = 1935897198;
    public static final int TAG_TAG_targ = 1952543335;
    public static final int TAG_TAG_tech = 1952801640;
    public static final int TAG_TAG_view = 1986618743;
    public static final int TAG_TAG_vued = 1987405156;
    public static final int TAG_TAG_wtpt = 2004119668;
    public static final int TAG_XYZ_VALUES = 68;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "ICC Profile";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Profile Size");
        hashMap.put(4, "CMM Type");
        hashMap.put(8, "Version");
        hashMap.put(12, "Class");
        hashMap.put(16, "Color space");
        hashMap.put(20, "Profile Connection Space");
        hashMap.put(24, "Profile Date/Time");
        hashMap.put(36, "Signature");
        hashMap.put(40, "Primary Platform");
        hashMap.put(44, "CMM Flags");
        hashMap.put(48, "Device manufacturer");
        hashMap.put(52, "Device model");
        hashMap.put(56, "Device attributes");
        hashMap.put(64, "Rendering Intent");
        hashMap.put(68, "XYZ values");
        hashMap.put(80, "Profile Creator");
        hashMap.put(128, "Tag Count");
        hashMap.put(Integer.valueOf(TAG_TAG_A2B0), "AToB 0");
        hashMap.put(Integer.valueOf(TAG_TAG_A2B1), "AToB 1");
        hashMap.put(Integer.valueOf(TAG_TAG_A2B2), "AToB 2");
        hashMap.put(Integer.valueOf(TAG_TAG_bXYZ), "Blue Colorant");
        hashMap.put(Integer.valueOf(TAG_TAG_bTRC), "Blue TRC");
        hashMap.put(Integer.valueOf(TAG_TAG_B2A0), "BToA 0");
        hashMap.put(Integer.valueOf(TAG_TAG_B2A1), "BToA 1");
        hashMap.put(Integer.valueOf(TAG_TAG_B2A2), "BToA 2");
        hashMap.put(Integer.valueOf(TAG_TAG_calt), "Calibration Date/Time");
        hashMap.put(Integer.valueOf(TAG_TAG_targ), "Char Target");
        hashMap.put(Integer.valueOf(TAG_TAG_chad), "Chromatic Adaptation");
        hashMap.put(Integer.valueOf(TAG_TAG_chrm), "Chromaticity");
        hashMap.put(Integer.valueOf(TAG_TAG_cprt), ExifInterface.TAG_COPYRIGHT);
        hashMap.put(Integer.valueOf(TAG_TAG_crdi), "CrdInfo");
        hashMap.put(Integer.valueOf(TAG_TAG_dmnd), "Device Mfg Description");
        hashMap.put(Integer.valueOf(TAG_TAG_dmdd), "Device Model Description");
        hashMap.put(Integer.valueOf(TAG_TAG_devs), "Device Settings");
        hashMap.put(Integer.valueOf(TAG_TAG_gamt), "Gamut");
        hashMap.put(Integer.valueOf(TAG_TAG_kTRC), "Gray TRC");
        hashMap.put(Integer.valueOf(TAG_TAG_gXYZ), "Green Colorant");
        hashMap.put(Integer.valueOf(TAG_TAG_gTRC), "Green TRC");
        hashMap.put(Integer.valueOf(TAG_TAG_lumi), "Luminance");
        hashMap.put(Integer.valueOf(TAG_TAG_meas), "Measurement");
        hashMap.put(Integer.valueOf(TAG_TAG_bkpt), "Media Black Point");
        hashMap.put(Integer.valueOf(TAG_TAG_wtpt), "Media White Point");
        hashMap.put(Integer.valueOf(TAG_TAG_ncol), "Named Color");
        hashMap.put(Integer.valueOf(TAG_TAG_ncl2), "Named Color 2");
        hashMap.put(Integer.valueOf(TAG_TAG_resp), "Output Response");
        hashMap.put(Integer.valueOf(TAG_TAG_pre0), "Preview 0");
        hashMap.put(Integer.valueOf(TAG_TAG_pre1), "Preview 1");
        hashMap.put(Integer.valueOf(TAG_TAG_pre2), "Preview 2");
        hashMap.put(Integer.valueOf(TAG_TAG_desc), "Profile Description");
        hashMap.put(Integer.valueOf(TAG_TAG_pseq), "Profile Sequence Description");
        hashMap.put(Integer.valueOf(TAG_TAG_psd0), "Ps2 CRD 0");
        hashMap.put(Integer.valueOf(TAG_TAG_psd1), "Ps2 CRD 1");
        hashMap.put(Integer.valueOf(TAG_TAG_psd2), "Ps2 CRD 2");
        hashMap.put(Integer.valueOf(TAG_TAG_psd3), "Ps2 CRD 3");
        hashMap.put(Integer.valueOf(TAG_TAG_ps2s), "Ps2 CSA");
        hashMap.put(Integer.valueOf(TAG_TAG_ps2i), "Ps2 Rendering Intent");
        hashMap.put(Integer.valueOf(TAG_TAG_rXYZ), "Red Colorant");
        hashMap.put(Integer.valueOf(TAG_TAG_rTRC), "Red TRC");
        hashMap.put(Integer.valueOf(TAG_TAG_scrd), "Screening Desc");
        hashMap.put(Integer.valueOf(TAG_TAG_scrn), "Screening");
        hashMap.put(Integer.valueOf(TAG_TAG_tech), "Technology");
        hashMap.put(Integer.valueOf(TAG_TAG_bfd), "Ucrbg");
        hashMap.put(Integer.valueOf(TAG_TAG_vued), "Viewing Conditions Description");
        hashMap.put(Integer.valueOf(TAG_TAG_view), "Viewing Conditions");
        hashMap.put(Integer.valueOf(TAG_APPLE_MULTI_LANGUAGE_PROFILE_NAME), "Apple Multi-language Profile Name");
    }

    public IccDirectory() {
        setDescriptor(new IccDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
