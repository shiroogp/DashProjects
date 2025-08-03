package com.reactlibrary.rnwifi.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

public final class LocationUtils {
    private LocationUtils() {
    }

    public static boolean isLocationOn(Context context) {
        return !isMarshmallowOrLater() || isLocationTurnedOn(context);
    }

    private static boolean isMarshmallowOrLater() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean isLocationTurnedOn(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0) {
            return true;
        }
        return false;
    }
}
