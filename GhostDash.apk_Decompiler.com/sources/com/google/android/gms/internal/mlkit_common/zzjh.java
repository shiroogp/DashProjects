package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.model.RemoteModel;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzjh implements Runnable {
    public final /* synthetic */ zzjl zza;
    public final /* synthetic */ zzjc zzb;
    public final /* synthetic */ zzjn zzc;
    public final /* synthetic */ RemoteModel zzd;

    public /* synthetic */ zzjh(zzjl zzjl, zzjc zzjc, zzjn zzjn, RemoteModel remoteModel) {
        this.zza = zzjl;
        this.zzb = zzjc;
        this.zzc = zzjn;
        this.zzd = remoteModel;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
