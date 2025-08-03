package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class Uploader {
    private static final String CLIENT_HEALTH_METRICS_LOG_SOURCE = "GDT_CLIENT_METRICS";
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final ClientHealthMetricsStore clientHealthMetricsStore;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final Clock uptimeClock;
    private final WorkScheduler workScheduler;

    @Inject
    public Uploader(Context context2, BackendRegistry backendRegistry2, EventStore eventStore2, WorkScheduler workScheduler2, Executor executor2, SynchronizationGuard synchronizationGuard, Clock clock2, Clock clock3, ClientHealthMetricsStore clientHealthMetricsStore2) {
        this.context = context2;
        this.backendRegistry = backendRegistry2;
        this.eventStore = eventStore2;
        this.workScheduler = workScheduler2;
        this.executor = executor2;
        this.guard = synchronizationGuard;
        this.clock = clock2;
        this.uptimeClock = clock3;
        this.clientHealthMetricsStore = clientHealthMetricsStore2;
    }

    /* access modifiers changed from: package-private */
    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void upload(TransportContext transportContext, int i, Runnable runnable) {
        this.executor.execute(new Runnable(transportContext, i, runnable) {
            public final /* synthetic */ TransportContext f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ Runnable f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                Uploader.this.lambda$upload$1$Uploader(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.workScheduler.schedule(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$upload$1$Uploader(com.google.android.datatransport.runtime.TransportContext r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r3.eventStore     // Catch:{ SynchronizationException -> 0x0026 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$DPpDAVxuR9YHLjNY9v3GYiOTm8c r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$DPpDAVxuR9YHLjNY9v3GYiOTm8c     // Catch:{ SynchronizationException -> 0x0026 }
            r2.<init>()     // Catch:{ SynchronizationException -> 0x0026 }
            r0.runCriticalSection(r2)     // Catch:{ SynchronizationException -> 0x0026 }
            boolean r0 = r3.isNetworkAvailable()     // Catch:{ SynchronizationException -> 0x0026 }
            if (r0 != 0) goto L_0x0020
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$Uploader$sr3vPq_E-juy6AzUzRSaApsvUdw r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$Uploader$sr3vPq_E-juy6AzUzRSaApsvUdw     // Catch:{ SynchronizationException -> 0x0026 }
            r1.<init>(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0020:
            r3.logAndUpdateState(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0024:
            r4 = move-exception
            goto L_0x0031
        L_0x0026:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r3.workScheduler     // Catch:{ all -> 0x0024 }
            int r5 = r5 + 1
            r0.schedule(r4, r5)     // Catch:{ all -> 0x0024 }
        L_0x002d:
            r6.run()
            return
        L_0x0031:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.lambda$upload$1$Uploader(com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    public /* synthetic */ Object lambda$upload$0$Uploader(TransportContext transportContext, int i) {
        this.workScheduler.schedule(transportContext, i + 1);
        return null;
    }

    /* access modifiers changed from: package-private */
    public void logAndUpdateState(TransportContext transportContext, int i) {
        BackendResponse backendResponse;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        long j = 0;
        while (true) {
            long j2 = j;
            while (((Boolean) this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection(transportContext) {
                public final /* synthetic */ TransportContext f$1;

                {
                    this.f$1 = r2;
                }

                public final Object execute() {
                    return Uploader.this.lambda$logAndUpdateState$2$Uploader(this.f$1);
                }
            })).booleanValue()) {
                Iterable<PersistedEvent> iterable = (Iterable) this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection(transportContext) {
                    public final /* synthetic */ TransportContext f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object execute() {
                        return Uploader.this.lambda$logAndUpdateState$3$Uploader(this.f$1);
                    }
                });
                if (iterable.iterator().hasNext()) {
                    if (transportBackend == null) {
                        Logging.d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", (Object) transportContext);
                        backendResponse = BackendResponse.fatalError();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (PersistedEvent event : iterable) {
                            arrayList.add(event.getEvent());
                        }
                        if (transportContext.shouldUploadClientHealthMetrics()) {
                            arrayList.add(createMetricsEvent(transportBackend));
                        }
                        backendResponse = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
                    }
                    if (backendResponse.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
                        this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection(iterable, transportContext, j2) {
                            public final /* synthetic */ Iterable f$1;
                            public final /* synthetic */ TransportContext f$2;
                            public final /* synthetic */ long f$3;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                            }

                            public final Object execute() {
                                return Uploader.this.lambda$logAndUpdateState$4$Uploader(this.f$1, this.f$2, this.f$3);
                            }
                        });
                        this.workScheduler.schedule(transportContext, i + 1, true);
                        return;
                    }
                    this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection(iterable) {
                        public final /* synthetic */ Iterable f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object execute() {
                            return Uploader.this.lambda$logAndUpdateState$5$Uploader(this.f$1);
                        }
                    });
                    if (backendResponse.getStatus() == BackendResponse.Status.OK) {
                        j = Math.max(j2, backendResponse.getNextRequestWaitMillis());
                        if (transportContext.shouldUploadClientHealthMetrics()) {
                            this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() {
                                public final Object execute() {
                                    return Uploader.this.lambda$logAndUpdateState$6$Uploader();
                                }
                            });
                        }
                    } else if (backendResponse.getStatus() == BackendResponse.Status.INVALID_PAYLOAD) {
                        HashMap hashMap = new HashMap();
                        for (PersistedEvent event2 : iterable) {
                            String transportName = event2.getEvent().getTransportName();
                            if (!hashMap.containsKey(transportName)) {
                                hashMap.put(transportName, 1);
                            } else {
                                hashMap.put(transportName, Integer.valueOf(((Integer) hashMap.get(transportName)).intValue() + 1));
                            }
                        }
                        this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection(hashMap) {
                            public final /* synthetic */ Map f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final Object execute() {
                                return Uploader.this.lambda$logAndUpdateState$7$Uploader(this.f$1);
                            }
                        });
                    }
                } else {
                    return;
                }
            }
            this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection(transportContext, j2) {
                public final /* synthetic */ TransportContext f$1;
                public final /* synthetic */ long f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final Object execute() {
                    return Uploader.this.lambda$logAndUpdateState$8$Uploader(this.f$1, this.f$2);
                }
            });
            return;
        }
    }

    public /* synthetic */ Boolean lambda$logAndUpdateState$2$Uploader(TransportContext transportContext) {
        return Boolean.valueOf(this.eventStore.hasPendingEventsFor(transportContext));
    }

    public /* synthetic */ Iterable lambda$logAndUpdateState$3$Uploader(TransportContext transportContext) {
        return this.eventStore.loadBatch(transportContext);
    }

    public /* synthetic */ Object lambda$logAndUpdateState$4$Uploader(Iterable iterable, TransportContext transportContext, long j) {
        this.eventStore.recordFailure(iterable);
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j);
        return null;
    }

    public /* synthetic */ Object lambda$logAndUpdateState$5$Uploader(Iterable iterable) {
        this.eventStore.recordSuccess(iterable);
        return null;
    }

    public /* synthetic */ Object lambda$logAndUpdateState$6$Uploader() {
        this.clientHealthMetricsStore.resetClientMetrics();
        return null;
    }

    public /* synthetic */ Object lambda$logAndUpdateState$7$Uploader(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.clientHealthMetricsStore.recordLogEventDropped((long) ((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    public /* synthetic */ Object lambda$logAndUpdateState$8$Uploader(TransportContext transportContext, long j) {
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j);
        return null;
    }

    public EventInternal createMetricsEvent(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.guard;
        ClientHealthMetricsStore clientHealthMetricsStore2 = this.clientHealthMetricsStore;
        Objects.requireNonNull(clientHealthMetricsStore2);
        return transportBackend.decorate(EventInternal.builder().setEventMillis(this.clock.getTime()).setUptimeMillis(this.uptimeClock.getTime()).setTransportName(CLIENT_HEALTH_METRICS_LOG_SOURCE).setEncodedPayload(new EncodedPayload(Encoding.of("proto"), ((ClientMetrics) synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() {
            public final Object execute() {
                return ClientHealthMetricsStore.this.loadClientMetrics();
            }
        })).toByteArray())).build());
    }
}
