package com.google.mlkit.common.sdkinternal.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.mlkit_common.zzgu;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzjc;
import com.google.android.gms.internal.mlkit_common.zzjl;
import com.google.android.gms.internal.mlkit_common.zzjm;
import com.google.android.gms.internal.mlkit_common.zzjn;
import com.google.android.gms.internal.mlkit_common.zzjo;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzc extends BroadcastReceiver {
    final /* synthetic */ RemoteModelDownloadManager zza;
    private final long zzb;
    private final TaskCompletionSource<Void> zzc;

    /* synthetic */ zzc(RemoteModelDownloadManager remoteModelDownloadManager, long j, TaskCompletionSource taskCompletionSource, zzb zzb2) {
        this.zza = remoteModelDownloadManager;
        this.zzb = j;
        this.zzc = taskCompletionSource;
    }

    public final void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1);
        if (longExtra == this.zzb) {
            Integer downloadingModelStatusCode = this.zza.getDownloadingModelStatusCode();
            synchronized (this.zza) {
                try {
                    this.zza.zze.getApplicationContext().unregisterReceiver(this);
                } catch (IllegalArgumentException e) {
                    RemoteModelDownloadManager.zza.w("ModelDownloadManager", "Exception thrown while trying to unregister the broadcast receiver for the download", e);
                }
                this.zza.zzc.remove(this.zzb);
                this.zza.zzd.remove(this.zzb);
            }
            if (downloadingModelStatusCode != null) {
                if (downloadingModelStatusCode.intValue() == 16) {
                    zzjl zzh = this.zza.zzi;
                    zzjc zzg = zzjo.zzg();
                    RemoteModel zze = this.zza.zzg;
                    RemoteModelDownloadManager remoteModelDownloadManager = this.zza;
                    Long valueOf = Long.valueOf(longExtra);
                    zzh.zzd(zzg, zze, false, remoteModelDownloadManager.getFailureReason(valueOf));
                    this.zzc.setException(this.zza.zzl(valueOf));
                    return;
                } else if (downloadingModelStatusCode.intValue() == 8) {
                    zzjl zzh2 = this.zza.zzi;
                    zzjc zzg2 = zzjo.zzg();
                    RemoteModel zze2 = this.zza.zzg;
                    zzjm zzh3 = zzjn.zzh();
                    zzh3.zzb(zzgu.NO_ERROR);
                    zzh3.zze(true);
                    zzh3.zzd(this.zza.zzg.getModelType());
                    zzh3.zza(zzhb.SUCCEEDED);
                    zzh2.zzf(zzg2, zze2, zzh3.zzh());
                    this.zzc.setResult(null);
                    return;
                }
            }
            this.zza.zzi.zzd(zzjo.zzg(), this.zza.zzg, false, 0);
            this.zzc.setException(new MlKitException("Model downloading failed", 13));
        }
    }
}
