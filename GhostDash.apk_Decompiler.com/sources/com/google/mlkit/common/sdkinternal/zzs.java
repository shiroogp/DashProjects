package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.Closeable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzs implements Closeable {
    final /* synthetic */ TaskQueue zza;

    /* synthetic */ zzs(TaskQueue taskQueue, zzq zzq) {
        this.zza = taskQueue;
        Preconditions.checkState(((Thread) taskQueue.zzd.getAndSet(Thread.currentThread())) == null);
    }

    public final void close() {
        this.zza.zzd.set((Object) null);
        this.zza.zzc();
    }
}
