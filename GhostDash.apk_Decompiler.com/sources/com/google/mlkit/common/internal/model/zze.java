package com.google.mlkit.common.internal.model;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.model.CustomRemoteModel;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ zzg zza;
    public final /* synthetic */ CustomRemoteModel zzb;
    public final /* synthetic */ TaskCompletionSource zzc;

    public /* synthetic */ zze(zzg zzg, CustomRemoteModel customRemoteModel, TaskCompletionSource taskCompletionSource) {
        this.zza = zzg;
        this.zzb = customRemoteModel;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc);
    }
}
