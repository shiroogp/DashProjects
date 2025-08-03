package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$CrashlyticsReportJsonTransform$gtp7HVGCmfilv97Jnlfp7uKMByE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashlyticsReportJsonTransform$gtp7HVGCmfilv97Jnlfp7uKMByE implements CrashlyticsReportJsonTransform.ObjectParser {
    public static final /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$gtp7HVGCmfilv97Jnlfp7uKMByE INSTANCE = new $$Lambda$CrashlyticsReportJsonTransform$gtp7HVGCmfilv97Jnlfp7uKMByE();

    private /* synthetic */ $$Lambda$CrashlyticsReportJsonTransform$gtp7HVGCmfilv97Jnlfp7uKMByE() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseFile(jsonReader);
    }
}
