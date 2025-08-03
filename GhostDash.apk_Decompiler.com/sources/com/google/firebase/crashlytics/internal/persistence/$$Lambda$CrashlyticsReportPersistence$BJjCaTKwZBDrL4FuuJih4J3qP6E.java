package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.-$$Lambda$CrashlyticsReportPersistence$BJjCaTKwZBDrL4FuuJih4J3qP6E  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportPersistence$BJjCaTKwZBDrL4FuuJih4J3qP6E implements Comparator {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportPersistence$BJjCaTKwZBDrL4FuuJih4J3qP6E INSTANCE = new $$Lambda$CrashlyticsReportPersistence$BJjCaTKwZBDrL4FuuJih4J3qP6E();

    private /* synthetic */ $$Lambda$CrashlyticsReportPersistence$BJjCaTKwZBDrL4FuuJih4J3qP6E() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
