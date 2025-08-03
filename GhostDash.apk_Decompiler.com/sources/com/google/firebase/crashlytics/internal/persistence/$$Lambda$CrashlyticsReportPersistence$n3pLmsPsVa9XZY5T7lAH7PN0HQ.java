package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.-$$Lambda$CrashlyticsReportPersistence$n3pLmsPsV-a9XZY5T7lAH7PN0HQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportPersistence$n3pLmsPsVa9XZY5T7lAH7PN0HQ implements Comparator {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportPersistence$n3pLmsPsVa9XZY5T7lAH7PN0HQ INSTANCE = new $$Lambda$CrashlyticsReportPersistence$n3pLmsPsVa9XZY5T7lAH7PN0HQ();

    private /* synthetic */ $$Lambda$CrashlyticsReportPersistence$n3pLmsPsVa9XZY5T7lAH7PN0HQ() {
    }

    public final int compare(Object obj, Object obj2) {
        return CrashlyticsReportPersistence.oldestEventFileFirst((File) obj, (File) obj2);
    }
}
