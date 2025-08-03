package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$CrashlyticsReportJsonTransform$xcqRtqatafHDts0kwSCvKzZoURs  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportJsonTransform$xcqRtqatafHDts0kwSCvKzZoURs implements CrashlyticsReportJsonTransform.ObjectParser {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$xcqRtqatafHDts0kwSCvKzZoURs INSTANCE = new $$Lambda$CrashlyticsReportJsonTransform$xcqRtqatafHDts0kwSCvKzZoURs();

    private /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$xcqRtqatafHDts0kwSCvKzZoURs() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader);
    }
}
