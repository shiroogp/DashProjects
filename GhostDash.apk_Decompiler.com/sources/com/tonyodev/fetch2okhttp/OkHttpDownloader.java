package com.tonyodev.fetch2okhttp;

import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0006\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0007\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\"\u0010\u001e\u001a\u00020\u001f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0!0\u000fH\u0016J\u001f\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001fH\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010.\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000500H\u0016J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u0005002\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u00102\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u00103\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u00104\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001fH\u0016R\u001a\u0010\t\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/tonyodev/fetch2okhttp/OkHttpDownloader;", "Lcom/tonyodev/fetch2core/Downloader;", "Lokhttp3/OkHttpClient;", "Lokhttp3/Request;", "fileDownloaderType", "Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;", "(Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;)V", "okHttpClient", "(Lokhttp3/OkHttpClient;Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;)V", "client", "getClient", "()Lokhttp3/OkHttpClient;", "setClient", "(Lokhttp3/OkHttpClient;)V", "connections", "", "Lcom/tonyodev/fetch2core/Downloader$Response;", "Lokhttp3/Response;", "getConnections", "()Ljava/util/Map;", "close", "", "closeResponse", "response", "disconnect", "execute", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "interruptMonitor", "Lcom/tonyodev/fetch2core/InterruptMonitor;", "getContentHash", "", "responseHeaders", "", "getFileSlicingCount", "", "contentLength", "", "(Lcom/tonyodev/fetch2core/Downloader$ServerRequest;J)Ljava/lang/Integer;", "getHeadRequestMethodSupported", "", "getRedirectedServerRequest", "oldRequest", "redirectUrl", "getRequestBufferSize", "getRequestContentLength", "getRequestFileDownloaderType", "supportedFileDownloaderTypes", "", "getRequestSupportedFileDownloaderTypes", "onPreClientExecute", "onServerResponse", "verifyContentHash", "hash", "fetch2okhttp_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: OkHttpDownloader.kt */
public class OkHttpDownloader implements Downloader<OkHttpClient, Request> {
    private volatile OkHttpClient client;
    private final Map<Downloader.Response, Response> connections;
    private final Downloader.FileDownloaderType fileDownloaderType;

    public OkHttpDownloader() {
        this((OkHttpClient) null, (Downloader.FileDownloaderType) null, 3, (DefaultConstructorMarker) null);
    }

    public OkHttpDownloader(OkHttpClient okHttpClient) {
        this(okHttpClient, (Downloader.FileDownloaderType) null, 2, (DefaultConstructorMarker) null);
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

    public void onServerResponse(Downloader.ServerRequest serverRequest, Downloader.Response response) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        Intrinsics.checkParameterIsNotNull(response, "response");
    }

    public OkHttpDownloader(OkHttpClient okHttpClient, Downloader.FileDownloaderType fileDownloaderType2) {
        Intrinsics.checkParameterIsNotNull(fileDownloaderType2, "fileDownloaderType");
        this.fileDownloaderType = fileDownloaderType2;
        Map<Downloader.Response, Response> synchronizedMap = Collections.synchronizedMap(new HashMap());
        Intrinsics.checkExpressionValueIsNotNull(synchronizedMap, "Collections.synchronized…er.Response, Response>())");
        this.connections = synchronizedMap;
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().readTimeout(20000, TimeUnit.MILLISECONDS).connectTimeout(15000, TimeUnit.MILLISECONDS).cache((Cache) null).followRedirects(true).followSslRedirects(true).retryOnConnectionFailure(false).cookieJar(OkHttpUtils.getDefaultCookieJar()).build();
            Intrinsics.checkExpressionValueIsNotNull(okHttpClient, "OkHttpClient.Builder()\n …r())\n            .build()");
        }
        this.client = okHttpClient;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OkHttpDownloader(OkHttpClient okHttpClient, Downloader.FileDownloaderType fileDownloaderType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : okHttpClient, (i & 2) != 0 ? Downloader.FileDownloaderType.SEQUENTIAL : fileDownloaderType2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OkHttpDownloader(Downloader.FileDownloaderType fileDownloaderType2) {
        this((OkHttpClient) null, fileDownloaderType2);
        Intrinsics.checkParameterIsNotNull(fileDownloaderType2, "fileDownloaderType");
    }

    /* access modifiers changed from: protected */
    public final Map<Downloader.Response, Response> getConnections() {
        return this.connections;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final void setClient(OkHttpClient okHttpClient) {
        Intrinsics.checkParameterIsNotNull(okHttpClient, "<set-?>");
        this.client = okHttpClient;
    }

    public Request onPreClientExecute(OkHttpClient okHttpClient, Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        Request.Builder method = new Request.Builder().url(serverRequest.getUrl()).method(serverRequest.getRequestMethod(), (RequestBody) null);
        for (Map.Entry entry : serverRequest.getHeaders().entrySet()) {
            method.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        Request build = method.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "okHttpRequestBuilder.build()");
        return build;
    }

    private final Downloader.ServerRequest getRedirectedServerRequest(Downloader.ServerRequest serverRequest, String str) {
        return new Downloader.ServerRequest(serverRequest.getId(), serverRequest.getUrl(), serverRequest.getHeaders(), serverRequest.getFile(), serverRequest.getFileUri(), serverRequest.getTag(), serverRequest.getIdentifier(), serverRequest.getRequestMethod(), serverRequest.getExtras(), true, str, serverRequest.getSegment());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tonyodev.fetch2core.Downloader.Response execute(com.tonyodev.fetch2core.Downloader.ServerRequest r25, com.tonyodev.fetch2core.InterruptMonitor r26) {
        /*
            r24 = this;
            r0 = r24
            r12 = r25
            java.lang.String r1 = "request"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r1)
            java.lang.String r1 = "interruptMonitor"
            r2 = r26
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r1)
            okhttp3.OkHttpClient r1 = r0.client
            okhttp3.Request r1 = r0.onPreClientExecute((okhttp3.OkHttpClient) r1, (com.tonyodev.fetch2core.Downloader.ServerRequest) r12)
            java.lang.String r2 = "Referer"
            java.lang.String r3 = r1.header(r2)
            java.lang.String r4 = "okHttpRequest.newBuilder…                 .build()"
            if (r3 != 0) goto L_0x0037
            java.lang.String r3 = r25.getUrl()
            java.lang.String r3 = com.tonyodev.fetch2core.FetchCoreUtils.getRefererFromUrl(r3)
            okhttp3.Request$Builder r1 = r1.newBuilder()
            okhttp3.Request$Builder r1 = r1.addHeader(r2, r3)
            okhttp3.Request r1 = r1.build()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
        L_0x0037:
            okhttp3.OkHttpClient r3 = r0.client
            okhttp3.Call r1 = r3.newCall(r1)
            okhttp3.Response r1 = r1.execute()
            okhttp3.Headers r3 = r1.headers()
            java.util.Map r3 = r3.toMultimap()
            int r5 = r1.code()
            r6 = 302(0x12e, float:4.23E-43)
            java.lang.String r7 = "responseHeaders"
            if (r5 == r6) goto L_0x005b
            r6 = 301(0x12d, float:4.22E-43)
            if (r5 == r6) goto L_0x005b
            r6 = 303(0x12f, float:4.25E-43)
            if (r5 != r6) goto L_0x00bb
        L_0x005b:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r7)
            java.lang.String r6 = "Location"
            java.lang.String[] r8 = new java.lang.String[]{r6}
            java.lang.String r8 = com.tonyodev.fetch2core.FetchCoreUtils.getHeaderValue(r3, r8)
            if (r8 == 0) goto L_0x00bb
            okhttp3.OkHttpClient r5 = r0.client
            java.lang.String[] r6 = new java.lang.String[]{r6}
            java.lang.String r3 = com.tonyodev.fetch2core.FetchCoreUtils.getHeaderValue(r3, r6)
            if (r3 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            java.lang.String r3 = ""
        L_0x0079:
            com.tonyodev.fetch2core.Downloader$ServerRequest r3 = r0.getRedirectedServerRequest(r12, r3)
            okhttp3.Request r3 = r0.onPreClientExecute((okhttp3.OkHttpClient) r5, (com.tonyodev.fetch2core.Downloader.ServerRequest) r3)
            java.lang.String r5 = r3.header(r2)
            if (r5 != 0) goto L_0x009e
            java.lang.String r5 = r25.getUrl()
            java.lang.String r5 = com.tonyodev.fetch2core.FetchCoreUtils.getRefererFromUrl(r5)
            okhttp3.Request$Builder r3 = r3.newBuilder()
            okhttp3.Request$Builder r2 = r3.addHeader(r2, r5)
            okhttp3.Request r3 = r2.build()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
        L_0x009e:
            r1.close()     // Catch:{ Exception -> 0x00a1 }
        L_0x00a1:
            okhttp3.OkHttpClient r1 = r0.client
            okhttp3.Call r1 = r1.newCall(r3)
            okhttp3.Response r1 = r1.execute()
            okhttp3.Headers r2 = r1.headers()
            java.util.Map r2 = r2.toMultimap()
            int r3 = r1.code()
            r13 = r1
            r15 = r2
            r14 = r3
            goto L_0x00be
        L_0x00bb:
            r13 = r1
            r15 = r3
            r14 = r5
        L_0x00be:
            java.lang.String r1 = "okHttpResponse"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r1)
            boolean r16 = r13.isSuccessful()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r7)
            r1 = -1
            long r17 = com.tonyodev.fetch2core.FetchCoreUtils.getContentLengthFromHeader(r15, r1)
            okhttp3.ResponseBody r1 = r13.body()
            r2 = 0
            if (r1 == 0) goto L_0x00dd
            java.io.InputStream r1 = r1.byteStream()
            r11 = r1
            goto L_0x00de
        L_0x00dd:
            r11 = r2
        L_0x00de:
            if (r16 != 0) goto L_0x00e8
            r1 = 0
            java.lang.String r1 = com.tonyodev.fetch2core.FetchCoreUtils.copyStreamToString(r11, r1)
            r19 = r1
            goto L_0x00ea
        L_0x00e8:
            r19 = r2
        L_0x00ea:
            java.util.Map r1 = kotlin.collections.MapsKt.toMutableMap(r15)
            java.lang.String r20 = r0.getContentHash(r1)
            boolean r21 = com.tonyodev.fetch2core.FetchCoreUtils.acceptRanges(r14, r15)
            com.tonyodev.fetch2core.Downloader$Response r10 = new com.tonyodev.fetch2core.Downloader$Response
            r6 = 0
            r1 = r10
            r2 = r14
            r3 = r16
            r4 = r17
            r7 = r25
            r8 = r20
            r9 = r15
            r22 = r10
            r10 = r21
            r23 = r11
            r11 = r19
            r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11)
            r1 = r22
            r0.onServerResponse(r12, r1)
            com.tonyodev.fetch2core.Downloader$Response r11 = new com.tonyodev.fetch2core.Downloader$Response
            r1 = r11
            r6 = r23
            r12 = r11
            r11 = r19
            r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11)
            java.util.Map<com.tonyodev.fetch2core.Downloader$Response, okhttp3.Response> r1 = r0.connections
            r1.put(r12, r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2okhttp.OkHttpDownloader.execute(com.tonyodev.fetch2core.Downloader$ServerRequest, com.tonyodev.fetch2core.InterruptMonitor):com.tonyodev.fetch2core.Downloader$Response");
    }

    public String getContentHash(Map<String, List<String>> map) {
        Intrinsics.checkParameterIsNotNull(map, "responseHeaders");
        String headerValue = FetchCoreUtils.getHeaderValue(map, "Content-MD5");
        return headerValue != null ? headerValue : "";
    }

    public void disconnect(Downloader.Response response) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (this.connections.containsKey(response)) {
            this.connections.remove(response);
            closeResponse(this.connections.get(response));
        }
    }

    public void close() {
        for (Map.Entry value : this.connections.entrySet()) {
            closeResponse((Response) value.getValue());
        }
        this.connections.clear();
    }

    private final void closeResponse(Response response) {
        if (response != null) {
            try {
                response.close();
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
}
