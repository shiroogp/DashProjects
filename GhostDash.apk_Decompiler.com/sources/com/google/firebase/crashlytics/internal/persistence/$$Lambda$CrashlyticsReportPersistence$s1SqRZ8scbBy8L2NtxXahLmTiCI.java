package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.-$$Lambda$CrashlyticsReportPersistence$s1SqRZ8scbBy8L2NtxXahLmTiCI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportPersistence$s1SqRZ8scbBy8L2NtxXahLmTiCI implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportPersistence$s1SqRZ8scbBy8L2NtxXahLmTiCI INSTANCE = new $$Lambda$CrashlyticsReportPersistence$s1SqRZ8scbBy8L2NtxXahLmTiCI();

    private /* synthetic */ $$Lambda$CrashlyticsReportPersistence$s1SqRZ8scbBy8L2NtxXahLmTiCI() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith("event");
    }
}
