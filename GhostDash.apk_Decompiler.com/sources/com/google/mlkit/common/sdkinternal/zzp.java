package com.google.mlkit.common.sdkinternal;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzp implements Runnable {
    public final /* synthetic */ TaskQueue zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzp(TaskQueue taskQueue, Runnable runnable) {
        this.zza = taskQueue;
        this.zzb = runnable;
    }

    public final void run() {
        TaskQueue taskQueue = this.zza;
        Runnable runnable = this.zzb;
        zzs zzs = new zzs(taskQueue, (zzq) null);
        try {
            runnable.run();
            zzs.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
