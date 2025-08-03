package com.tonyodev.fetch2.util;

import com.facebook.common.util.UriUtil;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.FileSliceInfo;
import com.tonyodev.fetch2core.server.FileRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0016\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u001e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0003\u001a\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0016\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a6\u0010\u001e\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020\u000f\u001a\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\u0011\u001a\u001e\u0010#\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u001e\u0010%\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006'"}, d2 = {"awaitFinishOrTimeout", "", "allowTimeInMilliseconds", "", "fetchHandler", "Lcom/tonyodev/fetch2/fetch/FetchHandler;", "canCancelDownload", "", "download", "Lcom/tonyodev/fetch2/Download;", "canPauseDownload", "canResumeDownload", "canRetryDownload", "deleteAllInFolderForId", "id", "", "fileTempDir", "", "getCatalogServerRequestFromRequest", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "request", "Lcom/tonyodev/fetch2/Request;", "getDownloadedInfoFilePath", "position", "getFileSliceInfo", "Lcom/tonyodev/fetch2core/FileSliceInfo;", "fileSliceSize", "totalBytes", "getMetaFilePath", "getPreviousSliceCount", "getRequestForDownload", "rangeStart", "rangeEnd", "requestMethod", "segment", "getSavedDownloadedInfo", "getServerRequestFromRequest", "saveCurrentSliceCount", "SliceCount", "fetch2_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: FetchUtils.kt */
public final class FetchUtils {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[Status.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Status.DOWNLOADING.ordinal()] = 1;
            iArr[Status.QUEUED.ordinal()] = 2;
            int[] iArr2 = new int[Status.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Status.ADDED.ordinal()] = 1;
            iArr2[Status.QUEUED.ordinal()] = 2;
            iArr2[Status.PAUSED.ordinal()] = 3;
            int[] iArr3 = new int[Status.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[Status.ADDED.ordinal()] = 1;
            iArr3[Status.FAILED.ordinal()] = 2;
            iArr3[Status.CANCELLED.ordinal()] = 3;
            int[] iArr4 = new int[Status.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[Status.COMPLETED.ordinal()] = 1;
            iArr4[Status.NONE.ordinal()] = 2;
            iArr4[Status.FAILED.ordinal()] = 3;
        }
    }

    public static final boolean canPauseDownload(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        int i = WhenMappings.$EnumSwitchMapping$0[download.getStatus().ordinal()];
        return i == 1 || i == 2;
    }

    public static final boolean canResumeDownload(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        int i = WhenMappings.$EnumSwitchMapping$1[download.getStatus().ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    public static final boolean canRetryDownload(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        int i = WhenMappings.$EnumSwitchMapping$2[download.getStatus().ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    public static final boolean canCancelDownload(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        int i = WhenMappings.$EnumSwitchMapping$3[download.getStatus().ordinal()];
        return (i == 1 || i == 2 || i == 3) ? false : true;
    }

    public static /* synthetic */ Downloader.ServerRequest getRequestForDownload$default(Download download, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = FetchCoreUtils.GET_REQUEST_METHOD;
        }
        return getRequestForDownload(download, str);
    }

    public static final Downloader.ServerRequest getRequestForDownload(Download download, String str) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(str, "requestMethod");
        return getRequestForDownload$default(download, -1, -1, str, 0, 16, (Object) null);
    }

    public static /* synthetic */ Downloader.ServerRequest getRequestForDownload$default(Download download, long j, long j2, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = -1;
        }
        if ((i2 & 4) != 0) {
            j2 = -1;
        }
        if ((i2 & 8) != 0) {
            str = FetchCoreUtils.GET_REQUEST_METHOD;
        }
        if ((i2 & 16) != 0) {
            i = 1;
        }
        return getRequestForDownload(download, j, j2, str, i);
    }

    public static final Downloader.ServerRequest getRequestForDownload(Download download, long j, long j2, String str, int i) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        Intrinsics.checkParameterIsNotNull(str, "requestMethod");
        long j3 = j == -1 ? 0 : j;
        String valueOf = j2 == -1 ? "" : String.valueOf(j2);
        Map<String, String> mutableMap = MapsKt.toMutableMap(download.getHeaders());
        mutableMap.put("Range", "bytes=" + j3 + '-' + valueOf);
        return new Downloader.ServerRequest(download.getId(), download.getUrl(), mutableMap, download.getFile(), FetchCoreUtils.getFileUri(download.getFile()), download.getTag(), download.getIdentifier(), str, download.getExtras(), false, "", i);
    }

    public static final Downloader.ServerRequest getServerRequestFromRequest(Request request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        return new Downloader.ServerRequest(request.getId(), request.getUrl(), request.getHeaders(), request.getFile(), FetchCoreUtils.getFileUri(request.getFile()), request.getTag(), request.getIdentifier(), FetchCoreUtils.GET_REQUEST_METHOD, request.getExtras(), false, "", 1);
    }

    public static final Downloader.ServerRequest getCatalogServerRequestFromRequest(Request request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Map<String, String> mutableMap = MapsKt.toMutableMap(request.getHeaders());
        mutableMap.put("Range", "bytes=0-");
        mutableMap.put(FileRequest.FIELD_PAGE, "-1");
        mutableMap.put(FileRequest.FIELD_SIZE, "-1");
        mutableMap.put(FileRequest.FIELD_TYPE, String.valueOf(1));
        return new Downloader.ServerRequest(request.getId(), request.getUrl(), mutableMap, request.getFile(), FetchCoreUtils.getFileUri(request.getFile()), request.getTag(), request.getIdentifier(), FetchCoreUtils.GET_REQUEST_METHOD, request.getExtras(), false, "", 1);
    }

    public static final int getPreviousSliceCount(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "fileTempDir");
        try {
            Long longDataFromFile = FetchCoreUtils.getLongDataFromFile(getMetaFilePath(i, str));
            if (longDataFromFile != null) {
                return (int) longDataFromFile.longValue();
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final String getMetaFilePath(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "fileTempDir");
        return str + '/' + i + ".meta.data";
    }

    public static final void saveCurrentSliceCount(int i, int i2, String str) {
        Intrinsics.checkParameterIsNotNull(str, "fileTempDir");
        try {
            FetchCoreUtils.writeLongToFile(getMetaFilePath(i, str), (long) i2);
        } catch (Exception unused) {
        }
    }

    public static final String getDownloadedInfoFilePath(int i, int i2, String str) {
        Intrinsics.checkParameterIsNotNull(str, "fileTempDir");
        return str + '/' + i + '.' + i2 + ".data";
    }

    public static final void deleteAllInFolderForId(int i, String str) {
        File[] listFiles;
        Intrinsics.checkParameterIsNotNull(str, "fileTempDir");
        try {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                Collection arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    Intrinsics.checkExpressionValueIsNotNull(file2, UriUtil.LOCAL_FILE_SCHEME);
                    if (StringsKt.startsWith$default(FilesKt.getNameWithoutExtension(file2), new StringBuilder().append(i).append('.').toString(), false, 2, (Object) null)) {
                        arrayList.add(file2);
                    }
                }
                for (File file3 : (List) arrayList) {
                    if (file3.exists()) {
                        file3.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static final long getSavedDownloadedInfo(int i, int i2, String str) {
        Intrinsics.checkParameterIsNotNull(str, "fileTempDir");
        try {
            Long longDataFromFile = FetchCoreUtils.getLongDataFromFile(getDownloadedInfoFilePath(i, i2, str));
            if (longDataFromFile != null) {
                return longDataFromFile.longValue();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final FileSliceInfo getFileSliceInfo(int i, long j) {
        if (i != -1) {
            return new FileSliceInfo(i, (long) ((float) Math.ceil((double) (((float) j) / ((float) i)))));
        }
        float f = (float) j;
        float f2 = (f / 1024.0f) * 1024.0f;
        if (1024.0f * f2 >= 1.0f) {
            return new FileSliceInfo(6, (long) ((float) Math.ceil((double) (f / ((float) 6)))));
        }
        if (f2 >= 1.0f) {
            return new FileSliceInfo(4, (long) ((float) Math.ceil((double) (f / ((float) 4)))));
        }
        return new FileSliceInfo(2, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void awaitFinishOrTimeout(long r15, com.tonyodev.fetch2.fetch.FetchHandler r17) {
        /*
            java.lang.String r0 = "fetchHandler"
            r6 = r17
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            java.lang.String r2 = "Looper.getMainLooper()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.Thread r1 = r1.getThread()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x0069
            r7 = 0
            int r0 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            r9 = 0
            if (r0 != 0) goto L_0x0028
            r0 = 1
            r10 = r0
            goto L_0x0029
        L_0x0028:
            r10 = r9
        L_0x0029:
            if (r10 == 0) goto L_0x002f
            r0 = 5000(0x1388, double:2.4703E-320)
        L_0x002d:
            r11 = r0
            goto L_0x003b
        L_0x002f:
            r0 = 1000(0x3e8, float:1.401E-42)
            long r0 = (long) r0
            int r0 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0038
            r11 = r15
            goto L_0x003b
        L_0x0038:
            r0 = 1000(0x3e8, double:4.94E-321)
            goto L_0x002d
        L_0x003b:
            long r13 = java.lang.System.currentTimeMillis()
            long r0 = r17.getPendingCount()
            r2 = r9
        L_0x0044:
            if (r10 != 0) goto L_0x004e
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x004d
            if (r2 != 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            return
        L_0x004e:
            java.lang.Thread.sleep(r11)     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            r0 = -1
            int r0 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0059
            r2 = r9
            goto L_0x0064
        L_0x0059:
            long r2 = java.lang.System.currentTimeMillis()
            r0 = r13
            r4 = r15
            boolean r0 = com.tonyodev.fetch2core.FetchCoreUtils.hasAllowedTimeExpired(r0, r2, r4)
            r2 = r0
        L_0x0064:
            long r0 = r17.getPendingCount()
            goto L_0x0044
        L_0x0069:
            com.tonyodev.fetch2.exception.FetchException r0 = new com.tonyodev.fetch2.exception.FetchException
            java.lang.String r1 = "await_call_on_ui_thread"
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.util.FetchUtils.awaitFinishOrTimeout(long, com.tonyodev.fetch2.fetch.FetchHandler):void");
    }
}
