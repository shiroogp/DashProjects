package com.arthenica.ffmpegkit;

public class AbiDetect {
    static final String ARM_V7A = "arm-v7a";
    static final String ARM_V7A_NEON = "arm-v7a-neon";
    private static boolean armV7aNeonLoaded = false;

    static native String getNativeAbi();

    static native String getNativeBuildConf();

    static native String getNativeCpuAbi();

    static native boolean isNativeLTSBuild();

    static {
        NativeLoader.loadFFmpegKitAbiDetect();
        Class<FFmpegKit> cls = FFmpegKit.class;
        Class<FFmpegKitConfig> cls2 = FFmpegKitConfig.class;
        Class<FFprobeKit> cls3 = FFprobeKit.class;
    }

    private AbiDetect() {
    }

    static void setArmV7aNeonLoaded() {
        armV7aNeonLoaded = true;
    }

    public static String getAbi() {
        if (armV7aNeonLoaded) {
            return ARM_V7A_NEON;
        }
        return getNativeAbi();
    }

    public static String getCpuAbi() {
        return getNativeCpuAbi();
    }
}
