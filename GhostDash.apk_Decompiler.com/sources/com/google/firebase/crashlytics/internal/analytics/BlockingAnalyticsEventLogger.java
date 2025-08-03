package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    static final String APP_EXCEPTION_EVENT_NAME = "_ae";
    private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private boolean callbackReceived = false;
    private CountDownLatch eventLatch;
    private final Object latchLock = new Object();
    private final TimeUnit timeUnit;
    private final int timeout;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit2) {
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = i;
        this.timeUnit = timeUnit2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.google.firebase.crashlytics.internal.Logger.getLogger().e("Interrupted while awaiting app exception callback from Analytics listener.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logEvent(java.lang.String r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.latchLock
            monitor-enter(r0)
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
            r2.<init>()     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = "Logging event "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = " to Firebase Analytics with params "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ all -> 0x0071 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0071 }
            r1.v(r2)     // Catch:{ all -> 0x0071 }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0071 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0071 }
            r5.eventLatch = r1     // Catch:{ all -> 0x0071 }
            r1 = 0
            r5.callbackReceived = r1     // Catch:{ all -> 0x0071 }
            com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger r1 = r5.baseAnalyticsEventLogger     // Catch:{ all -> 0x0071 }
            r1.logEvent(r6, r7)     // Catch:{ all -> 0x0071 }
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0071 }
            java.lang.String r7 = "Awaiting app exception callback from Analytics..."
            r6.v(r7)     // Catch:{ all -> 0x0071 }
            java.util.concurrent.CountDownLatch r6 = r5.eventLatch     // Catch:{ InterruptedException -> 0x0063 }
            int r7 = r5.timeout     // Catch:{ InterruptedException -> 0x0063 }
            long r3 = (long) r7     // Catch:{ InterruptedException -> 0x0063 }
            java.util.concurrent.TimeUnit r7 = r5.timeUnit     // Catch:{ InterruptedException -> 0x0063 }
            boolean r6 = r6.await(r3, r7)     // Catch:{ InterruptedException -> 0x0063 }
            if (r6 == 0) goto L_0x0059
            r5.callbackReceived = r2     // Catch:{ InterruptedException -> 0x0063 }
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ InterruptedException -> 0x0063 }
            java.lang.String r7 = "App exception callback received from Analytics listener."
            r6.v(r7)     // Catch:{ InterruptedException -> 0x0063 }
            goto L_0x006c
        L_0x0059:
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ InterruptedException -> 0x0063 }
            java.lang.String r7 = "Timeout exceeded while awaiting app exception callback from Analytics listener."
            r6.w(r7)     // Catch:{ InterruptedException -> 0x0063 }
            goto L_0x006c
        L_0x0063:
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0071 }
            java.lang.String r7 = "Interrupted while awaiting app exception callback from Analytics listener."
            r6.e(r7)     // Catch:{ all -> 0x0071 }
        L_0x006c:
            r6 = 0
            r5.eventLatch = r6     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x0071:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger.logEvent(java.lang.String, android.os.Bundle):void");
    }

    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.eventLatch;
        if (countDownLatch != null && APP_EXCEPTION_EVENT_NAME.equals(str)) {
            countDownLatch.countDown();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isCallbackReceived() {
        return this.callbackReceived;
    }
}
