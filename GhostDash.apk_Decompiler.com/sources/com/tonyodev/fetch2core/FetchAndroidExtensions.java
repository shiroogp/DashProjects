package com.tonyodev.fetch2core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0005"}, d2 = {"isNetworkAvailable", "", "Landroid/content/Context;", "isOnMeteredConnection", "isOnWiFi", "fetch2core_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: AndroidExtentions.kt */
public final class FetchAndroidExtensions {
    public static final boolean isOnWiFi(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$isOnWiFi");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 1) {
                return false;
            }
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public static final boolean isOnMeteredConnection(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$isOnMeteredConnection");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT >= 16) {
                return connectivityManager.isActiveNetworkMetered();
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return true;
            }
            switch (activeNetworkInfo.getType()) {
                case 1:
                case 7:
                case 9:
                    return false;
                default:
                    return true;
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }

    public static final boolean isNetworkAvailable(Context context) {
        Boolean bool;
        Intrinsics.checkParameterIsNotNull(context, "$this$isNetworkAvailable");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z = true;
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            if (z2) {
                return z2;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                int length = allNetworkInfo.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    NetworkInfo networkInfo = allNetworkInfo[i];
                    Intrinsics.checkExpressionValueIsNotNull(networkInfo, "it");
                    if (networkInfo.isConnected()) {
                        break;
                    }
                    i++;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            return bool.booleanValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
