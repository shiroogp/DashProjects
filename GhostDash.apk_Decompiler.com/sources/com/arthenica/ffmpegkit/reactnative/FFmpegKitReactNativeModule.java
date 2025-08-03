package com.arthenica.ffmpegkit.reactnative;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.arthenica.ffmpegkit.AbiDetect;
import com.arthenica.ffmpegkit.AbstractSession;
import com.arthenica.ffmpegkit.FFmpegKit;
import com.arthenica.ffmpegkit.FFmpegKitConfig;
import com.arthenica.ffmpegkit.FFmpegSession;
import com.arthenica.ffmpegkit.FFmpegSessionCompleteCallback;
import com.arthenica.ffmpegkit.FFprobeKit;
import com.arthenica.ffmpegkit.FFprobeSession;
import com.arthenica.ffmpegkit.FFprobeSessionCompleteCallback;
import com.arthenica.ffmpegkit.Level;
import com.arthenica.ffmpegkit.LogCallback;
import com.arthenica.ffmpegkit.LogRedirectionStrategy;
import com.arthenica.ffmpegkit.MediaInformation;
import com.arthenica.ffmpegkit.MediaInformationJsonParser;
import com.arthenica.ffmpegkit.MediaInformationSession;
import com.arthenica.ffmpegkit.MediaInformationSessionCompleteCallback;
import com.arthenica.ffmpegkit.Packages;
import com.arthenica.ffmpegkit.ReturnCode;
import com.arthenica.ffmpegkit.Session;
import com.arthenica.ffmpegkit.SessionState;
import com.arthenica.ffmpegkit.Signal;
import com.arthenica.ffmpegkit.Statistics;
import com.arthenica.ffmpegkit.StatisticsCallback;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FFmpegKitReactNativeModule extends ReactContextBaseJavaModule {
    public static final String EVENT_COMPLETE_CALLBACK_EVENT = "FFmpegKitCompleteCallbackEvent";
    public static final String EVENT_LOG_CALLBACK_EVENT = "FFmpegKitLogCallbackEvent";
    public static final String EVENT_STATISTICS_CALLBACK_EVENT = "FFmpegKitStatisticsCallbackEvent";
    public static final String KEY_LOG_LEVEL = "level";
    public static final String KEY_LOG_MESSAGE = "message";
    public static final String KEY_LOG_SESSION_ID = "sessionId";
    public static final String KEY_SESSION_COMMAND = "command";
    public static final String KEY_SESSION_CREATE_TIME = "createTime";
    public static final String KEY_SESSION_ID = "sessionId";
    public static final String KEY_SESSION_MEDIA_INFORMATION = "mediaInformation";
    public static final String KEY_SESSION_START_TIME = "startTime";
    public static final String KEY_SESSION_TYPE = "type";
    public static final String KEY_STATISTICS_BITRATE = "bitrate";
    public static final String KEY_STATISTICS_SESSION_ID = "sessionId";
    public static final String KEY_STATISTICS_SIZE = "size";
    public static final String KEY_STATISTICS_SPEED = "speed";
    public static final String KEY_STATISTICS_TIME = "time";
    public static final String KEY_STATISTICS_VIDEO_FPS = "videoFps";
    public static final String KEY_STATISTICS_VIDEO_FRAME_NUMBER = "videoFrameNumber";
    public static final String KEY_STATISTICS_VIDEO_QUALITY = "videoQuality";
    public static final String LIBRARY_NAME = "ffmpeg-kit-react-native";
    public static final String PLATFORM_NAME = "android";
    public static final int READABLE_REQUEST_CODE = 10000;
    public static final int SESSION_TYPE_FFMPEG = 1;
    public static final int SESSION_TYPE_FFPROBE = 2;
    public static final int SESSION_TYPE_MEDIA_INFORMATION = 3;
    public static final int WRITABLE_REQUEST_CODE = 20000;
    private static final int asyncWriteToPipeConcurrencyLimit = 10;
    private final ExecutorService asyncExecutorService = Executors.newFixedThreadPool(10);
    private final AtomicBoolean logsEnabled = new AtomicBoolean(false);
    private final AtomicBoolean statisticsEnabled = new AtomicBoolean(false);

    public String getName() {
        return "FFmpegKitReactNativeModule";
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public FFmpegKitReactNativeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (reactApplicationContext != null) {
            registerGlobalCallbacks(reactApplicationContext);
        }
    }

    @ReactMethod
    public void addListener(String str) {
        Log.i(LIBRARY_NAME, String.format("Listener added for %s event.", new Object[]{str}));
    }

    /* access modifiers changed from: protected */
    public void registerGlobalCallbacks(ReactApplicationContext reactApplicationContext) {
        FFmpegKitConfig.enableFFmpegSessionCompleteCallback(new FFmpegSessionCompleteCallback() {
            public final void apply(FFmpegSession fFmpegSession) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactApplicationContext.this.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(FFmpegKitReactNativeModule.EVENT_COMPLETE_CALLBACK_EVENT, FFmpegKitReactNativeModule.toMap((Session) fFmpegSession));
            }
        });
        FFmpegKitConfig.enableFFprobeSessionCompleteCallback(new FFprobeSessionCompleteCallback() {
            public final void apply(FFprobeSession fFprobeSession) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactApplicationContext.this.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(FFmpegKitReactNativeModule.EVENT_COMPLETE_CALLBACK_EVENT, FFmpegKitReactNativeModule.toMap((Session) fFprobeSession));
            }
        });
        FFmpegKitConfig.enableMediaInformationSessionCompleteCallback(new MediaInformationSessionCompleteCallback() {
            public final void apply(MediaInformationSession mediaInformationSession) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactApplicationContext.this.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(FFmpegKitReactNativeModule.EVENT_COMPLETE_CALLBACK_EVENT, FFmpegKitReactNativeModule.toMap((Session) mediaInformationSession));
            }
        });
        FFmpegKitConfig.enableLogCallback(new LogCallback(reactApplicationContext) {
            public final /* synthetic */ ReactApplicationContext f$1;

            {
                this.f$1 = r2;
            }

            public final void apply(com.arthenica.ffmpegkit.Log log) {
                FFmpegKitReactNativeModule.this.lambda$registerGlobalCallbacks$3$FFmpegKitReactNativeModule(this.f$1, log);
            }
        });
        FFmpegKitConfig.enableStatisticsCallback(new StatisticsCallback(reactApplicationContext) {
            public final /* synthetic */ ReactApplicationContext f$1;

            {
                this.f$1 = r2;
            }

            public final void apply(Statistics statistics) {
                FFmpegKitReactNativeModule.this.lambda$registerGlobalCallbacks$4$FFmpegKitReactNativeModule(this.f$1, statistics);
            }
        });
    }

    public /* synthetic */ void lambda$registerGlobalCallbacks$3$FFmpegKitReactNativeModule(ReactApplicationContext reactApplicationContext, com.arthenica.ffmpegkit.Log log) {
        if (this.logsEnabled.get()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVENT_LOG_CALLBACK_EVENT, toMap(log));
        }
    }

    public /* synthetic */ void lambda$registerGlobalCallbacks$4$FFmpegKitReactNativeModule(ReactApplicationContext reactApplicationContext, Statistics statistics) {
        if (this.statisticsEnabled.get()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVENT_STATISTICS_CALLBACK_EVENT, toMap(statistics));
        }
    }

    @ReactMethod
    public void abstractSessionGetEndTime(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
                return;
            }
            Date endTime = session.getEndTime();
            if (endTime == null) {
                promise.resolve((Object) null);
            } else {
                promise.resolve(Long.valueOf(endTime.getTime()));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void abstractSessionGetDuration(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else {
                promise.resolve(Double.valueOf((double) session.getDuration()));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void abstractSessionGetAllLogs(Double d, Double d2, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else {
                promise.resolve(toLogArray(session.getAllLogs(isValidPositiveNumber(d2) ? d2.intValue() : AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT)));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void abstractSessionGetLogs(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else {
                promise.resolve(toLogArray(session.getLogs()));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void abstractSessionGetAllLogsAsString(Double d, Double d2, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else {
                promise.resolve(session.getAllLogsAsString(isValidPositiveNumber(d2) ? d2.intValue() : AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void abstractSessionGetState(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else {
                promise.resolve(Integer.valueOf(session.getState().ordinal()));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void abstractSessionGetReturnCode(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
                return;
            }
            ReturnCode returnCode = session.getReturnCode();
            if (returnCode == null) {
                promise.resolve((Object) null);
            } else {
                promise.resolve(Integer.valueOf(returnCode.getValue()));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void abstractSessionGetFailStackTrace(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else {
                promise.resolve(session.getFailStackTrace());
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void thereAreAsynchronousMessagesInTransmit(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else {
                promise.resolve(Boolean.valueOf(session.thereAreAsynchronousMessagesInTransmit()));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void getArch(Promise promise) {
        promise.resolve(AbiDetect.getAbi());
    }

    @ReactMethod
    public void ffmpegSession(ReadableArray readableArray, Promise promise) {
        promise.resolve(toMap((Session) new FFmpegSession(toArgumentsArray(readableArray), (FFmpegSessionCompleteCallback) null, (LogCallback) null, (StatisticsCallback) null, LogRedirectionStrategy.NEVER_PRINT_LOGS)));
    }

    @ReactMethod
    public void ffmpegSessionGetAllStatistics(Double d, Double d2, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isFFmpeg()) {
                promise.resolve(toStatisticsArray(((FFmpegSession) session).getAllStatistics(isValidPositiveNumber(d2) ? d2.intValue() : AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT)));
            } else {
                promise.reject("NOT_FFMPEG_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void ffmpegSessionGetStatistics(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isFFmpeg()) {
                promise.resolve(toStatisticsArray(((FFmpegSession) session).getStatistics()));
            } else {
                promise.reject("NOT_FFMPEG_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void ffprobeSession(ReadableArray readableArray, Promise promise) {
        promise.resolve(toMap((Session) new FFprobeSession(toArgumentsArray(readableArray), (FFprobeSessionCompleteCallback) null, (LogCallback) null, LogRedirectionStrategy.NEVER_PRINT_LOGS)));
    }

    @ReactMethod
    public void mediaInformationSession(ReadableArray readableArray, Promise promise) {
        promise.resolve(toMap((Session) new MediaInformationSession(toArgumentsArray(readableArray), (MediaInformationSessionCompleteCallback) null, (LogCallback) null)));
    }

    @ReactMethod
    public void mediaInformationJsonParserFrom(String str, Promise promise) {
        try {
            promise.resolve(toMap(MediaInformationJsonParser.fromWithError(str)));
        } catch (JSONException e) {
            Log.i(LIBRARY_NAME, "Parsing MediaInformation failed.", e);
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void mediaInformationJsonParserFromWithError(String str, Promise promise) {
        try {
            promise.resolve(toMap(MediaInformationJsonParser.fromWithError(str)));
        } catch (JSONException e) {
            Log.i(LIBRARY_NAME, "Parsing MediaInformation failed.", e);
            promise.reject("PARSE_FAILED", "Parsing MediaInformation failed with JSON error.");
        }
    }

    @ReactMethod
    public void enableRedirection(Promise promise) {
        enableLogs();
        enableStatistics();
        FFmpegKitConfig.enableRedirection();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void disableRedirection(Promise promise) {
        FFmpegKitConfig.disableRedirection();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void enableLogs(Promise promise) {
        enableLogs();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void disableLogs(Promise promise) {
        disableLogs();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void enableStatistics(Promise promise) {
        enableStatistics();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void disableStatistics(Promise promise) {
        disableStatistics();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setFontconfigConfigurationPath(String str, Promise promise) {
        FFmpegKitConfig.setFontconfigConfigurationPath(str);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setFontDirectory(String str, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null) {
            FFmpegKitConfig.setFontDirectory(reactApplicationContext, str, toMap(readableMap));
            promise.resolve((Object) null);
            return;
        }
        promise.reject("INVALID_CONTEXT", "React context is not initialized.");
    }

    @ReactMethod
    public void setFontDirectoryList(ReadableArray readableArray, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null) {
            FFmpegKitConfig.setFontDirectoryList(reactApplicationContext, Arrays.asList(toArgumentsArray(readableArray)), toMap(readableMap));
            promise.resolve((Object) null);
            return;
        }
        promise.reject("INVALID_CONTEXT", "React context is not initialized.");
    }

    @ReactMethod
    public void registerNewFFmpegPipe(Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null) {
            promise.resolve(FFmpegKitConfig.registerNewFFmpegPipe(reactApplicationContext));
        } else {
            promise.reject("INVALID_CONTEXT", "React context is not initialized.");
        }
    }

    @ReactMethod
    public void closeFFmpegPipe(String str, Promise promise) {
        FFmpegKitConfig.closeFFmpegPipe(str);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void getFFmpegVersion(Promise promise) {
        promise.resolve(FFmpegKitConfig.getFFmpegVersion());
    }

    @ReactMethod
    public void isLTSBuild(Promise promise) {
        promise.resolve(Boolean.valueOf(FFmpegKitConfig.isLTSBuild()));
    }

    @ReactMethod
    public void getBuildDate(Promise promise) {
        promise.resolve(FFmpegKitConfig.getBuildDate());
    }

    @ReactMethod
    public void setEnvironmentVariable(String str, String str2, Promise promise) {
        FFmpegKitConfig.setEnvironmentVariable(str, str2);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void ignoreSignal(Double d, Promise promise) {
        Signal signal;
        if (d.intValue() == Signal.SIGINT.getValue()) {
            signal = Signal.SIGINT;
        } else if (d.intValue() == Signal.SIGQUIT.getValue()) {
            signal = Signal.SIGQUIT;
        } else if (d.intValue() == Signal.SIGPIPE.getValue()) {
            signal = Signal.SIGPIPE;
        } else if (d.intValue() == Signal.SIGTERM.getValue()) {
            signal = Signal.SIGTERM;
        } else {
            signal = d.intValue() == Signal.SIGXCPU.getValue() ? Signal.SIGXCPU : null;
        }
        if (signal != null) {
            FFmpegKitConfig.ignoreSignal(signal);
            promise.resolve((Object) null);
            return;
        }
        promise.reject("INVALID_SIGNAL", "Signal value not supported.");
    }

    @ReactMethod
    public void ffmpegSessionExecute(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isFFmpeg()) {
                this.asyncExecutorService.submit(new FFmpegSessionExecuteTask((FFmpegSession) session, promise));
            } else {
                promise.reject("NOT_FFMPEG_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void ffprobeSessionExecute(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isFFprobe()) {
                this.asyncExecutorService.submit(new FFprobeSessionExecuteTask((FFprobeSession) session, promise));
            } else {
                promise.reject("NOT_FFPROBE_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void mediaInformationSessionExecute(Double d, Double d2, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isMediaInformation()) {
                this.asyncExecutorService.submit(new MediaInformationSessionExecuteTask((MediaInformationSession) session, isValidPositiveNumber(d2) ? d2.intValue() : AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT, promise));
            } else {
                promise.reject("NOT_MEDIA_INFORMATION_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void asyncFFmpegSessionExecute(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isFFmpeg()) {
                FFmpegKitConfig.asyncFFmpegExecute((FFmpegSession) session);
                promise.resolve((Object) null);
            } else {
                promise.reject("NOT_FFMPEG_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void asyncFFprobeSessionExecute(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isFFprobe()) {
                FFmpegKitConfig.asyncFFprobeExecute((FFprobeSession) session);
                promise.resolve((Object) null);
            } else {
                promise.reject("NOT_FFPROBE_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void asyncMediaInformationSessionExecute(Double d, Double d2, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isMediaInformation()) {
                FFmpegKitConfig.asyncGetMediaInformationExecute((MediaInformationSession) session, isValidPositiveNumber(d2) ? d2.intValue() : AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT);
                promise.resolve((Object) null);
            } else {
                promise.reject("NOT_MEDIA_INFORMATION_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void getLogLevel(Promise promise) {
        promise.resolve(Integer.valueOf(toInt(FFmpegKitConfig.getLogLevel())));
    }

    @ReactMethod
    public void setLogLevel(Double d, Promise promise) {
        if (d != null) {
            FFmpegKitConfig.setLogLevel(Level.from(d.intValue()));
            promise.resolve((Object) null);
            return;
        }
        promise.reject("INVALID_LEVEL", "Invalid level value.");
    }

    @ReactMethod
    public void getSessionHistorySize(Promise promise) {
        promise.resolve(Integer.valueOf(FFmpegKitConfig.getSessionHistorySize()));
    }

    @ReactMethod
    public void setSessionHistorySize(Double d, Promise promise) {
        if (d != null) {
            FFmpegKitConfig.setSessionHistorySize(d.intValue());
            promise.resolve((Object) null);
            return;
        }
        promise.reject("INVALID_SIZE", "Invalid session history size value.");
    }

    @ReactMethod
    public void getSession(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else {
                promise.resolve(toMap(session));
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void getLastSession(Promise promise) {
        promise.resolve(toMap(FFmpegKitConfig.getLastSession()));
    }

    @ReactMethod
    public void getLastCompletedSession(Promise promise) {
        promise.resolve(toMap(FFmpegKitConfig.getLastCompletedSession()));
    }

    @ReactMethod
    public void getSessions(Promise promise) {
        promise.resolve(toSessionArray(FFmpegKitConfig.getSessions()));
    }

    @ReactMethod
    public void clearSessions(Promise promise) {
        FFmpegKitConfig.clearSessions();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void getSessionsByState(Double d, Promise promise) {
        if (d != null) {
            promise.resolve(toSessionArray(FFmpegKitConfig.getSessionsByState(toSessionState(d.intValue()))));
        } else {
            promise.reject("INVALID_SESSION_STATE", "Invalid session state value.");
        }
    }

    @ReactMethod
    public void getLogRedirectionStrategy(Promise promise) {
        promise.resolve(Integer.valueOf(toInt(FFmpegKitConfig.getLogRedirectionStrategy())));
    }

    @ReactMethod
    public void setLogRedirectionStrategy(Double d, Promise promise) {
        if (d != null) {
            FFmpegKitConfig.setLogRedirectionStrategy(toLogRedirectionStrategy(d.intValue()));
            promise.resolve((Object) null);
            return;
        }
        promise.reject("INVALID_LOG_REDIRECTION_STRATEGY", "Invalid log redirection strategy value.");
    }

    @ReactMethod
    public void messagesInTransmit(Double d, Promise promise) {
        if (d != null) {
            promise.resolve(Integer.valueOf(FFmpegKitConfig.messagesInTransmit(d.longValue())));
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void getPlatform(Promise promise) {
        promise.resolve(PLATFORM_NAME);
    }

    @ReactMethod
    public void writeToPipe(String str, String str2, Promise promise) {
        this.asyncExecutorService.submit(new WriteToPipeTask(str, str2, promise));
    }

    @ReactMethod
    public void selectDocument(Boolean bool, String str, String str2, ReadableArray readableArray, Promise promise) {
        Intent intent;
        String str3;
        char c;
        String str4;
        char c2;
        String str5;
        char c3;
        String str6 = str;
        String str7 = str2;
        Promise promise2 = promise;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (bool.booleanValue()) {
            intent = new Intent("android.intent.action.CREATE_DOCUMENT");
            intent.addFlags(3);
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.addFlags(1);
        }
        Intent intent2 = intent;
        if (str7 != null) {
            intent2.setType(str7);
        } else {
            intent2.setType("*/*");
        }
        if (str6 != null) {
            intent2.putExtra("android.intent.extra.TITLE", str6);
        }
        if (readableArray != null) {
            intent2.putExtra("android.intent.extra.MIME_TYPES", toArgumentsArray(readableArray));
        }
        if (reactApplicationContext != null) {
            Activity currentActivity = reactApplicationContext.getCurrentActivity();
            if (currentActivity != null) {
                final ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
                final Boolean bool2 = bool;
                AnonymousClass1 r15 = r1;
                final String str8 = str2;
                Activity activity = currentActivity;
                final String str9 = str;
                String str10 = LIBRARY_NAME;
                final ReadableArray readableArray2 = readableArray;
                final Promise promise3 = promise;
                AnonymousClass1 r1 = new BaseActivityEventListener() {
                    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                        reactApplicationContext2.removeActivityEventListener(this);
                        Object[] objArr = new Object[7];
                        objArr[0] = bool2;
                        objArr[1] = str8;
                        objArr[2] = str9;
                        ReadableArray readableArray = readableArray2;
                        String str = null;
                        objArr[3] = readableArray == null ? null : Arrays.toString(FFmpegKitReactNativeModule.toArgumentsArray(readableArray));
                        objArr[4] = Integer.valueOf(i);
                        objArr[5] = Integer.valueOf(i2);
                        objArr[6] = intent == null ? null : intent.toString();
                        Log.d(FFmpegKitReactNativeModule.LIBRARY_NAME, String.format("selectDocument using parameters writable: %s, type: %s, title: %s and extra types: %s completed with requestCode: %d, resultCode: %d, data: %s.", objArr));
                        if (i != 10000 && i != 20000) {
                            super.onActivityResult(activity, i, i2, intent);
                        } else if (i2 != -1) {
                            promise3.reject("SELECT_CANCELLED", String.valueOf(i2));
                        } else if (intent == null) {
                            promise3.resolve((Object) null);
                        } else {
                            Uri data = intent.getData();
                            Promise promise = promise3;
                            if (data != null) {
                                str = data.toString();
                            }
                            promise.resolve(str);
                        }
                    }
                };
                reactApplicationContext.addActivityEventListener(r15);
                try {
                    activity.startActivityForResult(intent2, bool.booleanValue() ? WRITABLE_REQUEST_CODE : 10000);
                } catch (Exception e) {
                    Object[] objArr = new Object[4];
                    objArr[0] = bool;
                    objArr[1] = str7;
                    objArr[2] = str6;
                    if (readableArray == null) {
                        c3 = 3;
                        str5 = null;
                    } else {
                        str5 = Arrays.toString(toArgumentsArray(readableArray));
                        c3 = 3;
                    }
                    objArr[c3] = str5;
                    Log.i(str10, String.format("Failed to selectDocument using parameters writable: %s, type: %s, title: %s and extra types: %s!", objArr), e);
                    promise2.reject("SELECT_FAILED", e.getMessage());
                }
            } else {
                String str11 = LIBRARY_NAME;
                Object[] objArr2 = new Object[4];
                objArr2[0] = bool;
                objArr2[1] = str7;
                objArr2[2] = str6;
                if (readableArray == null) {
                    c2 = 3;
                    str4 = null;
                } else {
                    str4 = Arrays.toString(toArgumentsArray(readableArray));
                    c2 = 3;
                }
                objArr2[c2] = str4;
                Log.w(str11, String.format("Cannot selectDocument using parameters writable: %s, type: %s, title: %s and extra types: %s. Current activity is null.", objArr2));
                promise2.reject("INVALID_ACTIVITY", "Activity is null.");
            }
        } else {
            String str12 = LIBRARY_NAME;
            Object[] objArr3 = new Object[4];
            objArr3[0] = bool;
            objArr3[1] = str7;
            objArr3[2] = str6;
            if (readableArray == null) {
                c = 3;
                str3 = null;
            } else {
                str3 = Arrays.toString(toArgumentsArray(readableArray));
                c = 3;
            }
            objArr3[c] = str3;
            Log.w(str12, String.format("Cannot selectDocument using parameters writable: %s, type: %s, title: %s and extra types: %s. React context is null.", objArr3));
            promise2.reject("INVALID_CONTEXT", "Context is null.");
        }
    }

    @ReactMethod
    public void getSafParameter(String str, String str2, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Uri parse = Uri.parse(str);
        if (parse == null) {
            Log.w(LIBRARY_NAME, String.format("Cannot getSafParameter using parameters uriString: %s, openMode: %s. Uri string cannot be parsed.", new Object[]{str, str2}));
            promise.reject("GET_SAF_PARAMETER_FAILED", "Uri string cannot be parsed.");
            return;
        }
        String safParameter = FFmpegKitConfig.getSafParameter(reactApplicationContext, parse, str2);
        Log.d(LIBRARY_NAME, String.format("getSafParameter using parameters uriString: %s, openMode: %s completed with saf parameter: %s.", new Object[]{str, str2, safParameter}));
        promise.resolve(safParameter);
    }

    @ReactMethod
    public void cancel(Promise promise) {
        FFmpegKit.cancel();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void cancelSession(Double d, Promise promise) {
        if (d != null) {
            FFmpegKit.cancel(d.longValue());
        } else {
            FFmpegKit.cancel();
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void getFFmpegSessions(Promise promise) {
        promise.resolve(toSessionArray(FFmpegKit.listSessions()));
    }

    @ReactMethod
    public void getFFprobeSessions(Promise promise) {
        promise.resolve(toSessionArray(FFprobeKit.listFFprobeSessions()));
    }

    @ReactMethod
    public void getMediaInformationSessions(Promise promise) {
        promise.resolve(toSessionArray(FFprobeKit.listMediaInformationSessions()));
    }

    @ReactMethod
    public void getMediaInformation(Double d, Promise promise) {
        if (d != null) {
            Session session = FFmpegKitConfig.getSession(d.longValue());
            if (session == null) {
                promise.reject("SESSION_NOT_FOUND", "Session not found.");
            } else if (session.isMediaInformation()) {
                MediaInformation mediaInformation = ((MediaInformationSession) session).getMediaInformation();
                if (mediaInformation != null) {
                    promise.resolve(toMap(mediaInformation));
                } else {
                    promise.resolve((Object) null);
                }
            } else {
                promise.reject("NOT_MEDIA_INFORMATION_SESSION", "A session is found but it does not have the correct type.");
            }
        } else {
            promise.reject("INVALID_SESSION", "Invalid session id.");
        }
    }

    @ReactMethod
    public void getPackageName(Promise promise) {
        promise.resolve(Packages.getPackageName());
    }

    @ReactMethod
    public void getExternalLibraries(Promise promise) {
        promise.resolve(toStringArray(Packages.getExternalLibraries()));
    }

    @ReactMethod
    public void uninit(Promise promise) {
        this.asyncExecutorService.shutdown();
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: protected */
    public void enableLogs() {
        this.logsEnabled.compareAndSet(false, true);
    }

    /* access modifiers changed from: protected */
    public void disableLogs() {
        this.logsEnabled.compareAndSet(true, false);
    }

    /* access modifiers changed from: protected */
    public void enableStatistics() {
        this.statisticsEnabled.compareAndSet(false, true);
    }

    /* access modifiers changed from: protected */
    public void disableStatistics() {
        this.statisticsEnabled.compareAndSet(true, false);
    }

    protected static int toInt(Level level) {
        if (level == null) {
            level = Level.AV_LOG_TRACE;
        }
        return level.getValue();
    }

    protected static WritableMap toMap(Session session) {
        if (session == null) {
            return null;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("sessionId", (double) session.getSessionId());
        createMap.putDouble(KEY_SESSION_CREATE_TIME, (double) toLong(session.getCreateTime()));
        createMap.putDouble(KEY_SESSION_START_TIME, (double) toLong(session.getStartTime()));
        createMap.putString(KEY_SESSION_COMMAND, session.getCommand());
        if (session.isFFmpeg()) {
            createMap.putDouble("type", 1.0d);
        } else if (session.isFFprobe()) {
            createMap.putDouble("type", 2.0d);
        } else if (session.isMediaInformation()) {
            MediaInformation mediaInformation = ((MediaInformationSession) session).getMediaInformation();
            if (mediaInformation != null) {
                createMap.putMap(KEY_SESSION_MEDIA_INFORMATION, toMap(mediaInformation));
            }
            createMap.putDouble("type", 3.0d);
        }
        return createMap;
    }

    protected static long toLong(Date date) {
        if (date != null) {
            return date.getTime();
        }
        return 0;
    }

    /* renamed from: com.arthenica.ffmpegkit.reactnative.FFmpegKitReactNativeModule$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.arthenica.ffmpegkit.LogRedirectionStrategy[] r0 = com.arthenica.ffmpegkit.LogRedirectionStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy = r0
                com.arthenica.ffmpegkit.LogRedirectionStrategy r1 = com.arthenica.ffmpegkit.LogRedirectionStrategy.ALWAYS_PRINT_LOGS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy     // Catch:{ NoSuchFieldError -> 0x001d }
                com.arthenica.ffmpegkit.LogRedirectionStrategy r1 = com.arthenica.ffmpegkit.LogRedirectionStrategy.PRINT_LOGS_WHEN_NO_CALLBACKS_DEFINED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.arthenica.ffmpegkit.LogRedirectionStrategy r1 = com.arthenica.ffmpegkit.LogRedirectionStrategy.PRINT_LOGS_WHEN_GLOBAL_CALLBACK_NOT_DEFINED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.arthenica.ffmpegkit.LogRedirectionStrategy r1 = com.arthenica.ffmpegkit.LogRedirectionStrategy.PRINT_LOGS_WHEN_SESSION_CALLBACK_NOT_DEFINED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy     // Catch:{ NoSuchFieldError -> 0x003e }
                com.arthenica.ffmpegkit.LogRedirectionStrategy r1 = com.arthenica.ffmpegkit.LogRedirectionStrategy.NEVER_PRINT_LOGS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arthenica.ffmpegkit.reactnative.FFmpegKitReactNativeModule.AnonymousClass2.<clinit>():void");
        }
    }

    protected static int toInt(LogRedirectionStrategy logRedirectionStrategy) {
        int i = AnonymousClass2.$SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy[logRedirectionStrategy.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 4 : 3;
        }
        return 2;
    }

    protected static LogRedirectionStrategy toLogRedirectionStrategy(int i) {
        if (i == 0) {
            return LogRedirectionStrategy.ALWAYS_PRINT_LOGS;
        }
        if (i == 1) {
            return LogRedirectionStrategy.PRINT_LOGS_WHEN_NO_CALLBACKS_DEFINED;
        }
        if (i == 2) {
            return LogRedirectionStrategy.PRINT_LOGS_WHEN_GLOBAL_CALLBACK_NOT_DEFINED;
        }
        if (i != 3) {
            return LogRedirectionStrategy.NEVER_PRINT_LOGS;
        }
        return LogRedirectionStrategy.PRINT_LOGS_WHEN_SESSION_CALLBACK_NOT_DEFINED;
    }

    protected static SessionState toSessionState(int i) {
        if (i == 0) {
            return SessionState.CREATED;
        }
        if (i == 1) {
            return SessionState.RUNNING;
        }
        if (i != 2) {
            return SessionState.COMPLETED;
        }
        return SessionState.FAILED;
    }

    protected static WritableArray toStringArray(List<String> list) {
        WritableArray createArray = Arguments.createArray();
        if (list != null) {
            for (String pushString : list) {
                createArray.pushString(pushString);
            }
        }
        return createArray;
    }

    protected static Map<String, String> toMap(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (readableMap.getType(nextKey) == ReadableType.String) {
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                }
            }
        }
        return hashMap;
    }

    protected static WritableMap toMap(com.arthenica.ffmpegkit.Log log) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("sessionId", (double) log.getSessionId());
        createMap.putDouble("level", (double) toInt(log.getLevel()));
        createMap.putString(KEY_LOG_MESSAGE, log.getMessage());
        return createMap;
    }

    protected static WritableMap toMap(Statistics statistics) {
        WritableMap createMap = Arguments.createMap();
        if (statistics != null) {
            createMap.putDouble("sessionId", (double) statistics.getSessionId());
            createMap.putDouble(KEY_STATISTICS_VIDEO_FRAME_NUMBER, (double) statistics.getVideoFrameNumber());
            createMap.putDouble(KEY_STATISTICS_VIDEO_FPS, (double) statistics.getVideoFps());
            createMap.putDouble(KEY_STATISTICS_VIDEO_QUALITY, (double) statistics.getVideoQuality());
            createMap.putDouble("size", (double) statistics.getSize());
            createMap.putDouble(KEY_STATISTICS_TIME, (double) statistics.getTime());
            createMap.putDouble(KEY_STATISTICS_BITRATE, statistics.getBitrate());
            createMap.putDouble(KEY_STATISTICS_SPEED, statistics.getSpeed());
        }
        return createMap;
    }

    protected static WritableMap toMap(MediaInformation mediaInformation) {
        if (mediaInformation == null) {
            return null;
        }
        WritableMap createMap = Arguments.createMap();
        JSONObject allProperties = mediaInformation.getAllProperties();
        return allProperties != null ? toMap(allProperties) : createMap;
    }

    protected static WritableMap toMap(JSONObject jSONObject) {
        WritableMap createMap = Arguments.createMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt != null) {
                    if (opt instanceof JSONArray) {
                        createMap.putArray(next, toList((JSONArray) opt));
                    } else if (opt instanceof JSONObject) {
                        createMap.putMap(next, toMap((JSONObject) opt));
                    } else if (opt instanceof String) {
                        createMap.putString(next, (String) opt);
                    } else if (opt instanceof Number) {
                        if (opt instanceof Integer) {
                            createMap.putInt(next, ((Integer) opt).intValue());
                        } else {
                            createMap.putDouble(next, ((Number) opt).doubleValue());
                        }
                    } else if (opt instanceof Boolean) {
                        createMap.putBoolean(next, ((Boolean) opt).booleanValue());
                    } else {
                        Log.i(LIBRARY_NAME, String.format("Cannot map json key %s using value %s:%s", new Object[]{next, opt.toString(), opt.getClass().toString()}));
                    }
                }
            }
        }
        return createMap;
    }

    protected static WritableArray toList(JSONArray jSONArray) {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object opt = jSONArray.opt(i);
            if (opt != null) {
                if (opt instanceof JSONArray) {
                    createArray.pushArray(toList((JSONArray) opt));
                } else if (opt instanceof JSONObject) {
                    createArray.pushMap(toMap((JSONObject) opt));
                } else if (opt instanceof String) {
                    createArray.pushString((String) opt);
                } else if (opt instanceof Number) {
                    if (opt instanceof Integer) {
                        createArray.pushInt(((Integer) opt).intValue());
                    } else {
                        createArray.pushDouble(((Number) opt).doubleValue());
                    }
                } else if (opt instanceof Boolean) {
                    createArray.pushBoolean(((Boolean) opt).booleanValue());
                } else {
                    Log.i(LIBRARY_NAME, String.format("Cannot map json value %s:%s", new Object[]{opt.toString(), opt.getClass().toString()}));
                }
            }
        }
        return createArray;
    }

    protected static String[] toArgumentsArray(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            if (readableArray.getType(i) == ReadableType.String) {
                arrayList.add(readableArray.getString(i));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    protected static WritableArray toSessionArray(List<? extends Session> list) {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < list.size(); i++) {
            createArray.pushMap(toMap((Session) list.get(i)));
        }
        return createArray;
    }

    protected static WritableArray toLogArray(List<com.arthenica.ffmpegkit.Log> list) {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < list.size(); i++) {
            createArray.pushMap(toMap(list.get(i)));
        }
        return createArray;
    }

    protected static WritableArray toStatisticsArray(List<Statistics> list) {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < list.size(); i++) {
            createArray.pushMap(toMap(list.get(i)));
        }
        return createArray;
    }

    protected static boolean isValidPositiveNumber(Double d) {
        return d != null && d.intValue() >= 0;
    }
}
