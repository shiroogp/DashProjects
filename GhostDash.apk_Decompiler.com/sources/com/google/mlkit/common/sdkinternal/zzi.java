package com.google.mlkit.common.sdkinternal;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ Runnable zza;

    public /* synthetic */ zzi(Runnable runnable) {
        this.zza = runnable;
    }

    public final void run() {
        MlKitThreadPool.zze(MlKitThreadPool.zza.get(), this.zza);
    }
}
