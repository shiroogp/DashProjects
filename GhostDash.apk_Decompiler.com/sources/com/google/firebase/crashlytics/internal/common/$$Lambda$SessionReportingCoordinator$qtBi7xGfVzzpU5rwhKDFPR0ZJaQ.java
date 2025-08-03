package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Comparator;

/* renamed from: com.google.firebase.crashlytics.internal.common.-$$Lambda$SessionReportingCoordinator$qtBi7xGfVzzpU5rwhKDFPR0ZJaQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SessionReportingCoordinator$qtBi7xGfVzzpU5rwhKDFPR0ZJaQ implements Comparator {
    public static final /* synthetic */ $$Lambda$SessionReportingCoordinator$qtBi7xGfVzzpU5rwhKDFPR0ZJaQ INSTANCE = new $$Lambda$SessionReportingCoordinator$qtBi7xGfVzzpU5rwhKDFPR0ZJaQ();

    private /* synthetic */ $$Lambda$SessionReportingCoordinator$qtBi7xGfVzzpU5rwhKDFPR0ZJaQ() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((CrashlyticsReport.CustomAttribute) obj).getKey().compareTo(((CrashlyticsReport.CustomAttribute) obj2).getKey());
    }
}
