package com.facebook.react.devsupport;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.MultipartStreamReader;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleDownloader {
    private static final int FILES_CHANGED_COUNT_NOT_BUILT_BY_BUNDLER = -2;
    private static final String TAG = "BundleDownloader";
    private final OkHttpClient mClient;
    /* access modifiers changed from: private */
    public Call mDownloadBundleFromURLCall;

    private String formatBundleUrl(String str) {
        return str;
    }

    public static class BundleInfo {
        /* access modifiers changed from: private */
        public int mFilesChangedCount;
        /* access modifiers changed from: private */
        public String mUrl;

        public static BundleInfo fromJSONString(String str) {
            if (str == null) {
                return null;
            }
            BundleInfo bundleInfo = new BundleInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bundleInfo.mUrl = jSONObject.getString(ImagesContract.URL);
                bundleInfo.mFilesChangedCount = jSONObject.getInt("filesChangedCount");
                return bundleInfo;
            } catch (JSONException e) {
                FLog.e(BundleDownloader.TAG, "Invalid bundle info: ", (Throwable) e);
                return null;
            }
        }

        public String toJSONString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ImagesContract.URL, this.mUrl);
                jSONObject.put("filesChangedCount", this.mFilesChangedCount);
                return jSONObject.toString();
            } catch (JSONException e) {
                FLog.e(BundleDownloader.TAG, "Can't serialize bundle info: ", (Throwable) e);
                return null;
            }
        }

        public String getUrl() {
            String str = this.mUrl;
            return str != null ? str : "unknown";
        }

        public int getFilesChangedCount() {
            return this.mFilesChangedCount;
        }
    }

    public BundleDownloader(OkHttpClient okHttpClient) {
        this.mClient = okHttpClient;
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo) {
        downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, new Request.Builder());
    }

    public void downloadBundleFromURL(final DevBundleDownloadListener devBundleDownloadListener, final File file, String str, final BundleInfo bundleInfo, Request.Builder builder) {
        Call call = (Call) Assertions.assertNotNull(this.mClient.newCall(builder.url(formatBundleUrl(str)).addHeader("Accept", "multipart/mixed").build()));
        this.mDownloadBundleFromURLCall = call;
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                if (BundleDownloader.this.mDownloadBundleFromURLCall == null || BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()) {
                    Call unused = BundleDownloader.this.mDownloadBundleFromURLCall = null;
                    return;
                }
                Call unused2 = BundleDownloader.this.mDownloadBundleFromURLCall = null;
                String httpUrl = call.request().url().toString();
                devBundleDownloadListener.onFailure(DebugServerException.makeGeneric(httpUrl, "Could not connect to development server.", "URL: " + httpUrl, iOException));
            }

            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0077, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0078, code lost:
                if (r10 != null) goto L_0x007a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x007a, code lost:
                if (r9 != null) goto L_0x007c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
                r10.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
                r10 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
                r9.addSuppressed(r10);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
                r10.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
                throw r0;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(okhttp3.Call r9, okhttp3.Response r10) throws java.io.IOException {
                /*
                    r8 = this;
                    com.facebook.react.devsupport.BundleDownloader r9 = com.facebook.react.devsupport.BundleDownloader.this
                    okhttp3.Call r9 = r9.mDownloadBundleFromURLCall
                    r0 = 0
                    if (r9 == 0) goto L_0x0089
                    com.facebook.react.devsupport.BundleDownloader r9 = com.facebook.react.devsupport.BundleDownloader.this
                    okhttp3.Call r9 = r9.mDownloadBundleFromURLCall
                    boolean r9 = r9.isCanceled()
                    if (r9 == 0) goto L_0x0017
                    goto L_0x0089
                L_0x0017:
                    com.facebook.react.devsupport.BundleDownloader r9 = com.facebook.react.devsupport.BundleDownloader.this
                    okhttp3.Call unused = r9.mDownloadBundleFromURLCall = r0
                    okhttp3.Request r9 = r10.request()
                    okhttp3.HttpUrl r9 = r9.url()
                    java.lang.String r1 = r9.toString()
                    java.lang.String r9 = "content-type"
                    java.lang.String r9 = r10.header(r9)
                    java.lang.String r0 = "multipart/mixed;.*boundary=\"([^\"]+)\""
                    java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
                    java.util.regex.Matcher r9 = r0.matcher(r9)
                    boolean r0 = r9.find()     // Catch:{ all -> 0x0075 }
                    if (r0 == 0) goto L_0x0050
                    com.facebook.react.devsupport.BundleDownloader r0 = com.facebook.react.devsupport.BundleDownloader.this     // Catch:{ all -> 0x0075 }
                    r2 = 1
                    java.lang.String r3 = r9.group(r2)     // Catch:{ all -> 0x0075 }
                    java.io.File r4 = r3     // Catch:{ all -> 0x0075 }
                    com.facebook.react.devsupport.BundleDownloader$BundleInfo r5 = r5     // Catch:{ all -> 0x0075 }
                    com.facebook.react.devsupport.interfaces.DevBundleDownloadListener r6 = r2     // Catch:{ all -> 0x0075 }
                    r2 = r10
                    r0.processMultipartResponse(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0075 }
                    goto L_0x006f
                L_0x0050:
                    com.facebook.react.devsupport.BundleDownloader r0 = com.facebook.react.devsupport.BundleDownloader.this     // Catch:{ all -> 0x0075 }
                    int r2 = r10.code()     // Catch:{ all -> 0x0075 }
                    okhttp3.Headers r3 = r10.headers()     // Catch:{ all -> 0x0075 }
                    okhttp3.ResponseBody r9 = r10.body()     // Catch:{ all -> 0x0075 }
                    okio.BufferedSource r9 = r9.source()     // Catch:{ all -> 0x0075 }
                    okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r9)     // Catch:{ all -> 0x0075 }
                    java.io.File r5 = r3     // Catch:{ all -> 0x0075 }
                    com.facebook.react.devsupport.BundleDownloader$BundleInfo r6 = r5     // Catch:{ all -> 0x0075 }
                    com.facebook.react.devsupport.interfaces.DevBundleDownloadListener r7 = r2     // Catch:{ all -> 0x0075 }
                    r0.processBundleResult(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0075 }
                L_0x006f:
                    if (r10 == 0) goto L_0x0074
                    r10.close()
                L_0x0074:
                    return
                L_0x0075:
                    r9 = move-exception
                    throw r9     // Catch:{ all -> 0x0077 }
                L_0x0077:
                    r0 = move-exception
                    if (r10 == 0) goto L_0x0088
                    if (r9 == 0) goto L_0x0085
                    r10.close()     // Catch:{ all -> 0x0080 }
                    goto L_0x0088
                L_0x0080:
                    r10 = move-exception
                    r9.addSuppressed(r10)
                    goto L_0x0088
                L_0x0085:
                    r10.close()
                L_0x0088:
                    throw r0
                L_0x0089:
                    com.facebook.react.devsupport.BundleDownloader r9 = com.facebook.react.devsupport.BundleDownloader.this
                    okhttp3.Call unused = r9.mDownloadBundleFromURLCall = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.BundleDownloader.AnonymousClass1.onResponse(okhttp3.Call, okhttp3.Response):void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void processMultipartResponse(String str, Response response, String str2, File file, BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        final Response response2 = response;
        final String str3 = str;
        final File file2 = file;
        final BundleInfo bundleInfo2 = bundleInfo;
        final DevBundleDownloadListener devBundleDownloadListener2 = devBundleDownloadListener;
        if (!new MultipartStreamReader(response.body().source(), str2).readAllParts(new MultipartStreamReader.ChunkListener() {
            public void onChunkComplete(Map<String, String> map, Buffer buffer, boolean z) throws IOException {
                if (z) {
                    int code = response2.code();
                    if (map.containsKey("X-Http-Status")) {
                        code = Integer.parseInt(map.get("X-Http-Status"));
                    }
                    BundleDownloader.this.processBundleResult(str3, code, Headers.of(map), buffer, file2, bundleInfo2, devBundleDownloadListener2);
                } else if (map.containsKey("Content-Type") && map.get("Content-Type").equals("application/json")) {
                    try {
                        JSONObject jSONObject = new JSONObject(buffer.readUtf8());
                        Integer num = null;
                        String string = jSONObject.has("status") ? jSONObject.getString("status") : null;
                        Integer valueOf = jSONObject.has("done") ? Integer.valueOf(jSONObject.getInt("done")) : null;
                        if (jSONObject.has("total")) {
                            num = Integer.valueOf(jSONObject.getInt("total"));
                        }
                        devBundleDownloadListener2.onProgress(string, valueOf, num);
                    } catch (JSONException e) {
                        FLog.e(ReactConstants.TAG, "Error parsing progress JSON. " + e.toString());
                    }
                }
            }

            public void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException {
                if ("application/javascript".equals(map.get("Content-Type"))) {
                    devBundleDownloadListener2.onProgress("Downloading JavaScript bundle", Integer.valueOf((int) (j / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)), Integer.valueOf((int) (j2 / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)));
                }
            }
        })) {
            devBundleDownloadListener.onFailure(new DebugServerException("Error while reading multipart response.\n\nResponse code: " + response.code() + "\n\nURL: " + str.toString() + "\n\n"));
        }
    }

    /* access modifiers changed from: private */
    public void processBundleResult(String str, int i, Headers headers, BufferedSource bufferedSource, File file, BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) throws IOException {
        if (i != 200) {
            String readUtf8 = bufferedSource.readUtf8();
            DebugServerException parse = DebugServerException.parse(str, readUtf8);
            if (parse != null) {
                devBundleDownloadListener.onFailure(parse);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The development server returned response error code: ").append(i).append("\n\n").append("URL: ").append(str).append("\n\n").append("Body:\n").append(readUtf8);
            devBundleDownloadListener.onFailure(new DebugServerException(sb.toString()));
            return;
        }
        if (bundleInfo != null) {
            populateBundleInfo(str, headers, bundleInfo);
        }
        File file2 = new File(file.getPath() + DefaultDiskStorage.FileType.TEMP);
        if (!storePlainJSInFile(bufferedSource, file2) || file2.renameTo(file)) {
            devBundleDownloadListener.onSuccess();
            return;
        }
        throw new IOException("Couldn't rename " + file2 + " to " + file);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean storePlainJSInFile(okio.BufferedSource r0, java.io.File r1) throws java.io.IOException {
        /*
            okio.Sink r1 = okio.Okio.sink((java.io.File) r1)     // Catch:{ all -> 0x0010 }
            r0.readAll(r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000c
            r1.close()
        L_0x000c:
            r0 = 1
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0017
            r1.close()
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.BundleDownloader.storePlainJSInFile(okio.BufferedSource, java.io.File):boolean");
    }

    private static void populateBundleInfo(String str, Headers headers, BundleInfo bundleInfo) {
        String unused = bundleInfo.mUrl = str;
        String str2 = headers.get("X-Metro-Files-Changed-Count");
        if (str2 != null) {
            try {
                int unused2 = bundleInfo.mFilesChangedCount = Integer.parseInt(str2);
            } catch (NumberFormatException unused3) {
                int unused4 = bundleInfo.mFilesChangedCount = -2;
            }
        }
    }
}
