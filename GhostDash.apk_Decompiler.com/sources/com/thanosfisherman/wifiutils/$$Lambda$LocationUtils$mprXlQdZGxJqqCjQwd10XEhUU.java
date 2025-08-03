package com.thanosfisherman.wifiutils;

import android.location.LocationManager;
import androidx.arch.core.util.Function;

/* renamed from: com.thanosfisherman.wifiutils.-$$Lambda$LocationUtils$m-prXlQdZGxJqqCj-Qwd10XEhUU  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$LocationUtils$mprXlQdZGxJqqCjQwd10XEhUU implements Function {
    public static final /* synthetic */ $$Lambda$LocationUtils$mprXlQdZGxJqqCjQwd10XEhUU INSTANCE = new $$Lambda$LocationUtils$mprXlQdZGxJqqCjQwd10XEhUU();

    private /* synthetic */ $$Lambda$LocationUtils$mprXlQdZGxJqqCjQwd10XEhUU() {
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(((LocationManager) obj).isProviderEnabled("gps"));
    }
}
