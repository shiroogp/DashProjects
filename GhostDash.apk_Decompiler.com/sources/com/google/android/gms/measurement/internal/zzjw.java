package com.google.android.gms.measurement.internal;

import com.tonyodev.fetch2core.FetchCoreDefaults;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzjw {
    final /* synthetic */ zzka zza;
    private zzjv zzb;

    zzjw(zzka zzka) {
        this.zza = zzka;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzb = new zzjv(this, this.zza.zzs.zzav().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, FetchCoreDefaults.DEFAULT_PROGRESS_REPORTING_INTERVAL_IN_MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zza.zzg();
        zzjv zzjv = this.zzb;
        if (zzjv != null) {
            this.zza.zzd.removeCallbacks(zzjv);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
