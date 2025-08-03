package com.tonyodev.fetch2;

import com.tonyodev.fetch2core.FetchErrorStrings;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"getErrorFromMessage", "Lcom/tonyodev/fetch2/Error;", "message", "", "getErrorFromThrowable", "throwable", "", "fetch2_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: FetchErrorUtils.kt */
public final class FetchErrorUtils {
    public static final Error getErrorFromThrowable(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        boolean z = th instanceof SocketTimeoutException;
        if (z) {
            if (message.length() == 0) {
                message = FetchErrorStrings.CONNECTION_TIMEOUT;
            }
        }
        Error errorFromMessage = getErrorFromMessage(message);
        if (errorFromMessage == Error.UNKNOWN && z) {
            errorFromMessage = Error.CONNECTION_TIMED_OUT;
        } else if (errorFromMessage == Error.UNKNOWN && (th instanceof IOException)) {
            errorFromMessage = Error.UNKNOWN_IO_ERROR;
        }
        errorFromMessage.setThrowable(th);
        return errorFromMessage;
    }

    public static final Error getErrorFromMessage(String str) {
        if (str != null) {
            CharSequence charSequence = str;
            if (!(charSequence.length() == 0)) {
                if (StringsKt.equals(str, FetchErrorStrings.REQUEST_WITH_FILE_PATH_ALREADY_EXIST, true) || StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FAILED_TO_ENQUEUE_REQUEST_FILE_FOUND, true)) {
                    return Error.REQUEST_WITH_FILE_PATH_ALREADY_EXIST;
                }
                if (StringsKt.contains$default(charSequence, (CharSequence) FetchErrorStrings.UNIQUE_ID_DATABASE, false, 2, (Object) null)) {
                    return Error.REQUEST_WITH_ID_ALREADY_EXIST;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.EMPTY_RESPONSE_BODY, true)) {
                    return Error.EMPTY_RESPONSE_FROM_SERVER;
                }
                if (StringsKt.equals(str, FetchErrorStrings.FNC, true) || StringsKt.equals(str, FetchErrorStrings.ENOENT, true)) {
                    return Error.FILE_NOT_CREATED;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.ETIMEDOUT, true) || StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.CONNECTION_TIMEOUT, true) || StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.SOFTWARE_ABORT_CONNECTION, true) || StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.READ_TIME_OUT, true)) {
                    return Error.CONNECTION_TIMED_OUT;
                }
                if (StringsKt.equals(str, FetchErrorStrings.IO404, true) || StringsKt.contains$default(charSequence, (CharSequence) FetchErrorStrings.NO_ADDRESS_HOSTNAME, false, 2, (Object) null)) {
                    return Error.HTTP_NOT_FOUND;
                }
                if (StringsKt.contains$default(charSequence, (CharSequence) FetchErrorStrings.HOST_RESOLVE_ISSUE, false, 2, (Object) null)) {
                    return Error.UNKNOWN_HOST;
                }
                if (StringsKt.equals(str, FetchErrorStrings.EACCES, true)) {
                    return Error.WRITE_PERMISSION_DENIED;
                }
                if (StringsKt.equals(str, FetchErrorStrings.ENOSPC, true) || StringsKt.equals(str, FetchErrorStrings.DATABASE_DISK_FULL, true)) {
                    return Error.NO_STORAGE_SPACE;
                }
                if (StringsKt.equals(str, FetchErrorStrings.FAILED_TO_ENQUEUE_REQUEST, true)) {
                    return Error.REQUEST_ALREADY_EXIST;
                }
                if (StringsKt.equals(str, FetchErrorStrings.DOWNLOAD_NOT_FOUND, true)) {
                    return Error.DOWNLOAD_NOT_FOUND;
                }
                if (StringsKt.equals(str, FetchErrorStrings.FETCH_DATABASE_ERROR, true)) {
                    return Error.FETCH_DATABASE_ERROR;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.RESPONSE_NOT_SUCCESSFUL, true) || StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FAILED_TO_CONNECT, true)) {
                    return Error.REQUEST_NOT_SUCCESSFUL;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.INVALID_CONTENT_HASH, true)) {
                    return Error.INVALID_CONTENT_HASH;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.DOWNLOAD_INCOMPLETE, true)) {
                    return Error.UNKNOWN_IO_ERROR;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FAILED_TO_UPDATE_REQUEST, true)) {
                    return Error.FAILED_TO_UPDATE_REQUEST;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FAILED_TO_ADD_COMPLETED_DOWNLOAD, true)) {
                    return Error.FAILED_TO_ADD_COMPLETED_DOWNLOAD;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FETCH_FILE_SERVER_INVALID_RESPONSE_TYPE, true)) {
                    return Error.FETCH_FILE_SERVER_INVALID_RESPONSE;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.REQUEST_DOES_NOT_EXIST, true)) {
                    return Error.REQUEST_DOES_NOT_EXIST;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.NO_NETWORK_CONNECTION, true)) {
                    return Error.NO_NETWORK_CONNECTION;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FILE_NOT_FOUND, true)) {
                    return Error.FILE_NOT_FOUND;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FETCH_FILE_SERVER_URL_INVALID, true)) {
                    return Error.FETCH_FILE_SERVER_URL_INVALID;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.ENQUEUED_REQUESTS_ARE_NOT_DISTINCT, true)) {
                    return Error.ENQUEUED_REQUESTS_ARE_NOT_DISTINCT;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.ENQUEUE_NOT_SUCCESSFUL, true)) {
                    return Error.ENQUEUE_NOT_SUCCESSFUL;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FAILED_RENAME_FILE_ASSOCIATED_WITH_INCOMPLETE_DOWNLOAD, true)) {
                    return Error.FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FILE_CANNOT_BE_RENAMED, true)) {
                    return Error.FAILED_TO_RENAME_FILE;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.FILE_ALLOCATION_ERROR, true)) {
                    return Error.FILE_ALLOCATION_FAILED;
                }
                if (StringsKt.contains(charSequence, (CharSequence) FetchErrorStrings.CLEAR_TEXT_NETWORK_VIOLATION, true)) {
                    return Error.HTTP_CONNECTION_NOT_ALLOWED;
                }
                return Error.UNKNOWN;
            }
        }
        return Error.UNKNOWN;
    }
}
