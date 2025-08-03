package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzk implements ThreadFactory {
    public final /* synthetic */ ThreadFactory zza;

    public /* synthetic */ zzk(ThreadFactory threadFactory) {
        this.zza = threadFactory;
    }

    public final Thread newThread(Runnable runnable) {
        return this.zza.newThread(new zzj(runnable));
    }
}
