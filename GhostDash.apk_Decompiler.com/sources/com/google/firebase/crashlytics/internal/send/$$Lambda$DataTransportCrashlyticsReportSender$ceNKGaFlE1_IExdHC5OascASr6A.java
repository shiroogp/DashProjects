package com.google.firebase.crashlytics.internal.send;

import com.bumptech.glide.load.Key;
import com.google.android.datatransport.Transformer;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.nio.charset.Charset;

/* renamed from: com.google.firebase.crashlytics.internal.send.-$$Lambda$DataTransportCrashlyticsReportSender$ceNKGaFlE1_IExdHC5OascASr6A  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DataTransportCrashlyticsReportSender$ceNKGaFlE1_IExdHC5OascASr6A implements Transformer {
    public static final /* synthetic */ $$Lambda$DataTransportCrashlyticsReportSender$ceNKGaFlE1_IExdHC5OascASr6A INSTANCE = new $$Lambda$DataTransportCrashlyticsReportSender$ceNKGaFlE1_IExdHC5OascASr6A();

    private /* synthetic */ $$Lambda$DataTransportCrashlyticsReportSender$ceNKGaFlE1_IExdHC5OascASr6A() {
    }

    public final Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
    }
}
