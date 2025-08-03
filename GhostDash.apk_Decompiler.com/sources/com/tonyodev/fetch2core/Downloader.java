package com.tonyodev.fetch2core;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0003&'(J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\"\u0010\r\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00110\u0010H&J\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H&¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH&J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH&J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\t\u001a\u00020\nH&J\u001f\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u000eH&¨\u0006)"}, d2 = {"Lcom/tonyodev/fetch2core/Downloader;", "T", "R", "Ljava/io/Closeable;", "disconnect", "", "response", "Lcom/tonyodev/fetch2core/Downloader$Response;", "execute", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "interruptMonitor", "Lcom/tonyodev/fetch2core/InterruptMonitor;", "getContentHash", "", "responseHeaders", "", "", "getFileSlicingCount", "", "contentLength", "", "(Lcom/tonyodev/fetch2core/Downloader$ServerRequest;J)Ljava/lang/Integer;", "getHeadRequestMethodSupported", "", "getRequestBufferSize", "getRequestContentLength", "getRequestFileDownloaderType", "Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;", "supportedFileDownloaderTypes", "", "getRequestSupportedFileDownloaderTypes", "onPreClientExecute", "client", "(Ljava/lang/Object;Lcom/tonyodev/fetch2core/Downloader$ServerRequest;)Ljava/lang/Object;", "onServerResponse", "verifyContentHash", "hash", "FileDownloaderType", "Response", "ServerRequest", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Downloader.kt */
public interface Downloader<T, R> extends Closeable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;", "", "(Ljava/lang/String;I)V", "SEQUENTIAL", "PARALLEL", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Downloader.kt */
    public enum FileDownloaderType {
        SEQUENTIAL,
        PARALLEL
    }

    void disconnect(Response response);

    Response execute(ServerRequest serverRequest, InterruptMonitor interruptMonitor);

    String getContentHash(Map<String, List<String>> map);

    Integer getFileSlicingCount(ServerRequest serverRequest, long j);

    boolean getHeadRequestMethodSupported(ServerRequest serverRequest);

    int getRequestBufferSize(ServerRequest serverRequest);

    long getRequestContentLength(ServerRequest serverRequest);

    FileDownloaderType getRequestFileDownloaderType(ServerRequest serverRequest, Set<? extends FileDownloaderType> set);

    Set<FileDownloaderType> getRequestSupportedFileDownloaderTypes(ServerRequest serverRequest);

    R onPreClientExecute(T t, ServerRequest serverRequest);

    void onServerResponse(ServerRequest serverRequest, Response response);

    boolean verifyContentHash(ServerRequest serverRequest, String str);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019¨\u0006)"}, d2 = {"Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "", "id", "", "url", "", "headers", "", "file", "fileUri", "Landroid/net/Uri;", "tag", "identifier", "", "requestMethod", "extras", "Lcom/tonyodev/fetch2core/Extras;", "redirected", "", "redirectUrl", "segment", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;JLjava/lang/String;Lcom/tonyodev/fetch2core/Extras;ZLjava/lang/String;I)V", "getExtras", "()Lcom/tonyodev/fetch2core/Extras;", "getFile", "()Ljava/lang/String;", "getFileUri", "()Landroid/net/Uri;", "getHeaders", "()Ljava/util/Map;", "getId", "()I", "getIdentifier", "()J", "getRedirectUrl", "getRedirected", "()Z", "getRequestMethod", "getSegment", "getTag", "getUrl", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Downloader.kt */
    public static class ServerRequest {
        private final Extras extras;
        private final String file;
        private final Uri fileUri;
        private final Map<String, String> headers;
        private final int id;
        private final long identifier;
        private final String redirectUrl;
        private final boolean redirected;
        private final String requestMethod;
        private final int segment;
        private final String tag;
        private final String url;

        public ServerRequest(int i, String str, Map<String, String> map, String str2, Uri uri, String str3, long j, String str4, Extras extras2, boolean z, String str5, int i2) {
            Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
            Intrinsics.checkParameterIsNotNull(map, "headers");
            Intrinsics.checkParameterIsNotNull(str2, UriUtil.LOCAL_FILE_SCHEME);
            Intrinsics.checkParameterIsNotNull(uri, "fileUri");
            Intrinsics.checkParameterIsNotNull(str4, "requestMethod");
            Intrinsics.checkParameterIsNotNull(extras2, "extras");
            Intrinsics.checkParameterIsNotNull(str5, "redirectUrl");
            this.id = i;
            this.url = str;
            this.headers = map;
            this.file = str2;
            this.fileUri = uri;
            this.tag = str3;
            this.identifier = j;
            this.requestMethod = str4;
            this.extras = extras2;
            this.redirected = z;
            this.redirectUrl = str5;
            this.segment = i2;
        }

        public final int getId() {
            return this.id;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getFile() {
            return this.file;
        }

        public final Uri getFileUri() {
            return this.fileUri;
        }

        public final String getTag() {
            return this.tag;
        }

        public final long getIdentifier() {
            return this.identifier;
        }

        public final String getRequestMethod() {
            return this.requestMethod;
        }

        public final Extras getExtras() {
            return this.extras;
        }

        public final boolean getRedirected() {
            return this.redirected;
        }

        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        public final int getSegment() {
            return this.segment;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R#\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/tonyodev/fetch2core/Downloader$Response;", "", "code", "", "isSuccessful", "", "contentLength", "", "byteStream", "Ljava/io/InputStream;", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "hash", "", "responseHeaders", "", "", "acceptsRanges", "errorResponse", "(IZJLjava/io/InputStream;Lcom/tonyodev/fetch2core/Downloader$ServerRequest;Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)V", "getAcceptsRanges", "()Z", "getByteStream", "()Ljava/io/InputStream;", "getCode", "()I", "getContentLength", "()J", "getErrorResponse", "()Ljava/lang/String;", "getHash", "getRequest", "()Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "getResponseHeaders", "()Ljava/util/Map;", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Downloader.kt */
    public static class Response {
        private final boolean acceptsRanges;
        private final InputStream byteStream;
        private final int code;
        private final long contentLength;
        private final String errorResponse;
        private final String hash;
        private final boolean isSuccessful;
        private final ServerRequest request;
        private final Map<String, List<String>> responseHeaders;

        public Response(int i, boolean z, long j, InputStream inputStream, ServerRequest serverRequest, String str, Map<String, ? extends List<String>> map, boolean z2, String str2) {
            Intrinsics.checkParameterIsNotNull(serverRequest, "request");
            Intrinsics.checkParameterIsNotNull(str, "hash");
            Intrinsics.checkParameterIsNotNull(map, "responseHeaders");
            this.code = i;
            this.isSuccessful = z;
            this.contentLength = j;
            this.byteStream = inputStream;
            this.request = serverRequest;
            this.hash = str;
            this.responseHeaders = map;
            this.acceptsRanges = z2;
            this.errorResponse = str2;
        }

        public final int getCode() {
            return this.code;
        }

        public final boolean isSuccessful() {
            return this.isSuccessful;
        }

        public final long getContentLength() {
            return this.contentLength;
        }

        public final InputStream getByteStream() {
            return this.byteStream;
        }

        public final ServerRequest getRequest() {
            return this.request;
        }

        public final String getHash() {
            return this.hash;
        }

        public final Map<String, List<String>> getResponseHeaders() {
            return this.responseHeaders;
        }

        public final boolean getAcceptsRanges() {
            return this.acceptsRanges;
        }

        public final String getErrorResponse() {
            return this.errorResponse;
        }
    }
}
