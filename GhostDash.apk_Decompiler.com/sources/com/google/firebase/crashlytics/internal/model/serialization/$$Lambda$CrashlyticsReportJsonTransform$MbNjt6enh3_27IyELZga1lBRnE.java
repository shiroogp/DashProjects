package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$CrashlyticsReportJsonTransform$-MbNjt6enh3_27IyELZga1lBRnE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportJsonTransform$MbNjt6enh3_27IyELZga1lBRnE implements CrashlyticsReportJsonTransform.ObjectParser {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$MbNjt6enh3_27IyELZga1lBRnE INSTANCE = new $$Lambda$CrashlyticsReportJsonTransform$MbNjt6enh3_27IyELZga1lBRnE();

    private /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$MbNjt6enh3_27IyELZga1lBRnE() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEvent(jsonReader);
    }
}
