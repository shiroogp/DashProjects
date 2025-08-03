package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$CrashlyticsReportJsonTransform$GuwJSqrRyOux7gdIs2hcasuwZyE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportJsonTransform$GuwJSqrRyOux7gdIs2hcasuwZyE implements CrashlyticsReportJsonTransform.ObjectParser {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$GuwJSqrRyOux7gdIs2hcasuwZyE INSTANCE = new $$Lambda$CrashlyticsReportJsonTransform$GuwJSqrRyOux7gdIs2hcasuwZyE();

    private /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$GuwJSqrRyOux7gdIs2hcasuwZyE() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventThread(jsonReader);
    }
}
