package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$CrashlyticsReportJsonTransform$4s8CoJuYX6GniCnSQ9blv-x0UAE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportJsonTransform$4s8CoJuYX6GniCnSQ9blvx0UAE implements CrashlyticsReportJsonTransform.ObjectParser {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$4s8CoJuYX6GniCnSQ9blvx0UAE INSTANCE = new $$Lambda$CrashlyticsReportJsonTransform$4s8CoJuYX6GniCnSQ9blvx0UAE();

    private /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$4s8CoJuYX6GniCnSQ9blvx0UAE() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventFrame(jsonReader);
    }
}
