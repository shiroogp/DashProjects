package com.google.mlkit.common.sdkinternal;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class ExecutorSelector {
    private final Provider<? extends Executor> zza;

    public ExecutorSelector(Provider<? extends Executor> provider) {
        this.zza = provider;
    }

    public Executor getExecutorToUse(Executor executor) {
        return executor != null ? executor : (Executor) this.zza.get();
    }
}
