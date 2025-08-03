package com.google.android.gms.internal.mlkit_vision_barcode;

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
import com.google.mlkit.vision.barcode.internal.zzg;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzlo {
    private static zzcb<String> zza;
    private final String zzb;
    private final String zzc;
    private final zzln zzd;
    private final SharedPrefManager zze;
    private final Task<String> zzf;
    private final Task<String> zzg;
    private final String zzh;
    private final Map<zzjc, Long> zzi = new HashMap();
    private final Map<zzjc, zzcd<Object, Long>> zzj = new HashMap();

    public zzlo(Context context, SharedPrefManager sharedPrefManager, zzln zzln, String str) {
        this.zzb = context.getPackageName();
        this.zzc = CommonUtils.getAppVersion(context);
        this.zze = sharedPrefManager;
        this.zzd = zzln;
        this.zzh = str;
        this.zzf = MLTaskExecutor.getInstance().scheduleCallable(new zzll(str));
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzg = instance.scheduleCallable(new zzlk(sharedPrefManager));
    }

    static long zza(List<Long> list, double d) {
        return list.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) list.size()))) - 1, 0)).longValue();
    }

    private static synchronized zzcb<String> zzg() {
        synchronized (zzlo.class) {
            zzcb<String> zzcb = zza;
            if (zzcb != null) {
                return zzcb;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzby zzby = new zzby();
            for (int i = 0; i < locales.size(); i++) {
                zzby.zzd(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzcb<String> zzf2 = zzby.zzf();
            zza = zzf2;
            return zzf2;
        }
    }

    private final String zzh() {
        if (this.zzf.isSuccessful()) {
            return this.zzf.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzh);
    }

    private final boolean zzi(zzjc zzjc, long j, long j2) {
        if (this.zzi.get(zzjc) != null && j - this.zzi.get(zzjc).longValue() <= TimeUnit.SECONDS.toMillis(30)) {
            return false;
        }
        return true;
    }

    public final void zzb(zzlm zzlm, zzjc zzjc) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzi(zzjc, elapsedRealtime, 30)) {
            this.zzi.put(zzjc, Long.valueOf(elapsedRealtime));
            zze(zzlm.zza(), zzjc, zzh());
        }
    }

    public final /* synthetic */ void zzc(zzlr zzlr, zzjc zzjc, String str) {
        String str2;
        zzlr.zzf(zzjc);
        String zzb2 = zzlr.zzb();
        zzkv zzkv = new zzkv();
        zzkv.zzb(this.zzb);
        zzkv.zzc(this.zzc);
        zzkv.zzh(zzg());
        zzkv.zzg(true);
        zzkv.zzk(zzb2);
        zzkv.zzj(str);
        if (this.zzg.isSuccessful()) {
            str2 = this.zzg.getResult();
        } else {
            str2 = this.zze.getMlSdkInstanceId();
        }
        zzkv.zzi(str2);
        zzkv.zzd(10);
        zzlr.zzg(zzkv);
        this.zzd.zza(zzlr);
    }

    public final void zzd(zzlr zzlr, zzjc zzjc) {
        zze(zzlr, zzjc, zzh());
    }

    public final void zze(zzlr zzlr, zzjc zzjc, String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new zzlj(this, zzlr, zzjc, str, (byte[]) null));
    }

    public final <K> void zzf(K k, long j, zzjc zzjc, zzg zzg2) {
        if (!this.zzj.containsKey(zzjc)) {
            this.zzj.put(zzjc, zzbh.zzr());
        }
        zzcd zzcd = this.zzj.get(zzjc);
        zzcd.zzo(k, Long.valueOf(j));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzi(zzjc, elapsedRealtime, 30)) {
            this.zzi.put(zzjc, Long.valueOf(elapsedRealtime));
            for (Object next : zzcd.zzq()) {
                List<Long> zzc2 = zzcd.zzc(next);
                Collections.sort(zzc2);
                zzik zzik = new zzik();
                long j2 = 0;
                for (Long longValue : zzc2) {
                    j2 += longValue.longValue();
                }
                zzik.zza(Long.valueOf(j2 / ((long) zzc2.size())));
                zzik.zzc(Long.valueOf(zza(zzc2, 100.0d)));
                zzik.zzf(Long.valueOf(zza(zzc2, 75.0d)));
                zzik.zzd(Long.valueOf(zza(zzc2, 50.0d)));
                zzik.zzb(Long.valueOf(zza(zzc2, 25.0d)));
                zzik.zze(Long.valueOf(zza(zzc2, 0.0d)));
                zzil zzg3 = zzik.zzg();
                zze(zzg2.zza.zze((zzdp) next, zzcd.zzc(next).size(), zzg3), zzjc, zzh());
            }
            this.zzj.remove(zzjc);
        }
    }
}
