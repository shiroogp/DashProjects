package com.arthenica.ffmpegkit;

import com.brentvatne.react.ReactVideoView;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class FFprobeKit {
    private static String[] defaultGetMediaInformationCommandArguments(String str) {
        return new String[]{"-v", ReactVideoView.EVENT_PROP_ERROR, "-hide_banner", "-print_format", "json", "-show_format", "-show_streams", "-show_chapters", "-i", str};
    }

    static {
        Class<AbiDetect> cls = AbiDetect.class;
        Class<FFmpegKitConfig> cls2 = FFmpegKitConfig.class;
    }

    private FFprobeKit() {
    }

    public static FFprobeSession executeWithArguments(String[] strArr) {
        FFprobeSession fFprobeSession = new FFprobeSession(strArr);
        FFmpegKitConfig.ffprobeExecute(fFprobeSession);
        return fFprobeSession;
    }

    public static FFprobeSession executeWithArgumentsAsync(String[] strArr, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback) {
        FFprobeSession fFprobeSession = new FFprobeSession(strArr, fFprobeSessionCompleteCallback);
        FFmpegKitConfig.asyncFFprobeExecute(fFprobeSession);
        return fFprobeSession;
    }

    public static FFprobeSession executeWithArgumentsAsync(String[] strArr, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback, LogCallback logCallback) {
        FFprobeSession fFprobeSession = new FFprobeSession(strArr, fFprobeSessionCompleteCallback, logCallback);
        FFmpegKitConfig.asyncFFprobeExecute(fFprobeSession);
        return fFprobeSession;
    }

    public static FFprobeSession executeWithArgumentsAsync(String[] strArr, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback, ExecutorService executorService) {
        FFprobeSession fFprobeSession = new FFprobeSession(strArr, fFprobeSessionCompleteCallback);
        FFmpegKitConfig.asyncFFprobeExecute(fFprobeSession, executorService);
        return fFprobeSession;
    }

    public static FFprobeSession executeWithArgumentsAsync(String[] strArr, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback, LogCallback logCallback, ExecutorService executorService) {
        FFprobeSession fFprobeSession = new FFprobeSession(strArr, fFprobeSessionCompleteCallback, logCallback);
        FFmpegKitConfig.asyncFFprobeExecute(fFprobeSession, executorService);
        return fFprobeSession;
    }

    public static FFprobeSession execute(String str) {
        return executeWithArguments(FFmpegKitConfig.parseArguments(str));
    }

    public static FFprobeSession executeAsync(String str, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback) {
        return executeWithArgumentsAsync(FFmpegKitConfig.parseArguments(str), fFprobeSessionCompleteCallback);
    }

    public static FFprobeSession executeAsync(String str, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback, LogCallback logCallback) {
        return executeWithArgumentsAsync(FFmpegKitConfig.parseArguments(str), fFprobeSessionCompleteCallback, logCallback);
    }

    public static FFprobeSession executeAsync(String str, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback, ExecutorService executorService) {
        FFprobeSession fFprobeSession = new FFprobeSession(FFmpegKitConfig.parseArguments(str), fFprobeSessionCompleteCallback);
        FFmpegKitConfig.asyncFFprobeExecute(fFprobeSession, executorService);
        return fFprobeSession;
    }

    public static FFprobeSession executeAsync(String str, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback, LogCallback logCallback, ExecutorService executorService) {
        FFprobeSession fFprobeSession = new FFprobeSession(FFmpegKitConfig.parseArguments(str), fFprobeSessionCompleteCallback, logCallback);
        FFmpegKitConfig.asyncFFprobeExecute(fFprobeSession, executorService);
        return fFprobeSession;
    }

    public static MediaInformationSession getMediaInformation(String str) {
        MediaInformationSession mediaInformationSession = new MediaInformationSession(defaultGetMediaInformationCommandArguments(str));
        FFmpegKitConfig.getMediaInformationExecute(mediaInformationSession, AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT);
        return mediaInformationSession;
    }

    public static MediaInformationSession getMediaInformation(String str, int i) {
        MediaInformationSession mediaInformationSession = new MediaInformationSession(defaultGetMediaInformationCommandArguments(str));
        FFmpegKitConfig.getMediaInformationExecute(mediaInformationSession, i);
        return mediaInformationSession;
    }

    public static MediaInformationSession getMediaInformationAsync(String str, MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback) {
        MediaInformationSession mediaInformationSession = new MediaInformationSession(defaultGetMediaInformationCommandArguments(str), mediaInformationSessionCompleteCallback);
        FFmpegKitConfig.asyncGetMediaInformationExecute(mediaInformationSession, AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT);
        return mediaInformationSession;
    }

    public static MediaInformationSession getMediaInformationAsync(String str, MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback, LogCallback logCallback, int i) {
        MediaInformationSession mediaInformationSession = new MediaInformationSession(defaultGetMediaInformationCommandArguments(str), mediaInformationSessionCompleteCallback, logCallback);
        FFmpegKitConfig.asyncGetMediaInformationExecute(mediaInformationSession, i);
        return mediaInformationSession;
    }

    public static MediaInformationSession getMediaInformationAsync(String str, MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback, ExecutorService executorService) {
        MediaInformationSession mediaInformationSession = new MediaInformationSession(defaultGetMediaInformationCommandArguments(str), mediaInformationSessionCompleteCallback);
        FFmpegKitConfig.asyncGetMediaInformationExecute(mediaInformationSession, executorService, AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT);
        return mediaInformationSession;
    }

    public static MediaInformationSession getMediaInformationAsync(String str, MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback, LogCallback logCallback, ExecutorService executorService, int i) {
        MediaInformationSession mediaInformationSession = new MediaInformationSession(defaultGetMediaInformationCommandArguments(str), mediaInformationSessionCompleteCallback, logCallback);
        FFmpegKitConfig.asyncGetMediaInformationExecute(mediaInformationSession, executorService, i);
        return mediaInformationSession;
    }

    public static MediaInformationSession getMediaInformationFromCommand(String str) {
        MediaInformationSession mediaInformationSession = new MediaInformationSession(FFmpegKitConfig.parseArguments(str));
        FFmpegKitConfig.getMediaInformationExecute(mediaInformationSession, AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT);
        return mediaInformationSession;
    }

    public static MediaInformationSession getMediaInformationFromCommandAsync(String str, MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback, LogCallback logCallback, int i) {
        return getMediaInformationFromCommandArgumentsAsync(FFmpegKitConfig.parseArguments(str), mediaInformationSessionCompleteCallback, logCallback, i);
    }

    private static MediaInformationSession getMediaInformationFromCommandArgumentsAsync(String[] strArr, MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback, LogCallback logCallback, int i) {
        MediaInformationSession mediaInformationSession = new MediaInformationSession(strArr, mediaInformationSessionCompleteCallback, logCallback);
        FFmpegKitConfig.asyncGetMediaInformationExecute(mediaInformationSession, i);
        return mediaInformationSession;
    }

    public static List<FFprobeSession> listFFprobeSessions() {
        return FFmpegKitConfig.getFFprobeSessions();
    }

    public static List<MediaInformationSession> listMediaInformationSessions() {
        return FFmpegKitConfig.getMediaInformationSessions();
    }
}
