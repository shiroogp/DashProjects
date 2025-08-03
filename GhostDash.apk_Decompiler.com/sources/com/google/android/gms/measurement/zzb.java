package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzhx;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzb extends zzd {
    private final zzhx zza;

    public zzb(zzhx zzhx) {
        super((zzc) null);
        Preconditions.checkNotNull(zzhx);
        this.zza = zzhx;
    }

    public final int zza(String str) {
        return this.zza.zza(str);
    }

    public final long zzb() {
        return this.zza.zzb();
    }

    public final Boolean zzc() {
        return (Boolean) this.zza.zzg(4);
    }

    public final Double zzd() {
        return (Double) this.zza.zzg(2);
    }

    public final Integer zze() {
        return (Integer) this.zza.zzg(3);
    }

    public final Long zzf() {
        return (Long) this.zza.zzg(1);
    }

    public final Object zzg(int i) {
        return this.zza.zzg(i);
    }

    public final String zzh() {
        return this.zza.zzh();
    }

    public final String zzi() {
        return this.zza.zzi();
    }

    public final String zzj() {
        return this.zza.zzj();
    }

    public final String zzk() {
        return this.zza.zzk();
    }

    public final String zzl() {
        return (String) this.zza.zzg(0);
    }

    public final List zzm(String str, String str2) {
        return this.zza.zzm(str, str2);
    }

    public final Map zzn(boolean z) {
        return this.zza.zzo((String) null, (String) null, z);
    }

    public final Map zzo(String str, String str2, boolean z) {
        return this.zza.zzo(str, str2, z);
    }

    public final void zzp(String str) {
        this.zza.zzp(str);
    }

    public final void zzq(String str, String str2, Bundle bundle) {
        this.zza.zzq(str, str2, bundle);
    }

    public final void zzr(String str) {
        this.zza.zzr(str);
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        this.zza.zzs(str, str2, bundle);
    }

    public final void zzt(String str, String str2, Bundle bundle, long j) {
        this.zza.zzt(str, str2, bundle, j);
    }

    public final void zzu(zzgs zzgs) {
        this.zza.zzu(zzgs);
    }

    public final void zzv(Bundle bundle) {
        this.zza.zzv(bundle);
    }

    public final void zzw(zzgr zzgr) {
        this.zza.zzw(zzgr);
    }

    public final void zzx(zzgs zzgs) {
        this.zza.zzx(zzgs);
    }
}
