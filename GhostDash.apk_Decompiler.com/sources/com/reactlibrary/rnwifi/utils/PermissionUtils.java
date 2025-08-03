package com.reactlibrary.rnwifi.utils;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import java.security.InvalidParameterException;

public final class PermissionUtils {
    private PermissionUtils() {
    }

    public static boolean isLocationPermissionGranted(Context context) throws InvalidParameterException {
        return !isMarshmallowOrLater() || isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    private static boolean isMarshmallowOrLater() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean isPermissionGranted(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}
