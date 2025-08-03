package com.RNFetchBlob;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.tonyodev.fetch2core.FetchErrorStrings;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.TlsVersion;

public class RNFetchBlobReq extends BroadcastReceiver implements Runnable {
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    static HashMap<String, RNFetchBlobProgressConfig> progressReport = new HashMap<>();
    public static HashMap<String, Call> taskTable = new HashMap<>();
    static HashMap<String, RNFetchBlobProgressConfig> uploadProgressReport = new HashMap<>();
    Callback callback;
    OkHttpClient client;
    long contentLength;
    String destPath;
    long downloadManagerId;
    ReadableMap headers;
    String method;
    RNFetchBlobConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    ArrayList<String> redirects = new ArrayList<>();
    RNFetchBlobBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseFormat responseFormat = ResponseFormat.Auto;
    ResponseType responseType;
    String taskId;
    boolean timeout = false;
    String url;

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    public RNFetchBlobReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback2) {
        this.method = str2.toUpperCase();
        RNFetchBlobConfig rNFetchBlobConfig = new RNFetchBlobConfig(readableMap);
        this.options = rNFetchBlobConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback2;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        if (rNFetchBlobConfig.fileCache.booleanValue() || this.options.path != null) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        if (taskTable.containsKey(str)) {
            taskTable.get(str).cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) RNFetchBlob.RCTContext.getApplicationContext().getSystemService("download")).remove(new long[]{androidDownloadManagerTaskTable.get(str).longValue()});
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0360 A[Catch:{ Exception -> 0x04ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0414 A[Catch:{ Exception -> 0x04ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x045c A[Catch:{ Exception -> 0x04ac }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ";base64"
            java.lang.String r3 = "post"
            java.lang.String r4 = "Content-Type"
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r5 = "path"
            r6 = 2
            r7 = 1
            if (r0 == 0) goto L_0x0120
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r8 = "useDownloadManager"
            boolean r0 = r0.hasKey(r8)
            if (r0 == 0) goto L_0x0120
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r8)
            if (r0 == 0) goto L_0x0120
            java.lang.String r0 = r1.url
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.DownloadManager$Request r2 = new android.app.DownloadManager$Request
            r2.<init>(r0)
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "notification"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x004e
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r3)
            if (r0 == 0) goto L_0x004e
            r2.setNotificationVisibility(r7)
            goto L_0x0051
        L_0x004e:
            r2.setNotificationVisibility(r6)
        L_0x0051:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "title"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x0069
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            r2.setTitle(r0)
        L_0x0069:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "description"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x0080
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            r2.setDescription(r0)
        L_0x0080:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.hasKey(r5)
            if (r0 == 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "file://"
            java.lang.StringBuilder r0 = r0.append(r3)
            com.RNFetchBlob.RNFetchBlobConfig r3 = r1.options
            com.facebook.react.bridge.ReadableMap r3 = r3.addAndroidDownloads
            java.lang.String r3 = r3.getString(r5)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r2.setDestinationUri(r0)
        L_0x00ac:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "mime"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x00c3
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            r2.setMimeType(r0)
        L_0x00c3:
            com.facebook.react.bridge.ReadableMap r0 = r1.headers
            com.facebook.react.bridge.ReadableMapKeySetIterator r0 = r0.keySetIterator()
            com.RNFetchBlob.RNFetchBlobConfig r3 = r1.options
            com.facebook.react.bridge.ReadableMap r3 = r3.addAndroidDownloads
            java.lang.String r4 = "mediaScannable"
            boolean r3 = r3.hasKey(r4)
            if (r3 == 0) goto L_0x00e2
            com.RNFetchBlob.RNFetchBlobConfig r3 = r1.options
            com.facebook.react.bridge.ReadableMap r3 = r3.addAndroidDownloads
            boolean r3 = r3.hasKey(r4)
            if (r3 == 0) goto L_0x00e2
            r2.allowScanningByMediaScanner()
        L_0x00e2:
            boolean r3 = r0.hasNextKey()
            if (r3 == 0) goto L_0x00f6
            java.lang.String r3 = r0.nextKey()
            com.facebook.react.bridge.ReadableMap r4 = r1.headers
            java.lang.String r4 = r4.getString(r3)
            r2.addRequestHeader(r3, r4)
            goto L_0x00e2
        L_0x00f6:
            com.facebook.react.bridge.ReactApplicationContext r0 = com.RNFetchBlob.RNFetchBlob.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r3 = "download"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.app.DownloadManager r3 = (android.app.DownloadManager) r3
            long r2 = r3.enqueue(r2)
            r1.downloadManagerId = r2
            java.util.HashMap<java.lang.String, java.lang.Long> r4 = androidDownloadManagerTaskTable
            java.lang.String r5 = r1.taskId
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4.put(r5, r2)
            android.content.IntentFilter r2 = new android.content.IntentFilter
            java.lang.String r3 = "android.intent.action.DOWNLOAD_COMPLETE"
            r2.<init>(r3)
            r0.registerReceiver(r1, r2)
            return
        L_0x0120:
            java.lang.String r0 = r1.taskId
            com.RNFetchBlob.RNFetchBlobConfig r8 = r1.options
            java.lang.String r8 = r8.appendExt
            boolean r8 = r8.isEmpty()
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x0130
            r8 = r9
            goto L_0x0147
        L_0x0130:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "."
            java.lang.StringBuilder r8 = r8.append(r10)
            com.RNFetchBlob.RNFetchBlobConfig r10 = r1.options
            java.lang.String r10 = r10.appendExt
            java.lang.StringBuilder r8 = r8.append(r10)
            java.lang.String r8 = r8.toString()
        L_0x0147:
            com.RNFetchBlob.RNFetchBlobConfig r10 = r1.options
            java.lang.String r10 = r10.key
            r11 = 3
            r12 = 0
            r13 = 0
            if (r10 == 0) goto L_0x018e
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            java.lang.String r0 = r0.key
            java.lang.String r0 = com.RNFetchBlob.RNFetchBlobUtils.getMD5(r0)
            if (r0 != 0) goto L_0x015c
            java.lang.String r0 = r1.taskId
        L_0x015c:
            java.io.File r10 = new java.io.File
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = com.RNFetchBlob.RNFetchBlobFS.getTmpPath(r0)
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.StringBuilder r14 = r14.append(r8)
            java.lang.String r14 = r14.toString()
            r10.<init>(r14)
            boolean r14 = r10.exists()
            if (r14 == 0) goto L_0x018e
            com.facebook.react.bridge.Callback r0 = r1.callback
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r2[r13] = r12
            r2[r7] = r5
            java.lang.String r3 = r10.getAbsolutePath()
            r2[r6] = r3
            r0.invoke(r2)
            return
        L_0x018e:
            com.RNFetchBlob.RNFetchBlobConfig r5 = r1.options
            java.lang.String r5 = r5.path
            if (r5 == 0) goto L_0x019b
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options
            java.lang.String r0 = r0.path
            r1.destPath = r0
            goto L_0x01bc
        L_0x019b:
            com.RNFetchBlob.RNFetchBlobConfig r5 = r1.options
            java.lang.Boolean r5 = r5.fileCache
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x01bc
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = com.RNFetchBlob.RNFetchBlobFS.getTmpPath(r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            r1.destPath = r0
        L_0x01bc:
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options     // Catch:{ Exception -> 0x04ac }
            java.lang.Boolean r0 = r0.trusty     // Catch:{ Exception -> 0x04ac }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x04ac }
            if (r0 == 0) goto L_0x01cd
            okhttp3.OkHttpClient r0 = r1.client     // Catch:{ Exception -> 0x04ac }
            okhttp3.OkHttpClient$Builder r0 = com.RNFetchBlob.RNFetchBlobUtils.getUnsafeOkHttpClient(r0)     // Catch:{ Exception -> 0x04ac }
            goto L_0x01d3
        L_0x01cd:
            okhttp3.OkHttpClient r0 = r1.client     // Catch:{ Exception -> 0x04ac }
            okhttp3.OkHttpClient$Builder r0 = r0.newBuilder()     // Catch:{ Exception -> 0x04ac }
        L_0x01d3:
            r5 = r0
            com.RNFetchBlob.RNFetchBlobConfig r0 = r1.options     // Catch:{ Exception -> 0x04ac }
            java.lang.Boolean r0 = r0.wifiOnly     // Catch:{ Exception -> 0x04ac }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x04ac }
            if (r0 == 0) goto L_0x0242
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04ac }
            r8 = 21
            if (r0 < r8) goto L_0x023d
            com.facebook.react.bridge.ReactApplicationContext r0 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ Exception -> 0x04ac }
            com.facebook.react.bridge.ReactApplicationContext r8 = com.RNFetchBlob.RNFetchBlob.RCTContext     // Catch:{ Exception -> 0x04ac }
            java.lang.String r8 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r8)     // Catch:{ Exception -> 0x04ac }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x04ac }
            android.net.Network[] r8 = r0.getAllNetworks()     // Catch:{ Exception -> 0x04ac }
            int r10 = r8.length     // Catch:{ Exception -> 0x04ac }
            r14 = r13
        L_0x01f6:
            if (r14 >= r10) goto L_0x0226
            r15 = r8[r14]     // Catch:{ Exception -> 0x04ac }
            android.net.NetworkInfo r16 = r0.getNetworkInfo(r15)     // Catch:{ Exception -> 0x04ac }
            android.net.NetworkCapabilities r6 = r0.getNetworkCapabilities(r15)     // Catch:{ Exception -> 0x04ac }
            if (r6 == 0) goto L_0x0222
            if (r16 != 0) goto L_0x0207
            goto L_0x0222
        L_0x0207:
            boolean r16 = r16.isConnected()     // Catch:{ Exception -> 0x04ac }
            if (r16 != 0) goto L_0x020e
            goto L_0x0222
        L_0x020e:
            boolean r6 = r6.hasTransport(r7)     // Catch:{ Exception -> 0x04ac }
            if (r6 == 0) goto L_0x0222
            java.net.Proxy r0 = java.net.Proxy.NO_PROXY     // Catch:{ Exception -> 0x04ac }
            r5.proxy(r0)     // Catch:{ Exception -> 0x04ac }
            javax.net.SocketFactory r0 = r15.getSocketFactory()     // Catch:{ Exception -> 0x04ac }
            r5.socketFactory(r0)     // Catch:{ Exception -> 0x04ac }
            r0 = r7
            goto L_0x0227
        L_0x0222:
            int r14 = r14 + 1
            r6 = 2
            goto L_0x01f6
        L_0x0226:
            r0 = r13
        L_0x0227:
            if (r0 != 0) goto L_0x0242
            com.facebook.react.bridge.Callback r0 = r1.callback     // Catch:{ Exception -> 0x04ac }
            java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x04ac }
            java.lang.String r3 = "No available WiFi connections."
            r2[r13] = r3     // Catch:{ Exception -> 0x04ac }
            r2[r7] = r12     // Catch:{ Exception -> 0x04ac }
            r3 = 2
            r2[r3] = r12     // Catch:{ Exception -> 0x04ac }
            r0.invoke(r2)     // Catch:{ Exception -> 0x04ac }
            r17.releaseTaskResource()     // Catch:{ Exception -> 0x04ac }
            return
        L_0x023d:
            java.lang.String r0 = "RNFetchBlob: wifiOnly was set, but SDK < 21. wifiOnly was ignored."
            com.RNFetchBlob.RNFetchBlobUtils.emitWarningEvent(r0)     // Catch:{ Exception -> 0x04ac }
        L_0x0242:
            okhttp3.Request$Builder r6 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x04ac }
            r6.<init>()     // Catch:{ Exception -> 0x04ac }
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0252 }
            java.lang.String r8 = r1.url     // Catch:{ MalformedURLException -> 0x0252 }
            r0.<init>(r8)     // Catch:{ MalformedURLException -> 0x0252 }
            r6.url((java.net.URL) r0)     // Catch:{ MalformedURLException -> 0x0252 }
            goto L_0x0256
        L_0x0252:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x04ac }
        L_0x0256:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x04ac }
            r0.<init>()     // Catch:{ Exception -> 0x04ac }
            com.facebook.react.bridge.ReadableMap r8 = r1.headers     // Catch:{ Exception -> 0x04ac }
            if (r8 == 0) goto L_0x02a5
            com.facebook.react.bridge.ReadableMapKeySetIterator r8 = r8.keySetIterator()     // Catch:{ Exception -> 0x04ac }
        L_0x0263:
            boolean r10 = r8.hasNextKey()     // Catch:{ Exception -> 0x04ac }
            if (r10 == 0) goto L_0x02a5
            java.lang.String r10 = r8.nextKey()     // Catch:{ Exception -> 0x04ac }
            com.facebook.react.bridge.ReadableMap r14 = r1.headers     // Catch:{ Exception -> 0x04ac }
            java.lang.String r14 = r14.getString(r10)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r15 = "RNFB-Response"
            boolean r15 = r10.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x04ac }
            if (r15 == 0) goto L_0x0296
            java.lang.String r10 = "base64"
            boolean r10 = r14.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x04ac }
            if (r10 == 0) goto L_0x0288
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r10 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.BASE64     // Catch:{ Exception -> 0x04ac }
            r1.responseFormat = r10     // Catch:{ Exception -> 0x04ac }
            goto L_0x0263
        L_0x0288:
            java.lang.String r10 = "utf8"
            boolean r10 = r14.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x04ac }
            if (r10 == 0) goto L_0x0263
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r10 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.UTF8     // Catch:{ Exception -> 0x04ac }
            r1.responseFormat = r10     // Catch:{ Exception -> 0x04ac }
            goto L_0x0263
        L_0x0296:
            java.lang.String r15 = r10.toLowerCase()     // Catch:{ Exception -> 0x04ac }
            r6.header(r15, r14)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r10 = r10.toLowerCase()     // Catch:{ Exception -> 0x04ac }
            r0.put(r10, r14)     // Catch:{ Exception -> 0x04ac }
            goto L_0x0263
        L_0x02a5:
            java.lang.String r8 = r1.method     // Catch:{ Exception -> 0x04ac }
            boolean r8 = r8.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r10 = "patch"
            java.lang.String r14 = "put"
            java.lang.String r15 = "content-type"
            if (r8 != 0) goto L_0x02ca
            java.lang.String r8 = r1.method     // Catch:{ Exception -> 0x04ac }
            boolean r8 = r8.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04ac }
            if (r8 != 0) goto L_0x02ca
            java.lang.String r8 = r1.method     // Catch:{ Exception -> 0x04ac }
            boolean r8 = r8.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x04ac }
            if (r8 == 0) goto L_0x02c4
            goto L_0x02ca
        L_0x02c4:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r2 = com.RNFetchBlob.RNFetchBlobReq.RequestType.WithoutBody     // Catch:{ Exception -> 0x04ac }
            r1.requestType = r2     // Catch:{ Exception -> 0x04ac }
            goto L_0x0348
        L_0x02ca:
            java.lang.String r8 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ Exception -> 0x04ac }
            com.facebook.react.bridge.ReadableArray r13 = r1.rawRequestBodyArray     // Catch:{ Exception -> 0x04ac }
            if (r13 == 0) goto L_0x02db
            com.RNFetchBlob.RNFetchBlobReq$RequestType r13 = com.RNFetchBlob.RNFetchBlobReq.RequestType.Form     // Catch:{ Exception -> 0x04ac }
            r1.requestType = r13     // Catch:{ Exception -> 0x04ac }
            goto L_0x02f0
        L_0x02db:
            boolean r13 = r8.isEmpty()     // Catch:{ Exception -> 0x04ac }
            if (r13 == 0) goto L_0x02f0
            boolean r13 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x04ac }
            if (r13 != 0) goto L_0x02ec
            java.lang.String r13 = "application/octet-stream"
            r6.header(r4, r13)     // Catch:{ Exception -> 0x04ac }
        L_0x02ec:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r13 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04ac }
            r1.requestType = r13     // Catch:{ Exception -> 0x04ac }
        L_0x02f0:
            java.lang.String r13 = r1.rawRequestBody     // Catch:{ Exception -> 0x04ac }
            if (r13 == 0) goto L_0x0348
            java.lang.String r12 = "RNFetchBlob-file://"
            boolean r12 = r13.startsWith(r12)     // Catch:{ Exception -> 0x04ac }
            if (r12 != 0) goto L_0x0344
            java.lang.String r12 = r1.rawRequestBody     // Catch:{ Exception -> 0x04ac }
            java.lang.String r13 = "RNFetchBlob-content://"
            boolean r12 = r12.startsWith(r13)     // Catch:{ Exception -> 0x04ac }
            if (r12 == 0) goto L_0x0307
            goto L_0x0344
        L_0x0307:
            java.lang.String r12 = r8.toLowerCase()     // Catch:{ Exception -> 0x04ac }
            boolean r12 = r12.contains(r2)     // Catch:{ Exception -> 0x04ac }
            if (r12 != 0) goto L_0x0323
            java.lang.String r12 = r8.toLowerCase()     // Catch:{ Exception -> 0x04ac }
            java.lang.String r13 = "application/octet"
            boolean r12 = r12.startsWith(r13)     // Catch:{ Exception -> 0x04ac }
            if (r12 == 0) goto L_0x031e
            goto L_0x0323
        L_0x031e:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r2 = com.RNFetchBlob.RNFetchBlobReq.RequestType.AsIs     // Catch:{ Exception -> 0x04ac }
            r1.requestType = r2     // Catch:{ Exception -> 0x04ac }
            goto L_0x0348
        L_0x0323:
            java.lang.String r2 = r8.replace(r2, r9)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r8 = ";BASE64"
            java.lang.String r2 = r2.replace(r8, r9)     // Catch:{ Exception -> 0x04ac }
            boolean r8 = r0.containsKey(r15)     // Catch:{ Exception -> 0x04ac }
            if (r8 == 0) goto L_0x0336
            r0.put(r15, r2)     // Catch:{ Exception -> 0x04ac }
        L_0x0336:
            boolean r8 = r0.containsKey(r4)     // Catch:{ Exception -> 0x04ac }
            if (r8 == 0) goto L_0x033f
            r0.put(r4, r2)     // Catch:{ Exception -> 0x04ac }
        L_0x033f:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r2 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04ac }
            r1.requestType = r2     // Catch:{ Exception -> 0x04ac }
            goto L_0x0348
        L_0x0344:
            com.RNFetchBlob.RNFetchBlobReq$RequestType r2 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04ac }
            r1.requestType = r2     // Catch:{ Exception -> 0x04ac }
        L_0x0348:
            java.lang.String r2 = "Transfer-Encoding"
            java.lang.String r2 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r4 = "chunked"
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x04ac }
            int[] r4 = com.RNFetchBlob.RNFetchBlobReq.AnonymousClass4.$SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r8 = r1.requestType     // Catch:{ Exception -> 0x04ac }
            int r8 = r8.ordinal()     // Catch:{ Exception -> 0x04ac }
            r4 = r4[r8]     // Catch:{ Exception -> 0x04ac }
            if (r4 == r7) goto L_0x0414
            r8 = 2
            if (r4 == r8) goto L_0x03e9
            if (r4 == r11) goto L_0x039a
            r0 = 4
            if (r4 == r0) goto L_0x036a
            goto L_0x043e
        L_0x036a:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ac }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x04ac }
            if (r0 != 0) goto L_0x038b
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ac }
            boolean r0 = r0.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04ac }
            if (r0 != 0) goto L_0x038b
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ac }
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x04ac }
            if (r0 == 0) goto L_0x0383
            goto L_0x038b
        L_0x0383:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ac }
            r2 = 0
            r6.method(r0, r2)     // Catch:{ Exception -> 0x04ac }
            goto L_0x043e
        L_0x038b:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ac }
            r2 = 0
            byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x04ac }
            r2 = 0
            okhttp3.RequestBody r2 = okhttp3.RequestBody.create((okhttp3.MediaType) r2, (byte[]) r3)     // Catch:{ Exception -> 0x04ac }
            r6.method(r0, r2)     // Catch:{ Exception -> 0x04ac }
            goto L_0x043e
        L_0x039a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ac }
            r0.<init>()     // Catch:{ Exception -> 0x04ac }
            java.lang.String r3 = "RNFetchBlob-"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r3 = r1.taskId     // Catch:{ Exception -> 0x04ac }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r3 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x04ac }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x04ac }
            r3.<init>(r4)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x04ac }
            com.facebook.react.bridge.ReadableArray r3 = r1.rawRequestBodyArray     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r2.setBody((com.facebook.react.bridge.ReadableArray) r3)     // Catch:{ Exception -> 0x04ac }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ac }
            r3.<init>()     // Catch:{ Exception -> 0x04ac }
            java.lang.String r4 = "multipart/form-data; boundary="
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x04ac }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04ac }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x04ac }
            r1.requestBody = r0     // Catch:{ Exception -> 0x04ac }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x04ac }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x04ac }
            goto L_0x043e
        L_0x03e9:
            com.RNFetchBlob.RNFetchBlobBody r3 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x04ac }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x04ac }
            r3.<init>(r4)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r3 = r1.rawRequestBody     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r2.setBody((java.lang.String) r3)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r0 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r15)     // Catch:{ Exception -> 0x04ac }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x04ac }
            r1.requestBody = r0     // Catch:{ Exception -> 0x04ac }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x04ac }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x04ac }
            goto L_0x043e
        L_0x0414:
            com.RNFetchBlob.RNFetchBlobBody r3 = new com.RNFetchBlob.RNFetchBlobBody     // Catch:{ Exception -> 0x04ac }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x04ac }
            r3.<init>(r4)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r3 = r1.rawRequestBody     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r2 = r2.setBody((java.lang.String) r3)     // Catch:{ Exception -> 0x04ac }
            java.lang.String r0 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r15)     // Catch:{ Exception -> 0x04ac }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x04ac }
            r1.requestBody = r0     // Catch:{ Exception -> 0x04ac }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x04ac }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x04ac }
        L_0x043e:
            okhttp3.Request r0 = r6.build()     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobReq$1 r2 = new com.RNFetchBlob.RNFetchBlobReq$1     // Catch:{ Exception -> 0x04ac }
            r2.<init>()     // Catch:{ Exception -> 0x04ac }
            r5.addNetworkInterceptor(r2)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobReq$2 r2 = new com.RNFetchBlob.RNFetchBlobReq$2     // Catch:{ Exception -> 0x04ac }
            r2.<init>(r0)     // Catch:{ Exception -> 0x04ac }
            r5.addInterceptor(r2)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobConfig r2 = r1.options     // Catch:{ Exception -> 0x04ac }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x04ac }
            r8 = 0
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x046e
            com.RNFetchBlob.RNFetchBlobConfig r2 = r1.options     // Catch:{ Exception -> 0x04ac }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x04ac }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x04ac }
            r5.connectTimeout(r2, r4)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobConfig r2 = r1.options     // Catch:{ Exception -> 0x04ac }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x04ac }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x04ac }
            r5.readTimeout(r2, r4)     // Catch:{ Exception -> 0x04ac }
        L_0x046e:
            okhttp3.ConnectionPool r2 = pool     // Catch:{ Exception -> 0x04ac }
            r5.connectionPool(r2)     // Catch:{ Exception -> 0x04ac }
            r2 = 0
            r5.retryOnConnectionFailure(r2)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobConfig r2 = r1.options     // Catch:{ Exception -> 0x04ac }
            java.lang.Boolean r2 = r2.followRedirect     // Catch:{ Exception -> 0x04ac }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x04ac }
            r5.followRedirects(r2)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobConfig r2 = r1.options     // Catch:{ Exception -> 0x04ac }
            java.lang.Boolean r2 = r2.followRedirect     // Catch:{ Exception -> 0x04ac }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x04ac }
            r5.followSslRedirects(r2)     // Catch:{ Exception -> 0x04ac }
            r5.retryOnConnectionFailure(r7)     // Catch:{ Exception -> 0x04ac }
            okhttp3.OkHttpClient$Builder r2 = enableTls12OnPreLollipop(r5)     // Catch:{ Exception -> 0x04ac }
            okhttp3.OkHttpClient r2 = r2.build()     // Catch:{ Exception -> 0x04ac }
            okhttp3.Call r0 = r2.newCall(r0)     // Catch:{ Exception -> 0x04ac }
            java.util.HashMap<java.lang.String, okhttp3.Call> r2 = taskTable     // Catch:{ Exception -> 0x04ac }
            java.lang.String r3 = r1.taskId     // Catch:{ Exception -> 0x04ac }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x04ac }
            com.RNFetchBlob.RNFetchBlobReq$3 r2 = new com.RNFetchBlob.RNFetchBlobReq$3     // Catch:{ Exception -> 0x04ac }
            r2.<init>()     // Catch:{ Exception -> 0x04ac }
            r0.enqueue(r2)     // Catch:{ Exception -> 0x04ac }
            goto L_0x04dc
        L_0x04ac:
            r0 = move-exception
            r0.printStackTrace()
            r17.releaseTaskResource()
            com.facebook.react.bridge.Callback r2 = r1.callback
            java.lang.Object[] r3 = new java.lang.Object[r7]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "RNFetchBlob request error: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r0.getMessage()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.Throwable r0 = r0.getCause()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            r4 = 0
            r3[r4] = r0
            r2.invoke(r3)
        L_0x04dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.run():void");
    }

    /* renamed from: com.RNFetchBlob.RNFetchBlobReq$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType;
        static final /* synthetic */ int[] $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        static {
            /*
                com.RNFetchBlob.RNFetchBlobReq$ResponseType[] r0 = com.RNFetchBlob.RNFetchBlobReq.ResponseType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType = r0
                r1 = 1
                com.RNFetchBlob.RNFetchBlobReq$ResponseType r2 = com.RNFetchBlob.RNFetchBlobReq.ResponseType.KeepInMemory     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.RNFetchBlob.RNFetchBlobReq$ResponseType r3 = com.RNFetchBlob.RNFetchBlobReq.ResponseType.FileStorage     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.RNFetchBlob.RNFetchBlobReq$RequestType[] r2 = com.RNFetchBlob.RNFetchBlobReq.RequestType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType = r2
                com.RNFetchBlob.RNFetchBlobReq$RequestType r3 = com.RNFetchBlob.RNFetchBlobReq.RequestType.SingleFile     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.RNFetchBlob.RNFetchBlobReq$RequestType r2 = com.RNFetchBlob.RNFetchBlobReq.RequestType.AsIs     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.RNFetchBlob.RNFetchBlobReq$RequestType r1 = com.RNFetchBlob.RNFetchBlobReq.RequestType.Form     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType     // Catch:{ NoSuchFieldError -> 0x004e }
                com.RNFetchBlob.RNFetchBlobReq$RequestType r1 = com.RNFetchBlob.RNFetchBlobReq.RequestType.WithoutBody     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.AnonymousClass4.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        RNFetchBlobBody rNFetchBlobBody = this.requestBody;
        if (rNFetchBlobBody != null) {
            rNFetchBlobBody.clearRequestBody();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:32|33|34|35|(1:37)(1:38)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x011e */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0124 A[Catch:{ IOException -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0137 A[Catch:{ IOException -> 0x0149 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void done(okhttp3.Response r13) {
        /*
            r12 = this;
            boolean r0 = r12.isBlobResponse(r13)
            com.facebook.react.bridge.WritableMap r1 = r12.getResponseInfo(r13, r0)
            r12.emitStateEvent(r1)
            int[] r1 = com.RNFetchBlob.RNFetchBlobReq.AnonymousClass4.$SwitchMap$com$RNFetchBlob$RNFetchBlobReq$ResponseType
            com.RNFetchBlob.RNFetchBlobReq$ResponseType r2 = r12.responseType
            int r2 = r2.ordinal()
            r1 = r1[r2]
            java.lang.String r2 = "path"
            java.lang.String r3 = "UTF-8"
            java.lang.String r4 = "utf8"
            r5 = 3
            r6 = 0
            r7 = 0
            r8 = 1
            r9 = 2
            if (r1 == r8) goto L_0x008b
            if (r1 == r9) goto L_0x0050
            com.facebook.react.bridge.Callback r0 = r12.callback     // Catch:{ IOException -> 0x0041 }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0041 }
            r1[r7] = r6     // Catch:{ IOException -> 0x0041 }
            r1[r8] = r4     // Catch:{ IOException -> 0x0041 }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0041 }
            okhttp3.ResponseBody r4 = r13.body()     // Catch:{ IOException -> 0x0041 }
            byte[] r4 = r4.bytes()     // Catch:{ IOException -> 0x0041 }
            r2.<init>(r4, r3)     // Catch:{ IOException -> 0x0041 }
            r1[r9] = r2     // Catch:{ IOException -> 0x0041 }
            r0.invoke(r1)     // Catch:{ IOException -> 0x0041 }
            goto L_0x0156
        L_0x0041:
            com.facebook.react.bridge.Callback r0 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r9]
            java.lang.String r2 = "RNFetchBlob failed to encode response data to UTF8 string."
            r1[r7] = r2
            r1[r8] = r6
            r0.invoke(r1)
            goto L_0x0156
        L_0x0050:
            okhttp3.ResponseBody r0 = r13.body()
            r0.bytes()     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            com.RNFetchBlob.Response.RNFetchBlobFileResp r0 = (com.RNFetchBlob.Response.RNFetchBlobFileResp) r0
            if (r0 == 0) goto L_0x0070
            boolean r0 = r0.isDownloadComplete()
            if (r0 != 0) goto L_0x0070
            com.facebook.react.bridge.Callback r0 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r9]
            java.lang.String r2 = "Download interrupted."
            r1[r7] = r2
            r1[r8] = r6
            r0.invoke(r1)
            goto L_0x0156
        L_0x0070:
            java.lang.String r0 = r12.destPath
            java.lang.String r1 = "?append=true"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r1, r3)
            r12.destPath = r0
            com.facebook.react.bridge.Callback r1 = r12.callback
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r7] = r6
            r3[r8] = r2
            r3[r9] = r0
            r1.invoke(r3)
            goto L_0x0156
        L_0x008b:
            if (r0 == 0) goto L_0x00d6
            com.RNFetchBlob.RNFetchBlobConfig r0 = r12.options     // Catch:{ IOException -> 0x0149 }
            java.lang.Boolean r0 = r0.auto     // Catch:{ IOException -> 0x0149 }
            boolean r0 = r0.booleanValue()     // Catch:{ IOException -> 0x0149 }
            if (r0 == 0) goto L_0x00d6
            java.lang.String r0 = r12.taskId     // Catch:{ IOException -> 0x0149 }
            java.lang.String r0 = com.RNFetchBlob.RNFetchBlobFS.getTmpPath(r0)     // Catch:{ IOException -> 0x0149 }
            okhttp3.ResponseBody r1 = r13.body()     // Catch:{ IOException -> 0x0149 }
            java.io.InputStream r1 = r1.byteStream()     // Catch:{ IOException -> 0x0149 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0149 }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0149 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x0149 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0149 }
            r4 = 10240(0x2800, float:1.4349E-41)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0149 }
        L_0x00b3:
            int r10 = r1.read(r4)     // Catch:{ IOException -> 0x0149 }
            r11 = -1
            if (r10 == r11) goto L_0x00be
            r3.write(r4, r7, r10)     // Catch:{ IOException -> 0x0149 }
            goto L_0x00b3
        L_0x00be:
            r1.close()     // Catch:{ IOException -> 0x0149 }
            r3.flush()     // Catch:{ IOException -> 0x0149 }
            r3.close()     // Catch:{ IOException -> 0x0149 }
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ IOException -> 0x0149 }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0149 }
            r3[r7] = r6     // Catch:{ IOException -> 0x0149 }
            r3[r8] = r2     // Catch:{ IOException -> 0x0149 }
            r3[r9] = r0     // Catch:{ IOException -> 0x0149 }
            r1.invoke(r3)     // Catch:{ IOException -> 0x0149 }
            goto L_0x0156
        L_0x00d6:
            okhttp3.ResponseBody r0 = r13.body()     // Catch:{ IOException -> 0x0149 }
            byte[] r0 = r0.bytes()     // Catch:{ IOException -> 0x0149 }
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r3)     // Catch:{ IOException -> 0x0149 }
            java.nio.charset.CharsetEncoder r1 = r1.newEncoder()     // Catch:{ IOException -> 0x0149 }
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r2 = r12.responseFormat     // Catch:{ IOException -> 0x0149 }
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r3 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.BASE64     // Catch:{ IOException -> 0x0149 }
            java.lang.String r10 = "base64"
            if (r2 != r3) goto L_0x0100
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ IOException -> 0x0149 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0149 }
            r2[r7] = r6     // Catch:{ IOException -> 0x0149 }
            r2[r8] = r10     // Catch:{ IOException -> 0x0149 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r9)     // Catch:{ IOException -> 0x0149 }
            r2[r9] = r0     // Catch:{ IOException -> 0x0149 }
            r1.invoke(r2)     // Catch:{ IOException -> 0x0149 }
            return
        L_0x0100:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.CharBuffer r2 = r2.asCharBuffer()     // Catch:{ CharacterCodingException -> 0x011e }
            r1.encode(r2)     // Catch:{ CharacterCodingException -> 0x011e }
            java.lang.String r1 = new java.lang.String     // Catch:{ CharacterCodingException -> 0x011e }
            r1.<init>(r0)     // Catch:{ CharacterCodingException -> 0x011e }
            com.facebook.react.bridge.Callback r2 = r12.callback     // Catch:{ CharacterCodingException -> 0x011e }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ CharacterCodingException -> 0x011e }
            r3[r7] = r6     // Catch:{ CharacterCodingException -> 0x011e }
            r3[r8] = r4     // Catch:{ CharacterCodingException -> 0x011e }
            r3[r9] = r1     // Catch:{ CharacterCodingException -> 0x011e }
            r2.invoke(r3)     // Catch:{ CharacterCodingException -> 0x011e }
            goto L_0x0156
        L_0x011e:
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r1 = r12.responseFormat     // Catch:{ IOException -> 0x0149 }
            com.RNFetchBlob.RNFetchBlobReq$ResponseFormat r2 = com.RNFetchBlob.RNFetchBlobReq.ResponseFormat.UTF8     // Catch:{ IOException -> 0x0149 }
            if (r1 != r2) goto L_0x0137
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x0149 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0149 }
            com.facebook.react.bridge.Callback r0 = r12.callback     // Catch:{ IOException -> 0x0149 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0149 }
            r2[r7] = r6     // Catch:{ IOException -> 0x0149 }
            r2[r8] = r4     // Catch:{ IOException -> 0x0149 }
            r2[r9] = r1     // Catch:{ IOException -> 0x0149 }
            r0.invoke(r2)     // Catch:{ IOException -> 0x0149 }
            goto L_0x0156
        L_0x0137:
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ IOException -> 0x0149 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0149 }
            r2[r7] = r6     // Catch:{ IOException -> 0x0149 }
            r2[r8] = r10     // Catch:{ IOException -> 0x0149 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r9)     // Catch:{ IOException -> 0x0149 }
            r2[r9] = r0     // Catch:{ IOException -> 0x0149 }
            r1.invoke(r2)     // Catch:{ IOException -> 0x0149 }
            goto L_0x0156
        L_0x0149:
            com.facebook.react.bridge.Callback r0 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r9]
            java.lang.String r2 = "RNFetchBlob failed to encode response data to BASE64 string."
            r1[r7] = r2
            r1[r8] = r6
            r0.invoke(r1)
        L_0x0156:
            okhttp3.ResponseBody r13 = r13.body()
            r13.close()
            r12.releaseTaskResource()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.done(okhttp3.Response):void");
    }

    public static RNFetchBlobProgressConfig getReportProgress(String str) {
        if (!progressReport.containsKey(str)) {
            return null;
        }
        return progressReport.get(str);
    }

    public static RNFetchBlobProgressConfig getReportUploadProgress(String str) {
        if (!uploadProgressReport.containsKey(str)) {
            return null;
        }
        return uploadProgressReport.get(str);
    }

    private WritableMap getResponseInfo(Response response, boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("status", response.code());
        createMap.putString("state", ExifInterface.GPS_MEASUREMENT_2D);
        createMap.putString("taskId", this.taskId);
        createMap.putBoolean(FetchErrorStrings.CONNECTION_TIMEOUT, this.timeout);
        WritableMap createMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            createMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray createArray = Arguments.createArray();
        Iterator<String> it2 = this.redirects.iterator();
        while (it2.hasNext()) {
            createArray.pushString(it2.next());
        }
        createMap.putArray("redirects", createArray);
        createMap.putMap("headers", createMap2);
        Headers headers2 = response.headers();
        if (z) {
            createMap.putString("respType", "blob");
        } else if (getHeaderIgnoreCases(headers2, "content-type").equalsIgnoreCase("text/")) {
            createMap.putString("respType", "text");
        } else if (getHeaderIgnoreCases(headers2, "content-type").contains("application/json")) {
            createMap.putString("respType", "json");
        } else {
            createMap.putString("respType", "");
        }
        return createMap;
    }

    private boolean isBlobResponse(Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), "Content-Type");
        boolean z2 = !headerIgnoreCases.equalsIgnoreCase("text/");
        boolean z3 = !headerIgnoreCases.equalsIgnoreCase("application/json");
        if (this.options.binaryContentTypes != null) {
            int i = 0;
            while (true) {
                if (i >= this.options.binaryContentTypes.size()) {
                    break;
                } else if (headerIgnoreCases.toLowerCase().contains(this.options.binaryContentTypes.getString(i).toLowerCase())) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        z = false;
        if ((z3 || z2) && !z) {
            return false;
        }
        return true;
    }

    private String getHeaderIgnoreCases(Headers headers2, String str) {
        String str2 = headers2.get(str);
        if (str2 != null) {
            return str2;
        }
        return headers2.get(str.toLowerCase()) == null ? "" : headers2.get(str.toLowerCase());
    }

    private String getHeaderIgnoreCases(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = hashMap.get(str.toLowerCase());
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNFetchBlob.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(RNFetchBlobConst.EVENT_HTTP_STATE, writableMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0113 A[SYNTHETIC, Splitter:B:32:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            r13 = this;
            java.lang.String r14 = "mime"
            java.lang.String r0 = r15.getAction()
            java.lang.String r1 = "android.intent.action.DOWNLOAD_COMPLETE"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0177
            com.facebook.react.bridge.ReactApplicationContext r0 = com.RNFetchBlob.RNFetchBlob.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            android.os.Bundle r15 = r15.getExtras()
            java.lang.String r1 = "extra_download_id"
            long r1 = r15.getLong(r1)
            long r3 = r13.downloadManagerId
            int r15 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r15 != 0) goto L_0x0177
            r13.releaseTaskResource()
            android.app.DownloadManager$Query r15 = new android.app.DownloadManager$Query
            r15.<init>()
            r1 = 1
            long[] r2 = new long[r1]
            long r3 = r13.downloadManagerId
            r5 = 0
            r2[r5] = r3
            r15.setFilterById(r2)
            java.lang.String r2 = "download"
            java.lang.Object r2 = r0.getSystemService(r2)
            android.app.DownloadManager r2 = (android.app.DownloadManager) r2
            r2.query(r15)
            android.database.Cursor r15 = r2.query(r15)
            java.lang.String r2 = "Download manager failed to download from  "
            r3 = 3
            r4 = 2
            r6 = 0
            if (r15 != 0) goto L_0x0074
            com.facebook.react.bridge.Callback r14 = r13.callback
            java.lang.Object[] r15 = new java.lang.Object[r3]
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r13.url
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = ". Query was unsuccessful "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r15[r5] = r0
            r15[r1] = r6
            r15[r4] = r6
            r14.invoke(r15)
            return
        L_0x0074:
            boolean r7 = r15.moveToFirst()     // Catch:{ all -> 0x0170 }
            if (r7 == 0) goto L_0x0101
            java.lang.String r7 = "status"
            int r7 = r15.getColumnIndex(r7)     // Catch:{ all -> 0x0170 }
            int r7 = r15.getInt(r7)     // Catch:{ all -> 0x0170 }
            r8 = 16
            if (r7 != r8) goto L_0x00b9
            com.facebook.react.bridge.Callback r14 = r13.callback     // Catch:{ all -> 0x0170 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r3.<init>()     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = r13.url     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = ". Status Code = "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0170 }
            r0[r5] = r2     // Catch:{ all -> 0x0170 }
            r0[r1] = r6     // Catch:{ all -> 0x0170 }
            r0[r4] = r6     // Catch:{ all -> 0x0170 }
            r14.invoke(r0)     // Catch:{ all -> 0x0170 }
            if (r15 == 0) goto L_0x00b8
            r15.close()
        L_0x00b8:
            return
        L_0x00b9:
            java.lang.String r2 = "local_uri"
            int r2 = r15.getColumnIndex(r2)     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = r15.getString(r2)     // Catch:{ all -> 0x0170 }
            if (r2 == 0) goto L_0x0101
            com.RNFetchBlob.RNFetchBlobConfig r7 = r13.options     // Catch:{ all -> 0x0170 }
            com.facebook.react.bridge.ReadableMap r7 = r7.addAndroidDownloads     // Catch:{ all -> 0x0170 }
            boolean r7 = r7.hasKey(r14)     // Catch:{ all -> 0x0170 }
            if (r7 == 0) goto L_0x0101
            com.RNFetchBlob.RNFetchBlobConfig r7 = r13.options     // Catch:{ all -> 0x0170 }
            com.facebook.react.bridge.ReadableMap r7 = r7.addAndroidDownloads     // Catch:{ all -> 0x0170 }
            java.lang.String r14 = r7.getString(r14)     // Catch:{ all -> 0x0170 }
            java.lang.String r7 = "image"
            boolean r14 = r14.contains(r7)     // Catch:{ all -> 0x0170 }
            if (r14 == 0) goto L_0x0101
            android.net.Uri r8 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x0170 }
            android.content.ContentResolver r7 = r0.getContentResolver()     // Catch:{ all -> 0x0170 }
            java.lang.String r14 = "_data"
            java.lang.String[] r9 = new java.lang.String[]{r14}     // Catch:{ all -> 0x0170 }
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r14 = r7.query(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0170 }
            if (r14 == 0) goto L_0x0101
            r14.moveToFirst()     // Catch:{ all -> 0x0170 }
            java.lang.String r0 = r14.getString(r5)     // Catch:{ all -> 0x0170 }
            r14.close()     // Catch:{ all -> 0x0170 }
            goto L_0x0102
        L_0x0101:
            r0 = r6
        L_0x0102:
            if (r15 == 0) goto L_0x0107
            r15.close()
        L_0x0107:
            com.RNFetchBlob.RNFetchBlobConfig r14 = r13.options
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads
            java.lang.String r15 = "path"
            boolean r14 = r14.hasKey(r15)
            if (r14 == 0) goto L_0x0150
            com.RNFetchBlob.RNFetchBlobConfig r14 = r13.options     // Catch:{ Exception -> 0x013c }
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads     // Catch:{ Exception -> 0x013c }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x013c }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x013c }
            r0.<init>(r14)     // Catch:{ Exception -> 0x013c }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x013c }
            if (r0 == 0) goto L_0x0134
            com.facebook.react.bridge.Callback r0 = r13.callback     // Catch:{ Exception -> 0x013c }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x013c }
            r2[r5] = r6     // Catch:{ Exception -> 0x013c }
            r2[r1] = r15     // Catch:{ Exception -> 0x013c }
            r2[r4] = r14     // Catch:{ Exception -> 0x013c }
            r0.invoke(r2)     // Catch:{ Exception -> 0x013c }
            goto L_0x0177
        L_0x0134:
            java.lang.Exception r14 = new java.lang.Exception     // Catch:{ Exception -> 0x013c }
            java.lang.String r15 = "Download manager download failed, the file does not downloaded to destination."
            r14.<init>(r15)     // Catch:{ Exception -> 0x013c }
            throw r14     // Catch:{ Exception -> 0x013c }
        L_0x013c:
            r14 = move-exception
            r14.printStackTrace()
            com.facebook.react.bridge.Callback r15 = r13.callback
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r14 = r14.getLocalizedMessage()
            r0[r5] = r14
            r0[r1] = r6
            r15.invoke(r0)
            goto L_0x0177
        L_0x0150:
            if (r0 != 0) goto L_0x0162
            com.facebook.react.bridge.Callback r14 = r13.callback
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r2 = "Download manager could not resolve downloaded file path."
            r0[r5] = r2
            r0[r1] = r15
            r0[r4] = r6
            r14.invoke(r0)
            goto L_0x0177
        L_0x0162:
            com.facebook.react.bridge.Callback r14 = r13.callback
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r6
            r2[r1] = r15
            r2[r4] = r0
            r14.invoke(r2)
            goto L_0x0177
        L_0x0170:
            r14 = move-exception
            if (r15 == 0) goto L_0x0176
            r15.close()
        L_0x0176:
            throw r14
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobReq.onReceive(android.content.Context, android.content.Intent):void");
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19) {
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init((KeyStore) null);
                TrustManager[] trustManagers = instance.getTrustManagers();
                if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                    throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                }
                X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
                SSLContext instance2 = SSLContext.getInstance("SSL");
                instance2.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
                builder.sslSocketFactory(instance2.getSocketFactory(), x509TrustManager);
                ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
                ArrayList arrayList = new ArrayList();
                arrayList.add(build);
                arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
                arrayList.add(ConnectionSpec.CLEARTEXT);
                builder.connectionSpecs(arrayList);
            } catch (Exception e) {
                FLog.e("OkHttpClientProvider", "Error while enabling TLS 1.2", (Throwable) e);
            }
        }
        return builder;
    }
}
