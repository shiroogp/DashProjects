package com.arthenica.ffmpegkit;

import android.os.Build;
import android.util.Log;
import com.arthenica.smartexception.java.Exceptions;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NativeLoader {
    static final String[] FFMPEG_LIBRARIES = {"avutil", "swscale", "swresample", "avcodec", "avformat", "avfilter", "avdevice"};
    static final String[] LIBRARIES_LINKED_WITH_CXX = {"openh264", "rubberband", "snappy", "srt", "tesseract", "x265", "zimg"};

    static boolean isTestModeDisabled() {
        return System.getProperty("enable.ffmpeg.kit.test.mode") == null;
    }

    private static void loadLibrary(String str) {
        if (isTestModeDisabled()) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e) {
                throw new Error(String.format("FFmpegKit failed to start on %s.", new Object[]{getDeviceDebugInformation()}), e);
            }
        }
    }

    private static List<String> loadExternalLibraries() {
        if (isTestModeDisabled()) {
            return Packages.getExternalLibraries();
        }
        return Collections.emptyList();
    }

    private static String loadNativeAbi() {
        if (isTestModeDisabled()) {
            return AbiDetect.getNativeAbi();
        }
        return Abi.ABI_X86_64.getName();
    }

    static String loadAbi() {
        if (isTestModeDisabled()) {
            return AbiDetect.getAbi();
        }
        return Abi.ABI_X86_64.getName();
    }

    static String loadPackageName() {
        return isTestModeDisabled() ? Packages.getPackageName() : "test";
    }

    static String loadVersion() {
        if (isTestModeDisabled()) {
            return FFmpegKitConfig.getVersion();
        }
        if (!loadIsLTSBuild()) {
            return "4.5.1";
        }
        return String.format("%s-lts", new Object[]{"4.5.1"});
    }

    static boolean loadIsLTSBuild() {
        if (isTestModeDisabled()) {
            return AbiDetect.isNativeLTSBuild();
        }
        return true;
    }

    static int loadLogLevel() {
        if (isTestModeDisabled()) {
            return FFmpegKitConfig.getNativeLogLevel();
        }
        return Level.AV_LOG_DEBUG.getValue();
    }

    static String loadBuildDate() {
        if (isTestModeDisabled()) {
            return FFmpegKitConfig.getBuildDate();
        }
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
    }

    static void enableRedirection() {
        if (isTestModeDisabled()) {
            FFmpegKitConfig.enableRedirection();
        }
    }

    static void loadFFmpegKitAbiDetect() {
        loadLibrary("ffmpegkit_abidetect");
    }

    static boolean loadFFmpeg() {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21) {
            return false;
        }
        List<String> loadExternalLibraries = loadExternalLibraries();
        String[] strArr = LIBRARIES_LINKED_WITH_CXX;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (loadExternalLibraries.contains(strArr[i])) {
                loadLibrary("c++_shared");
                break;
            } else {
                i++;
            }
        }
        boolean z2 = true;
        if ("arm-v7a".equals(loadNativeAbi())) {
            try {
                String[] strArr2 = FFMPEG_LIBRARIES;
                int length2 = strArr2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    loadLibrary(strArr2[i2] + "_neon");
                }
                z = false;
            } catch (Error e) {
                Log.i("ffmpeg-kit", String.format("NEON supported armeabi-v7a ffmpeg library not found. Loading default armeabi-v7a library.%s", new Object[]{Exceptions.getStackTraceString(e)}));
                z = true;
                z2 = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        if (!z2) {
            for (String loadLibrary : FFMPEG_LIBRARIES) {
                loadLibrary(loadLibrary);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void loadFFmpegKit(boolean r3) {
        /*
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L_0x0033
            java.lang.String r3 = loadNativeAbi()
            java.lang.String r2 = "arm-v7a"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0033
            java.lang.String r3 = "ffmpegkit_armv7a_neon"
            loadLibrary(r3)     // Catch:{ Error -> 0x001c }
            com.arthenica.ffmpegkit.AbiDetect.setArmV7aNeonLoaded()     // Catch:{ Error -> 0x0019 }
            goto L_0x0034
        L_0x0019:
            r3 = move-exception
            r2 = r0
            goto L_0x001e
        L_0x001c:
            r3 = move-exception
            r2 = r1
        L_0x001e:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = com.arthenica.smartexception.java.Exceptions.getStackTraceString(r3)
            r0[r1] = r3
            java.lang.String r3 = "NEON supported armeabi-v7a ffmpegkit library not found. Loading default armeabi-v7a library.%s"
            java.lang.String r3 = java.lang.String.format(r3, r0)
            java.lang.String r0 = "ffmpeg-kit"
            android.util.Log.i(r0, r3)
            r0 = r2
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            if (r0 != 0) goto L_0x003b
            java.lang.String r3 = "ffmpegkit"
            loadLibrary(r3)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arthenica.ffmpegkit.NativeLoader.loadFFmpegKit(boolean):void");
    }

    static String getDeviceDebugInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("brand: ");
        sb.append(Build.BRAND);
        sb.append(", model: ");
        sb.append(Build.MODEL);
        sb.append(", device: ");
        sb.append(Build.DEVICE);
        sb.append(", api level: ");
        sb.append(Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= 21) {
            sb.append(", abis: ");
            sb.append(FFmpegKitConfig.argumentsToString(Build.SUPPORTED_ABIS));
            sb.append(", 32bit abis: ");
            sb.append(FFmpegKitConfig.argumentsToString(Build.SUPPORTED_32_BIT_ABIS));
            sb.append(", 64bit abis: ");
            sb.append(FFmpegKitConfig.argumentsToString(Build.SUPPORTED_64_BIT_ABIS));
        } else {
            sb.append(", cpu abis: ");
            sb.append(Build.CPU_ABI);
            sb.append(", cpu abi2s: ");
            sb.append(Build.CPU_ABI2);
        }
        return sb.toString();
    }
}
