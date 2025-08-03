package com.tonyodev.fetch2;

import com.tonyodev.fetch2core.Downloader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\b\u0001\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00012B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1¨\u00063"}, d2 = {"Lcom/tonyodev/fetch2/Error;", "", "value", "", "throwable", "", "httpResponse", "Lcom/tonyodev/fetch2core/Downloader$Response;", "(Ljava/lang/String;IILjava/lang/Throwable;Lcom/tonyodev/fetch2core/Downloader$Response;)V", "getHttpResponse", "()Lcom/tonyodev/fetch2core/Downloader$Response;", "setHttpResponse", "(Lcom/tonyodev/fetch2core/Downloader$Response;)V", "getThrowable", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "getValue", "()I", "UNKNOWN", "NONE", "FILE_NOT_CREATED", "CONNECTION_TIMED_OUT", "UNKNOWN_HOST", "HTTP_NOT_FOUND", "WRITE_PERMISSION_DENIED", "NO_STORAGE_SPACE", "NO_NETWORK_CONNECTION", "EMPTY_RESPONSE_FROM_SERVER", "REQUEST_ALREADY_EXIST", "DOWNLOAD_NOT_FOUND", "FETCH_DATABASE_ERROR", "REQUEST_WITH_ID_ALREADY_EXIST", "REQUEST_WITH_FILE_PATH_ALREADY_EXIST", "REQUEST_NOT_SUCCESSFUL", "UNKNOWN_IO_ERROR", "FILE_NOT_FOUND", "FETCH_FILE_SERVER_URL_INVALID", "INVALID_CONTENT_HASH", "FAILED_TO_UPDATE_REQUEST", "FAILED_TO_ADD_COMPLETED_DOWNLOAD", "FETCH_FILE_SERVER_INVALID_RESPONSE", "REQUEST_DOES_NOT_EXIST", "ENQUEUE_NOT_SUCCESSFUL", "COMPLETED_NOT_ADDED_SUCCESSFULLY", "ENQUEUED_REQUESTS_ARE_NOT_DISTINCT", "FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE", "FAILED_TO_RENAME_FILE", "FILE_ALLOCATION_FAILED", "HTTP_CONNECTION_NOT_ALLOWED", "Companion", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Error.kt */
public enum Error {
    UNKNOWN(-1, (int) null, (int) null, 6, (Downloader.Response) null),
    NONE(0, (int) null, (int) null, 6, (Downloader.Response) null),
    FILE_NOT_CREATED(1, (int) null, (int) null, 6, (Downloader.Response) null),
    CONNECTION_TIMED_OUT(2, (int) null, (int) null, 6, (Downloader.Response) null),
    UNKNOWN_HOST(3, (int) null, (int) null, 6, (Downloader.Response) null),
    HTTP_NOT_FOUND(4, (int) null, (int) null, 6, (Downloader.Response) null),
    WRITE_PERMISSION_DENIED(5, (int) null, (int) null, 6, (Downloader.Response) null),
    NO_STORAGE_SPACE(6, (int) null, (int) null, 6, (Downloader.Response) null),
    NO_NETWORK_CONNECTION(7, (int) null, (int) null, 6, (Downloader.Response) null),
    EMPTY_RESPONSE_FROM_SERVER(8, (int) null, (int) null, 6, (Downloader.Response) null),
    REQUEST_ALREADY_EXIST(9, (int) null, (int) null, 6, (Downloader.Response) null),
    DOWNLOAD_NOT_FOUND(10, (int) null, (int) null, 6, (Downloader.Response) null),
    FETCH_DATABASE_ERROR(11, (int) null, (int) null, 6, (Downloader.Response) null),
    REQUEST_WITH_ID_ALREADY_EXIST(13, (int) null, (int) null, 6, (Downloader.Response) null),
    REQUEST_WITH_FILE_PATH_ALREADY_EXIST(14, (int) null, (int) null, 6, (Downloader.Response) null),
    REQUEST_NOT_SUCCESSFUL(15, (int) null, (int) null, 6, (Downloader.Response) null),
    UNKNOWN_IO_ERROR(16, (int) null, (int) null, 6, (Downloader.Response) null),
    FILE_NOT_FOUND(17, (int) null, (int) null, 6, (Downloader.Response) null),
    FETCH_FILE_SERVER_URL_INVALID(19, (int) null, (int) null, 6, (Downloader.Response) null),
    INVALID_CONTENT_HASH(20, (int) null, (int) null, 6, (Downloader.Response) null),
    FAILED_TO_UPDATE_REQUEST(21, (int) null, (int) null, 6, (Downloader.Response) null),
    FAILED_TO_ADD_COMPLETED_DOWNLOAD(22, (int) null, (int) null, 6, (Downloader.Response) null),
    FETCH_FILE_SERVER_INVALID_RESPONSE(23, (int) null, (int) null, 6, (Downloader.Response) null),
    REQUEST_DOES_NOT_EXIST(24, (int) null, (int) null, 6, (Downloader.Response) null),
    ENQUEUE_NOT_SUCCESSFUL(25, (int) null, (int) null, 6, (Downloader.Response) null),
    COMPLETED_NOT_ADDED_SUCCESSFULLY(26, (int) null, (int) null, 6, (Downloader.Response) null),
    ENQUEUED_REQUESTS_ARE_NOT_DISTINCT(27, (int) null, (int) null, 6, (Downloader.Response) null),
    FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE(28, (int) null, (int) null, 6, (Downloader.Response) null),
    FAILED_TO_RENAME_FILE(29, (int) null, (int) null, 6, (Downloader.Response) null),
    FILE_ALLOCATION_FAILED(30, (int) null, (int) null, 6, (Downloader.Response) null),
    HTTP_CONNECTION_NOT_ALLOWED(31, (int) null, (int) null, 6, (Downloader.Response) null);
    
    public static final Companion Companion = null;
    private Downloader.Response httpResponse;
    private Throwable throwable;
    private final int value;

    @JvmStatic
    public static final Error valueOf(int i) {
        return Companion.valueOf(i);
    }

    private Error(int i, Throwable th, Downloader.Response response) {
        this.value = i;
        this.throwable = th;
        this.httpResponse = response;
    }

    public final int getValue() {
        return this.value;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public final Downloader.Response getHttpResponse() {
        return this.httpResponse;
    }

    public final void setHttpResponse(Downloader.Response response) {
        this.httpResponse = response;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/tonyodev/fetch2/Error$Companion;", "", "()V", "valueOf", "Lcom/tonyodev/fetch2/Error;", "value", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Error.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Error valueOf(int i) {
            switch (i) {
                case -1:
                    return Error.UNKNOWN;
                case 0:
                    return Error.NONE;
                case 1:
                    return Error.FILE_NOT_CREATED;
                case 2:
                    return Error.CONNECTION_TIMED_OUT;
                case 3:
                    return Error.UNKNOWN_HOST;
                case 4:
                    return Error.HTTP_NOT_FOUND;
                case 5:
                    return Error.WRITE_PERMISSION_DENIED;
                case 6:
                    return Error.NO_STORAGE_SPACE;
                case 7:
                    return Error.NO_NETWORK_CONNECTION;
                case 8:
                    return Error.EMPTY_RESPONSE_FROM_SERVER;
                case 9:
                    return Error.REQUEST_ALREADY_EXIST;
                case 10:
                    return Error.DOWNLOAD_NOT_FOUND;
                case 11:
                    return Error.FETCH_DATABASE_ERROR;
                case 13:
                    return Error.REQUEST_WITH_ID_ALREADY_EXIST;
                case 15:
                    return Error.REQUEST_NOT_SUCCESSFUL;
                case 16:
                    return Error.UNKNOWN_IO_ERROR;
                case 17:
                    return Error.FILE_NOT_FOUND;
                case 19:
                    return Error.FETCH_FILE_SERVER_URL_INVALID;
                case 20:
                    return Error.INVALID_CONTENT_HASH;
                case 21:
                    return Error.FAILED_TO_UPDATE_REQUEST;
                case 22:
                    return Error.FAILED_TO_ADD_COMPLETED_DOWNLOAD;
                case 23:
                    return Error.FETCH_FILE_SERVER_INVALID_RESPONSE;
                case 24:
                    return Error.REQUEST_DOES_NOT_EXIST;
                case 25:
                    return Error.ENQUEUE_NOT_SUCCESSFUL;
                case 26:
                    return Error.COMPLETED_NOT_ADDED_SUCCESSFULLY;
                case 27:
                    return Error.ENQUEUED_REQUESTS_ARE_NOT_DISTINCT;
                case 28:
                    return Error.FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE;
                case 29:
                    return Error.FAILED_TO_RENAME_FILE;
                case 30:
                    return Error.FILE_ALLOCATION_FAILED;
                case 31:
                    return Error.HTTP_CONNECTION_NOT_ALLOWED;
                default:
                    return Error.UNKNOWN;
            }
        }
    }
}
