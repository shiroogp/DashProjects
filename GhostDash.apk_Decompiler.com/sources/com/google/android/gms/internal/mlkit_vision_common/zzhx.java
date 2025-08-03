package com.google.android.gms.internal.mlkit_vision_common;

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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final class zzhx {
    private static zzo<String> zza;
    private final String zzb;
    private final String zzc;
    private final zzhw zzd;
    private final SharedPrefManager zze;
    private final Task<String> zzf;
    private final Task<String> zzg;
    private final String zzh;
    private final Map<zzfs, Long> zzi = new HashMap();
    private final Map<zzfs, Object> zzj = new HashMap();

    public zzhx(Context context, SharedPrefManager sharedPrefManager, zzhw zzhw, String str) {
        this.zzb = context.getPackageName();
        this.zzc = CommonUtils.getAppVersion(context);
        this.zze = sharedPrefManager;
        this.zzd = zzhw;
        this.zzh = str;
        this.zzf = MLTaskExecutor.getInstance().scheduleCallable(new zzhv(str));
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzg = instance.scheduleCallable(new zzhu(sharedPrefManager));
    }

    private static synchronized zzo<String> zzc() {
        synchronized (zzhx.class) {
            zzo<String> zzo = zza;
            if (zzo != null) {
                return zzo;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzl zzl = new zzl();
            for (int i = 0; i < locales.size(); i++) {
                zzl.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzo<String> zzc2 = zzl.zzc();
            zza = zzc2;
            return zzc2;
        }
    }

    public final /* synthetic */ void zza(zzhy zzhy, zzfs zzfs, String str) {
        String str2;
        zzhy.zzd(zzfs);
        String zza2 = zzhy.zza();
        zzhf zzhf = new zzhf();
        zzhf.zzb(this.zzb);
        zzhf.zzc(this.zzc);
        zzhf.zzh(zzc());
        zzhf.zzg(true);
        zzhf.zzk(zza2);
        zzhf.zzj(str);
        if (this.zzg.isSuccessful()) {
            str2 = this.zzg.getResult();
        } else {
            str2 = this.zze.getMlSdkInstanceId();
        }
        zzhf.zzi(str2);
        zzhf.zzd(10);
        zzhy.zze(zzhf);
        this.zzd.zza(zzhy);
    }

    public final void zzb(zzih zzih, zzfs zzfs) {
        zzfg zzfg;
        zzfm zzfm;
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzi.get(zzfs) == null || elapsedRealtime - this.zzi.get(zzfs).longValue() > TimeUnit.SECONDS.toMillis(30)) {
            this.zzi.put(zzfs, Long.valueOf(elapsedRealtime));
            int i = zzih.zza;
            int i2 = zzih.zzb;
            int i3 = zzih.zzc;
            int i4 = zzih.zzd;
            int i5 = zzih.zze;
            long j = zzih.zzf;
            int i6 = zzih.zzg;
            zzfl zzfl = new zzfl();
            if (i == -1) {
                zzfg = zzfg.BITMAP;
            } else if (i == 35) {
                zzfg = zzfg.YUV_420_888;
            } else if (i == 842094169) {
                zzfg = zzfg.YV12;
            } else if (i == 16) {
                zzfg = zzfg.NV16;
            } else if (i != 17) {
                zzfg = zzfg.UNKNOWN_FORMAT;
            } else {
                zzfg = zzfg.NV21;
            }
            zzfl.zzd(zzfg);
            if (i2 == 1) {
                zzfm = zzfm.BITMAP;
            } else if (i2 == 2) {
                zzfm = zzfm.BYTEARRAY;
            } else if (i2 == 3) {
                zzfm = zzfm.BYTEBUFFER;
            } else if (i2 != 4) {
                zzfm = zzfm.ANDROID_MEDIA_IMAGE;
            } else {
                zzfm = zzfm.FILEPATH;
            }
            zzfl.zzf(zzfm);
            zzfl.zzc(Integer.valueOf(i3));
            zzfl.zze(Integer.valueOf(i4));
            zzfl.zzg(Integer.valueOf(i5));
            zzfl.zzb(Long.valueOf(j));
            zzfl.zzh(Integer.valueOf(i6));
            zzfn zzj2 = zzfl.zzj();
            zzfu zzfu = new zzfu();
            zzfu.zzd(zzj2);
            zzhy zzc2 = zzhy.zzc(zzfu);
            if (this.zzf.isSuccessful()) {
                str = this.zzf.getResult();
            } else {
                str = LibraryVersion.getInstance().getVersion(this.zzh);
            }
            MLTaskExecutor.workerThreadExecutor().execute(new zzht(this, zzc2, zzfs, str, (byte[]) null));
        }
    }
}
