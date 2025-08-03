package com.arthenica.ffmpegkit;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class FFmpegKit {
    static {
        Class<AbiDetect> cls = AbiDetect.class;
        Class<FFmpegKitConfig> cls2 = FFmpegKitConfig.class;
    }

    private FFmpegKit() {
    }

    public static FFmpegSession executeWithArguments(String[] strArr) {
        FFmpegSession fFmpegSession = new FFmpegSession(strArr);
        FFmpegKitConfig.ffmpegExecute(fFmpegSession);
        return fFmpegSession;
    }

    public static FFmpegSession executeWithArgumentsAsync(String[] strArr, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback) {
        FFmpegSession fFmpegSession = new FFmpegSession(strArr, fFmpegSessionCompleteCallback);
        FFmpegKitConfig.asyncFFmpegExecute(fFmpegSession);
        return fFmpegSession;
    }

    public static FFmpegSession executeWithArgumentsAsync(String[] strArr, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback, LogCallback logCallback, StatisticsCallback statisticsCallback) {
        FFmpegSession fFmpegSession = new FFmpegSession(strArr, fFmpegSessionCompleteCallback, logCallback, statisticsCallback);
        FFmpegKitConfig.asyncFFmpegExecute(fFmpegSession);
        return fFmpegSession;
    }

    public static FFmpegSession executeWithArgumentsAsync(String[] strArr, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback, ExecutorService executorService) {
        FFmpegSession fFmpegSession = new FFmpegSession(strArr, fFmpegSessionCompleteCallback);
        FFmpegKitConfig.asyncFFmpegExecute(fFmpegSession, executorService);
        return fFmpegSession;
    }

    public static FFmpegSession executeWithArgumentsAsync(String[] strArr, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback, LogCallback logCallback, StatisticsCallback statisticsCallback, ExecutorService executorService) {
        FFmpegSession fFmpegSession = new FFmpegSession(strArr, fFmpegSessionCompleteCallback, logCallback, statisticsCallback);
        FFmpegKitConfig.asyncFFmpegExecute(fFmpegSession, executorService);
        return fFmpegSession;
    }

    public static FFmpegSession execute(String str) {
        return executeWithArguments(FFmpegKitConfig.parseArguments(str));
    }

    public static FFmpegSession executeAsync(String str, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback) {
        return executeWithArgumentsAsync(FFmpegKitConfig.parseArguments(str), fFmpegSessionCompleteCallback);
    }

    public static FFmpegSession executeAsync(String str, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback, LogCallback logCallback, StatisticsCallback statisticsCallback) {
        return executeWithArgumentsAsync(FFmpegKitConfig.parseArguments(str), fFmpegSessionCompleteCallback, logCallback, statisticsCallback);
    }

    public static FFmpegSession executeAsync(String str, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback, ExecutorService executorService) {
        FFmpegSession fFmpegSession = new FFmpegSession(FFmpegKitConfig.parseArguments(str), fFmpegSessionCompleteCallback);
        FFmpegKitConfig.asyncFFmpegExecute(fFmpegSession, executorService);
        return fFmpegSession;
    }

    public static FFmpegSession executeAsync(String str, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback, LogCallback logCallback, StatisticsCallback statisticsCallback, ExecutorService executorService) {
        FFmpegSession fFmpegSession = new FFmpegSession(FFmpegKitConfig.parseArguments(str), fFmpegSessionCompleteCallback, logCallback, statisticsCallback);
        FFmpegKitConfig.asyncFFmpegExecute(fFmpegSession, executorService);
        return fFmpegSession;
    }

    public static void cancel() {
        FFmpegKitConfig.nativeFFmpegCancel(0);
    }

    public static void cancel(long j) {
        FFmpegKitConfig.nativeFFmpegCancel(j);
    }

    public static List<FFmpegSession> listSessions() {
        return FFmpegKitConfig.getFFmpegSessions();
    }
}
