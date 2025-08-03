package com.tonyodev.fetch2;

import com.arthenica.ffmpegkit.Chapter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.FetchErrorStrings;
import com.tonyodev.fetch2core.FileResource;
import com.tonyodev.fetch2core.FileServerDownloader;
import com.tonyodev.fetch2core.InterruptMonitor;
import com.tonyodev.fetch2core.server.FetchFileResourceTransporter;
import com.tonyodev.fetch2core.server.FileRequest;
import com.tonyodev.fetch2core.server.FileResponse;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00190\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00192\u0006\u0010 \u001a\u00020\u0013H\u0016J\u001f\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010'\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010)\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030+H\u0016J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030+2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u00100\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00192\u0006\u00102\u001a\u00020\u0017H\u0002J\u0018\u00103\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0017H\u0016R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/tonyodev/fetch2/FetchFileServerDownloader;", "Lcom/tonyodev/fetch2core/FileServerDownloader;", "fileDownloaderType", "Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;", "timeout", "", "(Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;J)V", "connections", "", "Lcom/tonyodev/fetch2core/Downloader$Response;", "Lcom/tonyodev/fetch2core/server/FetchFileResourceTransporter;", "getConnections", "()Ljava/util/Map;", "close", "", "disconnect", "response", "execute", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "interruptMonitor", "Lcom/tonyodev/fetch2core/InterruptMonitor;", "getContentHash", "", "responseHeaders", "", "getExtrasFromCatalogItem", "Lcom/tonyodev/fetch2core/Extras;", "catalogItem", "Lorg/json/JSONObject;", "getFetchFileServerCatalog", "Lcom/tonyodev/fetch2core/FileResource;", "serverRequest", "getFileSlicingCount", "", "contentLength", "(Lcom/tonyodev/fetch2core/Downloader$ServerRequest;J)Ljava/lang/Integer;", "getHeadRequestMethodSupported", "", "getRequestBufferSize", "getRequestContentLength", "getRequestFileDownloaderType", "supportedFileDownloaderTypes", "", "getRequestSupportedFileDownloaderTypes", "onPreClientExecute", "Lcom/tonyodev/fetch2core/FileServerDownloader$TransporterRequest;", "client", "onServerResponse", "parseFileResourceList", "data", "verifyContentHash", "hash", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchFileServerDownloader.kt */
public class FetchFileServerDownloader implements FileServerDownloader {
    private final Map<Downloader.Response, FetchFileResourceTransporter> connections;
    private final Downloader.FileDownloaderType fileDownloaderType;
    private final long timeout;

    public FetchFileServerDownloader() {
        this((Downloader.FileDownloaderType) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public FetchFileServerDownloader(Downloader.FileDownloaderType fileDownloaderType2) {
        this(fileDownloaderType2, 0, 2, (DefaultConstructorMarker) null);
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

    public FetchFileServerDownloader(Downloader.FileDownloaderType fileDownloaderType2, long j) {
        Intrinsics.checkParameterIsNotNull(fileDownloaderType2, "fileDownloaderType");
        this.fileDownloaderType = fileDownloaderType2;
        this.timeout = j;
        Map<Downloader.Response, FetchFileResourceTransporter> synchronizedMap = Collections.synchronizedMap(new HashMap());
        Intrinsics.checkExpressionValueIsNotNull(synchronizedMap, "Collections.synchronized…leResourceTransporter>())");
        this.connections = synchronizedMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FetchFileServerDownloader(Downloader.FileDownloaderType fileDownloaderType2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Downloader.FileDownloaderType.SEQUENTIAL : fileDownloaderType2, (i & 2) != 0 ? 20000 : j);
    }

    /* access modifiers changed from: protected */
    public final Map<Downloader.Response, FetchFileResourceTransporter> getConnections() {
        return this.connections;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00c4, code lost:
        r2 = kotlin.text.StringsKt.toIntOrNull(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tonyodev.fetch2core.FileServerDownloader.TransporterRequest onPreClientExecute(com.tonyodev.fetch2core.server.FetchFileResourceTransporter r18, com.tonyodev.fetch2core.Downloader.ServerRequest r19) {
        /*
            r17 = this;
            java.lang.String r0 = "client"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "request"
            r1 = r19
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.util.Map r0 = r19.getHeaders()
            java.lang.String r2 = "Range"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            java.lang.String r2 = "bytes=0-"
        L_0x001f:
            kotlin.Pair r2 = com.tonyodev.fetch2core.FetchCoreUtils.getRangeForFetchFileServerRequest(r2)
            java.lang.String r3 = "Authorization"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            java.lang.String r3 = ""
        L_0x0030:
            r11 = r3
            java.lang.String r3 = r19.getUrl()
            int r3 = com.tonyodev.fetch2core.FetchCoreUtils.getFetchFileServerPort(r3)
            java.lang.String r4 = r19.getUrl()
            java.lang.String r4 = com.tonyodev.fetch2core.FetchCoreUtils.getFetchFileServerHostAddress(r4)
            com.tonyodev.fetch2core.Extras r5 = r19.getExtras()
            com.tonyodev.fetch2core.MutableExtras r5 = r5.toMutableExtras()
            java.util.Map r6 = r19.getHeaders()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0055:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0071
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            r5.putString(r8, r7)
            goto L_0x0055
        L_0x0071:
            com.tonyodev.fetch2core.FileServerDownloader$TransporterRequest r15 = new com.tonyodev.fetch2core.FileServerDownloader$TransporterRequest
            r15.<init>()
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress
            r6.<init>(r4, r3)
            r15.setInetSocketAddress(r6)
            com.tonyodev.fetch2core.server.FileRequest r3 = new com.tonyodev.fetch2core.server.FileRequest
            r6 = 1
            java.lang.String r1 = r19.getUrl()
            java.lang.String r1 = com.tonyodev.fetch2core.FetchCoreUtils.getFileResourceIdFromUrl(r1)
            java.lang.Object r4 = r2.getFirst()
            java.lang.Number r4 = (java.lang.Number) r4
            long r7 = r4.longValue()
            java.lang.Object r2 = r2.getSecond()
            java.lang.Number r2 = (java.lang.Number) r2
            long r9 = r2.longValue()
            java.lang.String r2 = "Client"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00a8
            goto L_0x00b5
        L_0x00a8:
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "UUID.randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
        L_0x00b5:
            r12 = r2
            r13 = r5
            com.tonyodev.fetch2core.Extras r13 = (com.tonyodev.fetch2core.Extras) r13
            java.lang.String r2 = "Page"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r4 = 0
            if (r2 == 0) goto L_0x00d0
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto L_0x00d0
            int r2 = r2.intValue()
            r14 = r2
            goto L_0x00d1
        L_0x00d0:
            r14 = r4
        L_0x00d1:
            java.lang.String r2 = "Size"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00e6
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L_0x00e6
            int r0 = r0.intValue()
            goto L_0x00e7
        L_0x00e6:
            r0 = r4
        L_0x00e7:
            r16 = 0
            r4 = r3
            r5 = r6
            r6 = r1
            r1 = r15
            r15 = r0
            r4.<init>(r5, r6, r7, r9, r11, r12, r13, r14, r15, r16)
            r1.setFileRequest(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.FetchFileServerDownloader.onPreClientExecute(com.tonyodev.fetch2core.server.FetchFileResourceTransporter, com.tonyodev.fetch2core.Downloader$ServerRequest):com.tonyodev.fetch2core.FileServerDownloader$TransporterRequest");
    }

    public Downloader.Response execute(Downloader.ServerRequest serverRequest, InterruptMonitor interruptMonitor) {
        boolean z;
        Downloader.ServerRequest serverRequest2 = serverRequest;
        Intrinsics.checkParameterIsNotNull(serverRequest2, "request");
        Intrinsics.checkParameterIsNotNull(interruptMonitor, "interruptMonitor");
        String str = null;
        FetchFileResourceTransporter fetchFileResourceTransporter = new FetchFileResourceTransporter((Socket) null, 1, (DefaultConstructorMarker) null);
        long nanoTime = System.nanoTime();
        FileServerDownloader.TransporterRequest onPreClientExecute = onPreClientExecute(fetchFileResourceTransporter, serverRequest2);
        fetchFileResourceTransporter.connect(onPreClientExecute.getInetSocketAddress());
        fetchFileResourceTransporter.sendFileRequest(onPreClientExecute.getFileRequest());
        while (!interruptMonitor.isInterrupted()) {
            FileResponse receiveFileResponse = fetchFileResourceTransporter.receiveFileResponse();
            if (receiveFileResponse == null) {
                if (FetchCoreUtils.hasIntervalTimeElapsed(nanoTime, System.nanoTime(), this.timeout)) {
                    break;
                }
            } else {
                int status = receiveFileResponse.getStatus();
                boolean z2 = receiveFileResponse.getConnection() == 1 && receiveFileResponse.getType() == 1 && receiveFileResponse.getStatus() == 206;
                long contentLength = receiveFileResponse.getContentLength();
                InputStream inputStream = fetchFileResourceTransporter.getInputStream();
                String copyStreamToString = !z2 ? FetchCoreUtils.copyStreamToString(inputStream, false) : null;
                Map linkedHashMap = new LinkedHashMap();
                try {
                    JSONObject jSONObject = new JSONObject(receiveFileResponse.getToJsonString());
                    Iterator<String> keys = jSONObject.keys();
                    Intrinsics.checkExpressionValueIsNotNull(keys, "json.keys()");
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Intrinsics.checkExpressionValueIsNotNull(next, "it");
                        linkedHashMap.put(next, CollectionsKt.listOf(jSONObject.get(next).toString()));
                    }
                } catch (Exception unused) {
                }
                if (!linkedHashMap.containsKey("Content-MD5")) {
                    linkedHashMap.put("Content-MD5", CollectionsKt.listOf(receiveFileResponse.getMd5()));
                }
                String contentHash = getContentHash(linkedHashMap);
                if (status != 206) {
                    List list = (List) linkedHashMap.get(FetchCoreUtils.HEADER_ACCEPT_RANGE);
                    if (list != null) {
                        str = (String) CollectionsKt.firstOrNull(list);
                    }
                    if (!Intrinsics.areEqual((Object) str, (Object) "bytes")) {
                        z = false;
                        int i = status;
                        boolean z3 = z2;
                        long j = contentLength;
                        Downloader.ServerRequest serverRequest3 = serverRequest;
                        String str2 = contentHash;
                        Downloader.Response response = r1;
                        Map map = linkedHashMap;
                        Map map2 = linkedHashMap;
                        boolean z4 = z;
                        Downloader.Response response2 = new Downloader.Response(i, z3, j, (InputStream) null, serverRequest3, str2, map, z4, copyStreamToString);
                        onServerResponse(serverRequest2, response);
                        Downloader.Response response3 = r1;
                        Downloader.Response response4 = new Downloader.Response(i, z3, j, inputStream, serverRequest3, str2, map2, z4, copyStreamToString);
                        this.connections.put(response3, fetchFileResourceTransporter);
                        return response3;
                    }
                }
                z = true;
                int i2 = status;
                boolean z32 = z2;
                long j2 = contentLength;
                Downloader.ServerRequest serverRequest32 = serverRequest;
                String str22 = contentHash;
                Downloader.Response response5 = response2;
                Map map3 = linkedHashMap;
                Map map22 = linkedHashMap;
                boolean z42 = z;
                Downloader.Response response22 = new Downloader.Response(i2, z32, j2, (InputStream) null, serverRequest32, str22, map3, z42, copyStreamToString);
                onServerResponse(serverRequest2, response5);
                Downloader.Response response32 = response4;
                Downloader.Response response42 = new Downloader.Response(i2, z32, j2, inputStream, serverRequest32, str22, map22, z42, copyStreamToString);
                this.connections.put(response32, fetchFileResourceTransporter);
                return response32;
            }
        }
        return null;
    }

    public void disconnect(Downloader.Response response) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (this.connections.containsKey(response)) {
            FetchFileResourceTransporter fetchFileResourceTransporter = this.connections.get(response);
            this.connections.remove(response);
            if (fetchFileResourceTransporter != null) {
                fetchFileResourceTransporter.close();
            }
        }
    }

    public void close() {
        try {
            for (Map.Entry value : this.connections.entrySet()) {
                ((FetchFileResourceTransporter) value.getValue()).close();
            }
            this.connections.clear();
        } catch (Exception unused) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r2 = (java.lang.String) kotlin.collections.CollectionsKt.firstOrNull(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getContentHash(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "responseHeaders"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "Content-MD5"
            java.lang.Object r2 = r2.get(r0)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0018
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            java.lang.String r2 = ""
        L_0x001a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.FetchFileServerDownloader.getContentHash(java.util.Map):java.lang.String");
    }

    public long getRequestContentLength(Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        return FetchCoreUtils.getRequestContentLength(serverRequest, this);
    }

    public List<FileResource> getFetchFileServerCatalog(Downloader.ServerRequest serverRequest) {
        String str;
        Intrinsics.checkParameterIsNotNull(serverRequest, "serverRequest");
        Downloader.Response execute = execute(serverRequest, new FetchFileServerDownloader$getFetchFileServerCatalog$response$1());
        if ((execute != null ? execute.getByteStream() : null) != null) {
            try {
                List list = execute.getResponseHeaders().get(FileRequest.FIELD_TYPE);
                boolean z = true;
                if (((list == null || (str = (String) CollectionsKt.firstOrNull(list)) == null) ? -1 : Integer.parseInt(str)) == 1) {
                    char[] cArr = new char[1024];
                    StringBuilder sb = new StringBuilder();
                    InputStreamReader inputStreamReader = new InputStreamReader(execute.getByteStream(), Charsets.UTF_8);
                    for (int read = inputStreamReader.read(cArr, 0, 1024); read != -1; read = inputStreamReader.read(cArr, 0, 1024)) {
                        sb.append(cArr, 0, read);
                    }
                    inputStreamReader.close();
                    String sb2 = sb.toString();
                    Intrinsics.checkExpressionValueIsNotNull(sb2, "stringBuilder.toString()");
                    if (sb2.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        List<FileResource> parseFileResourceList = parseFileResourceList(sb2);
                        disconnect(execute);
                        return parseFileResourceList;
                    }
                    throw new Exception(FetchErrorStrings.EMPTY_RESPONSE_BODY);
                }
                disconnect(execute);
                throw new Exception(FetchErrorStrings.FETCH_FILE_SERVER_INVALID_RESPONSE_TYPE);
            } catch (Exception e) {
                disconnect(execute);
                throw e;
            }
        } else {
            throw new Exception(FetchErrorStrings.EMPTY_RESPONSE_BODY);
        }
    }

    private final List<FileResource> parseFileResourceList(String str) {
        JSONArray jSONArray = new JSONArray(new JSONObject(str).getString("catalog"));
        int length = jSONArray.length();
        List<FileResource> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            FileResource fileResource = new FileResource();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            fileResource.setId(jSONObject.getLong(Chapter.KEY_ID));
            String string = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkExpressionValueIsNotNull(string, "catalogItem.getString(\"name\")");
            fileResource.setName(string);
            fileResource.setLength(jSONObject.getLong("length"));
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "catalogItem");
            fileResource.setExtras(getExtrasFromCatalogItem(jSONObject));
            String string2 = jSONObject.getString(FileResponse.FIELD_MD5);
            Intrinsics.checkExpressionValueIsNotNull(string2, "catalogItem.getString(\"md5\")");
            fileResource.setMd5(string2);
            arrayList.add(fileResource);
        }
        return arrayList;
    }

    private final Extras getExtrasFromCatalogItem(JSONObject jSONObject) {
        try {
            Map linkedHashMap = new LinkedHashMap();
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("extras"));
            Iterator<String> keys = jSONObject2.keys();
            Intrinsics.checkExpressionValueIsNotNull(keys, "customJson.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkExpressionValueIsNotNull(next, "it");
                String string = jSONObject2.getString(next);
                Intrinsics.checkExpressionValueIsNotNull(string, "customJson.getString(it)");
                linkedHashMap.put(next, string);
            }
            return new Extras(linkedHashMap);
        } catch (Exception unused) {
            return Extras.CREATOR.getEmptyExtras();
        }
    }

    public Set<Downloader.FileDownloaderType> getRequestSupportedFileDownloaderTypes(Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        try {
            return FetchCoreUtils.getRequestSupportedFileDownloaderTypes(serverRequest, this);
        } catch (Exception unused) {
            return SetsKt.mutableSetOf(this.fileDownloaderType);
        }
    }
}
