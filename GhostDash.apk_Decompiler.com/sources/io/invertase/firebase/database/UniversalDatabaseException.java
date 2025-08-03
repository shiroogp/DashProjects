package io.invertase.firebase.database;

import com.google.firebase.database.DatabaseError;

public class UniversalDatabaseException extends Exception {
    private final String code;
    private final String message;

    UniversalDatabaseException(int i, String str, Throwable th) {
        super(str, th);
        String str2;
        String str3;
        if (i == -25) {
            str3 = "write-cancelled";
            str2 = "The write was canceled by the user.";
        } else if (i == -24) {
            str3 = "network-error";
            str2 = "The operation could not be performed due to a network error.";
        } else if (i == -4) {
            str3 = "disconnected";
            str2 = "The operation had to be aborted due to a network disconnect.";
        } else if (i == -3) {
            str3 = "permission-denied";
            str2 = "Client doesn't have permission to access the desired data.";
        } else if (i == -2) {
            str3 = "failure";
            str2 = "The server indicated that this operation failed.";
        } else if (i != -1) {
            switch (i) {
                case DatabaseError.UNAVAILABLE /*-10*/:
                    str3 = "unavailable";
                    str2 = "The service is unavailable.";
                    break;
                case DatabaseError.OVERRIDDEN_BY_SET /*-9*/:
                    str3 = "overridden-by-set";
                    str2 = "The transaction was overridden by a subsequent set.";
                    break;
                case DatabaseError.MAX_RETRIES /*-8*/:
                    str3 = "max-retries";
                    str2 = "The transaction had too many retries.";
                    break;
                case DatabaseError.INVALID_TOKEN /*-7*/:
                    str3 = "invalid-token";
                    str2 = "The supplied auth token was invalid.";
                    break;
                case DatabaseError.EXPIRED_TOKEN /*-6*/:
                    str3 = "expired-token";
                    str2 = "The supplied auth token has expired.";
                    break;
                default:
                    str3 = "unknown";
                    str2 = "An unknown error occurred";
                    break;
            }
        } else {
            str3 = "data-stale";
            str2 = "The transaction needs to be run again with current data.";
        }
        this.code = str3;
        this.message = str2;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
