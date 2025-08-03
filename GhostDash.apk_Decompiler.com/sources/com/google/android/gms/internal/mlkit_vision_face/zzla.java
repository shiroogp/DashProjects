package com.google.android.gms.internal.mlkit_vision_face;

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
import com.google.mlkit.vision.face.internal.zzf;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzla {
    private static zzbm<String> zza;
    private final String zzb;
    private final String zzc;
    private final zzkz zzd;
    private final SharedPrefManager zze;
    private final Task<String> zzf;
    private final Task<String> zzg;
    private final String zzh;
    private final Map<zzit, Long> zzi = new HashMap();
    private final Map<zzit, zzbo<Object, Long>> zzj = new HashMap();

    public zzla(Context context, SharedPrefManager sharedPrefManager, zzkz zzkz, String str) {
        this.zzb = context.getPackageName();
        this.zzc = CommonUtils.getAppVersion(context);
        this.zze = sharedPrefManager;
        this.zzd = zzkz;
        this.zzh = str;
        this.zzf = MLTaskExecutor.getInstance().scheduleCallable(new zzkx(str));
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzg = instance.scheduleCallable(new zzkw(sharedPrefManager));
    }

    static long zza(List<Long> list, double d) {
        return list.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) list.size()))) - 1, 0)).longValue();
    }

    private static synchronized zzbm<String> zzg() {
        synchronized (zzla.class) {
            zzbm<String> zzbm = zza;
            if (zzbm != null) {
                return zzbm;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzbj zzbj = new zzbj();
            for (int i = 0; i < locales.size(); i++) {
                zzbj.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzbm<String> zzc2 = zzbj.zzc();
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

    private final boolean zzi(zzit zzit, long j, long j2) {
        if (this.zzi.get(zzit) != null && j - this.zzi.get(zzit).longValue() <= TimeUnit.SECONDS.toMillis(30)) {
            return false;
        }
        return true;
    }

    public final void zzb(zzky zzky, zzit zzit) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzi(zzit, elapsedRealtime, 30)) {
            this.zzi.put(zzit, Long.valueOf(elapsedRealtime));
            zze(zzky.zza(), zzit, zzh());
        }
    }

    public final /* synthetic */ void zzc(zzld zzld, zzit zzit, String str) {
        String str2;
        zzld.zzf(zzit);
        String zzb2 = zzld.zzb();
        zzkk zzkk = new zzkk();
        zzkk.zzb(this.zzb);
        zzkk.zzc(this.zzc);
        zzkk.zzh(zzg());
        zzkk.zzg(true);
        zzkk.zzk(zzb2);
        zzkk.zzj(str);
        if (this.zzg.isSuccessful()) {
            str2 = this.zzg.getResult();
        } else {
            str2 = this.zze.getMlSdkInstanceId();
        }
        zzkk.zzi(str2);
        zzkk.zzd(10);
        zzld.zzg(zzkk);
        this.zzd.zza(zzld);
    }

    public final void zzd(zzld zzld, zzit zzit) {
        zze(zzld, zzit, zzh());
    }

    public final void zze(zzld zzld, zzit zzit, String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new zzkv(this, zzld, zzit, str, (byte[]) null));
    }

    public final <K> void zzf(K k, long j, zzit zzit, zzf zzf2) {
        if (!this.zzj.containsKey(zzit)) {
            this.zzj.put(zzit, zzas.zzr());
        }
        zzbo zzbo = this.zzj.get(zzit);
        zzbo.zzo(k, Long.valueOf(j));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzi(zzit, elapsedRealtime, 30)) {
            this.zzi.put(zzit, Long.valueOf(elapsedRealtime));
            for (Object next : zzbo.zzq()) {
                List<Long> zzc2 = zzbo.zzc(next);
                Collections.sort(zzc2);
                zzhv zzhv = new zzhv();
                long j2 = 0;
                for (Long longValue : zzc2) {
                    j2 += longValue.longValue();
                }
                zzhv.zza(Long.valueOf(j2 / ((long) zzc2.size())));
                zzhv.zzc(Long.valueOf(zza(zzc2, 100.0d)));
                zzhv.zzf(Long.valueOf(zza(zzc2, 75.0d)));
                zzhv.zzd(Long.valueOf(zza(zzc2, 50.0d)));
                zzhv.zzb(Long.valueOf(zza(zzc2, 25.0d)));
                zzhv.zze(Long.valueOf(zza(zzc2, 0.0d)));
                zzhw zzg2 = zzhv.zzg();
                zze(zzf2.zza.zzf((zzdc) next, zzbo.zzc(next).size(), zzg2), zzit, zzh());
            }
            this.zzj.remove(zzit);
        }
    }
}
