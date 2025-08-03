package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.-$$Lambda$CrashlyticsReportPersistence$JFU0vij0Pn952vNT34mb4Hr_UXo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportPersistence$JFU0vij0Pn952vNT34mb4Hr_UXo implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportPersistence$JFU0vij0Pn952vNT34mb4Hr_UXo INSTANCE = new $$Lambda$CrashlyticsReportPersistence$JFU0vij0Pn952vNT34mb4Hr_UXo();

    private /* synthetic */ $$Lambda$CrashlyticsReportPersistence$JFU0vij0Pn952vNT34mb4Hr_UXo() {
    }

    public final boolean accept(File file, String str) {
        return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, str);
    }
}
