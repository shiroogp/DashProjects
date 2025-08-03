package com.thanosfisherman.wifiutils;

import android.location.LocationManager;
import androidx.arch.core.util.Function;

/* renamed from: com.thanosfisherman.wifiutils.-$$Lambda$LocationUtils$w5mn34fyhj7OiiiLnPqZKZbZxkQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$LocationUtils$w5mn34fyhj7OiiiLnPqZKZbZxkQ implements Function {
    public static final /* synthetic */ $$Lambda$LocationUtils$w5mn34fyhj7OiiiLnPqZKZbZxkQ INSTANCE = new $$Lambda$LocationUtils$w5mn34fyhj7OiiiLnPqZKZbZxkQ();

    private /* synthetic */ $$Lambda$LocationUtils$w5mn34fyhj7OiiiLnPqZKZbZxkQ() {
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(((LocationManager) obj).isProviderEnabled("network"));
    }
}
