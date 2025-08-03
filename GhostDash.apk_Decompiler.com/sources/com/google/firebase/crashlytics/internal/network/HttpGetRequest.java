package com.google.firebase.crashlytics.internal.network;

import com.bumptech.glide.load.Key;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpGetRequest {
    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private static final String METHOD_GET = "GET";
    private static final int READ_BUFFER_SIZE = 8192;
    private final Map<String, String> headers = new HashMap();
    private final Map<String, String> queryParams;
    private final String url;

    public HttpGetRequest(String str, Map<String, String> map) {
        this.url = str;
        this.queryParams = map;
    }

    public HttpGetRequest header(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public HttpGetRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.crashlytics.internal.network.HttpResponse execute() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r5.url     // Catch:{ all -> 0x0088 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.queryParams     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = r5.createUrlWithParams(r1, r2)     // Catch:{ all -> 0x0088 }
            com.google.firebase.crashlytics.internal.Logger r2 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r3.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r4 = "GET Request URL: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0088 }
            r2.v(r3)     // Catch:{ all -> 0x0088 }
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0088 }
            r2.<init>(r1)     // Catch:{ all -> 0x0088 }
            java.net.URLConnection r1 = r2.openConnection()     // Catch:{ all -> 0x0088 }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x0088 }
            r2 = 10000(0x2710, float:1.4013E-41)
            r1.setReadTimeout(r2)     // Catch:{ all -> 0x0086 }
            r1.setConnectTimeout(r2)     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ all -> 0x0086 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.headers     // Catch:{ all -> 0x0086 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0086 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0045:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0086 }
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0086 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0086 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x0086 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0086 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0086 }
            r1.addRequestProperty(r4, r3)     // Catch:{ all -> 0x0086 }
            goto L_0x0045
        L_0x0061:
            r1.connect()     // Catch:{ all -> 0x0086 }
            int r2 = r1.getResponseCode()     // Catch:{ all -> 0x0086 }
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ all -> 0x0086 }
            if (r3 == 0) goto L_0x0076
            java.lang.String r0 = r5.readStream(r3)     // Catch:{ all -> 0x0073 }
            goto L_0x0076
        L_0x0073:
            r2 = move-exception
            r0 = r3
            goto L_0x008a
        L_0x0076:
            if (r3 == 0) goto L_0x007b
            r3.close()
        L_0x007b:
            if (r1 == 0) goto L_0x0080
            r1.disconnect()
        L_0x0080:
            com.google.firebase.crashlytics.internal.network.HttpResponse r1 = new com.google.firebase.crashlytics.internal.network.HttpResponse
            r1.<init>(r2, r0)
            return r1
        L_0x0086:
            r2 = move-exception
            goto L_0x008a
        L_0x0088:
            r2 = move-exception
            r1 = r0
        L_0x008a:
            if (r0 == 0) goto L_0x008f
            r0.close()
        L_0x008f:
            if (r1 == 0) goto L_0x0094
            r1.disconnect()
        L_0x0094:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.network.HttpGetRequest.execute():com.google.firebase.crashlytics.internal.network.HttpResponse");
    }

    private String createUrlWithParams(String str, Map<String, String> map) {
        String createParamsString = createParamsString(map);
        if (createParamsString.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return str + "?" + createParamsString;
        }
        if (!str.endsWith("&")) {
            createParamsString = "&" + createParamsString;
        }
        return str + createParamsString;
    }

    private String createParamsString(Map<String, String> map) {
        String str;
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
        Map.Entry next = it2.next();
        sb.append(((String) next.getKey()) + "=" + (next.getValue() != null ? (String) next.getValue() : ""));
        while (it2.hasNext()) {
            Map.Entry next2 = it2.next();
            StringBuilder append = new StringBuilder().append("&").append((String) next2.getKey()).append("=");
            if (next2.getValue() != null) {
                str = (String) next2.getValue();
            } else {
                str = "";
            }
            sb.append(append.append(str).toString());
        }
        return sb.toString();
    }

    private String readStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Key.STRING_CHARSET_NAME));
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }
}
