package com.arthenica.ffmpegkit;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.SparseArray;
import com.arthenica.smartexception.java.Exceptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class FFmpegKitConfig {
    static final String FFMPEG_KIT_NAMED_PIPE_PREFIX = "fk_pipe_";
    static final String TAG = "ffmpeg-kit";
    private static Level activeLogLevel = Level.from(NativeLoader.loadLogLevel());
    private static int asyncConcurrencyLimit = 10;
    private static ExecutorService asyncExecutorService = Executors.newFixedThreadPool(10);
    private static FFmpegSessionCompleteCallback globalFFmpegSessionCompleteCallback = null;
    private static FFprobeSessionCompleteCallback globalFFprobeSessionCompleteCallback = null;
    private static LogCallback globalLogCallback = null;
    private static LogRedirectionStrategy globalLogRedirectionStrategy = LogRedirectionStrategy.PRINT_LOGS_WHEN_NO_CALLBACKS_DEFINED;
    private static MediaInformationSessionCompleteCallback globalMediaInformationSessionCompleteCallback = null;
    private static StatisticsCallback globalStatisticsCallback = null;
    private static final SparseArray<SAFProtocolUrl> safFileDescriptorMap = new SparseArray<>();
    private static final SparseArray<SAFProtocolUrl> safIdMap = new SparseArray<>();
    private static final List<Session> sessionHistoryList = new LinkedList();
    private static final Object sessionHistoryLock = new Object();
    private static final Map<Long, Session> sessionHistoryMap = new LinkedHashMap<Long, Session>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<Long, Session> entry) {
            return size() > FFmpegKitConfig.sessionHistorySize;
        }
    };
    /* access modifiers changed from: private */
    public static int sessionHistorySize = 10;
    private static final AtomicInteger uniqueIdGenerator = new AtomicInteger(1);

    private static native void disableNativeRedirection();

    private static native void enableNativeRedirection();

    private static native String getNativeBuildDate();

    private static native String getNativeFFmpegVersion();

    static native int getNativeLogLevel();

    private static native String getNativeVersion();

    private static native void ignoreNativeSignal(int i);

    public static native int messagesInTransmit(long j);

    static native void nativeFFmpegCancel(long j);

    private static native int nativeFFmpegExecute(long j, String[] strArr);

    static native int nativeFFprobeExecute(long j, String[] strArr);

    private static native int registerNewNativeFFmpegPipe(String str);

    private static native int setNativeEnvironmentVariable(String str, String str2);

    private static native void setNativeLogLevel(int i);

    static class SAFProtocolUrl {
        private final ContentResolver contentResolver;
        private final String openMode;
        private ParcelFileDescriptor parcelFileDescriptor;
        private final Integer safId;
        private final Uri uri;

        public SAFProtocolUrl(Integer num, Uri uri2, String str, ContentResolver contentResolver2) {
            this.safId = num;
            this.uri = uri2;
            this.openMode = str;
            this.contentResolver = contentResolver2;
        }

        public Integer getSafId() {
            return this.safId;
        }

        public Uri getUri() {
            return this.uri;
        }

        public String getOpenMode() {
            return this.openMode;
        }

        public ContentResolver getContentResolver() {
            return this.contentResolver;
        }

        public void setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor2) {
            this.parcelFileDescriptor = parcelFileDescriptor2;
        }

        public ParcelFileDescriptor getParcelFileDescriptor() {
            return this.parcelFileDescriptor;
        }
    }

    static {
        Exceptions.registerRootPackage("com.arthenica");
        Log.i(TAG, "Loading ffmpeg-kit.");
        Class<Abi> cls = Abi.class;
        Class<FFmpegKit> cls2 = FFmpegKit.class;
        Class<FFprobeKit> cls3 = FFprobeKit.class;
        NativeLoader.loadFFmpegKit(NativeLoader.loadFFmpeg());
        Log.i(TAG, String.format("Loaded ffmpeg-kit-%s-%s-%s-%s.", new Object[]{NativeLoader.loadPackageName(), NativeLoader.loadAbi(), NativeLoader.loadVersion(), NativeLoader.loadBuildDate()}));
        NativeLoader.enableRedirection();
    }

    private FFmpegKitConfig() {
    }

    public static void enableRedirection() {
        enableNativeRedirection();
    }

    public static void disableRedirection() {
        disableNativeRedirection();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f A[SYNTHETIC, Splitter:B:18:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void log(long r5, int r7, byte[] r8) {
        /*
            com.arthenica.ffmpegkit.Level r0 = com.arthenica.ffmpegkit.Level.from(r7)
            java.lang.String r1 = new java.lang.String
            r1.<init>(r8)
            com.arthenica.ffmpegkit.Log r8 = new com.arthenica.ffmpegkit.Log
            r8.<init>(r5, r0, r1)
            com.arthenica.ffmpegkit.LogRedirectionStrategy r2 = globalLogRedirectionStrategy
            com.arthenica.ffmpegkit.Level r3 = activeLogLevel
            com.arthenica.ffmpegkit.Level r4 = com.arthenica.ffmpegkit.Level.AV_LOG_QUIET
            if (r3 != r4) goto L_0x001e
            com.arthenica.ffmpegkit.Level r3 = com.arthenica.ffmpegkit.Level.AV_LOG_STDERR
            int r3 = r3.getValue()
            if (r7 != r3) goto L_0x0026
        L_0x001e:
            com.arthenica.ffmpegkit.Level r3 = activeLogLevel
            int r3 = r3.getValue()
            if (r7 <= r3) goto L_0x0027
        L_0x0026:
            return
        L_0x0027:
            com.arthenica.ffmpegkit.Session r5 = getSession(r5)
            r6 = 0
            r7 = 1
            java.lang.String r3 = "ffmpeg-kit"
            if (r5 == 0) goto L_0x005a
            com.arthenica.ffmpegkit.LogRedirectionStrategy r2 = r5.getLogRedirectionStrategy()
            r5.addLog(r8)
            com.arthenica.ffmpegkit.LogCallback r4 = r5.getLogCallback()
            if (r4 == 0) goto L_0x005a
            com.arthenica.ffmpegkit.LogCallback r5 = r5.getLogCallback()     // Catch:{ Exception -> 0x0046 }
            r5.apply(r8)     // Catch:{ Exception -> 0x0046 }
            goto L_0x0058
        L_0x0046:
            r5 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.String r5 = com.arthenica.smartexception.java.Exceptions.getStackTraceString(r5)
            r4[r6] = r5
            java.lang.String r5 = "Exception thrown inside session log callback.%s"
            java.lang.String r5 = java.lang.String.format(r5, r4)
            android.util.Log.e(r3, r5)
        L_0x0058:
            r5 = r7
            goto L_0x005b
        L_0x005a:
            r5 = r6
        L_0x005b:
            com.arthenica.ffmpegkit.LogCallback r4 = globalLogCallback
            if (r4 == 0) goto L_0x0076
            r4.apply(r8)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0075
        L_0x0063:
            r8 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.String r8 = com.arthenica.smartexception.java.Exceptions.getStackTraceString(r8)
            r4[r6] = r8
            java.lang.String r6 = "Exception thrown inside global log callback.%s"
            java.lang.String r6 = java.lang.String.format(r6, r4)
            android.util.Log.e(r3, r6)
        L_0x0075:
            r6 = r7
        L_0x0076:
            int[] r8 = com.arthenica.ffmpegkit.FFmpegKitConfig.AnonymousClass2.$SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy
            int r2 = r2.ordinal()
            r8 = r8[r2]
            if (r8 == r7) goto L_0x00b3
            r7 = 2
            if (r8 == r7) goto L_0x0092
            r7 = 3
            if (r8 == r7) goto L_0x008f
            r7 = 4
            if (r8 == r7) goto L_0x008a
            goto L_0x0095
        L_0x008a:
            if (r6 != 0) goto L_0x008e
            if (r5 == 0) goto L_0x0095
        L_0x008e:
            return
        L_0x008f:
            if (r5 == 0) goto L_0x0095
            return
        L_0x0092:
            if (r6 == 0) goto L_0x0095
            return
        L_0x0095:
            int[] r5 = com.arthenica.ffmpegkit.FFmpegKitConfig.AnonymousClass2.$SwitchMap$com$arthenica$ffmpegkit$Level
            int r6 = r0.ordinal()
            r5 = r5[r6]
            switch(r5) {
                case 1: goto L_0x00b3;
                case 2: goto L_0x00b0;
                case 3: goto L_0x00b0;
                case 4: goto L_0x00ac;
                case 5: goto L_0x00a8;
                case 6: goto L_0x00a4;
                case 7: goto L_0x00a4;
                case 8: goto L_0x00a4;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            android.util.Log.v(r3, r1)
            goto L_0x00b3
        L_0x00a4:
            android.util.Log.e(r3, r1)
            goto L_0x00b3
        L_0x00a8:
            android.util.Log.w(r3, r1)
            goto L_0x00b3
        L_0x00ac:
            android.util.Log.i(r3, r1)
            goto L_0x00b3
        L_0x00b0:
            android.util.Log.d(r3, r1)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arthenica.ffmpegkit.FFmpegKitConfig.log(long, int, byte[]):void");
    }

    /* renamed from: com.arthenica.ffmpegkit.FFmpegKitConfig$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$arthenica$ffmpegkit$Level;
        static final /* synthetic */ int[] $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy;

        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x009d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a7 */
        static {
            /*
                com.arthenica.ffmpegkit.Level[] r0 = com.arthenica.ffmpegkit.Level.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$arthenica$ffmpegkit$Level = r0
                r1 = 1
                com.arthenica.ffmpegkit.Level r2 = com.arthenica.ffmpegkit.Level.AV_LOG_QUIET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x001d }
                com.arthenica.ffmpegkit.Level r3 = com.arthenica.ffmpegkit.Level.AV_LOG_TRACE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.arthenica.ffmpegkit.Level r4 = com.arthenica.ffmpegkit.Level.AV_LOG_DEBUG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.arthenica.ffmpegkit.Level r5 = com.arthenica.ffmpegkit.Level.AV_LOG_INFO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x003e }
                com.arthenica.ffmpegkit.Level r6 = com.arthenica.ffmpegkit.Level.AV_LOG_WARNING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.arthenica.ffmpegkit.Level r6 = com.arthenica.ffmpegkit.Level.AV_LOG_ERROR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r5 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.arthenica.ffmpegkit.Level r6 = com.arthenica.ffmpegkit.Level.AV_LOG_FATAL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7 = 7
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r5 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.arthenica.ffmpegkit.Level r6 = com.arthenica.ffmpegkit.Level.AV_LOG_PANIC     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r7 = 8
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r5 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x006c }
                com.arthenica.ffmpegkit.Level r6 = com.arthenica.ffmpegkit.Level.AV_LOG_STDERR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r7 = 9
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r5 = $SwitchMap$com$arthenica$ffmpegkit$Level     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.arthenica.ffmpegkit.Level r6 = com.arthenica.ffmpegkit.Level.AV_LOG_VERBOSE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r7 = 10
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.arthenica.ffmpegkit.LogRedirectionStrategy[] r5 = com.arthenica.ffmpegkit.LogRedirectionStrategy.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy = r5
                com.arthenica.ffmpegkit.LogRedirectionStrategy r6 = com.arthenica.ffmpegkit.LogRedirectionStrategy.NEVER_PRINT_LOGS     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r1 = $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.arthenica.ffmpegkit.LogRedirectionStrategy r5 = com.arthenica.ffmpegkit.LogRedirectionStrategy.PRINT_LOGS_WHEN_GLOBAL_CALLBACK_NOT_DEFINED     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy     // Catch:{ NoSuchFieldError -> 0x009d }
                com.arthenica.ffmpegkit.LogRedirectionStrategy r1 = com.arthenica.ffmpegkit.LogRedirectionStrategy.PRINT_LOGS_WHEN_SESSION_CALLBACK_NOT_DEFINED     // Catch:{ NoSuchFieldError -> 0x009d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                int[] r0 = $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy     // Catch:{ NoSuchFieldError -> 0x00a7 }
                com.arthenica.ffmpegkit.LogRedirectionStrategy r1 = com.arthenica.ffmpegkit.LogRedirectionStrategy.PRINT_LOGS_WHEN_NO_CALLBACKS_DEFINED     // Catch:{ NoSuchFieldError -> 0x00a7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                int[] r0 = $SwitchMap$com$arthenica$ffmpegkit$LogRedirectionStrategy     // Catch:{ NoSuchFieldError -> 0x00b1 }
                com.arthenica.ffmpegkit.LogRedirectionStrategy r1 = com.arthenica.ffmpegkit.LogRedirectionStrategy.ALWAYS_PRINT_LOGS     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arthenica.ffmpegkit.FFmpegKitConfig.AnonymousClass2.<clinit>():void");
        }
    }

    private static void statistics(long j, int i, float f, float f2, long j2, int i2, double d, double d2) {
        Statistics statistics = new Statistics(j, i, f, f2, j2, i2, d, d2);
        Session session = getSession(j);
        if (session != null && session.isFFmpeg()) {
            FFmpegSession fFmpegSession = (FFmpegSession) session;
            fFmpegSession.addStatistics(statistics);
            if (fFmpegSession.getStatisticsCallback() != null) {
                try {
                    fFmpegSession.getStatisticsCallback().apply(statistics);
                } catch (Exception e) {
                    Log.e(TAG, String.format("Exception thrown inside session statistics callback.%s", new Object[]{Exceptions.getStackTraceString(e)}));
                }
            }
        }
        StatisticsCallback statisticsCallback = globalStatisticsCallback;
        if (statisticsCallback != null) {
            try {
                statisticsCallback.apply(statistics);
            } catch (Exception e2) {
                Log.e(TAG, String.format("Exception thrown inside global statistics callback.%s", new Object[]{Exceptions.getStackTraceString(e2)}));
            }
        }
    }

    public static int setFontconfigConfigurationPath(String str) {
        return setNativeEnvironmentVariable("FONTCONFIG_PATH", str);
    }

    public static void setFontDirectory(Context context, String str, Map<String, String> map) {
        setFontDirectoryList(context, Collections.singletonList(str), map);
    }

    public static void setFontDirectoryList(Context context, List<String> list, Map<String, String> map) {
        int i;
        Object obj;
        File file = new File(context.getCacheDir(), "fontconfig");
        if (!file.exists()) {
            Log.d(TAG, String.format("Created temporary font conf directory: %s.", new Object[]{Boolean.valueOf(file.mkdirs())}));
        }
        File file2 = new File(file, "fonts.conf");
        if (file2.exists()) {
            Log.d(TAG, String.format("Deleted old temporary font configuration: %s.", new Object[]{Boolean.valueOf(file2.delete())}));
        }
        StringBuilder sb = new StringBuilder("");
        if (map == null || map.size() <= 0) {
            i = 0;
        } else {
            map.entrySet();
            i = 0;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                if (str != null && str2 != null && str.trim().length() > 0 && str2.trim().length() > 0) {
                    sb.append("        <match target=\"pattern\">\n");
                    sb.append("                <test qual=\"any\" name=\"family\">\n");
                    sb.append(String.format("                        <string>%s</string>\n", new Object[]{str}));
                    sb.append("                </test>\n");
                    sb.append("                <edit name=\"family\" mode=\"assign\" binding=\"same\">\n");
                    sb.append(String.format("                        <string>%s</string>\n", new Object[]{str2}));
                    sb.append("                </edit>\n");
                    sb.append("        </match>\n");
                    i++;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<?xml version=\"1.0\"?>\n");
        sb2.append("<!DOCTYPE fontconfig SYSTEM \"fonts.dtd\">\n");
        sb2.append("<fontconfig>\n");
        sb2.append("    <dir prefix=\"cwd\">.</dir>\n");
        for (String append : list) {
            sb2.append("    <dir>");
            sb2.append(append);
            sb2.append("</dir>\n");
        }
        sb2.append(sb);
        sb2.append("</fontconfig>");
        AtomicReference atomicReference = new AtomicReference();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            atomicReference.set(fileOutputStream);
            fileOutputStream.write(sb2.toString().getBytes());
            fileOutputStream.flush();
            Log.d(TAG, String.format("Saved new temporary font configuration with %d font name mappings.", new Object[]{Integer.valueOf(i)}));
            setFontconfigConfigurationPath(file.getAbsolutePath());
            for (String str3 : list) {
                Log.d(TAG, String.format("Font directory %s registered successfully.", new Object[]{str3}));
            }
            if (atomicReference.get() != null) {
                try {
                    obj = atomicReference.get();
                    ((FileOutputStream) obj).close();
                } catch (IOException unused) {
                }
            }
        } catch (IOException e) {
            Log.e(TAG, String.format("Failed to set font directory: %s.%s", new Object[]{Arrays.toString(list.toArray()), Exceptions.getStackTraceString(e)}));
            if (atomicReference.get() != null) {
                obj = atomicReference.get();
            }
        } catch (Throwable th) {
            if (atomicReference.get() != null) {
                try {
                    ((FileOutputStream) atomicReference.get()).close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static String registerNewFFmpegPipe(Context context) {
        File file = new File(context.getCacheDir(), "pipes");
        if (file.exists() || file.mkdirs()) {
            String format = MessageFormat.format("{0}{1}{2}{3}", new Object[]{file, File.separator, FFMPEG_KIT_NAMED_PIPE_PREFIX, Integer.valueOf(uniqueIdGenerator.getAndIncrement())});
            closeFFmpegPipe(format);
            int registerNewNativeFFmpegPipe = registerNewNativeFFmpegPipe(format);
            if (registerNewNativeFFmpegPipe == 0) {
                return format;
            }
            Log.e(TAG, String.format("Failed to register new FFmpeg pipe %s. Operation failed with rc=%d.", new Object[]{format, Integer.valueOf(registerNewNativeFFmpegPipe)}));
            return null;
        }
        Log.e(TAG, String.format("Failed to create pipes directory: %s.", new Object[]{file.getAbsolutePath()}));
        return null;
    }

    public static void closeFFmpegPipe(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static List<String> getSupportedCameraIds(Context context) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.addAll(CameraSupport.extractSupportedCameraIds(context));
        }
        return arrayList;
    }

    public static String getFFmpegVersion() {
        return getNativeFFmpegVersion();
    }

    public static String getVersion() {
        if (!isLTSBuild()) {
            return getNativeVersion();
        }
        return String.format("%s-lts", new Object[]{getNativeVersion()});
    }

    public static boolean isLTSBuild() {
        return AbiDetect.isNativeLTSBuild();
    }

    public static String getBuildDate() {
        return getNativeBuildDate();
    }

    public static void printToLogcat(int i, String str) {
        do {
            if (str.length() <= 4000) {
                Log.println(i, TAG, str);
                str = "";
            } else {
                int lastIndexOf = str.substring(0, 4000).lastIndexOf(10);
                if (lastIndexOf < 0) {
                    Log.println(i, TAG, str.substring(0, 4000));
                    str = str.substring(4000);
                } else {
                    Log.println(i, TAG, str.substring(0, lastIndexOf));
                    str = str.substring(lastIndexOf);
                }
            }
        } while (str.length() > 0);
    }

    public static int setEnvironmentVariable(String str, String str2) {
        return setNativeEnvironmentVariable(str, str2);
    }

    public static void ignoreSignal(Signal signal) {
        ignoreNativeSignal(signal.getValue());
    }

    public static void ffmpegExecute(FFmpegSession fFmpegSession) {
        fFmpegSession.startRunning();
        try {
            fFmpegSession.complete(new ReturnCode(nativeFFmpegExecute(fFmpegSession.getSessionId(), fFmpegSession.getArguments())));
        } catch (Exception e) {
            fFmpegSession.fail(e);
            Log.w(TAG, String.format("FFmpeg execute failed: %s.%s", new Object[]{argumentsToString(fFmpegSession.getArguments()), Exceptions.getStackTraceString(e)}));
        }
    }

    public static void ffprobeExecute(FFprobeSession fFprobeSession) {
        fFprobeSession.startRunning();
        try {
            fFprobeSession.complete(new ReturnCode(nativeFFprobeExecute(fFprobeSession.getSessionId(), fFprobeSession.getArguments())));
        } catch (Exception e) {
            fFprobeSession.fail(e);
            Log.w(TAG, String.format("FFprobe execute failed: %s.%s", new Object[]{argumentsToString(fFprobeSession.getArguments()), Exceptions.getStackTraceString(e)}));
        }
    }

    public static void getMediaInformationExecute(MediaInformationSession mediaInformationSession, int i) {
        mediaInformationSession.startRunning();
        try {
            ReturnCode returnCode = new ReturnCode(nativeFFprobeExecute(mediaInformationSession.getSessionId(), mediaInformationSession.getArguments()));
            mediaInformationSession.complete(returnCode);
            if (returnCode.isValueSuccess()) {
                mediaInformationSession.setMediaInformation(MediaInformationJsonParser.fromWithError(mediaInformationSession.getAllLogsAsString(i)));
            }
        } catch (Exception e) {
            mediaInformationSession.fail(e);
            Log.w(TAG, String.format("Get media information execute failed: %s.%s", new Object[]{argumentsToString(mediaInformationSession.getArguments()), Exceptions.getStackTraceString(e)}));
        }
    }

    public static void asyncFFmpegExecute(FFmpegSession fFmpegSession) {
        fFmpegSession.setFuture(asyncExecutorService.submit(new AsyncFFmpegExecuteTask(fFmpegSession)));
    }

    public static void asyncFFmpegExecute(FFmpegSession fFmpegSession, ExecutorService executorService) {
        fFmpegSession.setFuture(executorService.submit(new AsyncFFmpegExecuteTask(fFmpegSession)));
    }

    public static void asyncFFprobeExecute(FFprobeSession fFprobeSession) {
        fFprobeSession.setFuture(asyncExecutorService.submit(new AsyncFFprobeExecuteTask(fFprobeSession)));
    }

    public static void asyncFFprobeExecute(FFprobeSession fFprobeSession, ExecutorService executorService) {
        fFprobeSession.setFuture(executorService.submit(new AsyncFFprobeExecuteTask(fFprobeSession)));
    }

    public static void asyncGetMediaInformationExecute(MediaInformationSession mediaInformationSession, int i) {
        mediaInformationSession.setFuture(asyncExecutorService.submit(new AsyncGetMediaInformationTask(mediaInformationSession, Integer.valueOf(i))));
    }

    public static void asyncGetMediaInformationExecute(MediaInformationSession mediaInformationSession, ExecutorService executorService, int i) {
        mediaInformationSession.setFuture(executorService.submit(new AsyncGetMediaInformationTask(mediaInformationSession, Integer.valueOf(i))));
    }

    public static int getAsyncConcurrencyLimit() {
        return asyncConcurrencyLimit;
    }

    public static void setAsyncConcurrencyLimit(int i) {
        if (i > 0) {
            asyncConcurrencyLimit = i;
            ExecutorService executorService = asyncExecutorService;
            asyncExecutorService = Executors.newFixedThreadPool(i);
            executorService.shutdown();
        }
    }

    public static void enableLogCallback(LogCallback logCallback) {
        globalLogCallback = logCallback;
    }

    public static void enableStatisticsCallback(StatisticsCallback statisticsCallback) {
        globalStatisticsCallback = statisticsCallback;
    }

    public static void enableFFmpegSessionCompleteCallback(FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback) {
        globalFFmpegSessionCompleteCallback = fFmpegSessionCompleteCallback;
    }

    public static FFmpegSessionCompleteCallback getFFmpegSessionCompleteCallback() {
        return globalFFmpegSessionCompleteCallback;
    }

    public static void enableFFprobeSessionCompleteCallback(FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback) {
        globalFFprobeSessionCompleteCallback = fFprobeSessionCompleteCallback;
    }

    public static FFprobeSessionCompleteCallback getFFprobeSessionCompleteCallback() {
        return globalFFprobeSessionCompleteCallback;
    }

    public static void enableMediaInformationSessionCompleteCallback(MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback) {
        globalMediaInformationSessionCompleteCallback = mediaInformationSessionCompleteCallback;
    }

    public static MediaInformationSessionCompleteCallback getMediaInformationSessionCompleteCallback() {
        return globalMediaInformationSessionCompleteCallback;
    }

    public static Level getLogLevel() {
        return activeLogLevel;
    }

    public static void setLogLevel(Level level) {
        if (level != null) {
            activeLogLevel = level;
            setNativeLogLevel(level.getValue());
        }
    }

    static String extractExtensionFromSafDisplayName(String str) {
        try {
            return new StringTokenizer(str.lastIndexOf(".") >= 0 ? str.substring(str.lastIndexOf(".")) : str, " .").nextToken();
        } catch (Exception e) {
            Log.w(TAG, String.format("Failed to extract extension from saf display name: %s.%s", new Object[]{str, Exceptions.getStackTraceString(e)}));
            return "raw";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r1 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r11 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        throw r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059 A[SYNTHETIC, Splitter:B:26:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSafParameter(android.content.Context r11, android.net.Uri r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "_display_name"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            r3 = 1
            java.lang.String r4 = "ffmpeg-kit"
            r5 = 19
            if (r1 >= r5) goto L_0x0022
            java.lang.Object[] r11 = new java.lang.Object[r3]
            int r12 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r2] = r12
            java.lang.String r12 = "getSafParameter is not supported on API Level %d"
            java.lang.String r11 = java.lang.String.format(r12, r11)
            android.util.Log.i(r4, r11)
            java.lang.String r11 = ""
            return r11
        L_0x0022:
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ all -> 0x0096 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r6 = r12
            android.database.Cursor r1 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0054
            boolean r5 = r1.moveToFirst()     // Catch:{ all -> 0x0040 }
            if (r5 == 0) goto L_0x0054
            int r5 = r1.getColumnIndex(r0)     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = r1.getString(r5)     // Catch:{ all -> 0x0040 }
            goto L_0x0057
        L_0x0040:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r13 = move-exception
            if (r1 == 0) goto L_0x0053
            if (r11 == 0) goto L_0x0050
            r1.close()     // Catch:{ all -> 0x004b }
            goto L_0x0053
        L_0x004b:
            r1 = move-exception
            r11.addSuppressed(r1)     // Catch:{ all -> 0x0096 }
            goto L_0x0053
        L_0x0050:
            r1.close()     // Catch:{ all -> 0x0096 }
        L_0x0053:
            throw r13     // Catch:{ all -> 0x0096 }
        L_0x0054:
            java.lang.String r5 = "unknown"
        L_0x0057:
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ all -> 0x0096 }
        L_0x005c:
            java.util.concurrent.atomic.AtomicInteger r0 = uniqueIdGenerator
            int r0 = r0.getAndIncrement()
            android.util.SparseArray<com.arthenica.ffmpegkit.FFmpegKitConfig$SAFProtocolUrl> r1 = safIdMap
            com.arthenica.ffmpegkit.FFmpegKitConfig$SAFProtocolUrl r2 = new com.arthenica.ffmpegkit.FFmpegKitConfig$SAFProtocolUrl
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            android.content.ContentResolver r11 = r11.getContentResolver()
            r2.<init>(r3, r12, r13, r11)
            r1.put(r0, r2)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "saf:"
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.String r12 = "."
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = extractExtensionFromSafDisplayName(r5)
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            return r11
        L_0x0096:
            r11 = move-exception
            r13 = 3
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r13[r2] = r0
            java.lang.String r12 = r12.toString()
            r13[r3] = r12
            r12 = 2
            java.lang.String r0 = com.arthenica.smartexception.java.Exceptions.getStackTraceString(r11)
            r13[r12] = r0
            java.lang.String r12 = "Failed to get %s column for %s.%s"
            java.lang.String r12 = java.lang.String.format(r12, r13)
            android.util.Log.e(r4, r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arthenica.ffmpegkit.FFmpegKitConfig.getSafParameter(android.content.Context, android.net.Uri, java.lang.String):java.lang.String");
    }

    public static String getSafParameterForRead(Context context, Uri uri) {
        return getSafParameter(context, uri, "r");
    }

    public static String getSafParameterForWrite(Context context, Uri uri) {
        return getSafParameter(context, uri, "w");
    }

    private static int safOpen(int i) {
        try {
            SAFProtocolUrl sAFProtocolUrl = safIdMap.get(i);
            if (sAFProtocolUrl != null) {
                ParcelFileDescriptor openFileDescriptor = sAFProtocolUrl.getContentResolver().openFileDescriptor(sAFProtocolUrl.getUri(), sAFProtocolUrl.getOpenMode());
                sAFProtocolUrl.setParcelFileDescriptor(openFileDescriptor);
                int fd = openFileDescriptor.getFd();
                safFileDescriptorMap.put(fd, sAFProtocolUrl);
                return fd;
            }
            Log.e(TAG, String.format("SAF id %d not found.", new Object[]{Integer.valueOf(i)}));
            return 0;
        } catch (Throwable th) {
            Log.e(TAG, String.format("Failed to open SAF id: %d.%s", new Object[]{Integer.valueOf(i), Exceptions.getStackTraceString(th)}));
        }
    }

    private static int safClose(int i) {
        try {
            SparseArray<SAFProtocolUrl> sparseArray = safFileDescriptorMap;
            SAFProtocolUrl sAFProtocolUrl = sparseArray.get(i);
            if (sAFProtocolUrl != null) {
                ParcelFileDescriptor parcelFileDescriptor = sAFProtocolUrl.getParcelFileDescriptor();
                if (parcelFileDescriptor != null) {
                    sparseArray.delete(i);
                    safIdMap.delete(sAFProtocolUrl.getSafId().intValue());
                    parcelFileDescriptor.close();
                    return 1;
                }
                Log.e(TAG, String.format("ParcelFileDescriptor for SAF fd %d not found.", new Object[]{Integer.valueOf(i)}));
            } else {
                Log.e(TAG, String.format("SAF fd %d not found.", new Object[]{Integer.valueOf(i)}));
            }
        } catch (Throwable th) {
            Log.e(TAG, String.format("Failed to close SAF fd: %d.%s", new Object[]{Integer.valueOf(i), Exceptions.getStackTraceString(th)}));
        }
        return 0;
    }

    public static int getSessionHistorySize() {
        return sessionHistorySize;
    }

    public static void setSessionHistorySize(int i) {
        if (i >= 1000) {
            throw new IllegalArgumentException("Session history size must not exceed the hard limit!");
        } else if (i > 0) {
            sessionHistorySize = i;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|(3:7|8|9))|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void addSession(com.arthenica.ffmpegkit.Session r4) {
        /*
            java.lang.Object r0 = sessionHistoryLock
            monitor-enter(r0)
            java.util.Map<java.lang.Long, com.arthenica.ffmpegkit.Session> r1 = sessionHistoryMap     // Catch:{ all -> 0x0031 }
            long r2 = r4.getSessionId()     // Catch:{ all -> 0x0031 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0031 }
            boolean r2 = r1.containsKey(r2)     // Catch:{ all -> 0x0031 }
            if (r2 != 0) goto L_0x002f
            long r2 = r4.getSessionId()     // Catch:{ all -> 0x0031 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0031 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0031 }
            java.util.List<com.arthenica.ffmpegkit.Session> r1 = sessionHistoryList     // Catch:{ all -> 0x0031 }
            r1.add(r4)     // Catch:{ all -> 0x0031 }
            int r4 = r1.size()     // Catch:{ all -> 0x0031 }
            int r2 = sessionHistorySize     // Catch:{ all -> 0x0031 }
            if (r4 <= r2) goto L_0x002f
            r4 = 0
            r1.remove(r4)     // Catch:{ IndexOutOfBoundsException -> 0x002f }
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arthenica.ffmpegkit.FFmpegKitConfig.addSession(com.arthenica.ffmpegkit.Session):void");
    }

    public static Session getSession(long j) {
        Session session;
        synchronized (sessionHistoryLock) {
            session = sessionHistoryMap.get(Long.valueOf(j));
        }
        return session;
    }

    public static Session getLastSession() {
        synchronized (sessionHistoryLock) {
            List<Session> list = sessionHistoryList;
            if (list.size() <= 0) {
                return null;
            }
            Session session = list.get(list.size() - 1);
            return session;
        }
    }

    public static Session getLastCompletedSession() {
        synchronized (sessionHistoryLock) {
            for (int size = sessionHistoryList.size() - 1; size >= 0; size--) {
                Session session = sessionHistoryList.get(size);
                if (session.getState() == SessionState.COMPLETED) {
                    return session;
                }
            }
            return null;
        }
    }

    public static List<Session> getSessions() {
        LinkedList linkedList;
        synchronized (sessionHistoryLock) {
            linkedList = new LinkedList(sessionHistoryList);
        }
        return linkedList;
    }

    public static void clearSessions() {
        synchronized (sessionHistoryLock) {
            sessionHistoryList.clear();
            sessionHistoryMap.clear();
        }
    }

    public static List<FFmpegSession> getFFmpegSessions() {
        LinkedList linkedList = new LinkedList();
        synchronized (sessionHistoryLock) {
            for (Session next : sessionHistoryList) {
                if (next.isFFmpeg()) {
                    linkedList.add((FFmpegSession) next);
                }
            }
        }
        return linkedList;
    }

    public static List<FFprobeSession> getFFprobeSessions() {
        LinkedList linkedList = new LinkedList();
        synchronized (sessionHistoryLock) {
            for (Session next : sessionHistoryList) {
                if (next.isFFprobe()) {
                    linkedList.add((FFprobeSession) next);
                }
            }
        }
        return linkedList;
    }

    public static List<MediaInformationSession> getMediaInformationSessions() {
        LinkedList linkedList = new LinkedList();
        synchronized (sessionHistoryLock) {
            for (Session next : sessionHistoryList) {
                if (next.isMediaInformation()) {
                    linkedList.add((MediaInformationSession) next);
                }
            }
        }
        return linkedList;
    }

    public static List<Session> getSessionsByState(SessionState sessionState) {
        LinkedList linkedList = new LinkedList();
        synchronized (sessionHistoryLock) {
            for (Session next : sessionHistoryList) {
                if (next.getState() == sessionState) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    public static LogRedirectionStrategy getLogRedirectionStrategy() {
        return globalLogRedirectionStrategy;
    }

    public static void setLogRedirectionStrategy(LogRedirectionStrategy logRedirectionStrategy) {
        globalLogRedirectionStrategy = logRedirectionStrategy;
    }

    public static String sessionStateToString(SessionState sessionState) {
        return sessionState.toString();
    }

    public static String[] parseArguments(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < str.length()) {
            Character valueOf = i > 0 ? Character.valueOf(str.charAt(i - 1)) : null;
            char charAt = str.charAt(i);
            if (charAt == ' ') {
                if (z || z2) {
                    sb.append(charAt);
                } else if (sb.length() > 0) {
                    arrayList.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else if (charAt != '\'' || (valueOf != null && valueOf.charValue() == '\\')) {
                if (charAt != '\"' || (valueOf != null && valueOf.charValue() == '\\')) {
                    sb.append(charAt);
                } else if (z2) {
                    z2 = false;
                } else if (z) {
                    sb.append(charAt);
                } else {
                    z2 = true;
                }
            } else if (z) {
                z = false;
            } else if (z2) {
                sb.append(charAt);
            } else {
                z = true;
            }
            i++;
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String argumentsToString(String[] strArr) {
        if (strArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}
