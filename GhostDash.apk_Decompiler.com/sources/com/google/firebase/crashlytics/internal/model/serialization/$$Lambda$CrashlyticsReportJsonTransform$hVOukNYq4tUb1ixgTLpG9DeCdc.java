package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$CrashlyticsReportJsonTransform$hVOu-kNYq4tUb1ixgTLpG9DeCdc  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportJsonTransform$hVOukNYq4tUb1ixgTLpG9DeCdc implements CrashlyticsReportJsonTransform.ObjectParser {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$hVOukNYq4tUb1ixgTLpG9DeCdc INSTANCE = new $$Lambda$CrashlyticsReportJsonTransform$hVOukNYq4tUb1ixgTLpG9DeCdc();

    private /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$hVOukNYq4tUb1ixgTLpG9DeCdc() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventBinaryImage(jsonReader);
    }
}
