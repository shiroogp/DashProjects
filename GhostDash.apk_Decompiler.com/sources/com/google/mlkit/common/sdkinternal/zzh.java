package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@17.2.0 */
enum zzh implements Executor {
    INSTANCE;

    public final void execute(Runnable runnable) {
        MLTaskExecutor.getInstance().zzc.post(runnable);
    }
}
