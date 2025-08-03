package com.google.android.gms.internal.mlkit_vision_text;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.vision.text.internal.zzm;
import com.google.mlkit.vision.text.internal.zzn;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzkw {
    private static zzbl<String> zza;
    private final String zzb;
    private final String zzc;
    private final zzkv zzd;
    private final SharedPrefManager zze;
    private final Task<String> zzf;
    private final Task<String> zzg;
    private final String zzh;
    private final Map<zzis, Long> zzi = new HashMap();
    private final Map<zzis, zzbn<Object, Long>> zzj = new HashMap();

    public zzkw(Context context, SharedPrefManager sharedPrefManager, zzkv zzkv, String str) {
        this.zzb = context.getPackageName();
        this.zzc = CommonUtils.getAppVersion(context);
        this.zze = sharedPrefManager;
        this.zzd = zzkv;
        this.zzh = str;
        this.zzf = MLTaskExecutor.getInstance().scheduleCallable(new zzku(str));
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzg = instance.scheduleCallable(new zzkt(sharedPrefManager));
    }

    static long zza(List<Long> list, double d) {
        return list.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) list.size()))) - 1, 0)).longValue();
    }

    private static synchronized zzbl<String> zzg() {
        synchronized (zzkw.class) {
            zzbl<String> zzbl = zza;
            if (zzbl != null) {
                return zzbl;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzbi zzbi = new zzbi();
            for (int i = 0; i < locales.size(); i++) {
                zzbi.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzbl<String> zzc2 = zzbi.zzc();
            zza = zzc2;
            return zzc2;
        }
    }

    private final String zzh() {
        if (this.zzf.isSuccessful()) {
            return this.zzf.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzh);
    }

    private final boolean zzi(zzis zzis, long j, long j2) {
        if (this.zzi.get(zzis) != null && j - this.zzi.get(zzis).longValue() <= TimeUnit.SECONDS.toMillis(30)) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void zzb(zzkz zzkz, zzis zzis, String str) {
        String str2;
        zzkz.zzf(zzis);
        String zzb2 = zzkz.zzb();
        zzkh zzkh = new zzkh();
        zzkh.zzb(this.zzb);
        zzkh.zzc(this.zzc);
        zzkh.zzh(zzg());
        zzkh.zzg(true);
        zzkh.zzk(zzb2);
        zzkh.zzj(str);
        if (this.zzg.isSuccessful()) {
            str2 = this.zzg.getResult();
        } else {
            str2 = this.zze.getMlSdkInstanceId();
        }
        zzkh.zzi(str2);
        zzkh.zzd(10);
        zzkz.zzg(zzkh);
        this.zzd.zza(zzkz);
    }

    public final void zzc(zzkz zzkz, zzis zzis) {
        zzd(zzkz, zzis, zzh());
    }

    public final void zzd(zzkz zzkz, zzis zzis, String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new zzks(this, zzkz, zzis, str, (byte[]) null));
    }

    public final void zze(zzn zzn, zzis zzis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzi(zzis, elapsedRealtime, 30)) {
            this.zzi.put(zzis, Long.valueOf(elapsedRealtime));
            zzd(zzn.zza(), zzis, zzh());
        }
    }

    public final <K> void zzf(K k, long j, zzis zzis, zzm zzm) {
        if (!this.zzj.containsKey(zzis)) {
            this.zzj.put(zzis, zzar.zzr());
        }
        zzbn zzbn = this.zzj.get(zzis);
        zzbn.zzo(k, Long.valueOf(j));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzi(zzis, elapsedRealtime, 30)) {
            this.zzi.put(zzis, Long.valueOf(elapsedRealtime));
            for (Object next : zzbn.zzq()) {
                List<Long> zzc2 = zzbn.zzc(next);
                Collections.sort(zzc2);
                zzia zzia = new zzia();
                long j2 = 0;
                for (Long longValue : zzc2) {
                    j2 += longValue.longValue();
                }
                zzia.zza(Long.valueOf(j2 / ((long) zzc2.size())));
                zzia.zzc(Long.valueOf(zza(zzc2, 100.0d)));
                zzia.zzf(Long.valueOf(zza(zzc2, 75.0d)));
                zzia.zzd(Long.valueOf(zza(zzc2, 50.0d)));
                zzia.zzb(Long.valueOf(zza(zzc2, 25.0d)));
                zzia.zze(Long.valueOf(zza(zzc2, 0.0d)));
                zzib zzg2 = zzia.zzg();
                int size = zzbn.zzc(next).size();
                zziu zziu = new zziu();
                zziu.zze(false);
                zzdp zzdp = new zzdp();
                zzdp.zza(Integer.valueOf(size));
                zzdp.zzc((zzdr) next);
                zzdp.zzb(zzg2);
                zziu.zzc(zzdp.zze());
                zzd(zzkz.zzd(zziu), zzis, zzh());
            }
            this.zzj.remove(zzis);
        }
    }
}
