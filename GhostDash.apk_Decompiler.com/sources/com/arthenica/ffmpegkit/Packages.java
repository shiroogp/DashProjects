package com.arthenica.ffmpegkit;

import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Packages {
    private static final List<String> supportedExternalLibraries;

    static {
        ArrayList arrayList = new ArrayList();
        supportedExternalLibraries = arrayList;
        arrayList.add("dav1d");
        arrayList.add("fontconfig");
        arrayList.add("freetype");
        arrayList.add("fribidi");
        arrayList.add("gmp");
        arrayList.add("gnutls");
        arrayList.add("kvazaar");
        arrayList.add("mp3lame");
        arrayList.add("libass");
        arrayList.add("iconv");
        arrayList.add("libilbc");
        arrayList.add("libtheora");
        arrayList.add("libvidstab");
        arrayList.add("libvorbis");
        arrayList.add("libvpx");
        arrayList.add("libwebp");
        arrayList.add("libxml2");
        arrayList.add("opencore-amr");
        arrayList.add("openh264");
        arrayList.add("openssl");
        arrayList.add("opus");
        arrayList.add("rubberband");
        arrayList.add("sdl2");
        arrayList.add("shine");
        arrayList.add("snappy");
        arrayList.add("soxr");
        arrayList.add("speex");
        arrayList.add("srt");
        arrayList.add("tesseract");
        arrayList.add("twolame");
        arrayList.add("x264");
        arrayList.add("x265");
        arrayList.add("xvid");
        arrayList.add("zimg");
    }

    public static String getPackageName() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        List<String> externalLibraries = getExternalLibraries();
        boolean contains = externalLibraries.contains("speex");
        boolean contains2 = externalLibraries.contains("fribidi");
        boolean contains3 = externalLibraries.contains("gnutls");
        boolean contains4 = externalLibraries.contains("xvid");
        boolean z6 = true;
        boolean z7 = false;
        if (!contains || !contains2) {
            if (contains) {
                z4 = true;
                z5 = false;
                z3 = false;
            } else {
                if (contains2) {
                    z5 = true;
                    z4 = false;
                } else if (contains4) {
                    if (contains3) {
                        z3 = true;
                        z5 = false;
                        z4 = false;
                        z2 = false;
                        z6 = z2;
                        z = z6;
                    } else {
                        z = true;
                        z5 = false;
                        z4 = false;
                        z3 = false;
                        z2 = false;
                        z6 = false;
                    }
                } else if (contains3) {
                    z2 = true;
                    z5 = false;
                    z4 = false;
                    z3 = false;
                    z6 = false;
                    z = z6;
                } else {
                    z5 = false;
                    z4 = false;
                }
                z3 = z4;
            }
            z2 = z3;
            z6 = z2;
            z = z6;
        } else if (contains4) {
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        } else {
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
            z7 = true;
            z6 = false;
        }
        boolean z8 = z;
        boolean z9 = z2;
        boolean z10 = z3;
        boolean z11 = z4;
        boolean z12 = z5;
        boolean z13 = z7;
        Object obj = "xvid";
        Object obj2 = "x265";
        Object obj3 = "x264";
        Object obj4 = "speex";
        Object obj5 = "shine";
        if (!z6) {
            Object obj6 = obj;
            Object obj7 = obj2;
            Object obj8 = obj3;
            Object obj9 = obj5;
            Object obj10 = "libvidstab";
            Object obj11 = obj4;
            if (z13) {
                if (!externalLibraries.contains("dav1d") || !externalLibraries.contains("fontconfig") || !externalLibraries.contains("freetype") || !externalLibraries.contains("fribidi") || !externalLibraries.contains("gmp") || !externalLibraries.contains("gnutls") || !externalLibraries.contains("kvazaar") || !externalLibraries.contains("mp3lame") || !externalLibraries.contains("libass") || !externalLibraries.contains("iconv") || !externalLibraries.contains("libilbc") || !externalLibraries.contains("libtheora") || !externalLibraries.contains("libvorbis") || !externalLibraries.contains("libvpx") || !externalLibraries.contains("libwebp") || !externalLibraries.contains("libxml2") || !externalLibraries.contains("opencore-amr") || !externalLibraries.contains("opus") || !externalLibraries.contains(obj9) || !externalLibraries.contains("snappy") || !externalLibraries.contains("soxr") || !externalLibraries.contains(obj11) || !externalLibraries.contains("twolame") || !externalLibraries.contains("zimg")) {
                    return "custom";
                }
                return "full";
            } else if (z12) {
                if (!externalLibraries.contains("dav1d") || !externalLibraries.contains("fontconfig") || !externalLibraries.contains("freetype") || !externalLibraries.contains("fribidi") || !externalLibraries.contains("kvazaar") || !externalLibraries.contains("libass") || !externalLibraries.contains("iconv") || !externalLibraries.contains("libtheora") || !externalLibraries.contains("libvpx") || !externalLibraries.contains("libwebp") || !externalLibraries.contains("snappy") || !externalLibraries.contains("zimg")) {
                    return "custom";
                }
                return "video";
            } else if (z11) {
                if (!externalLibraries.contains("mp3lame") || !externalLibraries.contains("libilbc") || !externalLibraries.contains("libvorbis") || !externalLibraries.contains("opencore-amr") || !externalLibraries.contains("opus") || !externalLibraries.contains(obj9) || !externalLibraries.contains("soxr") || !externalLibraries.contains(obj11) || !externalLibraries.contains("twolame")) {
                    return "custom";
                }
                return "audio";
            } else if (!z10) {
                Object obj12 = obj10;
                Object obj13 = obj7;
                Object obj14 = obj8;
                Object obj15 = obj6;
                if (z9) {
                    if (!externalLibraries.contains("gmp") || !externalLibraries.contains("gnutls")) {
                        return "custom";
                    }
                    return UriUtil.HTTPS_SCHEME;
                } else if (z8) {
                    if (!externalLibraries.contains(obj12) || !externalLibraries.contains(obj14) || !externalLibraries.contains(obj13) || !externalLibraries.contains(obj15)) {
                        return "custom";
                    }
                    return "min-gpl";
                } else if (externalLibraries.size() == 0) {
                    return "min";
                } else {
                    return "custom";
                }
            } else if (!externalLibraries.contains("gmp") || !externalLibraries.contains("gnutls") || !externalLibraries.contains(obj10) || !externalLibraries.contains(obj8) || !externalLibraries.contains(obj7) || !externalLibraries.contains(obj6)) {
                return "custom";
            } else {
                return "https-gpl";
            }
        } else if (!externalLibraries.contains("dav1d") || !externalLibraries.contains("fontconfig") || !externalLibraries.contains("freetype") || !externalLibraries.contains("fribidi") || !externalLibraries.contains("gmp") || !externalLibraries.contains("gnutls") || !externalLibraries.contains("kvazaar") || !externalLibraries.contains("mp3lame") || !externalLibraries.contains("libass") || !externalLibraries.contains("iconv") || !externalLibraries.contains("libilbc") || !externalLibraries.contains("libtheora") || !externalLibraries.contains("libvidstab") || !externalLibraries.contains("libvorbis") || !externalLibraries.contains("libvpx") || !externalLibraries.contains("libwebp") || !externalLibraries.contains("libxml2") || !externalLibraries.contains("opencore-amr") || !externalLibraries.contains("opus") || !externalLibraries.contains(obj5) || !externalLibraries.contains("snappy") || !externalLibraries.contains("soxr") || !externalLibraries.contains(obj4) || !externalLibraries.contains("twolame") || !externalLibraries.contains(obj3) || !externalLibraries.contains(obj2) || !externalLibraries.contains(obj) || !externalLibraries.contains("zimg")) {
            return "custom";
        } else {
            return "full-gpl";
        }
    }

    public static List<String> getExternalLibraries() {
        String nativeBuildConf = AbiDetect.getNativeBuildConf();
        ArrayList arrayList = new ArrayList();
        for (String next : supportedExternalLibraries) {
            if (nativeBuildConf.contains("enable-" + next) || nativeBuildConf.contains("enable-lib" + next)) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
