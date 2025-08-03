package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.internal.common.-$$Lambda$CrashlyticsController$KdOR_Yifvg9Sk8KSAhQ8lZy6az4  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsController$KdOR_Yifvg9Sk8KSAhQ8lZy6az4 implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$CrashlyticsController$KdOR_Yifvg9Sk8KSAhQ8lZy6az4 INSTANCE = new $$Lambda$CrashlyticsController$KdOR_Yifvg9Sk8KSAhQ8lZy6az4();

    private /* synthetic */ $$Lambda$CrashlyticsController$KdOR_Yifvg9Sk8KSAhQ8lZy6az4() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(CrashlyticsController.APP_EXCEPTION_MARKER_PREFIX);
    }
}
