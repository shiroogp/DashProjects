package com.google.mlkit.common.sdkinternal;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzj implements Runnable {
    public final /* synthetic */ Runnable zza;

    public /* synthetic */ zzj(Runnable runnable) {
        this.zza = runnable;
    }

    public final void run() {
        MlKitThreadPool.zzd(this.zza);
    }
}
