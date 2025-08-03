package com.tonyodev.fetch2core;

import android.content.Context;
import android.net.Uri;
import com.RNFetchBlob.RNFetchBlobConst;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.tonyodev.fetch2core.Downloader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00150\u0014H\u0007\u001a\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017\u001a\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017\u001a\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f\u001a\u001c\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u0010\u001a\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(\u001a\u000e\u0010)\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(\u001a(\u0010*\u001a\u00020\u00172\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00150\u00142\u0006\u0010+\u001a\u00020\u0017\u001a\u0006\u0010,\u001a\u00020-\u001a\u000e\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0001\u001a\u000e\u00100\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0001\u001a\u000e\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0001\u001a\u0010\u00103\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\u0001\u001a\u000e\u00104\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0001\u001a\u000e\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u000207\u001a\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0001\u001a;\u0010;\u001a\u0004\u0018\u00010\u00012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00150\u00142\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010=\"\u00020\u0001¢\u0006\u0002\u0010>\u001a\u000e\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0001\u001a\u0015\u0010A\u001a\u0004\u0018\u00010\u00172\u0006\u00102\u001a\u00020\u0001¢\u0006\u0002\u0010B\u001a\"\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u00122\b\b\u0002\u0010G\u001a\u00020\u0012\u001a\u001a\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170I2\u0006\u0010J\u001a\u00020\u0001\u001a\u000e\u0010K\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0001\u001a\u001e\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020N2\u000e\u0010O\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030P\u001a$\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0R2\u0006\u0010M\u001a\u00020N2\u000e\u0010O\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030P\u001a\u0006\u0010T\u001a\u00020U\u001a\u0016\u0010V\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001\u001a\u001e\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\u0017\u001a\u001e\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u00172\u0006\u0010^\u001a\u00020\u0017\u001a\u000e\u0010_\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0001\u001a(\u0010`\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00150\u0014\u001a\u000e\u0010a\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0001\u001a\u0016\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020(2\u0006\u0010d\u001a\u00020(\u001a\u0016\u0010e\u001a\u00020&2\u0006\u00102\u001a\u00020\u00012\u0006\u0010f\u001a\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"GET_REQUEST_METHOD", "", "HEADER_ACCEPT_RANGE", "HEADER_ACCEPT_RANGE_COMPAT", "HEADER_ACCEPT_RANGE_LEGACY", "HEADER_CONTENT_LENGTH", "HEADER_CONTENT_LENGTH_COMPAT", "HEADER_CONTENT_LENGTH_LEGACY", "HEADER_CONTENT_RANGE", "HEADER_CONTENT_RANGE_COMPAT", "HEADER_CONTENT_RANGE_LEGACY", "HEADER_TRANSFER_ENCODING", "HEADER_TRANSFER_ENCODING_COMPAT", "HEADER_TRANSFER_LEGACY", "HEAD_REQUEST_METHOD", "acceptRanges", "", "code", "", "headers", "", "", "calculateEstimatedTimeRemainingInMilliseconds", "", "downloadedBytes", "totalBytes", "downloadedBytesPerSecond", "calculateProgress", "downloaded", "total", "copyDownloadResponseNoStream", "Lcom/tonyodev/fetch2core/Downloader$Response;", "response", "copyStreamToString", "inputStream", "Ljava/io/InputStream;", "closeStream", "createFile", "", "file", "Ljava/io/File;", "deleteFile", "getContentLengthFromHeader", "defaultValue", "getDefaultCookieManager", "Ljava/net/CookieManager;", "getFetchFileServerHostAddress", "url", "getFetchFileServerPort", "getFile", "filePath", "getFileMd5String", "getFileResourceIdFromUrl", "getFileTempDir", "context", "Landroid/content/Context;", "getFileUri", "Landroid/net/Uri;", "path", "getHeaderValue", "keys", "", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/lang/String;", "getIncrementedFileIfOriginalExists", "originalPath", "getLongDataFromFile", "(Ljava/lang/String;)Ljava/lang/Long;", "getMd5String", "bytes", "", "start", "length", "getRangeForFetchFileServerRequest", "Lkotlin/Pair;", "range", "getRefererFromUrl", "getRequestContentLength", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "downloader", "Lcom/tonyodev/fetch2core/Downloader;", "getRequestSupportedFileDownloaderTypes", "", "Lcom/tonyodev/fetch2core/Downloader$FileDownloaderType;", "getSimpleInterruptMonitor", "Lcom/tonyodev/fetch2core/InterruptMonitor;", "getUniqueId", "hasAllowedTimeExpired", "timeStartedMillis", "timeStopMillis", "allowedTimeMillis", "hasIntervalTimeElapsed", "nanoStartTime", "nanoStopTime", "progressIntervalMilliseconds", "isFetchFileServerUrl", "isParallelDownloadingSupported", "isUriPath", "renameFile", "oldFile", "newFile", "writeLongToFile", "data", "fetch2core_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: FetchCoreUtils.kt */
public final class FetchCoreUtils {
    public static final String GET_REQUEST_METHOD = "GET";
    public static final String HEADER_ACCEPT_RANGE = "Accept-Ranges";
    public static final String HEADER_ACCEPT_RANGE_COMPAT = "AcceptRanges";
    public static final String HEADER_ACCEPT_RANGE_LEGACY = "accept-ranges";
    public static final String HEADER_CONTENT_LENGTH = "content-length";
    public static final String HEADER_CONTENT_LENGTH_COMPAT = "ContentLength";
    public static final String HEADER_CONTENT_LENGTH_LEGACY = "Content-Length";
    public static final String HEADER_CONTENT_RANGE = "Content-Range";
    public static final String HEADER_CONTENT_RANGE_COMPAT = "ContentRange";
    public static final String HEADER_CONTENT_RANGE_LEGACY = "content-range";
    public static final String HEADER_TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String HEADER_TRANSFER_ENCODING_COMPAT = "TransferEncoding";
    public static final String HEADER_TRANSFER_LEGACY = "transfer-encoding";
    public static final String HEAD_REQUEST_METHOD = "HEAD";

    public static final int calculateProgress(long j, long j2) {
        if (j2 < 1) {
            return -1;
        }
        if (j < 1) {
            return 0;
        }
        if (j >= j2) {
            return 100;
        }
        return (int) ((((double) j) / ((double) j2)) * ((double) 100));
    }

    public static final boolean hasAllowedTimeExpired(long j, long j2, long j3) {
        return j2 - j >= j3;
    }

    public static final long calculateEstimatedTimeRemainingInMilliseconds(long j, long j2, long j3) {
        if (j2 >= 1 && j >= 1 && j3 >= 1) {
            return ((long) Math.abs(Math.ceil(((double) (j2 - j)) / ((double) j3)))) * ((long) 1000);
        }
        return -1;
    }

    public static final boolean hasIntervalTimeElapsed(long j, long j2, long j3) {
        return TimeUnit.NANOSECONDS.toMillis(j2 - j) >= j3;
    }

    public static final int getUniqueId(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        Intrinsics.checkParameterIsNotNull(str2, UriUtil.LOCAL_FILE_SCHEME);
        return (str.hashCode() * 31) + str2.hashCode();
    }

    public static final File getIncrementedFileIfOriginalExists(String str) {
        Intrinsics.checkParameterIsNotNull(str, "originalPath");
        File file = new File(str);
        if (file.exists()) {
            String str2 = file.getParent() + '/';
            String extension = FilesKt.getExtension(file);
            String nameWithoutExtension = FilesKt.getNameWithoutExtension(file);
            int i = 0;
            while (file.exists()) {
                i++;
                file = new File(str2 + (nameWithoutExtension + " (" + i + ')') + '.' + extension);
            }
        }
        createFile(file);
        return file;
    }

    public static final void createFile(File file) {
        Intrinsics.checkParameterIsNotNull(file, UriUtil.LOCAL_FILE_SCHEME);
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() == null || file.getParentFile().exists()) {
            if (!file.createNewFile()) {
                throw new FileNotFoundException(file + " file_not_found");
            }
        } else if (!file.getParentFile().mkdirs()) {
            throw new FileNotFoundException(file + " file_not_found");
        } else if (!file.createNewFile()) {
            throw new FileNotFoundException(file + " file_not_found");
        }
    }

    public static final String getFileTempDir(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        StringBuilder sb = new StringBuilder();
        File filesDir = context.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir, "context.filesDir");
        return sb.append(filesDir.getAbsoluteFile()).append("/_fetchData/temp").toString();
    }

    public static final File getFile(String str) {
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() == null || file.getParentFile().exists()) {
                file.createNewFile();
            } else if (file.getParentFile().mkdirs()) {
                file.createNewFile();
            }
        }
        return file;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void writeLongToFile(java.lang.String r3, long r4) {
        /*
            java.lang.String r0 = "filePath"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.io.File r3 = getFile(r3)
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x002a
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r3, r1)
            r1 = 0
            r0.seek(r1)     // Catch:{ Exception -> 0x0021, all -> 0x0025 }
            r0.setLength(r1)     // Catch:{ Exception -> 0x0021, all -> 0x0025 }
            r0.writeLong(r4)     // Catch:{ Exception -> 0x0021, all -> 0x0025 }
        L_0x0021:
            r0.close()     // Catch:{ Exception -> 0x002a }
            goto L_0x002a
        L_0x0025:
            r3 = move-exception
            r0.close()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r3
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.FetchCoreUtils.writeLongToFile(java.lang.String, long):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long getLongDataFromFile(java.lang.String r4) {
        /*
            java.lang.String r0 = "filePath"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.io.File r4 = getFile(r4)
            r0 = 0
            java.lang.Long r0 = (java.lang.Long) r0
            boolean r1 = r4.exists()
            if (r1 == 0) goto L_0x002a
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "r"
            r1.<init>(r4, r2)
            long r2 = r1.readLong()     // Catch:{ Exception -> 0x0021, all -> 0x0025 }
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0021, all -> 0x0025 }
        L_0x0021:
            r1.close()     // Catch:{ Exception -> 0x002a }
            goto L_0x002a
        L_0x0025:
            r4 = move-exception
            r1.close()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r4
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.FetchCoreUtils.getLongDataFromFile(java.lang.String):java.lang.Long");
    }

    public static final boolean isFetchFileServerUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        try {
            if (!StringsKt.startsWith$default(str, "fetchlocal://", false, 2, (Object) null)) {
                return false;
            }
            if (!(getFetchFileServerHostAddress(str).length() > 0) || getFetchFileServerPort(str) <= -1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final int getFetchFileServerPort(String str) {
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        String substring = str.substring(StringsKt.lastIndexOf$default((CharSequence) str, ":", 0, false, 6, (Object) null) + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) substring, "/", 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return Integer.parseInt(substring);
        }
        if (substring != null) {
            String substring2 = substring.substring(0, indexOf$default);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return Integer.parseInt(substring2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String getFetchFileServerHostAddress(String str) {
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        CharSequence charSequence = str;
        String substring = str.substring(StringsKt.indexOf$default(charSequence, "//", 0, false, 6, (Object) null) + 2, StringsKt.lastIndexOf$default(charSequence, ":", 0, false, 6, (Object) null));
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String getFileResourceIdFromUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(url)");
        String lastPathSegment = parse.getLastPathSegment();
        return lastPathSegment != null ? lastPathSegment : "-1";
    }

    public static final Pair<Long, Long> getRangeForFetchFileServerRequest(String str) {
        long j;
        Intrinsics.checkParameterIsNotNull(str, "range");
        CharSequence charSequence = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, "=", 0, false, 6, (Object) null);
        int lastIndexOf$default2 = StringsKt.lastIndexOf$default(charSequence, "-", 0, false, 6, (Object) null);
        String substring = str.substring(lastIndexOf$default + 1, lastIndexOf$default2);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        long parseLong = Long.parseLong(substring);
        try {
            String substring2 = str.substring(lastIndexOf$default2 + 1, str.length());
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            j = Long.parseLong(substring2);
        } catch (Exception unused) {
            j = -1;
        }
        return new Pair<>(Long.valueOf(parseLong), Long.valueOf(j));
    }

    public static /* synthetic */ String getMd5String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return getMd5String(bArr, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getMd5String(byte[] r4, int r5, int r6) {
        /*
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0068 }
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x0068 }
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch:{ Exception -> 0x0068 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0068 }
            r3.<init>(r4, r5, r6)     // Catch:{ Exception -> 0x0068 }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ Exception -> 0x0068 }
            r2.<init>(r3, r1)     // Catch:{ Exception -> 0x0068 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ Exception -> 0x0068 }
            r4 = 0
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ Exception -> 0x0068 }
            r5 = r2
            java.security.DigestInputStream r5 = (java.security.DigestInputStream) r5     // Catch:{ all -> 0x0061 }
        L_0x0023:
            int r6 = r5.read(r0)     // Catch:{ all -> 0x0061 }
            r3 = -1
            if (r6 == r3) goto L_0x002b
            goto L_0x0023
        L_0x002b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0061 }
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ Exception -> 0x0068 }
            java.math.BigInteger r4 = new java.math.BigInteger     // Catch:{ Exception -> 0x0068 }
            r5 = 1
            byte[] r6 = r1.digest()     // Catch:{ Exception -> 0x0068 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0068 }
            r5 = 16
            java.lang.String r4 = r4.toString(r5)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r5 = "BigInteger(1, md.digest()).toString(16)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch:{ Exception -> 0x0068 }
        L_0x0045:
            int r5 = r4.length()     // Catch:{ Exception -> 0x0068 }
            r6 = 32
            if (r5 >= r6) goto L_0x006a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0068 }
            r5.<init>()     // Catch:{ Exception -> 0x0068 }
            r6 = 48
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x0068 }
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0068 }
            goto L_0x0045
        L_0x0061:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ Exception -> 0x0068 }
            throw r5     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            java.lang.String r4 = ""
        L_0x006a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.FetchCoreUtils.getMd5String(byte[], int, int):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getFileMd5String(java.lang.String r7) {
        /*
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r7 = 8192(0x2000, float:1.14794E-41)
            r1 = 0
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x0070 }
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0070 }
            java.security.DigestInputStream r3 = new java.security.DigestInputStream     // Catch:{ Exception -> 0x0070 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0070 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0070 }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ Exception -> 0x0070 }
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x0070 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ Exception -> 0x0070 }
            r0 = r1
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x0070 }
            r4 = r3
            java.security.DigestInputStream r4 = (java.security.DigestInputStream) r4     // Catch:{ all -> 0x0069 }
        L_0x0029:
            int r5 = r4.read(r7)     // Catch:{ all -> 0x0069 }
            r6 = -1
            if (r5 == r6) goto L_0x0031
            goto L_0x0029
        L_0x0031:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0069 }
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ Exception -> 0x0070 }
            java.math.BigInteger r7 = new java.math.BigInteger     // Catch:{ Exception -> 0x0070 }
            r0 = 1
            byte[] r2 = r2.digest()     // Catch:{ Exception -> 0x0070 }
            r7.<init>(r0, r2)     // Catch:{ Exception -> 0x0070 }
            r0 = 16
            java.lang.String r7 = r7.toString(r0)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r0 = "BigInteger(1, md.digest()).toString(16)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r0)     // Catch:{ Exception -> 0x0070 }
        L_0x004b:
            int r0 = r7.length()     // Catch:{ Exception -> 0x0070 }
            r2 = 32
            if (r0 >= r2) goto L_0x0067
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0070 }
            r0.<init>()     // Catch:{ Exception -> 0x0070 }
            r2 = 48
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x0070 }
            java.lang.StringBuilder r7 = r0.append(r7)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0070 }
            goto L_0x004b
        L_0x0067:
            r1 = r7
            goto L_0x0070
        L_0x0069:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x006b }
        L_0x006b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r7)     // Catch:{ Exception -> 0x0070 }
            throw r0     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.FetchCoreUtils.getFileMd5String(java.lang.String):java.lang.String");
    }

    public static final boolean isParallelDownloadingSupported(int i, Map<String, ? extends List<String>> map) {
        Intrinsics.checkParameterIsNotNull(map, "headers");
        return acceptRanges(i, map);
    }

    public static final Set<Downloader.FileDownloaderType> getRequestSupportedFileDownloaderTypes(Downloader.ServerRequest serverRequest, Downloader<?, ?> downloader) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        Intrinsics.checkParameterIsNotNull(downloader, "downloader");
        Set<Downloader.FileDownloaderType> mutableSetOf = SetsKt.mutableSetOf(Downloader.FileDownloaderType.SEQUENTIAL);
        try {
            Downloader.Response execute = downloader.execute(serverRequest, getSimpleInterruptMonitor());
            if (execute != null) {
                if (isParallelDownloadingSupported(execute.getCode(), execute.getResponseHeaders())) {
                    mutableSetOf.add(Downloader.FileDownloaderType.PARALLEL);
                }
                downloader.disconnect(execute);
            }
        } catch (Exception unused) {
        }
        return mutableSetOf;
    }

    public static final boolean acceptRanges(int i, Map<String, ? extends List<String>> map) {
        String str;
        Intrinsics.checkParameterIsNotNull(map, "headers");
        String headerValue = getHeaderValue(map, HEADER_ACCEPT_RANGE, HEADER_ACCEPT_RANGE_LEGACY, HEADER_ACCEPT_RANGE_COMPAT);
        String headerValue2 = getHeaderValue(map, HEADER_TRANSFER_ENCODING, HEADER_TRANSFER_LEGACY, HEADER_TRANSFER_ENCODING_COMPAT);
        long contentLengthFromHeader = getContentLengthFromHeader(map, -1);
        boolean z = i == 206 || Intrinsics.areEqual((Object) headerValue, (Object) "bytes");
        int i2 = (contentLengthFromHeader > -1 ? 1 : (contentLengthFromHeader == -1 ? 0 : -1));
        if (i2 <= 0 || !z) {
            if (i2 <= 0) {
                return false;
            }
            if (headerValue2 == null) {
                str = null;
            } else if (headerValue2 != null) {
                str = headerValue2.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            if (!(!Intrinsics.areEqual((Object) str, (Object) "chunked"))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long getContentLengthFromHeader(java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r7, long r8) {
        /*
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.String r0 = "Content-Range"
            java.lang.String r1 = "content-range"
            java.lang.String r2 = "ContentRange"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2}
            java.lang.String r0 = getHeaderValue(r7, r0)
            if (r0 == 0) goto L_0x0027
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.lang.String r2 = "/"
            int r1 = kotlin.text.StringsKt.lastIndexOf$default((java.lang.CharSequence) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            r2 = -1
            if (r1 == 0) goto L_0x0061
            int r4 = r1.intValue()
            r5 = -1
            if (r4 == r5) goto L_0x0061
            int r4 = r1.intValue()
            int r5 = r0.length()
            if (r4 >= r5) goto L_0x0061
            int r1 = r1.intValue()
            int r1 = r1 + 1
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r1 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Long r0 = kotlin.text.StringsKt.toLongOrNull(r0)
            if (r0 == 0) goto L_0x0061
            long r0 = r0.longValue()
            goto L_0x0062
        L_0x0059:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r8)
            throw r7
        L_0x0061:
            r0 = r2
        L_0x0062:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0081
            java.lang.String r0 = "content-length"
            java.lang.String r1 = "Content-Length"
            java.lang.String r2 = "ContentLength"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2}
            java.lang.String r7 = getHeaderValue(r7, r0)
            if (r7 == 0) goto L_0x0080
            java.lang.Long r7 = kotlin.text.StringsKt.toLongOrNull(r7)
            if (r7 == 0) goto L_0x0080
            long r8 = r7.longValue()
        L_0x0080:
            r0 = r8
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.FetchCoreUtils.getContentLengthFromHeader(java.util.Map, long):long");
    }

    public static final String getHeaderValue(Map<String, ? extends List<String>> map, String... strArr) {
        Intrinsics.checkParameterIsNotNull(map, "headers");
        Intrinsics.checkParameterIsNotNull(strArr, "keys");
        int length = strArr.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length) {
                return null;
            }
            List list = (List) map.get(strArr[i]);
            if (list != null) {
                str = (String) CollectionsKt.firstOrNull(list);
            }
            CharSequence charSequence = str;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                return str;
            }
            i++;
        }
    }

    public static final long getRequestContentLength(Downloader.ServerRequest serverRequest, Downloader<?, ?> downloader) {
        Map<String, List<String>> map;
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        Intrinsics.checkParameterIsNotNull(downloader, "downloader");
        try {
            Downloader.Response execute = downloader.execute(serverRequest, getSimpleInterruptMonitor());
            if (execute == null || (map = execute.getResponseHeaders()) == null) {
                map = MapsKt.emptyMap();
            }
            long contentLengthFromHeader = getContentLengthFromHeader(map, -1);
            if (execute != null) {
                downloader.disconnect(execute);
            }
            return contentLengthFromHeader;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final boolean isUriPath(String str) {
        Intrinsics.checkParameterIsNotNull(str, RNFetchBlobConst.RNFB_RESPONSE_PATH);
        boolean z = true;
        if (!(str.length() > 0)) {
            str = null;
        }
        if (str == null) {
            return false;
        }
        if (!StringsKt.startsWith$default(str, RNFetchBlobConst.FILE_PREFIX_CONTENT, false, 2, (Object) null) && !StringsKt.startsWith$default(str, "file://", false, 2, (Object) null)) {
            z = false;
        }
        return z;
    }

    public static final Uri getFileUri(String str) {
        Intrinsics.checkParameterIsNotNull(str, RNFetchBlobConst.RNFB_RESPONSE_PATH);
        if (isUriPath(str)) {
            Uri parse = Uri.parse(str);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(path)");
            return parse;
        }
        Uri fromFile = Uri.fromFile(new File(str));
        Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(File(path))");
        return fromFile;
    }

    public static final boolean deleteFile(File file) {
        Intrinsics.checkParameterIsNotNull(file, UriUtil.LOCAL_FILE_SCHEME);
        if (!file.exists() || !file.canWrite()) {
            return false;
        }
        return file.delete();
    }

    public static final boolean renameFile(File file, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "oldFile");
        Intrinsics.checkParameterIsNotNull(file2, "newFile");
        return file.renameTo(file2);
    }

    public static final Downloader.Response copyDownloadResponseNoStream(Downloader.Response response) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        return new Downloader.Response(response.getCode(), response.isSuccessful(), response.getContentLength(), (InputStream) null, response.getRequest(), response.getHash(), response.getResponseHeaders(), response.getAcceptsRanges(), response.getErrorResponse());
    }

    public static final CookieManager getDefaultCookieManager() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        return cookieManager;
    }

    public static final String getRefererFromUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        try {
            Uri parse = Uri.parse(str);
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
            return sb.append(parse.getScheme()).append("://").append(parse.getAuthority()).toString();
        } catch (Exception unused) {
            return "https://google.com";
        }
    }

    public static /* synthetic */ String copyStreamToString$default(InputStream inputStream, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return copyStreamToString(inputStream, z);
    }

    public static final String copyStreamToString(InputStream inputStream, boolean z) {
        String str = null;
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            try {
                StringBuilder sb = new StringBuilder();
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    sb.append(readLine).append(10);
                }
                str = sb.toString();
                if (z) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                bufferedReader = bufferedReader2;
                bufferedReader.close();
                return str;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                try {
                    bufferedReader.close();
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            if (z && bufferedReader != null) {
                bufferedReader.close();
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            if (z && bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return str;
    }

    public static final InterruptMonitor getSimpleInterruptMonitor() {
        return new FetchCoreUtils$getSimpleInterruptMonitor$1();
    }
}
