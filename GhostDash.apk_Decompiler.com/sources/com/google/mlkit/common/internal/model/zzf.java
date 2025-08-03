package com.google.mlkit.common.internal.model;

import com.google.mlkit.common.model.CustomRemoteModel;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzf implements Callable {
    public final /* synthetic */ zzg zza;
    public final /* synthetic */ CustomRemoteModel zzb;

    public /* synthetic */ zzf(zzg zzg, CustomRemoteModel customRemoteModel) {
        this.zza = zzg;
        this.zzb = customRemoteModel;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
