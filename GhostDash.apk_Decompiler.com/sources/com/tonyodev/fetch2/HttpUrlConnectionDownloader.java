package com.tonyodev.fetch2;

import com.arthenica.ffmpegkit.reactnative.FFmpegKitReactNativeModule;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.InterruptMonitor;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\t\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0007\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J8\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0#0\u000e2\u001c\u0010$\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\"\u0018\u00010#0\u000eH\u0002J\"\u0010%\u001a\u00020\"2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0#0\u000eH\u0016J\u001f\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010-\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010/\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000501H\u0016J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\u0005012\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020'H\u0004J\u001a\u00105\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u00106\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u00107\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\"H\u0016R\u0014\u0010\n\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/tonyodev/fetch2/HttpUrlConnectionDownloader;", "Lcom/tonyodev/fetch2core/Downloader;", "Ljava/net/HttpURLConnection;", "Ljava/lang/Void;", "fileDownloaderType", "Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;", "(Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;)V", "httpUrlConnectionPreferences", "Lcom/tonyodev/fetch2/HttpUrlConnectionDownloader$HttpUrlConnectionPreferences;", "(Lcom/tonyodev/fetch2/HttpUrlConnectionDownloader$HttpUrlConnectionPreferences;Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;)V", "connectionPrefs", "getConnectionPrefs", "()Lcom/tonyodev/fetch2/HttpUrlConnectionDownloader$HttpUrlConnectionPreferences;", "connections", "", "Lcom/tonyodev/fetch2core/Downloader$Response;", "getConnections", "()Ljava/util/Map;", "cookieManager", "Ljava/net/CookieManager;", "getCookieManager", "()Ljava/net/CookieManager;", "close", "", "disconnect", "response", "disconnectClient", "client", "execute", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "interruptMonitor", "Lcom/tonyodev/fetch2core/InterruptMonitor;", "getCleanedHeaders", "", "", "responseHeaders", "getContentHash", "getFileSlicingCount", "", "contentLength", "", "(Lcom/tonyodev/fetch2core/Downloader$ServerRequest;J)Ljava/lang/Integer;", "getHeadRequestMethodSupported", "", "getRequestBufferSize", "getRequestContentLength", "getRequestFileDownloaderType", "supportedFileDownloaderTypes", "", "getRequestSupportedFileDownloaderTypes", "isResponseOk", "responseCode", "onPreClientExecute", "onServerResponse", "verifyContentHash", "hash", "HttpUrlConnectionPreferences", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: HttpUrlConnectionDownloader.kt */
public class HttpUrlConnectionDownloader implements Downloader<HttpURLConnection, Void> {
    private final HttpUrlConnectionPreferences connectionPrefs;
    private final Map<Downloader.Response, HttpURLConnection> connections;
    private final CookieManager cookieManager;
    private final Downloader.FileDownloaderType fileDownloaderType;

    public HttpUrlConnectionDownloader() {
        this((HttpUrlConnectionPreferences) null, (Downloader.FileDownloaderType) null, 3, (DefaultConstructorMarker) null);
    }

    public HttpUrlConnectionDownloader(HttpUrlConnectionPreferences httpUrlConnectionPreferences) {
        this(httpUrlConnectionPreferences, (Downloader.FileDownloaderType) null, 2, (DefaultConstructorMarker) null);
    }

    public Integer getFileSlicingCount(Downloader.ServerRequest serverRequest, long j) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        return null;
    }

    public boolean getHeadRequestMethodSupported(Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        return false;
    }

    public int getRequestBufferSize(Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        return 8192;
    }

    /* access modifiers changed from: protected */
    public final boolean isResponseOk(int i) {
        return 200 <= i && 299 >= i;
    }

    public void onServerResponse(Downloader.ServerRequest serverRequest, Downloader.Response response) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        Intrinsics.checkParameterIsNotNull(response, "response");
    }

    public HttpUrlConnectionDownloader(HttpUrlConnectionPreferences httpUrlConnectionPreferences, Downloader.FileDownloaderType fileDownloaderType2) {
        Intrinsics.checkParameterIsNotNull(fileDownloaderType2, "fileDownloaderType");
        this.fileDownloaderType = fileDownloaderType2;
        this.connectionPrefs = httpUrlConnectionPreferences == null ? new HttpUrlConnectionPreferences() : httpUrlConnectionPreferences;
        Map<Downloader.Response, HttpURLConnection> synchronizedMap = Collections.synchronizedMap(new HashMap());
        Intrinsics.checkExpressionValueIsNotNull(synchronizedMap, "Collections.synchronized…se, HttpURLConnection>())");
        this.connections = synchronizedMap;
        this.cookieManager = FetchCoreUtils.getDefaultCookieManager();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpUrlConnectionDownloader(HttpUrlConnectionPreferences httpUrlConnectionPreferences, Downloader.FileDownloaderType fileDownloaderType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : httpUrlConnectionPreferences, (i & 2) != 0 ? Downloader.FileDownloaderType.SEQUENTIAL : fileDownloaderType2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpUrlConnectionDownloader(Downloader.FileDownloaderType fileDownloaderType2) {
        this((HttpUrlConnectionPreferences) null, fileDownloaderType2);
        Intrinsics.checkParameterIsNotNull(fileDownloaderType2, "fileDownloaderType");
    }

    /* access modifiers changed from: protected */
    public final HttpUrlConnectionPreferences getConnectionPrefs() {
        return this.connectionPrefs;
    }

    /* access modifiers changed from: protected */
    public final Map<Downloader.Response, HttpURLConnection> getConnections() {
        return this.connections;
    }

    /* access modifiers changed from: protected */
    public final CookieManager getCookieManager() {
        return this.cookieManager;
    }

    public Void onPreClientExecute(HttpURLConnection httpURLConnection, Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(httpURLConnection, "client");
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        httpURLConnection.setRequestMethod(serverRequest.getRequestMethod());
        httpURLConnection.setReadTimeout(this.connectionPrefs.getReadTimeout());
        httpURLConnection.setConnectTimeout(this.connectionPrefs.getConnectTimeout());
        httpURLConnection.setUseCaches(this.connectionPrefs.getUsesCache());
        httpURLConnection.setDefaultUseCaches(this.connectionPrefs.getUsesDefaultCache());
        httpURLConnection.setInstanceFollowRedirects(this.connectionPrefs.getFollowsRedirect());
        httpURLConnection.setDoInput(true);
        for (Map.Entry entry : serverRequest.getHeaders().entrySet()) {
            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        return null;
    }

    private final Map<String, List<String>> getCleanedHeaders(Map<String, List<String>> map) {
        Map<String, List<String>> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (str != null) {
                List list = (List) next.getValue();
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                linkedHashMap.put(str, list);
            }
        }
        return linkedHashMap;
    }

    public Downloader.Response execute(Downloader.ServerRequest serverRequest, InterruptMonitor interruptMonitor) {
        Map<String, List<String>> map;
        int i;
        HttpURLConnection httpURLConnection;
        String str;
        String str2;
        InputStream inputStream;
        long j;
        boolean z;
        Downloader.ServerRequest serverRequest2 = serverRequest;
        Intrinsics.checkParameterIsNotNull(serverRequest2, "request");
        Intrinsics.checkParameterIsNotNull(interruptMonitor, "interruptMonitor");
        CookieHandler.setDefault(this.cookieManager);
        URLConnection openConnection = new URL(serverRequest.getUrl()).openConnection();
        if (openConnection != null) {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
            onPreClientExecute(httpURLConnection2, serverRequest2);
            if (httpURLConnection2.getRequestProperty("Referer") == null) {
                httpURLConnection2.addRequestProperty("Referer", FetchCoreUtils.getRefererFromUrl(serverRequest.getUrl()));
            }
            httpURLConnection2.connect();
            Map headerFields = httpURLConnection2.getHeaderFields();
            Intrinsics.checkExpressionValueIsNotNull(headerFields, "client.headerFields");
            Map<String, List<String>> cleanedHeaders = getCleanedHeaders(headerFields);
            int responseCode = httpURLConnection2.getResponseCode();
            if ((responseCode == 302 || responseCode == 301 || responseCode == 303) && FetchCoreUtils.getHeaderValue(cleanedHeaders, "Location") != null) {
                try {
                    httpURLConnection2.disconnect();
                } catch (Exception unused) {
                }
                String headerValue = FetchCoreUtils.getHeaderValue(cleanedHeaders, "Location");
                if (headerValue == null) {
                    headerValue = "";
                }
                URLConnection openConnection2 = new URL(headerValue).openConnection();
                if (openConnection2 != null) {
                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) openConnection2;
                    onPreClientExecute(httpURLConnection3, serverRequest2);
                    if (httpURLConnection3.getRequestProperty("Referer") == null) {
                        httpURLConnection3.addRequestProperty("Referer", FetchCoreUtils.getRefererFromUrl(serverRequest.getUrl()));
                    }
                    httpURLConnection3.connect();
                    Map headerFields2 = httpURLConnection3.getHeaderFields();
                    Intrinsics.checkExpressionValueIsNotNull(headerFields2, "client.headerFields");
                    httpURLConnection = httpURLConnection3;
                    map = getCleanedHeaders(headerFields2);
                    i = httpURLConnection3.getResponseCode();
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
                }
            } else {
                httpURLConnection = httpURLConnection2;
                map = cleanedHeaders;
                i = responseCode;
            }
            InputStream inputStream2 = null;
            String str3 = null;
            if (isResponseOk(i)) {
                j = FetchCoreUtils.getContentLengthFromHeader(map, -1);
                str = str3;
                z = true;
                inputStream = httpURLConnection.getInputStream();
                str2 = getContentHash(map);
            } else {
                j = -1;
                str = FetchCoreUtils.copyStreamToString(httpURLConnection.getErrorStream(), false);
                inputStream = inputStream2;
                z = false;
                str2 = "";
            }
            boolean acceptRanges = FetchCoreUtils.acceptRanges(i, map);
            Map headerFields3 = httpURLConnection.getHeaderFields();
            Intrinsics.checkExpressionValueIsNotNull(headerFields3, "client.headerFields");
            int i2 = i;
            boolean z2 = z;
            long j2 = j;
            Downloader.ServerRequest serverRequest3 = serverRequest;
            String str4 = str2;
            boolean z3 = acceptRanges;
            HttpURLConnection httpURLConnection4 = httpURLConnection;
            Downloader.Response response = r1;
            String str5 = str;
            Downloader.Response response2 = new Downloader.Response(i2, z2, j2, (InputStream) null, serverRequest3, str4, headerFields3, z3, str5);
            onServerResponse(serverRequest2, response);
            Downloader.Response response3 = new Downloader.Response(i2, z2, j2, inputStream, serverRequest3, str4, map, z3, str5);
            this.connections.put(response3, httpURLConnection4);
            return response3;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
    }

    public void disconnect(Downloader.Response response) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (this.connections.containsKey(response)) {
            this.connections.remove(response);
            disconnectClient(this.connections.get(response));
        }
    }

    public String getContentHash(Map<String, List<String>> map) {
        Intrinsics.checkParameterIsNotNull(map, "responseHeaders");
        String headerValue = FetchCoreUtils.getHeaderValue(map, "Content-MD5");
        return headerValue != null ? headerValue : "";
    }

    public void close() {
        for (Map.Entry value : this.connections.entrySet()) {
            disconnectClient((HttpURLConnection) value.getValue());
        }
        this.connections.clear();
    }

    private final void disconnectClient(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        }
    }

    public Downloader.FileDownloaderType getRequestFileDownloaderType(Downloader.ServerRequest serverRequest, Set<? extends Downloader.FileDownloaderType> set) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        Intrinsics.checkParameterIsNotNull(set, "supportedFileDownloaderTypes");
        return this.fileDownloaderType;
    }

    public boolean verifyContentHash(Downloader.ServerRequest serverRequest, String str) {
        String fileMd5String;
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        Intrinsics.checkParameterIsNotNull(str, "hash");
        CharSequence charSequence = str;
        if ((charSequence.length() == 0) || (fileMd5String = FetchCoreUtils.getFileMd5String(serverRequest.getFile())) == null) {
            return true;
        }
        if (fileMd5String != null) {
            return fileMd5String.contentEquals(charSequence);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public long getRequestContentLength(Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        return FetchCoreUtils.getRequestContentLength(serverRequest, this);
    }

    public Set<Downloader.FileDownloaderType> getRequestSupportedFileDownloaderTypes(Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        if (this.fileDownloaderType == Downloader.FileDownloaderType.SEQUENTIAL) {
            return SetsKt.mutableSetOf(this.fileDownloaderType);
        }
        try {
            return FetchCoreUtils.getRequestSupportedFileDownloaderTypes(serverRequest, this);
        } catch (Exception unused) {
            return SetsKt.mutableSetOf(this.fileDownloaderType);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tonyodev/fetch2/HttpUrlConnectionDownloader$HttpUrlConnectionPreferences;", "", "()V", "connectTimeout", "", "getConnectTimeout", "()I", "setConnectTimeout", "(I)V", "followsRedirect", "", "getFollowsRedirect", "()Z", "setFollowsRedirect", "(Z)V", "readTimeout", "getReadTimeout", "setReadTimeout", "usesCache", "getUsesCache", "setUsesCache", "usesDefaultCache", "getUsesDefaultCache", "setUsesDefaultCache", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: HttpUrlConnectionDownloader.kt */
    public static class HttpUrlConnectionPreferences {
        private int connectTimeout = 15000;
        private boolean followsRedirect = true;
        private int readTimeout = FFmpegKitReactNativeModule.WRITABLE_REQUEST_CODE;
        private boolean usesCache;
        private boolean usesDefaultCache;

        public final int getReadTimeout() {
            return this.readTimeout;
        }

        public final void setReadTimeout(int i) {
            this.readTimeout = i;
        }

        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        public final void setConnectTimeout(int i) {
            this.connectTimeout = i;
        }

        public final boolean getUsesCache() {
            return this.usesCache;
        }

        public final void setUsesCache(boolean z) {
            this.usesCache = z;
        }

        public final boolean getUsesDefaultCache() {
            return this.usesDefaultCache;
        }

        public final void setUsesDefaultCache(boolean z) {
            this.usesDefaultCache = z;
        }

        public final boolean getFollowsRedirect() {
            return this.followsRedirect;
        }

        public final void setFollowsRedirect(boolean z) {
            this.followsRedirect = z;
        }
    }
}
