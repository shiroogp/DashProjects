package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

/* renamed from: com.google.android.datatransport.cct.-$$Lambda$CctTransportBackend$S-r8nBLtE2gbjrB4Xb4-7yhMlbw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CctTransportBackend$Sr8nBLtE2gbjrB4Xb47yhMlbw implements RetryStrategy {
    public static final /* synthetic */ $$Lambda$CctTransportBackend$Sr8nBLtE2gbjrB4Xb47yhMlbw INSTANCE = new $$Lambda$CctTransportBackend$Sr8nBLtE2gbjrB4Xb47yhMlbw();

    private /* synthetic */ $$Lambda$CctTransportBackend$Sr8nBLtE2gbjrB4Xb47yhMlbw() {
    }

    public final Object shouldRetry(Object obj, Object obj2) {
        return CctTransportBackend.lambda$send$0((CctTransportBackend.HttpRequest) obj, (CctTransportBackend.HttpResponse) obj2);
    }
}
